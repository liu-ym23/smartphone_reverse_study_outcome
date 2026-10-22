package com.stepos.widget.searchbar;

import android.app.SharedElementCallback;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import kotlin.Metadata;
import kotlin.sequences.SequencesKt___SequencesKt;
import p9.InterfaceC5074l;
import v9.C5685n;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/stepos/widget/searchbar/StepOSSearchTransition$whiteSnapshotCallback$1", "Landroid/app/SharedElementCallback;", "onCaptureSharedElementSnapshot", "Landroid/graphics/Bitmap;", "sharedElement", "Landroid/view/View;", "viewToGlobalMatrix", "Landroid/graphics/Matrix;", "screenBounds", "Landroid/graphics/RectF;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSSearchTransition$whiteSnapshotCallback$1 extends SharedElementCallback {
    /* JADX INFO: Access modifiers changed from: private */
    public static final View onCaptureSharedElementSnapshot$lambda$0(View it) {
        kotlin.jvm.internal.p.i(it, "it");
        Object parent = it.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    @Override // android.app.SharedElementCallback
    public Bitmap onCaptureSharedElementSnapshot(View sharedElement, Matrix viewToGlobalMatrix, RectF screenBounds) {
        kotlin.jvm.internal.p.i(sharedElement, "sharedElement");
        kotlin.jvm.internal.p.i(viewToGlobalMatrix, "viewToGlobalMatrix");
        kotlin.jvm.internal.p.i(screenBounds, "screenBounds");
        int iF = C5685n.f(sharedElement.getWidth(), 1);
        int iF2 = C5685n.f(sharedElement.getHeight(), 1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iF, iF2, Bitmap.Config.ARGB_8888);
        kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Ka.j jVarF = SequencesKt___SequencesKt.F(Ka.t.q(sharedElement, new InterfaceC5074l() { // from class: com.stepos.widget.searchbar.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return StepOSSearchTransition$whiteSnapshotCallback$1.onCaptureSharedElementSnapshot$lambda$0((View) obj);
            }
        }), new InterfaceC5074l<Object, Boolean>() { // from class: com.stepos.widget.searchbar.StepOSSearchTransition$whiteSnapshotCallback$1$onCaptureSharedElementSnapshot$$inlined$filterIsInstance$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p9.InterfaceC5074l
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(obj instanceof StepOSSearchBar);
            }
        });
        kotlin.jvm.internal.p.g(jVarF, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        StepOSSearchBar stepOSSearchBar = (StepOSSearchBar) SequencesKt___SequencesKt.K(jVarF);
        if (stepOSSearchBar != null) {
            stepOSSearchBar.drawTransitionShapes$StepOSWidget_release(canvas);
            return bitmapCreateBitmap;
        }
        float f10 = iF;
        float f11 = iF2;
        float f12 = f11 / 2.0f;
        Paint paint = new Paint(1);
        paint.setColor(-1);
        Y8.t tVar = Y8.t.f7040a;
        canvas.drawRoundRect(0.0f, 0.0f, f10, f11, f12, f12, paint);
        return bitmapCreateBitmap;
    }
}
