package D;

import K.InterfaceC0872a0;
import android.media.Image;
import android.media.ImageReader;
import android.view.Surface;
import java.util.concurrent.Executor;

/* renamed from: D.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0762c implements InterfaceC0872a0 {

    /* renamed from: a, reason: collision with root package name */
    public final ImageReader f2085a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2086b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public boolean f2087c = true;

    public C0762c(ImageReader imageReader) {
        this.f2085a = imageReader;
    }

    public static /* synthetic */ void c(final C0762c c0762c, Executor executor, final InterfaceC0872a0.a aVar, ImageReader imageReader) {
        synchronized (c0762c.f2086b) {
            try {
                if (!c0762c.f2087c) {
                    executor.execute(new Runnable() { // from class: D.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            C0762c.h(this.f2082a, aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static /* synthetic */ void h(C0762c c0762c, InterfaceC0872a0.a aVar) {
        c0762c.getClass();
        aVar.a(c0762c);
    }

    @Override // K.InterfaceC0872a0
    public int a() {
        int maxImages;
        synchronized (this.f2086b) {
            maxImages = this.f2085a.getMaxImages();
        }
        return maxImages;
    }

    @Override // K.InterfaceC0872a0
    public void b(final InterfaceC0872a0.a aVar, final Executor executor) {
        synchronized (this.f2086b) {
            this.f2087c = false;
            this.f2085a.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: D.a
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    C0762c.c(this.f2077a, executor, aVar, imageReader);
                }
            }, M.j.a());
        }
    }

    @Override // K.InterfaceC0872a0
    public void close() {
        synchronized (this.f2086b) {
            this.f2085a.close();
        }
    }

    @Override // K.InterfaceC0872a0
    public androidx.camera.core.i d() {
        Image imageAcquireLatestImage;
        synchronized (this.f2086b) {
            try {
                imageAcquireLatestImage = this.f2085a.acquireLatestImage();
            } catch (RuntimeException e10) {
                if (!this.i(e10)) {
                    throw e10;
                }
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return null;
            }
            return new androidx.camera.core.a(imageAcquireLatestImage);
        }
    }

    @Override // K.InterfaceC0872a0
    public int e() {
        int imageFormat;
        synchronized (this.f2086b) {
            imageFormat = this.f2085a.getImageFormat();
        }
        return imageFormat;
    }

    @Override // K.InterfaceC0872a0
    public void f() {
        synchronized (this.f2086b) {
            this.f2087c = true;
            this.f2085a.setOnImageAvailableListener(null, null);
        }
    }

    @Override // K.InterfaceC0872a0
    public androidx.camera.core.i g() {
        Image imageAcquireNextImage;
        synchronized (this.f2086b) {
            try {
                imageAcquireNextImage = this.f2085a.acquireNextImage();
            } catch (RuntimeException e10) {
                if (!this.i(e10)) {
                    throw e10;
                }
                imageAcquireNextImage = null;
            }
            if (imageAcquireNextImage == null) {
                return null;
            }
            return new androidx.camera.core.a(imageAcquireNextImage);
        }
    }

    @Override // K.InterfaceC0872a0
    public int getHeight() {
        int height;
        synchronized (this.f2086b) {
            height = this.f2085a.getHeight();
        }
        return height;
    }

    @Override // K.InterfaceC0872a0
    public Surface getSurface() {
        Surface surface;
        synchronized (this.f2086b) {
            surface = this.f2085a.getSurface();
        }
        return surface;
    }

    @Override // K.InterfaceC0872a0
    public int getWidth() {
        int width;
        synchronized (this.f2086b) {
            width = this.f2085a.getWidth();
        }
        return width;
    }

    public final boolean i(RuntimeException runtimeException) {
        return "ImageReaderContext is not initialized".equals(runtimeException.getMessage());
    }
}
