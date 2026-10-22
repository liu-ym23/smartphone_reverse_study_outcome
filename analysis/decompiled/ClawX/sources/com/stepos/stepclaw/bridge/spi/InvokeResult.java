package com.stepos.stepclaw.bridge.spi;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/InvokeResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "payloadJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", "Lcom/stepos/stepclaw/bridge/spi/ErrorShape;", "<init>", "(ZLjava/lang/String;Lcom/stepos/stepclaw/bridge/spi/ErrorShape;)V", "getOk", "()Z", "getPayloadJson", "()Ljava/lang/String;", "getError", "()Lcom/stepos/stepclaw/bridge/spi/ErrorShape;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "Companion", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class InvokeResult {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ErrorShape error;
    private final boolean ok;
    private final String payloadJson;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/stepclaw/bridge/spi/InvokeResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", ConfigIpcContract.KEY_OK, "Lcom/stepos/stepclaw/bridge/spi/InvokeResult;", "payloadJson", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "error", "code", OperationResult.EXTRA_MESSAGE, "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final InvokeResult error(String code, String message) {
            p.e(code, "code");
            p.e(message, "message");
            return new InvokeResult(false, null, new ErrorShape(code, message));
        }

        public final InvokeResult ok(String payloadJson) {
            return new InvokeResult(true, payloadJson, null);
        }

        private Companion() {
        }
    }

    public InvokeResult(boolean z, String str, ErrorShape errorShape) {
        this.ok = z;
        this.payloadJson = str;
        this.error = errorShape;
    }

    public static /* synthetic */ InvokeResult copy$default(InvokeResult invokeResult, boolean z, String str, ErrorShape errorShape, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = invokeResult.ok;
        }
        if ((i8 & 2) != 0) {
            str = invokeResult.payloadJson;
        }
        if ((i8 & 4) != 0) {
            errorShape = invokeResult.error;
        }
        return invokeResult.copy(z, str, errorShape);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPayloadJson() {
        return this.payloadJson;
    }

    /* renamed from: component3, reason: from getter */
    public final ErrorShape getError() {
        return this.error;
    }

    public final InvokeResult copy(boolean ok, String payloadJson, ErrorShape error) {
        return new InvokeResult(ok, payloadJson, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InvokeResult)) {
            return false;
        }
        InvokeResult invokeResult = (InvokeResult) other;
        return this.ok == invokeResult.ok && p.a(this.payloadJson, invokeResult.payloadJson) && p.a(this.error, invokeResult.error);
    }

    public final ErrorShape getError() {
        return this.error;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final String getPayloadJson() {
        return this.payloadJson;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        String str = this.payloadJson;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode2 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "InvokeResult(ok=" + this.ok + ", payloadJson=" + this.payloadJson + ", error=" + this.error + ")";
    }
}
