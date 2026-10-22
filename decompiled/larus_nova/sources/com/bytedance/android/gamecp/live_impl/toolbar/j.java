package com.bytedance.android.gamecp.live_impl.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IToolbarHandler;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements IToolbarHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f58003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58006d;

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IToolbarHandler
    public final boolean onClick() {
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IToolbarHandler
    public final void onDestroy() {
        l r100 = this.f58003a;
        if (r100 == null) goto L9;
        ToolbarContext r101 = r100.f58011c;
        if (r101 == null) goto L9;
        if (r101.isCleared() == true) goto L9;
        r100.f58011c.setPreloadToolbarDuration(0L);
        r100.f58011c.setPreloadToolbarHasClick(false);
        r100.f58011c.setEnterRoomTimestamp(0);
        r100.f58010b.dispose();
        r100.f58011c.onCleared();
    L9:
        this.f58003a = null;
    }

    @Override // com.bytedance.android.livesdkapi.room.handler.viewinterface.IToolbarHandler
    public final View getView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f58003a != null) goto L5;
        this.f58003a = new l(r100, this.f58004b, this.f58005c, this.f58006d);
    L5:
        l r101 = this.f58003a;
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public j(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        Intrinsics.checkNotNullParameter(r101, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f58004b = r100;
        this.f58005c = r101;
        this.f58006d = r102;
    }
}
