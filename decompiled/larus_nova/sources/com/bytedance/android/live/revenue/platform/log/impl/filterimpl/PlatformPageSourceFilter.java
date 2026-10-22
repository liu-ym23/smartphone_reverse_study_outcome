package com.bytedance.android.live.revenue.platform.log.impl.filterimpl;

import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mz0.f;

/* JADX INFO: loaded from: classes47.dex */
public final class PlatformPageSourceFilter extends a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f91482b;

    public final t p() {
        return (t) this.f91482b.getValue();
    }

    @Override // mz0.f
    public final String b() {
        Intrinsics.checkNotNullParameter(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID, "key");
        o<Object> r100 = this.f91483a;
        if ((r100 instanceof t) == false) goto L9;
        Map<String, String> r101 = ((t) r100).getMap();
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.get(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_ID);
    L9:
        return "";
    }

    @Override // mz0.f
    public final String getCommonParams() {
        Intrinsics.checkNotNullParameter("homepage_hot_scene", "key");
        o<Object> r100 = this.f91483a;
        if ((r100 instanceof t) == true) goto L5;
        return "";
    L5:
        return ((t) r100).h("homepage_hot_scene");
    }

    @Override // mz0.f
    public final String d() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.d();
    }

    @Override // mz0.f
    public final String e() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.e();
    }

    @Override // mz0.f
    public final String f() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    @Override // mz0.f
    public final String g() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.g();
    }

    @Override // mz0.f
    public final int getApplyType() {
        t r100 = p();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getApplyType();
    }

    @Override // mz0.f
    public final String getRoomTag() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRoomTag();
    }

    @Override // mz0.f
    public final boolean j() {
        t r100 = p();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.j();
    }

    @Override // mz0.f
    public final String k() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.k();
    }

    @Override // mz0.f
    public final String l() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.l();
    }

    @Override // mz0.f
    public final String m() {
        t r100 = p();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.m();
    }

    @Override // mz0.f
    public final boolean o() {
        t r100 = p();
        if (r100 == null) goto L7;
        r100.o();
        return false;
    L7:
        return false;
    }

    public PlatformPageSourceFilter(final o<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "filter");
        super(r100);
        this.f91482b = LazyKt.lazy(new PlatformPageSourceFilter$pageSourceFilter$2(r100));
    }
}
