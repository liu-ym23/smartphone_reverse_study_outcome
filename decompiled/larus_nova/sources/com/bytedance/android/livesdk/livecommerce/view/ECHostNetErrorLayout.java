package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ECHostNetErrorLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View.OnClickListener f153157b;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHostNetErrorLayout f153158a;

        public a(ECHostNetErrorLayout r100) {
            this.f153158a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            View.OnClickListener r101 = this.f153158a.f153157b;
            if (r101 == null) goto L6;
            r101.onClick(r100);
            return;
        }
    }

    public abstract TextView a();

    public abstract int getGrayColor();

    public ECHostNetErrorLayout(Context r100) {
        super(r100);
        b(r100);
    }

    public final void b(Context r100) {
        LayoutInflater r101 = LayoutInflater.from(r100);
        this.f153156a = r101.inflate(R.layout.ec_layout_net_error_douyin, (ECHostNetErrorLayoutImpl) this, true);
        TextView r102 = a();
        if (r102 == null) goto L6;
        r102.setOnClickListener(new a(this));
        return;
    }

    public void setBackgroundGray(boolean r100) {
        if (r100 == false) goto L4;
        setBackgroundColor(getGrayColor());
        return;
    L4:
        setBackgroundColor(-1);
    }

    public void setRetryClickListener(View.OnClickListener r100) {
        this.f153157b = r100;
    }

    public ECHostNetErrorLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r100);
    }

    public ECHostNetErrorLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r100);
    }
}
