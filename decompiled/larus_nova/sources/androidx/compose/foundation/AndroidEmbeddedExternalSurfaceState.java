package androidx.compose.foundation;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0017H\u0016R\u001c\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "Landroidx/compose/foundation/BaseAndroidExternalSurfaceState;", "Landroid/view/TextureView$SurfaceTextureListener;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "getSurfaceSize-YbymL2g", "()J", "setSurfaceSize-ozmzZPI", "(J)V", "J", "matrix", "Landroid/graphics/Matrix;", "getMatrix", "()Landroid/graphics/Matrix;", "surfaceTextureSurface", "Landroid/view/Surface;", "onSurfaceTextureAvailable", "", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureSizeChanged", "onSurfaceTextureDestroyed", "", "onSurfaceTextureUpdated", "surface", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class AndroidEmbeddedExternalSurfaceState extends BaseAndroidExternalSurfaceState implements TextureView.SurfaceTextureListener {
    private final Matrix matrix;
    private long surfaceSize;
    private Surface surfaceTextureSurface;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture r100) {
    }

    public final Matrix getMatrix() {
        return this.matrix;
    }

    /* JADX INFO: renamed from: getSurfaceSize-YbymL2g, reason: not valid java name */
    public final long m214getSurfaceSizeYbymL2g() {
        return this.surfaceSize;
    }

    public AndroidEmbeddedExternalSurfaceState(CoroutineScope r100) {
        super(r100);
        this.surfaceSize = IntSize.Companion.m7724getZeroYbymL2g();
        this.matrix = new Matrix();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Surface r101 = this.surfaceTextureSurface;
        Intrinsics.checkNotNull(r101);
        dispatchSurfaceDestroyed(r101);
        this.surfaceTextureSurface = null;
        return true;
    }

    /* JADX INFO: renamed from: setSurfaceSize-ozmzZPI, reason: not valid java name */
    public final void m215setSurfaceSizeozmzZPI(long r100) {
        this.surfaceSize = r100;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        if (IntSize.m7717equalsimpl0(this.surfaceSize, IntSize.Companion.m7724getZeroYbymL2g()) == true) goto L5;
        long r103 = this.surfaceSize;
        int r104 = (int) (r103 >> 32);
        r102 = (int) (r103 & BodyPartID.bodyIdMax);
        r100.setDefaultBufferSize(r104, r102);
        r101 = r104;
    L5:
        Surface r105 = new Surface(r100);
        this.surfaceTextureSurface = r105;
        dispatchSurfaceCreated(r105, r101, r102);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        if (IntSize.m7717equalsimpl0(this.surfaceSize, IntSize.Companion.m7724getZeroYbymL2g()) == true) goto L5;
        long r103 = this.surfaceSize;
        int r104 = (int) (r103 >> 32);
        r102 = (int) (r103 & BodyPartID.bodyIdMax);
        r100.setDefaultBufferSize(r104, r102);
        r101 = r104;
    L5:
        Surface r105 = this.surfaceTextureSurface;
        Intrinsics.checkNotNull(r105);
        dispatchSurfaceChanged(r105, r101, r102);
    }
}
