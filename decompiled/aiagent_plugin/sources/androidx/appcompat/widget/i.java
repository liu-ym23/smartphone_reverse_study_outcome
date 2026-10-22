package androidx.appcompat.widget;

import android.R;
import android.content.Context;
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
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppCompatProgressBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f440a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProgressBar f441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bitmap f442c;

    /* JADX INFO: compiled from: AppCompatProgressBarHelper.java */
    private static class a {
        public static void a(LayerDrawable r1, LayerDrawable r2, int r3) {
            r2.setLayerGravity(r3, r1.getLayerGravity(r3));
            r2.setLayerWidth(r3, r1.getLayerWidth(r3));
            r2.setLayerHeight(r3, r1.getLayerHeight(r3));
            r2.setLayerInsetLeft(r3, r1.getLayerInsetLeft(r3));
            r2.setLayerInsetRight(r3, r1.getLayerInsetRight(r3));
            r2.setLayerInsetTop(r3, r1.getLayerInsetTop(r3));
            r2.setLayerInsetBottom(r3, r1.getLayerInsetBottom(r3));
            r2.setLayerInsetStart(r3, r1.getLayerInsetStart(r3));
            r2.setLayerInsetEnd(r3, r1.getLayerInsetEnd(r3));
        }
    }

    static {
        f440a = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    i(ProgressBar r1) {
        this.f441b = r1;
    }

    void a(AttributeSet r4, int r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        y r7 = y.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f441b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6, f440a, r5, 0);
        Drawable r8 = r7.b(0);
        if (r8 == null) goto L5;
        this.f441b.setIndeterminateDrawable(a(r8));
    L5:
        Drawable r9 = r7.b(1);
        if (r9 == null) goto L8;
        this.f441b.setProgressDrawable(a(r9, false));
    L8:
        r7.b();
    }

    Drawable a(Drawable r8, boolean r9) {
        if (ZeusTransformUtils.instanceOf(r8, androidx.core.graphics.drawable.d.class) == false) goto L8;
        Drawable r0 = ((androidx.core.graphics.drawable.d) ZeusTransformUtils.preCheckCast(r8, androidx.core.graphics.drawable.d.class, "com.obric.aiagent.plugin")).getWrappedDrawable();
        if (r0 == null) goto L35;
        ((androidx.core.graphics.drawable.d) ZeusTransformUtils.preCheckCast(r8, androidx.core.graphics.drawable.d.class, "com.obric.aiagent.plugin")).setWrappedDrawable(a(r0, r9));
    L35:
        return r8;
    L8:
        if (ZeusTransformUtils.instanceOf(r8, LayerDrawable.class) == false) goto L27;
        LayerDrawable r10 = (LayerDrawable) ZeusTransformUtils.preCheckCast(r8, LayerDrawable.class, "com.obric.aiagent.plugin");
        int r11 = r10.getNumberOfLayers();
        Drawable[] r1 = new Drawable[r11];
        int r2 = 0;
        int r3 = 0;
    L10:
        if (r3 >= r11) goto L19;
        int r4 = r10.getId(r3);
        Drawable r5 = r10.getDrawable(r3);
        if (r4 != 16908301) goto L14;
    L17:
        boolean r6 = true;
    L18:
        r1[r3] = a(r5, r6);
        r3 = r3 + 1;
        goto L10
    L14:
        if (r4 == 16908303) goto L17;
        r6 = false;
        goto L18
    L19:
        LayerDrawable r7 = new LayerDrawable(r1);
    L20:
        if (r2 >= r11) goto L25;
        r7.setId(r2, r10.getId(r2));
        if (Build.VERSION.SDK_INT < 23) goto L24;
        a.a(r10, r7, r2);
    L24:
        r2 = r2 + 1;
        goto L20
    L25:
        return r7;
    L27:
        if (ZeusTransformUtils.instanceOf(r8, BitmapDrawable.class) == false) goto L35;
        BitmapDrawable r12 = (BitmapDrawable) ZeusTransformUtils.preCheckCast(r8, BitmapDrawable.class, "com.obric.aiagent.plugin");
        Bitmap r13 = r12.getBitmap();
        if (this.f442c != null) goto L31;
        this.f442c = r13;
    L31:
        ShapeDrawable r14 = new ShapeDrawable(b());
        r14.getPaint().setShader(new BitmapShader(r13, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
        r14.getPaint().setColorFilter(r12.getPaint().getColorFilter());
        if (r9 == true) goto L34;
        return r14;
    L34:
        return new ClipDrawable(r14, 3, 1);
    }

    private Drawable a(Drawable r7) {
        if (ZeusTransformUtils.instanceOf(r7, AnimationDrawable.class) == false) goto L11;
        AnimationDrawable r8 = (AnimationDrawable) ZeusTransformUtils.preCheckCast(r7, AnimationDrawable.class, "com.obric.aiagent.plugin");
        int r0 = r8.getNumberOfFrames();
        AnimationDrawable r1 = new AnimationDrawable();
        r1.setOneShot(r8.isOneShot());
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        Drawable r4 = a(r8.getFrame(r2), true);
        r4.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r1.addFrame(r4, r8.getDuration(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        r1.setLevel(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        return r1;
    L11:
        return r7;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    Bitmap a() {
        return this.f442c;
    }
}
