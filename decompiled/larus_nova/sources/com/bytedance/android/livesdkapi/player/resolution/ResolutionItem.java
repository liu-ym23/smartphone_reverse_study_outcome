package com.bytedance.android.livesdkapi.player.resolution;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/ResolutionItem;", "", "name", "", "sdkkey", "level", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getLevel", "()I", "getName", "()Ljava/lang/String;", "getSdkkey", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ResolutionItem {
    private final int level;
    private final String name;
    private final String sdkkey;

    public final int getLevel() {
        return this.level;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSdkkey() {
        return this.sdkkey;
    }

    public ResolutionItem(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "sdkkey");
        this.name = r100;
        this.sdkkey = r101;
        this.level = r102;
    }
}
