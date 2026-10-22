package okhttp3.internal.http2;

import com.bytedance.librarian.LibrarianImpl;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import fg.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.channels.Channel;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: classes4.dex */
final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = null;

    public static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(int r10, Source r11) {
            this(r10, r10, r11);
        }

        private void adjustDynamicTableByteCount() {
            int r10 = this.maxDynamicTableByteCount;
            int r11 = this.dynamicTableByteCount;
            if (r10 >= r11) goto L8;
            if (r10 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r11 - r10);
            return;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int r10) {
            return (this.nextHeaderIndex + 1) + r10;
        }

        private int evictToRecoverBytes(int r10) {
            int r11 = 0;
            if (r10 <= 0) goto L10;
            int r12 = this.dynamicTable.length;
        L5:
            r12 = r12 - 1;
            int r13 = this.nextHeaderIndex;
            if (r12 < r13) goto L9;
            if (r10 <= 0) goto L9;
            int r14 = this.dynamicTable[r12].hpackSize;
            r10 = r10 - r14;
            this.dynamicTableByteCount -= r14;
            this.headerCount--;
            r11 = r11 + 1;
        L9:
            Header[] r15 = this.dynamicTable;
            System.arraycopy(r15, r13 + 1, r15, (r13 + 1) + r11, this.headerCount);
            this.nextHeaderIndex += r11;
        L10:
            return r11;
        }

        private ByteString getName(int r10) throws IOException {
            if (isStaticHeader(r10) == true) goto L5;
            int r11 = dynamicTableIndex(r10 - Hpack.STATIC_HEADER_TABLE.length);
            if (r11 < 0) goto L13;
            Header[] r12 = this.dynamicTable;
            if (r11 >= r12.length) goto L13;
            return r12[r11].name;
        L13:
            throw new IOException("Header index too large " + (r10 + 1));
        L5:
            return Hpack.STATIC_HEADER_TABLE[r10].name;
        }

        private void insertIntoDynamicTable(int r10, Header r11) {
            this.headerList.add(r11);
            int r12 = r11.hpackSize;
            if (r10 == (-1)) goto L5;
            r12 = r12 - this.dynamicTable[dynamicTableIndex(r10)].hpackSize;
        L5:
            int r13 = this.maxDynamicTableByteCount;
            if (r12 <= r13) goto L9;
            clearDynamicTable();
            return;
        L9:
            int r14 = evictToRecoverBytes((this.dynamicTableByteCount + r12) - r13);
            if (r10 != (-1)) goto L15;
            int r15 = this.headerCount + 1;
            Header[] r16 = this.dynamicTable;
            if (r15 <= r16.length) goto L14;
            Header[] r17 = new Header[r16.length * 2];
            System.arraycopy(r16, 0, r17, r16.length, r16.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r17;
        L14:
            int r18 = this.nextHeaderIndex;
            this.nextHeaderIndex = r18 - 1;
            this.dynamicTable[r18] = r11;
            this.headerCount++;
        L16:
            this.dynamicTableByteCount += r12;
            return;
        L15:
            this.dynamicTable[r10 + (dynamicTableIndex(r10) + r14)] = r11;
            goto L16
        }

        private boolean isStaticHeader(int r10) {
            if (r10 >= 0) goto L4;
        L6:
            return false;
        L4:
            if (r10 > (Hpack.STATIC_HEADER_TABLE.length - 1)) goto L6;
            return true;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & UnsignedBytes.MAX_VALUE;
        }

        private void readIndexedHeader(int r10) throws IOException {
            if (isStaticHeader(r10) == false) goto L5;
            this.headerList.add(Hpack.STATIC_HEADER_TABLE[r10]);
            return;
        L5:
            int r11 = dynamicTableIndex(r10 - Hpack.STATIC_HEADER_TABLE.length);
            if (r11 < 0) goto L12;
            Header[] r12 = this.dynamicTable;
            if (r11 >= r12.length) goto L12;
            this.headerList.add(r12[r11]);
            return;
        L12:
            throw new IOException("Header index too large " + (r10 + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int r10) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(r10), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int r10) throws IOException {
            ByteString r11 = getName(r10);
            ByteString r12 = readByteString();
            this.headerList.add(new Header(r11, r12));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            ByteString r10 = Hpack.checkLowercase(readByteString());
            ByteString r11 = readByteString();
            this.headerList.add(new Header(r10, r11));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList r10 = new ArrayList(this.headerList);
            this.headerList.clear();
            return r10;
        }

        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public ByteString readByteString() throws IOException {
            int r10 = readByte();
            if ((r10 & 128) != 128) goto L5;
            boolean r11 = true;
        L6:
            int r12 = readInt(r10, Hpack.PREFIX_7_BITS);
            if (r11 == false) goto L11;
            return ByteString.of(Huffman.get().decode(this.source.readByteArray(r12)));
        L11:
            return this.source.readByteString(r12);
        L5:
            r11 = false;
            goto L6
        }

        public void readHeaders() throws IOException {
        L3:
            if (this.source.exhausted() == true) goto L32;
            byte r10 = this.source.readByte();
            int r11 = r10 & UnsignedBytes.MAX_VALUE;
            if (r11 == 128) goto L31;
            if ((r10 & UnsignedBytes.MAX_POWER_OF_TWO) == 128) goto L8;
            if (r11 == 64) goto L11;
            if ((r10 & SignedBytes.MAX_POWER_OF_TWO) == 64) goto L14;
            if ((r10 & 32) == 32) goto L17;
            if (r11 == 16) goto L29;
            if (r11 == 0) goto L29;
            readLiteralHeaderWithoutIndexingIndexedName(readInt(r11, 15) - 1);
        L29:
            readLiteralHeaderWithoutIndexingNewName();
            goto L3
        L17:
            int r12 = readInt(r11, 31);
            this.maxDynamicTableByteCount = r12;
            if (r12 < 0) goto L23;
            if (r12 > this.headerTableSizeSetting) goto L23;
            adjustDynamicTableByteCount();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
        L14:
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(r11, 63) - 1);
            goto L3
        L11:
            readLiteralHeaderWithIncrementalIndexingNewName();
            goto L3
        L8:
            readIndexedHeader(readInt(r11, Hpack.PREFIX_7_BITS) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        public int readInt(int r10, int r11) throws IOException {
            int r12 = r10 & r11;
            if (r12 >= r11) goto L5;
            return r12;
        L5:
            int r13 = 0;
        L6:
            int r14 = readByte();
            if ((r14 & 128) == 0) goto L10;
            r11 = r11 + ((r14 & Hpack.PREFIX_7_BITS) << r13);
            r13 = r13 + 7;
            goto L6
        L10:
            return r11 + (r14 << r13);
        }

        public Reader(int r10, int r11, Source r12) {
            this.headerList = new ArrayList();
            Header[] r13 = new Header[8];
            this.dynamicTable = r13;
            this.nextHeaderIndex = r13.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = r10;
            this.maxDynamicTableByteCount = r11;
            this.source = j.d(r12);
        }
    }

    public static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(Buffer r10) {
            this(4096, true, r10);
        }

        private void adjustDynamicTableByteCount() {
            int r10 = this.maxDynamicTableByteCount;
            int r11 = this.dynamicTableByteCount;
            if (r10 >= r11) goto L8;
            if (r10 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r11 - r10);
            return;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int r10) {
            int r11 = 0;
            if (r10 <= 0) goto L10;
            int r12 = this.dynamicTable.length;
        L5:
            r12 = r12 - 1;
            int r13 = this.nextHeaderIndex;
            if (r12 < r13) goto L9;
            if (r10 <= 0) goto L9;
            int r14 = this.dynamicTable[r12].hpackSize;
            r10 = r10 - r14;
            this.dynamicTableByteCount -= r14;
            this.headerCount--;
            r11 = r11 + 1;
        L9:
            Header[] r15 = this.dynamicTable;
            System.arraycopy(r15, r13 + 1, r15, (r13 + 1) + r11, this.headerCount);
            Header[] r16 = this.dynamicTable;
            int r17 = this.nextHeaderIndex;
            Arrays.fill(r16, r17 + 1, (r17 + 1) + r11, null);
            this.nextHeaderIndex += r11;
        L10:
            return r11;
        }

        private void insertIntoDynamicTable(Header r10) {
            int r11 = r10.hpackSize;
            int r12 = this.maxDynamicTableByteCount;
            if (r11 <= r12) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes((this.dynamicTableByteCount + r11) - r12);
            int r13 = this.headerCount + 1;
            Header[] r14 = this.dynamicTable;
            if (r13 <= r14.length) goto L9;
            Header[] r15 = new Header[r14.length * 2];
            System.arraycopy(r14, 0, r15, r14.length, r14.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r15;
        L9:
            int r16 = this.nextHeaderIndex;
            this.nextHeaderIndex = r16 - 1;
            this.dynamicTable[r16] = r10;
            this.headerCount++;
            this.dynamicTableByteCount += r11;
        }

        public void setHeaderTableSizeSetting(int r10) {
            this.headerTableSizeSetting = r10;
            int r11 = Math.min(r10, 16384);
            int r12 = this.maxDynamicTableByteCount;
            if (r12 != r11) goto L5;
            return;
        L5:
            if (r11 >= r12) goto L7;
            this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, r11);
        L7:
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = r11;
            adjustDynamicTableByteCount();
        }

        public void writeByteString(ByteString r10) throws IOException {
            if (this.useCompression == true) goto L5;
        L7:
            writeInt(r10.size(), Hpack.PREFIX_7_BITS, 0);
            this.out.q(r10);
            return;
        L5:
            if (Huffman.get().encodedLength(r10) >= r10.size()) goto L7;
            Buffer r11 = new Buffer();
            Huffman.get().encode(r10, r11);
            ByteString r12 = r11.readByteString();
            writeInt(r12.size(), Hpack.PREFIX_7_BITS, 128);
            this.out.q(r12);
        }

        public void writeHeaders(List<Header> r14) throws IOException {
            if (this.emitDynamicTableSizeUpdate == false) goto L8;
            int r10 = this.smallestHeaderTableSizeSetting;
            if (r10 >= this.maxDynamicTableByteCount) goto L7;
            writeInt(r10, 31, 32);
        L7:
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = Channel.UNLIMITED;
            writeInt(this.maxDynamicTableByteCount, 31, 32);
        L8:
            int r11 = r14.size();
            int r12 = 0;
        L9:
            if (r12 >= r11) goto L47;
            Header r13 = r14.get(r12);
            ByteString r15 = r13.name.toAsciiLowercase();
            ByteString r16 = r13.value;
            Integer r17 = Hpack.NAME_TO_FIRST_INDEX.get(r15);
            if (r17 == null) goto L23;
            int r18 = r17.intValue();
            int r19 = r18 + 1;
            if (r19 > 1) goto L15;
        L22:
            int r20 = r19;
            r19 = -1;
        L24:
            if (r19 != (-1)) goto L35;
            int r110 = this.nextHeaderIndex + 1;
            int r21 = this.dynamicTable.length;
        L26:
            if (r110 >= r21) goto L35;
            if (Util.equal(this.dynamicTable[r110].name, r15) == false) goto L34;
            if (Util.equal(this.dynamicTable[r110].value, r16) == true) goto L31;
            if (r20 != (-1)) goto L34;
            r20 = (r110 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
            goto L34
        L31:
            r19 = (r110 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
        L34:
            r110 = r110 + 1;
        L35:
            if (r19 == (-1)) goto L38;
            writeInt(r19, Hpack.PREFIX_7_BITS, 128);
        L46:
            r12 = r12 + 1;
            goto L9
        L38:
            if (r20 != (-1)) goto L41;
            this.out.t(64);
            writeByteString(r15);
            writeByteString(r16);
            insertIntoDynamicTable(r13);
            goto L46
        L41:
            if (r15.startsWith(Header.PSEUDO_PREFIX) == true) goto L43;
        L45:
            writeInt(r20, 63, 64);
            writeByteString(r16);
            insertIntoDynamicTable(r13);
            goto L46
        L43:
            if (Header.TARGET_AUTHORITY.equals(r15) == true) goto L45;
            writeInt(r20, 15, 0);
            writeByteString(r16);
            goto L46
        L15:
            if (r19 >= 8) goto L22;
            Header[] r111 = Hpack.STATIC_HEADER_TABLE;
            if (Util.equal(r111[r18].value, r16) == false) goto L20;
            r20 = r19;
            goto L24
        L20:
            if (Util.equal(r111[r19].value, r16) == false) goto L22;
            r19 = r18 + 2;
            r20 = r19;
            goto L24
        L23:
            r20 = -1;
            r19 = -1;
            goto L24
        }

        public void writeInt(int r10, int r11, int r12) {
            if (r10 >= r11) goto L5;
            this.out.t(r10 | r12);
            return;
        L5:
            this.out.t(r12 | r11);
            int r13 = r10 - r11;
        L7:
            if (r13 < 128) goto L9;
            int r14 = r13 & Hpack.PREFIX_7_BITS;
            this.out.t(128 | r14);
            r13 = r13 >>> 7;
            goto L7
        L9:
            this.out.t(r13);
        }

        public Writer(int r10, boolean r11, Buffer r12) {
            this.smallestHeaderTableSizeSetting = Channel.UNLIMITED;
            Header[] r13 = new Header[8];
            this.dynamicTable = r13;
            this.nextHeaderIndex = r13.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = r10;
            this.maxDynamicTableByteCount = r10;
            this.useCompression = r11;
            this.out = r12;
        }
    }

    static {
        Header r10 = new Header(Header.TARGET_AUTHORITY, "");
        ByteString r11 = Header.TARGET_METHOD;
        Header r12 = new Header(r11, "GET");
        Header r13 = new Header(r11, "POST");
        ByteString r14 = Header.TARGET_PATH;
        Header r15 = new Header(r14, LibrarianImpl.Constants.SEPARATOR);
        Header r16 = new Header(r14, "/index.html");
        ByteString r17 = Header.TARGET_SCHEME;
        Header r18 = new Header(r17, HttpHost.DEFAULT_SCHEME_NAME);
        Header r19 = new Header(r17, "https");
        ByteString r110 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{r10, r12, r13, r15, r16, r18, r19, new Header(r110, "200"), new Header(r110, "204"), new Header(r110, "206"), new Header(r110, "304"), new Header(r110, "400"), new Header(r110, "404"), new Header(r110, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    public static ByteString checkLowercase(ByteString r10) throws IOException {
        int r11 = r10.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L12;
        byte r13 = r10.getByte(r12);
        if (r13 < 65) goto L11;
        if (r13 > 90) goto L11;
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r10.utf8());
    L11:
        r12 = r12 + 1;
        goto L3
    L12:
        return r10;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap r10 = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int r11 = 0;
    L3:
        Header[] r12 = STATIC_HEADER_TABLE;
        if (r11 >= r12.length) goto L10;
        if (r10.containsKey(r12[r11].name) == true) goto L8;
        r10.put(r12[r11].name, Integer.valueOf(r11));
    L8:
        r11 = r11 + 1;
        goto L3
    L10:
        return Collections.unmodifiableMap(r10);
    }
}
