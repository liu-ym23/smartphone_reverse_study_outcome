package am4;

import android.view.View;
import com.bytedance.dux.stepper.DuxSteppers;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxSteppers f4387a;

    public c(DuxSteppers r100) {
        this.f4387a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f4387a.getOnValueChangeListener();
    }
}
