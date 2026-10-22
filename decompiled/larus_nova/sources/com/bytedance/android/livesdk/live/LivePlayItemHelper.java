package com.bytedance.android.livesdk.live;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.personalfeed.PersonalizedFeedUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class LivePlayItemHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f147258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f147259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f147260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f147261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f147262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f147263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f147264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f147265h;

    public static final class a {
    }

    static {
    }

    public LivePlayItemHelper() {
        this.f147260c = "";
        this.f147263f = LazyKt.lazy(LivePlayItemHelper$optStopRoom$2.INSTANCE);
        this.f147264g = LazyKt.lazy(LivePlayItemHelper$optDetailStopRoom$2.INSTANCE);
        this.f147265h = LazyKt.lazy(LivePlayItemHelper$optStopRoomNotLimitScene$2.INSTANCE);
    }

    public final boolean a(Activity r100) {
        ALogger.i("LivePlayItemHelper", "canInterceptRoomStop roomId:" + this.f147260c + ", isInRoom:" + this.f147259b + ", optStopRoom:" + ((Boolean) this.f147263f.getValue()) + ", act:" + r100);
        if (this.f147258a == false) goto L5;
        return false;
    L5:
        if (r100 != null) goto L8;
        return false;
    L8:
        if (b(r100) == true) goto L20;
        if (((Boolean) this.f147264g.getValue()).booleanValue() == true) goto L12;
    L14:
        boolean r101 = false;
    L15:
        ALogger.i("LivePlayItemHelper", "isDetailActivityMode, isDetailPreview:" + r101);
        if (r101 == true) goto L20;
        return false;
    L12:
        if (Intrinsics.areEqual(r100.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.detail.ui.DetailActivity") == false) goto L14;
        r101 = true;
    L20:
        return !this.f147259b;
    }

    public final boolean b(Activity r100) {
        boolean r101 = false;
        if (((Boolean) this.f147263f.getValue()).booleanValue() == true) goto L5;
    L30:
        ALogger.i("LivePlayItemHelper", "isLiveActivityMode, liveMode:" + r101 + ", isPersonalRoom:" + this.f147261d + ", isConsumed:" + this.f147262e);
        return r101;
    L5:
        if (Intrinsics.areEqual(r100.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivity") == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L30;
        if (PersonalizedFeedUtils.b().f() == true) goto L15;
    L20:
        boolean r103 = true;
    L21:
        if (r103 == false) goto L23;
    L29:
        r101 = true;
        goto L30
    L23:
        if (((Boolean) this.f147265h.getValue()).booleanValue() == true) goto L25;
    L27:
        boolean r104 = false;
    L28:
        if (r104 == false) goto L30;
    L25:
        if (this.f147262e == true) goto L27;
        r104 = true;
        goto L28
    L15:
        if (this.f147261d == true) goto L17;
    L19:
        r103 = false;
        goto L21
    L17:
        if (this.f147262e == true) goto L19;
    L7:
        if (Intrinsics.areEqual(r100.getClass().getCanonicalName(), "com.ss.android.ugc.aweme.live.LivePlayActivityV2") == true) goto L10;
        r102 = false;
        goto L11
    }
}
