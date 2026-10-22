package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SharedElementCallback.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Matrix f1140a;

    /* JADX INFO: compiled from: SharedElementCallback.java */
    public interface a {
        void onSharedElementsReady();
    }

    public void a(List<View> r2) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
    }

    public void a(List<String> r2, List<View> r3, List<View> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
    }

    public void a(List<String> r2, Map<String, View> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public void b(List<String> r2, List<View> r3, List<View> r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
    }

    public Parcelable a(View r6, Matrix r7, RectF r8) {
        if (ZeusTransformUtils.instanceOf(r6, ImageView.class) == false) goto L13;
        ImageView r0 = (ImageView) ZeusTransformUtils.preCheckCast(r6, ImageView.class, "com.obric.aiagent.plugin");
        Drawable r1 = r0.getDrawable();
        Drawable r2 = r0.getBackground();
        if (r1 == null) goto L13;
        if (r2 != null) goto L13;
        Bitmap r3 = a(r1);
        if (r3 == null) goto L13;
        Bundle r5 = new Bundle();
        r5.putParcelable("sharedElement:snapshot:bitmap", r3);
        r5.putString("sharedElement:snapshot:imageScaleType", r0.getScaleType().toString());
        if (r0.getScaleType() != ImageView.ScaleType.MATRIX) goto L12;
        float[] r9 = new float[9];
        r0.getImageMatrix().getValues(r9);
        r5.putFloatArray("sharedElement:snapshot:imageMatrix", r9);
    L12:
        return r5;
    L13:
        int r4 = Math.round(r8.width());
        int r10 = Math.round(r8.height());
        if (r4 <= 0) goto L21;
        if (r10 <= 0) goto L22;
        float r11 = Math.min(1.0f, 1048576.0f / (r4 * r10));
        int r12 = (int) (r4 * r11);
        int r13 = (int) (r10 * r11);
        if (this.f1140a != null) goto L19;
        this.f1140a = new Matrix();
    L19:
        this.f1140a.set(r7);
        this.f1140a.postTranslate(-r8.left, -r8.top);
        this.f1140a.postScale(r11, r11);
        Bitmap r14 = Bitmap.createBitmap(r12, r13, Bitmap.Config.ARGB_8888);
        Canvas r15 = new Canvas(r14);
        r15.concat(this.f1140a);
        r6.draw(r15);
        return r14;
    L22:
        return null;
    L21:
        return null;
    }

    private static Bitmap a(Drawable r9) {
        int r0 = r9.getIntrinsicWidth();
        int r1 = r9.getIntrinsicHeight();
        if (r0 <= 0) goto L14;
        if (r1 <= 0) goto L16;
        float r2 = Math.min(1.0f, 1048576.0f / (r0 * r1));
        if (ZeusTransformUtils.instanceOf(r9, BitmapDrawable.class) == true) goto L9;
    L12:
        int r3 = (int) (r0 * r2);
        int r4 = (int) (r1 * r2);
        Bitmap r5 = Bitmap.createBitmap(r3, r4, Bitmap.Config.ARGB_8888);
        Canvas r6 = new Canvas(r5);
        Rect r7 = r9.getBounds();
        int r8 = r7.left;
        int r10 = r7.top;
        int r11 = r7.right;
        int r12 = r7.bottom;
        r9.setBounds(0, 0, r3, r4);
        r9.draw(r6);
        r9.setBounds(r8, r10, r11, r12);
        return r5;
    L9:
        if (r2 != 1.0f) goto L12;
        return ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r9, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap();
    L16:
        return null;
    L14:
        return null;
    }

    public View a(Context r4, Parcelable r5) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r5, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Bundle.class) == false) goto L11;
        Bundle r7 = (Bundle) ZeusTransformUtils.preCheckCast(r6, Bundle.class, "com.obric.aiagent.plugin");
        Bitmap r8 = (Bitmap) ZeusTransformUtils.preCheckCast(r7.getParcelable("sharedElement:snapshot:bitmap"), Bitmap.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L7;
        return null;
    L7:
        ImageView r1 = new ImageView(r3);
        r1.setImageBitmap(r8);
        r1.setScaleType(ImageView.ScaleType.valueOf(r7.getString("sharedElement:snapshot:imageScaleType")));
        if (r1.getScaleType() != ImageView.ScaleType.MATRIX) goto L14;
        float[] r9 = r7.getFloatArray("sharedElement:snapshot:imageMatrix");
        Matrix r10 = new Matrix();
        r10.setValues(r9);
        r1.setImageMatrix(r10);
        return r1;
    L14:
        return r1;
    L11:
        if (ZeusTransformUtils.instanceOf(r6, Bitmap.class) == false) goto L16;
        Bitmap r11 = (Bitmap) ZeusTransformUtils.preCheckCast(r6, Bitmap.class, "com.obric.aiagent.plugin");
        ImageView r2 = new ImageView(r3);
        r2.setImageBitmap(r11);
        return r2;
    L16:
        return null;
    }

    public void a(List<String> r2, List<View> r3, a r4) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        ((a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin")).onSharedElementsReady();
    }
}
