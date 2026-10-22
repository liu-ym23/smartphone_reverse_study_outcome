package kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements CopyActionContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21132a = null;

    static {
        f21132a = new a();
    }

    public a() {
    }

    @Override // kotlin.io.path.CopyActionContext
    public CopyActionResult copyToIgnoringExistingDirectory(Path r10, Path r11, boolean r12) {
        q.g(r10, "<this>");
        q.g(r11, "target");
        LinkOption[] r13 = d.f21140a.a(r12);
        LinkOption[] r14 = (LinkOption[]) Arrays.copyOf(r13, r13.length);
        if (Files.isDirectory(r10, (LinkOption[]) Arrays.copyOf(r14, r14.length)) == true) goto L5;
    L6:
        CopyOption[] r15 = (CopyOption[]) Arrays.copyOf(r13, r13.length);
        q.f(Files.copy(r10, r11, (CopyOption[]) Arrays.copyOf(r15, r15.length)), "copy(...)");
    L8:
        return CopyActionResult.CONTINUE;
    L5:
        if (Files.isDirectory(r11, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == true) goto L8;
        goto L6
    }
}
