package la;

import android.content.Context;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public sa.a f10381a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f10382a = new b();
    }

    public final String a(Context context) {
        if (this.f10381a == null) {
            this.f10381a = new sa.a(context, "com.stepos.statsapp.v3.umid");
        }
        String string = this.f10381a.f11898a.getString("UMID", "");
        ta.c.a("UmidFetcher", "getLocalUmId umId:" + string);
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01b2 A[Catch: JSONException -> 0x01f3, TryCatch #1 {JSONException -> 0x01f3, blocks: (B:54:0x01a0, B:57:0x01b2, B:60:0x01ca, B:62:0x01e2, B:63:0x01eb), top: B:70:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.content.Context r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.b.b(android.content.Context):java.lang.String");
    }
}
