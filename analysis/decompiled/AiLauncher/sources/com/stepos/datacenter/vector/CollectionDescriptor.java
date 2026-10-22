package com.stepos.datacenter.vector;

import La.H;
import Z8.C1173v;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import lb.l;
import ob.d;
import pb.C5089c0;
import pb.C5094f;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010\u0006\n\u0002\b\u0006\b\u0087\b\u0018\u0000 a2\u00020\u0001:\u0002abB\u009f\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u00ad\u0001\b\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0019\u0010\u001eJ'\u0010'\u001a\u00020$2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b,\u0010+J\u0010\u0010-\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00101\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b1\u0010)J\u0010\u00102\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u000eHÆ\u0003¢\u0006\u0004\b4\u00105J\u0010\u00106\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b6\u0010+J\u0012\u00107\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b7\u0010)J\u0016\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012HÆ\u0003¢\u0006\u0004\b8\u00109J\u0010\u0010:\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b:\u0010+J\u001c\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0015HÆ\u0003¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0017HÆ\u0003¢\u0006\u0004\b=\u0010>J°\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u0014\b\u0002\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017HÆ\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bA\u0010)J\u0010\u0010B\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bB\u0010+J\u001a\u0010D\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bD\u0010ER\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010F\u001a\u0004\bG\u0010)R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010H\u001a\u0004\bI\u0010+R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010H\u001a\u0004\bJ\u0010+R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010K\u001a\u0004\bL\u0010.R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010M\u001a\u0004\bN\u00100R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010F\u001a\u0004\bO\u0010)R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010P\u001a\u0004\bQ\u00103R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010R\u001a\u0004\bS\u00105R\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010H\u001a\u0004\bT\u0010+R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010F\u001a\u0004\bU\u0010)R\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010V\u001a\u0004\bW\u00109R\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010H\u001a\u0004\bX\u0010+R#\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00158\u0006¢\u0006\f\n\u0004\b\u0016\u0010Y\u001a\u0004\bZ\u0010<R\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010[\u001a\u0004\b\\\u0010>R\u0011\u0010`\u001a\u00020]8F¢\u0006\u0006\u001a\u0004\b^\u0010_¨\u0006c"}, d2 = {"Lcom/stepos/datacenter/vector/CollectionDescriptor;", "", "", "id", "", "rawDim", "storageDim", "Lcom/stepos/datacenter/vector/DistanceMetric;", "metric", "Lcom/stepos/datacenter/vector/StorageDType;", "dtype", "embeddingModel", "", "inputNormalized", "", "createdAtNs", "formatVersion", "primaryIndexId", "", "activeIndexIds", "indexRetention", "", "extra", "Lcom/stepos/datacenter/vector/CapacityPolicy;", "capacityPolicy", "<init>", "(Ljava/lang/String;IILcom/stepos/datacenter/vector/DistanceMetric;Lcom/stepos/datacenter/vector/StorageDType;Ljava/lang/String;ZJILjava/lang/String;Ljava/util/List;ILjava/util/Map;Lcom/stepos/datacenter/vector/CapacityPolicy;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;IILcom/stepos/datacenter/vector/DistanceMetric;Lcom/stepos/datacenter/vector/StorageDType;Ljava/lang/String;ZJILjava/lang/String;Ljava/util/List;ILjava/util/Map;Lcom/stepos/datacenter/vector/CapacityPolicy;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$vector_release", "(Lcom/stepos/datacenter/vector/CollectionDescriptor;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()I", "component3", "component4", "()Lcom/stepos/datacenter/vector/DistanceMetric;", "component5", "()Lcom/stepos/datacenter/vector/StorageDType;", "component6", "component7", "()Z", "component8", "()J", "component9", "component10", "component11", "()Ljava/util/List;", "component12", "component13", "()Ljava/util/Map;", "component14", "()Lcom/stepos/datacenter/vector/CapacityPolicy;", ChatTracker.CLICK_COPY, "(Ljava/lang/String;IILcom/stepos/datacenter/vector/DistanceMetric;Lcom/stepos/datacenter/vector/StorageDType;Ljava/lang/String;ZJILjava/lang/String;Ljava/util/List;ILjava/util/Map;Lcom/stepos/datacenter/vector/CapacityPolicy;)Lcom/stepos/datacenter/vector/CollectionDescriptor;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "I", "getRawDim", "getStorageDim", "Lcom/stepos/datacenter/vector/DistanceMetric;", "getMetric", "Lcom/stepos/datacenter/vector/StorageDType;", "getDtype", "getEmbeddingModel", "Z", "getInputNormalized", "J", "getCreatedAtNs", "getFormatVersion", "getPrimaryIndexId", "Ljava/util/List;", "getActiveIndexIds", "getIndexRetention", "Ljava/util/Map;", "getExtra", "Lcom/stepos/datacenter/vector/CapacityPolicy;", "getCapacityPolicy", "", "getPaddingOverheadPercent", "()D", "paddingOverheadPercent", "Companion", "$serializer", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class CollectionDescriptor {
    private static final KSerializer<Object>[] $childSerializers;
    public static final int ALIGN_BOUNDARY = 64;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String DEFAULT_ID = "default";
    public static final int DEFAULT_INDEX_RETENTION = 2;
    public static final int FORMAT_VERSION = 1;
    private static final Regex ID_REGEX;
    private final List<String> activeIndexIds;
    private final CapacityPolicy capacityPolicy;
    private final long createdAtNs;
    private final StorageDType dtype;
    private final String embeddingModel;
    private final Map<String, String> extra;
    private final int formatVersion;
    private final String id;
    private final int indexRetention;
    private final boolean inputNormalized;
    private final DistanceMetric metric;
    private final String primaryIndexId;
    private final int rawDim;
    private final int storageDim;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0005J\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stepos/datacenter/vector/CollectionDescriptor$Companion;", "", "<init>", "()V", "FORMAT_VERSION", "", "ALIGN_BOUNDARY", "DEFAULT_INDEX_RETENTION", "DEFAULT_ID", "", "ID_REGEX", "Lkotlin/text/Regex;", "alignDim", "raw", "boundary", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ int alignDim$default(Companion companion, int i10, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 64;
            }
            return companion.alignDim(i10, i11);
        }

        public final int alignDim(int raw, int boundary) {
            if (raw <= 0) {
                throw new IllegalArgumentException(("raw dim must be > 0, got " + raw).toString());
            }
            if (boundary > 0) {
                return (((raw + boundary) - 1) / boundary) * boundary;
            }
            throw new IllegalArgumentException(("boundary must be > 0, got " + boundary).toString());
        }

        public final KSerializer<CollectionDescriptor> serializer() {
            return CollectionDescriptor$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        KSerializer<DistanceMetric> kSerializerSerializer = DistanceMetric.INSTANCE.serializer();
        KSerializer<StorageDType> kSerializerSerializer2 = StorageDType.INSTANCE.serializer();
        Y0 y02 = Y0.f38329a;
        $childSerializers = new KSerializer[]{null, null, null, kSerializerSerializer, kSerializerSerializer2, null, null, null, null, null, new C5094f(y02), null, new C5089c0(y02, y02), null};
        ID_REGEX = new Regex("^[a-z][a-z0-9_]{0,63}$");
    }

    public /* synthetic */ CollectionDescriptor(int i10, String str, int i11, int i12, DistanceMetric distanceMetric, StorageDType storageDType, String str2, boolean z10, long j10, int i13, String str3, List list, int i14, Map map, CapacityPolicy capacityPolicy, T0 t02) {
        if (43 != (i10 & 43)) {
            E0.a(i10, 43, CollectionDescriptor$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.rawDim = i11;
        this.storageDim = (i10 & 4) == 0 ? Companion.alignDim$default(INSTANCE, i11, 0, 2, null) : i12;
        this.metric = distanceMetric;
        if ((i10 & 16) == 0) {
            this.dtype = StorageDType.FP32;
        } else {
            this.dtype = storageDType;
        }
        this.embeddingModel = str2;
        if ((i10 & 64) == 0) {
            this.inputNormalized = false;
        } else {
            this.inputNormalized = z10;
        }
        if ((i10 & 128) == 0) {
            this.createdAtNs = System.nanoTime();
        } else {
            this.createdAtNs = j10;
        }
        if ((i10 & 256) == 0) {
            this.formatVersion = 1;
        } else {
            this.formatVersion = i13;
        }
        if ((i10 & 512) == 0) {
            this.primaryIndexId = null;
        } else {
            this.primaryIndexId = str3;
        }
        this.activeIndexIds = (i10 & 1024) == 0 ? C1173v.m() : list;
        if ((i10 & 2048) == 0) {
            this.indexRetention = 2;
        } else {
            this.indexRetention = i14;
        }
        this.extra = (i10 & 4096) == 0 ? a.i() : map;
        this.capacityPolicy = (i10 & b.THRESHOLD) == 0 ? CapacityPolicy.INSTANCE.a() : capacityPolicy;
        if (H.x0(str)) {
            throw new IllegalArgumentException("CollectionDescriptor.id must be non-blank");
        }
        Regex regex = ID_REGEX;
        if (!regex.k(str)) {
            throw new IllegalArgumentException(("CollectionDescriptor.id must match " + regex + " (lower_snake_case with optional digits), got '" + str + "'").toString());
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException(("rawDim must be > 0, got " + i11).toString());
        }
        int i15 = this.storageDim;
        if (i15 < i11) {
            throw new IllegalArgumentException(("storageDim (" + i15 + ") must be >= rawDim (" + i11 + ")").toString());
        }
        if (i15 % 64 != 0) {
            throw new IllegalArgumentException(("storageDim must be aligned to 64, got " + i15).toString());
        }
        if (H.x0(str2)) {
            throw new IllegalArgumentException("embeddingModel must be non-blank; use 'unknown@v0' as placeholder if truly unknown");
        }
        int i16 = this.indexRetention;
        if (i16 < 1) {
            throw new IllegalArgumentException(("indexRetention must be >= 1, got " + i16).toString());
        }
        int i17 = this.formatVersion;
        if (i17 != 1) {
            throw new IllegalArgumentException(("unsupported CollectionDescriptor formatVersion " + i17 + " (current=1)").toString());
        }
        String str4 = this.primaryIndexId;
        if (str4 == null || this.activeIndexIds.contains(str4)) {
            return;
        }
        throw new IllegalArgumentException(("primaryIndexId '" + str4 + "' must be in activeIndexIds " + this.activeIndexIds).toString());
    }

    public static final /* synthetic */ void write$Self$vector_release(CollectionDescriptor self, d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.w(serialDesc, 0, self.id);
        output.t(serialDesc, 1, self.rawDim);
        if (output.y(serialDesc, 2) || self.storageDim != Companion.alignDim$default(INSTANCE, self.rawDim, 0, 2, null)) {
            output.t(serialDesc, 2, self.storageDim);
        }
        output.x(serialDesc, 3, kSerializerArr[3], self.metric);
        if (output.y(serialDesc, 4) || self.dtype != StorageDType.FP32) {
            output.x(serialDesc, 4, kSerializerArr[4], self.dtype);
        }
        output.w(serialDesc, 5, self.embeddingModel);
        if (output.y(serialDesc, 6) || self.inputNormalized) {
            output.v(serialDesc, 6, self.inputNormalized);
        }
        if (output.y(serialDesc, 7) || self.createdAtNs != System.nanoTime()) {
            output.C(serialDesc, 7, self.createdAtNs);
        }
        if (output.y(serialDesc, 8) || self.formatVersion != 1) {
            output.t(serialDesc, 8, self.formatVersion);
        }
        if (output.y(serialDesc, 9) || self.primaryIndexId != null) {
            output.k(serialDesc, 9, Y0.f38329a, self.primaryIndexId);
        }
        if (output.y(serialDesc, 10) || !p.d(self.activeIndexIds, C1173v.m())) {
            output.x(serialDesc, 10, kSerializerArr[10], self.activeIndexIds);
        }
        if (output.y(serialDesc, 11) || self.indexRetention != 2) {
            output.t(serialDesc, 11, self.indexRetention);
        }
        if (output.y(serialDesc, 12) || !p.d(self.extra, a.i())) {
            output.x(serialDesc, 12, kSerializerArr[12], self.extra);
        }
        if (!output.y(serialDesc, 13) && p.d(self.capacityPolicy, CapacityPolicy.INSTANCE.a())) {
            return;
        }
        output.x(serialDesc, 13, CapacityPolicy$$serializer.INSTANCE, self.capacityPolicy);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPrimaryIndexId() {
        return this.primaryIndexId;
    }

    public final List<String> component11() {
        return this.activeIndexIds;
    }

    /* renamed from: component12, reason: from getter */
    public final int getIndexRetention() {
        return this.indexRetention;
    }

    public final Map<String, String> component13() {
        return this.extra;
    }

    /* renamed from: component14, reason: from getter */
    public final CapacityPolicy getCapacityPolicy() {
        return this.capacityPolicy;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRawDim() {
        return this.rawDim;
    }

    /* renamed from: component3, reason: from getter */
    public final int getStorageDim() {
        return this.storageDim;
    }

    /* renamed from: component4, reason: from getter */
    public final DistanceMetric getMetric() {
        return this.metric;
    }

    /* renamed from: component5, reason: from getter */
    public final StorageDType getDtype() {
        return this.dtype;
    }

    /* renamed from: component6, reason: from getter */
    public final String getEmbeddingModel() {
        return this.embeddingModel;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getInputNormalized() {
        return this.inputNormalized;
    }

    /* renamed from: component8, reason: from getter */
    public final long getCreatedAtNs() {
        return this.createdAtNs;
    }

    /* renamed from: component9, reason: from getter */
    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public final CollectionDescriptor copy(String id, int rawDim, int storageDim, DistanceMetric metric, StorageDType dtype, String embeddingModel, boolean inputNormalized, long createdAtNs, int formatVersion, String primaryIndexId, List<String> activeIndexIds, int indexRetention, Map<String, String> extra, CapacityPolicy capacityPolicy) {
        p.i(id, "id");
        p.i(metric, "metric");
        p.i(dtype, "dtype");
        p.i(embeddingModel, "embeddingModel");
        p.i(activeIndexIds, "activeIndexIds");
        p.i(extra, "extra");
        p.i(capacityPolicy, "capacityPolicy");
        return new CollectionDescriptor(id, rawDim, storageDim, metric, dtype, embeddingModel, inputNormalized, createdAtNs, formatVersion, primaryIndexId, activeIndexIds, indexRetention, extra, capacityPolicy);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectionDescriptor)) {
            return false;
        }
        CollectionDescriptor collectionDescriptor = (CollectionDescriptor) other;
        return p.d(this.id, collectionDescriptor.id) && this.rawDim == collectionDescriptor.rawDim && this.storageDim == collectionDescriptor.storageDim && this.metric == collectionDescriptor.metric && this.dtype == collectionDescriptor.dtype && p.d(this.embeddingModel, collectionDescriptor.embeddingModel) && this.inputNormalized == collectionDescriptor.inputNormalized && this.createdAtNs == collectionDescriptor.createdAtNs && this.formatVersion == collectionDescriptor.formatVersion && p.d(this.primaryIndexId, collectionDescriptor.primaryIndexId) && p.d(this.activeIndexIds, collectionDescriptor.activeIndexIds) && this.indexRetention == collectionDescriptor.indexRetention && p.d(this.extra, collectionDescriptor.extra) && p.d(this.capacityPolicy, collectionDescriptor.capacityPolicy);
    }

    public final List<String> getActiveIndexIds() {
        return this.activeIndexIds;
    }

    public final CapacityPolicy getCapacityPolicy() {
        return this.capacityPolicy;
    }

    public final long getCreatedAtNs() {
        return this.createdAtNs;
    }

    public final StorageDType getDtype() {
        return this.dtype;
    }

    public final String getEmbeddingModel() {
        return this.embeddingModel;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public final String getId() {
        return this.id;
    }

    public final int getIndexRetention() {
        return this.indexRetention;
    }

    public final boolean getInputNormalized() {
        return this.inputNormalized;
    }

    public final DistanceMetric getMetric() {
        return this.metric;
    }

    public final double getPaddingOverheadPercent() {
        int i10 = this.rawDim;
        if (i10 == 0) {
            return 0.0d;
        }
        return ((this.storageDim - i10) * 100.0d) / i10;
    }

    public final String getPrimaryIndexId() {
        return this.primaryIndexId;
    }

    public final int getRawDim() {
        return this.rawDim;
    }

    public final int getStorageDim() {
        return this.storageDim;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.rawDim)) * 31) + Integer.hashCode(this.storageDim)) * 31) + this.metric.hashCode()) * 31) + this.dtype.hashCode()) * 31) + this.embeddingModel.hashCode()) * 31) + Boolean.hashCode(this.inputNormalized)) * 31) + Long.hashCode(this.createdAtNs)) * 31) + Integer.hashCode(this.formatVersion)) * 31;
        String str = this.primaryIndexId;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.activeIndexIds.hashCode()) * 31) + Integer.hashCode(this.indexRetention)) * 31) + this.extra.hashCode()) * 31) + this.capacityPolicy.hashCode();
    }

    public String toString() {
        return "CollectionDescriptor(id=" + this.id + ", rawDim=" + this.rawDim + ", storageDim=" + this.storageDim + ", metric=" + this.metric + ", dtype=" + this.dtype + ", embeddingModel=" + this.embeddingModel + ", inputNormalized=" + this.inputNormalized + ", createdAtNs=" + this.createdAtNs + ", formatVersion=" + this.formatVersion + ", primaryIndexId=" + this.primaryIndexId + ", activeIndexIds=" + this.activeIndexIds + ", indexRetention=" + this.indexRetention + ", extra=" + this.extra + ", capacityPolicy=" + this.capacityPolicy + ")";
    }

    public CollectionDescriptor(String id, int i10, int i11, DistanceMetric metric, StorageDType dtype, String embeddingModel, boolean z10, long j10, int i12, String str, List<String> activeIndexIds, int i13, Map<String, String> extra, CapacityPolicy capacityPolicy) {
        p.i(id, "id");
        p.i(metric, "metric");
        p.i(dtype, "dtype");
        p.i(embeddingModel, "embeddingModel");
        p.i(activeIndexIds, "activeIndexIds");
        p.i(extra, "extra");
        p.i(capacityPolicy, "capacityPolicy");
        this.id = id;
        this.rawDim = i10;
        this.storageDim = i11;
        this.metric = metric;
        this.dtype = dtype;
        this.embeddingModel = embeddingModel;
        this.inputNormalized = z10;
        this.createdAtNs = j10;
        this.formatVersion = i12;
        this.primaryIndexId = str;
        this.activeIndexIds = activeIndexIds;
        this.indexRetention = i13;
        this.extra = extra;
        this.capacityPolicy = capacityPolicy;
        if (!H.x0(id)) {
            Regex regex = ID_REGEX;
            if (!regex.k(id)) {
                throw new IllegalArgumentException(("CollectionDescriptor.id must match " + regex + " (lower_snake_case with optional digits), got '" + id + "'").toString());
            }
            if (i10 <= 0) {
                throw new IllegalArgumentException(("rawDim must be > 0, got " + i10).toString());
            }
            if (i11 >= i10) {
                if (i11 % 64 == 0) {
                    if (H.x0(embeddingModel)) {
                        throw new IllegalArgumentException("embeddingModel must be non-blank; use 'unknown@v0' as placeholder if truly unknown");
                    }
                    if (i13 < 1) {
                        throw new IllegalArgumentException(("indexRetention must be >= 1, got " + i13).toString());
                    }
                    if (i12 == 1) {
                        if (str == null || activeIndexIds.contains(str)) {
                            return;
                        }
                        throw new IllegalArgumentException(("primaryIndexId '" + str + "' must be in activeIndexIds " + activeIndexIds).toString());
                    }
                    throw new IllegalArgumentException(("unsupported CollectionDescriptor formatVersion " + i12 + " (current=1)").toString());
                }
                throw new IllegalArgumentException(("storageDim must be aligned to 64, got " + i11).toString());
            }
            throw new IllegalArgumentException(("storageDim (" + i11 + ") must be >= rawDim (" + i10 + ")").toString());
        }
        throw new IllegalArgumentException("CollectionDescriptor.id must be non-blank");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CollectionDescriptor(String str, int i10, int i11, DistanceMetric distanceMetric, StorageDType storageDType, String str2, boolean z10, long j10, int i12, String str3, List list, int i13, Map map, CapacityPolicy capacityPolicy, int i14, i iVar) {
        int i15;
        int iAlignDim$default;
        if ((i14 & 4) != 0) {
            i15 = i10;
            iAlignDim$default = Companion.alignDim$default(INSTANCE, i15, 0, 2, null);
        } else {
            i15 = i10;
            iAlignDim$default = i11;
        }
        this(str, i15, iAlignDim$default, distanceMetric, (i14 & 16) != 0 ? StorageDType.FP32 : storageDType, str2, (i14 & 64) != 0 ? false : z10, (i14 & 128) != 0 ? System.nanoTime() : j10, (i14 & 256) != 0 ? 1 : i12, (i14 & 512) != 0 ? null : str3, (i14 & 1024) != 0 ? C1173v.m() : list, (i14 & 2048) != 0 ? 2 : i13, (i14 & 4096) != 0 ? a.i() : map, (i14 & b.THRESHOLD) != 0 ? CapacityPolicy.INSTANCE.a() : capacityPolicy);
    }
}
