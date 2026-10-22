package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.w;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/io/path/CopyActionContext;", "src", "Ljava/nio/file/Path;", "dst", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2 extends Lambda implements Function3<CopyActionContext, Path, Path, CopyActionResult> {
    final /* synthetic */ boolean $followLinks;

    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(boolean r10) {
        this.$followLinks = r10;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ CopyActionResult invoke(CopyActionContext r10, Path r11, Path r12) {
        return invoke2(r10, r11, r12);
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CopyActionResult invoke2(@NotNull CopyActionContext r10, @NotNull Path r11, @NotNull Path r12) {
        q.g(r10, "$this$copyToRecursively");
        q.g(r11, "src");
        q.g(r12, "dst");
        LinkOption[] r13 = d.f21140a.a(this.$followLinks);
        boolean r14 = Files.isDirectory(r12, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        LinkOption[] r15 = (LinkOption[]) Arrays.copyOf(r13, r13.length);
        if (Files.isDirectory(r11, (LinkOption[]) Arrays.copyOf(r15, r15.length)) == false) goto L5;
        if (r14 == false) goto L5;
    L9:
        return CopyActionResult.CONTINUE;
    L5:
        if (r14 == false) goto L7;
        j.f(r12);
    L7:
        w r16 = new w(2);
        r16.b(r13);
        r16.a(StandardCopyOption.REPLACE_EXISTING);
        CopyOption[] r17 = (CopyOption[]) r16.d(new CopyOption[r16.c()]);
        q.f(Files.copy(r11, r12, (CopyOption[]) Arrays.copyOf(r17, r17.length)), "copy(...)");
        goto L9
    }
}
