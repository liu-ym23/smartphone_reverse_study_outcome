package com.stepos.stepclaw.memory.upload;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/FileUploadResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "objectKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_SUCCESS, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, ConfigIpcContract.KEY_ERROR_MESSAGE, "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "getObjectKey", "()Ljava/lang/String;", "getSuccess", "()Z", "getErrorMessage", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class FileUploadResult {
    private final String errorMessage;
    private final String objectKey;
    private final boolean success;

    public FileUploadResult(String objectKey, boolean z, String str) {
        p.e(objectKey, "objectKey");
        this.objectKey = objectKey;
        this.success = z;
        this.errorMessage = str;
    }

    public static /* synthetic */ FileUploadResult copy$default(FileUploadResult fileUploadResult, String str, boolean z, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = fileUploadResult.objectKey;
        }
        if ((i8 & 2) != 0) {
            z = fileUploadResult.success;
        }
        if ((i8 & 4) != 0) {
            str2 = fileUploadResult.errorMessage;
        }
        return fileUploadResult.copy(str, z, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getObjectKey() {
        return this.objectKey;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final FileUploadResult copy(String objectKey, boolean success, String errorMessage) {
        p.e(objectKey, "objectKey");
        return new FileUploadResult(objectKey, success, errorMessage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileUploadResult)) {
            return false;
        }
        FileUploadResult fileUploadResult = (FileUploadResult) other;
        return p.a(this.objectKey, fileUploadResult.objectKey) && this.success == fileUploadResult.success && p.a(this.errorMessage, fileUploadResult.errorMessage);
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getObjectKey() {
        return this.objectKey;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int iG = b.g(this.objectKey.hashCode() * 31, 31, this.success);
        String str = this.errorMessage;
        return iG + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.objectKey;
        boolean z = this.success;
        String str2 = this.errorMessage;
        StringBuilder sb = new StringBuilder("FileUploadResult(objectKey=");
        sb.append(str);
        sb.append(", success=");
        sb.append(z);
        sb.append(", errorMessage=");
        return f.f(sb, str2, ")");
    }

    public /* synthetic */ FileUploadResult(String str, boolean z, String str2, int i8, i iVar) {
        this(str, z, (i8 & 4) != 0 ? null : str2);
    }
}
