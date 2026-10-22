package com.bytedance.android.live.soloktv.karaokestation.view;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.view.LiveOnlineAvatarView;
import com.bytedance.android.live.soloktv.karaokestation.util.CommonViewHolder;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.imagepipeline.image.ImageInfo;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/soloktv/karaokestation/view/SoloKtvRoomViewHolder;", "Lcom/bytedance/android/live/soloktv/karaokestation/util/CommonViewHolder;", "Lcom/bytedance/android/live/soloktv/model/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvRoomViewHolder extends CommonViewHolder<com.bytedance.android.live.soloktv.model.m> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f101271f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f101272g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f101273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveOnlineAvatarView f101274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f101275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f101276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Long> f101277e;

    public static final class a {
    }

    public static final class b extends BaseControllerListener<ImageInfo> {
        public b() {
        }

        @Override // com.facebook.drawee.controller.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public final void onFinalImageSet(String r100, Object r101, Animatable r102) {
            super.onFinalImageSet(r100, (ImageInfo) r101, r102);
            if ((r102 instanceof AnimatedDrawable2) == true) goto L5;
            Animatable r103 = null;
        L6:
            AnimatedDrawable2 r104 = (AnimatedDrawable2) r103;
            if (r104 == null) goto L10;
            r104.setPrivateFrameScheduler(new DropFramesFrameScheduler(((AnimatedDrawable2) r102).getAnimationBackend()));
            return;
        L10:
            return;
        L5:
            r103 = r102;
            goto L6
        }
    }

    static {
        f101271f = s1.B(R.string.ttlive_solo_ktv_online_count);
        f101272g = 15;
    }

    public SoloKtvRoomViewHolder(View r100, ArrayList<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "roomIdList");
        super(r100);
        this.f101277e = r101;
        this.f101274b = (LiveOnlineAvatarView) r100.findViewById(R.id.anchor_avatar);
        this.f101273a = (TextView) r100.findViewById(R.id.online_count);
        this.f101275c = (TextView) r100.findViewById(R.id.anchor_name);
        this.f101276d = (TextView) r100.findViewById(R.id.sing_info);
        HSImageView r102 = (HSImageView) r100.findViewById(R.id.living_icon);
        PipelineDraweeControllerBuilder r103 = Fresco.newDraweeControllerBuilder();
        if (r102 == null) goto L5;
        DraweeController r104 = r102.getController();
    L6:
        AbstractDraweeController r105 = r103.setOldController(r104).setUri(UriProtector.parse(com.bytedance.android.live.ktv.common.util.n.a((String) vm2.h.f556188n1.getValue(null, vm2.h.f556082a[116(0x74, float:1.63E-43)])))).setAutoPlayAnimations(true).setControllerListener(new b()).build();
        if (r102 == null) goto L10;
        r102.setController(r105);
        return;
    L10:
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.soloktv.karaokestation.util.CommonViewHolder
    public final void T3(final int r110, com.bytedance.android.live.soloktv.model.m r111) {
        final com.bytedance.android.live.soloktv.model.m r100 = r111;
        Intrinsics.checkNotNullParameter(r100, "t");
        IBaseUser r101 = r100.c();
        if (r101 == null) goto L10;
        py.k r102 = r101.getAvatarThumbKt();
        if (r102 == null) goto L10;
        LiveOnlineAvatarView r103 = this.f101274b;
        if (r103 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("avatart");
    L9:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ImageUtil.loadRoundImage(r103.f70750a, r102);
    L10:
        IBaseUser r104 = r100.c();
        if (r104 == null) goto L40;
        final long r105 = r104.getLiveRoomId();
        Integer r106 = Integer.valueOf(this.f101277e.indexOf(Long.valueOf(r105)));
        if (r106.intValue() <= 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L19;
        r106 = null;
    L19:
        if (r106 == null) goto L29;
        int r108 = r106.intValue();
        int r109 = f101272g;
        if (r108 <= r109) goto L23;
        int r112 = r108 - r109;
    L24:
        int r113 = r108 + r109;
        if (r113 <= this.f101277e.size()) goto L27;
        r113 = this.f101277e.size();
    L27:
        List<Long> r114 = this.f101277e.subList(r112, r113);
        if (r114 == null) goto L29;
    L30:
        List<Long> r115 = r114;
        LiveOnlineAvatarView r116 = this.f101274b;
        if (r116 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("avatart");
    L33:
        r116.getClass();
        Intrinsics.checkNotNullParameter(r115, "roomIds");
        HSImageView r117 = r116.f70750a;
        r117.setOnClickListener(new com.bytedance.android.live.ktv.common.view.e(r117, r116, r115, r105));
        LiveOnlineAvatarView r118 = this.f101274b;
        if (r118 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("avatart");
    L36:
        r118.setEnterParamMap(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enter_from_merge", "solo_ktv"), TuplesKt.to("enter_method", "solo_ktv"), TuplesKt.to("function_type2", "ktv")}));
        LiveOnlineAvatarView r119 = this.f101274b;
        if (r119 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("avatart");
    L39:
        r119.setOnClickAvatarCb(new SoloKtvRoomViewHolder$bind$$inlined$let$lambda$1(r105, this, r100, r110));
        goto L40
    L23:
        r112 = 0;
    L29:
        r114 = this.f101277e;
        goto L30
    L15:
        r107 = false;
    L40:
        TextView r120 = this.f101275c;
        if (r120 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("title");
    L43:
        IBaseUser r121 = r100.c();
        if (r121 == null) goto L47;
        Object r122 = r121.getRealNickName();
        if (r122 == null) goto L47;
    L48:
        r120.setText(r122.toString());
        String r123 = r100.b();
        if (TextUtils.isEmpty(r123) == false) goto L54;
        TextView r124 = this.f101276d;
        if (r124 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("info");
    L53:
        r124.setVisibility(8);
    L61:
        TextView r125 = this.f101276d;
        if (r125 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("info");
    L64:
        Object r126 = r100.b();
        if (r126 != null) goto L67;
        r126 = 0;
    L67:
        r125.setText(r126.toString());
        TextView r127 = this.f101273a;
        if (r127 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("onlineCount");
    L70:
        StringCompanionObject r128 = StringCompanionObject.INSTANCE;
        String r129 = f101271f;
        Object[] r130 = new Object[1];
        Integer r131 = r100.a();
        if (r131 == null) goto L73;
        int r132 = r131.intValue();
    L74:
        r130[0] = Integer.valueOf(r132);
        r127.setText(String.format(r129, Arrays.copyOf(r130, 1)));
        return;
    L73:
        r132 = 0;
        goto L74
    L54:
        TextView r133 = this.f101276d;
        if (r133 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("info");
    L57:
        r133.setText(r123);
        TextView r134 = this.f101276d;
        if (r134 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("info");
    L60:
        r134.setVisibility(0);
    L47:
        r122 = 0;
        goto L48
    }
}
