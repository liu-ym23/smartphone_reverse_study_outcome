package com.bytedance.android.live.core.monitor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.crash.d;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class SafetyGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f64960a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/core/monitor/SafetyGuard$SafetyGuardCustomException;", "Ljava/lang/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SafetyGuardCustomException extends RuntimeException {
        public SafetyGuardCustomException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/core/monitor/SafetyGuard$a;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "logTypeAllowlist", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "setLogTypeAllowlist", "(Ljava/util/ArrayList;)V", "msgAllowlist", "d", "setMsgAllowlist", "crashInVirtualEnv", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCrashInVirtualEnv", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("crash_in_virtualenv")
        private boolean crashInVirtualEnv;

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("log_type_allowlist")
        private ArrayList<String> logTypeAllowlist;

        @SerializedName("message_allowlist")
        private ArrayList<String> msgAllowlist;

        public a() {
            this.logTypeAllowlist = new ArrayList();
            this.msgAllowlist = new ArrayList();
            this.crashInVirtualEnv = true;
        }

        public final boolean a() {
            return this.crashInVirtualEnv;
        }

        public final boolean b() {
            return this.enable;
        }

        public final ArrayList<String> c() {
            return this.logTypeAllowlist;
        }

        public final ArrayList<String> d() {
            return this.msgAllowlist;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f64961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f64962b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f64963c;

        public b(String r100, Throwable r101, String r102) {
            this.f64961a = r100;
            this.f64962b = r101;
            this.f64963c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.f(this.f64961a, this.f64962b, this.f64963c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        f64960a = LiveInfraSettingKeys.LIVE_SAFETY_GUARD_CONFIG.getValue();
    }

    @JvmStatic
    public static final void b(Throwable r100) {
        a(null, r100, null);
    }

    @JvmStatic
    public static final void a(String r100, Throwable r101, String r102) {
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L12;
        r100 = "ttlive_safety_guard_log_type";
    L14:
        if (r102 != null) goto L16;
        String r104 = "[SafetyGuard]";
    L17:
        if (r101 != null) goto L19;
        Throwable r105 = new Throwable(r104);
    L20:
        ALogger.e("SafetyGuard", r104, r101);
        a r106 = f64960a;
        if (r106.b() == false) goto L30;
        ThreadPlus.submitRunnable(new b(r100, r105, r104));
        if (r106.a() == true) goto L25;
        return;
    L25:
        if (jc1.a.c() == false) goto L32;
        if (r101 == null) goto L29;
        throw r101;
    L29:
        throw new IllegalStateException(r104);
    L32:
        return;
    L30:
        return;
    L19:
        r105 = r101;
        goto L20
    L16:
        r104 = "[SafetyGuard] ".concat(r102);
        goto L17
    L12:
        if (StringsKt.startsWith$default(r100, "ttlive_", false, 2, null) == true) goto L14;
        r100 = "ttlive_" + r100;
        goto L14
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @JvmStatic
    public static final void c(String r100, Throwable r101, String r102) {
        a(r100, r101, r102);
        if (v.a() == true) goto L10;
        a r103 = f64960a;
        if (CollectionsKt.contains(r103.c(), r100) == false) goto L7;
        return;
    L7:
        if (CollectionsKt.contains(r103.d(), r102) == false) goto L10;
        return;
    L10:
        throw new SafetyGuardCustomException(r102, r101);
    }
}
