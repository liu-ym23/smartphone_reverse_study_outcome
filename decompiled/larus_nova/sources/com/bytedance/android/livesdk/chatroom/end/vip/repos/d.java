package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import com.bytedance.android.livesdk.chatroom.end.vip.models.RestartLiveStatus;
import io.reactivex.functions.Action;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RestartLiveStateRepository f106158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f106159b;

    public d(RestartLiveStateRepository r100, long r101) {
        this.f106158a = r100;
        this.f106159b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        ((BehaviorSubject) this.f106158a.f106151f.getValue()).onNext(new ug1.a(RestartLiveStatus.STREAMING, this.f106159b));
    }
}
