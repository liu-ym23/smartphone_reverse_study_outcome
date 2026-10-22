package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.uicomponent.popover.PopLayout;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/element/ReplayPlayerViewLockGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayPlayerViewLockGuideWidget extends LiveWidget {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f108452g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f108453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f108454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f108455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f108456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f108457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f108458f;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayerViewLockGuideWidget f108459a;

        public b(ReplayPlayerViewLockGuideWidget r100) {
            this.f108459a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            ALogger.w(this.f108459a.f108458f, "receive tryShow pop message");
            ReplayPlayerViewLockGuideWidget r102 = this.f108459a;
            if (r102.f108455c == false) goto L6;
            ALogger.e(r102.f108458f, "is showing ,skip");
            return;
        L6:
            if (nq1.d.f520105n.getValue().booleanValue() == false) goto L16;
            r102.f108455c = true;
            Disposable r103 = r102.f108457e;
            if (r103 == null) goto L10;
            r103.dispose();
        L10:
            Disposable r104 = r102.f108456d;
            if (r104 == null) goto L13;
            r104.dispose();
        L13:
            ObjectAnimator r105 = ObjectAnimator.ofFloat(r102.contentView, "alpha", new float[]{0.0f, 1.0f});
            r105.addListener(new r(r102));
            r105.setDuration(300);
            r105.start();
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayPlayerViewLockGuideWidget f108460a;

        public c(ReplayPlayerViewLockGuideWidget r100) {
            this.f108460a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L8;
            ReplayPlayerViewLockGuideWidget r101 = this.f108460a;
            if (r101.f108455c == false) goto L9;
            ReplayPlayerViewLockGuideWidget.wq(r101);
            return;
        L9:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_replay_widget_view_lock_guide;
    }

    public ReplayPlayerViewLockGuideWidget() {
        this.f108453a = LazyKt.lazy(new ReplayPlayerViewLockGuideWidget$playerLockPop$2(this));
        this.f108454b = LazyKt.lazy(new ReplayPlayerViewLockGuideWidget$playerPopText$2(this));
        this.f108458f = "VSPlayerViewLockGuideWidget[" + hashCode() + ']';
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        HSImageView r100 = (HSImageView) this.contentView.findViewById(R.id.ttlive_iv_player_lock);
        if (r100 == null) goto L5;
        r100.setActualImageResource(R.drawable.ttlive_replay_player_lock);
    L5:
        View r101 = this.contentView;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.i(r101);
    L8:
        this.dataCenter.observe("cmd_try_show_lock_view_guide_pop", new b(this));
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onResume() {
        super.onResume();
        mq1.t r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.s.e();
        if (r100 == null) goto L7;
        mq1.v r101 = r100.provideVSPlayerViewControlService(this.dataCenter);
        if (r101 == null) goto L7;
        VSPlayerViewControlContext r102 = r101.provideContext();
    L8:
        if (r102 == null) goto L11;
        r102.getPlayerViewVisible().a().subscribe(new c(this));
        return;
    L11:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public static final void wq(ReplayPlayerViewLockGuideWidget r100) {
        r100.f108455c = false;
        UtilityKotlinExtentionsKt.h((PopLayout) r100.f108453a.getValue());
        UtilityKotlinExtentionsKt.h(r100.contentView);
        Disposable r101 = r100.f108456d;
        Disposable r102 = null;
        if (r101 != null) goto L5;
    L10:
        Disposable r103 = r100.f108457e;
        if (r103 != null) goto L13;
    L17:
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r104 = nq1.d.f520105n;
        Boolean r105 = Boolean.FALSE;
        r104.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r104, r105);
        return;
    L13:
        if (r103.isDisposed() == true) goto L15;
        r102 = r103;
    L15:
        if (r102 == null) goto L17;
        r102.dispose();
        goto L17
    L5:
        if (r101.isDisposed() == false) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L10;
        r101.dispose();
        goto L10
    }
}
