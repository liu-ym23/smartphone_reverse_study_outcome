package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<c> f106555a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f106555a, ((a) r100).f106555a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Function0<c> r100 = this.f106555a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Lazy(get=" + this.f106555a + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<? extends c> r100) {
            Intrinsics.checkNotNullParameter(r100, MonitorConstants.CONNECT_TYPE_GET);
            this.f106555a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ShortTermIndicatorEvent f106556a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f106556a, ((b) r100).f106556a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ShortTermIndicatorEvent r100 = this.f106556a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Notify(event=" + this.f106556a + ")";
        }

        public b(ShortTermIndicatorEvent.InsertionStarted r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.f106556a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.indicator.shortterm.c$c, reason: collision with other inner class name */
    public static final class C1606c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<c> f106557a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1606c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f106557a, ((C1606c) r100).f106557a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Iterable<c> r100 = this.f106557a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Parallel(plans=" + this.f106557a + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C1606c(Iterable<? extends c> r100) {
            Intrinsics.checkNotNullParameter(r100, "plans");
            this.f106557a = r100;
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f106558a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == true) goto L6;
            return false;
        L6:
            if (this.f106558a == ((d) r100).f106558a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f106558a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Pause(milliseconds=" + this.f106558a + ")";
        }

        public d(long r100) {
            this.f106558a = r100;
        }
    }

    public static final class e extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ShortTermIcon> f106559a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof e) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f106559a, ((e) r100).f106559a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            List<ShortTermIcon> r100 = this.f106559a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Place(icons=" + this.f106559a + ")";
        }

        public e(List<ShortTermIcon> r100) {
            Intrinsics.checkNotNullParameter(r100, "icons");
            this.f106559a = r100;
        }
    }

    public static final class f extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f106560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f106561b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L10;
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f106560a, r101.f106560a) == true) goto L8;
            return false;
        L8:
            if (this.f106561b == r101.f106561b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            View r100 = this.f106560a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f106561b;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "PreserveWidth(rightmostView=" + this.f106560a + ", width=" + this.f106561b + ")";
        }

        public f(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "rightmostView");
            this.f106560a = r100;
            this.f106561b = r101;
        }
    }

    public static final class g extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ShortTermIcon f106562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f106563b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof g) == false) goto L10;
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f106562a, r101.f106562a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f106563b, r101.f106563b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ShortTermIcon r100 = this.f106562a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Rect r104 = this.f106563b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Scale(icon=" + this.f106562a + ", rect=" + this.f106563b + ")";
        }

        public g(ShortTermIcon r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
            this.f106562a = r100;
            this.f106563b = r101;
        }
    }

    public static final class h extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f106564a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof h) == true) goto L6;
            return false;
        L6:
            if (this.f106564a == ((h) r100).f106564a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            return this.f106564a;
        }

        public final String toString() {
            return "Scroll(dx=" + this.f106564a + ")";
        }

        public h(int r100) {
            this.f106564a = r100;
        }
    }

    public static final class i extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<ShortTermIcon> f106565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f106566b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof i) == false) goto L10;
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f106565a, r101.f106565a) == true) goto L8;
            return false;
        L8:
            if (this.f106566b == r101.f106566b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            List<ShortTermIcon> r100 = this.f106565a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L7:
            return (r101 * 31) + this.f106566b;
        L5:
            r101 = 0;
            goto L7
        }

        public final String toString() {
            return "Shift(icons=" + this.f106565a + ", offset=" + this.f106566b + ")";
        }

        public i(List<ShortTermIcon> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "icons");
            this.f106565a = r100;
            this.f106566b = r101;
        }
    }

    public static final class j extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f106567a = null;

        static {
            f106567a = new j();
        }

        public j() {
        }
    }

    public static final class k extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f106568a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof k) == true) goto L6;
            return false;
        L6:
            if (this.f106568a == ((k) r100).f106568a) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f106568a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Tok(minGapMs=" + this.f106568a + ")";
        }

        public k(long r100) {
            this.f106568a = r100;
        }
    }

    public c() {
    }
}
