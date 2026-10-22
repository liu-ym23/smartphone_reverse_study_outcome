package com.stepos.ailauncher.container;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u0012R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001f\u0010\u0010R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b \u0010\u0010R\u0017\u0010\f\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b!\u0010\u0012¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/container/Y;", "", "", "fileId", "fileName", "uri", "filePath", "fileUrl", "", "fileType", "fileSize", "uploadState", "progress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", "getFileName", "getUri", "getFilePath", "getFileUrl", "I", "getFileType", "getFileSize", "getUploadState", "getProgress", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.container.Y, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class OverlayAttachmentPreview {
    private final String fileId;
    private final String fileName;
    private final String filePath;
    private final String fileSize;
    private final int fileType;
    private final String fileUrl;
    private final int progress;
    private final String uploadState;
    private final String uri;

    public OverlayAttachmentPreview(String fileId, String fileName, String uri, String filePath, String fileUrl, int i10, String fileSize, String uploadState, int i11) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        kotlin.jvm.internal.p.i(fileName, "fileName");
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(filePath, "filePath");
        kotlin.jvm.internal.p.i(fileUrl, "fileUrl");
        kotlin.jvm.internal.p.i(fileSize, "fileSize");
        kotlin.jvm.internal.p.i(uploadState, "uploadState");
        this.fileId = fileId;
        this.fileName = fileName;
        this.uri = uri;
        this.filePath = filePath;
        this.fileUrl = fileUrl;
        this.fileType = i10;
        this.fileSize = fileSize;
        this.uploadState = uploadState;
        this.progress = i11;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OverlayAttachmentPreview)) {
            return false;
        }
        OverlayAttachmentPreview overlayAttachmentPreview = (OverlayAttachmentPreview) other;
        return kotlin.jvm.internal.p.d(this.fileId, overlayAttachmentPreview.fileId) && kotlin.jvm.internal.p.d(this.fileName, overlayAttachmentPreview.fileName) && kotlin.jvm.internal.p.d(this.uri, overlayAttachmentPreview.uri) && kotlin.jvm.internal.p.d(this.filePath, overlayAttachmentPreview.filePath) && kotlin.jvm.internal.p.d(this.fileUrl, overlayAttachmentPreview.fileUrl) && this.fileType == overlayAttachmentPreview.fileType && kotlin.jvm.internal.p.d(this.fileSize, overlayAttachmentPreview.fileSize) && kotlin.jvm.internal.p.d(this.uploadState, overlayAttachmentPreview.uploadState) && this.progress == overlayAttachmentPreview.progress;
    }

    public int hashCode() {
        return (((((((((((((((this.fileId.hashCode() * 31) + this.fileName.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.filePath.hashCode()) * 31) + this.fileUrl.hashCode()) * 31) + Integer.hashCode(this.fileType)) * 31) + this.fileSize.hashCode()) * 31) + this.uploadState.hashCode()) * 31) + Integer.hashCode(this.progress);
    }

    public String toString() {
        return "OverlayAttachmentPreview(fileId=" + this.fileId + ", fileName=" + this.fileName + ", uri=" + this.uri + ", filePath=" + this.filePath + ", fileUrl=" + this.fileUrl + ", fileType=" + this.fileType + ", fileSize=" + this.fileSize + ", uploadState=" + this.uploadState + ", progress=" + this.progress + ")";
    }
}
