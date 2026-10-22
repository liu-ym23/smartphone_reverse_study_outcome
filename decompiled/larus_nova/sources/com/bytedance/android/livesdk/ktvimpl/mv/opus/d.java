package com.bytedance.android.livesdk.ktvimpl.mv.opus;

import android.content.Context;
import com.bytedance.android.livesdk.ktvapi.model.mv.m;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<Integer, Integer> f146187a;

    public d() {
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.d
    public final d a(HashMap r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f146187a = r100;
        return this;
    }

    @Override // com.bytedance.android.livesdk.ktvapi.model.mv.d
    public final OpusServiceImpl build(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        OpusServiceImpl r101 = new OpusServiceImpl(null, r100, this.f146187a, null);
        r101.f146163j = null;
        r101.f146164k = null;
        return r101;
    }
}
