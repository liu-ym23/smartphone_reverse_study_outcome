package io.ktor.server.http.content;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeJvmKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.VersionsKt;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import v9.C5683l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/server/http/content/LocalFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Ljava/io/File;", Const.STR_FILE, "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/io/File;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lv9/l;", "range", "(Lv9/l;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalFileContent extends OutgoingContent.ReadChannelContent {
    private final ContentType contentType;
    private final File file;

    public /* synthetic */ LocalFileContent(File file, ContentType contentType, int i10, kotlin.jvm.internal.i iVar) {
        this(file, (i10 & 2) != 0 ? FileContentTypeJvmKt.defaultForFile(ContentType.INSTANCE, file) : contentType);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return Long.valueOf(this.file.length());
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public final File getFile() {
        return this.file;
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return FileChannelsKt.readChannel$default(this.file, 0L, 0L, null, 7, null);
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom(C5683l range) {
        kotlin.jvm.internal.p.i(range, "range");
        return FileChannelsKt.readChannel$default(this.file, range.getFirst(), range.getLast(), null, 4, null);
    }

    public LocalFileContent(File file, ContentType contentType) throws IOException {
        kotlin.jvm.internal.p.i(file, "file");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        this.file = file;
        this.contentType = contentType;
        if (file.exists()) {
            VersionsKt.setVersions(this, Z8.F.T0(VersionsKt.getVersions(this), LastModifiedJavaTimeKt.LastModifiedVersion(file.lastModified())));
        } else {
            throw new IOException("No such file " + file.getAbsolutePath());
        }
    }
}
