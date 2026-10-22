package az2;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes12.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<View> f16802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f16803b;

    public final String getType() {
        return this.f16803b;
    }

    public f(View r100, String r101) {
        this.f16803b = r101;
        this.f16802a = new WeakReference(r100);
    }
}
