package com.obric.Intelligentcall.activity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import com.GlobalProxyLancet;
import com.android.contacts.BaseActivity;
import com.android.contacts.R;
import com.android.contacts.calllog.record.AudioFocusChangeListener;
import com.android.contacts.calllog.record.AudioFocusManager;
import com.android.contacts.util.UiUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.Intelligentcall.adapter.IntelligentSoundCardItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PrivacyUtils;
import com.obric.settings.SettingsProviderHelper;
import com.obric.voice.TTSManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: CallForMeVoiceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0004\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\tH\u0002J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0015J\b\u0010\u001c\u001a\u00020\u0011H\u0014J\b\u0010\u001d\u001a\u00020\u0011H\u0014J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0011H\u0002J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0002J7\u0010#\u001a\u00020\u00112\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160%2\u0006\u0010&\u001a\u00020\u00162\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00110(H\u0002¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u0011H\u0002J\u0010\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u000bH\u0002J\b\u0010.\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/Intelligentcall/activity/CallForMeVoiceActivity;", "Lcom/android/contacts/BaseActivity;", "()V", "audioFocusChangeListener", "com/obric/Intelligentcall/activity/CallForMeVoiceActivity$audioFocusChangeListener$1", "Lcom/obric/Intelligentcall/activity/CallForMeVoiceActivity$audioFocusChangeListener$1;", "audioFocusManager", "Lcom/android/contacts/calllog/record/AudioFocusManager;", "isActivityResumed", "", "lastId", "", "mediaPlayer", "Landroid/media/MediaPlayer;", "ttsManager", "Lcom/obric/voice/TTSManager;", "clickItemAction", "", "voice", "finish", "getSubTitleText", "index", "", "getTitleText", "isPlaying", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onStatusBarHeightChanged", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "playAssetSound", "sendMessage", "message", "setGroup", "ids", "", "selected", "callback", "Lkotlin/Function1;", "([Ljava/lang/Integer;ILkotlin/jvm/functions/Function1;)V", "showCallForMeVoice", "stopAssetSound", "stopMessage", "taskId", "ttsManagerOnDestroy", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallForMeVoiceActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "CallForMeVoiceActivity";
    private final CallForMeVoiceActivity$audioFocusChangeListener$1 audioFocusChangeListener;
    private final AudioFocusManager audioFocusManager;
    private boolean isActivityResumed;
    private String lastId;
    private MediaPlayer mediaPlayer;
    private TTSManager ttsManager;

    /* JADX INFO: compiled from: CallForMeVoiceActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/Intelligentcall/activity/CallForMeVoiceActivity$Companion;", "", "()V", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void $r8$lambda$U9iePbAfWFMEv5WD66QqOBtqWds(List r0, Function1 r1, int r2, View r3) {
        setGroup$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$_oR3NG_-_jKlcx7ZjCWF3AKAH0I, reason: not valid java name */
    public static /* synthetic */ void m292$r8$lambda$_oR3NG__jKlcx7ZjCWF3AKAH0I(CallForMeVoiceActivity r0, MediaPlayer r1) {
        playAssetSound$lambda$8$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$pAHG32W4xkGnLrE4stH5VI048Q4(CallForMeVoiceActivity r0, View r1) {
        onCreate$lambda$1$lambda$0(r0, r1);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onStop$___twin___() {
        super.onStop();
    }

    @Override // com.android.contacts.BaseActivity, android.app.Activity
    public void finish() {
        com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onCreate(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onPause(this);
    }

    @Override // com.android.contacts.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onResume(this);
    }

    @Override // com.android.contacts.BaseActivity, com.obric.immersive.ImmersiveCallback
    public void onStatusBarHeightChanged(int r1) {
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(this);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.Intelligentcall.activity.CallForMeVoiceActivity$audioFocusChangeListener$1] */
    public CallForMeVoiceActivity() {
        this.lastId = "";
        ?? r0 = new CallForMeVoiceActivity$audioFocusChangeListener$1(this);
        this.audioFocusChangeListener = r0;
        this.audioFocusManager = new AudioFocusManager(this, (AudioFocusChangeListener) r0);
    }

    public static final /* synthetic */ void access$clickItemAction(CallForMeVoiceActivity r0, String r1) {
        r0.clickItemAction(r1);
    }

    public static final /* synthetic */ boolean access$isActivityResumed$p(CallForMeVoiceActivity r0) {
        return r0.isActivityResumed;
    }

    public static final /* synthetic */ boolean access$isPlaying(CallForMeVoiceActivity r0) {
        return r0.isPlaying();
    }

    public static final /* synthetic */ void access$playAssetSound(CallForMeVoiceActivity r0) {
        r0.playAssetSound();
    }

    public static final /* synthetic */ void access$stopAssetSound(CallForMeVoiceActivity r0) {
        r0.stopAssetSound();
    }

    public static final /* synthetic */ void access$ttsManagerOnDestroy(CallForMeVoiceActivity r0) {
        r0.ttsManagerOnDestroy();
    }

    public void com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.activity_call_for_me_voice_layout);
        UiUtils.setWindowColorStatusBar(this);
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r0 == null) goto L5;
        OFloatingTitleBar.addStartAction$default(r0, R.drawable.icon_back_22_22, 0, null, 6, null).setOnClickListener(new CallForMeVoiceActivity$$ExternalSyntheticLambda2(this));
    L5:
        showCallForMeVoice();
    }

    private static final void onCreate$lambda$1$lambda$0(CallForMeVoiceActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    public void com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onResume$___twin___() {
        super.onResume();
        this.isActivityResumed = true;
        showCallForMeVoice();
    }

    public void com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onPause$___twin___() {
        super.onPause();
        boolean r0 = false;
        this.isActivityResumed = false;
        if (this.lastId.length() <= 0) goto L5;
        r0 = true;
    L5:
        if (r0 == false) goto L7;
        stopMessage(this.lastId);
        this.lastId = "";
    L7:
        ttsManagerOnDestroy();
        stopAssetSound();
        this.audioFocusManager.releaseAudioFocus();
    }

    public void com_obric_Intelligentcall_activity_CallForMeVoiceActivity__finish$___twin___() {
        super.finish();
        if (this.lastId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        stopMessage(this.lastId);
        this.lastId = "";
    L8:
        ttsManagerOnDestroy();
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final String sendMessage(String r4) {
        stopAssetSound();
        this.audioFocusManager.requestAudioFocus();
        if (this.lastId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        stopMessage(this.lastId);
        ttsManagerOnDestroy();
        this.lastId = "";
    L9:
        if (this.ttsManager != null) goto L11;
        this.ttsManager = new TTSManager();
    L11:
        String r1 = "CallForMeVoiceActivity_" + System.currentTimeMillis();
        TTSManager r3 = this.ttsManager;
        if (r3 == null) goto L14;
        r3.startSendTextTask(r1, r4, null);
    L14:
        return r1;
    L5:
        r0 = false;
        goto L6
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

    private static final void setGroup$lambda$5$lambda$4(List r2, Function1 r3, int r4, View r5) {
        Intrinsics.checkNotNullParameter(r2, "$views");
        Intrinsics.checkNotNullParameter(r3, "$callback");
        Iterator r6 = r2.iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        IntelligentSoundCardItem r7 = (IntelligentSoundCardItem) r6.next();
        Object r0 = r7.getContentContainer().getTag();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.Int");
        if (((Integer) r0).intValue() != r4) goto L8;
        boolean r1 = true;
    L9:
        r7.setItemChecked(r1);
        goto L4
    L8:
        r1 = false;
        goto L9
    L10:
        r3.invoke(Integer.valueOf(r4));
    }

    public final String getTitleText(int r4) {
        if (r4 != 0) goto L5;
        String r3 = getString(R.string.common_default_tone);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.common_default_tone)");
        return r3;
    L5:
        if (r4 == 1) goto L7;
        String r5 = getString(R.string.common_default_tone);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.common_default_tone)");
        return r5;
    L7:
        String r6 = getString(R.string.call_for_male_voice);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.call_for_male_voice)");
        return r6;
    }

    public final String getSubTitleText(int r4) {
        if (r4 != 0) goto L5;
        String r3 = getString(R.string.call_for_female_voice_tips);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.call_for_female_voice_tips)");
        return r3;
    L5:
        if (r4 == 1) goto L7;
        String r5 = getString(R.string.call_for_female_voice_tips);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.call_for_female_voice_tips)");
        return r5;
    L7:
        String r6 = getString(R.string.call_for_male_voice_tips);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.call_for_male_voice_tips)");
        return r6;
    }

    private final void showCallForMeVoice() {
        boolean r0 = Intrinsics.areEqual(SettingsProviderHelper.INSTANCE.getCallForMeVoice(this), SettingsProviderHelper.CALL_FOR_ME_VOICE_MALE);
        setGroup(new Integer[]{Integer.valueOf(R.id.call_for_me_voice_female), Integer.valueOf(R.id.call_for_me_voice_male)}, r0 ? 1 : 0, new AnonymousClass1(this));
    }

    private final void playAssetSound() {
        if (this.lastId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        stopMessage(this.lastId);
        this.lastId = "";
    L8:
        ttsManagerOnDestroy();
        this.audioFocusManager.requestAudioFocus();
        stopAssetSound();
        AssetFileDescriptor r1 = getAssets().openFd("call_for_me_junyu_voice.m4a");     // Catch: Exception -> L19
        AssetFileDescriptor r2 = r1;     // Catch: Throwable -> L14
        MediaPlayer r8 = new MediaPlayer();     // Catch: Throwable -> L14
        r8.setDataSource(r2.getFileDescriptor(), r2.getStartOffset(), r2.getLength());     // Catch: Throwable -> L14
        r8.prepare();     // Catch: Throwable -> L14
        r8.start();     // Catch: Throwable -> L14
        r8.setOnCompletionListener(new CallForMeVoiceActivity$$ExternalSyntheticLambda1(this));     // Catch: Throwable -> L14
        this.mediaPlayer = r8;     // Catch: Throwable -> L14
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L14
    L12:
        CloseableKt.closeFinally(r1, null);     // Catch: Exception -> L19
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "playAssetSound error", e);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final void playAssetSound$lambda$8$lambda$7$lambda$6(CallForMeVoiceActivity r0, MediaPlayer r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.stopAssetSound();
    }

    private final void stopAssetSound() {
        MediaPlayer r0 = this.mediaPlayer;
        if (r0 != null) goto L5;
    L8:
        this.mediaPlayer = null;
        return;
    L5:
        if (r0.isPlaying() == false) goto L7;
        r0.stop();
    L7:
        r0.release();
        goto L8
    }

    private final void clickItemAction(String r2) {
        if (Intrinsics.areEqual(r2, SettingsProviderHelper.CALL_FOR_ME_VOICE_FEMALE) == false) goto L6;
        String r3 = getString(R.string.intelligent_sound_panel_record_sys_default_sound);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.intel…record_sys_default_sound)");
        sendMessage(r3);
        return;
    L6:
        if (Intrinsics.areEqual(r2, SettingsProviderHelper.CALL_FOR_ME_VOICE_MALE) == false) goto L10;
        playAssetSound();
        return;
    }

    private final boolean isPlaying() {
        MediaPlayer r2 = this.mediaPlayer;
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isPlaying() == true) goto L7;
        return false;
    L7:
        return true;
    }

    private final void setGroup(Integer[] r8, int r9, final Function1<? super Integer, Unit> r10) {
        ArrayList r0 = new ArrayList(r8.length);
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.add((IntelligentSoundCardItem) findViewById(r8[r3].intValue()));
        r3 = r3 + 1;
        goto L3
    L5:
        final ArrayList r2 = r0;
        Iterator r11 = r2.iterator();
        final int r4 = 0;
    L7:
        if (r11.hasNext() == false) goto L19;
        Object r5 = r11.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        IntelligentSoundCardItem r7 = (IntelligentSoundCardItem) r5;
        r7.setTitleText(getTitleText(r4));
        r7.setSubtitleText(getSubTitleText(r4));
        if (r4 != r9) goto L14;
        boolean r12 = true;
    L15:
        r7.setItemChecked(r12);
        r7.getContentContainer().setTag(Integer.valueOf(r4));
        if (r7 == null) goto L18;
        r7.setOnContentClickListener(new CallForMeVoiceActivity$$ExternalSyntheticLambda0(r2, r10, r4));
    L18:
        r4 = r6;
        goto L7
    L14:
        r12 = false;
        goto L15
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onCreate")
    public static void com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onCreate(CallForMeVoiceActivity r2, Bundle r3) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallForMeVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        PrivacyUtils.INSTANCE.applicationInit();
        r2.com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onCreate$___twin___(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CallForMeVoiceActivity r1) {
        com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onResume")
    public static void com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onResume(CallForMeVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallForMeVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onPause")
    public static void com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onPause(CallForMeVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallForMeVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("onStop")
    public static void com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_onStop(CallForMeVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallForMeVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_CallForMeVoiceActivity__onStop$___twin___();
    }

    @TargetClass(scope = Scope.ALL, value = "com.obric.privacyhook.LifeHookActivity")
    @Insert("finish")
    public static void com_obric_Intelligentcall_activity_CallForMeVoiceActivity_com_obric_privacyhook_PrivacyHook_finish(CallForMeVoiceActivity r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.obric.privacyhook.LifeHookActivity");
        CallForMeVoiceActivity r0 = r2;
        if (r0.isPrivacyOk() == true) goto L6;
        r0.superFinish();
        return;
    L6:
        r2.com_obric_Intelligentcall_activity_CallForMeVoiceActivity__finish$___twin___();
    }
}
