package g4;

import a6.w;
import c5.m;
import c5.o;
import j6.k;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k4.q;
import k4.t;
import kotlin.jvm.internal.p;
import n4.h;
import n4.i;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends n4.d {

    /* renamed from: a, reason: collision with root package name */
    public final k4.g f2975a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2976b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f2977c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2978e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f2979f;

    /* renamed from: g, reason: collision with root package name */
    public final Long f2980g;

    public f(ArrayList arrayList) throws CharacterCodingException {
        g gVar;
        byte[] bArr = b.f2964a;
        StringBuilder sb = new StringBuilder();
        int i8 = 0;
        for (int i9 = 0; i9 < 32; i9++) {
            s5.a aVar = s5.d.f5240a;
            int iNextInt = s5.d.f5240a.a().nextInt();
            x.f.r(16);
            String string = Integer.toString(iNextInt, 16);
            p.d(string, "toString(...)");
            sb.append(string);
        }
        String strQ1 = n.Q1(70, sb.toString());
        this.f2975a = k4.e.f3604a.v("boundary", strQ1);
        String strD = m0.f.d("--", strQ1, "\r\n");
        Charset charset = x5.a.f6276a;
        byte[] bArrX0 = x.e.x0(strD, charset);
        this.f2976b = bArrX0;
        byte[] bArrX02 = x.e.x0("--" + strQ1 + "--\r\n", charset);
        this.f2977c = bArrX02;
        this.d = bArrX02.length;
        this.f2978e = (b.f2964a.length * 2) + bArrX0.length;
        ArrayList arrayList2 = new ArrayList(o.n0(arrayList, 10));
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                this.f2979f = arrayList2;
                Long lValueOf = 0L;
                int size2 = arrayList2.size();
                while (true) {
                    if (i8 >= size2) {
                        l = lValueOf;
                        break;
                    }
                    Object obj = arrayList2.get(i8);
                    i8++;
                    Long l3 = ((g) obj).f2982b;
                    if (l3 == null) {
                        break;
                    } else {
                        lValueOf = lValueOf != null ? Long.valueOf(l3.longValue() + lValueOf.longValue()) : null;
                    }
                }
                this.f2980g = l != null ? Long.valueOf(l.longValue() + this.d) : l;
                return;
            }
            Object obj2 = arrayList.get(i10);
            i10++;
            i iVar = (i) obj2;
            j6.a aVar2 = new j6.a();
            for (Map.Entry entry : iVar.f3982a.a()) {
                x.e.D0(aVar2, ((String) entry.getKey()) + ": " + m.A0((List) entry.getValue(), "; ", null, null, null, 62));
                x.e.C0(aVar2, b.f2964a);
            }
            q qVar = iVar.f3982a;
            List list = t.f3636a;
            String strD2 = qVar.d("Content-Length");
            Long lValueOf2 = strD2 != null ? Long.valueOf(Long.parseLong(strD2)) : null;
            if (iVar instanceof n4.g) {
                gVar = new g(k.f(aVar2, -1), ((n4.g) iVar).f3980b, lValueOf2 != null ? Long.valueOf(lValueOf2.longValue() + this.f2978e + r8.length) : null);
            } else {
                if (!(iVar instanceof h)) {
                    throw new w();
                }
                j6.a aVar3 = new j6.a();
                x.e.D0(aVar3, ((h) iVar).f3981b);
                byte[] bArrF = k.f(aVar3, -1);
                b7.c cVar = new b7.c(14, bArrF);
                if (lValueOf2 == null) {
                    x.e.D0(aVar2, "Content-Length: " + bArrF.length);
                    x.e.C0(aVar2, b.f2964a);
                }
                gVar = new g(k.f(aVar2, -1), cVar, Long.valueOf(bArrF.length + this.f2978e + r8.length));
            }
            arrayList2.add(gVar);
        }
    }

    @Override // n4.e
    public final Long a() {
        return this.f2980g;
    }

    @Override // n4.e
    public final k4.g b() {
        return this.f2975a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x012b, code lost:
    
        if (r10 == r1) goto L94;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c2 A[Catch: all -> 0x004a, TryCatch #2 {all -> 0x004a, blocks: (B:17:0x0045, B:47:0x00bc, B:49:0x00c2, B:52:0x00dc, B:55:0x00f0, B:70:0x0133, B:80:0x0155, B:46:0x00b6), top: B:98:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f0 A[Catch: all -> 0x004a, PHI: r2 r9 r10
      0x00f0: PHI (r2v13 g4.g) = (r2v4 g4.g), (r2v15 g4.g) binds: [B:41:0x009e, B:53:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      0x00f0: PHI (r9v27 io.ktor.utils.io.d0) = (r9v12 io.ktor.utils.io.d0), (r9v29 io.ktor.utils.io.d0) binds: [B:41:0x009e, B:53:0x00ec] A[DONT_GENERATE, DONT_INLINE]
      0x00f0: PHI (r10v18 java.util.Iterator) = (r10v7 java.util.Iterator), (r10v19 java.util.Iterator) binds: [B:41:0x009e, B:53:0x00ec] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:17:0x0045, B:47:0x00bc, B:49:0x00c2, B:52:0x00dc, B:55:0x00f0, B:70:0x0133, B:80:0x0155, B:46:0x00b6), top: B:98:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010b A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #5 {all -> 0x008d, blocks: (B:59:0x0107, B:61:0x010b, B:68:0x012f, B:78:0x014f, B:79:0x0154, B:76:0x014b, B:77:0x014e, B:35:0x0088, B:40:0x009b, B:43:0x00ac, B:74:0x0149, B:62:0x0113, B:30:0x0076), top: B:98:0x0023, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x014f A[Catch: all -> 0x008d, TryCatch #5 {all -> 0x008d, blocks: (B:59:0x0107, B:61:0x010b, B:68:0x012f, B:78:0x014f, B:79:0x0154, B:76:0x014b, B:77:0x014e, B:35:0x0088, B:40:0x009b, B:43:0x00ac, B:74:0x0149, B:62:0x0113, B:30:0x0076), top: B:98:0x0023, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0155 A[Catch: all -> 0x004a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:17:0x0045, B:47:0x00bc, B:49:0x00c2, B:52:0x00dc, B:55:0x00f0, B:70:0x0133, B:80:0x0155, B:46:0x00b6), top: B:98:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x018b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019f A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:73:0x0146 -> B:47:0x00bc). Please report as a decompilation issue!!! */
    @Override // n4.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(io.ktor.utils.io.d0 r9, f5.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.f.d(io.ktor.utils.io.d0, f5.c):java.lang.Object");
    }
}
