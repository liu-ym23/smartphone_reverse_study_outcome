package com.android.contacts.calllog.blocked.settings;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.core.content.res.ResourcesCompat;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.calllog.blocked.repo.BlockedDataRequester;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.utils.ContactsLogHook;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: BlockedCallSettingsActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J2\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0018\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0018H\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/android/contacts/calllog/blocked/settings/BlockedCallSettingsActivity;", "Lcom/android/contacts/BaseActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "btnBlockedNumber", "Lcom/obric/oui/lisitem/OCardListItem;", "btnWhitelist", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStatusBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "", "setSwitch", "id", MaterialConfigFormatNames.CHECKED, "", "callback", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "updateNumberCount", "updateNumberCountUI", "numberBtn", "count", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockedCallSettingsActivity extends BaseActivity implements CoroutineScope {
    public static final Companion Companion = null;
    private static final String TAG = "BlockedCallSettingsActivity";
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private OCardListItem btnBlockedNumber;
    private OCardListItem btnWhitelist;

    /* JADX INFO: compiled from: BlockedCallSettingsActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/calllog/blocked/settings/BlockedCallSettingsActivity$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.android.contacts.calllog.blocked.settings.BlockedCallSettingsActivity$updateNumberCount$1, reason: invalid class name */
    /* JADX INFO: compiled from: BlockedCallSettingsActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.android.contacts.calllog.blocked.settings.BlockedCallSettingsActivity$updateNumberCount$1", f = "BlockedCallSettingsActivity.kt", i = {1}, l = {133, 135}, m = "invokeSuspend", n = {"whitelistCount"}, s = {"I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int label;
        final /* synthetic */ BlockedCallSettingsActivity this$0;

        AnonymousClass1(BlockedCallSettingsActivity r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass1(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            int r2 = this.I$0;
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13 Exception -> L15
        L25:
            int r8 = ((Number) r7).intValue();     // Catch: Throwable -> L13 Exception -> L15
            BlockedCallSettingsActivity r3 = this.this$0;     // Catch: Throwable -> L13 Exception -> L15
            BlockedCallSettingsActivity.access$updateNumberCountUI(r3, BlockedCallSettingsActivity.access$getBtnWhitelist$p(r3), r2);     // Catch: Throwable -> L13 Exception -> L15
            BlockedCallSettingsActivity r6 = this.this$0;     // Catch: Throwable -> L13 Exception -> L15
            BlockedCallSettingsActivity.access$updateNumberCountUI(r6, BlockedCallSettingsActivity.access$getBtnBlockedNumber$p(r6), r8);     // Catch: Throwable -> L13 Exception -> L15
        L29:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L13 Exception -> L15
        L21:
            int r9 = ((Number) r7).intValue();     // Catch: Throwable -> L13 Exception -> L15
            BlockedDataRequester r4 = BlockedDataRequester.INSTANCE;     // Catch: Throwable -> L13 Exception -> L15
            ContentResolver r5 = this.this$0.getContentResolver();     // Catch: Throwable -> L13 Exception -> L15
            Intrinsics.checkNotNullExpressionValue(r5, "contentResolver");     // Catch: Throwable -> L13 Exception -> L15
            this.I$0 = r9;     // Catch: Throwable -> L13 Exception -> L15
            this.label = 2;     // Catch: Throwable -> L13 Exception -> L15
            Object r10 = r4.queryBlockedNumberTotalCountAsync(r5, this);     // Catch: Throwable -> L13 Exception -> L15
            if (r10 != r0) goto L24;
            return r0;
        L24:
            r2 = r9;
            r7 = r10;
            goto L25
        L17:
            ResultKt.throwOnFailure(r7);
            BlockedDataRequester r11 = BlockedDataRequester.INSTANCE;     // Catch: Throwable -> L13 Exception -> L15
            ContentResolver r12 = this.this$0.getContentResolver();     // Catch: Throwable -> L13 Exception -> L15
            Intrinsics.checkNotNullExpressionValue(r12, "contentResolver");     // Catch: Throwable -> L13 Exception -> L15
            this.label = 1;     // Catch: Throwable -> L13 Exception -> L15
            r7 = r11.queryWhiteListTotalCountAsync(r12, this);     // Catch: Throwable -> L13 Exception -> L15
            if (r7 != r0) goto L21;
            return r0;
        L13:
            th = move-exception;
            throw th;
        L15:
            e = move-exception;
            ContactsLogHook.e(BlockedCallSettingsActivity.TAG, "updateNumberCount failed", e);     // Catch: Throwable -> L13
            goto L29
        }
    }

    public static /* synthetic */ void $r8$lambda$8Q2XHZQPdSHtYPYOB7KIJnPu98o(Function2 r0, CompoundButton r1, boolean r2) {
        setSwitch$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$G5ozbHl3919E1wEfFqjw60zJ2x8(BlockedCallSettingsActivity r0, View r1) {
        onCreate$lambda$5$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$MBqK-SURRixj2dubIEVkp-PmIMU, reason: not valid java name */
    public static /* synthetic */ void m134$r8$lambda$MBqKSURRixj2dubIEVkpPmIMU(BlockedCallSettingsActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$acFhqh2oJ4CJqXeBTAbIIpE361M(BlockedCallSettingsActivity r0, View r1) {
        onCreate$lambda$3$lambda$2(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    public BlockedCallSettingsActivity() {
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
    }

    public static final /* synthetic */ OCardListItem access$getBtnBlockedNumber$p(BlockedCallSettingsActivity r0) {
        return r0.btnBlockedNumber;
    }

    public static final /* synthetic */ OCardListItem access$getBtnWhitelist$p(BlockedCallSettingsActivity r0) {
        return r0.btnWhitelist;
    }

    public static final /* synthetic */ void access$updateNumberCountUI(BlockedCallSettingsActivity r0, OCardListItem r1, int r2) {
        r0.updateNumberCountUI(r1, r2);
    }

    public void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity__onCreate$___twin___(Bundle r10) {
        super.onCreate(r10);
        setContentView(R.layout.blocked_call_settings_activity);
        UiUtils.setWindowColorStatusBar(this);
        LinkedHashMap r11 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to(2, Integer.valueOf(R.id.blocked_type_mark_classify_ad_sales)), TuplesKt.to(256, Integer.valueOf(R.id.blocked_type_mark_classify_insurance_finance)), TuplesKt.to(1, Integer.valueOf(R.id.blocked_type_mark_classify_harassment)), TuplesKt.to(4, Integer.valueOf(R.id.blocked_type_mark_classify_house_market)), TuplesKt.to(8, Integer.valueOf(R.id.blocked_type_mark_classify_express)), TuplesKt.to(64, Integer.valueOf(R.id.blocked_type_mark_classify_taxi)), TuplesKt.to(128, Integer.valueOf(R.id.blocked_type_mark_classify_high_risk)), TuplesKt.to(16, Integer.valueOf(R.id.blocked_type_mark_classify_fraud)), TuplesKt.to(32, Integer.valueOf(R.id.blocked_type_mark_classify_head_hunter)), TuplesKt.to(512, Integer.valueOf(R.id.blocked_type_mark_classify_load_promotion)), TuplesKt.to(4096, Integer.valueOf(R.id.blocked_type_mark_classify_education)), TuplesKt.to(8192, Integer.valueOf(R.id.blocked_type_mark_classify_decoration))});
        OSectionTitleBar r0 = (OSectionTitleBar) findViewById(R.id.blocked_type_tips);
        String r4 = null;
        if (r0 == null) goto L5;
        r0.setTitleTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_basic_text_3, null));
    L5:
        OFloatingTitleBar r1 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r1 != null) goto L8;
        return;
    L8:
        OFloatingTitleBarHolder r5 = new OFloatingTitleBarHolder(r1);
        Intent r2 = getIntent();
        if (r2 == null) goto L11;
        r4 = r2.getStringExtra("enter_from");
    L11:
        String r6 = r4;
        if (r6 != null) goto L14;
    L17:
        boolean r3 = true;
    L18:
        boolean r7 = !r3;
        if (r6 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r8 == false) goto L27;
        int r9 = R.string.blocked_call_settings_title;
    L28:
        OFloatingTitleBar r12 = r5.getTitleBar();
        if (r12 == null) goto L31;
        r12.setCenterTitle(getString(r9));
    L31:
        r5.addStartAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_back_22_22, new BlockedCallSettingsActivity$$ExternalSyntheticLambda0(this));
        final Ref.IntRef r13 = new Ref.IntRef();
        r13.element = IntelligentUtils.INSTANCE.getPhoneInterceptTypes(this);
        Iterator r14 = r11.entrySet().iterator();
    L33:
        if (r14.hasNext() == false) goto L39;
        Map.Entry r15 = (Map.Entry) r14.next();
        final int r16 = ((Number) r15.getKey()).intValue();
        int r17 = ((Number) r15.getValue()).intValue();
        if ((r13.element & r16) == 0) goto L37;
        boolean r18 = true;
    L38:
        setSwitch(r17, r18, new BlockedCallSettingsActivity$onCreate$2$1(r13, r16, this));
        goto L33
    L37:
        r18 = false;
        goto L38
    L39:
        OCardListItem r19 = (OCardListItem) findViewById(R.id.btn_blocked_number);
        OCardListItem r20 = (OCardListItem) findViewById(R.id.btn_whitelist_number);
        if (r7 == false) goto L47;
        if (r19 == null) goto L44;
        r19.setVisibility(8);
    L44:
        if (r20 == null) goto L57;
        r20.setVisibility(8);
        return;
    L57:
        return;
    L47:
        if (r19 == null) goto L49;
        this.btnBlockedNumber = r19;
        r19.setOnContentClickListener(new BlockedCallSettingsActivity$$ExternalSyntheticLambda1(this));
    L49:
        if (r20 == null) goto L56;
        this.btnWhitelist = r20;
        r20.setOnContentClickListener(new BlockedCallSettingsActivity$$ExternalSyntheticLambda2(this));
        return;
    L56:
        return;
    L27:
        r9 = R.string.blocked_call_title;
        goto L28
    L21:
        if (r6.length() == 0) goto L24;
        r8 = false;
        goto L25
    L14:
        if (r6.length() == 0) goto L17;
        r3 = false;
        goto L18
    }

    private static final void onCreate$lambda$0(BlockedCallSettingsActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void onCreate$lambda$3$lambda$2(BlockedCallSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent();
        r4.setClassName("com.obric.security", "com.obric.securitycenter.nodisturb.black.BlackListActivity");
        r4.setAction("android.intent.action.VIEW");
        r2.startActivity(r4);
    }

    private static final void onCreate$lambda$5$lambda$4(BlockedCallSettingsActivity r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intent r4 = new Intent().setClassName("com.obric.security", "com.obric.securitycenter.nodisturb.white.WhiteListActivity");
        Intrinsics.checkNotNullExpressionValue(r4, "Intent().setClassName(\n …ty\"\n                    )");
        r4.setAction("android.intent.action.VIEW");
        r2.startActivity(r4);
    }

    private final void setSwitch(int r2, boolean r3, final Function2<? super CompoundButton, ? super Boolean, Unit> r4) {
        OCardListItem r1 = (OCardListItem) findViewById(r2);
        OSwitch r5 = null;
        if (r1 == null) goto L5;
        View r6 = r1.getCustomEndView();
    L7:
        if ((r6 instanceof OSwitch) == false) goto L9;
        r5 = (OSwitch) r6;
    L9:
        if (r5 == null) goto L12;
        r5.setChecked(r3);
    L12:
        if (r5 == null) goto L15;
        r5.setOnCheckedChangeListener(new BlockedCallSettingsActivity$$ExternalSyntheticLambda3(r4));
        return;
    L15:
        return;
    L5:
        r6 = null;
        goto L7
    }

    private static final void setSwitch$lambda$6(Function2 r1, CompoundButton r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        Intrinsics.checkNotNullParameter(r2, "buttonView");
        r1.invoke(r2, Boolean.valueOf(r3));
    }

    public void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity__onResume$___twin___() {
        super.onResume();
        updateNumberCount();
    }

    private final void updateNumberCount() {
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
    }

    private final void updateNumberCountUI(OCardListItem r4, int r5) {
        if (r4 == null) goto L4;
        r4.getCustomEndView();
    L4:
        if (r4 == null) goto L7;
        OCardListItem.setEndDetailText$default(r4, getResources().getQuantityString(R.plurals.number_count, r5, new Object[]{Integer.valueOf(r5)}), 0, 2, null);
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_obric_privacyhook_PrivacyHook_onCreate(BlockedCallSettingsActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BlockedCallSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(BlockedCallSettingsActivity r1) {
        com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_obric_privacyhook_PrivacyHook_onResume(BlockedCallSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BlockedCallSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity_com_obric_privacyhook_PrivacyHook_onStop(BlockedCallSettingsActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        BlockedCallSettingsActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_android_contacts_calllog_blocked_settings_BlockedCallSettingsActivity__onStop$___twin___();
    }
}
