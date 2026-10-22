package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0014\u0010\u0016\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/GameDetailErrorView;", "Landroid/widget/LinearLayout;", "", "msg", "", "setMsgText", "", "color", "setMsgTextColor", "", "size", "setMsgTextSize", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageRes", "setRetryButtonBackground", "setRetryButtonTextColor", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", "setImageLayoutParams", "Lkotlin/Function0;", "action", "setOnRetryClickListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailErrorView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f55670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f55671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f55672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f55673d;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GameDetailErrorView f55674a;

        public a(GameDetailErrorView r100) {
            this.f55674a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f55674a.f55673d.invoke();
        }
    }

    public GameDetailErrorView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameDetailErrorView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setImageLayoutParams(LinearLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutParams");
        ImageView r101 = this.f55672c;
        if (r101 == null) goto L6;
        r101.setLayoutParams(r100);
        return;
    }

    public final void setImageRes(Drawable r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        ImageView r101 = this.f55672c;
        if (r101 == null) goto L6;
        r101.setImageDrawable(r100);
        return;
    }

    public final void setMsgText(String r100) {
        TextView r101 = this.f55670a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public final void setMsgTextColor(int r100) {
        TextView r101 = this.f55670a;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public final void setMsgTextSize(float r100) {
        TextView r101 = this.f55670a;
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        return;
    }

    public final void setOnRetryClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f55673d = r100;
    }

    public final void setRetryButtonBackground(Drawable r100) {
        TextView r101 = this.f55671b;
        if (r101 == null) goto L6;
        r101.setBackground(r100);
        return;
    }

    public final void setRetryButtonTextColor(int r100) {
        TextView r101 = this.f55671b;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public GameDetailErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f55673d = GameDetailErrorView$mAction$1.INSTANCE;
        View r103 = LayoutInflater.from(r100).inflate(R.layout.gamecp_error_view_game_promote_list_v2, this, false);
        this.f55670a = (TextView) r103.findViewById(R.id.tv_game_promote_common_error_msg);
        TextView r104 = (TextView) r103.findViewById(R.id.tv_game_promote_list_retry);
        this.f55671b = r104;
        this.f55672c = (ImageView) r103.findViewById(R.id.iv_game_promote_common_error_image);
        if (r104 == null) goto L5;
        r104.setOnClickListener(new a(this));
    L5:
        addView(r103);
    }

    public /* synthetic */ GameDetailErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
