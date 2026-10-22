package com.bytedance.android.livesdk.livecommerce.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListFragment;
import com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomCouponListViewModel;
import com.larus.nova.R;
import fh2.o;

/* JADX INFO: loaded from: classes10.dex */
public abstract class ECHostNoCouponLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f153159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f153160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f153161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f153162d;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECHostNoCouponLayout f153163a;

        public a(ECHostNoCouponLayout r100) {
            this.f153163a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f153163a.f153162d;
            if (r101 == null) goto L6;
            LiveRoomCouponListFragment r102 = ((o) r101).f476983a;
            int r103 = LiveRoomCouponListFragment.f147680x;
            ((LiveRoomCouponListViewModel) r102.f147650g).bindCoupon(r102.getFragmentManager());
            return;
        }
    }

    public interface b {
    }

    public abstract TextView a(View r100);

    public abstract TextView b(View r100);

    public TextView getBindCouponTextView() {
        return this.f153160b;
    }

    public ECHostNoCouponLayout(Context r100) {
        super(r100);
        c(r100);
    }

    public final void c(Context r100) {
        ScrollView r101 = new ScrollView(r100);
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r101.setFillViewport(true);
        addView(r101);
        View r102 = View.inflate(r100, R.layout.ec_layout_no_coupon_douyin, r101);
        this.f153159a = r102;
        this.f153160b = b(r102);
        this.f153161c = a(this.f153159a);
        TextView r103 = this.f153160b;
        if (r103 == null) goto L6;
        r103.setOnClickListener(new a(this));
        return;
    }

    public void setBindCouponClickListener(b r100) {
        this.f153162d = r100;
    }

    public void setBindNotice(String r100) {
        TextView r101 = this.f153161c;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    public ECHostNoCouponLayout(Context r100, AttributeSet r101) {
        super(r100, r101);
        c(r100);
    }

    public ECHostNoCouponLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        c(r100);
    }
}
