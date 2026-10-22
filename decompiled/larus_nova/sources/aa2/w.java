package aa2;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;
import com.bytedance.android.livesdk.interactivity.publicscreen.presenter.TransTextMessagePresenter;

/* JADX INFO: loaded from: classes9.dex */
public final class w implements com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TransTextMessagePresenter f2336a;

    public final boolean a() {
        if (this.f2336a.F.f140271e != PublicScreenHeatState.COLD) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.f2336a.F.f140271e != PublicScreenHeatState.HOT) goto L5;
        return true;
    L5:
        return false;
    }

    public w(TransTextMessagePresenter r100) {
        this.f2336a = r100;
    }
}
