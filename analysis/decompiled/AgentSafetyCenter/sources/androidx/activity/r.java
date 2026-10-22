package androidx.activity;

import android.graphics.Color;
import android.view.View;
import android.view.Window;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class r {
    static {
        Color.argb(230, 255, 255, 255);
        Color.argb(128, 27, 27, 27);
    }

    public static final void a(p pVar, h0 h0Var, h0 h0Var2) {
        View decorView = pVar.getWindow().getDecorView();
        decorView.getClass();
        decorView.getResources().getClass();
        decorView.getResources().getClass();
        s sVar = new s();
        Window window = pVar.getWindow();
        window.getClass();
        sVar.a(h0Var, h0Var2, window, decorView, true, true);
    }
}
