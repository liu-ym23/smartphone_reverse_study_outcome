package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f77469b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, q> f77470a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f77471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f77472b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.bytedance.android.live.pushstream.d f77473c;

        public a() {
        }

        public final d0 a() {
            d0 r100 = new d0();
            if (this.f77471a == false) goto L6;
            r100.b(2, new IMStreamInfoSender());
        L6:
            if (this.f77472b == false) goto L10;
            com.bytedance.android.live.pushstream.d r101 = this.f77473c;
            if (r101 == null) goto L10;
            r100.b(1, new c(r101));
        L10:
            ALogger.i("LiveStreamInfoSenderManager", "build: IM:" + this.f77471a + ",SEI:" + this.f77472b + ", liveStream:" + this.f77473c);
            return r100;
        }

        public final void b(boolean r100) {
            this.f77471a = r100;
            ALogger.i("LiveStreamInfoSenderManager", "enableIM：" + this.f77471a);
        }

        public final void c(boolean r100, com.bytedance.android.live.pushstream.d r101) {
            Intrinsics.checkNotNullParameter(r101, "liveStream");
            this.f77472b = r100;
            this.f77473c = r101;
            ALogger.i("LiveStreamInfoSenderManager", "enableSei：" + this.f77472b);
        }
    }

    public static final class b {
    }

    static {
    }

    public d0() {
        this.f77470a = new ConcurrentHashMap();
    }

    public final q a(int r100) {
        return this.f77470a.get(Integer.valueOf(r100));
    }

    public final void b(int r100, q r101) {
        Intrinsics.checkNotNullParameter(r101, "sender");
        boolean r102 = false;
        if (this.f77470a.contains(Integer.valueOf(r100)) == false) goto L12;
        q r103 = this.f77470a.remove(Integer.valueOf(r100));
        if (r103 == null) goto L8;
        r103.onClose();
    L8:
        if (this.f77470a.size() > 1) goto L10;
        boolean r104 = true;
    L11:
        f77469b = r104;
        goto L12
    L10:
        r104 = false;
    L12:
        this.f77470a.put(Integer.valueOf(r100), r101);
        if (this.f77470a.size() > 1) goto L15;
        r102 = true;
    L15:
        f77469b = r102;
    }
}
