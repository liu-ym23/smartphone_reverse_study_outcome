package androidx.camera.core;

/* loaded from: classes.dex */
public class ImageCaptureException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f11209a;

    public ImageCaptureException(int i10, String str, Throwable th) {
        super(str, th);
        this.f11209a = i10;
    }

    public int a() {
        return this.f11209a;
    }
}
