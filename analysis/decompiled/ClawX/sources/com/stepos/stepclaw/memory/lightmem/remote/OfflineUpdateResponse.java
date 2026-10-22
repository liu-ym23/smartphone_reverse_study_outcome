package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.List;
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
import q3.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0002=<BS\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rBg\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\f\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0014J\\\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0014J\u0010\u0010\u001f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$J'\u0010-\u001a\u00020*2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0001¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010.\u001a\u0004\b0\u0010\u0014R \u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010.\u0012\u0004\b2\u00103\u001a\u0004\b1\u0010\u0014R \u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010.\u0012\u0004\b5\u00103\u001a\u0004\b4\u0010\u0014R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u00106\u001a\u0004\b7\u0010\u0019R \u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010.\u0012\u0004\b9\u00103\u001a\u0004\b8\u0010\u0014R \u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010.\u0012\u0004\b;\u00103\u001a\u0004\b:\u0010\u0014¨\u0006>"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "status", OperationResult.EXTRA_MESSAGE, "unique_id", "task_status", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionGroup;", "evolution_groups", "evolution_id", "error_detail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Ljava/util/List;", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getStatus", "getMessage", "getUnique_id", "getUnique_id$annotations", "()V", "getTask_status", "getTask_status$annotations", "Ljava/util/List;", "getEvolution_groups", "getEvolution_id", "getEvolution_id$annotations", "getError_detail", "getError_detail$annotations", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineUpdateResponse {
    private final String error_detail;
    private final List<OfflineEvolutionGroup> evolution_groups;
    private final String evolution_id;
    private final String message;
    private final String status;
    private final String task_status;
    private final String unique_id;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, null, null, h.w(f.f889a, new a(2)), null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineUpdateResponse> serializer() {
            return OfflineUpdateResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public OfflineUpdateResponse() {
        this((String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 127, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(OfflineEvolutionGroup$$serializer.INSTANCE);
    }

    public static /* synthetic */ OfflineUpdateResponse copy$default(OfflineUpdateResponse offlineUpdateResponse, String str, String str2, String str3, String str4, List list, String str5, String str6, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = offlineUpdateResponse.status;
        }
        if ((i8 & 2) != 0) {
            str2 = offlineUpdateResponse.message;
        }
        if ((i8 & 4) != 0) {
            str3 = offlineUpdateResponse.unique_id;
        }
        if ((i8 & 8) != 0) {
            str4 = offlineUpdateResponse.task_status;
        }
        if ((i8 & 16) != 0) {
            list = offlineUpdateResponse.evolution_groups;
        }
        if ((i8 & 32) != 0) {
            str5 = offlineUpdateResponse.evolution_id;
        }
        if ((i8 & 64) != 0) {
            str6 = offlineUpdateResponse.error_detail;
        }
        String str7 = str5;
        String str8 = str6;
        List list2 = list;
        String str9 = str3;
        return offlineUpdateResponse.copy(str, str2, str9, str4, list2, str7, str8);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineUpdateResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
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
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !p.a(self.evolution_groups, s.f1092a)) {
            output.encodeSerializableElement(serialDesc, 4, (SerializationStrategy) eVarArr[4].getValue(), self.evolution_groups);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || !p.a(self.evolution_id, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 5, self.evolution_id);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && p.a(self.error_detail, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            return;
        }
        output.encodeStringElement(serialDesc, 6, self.error_detail);
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

    public final List<OfflineEvolutionGroup> component5() {
        return this.evolution_groups;
    }

    /* renamed from: component6, reason: from getter */
    public final String getEvolution_id() {
        return this.evolution_id;
    }

    /* renamed from: component7, reason: from getter */
    public final String getError_detail() {
        return this.error_detail;
    }

    public final OfflineUpdateResponse copy(String status, String message, String unique_id, String task_status, List<OfflineEvolutionGroup> evolution_groups, String evolution_id, String error_detail) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(unique_id, "unique_id");
        p.e(task_status, "task_status");
        p.e(evolution_groups, "evolution_groups");
        p.e(evolution_id, "evolution_id");
        p.e(error_detail, "error_detail");
        return new OfflineUpdateResponse(status, message, unique_id, task_status, evolution_groups, evolution_id, error_detail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineUpdateResponse)) {
            return false;
        }
        OfflineUpdateResponse offlineUpdateResponse = (OfflineUpdateResponse) other;
        return p.a(this.status, offlineUpdateResponse.status) && p.a(this.message, offlineUpdateResponse.message) && p.a(this.unique_id, offlineUpdateResponse.unique_id) && p.a(this.task_status, offlineUpdateResponse.task_status) && p.a(this.evolution_groups, offlineUpdateResponse.evolution_groups) && p.a(this.evolution_id, offlineUpdateResponse.evolution_id) && p.a(this.error_detail, offlineUpdateResponse.error_detail);
    }

    public final String getError_detail() {
        return this.error_detail;
    }

    public final List<OfflineEvolutionGroup> getEvolution_groups() {
        return this.evolution_groups;
    }

    public final String getEvolution_id() {
        return this.evolution_id;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTask_status() {
        return this.task_status;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public int hashCode() {
        return this.error_detail.hashCode() + b.f((this.evolution_groups.hashCode() + b.f(b.f(b.f(this.status.hashCode() * 31, 31, this.message), 31, this.unique_id), 31, this.task_status)) * 31, 31, this.evolution_id);
    }

    public String toString() {
        String str = this.status;
        String str2 = this.message;
        String str3 = this.unique_id;
        String str4 = this.task_status;
        List<OfflineEvolutionGroup> list = this.evolution_groups;
        String str5 = this.evolution_id;
        String str6 = this.error_detail;
        StringBuilder sbV = b.v("OfflineUpdateResponse(status=", str, ", message=", str2, ", unique_id=");
        b.A(sbV, str3, ", task_status=", str4, ", evolution_groups=");
        sbV.append(list);
        sbV.append(", evolution_id=");
        sbV.append(str5);
        sbV.append(", error_detail=");
        return m0.f.f(sbV, str6, ")");
    }

    public /* synthetic */ OfflineUpdateResponse(int i8, String str, String str2, String str3, String str4, List list, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
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
            this.evolution_groups = s.f1092a;
        } else {
            this.evolution_groups = list;
        }
        if ((i8 & 32) == 0) {
            this.evolution_id = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.evolution_id = str5;
        }
        if ((i8 & 64) == 0) {
            this.error_detail = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.error_detail = str6;
        }
    }

    public OfflineUpdateResponse(String status, String message, String unique_id, String task_status, List<OfflineEvolutionGroup> evolution_groups, String evolution_id, String error_detail) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(unique_id, "unique_id");
        p.e(task_status, "task_status");
        p.e(evolution_groups, "evolution_groups");
        p.e(evolution_id, "evolution_id");
        p.e(error_detail, "error_detail");
        this.status = status;
        this.message = message;
        this.unique_id = unique_id;
        this.task_status = task_status;
        this.evolution_groups = evolution_groups;
        this.evolution_id = evolution_id;
        this.error_detail = error_detail;
    }

    public /* synthetic */ OfflineUpdateResponse(String str, String str2, String str3, String str4, List list, String str5, String str6, int i8, i iVar) {
        this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i8 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str4, (i8 & 16) != 0 ? s.f1092a : list, (i8 & 32) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str5, (i8 & 64) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str6);
    }

    @SerialName("error_detail")
    public static /* synthetic */ void getError_detail$annotations() {
    }

    @SerialName("evolution_id")
    public static /* synthetic */ void getEvolution_id$annotations() {
    }

    @SerialName("task_status")
    public static /* synthetic */ void getTask_status$annotations() {
    }

    @SerialName("unique_id")
    public static /* synthetic */ void getUnique_id$annotations() {
    }
}
