package com.bytedance.android.livesdk.dislike.tip;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.longpresspanel.ItemConfig;
import com.bytedance.android.live.core.log.g;
import com.bytedance.android.livesdk.config.ne0;
import com.bytedance.android.livesdk.config.setting.l;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService;
import com.bytedance.android.livesdkapi.model.LiveOptRecommendHintConfig;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements ILiveOptRecommendHintService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f122233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f122234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f122235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f122236d;

    public b() {
        this(true);
    }

    public final boolean a() {
        LiveOptRecommendHintConfig r100 = ne0.f120826a.getValue();
        Object r101 = null;
        if (this.f122236d == false) goto L12;
        Iterator<T> r102 = l.b().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((ItemConfig) r103).getIdentity(), "opt_recommend") == false) goto L6;
        r101 = r103;
    L10:
        if (r101 != null) goto L19;
    L20:
        boolean r104 = false;
    L21:
        if (r104 == true) goto L23;
        return false;
    L23:
        if (r100.getTipEnable() == true) goto L25;
        return false;
    L25:
        if (r100.getTipAbVersion() > 0) goto L27;
        return false;
    L27:
        if (r100.getTipShowMaxTime() > 0) goto L29;
        return false;
    L29:
        if (r100.getSkipRoomLimit() <= 1) goto L42;
        return true;
    L42:
        return false;
    L19:
        r104 = true;
        goto L21
    L12:
        Iterator<T> r105 = l.a().iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(((ItemConfig) r106).getIdentity(), "opt_recommend") == false) goto L14;
        r101 = r106;
    L18:
        if (r101 == null) goto L20;
        goto L19
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService
    public final LiveOptRecommendHintConfig getConfig() {
        return ne0.f120826a.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService
    public final void markOptRecommendTipShow() {
        b("markOptRecommendTipShow");
        int r100 = a.e().getInt("key_optimize_recommend_tip_show_times", 0) + 1;
        a.e().storeInt("key_optimize_recommend_tip_show_times", r100);
        if (TextUtils.equals(a.c(), a.f()) == true) goto L6;
        a.e().storeString("key_optimize_recommend_tip_show_last_date", a.f());
    L6:
        this.f122234b.clear();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService
    public final void updateOptRecommendUsedDate() {
        b("updateOptRecommendUsedDate");
        if (TextUtils.equals(a.a(), a.f()) == true) goto L6;
        a.e().storeString("key_optimize_recommend_use_last_date", a.f());
    L6:
        this.f122234b.clear();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService
    public final boolean canShowOptRecommendTip() {
        if (a() == true) goto L5;
        return false;
    L5:
        ne0 r100 = ne0.f120826a;
        LiveOptRecommendHintConfig r101 = r100.getValue();
        int r102 = a.e().getInt("key_optimize_recommend_ab_version", 0);
        if (r101.getTipAbVersion() <= 0) goto L17;
        if (r101.getTipAbVersion() <= r102) goto L17;
        b("ab_version update: " + r102 + " -> " + r101.getTipAbVersion());
        a.e().storeInt("key_optimize_recommend_ab_version", r101.getTipAbVersion());
        if (r101.getTipShowTimesReset() == false) goto L14;
        a.e().storeInt("key_optimize_recommend_tip_show_times", 0);
        b("tip show times reset");
    L14:
        if (r101.getTipShowDateReset() == false) goto L17;
        a.e().storeString("key_optimize_recommend_tip_show_last_date", "");
        b("tip show date reset");
    L17:
        if (this.f122234b.size() < r100.getValue().getSkipRoomLimit()) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == true) goto L24;
        b("累计跳过的roomId" + this.f122234b);
        return false;
    L24:
        if (a.b() < this.f122235c) goto L26;
        boolean r104 = true;
    L27:
        if (r104 == true) goto L31;
        b("上次使用优化推荐日期" + a.a());
        return false;
    L31:
        if (a.d() < r100.getValue().getTipShowInterval()) goto L33;
        boolean r105 = true;
    L34:
        if (r105 == true) goto L38;
        b("上次展现tip日期" + a.c());
        return false;
    L38:
        if (a.e().getInt("key_optimize_recommend_tip_show_times", 0) < r100.getValue().getTipShowMaxTime()) goto L40;
        boolean r106 = true;
    L41:
        if (r106 == false) goto L44;
        b("tip累计展现" + a.e().getInt("key_optimize_recommend_tip_show_times", 0));
        return false;
    L44:
        b("last_use_date:" + a.a() + " , last_use_interval:" + a.b() + ", last_tip_date:" + a.c() + ", last_tip_interval:" + a.d() + ", tip_show_times:" + a.e().getInt("key_optimize_recommend_tip_show_times", 0));
        return true;
    L40:
        r106 = false;
        goto L41
    L33:
        r105 = false;
        goto L34
    L26:
        r104 = false;
        goto L27
    L19:
        r103 = false;
        goto L20
    }

    public b(boolean r100) {
        this.f122236d = r100;
        this.f122233a = "optimize_recommend_tip";
        this.f122234b = new LinkedHashSet();
        this.f122235c = 14;
    }

    public final void b(String r100) {
        b0 r101 = b0.o();
        String r102 = this.f122233a;
        r101.getClass();
        g.i(r102, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveOptRecommendHintService
    public final void recordSkipRoom(long r100) {
        if (a() == true) goto L6;
        return;
    L6:
        if (r100 > 0) goto L8;
        return;
    L8:
        this.f122234b.add(String.valueOf(r100));
    }
}
