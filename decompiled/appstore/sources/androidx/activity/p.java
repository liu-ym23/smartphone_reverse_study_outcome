package androidx.activity;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final /* synthetic */ Rect a(View r10) {
        return b(r10);
    }

    public static final Rect b(View r10) {
        Rect r11 = new Rect();
        r10.getGlobalVisibleRect(r11);
        return r11;
    }
}
