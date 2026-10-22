package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0017J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/TitleScoreView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "getLayoutId", "", com.bytedance.android.ec.core.event.a.KEY_SCORE, "", "setScore", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TitleScoreView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f55749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f55750b;

    public TitleScoreView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TitleScoreView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public int getLayoutId() {
        return R.layout.gamecp_game_title_score_view;
    }

    public final void setScore(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_SCORE);
        TextView r101 = this.f55749a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public TitleScoreView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = View.inflate(r100, getLayoutId(), this);
        this.f55750b = r103;
        if (r103 == null) goto L5;
        TextView r104 = (TextView) r103.findViewById(R.id.tv_title_score);
    L6:
        this.f55749a = r104;
        return;
    L5:
        r104 = null;
        goto L6
    }

    public /* synthetic */ TitleScoreView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
