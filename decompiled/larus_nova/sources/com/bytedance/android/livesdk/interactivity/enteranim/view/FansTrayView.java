package com.bytedance.android.livesdk.interactivity.enteranim.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;

/* JADX INFO: loaded from: classes9.dex */
public class FansTrayView extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static float f136831d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f136832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f136833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f136834c;

    public FansTrayView(Context r100) {
        this(r100, null);
    }

    private void setTextContent(k32.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f136833b.setText(getContext().getString(R.string.ttlive_enter_room, new Object[]{r100.f501685b}));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        r100.getId();
    }

    public FansTrayView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FansTrayView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        LinearLayout.inflate(getContext(), R.layout.ttlive_fans_tray_view, this);
        this.f136832a = (LinearLayout) findViewById(R.id.tray_team_level);
        this.f136833b = (TextView) findViewById(R.id.tv_user_name);
        this.f136834c = (ViewGroup) findViewById(R.id.honor_tag_view);
        TextView r103 = (TextView) findViewById(R.id.tv_team_name);
        this.f136832a.setOnClickListener(this);
        this.f136833b.setOnClickListener(this);
        if (f136831d <= 0.0f) goto L5;
    L8:
        setGravity(16);
        return;
    L5:
        if (getContext() == null) goto L10;
        Resources r104 = getContext().getResources();
        f136831d = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics()).density / 3.0f;
        goto L8
    }
}
