package p6;

import C7.r;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import f6.AbstractC1436a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f5551a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ WhitelistCacheManager c;
    public final /* synthetic */ Ref$ObjectRef d;
    public final /* synthetic */ Ref$ObjectRef e;
    public final /* synthetic */ Ref$ObjectRef f;
    public final /* synthetic */ ITaskProgressCallback g;
    public final /* synthetic */ String h;

    public /* synthetic */ m(Context context, ITaskProgressCallback iTaskProgressCallback, WhitelistCacheManager whitelistCacheManager, String str, AtomicBoolean atomicBoolean, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.f5551a = atomicBoolean;
        this.b = context;
        this.c = whitelistCacheManager;
        this.d = ref$ObjectRef;
        this.e = ref$ObjectRef2;
        this.f = ref$ObjectRef3;
        this.g = iTaskProgressCallback;
        this.h = str;
    }

    @Override // S7.a
    public final Object invoke() {
        Context context = this.b;
        Handler handler = p.f5554a;
        this.f5551a.set(true);
        try {
            Intent intent = new Intent("com.stepos.ailauncher.action.DISMISS_WAKE");
            intent.setPackage("com.stepos.ailauncher");
            context.sendBroadcast(intent);
        } catch (Exception e) {
            AbstractC1436a.c("SafetyComplianceGuard", "preCheckGuiTask: sendDismissWakeBroadcast failed", e);
        }
        Intent intent2 = new Intent("stepos.intent.action.AGENT_OPERATE_PHONE");
        intent2.addFlags(268435456);
        try {
            context.startActivity(intent2);
        } catch (ActivityNotFoundException e6) {
            AbstractC1436a.c("SafetyComplianceGuard", "preCheckGuiTask: settings app not installed", e6);
            p.c(this.c, (WhitelistCacheManager.OnMasterSwitchChangedListener) this.d.f4920a, (WhitelistCacheManager.OnSafetySettingsDismissedListener) this.e.f4920a, (Runnable) this.f.f4920a);
            p.f(this.g, this.h, "用户拒绝Amoo操作手机授权");
        }
        return r.f317a;
    }
}
