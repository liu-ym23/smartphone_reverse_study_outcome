package com.stepos.datacenter.core.storage;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import lb.l;
import ob.d;
import pb.C5089c0;
import pb.C5101i0;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u00020>Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000e\u0010\u000fBs\b\u0010\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u000e\u0010\u0013J'\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u001c\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\tHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010&J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003¢\u0006\u0004\b'\u0010$Jp\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tHÆ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b*\u0010 J\u0010\u0010+\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b+\u0010\"J\u001a\u0010.\u001a\u00020-2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b.\u0010/R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u00101\u001a\u0004\b3\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001e\u00104\u001a\u0004\b5\u0010 R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u001f\u00106\u001a\u0004\b7\u0010\"R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010$R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010:\u001a\u0004\b;\u0010&R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t8\u0006¢\u0006\f\n\u0004\b%\u00108\u001a\u0004\b<\u0010$¨\u0006?"}, d2 = {"Lcom/stepos/datacenter/core/storage/DataCenterManifest;", "", "", "epoch", "createdAtNs", "", "engineVersion", "", "formatVersion", "", "Lcom/stepos/datacenter/core/storage/ComponentEpoch;", "components", "previousEpoch", "extra", "<init>", "(JJLjava/lang/String;ILjava/util/Map;Ljava/lang/Long;Ljava/util/Map;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IJJLjava/lang/String;ILjava/util/Map;Ljava/lang/Long;Ljava/util/Map;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "r", "(Lcom/stepos/datacenter/core/storage/DataCenterManifest;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", Const.INTENT_KEY_PKGNAME, "()J", "c", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "e", "()I", "f", "()Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(JJLjava/lang/String;ILjava/util/Map;Ljava/lang/Long;Ljava/util/Map;)Lcom/stepos/datacenter/core/storage/DataCenterManifest;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "n", "l", "Ljava/lang/String;", "m", "I", "p", "Ljava/util/Map;", "k", "Ljava/lang/Long;", "q", "o", "Companion", "$serializer", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class DataCenterManifest {
    private static final KSerializer<Object>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int FORMAT_VERSION = 1;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long epoch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long createdAtNs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String engineVersion;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int formatVersion;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final Map<String, ComponentEpoch> components;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final Long previousEpoch;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final Map<String, String> extra;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/datacenter/core/storage/DataCenterManifest$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/core/storage/DataCenterManifest;", "serializer", "()Lkotlinx/serialization/KSerializer;", "", "FORMAT_VERSION", "I", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.DataCenterManifest$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<DataCenterManifest> serializer() {
            return DataCenterManifest$$serializer.INSTANCE;
        }

        public Companion() {
        }
    }

    static {
        Y0 y02 = Y0.f38329a;
        $childSerializers = new KSerializer[]{null, null, null, null, new C5089c0(y02, ComponentEpoch$$serializer.INSTANCE), null, new C5089c0(y02, y02)};
    }

    public /* synthetic */ DataCenterManifest(int i10, long j10, long j11, String str, int i11, Map map, Long l10, Map map2, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, DataCenterManifest$$serializer.INSTANCE.getDescriptor());
        }
        this.epoch = j10;
        this.createdAtNs = j11;
        this.engineVersion = str;
        if ((i10 & 8) == 0) {
            this.formatVersion = 1;
        } else {
            this.formatVersion = i11;
        }
        if ((i10 & 16) == 0) {
            this.components = kotlin.collections.a.i();
        } else {
            this.components = map;
        }
        if ((i10 & 32) == 0) {
            this.previousEpoch = null;
        } else {
            this.previousEpoch = l10;
        }
        if ((i10 & 64) == 0) {
            this.extra = kotlin.collections.a.i();
        } else {
            this.extra = map2;
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(("epoch must be non-negative, got " + j10).toString());
        }
        int i12 = this.formatVersion;
        if (i12 != 1) {
            throw new IllegalArgumentException(("manifest formatVersion " + i12 + " not supported (current=1); run migration").toString());
        }
        Long l11 = this.previousEpoch;
        if (l11 != null) {
            long jLongValue = l11.longValue();
            if (jLongValue < j10) {
                return;
            }
            throw new IllegalArgumentException(("previousEpoch " + jLongValue + " must be strictly less than epoch " + j10).toString());
        }
    }

    public static /* synthetic */ DataCenterManifest j(DataCenterManifest dataCenterManifest, long j10, long j11, String str, int i10, Map map, Long l10, Map map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = dataCenterManifest.epoch;
        }
        long j12 = j10;
        if ((i11 & 2) != 0) {
            j11 = dataCenterManifest.createdAtNs;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            str = dataCenterManifest.engineVersion;
        }
        return dataCenterManifest.i(j12, j13, str, (i11 & 8) != 0 ? dataCenterManifest.formatVersion : i10, (i11 & 16) != 0 ? dataCenterManifest.components : map, (i11 & 32) != 0 ? dataCenterManifest.previousEpoch : l10, (i11 & 64) != 0 ? dataCenterManifest.extra : map2);
    }

    public static final /* synthetic */ void r(DataCenterManifest self, d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.C(serialDesc, 0, self.epoch);
        output.C(serialDesc, 1, self.createdAtNs);
        output.w(serialDesc, 2, self.engineVersion);
        if (output.y(serialDesc, 3) || self.formatVersion != 1) {
            output.t(serialDesc, 3, self.formatVersion);
        }
        if (output.y(serialDesc, 4) || !p.d(self.components, kotlin.collections.a.i())) {
            output.x(serialDesc, 4, kSerializerArr[4], self.components);
        }
        if (output.y(serialDesc, 5) || self.previousEpoch != null) {
            output.k(serialDesc, 5, C5101i0.f38365a, self.previousEpoch);
        }
        if (!output.y(serialDesc, 6) && p.d(self.extra, kotlin.collections.a.i())) {
            return;
        }
        output.x(serialDesc, 6, kSerializerArr[6], self.extra);
    }

    /* renamed from: b, reason: from getter */
    public final long getEpoch() {
        return this.epoch;
    }

    /* renamed from: c, reason: from getter */
    public final long getCreatedAtNs() {
        return this.createdAtNs;
    }

    /* renamed from: d, reason: from getter */
    public final String getEngineVersion() {
        return this.engineVersion;
    }

    /* renamed from: e, reason: from getter */
    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCenterManifest)) {
            return false;
        }
        DataCenterManifest dataCenterManifest = (DataCenterManifest) other;
        return this.epoch == dataCenterManifest.epoch && this.createdAtNs == dataCenterManifest.createdAtNs && p.d(this.engineVersion, dataCenterManifest.engineVersion) && this.formatVersion == dataCenterManifest.formatVersion && p.d(this.components, dataCenterManifest.components) && p.d(this.previousEpoch, dataCenterManifest.previousEpoch) && p.d(this.extra, dataCenterManifest.extra);
    }

    public final Map<String, ComponentEpoch> f() {
        return this.components;
    }

    /* renamed from: g, reason: from getter */
    public final Long getPreviousEpoch() {
        return this.previousEpoch;
    }

    public final Map<String, String> h() {
        return this.extra;
    }

    public int hashCode() {
        int iHashCode = ((((((((Long.hashCode(this.epoch) * 31) + Long.hashCode(this.createdAtNs)) * 31) + this.engineVersion.hashCode()) * 31) + Integer.hashCode(this.formatVersion)) * 31) + this.components.hashCode()) * 31;
        Long l10 = this.previousEpoch;
        return ((iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31) + this.extra.hashCode();
    }

    public final DataCenterManifest i(long epoch, long createdAtNs, String engineVersion, int formatVersion, Map<String, ComponentEpoch> components, Long previousEpoch, Map<String, String> extra) {
        p.i(engineVersion, "engineVersion");
        p.i(components, "components");
        p.i(extra, "extra");
        return new DataCenterManifest(epoch, createdAtNs, engineVersion, formatVersion, components, previousEpoch, extra);
    }

    public final Map<String, ComponentEpoch> k() {
        return this.components;
    }

    public final long l() {
        return this.createdAtNs;
    }

    public final String m() {
        return this.engineVersion;
    }

    public final long n() {
        return this.epoch;
    }

    public final Map<String, String> o() {
        return this.extra;
    }

    public final int p() {
        return this.formatVersion;
    }

    public final Long q() {
        return this.previousEpoch;
    }

    public String toString() {
        return "DataCenterManifest(epoch=" + this.epoch + ", createdAtNs=" + this.createdAtNs + ", engineVersion=" + this.engineVersion + ", formatVersion=" + this.formatVersion + ", components=" + this.components + ", previousEpoch=" + this.previousEpoch + ", extra=" + this.extra + ")";
    }

    public DataCenterManifest(long j10, long j11, String engineVersion, int i10, Map<String, ComponentEpoch> components, Long l10, Map<String, String> extra) {
        p.i(engineVersion, "engineVersion");
        p.i(components, "components");
        p.i(extra, "extra");
        this.epoch = j10;
        this.createdAtNs = j11;
        this.engineVersion = engineVersion;
        this.formatVersion = i10;
        this.components = components;
        this.previousEpoch = l10;
        this.extra = extra;
        if (j10 < 0) {
            throw new IllegalArgumentException(("epoch must be non-negative, got " + j10).toString());
        }
        if (i10 != 1) {
            throw new IllegalArgumentException(("manifest formatVersion " + i10 + " not supported (current=1); run migration").toString());
        }
        if (l10 != null) {
            long jLongValue = l10.longValue();
            if (jLongValue < j10) {
                return;
            }
            throw new IllegalArgumentException(("previousEpoch " + jLongValue + " must be strictly less than epoch " + j10).toString());
        }
    }

    public /* synthetic */ DataCenterManifest(long j10, long j11, String str, int i10, Map map, Long l10, Map map2, int i11, i iVar) {
        this(j10, j11, str, (i11 & 8) != 0 ? 1 : i10, (i11 & 16) != 0 ? kotlin.collections.a.i() : map, (i11 & 32) != 0 ? null : l10, (i11 & 64) != 0 ? kotlin.collections.a.i() : map2);
    }
}
