package bt4;

import android.view.View;
import at4.c;
import com.bytedance.ee.bear.bitable.uikit.Action;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ gv4.a f20556a;

    public a(c r100) {
        this.f20556a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        gv4.a r101 = this.f20556a;
        if (r101 == null) goto L6;
        r101.a(new Action(null, null, 3, null));
        return;
    }
}
