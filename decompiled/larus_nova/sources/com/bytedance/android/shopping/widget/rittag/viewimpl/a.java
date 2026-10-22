package com.bytedance.android.shopping.widget.rittag.viewimpl;

import android.content.Context;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.ec.model.response.RitTagUI;
import com.bytedance.android.shopping.widget.rittag.RitTagPart;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends ECDraweeView implements com.bytedance.android.shopping.widget.rittag.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187468a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.widget.rittag.viewimpl.a$a, reason: collision with other inner class name */
    public static final class C2744a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final View i() {
        return this;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0, 6, null);
        setAdjustMode(1);
    }

    @Override // com.bytedance.android.shopping.widget.rittag.b
    public final void l(RitTagUI.RitTagUIItem r110, RitTagPart r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "part");
        h0.d(this, r110.getImage(), null, null, null, null, null, 120);
    }
}
