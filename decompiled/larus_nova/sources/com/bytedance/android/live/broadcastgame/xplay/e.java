package com.bytedance.android.live.broadcastgame.xplay;

import com.google.gson.JsonObject;
import io.reactivex.Completable;
import io.reactivex.Observable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public interface e {

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.xplay.e$a$a, reason: collision with other inner class name */
        public static final class C1027a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f62064a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof C1027a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.f62064a, ((C1027a) r100).f62064a) == true) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                Throwable r100 = this.f62064a;
                if (r100 != null) goto L7;
                return 0;
            L7:
                return r100.hashCode();
            }

            public final String toString() {
                return "Failed(cause=" + this.f62064a + ")";
            }

            public C1027a(Throwable r100) {
                Intrinsics.checkNotNullParameter(r100, "cause");
                this.f62064a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f62065a = null;

            static {
                f62065a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f62066a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Float.compare(this.f62066a, ((c) r100).f62066a) == 0) goto L13;
                return false;
            L13:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.f62066a);
            }

            public final String toString() {
                return "Loading(progress=" + this.f62066a + ")";
            }

            public c(float r100) {
                this.f62066a = r100;
            }
        }

        public a() {
        }
    }

    Completable J();

    void a(a r100);

    Completable c();

    Completable d();

    Observable<Unit> f();

    Completable g();

    XplayApi.j getRtcInfo();

    void handleAnchorPanelJSBInvoke(String r100, JsonObject r101, Function1<? super JsonObject, Unit> r102);
}
