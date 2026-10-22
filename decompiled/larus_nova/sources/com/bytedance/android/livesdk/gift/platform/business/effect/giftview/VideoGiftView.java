package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.gift.effect.model.EffectMessage;
import com.bytedance.android.livesdk.gift.model.q2;
import com.bytedance.android.livesdk.gift.model.r3;
import com.bytedance.android.livesdk.gift.model.s3;
import com.bytedance.android.livesdk.gift.model.t3;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.GiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.NewGiftSwitchImageView;
import com.bytedance.android.livesdk.gift.platform.business.effect.utils.VideoGiftLinkMonitor;
import com.bytedance.android.livesdk.gift.platform.business.effect.widget.BaseVideoGiftWidget;
import com.bytedance.android.livesdk.gift.platform.core.utils.recorder.ErrorNo;
import com.bytedance.android.livesdk.message.model.zb;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.text.RevRenderConfig;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayController;
import com.bytedance.android.livesdkapi.depend.live.gift.SuperResolutionModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.live.alphaplayer.model.MaskSrc;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.tencent.open.SocialConstants;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public class VideoGiftView extends FrameLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f129341v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f129342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f129343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GiftSwitchImageView f129344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NewGiftSwitchImageView f129345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f129346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zb.a f129347f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f129348g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.livesdk.gift.platform.business.effect.player.f f129349h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, Object> f129350i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Runnable f129351j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f129352k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f129353l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EffectMessage f129354m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f129355n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public i f129356o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public dq2.d f129357p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f129358q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<Long> f129359r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f129360s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f129361t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f129362u;

    public final void e() {
        if (this.f129347f != null) goto L5;
        return;
    L5:
        this.f129343b.setVisibility(0);
        ObjectAnimator r100 = ObjectAnimator.ofFloat(this.f129343b, "alpha", new float[]{0.0f, 0.0f}).setDuration(this.f129347f.getStart());
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f129343b, "alpha", new float[]{0.0f, 1.0f}).setDuration(500);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f129343b, "alpha", new float[]{1.0f, 1.0f}).setDuration(this.f129347f.getDuration() - 500);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f129343b, "alpha", new float[]{1.0f, 0.0f}).setDuration(500);
        AnimatorSet r104 = new AnimatorSet();
        r104.playSequentially(new Animator[]{r100, r101, r102, r103});
        r104.start();
    }

    public int getDuration() {
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r100 = this.f129349h;
        if (r100 == null) goto L8;
        ILiveGiftPlayController r101 = r100.f129438f;
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.getDuration();
    L8:
        return 0;
    }

    public String getPlayerType() {
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r100 = this.f129349h;
        if (r100 == null) goto L8;
        ILiveGiftPlayController r101 = r100.f129438f;
        if (r101 != null) goto L7;
        return "unknown";
    L7:
        return r101.getPlayerType();
    L8:
        return "unknown";
    }

    private int getResourceLayout() {
        if (PadConfigUtils.c() == false) goto L5;
        return R.layout.ttlive_view_video_gift_pad;
    L5:
        if (com.bytedance.android.livesdk.gift.util.a.a() == true) goto L11;
        return R.layout.ttlive_view_video_gift;
    L11:
        return R.layout.ttlive_view_video_gift_pad;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable r100 = this.f129351j;
        if (r100 == null) goto L5;
        removeCallbacks(r100);
    L5:
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r101 = this.f129349h;
        if (r101 == null) goto L9;
        r101.a();
        return;
    }

    public FrameLayout getVideoContainer() {
        return this.f129342a;
    }

    public VideoGiftView(Context r100) {
        super(r100);
        this.f129350i = new HashMap();
        this.f129358q = false;
        this.f129359r = new ArrayList();
        this.f129361t = 0;
        this.f129362u = 0;
        b(r100);
    }

    public static void c(EffectMessage r100) {
        HashMap r101 = new HashMap();
        i02.g r102 = m02.f.b(r100.f126020d);
        if (r102 != null) goto L5;
        return;
    L5:
        if (PadConfigUtils.c() == false) goto L10;
        if (r102.portrait == null) goto L19;
        r101.put("origin_resolution_ratio", r102.portrait.videoWidth + "*" + r102.portrait.videoHeight);
    L19:
        r101.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, r100.f126028l + "");
        com.bytedance.android.livesdk.gift.platform.core.utils.h.d0("livesdk_gift_resolution_change", r101);
        return;
    L10:
        if (r102.landscape == null) goto L15;
        if (e5.n() == false) goto L15;
        r101.put("origin_resolution_ratio", r102.landscape.videoWidth + "*" + r102.landscape.videoHeight);
    L15:
        if (r102.portrait == null) goto L19;
        if (e5.n() == true) goto L19;
        r101.put("origin_resolution_ratio", r102.portrait.videoWidth + "*" + r102.portrait.videoHeight);
        goto L19
    }

    private void setTextEffect(zb r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f129346e == false) goto L7;
        zb.a r101 = r100.getPortraitDetail();
    L8:
        this.f129347f = r101;
        return;
    L7:
        r101 = r100.getLandscapeDetail();
        goto L8
    }

    public final void a(EffectMessage r100) {
        Map<String, Object> r101 = this.f129350i;
        HashMap r102 = (HashMap) r101;
        r102.put(MobConstants.EFFECT_ID, Long.valueOf(r100.f126018b));
        Map<String, Object> r103 = this.f129350i;
        HashMap r104 = (HashMap) r103;
        r104.put(ILiveRoomPlayFragmentConstant.ENTER_LIVE_GITF_ID, Long.valueOf(r100.f126028l));
        Map<String, Object> r105 = this.f129350i;
        HashMap r106 = (HashMap) r105;
        r106.put("msg_id", Long.valueOf(r100.f126017a));
        Map<String, Object> r107 = this.f129350i;
        IBaseUser r108 = r100.f126025i;
        if (r108 == null) goto L5;
        String r109 = String.valueOf(r108.getIdString());
    L6:
        ((HashMap) r107).put("from_user_id", r109);
        Map<String, Object> r110 = this.f129350i;
        HashMap r111 = (HashMap) r110;
        r111.put("log_id", r100.f126030n);
        jy0.b.d("ttlive_gift", this.f129350i.toString());
        return;
    L5:
        r109 = "";
        goto L6
    }

    public final void b(Context r100) {
        getResources().getDimension(R.dimen.ttlive_video_gift_user_view_margin_top_80);
        getResources().getDimension(R.dimen.ttlive_video_gift_user_view_margin_top_140);
        LayoutInflater.from(r100).inflate(getResourceLayout(), this, true);
        this.f129342a = (FrameLayout) findViewById(R.id.video_view);
        this.f129343b = findViewById(R.id.text_effect_body);
        ImageView r101 = (ImageView) findViewById(R.id.text_effect_iv);
        TextView r102 = (TextView) findViewById(R.id.text_effect_tv);
        this.f129344c = (GiftSwitchImageView) findViewById(R.id.switch_button);
        this.f129345d = (NewGiftSwitchImageView) findViewById(R.id.switch_button_new);
        ((HashMap) this.f129350i).put(SocialConstants.PARAM_APP_DESC, "播放大礼物动画");
        List r103 = (List) com.bytedance.android.livesdk.gift.platform.business.b.f126535b.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.f126533a[0]);
        if (r103 == null) goto L6;
        ((ArrayList) this.f129359r).addAll(r103);
        return;
    }

    public final void d(boolean r100) {
        com.bytedance.android.livesdk.gift.platform.business.effect.player.f r101 = this.f129349h;
        if (r101 == null) goto L10;
        ILiveGiftPlayController r102 = r101.f129438f;
        if (r102 == null) goto L11;
        if (r100 == false) goto L8;
        r102.attachAlphaView(r101.f129434b);
        return;
    L8:
        r102.detachAlphaView(r101.f129434b);
        return;
    L11:
        return;
    }

    public void setPortrait(boolean r100) {
        this.f129346e = r100;
    }

    public VideoGiftView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f129350i = new HashMap();
        this.f129358q = false;
        this.f129359r = new ArrayList();
        this.f129361t = 0;
        this.f129362u = 0;
        b(r100);
    }

    public final boolean f(EffectMessage r100, BaseVideoGiftWidget.c r101) {
        if (this.f129349h == null) goto L6;
        this.f129351j = r101;
        this.f129348g = r100.f126020d;
        setTextEffect(r100.f126027k);
        a(r100);
        setVisibility(0);
        e();
        postDelayed(r101, 1500);
        return true;
    L6:
        return false;
    }

    public final boolean g(final EffectMessage r210, final SuperResolutionModel r211) {
        EffectMessage r100 = r210;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a r101 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.f132070d;
        r101.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a r102 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C2088a.f132074e;
        r102.f132073c.d(Long.valueOf(r100.f126017a), "startVideoGift");
        if (this.f129349h == null) goto L54;
        this.f129354m = r100;
        this.f129355n = r100.f126028l;
        this.f129360s = r100.f126018b;
        setTextEffect(r100.f126027k);
        this.f129348g = r100.f126020d;
        a(r210);
        VideoGiftLinkMonitor.a(VideoGiftLinkMonitor.Event.playcontroller_receive, r100.f126017a, r100.f126028l, r100.f126018b);
        final ArrayList r110 = new ArrayList();
        IBaseUser r103 = r100.f126024h;
        if (r103 == null) goto L7;
        r103.getIdString();
    L7:
        com.bytedance.android.livesdk.gift.model.a r104 = r100.f126033q;
        if (r104 == null) goto L15;
        s3 r105 = r104.f126379d;
        if (r105 == null) goto L15;
        jy0.b.d("GiftEnterQueue", "delegate to enter queue");
        com.bytedance.android.live.revenue.core.b r106 = com.bytedance.android.live.revenue.core.util.j.C0.a();
        if (r106 == null) goto L14;
        ((com.bytedance.android.livesdk.revenue.service.interactivity.a) com.bytedance.android.live.revenue.core.util.e.b(r106, com.bytedance.android.livesdk.revenue.service.interactivity.a.class)).U4(r105.f126413a, r105.f126414b, r105.f126415c, r105.f126416d, r105.f126417e, this.f129356o, r105.f126418f);
    L14:
        return true;
    L15:
        if (r104 != null) goto L18;
    L25:
        boolean r107 = true;
    L27:
        if (r107 == false) goto L35;
        r101.getClass();
        r102.f132073c.g(Long.valueOf(r100.f126017a), "start mGiftPlayerLifecycleController.start " + r100.f126020d, new j());
        if (r211 == null) goto L34;
        if (r211.getOpenSR() == false) goto L34;
        c(r210);
    L34:
        return this.f129349h.b(r100.f126020d, r100.f126017a, r100.f126028l, r100.f126018b, r110, r211, r100.f126041y, r210);
    L35:
        Iterator<r3> r108 = r100.f126033q.f126377b.iterator();
    L37:
        if (r108.hasNext() == false) goto L45;
        r3 r109 = r108.next();
        MaskSrc r111 = new MaskSrc();
        r111.f451155a = r109.f126408a;
        r111.f451156b = 0;
        r111.f451157c = r109.f126409b;
        Long r112 = r109.f126410c;
        if (r112 == null) goto L41;
        r111.f451159e = s1.f(r112.intValue());
    L41:
        String r113 = r109.f126411d;
        if (r113 == null) goto L44;
        r111.f451158d = r113;
    L44:
        r110.add(r111);
        goto L37
    L45:
        Iterator<q2> r114 = r100.f126033q.f126376a.iterator();
    L47:
        if (r114.hasNext() == false) goto L49;
        final q2 r115 = r114.next();
        a1.k(r115.f126407b).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(this, r110, r115, r210, r211), new f(this, r210, r115, r110, r211));
        r100 = r100;
        goto L47
    L49:
        EffectMessage r116 = r100;
        t3 r117 = r116.f126033q.f126378c;
        if (r117 == null) goto L53;
        Bitmap[] r118 = new Bitmap[1];
        ((ur2.a) com.bytedance.android.live.revenue.core.util.e.a(ur2.a.class)).a4(r117.f126419a, RevRenderConfig.SyncDecodeContext, new m(this, s1.f(r117.f126420b), s1.f(r117.f126421c), r118));
        Bitmap r119 = r118[0];
        MaskSrc r120 = new MaskSrc();
        r120.f451155a = "{default_image}";
        r120.f451156b = 1;
        r120.f451161g = r119;
        r110.add(r120);
        return this.f129349h.b(r116.f126020d, r116.f126017a, r116.f126028l, r116.f126018b, r110, r211, r116.f126041y, r210);
    L53:
        return true;
    L18:
        if (r104.f126376a.isEmpty() == true) goto L20;
    L26:
        r107 = false;
        goto L27
    L20:
        if (r100.f126033q.f126377b.isEmpty() == false) goto L26;
        com.bytedance.android.livesdk.gift.model.a r121 = r100.f126033q;
        if (r121.f126378c != null) goto L26;
        if (r121.f126379d != null) goto L26;
    L54:
        r101.getClass();
        r102.f132073c.a(Long.valueOf(r100.f126017a), "startVideoGift-mGiftPlayerLifecycleController" + this.f129349h + " msg:" + r100, new com.bytedance.android.livesdk.gift.platform.core.utils.recorder.d(ErrorNo.OBJECT_NULL, "mGiftPlayerLifecycleController or msg null"));
        return false;
    }

    public VideoGiftView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f129350i = new HashMap();
        this.f129358q = false;
        this.f129359r = new ArrayList();
        this.f129361t = 0;
        this.f129362u = 0;
        b(r100);
    }
}
