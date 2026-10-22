package com.stepos.datacenter.vector;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import lb.l;
import ob.d;
import pb.T0;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002$*B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0016J.\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\"\u001a\u00020!2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010%\u001a\u0004\b'\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010%\u001a\u0004\b(\u0010\u0016¨\u0006+"}, d2 = {"Lcom/stepos/datacenter/vector/CapacityPolicy;", "", "", "initialBytes", "stepBytes", "maxBytes", "<init>", "(JJJ)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IJJJLpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/datacenter/vector/CapacityPolicy;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", Const.INTENT_KEY_PKGNAME, "()J", "c", Const.INTENT_KEY_UMID, "e", "(JJJ)Lcom/stepos/datacenter/vector/CapacityPolicy;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Companion", "$serializer", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class CapacityPolicy {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CapacityPolicy DEFAULT = new CapacityPolicy(0, 0, 0, 7, (i) null);
    public static final long USE_NATIVE_DEFAULT = -1;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long initialBytes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long stepBytes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long maxBytes;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/datacenter/vector/CapacityPolicy$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/vector/CapacityPolicy;", "serializer", "()Lkotlinx/serialization/KSerializer;", "DEFAULT", "Lcom/stepos/datacenter/vector/CapacityPolicy;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/datacenter/vector/CapacityPolicy;", "", "USE_NATIVE_DEFAULT", "J", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.vector.CapacityPolicy$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final CapacityPolicy a() {
            return CapacityPolicy.DEFAULT;
        }

        public final KSerializer<CapacityPolicy> serializer() {
            return CapacityPolicy$$serializer.INSTANCE;
        }

        public Companion() {
        }
    }

    public CapacityPolicy() {
        this(0L, 0L, 0L, 7, (i) null);
    }

    public static /* synthetic */ CapacityPolicy f(CapacityPolicy capacityPolicy, long j10, long j11, long j12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = capacityPolicy.initialBytes;
        }
        long j13 = j10;
        if ((i10 & 2) != 0) {
            j11 = capacityPolicy.stepBytes;
        }
        long j14 = j11;
        if ((i10 & 4) != 0) {
            j12 = capacityPolicy.maxBytes;
        }
        return capacityPolicy.e(j13, j14, j12);
    }

    public static final /* synthetic */ void j(CapacityPolicy self, d output, SerialDescriptor serialDesc) {
        if (output.y(serialDesc, 0) || self.initialBytes != -1) {
            output.C(serialDesc, 0, self.initialBytes);
        }
        if (output.y(serialDesc, 1) || self.stepBytes != -1) {
            output.C(serialDesc, 1, self.stepBytes);
        }
        if (!output.y(serialDesc, 2) && self.maxBytes == -1) {
            return;
        }
        output.C(serialDesc, 2, self.maxBytes);
    }

    /* renamed from: b, reason: from getter */
    public final long getInitialBytes() {
        return this.initialBytes;
    }

    /* renamed from: c, reason: from getter */
    public final long getStepBytes() {
        return this.stepBytes;
    }

    /* renamed from: d, reason: from getter */
    public final long getMaxBytes() {
        return this.maxBytes;
    }

    public final CapacityPolicy e(long initialBytes, long stepBytes, long maxBytes) {
        return new CapacityPolicy(initialBytes, stepBytes, maxBytes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CapacityPolicy)) {
            return false;
        }
        CapacityPolicy capacityPolicy = (CapacityPolicy) other;
        return this.initialBytes == capacityPolicy.initialBytes && this.stepBytes == capacityPolicy.stepBytes && this.maxBytes == capacityPolicy.maxBytes;
    }

    public final long g() {
        return this.initialBytes;
    }

    public final long h() {
        return this.maxBytes;
    }

    public int hashCode() {
        return (((Long.hashCode(this.initialBytes) * 31) + Long.hashCode(this.stepBytes)) * 31) + Long.hashCode(this.maxBytes);
    }

    public final long i() {
        return this.stepBytes;
    }

    public String toString() {
        return "CapacityPolicy(initialBytes=" + this.initialBytes + ", stepBytes=" + this.stepBytes + ", maxBytes=" + this.maxBytes + ")";
    }

    public /* synthetic */ CapacityPolicy(int i10, long j10, long j11, long j12, T0 t02) {
        if ((i10 & 1) == 0) {
            this.initialBytes = -1L;
        } else {
            this.initialBytes = j10;
        }
        if ((i10 & 2) == 0) {
            this.stepBytes = -1L;
        } else {
            this.stepBytes = j11;
        }
        if ((i10 & 4) == 0) {
            this.maxBytes = -1L;
        } else {
            this.maxBytes = j12;
        }
        long j13 = this.stepBytes;
        if (j13 != -1 && j13 <= 0) {
            throw new IllegalArgumentException(("stepBytes must be positive, got " + j13).toString());
        }
        long j14 = this.initialBytes;
        if (j14 != -1 && j14 < 0) {
            throw new IllegalArgumentException(("initialBytes must be >= 0, got " + j14).toString());
        }
        if (j13 != -1) {
            long j15 = this.maxBytes;
            if (j15 != -1 && j15 < j13) {
                throw new IllegalArgumentException(("maxBytes (" + j15 + ") must be >= stepBytes (" + j13 + ")").toString());
            }
        }
        if (j14 != -1) {
            long j16 = this.maxBytes;
            if (j16 == -1 || j14 <= j16) {
                return;
            }
            throw new IllegalArgumentException(("initialBytes (" + j14 + ") must be <= maxBytes (" + j16 + ")").toString());
        }
    }

    public CapacityPolicy(long j10, long j11, long j12) {
        this.initialBytes = j10;
        this.stepBytes = j11;
        this.maxBytes = j12;
        if (j11 != -1 && j11 <= 0) {
            throw new IllegalArgumentException(("stepBytes must be positive, got " + j11).toString());
        }
        if (j10 != -1 && j10 < 0) {
            throw new IllegalArgumentException(("initialBytes must be >= 0, got " + j10).toString());
        }
        if (j11 != -1 && j12 != -1 && j12 < j11) {
            throw new IllegalArgumentException(("maxBytes (" + j12 + ") must be >= stepBytes (" + j11 + ")").toString());
        }
        if (j10 == -1 || j12 == -1 || j10 <= j12) {
            return;
        }
        throw new IllegalArgumentException(("initialBytes (" + j10 + ") must be <= maxBytes (" + j12 + ")").toString());
    }

    public /* synthetic */ CapacityPolicy(long j10, long j11, long j12, int i10, i iVar) {
        this((i10 & 1) != 0 ? -1L : j10, (i10 & 2) != 0 ? -1L : j11, (i10 & 4) != 0 ? -1L : j12);
    }
}
