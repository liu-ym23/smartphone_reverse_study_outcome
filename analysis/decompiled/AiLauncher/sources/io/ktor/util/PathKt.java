package io.ktor.util;

import La.K;
import com.autonavi.aps.amapapi.config.Const;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\b\u001a\u0013\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\u0006\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0012\u001a\u00020\u000f*\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u0013\u0010\f\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\u0006¨\u0006\u0013"}, d2 = {"Ljava/io/File;", "", "relativePath", "combineSafe", "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", "normalizeAndRelativize", "(Ljava/io/File;)Ljava/io/File;", Const.JSON_KEY_DIR, "(Ljava/io/File;Ljava/io/File;)Ljava/io/File;", "notRooted", "path", "", "dropLeadingTopDirs", "(Ljava/lang/String;)I", "", "", "isPathSeparator", "(C)Z", "isPathSeparatorOrDot", "ktor-utils"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PathKt {
    public static final File combineSafe(File file, String relativePath) {
        kotlin.jvm.internal.p.i(file, "<this>");
        kotlin.jvm.internal.p.i(relativePath, "relativePath");
        return combineSafe(file, new File(relativePath));
    }

    public static final int dropLeadingTopDirs(String path) {
        kotlin.jvm.internal.p.i(path, "path");
        int length = path.length() - 1;
        int i10 = 0;
        while (i10 <= length) {
            char cCharAt = path.charAt(i10);
            if (!isPathSeparator(cCharAt)) {
                if (cCharAt != '.') {
                    break;
                }
                if (i10 == length) {
                    return i10 + 1;
                }
                char cCharAt2 = path.charAt(i10 + 1);
                int i11 = 2;
                if (!isPathSeparator(cCharAt2)) {
                    if (cCharAt2 == '.') {
                        int i12 = i10 + 2;
                        if (i12 != path.length()) {
                            if (!isPathSeparator(path.charAt(i12))) {
                                break;
                            }
                            i11 = 3;
                        }
                    } else {
                        break;
                    }
                }
                i10 += i11;
            } else {
                i10++;
            }
        }
        return i10;
    }

    private static final boolean isPathSeparator(char c10) {
        return c10 == '\\' || c10 == '/';
    }

    private static final boolean isPathSeparatorOrDot(char c10) {
        return c10 == '.' || isPathSeparator(c10);
    }

    public static final File normalizeAndRelativize(File file) {
        kotlin.jvm.internal.p.i(file, "<this>");
        return dropLeadingTopDirs(notRooted(l9.k.x(file)));
    }

    private static final File notRooted(File file) {
        String strSubstring;
        if (!l9.g.b(file)) {
            return file;
        }
        File file2 = file;
        while (true) {
            File parentFile = file2.getParentFile();
            if (parentFile == null) {
                break;
            }
            file2 = parentFile;
        }
        String path = file.getPath();
        kotlin.jvm.internal.p.h(path, "getPath(...)");
        String strL1 = K.L1(path, file2.getName().length());
        int length = strL1.length();
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                char cCharAt = strL1.charAt(i10);
                if (cCharAt != '\\' && cCharAt != '/') {
                    strSubstring = strL1.substring(i10);
                    kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                    break;
                }
                i10++;
            } else {
                strSubstring = "";
                break;
            }
        }
        return new File(strSubstring);
    }

    private static final File combineSafe(File file, File file2) {
        File fileNormalizeAndRelativize = normalizeAndRelativize(file2);
        if (l9.k.C(fileNormalizeAndRelativize, "..")) {
            throw new IllegalArgumentException("Bad relative path " + file2);
        }
        if (!fileNormalizeAndRelativize.isAbsolute()) {
            return new File(file, fileNormalizeAndRelativize.getPath());
        }
        throw new IllegalStateException(("Bad relative path " + file2).toString());
    }

    private static final File dropLeadingTopDirs(File file) {
        String path = file.getPath();
        if (path == null) {
            path = "";
        }
        int iDropLeadingTopDirs = dropLeadingTopDirs(path);
        if (iDropLeadingTopDirs == 0) {
            return file;
        }
        if (iDropLeadingTopDirs >= file.getPath().length()) {
            return new File(".");
        }
        String path2 = file.getPath();
        kotlin.jvm.internal.p.h(path2, "getPath(...)");
        String strSubstring = path2.substring(iDropLeadingTopDirs);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return new File(strSubstring);
    }
}
