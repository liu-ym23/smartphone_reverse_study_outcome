package androidx.core.view;

import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* renamed from: androidx.core.view.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0465j {

    /* renamed from: androidx.core.view.j$a */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return H.h(view, keyEvent);
    }

    public static boolean b(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return aVar.superDispatchKeyEvent(keyEvent);
    }
}
