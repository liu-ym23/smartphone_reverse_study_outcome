package okhttp3.internal.http2;

import Bb.q;
import Mb.C0966d;
import Mb.I;
import Mb.InterfaceC0968f;
import Mb.u;
import Z8.C1168p;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.g;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import okio.ByteString;
import ub.n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0006\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/http2/b;", "", "<init>", "()V", "Lokio/ByteString;", "name", Const.INTENT_KEY_APIKEY, "(Lokio/ByteString;)Lokio/ByteString;", "", "", Const.INTENT_KEY_UMID, "()Ljava/util/Map;", "", "LBb/a;", Const.INTENT_KEY_PKGNAME, "[LBb/a;", "c", "()[LBb/a;", "STATIC_HEADER_TABLE", "Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f37648a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Bb.a[] STATIC_HEADER_TABLE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;

    static {
        b bVar = new b();
        f37648a = bVar;
        Bb.a aVar = new Bb.a(Bb.a.f1485j, "");
        ByteString byteString = Bb.a.f1482g;
        Bb.a aVar2 = new Bb.a(byteString, "GET");
        Bb.a aVar3 = new Bb.a(byteString, "POST");
        ByteString byteString2 = Bb.a.f1483h;
        Bb.a aVar4 = new Bb.a(byteString2, "/");
        Bb.a aVar5 = new Bb.a(byteString2, "/index.html");
        ByteString byteString3 = Bb.a.f1484i;
        Bb.a aVar6 = new Bb.a(byteString3, "http");
        Bb.a aVar7 = new Bb.a(byteString3, "https");
        ByteString byteString4 = Bb.a.f1481f;
        STATIC_HEADER_TABLE = new Bb.a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new Bb.a(byteString4, "200"), new Bb.a(byteString4, "204"), new Bb.a(byteString4, "206"), new Bb.a(byteString4, "304"), new Bb.a(byteString4, "400"), new Bb.a(byteString4, "404"), new Bb.a(byteString4, "500"), new Bb.a("accept-charset", ""), new Bb.a("accept-encoding", "gzip, deflate"), new Bb.a("accept-language", ""), new Bb.a("accept-ranges", ""), new Bb.a("accept", ""), new Bb.a("access-control-allow-origin", ""), new Bb.a("age", ""), new Bb.a("allow", ""), new Bb.a("authorization", ""), new Bb.a("cache-control", ""), new Bb.a("content-disposition", ""), new Bb.a("content-encoding", ""), new Bb.a("content-language", ""), new Bb.a("content-length", ""), new Bb.a("content-location", ""), new Bb.a("content-range", ""), new Bb.a("content-type", ""), new Bb.a("cookie", ""), new Bb.a("date", ""), new Bb.a("etag", ""), new Bb.a("expect", ""), new Bb.a("expires", ""), new Bb.a("from", ""), new Bb.a("host", ""), new Bb.a("if-match", ""), new Bb.a("if-modified-since", ""), new Bb.a("if-none-match", ""), new Bb.a("if-range", ""), new Bb.a("if-unmodified-since", ""), new Bb.a("last-modified", ""), new Bb.a("link", ""), new Bb.a("location", ""), new Bb.a("max-forwards", ""), new Bb.a("proxy-authenticate", ""), new Bb.a("proxy-authorization", ""), new Bb.a("range", ""), new Bb.a("referer", ""), new Bb.a(g.ACTION_REFRESH, ""), new Bb.a("retry-after", ""), new Bb.a("server", ""), new Bb.a("set-cookie", ""), new Bb.a("strict-transport-security", ""), new Bb.a("transfer-encoding", ""), new Bb.a("user-agent", ""), new Bb.a("vary", ""), new Bb.a("via", ""), new Bb.a("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = bVar.d();
    }

    public final ByteString a(ByteString name) throws IOException {
        p.i(name, "name");
        int iK = name.K();
        for (int i10 = 0; i10 < iK; i10++) {
            byte bL = name.l(i10);
            if (65 <= bL && bL < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.Q());
            }
        }
        return name;
    }

    public final Map<ByteString, Integer> b() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Bb.a[] c() {
        return STATIC_HEADER_TABLE;
    }

    public final Map<ByteString, Integer> d() {
        Bb.a[] aVarArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(aVarArr.length, 1.0f);
        int length = aVarArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            Bb.a[] aVarArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(aVarArr2[i10].name)) {
                linkedHashMap.put(aVarArr2[i10].name, Integer.valueOf(i10));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        p.h(mapUnmodifiableMap, "unmodifiableMap(...)");
        return mapUnmodifiableMap;
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u000fJ\u000f\u0010\u0018\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0018\u0010\u000fJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u000fJ\u0017\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\u001eJ\u000f\u0010$\u001a\u00020\rH\u0002¢\u0006\u0004\b$\u0010\u000fJ\u0017\u0010%\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010+\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\nH\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\r2\u0006\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u00101R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00102R\u0016\u0010\u0006\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\n038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00107R\u0014\u0010\u0003\u001a\u0002098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010:R\u001e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0;8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010<R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00102R\u0016\u0010?\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b+\u00102R\u0016\u0010@\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b(\u00102¨\u0006A"}, d2 = {"Lokhttp3/internal/http2/b$a;", "", "LMb/I;", "source", "", "headerTableSizeSetting", "maxDynamicTableByteCount", "<init>", "(LMb/I;II)V", "", "LBb/a;", "f", "()Ljava/util/List;", "LY8/t;", "l", "()V", "firstByte", "prefixMask", "n", "(II)I", "Lokio/ByteString;", "k", "()Lokio/ByteString;", Const.INTENT_KEY_PKGNAME, "c", "bytesToRecover", "e", "(I)I", "index", "m", "(I)V", Const.INTENT_KEY_UMID, "q", "r", "nameIndex", "o", "p", Const.INTENT_KEY_BACKGROUND_COMMAND, "(I)Lokio/ByteString;", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)Z", "entry", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(ILBb/a;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()I", "header", Const.INTENT_KEY_APIKEY, "(LBb/a;)V", "I", "", "Ljava/util/List;", "headerList", "", "J", "headerListByteCount", "LMb/f;", "LMb/f;", "", "[LBb/a;", "dynamicTable", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final int headerTableSizeSetting;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int maxDynamicTableByteCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<Bb.a> headerList;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public long headerListByteCount;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC0968f source;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public Bb.a[] dynamicTable;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public int nextHeaderIndex;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public int headerCount;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public int dynamicTableByteCount;

        public a(I source, int i10, int i11) {
            p.i(source, "source");
            this.headerTableSizeSetting = i10;
            this.maxDynamicTableByteCount = i11;
            this.headerList = new ArrayList();
            this.source = u.c(source);
            this.dynamicTable = new Bb.a[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public final void a(Bb.a header) throws IOException {
            this.headerList.add(header);
            long jK = this.headerListByteCount + header.name.K() + header.value.K();
            this.headerListByteCount = jK;
            if (jK > 262144) {
                throw new IOException("header byte count limit of 262144 exceeded");
            }
        }

        public final void b() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    c();
                } else {
                    e(i11 - i10);
                }
            }
        }

        public final void c() {
            C1168p.B(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        public final int d(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        public final int e(int bytesToRecover) {
            int i10;
            int i11 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i10 = this.nextHeaderIndex;
                    if (length < i10 || bytesToRecover <= 0) {
                        break;
                    }
                    Bb.a aVar = this.dynamicTable[length];
                    p.f(aVar);
                    int i12 = aVar.hpackSize;
                    bytesToRecover -= i12;
                    this.dynamicTableByteCount -= i12;
                    this.headerCount--;
                    i11++;
                }
                Bb.a[] aVarArr = this.dynamicTable;
                System.arraycopy(aVarArr, i10 + 1, aVarArr, i10 + 1 + i11, this.headerCount);
                this.nextHeaderIndex += i11;
            }
            return i11;
        }

        public final List<Bb.a> f() {
            List<Bb.a> listM1 = F.m1(this.headerList);
            this.headerList.clear();
            this.headerListByteCount = 0L;
            return listM1;
        }

        public final ByteString g(int index) throws IOException {
            if (i(index)) {
                return b.f37648a.c()[index].name;
            }
            int iD = d(index - b.f37648a.c().length);
            if (iD >= 0) {
                Bb.a[] aVarArr = this.dynamicTable;
                if (iD < aVarArr.length) {
                    Bb.a aVar = aVarArr[iD];
                    p.f(aVar);
                    return aVar.name;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        public final void h(int index, Bb.a entry) throws IOException {
            a(entry);
            int i10 = entry.hpackSize;
            if (index != -1) {
                Bb.a aVar = this.dynamicTable[d(index)];
                p.f(aVar);
                i10 -= aVar.hpackSize;
            }
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                c();
                return;
            }
            int iE = e((this.dynamicTableByteCount + i10) - i11);
            if (index == -1) {
                int i12 = this.headerCount + 1;
                Bb.a[] aVarArr = this.dynamicTable;
                if (i12 > aVarArr.length) {
                    Bb.a[] aVarArr2 = new Bb.a[aVarArr.length * 2];
                    System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = aVarArr2;
                }
                int i13 = this.nextHeaderIndex;
                this.nextHeaderIndex = i13 - 1;
                this.dynamicTable[i13] = entry;
                this.headerCount++;
            } else {
                this.dynamicTable[index + d(index) + iE] = entry;
            }
            this.dynamicTableByteCount += i10;
        }

        public final boolean i(int index) {
            return index >= 0 && index <= b.f37648a.c().length - 1;
        }

        public final int j() throws IOException {
            return n.b(this.source.readByte(), 255);
        }

        public final ByteString k() throws IOException {
            int iJ = j();
            boolean z10 = (iJ & 128) == 128;
            long jN = n(iJ, 127);
            if (this.headerListByteCount + jN > 262144) {
                throw new IOException("header byte count limit of 262144 exceeded");
            }
            if (!z10) {
                return this.source.z0(jN);
            }
            C0966d c0966d = new C0966d();
            q.f1564a.b(this.source, jN, c0966d);
            return c0966d.N0();
        }

        public final void l() throws IOException {
            while (!this.source.k()) {
                int iB = n.b(this.source.readByte(), 255);
                if (iB == 128) {
                    throw new IOException("index == 0");
                }
                if ((iB & 128) == 128) {
                    m(n(iB, 127) - 1);
                } else if (iB == 64) {
                    p();
                } else if ((iB & 64) == 64) {
                    o(n(iB, 63) - 1);
                } else if ((iB & 32) == 32) {
                    int iN = n(iB, 31);
                    this.maxDynamicTableByteCount = iN;
                    if (iN < 0 || iN > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    b();
                } else if (iB == 16 || iB == 0) {
                    r();
                } else {
                    q(n(iB, 15) - 1);
                }
            }
        }

        public final void m(int index) throws IOException {
            if (i(index)) {
                a(b.f37648a.c()[index]);
                return;
            }
            int iD = d(index - b.f37648a.c().length);
            if (iD >= 0) {
                Bb.a[] aVarArr = this.dynamicTable;
                if (iD < aVarArr.length) {
                    Bb.a aVar = aVarArr[iD];
                    p.f(aVar);
                    a(aVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        public final int n(int firstByte, int prefixMask) throws IOException {
            int i10 = firstByte & prefixMask;
            if (i10 < prefixMask) {
                return i10;
            }
            long j10 = prefixMask;
            int i11 = 0;
            int i12 = 0;
            while (i11 != 5) {
                int iJ = j();
                i11++;
                long j11 = (iJ & 127) << i12;
                if (j11 > 2147483647L - j10) {
                    throw new IOException("HPACK integer overflow");
                }
                j10 += j11;
                if ((iJ & 128) == 0) {
                    return (int) j10;
                }
                i12 += 7;
            }
            throw new IOException("HPACK integer overflow");
        }

        public final void o(int nameIndex) throws IOException {
            h(-1, new Bb.a(g(nameIndex), k()));
        }

        public final void p() throws IOException {
            h(-1, new Bb.a(b.f37648a.a(k()), k()));
        }

        public final void q(int index) throws IOException {
            a(new Bb.a(g(index), k()));
        }

        public final void r() throws IOException {
            a(new Bb.a(b.f37648a.a(k()), k()));
        }

        public /* synthetic */ a(I i10, int i11, int i12, int i13, i iVar) {
            this(i10, i11, (i13 & 4) != 0 ? i11 : i12);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\rH\u0002¢\u0006\u0004\b#\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010%R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010$R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010%R\u0016\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010$R\u001e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0*8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010+R\u0016\u0010-\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010$R\u0016\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010$R\u0016\u00101\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b0\u0010$¨\u00062"}, d2 = {"Lokhttp3/internal/http2/b$b;", "", "", "headerTableSizeSetting", "", "useCompression", "LMb/d;", "out", "<init>", "(IZLMb/d;)V", "", "LBb/a;", "headerBlock", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/List;)V", UxipConstants.f30680s, "prefixMask", "bits", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(III)V", "Lokio/ByteString;", "data", "f", "(Lokio/ByteString;)V", "e", "(I)V", Const.INTENT_KEY_PKGNAME, "()V", "bytesToRecover", "c", "(I)I", "entry", Const.INTENT_KEY_UMID, "(LBb/a;)V", Const.INTENT_KEY_APIKEY, "I", "Z", "LMb/d;", "smallestHeaderTableSizeSetting", "emitDynamicTableSizeUpdate", "maxDynamicTableByteCount", "", "[LBb/a;", "dynamicTable", "nextHeaderIndex", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "headerCount", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "dynamicTableByteCount", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: okhttp3.internal.http2.b$b, reason: collision with other inner class name */
    public static final class C0483b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int headerTableSizeSetting;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final boolean useCompression;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final C0966d out;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public int smallestHeaderTableSizeSetting;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public boolean emitDynamicTableSizeUpdate;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public int maxDynamicTableByteCount;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public Bb.a[] dynamicTable;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public int nextHeaderIndex;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        public int headerCount;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        public int dynamicTableByteCount;

        public C0483b(int i10, boolean z10, C0966d out) {
            p.i(out, "out");
            this.headerTableSizeSetting = i10;
            this.useCompression = z10;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i10;
            this.dynamicTable = new Bb.a[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public final void a() {
            int i10 = this.maxDynamicTableByteCount;
            int i11 = this.dynamicTableByteCount;
            if (i10 < i11) {
                if (i10 == 0) {
                    b();
                } else {
                    c(i11 - i10);
                }
            }
        }

        public final void b() {
            C1168p.B(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        public final int c(int bytesToRecover) {
            int i10;
            int i11 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i10 = this.nextHeaderIndex;
                    if (length < i10 || bytesToRecover <= 0) {
                        break;
                    }
                    Bb.a aVar = this.dynamicTable[length];
                    p.f(aVar);
                    bytesToRecover -= aVar.hpackSize;
                    int i12 = this.dynamicTableByteCount;
                    Bb.a aVar2 = this.dynamicTable[length];
                    p.f(aVar2);
                    this.dynamicTableByteCount = i12 - aVar2.hpackSize;
                    this.headerCount--;
                    i11++;
                }
                Bb.a[] aVarArr = this.dynamicTable;
                System.arraycopy(aVarArr, i10 + 1, aVarArr, i10 + 1 + i11, this.headerCount);
                Bb.a[] aVarArr2 = this.dynamicTable;
                int i13 = this.nextHeaderIndex;
                Arrays.fill(aVarArr2, i13 + 1, i13 + 1 + i11, (Object) null);
                this.nextHeaderIndex += i11;
            }
            return i11;
        }

        public final void d(Bb.a entry) {
            int i10 = entry.hpackSize;
            int i11 = this.maxDynamicTableByteCount;
            if (i10 > i11) {
                b();
                return;
            }
            c((this.dynamicTableByteCount + i10) - i11);
            int i12 = this.headerCount + 1;
            Bb.a[] aVarArr = this.dynamicTable;
            if (i12 > aVarArr.length) {
                Bb.a[] aVarArr2 = new Bb.a[aVarArr.length * 2];
                System.arraycopy(aVarArr, 0, aVarArr2, aVarArr.length, aVarArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = aVarArr2;
            }
            int i13 = this.nextHeaderIndex;
            this.nextHeaderIndex = i13 - 1;
            this.dynamicTable[i13] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += i10;
        }

        public final void e(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int iMin = Math.min(headerTableSizeSetting, 16384);
            int i10 = this.maxDynamicTableByteCount;
            if (i10 == iMin) {
                return;
            }
            if (iMin < i10) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            a();
        }

        public final void f(ByteString data) throws IOException {
            p.i(data, "data");
            if (this.useCompression) {
                q qVar = q.f1564a;
                if (qVar.d(data) < data.K()) {
                    C0966d c0966d = new C0966d();
                    qVar.c(data, c0966d);
                    ByteString byteStringN0 = c0966d.N0();
                    h(byteStringN0.K(), 127, 128);
                    this.out.j1(byteStringN0);
                    return;
                }
            }
            h(data.K(), 127, 0);
            this.out.j1(data);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(java.util.List<Bb.a> r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.b.C0483b.g(java.util.List):void");
        }

        public final void h(int value, int prefixMask, int bits) {
            if (value < prefixMask) {
                this.out.writeByte(value | bits);
                return;
            }
            this.out.writeByte(bits | prefixMask);
            int i10 = value - prefixMask;
            while (i10 >= 128) {
                this.out.writeByte(128 | (i10 & 127));
                i10 >>>= 7;
            }
            this.out.writeByte(i10);
        }

        public /* synthetic */ C0483b(int i10, boolean z10, C0966d c0966d, int i11, i iVar) {
            this((i11 & 1) != 0 ? 4096 : i10, (i11 & 2) != 0 ? true : z10, c0966d);
        }
    }
}
