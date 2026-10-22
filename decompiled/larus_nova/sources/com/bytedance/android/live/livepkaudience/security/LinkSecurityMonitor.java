package com.bytedance.android.live.livepkaudience.security;

import android.util.Log;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.live.datacontext.i;
import com.ss.texturerender.VideoSurfaceTexture;
import dl0.n;
import hd0.c;
import io.reactivex.disposables.CompositeDisposable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class LinkSecurityMonitor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f82243c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f82244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Integer> f82245b;

    public static final class a {
    }

    public static final class b extends ThreadLocal<DateFormat> {
        @Override // java.lang.ThreadLocal
        public final DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.CHINA);
        }

        public b() {
        }
    }

    static {
    }

    public abstract boolean b();

    public LinkSecurityMonitor() {
        new CompositeDisposable();
        this.f82244a = new b();
        this.f82245b = SetsKt.setOf(new Integer[]{1, 2, 3, 4});
    }

    public final void a(Map<String, String> r100) {
        if (b() == true) goto L5;
        return;
    L5:
        r100.put("scene", String.valueOf(n.a()));
        r100.put(FastStartLiveConfig.PLAY_MODE, "[normal]");
        r100.put("stack_track", Log.getStackTraceString(new Throwable()));
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L13;
        i<Boolean> r102 = r101.isAnchor();
        if (r102 == null) goto L13;
        if (r102.getValue().booleanValue() != true) goto L13;
        String r103 = "anchor";
    L16:
        r100.put("role", r103);
        r100.put("is_self_singer", "false");
        return;
    L13:
        if (c.f().h() == false) goto L15;
        r103 = "guest";
        goto L16
    L15:
        r103 = "user";
        goto L16
    }

    public final void c(String r110, Map<String, String> r111, com.bytedance.android.live.core.privacy.av.api.b r112, com.bytedance.android.live.core.privacy.av.api.a r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r111);
        DateFormat r100 = this.f82244a.get();
        if (r100 == null) goto L8;
        String r101 = r100.format(new Date());
    L9:
        String r102 = String.valueOf(r101);
        Intrinsics.checkNotNullParameter("revenue_pk", "biz");
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r102, VideoSurfaceTexture.KEY_TIME);
        q60.a.f531757d.d("revenue_pk", r110, r111, r112, r113);
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void d(String r110, Map<String, String> r111, com.bytedance.android.live.core.privacy.av.api.b r112, com.bytedance.android.live.core.privacy.av.api.a r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r111);
        DateFormat r100 = this.f82244a.get();
        if (r100 == null) goto L8;
        String r101 = r100.format(new Date());
    L9:
        String r102 = String.valueOf(r101);
        Intrinsics.checkNotNullParameter("revenue_pk", "biz");
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r102, VideoSurfaceTexture.KEY_TIME);
        q60.a.f531757d.c("revenue_pk", r110, r111, r112, r113);
        return;
    L8:
        r101 = null;
        goto L9
    }

    public final void e(String r110, Map<String, String> r111, com.bytedance.android.live.core.privacy.av.api.b r112, com.bytedance.android.live.core.privacy.av.api.a r113) {
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Intrinsics.checkNotNullParameter(r113, "config");
        if (b() == true) goto L5;
        return;
    L5:
        a(r111);
        DateFormat r100 = this.f82244a.get();
        if (r100 == null) goto L8;
        String r101 = r100.format(new Date());
    L9:
        String r102 = String.valueOf(r101);
        Intrinsics.checkNotNullParameter("revenue_pk", "biz");
        Intrinsics.checkNotNullParameter(r110, "sense");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r102, VideoSurfaceTexture.KEY_TIME);
        q60.a.f531757d.e("revenue_pk", r110, r111, r112, r113);
        return;
    L8:
        r101 = null;
        goto L9
    }
}
