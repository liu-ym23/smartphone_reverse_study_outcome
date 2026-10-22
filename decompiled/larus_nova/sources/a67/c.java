package a67;

import android.view.View;
import com.bytedance.praisedialoglib.manager.h;
import com.bytedance.praisedialoglib.ui.PraiseDialogActivity;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PraiseDialogActivity f1961a;

    public c(PraiseDialogActivity r100) {
        this.f1961a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        b67.a.a("evaluate_pop_bad", this.f1961a.f266678h);
        PraiseDialogActivity r101 = this.f1961a;
        r101.f266679i = true;
        r101.finish();
        h.c().getClass();
        h.e();
    }
}
