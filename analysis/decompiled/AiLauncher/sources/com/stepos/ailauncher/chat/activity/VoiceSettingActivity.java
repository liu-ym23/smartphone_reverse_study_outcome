package com.stepos.ailauncher.chat.activity;

import Ua.C1060i;
import android.content.Intent;
import android.os.Bundle;
import android.view.C1398p;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import com.stepos.ailauncher.chat.manager.ChatConfigManager;
import com.stepos.ailauncher.chat.widget.FigmaSlider;
import com.stepos.ailauncher.chat.widget.FigmaSwitch;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import z5.ActivityC6361a;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/activity/VoiceSettingActivity;", "Lz5/a;", "<init>", "()V", "LY8/t;", "C", "I", "H", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onResume", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "Lcom/stepos/ailauncher/chat/widget/FigmaSwitch;", "swNavigation", "Lcom/stepos/ailauncher/chat/widget/FigmaSwitch;", "swHeadset", "Landroid/widget/TextView;", "tvVoiceWakeupSummary", "Landroid/widget/TextView;", "tvSoundSummary", "Lcom/stepos/ailauncher/chat/widget/FigmaSlider;", "sbVolume", "Lcom/stepos/ailauncher/chat/widget/FigmaSlider;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VoiceSettingActivity extends ActivityC6361a {
    private FigmaSlider sbVolume;
    private FigmaSwitch swHeadset;
    private FigmaSwitch swNavigation;
    private TextView tvSoundSummary;
    private TextView tvVoiceWakeupSummary;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.activity.VoiceSettingActivity$onCreate$2", f = "VoiceSettingActivity.kt", l = {51}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.activity.VoiceSettingActivity$onCreate$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        int label;

        public AnonymousClass2(InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                ChatConfigManager chatConfigManagerA = ChatConfigManager.INSTANCE.a();
                this.label = 1;
                if (chatConfigManagerA.g(this) == objG) {
                    return objG;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return Y8.t.f7040a;
        }
    }

    public static final void B(VoiceSettingActivity voiceSettingActivity, View view) {
        voiceSettingActivity.startActivity(new Intent(voiceSettingActivity, (Class<?>) SoundSettingActivity.class));
    }

    private final void C() {
        View viewFindViewById = findViewById(R$id.itemVoiceWakeup);
        int i10 = R$id.tvSettingTitle;
        ((TextView) viewFindViewById.findViewById(i10)).setText(R$string.voice_setting_voice_wakeup);
        int i11 = R$id.tvSettingSummary;
        View viewFindViewById2 = viewFindViewById.findViewById(i11);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.tvVoiceWakeupSummary = (TextView) viewFindViewById2;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.p2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSettingActivity.D(this.f24865a, view);
            }
        });
        View viewFindViewById3 = findViewById(R$id.itemNavigationKey);
        ((TextView) viewFindViewById3.findViewById(i10)).setText(R$string.voice_setting_navigation_key);
        ((TextView) viewFindViewById3.findViewById(i11)).setText(R$string.voice_setting_navigation_key_desc);
        int i12 = R$id.swSetting;
        View viewFindViewById4 = viewFindViewById3.findViewById(i12);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        FigmaSwitch figmaSwitch = (FigmaSwitch) viewFindViewById4;
        this.swNavigation = figmaSwitch;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swNavigation");
            figmaSwitch = null;
        }
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        figmaSwitch.setChecked(u02.r());
        viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSettingActivity.E(this.f24869a, view);
            }
        });
        View viewFindViewById5 = findViewById(R$id.itemHeadsetKey);
        ((TextView) viewFindViewById5.findViewById(i10)).setText(R$string.voice_setting_headset_key);
        ((TextView) viewFindViewById5.findViewById(i11)).setText(R$string.voice_setting_headset_key_desc);
        View viewFindViewById6 = viewFindViewById5.findViewById(i12);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        FigmaSwitch figmaSwitch3 = (FigmaSwitch) viewFindViewById6;
        this.swHeadset = figmaSwitch3;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swHeadset");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(u02.q());
        viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSettingActivity.F(this.f24872a, view);
            }
        });
    }

    public static final void D(VoiceSettingActivity voiceSettingActivity, View view) {
        voiceSettingActivity.startActivity(new Intent("com.stepos.ability.action.VOICE_WAKEUP_SETTING").setPackage("com.stepos.ability"));
    }

    public static final void E(VoiceSettingActivity voiceSettingActivity, View view) {
        FigmaSwitch figmaSwitch = voiceSettingActivity.swNavigation;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swNavigation");
            figmaSwitch = null;
        }
        boolean z10 = !figmaSwitch.getIsChecked();
        FigmaSwitch figmaSwitch3 = voiceSettingActivity.swNavigation;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swNavigation");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(z10);
        com.stepos.ailauncher.chat.manager.U0.INSTANCE.B(z10);
    }

    public static final void F(VoiceSettingActivity voiceSettingActivity, View view) {
        FigmaSwitch figmaSwitch = voiceSettingActivity.swHeadset;
        FigmaSwitch figmaSwitch2 = null;
        if (figmaSwitch == null) {
            kotlin.jvm.internal.p.A("swHeadset");
            figmaSwitch = null;
        }
        boolean z10 = !figmaSwitch.getIsChecked();
        FigmaSwitch figmaSwitch3 = voiceSettingActivity.swHeadset;
        if (figmaSwitch3 == null) {
            kotlin.jvm.internal.p.A("swHeadset");
        } else {
            figmaSwitch2 = figmaSwitch3;
        }
        figmaSwitch2.setChecked(z10);
        com.stepos.ailauncher.chat.manager.U0.INSTANCE.A(z10);
    }

    public static final void G(VoiceSettingActivity voiceSettingActivity, View view) {
        voiceSettingActivity.finish();
    }

    private final void H() {
        String strK = com.stepos.ailauncher.chat.manager.U0.INSTANCE.k();
        TextView textView = this.tvSoundSummary;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvSoundSummary");
            textView = null;
        }
        if (La.H.x0(strK)) {
            strK = getString(R$string.voice_setting_sound_default_persona);
        }
        textView.setText(strK);
    }

    private final void I() {
        boolean zS = com.stepos.ailauncher.chat.manager.U0.INSTANCE.s();
        TextView textView = this.tvVoiceWakeupSummary;
        if (textView == null) {
            kotlin.jvm.internal.p.A("tvVoiceWakeupSummary");
            textView = null;
        }
        textView.setText(zS ? R$string.voice_setting_state_on : R$string.voice_setting_state_off);
    }

    public static final void z(View view) {
    }

    public final void A() {
        View viewFindViewById = findViewById(R$id.itemSound);
        int i10 = R$id.tvSettingTitle;
        ((TextView) viewFindViewById.findViewById(i10)).setText(R$string.voice_setting_sound);
        View viewFindViewById2 = viewFindViewById.findViewById(R$id.tvSettingSummary);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.tvSoundSummary = (TextView) viewFindViewById2;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.o2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSettingActivity.B(this.f24861a, view);
            }
        });
        View viewFindViewById3 = findViewById(R$id.itemVolume);
        ((TextView) viewFindViewById3.findViewById(i10)).setText(R$string.voice_setting_volume);
        View viewFindViewById4 = viewFindViewById3.findViewById(R$id.sbVolume);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        FigmaSlider figmaSlider = (FigmaSlider) viewFindViewById4;
        this.sbVolume = figmaSlider;
        com.stepos.ailauncher.chat.manager.U0 u02 = com.stepos.ailauncher.chat.manager.U0.INSTANCE;
        if (figmaSlider == null) {
            kotlin.jvm.internal.p.A("sbVolume");
            figmaSlider = null;
        }
        u02.e(this, figmaSlider);
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.activity_voice_setting);
        Toolbar toolbar = (Toolbar) findViewById(R$id.toolbar);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.s(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.n2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSettingActivity.G(this.f24857a, view);
            }
        });
        C();
        A();
        y();
        C1060i.d(C1398p.a(this), null, null, new AnonymousClass2(null), 3, null);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        I();
        H();
    }

    public final void y() {
        View viewFindViewById = findViewById(R$id.itemCallAssistant);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingTitle)).setText(R$string.voice_setting_call_assistant);
        ((TextView) viewFindViewById.findViewById(R$id.tvSettingSummary)).setVisibility(8);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.activity.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VoiceSettingActivity.z(view);
            }
        });
    }
}
