package androidx.core.text.method;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.os.BuildCompat;

/* JADX INFO: loaded from: classes17.dex */
public class LinkMovementMethodCompat extends LinkMovementMethod {
    private static LinkMovementMethodCompat sInstance;

    public static LinkMovementMethodCompat getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new LinkMovementMethodCompat();
    L6:
        return sInstance;
    }

    private LinkMovementMethodCompat() {
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView r100, Spannable r101, MotionEvent r102) {
        if (BuildCompat.isAtLeastV() == true) goto L22;
        int r103 = r102.getAction();
        boolean r104 = true;
        if (r103 == 1) goto L7;
        if (r103 != 0) goto L22;
    L7:
        int r105 = (int) r102.getX();
        int r106 = (int) r102.getY();
        int r107 = r105 - r100.getTotalPaddingLeft();
        int r108 = r106 - r100.getTotalPaddingTop();
        int r109 = r107 + r100.getScrollX();
        int r110 = r108 + r100.getScrollY();
        Layout r111 = r100.getLayout();
        if (r110 >= 0) goto L10;
    L18:
        if (r104 == false) goto L22;
        Selection.removeSelection(r101);
        return Touch.onTouchEvent(r100, r101, r102);
    L10:
        if (r110 > r111.getHeight()) goto L18;
        int r112 = r111.getLineForVertical(r110);
        float r113 = r109;
        if (r113 < r111.getLineLeft(r112)) goto L18;
        if (r113 > r111.getLineRight(r112)) goto L18;
        r104 = false;
    L22:
        return super.onTouchEvent(r100, r101, r102);
    }
}
