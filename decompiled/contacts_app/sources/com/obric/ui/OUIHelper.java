package com.obric.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.utils.StyleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: OUIHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/ui/OUIHelper;", "", "()V", "TAG", "", "OUIBottomActionBar", "OUIList", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OUIHelper {
    public static final OUIHelper INSTANCE = null;
    public static final String TAG = "OUIHelper";

    /* JADX INFO: compiled from: OUIHelper.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0007¨\u0006\u0016"}, d2 = {"Lcom/obric/ui/OUIHelper$OUIBottomActionBar;", "", "()V", "createSingleIconButton", "Lcom/obric/oui/button/OIconButtonFloating;", "context", "Landroid/content/Context;", "drawableResId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "createSingleTextButton", "Lcom/obric/oui/button/OButtonFloating;", "text", "", "showButtons", "", "bottomActionBar", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "buttonList", "", "Lcom/obric/ui/OUIButtonData;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OUIBottomActionBar {
        public static final OUIBottomActionBar INSTANCE = null;

        static {
            INSTANCE = new OUIBottomActionBar();
        }

        private OUIBottomActionBar() {
        }

        @JvmStatic
        public static final void showButtons(Context r4, OBottomActionBarFloating r5, List<? extends OUIButtonData> r6) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "bottomActionBar");
            Intrinsics.checkNotNullParameter(r6, "buttonList");
            ArrayList r0 = new ArrayList();
            if (r6.isEmpty() == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(OUIHelper.TAG, "showButtons: buttons is empty");
            return;
        L6:
            Iterator<T> r7 = r6.iterator();
            int r1 = 0;
        L8:
            if (r7.hasNext() == false) goto L19;
            Object r2 = r7.next();
            int r3 = r1 + 1;
            if (r1 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            OUIButtonData r8 = (OUIButtonData) r2;
            if ((r8 instanceof OUIButtonData.TextButton) == false) goto L16;
            OUIButtonData.TextButton r9 = (OUIButtonData.TextButton) r8;
            r0.add(createSingleTextButton(r4, r9.getText(), r9.getOnClickListener()));
        L18:
            r1 = r3;
            goto L8
        L16:
            if ((r8 instanceof OUIButtonData.IconButton) == false) goto L18;
            OUIButtonData.IconButton r10 = (OUIButtonData.IconButton) r8;
            r0.add(createSingleIconButton(r4, r10.getDrawableResId(), r10.getOnClickListener()));
            goto L18
        L19:
            r5.setButtons(r0);
        }

        public static /* synthetic */ OButtonFloating createSingleTextButton$default(Context r0, String r1, View.OnClickListener r2, int r3, Object r4) {
            if ((r3 & 4) == 0) goto L6;
            r2 = null;
        L6:
            return createSingleTextButton(r0, r1, r2);
        }

        @JvmStatic
        public static final OButtonFloating createSingleTextButton(Context r1, final String r2, final View.OnClickListener r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "text");
            return (OButtonFloating) StyleUtil.createWidgetWithStyle(r1, 2131952506, new OUIHelper$OUIBottomActionBar$createSingleTextButton$1(r2, r3));
        }

        public static /* synthetic */ OIconButtonFloating createSingleIconButton$default(Context r0, int r1, View.OnClickListener r2, int r3, Object r4) {
            if ((r3 & 4) == 0) goto L6;
            r2 = null;
        L6:
            return createSingleIconButton(r0, r1, r2);
        }

        @JvmStatic
        public static final OIconButtonFloating createSingleIconButton(Context r1, final int r2, final View.OnClickListener r3) {
            Intrinsics.checkNotNullParameter(r1, "context");
            return (OIconButtonFloating) StyleUtil.createWidgetWithStyle(r1, 2131952506, new OUIHelper$OUIBottomActionBar$createSingleIconButton$1(r2, r3));
        }
    }

    /* JADX INFO: compiled from: OUIHelper.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0018J5\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0018J\u0018\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007¨\u0006#"}, d2 = {"Lcom/obric/ui/OUIHelper$OUIList;", "", "()V", "footerHeight100", "", "getFooterHeight100$annotations", "getFooterHeight100", "()I", "footerHeight184", "getFooterHeight184$annotations", "getFooterHeight184", "headerHeight112", "getHeaderHeight112$annotations", "getHeaderHeight112", "headerHeight96", "getHeaderHeight96$annotations", "getHeaderHeight96", "setFooter", "", "inflater", "Landroid/view/LayoutInflater;", "listView", "Landroid/widget/ListView;", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "(Landroid/view/LayoutInflater;Landroid/widget/ListView;Ljava/lang/Integer;)V", "setFooterAndHeader", "headerHeight", "footerHeight", "(Landroid/view/LayoutInflater;Landroid/widget/ListView;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setHeader", "setHeaderHeight", "view", "Landroid/view/View;", "hasTopSectionTitleBar", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OUIList {
        public static final OUIList INSTANCE = null;
        private static final int footerHeight100 = 0;
        private static final int footerHeight184 = 0;
        private static final int headerHeight112 = 0;
        private static final int headerHeight96 = 0;

        @JvmStatic
        public static /* synthetic */ void getFooterHeight100$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getFooterHeight184$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getHeaderHeight112$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getHeaderHeight96$annotations() {
        }

        private OUIList() {
        }

        public static final int getHeaderHeight96() {
            return headerHeight96;
        }

        public static final int getHeaderHeight112() {
            return headerHeight112;
        }

        public static final int getFooterHeight100() {
            return footerHeight100;
        }

        public static final int getFooterHeight184() {
            return footerHeight184;
        }

        public static /* synthetic */ void setFooterAndHeader$default(LayoutInflater r1, ListView r2, Integer r3, Integer r4, int r5, Object r6) {
            if ((r5 & 4) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 8) == 0) goto L8;
            r4 = null;
        L8:
            setFooterAndHeader(r1, r2, r3, r4);
        }

        @JvmStatic
        public static final void setFooterAndHeader(LayoutInflater r1, ListView r2, Integer r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r1, "inflater");
            Intrinsics.checkNotNullParameter(r2, "listView");
            setHeader(r1, r2, r3);
            setFooter(r1, r2, r4);
        }

        public static /* synthetic */ void setHeader$default(LayoutInflater r0, ListView r1, Integer r2, int r3, Object r4) {
            if ((r3 & 4) == 0) goto L5;
            r2 = null;
        L5:
            setHeader(r0, r1, r2);
        }

        @JvmStatic
        public static final void setHeader(LayoutInflater r3, ListView r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r3, "inflater");
            Intrinsics.checkNotNullParameter(r4, "listView");
            View r6 = r3.inflate(R.layout.list_header, r4, false);
            if (r5 != null) goto L5;
        L7:
            r6.setEnabled(false);
            r4.addHeaderView(r6);
            return;
        L5:
            if (r5.intValue() <= 0) goto L7;
            ViewGroup.LayoutParams r0 = r6.getLayoutParams();
            r0.height = r5.intValue();
            goto L7
        }

        public static /* synthetic */ void setFooter$default(LayoutInflater r0, ListView r1, Integer r2, int r3, Object r4) {
            if ((r3 & 4) == 0) goto L5;
            r2 = null;
        L5:
            setFooter(r0, r1, r2);
        }

        @JvmStatic
        public static final void setFooter(LayoutInflater r3, ListView r4, Integer r5) {
            Intrinsics.checkNotNullParameter(r3, "inflater");
            Intrinsics.checkNotNullParameter(r4, "listView");
            View r6 = r3.inflate(R.layout.list_footer, r4, false);
            if (r5 != null) goto L5;
        L7:
            r6.setEnabled(false);
            r4.addFooterView(r6);
            return;
        L5:
            if (r5.intValue() <= 0) goto L7;
            ViewGroup.LayoutParams r0 = r6.getLayoutParams();
            r0.height = r5.intValue();
            goto L7
        }

        @JvmStatic
        public static final void setHeaderHeight(View r1, boolean r2) {
            Intrinsics.checkNotNullParameter(r1, "view");
            ViewGroup.LayoutParams r3 = r1.getLayoutParams();
            if (r2 == false) goto L5;
            int r4 = headerHeight112;
        L6:
            r3.height = r4;
            return;
        L5:
            r4 = headerHeight96;
            goto L6
        }

        static {
            INSTANCE = new OUIList();
            headerHeight96 = MathKt.roundToInt(TypedValue.applyDimension(1, 96, Resources.getSystem().getDisplayMetrics()));
            headerHeight112 = MathKt.roundToInt(TypedValue.applyDimension(1, 112, Resources.getSystem().getDisplayMetrics()));
            footerHeight100 = MathKt.roundToInt(TypedValue.applyDimension(1, 100, Resources.getSystem().getDisplayMetrics()));
            footerHeight184 = MathKt.roundToInt(TypedValue.applyDimension(1, 184, Resources.getSystem().getDisplayMetrics()));
        }
    }

    static {
        INSTANCE = new OUIHelper();
    }

    private OUIHelper() {
    }
}
