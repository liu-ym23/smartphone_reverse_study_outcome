package G4;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import com.stepos.ability.voicewakeup.training.TrainingActivity;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f669a;
    public final /* synthetic */ FragmentActivity b;

    public /* synthetic */ f(FragmentActivity fragmentActivity, int i) {
        this.f669a = i;
        this.b = fragmentActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i6 = this.f669a;
        FragmentActivity fragmentActivity = this.b;
        switch (i6) {
            case 0:
                int i10 = VoiceWakeSettingActivity.f3343j;
                com.stepos.ability.voicewakeup.service.l lVar = com.stepos.ability.voicewakeup.service.l.f3333a;
                com.stepos.ability.voicewakeup.service.l.o(!com.stepos.ability.voicewakeup.service.l.i(), new D6.i(new b((VoiceWakeSettingActivity) fragmentActivity, 2), 19));
                com.stepos.statsrpk.d.G("amoo_settings_clear_voice", "amoo_settings", kotlin.collections.a.R(new Pair("page_name", "amoo_settings"), new Pair(GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "confirm")));
                dialogInterface.dismiss();
                break;
            default:
                int i11 = TrainingActivity.f3357M;
                dialogInterface.dismiss();
                ((TrainingActivity) fragmentActivity).finish();
                break;
        }
    }
}
