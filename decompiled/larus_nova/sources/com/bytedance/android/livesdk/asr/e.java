package com.bytedance.android.livesdk.asr;

import android.content.Context;
import com.bytedance.android.livesdk.asr.aio.ASRManagerService;
import com.bytedance.android.scope.o;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f103973a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public final Context getContext() {
        return this.f103973a;
    }

    public e(Context r100, ASRManagerService r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "asrService");
        this.f103973a = r100;
    }
}
