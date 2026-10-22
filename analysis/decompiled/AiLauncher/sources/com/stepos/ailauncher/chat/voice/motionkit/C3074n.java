package com.stepos.ailauncher.chat.voice.motionkit;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroid/view/View;", "start", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroid/view/View;)V", "Landroid/graphics/Bitmap;", "src", "c", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.voice.motionkit.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3074n {
    public static final Bitmap c(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        kotlin.jvm.internal.p.h(bitmapCreateBitmap, "createBitmap(...)");
        return bitmapCreateBitmap;
    }

    public static final void d(View view) {
        for (int i10 = 0; (view instanceof ViewGroup) && i10 < 4; i10++) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            Object parent = viewGroup.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
    }
}
