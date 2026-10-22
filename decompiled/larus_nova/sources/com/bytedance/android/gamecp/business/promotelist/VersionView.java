package com.bytedance.android.gamecp.business.promotelist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/gamecp/business/promotelist/VersionView;", "Landroid/widget/LinearLayout;", "", "", "version", "", "setVersion", "", "textSize", "setTextSize", "", "textColorRes", "setTextColorRes", "height", "setFootDivideHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VersionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f56252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f56253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f56254c;

    public VersionView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VersionView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        UtilityKotlinExtentionsKt.k(findViewById(R.id.divider), false);
    }

    public final void b(String r100) {
        TextView r101 = this.f56254c;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        TextView r102 = this.f56254c;
        if (r102 == null) goto L9;
        r102.setText(r100);
        return;
    }

    public void setFootDivideHeight(int r100) {
        View r101 = this.f56253b;
        if (r101 == null) goto L8;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L9;
        r102.height = r100;
        return;
    L9:
        return;
    }

    public final void setTextColorRes(int r100) {
        int r101 = y0.c(r100);
        TextView r102 = this.f56252a;
        if (r102 == null) goto L5;
        r102.setTextColor(r101);
    L5:
        View r103 = this.f56253b;
        if (r103 == null) goto L9;
        r103.setBackgroundColor(r101);
        return;
    }

    public final void setTextSize(float r100) {
        TextView r101 = this.f56252a;
        if (r101 == null) goto L5;
        r101.setTextSize(1, r100);
    L5:
        TextView r102 = this.f56254c;
        if (r102 == null) goto L9;
        r102.setTextSize(1, r100);
        return;
    }

    public final void setVersion(String r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        TextView r101 = this.f56252a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public VersionView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.gamecp_promote_list_version, this);
        setGravity(16);
        this.f56252a = (TextView) findViewById(R.id.tv_game_version);
        this.f56253b = findViewById(R.id.divider);
        this.f56254c = (TextView) findViewById(R.id.tv_title);
    }

    public /* synthetic */ VersionView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
