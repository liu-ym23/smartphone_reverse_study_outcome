package com.bytedance.android.live.liveinteract.revenue.linkroomfight.core;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$a$a, reason: collision with other inner class name */
        public static final class C1226a extends a {
        }

        public static final class b extends a {
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$a$c, reason: collision with other inner class name */
        public static final class C1227c extends a {
        }

        public static final class d extends a {
        }

        public static final class e extends a {
        }

        public static final class f extends a {
        }

        public static final class g extends a {
        }

        public static final class h extends a {
        }

        public static final class i extends a {
        }

        public static final class j extends a {
        }

        public static final class k extends a {
        }

        public final String toString() {
            return null;
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.liveinteract.multiscene.a f78514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f78515b;

        public static final class a extends b {
            public a(com.bytedance.android.live.liveinteract.multiscene.a r100) {
                Intrinsics.checkNotNullParameter(r100, "teamFightInfo");
                super(r100, "Fighting");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$b$b, reason: collision with other inner class name */
        public static final class C1228b extends b {
            public C1228b(com.bytedance.android.live.liveinteract.multiscene.a r100) {
                Intrinsics.checkNotNullParameter(r100, "teamFightInfo");
                super(r100, "Finished");
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c$b$c, reason: collision with other inner class name */
        public static final class C1229c extends b {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final C1229c f78516c = null;

            static {
                f78516c = new C1229c();
            }

            public C1229c() {
                super((com.bytedance.android.live.liveinteract.multiscene.a) vh7.f.c(com.bytedance.android.live.liveinteract.multiscene.a.class), "None");
            }
        }

        public static final class d extends b {
            public d(com.bytedance.android.live.liveinteract.multiscene.a r100) {
                Intrinsics.checkNotNullParameter(r100, "teamFightInfo");
                super(r100, "PunishFinish");
            }
        }

        public static final class e extends b {
            public e(com.bytedance.android.live.liveinteract.multiscene.a r100) {
                Intrinsics.checkNotNullParameter(r100, "teamFightInfo");
                super(r100, "Punishing");
            }
        }

        public static final class f extends b {
            public f() {
                throw null;
            }
        }

        public final boolean a() {
            if ((this instanceof a) == false) goto L5;
        L12:
            return true;
        L5:
            if ((this instanceof f) == true) goto L12;
            if ((this instanceof e) == true) goto L12;
            if ((this instanceof d) == true) goto L12;
            return false;
        }

        public final String toString() {
            return this.f78515b;
        }

        public b(com.bytedance.android.live.liveinteract.multiscene.a r100, String r101) {
            this.f78514a = r100;
            this.f78515b = r101;
        }
    }
}
