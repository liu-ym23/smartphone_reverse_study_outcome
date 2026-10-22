package androidx.compose.ui.graphics.layer;

import J7.c;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@RequiresApi(22)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/ui/graphics/layer/LayerSnapshotV22;", "Landroidx/compose/ui/graphics/layer/LayerSnapshotImpl;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "graphicsLayer", "Landroid/graphics/Bitmap;", "toBitmap", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;LH7/c;)Ljava/lang/Object;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayerSnapshotV22 implements LayerSnapshotImpl {
    public static final LayerSnapshotV22 INSTANCE = new LayerSnapshotV22();

    @c(c = "androidx.compose.ui.graphics.layer.LayerSnapshotV22", f = "LayerSnapshot.android.kt", l = {225}, m = "toBitmap")
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LayerSnapshotV22.this.toBitmap(null, this);
        }
    }

    private LayerSnapshotV22() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.graphics.layer.LayerSnapshotImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer r9, H7.c<? super android.graphics.Bitmap> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.graphics.layer.LayerSnapshotV22.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 r0 = (androidx.compose.ui.graphics.layer.LayerSnapshotV22.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 r0 = new androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1
            r0.<init>(r10)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r0.label
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L48
            if (r1 != r2) goto L40
            java.lang.Object r9 = r0.L$4
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$1 r9 = (androidx.compose.ui.graphics.layer.LayerSnapshotV22.AnonymousClass1) r9
            java.lang.Object r9 = r0.L$3
            android.media.ImageReader r9 = (android.media.ImageReader) r9
            java.lang.Object r9 = r0.L$2
            java.lang.AutoCloseable r9 = (java.lang.AutoCloseable) r9
            java.lang.Object r10 = r0.L$1
            android.os.Looper r10 = (android.os.Looper) r10
            java.lang.Object r10 = r0.L$0
            androidx.compose.ui.graphics.layer.GraphicsLayer r10 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r10
            kotlin.b.b(r8)     // Catch: java.lang.Throwable -> L3d
            goto Lb8
        L3d:
            r8 = move-exception
            goto Lca
        L40:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L48:
            kotlin.b.b(r8)
            long r4 = r9.getSize()
            android.os.Looper r8 = android.os.Looper.myLooper()
            if (r8 != 0) goto L59
            android.os.Looper r8 = android.os.Looper.getMainLooper()
        L59:
            r1 = 32
            long r6 = r4 >> r1
            int r1 = (int) r6
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            int r4 = (int) r4
            android.media.ImageReader r1 = android.media.ImageReader.newInstance(r1, r4, r2, r2)
            r0.L$0 = r9     // Catch: java.lang.Throwable -> Lc2
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lc2
            r0.L$2 = r1     // Catch: java.lang.Throwable -> Lc2
            r0.L$3 = r1     // Catch: java.lang.Throwable -> Lc2
            r0.L$4 = r0     // Catch: java.lang.Throwable -> Lc2
            r0.label = r2     // Catch: java.lang.Throwable -> Lc2
            m9.k r4 = new m9.k     // Catch: java.lang.Throwable -> Lc2
            H7.c r0 = U7.a.I(r0)     // Catch: java.lang.Throwable -> Lc2
            r4.<init>(r2, r0)     // Catch: java.lang.Throwable -> Lc2
            r4.y()     // Catch: java.lang.Throwable -> Lc2
            androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1 r0 = new androidx.compose.ui.graphics.layer.LayerSnapshotV22$toBitmap$2$image$1$1     // Catch: java.lang.Throwable -> Lc2
            r0.<init>()     // Catch: java.lang.Throwable -> Lc2
            android.os.Handler r8 = androidx.core.os.HandlerCompat.createAsync(r8)     // Catch: java.lang.Throwable -> Lc2
            r1.setOnImageAvailableListener(r0, r8)     // Catch: java.lang.Throwable -> Lc2
            android.view.Surface r8 = r1.getSurface()     // Catch: java.lang.Throwable -> Lc2
            androidx.compose.ui.graphics.layer.SurfaceUtils r0 = androidx.compose.ui.graphics.layer.SurfaceUtils.INSTANCE     // Catch: java.lang.Throwable -> Lc2
            android.graphics.Canvas r0 = r0.lockCanvas(r8)     // Catch: java.lang.Throwable -> Lc2
            androidx.compose.ui.graphics.Color$Companion r2 = androidx.compose.ui.graphics.Color.INSTANCE     // Catch: java.lang.Throwable -> Lc5
            long r5 = r2.m4165getBlack0d7_KjU()     // Catch: java.lang.Throwable -> Lc5
            int r2 = androidx.compose.ui.graphics.ColorKt.m4193toArgb8_81llA(r5)     // Catch: java.lang.Throwable -> Lc5
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.CLEAR     // Catch: java.lang.Throwable -> Lc5
            r0.drawColor(r2, r5)     // Catch: java.lang.Throwable -> Lc5
            androidx.compose.ui.graphics.Canvas r2 = androidx.compose.ui.graphics.AndroidCanvas_androidKt.Canvas(r0)     // Catch: java.lang.Throwable -> Lc5
            r9.draw$ui_graphics_release(r2, r3)     // Catch: java.lang.Throwable -> Lc5
            r8.unlockCanvasAndPost(r0)     // Catch: java.lang.Throwable -> Lc2
            java.lang.Object r8 = r4.x()     // Catch: java.lang.Throwable -> Lc2
            if (r8 != r10) goto Lb7
            return r10
        Lb7:
            r9 = r1
        Lb8:
            android.media.Image r8 = (android.media.Image) r8     // Catch: java.lang.Throwable -> L3d
            android.graphics.Bitmap r8 = androidx.compose.ui.graphics.layer.LayerSnapshot_androidKt.access$toBitmap(r8)     // Catch: java.lang.Throwable -> L3d
            com.stepos.ability.task.executor.e.s(r9, r3)
            return r8
        Lc2:
            r8 = move-exception
            r9 = r1
            goto Lca
        Lc5:
            r9 = move-exception
            r8.unlockCanvasAndPost(r0)     // Catch: java.lang.Throwable -> Lc2
            throw r9     // Catch: java.lang.Throwable -> Lc2
        Lca:
            throw r8     // Catch: java.lang.Throwable -> Lcb
        Lcb:
            r10 = move-exception
            com.stepos.ability.task.executor.e.s(r9, r8)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.LayerSnapshotV22.toBitmap(androidx.compose.ui.graphics.layer.GraphicsLayer, H7.c):java.lang.Object");
    }
}
