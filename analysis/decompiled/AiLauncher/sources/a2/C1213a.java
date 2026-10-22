package a2;

import android.annotation.TargetApi;
import android.view.View;

/* renamed from: a2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1213a {
    public static void a(View view, Runnable runnable) {
        b(view, runnable);
    }

    @TargetApi(16)
    public static void b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
