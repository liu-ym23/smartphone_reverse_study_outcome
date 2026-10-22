package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/view/combo/ComboEffectAnimationView;", "Landroid/widget/FrameLayout;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "I", "getCombo", "()I", "setCombo", "(I)V", "combo", "Lio/reactivex/disposables/Disposable;", "b", "Lio/reactivex/disposables/Disposable;", "getDisposable", "()Lio/reactivex/disposables/Disposable;", "setDisposable", "(Lio/reactivex/disposables/Disposable;)V", "disposable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComboEffectAnimationView extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f128619c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f128620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f128621b;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ComboEffectAnimationView f128622a;

        public b(ComboEffectAnimationView r100) {
            this.f128622a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            ComboEffectAnimationView r102 = this.f128622a;
            int r103 = ComboEffectAnimationView.f128619c;
            r102.getClass();
            Ref.ObjectRef r104 = new Ref.ObjectRef();
            r104.element = "combo/ttlive_gift_combo_effect_level4.json";
            int r105 = r102.f128620a;
            if (1 > r105) goto L9;
            if (66 < r105) goto L9;
            r104.element = "combo/ttlive_gift_combo_effect_level1.json";
        L26:
            LottieAnimationView r106 = new LottieAnimationView(r102.getContext());
            r102.addView(r106);
            r102.post(new b02.b(r102, r106, r104));
            return;
        L9:
            if (67 > r105) goto L15;
            if (188 < r105) goto L15;
            r104.element = "combo/ttlive_gift_combo_effect_level2.json";
        L15:
            if (189 > r105) goto L21;
            if (520 < r105) goto L21;
            r104.element = "combo/ttlive_gift_combo_effect_level3.json";
        L21:
            if (521 > r105) goto L26;
            if (1314 < r105) goto L26;
            r104.element = "combo/ttlive_gift_combo_effect_level4.json";
            goto L26
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f128623a = null;

        static {
            f128623a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    public static final class d implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f128624a = null;

        static {
            f128624a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    static {
    }

    public ComboEffectAnimationView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ComboEffectAnimationView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getCombo() {
        return this.f128620a;
    }

    public final Disposable getDisposable() {
        return this.f128621b;
    }

    public final void a(int r100) {
        this.f128620a = r100;
        if (r100 != 0) goto L5;
        Disposable r101 = this.f128621b;
        if (r101 == null) goto L17;
        r101.dispose();
        return;
    L17:
        return;
    L5:
        if (r100 != 1) goto L7;
        b(2000);
        return;
    L7:
        if (r100 != 1315) goto L18;
        b(1000);
        return;
    }

    public final void b(long r100) {
        Disposable r101 = this.f128621b;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        j.a r102 = j.f66356a;
        this.f128621b = j.a(0, r100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), c.f128623a, d.f128624a);
    }

    public final void setCombo(int r100) {
        this.f128620a = r100;
    }

    public final void setDisposable(Disposable r100) {
        this.f128621b = r100;
    }

    public ComboEffectAnimationView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ComboEffectAnimationView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
