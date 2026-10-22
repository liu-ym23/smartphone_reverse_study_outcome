package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import com.bytedance.android.livesdk.message.model.MusicPanel;

/* JADX INFO: loaded from: classes10.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f144540a;

    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f144541b = null;

        static {
            f144541b = new a();
        }

        public a() {
            super("OnClose");
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f144542b = null;

        static {
            f144542b = new b();
        }

        public b() {
            super("OnEnd");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.c$c, reason: collision with other inner class name */
    public static final class C2258c extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MusicPanel f144543b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f144544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f144545d;

        public C2258c() {
            super("OnFailure");
            this.f144543b = null;
            this.f144544c = true;
            this.f144545d = true;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f144546b = null;

        static {
            f144546b = new d();
        }

        public d() {
            super("OnPrepare");
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f144547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f144548c;

        public e(long r100, long r101) {
            super("OnStart");
            this.f144547b = r100;
            this.f144548c = r101;
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f144549b;

        public f(long r100, long r101) {
            super("OnSuccess");
            this.f144549b = r100;
        }
    }

    public static final class g extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f144550b;

        public g(long r100, long r101, Long r102, Long r103) {
            super("OnUpdateScore");
            this.f144550b = r100;
        }
    }

    public final String toString() {
        return this.f144540a;
    }

    public c(String r100) {
        this.f144540a = r100;
    }
}
