package a1;

import android.view.KeyEvent;
import q7.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final KeyEvent f155a;

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return k.a(this.f155a, ((c) obj).f155a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f155a.hashCode();
    }

    public final String toString() {
        return "KeyEvent(nativeKeyEvent=" + this.f155a + ')';
    }
}
