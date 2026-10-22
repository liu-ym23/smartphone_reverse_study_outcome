package h2;

import F.i;
import android.os.FileObserver;
import android.text.TextUtils;
import z2.l;

/* loaded from: classes2.dex */
public final class c extends FileObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.apm.insight.d f4554a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, com.apm.insight.d dVar, String str2) {
        super(str, 136);
        this.f4554a = dVar;
        this.b = str2;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        String strW;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.apm.insight.d dVar = this.f4554a;
            String str2 = this.b;
            ((i) dVar).getClass();
            if (str.startsWith("anr")) {
                strW = M.a.w(str2 + "/" + str);
            } else {
                strW = null;
            }
            l.d = strW;
        } catch (Throwable th) {
            int i6 = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", th);
        }
    }
}
