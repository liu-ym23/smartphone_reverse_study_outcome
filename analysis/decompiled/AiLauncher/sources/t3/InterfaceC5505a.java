package t3;

import D2.i;
import android.view.A;
import android.view.InterfaceC1397o;
import android.view.Lifecycle;
import java.io.Closeable;
import java.util.List;
import u3.C5573a;
import x3.C5846a;

/* renamed from: t3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public interface InterfaceC5505a extends Closeable, InterfaceC1397o, com.google.android.gms.common.api.e {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @A(Lifecycle.Event.ON_DESTROY)
    void close();

    i<List<C5573a>> n0(C5846a c5846a);
}
