package com.bytedance.android.livesdk.gamesticker.hok.machine;

import com.bytedance.android.livesdk.chatroom.model.b2;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamesticker.hok.machine.a$a, reason: collision with other inner class name */
    public static final class C2019a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2019a f125609a = null;

        static {
            f125609a = new C2019a();
        }

        public C2019a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f125610a = null;

        static {
            f125610a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f125611a = null;

        static {
            f125611a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j0 f125613b;

        public d(c3 r100, j0 r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "equipState");
            this.f125612a = r100;
            this.f125613b = r101;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k2 f125615b;

        public e(c3 r100, k2 r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "moneyCount");
            this.f125614a = r100;
            this.f125615b = r101;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b2 f125617b;

        public f(c3 r100, b2 r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "liveInfo");
            this.f125616a = r100;
            this.f125617b = r101;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125618a;

        public g(c3 r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.f125618a = r100;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f125619a = null;

        static {
            f125619a = new h();
        }

        public h() {
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f125621b;

        public i(c3 r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "battleInfo");
            this.f125620a = r100;
            this.f125621b = r101;
        }
    }

    public a() {
    }
}
