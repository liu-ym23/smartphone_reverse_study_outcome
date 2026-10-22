package c64;

import android.util.Size;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f22592a;

    @Override // c64.e
    public final Size getSize() {
        int r100 = this.f22592a.getWidth();
        int r101 = this.f22592a.getHeight();
        if (r100 != 0) goto L5;
        r100 = this.f22592a.getMeasuredWidth();
    L5:
        if (r101 != 0) goto L8;
        r101 = this.f22592a.getMeasuredHeight();
    L8:
        return new Size(r100, r101);
    }

    public g(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        this.f22592a = r100;
    }
}
