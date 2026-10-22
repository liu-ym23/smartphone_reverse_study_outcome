package com.android.ttcjpaysdk.base.ui.dialog.nativev2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.android.ttcjpaysdk.base.ktextension.CJPayViewExtensionsKt;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u001a\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0017\u001a\u00020\u000f2\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u00020\u000f2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rJ.\u0010\u001b\u001a\u00020\u000f2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\b2\u0014\b\u0002\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000f0\rR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayReasonSelectorLayout;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "items", "", "Lcom/android/ttcjpaysdk/base/ui/dialog/nativev2/CJPayKeepDialogLeaveReasonLayout;", "llReasonLine2", "Landroid/widget/LinearLayout;", "onItemClick", "Lkotlin/Function1;", "", "", "findSelectedText", SendEventContainerMethodParamModel.EventKinds.onClick, MapController.ITEM_LAYER_TAG, "setInnerMarginHV", "marginH", "", "marginV", "setItemStyle", "isSolid", "", "setOnItemClick", "updateContent", "uiComponentList", "Lcom/android/ttcjpaysdk/base/ui/data/UIComponent;", "updateUI", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayReasonSelectorLayout extends RelativeLayout {
    private final List<CJPayKeepDialogLeaveReasonLayout> items;
    private final LinearLayout llReasonLine2;
    private Function1<? super String, Unit> onItemClick;

    public final String findSelectedText() {
        Iterator<T> r100 = this.items.iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Object r101 = r100.next();
        if (((CJPayKeepDialogLeaveReasonLayout) r101).isSelectedState() == false) goto L4;
    L9:
        CJPayKeepDialogLeaveReasonLayout r102 = (CJPayKeepDialogLeaveReasonLayout) r101;
        if (r102 == null) goto L13;
        String r103 = r102.currentText();
        if (r103 == null) goto L13;
        return r103;
    L13:
        return "";
    L8:
        r101 = null;
        goto L9
    }

    private final void onClick(CJPayKeepDialogLeaveReasonLayout r100) {
        if (r100.isSelectedState() == false) goto L6;
        this.onItemClick.invoke(r100.currentText());
        r100.updateState(false);
        return;
    L6:
        Iterator<T> r101 = this.items.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((CJPayKeepDialogLeaveReasonLayout) r101.next()).updateState(false);
        goto L8
    L10:
        this.onItemClick.invoke(r100.currentText());
        r100.updateState(true);
    }

    public final void setItemStyle(boolean r100) {
        Iterator<T> r101 = this.items.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((CJPayKeepDialogLeaveReasonLayout) r101.next()).setItemStyle(r100);
        goto L4
    }

    public final void setOnItemClick(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.onItemClick = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CJPayReasonSelectorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_keep_dialog_leave_reason_selector_layout, this, true);
        this.llReasonLine2 = (LinearLayout) findViewById(R.id.ll_reason_line2);
        this.items = CollectionsKt.listOf(new CJPayKeepDialogLeaveReasonLayout[]{findViewById(R.id.leave_reason1), findViewById(R.id.leave_reason2), findViewById(R.id.leave_reason3), findViewById(R.id.leave_reason4)});
        this.onItemClick = CJPayReasonSelectorLayout$onItemClick$1.INSTANCE;
    }

    public static final /* synthetic */ void access$onClick(CJPayReasonSelectorLayout r100, CJPayKeepDialogLeaveReasonLayout r101) {
        r100.onClick(r101);
    }

    public final void setInnerMarginHV(int r100, int r110) {
        if (r100 <= 0) goto L9;
        CJPayKeepDialogLeaveReasonLayout r101 = (CJPayKeepDialogLeaveReasonLayout) CollectionsKt.getOrNull(this.items, 1);
        if (r101 == null) goto L6;
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(r101, Integer.valueOf(r100), null, null, null, 14, null);
    L6:
        CJPayKeepDialogLeaveReasonLayout r102 = (CJPayKeepDialogLeaveReasonLayout) CollectionsKt.getOrNull(this.items, 3);
        if (r102 == null) goto L9;
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(r102, Integer.valueOf(r100), null, null, null, 14, null);
    L9:
        if (r110 <= 0) goto L12;
        CJPayViewExtensionsKt.setMarginsDefaultCur$default(this.llReasonLine2, null, Integer.valueOf(r110), null, null, 13, null);
        return;
    }

    public final void updateContent(List<UIComponent> r100, Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "updateUI");
        boolean r102 = true;
        if (r100 == null) goto L20;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L6:
        if (r104.hasNext() == false) goto L21;
        Object r105 = r104.next();
        UIComponent r106 = (UIComponent) r105;
        if (r106 == null) goto L17;
        String r107 = r106.text;
        if (r107 == null) goto L17;
        if (r107.length() <= 0) goto L14;
        boolean r108 = true;
    L15:
        if (r108 != true) goto L17;
        boolean r109 = true;
    L18:
        if (r109 == false) goto L6;
        r103.add(r105);
        goto L6
    L14:
        r108 = false;
    L17:
        r109 = false;
    L21:
        if (r103 != null) goto L23;
    L25:
        boolean r110 = false;
    L26:
        if (r110 == false) goto L47;
        int r111 = Math.min(r103.size(), this.items.size());
        Iterator<T> r112 = this.items.iterator();
    L29:
        if (r112.hasNext() == false) goto L31;
        ((CJPayKeepDialogLeaveReasonLayout) r112.next()).setVisibility(8);
        goto L29
    L31:
        LinearLayout r113 = this.llReasonLine2;
        if (r111 > 2) goto L35;
        r102 = false;
    L35:
        CJPayViewExtensionsKt.toggleVisible(r113, r102);
        int r114 = 0;
    L36:
        if (r114 >= r111) goto L46;
        CJPayKeepDialogLeaveReasonLayout r115 = (CJPayKeepDialogLeaveReasonLayout) CollectionsKt.getOrNull(this.items, r114);
        if (r115 == null) goto L45;
        r115.setVisibility(0);
        UIComponent r116 = (UIComponent) CollectionsKt.getOrNull(r103, r114);
        if (r116 == null) goto L43;
        String r117 = r116.text;
        if (r117 == null) goto L43;
    L44:
        r115.updateText(r117);
        CJPayViewExtensionsKt.setDebouncingOnClickListener(r115, new CJPayReasonSelectorLayout$updateContent$3$1(this));
    L43:
        r117 = "";
    L45:
        r114 = r114 + 1;
        goto L36
    L46:
        CJPayViewExtensionsKt.viewVisible(this);
        r101.invoke(Boolean.TRUE);
        return;
    L47:
        CJPayViewExtensionsKt.viewGone(this);
        r101.invoke(Boolean.FALSE);
        return;
    L23:
        if ((!r103.isEmpty()) != true) goto L25;
        r110 = true;
        goto L26
    L20:
        r103 = null;
        goto L21
    }

    public static /* synthetic */ void setItemStyle$default(CJPayReasonSelectorLayout r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.setItemStyle(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnItemClick$default(CJPayReasonSelectorLayout r100, Function1 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = AnonymousClass1.INSTANCE;
    L5:
        r100.setOnItemClick(r101);
    }

    public static /* synthetic */ void setInnerMarginHV$default(CJPayReasonSelectorLayout r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = -1;
    L8:
        r100.setInnerMarginHV(r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateContent$default(CJPayReasonSelectorLayout r100, List r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = C89181.INSTANCE;
    L5:
        r100.updateContent(r101, r102);
    }
}
