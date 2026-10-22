package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.x0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f143521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f143522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Switch f143523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.tuningpanel.ability.a f143524d;

    private final ec0.a getTuningMusicControl() {
        return (ec0.a) this.f143521a.getValue();
    }

    public static final /* synthetic */ ec0.a a(a r100) {
        return r100.getTuningMusicControl();
    }

    public a(com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100, Context r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = false;
        super(r101, null, 0);
        this.f143524d = r100;
        this.f143521a = LazyKt.lazy(CellularEnhancementView$tuningMusicControl$2.INSTANCE);
        View r103 = LayoutInflater.from(r101).inflate(R.layout.ttlive_ktv_common_switch_button_item_layout, this, true);
        r103.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        TextView r104 = (TextView) r103.findViewById(R.id.btn_list_item_title);
        FrameLayout r105 = (FrameLayout) r103.findViewById(R.id.btn_list_item_switch_container);
        this.f143522b = r105;
        Switch r106 = (Switch) r103.findViewById(R.id.btn_list_item_switch);
        this.f143523c = r106;
        if (r104 == null) goto L5;
        r104.setText(s1.B(R.string.ttlive_ktv_cellular_enhancement));
    L5:
        if (r106 == null) goto L11;
        if (r100 != null) goto L8;
    L10:
        r106.setChecked(r102);
        goto L11
    L8:
        if (r100.p() != true) goto L10;
        r102 = true;
    L11:
        if (r105 == null) goto L14;
        r105.setOnClickListener(x0.a(new CellularEnhancementView$1(this)));
        return;
    }
}
