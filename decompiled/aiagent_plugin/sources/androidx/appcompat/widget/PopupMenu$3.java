package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
class PopupMenu$3 extends ForwardingListener {
    final /* synthetic */ t this$0;

    PopupMenu$3(t r1, View r2) {
        this.this$0 = r1;
        super(r2);
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStarted() {
        this.this$0.a();
        return true;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public boolean onForwardingStopped() {
        this.this$0.b();
        return true;
    }

    @Override // androidx.appcompat.widget.ForwardingListener
    public androidx.appcompat.view.menu.f getPopup() {
        return this.this$0.f476a.b();
    }
}
