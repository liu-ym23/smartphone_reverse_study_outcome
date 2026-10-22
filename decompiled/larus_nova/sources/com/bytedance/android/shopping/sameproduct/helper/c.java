package com.bytedance.android.shopping.sameproduct.helper;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f182424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f182425b;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f182425b;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f182425b = r100;
    }
}
