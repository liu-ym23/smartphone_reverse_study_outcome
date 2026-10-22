package androidx.activity;

import android.window.OnBackInvokedCallback;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class x implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f706a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f707b;

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i = this.f706a;
        Object obj = this.f707b;
        switch (i) {
            case 0:
                ((xb.a) obj).invoke();
                break;
            case 1:
                ((h.e0) obj).B();
                break;
            default:
                ((Runnable) obj).run();
                break;
        }
    }
}
