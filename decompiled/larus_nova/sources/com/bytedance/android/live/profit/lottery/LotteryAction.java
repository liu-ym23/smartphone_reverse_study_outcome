package com.bytedance.android.live.profit.lottery;

import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryAction;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", ce.f26391f, "Lcom/bytedance/android/live/profit/lottery/LotteryAction$a;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$b;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$c;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$d;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$e;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$f;", "Lcom/bytedance/android/live/profit/lottery/LotteryAction$g;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class LotteryAction {

    public static final class a extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f87928a = null;

        public a() {
            super(null);
        }

        static {
            f87928a = new a();
        }
    }

    public static final class b extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f87929a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f87929a, ((b) r100).f87929a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            t r100 = this.f87929a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Approve(info=" + this.f87929a + ")";
        }

        public b(t r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(null);
            this.f87929a = r100;
        }
    }

    public static final class c extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f87930a = null;

        public c() {
            super(null);
        }

        static {
            f87930a = new c();
        }
    }

    public static final class d extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f87931a = null;

        public d() {
            super(null);
        }

        static {
            f87931a = new d();
        }
    }

    public static final class e extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p0 f87932a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f87932a, ((e) r100).f87932a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            p0 r100 = this.f87932a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Finish(finishInfo=" + this.f87932a + ")";
        }

        public e(p0 r100) {
            Intrinsics.checkNotNullParameter(r100, "finishInfo");
            super(null);
            this.f87932a = r100;
        }
    }

    public static final class f extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h1 f87933a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f87933a, ((f) r100).f87933a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            h1 r100 = this.f87933a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Refresh(refreshInfo=" + this.f87933a + ")";
        }

        public f(h1 r100) {
            Intrinsics.checkNotNullParameter(r100, "refreshInfo");
            super(null);
            this.f87933a = r100;
        }
    }

    public static final class g extends LotteryAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i1 f87934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t f87935b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == false) goto L10;
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f87934a, r101.f87934a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f87935b, r101.f87935b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            i1 r100 = this.f87934a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            t r104 = this.f87935b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Reject(rejectInfo=" + this.f87934a + ", info=" + this.f87935b + ")";
        }

        public g(i1 r100, t r101) {
            Intrinsics.checkNotNullParameter(r100, "rejectInfo");
            super(null);
            this.f87934a = r100;
            this.f87935b = r101;
        }
    }

    private LotteryAction() {
    }

    public /* synthetic */ LotteryAction(DefaultConstructorMarker r100) {
        this();
    }
}
