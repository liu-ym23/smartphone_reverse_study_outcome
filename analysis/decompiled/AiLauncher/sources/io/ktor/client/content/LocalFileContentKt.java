package io.ktor.client.content;

import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeKt;
import io.ktor.util.PathKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a'\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ljava/io/File;", "baseDir", "", "relativePath", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/client/content/LocalFileContent;", "LocalFileContent", "(Ljava/io/File;Ljava/lang/String;Lio/ktor/http/ContentType;)Lio/ktor/client/content/LocalFileContent;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LocalFileContentKt {
    public static final LocalFileContent LocalFileContent(File baseDir, String relativePath, ContentType contentType) {
        p.i(baseDir, "baseDir");
        p.i(relativePath, "relativePath");
        p.i(contentType, "contentType");
        return new LocalFileContent(PathKt.combineSafe(baseDir, relativePath), contentType);
    }

    public static /* synthetic */ LocalFileContent LocalFileContent$default(File file, String str, ContentType contentType, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            contentType = FileContentTypeKt.defaultForFilePath(ContentType.INSTANCE, str);
        }
        return LocalFileContent(file, str, contentType);
    }
}
