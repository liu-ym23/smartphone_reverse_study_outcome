package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/SendDanmuMsgPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SendDanmuMsgPresenter extends DanmuPanelBasePresenter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f109115m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f109116n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f109117o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f109118p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Interpolator f109119q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f109120r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f109121s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f109122t;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendDanmuMsgPresenter f109123a;

        public a(SendDanmuMsgPresenter r100) {
            this.f109123a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f109123a.f109115m;     // Catch: Throwable -> L10
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("btnSend");     // Catch: Throwable -> L10
        L5:
            ViewGroup.LayoutParams r101 = r100.getLayoutParams();     // Catch: Throwable -> L10
            if (r101 == null) goto L9;
            ViewGroup.MarginLayoutParams r102 = (ViewGroup.MarginLayoutParams) r101;     // Catch: Throwable -> L10
            SendDanmuMsgPresenter r103 = this.f109123a;     // Catch: Throwable -> L10
            r103.f109120r = (r102.width + r102.rightMargin) + r102.leftMargin;     // Catch: Throwable -> L10
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SendDanmuMsgPresenter f109124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f109125b;

        public b(SendDanmuMsgPresenter r100, boolean r101) {
            this.f109124a = r100;
            this.f109125b = r101;
        }

        public final void a() {
            ViewGroup.LayoutParams r100 = this.f109124a.i().getLayoutParams();
            if (r100 == null) goto L11;
            FrameLayout.LayoutParams r101 = (FrameLayout.LayoutParams) r100;
            if (this.f109125b == false) goto L7;
            int r102 = this.f109124a.f109120r;
        L8:
            r101.rightMargin = r102;
            this.f109124a.i().setLayoutParams(r101);
            this.f109124a.i().requestLayout();
            return;
        L7:
            r102 = 0;
            goto L8
        L11:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final List<String> k() {
        return CollectionsKt.mutableListOf(new String[]{ObservedKeys.DANMU_INPUT, ObservedKeys.VS_DANMU_INPUT_LENGTH});
    }

    public SendDanmuMsgPresenter() {
        this.f109119q = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        this.f109121s = 50;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void g(DanmuPanelBasePresenter.IView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.g(r100);
        ViewGroup r101 = this.f109093d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L5:
        this.f109115m = r101.findViewById(R.id.btn_send);
        ViewGroup r102 = this.f109093d;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L8:
        this.f109116n = r102.findViewById(R.id.editor_container);
        DataCenter r103 = this.f510285b;
        if (r103 == null) goto L11;
        String r104 = (String) r103.get("VSInputInitText");
    L12:
        this.f109117o = r104;
        DataCenter r105 = this.f510285b;
        if (r105 == null) goto L17;
        Integer r106 = (Integer) r105.get("VSDanmuInputMaxInputLength");
        if (r106 == null) goto L17;
        int r107 = r106.intValue();
    L18:
        this.f109121s = r107;
        View r108 = this.f109115m;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
    L21:
        r108.post(new a(this));
        View r109 = this.f109115m;
        if (r109 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
    L24:
        r109.setOnClickListener(com.bytedance.android.livesdk.chatroom.vs_base.base.view.d.a(new SendDanmuMsgPresenter$attachView$2(this)));
        nl1.a r110 = this.f109100k;
        if (r110 == null) goto L31;
        BehaviorSubject<Boolean> r111 = r110.f519540b;
        if (r111 == null) goto L31;
        ObservableSubscribeProxy r112 = (ObservableSubscribeProxy) r111.as(AutoDispose.bind(this.f510284a));
        if (r112 == null) goto L31;
        r112.subscribe(new k(this));
    L31:
        n(false);
        return;
    L17:
        r107 = 50;
        goto L18
    L11:
        r104 = null;
        goto L12
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void m(KVData r100) {
        if (r100 == null) goto L19;
        String r101 = r100.getKey();
        int r102 = r101.hashCode();
        if (r102 == (-1891227055)) goto L16;
        if (r102 == 840681844) goto L9;
        return;
    L9:
        if (r101.equals(ObservedKeys.VS_DANMU_INPUT_LENGTH) == false) goto L20;
        Integer r103 = (Integer) r100.getData();
        if (r103 == null) goto L13;
        int r104 = r103.intValue();
    L14:
        this.f109122t = r104;
        return;
    L13:
        r104 = 0;
        goto L14
    L20:
        return;
    L16:
        if (r101.equals(ObservedKeys.DANMU_INPUT) == false) goto L22;
        this.f109117o = (String) r100.getData();
        n(true);
        return;
    L22:
        return;
    }

    public final void n(boolean r100) {
        String r101 = this.f109117o;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r100 == true) goto L11;
        View r103 = this.f109115m;
        if (r103 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
    L26:
        UtilityKotlinExtentionsKt.k(r103, r102);
        i().post(new b(this, r102));
        this.f109118p = r102;
        return;
    L11:
        if (r102 != this.f109118p) goto L13;
        return;
    L13:
        if (r102 == false) goto L18;
        ValueAnimator r104 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(250);
        View r105 = this.f109115m;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
    L17:
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, "alpha", new float[]{0.0f, 1.0f}).setDuration(250);
        r104.addUpdateListener(new h(this));
    L22:
        r106.addUpdateListener(new j(this, r102));
        r104.setInterpolator(this.f109119q);
        r106.start();
        r104.start();
        this.f109118p = r102;
        return;
    L18:
        r104 = ValueAnimator.ofInt(new int[]{0, 1}).setDuration(250);
        View r107 = this.f109115m;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
    L21:
        r106 = ObjectAnimator.ofFloat(r107, "alpha", new float[]{1.0f, 0.0f}).setDuration(250);
        r104.addUpdateListener(new i(this));
        goto L22
    L5:
        if (StringsKt.isBlank(r101) == true) goto L7;
        r102 = true;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        m((KVData) r100);
    }
}
