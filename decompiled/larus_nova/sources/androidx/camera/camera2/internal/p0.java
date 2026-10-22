package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p0 implements CameraCharacteristicsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CameraCharacteristicsCompat f4997a;

    public /* synthetic */ p0(CameraCharacteristicsCompat r100) {
        this.f4997a = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.CameraCharacteristicsProvider
    public final Object get(CameraCharacteristics.Key r100) {
        return this.f4997a.get(r100);
    }
}
