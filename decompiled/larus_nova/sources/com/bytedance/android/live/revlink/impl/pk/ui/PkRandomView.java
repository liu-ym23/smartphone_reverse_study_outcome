package com.bytedance.android.live.revlink.impl.pk.ui;

import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.fresco.ImageNetworkRequestsMonitor;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.revenue.common.k0;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.link.model.b0;
import com.bytedance.android.livesdk.link.model.h1;
import com.bytedance.android.livesdk.link.model.j8;
import com.bytedance.android.livesdk.link.model.k1;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016B\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0015\u0010\u0019B#\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0015\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bR\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/PkRandomView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "txt", "", "setRandomBtnTxt", "Lcom/bytedance/android/livesdk/link/model/b0;", "autoMatchInfo", "", "isNewPkAnchor", "update", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "b", "Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "getListener", "()Lcom/bytedance/android/live/revlink/impl/pk/ui/x;", "setListener", "(Lcom/bytedance/android/live/revlink/impl/pk/ui/x;)V", "listener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkRandomView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f97003j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f97004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f97005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f97006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkCrossRoomDataHolder f97007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f97008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f97009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f97010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f97011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f97012i;

    public final x getListener() {
        x r100 = this.f97005b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("listener");
    L5:
        return r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet r100 = this.f97011h;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    public PkRandomView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f97004a = new LinkedHashMap();
        this.f97006c = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_random_emoji, this);
        this.f97007d = com.bytedance.android.live.revlink.impl.global.b.j();
        StringBuilder r101 = new StringBuilder("https://");
        String r102 = k0.f90841a;
        String r103 = k0.f90841a;
        r101.append(r103);
        r101.append("/obj/live-android/pk_random_new_bg.png");
        this.f97008e = r101.toString();
        this.f97009f = "https://" + r103 + "/obj/live-android/pk_random_guest_avatar.webp";
        this.f97010g = "https://" + r103 + "/obj/live-android/pk_random_btn_anim.webp";
        l51.a.M(l51.a.p() + 1);
    }

    public final View _$_findCachedViewById(int r100) {
        if (this.f97004a != null) goto L5;
        this.f97004a = new LinkedHashMap();
    L5:
        View r101 = this.f97004a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f97004a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setListener(x r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f97005b = r100;
    }

    public final void setRandomBtnTxt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "txt");
        View r101 = this.f97006c;
        if (r101 == null) goto L5;
        View r102 = r101.findViewById(R.id.btn_start);
    L6:
        TextView r103 = (TextView) r102;
        if (r103 == null) goto L10;
        r103.setText(r100);
        return;
    L10:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public PkRandomView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f97004a = new LinkedHashMap();
        this.f97006c = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_random_emoji, this);
        this.f97007d = com.bytedance.android.live.revlink.impl.global.b.j();
        StringBuilder r102 = new StringBuilder("https://");
        String r103 = k0.f90841a;
        String r104 = k0.f90841a;
        r102.append(r104);
        r102.append("/obj/live-android/pk_random_new_bg.png");
        this.f97008e = r102.toString();
        this.f97009f = "https://" + r104 + "/obj/live-android/pk_random_guest_avatar.webp";
        this.f97010g = "https://" + r104 + "/obj/live-android/pk_random_btn_anim.webp";
        l51.a.M(l51.a.p() + 1);
    }

    public final void update(b0 r100, boolean r101) {
        if (r100 == null) goto L7;
        String r102 = r100.getMainTitle();
        if (r102 == null) goto L7;
        ((TextView) _$_findCachedViewById(R.id.random_title)).setText(r102);
    L7:
        View r103 = this.f97006c;
        ImageRequest[] r104 = null;
        if (r103 == null) goto L10;
        View r105 = r103.findViewById(R.id.random_bg);
    L11:
        a1.s((HSImageView) r105, this.f97008e);
        View r106 = this.f97006c;
        if (r106 == null) goto L14;
        View r107 = r106.findViewById(R.id.random_guest_anim);
    L15:
        com.bytedance.android.live.revlink.impl.pk.utils.w.a((SimpleDraweeView) r107, this.f97009f);
        View r108 = this.f97006c;
        if (r108 == null) goto L18;
        View r109 = r108.findViewById(R.id.btn_start);
    L19:
        TextView r110 = (TextView) r109;
        if (r110 == null) goto L22;
        r110.setOnClickListener(x0.a(new AnonymousClass2(this)));
    L22:
        View r111 = this.f97006c;
        if (r111 == null) goto L25;
        View r112 = r111.findViewById(R.id.btn_area);
    L26:
        if (r112 == null) goto L28;
        r112.setBackgroundResource(R.drawable.ttlive_bg_live_random_btn);
    L28:
        View r113 = this.f97006c;
        if (r113 == null) goto L31;
        View r114 = r113.findViewById(R.id.btn_start_brawl);
    L32:
        TextView r115 = (TextView) r114;
        if (r115 == null) goto L35;
        r115.setVisibility(8);
    L35:
        IBaseUser r116 = ((com.bytedance.android.livesdk.revenue.service.user.a) vh6.c.b(com.bytedance.android.livesdk.revenue.service.user.a.class)).b();
        View r117 = this.f97006c;
        if (r117 == null) goto L38;
        View r118 = r117.findViewById(R.id.random_avatar);
    L39:
        ImageView r119 = (ImageView) r118;
        if (r116 == null) goto L42;
        py.k r120 = r116.getAvatarThumbKt();
    L43:
        ImageUtil.loadRoundImage(r119, r120);
        if (r100 == null) goto L48;
        String r121 = r100.getMainTitle();
        if (r121 == null) goto L48;
        ((TextView) _$_findCachedViewById(R.id.random_title)).setText(r121);
    L48:
        String r122 = s1.B(R.string.ttlive_interact_pk_dialog_random_subtitle);
        ((TextView) _$_findCachedViewById(R.id.random_subtitle)).setText(r122 + " ");
        TextView r123 = (TextView) _$_findCachedViewById(R.id.random_match_text);
        ur2.a r124 = (ur2.a) vh6.c.b(ur2.a.class);
        if (r100 == null) goto L63;
        Intrinsics.checkNotNullParameter(r100, "$this$matchText");
        if ((r100 instanceof h1) == false) goto L61;
        vh7.c r125 = (h1) r100;
        KProperty[] r126 = k1.f147098a;
        Intrinsics.checkNotNullParameter(r125, "$this$_matchText");
        vh7.i r127 = k1.f147099b;
        KProperty r128 = k1.f147098a[0];
        if ((r125 instanceof FlexModelBase) == true) goto L55;
        r125 = null;
    L55:
        FlexModelBase r129 = (FlexModelBase) r125;
        if (r129 == null) goto L58;
        Object r130 = r129.get(r127.f554986a);
    L59:
        a5 r131 = (a5) r130;
    L64:
        r123.setText(r124.Lf(r131, ""));
        if (r101 == true) goto L67;
        return;
    L67:
        if (l51.a.p() <= 3) goto L69;
        return;
    L69:
        if (this.f97012i == true) goto L79;
        this.f97012i = true;
        PipelineDraweeControllerBuilder r132 = Fresco.newDraweeControllerBuilder().setOldController(((HSImageView) this.f97006c.findViewById(R.id.random_anim)).getController());
        String r133 = this.f97010g;
        ArrayList r134 = new ArrayList();
        ImageNetworkRequestsMonitor r135 = new ImageNetworkRequestsMonitor();
        ImageRequestBuilder r136 = ImageRequestBuilder.newBuilderWithSource(UriProtector.parse(r133));
        r135.monitor(r136);
        r134.add(r136.build());
        if (r134.size() == 0) goto L75;
        r104 = (ImageRequest[]) r134.toArray(new ImageRequest[r134.size()]);
    L75:
        ((HSImageView) this.f97006c.findViewById(R.id.random_anim)).setController(r132.setFirstAvailableImageRequests(r104).setControllerListener(new p(this)).setAutoPlayAnimations(true).build());
        return;
    L79:
        return;
    L58:
        r130 = null;
        goto L59
    L61:
        if ((r100 instanceof j8) == false) goto L63;
        r131 = ((j8) r100).get_matchText();
    L63:
        r131 = null;
        goto L64
    L42:
        r120 = null;
        goto L43
    L38:
        r118 = null;
        goto L39
    L31:
        r114 = null;
        goto L32
    L25:
        r112 = null;
        goto L26
    L18:
        r109 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L10:
        r105 = null;
        goto L11
    }

    public PkRandomView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f97004a = new LinkedHashMap();
        this.f97006c = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_item_pk_random_emoji, this);
        this.f97007d = com.bytedance.android.live.revlink.impl.global.b.j();
        StringBuilder r103 = new StringBuilder("https://");
        String r104 = k0.f90841a;
        String r105 = k0.f90841a;
        r103.append(r105);
        r103.append("/obj/live-android/pk_random_new_bg.png");
        this.f97008e = r103.toString();
        this.f97009f = "https://" + r105 + "/obj/live-android/pk_random_guest_avatar.webp";
        this.f97010g = "https://" + r105 + "/obj/live-android/pk_random_btn_anim.webp";
        l51.a.M(l51.a.p() + 1);
    }
}
