package com.stepos.stepclaw.bridge.openclaw;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.Map;
import k4.r;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u0000 A2\u00020\u0001:\u0002BAB\u008b\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010B\u008d\u0001\b\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u000f\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u001e\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b!\u0010 J\u0094\u0001\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b$\u0010\u001cJ\u0010\u0010%\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b(\u0010)J'\u00102\u001a\u00020/2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0001¢\u0006\u0004\b0\u00101R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b5\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u00103\u001a\u0004\b6\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u00103\u001a\u0004\b7\u0010\u0017R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u00108\u0012\u0004\b:\u0010;\u001a\u0004\b9\u0010\u001cR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u00108\u001a\u0004\b<\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\n\u00108\u001a\u0004\b=\u0010\u001cR%\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\b?\u0010 R%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010>\u001a\u0004\b@\u0010 ¨\u0006C"}, d2 = {"Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_OK, OperationResult.EXTRA_SUCCESS, "disabled", "unavailable", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_ERROR_MESSAGE, "warning", "action", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lkotlinx/serialization/json/JsonElement;", "details", "data", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/Boolean;", "component2", "component3", "component4", "component5", "()Ljava/lang/String;", "component6", "component7", "component8", "()Ljava/util/Map;", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_bridge_release", "(Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/Boolean;", "getOk", "getSuccess", "getDisabled", "getUnavailable", "Ljava/lang/String;", "getErrorMessage", "getErrorMessage$annotations", "()V", "getWarning", "getAction", "Ljava/util/Map;", "getDetails", "getData", "Companion", "$serializer", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class ToolsInvokeResult {
    private static final e[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String action;
    private final Map<String, JsonElement> data;
    private final Map<String, JsonElement> details;
    private final Boolean disabled;
    private final String errorMessage;
    private final Boolean ok;
    private final Boolean success;
    private final Boolean unavailable;
    private final String warning;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/bridge/openclaw/ToolsInvokeResult;", "step-bridge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<ToolsInvokeResult> serializer() {
            return ToolsInvokeResult$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        f fVar = f.f889a;
        $childSerializers = new e[]{null, null, null, null, null, null, null, h.w(fVar, new r(7)), h.w(fVar, new r(8))};
    }

    public ToolsInvokeResult() {
        this((Boolean) null, (Boolean) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (Map) null, (Map) null, 511, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, JsonElementSerializer.INSTANCE);
    }

    public static /* synthetic */ ToolsInvokeResult copy$default(ToolsInvokeResult toolsInvokeResult, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str, String str2, String str3, Map map, Map map2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            bool = toolsInvokeResult.ok;
        }
        if ((i8 & 2) != 0) {
            bool2 = toolsInvokeResult.success;
        }
        if ((i8 & 4) != 0) {
            bool3 = toolsInvokeResult.disabled;
        }
        if ((i8 & 8) != 0) {
            bool4 = toolsInvokeResult.unavailable;
        }
        if ((i8 & 16) != 0) {
            str = toolsInvokeResult.errorMessage;
        }
        if ((i8 & 32) != 0) {
            str2 = toolsInvokeResult.warning;
        }
        if ((i8 & 64) != 0) {
            str3 = toolsInvokeResult.action;
        }
        if ((i8 & 128) != 0) {
            map = toolsInvokeResult.details;
        }
        if ((i8 & 256) != 0) {
            map2 = toolsInvokeResult.data;
        }
        Map map3 = map;
        Map map4 = map2;
        String str4 = str2;
        String str5 = str3;
        String str6 = str;
        Boolean bool5 = bool3;
        return toolsInvokeResult.copy(bool, bool2, bool5, bool4, str6, str4, str5, map3, map4);
    }

    public static final /* synthetic */ void write$Self$step_bridge_release(ToolsInvokeResult self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.ok != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.ok);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.success != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.success);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.disabled != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.disabled);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.unavailable != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.unavailable);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.errorMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.errorMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.warning != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.warning);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.action != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.action);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.details != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, (SerializationStrategy) eVarArr[7].getValue(), self.details);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.data == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, (SerializationStrategy) eVarArr[8].getValue(), self.data);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getOk() {
        return this.ok;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getUnavailable() {
        return this.unavailable;
    }

    /* renamed from: component5, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: component6, reason: from getter */
    public final String getWarning() {
        return this.warning;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    public final Map<String, JsonElement> component8() {
        return this.details;
    }

    public final Map<String, JsonElement> component9() {
        return this.data;
    }

    public final ToolsInvokeResult copy(Boolean ok, Boolean success, Boolean disabled, Boolean unavailable, String errorMessage, String warning, String action, Map<String, ? extends JsonElement> details, Map<String, ? extends JsonElement> data) {
        return new ToolsInvokeResult(ok, success, disabled, unavailable, errorMessage, warning, action, details, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolsInvokeResult)) {
            return false;
        }
        ToolsInvokeResult toolsInvokeResult = (ToolsInvokeResult) other;
        return p.a(this.ok, toolsInvokeResult.ok) && p.a(this.success, toolsInvokeResult.success) && p.a(this.disabled, toolsInvokeResult.disabled) && p.a(this.unavailable, toolsInvokeResult.unavailable) && p.a(this.errorMessage, toolsInvokeResult.errorMessage) && p.a(this.warning, toolsInvokeResult.warning) && p.a(this.action, toolsInvokeResult.action) && p.a(this.details, toolsInvokeResult.details) && p.a(this.data, toolsInvokeResult.data);
    }

    public final String getAction() {
        return this.action;
    }

    public final Map<String, JsonElement> getData() {
        return this.data;
    }

    public final Map<String, JsonElement> getDetails() {
        return this.details;
    }

    public final Boolean getDisabled() {
        return this.disabled;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Boolean getOk() {
        return this.ok;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final Boolean getUnavailable() {
        return this.unavailable;
    }

    public final String getWarning() {
        return this.warning;
    }

    public int hashCode() {
        Boolean bool = this.ok;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.success;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.disabled;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.unavailable;
        int iHashCode4 = (iHashCode3 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str = this.errorMessage;
        int iHashCode5 = (iHashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.warning;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.action;
        int iHashCode7 = (iHashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, JsonElement> map = this.details;
        int iHashCode8 = (iHashCode7 + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, JsonElement> map2 = this.data;
        return iHashCode8 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        Boolean bool = this.ok;
        Boolean bool2 = this.success;
        Boolean bool3 = this.disabled;
        Boolean bool4 = this.unavailable;
        String str = this.errorMessage;
        String str2 = this.warning;
        String str3 = this.action;
        Map<String, JsonElement> map = this.details;
        Map<String, JsonElement> map2 = this.data;
        StringBuilder sb = new StringBuilder("ToolsInvokeResult(ok=");
        sb.append(bool);
        sb.append(", success=");
        sb.append(bool2);
        sb.append(", disabled=");
        sb.append(bool3);
        sb.append(", unavailable=");
        sb.append(bool4);
        sb.append(", errorMessage=");
        b.A(sb, str, ", warning=", str2, ", action=");
        sb.append(str3);
        sb.append(", details=");
        sb.append(map);
        sb.append(", data=");
        sb.append(map2);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ ToolsInvokeResult(int i8, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str, String str2, String str3, Map map, Map map2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.ok = null;
        } else {
            this.ok = bool;
        }
        if ((i8 & 2) == 0) {
            this.success = null;
        } else {
            this.success = bool2;
        }
        if ((i8 & 4) == 0) {
            this.disabled = null;
        } else {
            this.disabled = bool3;
        }
        if ((i8 & 8) == 0) {
            this.unavailable = null;
        } else {
            this.unavailable = bool4;
        }
        if ((i8 & 16) == 0) {
            this.errorMessage = null;
        } else {
            this.errorMessage = str;
        }
        if ((i8 & 32) == 0) {
            this.warning = null;
        } else {
            this.warning = str2;
        }
        if ((i8 & 64) == 0) {
            this.action = null;
        } else {
            this.action = str3;
        }
        if ((i8 & 128) == 0) {
            this.details = null;
        } else {
            this.details = map;
        }
        if ((i8 & 256) == 0) {
            this.data = null;
        } else {
            this.data = map2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ToolsInvokeResult(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str, String str2, String str3, Map<String, ? extends JsonElement> map, Map<String, ? extends JsonElement> map2) {
        this.ok = bool;
        this.success = bool2;
        this.disabled = bool3;
        this.unavailable = bool4;
        this.errorMessage = str;
        this.warning = str2;
        this.action = str3;
        this.details = map;
        this.data = map2;
    }

    public /* synthetic */ ToolsInvokeResult(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, String str, String str2, String str3, Map map, Map map2, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : bool, (i8 & 2) != 0 ? null : bool2, (i8 & 4) != 0 ? null : bool3, (i8 & 8) != 0 ? null : bool4, (i8 & 16) != 0 ? null : str, (i8 & 32) != 0 ? null : str2, (i8 & 64) != 0 ? null : str3, (i8 & 128) != 0 ? null : map, (i8 & 256) != 0 ? null : map2);
    }

    @SerialName("error")
    public static /* synthetic */ void getErrorMessage$annotations() {
    }
}
