package com.bytedance.android.shopping.store.mall.follows.bridge;

import com.bytedance.android.ec.sdk.helper.d;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import fj.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "", "params", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECGetCardConfigBridge$1 extends Lambda implements Function1<Map<String, ? extends Object>, Map<String, ? extends Object>> {
    public static final ECGetCardConfigBridge$1 INSTANCE = null;

    static {
        INSTANCE = new ECGetCardConfigBridge$1();
    }

    public ECGetCardConfigBridge$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<String, Object> invoke2(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Pair[] r101 = new Pair[2];
        boolean r102 = false;
        r101[0] = TuplesKt.to("code", 1);
        JSONObject r103 = new JSONObject();
        a r104 = d.f48119b.getAudioMuteService();
        if (r104 == null) goto L5;
        r104.c();
    L6:
        r103.put("is_global_muted", r102);
        Unit r105 = Unit.INSTANCE;
        r101[1] = TuplesKt.to("result", r103);
        return MapsKt.mutableMapOf(r101);
    L5:
        r102 = true;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Map<String, ? extends Object> invoke(Map<String, ? extends Object> r100) {
        return invoke2(r100);
    }
}
