package com.bytedance.android.live.broadcastgame.api.openplatform;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f59411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59412b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f59413a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f59414b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f59415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f59416d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f59417e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f59418f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f59419g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f59420h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f59421i;

        public a(long r100, String r101, String r102, String r103, String r104, int r105, boolean r106, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r101, "appVersion");
            Intrinsics.checkNotNullParameter(r102, "appdId");
            Intrinsics.checkNotNullParameter(r103, "schema");
            Intrinsics.checkNotNullParameter(r104, "name");
            Intrinsics.checkNotNullParameter(r110, "sourceType");
            Intrinsics.checkNotNullParameter(r111, "iconUrl");
            this.f59413a = r100;
            this.f59414b = r101;
            this.f59415c = r102;
            this.f59416d = r103;
            this.f59417e = r104;
            this.f59418f = r105;
            this.f59419g = r106;
            this.f59420h = r110;
            this.f59421i = r111;
        }

        public /* synthetic */ a(long r110, String r111, String r112, String r113, String r114, int r115, boolean r116, String r210, String r211, int r212) {
            if ((r212 & 1) == 0) goto L5;
            long r100 = 0;
        L6:
            String r101 = "";
            if ((r212 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r212 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r212 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r212 & 16) == 0) goto L21;
            String r105 = "";
        L22:
            boolean r106 = false;
            if ((r212 & 32) == 0) goto L25;
            int r107 = 0;
        L27:
            if ((r212 & 64) != 0) goto L31;
            r106 = r116;
        L31:
            if ((r212 & 128) == 0) goto L33;
            String r117 = "collection";
        L35:
            if ((r212 & 256) != 0) goto L38;
            r101 = r211;
        L38:
            this(r100, r102, r103, r104, r105, r107, r106, r117, r101);
            return;
        L33:
            r117 = r210;
            goto L35
        L25:
            r107 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L22
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L6
        }
    }

    public f() {
        this(0);
    }

    public f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "trackSource");
        this.f59412b = r100;
    }

    public /* synthetic */ f(int r100) {
        this("other");
    }
}
