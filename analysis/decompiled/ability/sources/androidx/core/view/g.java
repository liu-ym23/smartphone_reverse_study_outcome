package androidx.core.view;

import android.view.View;
import androidx.core.view.SoftwareKeyboardControllerCompat;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1937a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i) {
        this.f1937a = i;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f1937a;
        Object obj = this.b;
        switch (i) {
            case 0:
                SoftwareKeyboardControllerCompat.Impl20.lambda$show$0((View) obj);
                break;
            default:
                ((S7.a) obj).invoke();
                break;
        }
    }
}
