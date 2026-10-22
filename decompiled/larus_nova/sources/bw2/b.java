package bw2;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f21016a;

    public b(d r100) {
        this.f21016a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ICardLifecycle$State r101 = (ICardLifecycle$State) r100;
        if (r101 != ICardLifecycle$State.Showed) goto L8;
        v70.a r102 = this.f21016a.f21021d;
        if (r102 == null) goto L13;
        r102.setVisibility(0);
        return;
    L13:
        return;
    L8:
        if (r101 != ICardLifecycle$State.Hidden) goto L15;
        v70.a r103 = this.f21016a.f21021d;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
        return;
    L16:
        return;
    }
}
