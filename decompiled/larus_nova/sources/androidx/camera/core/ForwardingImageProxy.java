package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingImageProxy implements ImageProxy {
    protected final ImageProxy mImage;
    private final Object mLock;
    private final Set<OnImageCloseListener> mOnImageCloseListeners;

    public interface OnImageCloseListener {
        void onImageClose(ImageProxy r100);
    }

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return ImageProxy.CC.$default$toBitmap(this);
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
        notifyOnImageCloseListeners();
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    public Image getImage() {
        return this.mImage.getImage();
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImage.getImageInfo();
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mImage.getPlanes();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    public void notifyOnImageCloseListeners() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        HashSet r101 = new HashSet(this.mOnImageCloseListeners);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        ((OnImageCloseListener) r102.next()).onImageClose(this);
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public ForwardingImageProxy(ImageProxy r100) {
        this.mLock = new Object();
        this.mOnImageCloseListeners = new HashSet();
        this.mImage = r100;
    }

    public void addOnImageCloseListener(OnImageCloseListener r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mOnImageCloseListeners.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect r100) {
        this.mImage.setCropRect(r100);
    }
}
