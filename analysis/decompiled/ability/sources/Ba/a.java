package Ba;

import C7.r;
import C9.C;
import C9.s;
import C9.v;
import C9.z;
import H4.o;
import N9.j;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.gson.GsonBuilder;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.VoicePermissionProvider;
import com.stepos.ability.voicewakeup.service.l;
import com.stepos.ability.voicewakeup.training.TrainingActivity;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.core.base.parse.KViewNode;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f265a;

    public /* synthetic */ a(int i) {
        this.f265a = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // S7.a
    public final Object invoke() {
        final boolean z10 = false;
        Object[] objArr = 0;
        final boolean z11 = true;
        switch (this.f265a) {
            case 0:
                d dVar = d.f268a;
                e eVar = d.b;
                if (eVar == null) {
                    synchronized (dVar) {
                        eVar = d.b;
                        if (eVar == null) {
                            eVar = new e();
                            d.b = eVar;
                            j.F("Default coordinate transformer created", "CoordinateTransformerFactory");
                        }
                    }
                }
                return eVar;
            case 1:
                Uri uri = VoicePermissionProvider.c;
                return new Handler(Looper.getMainLooper());
            case 2:
                return new C4.g("amoo_amoo", R.string.voice_wake_word_amoo_amoo, "amoo amoo", "sm8_amam.uim", 34, 37, "/ˈeɪmoʊ/", Integer.valueOf(R.raw.voice_wake_phonetic_amoo));
            case 3:
                return new C4.g("azai_azai", R.string.voice_wake_word_azai_azai, "a仔 a仔", "sm8_AZAZ.uim", 38, 45, null, null);
            case 4:
                return new C4.g("azai_chulai", R.string.voice_wake_word_azai_chulai, "a仔出来", "sm8_AZCL.uim", 35, 35, null, null);
            case 5:
                return new C4.g("amoo_chulai", R.string.voice_wake_word_amoo_chulai, "amoo出来", "sm8_AMCL.uim", 34, 40, "/ˈeɪmoʊ/", Integer.valueOf(R.raw.voice_wake_phonetic_amoo_chulai));
            case 6:
                return o.N((C4.g) C4.h.f297a.getF4884a(), (C4.g) C4.h.b.getF4884a(), (C4.g) C4.h.c.getF4884a(), (C4.g) C4.h.d.getF4884a());
            case 7:
                return C.b;
            case 8:
                return v.b;
            case 9:
                return s.b;
            case 10:
                return z.b;
            case 11:
                return C9.f.b;
            case 12:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger");
            case 13:
                return Class.forName("android.hardware.soundtrigger.SoundTriggerModule");
            case 14:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$SoundModel");
            case 15:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$Keyphrase");
            case 16:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$KeyphraseSoundModel");
            case 17:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$ConfidenceLevel");
            case 18:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$KeyphraseRecognitionExtra");
            case 19:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$RecognitionConfig");
            case 20:
                return Class.forName("android.hardware.soundtrigger.SoundTrigger$StatusListener");
            case 21:
                return Class.forName("android.media.permission.Identity");
            case 22:
                l lVar = l.f3333a;
                l.o(true, new com.stepos.ability.voicewakeup.service.f(objArr == true ? 1 : 0));
                return r.f317a;
            case 23:
                l lVar2 = l.f3333a;
                l.o(!l.i(), new S7.a() { // from class: com.stepos.ability.voicewakeup.service.g
                    @Override // S7.a
                    public final Object invoke() {
                        int i = l.f3335q;
                        if (i > 0) {
                            l.f3335q = i - 1;
                        }
                        if (z11) {
                            l lVar3 = l.f3333a;
                            l.v(true);
                            lVar3.l();
                        }
                        return r.f317a;
                    }
                });
                return r.f317a;
            case 24:
                l lVar3 = l.f3333a;
                l.o(!l.i(), new S7.a() { // from class: com.stepos.ability.voicewakeup.service.g
                    @Override // S7.a
                    public final Object invoke() {
                        int i = l.f3335q;
                        if (i > 0) {
                            l.f3335q = i - 1;
                        }
                        if (z10) {
                            l lVar32 = l.f3333a;
                            l.v(true);
                            lVar32.l();
                        }
                        return r.f317a;
                    }
                });
                return r.f317a;
            case 25:
                int i = TrainingActivity.f3357M;
                return new com.stepos.ability.voicewakeup.training.a();
            case 26:
                return AgentCacheSdk.init$lambda$0();
            case 27:
                return ParseRule._childSerializers$_anonymous_();
            case 28:
                return KViewNode._childSerializers$_anonymous_();
            default:
                return new GsonBuilder().serializeNulls().disableHtmlEscaping().create();
        }
    }
}
