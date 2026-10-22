package com.bytedance.android.livesdk.interactivity.textmessage.render;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.m4;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f141209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f141210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f141211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f141212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f141213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o f141214f;

    public b(o r100) {
        this.f141214f = r100;
        this.f141209a = m4.f153487a.getValue().getMessageShowThreshold();
        this.f141210b = s1.h(R.color.ttlive_like_count_self_like);
        this.f141211c = s1.h(R.color.ttlive_like_count_self_unlike);
        this.f141212d = R.drawable.ttlive_public_screen_suffix_heart_like;
        this.f141213e = R.drawable.ttlive_public_screen_suffix_heart_unlike;
    }
}
