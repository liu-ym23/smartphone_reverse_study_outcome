package H4;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import com.stepos.ability.voicewakeup.training.TrainingActivity;

/* loaded from: classes3.dex */
public final class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f743a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ TrainingActivity d;

    public k(View view, int i, long j5, TrainingActivity trainingActivity) {
        this.f743a = view;
        this.b = i;
        this.c = j5;
        this.d = trainingActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f743a;
        Log.i("TrainingActivity", "event=done_first_predraw player=" + this.b + " elapsedMs=" + (SystemClock.uptimeMillis() - this.c) + " paused=" + this.d.f3363G + " titleShown=" + view.isShown());
    }
}
