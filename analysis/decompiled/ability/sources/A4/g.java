package A4;

import android.os.Handler;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import f6.AbstractC1436a;
import java.io.Serializable;
import kotlin.jvm.internal.Ref$ObjectRef;
import p6.p;

/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f102a = 0;
    public final /* synthetic */ String b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Serializable d;
    public final /* synthetic */ Serializable e;
    public final /* synthetic */ Object f;

    public /* synthetic */ g(j jVar, String str, String str2, String str3, String str4) {
        this.c = jVar;
        this.b = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f102a;
        Object obj = this.f;
        Serializable serializable = this.e;
        Serializable serializable2 = this.d;
        Object obj2 = this.c;
        String str = this.b;
        switch (i) {
            case 0:
                String str2 = (String) obj;
                try {
                    ((j) obj2).f105a.onRequestRelaunch(str, (String) serializable2, (String) serializable);
                    break;
                } catch (Throwable th) {
                    k.b(str2, "publishRequestRelaunch", th);
                    return;
                }
            default:
                AbstractC1436a.e("SafetyComplianceGuard", "preCheckGuiTask: master switch timeout, deny taskId=".concat(str), true);
                Handler handler = p.f5554a;
                p.c((WhitelistCacheManager) obj2, (WhitelistCacheManager.OnMasterSwitchChangedListener) ((Ref$ObjectRef) serializable2).f4920a, (WhitelistCacheManager.OnSafetySettingsDismissedListener) ((Ref$ObjectRef) serializable).f4920a, null);
                p.f((ITaskProgressCallback) obj, str, "授权超时，请重新发起任务");
                break;
        }
    }

    public /* synthetic */ g(String str, WhitelistCacheManager whitelistCacheManager, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, ITaskProgressCallback iTaskProgressCallback) {
        this.b = str;
        this.c = whitelistCacheManager;
        this.d = ref$ObjectRef;
        this.e = ref$ObjectRef2;
        this.f = iTaskProgressCallback;
    }
}
