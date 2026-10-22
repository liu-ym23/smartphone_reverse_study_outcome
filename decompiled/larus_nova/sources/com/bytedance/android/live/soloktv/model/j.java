package com.bytedance.android.live.soloktv.model;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f101393a;

        public a() {
            this(false);
        }

        public a(boolean r100) {
            this.f101393a = r100;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MusicPanel f101394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f101395b;

        public b() {
            this(0);
        }

        public /* synthetic */ b(int r100) {
            this(null, false);
        }

        public b(MusicPanel r100, boolean r101) {
            this.f101394a = r100;
            this.f101395b = r101;
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f101396a;

        public c() {
            this(false);
        }

        public c(boolean r100) {
            this.f101396a = r100;
        }
    }

    public static final class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MusicPanel f101397a;

        public d(MusicPanel r100) {
            Intrinsics.checkNotNullParameter(r100, "musicPanel");
            this.f101397a = r100;
        }
    }

    public static final class e extends j {
        public e(MusicPanel r100) {
            Intrinsics.checkNotNullParameter(r100, "musicPanel");
        }
    }

    public static final class f extends j {
        public f() {
        }
    }

    public j() {
    }
}
