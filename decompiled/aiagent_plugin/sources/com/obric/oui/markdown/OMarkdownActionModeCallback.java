package com.obric.oui.markdown;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OMarkdownActionModeCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OMarkdownActionModeCallback extends ActionMode.Callback2 {
    private final a delegate;
    private RectF selectionRect;

    /* JADX INFO: compiled from: OMarkdownActionModeCallback.kt */
    public interface a {
        void onCopy();

        void onSelectAll();
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r1) {
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r1, Menu r2) {
        Menu r0 = (Menu) ZeusTransformUtils.wrapperContextForParams(r2, Menu.class, "com.obric.aiagent.plugin");
        return true;
    }

    public OMarkdownActionModeCallback(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "delegate");
        this.delegate = r4;
        this.selectionRect = new RectF();
    }

    public final RectF getSelectionRect() {
        return this.selectionRect;
    }

    public final void setSelectionRect(RectF r2) {
        o.e(r2, "<set-?>");
        this.selectionRect = r2;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r3, Menu r4) {
        Menu r2 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L9;
        MenuInflater r5 = r3.getMenuInflater();
        if (r5 == null) goto L10;
        r5.inflate(ZeusTransformUtils.mapRes(R.menu.markdown_action_mode, "menu", "markdown_action_mode"), r2);
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r4, MenuItem r5) {
        MenuItem r6 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r5, MenuItem.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        Integer r7 = Integer.valueOf(r6.getItemId());
    L6:
        int r8 = ZeusTransformUtils.mapRes(R.id.action_mode_copy, DbHelper.COL_ID, "action_mode_copy");
        if (r7 != null) goto L10;
    L12:
        int r9 = ZeusTransformUtils.mapRes(R.id.action_mode_select_all, DbHelper.COL_ID, "action_mode_select_all");
        if (r7 != null) goto L16;
    L18:
        return false;
    L16:
        if (r7.intValue() != r9) goto L18;
        this.delegate.onSelectAll();
        return true;
    L10:
        if (r7.intValue() != r8) goto L12;
        this.delegate.onCopy();
        return true;
    L5:
        r7 = null;
        goto L6
    }

    @Override // android.view.ActionMode.Callback2
    public void onGetContentRect(ActionMode r2, View r3, Rect r4) {
        if (r4 == null) goto L5;
        r4.set((int) this.selectionRect.left, (int) this.selectionRect.top, (int) this.selectionRect.right, (int) this.selectionRect.bottom);
        return;
    }
}
