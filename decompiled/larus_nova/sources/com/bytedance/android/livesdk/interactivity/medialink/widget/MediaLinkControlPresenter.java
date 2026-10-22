package com.bytedance.android.livesdk.interactivity.medialink.widget;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.live.user.api.IUserServiceV2;
import com.bytedance.android.live.user.api.UserSetting;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkInitResult;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.user.h;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.Single;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
public final class MediaLinkControlPresenter extends n<IView> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Room f138431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f138432f;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/widget/MediaLinkControlPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        void OF();

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();
    }

    public final void g0() {
        StringBuilder r100 = new StringBuilder("room linkMap=");
        Room r101 = this.f138431e;
        z5 r102 = null;
        if (r101 == null) goto L5;
        Map<String, Long> r103 = r101.getLinkMap();
    L6:
        r100.append(r103);
        r100.append(' ');
        Room r104 = this.f138431e;
        if (r104 == null) goto L9;
        r102 = r104.getLinkerDetail();
    L9:
        r100.append(r102);
        ALogger.i("ttlive_link", r100.toString());
        Room r105 = this.f138431e;
        if (r105 == null) goto L45;
        LinkInitResult r106 = r105.linkInitResult;
        if (r106 == null) goto L46;
        ALogger.e("ttlive_link", "attach initResult=" + r106.getLinkMicId() + " accessToken=" + r106.getAccessToken() + " initScene=" + r105.linkMicScene);
        if (TextUtils.isEmpty(r106.getAccessToken()) == false) goto L16;
        return;
    L16:
        if (r106.getLinkMicId() <= 0) goto L18;
    L19:
        this.f107664c.put("data_voice_chat_room_shoot_way", "direct_shoot");
        tc0.c r107 = tc0.c.h();
        if (TextUtils.isEmpty(r106.getLinkMicIdStr()) == false) goto L22;
        r107.f545349f = String.valueOf(r106.getLinkMicId());
        r107.f545348e = String.valueOf(r106.getLinkMicId());
    L23:
        r107.f545353j = r106.getVendor();
        r107.f545354k = r106.getRtcExtInfo();
        r107.f545356m = r106.getLiveCoreExtInfo();
        if (r106.getMultiLiveCoreInfo() == null) goto L27;
        r107.f545361r = r106.getMultiLiveCoreInfo();
    L27:
        if (r106.getMultiRtcInfo() == null) goto L29;
        r107.f545357n = r106.getMultiRtcInfo();
    L29:
        tc0.c.h().E = r106.isSupportVideo();
        hd0.c.f().k(2);
        if (UserSetting.b() == false) goto L36;
        IUserServiceV2 r108 = (IUserServiceV2) k.f(IUserServiceV2.class);
        if (r108 == null) goto L43;
        Single<? extends IBaseUser> r109 = r108.updateCurrentUser(this.f107664c, "MediaLinkControlPresenter");
        if (r109 == null) goto L43;
        r109.subscribe(new h());
    L43:
        this.f107664c.put("data_room_shoot_way_exact", "live_take_page");
        return;
    L36:
        IUserService r110 = (IUserService) k.f(IUserService.class);
        if (r110 == null) goto L43;
        com.bytedance.android.livesdk.user.f r111 = r110.user();
        if (r111 == null) goto L43;
        Single<IUser> r112 = r111.j();
        if (r112 == null) goto L43;
        r112.subscribe(new h());
        goto L43
    L22:
        r107.f545348e = r106.getLinkMicIdStr();
        r107.f545349f = r106.getLinkMicIdStr();
        goto L23
    L18:
        if (TextUtils.isEmpty(r106.getLinkMicIdStr()) == false) goto L19;
        return;
    L46:
        return;
    L45:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        IView r101 = (IView) r100;
        g0();
    }

    public MediaLinkControlPresenter(Room r100, boolean r101) {
        this.f138431e = r100;
        this.f138432f = r101;
    }
}
