package bj4;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes15.dex */
public abstract class v {

    public static final class a {
    }

    static {
    }

    public v() {
    }

    public abstract View a();

    public final Rect b() {
        View r100 = a();
        if (r100 != null) goto L6;
    L7:
        return null;
    L6:
        if (ViewCompat.isAttachedToWindow(r100) == false) goto L7;
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = r101[0];
        int r103 = r101[1];
        return new Rect(r102, r103, (int) (r102 + (r100.getWidth() * r100.getScaleX())), (int) (r103 + (r100.getHeight() * r100.getScaleY())));
    }
}
