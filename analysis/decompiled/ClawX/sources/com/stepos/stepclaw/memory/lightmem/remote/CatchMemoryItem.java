package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.a0;
import b5.e;
import b5.f;
import b8.h;
import c5.s;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.evolution.EpisodicMemoryEvolutionState;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionIds;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryRecord;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import o3.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002GHBU\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eBe\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0015J\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0015J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0015J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0015J\u0012\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0003¢\u0006\u0004\b#\u0010$J^\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bHÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u0015J\u0010\u0010(\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b,\u0010-J'\u00106\u001a\u0002032\u0006\u0010.\u001a\u00020\u00002\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0001¢\u0006\u0004\b4\u00105R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00107\u001a\u0004\b8\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u00109\u001a\u0004\b:\u0010\u001dR \u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u00107\u0012\u0004\b<\u0010=\u001a\u0004\b;\u0010\u0015R \u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u00107\u0012\u0004\b?\u0010=\u001a\u0004\b>\u0010\u0015R \u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u00107\u0012\u0004\bA\u0010=\u001a\u0004\b@\u0010\u0015R\"\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010B\u0012\u0004\bD\u0010=\u001a\u0004\bC\u0010\"R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010E\u001a\u0004\bF\u0010$¨\u0006I"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "confidence", "profileType", "createAt", "state", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memoryIndex", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "keywords", "<init>", "(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "toJsonString", "()Ljava/lang/String;", "category", "date", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "toMemoryRecord", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "component1", "component2", "()D", "component3", "component4", "component5", "component6", "()Ljava/lang/Long;", "component7", "()Ljava/util/List;", "copy", "(Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getContent", "D", "getConfidence", "getProfileType", "getProfileType$annotations", "()V", "getCreateAt", "getCreateAt$annotations", "getState", "getState$annotations", "Ljava/lang/Long;", "getMemoryIndex", "getMemoryIndex$annotations", "Ljava/util/List;", "getKeywords", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class CatchMemoryItem {
    private final double confidence;
    private final String content;
    private final String createAt;
    private final List<String> keywords;
    private final Long memoryIndex;
    private final String profileType;
    private final String state;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, null, null, null, null, h.w(f.f889a, new r(23))};
    private static final Json JSON = JsonKt.Json$default(null, new a(6), 1, null);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "JSON", "Lkotlinx/serialization/json/Json;", "getJSON", "()Lkotlinx/serialization/json/Json;", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final Json getJSON() {
            return CatchMemoryItem.JSON;
        }

        public final KSerializer<CatchMemoryItem> serializer() {
            return CatchMemoryItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public CatchMemoryItem() {
        this((String) null, 0.0d, (String) null, (String) null, (String) null, (Long) null, (List) null, 127, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a0 JSON$lambda$0(JsonBuilder Json) {
        p.e(Json, "$this$Json");
        Json.setEncodeDefaults(true);
        return a0.f883a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    public static /* synthetic */ CatchMemoryItem copy$default(CatchMemoryItem catchMemoryItem, String str, double d, String str2, String str3, String str4, Long l3, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = catchMemoryItem.content;
        }
        if ((i8 & 2) != 0) {
            d = catchMemoryItem.confidence;
        }
        if ((i8 & 4) != 0) {
            str2 = catchMemoryItem.profileType;
        }
        if ((i8 & 8) != 0) {
            str3 = catchMemoryItem.createAt;
        }
        if ((i8 & 16) != 0) {
            str4 = catchMemoryItem.state;
        }
        if ((i8 & 32) != 0) {
            l3 = catchMemoryItem.memoryIndex;
        }
        if ((i8 & 64) != 0) {
            list = catchMemoryItem.keywords;
        }
        List list2 = list;
        String str5 = str4;
        String str6 = str2;
        return catchMemoryItem.copy(str, d, str6, str3, str5, l3, list2);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(CatchMemoryItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.content, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || Double.compare(self.confidence, 0.0d) != 0) {
            output.encodeDoubleElement(serialDesc, 1, self.confidence);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !p.a(self.profileType, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 2, self.profileType);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !p.a(self.createAt, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeSerializableElement(serialDesc, 3, Iso8601FlexibleStringSerializer.INSTANCE, self.createAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || !p.a(self.state, EpisodicMemoryEvolutionState.PENDING)) {
            output.encodeStringElement(serialDesc, 4, self.state);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.memoryIndex != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, LongSerializer.INSTANCE, self.memoryIndex);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && p.a(self.keywords, s.f1092a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 6, (SerializationStrategy) eVarArr[6].getValue(), self.keywords);
    }

    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final double getConfidence() {
        return this.confidence;
    }

    /* renamed from: component3, reason: from getter */
    public final String getProfileType() {
        return this.profileType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCreateAt() {
        return this.createAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getMemoryIndex() {
        return this.memoryIndex;
    }

    public final List<String> component7() {
        return this.keywords;
    }

    public final CatchMemoryItem copy(String content, double confidence, String profileType, String createAt, String state, Long memoryIndex, List<String> keywords) {
        p.e(content, "content");
        p.e(profileType, "profileType");
        p.e(createAt, "createAt");
        p.e(state, "state");
        p.e(keywords, "keywords");
        return new CatchMemoryItem(content, confidence, profileType, createAt, state, memoryIndex, keywords);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CatchMemoryItem)) {
            return false;
        }
        CatchMemoryItem catchMemoryItem = (CatchMemoryItem) other;
        return p.a(this.content, catchMemoryItem.content) && Double.compare(this.confidence, catchMemoryItem.confidence) == 0 && p.a(this.profileType, catchMemoryItem.profileType) && p.a(this.createAt, catchMemoryItem.createAt) && p.a(this.state, catchMemoryItem.state) && p.a(this.memoryIndex, catchMemoryItem.memoryIndex) && p.a(this.keywords, catchMemoryItem.keywords);
    }

    public final double getConfidence() {
        return this.confidence;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getCreateAt() {
        return this.createAt;
    }

    public final List<String> getKeywords() {
        return this.keywords;
    }

    public final Long getMemoryIndex() {
        return this.memoryIndex;
    }

    public final String getProfileType() {
        return this.profileType;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        int iF = b.f(b.f(b.f((Double.hashCode(this.confidence) + (this.content.hashCode() * 31)) * 31, 31, this.profileType), 31, this.createAt), 31, this.state);
        Long l3 = this.memoryIndex;
        return this.keywords.hashCode() + ((iF + (l3 == null ? 0 : l3.hashCode())) * 31);
    }

    public final String toJsonString() {
        return JSON.encodeToString(INSTANCE.serializer(), this);
    }

    public final MemoryRecord toMemoryRecord(String category, String date) {
        p.e(category, "category");
        p.e(date, "date");
        Long l3 = this.memoryIndex;
        long jLongValue = l3 != null ? l3.longValue() : OfflineEvolutionIds.INSTANCE.newMemoryIndexId();
        return new MemoryRecord(jLongValue != 0 ? String.valueOf(jLongValue) : MemoryFile.INSTANCE.generateEntryId(this.content, category, date), this.content, MemoryFile.INSTANCE.parseIso8601ToMillis(this.createAt), category, date, this.confidence, this.profileType, this.state, jLongValue, this.keywords);
    }

    public String toString() {
        String str = this.content;
        double d = this.confidence;
        String str2 = this.profileType;
        String str3 = this.createAt;
        String str4 = this.state;
        Long l3 = this.memoryIndex;
        List<String> list = this.keywords;
        StringBuilder sb = new StringBuilder("CatchMemoryItem(content=");
        sb.append(str);
        sb.append(", confidence=");
        sb.append(d);
        b.A(sb, ", profileType=", str2, ", createAt=", str3);
        sb.append(", state=");
        sb.append(str4);
        sb.append(", memoryIndex=");
        sb.append(l3);
        sb.append(", keywords=");
        sb.append(list);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ CatchMemoryItem(int i8, String str, double d, String str2, String str3, String str4, Long l3, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.content = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.content = str;
        }
        if ((i8 & 2) == 0) {
            this.confidence = 0.0d;
        } else {
            this.confidence = d;
        }
        if ((i8 & 4) == 0) {
            this.profileType = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.profileType = str2;
        }
        if ((i8 & 8) == 0) {
            this.createAt = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.createAt = str3;
        }
        if ((i8 & 16) == 0) {
            this.state = EpisodicMemoryEvolutionState.PENDING;
        } else {
            this.state = str4;
        }
        if ((i8 & 32) == 0) {
            this.memoryIndex = null;
        } else {
            this.memoryIndex = l3;
        }
        if ((i8 & 64) == 0) {
            this.keywords = s.f1092a;
        } else {
            this.keywords = list;
        }
    }

    public CatchMemoryItem(String content, double d, String profileType, String createAt, String state, Long l3, List<String> keywords) {
        p.e(content, "content");
        p.e(profileType, "profileType");
        p.e(createAt, "createAt");
        p.e(state, "state");
        p.e(keywords, "keywords");
        this.content = content;
        this.confidence = d;
        this.profileType = profileType;
        this.createAt = createAt;
        this.state = state;
        this.memoryIndex = l3;
        this.keywords = keywords;
    }

    public /* synthetic */ CatchMemoryItem(String str, double d, String str2, String str3, String str4, Long l3, List list, int i8, i iVar) {
        this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 2) != 0 ? 0.0d : d, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, (i8 & 16) != 0 ? EpisodicMemoryEvolutionState.PENDING : str4, (i8 & 32) != 0 ? null : l3, (i8 & 64) != 0 ? s.f1092a : list);
    }

    @SerialName("create_at")
    @Serializable(with = Iso8601FlexibleStringSerializer.class)
    public static /* synthetic */ void getCreateAt$annotations() {
    }

    @SerialName("memory_index")
    public static /* synthetic */ void getMemoryIndex$annotations() {
    }

    @SerialName("profile_type")
    public static /* synthetic */ void getProfileType$annotations() {
    }

    @SerialName("state")
    public static /* synthetic */ void getState$annotations() {
    }
}
