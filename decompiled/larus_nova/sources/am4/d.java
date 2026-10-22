package am4;

import android.view.View;
import com.bytedance.dux.stepper.DuxSteppers;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DuxSteppers f4388a;

    public d(DuxSteppers r100) {
        this.f4388a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f4388a.getOnValueChangeListener();
    }
}
