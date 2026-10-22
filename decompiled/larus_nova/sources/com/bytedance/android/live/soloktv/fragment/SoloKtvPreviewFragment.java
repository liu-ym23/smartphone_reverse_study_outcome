package com.bytedance.android.live.soloktv.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.soloktv.SoloKtvActivity;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.floatwindow.SaveProgressFloatWindowManager;
import com.bytedance.android.live.soloktv.viewmodel.SoloKtvEditViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.bytedance.ies.videoclip.api.player.IPlayer;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/soloktv/fragment/SoloKtvPreviewFragment;", "Lcom/bytedance/android/live/soloktv/fragment/BaseSoloKtvFragment;", "Landroid/view/TextureView$SurfaceTextureListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvPreviewFragment extends BaseSoloKtvFragment implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f101167m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextureView f101168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f101169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f101170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SoloKtvEditViewModel f101171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SurfaceTexture f101172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageView f101173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f101174k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeDisposable f101175l;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvPreviewFragment f101176a;

        public b(SoloKtvPreviewFragment r100) {
            this.f101176a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            SoloKtvEditViewModel r101 = this.f101176a.f101171h;
            if (r101 == null) goto L6;
            r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.n.f101903a);
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvPreviewFragment f101177a;

        public c(SoloKtvPreviewFragment r100) {
            this.f101177a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IPlayer.PlayerStatus r101 = (IPlayer.PlayerStatus) r100;
            if (r101 == null) goto L16;
            int r102 = f0.f101210a[r101.ordinal()];
            if (r102 != 1) goto L8;
            SoloKtvPreviewFragment r103 = this.f101177a;
            int r104 = SoloKtvPreviewFragment.f101167m;
            r103.getClass();
            this.f101177a.getClass();
            return;
        L8:
            if (r102 != 2) goto L10;
        L12:
            SoloKtvPreviewFragment r105 = this.f101177a;
            int r106 = SoloKtvPreviewFragment.f101167m;
            r105.getClass();
            return;
        L10:
            if (r102 == 3) goto L12;
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvPreviewFragment f101178a;

        public d(SoloKtvPreviewFragment r100) {
            this.f101178a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (vm2.h.k().enableKtvSaveToDraft == true) goto L9;
            String r101 = vm2.h.k().disableToast;
            if (r101 != null) goto L7;
            r101 = "";
        L7:
            f2.c(r101, 0);
            return;
        L9:
            SaveProgressFloatWindowManager.a r102 = SaveProgressFloatWindowManager.f101076k;
            if (SaveProgressFloatWindowManager.b.a().f101080c == false) goto L13;
            SoloKtvPreviewFragment.Y90(this.f101178a);
            return;
        L13:
            SoloKtvContext.Companion.getClass();
            com.bytedance.android.live.soloktv.model.k r103 = SoloKtvContext.a.a().getEditDataStore();
            if (r103 == null) goto L16;
            com.bytedance.android.live.soloktv.model.k r104 = com.bytedance.android.live.soloktv.model.l.a(r103);
        L17:
            SoloKtvEditViewModel r105 = this.f101178a.f101171h;
            if (r105 == null) goto L20;
            r105.doAction(com.bytedance.android.live.soloktv.viewmodel.f.g.f101892a);
        L20:
            SoloKtvPreviewFragment r106 = this.f101178a;
            SoloKtvEditViewModel r107 = r106.f101171h;
            if (r107 == null) goto L27;
            TextureView r108 = r106.f101168e;
            if (r108 == null) goto L25;
            Bitmap r109 = r108.getBitmap();
        L26:
            r107.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.k(r104, null, r109));
            goto L27
        L25:
            r109 = null;
        L27:
            SoloKtvPreviewFragment.X90(this.f101178a);
            return;
        L16:
            r104 = null;
            goto L17
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvPreviewFragment f101179a;

        public e(SoloKtvPreviewFragment r100) {
            this.f101179a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            if (vm2.h.k().enableKtvPublish == true) goto L9;
            String r101 = vm2.h.k().disableToast;
            if (r101 != null) goto L7;
            r101 = "";
        L7:
            f2.c(r101, 0);
            return;
        L9:
            SaveProgressFloatWindowManager.a r102 = SaveProgressFloatWindowManager.f101076k;
            if (SaveProgressFloatWindowManager.b.a().f101080c == false) goto L13;
            SoloKtvPreviewFragment.Y90(this.f101179a);
            return;
        L13:
            SoloKtvContext.Companion.getClass();
            com.bytedance.android.live.soloktv.model.k r103 = SoloKtvContext.a.a().getEditDataStore();
            if (r103 == null) goto L16;
            com.bytedance.android.live.soloktv.model.k r104 = com.bytedance.android.live.soloktv.model.l.a(r103);
        L17:
            SoloKtvEditViewModel r105 = this.f101179a.f101171h;
            if (r105 == null) goto L20;
            r105.doAction(com.bytedance.android.live.soloktv.viewmodel.f.g.f101892a);
        L20:
            SoloKtvPreviewFragment r106 = this.f101179a;
            SoloKtvEditViewModel r107 = r106.f101171h;
            if (r107 == null) goto L27;
            TextureView r108 = r106.f101168e;
            if (r108 == null) goto L25;
            Bitmap r109 = r108.getBitmap();
        L26:
            r107.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.h(r104, null, r109));
            goto L27
        L25:
            r109 = null;
        L27:
            SoloKtvPreviewFragment.X90(this.f101179a);
            return;
        L16:
            r104 = null;
            goto L17
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.soloktv.fragment.SoloKtvPreviewFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 5, 1})
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {
        public static final KProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(com.bytedance.android.live.soloktv.viewmodel.g.class, "playStatus", "getPlayStatus()Lcom/ss/bytedance/ies/videoclip/api/player/IPlayer$PlayerStatus;", 0);
        }

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public Object get(Object r100) {
            return ((com.bytedance.android.live.soloktv.viewmodel.g) r100).f101913f;
        }
    }

    static {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surface");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
    }

    public SoloKtvPreviewFragment() {
        this.f101175l = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        SoloKtvEditViewModel r100 = this.f101171h;
        if (r100 == null) goto L5;
        r100.doAction(com.bytedance.android.live.soloktv.viewmodel.f.m.f101902a);
    L5:
        SoloKtvEditViewModel r101 = this.f101171h;
        if (r101 == null) goto L8;
        r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.i.f101896a);
    L8:
        this.f101175l.dispose();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        SoloKtvEditViewModel r100 = this.f101171h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isPlaying() != true) goto L11;
        this.f101174k = true;
        SoloKtvEditViewModel r101 = this.f101171h;
        if (r101 == null) goto L12;
        r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.n.f101903a);
        return;
    L12:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f101174k == false) goto L8;
        SoloKtvEditViewModel r100 = this.f101171h;
        if (r100 == null) goto L9;
        r100.doAction(com.bytedance.android.live.soloktv.viewmodel.f.n.f101903a);
        return;
    L9:
        return;
    }

    public static final void X90(SoloKtvPreviewFragment r100) {
        SoloKtvEditViewModel r101 = r100.f101171h;
        if (r101 == null) goto L5;
        r101.doAction(com.bytedance.android.live.soloktv.viewmodel.f.m.f101902a);
    L5:
        SoloKtvEditViewModel r102 = r100.f101171h;
        if (r102 == null) goto L8;
        r102.doAction(com.bytedance.android.live.soloktv.viewmodel.f.i.f101896a);
    L8:
        r100.startActivity(new Intent(r100.getContext(), SoloKtvActivity.class));
    }

    public static final void Y90(SoloKtvPreviewFragment r100) {
        r100.getClass();
        com.bytedance.android.live.soloktv.util.l.b r101 = com.bytedance.android.live.soloktv.util.l.f101621d;
        if ((r101 instanceof com.bytedance.android.live.soloktv.util.l.b.a) == false) goto L5;
    L8:
        f2.b(R.string.ttlive_solo_ktv_in_save_window_publish, 0);
        return;
    L5:
        if ((r101 instanceof com.bytedance.android.live.soloktv.util.l.b.c) == true) goto L8;
        f2.b(R.string.ttlive_solo_ktv_in_save_window_save_draft, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f101171h = (SoloKtvEditViewModel) ViewModelProviders.of(this).get(SoloKtvEditViewModel.class);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        this.f101172i = r100;
        return false;
    }

    @Override // com.bytedance.android.live.soloktv.fragment.BaseSoloKtvFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f101168e = (TextureView) r110.findViewById(R.id.sf_preview_texture_view);
        this.f101169f = r110.findViewById(R.id.save_draft_btn);
        this.f101170g = r110.findViewById(R.id.publish_btn);
        this.f101173j = (ImageView) r110.findViewById(R.id.background_image);
        TextureView r112 = this.f101168e;
        if (r112 == null) goto L5;
        r112.setSurfaceTextureListener(this);
    L5:
        SoloKtvContext.Companion.getClass();
        com.bytedance.android.live.soloktv.model.k r113 = SoloKtvContext.a.a().getEditDataStore();
        ViewGroup.LayoutParams r100 = null;
        if (r113 == null) goto L8;
        com.bytedance.android.live.soloktv.model.k r101 = com.bytedance.android.live.soloktv.model.l.a(r113);
    L9:
        if (r101 == null) goto L13;
        eb1.f r114 = r101.b();
        if (r114 == null) goto L13;
        nb1.i r102 = r114.i();
    L14:
        SoloKtvEditViewModel r115 = this.f101171h;
        if (r115 == null) goto L17;
        r115.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.C1547f(requireActivity(), r101, null, 0, r102, 8));
    L17:
        r110.setOnClickListener(new b(this));
        SoloKtvEditViewModel r116 = this.f101171h;
        if (r116 == null) goto L22;
        MutableLiveData<com.bytedance.android.live.soloktv.viewmodel.g> r117 = r116.getUIState();
        if (r117 == null) goto L22;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r117, this, AnonymousClass2.INSTANCE, new c(this));
    L22:
        View r118 = this.f101169f;
        if (r118 == null) goto L25;
        r118.setOnClickListener(new d(this));
    L25:
        View r119 = this.f101170g;
        if (r119 == null) goto L28;
        r119.setOnClickListener(new e(this));
    L28:
        int r120 = s1.y();
        int r121 = s1.w();
        float r103 = r121 / r120;
        if (r103 <= 1.7777778f) goto L32;
        Integer r122 = Integer.valueOf(r120);
        Integer r123 = Integer.valueOf((int) (r122.intValue() * 1.7777778f));
    L35:
        if (r122 == null) goto L44;
        if (r123 == null) goto L45;
        int r124 = r123.intValue();
        int r125 = r122.intValue();
        RxUtilKt.c(Observable.create(new h0(SoloKtvContext.a.a().getEditDataStore())).compose(RxUtil.rxSchedulerHelper()).subscribe(new g0(this), i0.f101216a), this.f101175l);
        TextureView r104 = this.f101168e;
        if (r104 == null) goto L46;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L42;
        r105.width = r125;
        r105.height = r124;
        Unit r126 = Unit.INSTANCE;
        r100 = r105;
    L42:
        r104.setLayoutParams(r100);
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L32:
        if (r103 >= 1.7777778f) goto L34;
        r123 = Integer.valueOf(r121);
        r122 = Integer.valueOf((int) (r123.intValue() / 1.7777778f));
        goto L35
    L34:
        r122 = null;
        r123 = null;
    L13:
        r102 = null;
        goto L14
    L8:
        r101 = null;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_solo_ktv_preview_fragment, r101, false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "surface");
        SurfaceTexture r103 = this.f101172i;
        if (r103 == null) goto L11;
        TextureView r104 = this.f101168e;
        if (r104 == null) goto L7;
        r104.setSurfaceTexture(r103);
        Unit r105 = Unit.INSTANCE;
    L8:
        if (r105 == null) goto L11;
        boolean r106 = false;
    L12:
        SoloKtvEditViewModel r107 = this.f101171h;
        if (r107 == null) goto L15;
        r107.doAction(new com.bytedance.android.live.soloktv.viewmodel.f.a(new Surface(this.f101172i), r101, r102));
    L15:
        if (r106 == false) goto L20;
        SoloKtvEditViewModel r108 = this.f101171h;
        if (r108 == null) goto L21;
        r108.doAction(com.bytedance.android.live.soloktv.viewmodel.f.n.f101903a);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r105 = null;
    L11:
        this.f101172i = r100;
        Unit r109 = Unit.INSTANCE;
        r106 = true;
        goto L12
    }
}
