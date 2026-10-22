package com.stepos.stepclaw.bridge.openclaw;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B)\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB7\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ2\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u0019R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001d¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", "result", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeError;", "error", "<init>", "(ZLcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeError;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IZLcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeError;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_bridge_release", "(Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Z", "component2", "()Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", "component3", "()Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeError;", "copy", "(ZLcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeError;)Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getOk", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", "getResult", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeError;", "getError", "Companion", "$serializer", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class ToolsInvokeResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ToolsInvokeError error;
    private final boolean ok;
    private final ToolsInvokeResult result;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResponse;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<ToolsInvokeResponse> serializer() {
            return ToolsInvokeResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public ToolsInvokeResponse() {
        this(false, (ToolsInvokeResult) null, (ToolsInvokeError) null, 7, (i) null);
    }

    public static /* synthetic */ ToolsInvokeResponse copy$default(ToolsInvokeResponse toolsInvokeResponse, boolean z, ToolsInvokeResult toolsInvokeResult, ToolsInvokeError toolsInvokeError, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z = toolsInvokeResponse.ok;
        }
        if ((i8 & 2) != 0) {
            toolsInvokeResult = toolsInvokeResponse.result;
        }
        if ((i8 & 4) != 0) {
            toolsInvokeError = toolsInvokeResponse.error;
        }
        return toolsInvokeResponse.copy(z, toolsInvokeResult, toolsInvokeError);
    }

    public static final /* synthetic */ void write$Self$step_bridge_release(ToolsInvokeResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ok) {
            output.encodeBooleanElement(serialDesc, 0, self.ok);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.result != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ToolsInvokeResult$$serializer.INSTANCE, self.result);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.error == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, ToolsInvokeError$$serializer.INSTANCE, self.error);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final ToolsInvokeResult getResult() {
        return this.result;
    }

    /* renamed from: component3, reason: from getter */
    public final ToolsInvokeError getError() {
        return this.error;
    }

    public final ToolsInvokeResponse copy(boolean ok, ToolsInvokeResult result, ToolsInvokeError error) {
        return new ToolsInvokeResponse(ok, result, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolsInvokeResponse)) {
            return false;
        }
        ToolsInvokeResponse toolsInvokeResponse = (ToolsInvokeResponse) other;
        return this.ok == toolsInvokeResponse.ok && p.a(this.result, toolsInvokeResponse.result) && p.a(this.error, toolsInvokeResponse.error);
    }

    public final ToolsInvokeError getError() {
        return this.error;
    }

    public final boolean getOk() {
        return this.ok;
    }

    public final ToolsInvokeResult getResult() {
        return this.result;
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        ToolsInvokeResult toolsInvokeResult = this.result;
        int iHashCode2 = (iHashCode + (toolsInvokeResult == null ? 0 : toolsInvokeResult.hashCode())) * 31;
        ToolsInvokeError toolsInvokeError = this.error;
        return iHashCode2 + (toolsInvokeError != null ? toolsInvokeError.hashCode() : 0);
    }

    public String toString() {
        return "ToolsInvokeResponse(ok=" + this.ok + ", result=" + this.result + ", error=" + this.error + ")";
    }

    public /* synthetic */ ToolsInvokeResponse(int i8, boolean z, ToolsInvokeResult toolsInvokeResult, ToolsInvokeError toolsInvokeError, SerializationConstructorMarker serializationConstructorMarker) {
        this.ok = (i8 & 1) == 0 ? false : z;
        if ((i8 & 2) == 0) {
            this.result = null;
        } else {
            this.result = toolsInvokeResult;
        }
        if ((i8 & 4) == 0) {
            this.error = null;
        } else {
            this.error = toolsInvokeError;
        }
    }

    public ToolsInvokeResponse(boolean z, ToolsInvokeResult toolsInvokeResult, ToolsInvokeError toolsInvokeError) {
        this.ok = z;
        this.result = toolsInvokeResult;
        this.error = toolsInvokeError;
    }

    public /* synthetic */ ToolsInvokeResponse(boolean z, ToolsInvokeResult toolsInvokeResult, ToolsInvokeError toolsInvokeError, int i8, i iVar) {
        this((i8 & 1) != 0 ? false : z, (i8 & 2) != 0 ? null : toolsInvokeResult, (i8 & 4) != 0 ? null : toolsInvokeError);
    }
}
