package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0002DCBg\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fB{\b\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u000e\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0016J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0016J\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0016J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0016Jp\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0016J\u0010\u0010#\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(J'\u00101\u001a\u00020.2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b/\u00100R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00102\u001a\u0004\b3\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00102\u001a\u0004\b4\u0010\u0016R \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u00102\u0012\u0004\b6\u00107\u001a\u0004\b5\u0010\u0016R \u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u00102\u0012\u0004\b9\u00107\u001a\u0004\b8\u0010\u0016R \u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u00102\u0012\u0004\b;\u00107\u001a\u0004\b:\u0010\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010<\u001a\u0004\b=\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b>\u0010\u0016R \u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u00102\u0012\u0004\b@\u00107\u001a\u0004\b?\u0010\u0016R \u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u00102\u0012\u0004\bB\u00107\u001a\u0004\bA\u0010\u0016¨\u0006E"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "status", OperationResult.EXTRA_MESSAGE, "unique_id", "task_status", "trigger_status", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;", "search_groups", "memory", "trigger_id", "error_detail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "()Ljava/util/List;", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getStatus", "getMessage", "getUnique_id", "getUnique_id$annotations", "()V", "getTask_status", "getTask_status$annotations", "getTrigger_status", "getTrigger_status$annotations", "Ljava/util/List;", "getSearch_groups", "getMemory", "getTrigger_id", "getTrigger_id$annotations", "getError_detail", "getError_detail$annotations", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineTriggerResponse {
    private final String error_detail;
    private final String memory;
    private final String message;
    private final List<OfflineSearchGroup> search_groups;
    private final String status;
    private final String task_status;
    private final String trigger_id;
    private final String trigger_status;
    private final String unique_id;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, null, null, null, h.w(f.f889a, new r(29)), null, null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineTriggerResponse> serializer() {
            return OfflineTriggerResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public OfflineTriggerResponse() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, (String) null, 511, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(OfflineSearchGroup$$serializer.INSTANCE);
    }

    public static /* synthetic */ OfflineTriggerResponse copy$default(OfflineTriggerResponse offlineTriggerResponse, String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = offlineTriggerResponse.status;
        }
        if ((i8 & 2) != 0) {
            str2 = offlineTriggerResponse.message;
        }
        if ((i8 & 4) != 0) {
            str3 = offlineTriggerResponse.unique_id;
        }
        if ((i8 & 8) != 0) {
            str4 = offlineTriggerResponse.task_status;
        }
        if ((i8 & 16) != 0) {
            str5 = offlineTriggerResponse.trigger_status;
        }
        if ((i8 & 32) != 0) {
            list = offlineTriggerResponse.search_groups;
        }
        if ((i8 & 64) != 0) {
            str6 = offlineTriggerResponse.memory;
        }
        if ((i8 & 128) != 0) {
            str7 = offlineTriggerResponse.trigger_id;
        }
        if ((i8 & 256) != 0) {
            str8 = offlineTriggerResponse.error_detail;
        }
        String str9 = str7;
        String str10 = str8;
        List list2 = list;
        String str11 = str6;
        String str12 = str5;
        String str13 = str3;
        return offlineTriggerResponse.copy(str, str2, str13, str4, str12, list2, str11, str9, str10);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineTriggerResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.status, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.message, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.message);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !p.a(self.unique_id, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 2, self.unique_id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !p.a(self.task_status, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 3, self.task_status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !p.a(self.trigger_status, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 4, self.trigger_status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !p.a(self.search_groups, s.f1092a)) {
            output.encodeSerializableElement(serialDesc, 5, (SerializationStrategy) eVarArr[5].getValue(), self.search_groups);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || !p.a(self.memory, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 6, self.memory);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || !p.a(self.trigger_id, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 7, self.trigger_id);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && p.a(self.error_detail, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            return;
        }
        output.encodeStringElement(serialDesc, 8, self.error_detail);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUnique_id() {
        return this.unique_id;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTask_status() {
        return this.task_status;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTrigger_status() {
        return this.trigger_status;
    }

    public final List<OfflineSearchGroup> component6() {
        return this.search_groups;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMemory() {
        return this.memory;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTrigger_id() {
        return this.trigger_id;
    }

    /* renamed from: component9, reason: from getter */
    public final String getError_detail() {
        return this.error_detail;
    }

    public final OfflineTriggerResponse copy(String status, String message, String unique_id, String task_status, String trigger_status, List<OfflineSearchGroup> search_groups, String memory, String trigger_id, String error_detail) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(unique_id, "unique_id");
        p.e(task_status, "task_status");
        p.e(trigger_status, "trigger_status");
        p.e(search_groups, "search_groups");
        p.e(memory, "memory");
        p.e(trigger_id, "trigger_id");
        p.e(error_detail, "error_detail");
        return new OfflineTriggerResponse(status, message, unique_id, task_status, trigger_status, search_groups, memory, trigger_id, error_detail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineTriggerResponse)) {
            return false;
        }
        OfflineTriggerResponse offlineTriggerResponse = (OfflineTriggerResponse) other;
        return p.a(this.status, offlineTriggerResponse.status) && p.a(this.message, offlineTriggerResponse.message) && p.a(this.unique_id, offlineTriggerResponse.unique_id) && p.a(this.task_status, offlineTriggerResponse.task_status) && p.a(this.trigger_status, offlineTriggerResponse.trigger_status) && p.a(this.search_groups, offlineTriggerResponse.search_groups) && p.a(this.memory, offlineTriggerResponse.memory) && p.a(this.trigger_id, offlineTriggerResponse.trigger_id) && p.a(this.error_detail, offlineTriggerResponse.error_detail);
    }

    public final String getError_detail() {
        return this.error_detail;
    }

    public final String getMemory() {
        return this.memory;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<OfflineSearchGroup> getSearch_groups() {
        return this.search_groups;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTask_status() {
        return this.task_status;
    }

    public final String getTrigger_id() {
        return this.trigger_id;
    }

    public final String getTrigger_status() {
        return this.trigger_status;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public int hashCode() {
        return this.error_detail.hashCode() + b.f(b.f((this.search_groups.hashCode() + b.f(b.f(b.f(b.f(this.status.hashCode() * 31, 31, this.message), 31, this.unique_id), 31, this.task_status), 31, this.trigger_status)) * 31, 31, this.memory), 31, this.trigger_id);
    }

    public String toString() {
        String str = this.status;
        String str2 = this.message;
        String str3 = this.unique_id;
        String str4 = this.task_status;
        String str5 = this.trigger_status;
        List<OfflineSearchGroup> list = this.search_groups;
        String str6 = this.memory;
        String str7 = this.trigger_id;
        String str8 = this.error_detail;
        StringBuilder sbV = b.v("OfflineTriggerResponse(status=", str, ", message=", str2, ", unique_id=");
        b.A(sbV, str3, ", task_status=", str4, ", trigger_status=");
        sbV.append(str5);
        sbV.append(", search_groups=");
        sbV.append(list);
        sbV.append(", memory=");
        b.A(sbV, str6, ", trigger_id=", str7, ", error_detail=");
        return m0.f.f(sbV, str8, ")");
    }

    public /* synthetic */ OfflineTriggerResponse(int i8, String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.status = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.status = str;
        }
        if ((i8 & 2) == 0) {
            this.message = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.message = str2;
        }
        if ((i8 & 4) == 0) {
            this.unique_id = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.unique_id = str3;
        }
        if ((i8 & 8) == 0) {
            this.task_status = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.task_status = str4;
        }
        if ((i8 & 16) == 0) {
            this.trigger_status = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.trigger_status = str5;
        }
        if ((i8 & 32) == 0) {
            this.search_groups = s.f1092a;
        } else {
            this.search_groups = list;
        }
        if ((i8 & 64) == 0) {
            this.memory = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.memory = str6;
        }
        if ((i8 & 128) == 0) {
            this.trigger_id = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.trigger_id = str7;
        }
        if ((i8 & 256) == 0) {
            this.error_detail = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.error_detail = str8;
        }
    }

    public OfflineTriggerResponse(String status, String message, String unique_id, String task_status, String trigger_status, List<OfflineSearchGroup> search_groups, String memory, String trigger_id, String error_detail) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(unique_id, "unique_id");
        p.e(task_status, "task_status");
        p.e(trigger_status, "trigger_status");
        p.e(search_groups, "search_groups");
        p.e(memory, "memory");
        p.e(trigger_id, "trigger_id");
        p.e(error_detail, "error_detail");
        this.status = status;
        this.message = message;
        this.unique_id = unique_id;
        this.task_status = task_status;
        this.trigger_status = trigger_status;
        this.search_groups = search_groups;
        this.memory = memory;
        this.trigger_id = trigger_id;
        this.error_detail = error_detail;
    }

    public /* synthetic */ OfflineTriggerResponse(String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, String str8, int i8, i iVar) {
        this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i8 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str4, (i8 & 16) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str5, (i8 & 32) != 0 ? s.f1092a : list, (i8 & 64) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str6, (i8 & 128) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str7, (i8 & 256) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str8);
    }

    @SerialName("error_detail")
    public static /* synthetic */ void getError_detail$annotations() {
    }

    @SerialName("task_status")
    public static /* synthetic */ void getTask_status$annotations() {
    }

    @SerialName("trigger_id")
    public static /* synthetic */ void getTrigger_id$annotations() {
    }

    @SerialName("trigger_status")
    public static /* synthetic */ void getTrigger_status$annotations() {
    }

    @SerialName("unique_id")
    public static /* synthetic */ void getUnique_id$annotations() {
    }
}
