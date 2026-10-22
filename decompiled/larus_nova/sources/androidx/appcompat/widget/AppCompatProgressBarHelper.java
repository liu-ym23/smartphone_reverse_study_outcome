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

/* JADX INFO: loaded from: classes2.dex */
class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = null;
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    static {
        TINT_ATTRS = new int[]{R.attr.indeterminateDrawable, R.attr.progressDrawable};
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    public Bitmap getSampleTile() {
        return this.mSampleTile;
    }

    public AppCompatProgressBarHelper(ProgressBar r100) {
        this.mView = r100;
    }

    private Drawable tileifyIndeterminate(Drawable r100) {
        if ((r100 instanceof AnimationDrawable) == false) goto L11;
        AnimationDrawable r101 = (AnimationDrawable) r100;
        int r102 = r101.getNumberOfFrames();
        AnimationDrawable r103 = new AnimationDrawable();
        r103.setOneShot(r101.isOneShot());
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L8;
        Drawable r105 = tileify(r101.getFrame(r104), true);
        r105.setLevel(10000);
        r103.addFrame(r105, r101.getDuration(r104));
        r104 = r104 + 1;
        goto L6
    L8:
        r103.setLevel(10000);
        return r103;
    L11:
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable tileify(Drawable r100, boolean r101) {
        if ((r100 instanceof WrappedDrawable) == false) goto L8;
        WrappedDrawable r102 = (WrappedDrawable) r100;
        Drawable r103 = r102.getWrappedDrawable();
        if (r103 == null) goto L32;
        r102.setWrappedDrawable(tileify(r103, r101));
    L32:
        return r100;
    L8:
        if ((r100 instanceof LayerDrawable) == false) goto L24;
        LayerDrawable r104 = (LayerDrawable) r100;
        int r105 = r104.getNumberOfLayers();
        Drawable[] r106 = new Drawable[r105];
        int r107 = 0;
        int r108 = 0;
    L10:
        if (r108 >= r105) goto L19;
        int r109 = r104.getId(r108);
        Drawable r110 = r104.getDrawable(r108);
        if (r109 != 16908301) goto L14;
    L17:
        boolean r111 = true;
    L18:
        r106[r108] = tileify(r110, r111);
        r108 = r108 + 1;
        goto L10
    L14:
        if (r109 == 16908303) goto L17;
        r111 = false;
        goto L18
    L19:
        LayerDrawable r112 = new LayerDrawable(r106);
    L20:
        if (r107 >= r105) goto L22;
        r112.setId(r107, r104.getId(r107));
        r107 = r107 + 1;
        goto L20
    L22:
        return r112;
    L24:
        if ((r100 instanceof BitmapDrawable) == false) goto L32;
        BitmapDrawable r113 = (BitmapDrawable) r100;
        Bitmap r114 = r113.getBitmap();
        if (this.mSampleTile != null) goto L28;
        this.mSampleTile = r114;
    L28:
        ShapeDrawable r115 = new ShapeDrawable(getDrawableShape());
        BitmapShader r116 = new BitmapShader(r114, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
        r115.getPaint().setShader(r116);
        r115.getPaint().setColorFilter(r113.getPaint().getColorFilter());
        if (r101 == true) goto L31;
        return r115;
    L31:
        return new ClipDrawable(r115, 3, 1);
    }

    public void loadFromAttributes(AttributeSet r100, int r101) {
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), r100, TINT_ATTRS, r101, 0);
        Drawable r103 = r102.getDrawableIfKnown(0);
        if (r103 == null) goto L5;
        this.mView.setIndeterminateDrawable(tileifyIndeterminate(r103));
    L5:
        Drawable r104 = r102.getDrawableIfKnown(1);
        if (r104 == null) goto L8;
        this.mView.setProgressDrawable(tileify(r104, false));
    L8:
        r102.recycle();
    }
}
