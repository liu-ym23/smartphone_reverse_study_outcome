package com.bytedance.android.live.profit.vote.model;

import com.bytedance.apm.constant.UploadTypeInf;
import io.reactivex.subjects.Subject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.profit.vote.b f89237a;

        public final String toString() {
            return "CountDown(" + this.f89237a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.f89237a;
        }

        public a(com.bytedance.android.live.profit.vote.b r100) {
            Intrinsics.checkNotNullParameter(r100, "vote");
            this.f89237a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.vote.model.b$b, reason: collision with other inner class name */
    public static final class C1370b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.profit.vote.b f89238a;

        public final String toString() {
            return "Finished(" + this.f89238a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.f89238a;
        }

        public C1370b(com.bytedance.android.live.profit.vote.model.c r100) {
            Intrinsics.checkNotNullParameter(r100, "vote");
            this.f89238a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f89239a = null;

        public final String toString() {
            return "Gone";
        }

        static {
            f89239a = new c();
        }

        public c() {
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.profit.vote.b f89240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Subject<Long> f89241b;

        public final String toString() {
            return "Normal(" + this.f89240a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.f89240a;
        }

        public d(com.bytedance.android.live.profit.vote.model.c r100, Subject r101) {
            Intrinsics.checkNotNullParameter(r100, "vote");
            Intrinsics.checkNotNullParameter(r101, UploadTypeInf.TIMER);
            this.f89240a = r100;
            this.f89241b = r101;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.android.live.profit.vote.b f89242a;

        public final String toString() {
            return "TimeOut(" + this.f89242a + ')';
        }

        @Override // com.bytedance.android.live.profit.vote.model.b
        public final com.bytedance.android.live.profit.vote.b a() {
            return this.f89242a;
        }

        public e(com.bytedance.android.live.profit.vote.b r100) {
            Intrinsics.checkNotNullParameter(r100, "vote");
            this.f89242a = r100;
        }
    }

    public b() {
    }

    public com.bytedance.android.live.profit.vote.b a() {
        return null;
    }
}
