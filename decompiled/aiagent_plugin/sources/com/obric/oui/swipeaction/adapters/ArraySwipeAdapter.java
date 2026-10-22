package com.obric.oui.swipeaction.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ArraySwipeAdapter<T> extends ArrayAdapter implements a {
    private com.obric.oui.swipeaction.a.a mItemManger;

    public ArraySwipeAdapter(Context r3, int r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4);
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public ArraySwipeAdapter(Context r3, int r4, int r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public ArraySwipeAdapter(Context r3, int r4, T[] r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5);
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public ArraySwipeAdapter(Context r3, int r4, int r5, T[] r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, r6);
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public ArraySwipeAdapter(Context r3, int r4, List<T> r5) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin"));
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public ArraySwipeAdapter(Context r3, int r4, int r5, List<T> r6) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), r4, r5, (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin"));
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    @Override // com.obric.oui.swipeaction.b.a
    public void notifyDatasetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int r1, View r2, ViewGroup r3) {
        View r4 = super.getView(r1, r2, r3);
        this.mItemManger.a(r4, r1);
        return r4;
    }

    public void openItem(int r1) {
        this.mItemManger.a(r1);
    }

    public void closeItem(int r1) {
        this.mItemManger.b(r1);
    }

    public void closeAllExcept(OSwipeLayout r1) {
        this.mItemManger.a(r1);
    }

    public void closeAllItems() {
        this.mItemManger.b();
    }

    public List<Integer> getOpenItems() {
        return this.mItemManger.c();
    }

    public List<OSwipeLayout> getOpenLayouts() {
        return this.mItemManger.d();
    }

    public void removeShownLayouts(OSwipeLayout r1) {
        this.mItemManger.b(r1);
    }

    public boolean isOpen(int r1) {
        return this.mItemManger.c(r1);
    }

    public com.obric.oui.swipeaction.c.a.EnumC0996a getMode() {
        return this.mItemManger.a();
    }

    public void setMode(com.obric.oui.swipeaction.c.a.EnumC0996a r1) {
        this.mItemManger.a(r1);
    }
}
