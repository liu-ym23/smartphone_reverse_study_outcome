package z2;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final String f6936a;

    public m(String str) {
        String[] strArrSplit = str.split("\\s+");
        if (strArrSplit.length != 3) {
            int i = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", new RuntimeException("err ProcessTrack line:".concat(str)));
            return;
        }
        String str2 = strArrSplit[0];
        this.f6936a = strArrSplit[1];
        try {
            Long.parseLong(strArrSplit[2]);
        } catch (Throwable th) {
            int i6 = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", new RuntimeException("err ProcessTrack line:".concat(str), th));
        }
    }
}
