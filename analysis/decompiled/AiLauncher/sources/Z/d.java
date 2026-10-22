package Z;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

/* loaded from: classes.dex */
public class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public final CameraManager f7089a;

    public d(Context context) {
        this.f7089a = (CameraManager) context.getSystemService(CameraManager.class);
    }

    @Override // Z.g
    public e a(String str) throws CameraAccessException {
        return new c(this.f7089a, str);
    }
}
