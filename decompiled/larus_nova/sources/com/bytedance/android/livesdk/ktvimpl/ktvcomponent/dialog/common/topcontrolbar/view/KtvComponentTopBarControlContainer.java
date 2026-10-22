package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.manager.KtvComponentFirstLevelTabManager$initTopControlBarAction$1;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusViewModel;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.BusinessSwitchState;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvComponentTopBarControlContainer;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonTopBarControlContainer;", "com/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvComponentTopBarControlContainer$mKtvCoreListener$2$a", "s", "Lkotlin/Lazy;", "getMKtvCoreListener", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvComponentTopBarControlContainer$mKtvCoreListener$2$a;", "mKtvCoreListener", "Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "", "t", "getLinkPlayerStateObserver", "()Lcom/bytedance/android/livesdk/app/dataholder/Observer;", "linkPlayerStateObserver", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentTopBarControlContainer extends KtvCommonTopBarControlContainer {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f144162u = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f144163q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f144164r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f144165s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f144166t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvComponentTopBarControlContainer f144167a;

        public b(KtvComponentTopBarControlContainer r100) {
            this.f144167a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            fd2.a r101 = (fd2.a) r100;
            KtvContext.Companion.getClass();
            if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L12;
            KtvComponentTopBarControlContainer r102 = this.f144167a;
            int r103 = KtvComponentTopBarControlContainer.f144162u;
            r102.getClass();
            if ((r101 instanceof fd2.a.b) == false) goto L7;
        L10:
            r102.p(com.bytedance.android.livesdk.ktvimpl.multichorus.c.c(), com.bytedance.android.livesdk.ktvimpl.multichorus.c.d());
            return;
        L7:
            if ((r101 instanceof fd2.a.d) == true) goto L10;
            if ((r101 instanceof fd2.a.c) == true) goto L10;
            return;
        }
    }

    public static final class c extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f144168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ KtvComponentTopBarControlContainer f144169b;

        public c(TextView r100, KtvComponentTopBarControlContainer r101) {
            this.f144168a = r100;
            this.f144169b = r101;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "info");
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            String r102 = this.f144168a.getText().toString();
            KtvComponentTopBarControlContainer r103 = this.f144169b;
            int r104 = KtvComponentTopBarControlContainer.f144162u;
            r103.getClass();
            List r105 = StringsKt.split$default(r102, new String[]{":"}, false, 0, 6, null);
            if (r105.size() != 2) goto L8;
            Integer r106 = StringsKt.toIntOrNull((String) ListProtector.get(r105, 0));
            Integer r107 = StringsKt.toIntOrNull((String) ListProtector.get(r105, 1));
            if (r106 == null) goto L8;
            if (r107 == null) goto L8;
            String r108 = String.valueOf(r106.intValue()) + "分" + String.valueOf(r107.intValue()) + "秒";
        L9:
            this.f144168a.setText(r102);
            this.f144168a.setContentDescription(r108);
            return;
        L8:
            r108 = r102;
            goto L9
        }
    }

    static {
    }

    private final Observer<Integer> getLinkPlayerStateObserver() {
        return (Observer) this.f144166t.getValue();
    }

    private final KtvComponentTopBarControlContainer$mKtvCoreListener$2.a getMKtvCoreListener() {
        return (KtvComponentTopBarControlContainer$mKtvCoreListener$2.a) this.f144165s.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    public final void k() {
        Disposable r100 = this.f144164r;
        if (r100 == null) goto L5;
        getCompositeDisposable().remove(r100);
    L5:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.i r101 = KtvContext.a.g().getKtvCoreController().getValue();
        if (r101 == null) goto L10;
        PublishSubject<fd2.a> r102 = r101.f142522g;
        if (r102 == null) goto L10;
        Disposable r103 = r102.subscribe(new b(this));
    L11:
        this.f144164r = r103;
        if (r103 == null) goto L15;
        getCompositeDisposable().add(r103);
        return;
    L15:
        return;
    L10:
        r103 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void b() {
        LinearLayout r100 = getMusicOperateContainer();
        if (r100 == null) goto L6;
        r100.removeAllViews();
        MusicOperateType r101 = MusicOperateType.ADJUST;
        MusicOperateView r102 = ie2.b.a(r101, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r102.f144172a = "request_song";
        Unit r103 = Unit.INSTANCE;
        a(r102, r101);
        MusicOperateType r104 = MusicOperateType.PAUSE_RESTART;
        MusicOperateView r105 = ie2.b.a(r104, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r105.f144172a = "request_song";
        a(r105, r104);
        MusicOperateType r106 = MusicOperateType.CHALLENGE;
        MusicOperateView r107 = ie2.b.a(r106, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r107.f144172a = "request_song";
        a(r107, r106);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void c() {
        TextView r100 = getBusinessSwitch();
        if (r100 == null) goto L5;
        r100.setOnClickListener(x0.a(new KtvComponentTopBarControlContainer$bindOtherView$1(this)));
    L5:
        o();
    }

    public final void j() {
        o();
        com.bytedance.android.livesdk.ktvimpl.base.util.j r100 = com.bytedance.android.livesdk.ktvimpl.base.util.j.f143561l;
        MusicPanel r101 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        List<MusicPanel> r102 = null;
        if (r101 == null) goto L5;
        KtvMusic r103 = r101.f153577a;
    L6:
        r100.getClass();
        boolean r104 = com.bytedance.android.livesdk.ktvimpl.base.util.j.d(r103);
        ChorusContext.a r105 = ChorusContext.Companion;
        boolean r106 = true;
        if (r105.c() == false) goto L20;
        ChorusContext r107 = r105.getContext();
        if (r107 == null) goto L11;
        r102 = r107.getChorusNotSelfSeeingMusicList();
    L11:
        List<MusicPanel> r108 = r102;
        if (r108 != null) goto L14;
    L17:
        boolean r109 = true;
    L18:
        if (r109 == false) goto L27;
    L25:
        r106 = false;
    L27:
        if (r106 == false) goto L40;
        if (r104 == false) goto L40;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L32;
    L39:
        f(0);
        return;
    L32:
        if (KtvUtilsKt.j() == true) goto L39;
        if (MultiChorusContext.Companion.c() == true) goto L39;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L39;
        f(8);
        return;
    L40:
        f(8);
        return;
    L14:
        if (r108.isEmpty() == true) goto L17;
        r109 = false;
        goto L18
    L20:
        KtvContext.Companion.getClass();
        List<MusicPanel> r110 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.c(KtvContext.a.g());
        if (r110 == null) goto L25;
        if ((!r110.isEmpty()) != true) goto L25;
    L5:
        r103 = null;
        goto L6
    }

    public final void m() {
        if (hd0.c.f().h() == false) goto L7;
        if (MultiChorusContext.Companion.b() == false) goto L7;
    L8:
        TextView r100 = getBusinessSwitch();
        if (r100 == null) goto L11;
        r100.setText(s1.B(R.string.ttlive_ktv_not_sing_tips));
    L11:
        TextView r101 = getBusinessSwitch();
        if (r101 == null) goto L14;
        r101.setTag(BusinessSwitchState.NOT_SING);
    L14:
        TextView r102 = getBusinessSwitch();
        if (r102 == null) goto L27;
        r102.setBackgroundResource(R.drawable.ttlive_ktv_business_switch_selected_bg);
        return;
    L27:
        return;
    L7:
        if (this.f144163q == true) goto L8;
        TextView r103 = getBusinessSwitch();
        if (r103 == null) goto L20;
        r103.setText(s1.B(R.string.ttlive_ktv_multi_chorus_tips));
    L20:
        TextView r104 = getBusinessSwitch();
        if (r104 == null) goto L23;
        r104.setTag(BusinessSwitchState.MULTI_CHORUS);
    L23:
        TextView r105 = getBusinessSwitch();
        if (r105 == null) goto L29;
        r105.setBackgroundResource(R.drawable.ttlive_ktv_business_switch_unselected_bg);
        return;
    }

    public final void o() {
        HSImageView r100 = getMusicCoverIv();
        String r101 = null;
        if (r100 == null) goto L26;
        MusicPanel r102 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r102 == null) goto L9;
        KtvMusic r103 = r102.f153577a;
        if (r103 == null) goto L9;
        String r104 = r103.getMNewCoverUrl();
    L11:
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L26;
        int r106 = qy.a.f535172a;
        MusicPanel r107 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r107 == null) goto L24;
        KtvMusic r108 = r107.f153577a;
        if (r108 == null) goto L24;
        String r109 = r108.getMNewCoverUrl();
    L25:
        ImageUtil.loadImageWithRadius(r100, qy.a.a(r109), 0, 4);
    L24:
        r109 = null;
        goto L25
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L9:
        r104 = null;
    L26:
        p(com.bytedance.android.livesdk.ktvimpl.multichorus.c.c(), com.bytedance.android.livesdk.ktvimpl.multichorus.c.d());
        TextView r110 = getMusicNameTv();
        if (r110 == null) goto L35;
        MusicPanel r111 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r111 == null) goto L33;
        KtvMusic r112 = r111.f153577a;
        if (r112 == null) goto L33;
        r101 = r112.getMTitle();
    L33:
        r110.setText(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r100 = KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r100 == null) goto L5;
        r100.unregisterKtvCoreListener(getMKtvCoreListener());
    L5:
        hd0.c.f().e(getLinkPlayerStateObserver());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void e(boolean r110) {
        FrameLayout r100 = getUserInfoContainer();
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        int r101 = 0;
        py.k r102 = null;
        if (r110 == false) goto L71;
        getKtvCommonSingleAvatarView().setVisibility(0);
        FrameLayout r111 = getUserInfoContainer();
        if (r111 == null) goto L10;
        r111.addView(getKtvCommonSingleAvatarView());
    L10:
        ChorusContext.a r112 = ChorusContext.Companion;
        String r103 = "";
        if (r112.c() == false) goto L36;
        ChorusContext r113 = r112.getContext();
        if (r113 == null) goto L19;
        List<MusicPanel> r114 = r113.getChorusNotSelfSeeingMusicList();
        if (r114 == null) goto L19;
        MusicPanel r115 = (MusicPanel) CollectionsKt.firstOrNull(r114);
        if (r115 == null) goto L19;
        InteractiveSongUserInfo r116 = r115.f();
    L21:
        if (r116 == null) goto L23;
        py.k r104 = r116.getAvatarThumbFlex();
    L25:
        if ((r104 instanceof py.k) == false) goto L28;
        r102 = r104;
    L28:
        if (r102 != null) goto L30;
        r102 = qy.a.c();
    L30:
        if (r116 == null) goto L35;
        String r117 = r116.getNickNameFlex();
        if (r117 == null) goto L35;
        r103 = r117;
    L35:
        Pair r105 = new Pair(r102, r103);
    L65:
        KtvCommonSingleAvatarView r118 = getKtvCommonSingleAvatarView();
        py.k r106 = (py.k) r105.getFirst();
        String r107 = (String) r105.getSecond();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r106, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r107, "userName");
        HSImageView r108 = r118.f144133a;
        if (r108 == null) goto L68;
        ImageUtil.loadRoundImage(r108, r106);
    L68:
        TextView r119 = r118.f144134b;
        if (r119 == null) goto L124;
        r119.setText(r107);
        return;
    L124:
        return;
    L23:
        r104 = null;
    L19:
        r116 = null;
        goto L21
    L36:
        KtvContext.Companion.getClass();
        MusicPanel r120 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r120 == null) goto L45;
        KtvMusic r121 = r120.f153577a;
        if (r121 == null) goto L45;
        OrderInfo r122 = r121.getOrderInfo();
        if (r122 == null) goto L45;
        InteractiveSongUserInfo r123 = r122.getTopUser();
        if (r123 == null) goto L45;
        py.k r124 = r123.getAvatarThumbFlex();
    L47:
        if ((r124 instanceof py.k) == false) goto L50;
        r102 = r124;
    L50:
        if (r102 != null) goto L52;
        r102 = qy.a.c();
    L52:
        MusicPanel r125 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.a(KtvContext.a.g());
        if (r125 == null) goto L64;
        KtvMusic r126 = r125.f153577a;
        if (r126 == null) goto L64;
        OrderInfo r127 = r126.getOrderInfo();
        if (r127 == null) goto L64;
        InteractiveSongUserInfo r128 = r127.getTopUser();
        if (r128 == null) goto L64;
        String r129 = r128.getNickNameFlex();
        if (r129 == null) goto L64;
        r103 = r129;
    L64:
        r105 = new Pair(r102, r103);
    L45:
        r124 = null;
        goto L47
    L71:
        getKtvCommonStackAvatarView().setVisibility(0);
        FrameLayout r130 = getUserInfoContainer();
        if (r130 == null) goto L74;
        r130.addView(getKtvCommonStackAvatarView());
    L74:
        ArrayList r131 = new ArrayList();
        ArrayList r109 = new ArrayList();
        List<jd2.e> r132 = MultiChorusContext.Companion.k();
        if (r132 == null) goto L80;
        Iterator<T> r133 = r132.iterator();
    L78:
        if (r133.hasNext() == false) goto L80;
        r109.add((jd2.e) r133.next());
    L80:
        KtvContext.Companion.getClass();
        if (KtvContext.a.d() == true) goto L99;
        Iterator r134 = r109.iterator();
        int r135 = 0;
    L85:
        if (r134.hasNext() == false) goto L99;
        Object r136 = r134.next();
        int r137 = r135 + 1;
        if (r135 >= 0) goto L89;
        CollectionsKt.throwIndexOverflow();
    L89:
        String r138 = ((jd2.e) r136).f498241a;
        IMiddlewareUserService r139 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r139 == null) goto L94;
        com.bytedance.android.livesdk.user.e r140 = r139.user();
        if (r140 == null) goto L94;
        String r141 = r140.n();
    L96:
        if (Intrinsics.areEqual(r138, r141) == true) goto L100;
        r135 = r137;
    L100:
        int r142 = r109.size();
        if (r135 < 0) goto L105;
        if (r142 <= r135) goto L105;
        ListProtector.add(r109, 1, ListProtector.remove(r109, r135));
    L105:
        Iterator r143 = r109.iterator();
    L107:
        if (r143.hasNext() == false) goto L112;
        py.k r144 = ((jd2.e) r143.next()).f498242b;
        if (r144 == null) goto L107;
        r131.add(r144);
        goto L107
    L112:
        if (r132 == null) goto L114;
        r101 = r132.size();
    L114:
        Pair r145 = new Pair(r131, Integer.valueOf(r101));
        getKtvCommonStackAvatarView().r((List) r145.getFirst(), String.valueOf(((Number) r145.getSecond()).intValue()), ((Number) r145.getSecond()).intValue(), 5, "scene_ktv_component");
        return;
    L94:
        r141 = null;
    L99:
        r135 = -1;
        goto L100
    }

    public final void h(List<MusicPanel> r100) {
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.size();
    L7:
        if (ChorusContext.Companion.c() == false) goto L16;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r103 = g(MusicOperateType.ADJUST);
        if (r103 == null) goto L17;
        if (r102 <= 0) goto L14;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L14;
        r101 = true;
    L14:
        r103.c(r101);
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r102 = 0;
        goto L7
    }

    public final void i(boolean r100) {
        MultiChorusContext.a r101 = MultiChorusContext.Companion;
        List<jd2.e> r102 = r101.k();
        if (r102 == null) goto L5;
        int r103 = r102.size();
    L6:
        boolean r104 = true;
        if (r103 <= 1) goto L10;
        r104 = false;
    L10:
        e(r104);
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L62;
        if (KtvUtilsKt.j() == true) goto L62;
        if (r101.c() == false) goto L47;
        if (r100 == false) goto L30;
        TextView r105 = getBusinessSwitch();
        if (r105 == null) goto L21;
        r105.setVisibility(8);
    L21:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r106 = g(MusicOperateType.ADJUST);
        if (r106 == null) goto L24;
        r106.g(0);
    L24:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r107 = g(MusicOperateType.PAUSE_RESTART);
        if (r107 == null) goto L27;
        r107.g(0);
    L27:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r108 = g(MusicOperateType.CHALLENGE);
        if (r108 == null) goto L126;
        r108.g(8);
    L126:
        if (getMusicOperateContainer() == null) goto L136;
        Iterator<T> r109 = getMusicOperateViewMap().values().iterator();
    L129:
        if (r109.hasNext() == false) goto L142;
        KeyEvent.Callback r110 = (View) r109.next();
        if ((r110 instanceof com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b) == true) goto L133;
        r110 = null;
    L133:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r111 = (com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b) r110;
        if (r111 == null) goto L129;
        r111.c(r100);
        goto L129
    L142:
        return;
    L136:
        return;
    L30:
        TextView r112 = getBusinessSwitch();
        if (r112 == null) goto L33;
        r112.setVisibility(0);
    L33:
        m();
        if (r101.b() == false) goto L38;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r113 = g(MusicOperateType.ADJUST);
        if (r113 == null) goto L41;
        r113.g(0);
    L41:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r114 = g(MusicOperateType.PAUSE_RESTART);
        if (r114 == null) goto L44;
        r114.g(8);
    L44:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r115 = g(MusicOperateType.CHALLENGE);
        if (r115 == null) goto L126;
        r115.g(8);
        goto L126
    L38:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r116 = g(MusicOperateType.ADJUST);
        if (r116 == null) goto L41;
        r116.g(8);
        goto L41
    L47:
        if (r100 == false) goto L57;
        TextView r117 = getBusinessSwitch();
        if (r117 == null) goto L51;
        r117.setVisibility(8);
    L51:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r118 = g(MusicOperateType.ADJUST);
        if (r118 == null) goto L54;
        r118.g(0);
    L54:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r119 = g(MusicOperateType.PAUSE_RESTART);
        if (r119 == null) goto L58;
        r119.g(0);
    L58:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r120 = g(MusicOperateType.CHALLENGE);
        if (r120 == null) goto L126;
        r120.g(8);
        goto L126
    L57:
        f(8);
    L62:
        if (ChorusContext.Companion.c() == false) goto L78;
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L78;
        TextView r121 = getBusinessSwitch();
        if (r121 == null) goto L68;
        r121.setVisibility(8);
    L68:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r122 = g(MusicOperateType.ADJUST);
        if (r122 == null) goto L71;
        r122.g(0);
    L71:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r123 = g(MusicOperateType.PAUSE_RESTART);
        if (r123 == null) goto L74;
        r123.g(0);
    L74:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r124 = g(MusicOperateType.CHALLENGE);
        if (r124 == null) goto L126;
        r124.g(8);
    L78:
        if (r101.c() == false) goto L109;
        if (r100 == false) goto L92;
        TextView r125 = getBusinessSwitch();
        if (r125 == null) goto L83;
        r125.setVisibility(8);
    L83:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r126 = g(MusicOperateType.ADJUST);
        if (r126 == null) goto L86;
        r126.g(0);
    L86:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r127 = g(MusicOperateType.PAUSE_RESTART);
        if (r127 == null) goto L89;
        r127.g(0);
    L89:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r128 = g(MusicOperateType.CHALLENGE);
        if (r128 == null) goto L126;
        r128.g(8);
        goto L126
    L92:
        TextView r129 = getBusinessSwitch();
        if (r129 == null) goto L95;
        r129.setVisibility(0);
    L95:
        m();
        if (r101.b() == false) goto L100;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r130 = g(MusicOperateType.ADJUST);
        if (r130 == null) goto L103;
        r130.g(0);
    L103:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r131 = g(MusicOperateType.PAUSE_RESTART);
        if (r131 == null) goto L106;
        r131.g(0);
    L106:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r132 = g(MusicOperateType.CHALLENGE);
        if (r132 == null) goto L126;
        r132.g(8);
        goto L126
    L100:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r133 = g(MusicOperateType.ADJUST);
        if (r133 == null) goto L103;
        r133.g(8);
        goto L103
    L109:
        TextView r134 = getBusinessSwitch();
        if (r134 == null) goto L112;
        r134.setVisibility(8);
    L112:
        if (r100 == false) goto L116;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r135 = g(MusicOperateType.ADJUST);
        if (r135 == null) goto L119;
        r135.g(0);
    L119:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r136 = g(MusicOperateType.PAUSE_RESTART);
        if (r136 == null) goto L122;
        r136.g(0);
    L122:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r137 = g(MusicOperateType.CHALLENGE);
        if (r137 == null) goto L126;
        r137.g(0);
        goto L126
    L116:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.b r138 = g(MusicOperateType.ADJUST);
        if (r138 == null) goto L119;
        r138.g(8);
        goto L119
    L5:
        r103 = 0;
        goto L6
    }

    public final void l(com.bytedance.android.livesdk.ktvapi.util.e r100) {
        boolean r101 = false;
        if (hd0.c.f().h() == true) goto L25;
        Long r102 = null;
        if (r100 == null) goto L11;
        MusicPanel r103 = r100.f142340a;
        if (r103 == null) goto L11;
        KtvMusic r104 = r103.f153577a;
        if (r104 == null) goto L11;
        Long r105 = Long.valueOf(r104.getMId());
    L12:
        MusicPanel r106 = com.bytedance.android.livesdk.ktvimpl.multichorus.c.e();
        if (r106 == null) goto L18;
        KtvMusic r107 = r106.f153577a;
        if (r107 == null) goto L18;
        r102 = Long.valueOf(r107.getMId());
    L18:
        if (Intrinsics.areEqual(r105, r102) == false) goto L25;
        if (r100 != null) goto L21;
    L23:
        this.f144163q = r101;
        return;
    L21:
        if (r100.f142341b != true) goto L23;
        r101 = true;
    L11:
        r105 = null;
    L25:
        if (hd0.c.f().h() == true) goto L27;
        if (r100 == null) goto L27;
        return;
    L27:
        this.f144163q = false;
    }

    public KtvComponentTopBarControlContainer(KtvComponentFirstLevelTabManager$initTopControlBarAction$1.a r100, Context r110) {
        super(r100, r110);
        this.f144165s = LazyKt.lazy(new KtvComponentTopBarControlContainer$mKtvCoreListener$2(this));
        this.f144166t = LazyKt.lazy(new KtvComponentTopBarControlContainer$linkPlayerStateObserver$2(this));
        MultiChorusContext.a r101 = MultiChorusContext.Companion;
        MultiChorusContext r111 = r101.getContext();
        List<MusicPanel> r102 = null;
        if (r111 == null) goto L9;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvapi.util.a> r112 = r111.m8261getService();
        if (r112 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.a r113 = r112.getValue();
        if (r113 == null) goto L9;
        com.bytedance.android.livesdk.ktvapi.util.e r114 = r113.bj();
    L10:
        l(r114);
        f(8);
        KtvContext.Companion.getClass();
        Disposable r115 = KtvContext.a.g().getKtvCoreController().a().subscribe(new f(this));
        if (r115 == null) goto L13;
        RxUtilKt.c(r115, getCompositeDisposable());
    L13:
        k();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r116 = KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r116 == null) goto L16;
        r116.observerOnProgress(this, new AnonymousClass2(this));
    L16:
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r117 = KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r117 == null) goto L19;
        r117.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{"state"}), getMKtvCoreListener(), false);
    L19:
        j();
        KtvComponentOrderedSongDataContext r118 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r118 == null) goto L24;
        Disposable r119 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r118, null, new g(this), 3);
        if (r119 == null) goto L24;
        RxUtilKt.c(r119, getCompositeDisposable());
    L24:
        ChorusContext.a r120 = ChorusContext.Companion;
        ChorusContext r103 = r120.getContext();
        if (r103 == null) goto L33;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r104 = r103.getChorusSelectedSongList();
        if (r104 == null) goto L33;
        Observable<sh6.b<List<MusicPanel>>> r105 = r104.a();
        if (r105 == null) goto L33;
        Disposable r106 = r105.subscribe(new h(this));
        if (r106 == null) goto L33;
        RxUtilKt.c(r106, getCompositeDisposable());
    L33:
        Disposable r107 = KtvContext.a.g().getHasBgm().a().subscribe(new i(this));
        if (r107 == null) goto L36;
        RxUtilKt.c(r107, getCompositeDisposable());
    L36:
        i(KtvContext.a.g().isCurrentUserIsSinger());
        Disposable r108 = KtvContext.observerCurrentUserIsSinger$default(KtvContext.a.g(), null, false, new j(this), 3, null);
        if (r108 == null) goto L39;
        RxUtilKt.c(r108, getCompositeDisposable());
    L39:
        IMiddlewareUserService r109 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r109 == null) goto L48;
        com.bytedance.android.livesdk.user.e r121 = r109.user();
        if (r121 == null) goto L48;
        Observable<? extends UserAttr> r122 = r121.u();
        if (r122 == null) goto L48;
        Disposable r123 = r122.subscribe(new k(this));
        if (r123 == null) goto L48;
        RxUtilKt.c(r123, getCompositeDisposable());
    L48:
        ChorusContext r124 = r120.getContext();
        if (r124 == null) goto L53;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r125 = r124.getChorusSelectedSongList();
        if (r125 == null) goto L53;
        r102 = r125.getValue();
    L53:
        h(r102);
        ChorusContext r126 = r120.getContext();
        if (r126 == null) goto L62;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r127 = r126.getChorusSelectedSongList();
        if (r127 == null) goto L62;
        Observable<sh6.b<List<MusicPanel>>> r128 = r127.a();
        if (r128 == null) goto L62;
        Disposable r129 = r128.subscribe(new l(this));
        if (r129 == null) goto L62;
        RxUtilKt.c(r129, getCompositeDisposable());
    L62:
        r101.h(this, new m(this));
        ChorusContext r130 = r120.getContext();
        if (r130 == null) goto L71;
        com.bytedance.live.datacontext.j<ChorusViewModel> r131 = r130.getChorusViewModel();
        if (r131 == null) goto L71;
        ChorusViewModel r132 = r131.getValue();
        if (r132 == null) goto L71;
        MutableLiveData<Boolean> r133 = r132.getOpenStatus();
        if (r133 == null) goto L71;
        r133.observe(this, new com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.c(this));
    L71:
        Disposable r134 = r101.g(new d(this));
        if (r134 == null) goto L74;
        RxUtilKt.c(r134, getCompositeDisposable());
    L74:
        r101.i(this, new e(this));
        hd0.c.f().c(getLinkPlayerStateObserver());
        return;
    L9:
        r114 = null;
        goto L10
    }

    public final void p(long r100, long r101) {
        long r102 = r101 - r100;
        if (r102 > 0) goto L6;
        r102 = 0;
    L6:
        SimpleDateFormat r103 = new SimpleDateFormat("mm:ss", Locale.US);
        TextView r104 = getMusicTimeTv();
        if (r104 == null) goto L10;
        r104.setText(s1.C(R.string.ttlive_ktv_cur_music_count_down_progress, new Object[]{r103.format(Long.valueOf(r102))}));
        r104.setAccessibilityDelegate(new c(r104, this));
        return;
    }
}
