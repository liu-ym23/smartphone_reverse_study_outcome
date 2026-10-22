package p6;

import C7.r;
import D7.q;
import D7.v;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.Gson;
import com.stepos.ability.R;
import com.stepos.taskrobot.common.ITaskProgressCallback;
import com.stepos.taskrobot.dictionary.model.WhitelistApp;
import com.stepos.taskrobot.llmapi.stepfun.PackageUtil;
import com.stepos.taskrobot.settingsprovider.WhitelistCacheManager;
import f6.AbstractC1436a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f5554a = new Handler(Looper.getMainLooper());
    public static final AtomicBoolean b = new AtomicBoolean(false);
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final Gson d = new Gson();
    public static int e;
    public static int f;
    public static int g;

    public static boolean a(final Context context, final WhitelistCacheManager whitelistCacheManager, final String str, final String str2, final String str3, boolean z10, final ITaskProgressCallback iTaskProgressCallback, final S7.k kVar) {
        Object objA;
        Object objA2;
        if (str2 == null || j9.m.s0(str2)) {
            AbstractC1436a.d("SafetyComplianceGuard", "[LOOP-DEBUG] checkAppInstalled: no appName, calling onProceed, taskId=".concat(str), true);
            int i = f + 1;
            f = i;
            AbstractC1436a.d("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i, "[LOOP-DEBUG] onProceed called (no appName): callCount=", ", taskId=", str), true);
            int i6 = f;
            if (i6 % 10 == 0) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                kotlin.jvm.internal.k.e(stackTrace, "getStackTrace(...)");
                AbstractC1436a.b("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i6, "[LOOP-DEBUG] onProceed SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace), "\n", null, null, null, 62)), true);
            }
            kVar.invoke(str3);
            return true;
        }
        String packageNameByAppName = PackageUtil.INSTANCE.getPackageNameByAppName(context, str2);
        if (packageNameByAppName == null || packageNameByAppName.length() == 0) {
            StringBuilder sbW = B7.a.w("checkAppInstalled: app not found, taskId=", str, " appName=", str2, " isRedirected=");
            sbW.append(z10);
            AbstractC1436a.d("SafetyComplianceGuard", sbW.toString(), true);
            r rVar = r.f317a;
            if (z10) {
                String strM = B7.a.m("没有找到", str2, "，请前往下载");
                if (iTaskProgressCallback != null) {
                    try {
                        iTaskProgressCallback.onTaskAction(str, "", "error", null, null, strM);
                    } catch (Throwable th) {
                        objA2 = kotlin.b.a(th);
                    }
                } else {
                    rVar = null;
                }
                objA2 = rVar;
                Throwable thA = Result.a(objA2);
                if (thA == null) {
                    return false;
                }
                AbstractC1436a.c("SafetyComplianceGuard", "denyRedirectTargetNotFound callback failed", thA);
                return false;
            }
            String strM2 = B7.a.m("未找到", str2, "，无法打开应用");
            if (iTaskProgressCallback != null) {
                try {
                    iTaskProgressCallback.onTaskAction(str, "", "error", null, null, strM2);
                } catch (Throwable th2) {
                    objA = kotlin.b.a(th2);
                }
            } else {
                rVar = null;
            }
            objA = rVar;
            Throwable thA2 = Result.a(objA);
            if (thA2 == null) {
                return false;
            }
            AbstractC1436a.c("SafetyComplianceGuard", "denyAppNotFound callback failed", thA2);
            return false;
        }
        if (whitelistCacheManager.getAllowAllApps()) {
            AbstractC1436a.d("SafetyComplianceGuard", B7.a.n("[LOOP-DEBUG] checkAppAuthorized: allowAllApps enabled, bypass whitelist, proceed taskId=", str, " appName=", str2), true);
            int i10 = f + 1;
            f = i10;
            AbstractC1436a.d("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i10, "[LOOP-DEBUG] onProceed called (allowAllApps): callCount=", ", taskId=", str), true);
            int i11 = f;
            if (i11 % 10 == 0) {
                StackTraceElement[] stackTrace2 = Thread.currentThread().getStackTrace();
                kotlin.jvm.internal.k.e(stackTrace2, "getStackTrace(...)");
                AbstractC1436a.b("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i11, "[LOOP-DEBUG] onProceed SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace2), "\n", null, null, null, 62)), true);
            }
            kVar.invoke(str3);
            return true;
        }
        WhitelistApp whitelistItem = whitelistCacheManager.getWhitelistItem(str2);
        if (whitelistItem == null || !whitelistItem.getEnabled()) {
            if (whitelistItem == null) {
                AbstractC1436a.d("SafetyComplianceGuard", B7.a.n("checkAppAuthorized: app not in whitelist, deny taskId=", str, " appName=", str2), true);
                e(iTaskProgressCallback, str, str2);
                return false;
            }
            if (b.compareAndSet(false, true)) {
                f5554a.post(new Runnable() { // from class: p6.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        final String str4;
                        final String str5;
                        Context context2 = context;
                        String str6 = str2;
                        ITaskProgressCallback iTaskProgressCallback2 = iTaskProgressCallback;
                        String str7 = str;
                        final WhitelistCacheManager whitelistCacheManager2 = whitelistCacheManager;
                        final S7.k kVar2 = kVar;
                        final String str8 = str3;
                        int i12 = 0;
                        try {
                            String string = context2.getString(R.string.auth_dialog_per_app_title, str6);
                            kotlin.jvm.internal.k.e(string, "getString(...)");
                            String string2 = context2.getString(R.string.auth_dialog_per_app_desc, str6);
                            kotlin.jvm.internal.k.e(string2, "getString(...)");
                            String string3 = context2.getString(R.string.auth_dialog_button_allow);
                            kotlin.jvm.internal.k.e(string3, "getString(...)");
                            String string4 = context2.getString(R.string.auth_dialog_button_cancel);
                            kotlin.jvm.internal.k.e(string4, "getString(...)");
                            d dVar = new d(context2, string, string2, string3, string4, "app-auth:" + str6);
                            str4 = str6;
                            str5 = str7;
                            try {
                                dVar.e = new S7.a() { // from class: p6.i
                                    @Override // S7.a
                                    public final Object invoke() {
                                        p.b.set(false);
                                        WhitelistCacheManager whitelistCacheManager3 = whitelistCacheManager2;
                                        String str9 = str4;
                                        if (!whitelistCacheManager3.setAppEnabled(str9, true)) {
                                            AbstractC1436a.b("SafetyComplianceGuard", "checkAppAuthorized: setAppEnabled failed, fallback addOrUpdate, appName=" + str9, true);
                                            whitelistCacheManager3.addOrUpdateWhitelistItem(str9, true);
                                        }
                                        String str10 = str5;
                                        AbstractC1436a.d("SafetyComplianceGuard", B7.a.n("[LOOP-DEBUG] app auth confirmed, calling onProceed, appName=", str9, " taskId=", str10), true);
                                        int i13 = p.f + 1;
                                        p.f = i13;
                                        AbstractC1436a.d("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i13, "[LOOP-DEBUG] onProceed called (app auth confirmed): callCount=", ", taskId=", str10), true);
                                        int i14 = p.f;
                                        if (i14 % 10 == 0) {
                                            StackTraceElement[] stackTrace3 = Thread.currentThread().getStackTrace();
                                            kotlin.jvm.internal.k.e(stackTrace3, "getStackTrace(...)");
                                            AbstractC1436a.b("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i14, "[LOOP-DEBUG] onProceed SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace3), "\n", null, null, null, 62)), true);
                                        }
                                        kVar2.invoke(str8);
                                        return r.f317a;
                                    }
                                };
                                dVar.f = new j(str4, str5, iTaskProgressCallback2, i12);
                                dVar.a();
                            } catch (Throwable th3) {
                                th = th3;
                                Throwable th4 = th;
                                p.b.set(false);
                                AbstractC1436a.c("SafetyComplianceGuard", "checkAppAuthorized: show dialog failed", th4);
                                Handler handler = p.f5554a;
                                p.d(iTaskProgressCallback2, str5, str4);
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str4 = str6;
                            str5 = str7;
                        }
                    }
                });
                return false;
            }
            AbstractC1436a.e("SafetyComplianceGuard", "checkAppAuthorized: dialog already showing, deny taskId=".concat(str), true);
            d(iTaskProgressCallback, str, str2);
            return false;
        }
        AbstractC1436a.d("SafetyComplianceGuard", B7.a.n("[LOOP-DEBUG] checkAppAuthorized: already authorized, calling onProceed, taskId=", str, " appName=", str2), true);
        int i12 = f + 1;
        f = i12;
        AbstractC1436a.d("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i12, "[LOOP-DEBUG] onProceed called (app authorized): callCount=", ", taskId=", str), true);
        int i13 = f;
        if (i13 % 10 == 0) {
            StackTraceElement[] stackTrace3 = Thread.currentThread().getStackTrace();
            kotlin.jvm.internal.k.e(stackTrace3, "getStackTrace(...)");
            AbstractC1436a.b("SafetyComplianceGuard", androidx.constraintlayout.core.dsl.a.c(i13, "[LOOP-DEBUG] onProceed SUSPECTED LOOP! callCount=", ", stackTrace=\n", v.I0(q.E0(stackTrace3), "\n", null, null, null, 62)), true);
        }
        kVar.invoke(str3);
        return true;
    }

    public static boolean b(S7.k kVar, Context context, ITaskProgressCallback iTaskProgressCallback, WhitelistCacheManager whitelistCacheManager, String str, String str2, String str3) {
        if (str2 == null || j9.m.s0(str2)) {
            return a(context, whitelistCacheManager, str, str2, str3, false, iTaskProgressCallback, kVar);
        }
        boolean z10 = whitelistCacheManager.getWhitelistItem(str2) != null;
        String redirectTarget = whitelistCacheManager.getRedirectTarget(str2);
        if (redirectTarget == null || redirectTarget.equals(str2) || z10) {
            return a(context, whitelistCacheManager, str, str2, str3, false, iTaskProgressCallback, kVar);
        }
        com.stepos.statsrpk.service.c.r(B7.a.w("checkRedirect: redirect ", str2, " -> ", redirectTarget, ", taskId="), str, "SafetyComplianceGuard", true);
        if (b.compareAndSet(false, true)) {
            f5554a.post(new l(context, str2, redirectTarget, iTaskProgressCallback, str, str3, whitelistCacheManager, kVar));
            return false;
        }
        AbstractC1436a.e("SafetyComplianceGuard", "checkRedirect: dialog already showing, deny taskId=".concat(str), true);
        e(iTaskProgressCallback, str, str2);
        return false;
    }

    public static void c(WhitelistCacheManager whitelistCacheManager, WhitelistCacheManager.OnMasterSwitchChangedListener onMasterSwitchChangedListener, WhitelistCacheManager.OnSafetySettingsDismissedListener onSafetySettingsDismissedListener, Runnable runnable) {
        c.set(false);
        if (onMasterSwitchChangedListener != null) {
            whitelistCacheManager.removeMasterSwitchListener(onMasterSwitchChangedListener);
        }
        if (onSafetySettingsDismissedListener != null) {
            whitelistCacheManager.removeSafetySettingsDismissedListener(onSafetySettingsDismissedListener);
        }
        if (runnable != null) {
            f5554a.removeCallbacks(runnable);
        }
    }

    public static void d(ITaskProgressCallback iTaskProgressCallback, String str, String str2) {
        Object objA;
        r rVar = null;
        if (str2 == null || j9.m.s0(str2)) {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        String strM = B7.a.m("用户拒绝了", str2, "应用的授权");
        if (iTaskProgressCallback != null) {
            try {
                iTaskProgressCallback.onTaskAction(str, "", "error", null, null, strM);
                rVar = r.f317a;
                objA = rVar;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = rVar;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c("SafetyComplianceGuard", "denyAppAuth callback failed", thA);
        }
    }

    public static void e(ITaskProgressCallback iTaskProgressCallback, String str, String str2) {
        Object objA;
        String strL = androidx.appfunctions.metadata.a.l(str2, "App不支持Amoo操作，敬请期待");
        if (iTaskProgressCallback != null) {
            try {
                iTaskProgressCallback.onTaskAction(str, "", "error", null, null, strL);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = null;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c("SafetyComplianceGuard", "denyAppNotSupported callback failed", thA);
        }
    }

    public static void f(ITaskProgressCallback iTaskProgressCallback, String str, String str2) {
        Object objA;
        if (iTaskProgressCallback != null) {
            try {
                iTaskProgressCallback.onTaskAction(str, "", "error", null, null, str2);
                objA = r.f317a;
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
        } else {
            objA = null;
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            AbstractC1436a.c("SafetyComplianceGuard", "denyPhoneAuth callback failed", thA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x023d  */
    /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean h(final android.content.Context r25, final java.lang.String r26, java.lang.String r27, final com.stepos.taskrobot.common.ITaskProgressCallback r28, final java.lang.String r29, final S7.k r30) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p6.p.h(android.content.Context, java.lang.String, java.lang.String, com.stepos.taskrobot.common.ITaskProgressCallback, java.lang.String, S7.k):boolean");
    }
}
