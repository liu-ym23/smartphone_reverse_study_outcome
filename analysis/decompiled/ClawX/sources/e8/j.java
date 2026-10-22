package e8;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Win32Exception;
import com.sun.jna.ptr.IntByReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j extends b {
    static {
        z7.d.b(j.class).c("Checking for JNA classes: {} and {}", Memory.class.getName(), Win32Exception.class.getName());
    }

    @Override // e8.i
    public final void a() {
        g();
        new Memory(15360L);
        new IntByReference(0);
        int i8 = d.f2400a;
        Pointer pointer = Pointer.NULL;
        throw null;
    }
}
