package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.common.utility.Logger;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes45.dex */
public final class c extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f61286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f61287b;

    public static final class a {
    }

    public interface b {
    }

    static {
    }

    public final b getListener() {
        return null;
    }

    public final void setListener(b r100) {
    }

    public final View a() {
        if (this.f61286a != null) goto L5;
        this.f61286a = new LinkedHashMap();
    L5:
        Map<Integer, View> r100 = this.f61286a;
        LinkedHashMap r101 = (LinkedHashMap) r100;
        View r102 = (View) r101.get(Integer.valueOf(R.id.pay_amount));
        if (r102 != null) goto L12;
        View r103 = findViewById(R.id.pay_amount);
        if (r103 == null) goto L10;
        this.f61286a.put(Integer.valueOf(R.id.pay_amount), r103);
        return r103;
    L10:
        return null;
    L12:
        return r102;
    }

    public final View getView() {
        return this.f61287b;
    }

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f61286a = new LinkedHashMap();
        this.f61287b = View.inflate(r100, R.layout.ttlive_open_platform_anchor_panel_pay_msg_text, this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void j(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "endAction");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, fadeIn");
    L5:
        z.a(this.f61287b, 250, 0.0f, r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void k(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onHide");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, slideOut, " + this);
    L5:
        z.f(this.f61287b, r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void o(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "endAction");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, slideIn, " + this);
    L5:
        z.e(this.f61287b, r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void x(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onHide");
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
        Logger.d("PayFlowView", "FlowItemView, fadeOut, " + this);
    L5:
        z.c(this.f61287b, 250, 0.0f, r100);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.view.d
    public final void y(int r100, Function1<? super Integer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, "onTextWidthUpdated");
        ((TextView) a()).setText(Marker.ANY_NON_NULL_MARKER + r100);
        ((TextView) a()).measure(0, 0);
        r101.invoke(Integer.valueOf(((TextView) a()).getMeasuredWidth()));
    }
}
