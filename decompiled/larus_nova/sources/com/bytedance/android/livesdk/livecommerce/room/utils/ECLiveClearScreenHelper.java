package com.bytedance.android.livesdk.livecommerce.room.utils;

import android.os.SystemClock;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.i;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveClearScreenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f151898a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f151899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f151900b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f151899a == r101.f151899a) goto L8;
            return false;
        L8:
            if (this.f151900b == r101.f151900b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f151899a * 31;
            long r101 = this.f151900b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "ClearScreenAction(state=" + this.f151899a + ", timeStamp=" + this.f151900b + ")";
        }

        public a(int r100, long r101) {
            this.f151899a = r100;
            this.f151900b = r101;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(final int r100, final String r101, final String r102) {
        int r103 = RoomContextController.f151593h;
        com.bytedance.android.livesdk.livecommerce.room.api.c r104 = RoomContextController.a.b(r101, r102).J();
        if (r104 == null) goto L5;
        r104.b(r100);
    L5:
        ECContext r105 = RoomContextController.a.b(r101, r102).r();
        if (r105 == null) goto L10;
        i<fk2.b> r106 = r105.getEcLiveRoomDurationMonitor();
        if (r106 == null) goto L10;
        final fk2.b r107 = r106.getValue();
    L11:
        long r108 = SystemClock.elapsedRealtime();
        a r109 = new a(r100, r108);
        Function0<Unit> r110 = new ECLiveClearScreenHelper$onFullDialogHoverStateChanged$2(r101, r102, r100, r107);
        a r111 = f151898a;
        if (r111 != null) goto L14;
    L21:
        boolean r112 = false;
    L22:
        if (r112 == true) goto L24;
        r110.invoke();
    L24:
        f151898a = r109;
        return;
    L14:
        if (r100 != r111.f151899a) goto L21;
        long r113 = r108 - r111.f151900b;
        if (0 > r113) goto L21;
        if (1000 < r113) goto L21;
        r112 = true;
    L10:
        r107 = null;
        goto L11
    }
}
