package com.stepos.datacenter.vector;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import lb.l;
import ob.d;
import pb.C5094f;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002-&B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\u0004\b\t\u0010\nBC\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ:\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0018J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\u0018R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010\u001aR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010)\u001a\u0004\b+\u0010\u001a¨\u0006."}, d2 = {"Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;", "", "", "formatVersion", "", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "collections", "Lcom/stepos/datacenter/vector/IndexDescriptor;", "indexes", "<init>", "(ILjava/util/List;Ljava/util/List;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IILjava/util/List;Ljava/util/List;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", Const.INTENT_KEY_PKGNAME, "()I", "c", "()Ljava/util/List;", Const.INTENT_KEY_UMID, "e", "(ILjava/util/List;Ljava/util/List;)Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Companion", "$serializer", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class VectorRegistrySnapshot {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int formatVersion;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<CollectionDescriptor> collections;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<IndexDescriptor> indexes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new C5094f(CollectionDescriptor$$serializer.INSTANCE), new C5094f(IndexDescriptor$$serializer.INSTANCE)};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/vector/VectorRegistrySnapshot$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/VectorRegistrySnapshot;", "serializer", "()Lkotlinx/serialization/KSerializer;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.VectorRegistrySnapshot$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<VectorRegistrySnapshot> serializer() {
            return VectorRegistrySnapshot$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }
    }

    public /* synthetic */ VectorRegistrySnapshot(int i10, int i11, List list, List list2, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, VectorRegistrySnapshot$$serializer.INSTANCE.getDescriptor());
        }
        this.formatVersion = i11;
        this.collections = list;
        this.indexes = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VectorRegistrySnapshot f(VectorRegistrySnapshot vectorRegistrySnapshot, int i10, List list, List list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = vectorRegistrySnapshot.formatVersion;
        }
        if ((i11 & 2) != 0) {
            list = vectorRegistrySnapshot.collections;
        }
        if ((i11 & 4) != 0) {
            list2 = vectorRegistrySnapshot.indexes;
        }
        return vectorRegistrySnapshot.e(i10, list, list2);
    }

    public static final /* synthetic */ void j(VectorRegistrySnapshot self, d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.t(serialDesc, 0, self.formatVersion);
        output.x(serialDesc, 1, kSerializerArr[1], self.collections);
        output.x(serialDesc, 2, kSerializerArr[2], self.indexes);
    }

    /* renamed from: b, reason: from getter */
    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public final List<CollectionDescriptor> c() {
        return this.collections;
    }

    public final List<IndexDescriptor> d() {
        return this.indexes;
    }

    public final VectorRegistrySnapshot e(int formatVersion, List<CollectionDescriptor> collections, List<IndexDescriptor> indexes) {
        p.i(collections, "collections");
        p.i(indexes, "indexes");
        return new VectorRegistrySnapshot(formatVersion, collections, indexes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorRegistrySnapshot)) {
            return false;
        }
        VectorRegistrySnapshot vectorRegistrySnapshot = (VectorRegistrySnapshot) other;
        return this.formatVersion == vectorRegistrySnapshot.formatVersion && p.d(this.collections, vectorRegistrySnapshot.collections) && p.d(this.indexes, vectorRegistrySnapshot.indexes);
    }

    public final List<CollectionDescriptor> g() {
        return this.collections;
    }

    public final int h() {
        return this.formatVersion;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.formatVersion) * 31) + this.collections.hashCode()) * 31) + this.indexes.hashCode();
    }

    public final List<IndexDescriptor> i() {
        return this.indexes;
    }

    public String toString() {
        return "VectorRegistrySnapshot(formatVersion=" + this.formatVersion + ", collections=" + this.collections + ", indexes=" + this.indexes + ")";
    }

    public VectorRegistrySnapshot(int i10, List<CollectionDescriptor> collections, List<IndexDescriptor> indexes) {
        p.i(collections, "collections");
        p.i(indexes, "indexes");
        this.formatVersion = i10;
        this.collections = collections;
        this.indexes = indexes;
    }
}
