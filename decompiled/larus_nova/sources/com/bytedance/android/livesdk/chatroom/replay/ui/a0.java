package com.bytedance.android.livesdk.chatroom.replay.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VideoResolutionItem;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a0 extends LinearLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f110241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f110242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f110243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f110244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f110245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f110246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f110247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public VideoResolutionItem f110248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f110249i;

    public static final class a {
    }

    public interface b {
        void Ga(VideoResolutionItem r100);

        void Tn();
    }

    static {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 != null) goto L4;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getId() == R.id.resolution_name) goto L10;
        return;
    L10:
        if (this.f110247g == false) goto L18;
        VideoResolutionItem r101 = this.f110248h;
        if (r101 == null) goto L19;
        this.f110249i.Ga(r101);
        return;
    L19:
        return;
    L18:
        return;
    L4:
        if (r100.getId() != R.id.close_btn) goto L6;
        this.f110249i.Tn();
    }

    public a0(Context r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "switchCallback");
        super(r100);
        this.f110249i = r101;
        View r102 = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_replay_switch_resolution_hint_layout, this, true);
        this.f110242b = (ImageView) r102.findViewById(R.id.close_btn);
        this.f110244d = (TextView) r102.findViewById(R.id.hint_prefix);
        this.f110243c = (TextView) r102.findViewById(R.id.switch_hint_postfix);
        this.f110245e = (TextView) r102.findViewById(R.id.resolution_name);
        this.f110246f = r102.findViewById(R.id.resolution_icon);
        Unit r103 = Unit.INSTANCE;
        this.f110241a = r102;
        ImageView r104 = this.f110242b;
        if (r104 == null) goto L5;
        r104.setOnClickListener(this);
    L5:
        TextView r105 = this.f110245e;
        if (r105 == null) goto L9;
        r105.setOnClickListener(this);
        return;
    }
}
