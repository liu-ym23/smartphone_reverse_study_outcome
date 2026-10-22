package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ttnet.org.chromium.net.NetError;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboBottomAnimationView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboBottomAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f128608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f128609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f128610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f128611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f128612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f128613f;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f128614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ComboBottomAnimationView f128615b;

        public b(View r100, ComboBottomAnimationView r101) {
            this.f128614a = r100;
            this.f128615b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComboBottomAnimationView r100 = this.f128615b;     // Catch: Throwable -> L4
            r100.f128612e = true;     // Catch: Throwable -> L4
            r100.f128613f = this.f128614a.getHeight();     // Catch: Throwable -> L4
            this.f128614a.setTranslationY(this.f128615b.f128613f);     // Catch: Throwable -> L4
            this.f128614a.setVisibility(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboBottomAnimationView f128616a;

        public c(ComboBottomAnimationView r100) {
            this.f128616a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            LottieAnimationView r102 = new LottieAnimationView(this.f128616a.getContext());
            FrameLayout r103 = (FrameLayout) this.f128616a.a(R.id.combo_bottom_effect_container);
            if (r103 == null) goto L5;
            r103.addView(r102);
        L5:
            this.f128616a.post(new com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.a(this, r102));
            r102.playAnimation();
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f128617a = null;

        static {
            f128617a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f128618a = null;

        static {
            f128618a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    static {
    }

    public ComboBottomAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ComboBottomAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final View a(int r100) {
        if (this.f128608a != null) goto L5;
        this.f128608a = new LinkedHashMap();
    L5:
        View r101 = this.f128608a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f128608a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void b(int r100) {
        if (r100 >= 188) goto L18;
        Disposable r101 = this.f128609b;
        if (r101 == null) goto L7;
        r101.dispose();
    L7:
        this.f128610c = false;
        this.f128611d = false;
        this.f128612e = false;
        FrameLayout r102 = (FrameLayout) a(R.id.combo_bottom_effect_container);
        if (r102 == null) goto L10;
        r102.removeAllViews();
    L10:
        View r103 = a(R.id.combo_bottom_bg);
        if (r103 == null) goto L13;
        r103.setVisibility(4);
    L13:
        View r104 = a(R.id.combo_bottom_bg);
        if (r104 == null) goto L40;
        r104.setTranslationY(0.0f);
        return;
    L40:
        return;
    L18:
        if (188 > r100) goto L29;
        if (520 < r100) goto L29;
        if (this.f128612e == true) goto L26;
        View r105 = a(R.id.combo_bottom_bg);
        if (r105 == null) goto L26;
        r105.post(new b(r105, this));
    L26:
        int r106 = r100 + NetError.ERR_TTNET_SPECIFIED_NETWORK_UNAVAILABLE_FOR_DNS;
        float r107 = this.f128613f;
        float r108 = r107 - ((r106 / 332) * r107);
        View r109 = a(R.id.combo_bottom_bg);
        if (r109 == null) goto L29;
        r109.setTranslationY(r108);
    L29:
        boolean r110 = this.f128610c;
        if (r110 == true) goto L33;
        if (r100 < 520) goto L33;
        this.f128610c = true;
        c(3000);
        return;
    L33:
        if (r110 == true) goto L35;
        return;
    L35:
        if (this.f128611d == false) goto L37;
        return;
    L37:
        if (r100 < 1314) goto L44;
        this.f128611d = true;
        c(2000);
        return;
    }

    public final void c(long r100) {
        Disposable r101 = this.f128609b;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        j.a r102 = j.f66356a;
        this.f128609b = j.a(0, r100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), d.f128617a, e.f128618a);
    }

    public ComboBottomAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f128608a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_base_gift_combo_bottom_animation_view, this);
    }

    public /* synthetic */ ComboBottomAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
