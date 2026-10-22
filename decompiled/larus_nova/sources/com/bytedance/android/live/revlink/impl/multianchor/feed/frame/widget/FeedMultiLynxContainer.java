package com.bytedance.android.live.revlink.impl.multianchor.feed.frame.widget;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.ss.android.lark.utils.statistics.PerfLog;
import f31.k;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FeedMultiLynxContainer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f94206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f94207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f94208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f94209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<List<k>> f94210e;

    public FeedMultiLynxContainer(Context r100, FrameLayout r101, MutableLiveData<List<k>> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "windowStatus");
        this.f94208c = r100;
        this.f94209d = r101;
        this.f94210e = r102;
        this.f94206a = LazyKt.lazy(new FeedMultiLynxContainer$component$2(this));
    }
}
