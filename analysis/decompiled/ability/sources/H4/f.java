package H4;

import android.content.Intent;
import com.stepos.ability.voicewakeup.training.TrainingActivity;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f738a;
    public final /* synthetic */ TrainingActivity b;

    public /* synthetic */ f(TrainingActivity trainingActivity, int i) {
        this.f738a = i;
        this.b = trainingActivity;
    }

    @Override // S7.a
    public final Object invoke() {
        String stringExtra;
        int i = this.f738a;
        TrainingActivity trainingActivity = this.b;
        switch (i) {
            case 0:
                int i6 = TrainingActivity.f3357M;
                com.stepos.ability.voicewakeup.service.l lVar = com.stepos.ability.voicewakeup.service.l.f3333a;
                com.stepos.ability.voicewakeup.service.l.q(trainingActivity, new Intent("com.stepos.ability.voicewakeup.ACTION_TRAINING_COMPLETE"));
                return C7.r.f317a;
            case 1:
                int i10 = TrainingActivity.f3357M;
                return new E4.e(trainingActivity);
            case 2:
                int i11 = TrainingActivity.f3357M;
                E4.b bVar = new E4.b();
                E4.a.f472a.a(trainingActivity);
                return bVar;
            case 3:
                int i12 = TrainingActivity.f3357M;
                return new m(new M0.k(trainingActivity));
            case 4:
                int i13 = TrainingActivity.f3357M;
                Intent intent = trainingActivity.getIntent();
                return (intent == null || (stringExtra = intent.getStringExtra("extra_entry_source")) == null) ? "oobe" : stringExtra;
            default:
                return Boolean.valueOf(trainingActivity.f3363G || trainingActivity.f3362F || trainingActivity.isFinishing() || trainingActivity.isDestroyed());
        }
    }
}
