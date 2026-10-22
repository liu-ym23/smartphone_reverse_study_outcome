package okhttp3.internal.http2;

import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: classes5.dex */
final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = null;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE = null;

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int r1, Source r2) {
            this(r1, r1, r2);
        }

        Reader(int r2, int r3, Source r4) {
            this.headerList = new ArrayList();
            Header[] r0 = new Header[8];
            this.dynamicTable = r0;
            this.nextHeaderIndex = r0.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = r2;
            this.maxDynamicTableByteCount = r3;
            this.source = Okio.buffer(r4);
        }

        int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        private void adjustDynamicTableByteCount() {
            int r0 = this.maxDynamicTableByteCount;
            int r1 = this.dynamicTableByteCount;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r1 - r0);
            return;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.dynamicTable.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.nextHeaderIndex;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            r5 = r5 - this.dynamicTable[r1].hpackSize;
            this.dynamicTableByteCount -= this.dynamicTable[r1].hpackSize;
            this.headerCount--;
            r0 = r0 + 1;
        L9:
            Header[] r6 = this.dynamicTable;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.headerCount);
            this.nextHeaderIndex += r0;
        L10:
            return r0;
        }

        void readHeaders() throws IOException {
        L3:
            if (this.source.exhausted() == true) goto L32;
            int r0 = this.source.readByte() & 255;
            if (r0 == 128) goto L31;
            if ((r0 & 128) == 128) goto L8;
            if (r0 == 64) goto L11;
            if ((r0 & 64) == 64) goto L14;
            if ((r0 & 32) == 32) goto L17;
            if (r0 == 16) goto L29;
            if (r0 == 0) goto L29;
            readLiteralHeaderWithoutIndexingIndexedName(readInt(r0, 15) - 1);
        L29:
            readLiteralHeaderWithoutIndexingNewName();
            goto L3
        L17:
            int r1 = readInt(r0, 31);
            this.maxDynamicTableByteCount = r1;
            if (r1 < 0) goto L23;
            if (r1 > this.headerTableSizeSetting) goto L23;
            adjustDynamicTableByteCount();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
        L14:
            readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(r0, 63) - 1);
            goto L3
        L11:
            readLiteralHeaderWithIncrementalIndexingNewName();
            goto L3
        L8:
            readIndexedHeader(readInt(r0, 127) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList r0 = new ArrayList(this.headerList);
            this.headerList.clear();
            return r0;
        }

        private void readIndexedHeader(int r4) throws IOException {
            if (isStaticHeader(r4) == false) goto L5;
            this.headerList.add(Hpack.STATIC_HEADER_TABLE[r4]);
            return;
        L5:
            int r0 = dynamicTableIndex(r4 - Hpack.STATIC_HEADER_TABLE.length);
            if (r0 < 0) goto L12;
            Header[] r1 = this.dynamicTable;
            if (r0 >= r1.length) goto L12;
            this.headerList.add(r1[r0]);
            return;
        L12:
            throw new IOException("Header index too large " + (r4 + 1));
        }

        private int dynamicTableIndex(int r1) {
            return (this.nextHeaderIndex + 1) + r1;
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int r3) throws IOException {
            ByteString r4 = getName(r3);
            ByteString r0 = readByteString();
            this.headerList.add(new Header(r4, r0));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            ByteString r0 = Hpack.checkLowercase(readByteString());
            ByteString r1 = readByteString();
            this.headerList.add(new Header(r0, r1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int r3) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(r3), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private ByteString getName(int r3) throws IOException {
            if (isStaticHeader(r3) == true) goto L5;
            int r0 = dynamicTableIndex(r3 - Hpack.STATIC_HEADER_TABLE.length);
            if (r0 < 0) goto L13;
            Header[] r2 = this.dynamicTable;
            if (r0 >= r2.length) goto L13;
            return r2[r0].name;
        L13:
            throw new IOException("Header index too large " + (r3 + 1));
        L5:
            return Hpack.STATIC_HEADER_TABLE[r3].name;
        }

        private boolean isStaticHeader(int r2) {
            if (r2 >= 0) goto L4;
        L6:
            return false;
        L4:
            if (r2 > (Hpack.STATIC_HEADER_TABLE.length - 1)) goto L6;
            return true;
        }

        private void insertIntoDynamicTable(int r6, Header r7) {
            this.headerList.add(r7);
            int r0 = r7.hpackSize;
            if (r6 == (-1)) goto L5;
            r0 = r0 - this.dynamicTable[dynamicTableIndex(r6)].hpackSize;
        L5:
            int r2 = this.maxDynamicTableByteCount;
            if (r0 <= r2) goto L9;
            clearDynamicTable();
            return;
        L9:
            int r3 = evictToRecoverBytes((this.dynamicTableByteCount + r0) - r2);
            if (r6 != (-1)) goto L15;
            int r8 = this.headerCount + 1;
            Header[] r1 = this.dynamicTable;
            if (r8 <= r1.length) goto L14;
            Header[] r9 = new Header[r1.length * 2];
            System.arraycopy(r1, 0, r9, r1.length, r1.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r9;
        L14:
            int r10 = this.nextHeaderIndex;
            this.nextHeaderIndex = r10 - 1;
            this.dynamicTable[r10] = r7;
            this.headerCount++;
        L16:
            this.dynamicTableByteCount += r0;
            return;
        L15:
            this.dynamicTable[r6 + (dynamicTableIndex(r6) + r3)] = r7;
            goto L16
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        int readInt(int r3, int r4) throws IOException {
            int r5 = r3 & r4;
            if (r5 >= r4) goto L5;
            return r5;
        L5:
            int r6 = 0;
        L6:
            int r0 = readByte();
            if ((r0 & 128) == 0) goto L10;
            r4 = r4 + ((r0 & 127) << r6);
            r6 = r6 + 7;
            goto L6
        L10:
            return r4 + (r0 << r6);
        }

        ByteString readByteString() throws IOException {
            int r0 = readByte();
            if ((r0 & 128) != 128) goto L5;
            boolean r1 = true;
        L6:
            int r2 = readInt(r0, 127);
            if (r1 == false) goto L11;
            return ByteString.of(Huffman.get().decode(this.source.readByteArray(r2)));
        L11:
            return this.source.readByteString(r2);
        L5:
            r1 = false;
            goto L6
        }
    }

    static final class Writer {
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

        Writer(Buffer r3) {
            this(4096, true, r3);
        }

        Writer(int r2, boolean r3, Buffer r4) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            Header[] r0 = new Header[8];
            this.dynamicTable = r0;
            this.nextHeaderIndex = r0.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = r2;
            this.maxDynamicTableByteCount = r2;
            this.useCompression = r3;
            this.out = r4;
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.dynamicTable.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.nextHeaderIndex;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            r5 = r5 - this.dynamicTable[r1].hpackSize;
            this.dynamicTableByteCount -= this.dynamicTable[r1].hpackSize;
            this.headerCount--;
            r0 = r0 + 1;
        L9:
            Header[] r6 = this.dynamicTable;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.headerCount);
            Header[] r7 = this.dynamicTable;
            int r3 = this.nextHeaderIndex;
            Arrays.fill(r7, r3 + 1, (r3 + 1) + r0, null);
            this.nextHeaderIndex += r0;
        L10:
            return r0;
        }

        private void insertIntoDynamicTable(Header r7) {
            int r0 = r7.hpackSize;
            int r1 = this.maxDynamicTableByteCount;
            if (r0 <= r1) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes((this.dynamicTableByteCount + r0) - r1);
            int r2 = this.headerCount + 1;
            Header[] r3 = this.dynamicTable;
            if (r2 <= r3.length) goto L9;
            Header[] r4 = new Header[r3.length * 2];
            System.arraycopy(r3, 0, r4, r3.length, r3.length);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.dynamicTable = r4;
        L9:
            int r5 = this.nextHeaderIndex;
            this.nextHeaderIndex = r5 - 1;
            this.dynamicTable[r5] = r7;
            this.headerCount++;
            this.dynamicTableByteCount += r0;
        }

        void writeHeaders(List<Header> r14) throws IOException {
            if (this.emitDynamicTableSizeUpdate == false) goto L8;
            int r0 = this.smallestHeaderTableSizeSetting;
            if (r0 >= this.maxDynamicTableByteCount) goto L7;
            writeInt(r0, 31, 32);
        L7:
            this.emitDynamicTableSizeUpdate = false;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            writeInt(this.maxDynamicTableByteCount, 31, 32);
        L8:
            int r1 = r14.size();
            int r2 = 0;
        L9:
            if (r2 >= r1) goto L48;
            Header r3 = r14.get(r2);
            ByteString r4 = r3.name.toAsciiLowercase();
            ByteString r5 = r3.value;
            Integer r6 = Hpack.NAME_TO_FIRST_INDEX.get(r4);
            if (r6 == null) goto L23;
            int r7 = r6.intValue() + 1;
            if (r7 > 1) goto L15;
        L22:
            int r9 = r7;
            r7 = -1;
        L25:
            if (r7 != (-1)) goto L36;
            int r10 = this.nextHeaderIndex + 1;
            int r8 = this.dynamicTable.length;
        L27:
            if (r10 >= r8) goto L36;
            if (Util.equal(this.dynamicTable[r10].name, r4) == false) goto L35;
            if (Util.equal(this.dynamicTable[r10].value, r5) == true) goto L32;
            if (r9 != (-1)) goto L35;
            r9 = (r10 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
            goto L35
        L32:
            r7 = Hpack.STATIC_HEADER_TABLE.length + (r10 - this.nextHeaderIndex);
        L35:
            r10 = r10 + 1;
        L36:
            if (r7 == (-1)) goto L39;
            writeInt(r7, 127, 128);
        L47:
            r2 = r2 + 1;
            goto L9
        L39:
            if (r9 != (-1)) goto L42;
            this.out.writeByte(64);
            writeByteString(r4);
            writeByteString(r5);
            insertIntoDynamicTable(r3);
            goto L47
        L42:
            if (r4.startsWith(Header.PSEUDO_PREFIX) == true) goto L44;
        L46:
            writeInt(r9, 63, 64);
            writeByteString(r5);
            insertIntoDynamicTable(r3);
            goto L47
        L44:
            if (Header.TARGET_AUTHORITY.equals(r4) == true) goto L46;
            writeInt(r9, 15, 0);
            writeByteString(r5);
            goto L47
        L15:
            if (r7 >= 8) goto L22;
            if (Util.equal(Hpack.STATIC_HEADER_TABLE[r7 - 1].value, r5) == false) goto L20;
        L24:
            r9 = r7;
            goto L25
        L20:
            if (Util.equal(Hpack.STATIC_HEADER_TABLE[r7].value, r5) == false) goto L22;
            r9 = r7;
            r7 = r7 + 1;
            goto L25
        L23:
            r7 = -1;
            goto L24
        }

        void writeInt(int r2, int r3, int r4) {
            if (r2 >= r3) goto L5;
            this.out.writeByte(r2 | r4);
            return;
        L5:
            this.out.writeByte(r4 | r3);
            int r5 = r2 - r3;
        L7:
            if (r5 < 128) goto L9;
            this.out.writeByte(128 | (r5 & 127));
            r5 = r5 >>> 7;
            goto L7
        L9:
            this.out.writeByte(r5);
        }

        void writeByteString(ByteString r4) throws IOException {
            if (this.useCompression == true) goto L5;
        L7:
            writeInt(r4.size(), 127, 0);
            this.out.write(r4);
            return;
        L5:
            if (Huffman.get().encodedLength(r4) >= r4.size()) goto L7;
            Buffer r0 = new Buffer();
            Huffman.get().encode(r4, r0);
            ByteString r5 = r0.readByteString();
            writeInt(r5.size(), 127, 128);
            this.out.write(r5);
        }

        void setHeaderTableSizeSetting(int r2) {
            this.headerTableSizeSetting = r2;
            int r3 = Math.min(r2, 16384);
            int r0 = this.maxDynamicTableByteCount;
            if (r0 != r3) goto L5;
            return;
        L5:
            if (r3 >= r0) goto L7;
            this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, r3);
        L7:
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = r3;
            adjustDynamicTableByteCount();
        }

        private void adjustDynamicTableByteCount() {
            int r0 = this.maxDynamicTableByteCount;
            int r1 = this.dynamicTableByteCount;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            clearDynamicTable();
            return;
        L6:
            evictToRecoverBytes(r1 - r0);
            return;
        }
    }

    static {
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(Header.TARGET_METHOD, HttpMethodContrants.GET), new Header(Header.TARGET_METHOD, "POST"), new Header(Header.TARGET_PATH, LibrarianImpl.Constants.SEPARATOR), new Header(Header.TARGET_PATH, "/index.html"), new Header(Header.TARGET_SCHEME, HttpHost.DEFAULT_SCHEME_NAME), new Header(Header.TARGET_SCHEME, "https"), new Header(Header.RESPONSE_STATUS, "200"), new Header(Header.RESPONSE_STATUS, "204"), new Header(Header.RESPONSE_STATUS, "206"), new Header(Header.RESPONSE_STATUS, "304"), new Header(Header.RESPONSE_STATUS, "400"), new Header(Header.RESPONSE_STATUS, "404"), new Header(Header.RESPONSE_STATUS, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header(BaseHttpRequestInfo.KEY_COOKIE, ""), new Header("date", ""), new Header(URLDispatch.KEY_ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(BatteryTypeInf.BATTERY_LOC_API, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap r0 = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int r1 = 0;
    L3:
        Header[] r2 = STATIC_HEADER_TABLE;
        if (r1 >= r2.length) goto L10;
        if (r0.containsKey(r2[r1].name) == true) goto L8;
        r0.put(r2[r1].name, Integer.valueOf(r1));
    L8:
        r1 = r1 + 1;
        goto L3
    L10:
        return Collections.unmodifiableMap(r0);
    }

    static ByteString checkLowercase(ByteString r4) throws IOException {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        byte r2 = r4.getByte(r1);
        if (r2 < 65) goto L11;
        if (r2 > 90) goto L11;
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r4.utf8());
    L11:
        r1 = r1 + 1;
        goto L3
    L12:
        return r4;
    }
}
