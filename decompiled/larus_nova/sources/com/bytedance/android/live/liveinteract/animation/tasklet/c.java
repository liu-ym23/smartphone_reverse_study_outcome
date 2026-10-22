package com.bytedance.android.live.liveinteract.animation.tasklet;

import android.content.Context;
import com.bytedance.android.live.core.widget.HSImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f71171a;

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.a
    public final HSImageView b() {
        return new HSImageView(this.f71171a);
    }

    public final Context getContext() {
        return this.f71171a;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f71171a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.animation.tasklet.a
    public final void a(HSImageView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setTag(null);
    }
}
