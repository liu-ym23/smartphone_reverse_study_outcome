package c71;

import com.bytedance.android.live.room.api.messagewindow.lifecycle.ICardLifecycle$State;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface b<State, Event> {
    ICardLifecycle$State m();

    void n(State r100);

    Observable<State> v();
}
