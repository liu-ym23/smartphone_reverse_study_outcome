package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;

/* renamed from: androidx.core.view.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1322j {

    /* renamed from: androidx.core.view.j$a */
    public interface a {
        boolean superDispatchKeyEvent(KeyEvent keyEvent);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        return N.g(view, keyEvent);
    }

    @SuppressLint({"LambdaLast"})
    public static boolean b(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return aVar.superDispatchKeyEvent(keyEvent);
    }
}
