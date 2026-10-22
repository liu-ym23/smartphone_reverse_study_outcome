package ck9;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.larus.login.impl.view.TouristTipLayout;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes30.dex */
public final class h implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f24076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TouristTipLayout f24077b;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f24076a.getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f24076a.getLineCount() <= 1) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        this.f24076a.setTextSize(0, this.f24077b.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_sp_12, null, R.dimen.larus_sp_12)));
    L9:
        return !r100;
    L5:
        r100 = false;
        goto L6
    }

    public h(TextView r100, TouristTipLayout r101) {
        this.f24076a = r100;
        this.f24077b = r101;
    }
}
