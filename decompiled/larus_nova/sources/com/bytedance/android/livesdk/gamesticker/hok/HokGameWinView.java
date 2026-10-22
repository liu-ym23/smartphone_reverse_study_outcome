package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.chatroom.model.b2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0011\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameWinView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/b2;", "liveInfo", "", "setLiveInfo", "Landroid/view/View;", "getView", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getWinRateView", "()Landroid/widget/TextView;", "winRateView", "b", "getWinStreakView", "winStreakView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameWinView extends ConstraintLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125566b;

    public HokGameWinView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HokGameWinView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final TextView getWinRateView() {
        return (TextView) this.f125565a.getValue();
    }

    private final TextView getWinStreakView() {
        return (TextView) this.f125566b.getValue();
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setLiveInfo(null);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    public final void setLiveInfo(b2 r100) {
        if (r100 != null) goto L5;
        setVisibility(8);
        return;
    L5:
        Integer r101 = r100.b();
        if (r101 == null) goto L11;
        if (r101.intValue() != 0) goto L11;
    L14:
        setVisibility(0);
        R5(getWinStreakView(), "");
        R5(getWinRateView(), "");
        return;
    L11:
        if (r100.b() == null) goto L14;
        R5(getWinStreakView(), r100.c());
        R5(getWinRateView(), r100.a());
    }

    public final void R5(TextView r100, String r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        setVisibility(0);
        int r103 = g.f125606a;
        g.a(r100.getPaint(), 400);
        r100.setText(r101);
        r100.setVisibility(0);
        return;
    L11:
        r100.setVisibility(8);
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public HokGameWinView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125565a = LazyKt.lazy(new HokGameWinView$winRateView$2(this));
        this.f125566b = LazyKt.lazy(new HokGameWinView$winStreakView$2(this));
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_hok_win_view, this);
    }

    public /* synthetic */ HokGameWinView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
