package p6;

import C7.r;
import android.os.Handler;
import com.stepos.taskrobot.common.ITaskProgressCallback;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5548a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ITaskProgressCallback d;

    public /* synthetic */ j(String str, String str2, ITaskProgressCallback iTaskProgressCallback, int i) {
        this.f5548a = i;
        this.b = str;
        this.c = str2;
        this.d = iTaskProgressCallback;
    }

    @Override // S7.a
    public final Object invoke() {
        int i = this.f5548a;
        r rVar = r.f317a;
        ITaskProgressCallback iTaskProgressCallback = this.d;
        String str = this.c;
        String str2 = this.b;
        switch (i) {
            case 0:
                p.b.set(false);
                StringBuilder sb = new StringBuilder("checkAppAuthorized: user denied, appName=");
                sb.append(str2);
                sb.append(" taskId=");
                com.stepos.statsrpk.service.c.r(sb, str, "SafetyComplianceGuard", true);
                Handler handler = p.f5554a;
                p.d(iTaskProgressCallback, str, str2);
                break;
            default:
                p.b.set(false);
                StringBuilder sb2 = new StringBuilder("checkRedirect: user cancelled redirect, deny taskId=");
                sb2.append(str2);
                sb2.append(" appName=");
                com.stepos.statsrpk.service.c.r(sb2, str, "SafetyComplianceGuard", true);
                Handler handler2 = p.f5554a;
                p.e(iTaskProgressCallback, str2, str);
                break;
        }
        return rVar;
    }
}
