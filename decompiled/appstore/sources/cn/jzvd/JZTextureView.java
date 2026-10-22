package cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.bytedanceos.common.toolbox.i;

/* JADX INFO: loaded from: classes.dex */
public class JZTextureView extends TextureView {
    protected static final String TAG = "JZResizeTextureView";
    public int currentVideoHeight;
    public int currentVideoWidth;

    public JZTextureView(Context r10) {
        super(r10);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }

    @Override // android.view.View
    public void onMeasure(int r18, int r19) {
        i.e(TAG, "onMeasure  [" + hashCode() + "] ");
        int r10 = (int) getRotation();
        int r11 = this.currentVideoWidth;
        int r12 = this.currentVideoHeight;
        int r13 = ((View) getParent()).getMeasuredHeight();
        int r14 = ((View) getParent()).getMeasuredWidth();
        if (r14 == 0) goto L13;
        if (r13 == 0) goto L13;
        if (r11 == 0) goto L13;
        if (r12 == 0) goto L13;
        if (Jzvd.VIDEO_IMAGE_DISPLAY_TYPE != 1) goto L13;
        if (r10 == 90) goto L11;
        if (r10 == 270) goto L11;
    L12:
        r12 = (r11 * r13) / r14;
    L11:
        r14 = r13;
        r13 = r14;
    L13:
        if (r10 == 90) goto L17;
        if (r10 == 270) goto L17;
        int r15 = r18;
        int r16 = r19;
    L18:
        int r17 = TextureView.getDefaultSize(r11, r15);
        int r110 = TextureView.getDefaultSize(r12, r16);
        if (r11 <= 0) goto L46;
        if (r12 <= 0) goto L46;
        int r111 = View.MeasureSpec.getMode(r15);
        int r112 = View.MeasureSpec.getSize(r15);
        int r113 = View.MeasureSpec.getMode(r16);
        int r114 = View.MeasureSpec.getSize(r16);
        i.e(TAG, "widthMeasureSpec  [" + View.MeasureSpec.toString(r15) + "]");
        i.e(TAG, "heightMeasureSpec [" + View.MeasureSpec.toString(r16) + "]");
        if (r111 != 1073741824) goto L27;
        if (r113 != 1073741824) goto L27;
        r17 = r112;
    L25:
        r110 = r114;
    L27:
        if (r111 != 1073741824) goto L33;
        int r20 = (r112 * r12) / r11;
        if (r113 != Integer.MIN_VALUE) goto L32;
        if (r20 <= r114) goto L32;
        r17 = (r114 * r11) / r12;
    L32:
        r17 = r112;
        r110 = r20;
        goto L46
    L33:
        if (r113 != 1073741824) goto L39;
        int r21 = (r114 * r11) / r12;
        if (r111 != Integer.MIN_VALUE) goto L38;
        if (r21 <= r112) goto L38;
        r20 = (r112 * r12) / r11;
    L38:
        r17 = r21;
        goto L25
    L39:
        if (r113 != Integer.MIN_VALUE) goto L42;
        if (r12 <= r114) goto L42;
        r21 = (r114 * r11) / r12;
    L43:
        if (r111 != Integer.MIN_VALUE) goto L38;
        if (r21 <= r112) goto L38;
        r20 = (r112 * r12) / r11;
    L42:
        r21 = r11;
        r114 = r12;
    L46:
        if (r14 == 0) goto L65;
        if (r13 == 0) goto L65;
        if (r11 == 0) goto L65;
        if (r12 == 0) goto L65;
        int r22 = Jzvd.VIDEO_IMAGE_DISPLAY_TYPE;
        if (r22 != 3) goto L54;
    L66:
        setMeasuredDimension(r11, r12);
        return;
    L54:
        if (r22 != 2) goto L65;
        if (r10 != 90) goto L57;
    L58:
        int r115 = r14;
        r14 = r13;
        r13 = r115;
    L59:
        double r23 = ((double) r12) / ((double) r11);
        double r24 = r13;
        double r25 = r14;
        double r26 = r24 / r25;
        if (r23 <= r26) goto L63;
        r12 = (int) ((r25 / ((double) r17)) * ((double) r110));
        r11 = r14;
        goto L66
    L63:
        if (r23 >= r26) goto L65;
        r11 = (int) ((r24 / ((double) r110)) * ((double) r17));
        r12 = r13;
        goto L66
    L57:
        if (r10 != 270) goto L59;
    L65:
        r11 = r17;
        r12 = r110;
    L17:
        r16 = r18;
        r15 = r19;
        goto L18
    }

    @Override // android.view.View
    public void setRotation(float r10) {
        if (r10 == getRotation()) goto L6;
        super.setRotation(r10);
        requestLayout();
        return;
    }

    public void setVideoSize(int r10, int r11) {
        if (this.currentVideoWidth == r10) goto L5;
    L6:
        this.currentVideoWidth = r10;
        this.currentVideoHeight = r11;
        requestLayout();
        return;
    L5:
        if (this.currentVideoHeight != r11) goto L6;
    }

    public JZTextureView(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
