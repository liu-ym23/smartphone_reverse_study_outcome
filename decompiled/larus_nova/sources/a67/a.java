package a67;

import android.view.View;
import com.bytedance.praisedialoglib.ui.PraiseDialogActivity;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PraiseDialogActivity f1959a;

    public a(PraiseDialogActivity r100) {
        this.f1959a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f1959a.finish();
    }
}
