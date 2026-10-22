package io.ktor.server.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeJvmKt;
import io.ktor.http.FileContentTypeKt;
import io.ktor.util.NioPathKt;
import io.ktor.util.PathKt;
import java.io.File;
import java.nio.file.Path;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\u000b\u001a'\u0010\f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Ljava/io/File;", "baseDir", "", "relativePath", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/server/http/content/LocalFileContent;", "LocalFileContent", "(Ljava/io/File;Ljava/lang/String;Lio/ktor/http/ContentType;)Lio/ktor/server/http/content/LocalFileContent;", "Ljava/nio/file/Path;", "Lio/ktor/server/http/content/LocalPathContent;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Lio/ktor/http/ContentType;)Lio/ktor/server/http/content/LocalPathContent;", "LocalPathContent", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalFileContentKt {
    public static final LocalFileContent LocalFileContent(File baseDir, String relativePath, ContentType contentType) {
        kotlin.jvm.internal.p.i(baseDir, "baseDir");
        kotlin.jvm.internal.p.i(relativePath, "relativePath");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        return new LocalFileContent(PathKt.combineSafe(baseDir, relativePath), contentType);
    }

    public static /* synthetic */ LocalFileContent LocalFileContent$default(File file, String str, ContentType contentType, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            contentType = FileContentTypeKt.defaultForFilePath(ContentType.INSTANCE, str);
        }
        return LocalFileContent(file, str, contentType);
    }

    public static final LocalPathContent LocalPathContent(Path baseDir, Path relativePath, ContentType contentType) {
        kotlin.jvm.internal.p.i(baseDir, "baseDir");
        kotlin.jvm.internal.p.i(relativePath, "relativePath");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        return new LocalPathContent(NioPathKt.combineSafe(baseDir, relativePath), contentType);
    }

    public static /* synthetic */ LocalPathContent LocalPathContent$default(Path path, Path path2, ContentType contentType, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            contentType = FileContentTypeJvmKt.defaultForPath(ContentType.INSTANCE, path2);
        }
        return LocalPathContent(path, path2, contentType);
    }

    public static final LocalPathContent LocalFileContent(Path baseDir, Path relativePath, ContentType contentType) {
        kotlin.jvm.internal.p.i(baseDir, "baseDir");
        kotlin.jvm.internal.p.i(relativePath, "relativePath");
        kotlin.jvm.internal.p.i(contentType, "contentType");
        return new LocalPathContent(NioPathKt.combineSafe(baseDir, relativePath), contentType);
    }

    public static /* synthetic */ LocalPathContent LocalFileContent$default(Path path, Path path2, ContentType contentType, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            contentType = FileContentTypeJvmKt.defaultForPath(ContentType.INSTANCE, path2);
        }
        return LocalFileContent(path, path2, contentType);
    }
}
