package com.android.contacts.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.android.contacts.ContactsUtils;
import com.android.contacts.R;
import com.obric.contactsdk.loader.CallFeatureEntityUtilKt;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.ToolsExtKt;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.dialog.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.input.InputBodyController;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.popover.OPopover;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.selection.OActionSheet;
import com.obric.oui.selection.OActionSheetButton;
import com.obric.oui.sheet.OInsetSheet;
import com.obric.oui.sheet.OInsetSheetTitleBar;
import com.obric.oui.text.OTextView;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: OSheetUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001DB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002JZ\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00122\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J.\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0002JT\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0007JÊ\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010!\u001a\u0004\u0018\u00010\n2\b\u0010\"\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010#\u001a\u00020$2b\u0010%\u001a^\u0012\u0013\u0012\u00110'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110+¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(,\u0012\u0013\u0012\u00110$¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u001e0&2\b\u0010/\u001a\u0004\u0018\u0001002\b\b\u0002\u00101\u001a\u00020+2\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dJ\u0096\u0001\u00103\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u00104\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010\n2\b\u00106\u001a\u0004\u0018\u00010\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u00122\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\u00122\u0006\u0010\u0007\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u0001092\b\b\u0002\u0010:\u001a\u00020$2\b\b\u0002\u0010;\u001a\u00020$H\u0007J.\u0010<\u001a\u00020=2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010>\u001a\u00020+2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dJ\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0004H\u0002J\u0018\u0010A\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u0004H\u0002J\u000e\u0010B\u001a\u0004\u0018\u00010C*\u00020\u0018H\u0002¨\u0006E"}, d2 = {"Lcom/android/contacts/util/OSheetUtils;", "", "()V", "genActionContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "contentViewStyle", "Lcom/android/contacts/util/OSheetUtils$ContentViewStyle;", "contentViewBtnName", "", "contentViewListener", "Landroid/view/View$OnClickListener;", "sheet", "Lcom/obric/oui/sheet/OInsetSheet;", "genContentView", "contentViewBtnNameList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contentViewListeners", "genHeaderView", "title", "rightBtnClickListener", "getActionSheet", "Lcom/obric/oui/selection/OActionSheet;", "sheetWidth", "Lcom/obric/oui/sheet/OInsetSheet$PanelWidth;", "message", "close", "Lkotlin/Function0;", "", "getEditDialog", "Lcom/obric/oui/dialog/alert/OAlertDialog;", "hint", "value", "isSelectAllValue", "", CallFeatureEntityUtilKt.PARAM_KEY_ACTION, "Lkotlin/Function4;", "Landroid/content/DialogInterface;", "Lkotlin/ParameterName;", "name", "dialog", "", "which", "isPositivity", "res", "watcher", "Landroid/text/TextWatcher;", "limitCount", "limitFunction", "getOSheet", MaterialConfigFormatNames.WIDTH, "headerViewTitle", "headerViewCloseClickListener", "footView", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "cancelable", "closeClick", "getPopOverSimple", "Lcom/obric/oui/popover/OPopover;", "gravity", "hideSoftKeyboard", "view", "showSoftKeyboard", "getDesTextView", "Lcom/obric/oui/text/OTextView;", "ContentViewStyle", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OSheetUtils {
    public static final OSheetUtils INSTANCE = null;

    /* JADX INFO: compiled from: OSheetUtils.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/contacts/util/OSheetUtils$ContentViewStyle;", "", "(Ljava/lang/String;I)V", "BLUE", "RED", "BLACK", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum ContentViewStyle extends Enum<ContentViewStyle> {
        private static final /* synthetic */ ContentViewStyle[] $VALUES = null;
        public static final ContentViewStyle BLACK = null;
        public static final ContentViewStyle BLUE = null;
        public static final ContentViewStyle RED = null;

        private static final /* synthetic */ ContentViewStyle[] $values() {
            return new ContentViewStyle[]{BLUE, RED, BLACK};
        }

        public static ContentViewStyle valueOf(String r1) {
            return (ContentViewStyle) Enum.valueOf(ContentViewStyle.class, r1);
        }

        public static ContentViewStyle[] values() {
            return (ContentViewStyle[]) $VALUES.clone();
        }

        private ContentViewStyle(String r1, int r2) {
            super(r1, r2);
        }

        static {
            BLUE = new ContentViewStyle("BLUE", 0);
            RED = new ContentViewStyle("RED", 1);
            BLACK = new ContentViewStyle("BLACK", 2);
            $VALUES = $values();
        }
    }

    /* JADX INFO: compiled from: OSheetUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ContentViewStyle.values().length];
            r0[ContentViewStyle.BLUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ContentViewStyle.RED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1Rp1FhbB-YLMBZ6qVHNZnJTzAnI, reason: not valid java name */
    public static /* synthetic */ void m222$r8$lambda$1Rp1FhbBYLMBZ6qVHNZnJTzAnI(ArrayList r0, int r1, OInsetSheet r2, View r3) {
        genContentView$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$8p0AU1PatUME_sFR05YgCTfug3k(View.OnClickListener r0, OInsetSheet r1, View r2) {
        genActionContentView$lambda$16$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$A39PPcjlybg2KsxlHeqHGhQYAnc(Ref.ObjectRef r0, EditText r1, Function4 r2, DialogInterface r3, int r4) {
        getEditDialog$lambda$8(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$JU-LRb-kJPQC8i246a5D4bWHUHI, reason: not valid java name */
    public static /* synthetic */ void m223$r8$lambda$JULRbkJPQC8i246a5D4bWHUHI(EditText r0, Context r1) {
        getEditDialog$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$VbozcHDYXSaqCUUzI08cDWRrZYc(Function4 r0, Ref.ObjectRef r1, EditText r2, DialogInterface r3, int r4) {
        getEditDialog$lambda$9(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$dY3FEGEUxAwTWIJd4Cz_TEj-fPo, reason: not valid java name */
    public static /* synthetic */ void m224$r8$lambda$dY3FEGEUxAwTWIJd4Cz_TEjfPo(Ref.ObjectRef r0, EditText r1, Function4 r2, DialogInterface r3) {
        getEditDialog$lambda$12(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$gU0KPqQ0hLWv0rvs5S4dsrS-Jd0, reason: not valid java name */
    public static /* synthetic */ void m225$r8$lambda$gU0KPqQ0hLWv0rvs5S4dsrSJd0(DialogInterface.OnCancelListener r0, Ref.ObjectRef r1, DialogInterface r2) {
        getOSheet$lambda$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$nGDKMEe_Es4kbuFL3ZZfnK2rMo8(Context r0, View r1, boolean r2) {
        getEditDialog$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$qhz5ocxIilbktz5kwiYF20KfpLU(Context r0, EditText r1) {
        getEditDialog$lambda$7$lambda$6$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$yhCj2xRMryw8Chm4fTLQGpaRivI(View.OnClickListener r0, OInsetSheet r1, View r2) {
        genHeaderView$lambda$2(r0, r1, r2);
    }

    static {
        INSTANCE = new OSheetUtils();
    }

    private OSheetUtils() {
    }

    public static /* synthetic */ OInsetSheet getOSheet$default(Context r13, OInsetSheet.PanelWidth r14, String r15, View.OnClickListener r16, ArrayList r17, ArrayList r18, ContentViewStyle r19, View r20, DialogInterface.OnCancelListener r21, boolean r22, boolean r23, int r24, Object r25) {
        if ((r24 & 2) == 0) goto L5;
        OInsetSheet.PanelWidth r3 = OInsetSheet.PanelWidth.NARROW_WIDTH;
    L7:
        if ((r24 & 512) == 0) goto L9;
        boolean r11 = true;
    L11:
        if ((r24 & 1024) == 0) goto L13;
        boolean r12 = true;
    L15:
        return getOSheet(r13, r3, r15, r16, r17, r18, r19, r20, r21, r11, r12);
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r3 = r14;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, com.obric.oui.sheet.OInsetSheet] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @JvmStatic
    public static final OInsetSheet getOSheet(Context r8, OInsetSheet.PanelWidth r9, String r10, View.OnClickListener r11, ArrayList<String> r12, ArrayList<View.OnClickListener> r13, ContentViewStyle r14, View r15, final DialogInterface.OnCancelListener r16, boolean r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, MaterialConfigFormatNames.WIDTH);
        Intrinsics.checkNotNullParameter(r14, "contentViewStyle");
        ?? r6 = new OInsetSheet(r8);
        r6.setRootWidth(r9);
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = r6;
        if (r18 == true) goto L5;
        r7.element = null;
    L5:
        OSheetUtils r0 = INSTANCE;
        r6.setHeaderView(r0.genHeaderView(r8, r10, r6, r11));
        r6.setContainerView(r0.genContentView(r8, r14, r12, r13, (OInsetSheet) r7.element));
        r6.setFooterView(r15);
        r6.setCancelable(r17);
        r6.setOnCancelListener(new OSheetUtils$$ExternalSyntheticLambda8(r16, r7));
        return r6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void getOSheet$lambda$0(DialogInterface.OnCancelListener r1, Ref.ObjectRef r2, DialogInterface r3) {
        Intrinsics.checkNotNullParameter(r2, "$currentSheet");
        if (r1 == null) goto L5;
        r1.onCancel(r3);
    L5:
        OInsetSheet r4 = (OInsetSheet) r2.element;
        if (r4 == null) goto L9;
        r4.dismiss();
        return;
    }

    private final View genHeaderView(Context r7, String r8, final OInsetSheet r9, final View.OnClickListener r10) {
        OInsetSheetTitleBar r6 = new OInsetSheetTitleBar(r7, null, 0, 6, null);
        r6.setShowLeftBack(false);
        if (r8 == null) goto L5;
        r6.getMTitleView().setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 296, Resources.getSystem().getDisplayMetrics())));
        r6.setTitleText(r8);
    L5:
        OButton r11 = r6.createNeutralButton(r7, r6.getMRightContainer());
        r11.setButtonSourceBitmap(R.drawable.o_ic_close);
        r11.setOnClickListener(new OSheetUtils$$ExternalSyntheticLambda6(r10, r9));
        return r6;
    }

    private static final void genHeaderView$lambda$2(View.OnClickListener r0, OInsetSheet r1, View r2) {
        if (r0 == null) goto L4;
        r0.onClick(r2);
    L4:
        if (r1 == null) goto L7;
        r1.dismiss();
        return;
    }

    private final View genContentView(Context r9, ContentViewStyle r10, ArrayList<String> r11, final ArrayList<View.OnClickListener> r12, final OInsetSheet r13) {
        int r8 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r8 != 1) goto L5;
        int r14 = R.layout.sheet_button_center_blue;
    L9:
        LinearLayout r0 = new LinearLayout(r9);
        r0.setOrientation(1);
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(r9, 5.0d));
        if (r11 == null) goto L12;
        int r15 = r11.size();
    L13:
        if (r12 == null) goto L15;
        int r4 = r12.size();
    L16:
        int r16 = RangesKt.coerceAtMost(r15, r4);
        final int r5 = 0;
    L17:
        if (r5 >= r16) goto L22;
        String r6 = null;
        View r7 = LayoutInflater.from(r9).inflate(r14, null);
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        OButton r17 = (OButton) r7;
        if (r11 == null) goto L21;
        r6 = r11.get(r5);
    L21:
        r17.setText(r6);
        r17.setOnClickListener(new OSheetUtils$$ExternalSyntheticLambda0(r12, r5, r13));
        r17.setWidth(ContactsUtils.dipTopx(r9, 296.0d));
        r17.setHeight(ContactsUtils.dipTopx(r9, 56.0d));
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-2, -2);
        r18.gravity = 17;
        r18.bottomMargin = ContactsUtils.dipTopx(r9, 5.0d);
        r0.addView(r17, r18);
        r5 = r5 + 1;
        goto L17
    L22:
        r0.setPadding(0, 0, 0, ContactsUtils.dipTopx(r9, 15.0d));
        return r0;
    L15:
        r4 = 0;
        goto L16
    L12:
        r15 = 0;
        goto L13
    L5:
        if (r8 == 2) goto L7;
        r14 = R.layout.sheet_button_left_center_black;
        goto L9
    L7:
        r14 = R.layout.sheet_button_center_red;
        goto L9
    }

    private static final void genContentView$lambda$3(ArrayList r0, int r1, OInsetSheet r2, View r3) {
        if (r0 == null) goto L6;
        View.OnClickListener r4 = (View.OnClickListener) r0.get(r1);
        if (r4 == null) goto L6;
        r4.onClick(r3);
    L6:
        if (r2 == null) goto L9;
        r2.dismiss();
        return;
    }

    public final OPopover getPopOverSimple(Context r16, String r17, int r18, final Function0<Unit> r19) {
        Intrinsics.checkNotNullParameter(r16, "context");
        Intrinsics.checkNotNullParameter(r19, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        OPopoverEntranceMenuView.Builder r2 = new OPopoverEntranceMenuView.Builder(r16);
        OPopoverEntranceMenuView.Builder.addPopoverItem$default(r2, 0, 0, 0, r17, null, null, false, null, new AnonymousClass1(r19), 128, null);
        r2.setItemWidth(ContactsUtils.dipTopx(r16, 160.0d));
        OPopoverEntranceMenuView r1 = r2.build();
        r1.setElevation(100.0f);
        return new OPopover.Builder((Activity) r16).setView(r1).setGravity(r18).build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OAlertDialog getEditDialog$default(OSheetUtils r13, Context r14, String r15, String r16, String r17, String r18, boolean r19, Function4 r20, TextWatcher r21, int r22, Function0 r23, int r24, Object r25) {
        if ((r24 & 32) == 0) goto L5;
        boolean r8 = false;
    L7:
        if ((r24 & 256) == 0) goto L9;
        int r11 = Integer.MAX_VALUE;
    L11:
        if ((r24 & 512) == 0) goto L13;
        Function0 r12 = null;
    L15:
        return r13.getEditDialog(r14, r15, r16, r17, r18, r8, r20, r21, r11, r12);
    L13:
        r12 = r23;
        goto L15
    L9:
        r11 = r22;
        goto L11
    L5:
        r8 = r19;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OAlertDialog getEditDialog(final Context r21, String r22, String r23, String r24, String r25, boolean r26, final Function4<? super DialogInterface, ? super Integer, ? super Boolean, ? super String, Unit> r27, final TextWatcher r28, final int r29, final Function0<Unit> r30) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r27, CallFeatureEntityUtilKt.PARAM_KEY_ACTION);
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = r25;
        InputBodyController r4 = new InputBodyController(r21);
        final EditText r5 = r4.getInputText();
        if (r24 == null) goto L6;
        r5.setHint(r24);
    L6:
        if (r25 == 0) goto L10;
        r5.setText(r25);
        r5.setSelection(r25.length());
        if (r26 == false) goto L10;
        r5.setSelection(0, r25.length());
        r5.post(new OSheetUtils$$ExternalSyntheticLambda1(r5, r21));
    L10:
        OAlertDialogBuilder r1 = OAlertDialogBuilder.positiveButton$default(OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.horizontalButton$default(new OAlertDialogBuilder(r21).withBodyWithMatchParent(true).autoDismiss(false).body(r4), false, 1, null), android.R.string.cancel, new OSheetUtils$$ExternalSyntheticLambda2(r3, r5, r27), null, 4, null), R.string.common_done, new OSheetUtils$$ExternalSyntheticLambda3(r27, r3, r5), null, 4, null);
        if (r22 == null) goto L13;
        OAlertDialogBuilder.title$default(r1, r22, false, 2, null);
    L13:
        if (r23 == null) goto L15;
        r1.message(r23);
    L15:
        OAlertDialog r2 = r1.build();
        r2.setCancelable(true);
        r2.setOnCancelListener(new OSheetUtils$$ExternalSyntheticLambda4(r3, r5, r27));
        r5.setOnFocusChangeListener(new OSheetUtils$$ExternalSyntheticLambda5(r21));
        r5.addTextChangedListener(new AnonymousClass7(r28, r3, r29, r5, r30));
        return r2;
    }

    private static final void getEditDialog$lambda$7$lambda$6(final EditText r3, final Context r4) {
        Intrinsics.checkNotNullParameter(r3, "$editText");
        Intrinsics.checkNotNullParameter(r4, "$context");
        r3.selectAll();
        r3.requestFocus();
        r3.postDelayed(new OSheetUtils$$ExternalSyntheticLambda9(r4, r3), 100);
    }

    private static final void getEditDialog$lambda$7$lambda$6$lambda$5(Context r1, EditText r2) {
        Intrinsics.checkNotNullParameter(r1, "$context");
        Intrinsics.checkNotNullParameter(r2, "$editText");
        INSTANCE.showSoftKeyboard(r1, r2);
    }

    private static final void getEditDialog$lambda$8(final Ref.ObjectRef r7, final EditText r8, final Function4 r9, final DialogInterface r10, final int r11) {
        Intrinsics.checkNotNullParameter(r7, "$str");
        Intrinsics.checkNotNullParameter(r8, "$editText");
        Intrinsics.checkNotNullParameter(r9, "$action");
        ToolsExtKt.runInUIThread(new OSheetUtils$getEditDialog$dialogBuilder$1$1(r7, r8, r10, r9, r11));
    }

    private static final void getEditDialog$lambda$9(final Function4 r7, final Ref.ObjectRef r8, final EditText r9, final DialogInterface r10, final int r11) {
        Intrinsics.checkNotNullParameter(r7, "$action");
        Intrinsics.checkNotNullParameter(r8, "$str");
        Intrinsics.checkNotNullParameter(r9, "$editText");
        ToolsExtKt.runInUIThread(new OSheetUtils$getEditDialog$dialogBuilder$2$1(r10, r7, r11, r8, r9));
    }

    private static final void getEditDialog$lambda$12(final Ref.ObjectRef r1, final EditText r2, final Function4 r3, final DialogInterface r4) {
        Intrinsics.checkNotNullParameter(r1, "$str");
        Intrinsics.checkNotNullParameter(r2, "$editText");
        Intrinsics.checkNotNullParameter(r3, "$action");
        ToolsExtKt.runInUIThread(new OSheetUtils$getEditDialog$5$1(r1, r2, r4, r3));
    }

    private static final void getEditDialog$lambda$13(Context r1, View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$context");
        if (r3 == true) goto L6;
        OSheetUtils r4 = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r2, BaseSwitches.V);
        r4.hideSoftKeyboard(r1, r2);
        return;
    }

    private final void hideSoftKeyboard(Context r1, View r2) {
        Object r0 = r1.getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r0).hideSoftInputFromWindow(r2.getWindowToken(), 0);
    }

    private final void showSoftKeyboard(Context r1, View r2) {
        Object r0 = r1.getSystemService("input_method");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) r0).showSoftInput(r2, 0);
    }

    public static /* synthetic */ OActionSheet getActionSheet$default(Context r9, OInsetSheet.PanelWidth r10, String r11, String r12, String r13, ContentViewStyle r14, View.OnClickListener r15, Function0 r16, int r17, Object r18) {
        if ((r17 & 2) == 0) goto L5;
        OInsetSheet.PanelWidth r2 = OInsetSheet.PanelWidth.NARROW_WIDTH;
    L7:
        return getActionSheet(r9, r2, r11, r12, r13, r14, r15, r16);
    L5:
        r2 = r10;
        goto L7
    }

    @JvmStatic
    public static final OActionSheet getActionSheet(Context r10, OInsetSheet.PanelWidth r11, String r12, String r13, String r14, ContentViewStyle r15, View.OnClickListener r16, final Function0<Unit> r17) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sheetWidth");
        Intrinsics.checkNotNullParameter(r12, "title");
        Intrinsics.checkNotNullParameter(r14, "contentViewBtnName");
        Intrinsics.checkNotNullParameter(r15, "contentViewStyle");
        Intrinsics.checkNotNullParameter(r17, "close");
        String r7 = r13;
        if (r7 != null) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r8 == false) goto L11;
        String r9 = null;
    L12:
        OActionSheet r18 = new OActionSheet(r10, new OActionSheet.Companion.Modifier(r11, r12, r9, new OSheetUtils$getActionSheet$modifier$1(r17)));
        OSheetUtils r0 = INSTANCE;
        OTextView r2 = r0.getDesTextView(r18);
        if (r2 == null) goto L16;
        r2.setEnableAutoAlignLeft(true);
    L16:
        r18.setContainerView(r0.genActionContentView(r10, r15, r14, r16, r18));
        return r18;
    L11:
        r9 = r13;
        goto L12
    L5:
        if (r7.length() == 0) goto L8;
        r8 = false;
        goto L9
    }

    private final OTextView getDesTextView(OActionSheet r3) {
        Object r2 = null;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        View r4 = r3.getHeaderContainer().getChildAt(0);     // Catch: Throwable -> L23
        if ((r4 instanceof ViewGroup) == false) goto L6;
        ViewGroup r5 = (ViewGroup) r4;     // Catch: Throwable -> L23
    L7:
        if (r5 == null) goto L9;
        View r6 = r5.getChildAt(0);     // Catch: Throwable -> L23
    L11:
        if ((r6 instanceof OInsetSheetTitleBar) == false) goto L13;
        OInsetSheetTitleBar r7 = (OInsetSheetTitleBar) r6;     // Catch: Throwable -> L23
    L14:
        if (r7 == null) goto L16;
        OTextView r8 = (OTextView) r7.findViewById(R.id.sheet_title_bar_des_text);     // Catch: Throwable -> L23
    L18:
        if ((r8 instanceof OTextView) == true) goto L21;
        r8 = null;
    L21:
        Object r9 = Result.m803constructorimpl(r8);     // Catch: Throwable -> L23
    L26:
        if (Result.m809isFailureimpl(r9) == true) goto L30;
        r2 = r9;
    L30:
        return (OTextView) r2;
    L16:
        r8 = null;
        goto L18
    L13:
        r7 = null;
        goto L14
    L9:
        r6 = null;
        goto L11
    L6:
        r5 = null;
    L23:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.m803constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    private final View genActionContentView(Context r3, ContentViewStyle r4, String r5, final View.OnClickListener r6, final OInsetSheet r7) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        if (r2 == 1) goto L7;
        if (r2 == 2) goto L6;
        int r8 = r3.getColor(R.color.oui_text_1);
    L8:
        OActionSheetButton r9 = new OActionSheetButton(r3, null, 2, null);
        r9.setText(r5);
        r9.setTextColor(r8);
        r9.setOnClickListener(new OSheetUtils$$ExternalSyntheticLambda7(r6, r7));
        return r9;
    L6:
        r8 = r3.getColor(R.color.oui_functional_red_7);
        goto L8
    L7:
        r8 = r3.getColor(R.color.oui_accent_fg);
        goto L8
    }

    private static final void genActionContentView$lambda$16$lambda$15(View.OnClickListener r1, OInsetSheet r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "$sheet");
        if (r1 == null) goto L5;
        r1.onClick(r3);
    L5:
        r2.dismiss();
    }
}
