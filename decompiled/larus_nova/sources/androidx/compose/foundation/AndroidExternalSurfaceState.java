package androidx.compose.foundation;

import android.graphics.Rect;
import android.view.SurfaceHolder;
import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J(\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/AndroidExternalSurfaceState;", "Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroid/view/SurfaceHolder$Callback;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "lastWidth", "", "getLastWidth", "()I", "setLastWidth", "(I)V", "lastHeight", "getLastHeight", "setLastHeight", "surfaceCreated", "", "holder", "Landroid/view/SurfaceHolder;", "surfaceChanged", SubInfo.KEY_FORMAT, "width", "height", "surfaceDestroyed", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidExternalSurfaceState extends BaseAndroidExternalSurfaceState implements SurfaceHolder.Callback {
    private int lastHeight;
    private int lastWidth;

    public final int getLastHeight() {
        return this.lastHeight;
    }

    public final int getLastWidth() {
        return this.lastWidth;
    }

    public AndroidExternalSurfaceState(CoroutineScope r100) {
        super(r100);
        this.lastWidth = -1;
        this.lastHeight = -1;
    }

    public final void setLastHeight(int r100) {
        this.lastHeight = r100;
    }

    public final void setLastWidth(int r100) {
        this.lastWidth = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r100) {
        Rect r101 = r100.getSurfaceFrame();
        this.lastWidth = r101.width();
        this.lastHeight = r101.height();
        dispatchSurfaceCreated(r100.getSurface(), this.lastWidth, this.lastHeight);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r100) {
        dispatchSurfaceDestroyed(r100.getSurface());
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
        if (this.lastWidth == r102) goto L5;
    L6:
        this.lastWidth = r102;
        this.lastHeight = r103;
        dispatchSurfaceChanged(r100.getSurface(), r102, r103);
        return;
    L5:
        if (this.lastHeight != r103) goto L6;
    }
}
