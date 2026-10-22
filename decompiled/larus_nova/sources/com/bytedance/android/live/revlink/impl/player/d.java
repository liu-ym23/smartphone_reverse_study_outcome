package com.bytedance.android.live.revlink.impl.player;

import com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.StreamLayoutManager;
import com.bytedance.android.scope.o;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes47.dex */
public interface d extends o, c {
    boolean O(String r100);

    h handleSei(String r100);

    void me(StreamLayoutManager.b r100);

    PublishSubject ml();

    void q1();
}
