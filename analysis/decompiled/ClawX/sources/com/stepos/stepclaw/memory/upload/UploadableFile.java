package com.stepos.stepclaw.memory.upload;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/stepos/stepclaw/memory/upload/UploadableFile;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "file", "Ljava/io/File;", "objectKey", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "category", "isSingleFile", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Z)V", "getFile", "()Ljava/io/File;", "getObjectKey", "()Ljava/lang/String;", "getCategory", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class UploadableFile {
    private final String category;
    private final File file;
    private final boolean isSingleFile;
    private final String objectKey;

    public UploadableFile(File file, String objectKey, String category, boolean z) {
        p.e(file, "file");
        p.e(objectKey, "objectKey");
        p.e(category, "category");
        this.file = file;
        this.objectKey = objectKey;
        this.category = category;
        this.isSingleFile = z;
    }

    public static /* synthetic */ UploadableFile copy$default(UploadableFile uploadableFile, File file, String str, String str2, boolean z, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            file = uploadableFile.file;
        }
        if ((i8 & 2) != 0) {
            str = uploadableFile.objectKey;
        }
        if ((i8 & 4) != 0) {
            str2 = uploadableFile.category;
        }
        if ((i8 & 8) != 0) {
            z = uploadableFile.isSingleFile;
        }
        return uploadableFile.copy(file, str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final File getFile() {
        return this.file;
    }

    /* renamed from: component2, reason: from getter */
    public final String getObjectKey() {
        return this.objectKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsSingleFile() {
        return this.isSingleFile;
    }

    public final UploadableFile copy(File file, String objectKey, String category, boolean isSingleFile) {
        p.e(file, "file");
        p.e(objectKey, "objectKey");
        p.e(category, "category");
        return new UploadableFile(file, objectKey, category, isSingleFile);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadableFile)) {
            return false;
        }
        UploadableFile uploadableFile = (UploadableFile) other;
        return p.a(this.file, uploadableFile.file) && p.a(this.objectKey, uploadableFile.objectKey) && p.a(this.category, uploadableFile.category) && this.isSingleFile == uploadableFile.isSingleFile;
    }

    public final String getCategory() {
        return this.category;
    }

    public final File getFile() {
        return this.file;
    }

    public final String getObjectKey() {
        return this.objectKey;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isSingleFile) + b.f(b.f(this.file.hashCode() * 31, 31, this.objectKey), 31, this.category);
    }

    public final boolean isSingleFile() {
        return this.isSingleFile;
    }

    public String toString() {
        return "UploadableFile(file=" + this.file + ", objectKey=" + this.objectKey + ", category=" + this.category + ", isSingleFile=" + this.isSingleFile + ")";
    }
}
