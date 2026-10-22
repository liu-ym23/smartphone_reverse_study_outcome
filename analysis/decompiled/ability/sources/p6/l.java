package p6;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import com.stepos.ability.R;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import f6.AbstractC1436a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Ref$ObjectRef;

/* loaded from: classes3.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5550a = 0;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ ITaskProgressCallback d;
    public final /* synthetic */ WhitelistCacheManager e;
    public final /* synthetic */ Serializable f;
    public final /* synthetic */ Serializable g;
    public final /* synthetic */ Serializable h;
    public final /* synthetic */ Object i;

    public /* synthetic */ l(Context context, ITaskProgressCallback iTaskProgressCallback, WhitelistCacheManager whitelistCacheManager, String str, AtomicBoolean atomicBoolean, Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        this.b = context;
        this.e = whitelistCacheManager;
        this.f = ref$ObjectRef;
        this.g = ref$ObjectRef2;
        this.h = ref$ObjectRef3;
        this.d = iTaskProgressCallback;
        this.c = str;
        this.i = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar;
        ITaskProgressCallback iTaskProgressCallback;
        String str;
        int i = this.f5550a;
        Object obj = this.i;
        Serializable serializable = this.h;
        Serializable serializable2 = this.g;
        Serializable serializable3 = this.f;
        switch (i) {
            case 0:
                Context context = this.b;
                final WhitelistCacheManager whitelistCacheManager = this.e;
                final Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) serializable3;
                final Ref$ObjectRef ref$ObjectRef2 = (Ref$ObjectRef) serializable2;
                final Ref$ObjectRef ref$ObjectRef3 = (Ref$ObjectRef) serializable;
                final ITaskProgressCallback iTaskProgressCallback2 = this.d;
                final String str2 = this.c;
                final AtomicBoolean atomicBoolean = (AtomicBoolean) obj;
                try {
                    kotlin.jvm.internal.k.f(context, "context");
                    fVar = new f(com.stepos.statsrpk.d.P(context), R.style.PhoneAuthorizationDialog);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    m mVar = new m(context, iTaskProgressCallback2, whitelistCacheManager, str2, atomicBoolean, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3);
                    iTaskProgressCallback2 = iTaskProgressCallback2;
                    whitelistCacheManager = whitelistCacheManager;
                    str2 = str2;
                    ref$ObjectRef = ref$ObjectRef;
                    ref$ObjectRef2 = ref$ObjectRef2;
                    ref$ObjectRef3 = ref$ObjectRef3;
                    fVar.f5544a = mVar;
                    fVar.b = new n(iTaskProgressCallback2, whitelistCacheManager, str2, atomicBoolean, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3);
                    fVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: p6.o
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            if (atomicBoolean.compareAndSet(false, true)) {
                                String str3 = str2;
                                AbstractC1436a.e("SafetyComplianceGuard", "preCheckGuiTask: dialog dismissed without button, fallback cleanup+deny taskId=".concat(str3), true);
                                Handler handler = p.f5554a;
                                p.c(whitelistCacheManager, (WhitelistCacheManager.OnMasterSwitchChangedListener) ref$ObjectRef.f4920a, (WhitelistCacheManager.OnSafetySettingsDismissedListener) ref$ObjectRef2.f4920a, (Runnable) ref$ObjectRef3.f4920a);
                                p.f(iTaskProgressCallback2, str3, "用户拒绝Amoo操作手机授权");
                            }
                        }
                    });
                    AbstractC1436a.d("PhoneAuthorizationDialog", "[LOOP-DEBUG] PhoneAuthorizationDialog.showFromService called, thread=" + Thread.currentThread().getName(), true);
                    b.a(fVar, R.dimen.auth_dialog_margin_horizontal, R.dimen.auth_dialog_margin_bottom, R.dimen.auth_dialog_padding_top, R.dimen.auth_dialog_content_button_spacing, R.dimen.auth_dialog_button_height, R.dimen.auth_dialog_padding_bottom, 0.6f, false, 20);
                    break;
                } catch (Throwable th2) {
                    th = th2;
                    iTaskProgressCallback2 = iTaskProgressCallback2;
                    whitelistCacheManager = whitelistCacheManager;
                    str2 = str2;
                    ref$ObjectRef = ref$ObjectRef;
                    ref$ObjectRef2 = ref$ObjectRef2;
                    ref$ObjectRef3 = ref$ObjectRef3;
                    Handler handler = p.f5554a;
                    p.c(whitelistCacheManager, (WhitelistCacheManager.OnMasterSwitchChangedListener) ref$ObjectRef.f4920a, (WhitelistCacheManager.OnSafetySettingsDismissedListener) ref$ObjectRef2.f4920a, (Runnable) ref$ObjectRef3.f4920a);
                    AbstractC1436a.c("SafetyComplianceGuard", "preCheckGuiTask: show dialog failed", th);
                    p.f(iTaskProgressCallback2, str2, "用户拒绝Amoo操作手机授权");
                    return;
                }
            default:
                Context context2 = this.b;
                String str3 = this.c;
                String str4 = (String) serializable3;
                ITaskProgressCallback iTaskProgressCallback3 = this.d;
                String str5 = (String) serializable2;
                String str6 = (String) serializable;
                WhitelistCacheManager whitelistCacheManager2 = this.e;
                S7.k kVar = (S7.k) obj;
                try {
                    String string = context2.getString(R.string.recommend_redirect_title);
                    kotlin.jvm.internal.k.e(string, "getString(...)");
                    String string2 = context2.getString(R.string.recommend_redirect_desc, str3, str4);
                    kotlin.jvm.internal.k.e(string2, "getString(...)");
                    String string3 = context2.getString(R.string.recommend_redirect_button_confirm, str4);
                    kotlin.jvm.internal.k.e(string3, "getString(...)");
                    String string4 = context2.getString(R.string.recommend_redirect_button_cancel);
                    kotlin.jvm.internal.k.e(string4, "getString(...)");
                    d dVar = new d(context2, string, string2, string3, string4, "redirect:" + str3 + "->" + str4);
                    iTaskProgressCallback = iTaskProgressCallback3;
                    str = str5;
                    try {
                        dVar.e = new n(kVar, context2, iTaskProgressCallback, whitelistCacheManager2, str6, str4, str);
                        dVar.f = new j(str, str3, iTaskProgressCallback, 1);
                        dVar.a();
                        break;
                    } catch (Throwable th3) {
                        th = th3;
                        p.b.set(false);
                        AbstractC1436a.c("SafetyComplianceGuard", "checkRedirect: show dialog failed", th);
                        Handler handler2 = p.f5554a;
                        p.e(iTaskProgressCallback, str, str3);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    iTaskProgressCallback = iTaskProgressCallback3;
                    str = str5;
                }
        }
    }

    public /* synthetic */ l(Context context, String str, String str2, ITaskProgressCallback iTaskProgressCallback, String str3, String str4, WhitelistCacheManager whitelistCacheManager, S7.k kVar) {
        this.b = context;
        this.c = str;
        this.f = str2;
        this.d = iTaskProgressCallback;
        this.g = str3;
        this.h = str4;
        this.e = whitelistCacheManager;
        this.i = kVar;
    }
}
