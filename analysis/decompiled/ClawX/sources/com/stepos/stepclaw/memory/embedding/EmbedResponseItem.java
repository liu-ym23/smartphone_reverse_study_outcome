package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\r\b\u0083\b\u0018\u0000 .2\u00020\u0001:\u0002/.B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB=\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ4\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b \u0010\u001dJ\u0010\u0010!\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u001bR \u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010*\u0012\u0004\b,\u0010-\u001a\u0004\b+\u0010\u001d¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbedResponseItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embedding", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "obj", "<init>", "(Ljava/util/List;ILjava/lang/String;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/embedding/EmbedResponseItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/util/List;", "component2", "()I", "component3", "()Ljava/lang/String;", "copy", "(Ljava/util/List;ILjava/lang/String;)Lcom/stepos/stepclaw/memory/embedding/EmbedResponseItem;", "toString", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getEmbedding", "I", "getIndex", "Ljava/lang/String;", "getObj", "getObj$annotations", "()V", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
final /* data */ class EmbedResponseItem {
    private final List<Float> embedding;
    private final int index;
    private final String obj;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final b5.e[] $childSerializers = {b8.h.w(b5.f.f889a, new a(1)), null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbedResponseItem$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/embedding/EmbedResponseItem;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final KSerializer<EmbedResponseItem> serializer() {
            return EmbedResponseItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EmbedResponseItem(int i8, List list, int i9, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 3, EmbedResponseItem$$serializer.INSTANCE.getDescriptor());
        }
        this.embedding = list;
        this.index = i9;
        if ((i8 & 4) == 0) {
            this.obj = "embedding";
        } else {
            this.obj = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(FloatSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EmbedResponseItem copy$default(EmbedResponseItem embedResponseItem, List list, int i8, String str, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            list = embedResponseItem.embedding;
        }
        if ((i9 & 2) != 0) {
            i8 = embedResponseItem.index;
        }
        if ((i9 & 4) != 0) {
            str = embedResponseItem.obj;
        }
        return embedResponseItem.copy(list, i8, str);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(EmbedResponseItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.embedding);
        output.encodeIntElement(serialDesc, 1, self.index);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && p.a(self.obj, "embedding")) {
            return;
        }
        output.encodeStringElement(serialDesc, 2, self.obj);
    }

    public final List<Float> component1() {
        return this.embedding;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: component3, reason: from getter */
    public final String getObj() {
        return this.obj;
    }

    public final EmbedResponseItem copy(List<Float> embedding, int index, String obj) {
        p.e(embedding, "embedding");
        p.e(obj, "obj");
        return new EmbedResponseItem(embedding, index, obj);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmbedResponseItem)) {
            return false;
        }
        EmbedResponseItem embedResponseItem = (EmbedResponseItem) other;
        return p.a(this.embedding, embedResponseItem.embedding) && this.index == embedResponseItem.index && p.a(this.obj, embedResponseItem.obj);
    }

    public final List<Float> getEmbedding() {
        return this.embedding;
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getObj() {
        return this.obj;
    }

    public int hashCode() {
        return this.obj.hashCode() + a8.b.C(this.index, this.embedding.hashCode() * 31, 31);
    }

    public String toString() {
        List<Float> list = this.embedding;
        int i8 = this.index;
        String str = this.obj;
        StringBuilder sb = new StringBuilder("EmbedResponseItem(embedding=");
        sb.append(list);
        sb.append(", index=");
        sb.append(i8);
        sb.append(", obj=");
        return m0.f.f(sb, str, ")");
    }

    public EmbedResponseItem(List<Float> embedding, int i8, String obj) {
        p.e(embedding, "embedding");
        p.e(obj, "obj");
        this.embedding = embedding;
        this.index = i8;
        this.obj = obj;
    }

    public /* synthetic */ EmbedResponseItem(List list, int i8, String str, int i9, kotlin.jvm.internal.i iVar) {
        this(list, i8, (i9 & 4) != 0 ? "embedding" : str);
    }

    @SerialName("object")
    public static /* synthetic */ void getObj$annotations() {
    }
}
