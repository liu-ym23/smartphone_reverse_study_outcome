package com.obric.utils.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import com.android.contacts.R;
import com.obric.oui.lisitem.OListItemCheck;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SheetContainerListView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0014\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/utils/views/SheetContainerListView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemViews", "", "Lcom/obric/oui/lisitem/OListItemCheck;", "root", "getRoot", "()Landroid/widget/LinearLayout;", "setRoot", "(Landroid/widget/LinearLayout;)V", "select", "", "index", "", "setItems", "items", "", "Lcom/obric/utils/views/SheetContainerListView$SheetContainerItemDate;", "SheetContainerItemDate", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SheetContainerListView extends LinearLayout {
    private final List<OListItemCheck> itemViews;
    private LinearLayout root;

    /* JADX INFO: compiled from: SheetContainerListView.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0003JW\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fHÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\bHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018¨\u0006%"}, d2 = {"Lcom/obric/utils/views/SheetContainerListView$SheetContainerItemDate;", "", "title", "", "subTitle", "iconRes", "Landroid/graphics/drawable/Drawable;", "selectIndex", "", "showDivider", "", "callback", "Lkotlin/Function1;", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;IZLkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "getIconRes", "()Landroid/graphics/drawable/Drawable;", "getSelectIndex", "()I", "getShowDivider", "()Z", "getSubTitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SheetContainerItemDate {
        private final Function1<Integer, Unit> callback;
        private final Drawable iconRes;
        private final int selectIndex;
        private final boolean showDivider;
        private final String subTitle;
        private final String title;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SheetContainerItemDate copy$default(SheetContainerItemDate r4, String r5, String r6, Drawable r7, int r8, boolean r9, Function1 r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.title;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.subTitle;
        L8:
            String r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.iconRes;
        L11:
            Drawable r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.selectIndex;
        L14:
            int r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.showDivider;
        L17:
            boolean r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.callback;
        L20:
            String r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.subTitle;
        }

        public final Drawable component3() {
            return this.iconRes;
        }

        public final int component4() {
            return this.selectIndex;
        }

        public final boolean component5() {
            return this.showDivider;
        }

        public final Function1<Integer, Unit> component6() {
            return this.callback;
        }

        public final SheetContainerItemDate copy(String r8, String r9, Drawable r10, int r11, boolean r12, Function1<? super Integer, Unit> r13) {
            Intrinsics.checkNotNullParameter(r13, "callback");
            return new SheetContainerItemDate(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SheetContainerItemDate) == true) goto L8;
            return false;
        L8:
            SheetContainerItemDate r6 = (SheetContainerItemDate) r5;
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.subTitle, r6.subTitle) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.iconRes, r6.iconRes) == true) goto L18;
            return false;
        L18:
            if (this.selectIndex == r6.selectIndex) goto L21;
            return false;
        L21:
            if (this.showDivider == r6.showDivider) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.callback, r6.callback) == true) goto L26;
            return false;
        L26:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public int hashCode() {
            String r0 = this.title;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.subTitle;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Drawable r7 = this.iconRes;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            int r8 = (((r6 + r1) * 31) + Integer.hashCode(this.selectIndex)) * 31;
            boolean r9 = this.showDivider;
            ?? r10 = r9;
            if (r9 == false) goto L18;
            r10 = 1;
        L18:
            return ((r8 + r10) * 31) + this.callback.hashCode();
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SheetContainerItemDate(title=" + this.title + ", subTitle=" + this.subTitle + ", iconRes=" + this.iconRes + ", selectIndex=" + this.selectIndex + ", showDivider=" + this.showDivider + ", callback=" + this.callback + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public SheetContainerItemDate(String r2, String r3, Drawable r4, int r5, boolean r6, Function1<? super Integer, Unit> r7) {
            Intrinsics.checkNotNullParameter(r7, "callback");
            this.title = r2;
            this.subTitle = r3;
            this.iconRes = r4;
            this.selectIndex = r5;
            this.showDivider = r6;
            this.callback = r7;
        }

        public /* synthetic */ SheetContainerItemDate(String r10, String r11, Drawable r12, int r13, boolean r14, Function1 r15, int r16, DefaultConstructorMarker r17) {
            if ((r16 & 1) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r16 & 2) == 0) goto L9;
            String r4 = null;
        L11:
            if ((r16 & 4) == 0) goto L13;
            Drawable r5 = null;
        L15:
            if ((r16 & 8) == 0) goto L17;
            int r6 = 0;
        L19:
            if ((r16 & 16) == 0) goto L21;
            boolean r7 = false;
        L22:
            this(r3, r4, r5, r6, r7, r15);
            return;
        L21:
            r7 = r14;
            goto L22
        L17:
            r6 = r13;
            goto L19
        L13:
            r5 = r12;
            goto L15
        L9:
            r4 = r11;
            goto L11
        L5:
            r3 = r10;
            goto L7
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final Drawable getIconRes() {
            return this.iconRes;
        }

        public final int getSelectIndex() {
            return this.selectIndex;
        }

        public final boolean getShowDivider() {
            return this.showDivider;
        }

        public final Function1<Integer, Unit> getCallback() {
            return this.callback;
        }
    }

    public static /* synthetic */ void $r8$lambda$Zr3HffQ_upIQ4hntbSbrwhx_gpo(SheetContainerListView r0, int r1, SheetContainerItemDate r2, View r3) {
        setItems$lambda$3$lambda$2$lambda$1(r0, r1, r2, r3);
    }

    public SheetContainerListView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.itemViews = new ArrayList();
        LinearLayout.inflate(getContext(), R.layout.layout_sheet_container_list_view, this);
        View r4 = findViewById(R.id.root_layout);
        Intrinsics.checkNotNull(r4);
        this.root = (LinearLayout) r4;
    }

    public final LinearLayout getRoot() {
        return this.root;
    }

    public final void setRoot(LinearLayout r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.root = r2;
    }

    public final void select(int r6) {
        if (r6 >= 0) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L20;
        Iterator<T> r5 = this.itemViews.iterator();
        int r3 = 0;
    L11:
        if (r5.hasNext() == false) goto L24;
        Object r4 = r5.next();
        int r7 = r3 + 1;
        if (r3 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        OListItemCheck r8 = (OListItemCheck) r4;
        if (r3 != r6) goto L18;
        boolean r9 = true;
    L19:
        r8.setChecked(r9);
        r3 = r7;
        goto L11
    L18:
        r9 = false;
        goto L19
    L24:
        return;
    L20:
        return;
    L5:
        if (r6 >= this.itemViews.size()) goto L7;
        r2 = true;
        goto L8
    }

    public final void setItems(List<SheetContainerItemDate> r10) {
        Intrinsics.checkNotNullParameter(r10, "items");
        Iterator<T> r11 = r10.iterator();
        final int r1 = 0;
    L4:
        if (r11.hasNext() == false) goto L13;
        Object r2 = r11.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final SheetContainerItemDate r4 = (SheetContainerItemDate) r2;
        List<OListItemCheck> r5 = this.itemViews;
        Context r6 = getContext();
        Intrinsics.checkNotNullExpressionValue(r6, "context");
        OListItemCheck r7 = new OListItemCheck(r6, null, 2, null);
        r7.setBackgroundColor(r7.getContext().getColor(android.R.color.transparent));
        if (r4.getSelectIndex() != r1) goto L11;
        boolean r8 = true;
    L12:
        r7.setChecked(r8);
        r7.setShowDivider(r4.getShowDivider());
        r7.setTitleString(r4.getTitle());
        r7.setSubTitleString(r4.getSubTitle());
        r7.setOnClickListener(new SheetContainerListView$$ExternalSyntheticLambda0(this, r1, r4));
        this.root.addView(r7);
        r5.add(r7);
        r1 = r3;
        goto L4
    L11:
        r8 = false;
        goto L12
    }

    private static final void setItems$lambda$3$lambda$2$lambda$1(SheetContainerListView r0, int r1, SheetContainerItemDate r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$selectionItemData");
        r0.select(r1);
        r2.getCallback().invoke(Integer.valueOf(r1));
    }
}
