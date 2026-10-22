package com.bytedance.android.gamecp.common.monitor;

import com.bytedance.android.gamecp.common.setting.LiveInfraSettingKeys;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import hu.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import yr.b;

/* JADX INFO: loaded from: classes44.dex */
public final class SafetyGuard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f56539a = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/gamecp/common/monitor/SafetyGuard$SafetyGuardCustomException;", "Ljava/lang/RuntimeException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SafetyGuardCustomException extends RuntimeException {
        public SafetyGuardCustomException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/common/monitor/SafetyGuard$a;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "", "logTypeAllowlist", "Ljava/util/List;", "getLogTypeAllowlist", "()Ljava/util/List;", "setLogTypeAllowlist", "(Ljava/util/List;)V", "msgAllowlist", "getMsgAllowlist", "setMsgAllowlist", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("enable")
        private boolean enable;

        @SerializedName("log_type_allowlist")
        private List<String> logTypeAllowlist;

        @SerializedName("message_allowlist")
        private List<String> msgAllowlist;

        public a() {
            this.logTypeAllowlist = new ArrayList();
            this.msgAllowlist = new ArrayList();
        }

        public final boolean a() {
            return this.enable;
        }
    }

    static {
        f56539a = LiveInfraSettingKeys.LIVE_SAFETY_GUARD_CONFIG.getValue();
    }

    @JvmStatic
    public static final void a(Throwable r100, String r101) {
        String r102 = "[SafetyGuard] ".concat(r101);
        b.d("SafetyGuard", r102, r100);
        if (f56539a.a() == false) goto L6;
        ThreadPlus.submitRunnable(new e("ttlive_safety_guard_log_type", r100, r102));
        return;
    }
}
