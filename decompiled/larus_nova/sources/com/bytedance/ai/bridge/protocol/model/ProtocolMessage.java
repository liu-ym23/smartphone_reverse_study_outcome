package com.bytedance.ai.bridge.protocol.model;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ai.applet.base.gson.c;
import com.bytedance.ai.applet.base.gson.e;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u0000 22\u00020\u0001:\u0003234BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010!\u001a\u0004\u0018\u00010\u0000\"\u0004\b\u0000\u0010\"2\u0006\u0010\u0004\u001a\u0002H\"¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010(\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003JT\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u00065"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "", "name", "", "params", "Lcom/google/gson/JsonObject;", "callbackId", "", PickerReporterConstants.KEY.TARGET, "Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "type", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "timestamp", "", "<init>", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;J)V", "getName", "()Ljava/lang/String;", "getParams", "()Lcom/google/gson/JsonObject;", "getCallbackId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTarget", "()Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;", "getType", "()Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "getTimestamp", "()J", "callbackParams", "Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$CallbackParams;", "getCallbackParams", "()Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$CallbackParams;", "createCallback", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Object;)Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "toJSONString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Lcom/google/gson/JsonObject;Ljava/lang/Integer;Lcom/bytedance/ai/bridge/protocol/model/TargetEntity;Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;J)Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage;", "equals", "", "other", "hashCode", "toString", "Companion", "Type", "CallbackParams", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProtocolMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36070a = 0;

    @SerializedName("callbackId")
    private final Integer callbackId;

    @SerializedName("name")
    private final String name;

    @SerializedName("params")
    private final JsonObject params;

    @SerializedName(PickerReporterConstants.KEY.TARGET)
    private final TargetEntity target;

    @SerializedName("timestamp")
    private final long timestamp;

    @SerializedName("type")
    private final Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$Type;", "", "<init>", "(Ljava/lang/String;I)V", "Call", "Callback", "Event", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Type[] $VALUES = null;

        @SerializedName(NotificationCompat.CATEGORY_CALL)
        public static final Type Call = null;

        @SerializedName("callback")
        public static final Type Callback = null;

        @SerializedName("event")
        public static final Type Event = null;

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{Call, Callback, Event};
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        static {
            Call = new Type("Call", 0);
            Callback = new Type("Callback", 1);
            Event = new Type("Event", 2);
            Type[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ai/bridge/protocol/model/ProtocolMessage$CallbackParams;", "", "code", "", "msg", "", "data", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMsg", "()Ljava/lang/String;", "getData", "()Lcom/google/gson/JsonObject;", "applet-bridge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("code")
        private final Integer code;

        @SerializedName("data")
        private final JsonObject data;

        @SerializedName("msg")
        private final String msg;

        public a() {
            this.code = 0;
            this.msg = "";
            this.data = null;
        }

        public final Integer a() {
            return this.code;
        }

        public final JsonObject b() {
            return this.data;
        }

        public final String c() {
            return this.msg;
        }
    }

    public static final class b {
        @JvmStatic
        public static ProtocolMessage a(JsonObject r100) {
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            Lazy r102 = e.f34515a;     // Catch: Throwable -> L5
            Object r103 = Result.m9449constructorimpl((ProtocolMessage) GsonProtectorUtils.fromJson(c.a(), r100, ProtocolMessage.class));     // Catch: Throwable -> L5
        L7:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L11;
            com.bytedance.ai.applet.base.log.b r105 = com.bytedance.ai.applet.base.log.a.f34518a;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "deserializer json to ProtocolMessage error " + r104.getMessage(), null);
        L11:
            if (Result.m9455isFailureimpl(r103) == false) goto L14;
            r103 = null;
        L14:
            return (ProtocolMessage) r103;
        L5:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        @JvmStatic
        public static ProtocolMessage b(String r100) {
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            Lazy r102 = e.f34515a;     // Catch: Throwable -> L5
            Object r103 = Result.m9449constructorimpl((ProtocolMessage) e.a(r100, ProtocolMessage.class));     // Catch: Throwable -> L5
        L7:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L11;
            com.bytedance.ai.applet.base.log.b r105 = com.bytedance.ai.applet.base.log.a.f34518a;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "deserializer string to ProtocolMessage error " + r104.getMessage(), null);
        L11:
            if (Result.m9455isFailureimpl(r103) == false) goto L14;
            r103 = null;
        L14:
            return (ProtocolMessage) r103;
        L5:
            th = move-exception;
            Result.Companion r106 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        @JvmStatic
        public static JsonObject c(ProtocolMessage r100) {
            Intrinsics.checkNotNullParameter(r100, "protocolMessage");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
            Object r102 = Result.m9449constructorimpl(e.d(r100));     // Catch: Throwable -> L5
        L7:
            Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
            if (r103 == null) goto L11;
            com.bytedance.ai.applet.base.log.b r104 = com.bytedance.ai.applet.base.log.a.f34518a;
            com.bytedance.ai.applet.base.log.a.b("ai_bridge", "serializer ProtocolMessage error " + r103.getMessage(), null);
        L11:
            if (Result.m9455isFailureimpl(r102) == false) goto L14;
            r102 = null;
        L14:
            return (JsonObject) r102;
        L5:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }
    }

    static {
    }

    public ProtocolMessage() {
        this(null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProtocolMessage) == true) goto L8;
        return false;
    L8:
        ProtocolMessage r101 = (ProtocolMessage) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.callbackId, r101.callbackId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.target, r101.target) == true) goto L21;
        return false;
    L21:
        if (this.type == r101.type) goto L24;
        return false;
    L24:
        if (this.timestamp == r101.timestamp) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.params;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.callbackId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TargetEntity r110 = this.target;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Type r113 = this.type;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        int r114 = (r112 + r101) * 31;
        long r115 = this.timestamp;
        return r114 + ((int) (r115 ^ (r115 >>> 32)));
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProtocolMessage(name=" + this.name + ", params=" + this.params + ", callbackId=" + this.callbackId + ", target=" + this.target + ", type=" + this.type + ", timestamp=" + this.timestamp + ')';
    }

    public final a d() {
        Object r100 = null;
        if (this.type != Type.Callback) goto L18;
        JsonObject r101 = this.params;
        if (r101 == null) goto L19;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Lazy r103 = e.f34515a;     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl((a) GsonProtectorUtils.fromJson(c.a(), r101, a.class));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r104) == true) goto L15;
        r100 = r104;
    L15:
        return (a) r100;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    L19:
        return null;
    L18:
        return null;
    }

    public final String i() {
        JsonObject r100 = this.params;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.has("extras") != true) goto L7;
    L8:
        if (r101 == false) goto L20;
        JsonObject r102 = e.d(this);
        if (r102 == null) goto L14;
        JsonObject r103 = r102.getAsJsonObject("params");
        if (r103 == null) goto L14;
        r103.remove("extras");
    L14:
        if (r102 == null) goto L18;
        String r104 = r102.toString();
        if (r104 == null) goto L18;
        return r104;
    L18:
        return e.c(this);
    L20:
        return e.c(this);
    L7:
        r101 = false;
        goto L8
    }

    public final Integer c() {
        return this.callbackId;
    }

    public final String e() {
        return this.name;
    }

    public final JsonObject f() {
        return this.params;
    }

    public final TargetEntity g() {
        return this.target;
    }

    public final Type getType() {
        return this.type;
    }

    public final long h() {
        return this.timestamp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> ProtocolMessage b(T r110) {
        JsonObject r100 = null;
        if (this.type == Type.Call) goto L6;
        return null;
    L6:
        if ((r110 instanceof JsonObject) == false) goto L9;
        r100 = (JsonObject) r110;
    L8:
        JsonObject r101 = r100;
        String r102 = null;
        return new ProtocolMessage(r102, r101, this.callbackId, this.target, Type.Callback, 33);
    L9:
        if (r110 == 0) goto L8;
        r100 = e.d(r110);
        goto L8
    }

    public static ProtocolMessage a(ProtocolMessage r100, Integer r101) {
        String r102 = r100.name;
        JsonObject r103 = r100.params;
        TargetEntity r104 = r100.target;
        Type r105 = r100.type;
        long r106 = r100.timestamp;
        r100.getClass();
        return new ProtocolMessage(r102, r103, r101, r104, r105, r106);
    }

    public /* synthetic */ ProtocolMessage(String r110, JsonObject r111, Integer r112, TargetEntity r113, Type r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        JsonObject r101 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        TargetEntity r103 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        Type r104 = null;
    L23:
        if ((r115 & 32) == 0) goto L25;
        long r105 = System.currentTimeMillis();
    L26:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = 0;
        goto L26
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public ProtocolMessage(String r100, JsonObject r101, Integer r102, TargetEntity r103, Type r104, long r105) {
        this.name = r100;
        this.params = r101;
        this.callbackId = r102;
        this.target = r103;
        this.type = r104;
        this.timestamp = r105;
    }
}
