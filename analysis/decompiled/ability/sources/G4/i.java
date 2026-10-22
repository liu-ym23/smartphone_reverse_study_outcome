package G4;

import C7.r;
import android.util.Log;
import com.stepos.ability.voicewakeup.setting.VoiceWakeSettingActivity;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* loaded from: classes3.dex */
public final class i implements p9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f672a;
    public final /* synthetic */ Object b;

    public /* synthetic */ i(Object obj, int i) {
        this.f672a = i;
        this.b = obj;
    }

    @Override // p9.d
    public final Object emit(Object obj, H7.c cVar) {
        int i = this.f672a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                VoiceWakeSettingActivity voiceWakeSettingActivity = (VoiceWakeSettingActivity) obj2;
                Log.i("VoiceWakeSettingActivity", "observeGranted collected granted=" + zBooleanValue);
                if (!zBooleanValue) {
                    int i6 = VoiceWakeSettingActivity.f3343j;
                    voiceWakeSettingActivity.r();
                    voiceWakeSettingActivity.s();
                }
                return r.f317a;
            default:
                ((Ref$ObjectRef) obj2).f4920a = obj;
                throw new AbortFlowException(this);
        }
    }
}
