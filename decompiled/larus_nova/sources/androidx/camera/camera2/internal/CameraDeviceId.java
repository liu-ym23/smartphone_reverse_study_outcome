package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes2.dex */
abstract class CameraDeviceId {
    public abstract String getBrand();

    public abstract String getCameraId();

    public abstract String getDevice();

    public abstract String getModel();

    public CameraDeviceId() {
    }

    public static CameraDeviceId create(String r100, String r101, String r102, String r103) {
        return new AutoValue_CameraDeviceId(r100.toLowerCase(), r101.toLowerCase(), r102.toLowerCase(), r103.toLowerCase());
    }
}
