package com.bytedance.android.live.process;

import com.bytedance.android.live.room.api.experience.perf.LivePerfBizLevel;
import com.bytedance.android.live.room.api.experience.perf.LivePerfBizType;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes46.dex */
public final class BasicPerfProcess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f85888a = null;

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n61.b.a f85889a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f85890b = null;

        public a() {
        }

        static {
            f85890b = new a();
            f85889a = n61.b.a.f518103a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return f85889a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r100) {
            if (r100 == 11) goto L8;
            if (r100 == 12) goto L8;
            return null;
        L8:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P0);
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n61.b.C6897b f85891a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f85892b = null;

        public b() {
        }

        static {
            f85892b = new b();
            f85891a = n61.b.C6897b.f518104a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return f85891a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r100) {
            if (r100 == 2) goto L12;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P2);
        L15:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P1);
        L12:
            return new k61.a(LivePerfBizType.Degrade, LivePerfBizLevel.P0);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n61.b.C6897b f85893a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f85894b = null;

        public c() {
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r100) {
            return null;
        }

        static {
            f85894b = new c();
            f85893a = n61.b.C6897b.f518104a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return f85893a;
        }
    }

    public static final class d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n61.b.C6897b f85895a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f85896b = null;

        public d() {
        }

        static {
            f85896b = new d();
            f85895a = n61.b.C6897b.f518104a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public n61.b getType() {
            return f85895a;
        }

        @Override // com.bytedance.android.live.process.BasicPerfProcess.e
        public final k61.a a(int r100) {
            if (r100 == 0) goto L5;
            return null;
        L5:
            return new k61.a(LivePerfBizType.Normal, LivePerfBizLevel.Default);
        }
    }

    public interface e {
        k61.a a(int r100);

        n61.b getType();
    }

    static {
        f85888a = LazyKt.lazy(BasicPerfProcess$bizPerfMapping$2.INSTANCE);
    }
}
