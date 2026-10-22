package io.ktor.server.http.content;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/server/http/content/FileSystemPaths;", "", "", AMapLocationStaticsEntity.FIRST_LOCATE, "", "more", "Ljava/nio/file/Path;", "getPath", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FileSystemPaths {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/server/http/content/FileSystemPaths$Companion;", "", "<init>", "()V", "Ljava/nio/file/FileSystem;", "Lio/ktor/server/http/content/FileSystemPaths;", "paths", "(Ljava/nio/file/FileSystem;)Lio/ktor/server/http/content/FileSystemPaths;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final FileSystemPaths paths(final FileSystem fileSystem) {
            kotlin.jvm.internal.p.i(fileSystem, "<this>");
            return new FileSystemPaths() { // from class: io.ktor.server.http.content.FileSystemPaths$Companion$paths$1
                @Override // io.ktor.server.http.content.FileSystemPaths
                public Path getPath(String first, String... more) {
                    kotlin.jvm.internal.p.i(first, "first");
                    kotlin.jvm.internal.p.i(more, "more");
                    Path path = fileSystem.getPath(first, (String[]) Arrays.copyOf(more, more.length));
                    kotlin.jvm.internal.p.h(path, "getPath(...)");
                    return path;
                }
            };
        }
    }

    Path getPath(String first, String... more);
}
