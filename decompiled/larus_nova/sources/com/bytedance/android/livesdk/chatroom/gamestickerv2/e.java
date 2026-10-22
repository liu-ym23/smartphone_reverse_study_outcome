package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import java.util.HashMap;
import java.util.PriorityQueue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, PriorityQueue<GameStickerInfo>> f106345a;

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f106345a = new HashMap();
    }
}
