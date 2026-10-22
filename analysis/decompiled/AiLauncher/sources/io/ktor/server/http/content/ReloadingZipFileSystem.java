package io.ktor.server.http.content;

import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.sun.nio.file.SensitivityWatchEventModifier;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b\"\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u001c\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/ktor/server/http/content/ReloadingZipFileSystem;", "Lio/ktor/server/http/content/FileSystemPaths;", "Ljava/nio/file/Path;", "zip", "Ljava/lang/ClassLoader;", "classLoader", "delegate", "<init>", "(Ljava/nio/file/Path;Ljava/lang/ClassLoader;Lio/ktor/server/http/content/FileSystemPaths;)V", "", AMapLocationStaticsEntity.FIRST_LOCATE, "", "more", "getPath", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "Ljava/nio/file/Path;", "Ljava/lang/ClassLoader;", "Lio/ktor/server/http/content/FileSystemPaths;", "Ljava/nio/file/WatchService;", "kotlin.jvm.PlatformType", "watchService", "Ljava/nio/file/WatchService;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ReloadingZipFileSystem implements FileSystemPaths {
    private final ClassLoader classLoader;
    private FileSystemPaths delegate;
    private final WatchService watchService;
    private final Path zip;

    public ReloadingZipFileSystem(Path zip, ClassLoader classLoader, FileSystemPaths delegate) throws IOException {
        kotlin.jvm.internal.p.i(zip, "zip");
        kotlin.jvm.internal.p.i(classLoader, "classLoader");
        kotlin.jvm.internal.p.i(delegate, "delegate");
        this.zip = zip;
        this.classLoader = classLoader;
        this.delegate = delegate;
        WatchService watchServiceNewWatchService = FileSystems.getDefault().newWatchService();
        this.watchService = watchServiceNewWatchService;
        zip.getParent().register(watchServiceNewWatchService, new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.OVERFLOW}, SensitivityWatchEventModifier.HIGH);
    }

    @Override // io.ktor.server.http.content.FileSystemPaths
    public Path getPath(String first, String... more) {
        kotlin.jvm.internal.p.i(first, "first");
        kotlin.jvm.internal.p.i(more, "more");
        WatchKey watchKeyPoll = this.watchService.poll();
        if (watchKeyPoll == null) {
            return this.delegate.getPath(first, (String[]) Arrays.copyOf(more, more.length));
        }
        List<WatchEvent<?>> listPollEvents = watchKeyPoll.pollEvents();
        kotlin.jvm.internal.p.f(listPollEvents);
        if (!listPollEvents.isEmpty()) {
            this.delegate = FileSystemPaths.INSTANCE.paths(StaticContentKt.getFileSystem(this.zip, this.classLoader));
        }
        watchKeyPoll.reset();
        return this.delegate.getPath(first, (String[]) Arrays.copyOf(more, more.length));
    }
}
