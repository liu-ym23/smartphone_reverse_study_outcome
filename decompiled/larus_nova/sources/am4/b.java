package am4;

import android.view.View;
import com.bytedance.dux.stepper.DuxSteppers;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxSteppers f4386a;

    public b(DuxSteppers r100) {
        this.f4386a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DuxSteppers r101 = this.f4386a;
        int r102 = r101.f205667h - r101.f205670k;
        if (r102 >= r101.f205668i) goto L5;
        return;
    L5:
        if (r102 > r101.f205669j) goto L10;
        DuxSteppers.R5(r101, r102);
        this.f4386a.f205664e.clearFocus();
        return;
    }
}
