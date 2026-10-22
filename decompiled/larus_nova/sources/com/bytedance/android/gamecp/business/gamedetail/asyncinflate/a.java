package com.bytedance.android.gamecp.business.gamedetail.asyncinflate;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f53475a = 0;

    public a() {
    }

    static {
    }

    public static View a(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LocalTestManager.a(new Class[]{uv.a.class});
        return GameAsyncInflate.a(r100).aU(r101, null, false);
    }
}
