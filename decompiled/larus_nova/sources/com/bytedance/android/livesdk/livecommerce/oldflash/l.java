package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class l extends c implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f149626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f149627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m f149628e;

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final boolean a() {
        m r100 = this.f149628e;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.a();
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "label");
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.oldflash.m
    public final String b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        m r101 = this.f149628e;
        if (r101 == null) goto L6;
        String r102 = r101.b(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }
}
