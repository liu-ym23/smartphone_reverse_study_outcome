package com.bytedance.android.livesdk.landscapeslide;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.setting.u2;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.utils.v5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/LiveLandscapeSlideGuideWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLandscapeSlideGuideWidget extends LiveWidget implements Observer<KVData> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f146997f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f146998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ConstraintLayout f146999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConstraintLayout f147000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f147001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HSImageView f147002e;

    public static final class a {
        @JvmStatic
        public static boolean a(IRoom r100) {
            if (u2.f65422a.getValue().isEnableLandscapeSlideGuideWidgetLoadOpt() == false) goto L14;
            Context r101 = s1.getContext();
            if (r101 == null) goto L14;
            Resources r102 = r101.getResources();
            if (r102 == null) goto L14;
            Configuration r103 = r102.getConfiguration();
            if (r103 == null) goto L14;
            if (r103.orientation != 1) goto L14;
            return false;
        L14:
            if (v5.b().getBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE", false) == true) goto L16;
        L23:
            return true;
        L16:
            if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L19;
            return false;
        L19:
            if (d1.a(r100) == false) goto L21;
        L22:
            return false;
        L21:
            if (v5.b().getBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE_EXT", false) == false) goto L23;
            goto L22
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLandscapeSlideGuideWidget f147003a;

        public b(LiveLandscapeSlideGuideWidget r100) {
            this.f147003a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            LiveLandscapeSlideGuideWidget r101 = this.f147003a;
            int r102 = LiveLandscapeSlideGuideWidget.f146997f;
            r101.hide();
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_landscape_slide_guide;
    }

    public final void hide() {
        ViewGroup r100 = this.containerView;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.contentView == null) goto L10;
        r100.setVisibility(8);
        this.contentView.setVisibility(8);
        return;
    }

    public final void xq() {
        DataCenter r100 = this.dataCenter;
        IRoom r101 = null;
        if (r100 == null) goto L6;
        r101 = (IRoom) r100.get("data_room", null);
    L6:
        if (a.a(r101) == true) goto L9;
        return;
    L9:
        if (this.containerView != null) goto L11;
        return;
    L11:
        if (this.contentView == null) goto L22;
        AbstractDraweeController r102 = Fresco.newDraweeControllerBuilder().setUri(i2.c("/slide/ttlive_landscape_slide_guide.webp")).setAutoPlayAnimations(true).build();
        HSImageView r103 = this.f147002e;
        if (r103 == null) goto L16;
        r103.setController(r102);
    L16:
        this.containerView.setVisibility(0);
        this.contentView.setVisibility(0);
        this.containerView.setOnClickListener(new b(this));
        v5.b().edit().putBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE", true).apply();
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L21;
        v5.b().edit().putBoolean("live.key.LIVE_LANDSCAPE_SLIDE_GUIDE_EXT", true).apply();
        return;
    L21:
        return;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onCreate() {
        super.onCreate();
        e.a r100 = e.f147005a;
        int r101 = com.bytedance.android.livesdk.utils.landscape.f.f159074a.d();
        r100.getClass();
        if (r101 != 1) goto L5;
        e r102 = new c();
    L9:
        this.f146998a = r102;
        this.f146999b = (ConstraintLayout) this.contentView.findViewById(R.id.ttlive_landscape_layout_brightness);
        this.f147000c = (ConstraintLayout) this.contentView.findViewById(R.id.ttlive_landscape_layout_slide);
        this.f147001d = (ConstraintLayout) this.contentView.findViewById(R.id.ttlive_landscape_layout_volume);
        this.f147002e = (HSImageView) this.contentView.findViewById(R.id.ttlive_landscape_guide_slide);
        ConstraintLayout r103 = this.f146999b;
        e r104 = this.f146998a;
        Float r105 = null;
        if (r104 == null) goto L12;
        Float r106 = Float.valueOf(r104.a());
    L13:
        wq(r103, r106);
        ConstraintLayout r107 = this.f147000c;
        e r108 = this.f146998a;
        if (r108 == null) goto L16;
        Float r109 = Float.valueOf(r108.c());
    L17:
        wq(r107, r109);
        ConstraintLayout r110 = this.f147001d;
        e r111 = this.f146998a;
        if (r111 == null) goto L20;
        r105 = Float.valueOf(r111.b());
    L20:
        wq(r110, r105);
        DataCenter r112 = this.dataCenter;
        if (r112 != null) goto L23;
        return;
    L23:
        r112.observe("data_is_portrait", this);
        return;
    L16:
        r109 = null;
        goto L17
    L12:
        r106 = null;
        goto L13
    L5:
        if (r101 == 2) goto L7;
        r102 = new com.bytedance.android.livesdk.landscapeslide.a();
        goto L9
    L7:
        r102 = new com.bytedance.android.livesdk.landscapeslide.a();
        goto L9
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveWidget, com.bytedance.livesdk.preview.merge.AbsMergeWidget, com.bytedance.ies.sdk.widgets.Widget
    public final void onDestroy() {
        super.onDestroy();
        DataCenter r100 = this.dataCenter;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.removeObserver("data_is_portrait", this);
    }

    public LiveLandscapeSlideGuideWidget() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        Boolean r102 = null;
        if (r101 == null) goto L6;
        r102 = (Boolean) r101.getData(null);
    L6:
        if (Intrinsics.areEqual(r102, Boolean.TRUE) == false) goto L9;
        hide();
        return;
    }

    public static void wq(ConstraintLayout r100, Float r101) {
        if (r100 == null) goto L13;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r100.getLayoutParams() instanceof LinearLayout.LayoutParams) == false) goto L15;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 == null) goto L12;
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        r103.weight = r101.floatValue();
        r100.setLayoutParams(r103);
        return;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L15:
        return;
    }
}
