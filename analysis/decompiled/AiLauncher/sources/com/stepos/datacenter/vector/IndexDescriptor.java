package com.stepos.datacenter.vector;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
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
import pb.C5101i0;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0087\b\u0018\u0000 ^2\u00020\u0001:\u0002_`B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016B\u009b\u0001\b\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0015\u0010\u001aJ'\u0010#\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b!\u0010\"J\u001f\u0010&\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020\u000b¢\u0006\u0004\b&\u0010'J\u001f\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u000b¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0010¢\u0006\u0004\b,\u0010-J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010/J\u0010\u00101\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b7\u00108J\u0012\u00109\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b9\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b;\u0010:J\u0012\u0010<\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b<\u0010:J\u0010\u0010=\u001a\u00020\u0010HÆ\u0003¢\u0006\u0004\b=\u0010>J\u001c\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0012HÆ\u0003¢\u0006\u0004\b?\u0010@J\u0012\u0010A\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bA\u0010/J\u009c\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bD\u0010/J\u0010\u0010E\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\bE\u0010>J\u001a\u0010H\u001a\u00020G2\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bH\u0010IR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010J\u001a\u0004\bK\u0010/R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010J\u001a\u0004\bL\u0010/R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010M\u001a\u0004\bN\u00102R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010O\u001a\u0004\bP\u00104R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010Q\u001a\u0004\bR\u00106R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010S\u001a\u0004\bT\u00108R\u0019\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010U\u001a\u0004\bV\u0010:R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010U\u001a\u0004\bW\u0010:R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\u000f\u0010U\u001a\u0004\bX\u0010:R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010Y\u001a\u0004\bZ\u0010>R#\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010[\u001a\u0004\b\\\u0010@R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010J\u001a\u0004\b]\u0010/¨\u0006a"}, d2 = {"Lcom/stepos/datacenter/vector/IndexDescriptor;", "", "", "id", "collectionId", "Lcom/stepos/datacenter/vector/IndexType;", "type", "Lcom/stepos/datacenter/vector/StorageDType;", "dtype", "Lcom/stepos/datacenter/vector/IndexLifecycle;", VoiceWakeupReceiver.EXTRA_STATE, "", "createdAtNs", "readyAtNs", "promotedAtNs", "builtFromEpoch", "", "progressPermille", "", "params", "failReason", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/datacenter/vector/IndexType;Lcom/stepos/datacenter/vector/StorageDType;Lcom/stepos/datacenter/vector/IndexLifecycle;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ILjava/util/Map;Ljava/lang/String;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lcom/stepos/datacenter/vector/IndexType;Lcom/stepos/datacenter/vector/StorageDType;Lcom/stepos/datacenter/vector/IndexLifecycle;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ILjava/util/Map;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$vector_release", "(Lcom/stepos/datacenter/vector/IndexDescriptor;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "next", "now", "transitionTo", "(Lcom/stepos/datacenter/vector/IndexLifecycle;J)Lcom/stepos/datacenter/vector/IndexDescriptor;", "reason", "markFailed", "(Ljava/lang/String;J)Lcom/stepos/datacenter/vector/IndexDescriptor;", "permille", "withProgress", "(I)Lcom/stepos/datacenter/vector/IndexDescriptor;", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/stepos/datacenter/vector/IndexType;", "component4", "()Lcom/stepos/datacenter/vector/StorageDType;", "component5", "()Lcom/stepos/datacenter/vector/IndexLifecycle;", "component6", "()J", "component7", "()Ljava/lang/Long;", "component8", "component9", "component10", "()I", "component11", "()Ljava/util/Map;", "component12", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/datacenter/vector/IndexType;Lcom/stepos/datacenter/vector/StorageDType;Lcom/stepos/datacenter/vector/IndexLifecycle;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;ILjava/util/Map;Ljava/lang/String;)Lcom/stepos/datacenter/vector/IndexDescriptor;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getCollectionId", "Lcom/stepos/datacenter/vector/IndexType;", "getType", "Lcom/stepos/datacenter/vector/StorageDType;", "getDtype", "Lcom/stepos/datacenter/vector/IndexLifecycle;", "getState", "J", "getCreatedAtNs", "Ljava/lang/Long;", "getReadyAtNs", "getPromotedAtNs", "getBuiltFromEpoch", "I", "getProgressPermille", "Ljava/util/Map;", "getParams", "getFailReason", "Companion", Const.INTENT_KEY_APIKEY, "$serializer", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class IndexDescriptor {
    private static final KSerializer<Object>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex ID_REGEX;
    private final Long builtFromEpoch;
    private final String collectionId;
    private final long createdAtNs;
    private final StorageDType dtype;
    private final String failReason;
    private final String id;
    private final Map<String, String> params;
    private final int progressPermille;
    private final Long promotedAtNs;
    private final Long readyAtNs;
    private final IndexLifecycle state;
    private final IndexType type;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/datacenter/vector/IndexDescriptor$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/IndexDescriptor;", "serializer", "()Lkotlinx/serialization/KSerializer;", "Lkotlin/text/Regex;", "ID_REGEX", "Lkotlin/text/Regex;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.IndexDescriptor$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<IndexDescriptor> serializer() {
            return IndexDescriptor$$serializer.INSTANCE;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30110a;

        static {
            int[] iArr = new int[IndexLifecycle.values().length];
            try {
                iArr[IndexLifecycle.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IndexLifecycle.PRIMARY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IndexLifecycle.DEPRECATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IndexLifecycle.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f30110a = iArr;
        }
    }

    static {
        KSerializer<IndexType> kSerializerSerializer = IndexType.INSTANCE.serializer();
        KSerializer<StorageDType> kSerializerSerializer2 = StorageDType.INSTANCE.serializer();
        KSerializer<IndexLifecycle> kSerializerSerializer3 = IndexLifecycle.INSTANCE.serializer();
        Y0 y02 = Y0.f38329a;
        $childSerializers = new KSerializer[]{null, null, kSerializerSerializer, kSerializerSerializer2, kSerializerSerializer3, null, null, null, null, null, new C5089c0(y02, y02), null};
        ID_REGEX = new Regex("^[A-Za-z][A-Za-z0-9_-]{0,63}$");
    }

    public /* synthetic */ IndexDescriptor(int i10, String str, String str2, IndexType indexType, StorageDType storageDType, IndexLifecycle indexLifecycle, long j10, Long l10, Long l11, Long l12, int i11, Map map, String str3, T0 t02) {
        IndexLifecycle indexLifecycle2;
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, IndexDescriptor$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.collectionId = str2;
        this.type = indexType;
        if ((i10 & 8) == 0) {
            this.dtype = StorageDType.FP32;
        } else {
            this.dtype = storageDType;
        }
        if ((i10 & 16) == 0) {
            this.state = IndexLifecycle.CREATED;
        } else {
            this.state = indexLifecycle;
        }
        if ((i10 & 32) == 0) {
            this.createdAtNs = System.nanoTime();
        } else {
            this.createdAtNs = j10;
        }
        if ((i10 & 64) == 0) {
            this.readyAtNs = null;
        } else {
            this.readyAtNs = l10;
        }
        if ((i10 & 128) == 0) {
            this.promotedAtNs = null;
        } else {
            this.promotedAtNs = l11;
        }
        if ((i10 & 256) == 0) {
            this.builtFromEpoch = null;
        } else {
            this.builtFromEpoch = l12;
        }
        if ((i10 & 512) == 0) {
            this.progressPermille = 0;
        } else {
            this.progressPermille = i11;
        }
        if ((i10 & 1024) == 0) {
            this.params = a.i();
        } else {
            this.params = map;
        }
        if ((i10 & 2048) == 0) {
            this.failReason = null;
        } else {
            this.failReason = str3;
        }
        if (H.x0(str)) {
            throw new IllegalArgumentException("IndexDescriptor.id must be non-blank");
        }
        Regex regex = ID_REGEX;
        if (!regex.k(str)) {
            throw new IllegalArgumentException(("IndexDescriptor.id must match " + regex + ", got '" + str + "'").toString());
        }
        if (H.x0(str2)) {
            throw new IllegalArgumentException("collectionId must be non-blank");
        }
        int i12 = this.progressPermille;
        if (i12 < 0 || i12 >= 1001) {
            throw new IllegalArgumentException(("progressPermille must be in [0, 1000], got " + i12).toString());
        }
        IndexLifecycle indexLifecycle3 = this.state;
        if ((indexLifecycle3 == IndexLifecycle.READY || indexLifecycle3 == IndexLifecycle.PRIMARY || indexLifecycle3 == IndexLifecycle.DEPRECATED) && this.readyAtNs == null) {
            throw new IllegalArgumentException(("state=" + indexLifecycle3 + " requires readyAtNs to be set").toString());
        }
        if (indexLifecycle3 == IndexLifecycle.FAILED) {
            String str4 = this.failReason;
            if (str4 == null || H.x0(str4)) {
                throw new IllegalArgumentException("state=FAILED requires non-blank failReason");
            }
        } else if (this.failReason != null) {
            throw new IllegalArgumentException(("state=" + indexLifecycle3 + " must not carry failReason (only FAILED can)").toString());
        }
        if (this.promotedAtNs == null || (indexLifecycle2 = this.state) == IndexLifecycle.PRIMARY || indexLifecycle2 == IndexLifecycle.DEPRECATED) {
            return;
        }
        throw new IllegalArgumentException(("promotedAtNs only meaningful when state=PRIMARY or DEPRECATED, got " + indexLifecycle2).toString());
    }

    public static /* synthetic */ IndexDescriptor copy$default(IndexDescriptor indexDescriptor, String str, String str2, IndexType indexType, StorageDType storageDType, IndexLifecycle indexLifecycle, long j10, Long l10, Long l11, Long l12, int i10, Map map, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = indexDescriptor.id;
        }
        return indexDescriptor.copy(str, (i11 & 2) != 0 ? indexDescriptor.collectionId : str2, (i11 & 4) != 0 ? indexDescriptor.type : indexType, (i11 & 8) != 0 ? indexDescriptor.dtype : storageDType, (i11 & 16) != 0 ? indexDescriptor.state : indexLifecycle, (i11 & 32) != 0 ? indexDescriptor.createdAtNs : j10, (i11 & 64) != 0 ? indexDescriptor.readyAtNs : l10, (i11 & 128) != 0 ? indexDescriptor.promotedAtNs : l11, (i11 & 256) != 0 ? indexDescriptor.builtFromEpoch : l12, (i11 & 512) != 0 ? indexDescriptor.progressPermille : i10, (i11 & 1024) != 0 ? indexDescriptor.params : map, (i11 & 2048) != 0 ? indexDescriptor.failReason : str3);
    }

    public static /* synthetic */ IndexDescriptor markFailed$default(IndexDescriptor indexDescriptor, String str, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = System.nanoTime();
        }
        return indexDescriptor.markFailed(str, j10);
    }

    public static /* synthetic */ IndexDescriptor transitionTo$default(IndexDescriptor indexDescriptor, IndexLifecycle indexLifecycle, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = System.nanoTime();
        }
        return indexDescriptor.transitionTo(indexLifecycle, j10);
    }

    public static final /* synthetic */ void write$Self$vector_release(IndexDescriptor self, d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.w(serialDesc, 0, self.id);
        output.w(serialDesc, 1, self.collectionId);
        output.x(serialDesc, 2, kSerializerArr[2], self.type);
        if (output.y(serialDesc, 3) || self.dtype != StorageDType.FP32) {
            output.x(serialDesc, 3, kSerializerArr[3], self.dtype);
        }
        if (output.y(serialDesc, 4) || self.state != IndexLifecycle.CREATED) {
            output.x(serialDesc, 4, kSerializerArr[4], self.state);
        }
        if (output.y(serialDesc, 5) || self.createdAtNs != System.nanoTime()) {
            output.C(serialDesc, 5, self.createdAtNs);
        }
        if (output.y(serialDesc, 6) || self.readyAtNs != null) {
            output.k(serialDesc, 6, C5101i0.f38365a, self.readyAtNs);
        }
        if (output.y(serialDesc, 7) || self.promotedAtNs != null) {
            output.k(serialDesc, 7, C5101i0.f38365a, self.promotedAtNs);
        }
        if (output.y(serialDesc, 8) || self.builtFromEpoch != null) {
            output.k(serialDesc, 8, C5101i0.f38365a, self.builtFromEpoch);
        }
        if (output.y(serialDesc, 9) || self.progressPermille != 0) {
            output.t(serialDesc, 9, self.progressPermille);
        }
        if (output.y(serialDesc, 10) || !p.d(self.params, a.i())) {
            output.x(serialDesc, 10, kSerializerArr[10], self.params);
        }
        if (!output.y(serialDesc, 11) && self.failReason == null) {
            return;
        }
        output.k(serialDesc, 11, Y0.f38329a, self.failReason);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getProgressPermille() {
        return this.progressPermille;
    }

    public final Map<String, String> component11() {
        return this.params;
    }

    /* renamed from: component12, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCollectionId() {
        return this.collectionId;
    }

    /* renamed from: component3, reason: from getter */
    public final IndexType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final StorageDType getDtype() {
        return this.dtype;
    }

    /* renamed from: component5, reason: from getter */
    public final IndexLifecycle getState() {
        return this.state;
    }

    /* renamed from: component6, reason: from getter */
    public final long getCreatedAtNs() {
        return this.createdAtNs;
    }

    /* renamed from: component7, reason: from getter */
    public final Long getReadyAtNs() {
        return this.readyAtNs;
    }

    /* renamed from: component8, reason: from getter */
    public final Long getPromotedAtNs() {
        return this.promotedAtNs;
    }

    /* renamed from: component9, reason: from getter */
    public final Long getBuiltFromEpoch() {
        return this.builtFromEpoch;
    }

    public final IndexDescriptor copy(String id, String collectionId, IndexType type, StorageDType dtype, IndexLifecycle state, long createdAtNs, Long readyAtNs, Long promotedAtNs, Long builtFromEpoch, int progressPermille, Map<String, String> params, String failReason) {
        p.i(id, "id");
        p.i(collectionId, "collectionId");
        p.i(type, "type");
        p.i(dtype, "dtype");
        p.i(state, "state");
        p.i(params, "params");
        return new IndexDescriptor(id, collectionId, type, dtype, state, createdAtNs, readyAtNs, promotedAtNs, builtFromEpoch, progressPermille, params, failReason);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexDescriptor)) {
            return false;
        }
        IndexDescriptor indexDescriptor = (IndexDescriptor) other;
        return p.d(this.id, indexDescriptor.id) && p.d(this.collectionId, indexDescriptor.collectionId) && this.type == indexDescriptor.type && this.dtype == indexDescriptor.dtype && this.state == indexDescriptor.state && this.createdAtNs == indexDescriptor.createdAtNs && p.d(this.readyAtNs, indexDescriptor.readyAtNs) && p.d(this.promotedAtNs, indexDescriptor.promotedAtNs) && p.d(this.builtFromEpoch, indexDescriptor.builtFromEpoch) && this.progressPermille == indexDescriptor.progressPermille && p.d(this.params, indexDescriptor.params) && p.d(this.failReason, indexDescriptor.failReason);
    }

    public final Long getBuiltFromEpoch() {
        return this.builtFromEpoch;
    }

    public final String getCollectionId() {
        return this.collectionId;
    }

    public final long getCreatedAtNs() {
        return this.createdAtNs;
    }

    public final StorageDType getDtype() {
        return this.dtype;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, String> getParams() {
        return this.params;
    }

    public final int getProgressPermille() {
        return this.progressPermille;
    }

    public final Long getPromotedAtNs() {
        return this.promotedAtNs;
    }

    public final Long getReadyAtNs() {
        return this.readyAtNs;
    }

    public final IndexLifecycle getState() {
        return this.state;
    }

    public final IndexType getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.id.hashCode() * 31) + this.collectionId.hashCode()) * 31) + this.type.hashCode()) * 31) + this.dtype.hashCode()) * 31) + this.state.hashCode()) * 31) + Long.hashCode(this.createdAtNs)) * 31;
        Long l10 = this.readyAtNs;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.promotedAtNs;
        int iHashCode3 = (iHashCode2 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.builtFromEpoch;
        int iHashCode4 = (((((iHashCode3 + (l12 == null ? 0 : l12.hashCode())) * 31) + Integer.hashCode(this.progressPermille)) * 31) + this.params.hashCode()) * 31;
        String str = this.failReason;
        return iHashCode4 + (str != null ? str.hashCode() : 0);
    }

    public final IndexDescriptor markFailed(String reason, long now) {
        p.i(reason, "reason");
        IndexLifecycle indexLifecycle = this.state;
        IndexLifecycle indexLifecycle2 = IndexLifecycle.FAILED;
        if (indexLifecycle.canTransitionTo(indexLifecycle2)) {
            if (H.x0(reason)) {
                throw new IllegalArgumentException("failReason must be non-blank");
            }
            return copy$default(this, null, null, null, null, indexLifecycle2, 0L, null, null, null, 0, null, reason, ReportUtil.EXCEPTION_CODE_CREATEAPSREQ, null);
        }
        throw new IllegalStateException(("illegal transition for index '" + this.id + "': " + this.state + " → FAILED").toString());
    }

    public String toString() {
        return "IndexDescriptor(id=" + this.id + ", collectionId=" + this.collectionId + ", type=" + this.type + ", dtype=" + this.dtype + ", state=" + this.state + ", createdAtNs=" + this.createdAtNs + ", readyAtNs=" + this.readyAtNs + ", promotedAtNs=" + this.promotedAtNs + ", builtFromEpoch=" + this.builtFromEpoch + ", progressPermille=" + this.progressPermille + ", params=" + this.params + ", failReason=" + this.failReason + ")";
    }

    public final IndexDescriptor transitionTo(IndexLifecycle next, long now) {
        p.i(next, "next");
        if (this.state.canTransitionTo(next)) {
            int i10 = b.f30110a[next.ordinal()];
            if (i10 == 1) {
                Long l10 = this.readyAtNs;
                return copy$default(this, null, null, null, null, next, 0L, Long.valueOf(l10 != null ? l10.longValue() : now), null, null, 0, null, null, 4015, null);
            }
            if (i10 == 2) {
                return copy$default(this, null, null, null, null, next, 0L, null, Long.valueOf(now), null, 0, null, null, 3951, null);
            }
            if (i10 != 3 && i10 == 4) {
                return copy$default(this, null, null, null, null, next, 0L, null, null, null, 0, null, null, 4079, null);
            }
            return copy$default(this, null, null, null, null, next, 0L, null, null, null, 0, null, null, 4079, null);
        }
        throw new IllegalStateException(("illegal transition for index '" + this.id + "': " + this.state + " → " + next).toString());
    }

    public final IndexDescriptor withProgress(int permille) {
        IndexLifecycle indexLifecycle = this.state;
        if (indexLifecycle != IndexLifecycle.TRAINING && indexLifecycle != IndexLifecycle.CATCHING_UP) {
            throw new IllegalStateException(("progress is only meaningful in TRAINING / CATCHING_UP, not " + indexLifecycle).toString());
        }
        if (permille >= 0 && permille < 1001) {
            return copy$default(this, null, null, null, null, null, 0L, null, null, null, permille, null, null, 3583, null);
        }
        throw new IllegalArgumentException(("permille out of range: " + permille).toString());
    }

    public IndexDescriptor(String id, String collectionId, IndexType type, StorageDType dtype, IndexLifecycle state, long j10, Long l10, Long l11, Long l12, int i10, Map<String, String> params, String str) {
        p.i(id, "id");
        p.i(collectionId, "collectionId");
        p.i(type, "type");
        p.i(dtype, "dtype");
        p.i(state, "state");
        p.i(params, "params");
        this.id = id;
        this.collectionId = collectionId;
        this.type = type;
        this.dtype = dtype;
        this.state = state;
        this.createdAtNs = j10;
        this.readyAtNs = l10;
        this.promotedAtNs = l11;
        this.builtFromEpoch = l12;
        this.progressPermille = i10;
        this.params = params;
        this.failReason = str;
        if (!H.x0(id)) {
            Regex regex = ID_REGEX;
            if (regex.k(id)) {
                if (H.x0(collectionId)) {
                    throw new IllegalArgumentException("collectionId must be non-blank");
                }
                if (i10 >= 0 && i10 < 1001) {
                    if ((state != IndexLifecycle.READY && state != IndexLifecycle.PRIMARY && state != IndexLifecycle.DEPRECATED) || l10 != null) {
                        if (state == IndexLifecycle.FAILED) {
                            if (str == null || H.x0(str)) {
                                throw new IllegalArgumentException("state=FAILED requires non-blank failReason");
                            }
                        } else if (str != null) {
                            throw new IllegalArgumentException(("state=" + state + " must not carry failReason (only FAILED can)").toString());
                        }
                        if (l11 == null || state == IndexLifecycle.PRIMARY || state == IndexLifecycle.DEPRECATED) {
                            return;
                        }
                        throw new IllegalArgumentException(("promotedAtNs only meaningful when state=PRIMARY or DEPRECATED, got " + state).toString());
                    }
                    throw new IllegalArgumentException(("state=" + state + " requires readyAtNs to be set").toString());
                }
                throw new IllegalArgumentException(("progressPermille must be in [0, 1000], got " + i10).toString());
            }
            throw new IllegalArgumentException(("IndexDescriptor.id must match " + regex + ", got '" + id + "'").toString());
        }
        throw new IllegalArgumentException("IndexDescriptor.id must be non-blank");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ IndexDescriptor(java.lang.String r17, java.lang.String r18, com.stepos.datacenter.vector.IndexType r19, com.stepos.datacenter.vector.StorageDType r20, com.stepos.datacenter.vector.IndexLifecycle r21, long r22, java.lang.Long r24, java.lang.Long r25, java.lang.Long r26, int r27, java.util.Map r28, java.lang.String r29, int r30, kotlin.jvm.internal.i r31) {
        /*
            r16 = this;
            r0 = r30
            r1 = r0 & 8
            if (r1 == 0) goto La
            com.stepos.datacenter.vector.StorageDType r1 = com.stepos.datacenter.vector.StorageDType.FP32
            r6 = r1
            goto Lc
        La:
            r6 = r20
        Lc:
            r1 = r0 & 16
            if (r1 == 0) goto L14
            com.stepos.datacenter.vector.IndexLifecycle r1 = com.stepos.datacenter.vector.IndexLifecycle.CREATED
            r7 = r1
            goto L16
        L14:
            r7 = r21
        L16:
            r1 = r0 & 32
            if (r1 == 0) goto L20
            long r1 = java.lang.System.nanoTime()
            r8 = r1
            goto L22
        L20:
            r8 = r22
        L22:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L29
            r10 = r2
            goto L2b
        L29:
            r10 = r24
        L2b:
            r1 = r0 & 128(0x80, float:1.8E-43)
            if (r1 == 0) goto L31
            r11 = r2
            goto L33
        L31:
            r11 = r25
        L33:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L39
            r12 = r2
            goto L3b
        L39:
            r12 = r26
        L3b:
            r1 = r0 & 512(0x200, float:7.17E-43)
            if (r1 == 0) goto L42
            r1 = 0
            r13 = r1
            goto L44
        L42:
            r13 = r27
        L44:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L4e
            java.util.Map r1 = kotlin.collections.a.i()
            r14 = r1
            goto L50
        L4e:
            r14 = r28
        L50:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L5e
            r15 = r2
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r16
            goto L68
        L5e:
            r15 = r29
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
        L68:
            r2.<init>(r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.datacenter.vector.IndexDescriptor.<init>(java.lang.String, java.lang.String, com.stepos.datacenter.vector.IndexType, com.stepos.datacenter.vector.StorageDType, com.stepos.datacenter.vector.IndexLifecycle, long, java.lang.Long, java.lang.Long, java.lang.Long, int, java.util.Map, java.lang.String, int, kotlin.jvm.internal.i):void");
    }
}
