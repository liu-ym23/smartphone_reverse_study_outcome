package com.bytedance.android.shopping.anchorv4.helper;

import android.animation.Animator;
import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakReference<Animator> f166970a;

    static {
    }

    public static PdpAddCartAnimationV2 a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new PdpAddCartAnimationV2(r100);
    }
}
