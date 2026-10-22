package com.bytedance.android.livesdk.live;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.g41;
import com.bytedance.android.livesdk.slideuptip.LiveSlideUpTipsGuideStrategy;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class LiveInnerCommonController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f147254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f147255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f147256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f147257d;

    public static final class a {
    }

    static {
    }

    public final LiveSlideUpTipsGuideStrategy a() {
        return (LiveSlideUpTipsGuideStrategy) this.f147257d.getValue();
    }

    public final boolean c() {
        if (((g41) this.f147254a.getValue()).b() == true) goto L5;
        return false;
    L5:
        String r100 = this.f147255b + '-' + this.f147256c;
        if (r100 == null) goto L37;
        String r101 = r100.toLowerCase();
        g41 r102 = (g41) this.f147254a.getValue();
        if (r102 == null) goto L35;
        List<String> r103 = r102.c();
        if (r103 == null) goto L35;
        if ((!r103.isEmpty()) == true) goto L15;
        r103 = null;
    L15:
        if (r103 == null) goto L35;
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L35;
        String r105 = (String) r104.next();
        if (Intrinsics.areEqual(r105, r101) == true) goto L21;
        if (Intrinsics.areEqual(r105, "*") == true) goto L24;
        if (StringsKt.startsWith$default(r105, "*", false, 2, null) == false) goto L31;
        if (StringsKt.endsWith$default(r101, StringsKt.replace$default(r105, "*", "", false, 4, null), false, 2, null) == false) goto L31;
        return true;
    L31:
        if (StringsKt.endsWith$default(r105, "*", false, 2, null) == false) goto L18;
        if (StringsKt.startsWith$default(r101, StringsKt.replace$default(r105, "*", "", false, 4, null), false, 2, null) == false) goto L18;
        return true;
    L24:
        return true;
    L21:
        return true;
    L35:
        return false;
    L37:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public LiveInnerCommonController() {
        this.f147254a = LazyKt.lazy(LiveInnerCommonController$config$2.INSTANCE);
        this.f147257d = LazyKt.lazy(LiveInnerCommonController$liveSlideUpTipsGuideStrategyProxy$2.INSTANCE);
    }

    public final boolean b(ILiveRoomPlayFragment r100, String r101) {
        boolean r102 = false;
        if (c() == false) goto L19;
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L10:
        if (r103 == true) goto L19;
        if (r100 == null) goto L18;
        Fragment r104 = r100.getFragment();
        if (r104 == null) goto L18;
        Bundle r105 = r104.getArguments();
        if (r105 == null) goto L18;
        r102 = r105.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_INNER_FEED_IS_ENTER_ROOM, false);
    L18:
        ALogger.i("LiveInnerCommonController", "isFirstClickRoom: " + r102);
        goto L19
    L6:
        if (r101.length() == 0) goto L9;
        r103 = false;
    L19:
        return r102;
    }

    public final void d(int r100, boolean r101) {
        LiveSlideUpTipsGuideStrategy r102 = a();
        r102.f158375i = true;
        if (r101 == true) goto L5;
        r102.f158376j = false;
        r102.f158380n = false;
        r102.c("onPageSelected");
    L5:
        LiveSlideUpTipsGuideStrategy.b("onPageSelected, position: " + r100 + ", isFirstRun: " + r101 + ", isLiveGuideWidgetShown: " + r102.f158380n);
        r102.f158377k = r100;
    }
}
