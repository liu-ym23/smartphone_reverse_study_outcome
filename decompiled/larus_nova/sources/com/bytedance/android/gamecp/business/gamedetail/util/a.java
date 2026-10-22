package com.bytedance.android.gamecp.business.gamedetail.util;

import android.view.Choreographer;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.Iterator;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f55625a = null;

    static {
        f55625a = new a();
    }

    public a() {
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        LocalTestManager.a(new Class[]{uv.a.class});
        Iterator<T> r101 = b.f55627b.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        int r102 = ((Number) r101.next()).intValue();
        Lazy r103 = MessageQueueUtil.f55621a;
        MessageQueueUtil.c(r102);
        goto L4
    L6:
        b.f55627b.clear();
        b.f55626a = false;
    }
}
