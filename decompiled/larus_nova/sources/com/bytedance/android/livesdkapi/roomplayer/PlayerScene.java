package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/PlayerScene;", "Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerScene;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "scene", "getScene", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerScene extends ILivePlayerScene {
    private final String name;

    public final String getName() {
        return this.name;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene
    public String getScene() {
        return this.name;
    }

    public PlayerScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.name = r100;
    }
}
