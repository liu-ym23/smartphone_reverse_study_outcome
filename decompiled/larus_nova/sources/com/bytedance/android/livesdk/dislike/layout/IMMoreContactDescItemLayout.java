package com.bytedance.android.livesdk.dislike.layout;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nt1.c;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/dislike/layout/IMMoreContactDescItemLayout;", "Landroid/widget/LinearLayout;", "Lnt1/c;", "vo", "", "update", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IMMoreContactDescItemLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f122133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f122134b;

    public IMMoreContactDescItemLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IMMoreContactDescItemLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void update(c r100) {
        Intrinsics.checkNotNullParameter(r100, "vo");
        ImageView r101 = this.f122134b;
        if (r101 == null) goto L5;
        r101.setImageResource(r100.f520467a);
    L5:
        TextView r102 = this.f122133a;
        if (r102 == null) goto L8;
        r102.setText(getContext().getResources().getText(r100.f520468b));
    L8:
        String r103 = r100.f520469c;
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.length() <= 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 != true) goto L20;
        TextView r105 = this.f122133a;
        if (r105 == null) goto L21;
        r105.setText(r100.f520469c);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        r104 = false;
        goto L14
    }

    public IMMoreContactDescItemLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.ttlive_dialog_long_press_im_more_desc, this);
        TextView r103 = (TextView) findViewById(R.id.desc);
        this.f122133a = r103;
        this.f122134b = (ImageView) findViewById(R.id.icon);
        if (r103 == null) goto L7;
        TextPaint r104 = r103.getPaint();
        if (r104 == null) goto L7;
        r104.setFakeBoldText(false);
    L7:
        setPadding(UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(10), UtilityKotlinExtentionsKt.i(16), UtilityKotlinExtentionsKt.i(10));
        setGravity(16);
    }

    public /* synthetic */ IMMoreContactDescItemLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
