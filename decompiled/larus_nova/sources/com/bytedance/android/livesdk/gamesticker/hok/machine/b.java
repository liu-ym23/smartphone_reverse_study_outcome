package com.bytedance.android.livesdk.gamesticker.hok.machine;

import com.bytedance.android.livesdk.chatroom.model.b2;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f125622a = null;

        static {
            f125622a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamesticker.hok.machine.b$b, reason: collision with other inner class name */
    public static final class C2020b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final j0 f125624b;

        public C2020b(c3 r100, j0 r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "equipState");
            this.f125623a = r100;
            this.f125624b = r101;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final k2 f125626b;

        public c(c3 r100, k2 r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "moneyCount");
            this.f125625a = r100;
            this.f125626b = r101;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b2 f125628b;

        public d(c3 r100, b2 r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "liveInfo");
            this.f125627a = r100;
            this.f125628b = r101;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125629a;

        public e(c3 r100) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            this.f125629a = r100;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c3 f125630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o f125631b;

        public f(c3 r100, o r101) {
            Intrinsics.checkNotNullParameter(r100, "roleInfo");
            Intrinsics.checkNotNullParameter(r101, "battleInfo");
            this.f125630a = r100;
            this.f125631b = r101;
        }
    }

    public b() {
    }
}
