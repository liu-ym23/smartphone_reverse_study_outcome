package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.widget.VHeadView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\b\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/ui/TeamPkItemView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/revlink/impl/multianchor/ui/a;", "changeTeamSupportCallback", "", "setChangeTeamSupportCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TeamPkItemView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f94762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f94763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f94764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f94765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final VHeadView f94766e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f94767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f94768g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f94769h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f94770i;

    public TeamPkItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_team_pk_match_view_item, this);
        a1.j(this, 1);
        this.f94762a = (HSImageView) findViewById(R.id.image_avatar_bound);
        this.f94763b = (HSImageView) findViewById(R.id.image_avatar);
        this.f94764c = (TextView) findViewById(R.id.tv_nickname);
        this.f94765d = (TextView) findViewById(R.id.tv_status);
        this.f94766e = (VHeadView) findViewById(R.id.iv_close);
        this.f94767f = findViewById(R.id.change_team_click_area);
        this.f94768g = (HSImageView) findViewById(R.id.image_change_team);
        this.f94769h = (TextView) findViewById(R.id.tv_change_team);
    }

    public final void setChangeTeamSupportCallback(a r100) {
        this.f94770i = r100;
    }

    public TeamPkItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_team_pk_match_view_item, this);
        a1.j(this, 1);
        this.f94762a = (HSImageView) findViewById(R.id.image_avatar_bound);
        this.f94763b = (HSImageView) findViewById(R.id.image_avatar);
        this.f94764c = (TextView) findViewById(R.id.tv_nickname);
        this.f94765d = (TextView) findViewById(R.id.tv_status);
        this.f94766e = (VHeadView) findViewById(R.id.iv_close);
        this.f94767f = findViewById(R.id.change_team_click_area);
        this.f94768g = (HSImageView) findViewById(R.id.image_change_team);
        this.f94769h = (TextView) findViewById(R.id.tv_change_team);
    }

    public TeamPkItemView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_team_pk_match_view_item, this);
        a1.j(this, 1);
        this.f94762a = (HSImageView) findViewById(R.id.image_avatar_bound);
        this.f94763b = (HSImageView) findViewById(R.id.image_avatar);
        this.f94764c = (TextView) findViewById(R.id.tv_nickname);
        this.f94765d = (TextView) findViewById(R.id.tv_status);
        this.f94766e = (VHeadView) findViewById(R.id.iv_close);
        this.f94767f = findViewById(R.id.change_team_click_area);
        this.f94768g = (HSImageView) findViewById(R.id.image_change_team);
        this.f94769h = (TextView) findViewById(R.id.tv_change_team);
    }
}
