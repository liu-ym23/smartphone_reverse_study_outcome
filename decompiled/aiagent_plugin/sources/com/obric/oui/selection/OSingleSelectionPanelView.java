package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.ss.bduploader.BDAbstractUpload;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;

/* JADX INFO: compiled from: OSingleSelectionPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OSingleSelectionPanelView extends OSelectionPanelView {

    /* JADX INFO: compiled from: OSingleSelectionPanelView.kt */
    public interface a {
        void a(OSelectionPanelItemView r1, int r2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public boolean isMultiSelect() {
        return false;
    }

    public /* synthetic */ OSingleSelectionPanelView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = ZeusTransformUtils.mapRes(R.style.OSelectionPanel, "style", "OSelectionPanel");
    L8:
        this(r7, r8, r4);
    }

    public OSingleSelectionPanelView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void select(int r6) {
        int r0 = 0;
        if (r6 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L20;
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(getItemViews(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r5.hasNext() == false) goto L24;
        Object r2 = r5.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L15;
        p.c();
    L15:
        OSelectionPanelItemView r4 = (OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r2, OSelectionPanelItemView.class, "com.obric.aiagent.plugin");
        if (r0 != r6) goto L18;
        r4.select();
    L19:
        r0 = r3;
        goto L11
    L18:
        r4.unSelect();
        goto L19
    L24:
        return;
    L20:
        return;
    L5:
        if (r6 >= getItemViews().size()) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void initHeight() {
        if (ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L13;
        if (getItemViews().size() <= 7) goto L11;
        setScrollViewHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), BDAbstractUpload.KeyIsSocketWriteTimeout));
        return;
    L11:
        setScrollViewHeight(-2);
        return;
    L13:
        if (getItemViews().size() <= 2) goto L15;
        setScrollViewHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 112));
        return;
    L15:
        setScrollViewHeight(-2);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void registerItemSelectListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        setOnItemSelectListener(r4);
    }

    public final int getSelectedItem() {
        Iterator r5 = ((Iterable) ZeusTransformUtils.preCheckCast(getItemViews(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r0 = 0;
    L4:
        if (r5.hasNext() == false) goto L12;
        Object r2 = r5.next();
        int r3 = r0 + 1;
        if (r0 >= 0) goto L9;
        p.c();
    L9:
        if (((OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r2, OSelectionPanelItemView.class, "com.obric.aiagent.plugin")).isItemSelected() == true) goto L10;
        r0 = r3;
        goto L4
    L10:
        return r0;
    L12:
        return -1;
    }
}
