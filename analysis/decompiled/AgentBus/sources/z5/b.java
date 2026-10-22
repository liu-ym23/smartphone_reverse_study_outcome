package z5;

import d5.m;
import q7.k;

/* loaded from: classes.dex */
public final class b implements s5.d {

    /* renamed from: a, reason: collision with root package name */
    public final c f11807a;

    public b(c cVar) {
        this.f11807a = cVar;
    }

    @Override // s5.d
    public final boolean a(c5.b bVar, d5.e eVar) {
        k.e(bVar, "frame");
        k.e(eVar, "source");
        if (eVar.f() == m.CHANNEL && bVar.f1896a.equals("req") && k.a(bVar.d(), "chat.send")) {
            return true;
        }
        return eVar.f() == m.GATEWAY && k.a(bVar.d(), "node.event") && k.a(bVar.e(), "session.message");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01b9 A[PHI: r3
      0x01b9: PHI (r3v27 java.lang.String) = (r3v25 java.lang.String), (r3v28 java.lang.String) binds: [B:108:0x01b5, B:98:0x019b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0183 A[PHI: r2
      0x0183: PHI (r2v31 java.lang.String) = (r2v29 java.lang.String), (r2v33 java.lang.String) binds: [B:87:0x017f, B:77:0x0165] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d  */
    @Override // s5.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(c5.b r33, d5.e r34, g7.d r35) {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z5.b.b(c5.b, d5.e, g7.d):java.lang.Object");
    }

    @Override // s5.d
    public final String getId() {
        return "data-report.chat";
    }
}
