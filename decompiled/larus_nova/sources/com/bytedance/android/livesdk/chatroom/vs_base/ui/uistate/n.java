package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.vs_base.util.t;

/* JADX INFO: loaded from: classes8.dex */
public final class n extends ir1.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f118182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f118183d;

    public n() {
        this.f118182c = -1;
        this.f118183d = -1;
    }

    public final int o(Context r100) {
        ALogger.d("ReplayPlayFragmentUIState", "playFragmentLongSide context " + r100 + ", playFragmentLongSide " + this.f118182c);
        int r101 = this.f118182c;
        if (r101 > 0) goto L10;
        int r102 = t.f118215a;
        Rect r103 = new Rect();
        if ((r100 instanceof Activity) == false) goto L9;
        t.b(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r103);
    L9:
        return r103.height();
    L10:
        return r101;
    }

    public final int p(Context r100) {
        ALogger.d("ReplayPlayFragmentUIState", "playFragmentShortSide context " + r100 + ", playFragmentShortSide " + this.f118183d);
        int r101 = this.f118183d;
        if (r101 > 0) goto L10;
        int r102 = t.f118215a;
        Rect r103 = new Rect();
        if ((r100 instanceof Activity) == false) goto L9;
        t.b(((Activity) r100).getWindow()).getWindowVisibleDisplayFrame(r103);
    L9:
        return r103.width();
    L10:
        return r101;
    }
}
