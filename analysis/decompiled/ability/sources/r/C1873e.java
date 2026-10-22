package r;

/* renamed from: r.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1873e extends AbstractC1869a {
    public static final long[] f = {60000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};
    public static final long[] g = {180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    public static final long[] h = {10000, 10000, 20000, 20000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};

    /* JADX WARN: Can't wrap try/catch for region: R(12:26|(2:29|(2:31|(39:64|(1:66)|67|(1:69)(1:70)|71|185|72|73|179|74|75|193|76|(1:78)|81|(1:83)|84|(2:89|(1:91))(1:(2:95|(1:97)(1:98)))|99|(1:101)(1:102)|103|(1:105)|(4:107|(3:109|(1:114)|115)(1:116)|117|(1:119))(1:120)|(2:(1:125)|126)|127|(2:129|(2:(1:132)|133))(1:134)|135|(14:137|191|138|(2:(1:141)|144)|(1:150)|151|152|153|154|155|(1:166)(1:167)|(1:172)(1:171)|173|174)(1:145)|146|(2:148|150)|151|152|153|154|155|(1:166)(1:166)|(2:169|172)(0)|173|174)(1:175)))|32|183|33|(1:35)(1:36)|37|(1:45)(1:41)|189|46|(5:195|53|187|54|55)(1:61)|62) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x019d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b7, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x01b8, code lost:
    
        w.h.a("request register error.", r0);
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:163:0x044d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0451 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01e7  */
    @Override // r.AbstractC1869a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1172
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.C1873e.c():boolean");
    }

    @Override // r.AbstractC1869a
    public final String d() {
        return "register";
    }

    @Override // r.AbstractC1869a
    public final long[] e() {
        int iE = this.f5661a.f.e();
        if (iE == 0) {
            return h;
        }
        long[] jArr = g;
        if (iE == 1) {
            return jArr;
        }
        if (iE == 2) {
            return f;
        }
        w.h.b(null);
        return jArr;
    }

    @Override // r.AbstractC1869a
    public final long f() {
        long j5 = this.f5661a.f.f.getLong("bd_did_life_time", 0L);
        return j5 > 0 ? j5 : this.f5661a.f5664j.g ? 21600000L : 43200000L;
    }
}
