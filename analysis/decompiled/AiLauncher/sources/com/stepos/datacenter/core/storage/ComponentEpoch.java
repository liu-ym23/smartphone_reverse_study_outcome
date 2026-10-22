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
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 72\u00020\u0001:\u00028,BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\f\u0010\rB]\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\f\u0010\u0011J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001bJ\u0010\u0010\u001f\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010!J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nHÆ\u0003¢\u0006\u0004\b\"\u0010#JX\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nHÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b&\u0010\u001dJ\u0010\u0010'\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b'\u0010!J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010/\u001a\u0004\b0\u0010\u001dR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001c\u0010-\u001a\u0004\b1\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010/\u001a\u0004\b2\u0010\u001dR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001f\u00103\u001a\u0004\b4\u0010!R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b6\u0010#¨\u00069"}, d2 = {"Lcom/stepos/datacenter/core/storage/ComponentEpoch;", "", "", "subEpoch", "", "relativePath", "sizeBytes", "crcHex", "", "formatVersion", "", "extra", "<init>", "(JLjava/lang/String;JLjava/lang/String;ILjava/util/Map;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IJLjava/lang/String;JLjava/lang/String;ILjava/util/Map;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "p", "(Lcom/stepos/datacenter/core/storage/ComponentEpoch;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", Const.INTENT_KEY_PKGNAME, "()J", "c", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "e", "f", "()I", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Map;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(JLjava/lang/String;JLjava/lang/String;ILjava/util/Map;)Lcom/stepos/datacenter/core/storage/ComponentEpoch;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "J", "o", "Ljava/lang/String;", "m", "n", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "I", "l", "Ljava/util/Map;", "k", "Companion", "$serializer", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class ComponentEpoch {
    private static final KSerializer<Object>[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long subEpoch;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String relativePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long sizeBytes;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String crcHex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int formatVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final Map<String, String> extra;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/core/storage/ComponentEpoch$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/core/storage/ComponentEpoch;", "serializer", "()Lkotlinx/serialization/KSerializer;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.ComponentEpoch$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<ComponentEpoch> serializer() {
            return ComponentEpoch$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }
    }

    static {
        Y0 y02 = Y0.f38329a;
        $childSerializers = new KSerializer[]{null, null, null, null, null, new C5089c0(y02, y02)};
    }

    public /* synthetic */ ComponentEpoch(int i10, long j10, String str, long j11, String str2, int i11, Map map, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, ComponentEpoch$$serializer.INSTANCE.getDescriptor());
        }
        this.subEpoch = j10;
        this.relativePath = str;
        this.sizeBytes = j11;
        if ((i10 & 8) == 0) {
            this.crcHex = "";
        } else {
            this.crcHex = str2;
        }
        if ((i10 & 16) == 0) {
            this.formatVersion = 1;
        } else {
            this.formatVersion = i11;
        }
        if ((i10 & 32) == 0) {
            this.extra = kotlin.collections.a.i();
        } else {
            this.extra = map;
        }
    }

    public static /* synthetic */ ComponentEpoch i(ComponentEpoch componentEpoch, long j10, String str, long j11, String str2, int i10, Map map, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = componentEpoch.subEpoch;
        }
        long j12 = j10;
        if ((i11 & 2) != 0) {
            str = componentEpoch.relativePath;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            j11 = componentEpoch.sizeBytes;
        }
        long j13 = j11;
        if ((i11 & 8) != 0) {
            str2 = componentEpoch.crcHex;
        }
        return componentEpoch.h(j12, str3, j13, str2, (i11 & 16) != 0 ? componentEpoch.formatVersion : i10, (i11 & 32) != 0 ? componentEpoch.extra : map);
    }

    public static final /* synthetic */ void p(ComponentEpoch self, d output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.C(serialDesc, 0, self.subEpoch);
        output.w(serialDesc, 1, self.relativePath);
        output.C(serialDesc, 2, self.sizeBytes);
        if (output.y(serialDesc, 3) || !p.d(self.crcHex, "")) {
            output.w(serialDesc, 3, self.crcHex);
        }
        if (output.y(serialDesc, 4) || self.formatVersion != 1) {
            output.t(serialDesc, 4, self.formatVersion);
        }
        if (!output.y(serialDesc, 5) && p.d(self.extra, kotlin.collections.a.i())) {
            return;
        }
        output.x(serialDesc, 5, kSerializerArr[5], self.extra);
    }

    /* renamed from: b, reason: from getter */
    public final long getSubEpoch() {
        return this.subEpoch;
    }

    /* renamed from: c, reason: from getter */
    public final String getRelativePath() {
        return this.relativePath;
    }

    /* renamed from: d, reason: from getter */
    public final long getSizeBytes() {
        return this.sizeBytes;
    }

    /* renamed from: e, reason: from getter */
    public final String getCrcHex() {
        return this.crcHex;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ComponentEpoch)) {
            return false;
        }
        ComponentEpoch componentEpoch = (ComponentEpoch) other;
        return this.subEpoch == componentEpoch.subEpoch && p.d(this.relativePath, componentEpoch.relativePath) && this.sizeBytes == componentEpoch.sizeBytes && p.d(this.crcHex, componentEpoch.crcHex) && this.formatVersion == componentEpoch.formatVersion && p.d(this.extra, componentEpoch.extra);
    }

    /* renamed from: f, reason: from getter */
    public final int getFormatVersion() {
        return this.formatVersion;
    }

    public final Map<String, String> g() {
        return this.extra;
    }

    public final ComponentEpoch h(long subEpoch, String relativePath, long sizeBytes, String crcHex, int formatVersion, Map<String, String> extra) {
        p.i(relativePath, "relativePath");
        p.i(crcHex, "crcHex");
        p.i(extra, "extra");
        return new ComponentEpoch(subEpoch, relativePath, sizeBytes, crcHex, formatVersion, extra);
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.subEpoch) * 31) + this.relativePath.hashCode()) * 31) + Long.hashCode(this.sizeBytes)) * 31) + this.crcHex.hashCode()) * 31) + Integer.hashCode(this.formatVersion)) * 31) + this.extra.hashCode();
    }

    public final String j() {
        return this.crcHex;
    }

    public final Map<String, String> k() {
        return this.extra;
    }

    public final int l() {
        return this.formatVersion;
    }

    public final String m() {
        return this.relativePath;
    }

    public final long n() {
        return this.sizeBytes;
    }

    public final long o() {
        return this.subEpoch;
    }

    public String toString() {
        return "ComponentEpoch(subEpoch=" + this.subEpoch + ", relativePath=" + this.relativePath + ", sizeBytes=" + this.sizeBytes + ", crcHex=" + this.crcHex + ", formatVersion=" + this.formatVersion + ", extra=" + this.extra + ")";
    }

    public ComponentEpoch(long j10, String relativePath, long j11, String crcHex, int i10, Map<String, String> extra) {
        p.i(relativePath, "relativePath");
        p.i(crcHex, "crcHex");
        p.i(extra, "extra");
        this.subEpoch = j10;
        this.relativePath = relativePath;
        this.sizeBytes = j11;
        this.crcHex = crcHex;
        this.formatVersion = i10;
        this.extra = extra;
    }

    public /* synthetic */ ComponentEpoch(long j10, String str, long j11, String str2, int i10, Map map, int i11, i iVar) {
        this(j10, str, j11, (i11 & 8) != 0 ? "" : str2, (i11 & 16) != 0 ? 1 : i10, (i11 & 32) != 0 ? kotlin.collections.a.i() : map);
    }
}
