package com.bytedance.android.livesdkapi.init;

import android.os.SystemClock;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fJ\u0006\u0010\u000b\u001a\u00020\rR\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/init/LiveSceneInfo;", "", "scene", "", "pageType", "", "position", "", "(Ljava/lang/String;JI)V", "DEFAULT_TIME", "enter", "initEnd", "appendSceneInfo", "", "map", "", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSceneInfo {
    private final long DEFAULT_TIME;
    private final long enter;
    private long initEnd;
    private final long pageType;
    private final int position;
    private final String scene;

    public final void initEnd() {
        if (this.DEFAULT_TIME != this.initEnd) goto L6;
        this.initEnd = SystemClock.elapsedRealtime();
        return;
    }

    public final void appendSceneInfo(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        r100.put("scene", this.scene);
        r100.put("page_type", String.valueOf(this.pageType));
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_CARD_POSITION, String.valueOf(this.position));
        long r101 = this.DEFAULT_TIME;
        long r102 = this.initEnd;
        if (r101 == r102) goto L6;
        r100.put("scene_wait_duration", String.valueOf(r102 - this.enter));
        return;
    }

    public LiveSceneInfo(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.scene = r100;
        this.pageType = r101;
        this.position = r102;
        this.DEFAULT_TIME = -1;
        this.enter = SystemClock.elapsedRealtime();
        this.initEnd = -1;
    }
}
