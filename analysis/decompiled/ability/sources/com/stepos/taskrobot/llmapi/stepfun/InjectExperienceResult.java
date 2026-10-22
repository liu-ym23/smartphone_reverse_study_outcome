package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/InjectExperienceResult;", "", "success", "", SettingsConfig.KEY_DATA, "", "error", "reason", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getData", "()Ljava/lang/String;", "getError", "getReason", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InjectExperienceResult {
    public static final String REASON_DISABLED = "disabled";
    public static final String REASON_HAS_TAKEOVER = "has_takeover";
    public static final String REASON_NO_VALID_ACTION = "no_valid_action";
    public static final String REASON_TIMEOUT = "timeout";
    private final String data;
    private final String error;
    private final String reason;
    private final boolean success;

    public InjectExperienceResult(boolean z10, String str, String str2, String str3) {
        this.success = z10;
        this.data = str;
        this.error = str2;
        this.reason = str3;
    }

    public static /* synthetic */ InjectExperienceResult copy$default(InjectExperienceResult injectExperienceResult, boolean z10, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = injectExperienceResult.success;
        }
        if ((i & 2) != 0) {
            str = injectExperienceResult.data;
        }
        if ((i & 4) != 0) {
            str2 = injectExperienceResult.error;
        }
        if ((i & 8) != 0) {
            str3 = injectExperienceResult.reason;
        }
        return injectExperienceResult.copy(z10, str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public final InjectExperienceResult copy(boolean success, String data, String error, String reason) {
        return new InjectExperienceResult(success, data, error, reason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InjectExperienceResult)) {
            return false;
        }
        InjectExperienceResult injectExperienceResult = (InjectExperienceResult) other;
        return this.success == injectExperienceResult.success && kotlin.jvm.internal.k.b(this.data, injectExperienceResult.data) && kotlin.jvm.internal.k.b(this.error, injectExperienceResult.error) && kotlin.jvm.internal.k.b(this.reason, injectExperienceResult.reason);
    }

    public final String getData() {
        return this.data;
    }

    public final String getError() {
        return this.error;
    }

    public final String getReason() {
        return this.reason;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.data;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.error;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.reason;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        boolean z10 = this.success;
        String str = this.data;
        String str2 = this.error;
        String str3 = this.reason;
        StringBuilder sb = new StringBuilder("InjectExperienceResult(success=");
        sb.append(z10);
        sb.append(", data=");
        sb.append(str);
        sb.append(", error=");
        return androidx.appfunctions.metadata.a.p(sb, str2, ", reason=", str3, ")");
    }

    public /* synthetic */ InjectExperienceResult(boolean z10, String str, String str2, String str3, int i, kotlin.jvm.internal.e eVar) {
        this(z10, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }
}
