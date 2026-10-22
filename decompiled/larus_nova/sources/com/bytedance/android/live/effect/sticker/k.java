package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.ies.sdk.widgets.priority.PriorityModule;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import gd0.v;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f68198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f68199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f68200k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f68201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Long> f68202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<Effect> f68203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, Effect> f68204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f68205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f68206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f68207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f68208h;

    public static final class a {
        public a() {
        }

        public static boolean a() {
            if (LiveEffectSettings.LIVE_ENABLE_MULTI_ANCHOR_EFFECT_SHARE.getValue().booleanValue() == true) goto L5;
        L7:
            return false;
        L5:
            if (k.f68198i == false) goto L7;
            return true;
        }

        public static String b() {
            int r100 = k.f68199j;
            if (r100 > 0) goto L7;
            return "0";
        L7:
            if (v.a(r100, 4) == false) goto L9;
            return PbRequest.SwitchType.PK;
        L9:
            if (v.a(k.f68199j, 16) == true) goto L15;
            return PriorityModule.SCENE_MULTI;
        L15:
            return PbRequest.SwitchType.PK;
        }
    }

    public interface b {
        void a(List<? extends Effect> r100);
    }

    static {
        f68200k = new a();
    }

    public final void a() {
        int r100 = this.f68205e + 1;
        this.f68205e = r100;
        List<Long> r101 = this.f68202b;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == r101.size()) goto L7;
        return;
    L7:
        if (f68198i == true) goto L9;
        return;
    L9:
        this.f68203c.clear();
        List<Long> r102 = this.f68202b;
        if (r102 == null) goto L18;
        List<Long> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        long r106 = ((Number) r105.next()).longValue();
        r104.add(this.f68204d.get(String.valueOf(r106)));
        goto L13
    L15:
        List r107 = CollectionsKt.filterNotNull(r104);
        if (r107 == null) goto L18;
        this.f68203c.addAll(r107);
    L18:
        this.f68206f.a(this.f68203c);
    }

    public k(com.bytedance.android.live.effect.beauty.sticker.e r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mOnMultiAnchorEffectLoadListener");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        this.f68206f = r100;
        this.f68207g = r101;
        this.f68208h = r102;
        this.f68203c = new ArrayList();
        this.f68204d = new HashMap();
    }
}
