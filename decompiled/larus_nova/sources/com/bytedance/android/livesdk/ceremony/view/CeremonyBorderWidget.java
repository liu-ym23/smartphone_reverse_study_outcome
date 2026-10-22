package com.bytedance.android.livesdk.ceremony.view;

import android.widget.FrameLayout;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.ceremony.viewmodel.CeremonyViewModel;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomWidget;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.model.live.RoomBorderInfo;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ceremony/view/CeremonyBorderWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CeremonyBorderWidget extends RoomWidget {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CeremonyViewModel f104902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f104903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f104904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Disposable f104905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.livesdk.ceremony.viewmodel.a f104906f;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CeremonyBorderWidget f104907a;

        public a(CeremonyBorderWidget r100) {
            this.f104907a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            tf1.b r101 = (tf1.b) r100;
            CeremonyBorderWidget r102 = this.f104907a;
            com.bytedance.android.livesdk.ceremony.viewmodel.a r103 = r102.f104906f;
            if (r103 == null) goto L7;
            ITextureViewPlayerController r104 = r103.f104997b;
            if (r104 == null) goto L7;
            r104.stop();
        L7:
            Disposable r105 = r102.f104905e;
            if (r105 == null) goto L10;
            r105.dispose();
        L10:
            if (r101 == null) goto L13;
            StaticBorderView r106 = (StaticBorderView) r102.f104904d.getValue();
            r106.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            RoomBorderInfo.StaticBorderInfo r107 = r101.f545707a;
            ImageLoader.bindImage((HSImageView) r106.a(R.id.ceremony_top_border), r107.getTop(), new l(r106, r101), false);
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CeremonyBorderWidget f104908a;

        public b(CeremonyBorderWidget r100) {
            this.f104908a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            tf1.a r111 = (tf1.a) r110;
            CeremonyBorderWidget r100 = this.f104908a;
            ((StaticBorderView) r100.f104904d.getValue()).setAlpha(0.0f);
            if (r111 == null) goto L25;
            String r101 = r111.f545705a;
            if (r101 == null) goto L26;
            Disposable r102 = r100.f104905e;
            if (r102 != null) goto L9;
        L18:
            com.bytedance.android.livesdk.ceremony.viewmodel.a r103 = r100.f104906f;
            if (r103 == null) goto L21;
            r103.f105001f = new com.bytedance.android.livesdk.ceremony.view.a(r100);
        L21:
            if (r103 == null) goto L23;
            r103.c(r100.context, (FrameLayout) r100.f104903c.getValue(), r101, true, null, false, 0, "default");
        L23:
            r100.f104905e = Observable.timer(r111.f545706b + 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.ceremony.view.b(r100), c.f104960a);
            return;
        L9:
            if (r102.isDisposed() == true) goto L18;
            com.bytedance.android.livesdk.ceremony.viewmodel.a r104 = r100.f104906f;
            if (r104 == null) goto L15;
            ITextureViewPlayerController r105 = r104.f104997b;
            if (r105 == null) goto L15;
            r105.stop();
        L15:
            Disposable r106 = r100.f104905e;
            if (r106 == null) goto L18;
            r106.dispose();
            goto L18
        L26:
            return;
        }
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_ceremony_border_widget;
    }

    public CeremonyBorderWidget() {
        this.f104903c = LazyKt.lazy(new CeremonyBorderWidget$dynamicBorderView$2(this));
        this.f104904d = LazyKt.lazy(new CeremonyBorderWidget$staticBorderView$2(this));
        this.f104906f = new com.bytedance.android.livesdk.ceremony.viewmodel.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.widget.RoomWidget, com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        VSDataContext r100 = VSDataContext.a.c(VSDataContext.Companion, this.dataCenter);
        if (r100 == null) goto L8;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.isVSVideo();
        if (r101 == null) goto L8;
        if (r101.getValue().booleanValue() != true) goto L8;
    L18:
        CeremonyViewModel r102 = (CeremonyViewModel) r100.getCeremonyViewModel().getValue();
    L26:
        this.f104902b = r102;
        if (r102 == null) goto L29;
        r102.initMessageManager();
    L29:
        CeremonyViewModel r103 = this.f104902b;
        if (r103 == null) goto L34;
        NextLiveData<tf1.b> r104 = r103.getStaticBorderModel();
        if (r104 == null) goto L34;
        r104.observe(this, new a(this));
    L34:
        CeremonyViewModel r105 = this.f104902b;
        if (r105 == null) goto L39;
        NextLiveData<tf1.a> r106 = r105.getDynamicBorderModel();
        if (r106 == null) goto L39;
        r106.observe(this, new b(this));
    L39:
        CeremonyViewModel r107 = this.f104902b;
        if (r107 == null) goto L43;
        r107.enterRoom();
        return;
    L43:
        return;
    L8:
        if (r100 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r108 = r100.isVSFirstShow();
        if (r108 == null) goto L13;
        if (r108.getValue().booleanValue() == true) goto L18;
    L13:
        if (r100 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r109 = r100.isVSLive();
        if (r109 == null) goto L19;
        if (r109.getValue().booleanValue() == true) goto L18;
    L19:
        RoomContext r110 = this.f118688a;
        if (r110 == null) goto L24;
        com.bytedance.live.datacontext.j<ViewModel> r111 = r110.getCeremonyViewModel();
        if (r111 == null) goto L24;
        ViewModel r112 = r111.getValue();
    L25:
        r102 = (CeremonyViewModel) r112;
    L24:
        r112 = null;
        goto L25
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        com.bytedance.android.livesdk.ceremony.viewmodel.a r100 = this.f104906f;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f104906f = null;
        Disposable r101 = this.f104905e;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    }
}
