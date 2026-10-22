package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;
import com.bytedance.keva.KevaImpl;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f1040c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProgressBar f1041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f1042b;

    public static class a {
        public static void a(LayerDrawable r10, LayerDrawable r11, int r12) {
            r11.setLayerGravity(r12, r10.getLayerGravity(r12));
            r11.setLayerWidth(r12, r10.getLayerWidth(r12));
            r11.setLayerHeight(r12, r10.getLayerHeight(r12));
            r11.setLayerInsetLeft(r12, r10.getLayerInsetLeft(r12));
            r11.setLayerInsetRight(r12, r10.getLayerInsetRight(r12));
            r11.setLayerInsetTop(r12, r10.getLayerInsetTop(r12));
            r11.setLayerInsetBottom(r12, r10.getLayerInsetBottom(r12));
            r11.setLayerInsetStart(r12, r10.getLayerInsetStart(r12));
            r11.setLayerInsetEnd(r12, r10.getLayerInsetEnd(r12));
        }
    }

    static {
        f1040c = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    public k(ProgressBar r10) {
        this.f1041a = r10;
    }

    public final Shape a() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Bitmap b() {
        return this.f1042b;
    }

    public void c(AttributeSet r10, int r11) {
        b0 r12 = b0.v(this.f1041a.getContext(), r10, f1040c, r11, 0);
        Drawable r13 = r12.h(0);
        if (r13 == null) goto L5;
        this.f1041a.setIndeterminateDrawable(e(r13));
    L5:
        Drawable r14 = r12.h(1);
        if (r14 == null) goto L8;
        this.f1041a.setProgressDrawable(d(r14, false));
    L8:
        r12.w();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable d(Drawable r10, boolean r11) {
        if ((r10 instanceof WrappedDrawable) == false) goto L8;
        WrappedDrawable r12 = (WrappedDrawable) r10;
        Drawable r13 = r12.getWrappedDrawable();
        if (r13 == null) goto L32;
        r12.setWrappedDrawable(d(r13, r11));
    L32:
        return r10;
    L8:
        if ((r10 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r14 = (LayerDrawable) r10;
        int r15 = r14.getNumberOfLayers();
        Drawable[] r16 = new Drawable[r15];
        int r17 = 0;
        int r18 = 0;
    L10:
        if (r18 >= r15) goto L19;
        int r19 = r14.getId(r18);
        Drawable r20 = r14.getDrawable(r18);
        if (r19 != 16908301) goto L14;
    L17:
        boolean r21 = true;
    L18:
        r16[r18] = d(r20, r21);
        r18 = r18 + 1;
        goto L10
    L14:
        if (r19 == 16908303) goto L17;
        r21 = false;
        goto L18
    L19:
        LayerDrawable r22 = new LayerDrawable(r16);
    L20:
        if (r17 >= r15) goto L22;
        r22.setId(r17, r14.getId(r17));
        a.a(r14, r22, r17);
        r17 = r17 + 1;
        goto L20
    L22:
        return r22;
    L24:
        if ((r10 instanceof BitmapDrawable) == false) goto L32;
        BitmapDrawable r23 = (BitmapDrawable) r10;
        Bitmap r24 = r23.getBitmap();
        if (this.f1042b != null) goto L28;
        this.f1042b = r24;
    L28:
        ShapeDrawable r25 = new ShapeDrawable(a());
        r25.getPaint().setShader(new BitmapShader(r24, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        r25.getPaint().setColorFilter(r23.getPaint().getColorFilter());
        if (r11 == true) goto L31;
        return r25;
    L31:
        return new ClipDrawable(r25, 3, 1);
    }

    public final Drawable e(Drawable r10) {
        if ((r10 instanceof AnimationDrawable) == false) goto L11;
        AnimationDrawable r11 = (AnimationDrawable) r10;
        int r12 = r11.getNumberOfFrames();
        AnimationDrawable r13 = new AnimationDrawable();
        r13.setOneShot(r11.isOneShot());
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L8;
        Drawable r15 = d(r11.getFrame(r14), true);
        r15.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r13.addFrame(r15, r11.getDuration(r14));
        r14 = r14 + 1;
        goto L6
    L8:
        r13.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        return r13;
    L11:
        return r10;
    }
}
