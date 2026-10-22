package androidx.appcompat.widget;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class U0 extends X.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3012a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f3013b;

    public U0(EditText editText) {
        this.f3013b = new WeakReference(editText);
    }

    @Override // X.h
    public final void a() {
        switch (this.f3012a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) this.f3013b.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
        }
    }

    @Override // X.h
    public final void b() {
        WeakReference weakReference = this.f3013b;
        switch (this.f3012a) {
            case 0:
                SwitchCompat switchCompat = (SwitchCompat) weakReference.get();
                if (switchCompat != null) {
                    switchCompat.c();
                    break;
                }
                break;
            default:
                Z.j.a((EditText) weakReference.get(), 1);
                break;
        }
    }

    public U0(SwitchCompat switchCompat) {
        this.f3013b = new WeakReference(switchCompat);
    }
}
