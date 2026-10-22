package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class g extends LinearLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f61619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f61620b;

    public final ImageView getIcon() {
        return this.f61619a;
    }

    public final TextView getText() {
        return this.f61620b;
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.e
    public void setColor(int r100) {
        this.f61620b.setTextColor(r100);
        this.f61619a.getDrawable().setColorFilter(r100, PorterDuff.Mode.SRC_IN);
    }

    public g(Context r100, ImageView r101, TextView r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r102, "text");
        super(r100);
        this.f61619a = r101;
        this.f61620b = r102;
        setGravity(16);
        setOrientation(0);
        addView(r102);
        addView(r101);
    }
}
