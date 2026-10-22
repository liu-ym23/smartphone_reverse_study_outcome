package com.obric.Intelligentcall.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.CompoundButton;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.network.request.intelligentvoice.ConversationSceneConf;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentSceneActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005¢\u0006\u0002\u0010\u0002J:\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0016J2\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\f0\u001fH\u0002J#\u0010!\u001a\u00020\f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#2\u0006\u0010!\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSceneActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "diolog", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "editView", "Lcom/obric/oui/forms/OEditText;", "sceneList", "Ljava/util/ArrayList;", "Lcom/obric/network/request/intelligentvoice/ConversationSceneConf;", "Lkotlin/collections/ArrayList;", "initItemView", "", "itemList", "", "tips", "", "conversationKey", "type", "itemTitles", "values", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStatusBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "setSwitch", "id", MaterialConfigFormatNames.CHECKED, "", "callback", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "show", "ids", "", "([Ljava/lang/Integer;Z)V", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentSceneActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final int LIMITED_INPUT_TEXT_COUNT = 50;
    private static final String TAG = "IntelligentSceneActivity";
    private OSimpleFormDialog diolog;
    private OEditText editView;
    private final ArrayList<ConversationSceneConf> sceneList;

    /* JADX INFO: compiled from: IntelligentSceneActivity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentSceneActivity$Companion;", "", "()V", "LIMITED_INPUT_TEXT_COUNT", "", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$NDVr1qD-XER6_csHsH-8ZPr3AVc, reason: not valid java name */
    public static /* synthetic */ void m294$r8$lambda$NDVr1qDXER6_csHsH8ZPr3AVc(IntelligentSceneActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$UuInFoB5rPyIrs6jMzCq91BOHR4(String r0, IntelligentSceneActivity r1, OCardListItem r2, String r3, String r4, View r5) {
        initItemView$lambda$6$lambda$4(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$uKkL2LevOVjROVCAVpOICwb8OMk(Function2 r0, CompoundButton r1, boolean r2) {
        setSwitch$lambda$8(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentSceneActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentSceneActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentSceneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public IntelligentSceneActivity() {
        this.sceneList = new ArrayList();
    }

    public static final /* synthetic */ OSimpleFormDialog access$getDiolog$p(IntelligentSceneActivity r0) {
        return r0.diolog;
    }

    public static final /* synthetic */ OEditText access$getEditView$p(IntelligentSceneActivity r0) {
        return r0.editView;
    }

    public static final /* synthetic */ void access$setEditView$p(IntelligentSceneActivity r0, OEditText r1) {
        r0.editView = r1;
    }

    public static final /* synthetic */ void access$show(IntelligentSceneActivity r0, Integer[] r1, boolean r2) {
        r0.show(r1, r2);
    }

    public void com_obric_Intelligentcall_activity_IntelligentSceneActivity__onCreate$___twin___(Bundle r10) {
        super.onCreate(r10);
        setContentView(R.layout.activity_ai_intelligent_scene_layout);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r0 == null) goto L5;
        OFloatingTitleBar.addStartAction$default(r0, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new IntelligentSceneActivity$$ExternalSyntheticLambda2(this));
    L5:
        final Integer[] r11 = {Integer.valueOf(R.id.ai_intelligent_scene_layout_export), Integer.valueOf(R.id.ai_intelligent_scene_layout_car)};
        IntelligentSceneActivity r3 = this;
        boolean r1 = SettingsProviderHelper.INSTANCE.isAutoIntelligentSceneEnabled(r3, false);
        setSwitch(R.id.auto_intelligent_report, r1, new AnonymousClass2(this, r11));
        show(r11, r1);
        List<ConversationSceneConf> r12 = IntelligentUtils.INSTANCE.migrateConversationScenesIfNeeded(r3);
        this.sceneList.clear();
        this.sceneList.addAll(r12);
        String r13 = getString(R.string.intelligent_scene_item_values_default_ex);
        Intrinsics.checkNotNullExpressionValue(r13, "getString(R.string.intel…e_item_values_default_ex)");
        String r2 = getString(R.string.intelligent_scene_item_values_default_car);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.intel…_item_values_default_car)");
        if ((!this.sceneList.isEmpty()) == false) goto L22;
        Iterator<T> r4 = this.sceneList.iterator();
    L9:
        if (r4.hasNext() == false) goto L22;
        ConversationSceneConf r5 = (ConversationSceneConf) r4.next();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onCreate: " + r5.getConversationType() + ' ' + r5.getMessage());
        String r6 = r5.getConversationKey();
        if (Intrinsics.areEqual(r6, MarkInfoUtil.MARK_TYPE_EXPRESS) == true) goto L12;
        if (Intrinsics.areEqual(r6, MarkInfoUtil.MARK_TYPE_TAXI) == false) goto L9;
        String r7 = r5.getMessage();
        if (r7 == null) goto L9;
        r2 = r7;
        goto L9
    L12:
        String r8 = r5.getMessage();
        if (r8 == null) goto L9;
        r13 = r8;
    L22:
        String r9 = getString(R.string.intelligent_scene_tips_export);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(R.string.intelligent_scene_tips_export)");
        String r14 = getString(R.string.intelligent_scene_type_export);
        Intrinsics.checkNotNullExpressionValue(r14, "getString(R.string.intelligent_scene_type_export)");
        initItemView(R.id.ai_intelligent_scene_layout_export, r9, MarkInfoUtil.MARK_TYPE_EXPRESS, r14, getString(R.string.intelligent_scene_item_title), r13);
        String r15 = getString(R.string.intelligent_scene_tips_car);
        Intrinsics.checkNotNullExpressionValue(r15, "getString(R.string.intelligent_scene_tips_car)");
        String r16 = getString(R.string.intelligent_scene_type_car);
        Intrinsics.checkNotNullExpressionValue(r16, "getString(R.string.intelligent_scene_type_car)");
        initItemView(R.id.ai_intelligent_scene_layout_car, r15, MarkInfoUtil.MARK_TYPE_TAXI, r16, getString(R.string.intelligent_scene_item_title), r2);
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentSceneActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private final void initItemView(int r9, String r10, final String r11, final String r12, final String r13, String r14) {
        View r15 = findViewById(r9);
        OTextView r0 = null;
        if (r15 == null) goto L5;
        OSectionTitleBar r1 = (OSectionTitleBar) r15.findViewById(R.id.tips);
    L6:
        if (r1 == null) goto L8;
        r1.setTitleText(r10);
    L8:
        if (r15 == null) goto L10;
        OCardListItem r16 = (OCardListItem) r15.findViewById(R.id.item);
    L11:
        if (r16 == null) goto L18;
        r16.setTitle(r13);
        r16.showTitle(true);
        r16.showCustomEnd(true);
        r16.showTailIcon(true);
        OCardListItem.setCardPosition$default(r16, 0, false, 2, null);
        OCardListItem.setEndDetailText$default(r16, r14, 0, 2, null);
        r16.setDefaultTailIcon(0);
        final OCardListItem r4 = r16;
        r16.setOnContentClickListener(new IntelligentSceneActivity$$ExternalSyntheticLambda0(r13, this, r4, r11, r12));
        IntelligentUtils.INSTANCE.saveConversationScene(this, r11, r12, r14);
        View r8 = r16.getCustomEndView();
        if ((r8 instanceof OTextView) == false) goto L15;
        r0 = (OTextView) r8;
    L15:
        if (r0 == null) goto L19;
        r0.setMaxWidth(MathKt.roundToInt(TypedValue.applyDimension(1, 190, Resources.getSystem().getDisplayMetrics())));
        r0.setEllipsize(TextUtils.TruncateAt.END);
        return;
    L19:
        return;
    L18:
        return;
    L10:
        r16 = null;
        goto L11
    L5:
        r1 = null;
        goto L6
    }

    private static final void initItemView$lambda$6$lambda$4(String r24, final IntelligentSceneActivity r25, final OCardListItem r26, final String r27, final String r28, View r29) {
        Intrinsics.checkNotNullParameter(r25, "this$0");
        Intrinsics.checkNotNullParameter(r26, "$this_apply");
        Intrinsics.checkNotNullParameter(r27, "$conversationKey");
        Intrinsics.checkNotNullParameter(r28, "$type");
        OSimpleFormDialog.InputViewConfig r8 = new OSimpleFormDialog.InputViewConfig(true, false, new IntelligentSceneActivity$initItemView$1$1$input$1(r26, r25));
        OSimpleFormDialog.InputViewConfig r10 = new OSimpleFormDialog.InputViewConfig(false, false, IntelligentSceneActivity$initItemView$1$1$modifier$1.INSTANCE);
        String r12 = r25.getString(R.string.common_ok);
        Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.common_ok)");
        OBaseDialog.ButtonConfig r17 = new OBaseDialog.ButtonConfig(r12, new IntelligentSceneActivity$initItemView$1$1$modifier$2(r25, r26, r27, r28), null, 4, null);
        String r2 = r25.getString(R.string.common_cancel);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.common_cancel)");
        OSimpleFormDialog.Modifier r4 = new OSimpleFormDialog.Modifier(String.valueOf(r24), "", r8, r10, r17, new OBaseDialog.ButtonConfig(r2, new IntelligentSceneActivity$initItemView$1$1$modifier$3(r26, r25), null, 4, null));
        OSimpleFormDialog r1 = new OSimpleFormDialog(r25, r4);
        r25.diolog = r1;
        r1.show();
    }

    private final void setSwitch(int r4, boolean r5, final Function2<? super CompoundButton, ? super Boolean, Unit> r6) {
        OCardListItem r7 = (OCardListItem) findViewById(r4);
        if (r7 == null) goto L6;
        r7.setTitle(getString(R.string.ai_intelligent_auto_scene));
    L6:
        if (r7 == null) goto L8;
        r7.setDefaultCustomEndView(1);
    L8:
        if (r7 == null) goto L10;
        r7.showTitle(true);
    L10:
        if (r7 == null) goto L12;
        r7.showCustomEnd(true);
    L12:
        OSwitch r0 = null;
        if (r7 == null) goto L15;
        OCardListItem.setCardPosition$default(r7, 0, false, 2, null);
    L15:
        if (r7 == null) goto L17;
        r0 = r7.getEndSwitch();
    L17:
        if (r0 == null) goto L20;
        r0.setClickable(true);
    L20:
        if (r0 == null) goto L23;
        r0.setChecked(r5);
    L23:
        if (r0 == null) goto L26;
        r0.setOnCheckedChangeListener(new IntelligentSceneActivity$$ExternalSyntheticLambda1(r6));
        return;
    }

    private static final void setSwitch$lambda$8(Function2 r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        r1.invoke(r2, Boolean.valueOf(r3));
    }

    private final void show(Integer[] r6, boolean r7) {
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        View r3 = findViewById(r6[r2].intValue());
        if (r3 == null) goto L12;
        if ((!r7) == false) goto L10;
        int r4 = 8;
    L11:
        r3.setVisibility(r4);
        goto L12
    L10:
        r4 = 0;
    L12:
        r2 = r2 + 1;
        goto L3
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentSceneActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentSceneActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSceneActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentSceneActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentSceneActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentSceneActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentSceneActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentSceneActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentSceneActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentSceneActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentSceneActivity__onStop$___twin___();
    }
}
