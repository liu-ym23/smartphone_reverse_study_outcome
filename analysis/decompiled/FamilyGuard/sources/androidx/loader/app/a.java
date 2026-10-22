package androidx.loader.app;

import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.X;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {
    public static <T extends InterfaceC0539t & X> a b(T t5) {
        return new b(t5, t5.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
