package K;

import D.C0777n;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInternal;
import java.util.List;
import java.util.Set;

/* renamed from: K.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC0897u extends InterfaceC0900x {

    /* renamed from: K.u$a */
    public interface a {
        List<String> d(List<String> list);
    }

    /* renamed from: K.u$b */
    public interface b {
        @SuppressLint({"LambdaLast"})
        InterfaceC0897u a(Context context, O o10, CameraSelector cameraSelector, long j10, androidx.camera.core.f fVar, P.i iVar) throws InitializationException;
    }

    CameraInternal a(String str) throws CameraUnavailableException;

    p0<List<C0777n>> b();

    Set<String> c();

    Object f();

    E.a g();

    default void shutdown() {
    }
}
