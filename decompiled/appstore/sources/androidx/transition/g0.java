package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* JADX INFO: loaded from: classes.dex */
public class g0 implements WindowIdImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowId f5067a;

    public g0(View r10) {
        this.f5067a = r10.getWindowId();
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof g0) == true) goto L5;
    L7:
        return false;
    L5:
        if (((g0) r10).f5067a.equals(this.f5067a) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.f5067a.hashCode();
    }
}
