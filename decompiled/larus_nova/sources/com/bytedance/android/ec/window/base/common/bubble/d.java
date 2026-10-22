package com.bytedance.android.ec.window.base.common.bubble;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowBubbleShowStrategy f49119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Pair<t, e>> f49120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f49121c;

    public d() {
        this.f49119a = WindowBubbleShowStrategy.ONLY_ONE_ONCE;
        this.f49120b = new ArrayList();
        this.f49121c = new Handler(Looper.getMainLooper());
    }
}
