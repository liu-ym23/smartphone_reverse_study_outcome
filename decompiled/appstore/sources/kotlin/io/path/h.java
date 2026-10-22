package kotlin.io.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static final /* synthetic */ boolean a(e r10) {
        return c(r10);
    }

    public static final /* synthetic */ Object b(Path r10, LinkOption[] r11) {
        return d(r10, r11);
    }

    public static final boolean c(e r10) {
        e r11 = r10.c();
    L3:
        if (r11 == null) goto L15;
        if (r11.b() != null) goto L7;
    L18:
        if (Files.isSameFile(r11.d(), r10.d()) == false) goto L14;
        return true;
    L14:
        r11 = r11.c();
        goto L3
    L7:
        if (r10.b() == null) goto L18;
        if (q.b(r11.b(), r10.b()) == false) goto L14;
        return true;
    L15:
        return false;
    }

    public static final Object d(Path r10, LinkOption[] r11) {
        LinkOption[] r12 = (LinkOption[]) Arrays.copyOf(r11, r11.length);     // Catch: Throwable -> L4
        BasicFileAttributes r13 = Files.readAttributes(r10, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r12, r12.length));     // Catch: Throwable -> L4
        q.f(r13, "readAttributes(...)");     // Catch: Throwable -> L4
        return r13.fileKey();
    L4:
        return null;
    }
}
