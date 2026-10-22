package androidx.activity;

import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.l;
import androidx.lifecycle.p;
import androidx.lifecycle.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements p {

    /* renamed from: a, reason: collision with root package name */
    public static int f241a;

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) throws SecurityException {
        if (lVar != l.ON_DESTROY) {
            return;
        }
        if (f241a == 0) {
            try {
                f241a = 2;
                InputMethodManager.class.getDeclaredField("mServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mNextServedView").setAccessible(true);
                InputMethodManager.class.getDeclaredField("mH").setAccessible(true);
                f241a = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f241a == 1) {
            throw null;
        }
    }
}
