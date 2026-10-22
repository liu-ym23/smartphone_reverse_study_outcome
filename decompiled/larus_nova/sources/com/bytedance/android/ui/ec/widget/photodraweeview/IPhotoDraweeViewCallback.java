package com.bytedance.android.ui.ec.widget.photodraweeview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\n\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback;", "", "configTransform", "", "imageView", "Landroid/view/View;", "imageBounds", "Landroid/graphics/RectF;", "getDefaultTransform", "Landroid/graphics/Matrix;", "Companion", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPhotoDraweeViewCallback {
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/IPhotoDraweeViewCallback$Companion;", "", "()V", "tempRect", "Landroid/graphics/RectF;", "getTempRect", "()Landroid/graphics/RectF;", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final RectF tempRect = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            tempRect = new RectF();
        }

        public final RectF getTempRect() {
            return tempRect;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void configTransform(View r100, RectF r101);

    Matrix getDefaultTransform();
}
