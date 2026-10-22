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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OMultiSelectionPanelView.kt */
/* JADX INFO: loaded from: classes4.dex */
public class OMultiSelectionPanelView extends OSelectionPanelView {

    /* JADX INFO: compiled from: OMultiSelectionPanelView.kt */
    public interface a {
        void a(int r1);

        void a(List<OSelectionPanelItemView> r1, List<Integer> r2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public boolean isMultiSelect() {
        return true;
    }

    public /* synthetic */ OMultiSelectionPanelView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OMultiSelectionPanelView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void select(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L10;
        ((OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(getItemViews().get(r3), OSelectionPanelItemView.class, "com.obric.aiagent.plugin")).select();
        return;
    L10:
        return;
    L5:
        if (r3 >= getItemViews().size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void initHeight() {
        if (getItemViews().size() <= 7) goto L5;
        setScrollViewHeight(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), BDAbstractUpload.KeyIsSocketWriteTimeout));
        return;
    L5:
        setScrollViewHeight(-2);
    }

    public final List<Integer> getSelectedItems() {
        List<Integer> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(getItemViews(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r6.hasNext() == false) goto L12;
        Object r3 = r6.next();
        int r4 = r1 + 1;
        if (r1 >= 0) goto L9;
        p.c();
    L9:
        if (((OSelectionPanelItemView) ZeusTransformUtils.preCheckCast(r3, OSelectionPanelItemView.class, "com.obric.aiagent.plugin")).isItemSelected() == false) goto L11;
        r0.add(Integer.valueOf(r1));
    L11:
        r1 = r4;
        goto L4
    L12:
        return r0;
    }

    public final void registerMultiItemSelectListener(a r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        setOnMultiItemSelectListener(r4);
    }
}
