package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.message.GameRoomStickerOprMessage;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerScene;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTask;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTaskManager;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k implements IGameStickerTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, IGameStickerTask> f106353a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f106354b = null;

    public k() {
    }

    static {
        f106354b = new k();
        f106353a = new HashMap();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTaskManager
    public final void recycle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        HashMap<String, IGameStickerTask> r101 = f106353a;
        IGameStickerTask r102 = r101.get(r100);
        if (r102 == null) goto L13;
        int r103 = r102.referenceCount();
        if (r103 <= 0) goto L8;
        ALogger.i("GameStickerTaskManager", r100 + " recycle task false cause referenceCount " + r103);
        return;
    L8:
        IGameStickerTask r104 = r101.get(r100);
        if (r104 == null) goto L11;
        r104.release();
    L11:
        r101.remove(r100);
        ALogger.i("GameStickerTaskManager", r100 + " recycle task success , current taskMap size " + r101.size());
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTaskManager
    public final void dispatch(String r100, GameRoomStickerOprMessage r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "message");
        IGameStickerTask r102 = f106353a.get(r100);
        if (r102 == null) goto L6;
        r102.onMessage(r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTaskManager
    public final void dispatch(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "sei");
        IGameStickerTask r102 = f106353a.get(r100);
        if (r102 == null) goto L6;
        r102.onSei(r101);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerTaskManager
    public final IGameStickerTask obtainTask(GameStickerScene r100, String r101, Set<Integer> r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "stickerTypes");
        HashMap<String, IGameStickerTask> r103 = f106353a;
        IGameStickerTask r104 = r103.get(r101);
        if (r104 == null) goto L6;
        ALogger.i("GameStickerTaskManager", r101 + " obtainTask has exist");
        r104.setScene(r100);
        return r104;
    L6:
        ALogger.i("GameStickerTaskManager", r101 + " obtainTask type:" + r102);
        GameStickerTask r105 = new GameStickerTask(r101);
        Intrinsics.checkNotNullParameter(r100, "scene");
        r105.f106282k = r100;
        r105.init(r102);
        r103.put(r101, r105);
        return r105;
    }
}
