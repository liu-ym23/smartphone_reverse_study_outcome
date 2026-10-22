package com.obric.oui.swipeaction.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleCursorAdapter;
import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SimpleCursorSwipeAdapter extends SimpleCursorAdapter implements a {
    private com.obric.oui.swipeaction.a.a mItemManger;

    public SimpleCursorSwipeAdapter(Context r10, int r11, Cursor r12, String[] r13, int[] r14, int r15) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin"), r11, (Cursor) ZeusTransformUtils.wrapperContextForParams(r12, Cursor.class, "com.obric.aiagent.plugin"), r13, r14, r15);
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    public SimpleCursorSwipeAdapter(Context r9, int r10, Cursor r11, String[] r12, int[] r13) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), r10, (Cursor) ZeusTransformUtils.wrapperContextForParams(r11, Cursor.class, "com.obric.aiagent.plugin"), r12, r13);
        this.mItemManger = new com.obric.oui.swipeaction.a.a(this);
    }

    @Override // android.widget.CursorAdapter, android.widget.Adapter
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
