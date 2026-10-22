package b8c;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends b8c.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f18243b;

    public interface a {
        void a();
    }

    public b() {
        this.f18243b = null;
    }

    @Override // b8c.a
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        a r101 = this.f18243b;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
