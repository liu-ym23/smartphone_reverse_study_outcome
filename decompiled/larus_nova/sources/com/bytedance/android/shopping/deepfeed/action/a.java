package com.bytedance.android.shopping.deepfeed.action;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.action.a$a, reason: collision with other inner class name */
    public static final class C2588a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f173038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f173039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f173040c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C2588a) == false) goto L12;
            C2588a r101 = (C2588a) r100;
            if (Intrinsics.areEqual(this.f173038a, r101.f173038a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f173039b, r101.f173039b) == true) goto L10;
            return false;
        L10:
            if (this.f173040c == r101.f173040c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            String r100 = this.f173038a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.f173039b;
            if (r104 == null) goto L9;
            r101 = r104.hashCode();
        L9:
            int r105 = (r103 + r101) * 31;
            boolean r106 = this.f173040c;
            ?? r107 = r106;
            if (r106 == false) goto L13;
            r107 = 1;
        L13:
            return r105 + r107;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "AiRec(aiText=" + this.f173038a + ", aiFeature=" + this.f173039b + ", insertLoadingCard=" + this.f173040c + ")";
        }

        public C2588a(String r100, List<String> r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "aiText");
            Intrinsics.checkNotNullParameter(r101, "aiFeature");
            this.f173038a = r100;
            this.f173039b = r101;
            this.f173040c = r102;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Boolean, Unit> f173041a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f173041a, ((b) r100).f173041a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Function1<Boolean, Unit> r100 = this.f173041a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Collect(collectStateChange=" + this.f173041a + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Boolean, Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "collectStateChange");
            this.f173041a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DeepFeedCommentClickArea f173042a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f173042a, ((c) r100).f173042a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            DeepFeedCommentClickArea r100 = this.f173042a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Comment(area=" + this.f173042a + ")";
        }

        public c(int r100) {
            DeepFeedCommentClickArea r101 = DeepFeedCommentClickArea.Container;
            Intrinsics.checkNotNullParameter(r101, "area");
            this.f173042a = r101;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f173043a = null;

        static {
            f173043a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f173044a = null;

        static {
            f173044a = new e();
        }

        public e() {
        }
    }

    public static final class f extends a {
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f173045a = null;

        static {
            f173045a = new g();
        }

        public g() {
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f173046a = null;

        static {
            f173046a = new h();
        }

        public h() {
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f173047a = null;

        static {
            f173047a = new i();
        }

        public i() {
        }
    }

    public a() {
    }
}
