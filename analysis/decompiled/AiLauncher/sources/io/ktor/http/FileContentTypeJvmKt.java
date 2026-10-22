package io.ktor.http;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentType;
import java.io.File;
import java.nio.file.Path;
import kotlin.Metadata;
import m9.C4915c;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "Ljava/io/File;", Const.STR_FILE, "Lio/ktor/http/ContentType;", "defaultForFile", "(Lio/ktor/http/ContentType$Companion;Ljava/io/File;)Lio/ktor/http/ContentType;", "Ljava/nio/file/Path;", "path", "defaultForPath", "(Lio/ktor/http/ContentType$Companion;Ljava/nio/file/Path;)Lio/ktor/http/ContentType;", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileContentTypeJvmKt {
    public static final ContentType defaultForFile(ContentType.Companion companion, File file) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(file, "file");
        return FileContentTypeKt.selectDefault(FileContentTypeKt.fromFileExtension(ContentType.INSTANCE, l9.k.w(file)));
    }

    public static final ContentType defaultForPath(ContentType.Companion companion, Path path) {
        kotlin.jvm.internal.p.i(companion, "<this>");
        kotlin.jvm.internal.p.i(path, "path");
        return FileContentTypeKt.selectDefault(FileContentTypeKt.fromFileExtension(ContentType.INSTANCE, C4915c.a(path)));
    }
}
