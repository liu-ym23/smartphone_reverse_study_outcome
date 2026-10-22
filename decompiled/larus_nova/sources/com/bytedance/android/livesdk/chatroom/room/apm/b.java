package com.bytedance.android.livesdk.chatroom.room.apm;

import com.bytedance.android.livesdkapi.performance.IPerformanceCacheData;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f110686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IPerformanceCacheData f110687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f110688c;

    public static final class a {
    }

    static {
    }

    public abstract boolean u();

    public b(IPerformanceManager r100) {
        Intrinsics.checkNotNullParameter(r100, "livePerformanceManager");
        this.f110687b = r100.createPerformanceCacheData();
        this.f110688c = new HashMap();
    }

    public static boolean v(b r100) {
        IPerformanceCacheData r101 = r100.f110687b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "prefData");
        return r101.isDataValid();
    }

    public final boolean w(long r100) {
        if (u() == true) goto L5;
    L10:
        return true;
    L5:
        if (this.f110686a == false) goto L10;
        if (r100 != this.f110687b.getRoomId()) goto L10;
        return false;
    }
}
