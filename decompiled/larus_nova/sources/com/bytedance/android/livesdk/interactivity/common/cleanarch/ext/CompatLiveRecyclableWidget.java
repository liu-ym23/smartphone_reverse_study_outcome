package com.bytedance.android.livesdk.interactivity.common.cleanarch.ext;

import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/common/cleanarch/ext/CompatLiveRecyclableWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class CompatLiveRecyclableWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Disposable> f136444a;

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public void onUnload() {
        Iterator<T> r100 = this.f136444a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Disposable) r100.next()).dispose();
        goto L4
    L6:
        ((ArrayList) this.f136444a).clear();
    }

    public CompatLiveRecyclableWidget() {
        this.f136444a = new ArrayList();
    }
}
