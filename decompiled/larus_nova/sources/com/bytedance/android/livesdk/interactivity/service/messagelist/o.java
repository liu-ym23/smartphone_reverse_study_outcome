package com.bytedance.android.livesdk.interactivity.service.messagelist;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f140910a;

    public o(m r100) {
        this.f140910a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IMessageListManager.a r101 = (IMessageListManager.a) r100;
        if (r101 == null) goto L33;
        int r102 = n.f140909a[r101.getType().ordinal()];
        if (r102 != 1) goto L8;
        this.f140910a.f140903a.notifyDataSetChanged();
        MessageListScrollManager r103 = this.f140910a.f140904b;
        RecyclerView.Adapter r104 = r103.f140873l.getAdapter();
        if (r104 == null) goto L31;
        int r105 = r104.getItemCount() - 1;
        r103.f140873l.scrollToPosition(r105);
        r103.d(r105);
    L31:
        this.f140910a.f140904b.onEvent(r101);
        return;
    L8:
        if (r102 != 2) goto L10;
        this.f140910a.f140903a.notifyItemInserted(r101.f140854b);
        MessageListScrollManager r106 = this.f140910a.f140904b;
        if (r106.f140862a != MessageListScrollManager.ScrollState.AutoScroll) goto L31;
        RecyclerView.Adapter r107 = r106.f140873l.getAdapter();
        if (r107 == null) goto L31;
        int r108 = r107.getItemCount() - 1;
        if (r106.f140871j == false) goto L26;
        r106.f140873l.smoothScrollToPosition(r108);
    L27:
        r106.d(r108);
        goto L31
    L26:
        r106.f140873l.scrollToPosition(r108);
        goto L27
    L10:
        if (r102 != 3) goto L12;
        this.f140910a.f140903a.notifyItemInserted(r101.f140854b);
        goto L31
    L12:
        if (r102 != 4) goto L14;
        this.f140910a.f140903a.notifyDataSetChanged();
        goto L31
    L14:
        if (r102 != 5) goto L31;
        this.f140910a.f140903a.notifyItemRangeRemoved(r101.f140855c, r101.f140856d);
        goto L31
    }
}
