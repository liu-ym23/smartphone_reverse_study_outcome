package androidx.appcompat.app;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class ActionBarDrawerToggle$1 implements View.OnClickListener {
    final /* synthetic */ a this$0;

    ActionBarDrawerToggle$1(a r1) {
        this.this$0 = r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.this$0.f237a == false) goto L6;
        this.this$0.a();
        return;
    L6:
        if (this.this$0.f238b == null) goto L10;
        this.this$0.f238b.onClick(r2);
        return;
    }
}
