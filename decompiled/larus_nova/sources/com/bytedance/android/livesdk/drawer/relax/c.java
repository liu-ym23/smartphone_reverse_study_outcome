package com.bytedance.android.livesdk.drawer.relax;

import android.content.Context;
import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.livesdk.feed.feed.e> f122588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f122589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f122590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f122591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f122592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f122593f;

    public final Context getContext() {
        return this.f122591d;
    }

    public c(ArrayList<com.bytedance.android.livesdk.feed.feed.e> r100, d r101, j0 r102, Context r103, f r104, Map<String, Object> r105) {
        Intrinsics.checkNotNullParameter(r100, "tabList");
        Intrinsics.checkNotNullParameter(r101, "businessContext");
        Intrinsics.checkNotNullParameter(r102, "settings");
        Intrinsics.checkNotNullParameter(r105, "trackContext");
        this.f122588a = r100;
        this.f122589b = r101;
        this.f122590c = r102;
        this.f122591d = r103;
        this.f122592e = r104;
        this.f122593f = r105;
    }
}
