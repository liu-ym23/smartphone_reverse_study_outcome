package com.bytedance.android.shopping.yata.biz.popup.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes14.dex */
public final class e implements hl3.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f187567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f187568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f187569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f187570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final hl3.a f187571e;

    @Override // hl3.c
    public final View getView() {
        return (FrameLayout) this.f187568b.getValue();
    }

    @Override // hl3.c
    public final void release() {
        l r100 = this.f187567a;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    @Override // hl3.d
    public Context getContext() {
        return this.f187569c;
    }

    @Override // hl3.d
    public final void a(JSONObject r100) {
        Intrinsics.checkNotNullParameter("pageVisibilityChange", "eventName");
        l r101 = this.f187567a;
        if (r101 == null) goto L6;
        r101.sendJsEvent("pageVisibilityChange", r100);
        return;
    }

    @Override // hl3.c
    public final void b(il3.a r110, b r111) {
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r111, "firstCallback");
        r111.run();
        String r112 = UriProtector.getQueryParameter(UriProtector.parse(this.f187570d), "url");
        if (r112 != null) goto L5;
    L7:
        r112 = null;
    L8:
        if (r112 != null) goto L10;
        r112 = "";
    L10:
        Context r100 = getContext();
        l r113 = ECLiveHybridUtil.b(r100, r112, null, (FrameLayout) this.f187568b.getValue(), new d(this), null, null, false, null, null, false, 4068);
        if (r113 == null) goto L16;
        this.f187567a = r113;
        boolean r101 = ((Boolean) r110.a("split_mode", Boolean.FALSE)).booleanValue();
        int r102 = ((Number) r110.a("ec_split_screen_width", 0)).intValue();
        int r114 = ((Number) r110.a("ec_split_screen_height", 0)).intValue();
        if (r101 == false) goto L17;
        r113.updateScreenMetrics(r102, r114);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        if (k.c(r112) == false) goto L7;
        goto L7
    }

    public e(Context r100, String r101, com.bytedance.android.shopping.yata.biz.popup.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "schema");
        this.f187569c = r100;
        this.f187570d = r101;
        this.f187571e = r102;
        this.f187568b = LazyKt.lazy(new PopupLiveHybridComponent$parentView$2(this));
    }
}
