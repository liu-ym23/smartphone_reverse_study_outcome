package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import com.bytedance.android.livesdk.chatroom.end.vip.models.RestartLiveStatus;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RestartLiveStateRepository f106155a;

    public a(RestartLiveStateRepository r100) {
        this.f106155a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ((BehaviorSubject) this.f106155a.f106151f.getValue()).onNext(new ug1.a(RestartLiveStatus.TIMEOUT));
    }
}
