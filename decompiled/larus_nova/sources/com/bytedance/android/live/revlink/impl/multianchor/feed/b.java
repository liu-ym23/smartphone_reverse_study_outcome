package com.bytedance.android.live.revlink.impl.multianchor.feed;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f94103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IRoom f94104b;

    public final String getInteractId() {
        return this.f94103a;
    }

    public final IRoom getRoom() {
        return this.f94104b;
    }

    public b(Context r100, String r101, IRoom r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f94103a = r101;
        this.f94104b = r102;
    }
}
