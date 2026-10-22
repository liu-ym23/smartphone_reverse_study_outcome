package com.stepos.stepclaw.memory.upload;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000210B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bBE\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\n\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001eJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u001eJB\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b#\u0010\u001cJ\u0010\u0010$\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b$\u0010\u001eJ\u001a\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010\u001eR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b.\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b/\u0010\u001e¨\u00062"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/UploadDoneMark;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "uploaded", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "uploadedAt", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "totalFiles", "successCount", "failedCount", "<init>", "(ZLjava/lang/String;III)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IZLjava/lang/String;IIILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/upload/UploadDoneMark;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "()I", "component4", "component5", "copy", "(ZLjava/lang/String;III)Lcom/stepos/stepclaw/memory/upload/UploadDoneMark;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getUploaded", "Ljava/lang/String;", "getUploadedAt", "I", "getTotalFiles", "getSuccessCount", "getFailedCount", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class UploadDoneMark {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int failedCount;
    private final int successCount;
    private final int totalFiles;
    private final boolean uploaded;
    private final String uploadedAt;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/UploadDoneMark$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/upload/UploadDoneMark;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<UploadDoneMark> serializer() {
            return UploadDoneMark$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public UploadDoneMark() {
        this(false, (String) null, 0, 0, 0, 31, (i) null);
    }

    public static /* synthetic */ UploadDoneMark copy$default(UploadDoneMark uploadDoneMark, boolean z, String str, int i8, int i9, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z = uploadDoneMark.uploaded;
        }
        if ((i11 & 2) != 0) {
            str = uploadDoneMark.uploadedAt;
        }
        if ((i11 & 4) != 0) {
            i8 = uploadDoneMark.totalFiles;
        }
        if ((i11 & 8) != 0) {
            i9 = uploadDoneMark.successCount;
        }
        if ((i11 & 16) != 0) {
            i10 = uploadDoneMark.failedCount;
        }
        int i12 = i10;
        int i13 = i8;
        return uploadDoneMark.copy(z, str, i13, i9, i12);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(UploadDoneMark self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.uploaded) {
            output.encodeBooleanElement(serialDesc, 0, self.uploaded);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.uploadedAt, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.uploadedAt);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.totalFiles != 0) {
            output.encodeIntElement(serialDesc, 2, self.totalFiles);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.successCount != 0) {
            output.encodeIntElement(serialDesc, 3, self.successCount);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.failedCount == 0) {
            return;
        }
        output.encodeIntElement(serialDesc, 4, self.failedCount);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getUploaded() {
        return this.uploaded;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUploadedAt() {
        return this.uploadedAt;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTotalFiles() {
        return this.totalFiles;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    /* renamed from: component5, reason: from getter */
    public final int getFailedCount() {
        return this.failedCount;
    }

    public final UploadDoneMark copy(boolean uploaded, String uploadedAt, int totalFiles, int successCount, int failedCount) {
        p.e(uploadedAt, "uploadedAt");
        return new UploadDoneMark(uploaded, uploadedAt, totalFiles, successCount, failedCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadDoneMark)) {
            return false;
        }
        UploadDoneMark uploadDoneMark = (UploadDoneMark) other;
        return this.uploaded == uploadDoneMark.uploaded && p.a(this.uploadedAt, uploadDoneMark.uploadedAt) && this.totalFiles == uploadDoneMark.totalFiles && this.successCount == uploadDoneMark.successCount && this.failedCount == uploadDoneMark.failedCount;
    }

    public final int getFailedCount() {
        return this.failedCount;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }

    public final int getTotalFiles() {
        return this.totalFiles;
    }

    public final boolean getUploaded() {
        return this.uploaded;
    }

    public final String getUploadedAt() {
        return this.uploadedAt;
    }

    public int hashCode() {
        return Integer.hashCode(this.failedCount) + b.C(this.successCount, b.C(this.totalFiles, b.f(Boolean.hashCode(this.uploaded) * 31, 31, this.uploadedAt), 31), 31);
    }

    public String toString() {
        boolean z = this.uploaded;
        String str = this.uploadedAt;
        int i8 = this.totalFiles;
        int i9 = this.successCount;
        int i10 = this.failedCount;
        StringBuilder sb = new StringBuilder("UploadDoneMark(uploaded=");
        sb.append(z);
        sb.append(", uploadedAt=");
        sb.append(str);
        sb.append(", totalFiles=");
        b.z(sb, i8, ", successCount=", i9, ", failedCount=");
        return f.e(sb, i10, ")");
    }

    public /* synthetic */ UploadDoneMark(int i8, boolean z, String str, int i9, int i10, int i11, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.uploaded = false;
        } else {
            this.uploaded = z;
        }
        if ((i8 & 2) == 0) {
            this.uploadedAt = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.uploadedAt = str;
        }
        if ((i8 & 4) == 0) {
            this.totalFiles = 0;
        } else {
            this.totalFiles = i9;
        }
        if ((i8 & 8) == 0) {
            this.successCount = 0;
        } else {
            this.successCount = i10;
        }
        if ((i8 & 16) == 0) {
            this.failedCount = 0;
        } else {
            this.failedCount = i11;
        }
    }

    public UploadDoneMark(boolean z, String uploadedAt, int i8, int i9, int i10) {
        p.e(uploadedAt, "uploadedAt");
        this.uploaded = z;
        this.uploadedAt = uploadedAt;
        this.totalFiles = i8;
        this.successCount = i9;
        this.failedCount = i10;
    }

    public /* synthetic */ UploadDoneMark(boolean z, String str, int i8, int i9, int i10, int i11, i iVar) {
        this((i11 & 1) != 0 ? false : z, (i11 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i11 & 4) != 0 ? 0 : i8, (i11 & 8) != 0 ? 0 : i9, (i11 & 16) != 0 ? 0 : i10);
    }
}
