package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/widget/LiveSportScoreBoardView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSportScoreBoardView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f161081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f161082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f161083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f161084d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f161085e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f161086f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f161087g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HSImageView f161088h;

    public LiveSportScoreBoardView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_score_board_style, this, true);
        this.f161082b = (TextView) findViewById(R.id.team_a_name);
        this.f161083c = (TextView) findViewById(R.id.team_b_name);
        this.f161084d = (TextView) findViewById(R.id.team_a_score);
        this.f161085e = (TextView) findViewById(R.id.team_b_score);
        this.f161086f = (TextView) findViewById(R.id.match_info);
        this.f161087g = (HSImageView) findViewById(R.id.team_a_icon);
        this.f161088h = (HSImageView) findViewById(R.id.team_b_icon);
        this.f161081a = (HSImageView) findViewById(R.id.scoreboard_background);
    }

    public LiveSportScoreBoardView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_score_board_style, this, true);
        this.f161082b = (TextView) findViewById(R.id.team_a_name);
        this.f161083c = (TextView) findViewById(R.id.team_b_name);
        this.f161084d = (TextView) findViewById(R.id.team_a_score);
        this.f161085e = (TextView) findViewById(R.id.team_b_score);
        this.f161086f = (TextView) findViewById(R.id.match_info);
        this.f161087g = (HSImageView) findViewById(R.id.team_a_icon);
        this.f161088h = (HSImageView) findViewById(R.id.team_b_icon);
        this.f161081a = (HSImageView) findViewById(R.id.scoreboard_background);
    }

    public LiveSportScoreBoardView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_score_board_style, this, true);
        this.f161082b = (TextView) findViewById(R.id.team_a_name);
        this.f161083c = (TextView) findViewById(R.id.team_b_name);
        this.f161084d = (TextView) findViewById(R.id.team_a_score);
        this.f161085e = (TextView) findViewById(R.id.team_b_score);
        this.f161086f = (TextView) findViewById(R.id.match_info);
        this.f161087g = (HSImageView) findViewById(R.id.team_a_icon);
        this.f161088h = (HSImageView) findViewById(R.id.team_b_icon);
        this.f161081a = (HSImageView) findViewById(R.id.scoreboard_background);
    }
}
