package com.bytedance.android.livesdk.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f161903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Long> f161904b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<Long> f161905c = null;

    static {
        f161904b = new ArrayList();
        f161905c = new ArrayList();
    }

    @JvmStatic
    public static final long a(int r100) {
        if (r100 == 0) goto L14;
        List<Long> r101 = f161905c;
        if (((ArrayList) r101).isEmpty() == true) goto L15;
        List<Long> r102 = f161904b;
        if (((ArrayList) r102).isEmpty() == false) goto L10;
        return 0;
    L10:
        if (((ArrayList) r101).size() < (r100 - 1)) goto L17;
        int r103 = Math.min((((ArrayList) r101).size() - r100) + 1, ((ArrayList) r101).size() - 1);
        return ((System.currentTimeMillis() - ((Number) ListProtector.get(r101, r103)).longValue()) + ((Number) ListProtector.get(r102, r103)).longValue()) / ((long) Math.max(1, r100));
    L17:
        return 0;
    L15:
        return 0;
    L14:
        return 0;
    }
}
