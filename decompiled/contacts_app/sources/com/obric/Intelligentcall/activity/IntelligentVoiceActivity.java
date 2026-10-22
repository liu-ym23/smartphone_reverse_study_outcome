package com.obric.Intelligentcall.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.core.os.EnvironmentCompat;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.calllog.record.AudioFocusChangeListener;
import com.android.contacts.calllog.record.AudioFocusManager;
import com.android.contacts.util.OSheetUtils;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.internal.ViewUtils;
import com.obric.Intelligentcall.IntelligentUtils;
import com.obric.Intelligentcall.adapter.IntelligentSoundAdapter;
import com.obric.network.request.intelligentvoice.IntelligentVoiceHelper;
import com.obric.network.request.intelligentvoice.SoundListGetResponseBody;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import com.obric.oui.dialog.alert.OAlertDialog;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.toast.OToast;
import com.obric.privacy.PermissionUtils;
import com.obric.privacy.PrivacyConstantsKt;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import com.obric.voice.TTSManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.ProgressDialog;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0007\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u0011H\u0002J\"\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020\u001dH\u0016J\u0012\u0010+\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010-H\u0015J\u0018\u0010.\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\r2\u0006\u0010/\u001a\u00020&H\u0016J\u0018\u00100\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\r2\u0006\u0010/\u001a\u00020&H\u0016J\"\u00101\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\r2\u0006\u0010/\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u00103\u001a\u00020\u001dH\u0014J-\u00104\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0011062\u0006\u00107\u001a\u000208H\u0016¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u001dH\u0014J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020&H\u0016J7\u0010=\u001a\u00020\u001d2\b\b\u0002\u0010>\u001a\u00020\u00112#\b\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\u001d0?H\u0002J\u001c\u0010C\u001a\u00020\u00112\u0006\u00102\u001a\u00020\u00112\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010E\u001a\u00020\u001d2\b\b\u0002\u0010F\u001a\u00020&H\u0002J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020\u0011H\u0002J\b\u0010I\u001a\u00020\u001dH\u0002J(\u0010J\u001a\u00020\u001d2\u0006\u0010B\u001a\u00020\u001f2\b\u0010K\u001a\u0004\u0018\u00010L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001d0NH\u0002J\u0010\u0010J\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020&H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentVoiceActivity;", "Lcom/android/contacts/BaseActivity;", "Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter$OnItemClickListener;", "()V", "adapter", "Lcom/obric/Intelligentcall/adapter/IntelligentSoundAdapter;", "audioFocusChangeListener", "com/obric/Intelligentcall/activity/IntelligentVoiceActivity$audioFocusChangeListener$1", "Lcom/obric/Intelligentcall/activity/IntelligentVoiceActivity$audioFocusChangeListener$1;", "audioFocusManager", "Lcom/android/contacts/calllog/record/AudioFocusManager;", "customSoundList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseDetail;", "getCustomSoundList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "lastId", "", "listView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "loadingLayout", "Landroid/view/View;", "progressDialog", "Lobric/app/ProgressDialog;", "systemSoundList", "getSystemSoundList", "ttsManager", "Lcom/obric/voice/TTSManager;", "finish", "", "hasPhotoPermission", "", "hideLoading", "initSoundList", "logListSnapshot", "scene", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCopyClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDeleteClick", "position", "onEditClick", "onItemClick", "message", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onStatusBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "requestSoundList", "source", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "sendMessage", "speakerId", "showLoading", "loadingRes", "stopMessage", "taskId", "ttsManagerOnDestroy", "updateSoundList", "date", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseBody;", "callback", "Lkotlin/Function0;", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentVoiceActivity extends BaseActivity implements IntelligentSoundAdapter.OnItemClickListener {
    public static final int ACTIVITY_CODE_INTELLIGENT_COPY_VOICE = 1;
    public static final Companion Companion = null;
    public static final String DEFAULT_VOICE_ID = "defaultSound";
    public static final int MAX_CUSTOM_COUNT = 5;
    private static final String TAG = "IntelligentVoiceActivity";
    private IntelligentSoundAdapter adapter;
    private final IntelligentVoiceActivity$audioFocusChangeListener$1 audioFocusChangeListener;
    private final AudioFocusManager audioFocusManager;
    private final CopyOnWriteArrayList<SoundListGetResponseDetail> customSoundList;
    private String lastId;
    private RecyclerView listView;
    private View loadingLayout;
    private ProgressDialog progressDialog;
    private final CopyOnWriteArrayList<SoundListGetResponseDetail> systemSoundList;
    private TTSManager ttsManager;

    /* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/Intelligentcall/activity/IntelligentVoiceActivity$Companion;", "", "()V", "ACTIVITY_CODE_INTELLIGENT_COPY_VOICE", "", "DEFAULT_VOICE_ID", "", "MAX_CUSTOM_COUNT", "TAG", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$AV8Ixw7CQRkgpiNnjQN4p8XwJQU(IntelligentVoiceActivity r0) {
        initSoundList$lambda$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$B9lnTGcQJdOInit41DTEfKALZ_M(int r0, IntelligentVoiceActivity r1) {
        onEditClick$lambda$14$lambda$13$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$IU8J8zZRtnIv2X1bwe_-mbicEjI, reason: not valid java name */
    public static /* synthetic */ void m302$r8$lambda$IU8J8zZRtnIv2X1bwe_mbicEjI(Ref.ObjectRef r0, Ref.ObjectRef r1, IntelligentVoiceActivity r2, int r3, SoundListGetResponseDetail r4, int r5, DialogInterface r6) {
        onEditClick$lambda$14(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void $r8$lambda$V5hSYkl3SsAvD2HqaogGLzl7YSA(int r0, Ref.ObjectRef r1, Ref.ObjectRef r2, IntelligentVoiceActivity r3, SoundListGetResponseDetail r4, int r5) {
        onEditClick$lambda$14$lambda$13(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$bkGuvogwzVhBNTvFQS9T0RpfTdU(IntelligentVoiceActivity r0, int r1) {
        showLoading$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$djsvID0k1xSzeL7_ZAPulKA-9FI, reason: not valid java name */
    public static /* synthetic */ void m303$r8$lambda$djsvID0k1xSzeL7_ZAPulKA9FI(IntelligentVoiceActivity r0) {
        hideLoading$lambda$6(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$fitS-twg7SUaXHZecPFljfMop_0, reason: not valid java name */
    public static /* synthetic */ void m304$r8$lambda$fitStwg7SUaXHZecPFljfMop_0(IntelligentVoiceActivity r0, int r1) {
        updateSoundList$lambda$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$h5kkCP1sSjOnl_rD1FrbM6-4RMA, reason: not valid java name */
    public static /* synthetic */ void m305$r8$lambda$h5kkCP1sSjOnl_rD1FrbM64RMA(IntelligentVoiceActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ntnfDlnTUMH_gO041esqCze8pIk(DialogInterface r0, int r1) {
        onRequestPermissionsResult$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$wU_ycNSKqQDq8x6rxXM_BdYENsA(DialogInterface r0, int r1) {
        hasPhotoPermission$lambda$8(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.Intelligentcall.activity.IntelligentVoiceActivity$audioFocusChangeListener$1] */
    public IntelligentVoiceActivity() {
        this.systemSoundList = new CopyOnWriteArrayList();
        this.customSoundList = new CopyOnWriteArrayList();
        ?? r0 = new IntelligentVoiceActivity$audioFocusChangeListener$1();
        this.audioFocusChangeListener = r0;
        this.audioFocusManager = new AudioFocusManager(this, (AudioFocusChangeListener) r0);
        this.lastId = "";
    }

    public static final /* synthetic */ IntelligentSoundAdapter access$getAdapter$p(IntelligentVoiceActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ RecyclerView access$getListView$p(IntelligentVoiceActivity r0) {
        return r0.listView;
    }

    public static final /* synthetic */ void access$hideLoading(IntelligentVoiceActivity r0) {
        r0.hideLoading();
    }

    public static final /* synthetic */ void access$initSoundList(IntelligentVoiceActivity r0) {
        r0.initSoundList();
    }

    public static final /* synthetic */ void access$logListSnapshot(IntelligentVoiceActivity r0, String r1) {
        r0.logListSnapshot(r1);
    }

    public static final /* synthetic */ void access$setAdapter$p(IntelligentVoiceActivity r0, IntelligentSoundAdapter r1) {
        r0.adapter = r1;
    }

    public static final /* synthetic */ void access$updateSoundList(IntelligentVoiceActivity r0, int r1) {
        r0.updateSoundList(r1);
    }

    public static final /* synthetic */ void access$updateSoundList(IntelligentVoiceActivity r0, boolean r1, SoundListGetResponseBody r2, Function0 r3) {
        r0.updateSoundList(r1, r2, r3);
    }

    public final CopyOnWriteArrayList<SoundListGetResponseDetail> getSystemSoundList() {
        return this.systemSoundList;
    }

    public final CopyOnWriteArrayList<SoundListGetResponseDetail> getCustomSoundList() {
        return this.customSoundList;
    }

    private final void logListSnapshot(String r3) {
        StringBuilder r4 = new StringBuilder("listSnapshot scene=").append(r3).append(", systemCount=").append(this.systemSoundList.size()).append(", customCount=").append(this.customSoundList.size()).append(", hasCheckedId=");
        if (SettingsProviderHelper.INSTANCE.getIntelligentVoiceCheckId(this).length() <= 0) goto L5;
        boolean r2 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r4.append(r2).toString());
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onCreate$___twin___(Bundle r9) {
        super.onCreate(r9);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onCreate");
        setContentView(R.layout.activity_aiintelligent_voice_layout);
        UiUtils.setWindowColorStatusBar(this);
        View r10 = findViewById(R.id.sound_list);
        Intrinsics.checkNotNull(r10);
        RecyclerView r11 = (RecyclerView) r10;
        this.listView = r11;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r11 = null;
    L5:
        r11.setLayoutManager(new LinearLayoutManager(this));
        View r12 = findViewById(R.id.loading_layout);
        Intrinsics.checkNotNull(r12);
        this.loadingLayout = r12;
        OFloatingTitleBar r2 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r2 == null) goto L8;
        OFloatingTitleBar.addStartAction$default(r2, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new IntelligentVoiceActivity$$ExternalSyntheticLambda9(this));
    L8:
        logListSnapshot("onCreate_beforeInit");
        updateSoundList(false, null, new AnonymousClass2(this));
        requestSoundList$default(this, "onCreate", null, 2, null);
    }

    private static final void onCreate$lambda$1$lambda$0(IntelligentVoiceActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    public void com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onResume$___twin___() {
        super.onResume();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "onResume");
        requestSoundList$default(this, "onResume", null, 2, null);
    }

    public void com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onPause$___twin___() {
        super.onPause();
        StringBuilder r0 = new StringBuilder("onPause lastIdEmpty=");
        boolean r2 = true;
        if (this.lastId.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r1).toString());
        if (this.lastId.length() > 0) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L12;
        stopMessage(this.lastId);
        this.lastId = "";
    L12:
        ttsManagerOnDestroy();
        this.audioFocusManager.releaseAudioFocus();
        return;
    L5:
        r1 = false;
        goto L6
    }

    public void com_obric_Intelligentcall_activity_IntelligentVoiceActivity__finish$___twin___() {
        StringBuilder r0 = new StringBuilder("finish lastIdEmpty=");
        boolean r2 = true;
        if (this.lastId.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(r1).toString());
        super.finish();
        if (this.lastId.length() > 0) goto L10;
        r2 = false;
    L10:
        if (r2 == false) goto L12;
        stopMessage(this.lastId);
        this.lastId = "";
    L12:
        ttsManagerOnDestroy();
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r4, int r5, Intent r6) {
        super.onActivityResult(r4, r5, r6);
        StringBuilder r7 = new StringBuilder("onActivityResult requestCode=").append(r4).append(", resultCode=").append(r5).append(", isCopyVoiceResult=");
        if (r4 != 1) goto L5;
        boolean r2 = true;
    L6:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r7.append(r2).toString());
        if (r5 != (-1)) goto L11;
        if (r4 != 1) goto L12;
        showLoading$default(this, 0, 1, null);
        requestSoundList("onActivityResult", new AnonymousClass1(this));
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void initSoundList() {
        runOnUiThread(new IntelligentVoiceActivity$$ExternalSyntheticLambda1(this));
    }

    private static final void initSoundList$lambda$2(IntelligentVoiceActivity r7) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        RecyclerView r0 = r7.listView;
        RecyclerView r2 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r0 = null;
    L5:
        r0.setVisibility(0);
        View r1 = r7.loadingLayout;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r1 = null;
    L8:
        r1.setVisibility(8);
        r7.adapter = new IntelligentSoundAdapter(r7, r7.systemSoundList, r7.customSoundList, r7);
        RecyclerView r3 = r7.listView;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
    L12:
        r2.setAdapter(r7.adapter);
        return;
    L11:
        r2 = r3;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void requestSoundList$default(IntelligentVoiceActivity r0, String r1, C02211 r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = EnvironmentCompat.MEDIA_UNKNOWN;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = C02211.INSTANCE;
    L8:
        r0.requestSoundList(r1, r2);
    }

    private final void requestSoundList(final String r4, final Function1<? super Boolean, Unit> r5) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "requestSoundList called source=" + r4);
        IntelligentVoiceHelper.INSTANCE.getSoundList(new C02222(r4, this, r5), new AnonymousClass3(r4, this, r5));
    }

    private final void updateSoundList(final int r6) {
        IntelligentVoiceActivity r1 = this;
        this.adapter = new IntelligentSoundAdapter(r1, this.systemSoundList, this.customSoundList, this);
        runOnUiThread(new IntelligentVoiceActivity$$ExternalSyntheticLambda7(this, r6));
        IntelligentUtils.INSTANCE.saveSoundList(r1, this.systemSoundList, this.customSoundList);
        logListSnapshot("updateSoundList_position_" + r6);
    }

    private static final void updateSoundList$lambda$3(IntelligentVoiceActivity r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        RecyclerView r0 = r4.listView;
        RecyclerView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r0 = null;
    L5:
        r0.setAdapter(r4.adapter);
        IntelligentSoundAdapter r2 = r4.adapter;
        if (r2 == null) goto L8;
        r2.notifyDataSetChanged();
    L8:
        IntelligentSoundAdapter r3 = r4.adapter;
        if (r3 == null) goto L11;
        int r6 = r3.getItemCount();
    L12:
        if (r6 <= 0) goto L19;
        int r7 = RangesKt.coerceIn(r5 + 1, 0, r6 - 1);
        RecyclerView r8 = r4.listView;
        if (r8 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
    L17:
        r1.scrollToPosition(r7);
        return;
    L16:
        r1 = r8;
        goto L17
    L19:
        return;
    L11:
        r6 = 0;
        goto L12
    }

    private final void updateSoundList(boolean r12, SoundListGetResponseBody r13, Function0<Unit> r14) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "updateSoundList result isSuccess: " + r12 + " ,  data: " + r13);
        if (r12 == false) goto L8;
        if (r13 == null) goto L7;
        List<SoundListGetResponseDetail> r0 = r13.getSystemSound();
        if (r0 == null) goto L7;
    L9:
        boolean r2 = this.systemSoundList.equals(r0);
        if (r2 == true) goto L12;
        this.systemSoundList.clear();
        this.systemSoundList.addAll(r0);
    L12:
        boolean r4 = false;
        if (this.systemSoundList.size() == 0) goto L20;
        SoundListGetResponseDetail r1 = (SoundListGetResponseDetail) CollectionsKt.getOrNull(this.systemSoundList, 0);
        if (r1 == null) goto L17;
        String r3 = r1.getSpeakerId();
    L19:
        if (Intrinsics.areEqual(r3, "defaultSound") == false) goto L20;
    L21:
        if (r12 == false) goto L37;
        if (r13 == null) goto L26;
        List<SoundListGetResponseDetail> r5 = r13.getCustomSound();
        if (r5 == null) goto L26;
        int r6 = r5.size();
    L28:
        if (r6 <= 5) goto L33;
        if (r13 == null) goto L33;
        List<SoundListGetResponseDetail> r7 = r13.getCustomSound();
        if (r7 == null) goto L33;
        r7.subList(r13.getCustomSound().size() - 5, r13.getCustomSound().size());
    L33:
        if (r13 == null) goto L36;
        List<SoundListGetResponseDetail> r15 = r13.getCustomSound();
        if (r15 == null) goto L36;
    L38:
        boolean r8 = this.customSoundList.equals(r15);
        if (r8 == true) goto L41;
        this.customSoundList.clear();
        this.customSoundList.addAll(r15);
    L41:
        IntelligentVoiceActivity r9 = this;
        String r16 = IntelligentUtils.INSTANCE.getSelectedSoundName(r9);
        if (r16 != null) goto L44;
    L45:
        r4 = true;
    L46:
        if (r4 == false) goto L48;
        SettingsProviderHelper.INSTANCE.setIntelligentVoiceCheckId(r9, "defaultSound");
    L48:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "sysEquals " + r2 + " size = " + this.systemSoundList.size() + ", customEquals " + r8 + " size = " + this.customSoundList.size());
        logListSnapshot("updateSoundList_result_" + r12);
        if (r2 == false) goto L51;
        if (r8 == false) goto L51;
        return;
    L51:
        r14.invoke();
        return;
    L44:
        if (r16.length() != 0) goto L46;
    L36:
        r15 = CollectionsKt.emptyList();
    L26:
        r6 = 0;
        goto L28
    L37:
        r15 = IntelligentUtils.INSTANCE.getCustomSoundList(this);
        goto L38
    L17:
        r3 = null;
    L20:
        this.systemSoundList.add(0, new SoundListGetResponseDetail("defaultSound", getString(R.string.common_default_tone), null, null, null));
        r2 = false;
    L7:
        r0 = CollectionsKt.emptyList();
        goto L9
    L8:
        r0 = IntelligentUtils.INSTANCE.getSysSoundList(this);
        goto L9
    }

    static /* synthetic */ void showLoading$default(IntelligentVoiceActivity r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = R.string.intelligent_sound_list_loading;
    L5:
        r0.showLoading(r1);
    }

    private final void showLoading(final int r2) {
        runOnUiThread(new IntelligentVoiceActivity$$ExternalSyntheticLambda8(this, r2));
    }

    private static final void showLoading$lambda$5(IntelligentVoiceActivity r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        RecyclerView r0 = r3.listView;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r0 = null;
    L5:
        r0.setVisibility(8);
        View r2 = r3.loadingLayout;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
    L9:
        r1.setVisibility(0);
        ProgressDialog r5 = r3.progressDialog;
        if (r5 == null) goto L12;
        r5.dismiss();
    L12:
        ProgressDialog r6 = new ProgressDialog(r3);
        r6.setMessage(r3.getString(r4));
        r6.setCancelable(false);
        r6.setCanceledOnTouchOutside(false);
        r6.show();
        Window r7 = r6.getWindow();
        if (r7 == null) goto L15;
        r7.setLayout(-2, -2);
    L15:
        Window r8 = r6.getWindow();
        if (r8 == null) goto L18;
        r8.setGravity(17);
    L18:
        r3.progressDialog = r6;
        return;
    L8:
        r1 = r2;
        goto L9
    }

    private final void hideLoading() {
        runOnUiThread(new IntelligentVoiceActivity$$ExternalSyntheticLambda5(this));
    }

    private static final void hideLoading$lambda$6(IntelligentVoiceActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        RecyclerView r0 = r3.listView;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listView");
        r0 = null;
    L5:
        r0.setVisibility(0);
        View r1 = r3.loadingLayout;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        r1 = null;
    L8:
        r1.setVisibility(8);
        ProgressDialog r2 = r3.progressDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
    L11:
        r3.progressDialog = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r9, String[] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        Intrinsics.checkNotNullParameter(r11, "grantResults");
        super.onRequestPermissionsResult(r9, r10, r11);
        if (r9 == 12) goto L5;
        return;
    L5:
        if (PermissionUtils.granted(r11) == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "权限申请成功");
        startActivityForResult(new Intent(this, IntelligentSoundPanelActivity.class), 1);
        return;
    L7:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "权限申请失败");
        PermissionUtils.showPermissionGuideDialog$default(PermissionUtils.INSTANCE, this, getString(R.string.intelligent_sound_panel_request_microphone_permission_denied), false, new IntelligentVoiceActivity$$ExternalSyntheticLambda6(), null, 16, null);
    }

    private static final void onRequestPermissionsResult$lambda$7(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    private final boolean hasPhotoPermission() {
        List<String> r1 = PrivacyConstantsKt.getPERMS_FOR_RECORD();
        Intrinsics.checkNotNullExpressionValue(r1, "PERMS_FOR_RECORD");
        boolean r0 = PermissionUtils.checkPermission(this, 12, (String[]) r1.toArray(new String[0]), getString(R.string.intelligent_sound_panel_permission_guide_record_msg), null);
        if (r0 == false) goto L6;
        return true;
    L6:
        PermissionUtils r2 = PermissionUtils.INSTANCE;
        IntelligentVoiceActivity r5 = this;
        List<String> r4 = PrivacyConstantsKt.getPERMS_FOR_RECORD();
        Intrinsics.checkNotNullExpressionValue(r4, "PERMS_FOR_RECORD");
        if (r2.showRequestDialog(r5, (String[]) r4.toArray(new String[0])) == false) goto L10;
        PermissionUtils.showPermissionGuideDialog$default(PermissionUtils.INSTANCE, r5, getString(R.string.intelligent_sound_panel_request_microphone_permission_denied), false, new IntelligentVoiceActivity$$ExternalSyntheticLambda3(), null, 16, null);
        return false;
    L10:
        return r0;
    }

    private static final void hasPhotoPermission$lambda$8(DialogInterface r0, int r1) {
        r0.dismiss();
    }

    @Override // com.obric.Intelligentcall.adapter.IntelligentSoundAdapter.OnItemClickListener
    public void onItemClick(SoundListGetResponseDetail r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "data");
        StringBuilder r7 = new StringBuilder("onItemClick position=").append(r5).append(", name=").append(r4.getName()).append(", hasSpeakerId=");
        String r0 = r4.getSpeakerId();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        StringBuilder r8 = r7.append(!r2).append(", hasPreviewMessage=");
        String r3 = r6;
        if (r3 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        StringBuilder r10 = r8.append(!r9).append(", hadPlayingMessage=");
        if (this.lastId.length() <= 0) goto L19;
        boolean r11 = true;
    L20:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r10.append(r11).toString());
        if (this.lastId.length() <= 0) goto L23;
        r1 = true;
    L23:
        if (r1 == false) goto L25;
        stopMessage(this.lastId);
        ttsManagerOnDestroy();
        this.lastId = "";
    L25:
        if (r6 == null) goto L28;
        this.lastId = sendMessage(r6, r4.getSpeakerId());
        return;
    L28:
        return;
    L19:
        r11 = false;
        goto L20
    L12:
        if (r3.length() == 0) goto L15;
        r9 = false;
        goto L16
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.obric.Intelligentcall.adapter.IntelligentSoundAdapter.OnItemClickListener
    public void onDeleteClick(SoundListGetResponseDetail r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "data");
        StringBuilder r0 = new StringBuilder("onDeleteClick hasSpeakerId=");
        String r1 = r5.getSpeakerId();
        boolean r3 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(!r2).append(", position=").append(r6).append(", name=").append(r5.getName()).toString());
        if (this.lastId.length() > 0) goto L13;
        r3 = false;
    L13:
        if (r3 == false) goto L15;
        stopMessage(this.lastId);
        ttsManagerOnDestroy();
        this.lastId = "";
    L15:
        showLoading(R.string.intelligent_sound_list_delete_loading);
        String r4 = r5.getSpeakerId();
        if (r4 == null) goto L19;
        IntelligentVoiceHelper.INSTANCE.deleteSound(r4, false, new IntelligentVoiceActivity$onDeleteClick$1$1(this, r5, r6), new IntelligentVoiceActivity$onDeleteClick$1$2(this, r5));
        return;
    L19:
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.Intelligentcall.adapter.IntelligentSoundAdapter.OnItemClickListener
    public void onEditClick(final SoundListGetResponseDetail r21, final int r22) {
        Intrinsics.checkNotNullParameter(r21, "data");
        StringBuilder r0 = new StringBuilder("onEditClick hasSpeakerId=");
        String r1 = r21.getSpeakerId();
        int r2 = 0;
        boolean r4 = true;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r0.append(!r3).append(", position=").append(r22).append(", name=").append(r21.getName()).toString());
        if (this.lastId.length() > 0) goto L13;
        r4 = false;
    L13:
        if (r4 == false) goto L15;
        stopMessage(this.lastId);
        ttsManagerOnDestroy();
        this.lastId = "";
    L15:
        int r5 = this.customSoundList.size();
    L16:
        if (r2 >= r5) goto L21;
        if (Intrinsics.areEqual(this.customSoundList.get(r2).getSpeakerId(), r21.getSpeakerId()) == true) goto L19;
        r2 = r2 + 1;
        goto L16
    L19:
        this.customSoundList.set(r2, r21);
    L21:
        final int r6 = r22 - this.systemSoundList.size();
        final Ref.ObjectRef r7 = new Ref.ObjectRef();
        if (r6 >= 0) goto L24;
    L26:
        T r8 = getString(R.string.common_custom_tone);
    L27:
        r7.element = r8;
        final Ref.ObjectRef r9 = new Ref.ObjectRef();
        r9.element = r7.element;
        OAlertDialog r10 = OSheetUtils.getEditDialog$default(OSheetUtils.INSTANCE, this, getString(R.string.intelligent_sound_edit_dialog_title), null, null, (String) r7.element, true, new IntelligentVoiceActivity$onEditClick$dialog$1(r7, r9), null, 0, null, ViewUtils.EDGE_TO_EDGE_FLAGS, null);
        r10.show();
        r10.setOnDismissListener(new IntelligentVoiceActivity$$ExternalSyntheticLambda0(r7, r9, this, r6, r21, r22));
        return;
    L24:
        if (r6 >= this.customSoundList.size()) goto L26;
        r8 = this.customSoundList.get(r6).getName();
        goto L27
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private static final void onEditClick$lambda$14(final Ref.ObjectRef r7, final Ref.ObjectRef r8, final IntelligentVoiceActivity r9, final int r10, final SoundListGetResponseDetail r11, final int r12, DialogInterface r13) {
        Intrinsics.checkNotNullParameter(r7, "$text");
        Intrinsics.checkNotNullParameter(r8, "$before");
        Intrinsics.checkNotNullParameter(r9, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$data");
        if (Intrinsics.areEqual(r7.element, r8.element) == false) goto L5;
        return;
    L5:
        r9.runOnUiThread(new IntelligentVoiceActivity$$ExternalSyntheticLambda4(r10, r8, r7, r9, r11, r12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void onEditClick$lambda$14$lambda$13(final int r10, Ref.ObjectRef r11, Ref.ObjectRef r12, final IntelligentVoiceActivity r13, SoundListGetResponseDetail r14, int r15) {
        Intrinsics.checkNotNullParameter(r11, "$before");
        Intrinsics.checkNotNullParameter(r12, "$text");
        Intrinsics.checkNotNullParameter(r13, "this$0");
        Intrinsics.checkNotNullParameter(r14, "$data");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "editDialog dismiss index=" + r10 + ", oldName=" + ((String) r11.element) + ", newName=" + ((String) r12.element));
        if (r10 >= 0) goto L5;
    L9:
        r13.runOnUiThread(new IntelligentVoiceActivity$$ExternalSyntheticLambda2(r10, r13));
        return;
    L5:
        if (r10 >= r13.customSoundList.size()) goto L9;
        r13.showLoading(R.string.intelligent_sound_list_update_loading);
        String r16 = (String) r12.element;
        if (r16 == null) goto L11;
        IntelligentVoiceHelper.INSTANCE.soundCopy("", r16, r14.getSpeakerId(), null, new IntelligentVoiceActivity$onEditClick$1$1$1$1(r13, r14, r16, r10, r15), new IntelligentVoiceActivity$onEditClick$1$1$1$2(r13, r14, r16));
        return;
    }

    private static final void onEditClick$lambda$14$lambda$13$lambda$12(int r7, IntelligentVoiceActivity r8) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "onDismiss: " + r7 + " size " + r8.customSoundList.size());
        String r3 = r8.getString(R.string.edit_fail_toast);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.edit_fail_toast)");
        OToast.Companion.show$default(OToast.Companion, r8, r3, 0, 4, null);
    }

    @Override // com.obric.Intelligentcall.adapter.IntelligentSoundAdapter.OnItemClickListener
    public void onCopyClick() {
        if (hasPhotoPermission() == false) goto L6;
        startActivityForResult(new Intent(this, IntelligentSoundPanelActivity.class), 1);
        return;
    }

    static /* synthetic */ String sendMessage$default(IntelligentVoiceActivity r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.sendMessage(r1, r2);
    }

    private final String sendMessage(String r4, String r5) {
        this.audioFocusManager.requestAudioFocus();
        if (this.ttsManager != null) goto L5;
        this.ttsManager = new TTSManager();
    L5:
        String r0 = "IntelligentVoiceActivity_" + System.currentTimeMillis() + '_' + r5;
        TTSManager r3 = this.ttsManager;
        if (r3 == null) goto L11;
        if (r3 == null) goto L9;
        String r6 = r3.getSpeakerId(r5);
    L10:
        r3.startSendTextTask(r0, r4, r6);
        goto L11
    L9:
        r6 = null;
    L11:
        return r0;
    }

    private final void stopMessage(String r1) {
        TTSManager r0 = this.ttsManager;
        if (r0 == null) goto L6;
        r0.endSendTextTask(r1);
        return;
    }

    private final void ttsManagerOnDestroy() {
        TTSManager r0 = this.ttsManager;
        if (r0 == null) goto L5;
        r0.onDestroy();
    L5:
        this.ttsManager = null;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onCreate(IntelligentVoiceActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(IntelligentVoiceActivity r1) {
        com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onResume(IntelligentVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onPause(IntelligentVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_onStop(IntelligentVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentVoiceActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_obric_Intelligentcall_activity_IntelligentVoiceActivity_com_obric_privacyhook_PrivacyHook_finish(IntelligentVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        IntelligentVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_IntelligentVoiceActivity__finish$___twin___();
    }
}
