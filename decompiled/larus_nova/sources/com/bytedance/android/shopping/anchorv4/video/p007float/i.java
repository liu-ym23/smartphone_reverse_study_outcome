package com.bytedance.android.shopping.anchorv4.video.p007float;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.api.video.AVScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV4VM f167617a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f167618b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f167619c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f167620d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final x f167621e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public t f167622f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, Object> f167623g;

    public final boolean a() {
        if (this.f167620d.f167654d != AVScene.CONTENT_PRODUCT_DETAIL_HEADER) goto L5;
        return true;
    L5:
        return false;
    }

    public final Context getContext() {
        return this.f167618b;
    }

    public i(AnchorV4VM r100, Context r101, ViewGroup r102, w r103, x r104, t r105, Map<String, ? extends Object> r106) {
        Intrinsics.checkNotNullParameter(r100, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r103, "playerConfig");
        Intrinsics.checkNotNullParameter(r104, "uiConfig");
        this.f167617a = r100;
        this.f167618b = r101;
        this.f167619c = r102;
        this.f167620d = r103;
        this.f167621e = r104;
        this.f167622f = r105;
        this.f167623g = r106;
    }
}
