package androidx.activity;

import android.view.View;
import d.h.b.o;

/* JADX INFO: compiled from: PipHintTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f142a = null;

    static {
        f142a = new a();
    }

    private a() {
    }

    public final boolean a(View r1) {
        o.e(r1, "view");
        return r1.isAttachedToWindow();
    }
}
