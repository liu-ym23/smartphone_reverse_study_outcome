package com.bytedance.android.live.profit.lottery;

import com.amap.api.col.s.ce;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryState;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "d", "e", "f", ce.f26391f, "Lcom/bytedance/android/live/profit/lottery/LotteryState$a;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$b;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$c;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$d;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$e;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$f;", "Lcom/bytedance/android/live/profit/lottery/LotteryState$g;", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class LotteryState {

    public static final class a extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f88023a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f88023a, ((a) r100).f88023a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            t r100 = this.f88023a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Drawing(info=" + this.f88023a + ")";
        }

        public a(t r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(null);
            this.f88023a = r100;
        }
    }

    public static final class b extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f88024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p0 f88025b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f88024a, r101.f88024a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f88025b, r101.f88025b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            t r100 = this.f88024a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            p0 r104 = this.f88025b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Finished(info=" + this.f88024a + ", finishInfo=" + this.f88025b + ")";
        }

        public b(t r100, p0 r101) {
            Intrinsics.checkNotNullParameter(r100, "info");
            Intrinsics.checkNotNullParameter(r101, "finishInfo");
            super(null);
            this.f88024a = r100;
            this.f88025b = r101;
        }
    }

    public static final class c extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f88026a = null;

        public c() {
            super(null);
        }

        static {
            f88026a = new c();
        }
    }

    public static final class d extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f88027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h1 f88028b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f88027a, r101.f88027a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f88028b, r101.f88028b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            t r100 = this.f88027a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            h1 r104 = this.f88028b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Refresh(info=" + this.f88027a + ", refreshInfo=" + this.f88028b + ")";
        }

        public d(t r100, h1 r101) {
            Intrinsics.checkNotNullParameter(r100, "info");
            Intrinsics.checkNotNullParameter(r101, "refreshInfo");
            super(null);
            this.f88027a = r100;
            this.f88028b = r101;
        }
    }

    public static final class e extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i1 f88029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final t f88030b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == false) goto L10;
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f88029a, r101.f88029a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f88030b, r101.f88030b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            i1 r100 = this.f88029a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            t r104 = this.f88030b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Rejected(rejectInfo=" + this.f88029a + ", info=" + this.f88030b + ")";
        }

        public e(i1 r100, t r101) {
            Intrinsics.checkNotNullParameter(r100, "rejectInfo");
            super(null);
            this.f88029a = r100;
            this.f88030b = r101;
        }
    }

    public static final class f extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f88031a = null;

        public f() {
            super(null);
        }

        static {
            f88031a = new f();
        }
    }

    public static final class g extends LotteryState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f88032a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f88032a, ((g) r100).f88032a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            t r100 = this.f88032a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Waiting(info=" + this.f88032a + ")";
        }

        public g(t r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            super(null);
            this.f88032a = r100;
        }
    }

    private LotteryState() {
    }

    public /* synthetic */ LotteryState(DefaultConstructorMarker r100) {
        this();
    }
}
