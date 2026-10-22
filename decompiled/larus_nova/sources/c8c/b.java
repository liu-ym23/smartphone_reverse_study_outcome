package c8c;

import android.content.DialogInterface;
import android.view.View;
import com.ss.android.lark.ui.CommonDialog;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f22756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CommonDialog f22757b;

    public b(CommonDialog r100) {
        this.f22756a = null;
        this.f22757b = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        DialogInterface.OnClickListener r101 = this.f22756a;
        if (r101 == null) goto L6;
        r101.onClick(this.f22757b, 0);
        return;
    }
}
