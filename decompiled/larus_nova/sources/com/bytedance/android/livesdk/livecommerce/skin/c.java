package com.bytedance.android.livesdk.livecommerce.skin;

import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, ECLiveLayoutConfig> f152972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f152973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f152974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f152975d;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Boolean a() {
        Map<String, ECLiveLayoutConfig> r100 = this.f152972a;
        if (r100 == null) goto L7;
        ECLiveLayoutConfig r101 = r100.get("button_area");
        if (r101 == null) goto L7;
        return r101.getWidthSelfAdapt();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> b() {
        return l("cover");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> c() {
        Pair<Integer, Integer> r100 = l("add_cart_button");
        if (this.f152973b == false) goto L23;
        if (this.f152974c == false) goto L7;
        int r101 = 24;
    L8:
        if (r100 == null) goto L11;
        Pair<Integer, Integer> r102 = Pair.copy$default(r100, Integer.valueOf(r101), null, 2, null);
        if (r102 == null) goto L11;
        return r102;
    L11:
        Pair<Integer, Integer> r103 = j();
        if (r103 == null) goto L17;
        Integer r104 = r103.getSecond();
        if (r104 == null) goto L17;
        int r105 = r104.intValue();
    L21:
        return TuplesKt.to(Integer.valueOf(r101), Integer.valueOf(r105));
    L17:
        if (this.f152974c == false) goto L19;
        r105 = 26;
        goto L21
    L19:
        r105 = 40;
        goto L21
    L7:
        r101 = 34;
        goto L8
    L23:
        return l("add_cart_button");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.b d() {
        Map<String, ECLiveLayoutConfig> r100 = this.f152972a;
        if (r100 == null) goto L8;
        ECLiveLayoutConfig r101 = r100.get("parent");
        if (r101 != null) goto L7;
        return null;
    L7:
        return new hl2.b(r101.getTopPadding(), r101.getBottomPadding(), r101.getLeftPadding(), r101.getRightPadding());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.b e() {
        Map<String, ECLiveLayoutConfig> r100 = this.f152972a;
        if (r100 == null) goto L8;
        ECLiveLayoutConfig r101 = r100.get("price");
        if (r101 != null) goto L7;
        return null;
    L7:
        return new hl2.b(r101.getTopPadding(), r101.getBottomPadding(), r101.getLeftPadding(), r101.getRightPadding());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.a f() {
        Map<String, ECLiveLayoutConfig> r100 = this.f152972a;
        if (r100 == null) goto L8;
        ECLiveLayoutConfig r101 = r100.get("parent");
        if (r101 != null) goto L7;
        return null;
    L7:
        return new hl2.a(r101.getTopMargin(), r101.getBottomMargin(), r101.getLeftMargin(), r101.getRightMargin());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.a g() {
        Map<String, ECLiveLayoutConfig> r100 = this.f152972a;
        if (r100 == null) goto L8;
        ECLiveLayoutConfig r101 = r100.get("title");
        if (r101 != null) goto L7;
        return null;
    L7:
        return new hl2.a(r101.getTopMargin(), r101.getBottomMargin(), r101.getLeftMargin(), r101.getRightMargin());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.a h() {
        Map<String, ECLiveLayoutConfig> r100 = this.f152972a;
        if (r100 == null) goto L8;
        ECLiveLayoutConfig r101 = r100.get("cover");
        if (r101 != null) goto L7;
        return null;
    L7:
        return new hl2.a(r101.getTopMargin(), r101.getBottomMargin(), r101.getLeftMargin(), r101.getRightMargin());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> i() {
        return l("button_area");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> j() {
        Pair<Integer, Integer> r100 = l("button");
        if (this.f152973b == true) goto L5;
        return r100;
    L5:
        if (this.f152974c == false) goto L7;
        int r101 = 42;
    L9:
        if (r100 != null) goto L11;
        return null;
    L11:
        return Pair.copy$default(r100, Integer.valueOf(r101), null, 2, null);
    L7:
        r101 = 63;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> k() {
        return l("stepper_icon");
    }

    public c(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutTypes");
        this.f152975d = r100;
        ECLiveSkinUtil.f152968l.getClass();
        this.f152972a = ECLiveSkinUtil.e("promotion_card", r100);
    }

    public final Pair<Integer, Integer> l(String r100) {
        Map<String, ECLiveLayoutConfig> r101 = this.f152972a;
        boolean r102 = false;
        if (r101 == null) goto L9;
        ECLiveLayoutConfig r103 = r101.get(r100);
        if (r103 == null) goto L9;
        Integer r104 = r103.getWidth();
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        Map<String, ECLiveLayoutConfig> r106 = this.f152972a;
        if (r106 == null) goto L17;
        ECLiveLayoutConfig r107 = r106.get(r100);
        if (r107 == null) goto L17;
        Integer r108 = r107.getHeight();
        if (r108 == null) goto L17;
        int r109 = r108.intValue();
    L18:
        if (r105 <= 0) goto L22;
        if (r109 <= 0) goto L22;
        r102 = true;
    L22:
        if (r102 == false) goto L24;
        c r110 = this;
    L25:
        if (r110 != null) goto L27;
        return null;
    L27:
        return new Pair(Integer.valueOf(r105), Integer.valueOf(r109));
    L24:
        r110 = null;
    L17:
        r109 = 0;
    L9:
        r105 = 0;
        goto L10
    }
}
