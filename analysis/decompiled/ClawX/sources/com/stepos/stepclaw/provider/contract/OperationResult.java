package com.stepos.stepclaw.provider.contract;

import android.os.Bundle;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/stepos/stepclaw/provider/contract/OperationResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_SUCCESS, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "errorCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_MESSAGE, "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getErrorCode", "()Ljava/lang/String;", "getMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "Companion", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OperationResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_ERROR_CODE = "error_code";
    public static final String EXTRA_ID = "id";
    public static final String EXTRA_MESSAGE = "message";
    public static final String EXTRA_SUCCESS = "success";
    private final String errorCode;
    private final String message;
    private final boolean success;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/stepclaw/provider/contract/OperationResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "EXTRA_SUCCESS", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "EXTRA_ERROR_CODE", "EXTRA_MESSAGE", "EXTRA_ID", "fromBundle", "Lcom/stepos/stepclaw/provider/contract/OperationResult;", "b", "Landroid/os/Bundle;", OperationResult.EXTRA_SUCCESS, "id", "failure", "code", OperationResult.EXTRA_MESSAGE, "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ Bundle success$default(Companion companion, String str, int i8, Object obj) {
            if ((i8 & 1) != 0) {
                str = null;
            }
            return companion.success(str);
        }

        public final Bundle failure(String code, String message) {
            p.e(code, "code");
            p.e(message, "message");
            Bundle bundle = new Bundle();
            bundle.putBoolean(OperationResult.EXTRA_SUCCESS, false);
            bundle.putString(OperationResult.EXTRA_ERROR_CODE, code);
            bundle.putString(OperationResult.EXTRA_MESSAGE, message);
            return bundle;
        }

        public final OperationResult fromBundle(Bundle b9) {
            if (b9 == null) {
                return new OperationResult(false, "NULL_BUNDLE", "provider returned null");
            }
            if (b9.getBoolean(OperationResult.EXTRA_SUCCESS, false)) {
                return new OperationResult(true, null, null, 6, null);
            }
            String string = b9.getString(OperationResult.EXTRA_ERROR_CODE);
            if (string == null) {
                string = "UNKNOWN";
            }
            String string2 = b9.getString(OperationResult.EXTRA_MESSAGE);
            if (string2 == null) {
                string2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            return new OperationResult(false, string, string2);
        }

        public final Bundle success(String id) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(OperationResult.EXTRA_SUCCESS, true);
            if (id != null) {
                bundle.putString("id", id);
            }
            return bundle;
        }

        private Companion() {
        }
    }

    public OperationResult(boolean z, String str, String str2) {
        this.success = z;
        this.errorCode = str;
        this.message = str2;
    }

    public static /* synthetic */ OperationResult copy$default(OperationResult operationResult, boolean z, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = operationResult.success;
        }
        if ((i8 & 2) != 0) {
            str = operationResult.errorCode;
        }
        if ((i8 & 4) != 0) {
            str2 = operationResult.message;
        }
        return operationResult.copy(z, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final OperationResult copy(boolean success, String errorCode, String message) {
        return new OperationResult(success, errorCode, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OperationResult)) {
            return false;
        }
        OperationResult operationResult = (OperationResult) other;
        return this.success == operationResult.success && p.a(this.errorCode, operationResult.errorCode) && p.a(this.message, operationResult.message);
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.success) * 31;
        String str = this.errorCode;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.message;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.success;
        String str = this.errorCode;
        String str2 = this.message;
        StringBuilder sb = new StringBuilder("OperationResult(success=");
        sb.append(z);
        sb.append(", errorCode=");
        sb.append(str);
        sb.append(", message=");
        return f.f(sb, str2, ")");
    }

    public /* synthetic */ OperationResult(boolean z, String str, String str2, int i8, i iVar) {
        this(z, (i8 & 2) != 0 ? null : str, (i8 & 4) != 0 ? null : str2);
    }
}
