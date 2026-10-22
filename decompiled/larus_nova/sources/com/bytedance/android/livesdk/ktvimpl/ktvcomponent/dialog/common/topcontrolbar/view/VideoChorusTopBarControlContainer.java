package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.videochorus.VideoChorusFirstLevelTabManager$initTopControlBarAction$1;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.model.MusicOperateType;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/VideoChorusTopBarControlContainer;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/topcontrolbar/view/KtvCommonTopBarControlContainer;", "", "getCurMusicProgress", "getCurMusicTotalTime", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvComponentOrderedSongDataContext;", "getOrderedSongContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/KtvComponentOrderedSongDataContext;", "orderedSongContext", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getFirstOrderedSong", "()Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "firstOrderedSong", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoChorusTopBarControlContainer extends KtvCommonTopBarControlContainer {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f144187s = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f144188q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Disposable f144189r;

    public static final class a {
    }

    public static final class b extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f144190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoChorusTopBarControlContainer f144191b;

        public b(TextView r100, VideoChorusTopBarControlContainer r101) {
            this.f144190a = r100;
            this.f144191b = r101;
        }

        @Override // android.view.View.AccessibilityDelegate
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfo r101) {
            Intrinsics.checkNotNullParameter(r100, "host");
            Intrinsics.checkNotNullParameter(r101, "info");
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            String r102 = this.f144190a.getText().toString();
            VideoChorusTopBarControlContainer r103 = this.f144191b;
            int r104 = VideoChorusTopBarControlContainer.f144187s;
            r103.getClass();
            List r105 = StringsKt.split$default(r102, new String[]{":"}, false, 0, 6, null);
            if (r105.size() != 2) goto L8;
            Integer r106 = StringsKt.toIntOrNull((String) ListProtector.get(r105, 0));
            Integer r107 = StringsKt.toIntOrNull((String) ListProtector.get(r105, 1));
            if (r106 == null) goto L8;
            if (r107 == null) goto L8;
            String r108 = String.valueOf(r106.intValue()) + "分" + String.valueOf(r107.intValue()) + "秒";
        L9:
            this.f144190a.setText(r102);
            this.f144190a.setContentDescription(r108);
            return;
        L8:
            r108 = r102;
            goto L9
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, androidx.lifecycle.LifecycleOwner
    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.CC.$default$getLifecycle(this);
    }

    private final long getCurMusicProgress() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r100 = VideoChorusDataContext.Companion.a();
        if (r100 == null) goto L7;
        jd2.c r101 = r100.f();
        if (r101 == null) goto L7;
        return r101.f498227b;
    L7:
        return 0;
    }

    private final long getCurMusicTotalTime() {
        KtvMusic.a r100 = KtvMusic.Companion;
        MusicPanel r101 = getFirstOrderedSong();
        if (r101 == null) goto L5;
        KtvMusic r102 = r101.f153577a;
    L6:
        r100.getClass();
        return KtvMusic.a.a(r102) * 1000;
    L5:
        r102 = null;
        goto L6
    }

    private final KtvComponentOrderedSongDataContext getOrderedSongContext() {
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    private final MusicPanel getFirstOrderedSong() {
        KtvComponentOrderedSongDataContext r100 = getOrderedSongContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getKtvPublicFirstOrderedSong();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void b() {
        LinearLayout r100 = getMusicOperateContainer();
        if (r100 == null) goto L31;
        r100.removeAllViews();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L7;
    L20:
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
    L22:
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L29;
        MusicPanel r106 = getFirstOrderedSong();
        if (r106 == null) goto L32;
        KtvMusic r107 = r106.f153577a;
        if (r107 != null) goto L28;
        return;
    L28:
        if (KtvUtilsKt.w(r107) == true) goto L29;
        return;
    L32:
        return;
    L29:
        MusicOperateType r108 = MusicOperateType.SILENCE;
        MusicOperateView r109 = ie2.b.a(r108, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r109.f144172a = "request_song";
        Unit r110 = Unit.INSTANCE;
        a(r109, r108);
        return;
    L7:
        if (KtvUtilsKt.j() == true) goto L20;
        MusicPanel r111 = getFirstOrderedSong();
        if (r111 == null) goto L15;
        KtvMusic r112 = r111.f153577a;
        if (r112 == null) goto L15;
        if (KtvUtilsKt.w(r112) == true) goto L20;
    L15:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r113 = VideoChorusDataContext.Companion.a();
        if (r113 == null) goto L22;
        if (r113.i() != true) goto L22;
        MusicOperateType r114 = MusicOperateType.ADJUST;
        MusicOperateView r115 = ie2.b.a(r114, getContext());
        getOuterInjectCallback().a();
        Intrinsics.checkNotNullParameter("request_song", "requestPage");
        r115.f144172a = "request_song";
        Unit r116 = Unit.INSTANCE;
        a(r115, r114);
        goto L22
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void c() {
        TextView r100 = getBusinessSwitch();
        if (r100 == null) goto L5;
        r100.setVisibility(8);
    L5:
        k();
    }

    public final void k() {
        HSImageView r100 = getMusicCoverIv();
        String r101 = null;
        if (r100 == null) goto L26;
        MusicPanel r102 = getFirstOrderedSong();
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
        MusicPanel r107 = getFirstOrderedSong();
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
        l(getCurMusicProgress(), getCurMusicTotalTime());
        TextView r110 = getMusicNameTv();
        if (r110 == null) goto L35;
        MusicPanel r111 = getFirstOrderedSong();
        if (r111 == null) goto L33;
        KtvMusic r112 = r111.f153577a;
        if (r112 == null) goto L33;
        r101 = r112.getMTitle();
    L33:
        r110.setText(r101);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r100 = VideoChorusDataContext.Companion.a();
        Disposable r101 = this.f144189r;
        if (r101 != null) goto L5;
    L6:
        this.f144189r = Observable.interval(0, this.f144188q, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new r(this, r100), s.f144209a);
        return;
    L5:
        if (r101.isDisposed() == true) goto L6;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable r100 = this.f144189r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        r100.dispose();
        return;
    }

    public static final /* synthetic */ long h(VideoChorusTopBarControlContainer r100) {
        return r100.getCurMusicProgress();
    }

    public static final /* synthetic */ long i(VideoChorusTopBarControlContainer r100) {
        return r100.getCurMusicTotalTime();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.topcontrolbar.view.KtvCommonTopBarControlContainer
    public final void e(boolean r110) {
        FrameLayout r100 = getUserInfoContainer();
        if (r100 == null) goto L5;
        r100.removeAllViews();
    L5:
        jd2.a r101 = null;
        py.k r102 = null;
        if (r110 == false) goto L43;
        getKtvCommonSingleAvatarView().setVisibility(0);
        FrameLayout r111 = getUserInfoContainer();
        if (r111 == null) goto L10;
        r111.addView(getKtvCommonSingleAvatarView());
    L10:
        MusicPanel r103 = getFirstOrderedSong();
        if (r103 == null) goto L19;
        KtvMusic r104 = r103.f153577a;
        if (r104 == null) goto L19;
        OrderInfo r105 = r104.getOrderInfo();
        if (r105 == null) goto L19;
        InteractiveSongUserInfo r106 = r105.getTopUser();
        if (r106 == null) goto L19;
        py.k r107 = r106.getAvatarThumbFlex();
    L21:
        if ((r107 instanceof py.k) == false) goto L24;
        r102 = r107;
    L24:
        if (r102 != null) goto L26;
        r102 = qy.a.c();
    L26:
        MusicPanel r108 = getFirstOrderedSong();
        if (r108 == null) goto L36;
        KtvMusic r109 = r108.f153577a;
        if (r109 == null) goto L36;
        OrderInfo r112 = r109.getOrderInfo();
        if (r112 == null) goto L36;
        InteractiveSongUserInfo r113 = r112.getTopUser();
        if (r113 == null) goto L36;
        String r114 = r113.getNickNameFlex();
        if (r114 == null) goto L36;
    L37:
        Pair r115 = new Pair(r102, r114);
        KtvCommonSingleAvatarView r116 = getKtvCommonSingleAvatarView();
        py.k r117 = (py.k) r115.getFirst();
        String r118 = (String) r115.getSecond();
        r116.getClass();
        Intrinsics.checkNotNullParameter(r117, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Intrinsics.checkNotNullParameter(r118, "userName");
        HSImageView r119 = r116.f144133a;
        if (r119 == null) goto L40;
        ImageUtil.loadRoundImage(r119, r117);
    L40:
        TextView r120 = r116.f144134b;
        if (r120 == null) goto L65;
        r120.setText(r118);
        return;
    L65:
        return;
    L36:
        r114 = "";
    L19:
        r107 = null;
        goto L21
    L43:
        getKtvCommonStackAvatarView().setVisibility(0);
        FrameLayout r121 = getUserInfoContainer();
        if (r121 == null) goto L46;
        r121.addView(getKtvCommonStackAvatarView());
    L46:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r122 = VideoChorusDataContext.Companion.a();
        if (r122 == null) goto L49;
        r101 = r122.o();
    L49:
        py.k r123 = qy.a.c();
        if (r101 == null) goto L53;
        Collection r124 = r101.f498219c;
        if (r124 == null) goto L53;
    L54:
        List<? extends py.k> r125 = CollectionsKt.toMutableList(r124);
        r125.add(r123);
        KtvCommonStackAvatarView r126 = getKtvCommonStackAvatarView();
        if (r101 == null) goto L58;
        String r127 = r101.f498217a;
        if (r127 == null) goto L58;
    L59:
        String r128 = r127;
        if (r101 == null) goto L62;
        int r129 = r101.f498218b;
    L63:
        r126.r(r125, r128, r129, r125.size(), "scene_video_chorus_top_control");
        return;
    L62:
        r129 = 0;
    L58:
        r127 = "0";
    L53:
        r124 = new ArrayList();
        goto L54
    }

    public final void j(jd2.c r100) {
        if (r100 != null) goto L4;
    L10:
        f(8);
        return;
    L4:
        if (r100.f498226a == 0) goto L10;
        if (getFirstOrderedSong() == null) goto L10;
        k();
        f(0);
    }

    public VideoChorusTopBarControlContainer(VideoChorusFirstLevelTabManager$initTopControlBarAction$1.a r100, Context r101) {
        super(r100, r101);
        this.f144188q = 1000;
        boolean r102 = false;
        f(0);
        VideoChorusDataContext.a r103 = VideoChorusDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r104 = r103.a();
        if (r104 == null) goto L5;
        jd2.c r105 = r104.f();
    L6:
        j(r105);
        KtvComponentOrderedSongDataContext r106 = getOrderedSongContext();
        if (r106 == null) goto L11;
        Disposable r107 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r106, null, new n(this), 3);
        if (r107 == null) goto L11;
        RxUtilKt.c(r107, getCompositeDisposable());
    L11:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r108 = r103.a();
        if (r108 == null) goto L14;
        r108.l(this, new o(this));
    L14:
        IMiddlewareUserService r109 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r109 == null) goto L23;
        com.bytedance.android.livesdk.user.e r110 = r109.user();
        if (r110 == null) goto L23;
        Observable<? extends UserAttr> r111 = r110.u();
        if (r111 == null) goto L23;
        Disposable r112 = r111.subscribe(new p(this));
        if (r112 == null) goto L23;
        RxUtilKt.c(r112, getCompositeDisposable());
    L23:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r113 = r103.a();
        if (r113 == null) goto L30;
        jd2.a r114 = r113.o();
        if (r114 == null) goto L30;
        if (r114.f498218b != 1) goto L30;
        r102 = true;
    L30:
        e(r102);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r115 = r103.a();
        if (r115 == null) goto L34;
        r115.r(this, new q(this));
        return;
    L34:
        return;
    L5:
        r105 = null;
        goto L6
    }

    public final void l(long r100, long r101) {
        long r102 = r101 - r100;
        if (r102 > 0) goto L6;
        r102 = 0;
    L6:
        SimpleDateFormat r103 = new SimpleDateFormat("mm:ss", Locale.US);
        TextView r104 = getMusicTimeTv();
        if (r104 == null) goto L10;
        r104.setText(s1.C(R.string.ttlive_ktv_cur_music_count_down_progress, new Object[]{r103.format(Long.valueOf(r102))}));
        r104.setAccessibilityDelegate(new b(r104, this));
        return;
    }
}
