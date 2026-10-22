package com.obric.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.R;
import com.android.contacts.group.GroupEditorFormDialog;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.dialog.v2.selection.OSelectionDialog;
import com.obric.ui.dialog.action.ActionDialogAdapter;
import com.obric.ui.dialog.action.ActionDialogItemData;
import com.obric.ui.dialog.selection.SelectionButton;
import com.obric.ui.dialog.selection.SelectionDialogAdapter;
import com.obric.ui.dialog.selection.SelectionDialogItemData;
import com.obric.ui.dialog.selection.SelectionType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: OUIDialogHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J@\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0002J8\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J~\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u000b2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010#2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150#H\u0007Jd\u0010&\u001a\u00020'2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00110\b2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010)2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013H\u0007Jn\u0010+\u001a\u00020,2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00192\b\b\u0002\u0010!\u001a\u00020\u000b2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010#2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010#H\u0007¨\u0006-"}, d2 = {"Lcom/obric/ui/dialog/OUIDialogHelper;", "", "()V", "genActionContentView", "Landroid/view/View;", "context", "Landroid/content/Context;", "items", "", "Lcom/obric/ui/dialog/action/ActionDialogItemData;", "hasCancel", "", "genSelectionContentView", "activity", "Landroid/app/Activity;", "selectionType", "Lcom/obric/ui/dialog/selection/SelectionType;", "Lcom/obric/ui/dialog/selection/SelectionDialogItemData;", "itemClickListener", "Lkotlin/Function2;", "", "", "getActionDialog", "Lcom/obric/oui/dialog/v2/action/OActionDialog;", "title", "", "subtitle", "getGroupEditorFormDialog", "Lcom/android/contacts/group/GroupEditorFormDialog;", "positiveButtonText", "negativeButtonText", "hintText1", "hintText2", "showSecondInput", "positiveOnClick", "Lkotlin/Function0;", "negativeOnClick", "onFinishCallback", "getSelectionDialog", "Lcom/obric/oui/dialog/v2/selection/OSelectionDialog;", "positiveButton", "Lcom/obric/ui/dialog/selection/SelectionButton;", "negativeButton", "getSimpleFormDialog", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OUIDialogHelper {
    public static final OUIDialogHelper INSTANCE = null;

    static {
        INSTANCE = new OUIDialogHelper();
    }

    private OUIDialogHelper() {
    }

    public static final /* synthetic */ View access$genActionContentView(OUIDialogHelper r0, Context r1, List r2, boolean r3) {
        return r0.genActionContentView(r1, r2, r3);
    }

    public static final /* synthetic */ View access$genSelectionContentView(OUIDialogHelper r0, Activity r1, SelectionType r2, List r3, Function2 r4) {
        return r0.genSelectionContentView(r1, r2, r3, r4);
    }

    public static /* synthetic */ OActionDialog getActionDialog$default(Context r0, String r1, String r2, List r3, boolean r4, int r5, Object r6) {
        if ((r5 & 16) == 0) goto L6;
        r4 = false;
    L6:
        return getActionDialog(r0, r1, r2, r3, r4);
    }

    @JvmStatic
    public static final OActionDialog getActionDialog(final Context r2, String r3, String r4, final List<ActionDialogItemData> r5, final boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "subtitle");
        Intrinsics.checkNotNullParameter(r5, "items");
        return new OActionDialog(r2, new OActionDialog.Modifier(r3, r4, new OUIDialogHelper$getActionDialog$modifier$1(r2, r5, r6)));
    }

    static /* synthetic */ View genActionContentView$default(OUIDialogHelper r0, Context r1, List r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return r0.genActionContentView(r1, r2, r3);
    }

    private final View genActionContentView(Context r6, List<ActionDialogItemData> r7, boolean r8) {
        RecyclerView r5 = new RecyclerView(r6);
        r5.setOverScrollMode(2);
        r5.setLayoutManager(new LinearLayoutManager(r6));
        r5.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        int r1 = MathKt.roundToInt(TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics()));
        int r2 = MathKt.roundToInt(TypedValue.applyDimension(1, 24, Resources.getSystem().getDisplayMetrics()));
        if (r8 == false) goto L5;
        int r9 = r7.size();
    L6:
        r5.addItemDecoration(new ActionDialogItemDecoration(r1, r2, r9));
        ActionDialogAdapter r10 = new ActionDialogAdapter(r6);
        r5.setAdapter(r10);
        r10.setItems(r7);
        return r5;
    L5:
        r9 = r7.size() + 1;
        goto L6
    }

    @JvmStatic
    public static final OSelectionDialog getSelectionDialog(final Activity r15, String r16, String r17, final SelectionType r18, final List<SelectionDialogItemData> r19, SelectionButton r20, SelectionButton r21, final Function2<? super SelectionDialogItemData, ? super Integer, Unit> r22) {
        Intrinsics.checkNotNullParameter(r15, "activity");
        Intrinsics.checkNotNullParameter(r16, "title");
        Intrinsics.checkNotNullParameter(r17, "subtitle");
        Intrinsics.checkNotNullParameter(r18, "selectionType");
        Intrinsics.checkNotNullParameter(r19, "items");
        Intrinsics.checkNotNullParameter(r22, "itemClickListener");
        String r1 = r16;
        String r2 = r17;
        Function1<ViewGroup, View> r3 = new OUIDialogHelper$getSelectionDialog$modifier$1(r15, r18, r19, r22);
        boolean r4 = true;
        if (r20 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        OBaseDialog.ButtonConfig r8 = null;
        if (r7 == false) goto L11;
        OBaseDialog.ButtonConfig r9 = new OBaseDialog.ButtonConfig(r20.getText(), r20.getOnClick(), null, 4, null);
    L12:
        if (r21 != null) goto L14;
    L16:
        r4 = false;
    L17:
        if (r4 == false) goto L20;
        r8 = new OBaseDialog.ButtonConfig(r21.getText(), r21.getOnClick(), null, 4, null);
    L20:
        return new OSelectionDialog(r15, new OSelectionDialog.Modifier(r1, r2, r3, r9, r8));
    L14:
        if (r21.getShow() != true) goto L16;
    L11:
        r9 = null;
        goto L12
    L5:
        if (r20.getShow() != true) goto L7;
        r7 = true;
        goto L8
    }

    private final View genSelectionContentView(Activity r9, SelectionType r10, List<SelectionDialogItemData> r11, Function2<? super SelectionDialogItemData, ? super Integer, Unit> r12) {
        Activity r13 = r9;
        RecyclerView r8 = new RecyclerView(r13);
        r8.setOverScrollMode(2);
        r8.setLayoutManager(new LinearLayoutManager(r8.getContext()));
        r8.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        float r0 = 2;
        r8.addItemDecoration(new VerticalSpaceItemDecoration(TypedValue.applyDimension(1, (float) 0.6d, Resources.getSystem().getDisplayMetrics()), ContextCompat.getColor(r13, R.color.oui_basic_line_1), TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, r0, Resources.getSystem().getDisplayMetrics()), TypedValue.applyDimension(1, 12, Resources.getSystem().getDisplayMetrics())));
        SelectionDialogAdapter r1 = new SelectionDialogAdapter(r13, r10);
        r8.setAdapter(r1);
        r1.setItems(r11);
        r1.setOnItemClickListener(r12);
        return r8;
    }

    public static /* synthetic */ OSimpleFormDialog getSimpleFormDialog$default(Context r12, String r13, String r14, String r15, String r16, String r17, String r18, boolean r19, Function0 r20, Function0 r21, int r22, Object r23) {
        if ((r22 & 128) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r22 & 256) == 0) goto L9;
        Function0 r10 = null;
    L11:
        if ((r22 & 512) == 0) goto L13;
        Function0 r11 = null;
    L15:
        return getSimpleFormDialog(r12, r13, r14, r15, r16, r17, r18, r9, r10, r11);
    L13:
        r11 = r21;
        goto L15
    L9:
        r10 = r20;
        goto L11
    L5:
        r9 = r19;
        goto L7
    }

    @JvmStatic
    public static final OSimpleFormDialog getSimpleFormDialog(Context r26, String r27, String r28, String r29, String r30, final String r31, final String r32, boolean r33, Function0<Unit> r34, Function0<Unit> r35) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r27, "title");
        Intrinsics.checkNotNullParameter(r28, "subtitle");
        Intrinsics.checkNotNullParameter(r29, "positiveButtonText");
        Intrinsics.checkNotNullParameter(r30, "negativeButtonText");
        Intrinsics.checkNotNullParameter(r31, "hintText1");
        Intrinsics.checkNotNullParameter(r32, "hintText2");
        Function1 r9 = null;
        int r10 = 4;
        DefaultConstructorMarker r11 = null;
        return new OSimpleFormDialog(r26, new OSimpleFormDialog.Modifier(r27, r28, new OSimpleFormDialog.InputViewConfig(true, false, new OUIDialogHelper$getSimpleFormDialog$modifier$1(r31), 2, null), new OSimpleFormDialog.InputViewConfig(r33, false, new OUIDialogHelper$getSimpleFormDialog$modifier$2(r32), 2, null), new OBaseDialog.ButtonConfig(r29, r34, r9, r10, r11), new OBaseDialog.ButtonConfig(r30, r35, r9, r10, r11)));
    }

    public static /* synthetic */ GroupEditorFormDialog getGroupEditorFormDialog$default(Context r13, String r14, String r15, String r16, String r17, String r18, String r19, boolean r20, Function0 r21, Function0 r22, Function0 r23, int r24, Object r25) {
        if ((r24 & 128) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r24 & 256) == 0) goto L9;
        Function0 r10 = null;
    L11:
        if ((r24 & 512) == 0) goto L13;
        Function0 r11 = null;
    L15:
        if ((r24 & 1024) == 0) goto L17;
        Function0 r12 = AnonymousClass1.INSTANCE;
    L19:
        return getGroupEditorFormDialog(r13, r14, r15, r16, r17, r18, r19, r9, r10, r11, r12);
    L17:
        r12 = r23;
        goto L19
    L13:
        r11 = r22;
        goto L15
    L9:
        r10 = r21;
        goto L11
    L5:
        r9 = r20;
        goto L7
    }

    @JvmStatic
    public static final GroupEditorFormDialog getGroupEditorFormDialog(Context r27, String r28, String r29, String r30, String r31, final String r32, final String r33, boolean r34, Function0<Unit> r35, Function0<Unit> r36, Function0<Unit> r37) {
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r28, "title");
        Intrinsics.checkNotNullParameter(r29, "subtitle");
        Intrinsics.checkNotNullParameter(r30, "positiveButtonText");
        Intrinsics.checkNotNullParameter(r31, "negativeButtonText");
        Intrinsics.checkNotNullParameter(r32, "hintText1");
        Intrinsics.checkNotNullParameter(r33, "hintText2");
        Intrinsics.checkNotNullParameter(r37, "onFinishCallback");
        Function1 r10 = null;
        int r11 = 4;
        DefaultConstructorMarker r12 = null;
        return new GroupEditorFormDialog(r27, new OSimpleFormDialog.Modifier(r28, r29, new OSimpleFormDialog.InputViewConfig(true, false, new OUIDialogHelper$getGroupEditorFormDialog$modifier$1(r32), 2, null), new OSimpleFormDialog.InputViewConfig(r34, false, new OUIDialogHelper$getGroupEditorFormDialog$modifier$2(r33), 2, null), new OBaseDialog.ButtonConfig(r30, r35, r10, r11, r12), new OBaseDialog.ButtonConfig(r31, r36, r10, r11, r12)), r37);
    }
}
