package com.bytedance.android.live.room.api.record.guide;

import android.content.Context;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PublishDialogInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f99105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f99106b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DataCenter f99107c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f99108d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f99109e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f99110f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f99111g;

    public final Context getContext() {
        return this.f99109e;
    }

    public PublishDialogInfo(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "originFilePath");
        this.f99109e = r100;
        this.f99110f = r101;
        this.f99111g = r102;
        this.f99106b = LazyKt.lazy(new PublishDialogInfo$finalFilePath$2(this));
        this.f99108d = LazyKt.lazy(PublishDialogInfo$highlightId$2.INSTANCE);
    }
}
