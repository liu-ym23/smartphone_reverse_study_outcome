package H4;

import android.util.Log;
import android.view.OnBackPressedCallback;
import com.stepos.ability.voicewakeup.training.TrainingActivity;

/* loaded from: classes3.dex */
public final /* synthetic */ class j implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f742a;
    public final /* synthetic */ TrainingActivity b;

    public /* synthetic */ j(TrainingActivity trainingActivity, int i) {
        this.f742a = i;
        this.b = trainingActivity;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f742a;
        C7.r rVar = C7.r.f317a;
        TrainingActivity trainingActivity = this.b;
        switch (i) {
            case 0:
                OnBackPressedCallback addCallback = (OnBackPressedCallback) obj;
                int i6 = TrainingActivity.f3357M;
                kotlin.jvm.internal.k.f(addCallback, "$this$addCallback");
                Log.d("TrainingActivity", "system back, isFinished=" + trainingActivity.f3374z);
                if (trainingActivity.x()) {
                    com.stepos.statsrpk.d.n("voice_record_page", "back");
                }
                trainingActivity.y();
                break;
            default:
                int i10 = TrainingActivity.f3357M;
                trainingActivity.runOnUiThread(new D6.b(trainingActivity, 4));
                break;
        }
        return rVar;
    }
}
