package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f176015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f176016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f176017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f176018d;

    public final long getEndTime() {
        return this.f176015a;
    }

    public e(Long r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r101, null, 0);
        ShoppingAsyncInflater.f45268e.getClass();
        ShoppingAsyncInflater.a.a(r101).aU(R.layout.ec_commerce_count_down_layout, this, true);
        this.f176016b = (TextView) findViewById(R.id.tv_hours);
        this.f176017c = (TextView) findViewById(R.id.tv_mins);
        this.f176018d = (TextView) findViewById(R.id.tv_secs);
        if (r100 == null) goto L5;
        long r102 = r100.longValue();
    L6:
        this.f176015a = r102;
        return;
    L5:
        r102 = 0;
        goto L6
    }
}
