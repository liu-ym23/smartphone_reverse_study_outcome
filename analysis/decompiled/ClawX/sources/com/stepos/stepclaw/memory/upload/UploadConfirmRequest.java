package com.stepos.stepclaw.memory.upload;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000276BG\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fB_\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0011J'\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001cJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u001cJ\u0010\u0010 \u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001cJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJX\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010\u001cJ\u0010\u0010'\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b'\u0010(J\u001a\u0010+\u001a\u00020*2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010-\u001a\u0004\b/\u0010\u001cR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b0\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010-\u001a\u0004\b1\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00102\u001a\u0004\b3\u0010!R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010-\u001a\u0004\b4\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b5\u0010\u001c¨\u00068"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "objectKey", "platform", "userId", "deviceId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "fileSize", "uploadStatus", ConfigIpcContract.KEY_ERROR_MESSAGE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()J", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getObjectKey", "getPlatform", "getUserId", "getDeviceId", "J", "getFileSize", "getUploadStatus", "getErrorMessage", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class UploadConfirmRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String deviceId;
    private final String errorMessage;
    private final long fileSize;
    private final String objectKey;
    private final String platform;
    private final String uploadStatus;
    private final String userId;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/upload/UploadConfirmRequest;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<UploadConfirmRequest> serializer() {
            return UploadConfirmRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ UploadConfirmRequest(int i8, String str, String str2, String str3, String str4, long j4, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (57 != (i8 & 57)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 57, UploadConfirmRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.objectKey = str;
        if ((i8 & 2) == 0) {
            this.platform = "memory";
        } else {
            this.platform = str2;
        }
        if ((i8 & 4) == 0) {
            this.userId = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.userId = str3;
        }
        this.deviceId = str4;
        this.fileSize = j4;
        this.uploadStatus = str5;
        if ((i8 & 64) == 0) {
            this.errorMessage = null;
        } else {
            this.errorMessage = str6;
        }
    }

    public static /* synthetic */ UploadConfirmRequest copy$default(UploadConfirmRequest uploadConfirmRequest, String str, String str2, String str3, String str4, long j4, String str5, String str6, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = uploadConfirmRequest.objectKey;
        }
        if ((i8 & 2) != 0) {
            str2 = uploadConfirmRequest.platform;
        }
        if ((i8 & 4) != 0) {
            str3 = uploadConfirmRequest.userId;
        }
        if ((i8 & 8) != 0) {
            str4 = uploadConfirmRequest.deviceId;
        }
        if ((i8 & 16) != 0) {
            j4 = uploadConfirmRequest.fileSize;
        }
        if ((i8 & 32) != 0) {
            str5 = uploadConfirmRequest.uploadStatus;
        }
        if ((i8 & 64) != 0) {
            str6 = uploadConfirmRequest.errorMessage;
        }
        long j8 = j4;
        String str7 = str3;
        String str8 = str4;
        return uploadConfirmRequest.copy(str, str2, str7, str8, j8, str5, str6);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(UploadConfirmRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.objectKey);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.platform, "memory")) {
            output.encodeStringElement(serialDesc, 1, self.platform);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !p.a(self.userId, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 2, self.userId);
        }
        output.encodeStringElement(serialDesc, 3, self.deviceId);
        output.encodeLongElement(serialDesc, 4, self.fileSize);
        output.encodeStringElement(serialDesc, 5, self.uploadStatus);
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.errorMessage == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.errorMessage);
    }

    /* renamed from: component1, reason: from getter */
    public final String getObjectKey() {
        return this.objectKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUploadStatus() {
        return this.uploadStatus;
    }

    /* renamed from: component7, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final UploadConfirmRequest copy(String objectKey, String platform, String userId, String deviceId, long fileSize, String uploadStatus, String errorMessage) {
        p.e(objectKey, "objectKey");
        p.e(platform, "platform");
        p.e(userId, "userId");
        p.e(deviceId, "deviceId");
        p.e(uploadStatus, "uploadStatus");
        return new UploadConfirmRequest(objectKey, platform, userId, deviceId, fileSize, uploadStatus, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadConfirmRequest)) {
            return false;
        }
        UploadConfirmRequest uploadConfirmRequest = (UploadConfirmRequest) other;
        return p.a(this.objectKey, uploadConfirmRequest.objectKey) && p.a(this.platform, uploadConfirmRequest.platform) && p.a(this.userId, uploadConfirmRequest.userId) && p.a(this.deviceId, uploadConfirmRequest.deviceId) && this.fileSize == uploadConfirmRequest.fileSize && p.a(this.uploadStatus, uploadConfirmRequest.uploadStatus) && p.a(this.errorMessage, uploadConfirmRequest.errorMessage);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final String getObjectKey() {
        return this.objectKey;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getUploadStatus() {
        return this.uploadStatus;
    }

    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iF = b.f(b.e(b.f(b.f(b.f(this.objectKey.hashCode() * 31, 31, this.platform), 31, this.userId), 31, this.deviceId), 31, this.fileSize), 31, this.uploadStatus);
        String str = this.errorMessage;
        return iF + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.objectKey;
        String str2 = this.platform;
        String str3 = this.userId;
        String str4 = this.deviceId;
        long j4 = this.fileSize;
        String str5 = this.uploadStatus;
        String str6 = this.errorMessage;
        StringBuilder sbV = b.v("UploadConfirmRequest(objectKey=", str, ", platform=", str2, ", userId=");
        b.A(sbV, str3, ", deviceId=", str4, ", fileSize=");
        sbV.append(j4);
        sbV.append(", uploadStatus=");
        sbV.append(str5);
        sbV.append(", errorMessage=");
        sbV.append(str6);
        sbV.append(")");
        return sbV.toString();
    }

    public UploadConfirmRequest(String objectKey, String platform, String userId, String deviceId, long j4, String uploadStatus, String str) {
        p.e(objectKey, "objectKey");
        p.e(platform, "platform");
        p.e(userId, "userId");
        p.e(deviceId, "deviceId");
        p.e(uploadStatus, "uploadStatus");
        this.objectKey = objectKey;
        this.platform = platform;
        this.userId = userId;
        this.deviceId = deviceId;
        this.fileSize = j4;
        this.uploadStatus = uploadStatus;
        this.errorMessage = str;
    }

    public /* synthetic */ UploadConfirmRequest(String str, String str2, String str3, String str4, long j4, String str5, String str6, int i8, i iVar) {
        this(str, (i8 & 2) != 0 ? "memory" : str2, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3, str4, j4, str5, (i8 & 64) != 0 ? null : str6);
    }
}
