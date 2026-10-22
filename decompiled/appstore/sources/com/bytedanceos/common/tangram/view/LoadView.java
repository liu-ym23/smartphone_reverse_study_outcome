package com.bytedanceos.common.tangram.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedanceos.common.R$color;
import com.bytedanceos.common.R$dimen;
import com.bytedanceos.common.R$drawable;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.tangram.Bind;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;

/* JADX INFO: loaded from: classes2.dex */
public class LoadView extends RelativeLayout implements Bind<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProgressBar f9952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f9953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BaseCell f9954c;

    public LoadView(Context r10) {
        this(r10, null);
    }

    private void e() {
        f();
        c();
        b();
        a();
    }

    private void setProgressVisible(boolean r10) {
        ProgressBar r11 = this.f9952a;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    private void setTextVisible(boolean r10) {
        TextView r11 = this.f9953b;
        if (r10 == false) goto L5;
        int r12 = 0;
    L6:
        r11.setVisibility(r12);
        return;
    L5:
        r12 = 8;
        goto L6
    }

    public final void a() {
        ImageView r10 = new ImageView(getContext());
        r10.setImageResource(R$drawable.line);
        r10.setScaleType(ImageView.ScaleType.FIT_XY);
        RelativeLayout.LayoutParams r11 = new RelativeLayout.LayoutParams(-1, -2);
        r11.addRule(10);
        addView(r10, r11);
    }

    public final void b() {
        if (this.f9952a != null) goto L6;
        this.f9952a = new ProgressBar(getContext());
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-2, getResources().getDimensionPixelSize(R$dimen.LOAD_MORE_HEIGHT) - 2);
        r10.topMargin = 2;
        r10.addRule(13);
        addView(this.f9952a, r10);
        return;
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public /* bridge */ /* synthetic */ void bindData(Integer r10, BaseCell r11) {
        d(r10, r11);
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void bindStyle(Style r10, BaseCell r11) {
    }

    public final void c() {
        if (this.f9953b != null) goto L9;
        this.f9953b = new TextView(getContext());
        RelativeLayout.LayoutParams r10 = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R$dimen.LOAD_MORE_HEIGHT) - 2);
        r10.topMargin = 2;
        addView(this.f9953b, r10);
        this.f9953b.setGravity(17);
        if (getContext().getResources() == null) goto L7;
        this.f9953b.setTextColor(getContext().getResources().getColor(R$color.footer_text));
    L7:
        this.f9953b.setTextSize(2, 13.5f);
        this.f9953b.setBackgroundResource(R$drawable.app_list_selector);
        return;
    }

    public void d(Integer r10, BaseCell r11) {
        int r12 = r11.optIntParam("load_type");
        this.f9954c = r11;
        setLoadType(r12);
    }

    public final void f() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    }

    public void setLoadType(int r10) {
        BaseCell r11 = this.f9954c;
        if (r11 == null) goto L9;
        r11.extras.put("load_type", r10);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
    L9:
        if (r10 == 0) goto L15;
        if (r10 == 1) goto L15;
        if (r10 != 2) goto L23;
        setTextVisible(false);
        setProgressVisible(true);
        return;
    L23:
        return;
    L15:
        setTextVisible(true);
        setProgressVisible(false);
        TextView r12 = this.f9953b;
        if (r10 != 0) goto L18;
        int r13 = R$string.LOAD_MORE;
    L19:
        r12.setText(r13);
        return;
    L18:
        r13 = R$string.LOAD_RETRY;
        goto L19
    }

    @Override // com.bytedanceos.common.tangram.Bind
    public void unBind() {
    }

    public LoadView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    public LoadView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        e();
    }
}
