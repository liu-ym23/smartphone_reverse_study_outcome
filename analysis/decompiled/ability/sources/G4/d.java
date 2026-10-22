package G4;

import A6.n;
import android.provider.Settings;
import android.util.Log;
import android.view.result.ActivityResult;
import android.view.result.ActivityResultCallback;
import android.widget.Toast;
import com.stepos.ability.R;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.widget.list.StepOSListItem;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements ActivityResultCallback, F6.f, F6.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f667a;
    public final /* synthetic */ VoiceWakeSettingActivity b;

    public /* synthetic */ d(VoiceWakeSettingActivity voiceWakeSettingActivity, int i) {
        this.f667a = i;
        this.b = voiceWakeSettingActivity;
    }

    @Override // F6.g
    public void a(StepOSListItem stepOSListItem, boolean z10) {
        int i = VoiceWakeSettingActivity.f3343j;
        VoiceWakeSettingActivity voiceWakeSettingActivity = this.b;
        if (voiceWakeSettingActivity.c) {
            return;
        }
        voiceWakeSettingActivity.v(Settings.Global.getInt(voiceWakeSettingActivity.getContentResolver(), "voice_wakeup_enabled", 0) == 1);
        voiceWakeSettingActivity.q(z10);
    }

    @Override // F6.f
    public void b(StepOSListItem stepOSListItem) {
        int i = this.f667a;
        VoiceWakeSettingActivity voiceWakeSettingActivity = this.b;
        switch (i) {
            case 1:
                int i6 = VoiceWakeSettingActivity.f3343j;
                A6.g gVar = voiceWakeSettingActivity.g;
                if (gVar == null || !gVar.isShowing()) {
                    Q.a aVarR = z2.l.r(voiceWakeSettingActivity, false);
                    n nVar = (n) aVarR.b;
                    nVar.b = nVar.f153a.getText(R.string.voice_wake_clear_title);
                    nVar.d = nVar.f153a.getText(R.string.voice_wake_clear_message);
                    c cVar = new c(1);
                    nVar.h = nVar.f153a.getText(R.string.voice_wake_clear_cancel);
                    nVar.i = cVar;
                    f fVar = new f(voiceWakeSettingActivity, 0);
                    nVar.f = nVar.f153a.getText(R.string.voice_wake_clear_confirm);
                    nVar.g = fVar;
                    nVar.k = -1;
                    nVar.l = 2;
                    A6.g gVarC = aVarR.c();
                    voiceWakeSettingActivity.g = gVarC;
                    gVarC.show();
                    break;
                }
                break;
            case 2:
                int i10 = VoiceWakeSettingActivity.f3343j;
                voiceWakeSettingActivity.q(!stepOSListItem.getSwitchChecked());
                break;
            default:
                int i11 = VoiceWakeSettingActivity.f3343j;
                Log.i("VoiceWakeSettingActivity", "itemRerecord click");
                voiceWakeSettingActivity.u(new b(voiceWakeSettingActivity, 1));
                break;
        }
    }

    @Override // android.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        ActivityResult result = (ActivityResult) obj;
        int i = VoiceWakeSettingActivity.f3343j;
        kotlin.jvm.internal.k.f(result, "result");
        if (result.getResultCode() == 1) {
            VoiceWakeSettingActivity voiceWakeSettingActivity = this.b;
            if (voiceWakeSettingActivity.isFinishing() || voiceWakeSettingActivity.isDestroyed()) {
                return;
            }
            Toast.makeText(voiceWakeSettingActivity, R.string.voice_wake_record_blocked_in_call, 0).show();
        }
    }
}
