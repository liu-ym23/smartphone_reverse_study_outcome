package com.stepos.datacenter.ame;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import lb.l;
import ob.d;
import pb.E0;
import pb.T0;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u0000 02\u00020\u0001:\u00021\u0018B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ'\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJB\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ\u0010\u0010#\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b#\u0010\u001fJ\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b*\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b,\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b-\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010.\u001a\u0004\b/\u0010\u001f¨\u00062"}, d2 = {"Lcom/stepos/datacenter/ame/VectorMetadataRecord;", "", "", "vectorId", "entityId", "", "entityClassName", "label", "", QueryAlgorithmBundle.KEY_CATEGORY, "<init>", "(JJLjava/lang/String;Ljava/lang/String;I)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IJJLjava/lang/String;Ljava/lang/String;ILpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "m", "(Lcom/stepos/datacenter/ame/VectorMetadataRecord;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", Const.INTENT_KEY_APIKEY, "()J", Const.INTENT_KEY_PKGNAME, "c", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "e", "()I", "f", "(JJLjava/lang/String;Ljava/lang/String;I)Lcom/stepos/datacenter/ame/VectorMetadataRecord;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "J", "l", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "k", "I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Companion", "$serializer", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@l
/* loaded from: classes3.dex */
public final /* data */ class VectorMetadataRecord {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long vectorId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long entityId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String entityClassName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String label;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int category;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/datacenter/ame/VectorMetadataRecord$a;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/datacenter/ame/VectorMetadataRecord;", "serializer", "()Lkotlinx/serialization/KSerializer;", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.ame.VectorMetadataRecord$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final KSerializer<VectorMetadataRecord> serializer() {
            return VectorMetadataRecord$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(i iVar) {
            this();
        }
    }

    public /* synthetic */ VectorMetadataRecord(int i10, long j10, long j11, String str, String str2, int i11, T0 t02) {
        if (1 != (i10 & 1)) {
            E0.a(i10, 1, VectorMetadataRecord$$serializer.INSTANCE.getDescriptor());
        }
        this.vectorId = j10;
        if ((i10 & 2) == 0) {
            this.entityId = 0L;
        } else {
            this.entityId = j11;
        }
        if ((i10 & 4) == 0) {
            this.entityClassName = "";
        } else {
            this.entityClassName = str;
        }
        if ((i10 & 8) == 0) {
            this.label = "";
        } else {
            this.label = str2;
        }
        if ((i10 & 16) == 0) {
            this.category = 0;
        } else {
            this.category = i11;
        }
    }

    public static /* synthetic */ VectorMetadataRecord g(VectorMetadataRecord vectorMetadataRecord, long j10, long j11, String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = vectorMetadataRecord.vectorId;
        }
        long j12 = j10;
        if ((i11 & 2) != 0) {
            j11 = vectorMetadataRecord.entityId;
        }
        long j13 = j11;
        if ((i11 & 4) != 0) {
            str = vectorMetadataRecord.entityClassName;
        }
        String str3 = str;
        if ((i11 & 8) != 0) {
            str2 = vectorMetadataRecord.label;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            i10 = vectorMetadataRecord.category;
        }
        return vectorMetadataRecord.f(j12, j13, str3, str4, i10);
    }

    public static final /* synthetic */ void m(VectorMetadataRecord self, d output, SerialDescriptor serialDesc) {
        output.C(serialDesc, 0, self.vectorId);
        if (output.y(serialDesc, 1) || self.entityId != 0) {
            output.C(serialDesc, 1, self.entityId);
        }
        if (output.y(serialDesc, 2) || !p.d(self.entityClassName, "")) {
            output.w(serialDesc, 2, self.entityClassName);
        }
        if (output.y(serialDesc, 3) || !p.d(self.label, "")) {
            output.w(serialDesc, 3, self.label);
        }
        if (!output.y(serialDesc, 4) && self.category == 0) {
            return;
        }
        output.t(serialDesc, 4, self.category);
    }

    /* renamed from: a, reason: from getter */
    public final long getVectorId() {
        return this.vectorId;
    }

    /* renamed from: b, reason: from getter */
    public final long getEntityId() {
        return this.entityId;
    }

    /* renamed from: c, reason: from getter */
    public final String getEntityClassName() {
        return this.entityClassName;
    }

    /* renamed from: d, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: e, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VectorMetadataRecord)) {
            return false;
        }
        VectorMetadataRecord vectorMetadataRecord = (VectorMetadataRecord) other;
        return this.vectorId == vectorMetadataRecord.vectorId && this.entityId == vectorMetadataRecord.entityId && p.d(this.entityClassName, vectorMetadataRecord.entityClassName) && p.d(this.label, vectorMetadataRecord.label) && this.category == vectorMetadataRecord.category;
    }

    public final VectorMetadataRecord f(long vectorId, long entityId, String entityClassName, String label, int category) {
        p.i(entityClassName, "entityClassName");
        p.i(label, "label");
        return new VectorMetadataRecord(vectorId, entityId, entityClassName, label, category);
    }

    public final int h() {
        return this.category;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.vectorId) * 31) + Long.hashCode(this.entityId)) * 31) + this.entityClassName.hashCode()) * 31) + this.label.hashCode()) * 31) + Integer.hashCode(this.category);
    }

    public final String i() {
        return this.entityClassName;
    }

    public final long j() {
        return this.entityId;
    }

    public final String k() {
        return this.label;
    }

    public final long l() {
        return this.vectorId;
    }

    public String toString() {
        return "VectorMetadataRecord(vectorId=" + this.vectorId + ", entityId=" + this.entityId + ", entityClassName=" + this.entityClassName + ", label=" + this.label + ", category=" + this.category + ")";
    }

    public VectorMetadataRecord(long j10, long j11, String entityClassName, String label, int i10) {
        p.i(entityClassName, "entityClassName");
        p.i(label, "label");
        this.vectorId = j10;
        this.entityId = j11;
        this.entityClassName = entityClassName;
        this.label = label;
        this.category = i10;
    }

    public /* synthetic */ VectorMetadataRecord(long j10, long j11, String str, String str2, int i10, int i11, i iVar) {
        this(j10, (i11 & 2) != 0 ? 0L : j11, (i11 & 4) != 0 ? "" : str, (i11 & 8) != 0 ? "" : str2, (i11 & 16) != 0 ? 0 : i10);
    }
}
