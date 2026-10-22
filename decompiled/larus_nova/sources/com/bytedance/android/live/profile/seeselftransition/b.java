package com.bytedance.android.live.profile.seeselftransition;

import android.graphics.PointF;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.profile.p004enum.ProfileMode;
import kotlin.Pair;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    void BJ(a r100, ProfileMode r101);

    Pair<Integer, Integer> Ls();

    void Wl(k r100);

    void d80();

    void es(float r100);

    LifecycleOwner getLifecycleOwner();

    void ks(PointF r100);

    void setDressIconScale(float r100);

    void show(FragmentManager r100, String r101);

    PointF v10();
}
