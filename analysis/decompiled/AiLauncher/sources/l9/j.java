package l9;

import java.io.File;
import kotlin.Metadata;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0003*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Ljava/io/File;", "Lkotlin/io/FileWalkDirection;", "direction", "Ll9/f;", "s", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)Ll9/f;", "u", "(Ljava/io/File;)Ll9/f;", "t", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes4.dex */
public class j extends i {
    public static final f s(File file, FileWalkDirection direction) {
        p.i(file, "<this>");
        p.i(direction, "direction");
        return new f(file, direction);
    }

    public static final f t(File file) {
        p.i(file, "<this>");
        return s(file, FileWalkDirection.BOTTOM_UP);
    }

    public static f u(File file) {
        p.i(file, "<this>");
        return s(file, FileWalkDirection.TOP_DOWN);
    }
}
