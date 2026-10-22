package com.bytedance.android.shopping.mall.feed.help;

import android.os.Handler;
import android.os.Looper;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ECMallGulRefresh {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f176903g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f176904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f176905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f176906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f176907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f176908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f176909f;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/help/ECMallGulRefresh$Companion$PrefetchState;", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PrefetchState {
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/help/ECMallGulRefresh$Companion$a;", "", "", "fromPitaya", "Ljava/lang/Boolean;", "getFromPitaya", "()Ljava/lang/Boolean;", "", "leaveTimeout", "Ljava/lang/Long;", "getLeaveTimeout", "()Ljava/lang/Long;", "", "", "pageName", "Ljava/util/List;", "getPageName", "()Ljava/util/List;", "pitayaActions", "b", "", "revertFiltersLength", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "timeoutDelay", "getTimeoutDelay", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("from_pitaya")
            private final Boolean fromPitaya;

            @SerializedName("leave_timeout")
            private final Long leaveTimeout;

            @SerializedName("page_name")
            private final List<String> pageName;

            @SerializedName("pitaya_actions")
            private final Boolean pitayaActions;

            @SerializedName("revert_filters_length")
            private final Integer revertFiltersLength;

            @SerializedName("timeout_delay")
            private final Long timeoutDelay;

            public a() {
                this(null);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L18;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.fromPitaya, r101.fromPitaya) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.leaveTimeout, r101.leaveTimeout) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.pitayaActions, r101.pitayaActions) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.revertFiltersLength, r101.revertFiltersLength) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.timeoutDelay, r101.timeoutDelay) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public final int hashCode() {
                Boolean r100 = this.fromPitaya;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                Long r104 = this.leaveTimeout;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                List<String> r107 = this.pageName;
                if (r107 == null) goto L13;
                int r108 = r107.hashCode();
            L14:
                int r109 = (r106 + r108) * 31;
                Boolean r110 = this.pitayaActions;
                if (r110 == null) goto L17;
                int r111 = r110.hashCode();
            L18:
                int r112 = (r109 + r111) * 31;
                Integer r113 = this.revertFiltersLength;
                if (r113 == null) goto L21;
                int r114 = r113.hashCode();
            L22:
                int r115 = (r112 + r114) * 31;
                Long r116 = this.timeoutDelay;
                if (r116 == null) goto L26;
                r101 = r116.hashCode();
            L26:
                return r115 + r101;
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
            L13:
                r108 = 0;
                goto L14
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "GulRefreshConfig(fromPitaya=" + this.fromPitaya + ", leaveTimeout=" + this.leaveTimeout + ", pageName=" + this.pageName + ", pitayaActions=" + this.pitayaActions + ", revertFiltersLength=" + this.revertFiltersLength + ", timeoutDelay=" + this.timeoutDelay + ")";
            }

            public final Boolean b() {
                return this.pitayaActions;
            }

            public final Integer c() {
                return this.revertFiltersLength;
            }

            public a(Object r100) {
                this.fromPitaya = null;
                this.leaveTimeout = null;
                this.pageName = null;
                this.pitayaActions = null;
                this.revertFiltersLength = null;
                this.timeoutDelay = null;
            }

            public final Long a(String r100) {
                if (r100 != null) goto L5;
                return null;
            L5:
                List<String> r101 = this.pageName;
                if (r101 != null) goto L8;
            L12:
                return null;
            L8:
                if (r101.contains(r100) != true) goto L12;
                return this.leaveTimeout;
            }

            public final boolean d(String r100) {
                if (r100 != null) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.fromPitaya, Boolean.TRUE) == false) goto L13;
                List<String> r101 = this.pageName;
                if (r101 != null) goto L10;
                return false;
            L10:
                if (r101.contains(r100) != true) goto L15;
                return true;
            L15:
                return false;
            L13:
                return false;
            }
        }

        public static a a() {
            return (a) ECMallGulRefresh.f176903g.getValue();
        }
    }

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECMallGulRefresh f176910a;

        public a(ECMallGulRefresh r100) {
            this.f176910a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f176910a.f176908e.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECMallGulRefresh f176911a;

        public b(ECMallGulRefresh r100) {
            this.f176911a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = this.f176911a.f176904a;     // Catch: Throwable -> L10
            monitor-enter(r100);     // Catch: Throwable -> L10
            this.f176911a.f176907d = VideoEventOneOutSync.END_TYPE_FINISH;     // Catch: Throwable -> L7
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
        f176903g = LazyKt.lazy(ECMallGulRefresh$Companion$gulRefreshConfig$2.INSTANCE);
    }

    public final void a() {
        Object r100 = this.f176904a;
        monitor-enter(r100);
        this.f176906c.removeCallbacks(this.f176908e);     // Catch: Throwable -> L7
        this.f176907d = "init";     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r100 = this.f176904a;
        monitor-enter(r100);
        this.f176907d = VideoEventOneOutSync.END_TYPE_FINISH;     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Object r100 = this.f176904a;
        monitor-enter(r100);
        this.f176907d = "running";     // Catch: Throwable -> L7
        this.f176906c.removeCallbacks(this.f176908e);     // Catch: Throwable -> L7
        this.f176906c.postDelayed(new a(this), 16000);     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ECMallGulRefresh(boolean r100, Long r101) {
        this.f176909f = r100;
        this.f176904a = new Object();
        this.f176906c = new Handler(Looper.getMainLooper());
        this.f176907d = "init";
        this.f176908e = new b(this);
    }
}
