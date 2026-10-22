package com.bytedance.android.live.broadcastgame.opengame.cloud;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f59831d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f59832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f59833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59834c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f59835c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f59836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f59837b;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            return "sid = " + this.f59836a + ", expiredTime = " + this.f59837b;
        }

        public b() {
            this.f59836a = "";
            this.f59837b = -1;
        }
    }

    static {
    }

    public final String toString() {
        return "code = " + this.f59833b + ", message = " + this.f59834c + ", \ndata = {" + this.f59832a + '}';
    }

    public j(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f59833b = r100;
        this.f59834c = r101;
    }
}
