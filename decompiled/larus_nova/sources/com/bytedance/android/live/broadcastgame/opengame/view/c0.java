package com.bytedance.android.live.broadcastgame.opengame.view;

import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class c0 implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayDeque<m0> f61288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<m0> f61289b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.h
    public final m0 poll() {
        return this.f61288a.poll();
    }

    public c0() {
        this.f61288a = new ArrayDeque();
        this.f61289b = new ArrayList();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.h
    public final List<m0> getAll() {
        return this.f61289b;
    }
}
