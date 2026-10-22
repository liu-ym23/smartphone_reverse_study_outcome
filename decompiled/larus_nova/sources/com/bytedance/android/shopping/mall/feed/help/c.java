package com.bytedance.android.shopping.mall.feed.help;

import android.view.View;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EventExposureTime f176980a;

    public c(EventExposureTime r100) {
        this.f176980a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        EventExposureTime r101 = this.f176980a;
        r101.f176914b = System.currentTimeMillis();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Iterator<T> r101 = this.f176980a.f176913a.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        BaseViewHolder r102 = (BaseViewHolder) r101.next();
        if (Intrinsics.areEqual((Boolean) ((LinkedHashMap) this.f176980a.f176922j).get(r102), Boolean.TRUE) == false) goto L4;
        this.f176980a.f176922j.put(r102, Boolean.FALSE);
        ECHybridListItemVO r103 = r102.f47152c;
        if (r103 == null) goto L10;
        r103.N = System.currentTimeMillis();
    L10:
        JSONObject r104 = this.f176980a.i(r102);
        if (r104 == null) goto L4;
        AppLogNewUtils.onEventV3("show_ecom_card_time", r104);
        goto L4
    L13:
        EventExposureTime r105 = this.f176980a;
        r105.l(r105.f176914b, System.currentTimeMillis());
    }
}
