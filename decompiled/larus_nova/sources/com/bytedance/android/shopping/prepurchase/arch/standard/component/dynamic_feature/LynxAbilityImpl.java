package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.anchorv4.helper.w;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.o;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class LynxAbilityImpl implements com.bytedance.android.shopping.prepurchase.arch.container.ability.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<ti.j, f> f180928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DynamicFeatureComponent.b f180930c;

    public static final class a implements ti.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f180931a;

        public a(Function1 r100) {
            this.f180931a = r100;
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f180931a.invoke(r100);
        }
    }

    public final l p(o r110) {
        Intrinsics.checkNotNullParameter(r110, "option");
        Context r100 = r110.getContext();
        String r101 = r110.f180709b;
        Map<String, Object> r102 = r110.f180711d;
        ViewGroup r103 = r110.f180710c;
        boolean r111 = r110.f180712e;
        l r104 = ECLiveHybridUtil.b(r100, r101, r102, r103, r110.f180713f, null, null, false, null, null, r111, 2016);
        if (r104 == null) goto L5;
        w.a.e(w.f166998b, r104, r110.getContext(), Boolean.valueOf(this.f180930c.a()), 8);
        return r104;
    L5:
        return null;
    }

    public LynxAbilityImpl(String r100, DynamicFeatureComponent.b r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f180929b = r100;
        this.f180930c = r101;
        this.f180928a = new HashMap(30);
    }

    public final void B(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        ECLiveHybridUtil.f(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    public final void F0(String r100, ti.j r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        f r102 = (f) ((HashMap) this.f180928a).remove(r101);
        if (r102 == null) goto L8;
        ti.j r103 = r102.f180940b;
        if (r103 == null) goto L8;
        r101 = r103;
    L8:
        ECLiveHybridUtil.p(r100, r101);
    }

    public final void h0(String r100, boolean r101, Function1<? super JSONObject, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        l0(r100, r101, new a(r102));
    }

    public final void l0(final String r100, final boolean r101, final ti.j r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r102, "subscriber");
        com.bytedance.android.shopping.prepurchase.arch.utils.a.a(new LynxAbilityImpl$registerLynxHandler$1(this, r101, r102, r100));
    }
}
