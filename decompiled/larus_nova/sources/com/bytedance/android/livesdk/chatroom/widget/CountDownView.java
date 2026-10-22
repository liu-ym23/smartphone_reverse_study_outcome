package com.bytedance.android.livesdk.chatroom.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class CountDownView extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f118472h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Animation f118473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f118474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f118475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f118476d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f118477e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f118478f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f118479g;

    public class a implements Observer<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f118480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CountDownView f118481b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f118482c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f118483d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CountDownView f118484e;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            CountDownView.a(this.f118484e);
            if (this.f118482c == false) goto L6;
            CountDownView r100 = this.f118484e;
            String r101 = String.valueOf(System.currentTimeMillis() - this.f118483d.longValue());
            r100.getClass();
            HashMap r102 = new HashMap();
            r102.put("duration", r101);
            com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_room_countdown_duration", r102, new Object[0]);
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            CountDownView.a(this.f118484e);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Long r100) {
            Long r101 = r100;
            Logger.d("LiveCountDownView start", r101.toString());
            this.f118484e.f118474b.setText(String.valueOf(r101));
            if (this.f118484e.f118478f == false) goto L10;
            if (r101.equals(Long.valueOf(this.f118480a)) == false) goto L7;
            CharSequence r102 = "倒计时" + this.f118484e.f118474b.getText();
        L8:
            this.f118481b.setContentDescription(r102);
            this.f118484e.f118474b.setContentDescription(r102);
            r3.g(this.f118481b, r102);
            goto L10
        L7:
            r102 = this.f118484e.f118474b.getText();
        L10:
            if (r101.longValue() >= 2) goto L12;
            this.f118484e.f118473a.setAnimationListener(new q(this));
        L12:
            this.f118484e.f118473a.reset();
            CountDownView r103 = this.f118484e;
            r103.f118474b.startAnimation(r103.f118473a);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f118484e.f118479g = r100;
        }

        public a(CountDownView r100, long r101, CountDownView r102, boolean r103, Long r104) {
            this.f118484e = r100;
            this.f118480a = r101;
            this.f118481b = r102;
            this.f118482c = r103;
            this.f118483d = r104;
        }
    }

    public interface b {
        void a();
    }

    public CountDownView(Context r100) {
        super(r100);
        this.f118478f = false;
        this.f118479g = null;
        b(null, 0);
    }

    public static void a(final CountDownView r100) {
        r100.getClass();
        r100.post(new p(r100));
        b r101 = r100.f118476d;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        Disposable r102 = r100.f118479g;
        if (r102 == null) goto L9;
        r102.dispose();
        r100.f118479g = null;
        return;
    }

    public final void c(boolean r110) {
        Long r100 = Long.valueOf(System.currentTimeMillis());
        setFocusableInTouchMode(true);
        r3.p(this);
        final long r101 = ((long) this.f118477e) / 1000;
        Observable.interval(0, 1000, TimeUnit.MILLISECONDS).take(r101 - 1).map(new o(r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r101, this, r110, r100));
        if (r110 == false) goto L6;
        String r111 = String.valueOf(System.currentTimeMillis() - com.bytedance.android.livesdk.sharedpref.b.f158162j.getValue().longValue());
        HashMap r102 = new HashMap();
        r102.put("duration", r111);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_room_countdown_loading_duration", r102, new Object[0]);
        return;
    }

    public void setCountDownListener(b r100) {
        this.f118476d = r100;
    }

    public void setNeedAccessibility(boolean r100) {
        this.f118478f = r100;
    }

    public void setSubText(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (this.f118475c != null) goto L8;
        TextView r101 = new TextView(getContext());
        this.f118475c = r101;
        r101.setTextColor(getResources().getColor(R.color.ttlive_core_hs_s5));
        this.f118475c.setTextSize(1, 15.0f);
        this.f118475c.setGravity(17);
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        r102.gravity = 81;
        r102.bottomMargin = (int) UIUtils.dip2Px(getContext(), 20.0f);
        addView(this.f118475c, r102);
    L8:
        this.f118475c.setVisibility(0);
        this.f118475c.setText(r100);
    }

    public CountDownView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f118478f = false;
        this.f118479g = null;
        b(r101, 0);
    }

    public final void b(AttributeSet r100, int r101) {
        TypedArray r102 = getContext().obtainStyledAttributes(r100, new int[]{R.attr.count_down}, r101, 0);
        this.f118477e = r102.getInteger(0, 4000);
        r102.recycle();
        Context r103 = getContext();
        TextView r104 = new TextView(getContext());
        this.f118474b = r104;
        r104.setTextColor(getResources().getColor(R.color.ttlive_core_hs_s5));
        this.f118474b.setTextSize(1, 60.0f);
        this.f118474b.setGravity(17);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 17;
        addView(this.f118474b, r105);
        setFocusable(true);
        setClickable(true);
        this.f118473a = AnimationUtils.loadAnimation(r103, R.anim.ttlive_count_down);
    }

    public CountDownView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f118478f = false;
        this.f118479g = null;
        b(r101, r102);
    }
}
