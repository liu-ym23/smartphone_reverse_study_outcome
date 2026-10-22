package com.obric.settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.aiagent.assistant.utils.AppEnableStatus;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: CalllogSummarySetting.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\t\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\fH\u0014J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\u001c\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0002J@\u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0(H\u0002JV\u0010)\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020!0$2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020!0$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\f0(H\u0002JY\u0010.\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010/\u001a\u00020+2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\f002%\b\u0002\u00102\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u000103¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\f0(H\u0002J\u0018\u00107\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010/\u001a\u00020+H\u0002J\u0018\u00108\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u00108\u001a\u00020+H\u0002J\u0016\u00109\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006<"}, d2 = {"Lcom/obric/settings/CalllogSummarySetting;", "Lcom/android/contacts/BaseActivity;", "()V", "mAppEnableStatus", "Lkotlin/Lazy;", "Lcom/obric/aiagent/assistant/utils/AppEnableStatus;", "mMenuPopover", "Lcom/obric/oui/popover/v2/OPopover;", "switchUpdateListener", "com/obric/settings/CalllogSummarySetting$switchUpdateListener$1", "Lcom/obric/settings/CalllogSummarySetting$switchUpdateListener$1;", "dismissPopover", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNavigationBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "onResume", "onStatusBarHeightChanged", "recordFileFormatIndex2SettingsValue", "value", "recordFileFormatValue2Index", "recordNumberLimitIndex2SettingsValue", "recordNumberLimitSettingsValue2Index", "recordTypeIndex2SettingsValue", "recordTypeSettingsValue2Index", "refreshView", "setCardListShow", "id", "substring", "", "setOptions", "list", "", "selected", "Lkotlin/Function0;", "callback", "Lkotlin/Function1;", "setOptionsWithSubTitle", "needSelectItemOnClick", "", "titleList", "subTitleList", "setSwitch", MaterialConfigFormatNames.CHECKED, "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "listItemAction", "Lcom/obric/oui/lisitem/OCardListItem;", "Lkotlin/ParameterName;", "name", "listItem", "setSwitchChecked", "show", "showLocalModelDialog", "positiveCallback", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CalllogSummarySetting extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "CalllogSummarySetting";
    private Lazy<? extends AppEnableStatus> mAppEnableStatus;
    private OPopover mMenuPopover;
    private final CalllogSummarySetting$switchUpdateListener$1 switchUpdateListener;

    /* JADX INFO: compiled from: CalllogSummarySetting.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/settings/CalllogSummarySetting$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$F0yivX8QYahiZF1gMUJ5lYnN2Jg(Function0 r0, DialogInterface r1, int r2) {
        showLocalModelDialog$lambda$13(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$TJ2_q5VgQ94-3u9MwxTltIlNpVY, reason: not valid java name */
    public static /* synthetic */ void m766$r8$lambda$TJ2_q5VgQ943u9MwxTltIlNpVY(CalllogSummarySetting r0, List r1, Function0 r2, Function1 r3, OCardListItem r4, View r5) {
        setOptions$lambda$9(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$W0r4gMLJkZj_i4uxU1jUOw1Vwqs(CalllogSummarySetting r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$nCVNArz6SS7VbUqB_fvQkWLFzDM(CalllogSummarySetting r0, View r1) {
        refreshView$lambda$6$lambda$5(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$u_ExIjY07_yfvstbWcKZTwECeLY(Function2 r0, CompoundButton r1, boolean r2) {
        setSwitch$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$zZccnx9hC94MHMK5tQqRCTTA624(CalllogSummarySetting r0, List r1, List r2, Function0 r3, Function1 r4, boolean r5, OCardListItem r6, View r7) {
        setOptionsWithSubTitle$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        Companion = new Companion(null);
    }

    private final int recordFileFormatIndex2SettingsValue(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        if (r1 == 1) goto L8;
        return 2;
    L8:
        return 1;
    }

    private final int recordFileFormatValue2Index(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        if (r1 == 1) goto L8;
        return 2;
    L8:
        return 1;
    }

    private final int recordNumberLimitIndex2SettingsValue(int r1) {
        if (r1 != 1) goto L5;
        return 1000;
    L5:
        if (r1 != 2) goto L7;
        return 2000;
    L7:
        if (r1 == 3) goto L9;
        return 0;
    L9:
        return PathInterpolatorCompat.MAX_NUM_POINTS;
    }

    private final int recordNumberLimitSettingsValue2Index(int r1) {
        if (r1 != 1000) goto L5;
        return 1;
    L5:
        if (r1 != 2000) goto L7;
        return 2;
    L7:
        if (r1 == 3000) goto L9;
        return 0;
    L9:
        return 3;
    }

    private final int recordTypeIndex2SettingsValue(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        if (r1 == 2) goto L8;
        return 1;
    L8:
        return 2;
    }

    private final int recordTypeSettingsValue2Index(int r1) {
        if (r1 != 0) goto L4;
        return 0;
    L4:
        if (r1 == 2) goto L8;
        return 1;
    L8:
        return 2;
    }

    public void com_obric_settings_CalllogSummarySetting__onStop$___twin___() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onDestroy(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onNavigationBarHeightChanged(int r1) {
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_settings_CalllogSummarySetting_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.obric.settings.CalllogSummarySetting$switchUpdateListener$1] */
    public CalllogSummarySetting() {
        this.mAppEnableStatus = LazyKt.lazy(new CalllogSummarySetting$mAppEnableStatus$1(this));
        this.switchUpdateListener = new CalllogSummarySetting$switchUpdateListener$1(this);
    }

    public static final /* synthetic */ void access$dismissPopover(CalllogSummarySetting r0) {
        r0.dismissPopover();
    }

    public static final /* synthetic */ int access$recordFileFormatIndex2SettingsValue(CalllogSummarySetting r0, int r1) {
        return r0.recordFileFormatIndex2SettingsValue(r1);
    }

    public static final /* synthetic */ int access$recordFileFormatValue2Index(CalllogSummarySetting r0, int r1) {
        return r0.recordFileFormatValue2Index(r1);
    }

    public static final /* synthetic */ int access$recordNumberLimitIndex2SettingsValue(CalllogSummarySetting r0, int r1) {
        return r0.recordNumberLimitIndex2SettingsValue(r1);
    }

    public static final /* synthetic */ int access$recordNumberLimitSettingsValue2Index(CalllogSummarySetting r0, int r1) {
        return r0.recordNumberLimitSettingsValue2Index(r1);
    }

    public static final /* synthetic */ int access$recordTypeIndex2SettingsValue(CalllogSummarySetting r0, int r1) {
        return r0.recordTypeIndex2SettingsValue(r1);
    }

    public static final /* synthetic */ int access$recordTypeSettingsValue2Index(CalllogSummarySetting r0, int r1) {
        return r0.recordTypeSettingsValue2Index(r1);
    }

    public static final /* synthetic */ void access$setSwitchChecked(CalllogSummarySetting r0, int r1, boolean r2) {
        r0.setSwitchChecked(r1, r2);
    }

    public static final /* synthetic */ void access$show(CalllogSummarySetting r0, int r1, boolean r2) {
        r0.show(r1, r2);
    }

    public static final /* synthetic */ void access$showLocalModelDialog(CalllogSummarySetting r0, Function0 r1) {
        r0.showLocalModelDialog(r1);
    }

    private final void dismissPopover() {
        OPopover r0 = this.mMenuPopover;
        if (r0 == null) goto L5;
        r0.dismiss();
    L5:
        this.mMenuPopover = null;
    }

    public void com_obric_settings_CalllogSummarySetting__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.calllog_summary_settings_activity);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBar r5 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r5 == null) goto L5;
        r5.addStartAction(R.drawable.ic_arrow_back_24dp, -1, new CalllogSummarySetting$$ExternalSyntheticLambda3(this));
    L5:
        refreshView();
        setSwitch(R.id.mobile_data_switch, SettingsProviderHelper.INSTANCE.getUseMobileData(this, -1), new AnonymousClass2(this), AnonymousClass3.INSTANCE);
        CallSummaryWidget.setSwitchUpdateListener(this.switchUpdateListener);
    }

    private static final void onCreate$lambda$1$lambda$0(CalllogSummarySetting r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    public void com_obric_settings_CalllogSummarySetting__onResume$___twin___() {
        super.onResume();
        refreshView();
    }

    public void com_obric_settings_CalllogSummarySetting__onDestroy$___twin___() {
        super.onDestroy();
        CallSummaryWidget.removeSwitchUpdateListener(this.switchUpdateListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void setSwitch$default(CalllogSummarySetting r0, int r1, boolean r2, Function2 r3, C03871 r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = C03871.INSTANCE;
    L5:
        r0.setSwitch(r1, r2, r3, r4);
    }

    private final void setSwitch(int r1, boolean r2, final Function2<? super CompoundButton, ? super Boolean, Unit> r3, Function1<? super OCardListItem, Unit> r4) {
        OCardListItem r0 = (OCardListItem) findViewById(r1);
        if (r0 == null) goto L5;
        r0.setDefaultCustomEndView(1);
    L5:
        r4.invoke(r0);
        if (r0 == null) goto L8;
        OSwitch r5 = r0.getEndSwitch();
    L9:
        if (r5 == null) goto L12;
        r5.setClickable(true);
    L12:
        if (r5 == null) goto L15;
        r5.setChecked(r2);
    L15:
        if (r5 == null) goto L18;
        r5.setOnCheckedChangeListener(new CalllogSummarySetting$$ExternalSyntheticLambda0(r3));
        return;
    L18:
        return;
    L8:
        r5 = null;
        goto L9
    }

    private static final void setSwitch$lambda$2(Function2 r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        r1.invoke(r2, Boolean.valueOf(r3));
    }

    static /* synthetic */ void setCardListShow$default(CalllogSummarySetting r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.setCardListShow(r1, r2);
    }

    private final void setCardListShow(int r3, String r4) {
        OCardListItem r2 = (OCardListItem) findViewById(r3);
        if (r2 == null) goto L6;
        r2.showTailIcon(true);
        r2.showCustomEnd(true);
        r2.showSubTitle(true);
        r2.showTitle(true);
        OCardListItem.setEndDetailText$default(r2, r4, 0, 2, null);
        return;
    }

    private final void refreshView() {
        boolean r0 = SettingsProviderHelper.INSTANCE.isAutoRecordEnabled(this, false);
        setSwitch$default(this, R.id.auto_record_and_summary, r0, new AnonymousClass1(this), null, 8, null);
        show(R.id.record_type, r0);
        show(R.id.record_storage_count, r0);
        show(R.id.record_file_format, r0);
        OCardListItem r4 = (OCardListItem) findViewById(R.id.record_list);
        if (r4 == null) goto L9;
        setCardListShow$default(this, r4.getId(), null, 2, null);
        if (r0 == false) goto L7;
        int r1 = 3;
    L8:
        OCardListItem.setCardPosition$default(r4, r1, false, 2, null);
        r4.setOnContentClickListener(new CalllogSummarySetting$$ExternalSyntheticLambda4(this));
        goto L9
    L7:
        r1 = 0;
    L9:
        show(R.id.ai_model, CallSummaryGenerateManager.INSTANCE.getVlmProvisionedCache());
        String[] r2 = getResources().getStringArray(R.array.calllog_summary_setting_record_type_options);
        Intrinsics.checkNotNullExpressionValue(r2, "resources.getStringArray…ting_record_type_options)");
        setOptions(R.id.record_type, ArraysKt.toList(r2), new C03863(this), new AnonymousClass4(this));
        String[] r3 = getResources().getStringArray(R.array.calllog_summary_setting_record_storage_count_options);
        Intrinsics.checkNotNullExpressionValue(r3, "resources.getStringArray…rd_storage_count_options)");
        setOptions(R.id.record_storage_count, ArraysKt.toList(r3), new AnonymousClass5(this), new AnonymousClass6(this));
        final List<String> r9 = CollectionsKt.mutableListOf(new String[]{getString(R.string.ai_model_cloud), getString(R.string.ai_model_local)});
        setOptionsWithSubTitle(R.id.ai_model, false, r9, CollectionsKt.mutableListOf(new String[]{getString(R.string.ai_model_summary_cloud_desc), getString(R.string.ai_model_summary_local_desc)}), new AnonymousClass7(this), new AnonymousClass8(this, r9));
        String[] r5 = getResources().getStringArray(R.array.calllog_summary_setting_record_file_format_type_options);
        Intrinsics.checkNotNullExpressionValue(r5, "resources.getStringArray…file_format_type_options)");
        List<String> r6 = ArraysKt.toList(r5);
        String[] r7 = getResources().getStringArray(R.array.calllog_summary_setting_record_file_format_desc_options);
        Intrinsics.checkNotNullExpressionValue(r7, "resources.getStringArray…file_format_desc_options)");
        setOptionsWithSubTitle(R.id.record_file_format, true, r6, ArraysKt.toList(r7), new AnonymousClass9(this), new AnonymousClass10(this));
    }

    private static final void refreshView$lambda$6$lambda$5(CalllogSummarySetting r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.startActivity(new Intent(r2, CallRecordList.class));
    }

    private final void setSwitchChecked(int r1, boolean r2) {
        OCardListItem r0 = (OCardListItem) findViewById(r1);
        if (r0 == null) goto L5;
        OSwitch r3 = r0.getEndSwitch();
    L6:
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.isChecked() == r2) goto L12;
        r3.setChecked(r2);
        return;
    L12:
        return;
    L5:
        r3 = null;
        goto L6
    }

    private final void setOptions(int r8, final List<String> r9, final Function0<Integer> r10, final Function1<? super Integer, Unit> r11) {
        final OCardListItem r0 = (OCardListItem) findViewById(r8);
        setCardListShow(r8, (String) CollectionsKt.getOrNull(r9, r10.invoke().intValue()));
        if (r0 == null) goto L6;
        r0.setOnContentClickListener(new CalllogSummarySetting$$ExternalSyntheticLambda5(this, r9, r10, r11, r0));
        return;
    }

    private static final void setOptions$lambda$9(final CalllogSummarySetting r29, final List r30, Function0 r31, final Function1 r32, final OCardListItem r33, View r34) {
        Intrinsics.checkNotNullParameter(r29, "this$0");
        Intrinsics.checkNotNullParameter(r30, "$list");
        Intrinsics.checkNotNullParameter(r31, "$selected");
        Intrinsics.checkNotNullParameter(r32, "$callback");
        r29.dismissPopover();
        ArrayList r10 = new ArrayList();
        List r0 = r30;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r12 = r0.iterator();
        final int r2 = 0;
    L3:
        boolean r1 = true;
        if (r12.hasNext() == false) goto L13;
        Object r3 = r12.next();
        int r14 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ItemType r16 = ItemType.FILTERS;
        String r20 = (String) r3;
        if (r2 == ((Number) r31.invoke()).intValue()) goto L12;
        r1 = false;
    L12:
        r11.add(new MenuItemData(r16, null, null, null, r20, null, Boolean.valueOf(r1), null, null, new CalllogSummarySetting$setOptions$1$1$1(r32, r2, r33, r30, r29), false, 1422, null));
        r2 = r14;
        goto L3
    L13:
        r10.addAll(r11);
        CalllogSummarySetting r4 = r29;
        OPopover r5 = OUIPopoverHelper.genPopover(r4, r10, true);
        r29.mMenuPopover = r5;
        if (r5 == null) goto L20;
        OUIPopoverHelper.showPopupAtAnchorView(r4, r5, Direct.BOTTOM_LEFT, r33, null);
        return;
    }

    private final void setOptionsWithSubTitle(int r10, final boolean r11, final List<String> r12, final List<String> r13, final Function0<Integer> r14, final Function1<? super Integer, Unit> r15) {
        final OCardListItem r0 = (OCardListItem) findViewById(r10);
        setCardListShow(r10, (String) CollectionsKt.getOrNull(r12, r14.invoke().intValue()));
        if (r0 == null) goto L6;
        r0.setOnContentClickListener(new CalllogSummarySetting$$ExternalSyntheticLambda1(this, r12, r13, r14, r15, r11, r0));
        return;
    }

    private static final void setOptionsWithSubTitle$lambda$12(final CalllogSummarySetting r31, final List r32, List r33, Function0 r34, final Function1 r35, final boolean r36, final OCardListItem r37, View r38) {
        Intrinsics.checkNotNullParameter(r31, "this$0");
        Intrinsics.checkNotNullParameter(r32, "$titleList");
        Intrinsics.checkNotNullParameter(r33, "$subTitleList");
        Intrinsics.checkNotNullParameter(r34, "$selected");
        Intrinsics.checkNotNullParameter(r35, "$callback");
        r31.dismissPopover();
        ArrayList r12 = new ArrayList();
        List r0 = r32;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r14 = r0.iterator();
        final int r2 = 0;
    L3:
        boolean r1 = true;
        if (r14.hasNext() == false) goto L13;
        Object r3 = r14.next();
        int r16 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ItemType r18 = ItemType.FILTERS;
        String r22 = (String) r3;
        CharSequence r23 = (CharSequence) CollectionsKt.getOrNull(r33, r2);
        if (r2 == ((Number) r34.invoke()).intValue()) goto L12;
        r1 = false;
    L12:
        r13.add(new MenuItemData(r18, null, null, null, r22, r23, Boolean.valueOf(r1), null, null, new CalllogSummarySetting$setOptionsWithSubTitle$1$1$1(r35, r2, r36, r37, r32, r31), false, 1422, null));
        r2 = r16;
        goto L3
    L13:
        r12.addAll(r13);
        CalllogSummarySetting r4 = r31;
        OPopover r5 = OUIPopoverHelper.genPopover(r4, r12, true);
        r31.mMenuPopover = r5;
        if (r5 == null) goto L20;
        OUIPopoverHelper.showPopupAtAnchorView(r4, r5, Direct.BOTTOM_LEFT, r37, null);
        return;
    }

    private final void show(int r1, boolean r2) {
        View r0 = findViewById(r1);
        if (r0 != null) goto L6;
        return;
    L6:
        if ((!r2) == false) goto L8;
        int r3 = 8;
    L9:
        r0.setVisibility(r3);
        return;
    L8:
        r3 = 0;
        goto L9
    }

    private final void showLocalModelDialog(final Function0<Unit> r14) {
        OAlertDialogBuilder.negativeButton$default(OAlertDialogBuilder.positiveButton$default(new OAlertDialogBuilder(this).title(R.string.title_use_local_model).message(getString(R.string.title_use_local_model_tip)), R.string.common_ok, new CalllogSummarySetting$$ExternalSyntheticLambda2(r14), null, 4, null), R.string.common_cancel, null, null, 4, null).build().show();
    }

    private static final void showLocalModelDialog$lambda$13(Function0 r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "$positiveCallback");
        r0.invoke();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onCreate(CalllogSummarySetting r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CalllogSummarySetting r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_settings_CalllogSummarySetting__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_settings_CalllogSummarySetting_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CalllogSummarySetting r1) {
        com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onResume(CalllogSummarySetting r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CalllogSummarySetting r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_obric_settings_CalllogSummarySetting__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onStop(CalllogSummarySetting r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CalllogSummarySetting r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_settings_CalllogSummarySetting__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onDestroy")
    public static void com_obric_settings_CalllogSummarySetting_com_obric_privacyhook_PrivacyHook_onDestroy(CalllogSummarySetting r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CalllogSummarySetting r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperDestroy();
        return;
    L6:
        r2.com_obric_settings_CalllogSummarySetting__onDestroy$___twin___();
    }
}
