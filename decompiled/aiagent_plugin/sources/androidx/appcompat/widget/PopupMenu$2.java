package androidx.appcompat.widget;

import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes.dex */
class PopupMenu$2 implements PopupWindow.OnDismissListener {
    final /* synthetic */ t this$0;

    PopupMenu$2(t r1) {
        this.this$0 = r1;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        if (this.this$0.f477b == null) goto L6;
        this.this$0.f477b.a(this.this$0);
        return;
    }
}
