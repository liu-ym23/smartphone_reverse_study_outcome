package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45599a = 0;

    public static final class a {
        @JvmStatic
        public static int a(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return ContextCompat.getColor(th.a.e(r100, true), r101);
        }

        @JvmStatic
        public static Drawable b(Context r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return ContextCompat.getDrawable(th.a.e(r100, true), r101);
        }

        @JvmStatic
        public static String c(Context r100, int r101, Object... r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "formattedArgs");
            return th.a.e(r100, true).getString(r101, Arrays.copyOf(r102, r102.length));
        }
    }

    static {
    }
}
