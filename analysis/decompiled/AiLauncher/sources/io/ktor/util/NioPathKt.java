package io.ktor.util;

import Z8.C1173v;
import java.io.File;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0005\u001a\u0019\u0010\u0002\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\b¨\u0006\t"}, d2 = {"Ljava/nio/file/Path;", "relativePath", "combineSafe", "(Ljava/nio/file/Path;Ljava/nio/file/Path;)Ljava/nio/file/Path;", "normalizeAndRelativize", "(Ljava/nio/file/Path;)Ljava/nio/file/Path;", "dropLeadingTopDirs", "Ljava/io/File;", "(Ljava/io/File;Ljava/nio/file/Path;)Ljava/io/File;", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NioPathKt {
    public static final Path combineSafe(Path path, Path relativePath) {
        kotlin.jvm.internal.p.i(path, "<this>");
        kotlin.jvm.internal.p.i(relativePath, "relativePath");
        Path pathNormalizeAndRelativize = normalizeAndRelativize(relativePath);
        if (pathNormalizeAndRelativize.startsWith("..")) {
            throw new InvalidPathException(relativePath.toString(), "Relative path " + relativePath + " beginning with .. is invalid");
        }
        if (pathNormalizeAndRelativize.isAbsolute()) {
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        if (path.getNameCount() == 0) {
            return pathNormalizeAndRelativize;
        }
        Path pathResolve = path.resolve(pathNormalizeAndRelativize);
        kotlin.jvm.internal.p.h(pathResolve, "resolve(...)");
        return pathResolve;
    }

    private static final Path dropLeadingTopDirs(Path path) {
        Iterator it = path.iterator();
        int i10 = 0;
        while (true) {
            if (!it.hasNext()) {
                i10 = -1;
                break;
            }
            Object next = it.next();
            if (i10 < 0) {
                C1173v.w();
            }
            if (!kotlin.jvm.internal.p.d(((Path) next).toString(), "..")) {
                break;
            }
            i10++;
        }
        if (i10 <= 0) {
            return path;
        }
        Path pathSubpath = path.subpath(i10, path.getNameCount());
        kotlin.jvm.internal.p.h(pathSubpath, "subpath(...)");
        return pathSubpath;
    }

    public static final Path normalizeAndRelativize(Path path) {
        Path pathRelativize;
        Path pathNormalize;
        Path pathDropLeadingTopDirs;
        kotlin.jvm.internal.p.i(path, "<this>");
        Path root = path.getRoot();
        if (root != null && (pathRelativize = root.relativize(path)) != null && (pathNormalize = pathRelativize.normalize()) != null && (pathDropLeadingTopDirs = dropLeadingTopDirs(pathNormalize)) != null) {
            return pathDropLeadingTopDirs;
        }
        Path pathNormalize2 = path.normalize();
        kotlin.jvm.internal.p.h(pathNormalize2, "normalize(...)");
        return dropLeadingTopDirs(pathNormalize2);
    }

    public static final File combineSafe(File file, Path relativePath) {
        kotlin.jvm.internal.p.i(file, "<this>");
        kotlin.jvm.internal.p.i(relativePath, "relativePath");
        Path pathNormalizeAndRelativize = normalizeAndRelativize(relativePath);
        if (!pathNormalizeAndRelativize.startsWith("..")) {
            if (!pathNormalizeAndRelativize.isAbsolute()) {
                return new File(file, pathNormalizeAndRelativize.toString());
            }
            throw new IllegalStateException(("Bad relative path " + relativePath).toString());
        }
        throw new InvalidPathException(relativePath.toString(), "Relative path " + relativePath + " beginning with .. is invalid");
    }
}
