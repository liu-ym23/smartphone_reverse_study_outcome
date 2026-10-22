package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.video;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.api.video.AVScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f181552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f181553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f181554c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f181555d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u f181556e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f181557f;

    public final boolean a() {
        if (this.f181554c.f181581d != AVScene.CONTENT_PRODUCT_DETAIL_HEADER) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.f181552a;
    }

    public l(Context r100, ViewGroup r101, x r102, y r103, u r104, Map<String, ? extends Object> r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "playerConfig");
        Intrinsics.checkNotNullParameter(r103, "uiConfig");
        this.f181552a = r100;
        this.f181553b = r101;
        this.f181554c = r102;
        this.f181555d = r103;
        this.f181556e = r104;
        this.f181557f = r105;
    }
}
