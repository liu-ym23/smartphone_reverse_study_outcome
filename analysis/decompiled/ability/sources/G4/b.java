package G4;

import C7.r;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.policy.sdk.PolicySdk;
import java.io.File;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f665a;
    public final /* synthetic */ VoiceWakeSettingActivity b;

    public /* synthetic */ b(VoiceWakeSettingActivity voiceWakeSettingActivity, int i) {
        this.f665a = i;
        this.b = voiceWakeSettingActivity;
    }

    @Override // S7.a
    public final Object invoke() {
        File[] fileArrListFiles;
        int i = this.f665a;
        int i6 = 1;
        VoiceWakeSettingActivity voiceWakeSettingActivity = this.b;
        r rVar = r.f317a;
        switch (i) {
            case 0:
                int i10 = VoiceWakeSettingActivity.f3343j;
                File filesDir = voiceWakeSettingActivity.getFilesDir();
                if (filesDir != null && (fileArrListFiles = filesDir.listFiles(new E4.c(0))) != null && fileArrListFiles.length != 0) {
                    voiceWakeSettingActivity.v(true);
                    Vibrator vibrator = (Vibrator) voiceWakeSettingActivity.getSystemService(Vibrator.class);
                    if (vibrator != null) {
                        vibrator.vibrate(VibrationEffect.createOneShot(40L, -1));
                    }
                    Settings.Global.putInt(voiceWakeSettingActivity.getContentResolver(), "voice_wakeup_enabled", 1);
                    com.stepos.statsrpk.d.J("on");
                    Log.i("VoiceWakeSettingActivity", "wakeup enabled");
                    com.stepos.ability.voicewakeup.service.l lVar = com.stepos.ability.voicewakeup.service.l.f3333a;
                    com.stepos.ability.voicewakeup.service.l.t();
                    break;
                } else {
                    Log.i("VoiceWakeSettingActivity", "enable blocked: no user model, route to word selection");
                    voiceWakeSettingActivity.w(true);
                    break;
                }
            case 1:
                int i11 = VoiceWakeSettingActivity.f3343j;
                voiceWakeSettingActivity.w(false);
                break;
            case 2:
                int i12 = VoiceWakeSettingActivity.f3343j;
                voiceWakeSettingActivity.r();
                voiceWakeSettingActivity.s();
                break;
            case 3:
                int i13 = VoiceWakeSettingActivity.f3343j;
                Log.i("VoiceWakeSettingActivity", "permission dialog denied userId=".concat(H3.b.g));
                com.stepos.ability.voicewakeup.a.b(voiceWakeSettingActivity, H3.b.g, false);
                break;
            default:
                int i14 = VoiceWakeSettingActivity.f3343j;
                PolicySdk.getOnlinePolicyMethod(this.b, "zh_CN", "vrs", "声纹信息授权", Boolean.TRUE, new a(i6));
                break;
        }
        return rVar;
    }
}
