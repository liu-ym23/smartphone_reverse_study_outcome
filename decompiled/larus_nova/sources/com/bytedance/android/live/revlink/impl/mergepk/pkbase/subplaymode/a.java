package com.bytedance.android.live.revlink.impl.mergepk.pkbase.subplaymode;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.revlink.impl.pk.vm.pk.d;
import com.bytedance.android.livesdk.link.model.n3;

/* JADX INFO: loaded from: classes47.dex */
public interface a {
    com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.a getBattleScoreData();

    LiveData<n3> getBreakthroughInfo();

    LiveData<d> getPlayState();

    void resetState();
}
