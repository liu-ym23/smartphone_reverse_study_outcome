package com.bytedance.android.shopping.anchorv4.helper;

import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpIndexActionHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Map<String, IAction> f166917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f166918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f166919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f166920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f166921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function3<IAction, View, com.bytedance.android.ecom.arch.slice.g, Unit> f166922f;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PdpIndexActionHelper(Function3<? super IAction, ? super View, ? super com.bytedance.android.ecom.arch.slice.g, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "actionTrigger");
        this.f166922f = r100;
        this.f166917a = new LinkedHashMap();
        this.f166919c = LazyKt.lazy(PdpIndexActionHelper$pendingTrackItemList$2.INSTANCE);
    }

    public final void update(Map<String, ? extends IAction> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f166917a = MapsKt.toMutableMap(r100);
        UIUtils.e(new s(this));
    }

    public final void b(final String r100, final String r101, final boolean r110) {
        final boolean r102 = !this.f166917a.isEmpty();
        b2.b(new PdpIndexActionHelper$reportMonitorEvent$1(this, r100, r101, r110, r102));
    }

    public final boolean a(String r100, String r101, View r102, com.bytedance.android.ecom.arch.slice.g r103) {
        Intrinsics.checkNotNullParameter(r100, "indexName");
        Intrinsics.checkNotNullParameter(r101, "indexType");
        IAction r104 = this.f166917a.get(r100);
        if (r104 == null) goto L5;
        this.f166922f.invoke(r104, r102, r103);
        return true;
    L5:
        if ((!this.f166917a.isEmpty()) == false) goto L7;
    L12:
        b(r100, r101, false);
        return false;
    L7:
        if (Intrinsics.areEqual(r101, "click") == false) goto L10;
        this.f166920d++;
        this.f166918b = new j(r100, r101, r102, r103);
        goto L12
    L10:
        if (Intrinsics.areEqual(r101, GXTemplateKey.GAIAX_TRACK) == false) goto L12;
        this.f166921e++;
        ((List) this.f166919c.getValue()).add(new j(r100, r101, r102, r103));
        goto L12
    }
}
