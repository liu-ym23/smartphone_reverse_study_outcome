package com.bytedance.android.livesdk.gamesticker.hok;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/gamesticker/hok/HokGameMoneyView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/livesdk/gamesticker/hok/e;", "Lcom/bytedance/android/livesdk/chatroom/model/k2;", "moneyCount", "", "setMoneyCount", "Landroid/view/View;", "getView", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getMoneyFirstView", "()Landroid/widget/TextView;", "moneyFirstView", "b", "getMoneyDividerView", "()Landroid/view/View;", "moneyDividerView", "c", "getMoneySecondView", "moneySecondView", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HokGameMoneyView extends ConstraintLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f125546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f125547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f125548c;

    public HokGameMoneyView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HokGameMoneyView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getMoneyDividerView() {
        return (View) this.f125547b.getValue();
    }

    private final TextView getMoneyFirstView() {
        return (TextView) this.f125546a.getValue();
    }

    private final TextView getMoneySecondView() {
        return (TextView) this.f125548c.getValue();
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public final void D2() {
        setMoneyCount(null);
    }

    @Override // com.bytedance.android.livesdk.gamesticker.hok.e
    public View getView() {
        return this;
    }

    public final void setMoneyCount(k2 r100) {
        if (r100 != null) goto L6;
        setVisibility(8);
        return;
    L6:
        String r101 = r100.a();
        String r102 = r100.b();
        boolean r103 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r104 = true;
    L14:
        if (r104 == true) goto L23;
        if (r102 != null) goto L17;
    L20:
        boolean r105 = true;
    L21:
        if (r105 == true) goto L23;
        setVisibility(0);
        int r106 = g.f125606a;
        g.a(getMoneyFirstView().getPaint(), 400);
        g.a(getMoneySecondView().getPaint(), 400);
        getMoneyFirstView().setText(r102);
        getMoneySecondView().setText(r101);
        getMoneyDividerView().setVisibility(0);
        getMoneyFirstView().setVisibility(0);
        getMoneySecondView().setVisibility(0);
        return;
    L17:
        if (r102.length() == 0) goto L20;
        r105 = false;
    L23:
        if (r101 != null) goto L25;
    L28:
        boolean r107 = true;
    L29:
        if (r107 == true) goto L31;
        setVisibility(0);
        int r108 = g.f125606a;
        g.a(getMoneySecondView().getPaint(), 400);
        getMoneySecondView().setText(r101);
        getMoneyDividerView().setVisibility(8);
        getMoneyFirstView().setVisibility(8);
        getMoneySecondView().setVisibility(0);
        return;
    L31:
        if (r102 != null) goto L33;
    L36:
        if (r103 == true) goto L41;
        setVisibility(0);
        int r109 = g.f125606a;
        g.a(getMoneySecondView().getPaint(), 400);
        getMoneySecondView().setText(r102);
        getMoneyDividerView().setVisibility(8);
        getMoneyFirstView().setVisibility(8);
        getMoneySecondView().setVisibility(0);
        return;
    L41:
        return;
    L33:
        if (r102.length() == 0) goto L36;
        r103 = false;
        goto L36
    L25:
        if (r101.length() == 0) goto L28;
        r107 = false;
        goto L29
    L9:
        if (r101.length() == 0) goto L12;
        r104 = false;
        goto L14
    }

    public HokGameMoneyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f125546a = LazyKt.lazy(new HokGameMoneyView$moneyFirstView$2(this));
        this.f125547b = LazyKt.lazy(new HokGameMoneyView$moneyDividerView$2(this));
        this.f125548c = LazyKt.lazy(new HokGameMoneyView$moneySecondView$2(this));
        LayoutInflater.from(r100).inflate(R.layout.ttlive_game_hok_money_view, this);
    }

    public /* synthetic */ HokGameMoneyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
