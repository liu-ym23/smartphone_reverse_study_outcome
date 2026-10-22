package com.stepos.ability.voicewakeup.setting;

import A6.b;
import A6.g;
import A6.i;
import C7.r;
import D7.N;
import E4.c;
import G4.a;
import G4.d;
import G4.e;
import G4.h;
import G4.j;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LifecycleOwnerKt;
import android.view.View;
import android.view.ViewGroup;
import android.view.result.ActivityResultLauncher;
import android.view.result.contract.ActivityResultContracts;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.service.EngineStateListener;
import com.stepos.ability.voicewakeup.service.l;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.motionkit.fx.material.GlassEffect;
import com.stepos.policy.sdk.PolicySdk;
import com.stepos.widget.glass.StepOSGlassImageButton;
import com.stepos.widget.list.StepOSListGroup;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.toolbar.StepOSTitleBar;
import i9.C1570e;
import j9.m;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import stepos.support.v7.app.AbstractActivityC1962k;
import stepos.support.v7.app.DialogInterfaceC1961j;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/stepos/ability/voicewakeup/setting/VoiceWakeSettingActivity;", "Lstepos/support/v7/app/k;", AppAgent.CONSTRUCT, "()V", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceWakeSettingActivity extends AbstractActivityC1962k {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f3343j = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f3344a;
    public StepOSListItem b;
    public boolean c;
    public StepOSListItem d;
    public View e;
    public StepOSListGroup f;
    public g g;
    public final ActivityResultLauncher h = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this, 0));
    public final e i = new EngineStateListener() { // from class: G4.e
        @Override // com.stepos.ability.voicewakeup.service.EngineStateListener
        public final void onEngineError() {
            int i = VoiceWakeSettingActivity.f3343j;
            VoiceWakeSettingActivity voiceWakeSettingActivity = this.f668a;
            voiceWakeSettingActivity.runOnUiThread(new D6.b(voiceWakeSettingActivity, 3));
        }
    };

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        LinearLayout.LayoutParams layoutParams;
        super.onCreate(bundle);
        setContentView(R.layout.activity_voice_wake);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().setBackgroundDrawableResource(R.color.voice_wake_settings_background);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
        getWindow().setStatusBarContrastEnforced(false);
        getWindow().setNavigationBarContrastEnforced(false);
        boolean z10 = (getResources().getConfiguration().uiMode & 48) == 32;
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        boolean z11 = !z10;
        insetsController.setAppearanceLightStatusBars(z11);
        insetsController.setAppearanceLightNavigationBars(z11);
        View viewT = t(R.id.voiceWakeSettingsRoot);
        ViewCompat.setOnApplyWindowInsetsListener(viewT, new a(0));
        ViewCompat.requestApplyInsets(viewT);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_titlebar_action_size);
        int dimensionPixelSize2 = (dimensionPixelSize - getResources().getDimensionPixelSize(R.dimen.stepos_titlebar_action_icon_size)) / 2;
        StepOSGlassImageButton stepOSGlassImageButton = new StepOSGlassImageButton(this, null, 14);
        stepOSGlassImageButton.setLayoutParams(new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize));
        stepOSGlassImageButton.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        stepOSGlassImageButton.setGlassEffect(GlassEffect.INSTANCE.getCLEAR());
        stepOSGlassImageButton.setImageResource(R.drawable.ic_voicewakeup_back);
        stepOSGlassImageButton.setSurfaceDrawable(ContextCompat.getDrawable(stepOSGlassImageButton.getContext(), R.drawable.bg_voice_wake_settings_back));
        stepOSGlassImageButton.setContentDescription(getString(R.string.voice_wake_train_cancel_back));
        stepOSGlassImageButton.setOnClickListener(new b(this, 2));
        StepOSTitleBar stepOSTitleBar = (StepOSTitleBar) t(R.id.toolbar);
        LinearLayout linearLayout = stepOSTitleBar.f4175a;
        if (stepOSGlassImageButton.getParent() != null) {
            throw new IllegalStateException("The action view already has a parent");
        }
        if (stepOSGlassImageButton.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams2 = stepOSGlassImageButton.getLayoutParams();
            k.d(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            layoutParams = (LinearLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.setMarginStart(linearLayout.getChildCount() == 0 ? 0 : stepOSTitleBar.f4181q);
        linearLayout.addView(stepOSGlassImageButton, layoutParams);
        stepOSTitleBar.m(linearLayout);
        if (!stepOSTitleBar.f4180j) {
            stepOSTitleBar.b(stepOSGlassImageButton);
        }
        stepOSTitleBar.requestLayout();
        StepOSListItem stepOSListItem = (StepOSListItem) t(R.id.itemWakeEnable);
        this.b = stepOSListItem;
        stepOSListItem.setSwitchHapticFeedbackEnabled(false);
        StepOSListItem stepOSListItem2 = this.b;
        if (stepOSListItem2 == null) {
            k.n("itemWakeEnable");
            throw null;
        }
        C1570e c1570e = new C1570e(kotlin.sequences.a.f0(ViewGroupKt.getDescendants(stepOSListItem2), G4.g.f670a));
        while (c1570e.hasNext()) {
            ((L6.a) c1570e.next()).setContentDescription(getString(R.string.voice_wake_item_enable));
        }
        v(Settings.Global.getInt(getContentResolver(), "voice_wakeup_enabled", 0) == 1);
        StepOSListItem stepOSListItem3 = this.b;
        if (stepOSListItem3 == null) {
            k.n("itemWakeEnable");
            throw null;
        }
        stepOSListItem3.setOnItemClickListener(new d(this, 2));
        StepOSListItem stepOSListItem4 = this.b;
        if (stepOSListItem4 == null) {
            k.n("itemWakeEnable");
            throw null;
        }
        stepOSListItem4.setOnSwitchCheckedChangeListener(new d(this, 3));
        ((StepOSListItem) t(R.id.itemRerecord)).setOnItemClickListener(new d(this, 4));
        StepOSListItem stepOSListItem5 = (StepOSListItem) t(R.id.itemClearVoiceprint);
        this.d = stepOSListItem5;
        stepOSListItem5.getTitleView().setTextColor(getColor(R.color.stepos_system_red));
        stepOSListItem5.setOnItemClickListener(new d(this, 1));
        this.e = t(R.id.llCurrentWord);
        this.f = (StepOSListGroup) t(R.id.llCurrentWordList);
        AbstractC1683A.n(LifecycleOwnerKt.getLifecycleScope(this), null, new VoiceWakeSettingActivity$observePermissionChanges$1(this, null), 3);
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        g gVar = this.g;
        if (gVar != null) {
            gVar.dismiss();
        }
        this.g = null;
        super.onDestroy();
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        r();
        s();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        l lVar = l.f3333a;
        e listener = this.i;
        k.f(listener, "listener");
        l.l.addIfAbsent(listener);
    }

    @Override // stepos.support.v7.app.AbstractActivityC1962k, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        l lVar = l.f3333a;
        e listener = this.i;
        k.f(listener, "listener");
        l.l.remove(listener);
        super.onStop();
    }

    public final void q(boolean z10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.f3344a < 500) {
            Log.i("VoiceWakeSettingActivity", "itemEnable click ignored: debounce");
            return;
        }
        this.f3344a = jElapsedRealtime;
        Log.i("VoiceWakeSettingActivity", "itemEnable click target=" + z10);
        if (z10) {
            u(new G4.b(this, 0));
            return;
        }
        v(false);
        Vibrator vibrator = (Vibrator) getSystemService(Vibrator.class);
        if (vibrator != null) {
            vibrator.vibrate(VibrationEffect.createOneShot(40L, -1));
        }
        Settings.Global.putInt(getContentResolver(), "voice_wakeup_enabled", 0);
        l lVar = l.f3333a;
        l.u();
        com.stepos.statsrpk.d.J("off");
    }

    public final void r() {
        v(Settings.Global.getInt(getContentResolver(), "voice_wakeup_enabled", 0) == 1);
    }

    public final void s() {
        File[] fileArrListFiles;
        File filesDir = getFilesDir();
        boolean z10 = (filesDir == null || (fileArrListFiles = filesDir.listFiles(new c(0))) == null || fileArrListFiles.length == 0) ? false : true;
        List<C4.g> listE = N.E(this);
        StepOSListItem stepOSListItem = this.d;
        if (stepOSListItem != null) {
            stepOSListItem.setVisibility(z10 ? 0 : 8);
        }
        ((StepOSListGroup) t(R.id.settingsGroup)).setBackgroundMode(0);
        StepOSListGroup stepOSListGroup = this.f;
        if (!z10 || listE.isEmpty() || stepOSListGroup == null) {
            View view = this.e;
            if (view != null) {
                view.setVisibility(8);
                return;
            }
            return;
        }
        stepOSListGroup.removeAllViews();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this);
        for (C4.g gVar : listE) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.item_current_trained_word, (ViewGroup) stepOSListGroup, false);
            k.d(viewInflate, "null cannot be cast to non-null type com.stepos.widget.list.StepOSListItem");
            StepOSListItem stepOSListItem2 = (StepOSListItem) viewInflate;
            stepOSListItem2.setTitle(gVar.b);
            stepOSListGroup.addView(stepOSListItem2, new LinearLayout.LayoutParams(-1, -2));
        }
        View view2 = this.e;
        if (view2 != null) {
            view2.setVisibility(0);
        }
    }

    public final View t(int i) {
        View viewFindViewById = findViewById(i);
        k.c(viewFindViewById);
        return viewFindViewById;
    }

    public final void u(S7.a aVar) {
        String str = H3.b.g;
        boolean z10 = getApplicationContext().getSharedPreferences("voice_wakeup_permission", 0).getBoolean("consent_".concat(str), false);
        Log.i("VoicePermissionStorage", "isGranted userId=" + str + " granted=" + z10);
        if (z10) {
            Log.i("VoiceWakeSettingActivity", "requireVoicePermission already granted userId=".concat(str));
            aVar.invoke();
            return;
        }
        Log.i("VoiceWakeSettingActivity", "requireVoicePermission show dialog userId=".concat(str));
        i iVar = new i(6, this, aVar);
        G4.b bVar = new G4.b(this, 3);
        SpannableString spannableString = new SpannableString("开启后,可通过语音唤醒Amoo助手。为确认是本人唤醒,我们会收集你的声纹信息,仅用于身份确认。点击「同意」,即表示您已阅读并同意《声纹信息授权》");
        int iQ0 = m.q0("开启后,可通过语音唤醒Amoo助手。为确认是本人唤醒,我们会收集你的声纹信息,仅用于身份确认。点击「同意」,即表示您已阅读并同意《声纹信息授权》", "《声纹信息授权》", 0, false, 6);
        if (iQ0 >= 0) {
            spannableString.setSpan(new h(new G4.b(this, 4)), iQ0, iQ0 + 8, 33);
        }
        DialogInterfaceC1961j dialogInterfaceC1961jShowCustomPolicyDialogRecord = PolicySdk.showCustomPolicyDialogRecord(this, Boolean.FALSE, new String[0], new String[0], "开启语音唤醒", "", new SpannableStringBuilder(spannableString), new String[]{"pp", "up"}, H3.b.g, new j(iVar, bVar));
        if (dialogInterfaceC1961jShowCustomPolicyDialogRecord != null) {
            dialogInterfaceC1961jShowCustomPolicyDialogRecord.setButton(-2, "取消", new G4.c(0));
        }
        if (dialogInterfaceC1961jShowCustomPolicyDialogRecord != null) {
            dialogInterfaceC1961jShowCustomPolicyDialogRecord.show();
        }
    }

    public final void v(boolean z10) {
        StepOSListItem stepOSListItem = this.b;
        if (stepOSListItem != null) {
            if (stepOSListItem == null) {
                k.n("itemWakeEnable");
                throw null;
            }
            if (stepOSListItem.getSwitchChecked() == z10) {
                return;
            }
            this.c = true;
            try {
                StepOSListItem stepOSListItem2 = this.b;
                if (stepOSListItem2 != null) {
                    stepOSListItem2.setSwitchChecked(z10);
                } else {
                    k.n("itemWakeEnable");
                    throw null;
                }
            } finally {
                this.c = false;
            }
        }
    }

    public final void w(boolean z10) {
        Object objA;
        AudioManager audioManager = (AudioManager) getSystemService(AudioManager.class);
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getMode()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 2) || ((numValueOf != null && numValueOf.intValue() == 3) || ((numValueOf != null && numValueOf.intValue() == 4) || ((numValueOf != null && numValueOf.intValue() == 5) || (numValueOf != null && numValueOf.intValue() == 6))))) {
            Log.i("VoiceWakeSettingActivity", "word selection blocked: call in progress");
            Toast.makeText(this, R.string.voice_wake_record_blocked_in_call, 0).show();
            return;
        }
        if (z10) {
            Toast.makeText(this, R.string.voice_wake_need_record_first, 0).show();
        }
        Intent intent = new Intent(this, (Class<?>) WakeupWordSelectionActivity.class);
        intent.putExtra("extra_entry_source", "settings");
        try {
            this.h.launch(intent);
            objA = r.f317a;
        } catch (Throwable th) {
            objA = kotlin.b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Log.e("VoiceWakeSettingActivity", "start WakeupWordSelectionActivity failed", thA);
            Toast.makeText(this, R.string.voice_wake_train_unsupported, 0).show();
        }
    }
}
