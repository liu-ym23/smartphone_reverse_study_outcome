package com.bytedance.android.live.broadcastgame.opengame.cloud;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f59809d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f59811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f59812c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f59813f = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f59814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f59815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f59816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f59817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f59818e;

        public static final class a {
        }

        static {
        }

        public final String toString() {
            return "isLogin = " + this.f59818e + ", \ncode = " + this.f59814a + ", anonymousCod = " + this.f59815b + ", \ncloudCode = " + this.f59816c + ", cloudACode = " + this.f59817d;
        }

        public b(boolean r100) {
            this.f59818e = r100;
            this.f59816c = "";
            this.f59817d = "";
        }
    }

    static {
    }

    public final String toString() {
        return "errNo: " + this.f59811b + ", errMsg: " + this.f59810a + ", \ndata: {" + this.f59812c + '}';
    }

    public d(int r100, b r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f59811b = r100;
        this.f59812c = r101;
    }
}
