package com.bytedance.android.live.ktv.common.util;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.foundation.depend.HostLargeFontParam;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.en;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class KtvUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f70681a = null;

    public static final boolean I(int r100, int r101) {
        if (r100 != 9) goto L6;
        if (r101 != 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static final Set<Long> h() {
        return (Set) f70681a.getValue();
    }

    static {
        f70681a = LazyKt.lazy(LazyThreadSafetyMode.NONE, KtvUtilsKt$hasReportedIdSet$2.INSTANCE);
    }

    public static final boolean j() {
        IMiddlewareUserService r100 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.user.e r101 = r100.user();
    L6:
        if (r101 != null) goto L8;
    L16:
        return false;
    L8:
        if (r101.isAdmin() != true) goto L16;
        UserAttr r102 = r101.q();
        if (r102 == null) goto L16;
        List<Integer> r103 = r102.getAdminPrivileges();
        if (r103 == null) goto L16;
        LiveRoomPermission.D.getClass();
        if (r103.contains(Integer.valueOf(LiveRoomPermission.f105062l.f105077a)) != true) goto L16;
        return true;
    L5:
        r101 = null;
        goto L6
    }

    public static final boolean v() {
        com.bytedance.android.livesdk.chatroom.o r100 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.i<LiveMode> r101 = r100.getLiveMode();
        if (r101 == null) goto L7;
        LiveMode r102 = r101.getValue();
    L9:
        if (r102 != LiveMode.SCREEN_RECORD) goto L11;
        return true;
    L11:
        return false;
    L7:
        r102 = null;
        goto L9
    }

    public static final boolean A(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportLyricWithUrl");
        return !Lists.isEmpty(r100.f153577a.getMLyricUrlList());
    }

    public static final boolean B(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportMidiWithPath");
        return !TextUtils.isEmpty(r100.f153593q);
    }

    public static final boolean C(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportMidiWithUrl");
        return !TextUtils.isEmpty(r100.f153577a.getMidiUrl());
    }

    public static final boolean D(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportOriginSwitchWithPath");
        if (F(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (y(r100) == false) goto L7;
        return true;
    }

    public static final boolean E(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportOriginSwitchWithUrl");
        if (G(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (z(r100) == false) goto L7;
        return true;
    }

    public static final boolean F(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportOriginWithPath");
        return !TextUtils.isEmpty(r100.f153590n);
    }

    public static final boolean G(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportOriginWithUrl");
        AudioInfo r101 = r100.f153577a.getMFullTrack();
        if (r101 == null) goto L5;
        String r102 = r101.getMUrl();
    L7:
        return !TextUtils.isEmpty(r102);
    L5:
        r102 = null;
        goto L7
    }

    public static final boolean H(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportVocalWithUrl");
        return !TextUtils.isEmpty(r100.f153577a.getVocalUrl());
    }

    public static final void b(TextView r100) {
        if (r100 == null) goto L25;
        int r101 = r100.getMaxWidth();
        int r102 = com.bytedance.android.livesdk.m.f153482a;
        IMiddleWareHostContext r103 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        boolean r104 = false;
        if (r103 == null) goto L8;
        HostLargeFontParam r105 = r103.getHostLargeFontModeParams();
        if (r105 == null) goto L8;
        boolean r106 = r105.isLargeFontMode();
    L10:
        if (r106 == false) goto L14;
        float r107 = com.bytedance.android.livesdk.m.a() + 0.1f;
        if (r107 <= 1.0f) goto L14;
        r101 = (int) (r101 / r107);
    L14:
        IMiddleWareHostContext r108 = (IMiddleWareHostContext) jc1.k.f(IMiddleWareHostContext.class);
        if (r108 == null) goto L19;
        HostLargeFontParam r109 = r108.getHostLargeFontModeParams();
        if (r109 == null) goto L19;
        r104 = r109.isViewZoomEnable();
    L19:
        if (r104 == false) goto L23;
        float r110 = com.bytedance.android.livesdk.m.b() + 0.1f;
        if (r110 <= 1.0f) goto L23;
        r101 = (int) (r101 / r110);
    L23:
        r100.setMaxWidth(r101);
        return;
    L8:
        r106 = false;
        goto L10
    }

    public static final void c(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$checkInfoAndReport");
        if (h().contains(Long.valueOf(r100.getMId())) == false) goto L5;
        return;
    L5:
        AudioInfo r101 = r100.getMFullTrack();
        boolean r102 = false;
        if (r101 == null) goto L26;
        Intrinsics.checkNotNullParameter(r101, "$this$isUrlEmpty");
        String r103 = r101.getMUrl();
        if (r103 != null) goto L10;
    L13:
        boolean r104 = true;
    L14:
        if (r104 != true) goto L26;
        AudioInfo r105 = r100.getMAccompanimentTrack();
        if (r105 == null) goto L26;
        Intrinsics.checkNotNullParameter(r105, "$this$isUrlEmpty");
        String r106 = r105.getMUrl();
        if (r106 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 != true) goto L26;
        h().add(Long.valueOf(r100.getMId()));
        mb0.d.h(r100, MusicInfoError.SONG_FILE_MISSING);
        goto L26
    L20:
        if (r106.length() == 0) goto L23;
        r107 = false;
        goto L24
    L10:
        if (r103.length() == 0) goto L13;
        r104 = false;
    L26:
        List<String> r108 = r100.getMLyricUrlList();
        if (r108 != null) goto L29;
    L32:
        boolean r109 = true;
    L33:
        if (r109 == false) goto L35;
        h().add(Long.valueOf(r100.getMId()));
        mb0.d.h(r100, MusicInfoError.LYRICS_FILE_MUSSING);
    L35:
        KtvMusic.Companion.getClass();
        if (KtvMusic.a.a(r100) > 0) goto L39;
        h().add(Long.valueOf(r100.getMId()));
        mb0.d.h(r100, MusicInfoError.INVALID_DURATION);
    L39:
        if (r100.getMId() > 0) goto L41;
        h().add(Long.valueOf(r100.getMId()));
        mb0.d.h(r100, MusicInfoError.INVALID_ID);
    L41:
        String r110 = r100.getMTitle();
        if (r110 != null) goto L44;
    L47:
        boolean r111 = true;
    L48:
        if (r111 == false) goto L50;
        h().add(Long.valueOf(r100.getMId()));
        mb0.d.h(r100, MusicInfoError.INVALID_TITLE);
    L50:
        AudioInfo r112 = r100.getMFullTrack();
        if (r112 == null) goto L65;
        Intrinsics.checkNotNullParameter(r112, "$this$isAudioIdInvalid");
        r112.getMAudioId();
        if (r112.getMAudioId() > 0) goto L55;
        boolean r113 = true;
    L56:
        if (r113 != true) goto L66;
        AudioInfo r114 = r100.getMAccompanimentTrack();
        if (r114 == null) goto L67;
        Intrinsics.checkNotNullParameter(r114, "$this$isAudioIdInvalid");
        r114.getMAudioId();
        if (r114.getMAudioId() > 0) goto L62;
        r102 = true;
    L62:
        if (r102 != true) goto L68;
        h().add(Long.valueOf(r100.getMId()));
        mb0.d.h(r100, MusicInfoError.INVALID_AUDIO_ID);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L55:
        r113 = false;
        goto L56
    L65:
        return;
    L44:
        if (r110.length() == 0) goto L47;
        r111 = false;
        goto L48
    L29:
        if (r108.isEmpty() == true) goto L32;
        r109 = false;
        goto L33
    }

    public static final float d(float r100) {
        return (r100 * o.f70693a) + 0.5f;
    }

    public static final String e(long r100) {
        long r101 = 60;
        long r102 = r100 / r101;
        long r103 = r100 % r101;
        long r104 = 10;
        if (r102 < r104) goto L5;
        String r105 = String.valueOf(r102);
    L7:
        if (r103 < r104) goto L9;
        String r106 = String.valueOf(r103);
    L11:
        return s1.C(R.string.ttlive_ktv_challenge_countdown_text, new Object[]{r105, r106});
    L9:
        r106 = "0" + r103;
        goto L11
    L5:
        r105 = "0" + r102;
        goto L7
    }

    public static int f(int r100) {
        return jc1.a.b().getResources().getColor(r100);
    }

    public static final String g(py.k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getFirstUrl");
        List<String> r101 = r100.getUrls();
        if (r101 != null) goto L5;
        return null;
    L5:
        if ((!r101.isEmpty()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L10;
        return null;
    L10:
        return (String) CollectionsKt.firstOrNull(r101);
    }

    public static final int i(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getRemoveSongType");
        if (w(r100.f153577a) == false) goto L8;
        if (m(r100) == true) goto L8;
        return RemoveSongSource.DownloadSongFail.getValue();
    L8:
        return RemoveSongSource.UNKNOWN.getValue();
    }

    public static final py.k k(py.k r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$ifValid");
        Intrinsics.checkNotNullParameter(r100, "$this$isValide");
        String r101 = g(r100);
        boolean r102 = true;
        if (r101 != null) goto L5;
    L10:
        r101 = null;
    L11:
        if (r101 != null) goto L14;
        r102 = false;
    L14:
        if (r102 == false) goto L17;
        return r100;
    L17:
        return null;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L10;
    L7:
        r103 = false;
        goto L8
    }

    public static final boolean l(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        if (r102.exists() == true) goto L14;
    L16:
        return false;
    L14:
        if (r102.isFile() == false) goto L16;
        return true;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static final boolean m(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMusicDownloaded");
        if (z(r100) == false) goto L8;
        if (G(r100) == false) goto L8;
        boolean r101 = q(r100);
    L15:
        if (A(r100) == false) goto L17;
        boolean r102 = l(r100.f153588l);
    L19:
        if (C(r100) == false) goto L21;
        boolean r103 = l(r100.f153593q);
    L23:
        if (vm2.h.d() == true) goto L25;
    L27:
        boolean r104 = true;
    L28:
        int r105 = com.bytedance.android.live.ktv.common.music.download.v.f70112a;
        boolean r106 = FileUtils.checkFileExists(com.bytedance.android.live.ktv.common.music.download.v.a.a() + File.separator + r100.f153577a.getMId());
        if (KtvSettingHelper.f() == false) goto L38;
        if (r106 == false) goto L36;
        if (r101 == false) goto L36;
        if (r102 == false) goto L36;
        if (r103 == false) goto L36;
        if (r104 == false) goto L36;
        return true;
    L36:
        return false;
    L38:
        if (r106 == false) goto L41;
        if (r101 == false) goto L41;
        return true;
    L41:
        return false;
    L25:
        if (H(r100) == false) goto L27;
        r104 = l(r100.f153592p);
        goto L28
    L21:
        r103 = true;
        goto L23
    L17:
        r102 = true;
    L8:
        if (z(r100) == false) goto L11;
        Intrinsics.checkNotNullParameter(r100, "$this$isRealAccompanimentFileExists");
        r101 = l(r100.f153591o);
        goto L15
    L11:
        if (G(r100) == false) goto L13;
        Intrinsics.checkNotNullParameter(r100, "$this$isRealOriginFileExists");
        r101 = l(r100.f153590n);
        goto L15
    L13:
        r101 = true;
        goto L15
    }

    public static final boolean n(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMusicMainResourceDownloaded");
        Intrinsics.checkNotNullParameter(r100, "$this$isRealOriginFileExists");
        if (l(r100.f153590n) == true) goto L8;
        Intrinsics.checkNotNullParameter(r100, "$this$isRealAccompanimentFileExists");
        if (l(r100.f153591o) == true) goto L8;
        boolean r101 = false;
    L9:
        int r102 = com.bytedance.android.live.ktv.common.music.download.v.f70112a;
        if (FileUtils.checkFileExists(com.bytedance.android.live.ktv.common.music.download.v.a.a() + File.separator + r100.f153577a.getMId()) == false) goto L13;
        if (r101 == false) goto L13;
        return true;
    L13:
        return false;
    L8:
        r101 = true;
        goto L9
    }

    public static final boolean o(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isOnlySupportAccompanimentWithPath");
        if (F(r100) == false) goto L5;
    L7:
        return false;
    L5:
        if (y(r100) == false) goto L7;
        return true;
    }

    public static final boolean p(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isOnlySupportOriginWithPath");
        if (F(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (y(r100) == true) goto L7;
        return true;
    }

    public static final boolean q(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isRealOriginAndAccompanimentFileExists");
        if (l(r100.f153590n) == true) goto L5;
    L7:
        return false;
    L5:
        if (l(r100.f153591o) == false) goto L7;
        return true;
    }

    public static final boolean w(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSelf");
        OrderInfo r101 = r100.getOrderInfo();
        if (r101 == null) goto L7;
        InteractiveSongUserInfo r102 = r101.getTopUser();
        if (r102 == null) goto L7;
        String r103 = r102.getIdString();
    L9:
        return Intrinsics.areEqual(r103, ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n());
    L7:
        r103 = null;
        goto L9
    }

    public static final boolean x(KtvMusic r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSinger");
        String r101 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
        OrderInfo r102 = r100.getOrderInfo();
        if (r102 == null) goto L7;
        InteractiveSongUserInfo r103 = r102.getTopUser();
        if (r103 == null) goto L7;
        String r104 = r103.getIdString();
    L9:
        return Intrinsics.areEqual(r101, r104);
    L7:
        r104 = null;
        goto L9
    }

    public static final boolean y(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportAccompanimentWithPath");
        return !TextUtils.isEmpty(r100.f153591o);
    }

    public static final boolean z(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSupportAccompanimentWithUrl");
        AudioInfo r101 = r100.f153577a.getMAccompanimentTrack();
        if (r101 == null) goto L5;
        String r102 = r101.getMUrl();
    L7:
        return !TextUtils.isEmpty(r102);
    L5:
        r102 = null;
        goto L7
    }

    public static final int J(en r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$parse2Int");
        return Color.rgb((int) (r100.c() * r101), (int) (r100.b() * r101), (int) (r100.a() * r101));
    }

    public static final <T> T K(List<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$safeGet");
        int r102 = r100.size();
        if (r101 < 0) goto L7;
        if (r102 <= r101) goto L7;
        return (T) ListProtector.get(r100, r101);
    L7:
        return null;
    }

    public static final void L(View r100, boolean r101) {
        if (r101 == false) goto L4;
        String r102 = "已收藏";
    L5:
        r3.a(r100, r102);
        return;
    L4:
        r102 = "未收藏";
        goto L5
    }

    public static final void M(View r100, long r101) {
        long r102 = 60;
        long r103 = r101 / r102;
        long r104 = r101 % r102;
        StringBuilder r105 = new StringBuilder();
        r105.append(r103);
        r105.append(20998);
        r105.append(r104);
        r105.append(31186);
        r3.a(r100, r105.toString());
    }

    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$adaptImageScaleInLargeFontMode");
        float r102 = com.bytedance.android.livesdk.m.a();
        if (r102 <= 1.0f) goto L6;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        int r104 = (int) (r101 * r102);
        r103.width = r104;
        r103.height = r104;
        r100.setLayoutParams(r103);
        return;
    }

    public static final boolean r(HashMap<String, ? extends py.k> r100, HashMap<String, ? extends py.k> r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L24;
        if (r101 == null) goto L24;
        if (r101.size() == r100.size()) goto L13;
        return false;
    L13:
        List r102 = CollectionsKt.toMutableList(r101.keySet());
        Iterator r103 = CollectionsKt.toMutableList(r100.keySet()).iterator();
        int r104 = 0;
    L15:
        if (r103.hasNext() == false) goto L23;
        Object r105 = r103.next();
        int r106 = r104 + 1;
        if (r104 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        if ((!Intrinsics.areEqual((String) CollectionsKt.getOrNull(r102, r104), (String) r105)) == true) goto L21;
        r104 = r106;
        goto L15
    L21:
        return false;
    L23:
        return true;
    L24:
        return false;
    }

    public static final boolean t(KtvMusic r100, KtvMusic r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSameMusicForOrder");
        long r102 = r100.getMId();
        if (r101 != null) goto L5;
    L20:
        return false;
    L5:
        if (r102 != r101.getMId()) goto L20;
        OrderInfo r103 = r100.getOrderInfo();
        String r104 = null;
        if (r103 == null) goto L11;
        InteractiveSongUserInfo r105 = r103.getTopUser();
        if (r105 == null) goto L11;
        String r106 = r105.getIdString();
    L12:
        OrderInfo r107 = r101.getOrderInfo();
        if (r107 == null) goto L18;
        InteractiveSongUserInfo r108 = r107.getTopUser();
        if (r108 == null) goto L18;
        r104 = r108.getIdString();
    L18:
        if (Intrinsics.areEqual(r106, r104) == false) goto L20;
        return true;
    L11:
        r106 = null;
        goto L12
    }

    public static final boolean u(MusicPanel r100, MusicPanel r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSameMusicPanelForOrder");
        KtvMusic r102 = null;
        if (((Boolean) vm2.h.f556164k1.getValue(null, vm2.h.f556082a[113(0x71, float:1.58E-43)])).booleanValue() == false) goto L9;
        KtvMusic r103 = r100.f153577a;
        if (r101 == null) goto L8;
        r102 = r101.f153577a;
    L8:
        return t(r103, r102);
    L9:
        HashMap<String, py.k> r104 = r100.B;
        if (r104 == null) goto L17;
        if (r101 == null) goto L13;
        HashMap<String, py.k> r105 = r101.B;
    L15:
        if (r(r104, r105) != true) goto L17;
        boolean r106 = true;
    L18:
        boolean r107 = r100.f153584h;
        if (r101 == null) goto L21;
        boolean r108 = r101.f153584h;
    L22:
        if (r107 != r108) goto L24;
        boolean r109 = true;
    L25:
        KtvMusic r110 = r100.f153577a;
        if (r101 == null) goto L28;
        r102 = r101.f153577a;
    L28:
        boolean r111 = t(r110, r102);
        if (r106 == false) goto L33;
        if (r109 == false) goto L33;
        if (r111 == false) goto L33;
        return true;
    L33:
        return false;
    L24:
        r109 = false;
        goto L25
    L21:
        r108 = false;
        goto L22
    L13:
        r105 = null;
    L17:
        r106 = false;
        goto L18
    }

    public static final boolean s(KtvMusic r100, long r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$isSameMusicForOrder");
        Intrinsics.checkNotNullParameter(r102, "otherUid");
        if (r100.getMId() != r101) goto L13;
        OrderInfo r103 = r100.getOrderInfo();
        if (r103 == null) goto L9;
        InteractiveSongUserInfo r104 = r103.getTopUser();
        if (r104 == null) goto L9;
        String r105 = r104.getIdString();
    L11:
        if (Intrinsics.areEqual(r105, r102) == false) goto L13;
        return true;
    L9:
        r105 = null;
    L13:
        return false;
    }
}
