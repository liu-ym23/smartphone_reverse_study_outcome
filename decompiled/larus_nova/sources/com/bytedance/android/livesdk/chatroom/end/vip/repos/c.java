package com.bytedance.android.livesdk.chatroom.end.vip.repos;

import com.bytedance.android.livesdk.chatroom.end.vip.models.RestartLiveStatus;
import com.bytedance.android.livesdk.message.model.nl;
import io.reactivex.subjects.BehaviorSubject;
import vlc.l;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RestartLiveStateRepository f106157a;

    public c(RestartLiveStateRepository r100) {
        this.f106157a = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if ((r100 instanceof nl) == false) goto L6;
        this.f106157a.f106148c.dispose();
        ((BehaviorSubject) this.f106157a.f106151f.getValue()).onNext(new ug1.a(RestartLiveStatus.STREAMING, ((nl) r100).E()));
        return;
    }
}
