package G4;

import android.content.DialogInterface;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity;
import com.stepos.ability.voicewakeup.training.TrainingActivity;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f666a;

    public /* synthetic */ c(int i) {
        this.f666a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f666a) {
            case 0:
                int i6 = VoiceWakeSettingActivity.f3343j;
                break;
            case 1:
                int i10 = VoiceWakeSettingActivity.f3343j;
                dialogInterface.dismiss();
                break;
            case 2:
                int i11 = WakeupWordSelectionActivity.f;
                dialogInterface.dismiss();
                break;
            default:
                int i12 = TrainingActivity.f3357M;
                dialogInterface.dismiss();
                break;
        }
    }
}
