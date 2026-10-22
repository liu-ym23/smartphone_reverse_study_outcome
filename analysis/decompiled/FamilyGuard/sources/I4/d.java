package I4;

import L4.o;
import L4.y;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    static final c[] f2997a;

    /* renamed from: b, reason: collision with root package name */
    static final Map<L4.h, Integer> f2998b;

    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c> f2999a;

        /* renamed from: b, reason: collision with root package name */
        private final L4.g f3000b;

        /* renamed from: c, reason: collision with root package name */
        private final int f3001c;

        /* renamed from: d, reason: collision with root package name */
        private int f3002d;

        /* renamed from: e, reason: collision with root package name */
        c[] f3003e;

        /* renamed from: f, reason: collision with root package name */
        int f3004f;

        /* renamed from: g, reason: collision with root package name */
        int f3005g;

        /* renamed from: h, reason: collision with root package name */
        int f3006h;

        a(int i5, y yVar) {
            this(i5, i5, yVar);
        }

        private void a() {
            int i5 = this.f3002d;
            int i6 = this.f3006h;
            if (i5 < i6) {
                if (i5 == 0) {
                    b();
                } else {
                    d(i6 - i5);
                }
            }
        }

        private void b() {
            Arrays.fill(this.f3003e, (Object) null);
            this.f3004f = this.f3003e.length - 1;
            this.f3005g = 0;
            this.f3006h = 0;
        }

        private int c(int i5) {
            return this.f3004f + 1 + i5;
        }

        private int d(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f3003e.length;
                while (true) {
                    length--;
                    i6 = this.f3004f;
                    if (length < i6 || i5 <= 0) {
                        break;
                    }
                    int i8 = this.f3003e[length].f2996c;
                    i5 -= i8;
                    this.f3006h -= i8;
                    this.f3005g--;
                    i7++;
                }
                c[] cVarArr = this.f3003e;
                System.arraycopy(cVarArr, i6 + 1, cVarArr, i6 + 1 + i7, this.f3005g);
                this.f3004f += i7;
            }
            return i7;
        }

        private L4.h f(int i5) throws IOException {
            if (h(i5)) {
                return d.f2997a[i5].f2994a;
            }
            int iC = c(i5 - d.f2997a.length);
            if (iC >= 0) {
                c[] cVarArr = this.f3003e;
                if (iC < cVarArr.length) {
                    return cVarArr[iC].f2994a;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void g(int i5, c cVar) {
            this.f2999a.add(cVar);
            int i6 = cVar.f2996c;
            if (i5 != -1) {
                i6 -= this.f3003e[c(i5)].f2996c;
            }
            int i7 = this.f3002d;
            if (i6 > i7) {
                b();
                return;
            }
            int iD = d((this.f3006h + i6) - i7);
            if (i5 == -1) {
                int i8 = this.f3005g + 1;
                c[] cVarArr = this.f3003e;
                if (i8 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f3004f = this.f3003e.length - 1;
                    this.f3003e = cVarArr2;
                }
                int i9 = this.f3004f;
                this.f3004f = i9 - 1;
                this.f3003e[i9] = cVar;
                this.f3005g++;
            } else {
                this.f3003e[i5 + c(i5) + iD] = cVar;
            }
            this.f3006h += i6;
        }

        private boolean h(int i5) {
            return i5 >= 0 && i5 <= d.f2997a.length - 1;
        }

        private int i() {
            return this.f3000b.readByte() & 255;
        }

        private void l(int i5) throws IOException {
            if (h(i5)) {
                this.f2999a.add(d.f2997a[i5]);
                return;
            }
            int iC = c(i5 - d.f2997a.length);
            if (iC >= 0) {
                c[] cVarArr = this.f3003e;
                if (iC < cVarArr.length) {
                    this.f2999a.add(cVarArr[iC]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i5 + 1));
        }

        private void n(int i5) {
            g(-1, new c(f(i5), j()));
        }

        private void o() {
            g(-1, new c(d.a(j()), j()));
        }

        private void p(int i5) throws IOException {
            this.f2999a.add(new c(f(i5), j()));
        }

        private void q() throws IOException {
            this.f2999a.add(new c(d.a(j()), j()));
        }

        public List<c> e() {
            ArrayList arrayList = new ArrayList(this.f2999a);
            this.f2999a.clear();
            return arrayList;
        }

        L4.h j() {
            int i5 = i();
            boolean z5 = (i5 & 128) == 128;
            int iM = m(i5, 127);
            return z5 ? L4.h.p(k.f().c(this.f3000b.g0(iM))) : this.f3000b.j(iM);
        }

        void k() throws IOException {
            while (!this.f3000b.t()) {
                byte b6 = this.f3000b.readByte();
                int i5 = b6 & 255;
                if (i5 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b6 & 128) == 128) {
                    l(m(i5, 127) - 1);
                } else if (i5 == 64) {
                    o();
                } else if ((b6 & 64) == 64) {
                    n(m(i5, 63) - 1);
                } else if ((b6 & 32) == 32) {
                    int iM = m(i5, 31);
                    this.f3002d = iM;
                    if (iM < 0 || iM > this.f3001c) {
                        throw new IOException("Invalid dynamic table size update " + this.f3002d);
                    }
                    a();
                } else if (i5 == 16 || i5 == 0) {
                    q();
                } else {
                    p(m(i5, 15) - 1);
                }
            }
        }

        int m(int i5, int i6) {
            int i7 = i5 & i6;
            if (i7 < i6) {
                return i7;
            }
            int i8 = 0;
            while (true) {
                int i9 = i();
                if ((i9 & 128) == 0) {
                    return i6 + (i9 << i8);
                }
                i6 += (i9 & 127) << i8;
                i8 += 7;
            }
        }

        a(int i5, int i6, y yVar) {
            this.f2999a = new ArrayList();
            this.f3003e = new c[8];
            this.f3004f = r0.length - 1;
            this.f3005g = 0;
            this.f3006h = 0;
            this.f3001c = i5;
            this.f3002d = i6;
            this.f3000b = o.b(yVar);
        }
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final L4.e f3007a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f3008b;

        /* renamed from: c, reason: collision with root package name */
        private int f3009c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f3010d;

        /* renamed from: e, reason: collision with root package name */
        int f3011e;

        /* renamed from: f, reason: collision with root package name */
        int f3012f;

        /* renamed from: g, reason: collision with root package name */
        c[] f3013g;

        /* renamed from: h, reason: collision with root package name */
        int f3014h;

        /* renamed from: i, reason: collision with root package name */
        int f3015i;

        /* renamed from: j, reason: collision with root package name */
        int f3016j;

        b(L4.e eVar) {
            this(RecyclerView.ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT, true, eVar);
        }

        private void a() {
            int i5 = this.f3012f;
            int i6 = this.f3016j;
            if (i5 < i6) {
                if (i5 == 0) {
                    b();
                } else {
                    c(i6 - i5);
                }
            }
        }

        private void b() {
            Arrays.fill(this.f3013g, (Object) null);
            this.f3014h = this.f3013g.length - 1;
            this.f3015i = 0;
            this.f3016j = 0;
        }

        private int c(int i5) {
            int i6;
            int i7 = 0;
            if (i5 > 0) {
                int length = this.f3013g.length;
                while (true) {
                    length--;
                    i6 = this.f3014h;
                    if (length < i6 || i5 <= 0) {
                        break;
                    }
                    int i8 = this.f3013g[length].f2996c;
                    i5 -= i8;
                    this.f3016j -= i8;
                    this.f3015i--;
                    i7++;
                }
                c[] cVarArr = this.f3013g;
                System.arraycopy(cVarArr, i6 + 1, cVarArr, i6 + 1 + i7, this.f3015i);
                c[] cVarArr2 = this.f3013g;
                int i9 = this.f3014h;
                Arrays.fill(cVarArr2, i9 + 1, i9 + 1 + i7, (Object) null);
                this.f3014h += i7;
            }
            return i7;
        }

        private void d(c cVar) {
            int i5 = cVar.f2996c;
            int i6 = this.f3012f;
            if (i5 > i6) {
                b();
                return;
            }
            c((this.f3016j + i5) - i6);
            int i7 = this.f3015i + 1;
            c[] cVarArr = this.f3013g;
            if (i7 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f3014h = this.f3013g.length - 1;
                this.f3013g = cVarArr2;
            }
            int i8 = this.f3014h;
            this.f3014h = i8 - 1;
            this.f3013g[i8] = cVar;
            this.f3015i++;
            this.f3016j += i5;
        }

        void e(int i5) {
            this.f3011e = i5;
            int iMin = Math.min(i5, 16384);
            int i6 = this.f3012f;
            if (i6 == iMin) {
                return;
            }
            if (iMin < i6) {
                this.f3009c = Math.min(this.f3009c, iMin);
            }
            this.f3010d = true;
            this.f3012f = iMin;
            a();
        }

        void f(L4.h hVar) {
            if (!this.f3008b || k.f().e(hVar) >= hVar.w()) {
                h(hVar.w(), 127, 0);
                this.f3007a.R(hVar);
                return;
            }
            L4.e eVar = new L4.e();
            k.f().d(hVar, eVar);
            L4.h hVarG = eVar.G();
            h(hVarG.w(), 127, 128);
            this.f3007a.R(hVarG);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void g(java.util.List<I4.c> r14) {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: I4.d.b.g(java.util.List):void");
        }

        void h(int i5, int i6, int i7) {
            if (i5 < i6) {
                this.f3007a.writeByte(i5 | i7);
                return;
            }
            this.f3007a.writeByte(i7 | i6);
            int i8 = i5 - i6;
            while (i8 >= 128) {
                this.f3007a.writeByte(128 | (i8 & 127));
                i8 >>>= 7;
            }
            this.f3007a.writeByte(i8);
        }

        b(int i5, boolean z5, L4.e eVar) {
            this.f3009c = Integer.MAX_VALUE;
            this.f3013g = new c[8];
            this.f3014h = r0.length - 1;
            this.f3015i = 0;
            this.f3016j = 0;
            this.f3011e = i5;
            this.f3012f = i5;
            this.f3008b = z5;
            this.f3007a = eVar;
        }
    }

    static {
        c cVar = new c(c.f2993i, BuildConfig.FLAVOR);
        L4.h hVar = c.f2990f;
        c cVar2 = new c(hVar, "GET");
        c cVar3 = new c(hVar, "POST");
        L4.h hVar2 = c.f2991g;
        c cVar4 = new c(hVar2, "/");
        c cVar5 = new c(hVar2, "/index.html");
        L4.h hVar3 = c.f2992h;
        c cVar6 = new c(hVar3, "http");
        c cVar7 = new c(hVar3, "https");
        L4.h hVar4 = c.f2989e;
        f2997a = new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, new c(hVar4, "200"), new c(hVar4, "204"), new c(hVar4, "206"), new c(hVar4, "304"), new c(hVar4, "400"), new c(hVar4, "404"), new c(hVar4, "500"), new c("accept-charset", BuildConfig.FLAVOR), new c("accept-encoding", "gzip, deflate"), new c("accept-language", BuildConfig.FLAVOR), new c("accept-ranges", BuildConfig.FLAVOR), new c("accept", BuildConfig.FLAVOR), new c("access-control-allow-origin", BuildConfig.FLAVOR), new c("age", BuildConfig.FLAVOR), new c("allow", BuildConfig.FLAVOR), new c("authorization", BuildConfig.FLAVOR), new c("cache-control", BuildConfig.FLAVOR), new c("content-disposition", BuildConfig.FLAVOR), new c("content-encoding", BuildConfig.FLAVOR), new c("content-language", BuildConfig.FLAVOR), new c("content-length", BuildConfig.FLAVOR), new c("content-location", BuildConfig.FLAVOR), new c("content-range", BuildConfig.FLAVOR), new c("content-type", BuildConfig.FLAVOR), new c("cookie", BuildConfig.FLAVOR), new c("date", BuildConfig.FLAVOR), new c("etag", BuildConfig.FLAVOR), new c("expect", BuildConfig.FLAVOR), new c("expires", BuildConfig.FLAVOR), new c("from", BuildConfig.FLAVOR), new c("host", BuildConfig.FLAVOR), new c("if-match", BuildConfig.FLAVOR), new c("if-modified-since", BuildConfig.FLAVOR), new c("if-none-match", BuildConfig.FLAVOR), new c("if-range", BuildConfig.FLAVOR), new c("if-unmodified-since", BuildConfig.FLAVOR), new c("last-modified", BuildConfig.FLAVOR), new c("link", BuildConfig.FLAVOR), new c("location", BuildConfig.FLAVOR), new c("max-forwards", BuildConfig.FLAVOR), new c("proxy-authenticate", BuildConfig.FLAVOR), new c("proxy-authorization", BuildConfig.FLAVOR), new c("range", BuildConfig.FLAVOR), new c("referer", BuildConfig.FLAVOR), new c("refresh", BuildConfig.FLAVOR), new c("retry-after", BuildConfig.FLAVOR), new c("server", BuildConfig.FLAVOR), new c("set-cookie", BuildConfig.FLAVOR), new c("strict-transport-security", BuildConfig.FLAVOR), new c("transfer-encoding", BuildConfig.FLAVOR), new c("user-agent", BuildConfig.FLAVOR), new c("vary", BuildConfig.FLAVOR), new c("via", BuildConfig.FLAVOR), new c("www-authenticate", BuildConfig.FLAVOR)};
        f2998b = b();
    }

    static L4.h a(L4.h hVar) throws IOException {
        int iW = hVar.w();
        for (int i5 = 0; i5 < iW; i5++) {
            byte bI = hVar.i(i5);
            if (bI >= 65 && bI <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + hVar.C());
            }
        }
        return hVar;
    }

    private static Map<L4.h, Integer> b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f2997a.length);
        int i5 = 0;
        while (true) {
            c[] cVarArr = f2997a;
            if (i5 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i5].f2994a)) {
                linkedHashMap.put(cVarArr[i5].f2994a, Integer.valueOf(i5));
            }
            i5++;
        }
    }
}
