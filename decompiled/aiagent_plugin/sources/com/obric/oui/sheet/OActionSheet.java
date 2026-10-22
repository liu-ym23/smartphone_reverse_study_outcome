package com.obric.oui.sheet;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.obric.oui.panel.OBasePanelDialog;
import com.obric.oui.panel.OBasicPanelFragment;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: OActionSheet.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OActionSheet extends OBasicPanelFragment {
    public static final b Companion = null;
    public static final String DIVIDER_LINE = "divider_line";
    public static final String DIVIDER_VIEW = "divider_view";
    public static final String EXTENSION_SUBTITLE = "extension_subtitle";
    public static final String EXTENSION_TITLE = "extension_title";
    public static final String ITEM_SUBTITLE = "item_subtitle";
    public static final String ITEM_TITLE = "item_title";
    public static final String TAG = "OActionSheet";
    private LinearLayout mActionContainer;
    private ArrayList<a> mActions;
    private View.OnClickListener mCancelBtnClickListener;
    private CharSequence mSubTitle;
    private TextView mSubTitleText;
    private CharSequence mTitle;
    private TextView mTitleText;
    private final ArrayList<DialogInterface.OnDismissListener> onDismissListeners;

    /* JADX INFO: compiled from: OActionSheet.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CharSequence f36189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f36190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f36191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private m<? super View, ? super DialogFragment, x> f36192d;

        public final CharSequence a() {
            return this.f36189a;
        }

        public final CharSequence b() {
            return this.f36190b;
        }

        public final boolean c() {
            return this.f36191c;
        }

        public final m<View, DialogFragment, x> d() {
            return this.f36192d;
        }
    }

    /* JADX INFO: compiled from: OActionSheet.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    static {
        Companion = new b(null);
    }

    public static /* synthetic */ void lambda$8_Dz1BGVTp9wfUk_M9d2zaF1fY8(OActionSheet r0, View r1) {
        m1170onViewCreated$lambda2(r0, r1);
    }

    public static /* synthetic */ void lambda$EDKQ_gtAcfcX6ERAMQYIh3tZx_E(a r0, OActionSheet r1, View r2) {
        m1171onViewCreated$lambda4$lambda3(r0, r1, r2);
    }

    public static final /* synthetic */ void access$setMActions$p(OActionSheet r0, ArrayList r1) {
        r0.mActions = r1;
    }

    public OActionSheet() {
        this.mActions = new ArrayList();
        this.onDismissListeners = new ArrayList();
    }

    public final CharSequence getMTitle() {
        return this.mTitle;
    }

    public final void setMTitle(CharSequence r3) {
        this.mTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final CharSequence getMSubTitle() {
        return this.mSubTitle;
    }

    public final void setMSubTitle(CharSequence r3) {
        this.mSubTitle = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
    }

    public final View.OnClickListener getMCancelBtnClickListener() {
        return this.mCancelBtnClickListener;
    }

    public final void setMCancelBtnClickListener(View.OnClickListener r3) {
        this.mCancelBtnClickListener = (View.OnClickListener) ZeusTransformUtils.wrapperContextForParams(r3, View.OnClickListener.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        o.e(r2, "inflater");
        return ZeusTransformUtils.inflate(r2, ZeusTransformUtils.mapRes(R.layout.o_view_action_sheet, "layout", "o_view_action_sheet"), r3, false, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r6) {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "requireContext()");
        OBasePanelDialog r7 = new OBasePanelDialog(r0, 0, 2, null);
        r7.setExpandable(false);
        r7.setRemoveMinHeight(true);
        r7.setDisableAutoAdaptHeight(getDisableAutoAdaptHeight());
        return (Dialog) ZeusTransformUtils.preCheckCast(r7, Dialog.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.aiagent.plugin");
        o.e(r5, "dialog");
        super.onDismiss(r5);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(this.onDismissListeners, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((DialogInterface.OnDismissListener) ZeusTransformUtils.preCheckCast(r3.next(), DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin")).onDismiss(r5);
        goto L4
    }

    public final void addOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        this.onDismissListeners.add(r4);
    }

    public final boolean removeOnDismissListener(DialogInterface.OnDismissListener r3) {
        DialogInterface.OnDismissListener r4 = (DialogInterface.OnDismissListener) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.OnDismissListener.class, "com.obric.aiagent.plugin");
        o.e(r4, "listener");
        return this.onDismissListeners.remove(r4);
    }

    public final TextView getMTitleText() {
        return this.mTitleText;
    }

    public final void setMTitleText(TextView r1) {
        this.mTitleText = r1;
    }

    public final TextView getMSubTitleText() {
        return this.mSubTitleText;
    }

    public final void setMSubTitleText(TextView r1) {
        this.mSubTitleText = r1;
    }

    public final LinearLayout getMActionContainer() {
        return this.mActionContainer;
    }

    public final void setMActionContainer(LinearLayout r1) {
        this.mActionContainer = r1;
    }

    @Override // com.obric.oui.panel.OBasicPanelFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r18, Bundle r19) {
        final OActionSheet r0 = this;
        o.e(r18, "view");
        super.onViewCreated(r18, r19);
        LinearLayout r2 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.action_sheet_layout, DbHelper.COL_ID, "action_sheet_layout")), LinearLayout.class, "com.obric.aiagent.plugin");
        if (getAutoSwitchDayNight() == false) goto L5;
        Drawable r4 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_action_sheet_daynight_bg, "drawable", "o_action_sheet_daynight_bg"));
    L6:
        if (r2 == null) goto L9;
        r2.setBackground(r4);
    L9:
        r18.findViewById(ZeusTransformUtils.mapRes(R.id.divider_view, DbHelper.COL_ID, DIVIDER_VIEW)).setBackgroundColor(r0.getSpecColor(DIVIDER_VIEW));
        LinearLayout r3 = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.title_container, DbHelper.COL_ID, "title_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        TextView r5 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.action_title, DbHelper.COL_ID, "action_title")), TextView.class, "com.obric.aiagent.plugin");
        r0.mTitleText = r5;
        if (r5 == null) goto L13;
        r5.setTextColor(r0.getSpecColor(EXTENSION_TITLE));
    L13:
        TextView r6 = (TextView) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.action_sub_title, DbHelper.COL_ID, "action_sub_title")), TextView.class, "com.obric.aiagent.plugin");
        r0.mSubTitleText = r6;
        if (r6 == null) goto L17;
        r6.setTextColor(r0.getSpecColor(EXTENSION_SUBTITLE));
    L17:
        View r7 = r3.findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, DbHelper.COL_ID, "top_divider"));
        r7.setBackgroundColor(r0.getSpecColor(DIVIDER_LINE));
        r7.setVisibility(4);
        CharSequence r8 = r0.mTitle;
        boolean r13 = false;
        if (r8 == null) goto L31;
        TextView r15 = r0.mTitleText;
        if (r15 == null) goto L23;
        r15.setText(r8);
    L23:
        TextView r9 = r0.mTitleText;
        if (r9 == null) goto L27;
        r9.setVisibility(0);
    L27:
        TextView r10 = r0.mSubTitleText;
        if (r10 == null) goto L39;
        r10.setMaxLines(1);
    L39:
        CharSequence r11 = r0.mSubTitle;
        if (r11 == null) goto L49;
        TextView r16 = r0.mSubTitleText;
        if (r16 == null) goto L45;
        r16.setText(r11);
    L45:
        TextView r12 = r0.mSubTitleText;
        if (r12 == null) goto L54;
        r12.setVisibility(0);
    L54:
        if (r0.mTitle == null) goto L56;
    L58:
        TextView r14 = (TextView) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.cancel_action, DbHelper.COL_ID, "cancel_action")), TextView.class, "com.obric.aiagent.plugin");
        if (r14 == null) goto L62;
        r14.setTextColor(r0.getSpecColor(ITEM_TITLE));
    L62:
        r14.setAccessibilityDelegate((View.AccessibilityDelegate) ZeusTransformUtils.preCheckCast(new AnonymousClass1(), View.AccessibilityDelegate.class, "com.obric.aiagent.plugin"));
        r14.setOnClickListener(new $$Lambda$OActionSheet$8_Dz1BGVTp9wfUk_M9d2zaF1fY8(r0));
        r0.mActionContainer = (LinearLayout) ZeusTransformUtils.preCheckCast(r18.findViewById(ZeusTransformUtils.mapRes(R.id.action_container, DbHelper.COL_ID, "action_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0.mActions, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L64:
        if (r1.hasNext() == false) goto L97;
        final a r17 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin");
        View r110 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.o_item_action_sheet, "layout", "o_item_action_sheet"), (ViewGroup) ZeusTransformUtils.preCheckCast(getMActionContainer(), ViewGroup.class, "com.obric.aiagent.plugin"), r13, "com.obric.aiagent.plugin");
        r110.setOnClickListener(new $$Lambda$OActionSheet$EDKQ_gtAcfcX6ERAMQYIh3tZx_E(r17, r0));
        TextView r111 = (TextView) ZeusTransformUtils.preCheckCast(r110.findViewById(ZeusTransformUtils.mapRes(R.id.action_title, DbHelper.COL_ID, "action_title")), TextView.class, "com.obric.aiagent.plugin");
        TextView r112 = (TextView) ZeusTransformUtils.preCheckCast(r110.findViewById(ZeusTransformUtils.mapRes(R.id.action_sub_title, DbHelper.COL_ID, "action_sub_title")), TextView.class, "com.obric.aiagent.plugin");
        View r113 = r110.findViewById(ZeusTransformUtils.mapRes(R.id.top_divider, DbHelper.COL_ID, "top_divider"));
        if (r111 == null) goto L69;
        r111.setTextColor(r0.getSpecColor(ITEM_TITLE));
    L69:
        if (r112 == null) goto L72;
        r112.setTextColor(r0.getSpecColor(ITEM_SUBTITLE));
    L72:
        if (r113 == null) goto L76;
        r113.setBackgroundColor(r0.getSpecColor(DIVIDER_LINE));
    L76:
        if (r0.mActions.indexOf(r17) == 0) goto L78;
    L80:
        int r114 = 0;
        r113.setVisibility(0);
    L82:
        if (r17.a() == null) goto L84;
        r111.setText(r17.a());
        r111.setVisibility(r114);
        r110.setContentDescription(r17.a());
        r112.setMaxLines(1);
    L86:
        if (r17.b() == null) goto L88;
        r112.setText(r17.b());
        r112.setVisibility(0);
        r110.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(r110.getContentDescription() + ", " + r17.b(), CharSequence.class, "com.obric.aiagent.plugin"));
    L90:
        if (r17.c() == false) goto L92;
        r111.setTextColor(androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.color.Negative, "color", "Negative")));
    L92:
        r110.setAccessibilityDelegate((View.AccessibilityDelegate) ZeusTransformUtils.preCheckCast(new OActionSheet$onViewCreated$3$2(r17), View.AccessibilityDelegate.class, "com.obric.aiagent.plugin"));
        LinearLayout r20 = getMActionContainer();
        if (r20 == null) goto L96;
        r20.addView(r110);
    L96:
        r13 = false;
        r0 = this;
        goto L64
    L88:
        r112.setVisibility(8);
        goto L90
    L84:
        r111.setVisibility(8);
        r112.setMaxLines(2);
        goto L86
    L78:
        if (r3.getVisibility() != 8) goto L80;
        r113.setVisibility(4);
        r114 = 0;
        goto L82
    L97:
        return;
    L56:
        if (r0.mSubTitle != null) goto L58;
        r3.setVisibility(8);
        goto L58
    L49:
        TextView r21 = r0.mSubTitleText;
        if (r21 == null) goto L54;
        r21.setVisibility(8);
        goto L54
    L31:
        TextView r22 = r0.mTitleText;
        if (r22 == null) goto L35;
        r22.setVisibility(8);
    L35:
        TextView r23 = r0.mSubTitleText;
        if (r23 == null) goto L39;
        r23.setMaxLines(2);
        goto L39
    L5:
        r4 = androidx.core.content.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.drawable.o_action_sheet_const_bg, "drawable", "o_action_sheet_const_bg"));
        goto L6
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-2, reason: not valid java name */
    private static final void m1170onViewCreated$lambda2(OActionSheet r1, View r2) {
        o.e(r1, "this$0");
        View.OnClickListener r0 = r1.mCancelBtnClickListener;
        if (r0 == null) goto L6;
        r0.onClick(r2);
    L6:
        r1.dismissAllowingStateLoss();
    }

    /* JADX INFO: renamed from: onViewCreated$lambda-4$lambda-3, reason: not valid java name */
    private static final void m1171onViewCreated$lambda4$lambda3(a r1, OActionSheet r2, View r3) {
        o.e(r1, "$action");
        o.e(r2, "this$0");
        m<View, DialogFragment, x> r4 = r1.d();
        if (r4 == null) goto L6;
        o.c(r3, "it");
        r4.invoke(r3, r2);
    L6:
        r2.dismissAllowingStateLoss();
    }

    private final int getSpecColor(String r5) {
        switch(r5.hashCode()) {
            case -1951390164: goto L43;
            case -1672427580: goto L36;
            case -1210163878: goto L28;
            case -1209866229: goto L20;
            case 1704015448: goto L13;
            case 1915336728: goto L6;
            default: goto L50;
        };
    L50:
        int r6 = 0;
    L52:
        return androidx.core.content.a.c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r6);
    L6:
        if (r5.equals(EXTENSION_SUBTITLE) == false) goto L50;
        if (getAutoSwitchDayNight() == false) goto L11;
        r6 = ZeusTransformUtils.mapRes(R.color.TextTertiary, "color", "TextTertiary");
        goto L52
    L11:
        r6 = ZeusTransformUtils.mapRes(R.color.TextReverse3, "color", "TextReverse3");
        goto L52
    L13:
        if (r5.equals(EXTENSION_TITLE) == false) goto L50;
        if (getAutoSwitchDayNight() == false) goto L18;
        r6 = ZeusTransformUtils.mapRes(R.color.TextTertiary, "color", "TextTertiary");
        goto L52
    L18:
        r6 = ZeusTransformUtils.mapRes(R.color.TextReverse3, "color", "TextReverse3");
        goto L52
    L20:
        if (r5.equals(DIVIDER_VIEW) == false) goto L50;
        if (getAutoSwitchDayNight() == false) goto L25;
        int r7 = R.color.BGPlaceholderDefault;
        String r0 = "BGPlaceholderDefault";
    L26:
        r6 = ZeusTransformUtils.mapRes(r7, "color", r0);
        goto L52
    L25:
        r7 = R.color.BGInputReverse;
        r0 = "BGInputReverse";
        goto L26
    L28:
        if (r5.equals(DIVIDER_LINE) == false) goto L50;
        if (getAutoSwitchDayNight() == false) goto L33;
        int r8 = R.color.LinePrimary;
        String r1 = "LinePrimary";
    L34:
        r6 = ZeusTransformUtils.mapRes(r8, "color", r1);
        goto L52
    L33:
        r8 = R.color.LineReverse2;
        r1 = "LineReverse2";
        goto L34
    L36:
        if (r5.equals(ITEM_SUBTITLE) == false) goto L50;
        if (getAutoSwitchDayNight() == false) goto L41;
        r6 = ZeusTransformUtils.mapRes(R.color.TextTertiary, "color", "TextTertiary");
        goto L52
    L41:
        r6 = ZeusTransformUtils.mapRes(R.color.TextReverse3, "color", "TextReverse3");
        goto L52
    L43:
        if (r5.equals(ITEM_TITLE) == false) goto L50;
        if (getAutoSwitchDayNight() == false) goto L48;
        int r9 = R.color.TextPrimary;
        String r2 = "TextPrimary";
    L49:
        r6 = ZeusTransformUtils.mapRes(r9, "color", r2);
        goto L52
    L48:
        r9 = R.color.TextReverse;
        r2 = "TextReverse";
        goto L49
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (ZeusTransformUtils.instanceOf(getDialog(), OBasePanelDialog.class) == false) goto L6;
        Dialog r2 = getDialog();
        Objects.requireNonNull(r2, "null cannot be cast to non-null type com.obric.oui.panel.OBasePanelDialog");
        ((OBasePanelDialog) ZeusTransformUtils.preCheckCast(r2, OBasePanelDialog.class, "com.obric.aiagent.plugin")).hideHeader();
        return;
    }
}
