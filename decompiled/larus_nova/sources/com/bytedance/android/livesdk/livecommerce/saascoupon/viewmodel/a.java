package com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C2360a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2360a f152934a = null;

        static {
            f152934a = new C2360a();
        }

        public C2360a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f152935a;

        public b(boolean r100) {
            this.f152935a = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f152936a;

        public final Activity getActivity() {
            return this.f152936a;
        }

        public c(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f152936a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f152937a;

        public d(boolean r100) {
            this.f152937a = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f152938a = null;

        static {
            f152938a = new e();
        }

        public e() {
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f152939a = null;

        static {
            f152939a = new f();
        }

        public f() {
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f152940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f152941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f152942c;

        public g(String r100, String r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = "";
        L8:
            Intrinsics.checkNotNullParameter(r100, "eventTag");
            Intrinsics.checkNotNullParameter(r101, "buttonType");
            Intrinsics.checkNotNullParameter(r102, "postCouponStatus");
            this.f152940a = r100;
            this.f152941b = r101;
            this.f152942c = r102;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f152943a;

        public final Activity getActivity() {
            return this.f152943a;
        }

        public h(FragmentActivity r100) {
            Intrinsics.checkNotNullParameter(r100, "activity");
            this.f152943a = r100;
        }
    }

    public a() {
    }
}
