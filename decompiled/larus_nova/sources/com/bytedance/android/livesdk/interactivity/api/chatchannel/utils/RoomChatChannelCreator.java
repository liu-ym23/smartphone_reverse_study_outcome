package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.api.RoomRetrofitApi;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/utils/RoomChatChannelCreator;", "Ls22/e$c;", "Lcom/bytedance/android/livesdk/chatroom/n;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomChatChannelCreator implements s22.e.c, com.bytedance.android.livesdk.chatroom.n, Observer<KVData> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f132943m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CompositeDisposable f132944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f132945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f132946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f132947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f132948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f132949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f132950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f132951h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f132952i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RoomContext f132953j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f132954k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f132955l;

    public static final class a {
    }

    static {
    }

    @Override // s22.e.c
    public final void Df() {
    }

    @Override // s22.e.c
    public final void Nc() {
    }

    @Override // s22.e.c
    public final void Oo() {
    }

    @Override // s22.e.c
    public final void Y9(long r100) {
    }

    @Override // s22.e.c
    public final void p6(long r100) {
    }

    @Override // s22.e.c
    public final void t9(long r100) {
    }

    public final s22.e b() {
        com.bytedance.android.livesdk.interactivity.api.f r100 = com.bytedance.android.livesdk.interactivity.api.g.a(this.f132953j);
        if (r100 == null) goto L7;
        com.bytedance.live.datacontext.j<s22.e> r101 = r100.getChatChannelManager();
        if (r101 == null) goto L7;
        return r101.getValue();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.n
    public final void a() {
        s22.e r100 = b();
        if (r100 == null) goto L5;
        r100.onRoomDestroy("room creator");
    L5:
        this.f132954k.removeObserver(this);
        CompositeDisposable r101 = this.f132944a;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        Disposable r102 = this.f132945b;
        if (r102 == null) goto L11;
        r102.dispose();
    L11:
        this.f132952i = false;
    }

    @Override // s22.e.c
    public final void Dm(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void Va(long r100) {
        Long r101 = this.f132946c;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r100 != r101.longValue()) goto L9;
        k.b("quit failed while quit and join");
        this.f132946c = null;
        this.f132947d = null;
        this.f132948e = null;
        this.f132949f = null;
        this.f132950g = null;
        this.f132951h = null;
        return;
    }

    @Override // s22.e.c
    public final void W5(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    public final void c(long r100) {
        IUserService r101 = (IUserService) jc1.k.f(IUserService.class);
        if (r101 == null) goto L17;
        com.bytedance.android.livesdk.user.f r102 = r101.user();
        if (r102 == null) goto L17;
        if (r102.isLogin() == true) goto L17;
        Bundle r103 = new Bundle();
        IMiddlewareUserService r104 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r104 == null) goto L21;
        com.bytedance.android.livesdk.user.e r105 = r104.user();
        if (r105 == null) goto L22;
        Context r106 = this.f132955l;
        com.bytedance.android.livesdk.user.l.a r107 = new com.bytedance.android.livesdk.user.l.a();
        r107.f158689e = "";
        r107.f158692h = r103;
        Observable<IBaseUser> r108 = r105.login(r106, new com.bytedance.android.livesdk.user.l(r107));
        if (r108 == null) goto L23;
        Disposable r109 = r108.subscribe(new r(this, r100), s.f133011a);
        if (r109 == null) goto L24;
        RxUtilKt.c(r109, this.f132944a);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L21:
        return;
    L17:
        s22.e r110 = b();
        if (r110 == null) goto L26;
        r110.joinChannel(r100);
        return;
    }

    @Override // s22.e.c
    public final void d8(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    public final void e(Room r100) {
        RoomContext r101 = this.f132953j;
        com.bytedance.android.livesdk.interactivity.api.f r102 = com.bytedance.android.livesdk.interactivity.api.g.a(r101);
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.f132952i == false) goto L8;
        return;
    L8:
        RoomChatChannelCreator$tryInitChatChannel$1 r103 = new RoomChatChannelCreator$tryInitChatChannel$1(this, r100, r101, r102);
        RoomChannelData r104 = r100.roomChannel;
        if (r104 != null) goto L11;
    L13:
        RoomAuthStatus r105 = r100.getMRoomAuthStatus();
        if (r105 != null) goto L16;
    L32:
        r103.invoke(null);
        return;
    L16:
        if (r105.isEnableRoomChannel() != true) goto L32;
        com.bytedance.android.live.network.c r106 = com.bytedance.android.live.network.c.b();
        if (r106 == null) goto L28;
        RoomRetrofitApi r107 = (RoomRetrofitApi) r106.e(RoomRetrofitApi.class);
        if (r107 == null) goto L28;
        Observable<Response<Room>> r108 = r107.getRoomInfoByScene(r100.f162599id, "enter_room_channel");
        if (r108 == null) goto L28;
        Observable<R> r109 = r108.map(z.f133025a);
        if (r109 == 0) goto L28;
        Observable r110 = r109.subscribeOn(Schedulers.io());
        if (r110 == null) goto L28;
        Observable r111 = r110.observeOn(AndroidSchedulers.mainThread());
    L29:
        if (r111 == null) goto L31;
        RxUtilKt.c(r111.subscribe(new x(r103), new y(r103)), this.f132944a);
        return;
    L31:
        r103.invoke(null);
        return;
    L28:
        r111 = null;
        goto L29
    L11:
        if (r104.getStatus() != 1) goto L13;
        r103.invoke(r104);
    }

    @Override // s22.e.c
    public final void gf(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void hb(List<? extends s22.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "channels");
        Intrinsics.checkNotNullParameter(r100, "channels");
    }

    @Override // s22.e.c
    public final void kf(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-1741164106)) goto L12;
        return;
    L12:
        if (r102.equals("data_user_in_room") == false) goto L34;
        IUser r103 = (IUser) r101.getData();
        if (r103 == null) goto L35;
        com.bytedance.android.livesdk.interactivity.api.h r104 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r104 == null) goto L24;
        com.bytedance.live.datacontext.j<Long> r105 = r104.getUserFansCountOnStart();
        if (r105 == null) goto L24;
        py.j r106 = r103.getFollowInfoExt();
        if (r106 == null) goto L22;
        long r107 = r106.getFollowerCount();
    L23:
        r105.d(Long.valueOf(r107));
        goto L24
    L22:
        r107 = 0;
    L24:
        com.bytedance.android.livesdk.interactivity.api.h r108 = com.bytedance.android.livesdk.interactivity.api.i.b(null, 3);
        if (r108 == null) goto L36;
        com.bytedance.live.datacontext.j<Integer> r109 = r108.getUserHonorLevelOnStart();
        if (r109 == null) goto L37;
        py.d r110 = r103.getUserHonor();
        if (r110 == null) goto L31;
        int r111 = r110.getLevel();
    L32:
        r109.d(Integer.valueOf(r111));
        return;
    L31:
        r111 = 0;
        goto L32
    L37:
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // s22.e.c
    public final void vg(s22.a r100) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void D9(s22.a r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void Gh(s22.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "channel");
        Intrinsics.checkNotNullParameter(r100, "channel");
    }

    @Override // s22.e.c
    public final void Hh(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter(r101, "response");
    }

    @Override // s22.e.c
    public final void Rn(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k r110) {
        Intrinsics.checkNotNullParameter(r110, "response");
        Long r111 = this.f132946c;
        if (r111 != null) goto L6;
        return;
    L6:
        if (r100 != r111.longValue()) goto L21;
        this.f132946c = null;
        Long r101 = this.f132947d;
        if (r101 == null) goto L11;
        long r102 = r101.longValue();
        this.f132947d = null;
        c(r102);
        return;
    L11:
        Long r103 = this.f132948e;
        if (r103 == null) goto L22;
        long r104 = r103.longValue();
        s22.e r105 = b();
        if (r105 == null) goto L23;
        Long r106 = this.f132949f;
        if (r106 == null) goto L18;
        long r107 = r106.longValue();
    L19:
        r105.joinAnchorFansChannel(r104, r107, this.f132950g, this.f132951h);
        return;
    L18:
        r107 = 0;
        goto L19
    L23:
        return;
    L22:
        return;
    }

    @Override // s22.e.c
    public final void a3(long r110, Throwable r111) {
        boolean r100 = r111 instanceof ApiServerException;
        if (r100 == true) goto L5;
        Throwable r101 = null;
    L6:
        ApiServerException r102 = (ApiServerException) r101;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == false) goto L26;
        s22.e r112 = b();
        if (r112 == null) goto L22;
        com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> r113 = r112.getCurrentChannel();
        if (r113 == null) goto L22;
        sh6.b<s22.a> r114 = r113.getValue();
        if (r114 == null) goto L22;
        s22.a r115 = (s22.a) sh6.c.b(r114);
        if (r115 == null) goto L22;
        Long r116 = Long.valueOf(r115.getChannelId());
    L23:
        if (r116 == null) goto L25;
        d(this, r116.longValue(), Long.valueOf(r110), null, null, null, null, 60);
        return;
    L25:
        k.b("join failed because hasJoinChannel is true. but no channelId available");
        this.f132946c = null;
        this.f132947d = null;
        return;
    L22:
        r116 = null;
        goto L23
    L26:
        if (r100 == true) goto L28;
        r111 = null;
    L28:
        ApiServerException r117 = (ApiServerException) r111;
        if (r117 == null) goto L36;
        String r118 = r117.getPrompt();
        if (r118 == null) goto L37;
        f2.c(r118, 0);
        return;
    L37:
        return;
    L36:
        return;
    L9:
        if (r102.getErrorCode() != 4003129) goto L11;
        r103 = true;
        goto L12
    L5:
        r101 = r111;
        goto L6
    }

    public RoomChatChannelCreator(RoomContext r100, DataCenter r101, Context r102) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f132953j = r100;
        this.f132954k = r101;
        this.f132955l = r102;
    }

    @Override // s22.e.c
    public final void Ij(long r110, long r111, Long r112, Long r210, Throwable r211) {
        Throwable r100 = r211;
        boolean r101 = r100 instanceof ApiServerException;
        Long r102 = null;
        if (r101 == true) goto L5;
        Throwable r103 = null;
    L6:
        ApiServerException r104 = (ApiServerException) r103;
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.getErrorCode());
    L11:
        if (r105 != null) goto L14;
    L54:
        if (r105 != null) goto L57;
    L63:
        if (r105 != null) goto L66;
    L70:
        if (r101 == true) goto L72;
        r100 = null;
    L72:
        ApiServerException r106 = (ApiServerException) r100;
        if (r106 == null) goto L99;
        String r107 = r106.getPrompt();
        if (r107 == null) goto L100;
        f2.c(r107, 0);
        s22.e r108 = b();
        if (r108 == null) goto L101;
        s22.a r109 = r108.getChannel(r110);
        if (r109 == null) goto L102;
        PropertyOwner<String> r113 = r109.r();
        if (r113 == null) goto L103;
        r113.a(r107);
        return;
    L103:
        return;
    L102:
        return;
    L101:
        return;
    L100:
        return;
    L99:
        return;
    L66:
        if (r105.intValue() != 4003215) goto L70;
        f2.b(R.string.ttlive_chat_channel_fail_not_permit, 0);
        s22.e r114 = b();
        if (r114 == null) goto L97;
        r114.deleteAnchorFansChannel(r110);
        return;
    L97:
        return;
    L57:
        if (r105.intValue() != 4003123) goto L63;
        s22.e r115 = b();
        if (r115 == null) goto L94;
        s22.a r116 = r115.getChannel(r110);
        if (r116 == null) goto L95;
        r116.r().a(s1.B(R.string.ttlive_chat_channel_too_much_people));
        return;
    L95:
        return;
    L94:
        return;
    L14:
        if (r105.intValue() != 4003129) goto L54;
        s22.e r117 = b();
        if (r117 == null) goto L30;
        List<s22.a> r118 = r117.getAllChannel();
        if (r118 == null) goto L30;
        Iterator<T> r119 = r118.iterator();
    L21:
        if (r119.hasNext() == false) goto L29;
        s22.a r120 = (s22.a) r119.next();
        if (r120.y() != 0) goto L25;
        boolean r121 = true;
    L26:
        if (r121 == false) goto L21;
        Long r122 = Long.valueOf(r120.getChannelId());
    L31:
        if (r122 != null) goto L45;
        s22.e r123 = b();
        if (r123 == null) goto L44;
        List<s22.a> r124 = r123.getAllChannel();
        if (r124 == null) goto L44;
        Iterator<T> r125 = r124.iterator();
    L38:
        if (r125.hasNext() == false) goto L43;
        s22.a r126 = (s22.a) r125.next();
        if (r126.s() == false) goto L38;
        r102 = Long.valueOf(r126.getChannelId());
        goto L44
    L43:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L44:
        r122 = r102;
    L45:
        if (r122 == null) goto L92;
        s22.e r127 = b();
        if (r127 == null) goto L53;
        s22.a r128 = r127.getChannel(r110);
        if (r128 == null) goto L53;
        PropertyOwner<String> r129 = r128.r();
        if (r129 == null) goto L53;
        r129.a(s1.B(R.string.ttlive_chat_channel_too_much_channel));
    L53:
        d(this, r122.longValue(), null, Long.valueOf(r110), Long.valueOf(r111), r112, r210, 2);
        return;
    L92:
        return;
    L25:
        r121 = false;
        goto L26
    L29:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L30:
        r122 = null;
        goto L31
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = r100;
        goto L6
    }

    public static void d(RoomChatChannelCreator r110, long r111, Long r112, Long r113, Long r114, Long r115, Long r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r211 & 4) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r211 & 8) == 0) goto L13;
        Long r102 = null;
    L15:
        if ((r211 & 16) == 0) goto L17;
        Long r103 = null;
    L19:
        if ((r211 & 32) == 0) goto L21;
        Long r116 = null;
    L22:
        r110.getClass();
        x0.b r104 = new x0.b(r110.f132955l, 0);
        r104.f162238a.f162242a = 4;
        r104.setCornerRadius(2.0f);
        r104.l(R.string.ttlive_chat_channel_quit_and_join);
        r104.i(1, R.string.ttlive_chat_channel_quit_and_join_cancel, v.f133015a);
        r104.i(0, R.string.ttlive_chat_channel_quit_and_join_confirm, new w(r110, r111, r100, r101, r102, r103, r116));
        r104.f162238a.f162252k = false;
        r104.n();
        return;
    L21:
        r116 = r210;
        goto L22
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
