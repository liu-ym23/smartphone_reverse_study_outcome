package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class PSHighlightType implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f133416a;

    public static final class CommonHighlightComp extends PSHighlightType {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Lazy f133417f = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f133418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f133419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f133420d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f133421e;

        public static final class a {
        }

        public CommonHighlightComp() {
            this(0);
        }

        static {
            f133417f = LazyKt.lazy(PSHighlightType$CommonHighlightComp$Companion$Default$2.INSTANCE);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long a() {
            return this.f133420d;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long b() {
            return this.f133421e;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final String getBizScene() {
            return this.f133419c;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public long getType() {
            return this.f133418b;
        }

        public /* synthetic */ CommonHighlightComp(int r100) {
            this(-1, "", 300, 150);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final boolean c(n r100) {
            Intrinsics.checkNotNullParameter(r100, "other");
            if (super.c(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (getType() != r100.getType()) goto L7;
            return true;
        }

        public CommonHighlightComp(long r100, String r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r101, "bizScene");
            this.f133418b = r100;
            this.f133419c = r101;
            this.f133420d = r102;
            this.f133421e = r103;
        }
    }

    public static final class a extends PSHighlightType {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f133422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f133423c;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long a() {
            return this.f133422b;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long b() {
            return this.f133423c;
        }

        public a(long r100, long r101) {
            this.f133422b = r100;
            this.f133423c = r101;
        }
    }

    public static final class b extends PSHighlightType {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f133424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f133425c;

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long a() {
            return this.f133424b;
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
        public final long b() {
            return this.f133425c;
        }

        public b(long r100, long r101) {
            this.f133424b = r100;
            this.f133425c = r101;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
    public long getType() {
        return 0;
    }

    public PSHighlightType() {
        this.f133416a = "";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
    public String getBizScene() {
        return this.f133416a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n
    public boolean c(n r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        Intrinsics.checkNotNullParameter(r100, "other");
        return Intrinsics.areEqual(getClass(), r100.getClass());
    }
}
