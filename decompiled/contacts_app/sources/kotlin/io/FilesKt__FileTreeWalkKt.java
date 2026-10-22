package kotlin.io;

import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", MaterialConfigFormatNames.DIRECTION, "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public FilesKt__FileTreeWalkKt() {
    }

    public static /* synthetic */ FileTreeWalk walk$default(File r0, FileWalkDirection r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = FileWalkDirection.TOP_DOWN;
    L6:
        return FilesKt.walk(r0, r1);
    }

    public static final FileTreeWalk walk(File r1, FileWalkDirection r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, MaterialConfigFormatNames.DIRECTION);
        return new FileTreeWalk(r1, r2);
    }

    public static final FileTreeWalk walkTopDown(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return FilesKt.walk(r1, FileWalkDirection.TOP_DOWN);
    }

    public static final FileTreeWalk walkBottomUp(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return FilesKt.walk(r1, FileWalkDirection.BOTTOM_UP);
    }
}
