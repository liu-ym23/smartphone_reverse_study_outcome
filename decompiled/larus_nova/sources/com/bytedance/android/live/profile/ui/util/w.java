package com.bytedance.android.live.profile.ui.util;

import android.content.Context;
import com.bytedance.ies.utility.SharedPrefHelper;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f86964a = null;

    public static final class a {
        public a() {
        }

        public static boolean a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "spKey");
            long r102 = System.currentTimeMillis();
            long r103 = r102 - ((((long) TimeZone.getDefault().getRawOffset()) + r102) % 86400000);
            if (SharedPrefHelper.b(r100).i(r101, -1) >= r103) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        f86964a = new a();
    }
}
