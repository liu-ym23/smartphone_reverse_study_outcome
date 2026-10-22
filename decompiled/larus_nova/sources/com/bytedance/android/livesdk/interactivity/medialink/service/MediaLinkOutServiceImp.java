package com.bytedance.android.livesdk.interactivity.medialink.service;

import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.interactivity.api.medialink.BaseMediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService;
import com.bytedance.android.livesdk.interactivity.medialink.contract.a;
import com.bytedance.android.livesdk.interactivity.medialink.contract.b;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaLinkControlWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAnchorWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.MediaMultiLinkAudienceWidget;
import com.bytedance.android.livesdk.interactivity.medialink.widget.RevMediaLinkControlWidget;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.Widget;
import e92.d;
import e92.m;
import hh1.v0;
import hy.e;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\"\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/service/MediaLinkOutServiceImp;", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/IMediaLinkOutService;", "", "scene", "", "uid", "", "isUserInMultiAnchorLinkByScene", "Lhy/e;", "getLinkUserCenter", "", "factory", "Lx32/b;", "switchContext", "Lcom/bytedance/ies/sdk/widgets/Widget;", "createMediaMultiAnchorWidget", "createMediaMultiAudienceWidget", "isUserInMediaLink", "reqSrc", "", "finishMediaAnchorLink", "blockDigg", "isMediaLinkOn", "onClickLinkIcon", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget$a;", "callback", "Landroid/view/ViewGroup;", "parentView", "Lcom/bytedance/android/livesdk/interactivity/api/medialink/BaseMediaLinkControlWidget;", "createRevMediaControlWidget", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class MediaLinkOutServiceImp implements IMediaLinkOutService {
    public MediaLinkOutServiceImp() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public boolean blockDigg() {
        b.R0.getClass();
        if (b.a.a() == null) goto L8;
        int r100 = d.f471449a;
        if (m.h() == 4) goto L7;
        return false;
    L7:
        return true;
    L8:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public boolean isMediaLinkOn() {
        a.Q0.getClass();
        a r100 = a.C2196a.a();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.k0(256) != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public void onClickLinkIcon() {
        a.Q0.getClass();
        a r100 = a.C2196a.a();
        if (r100 == null) goto L6;
        r100.onClickLinkIcon();
        return;
    }

    private final e getLinkUserCenter(int r100) {
        b.R0.getClass();
        b r101 = b.a.a();
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 == 17) goto L9;
        return null;
    L9:
        return r101.Np();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public Widget createMediaMultiAudienceWidget(x32.b r100) {
        return new MediaMultiLinkAudienceWidget(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public boolean isUserInMediaLink(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        return isUserInMultiAnchorLinkByScene(17, r100);
    }

    private final boolean isUserInMultiAnchorLinkByScene(int r100, String r101) {
        e r102 = getLinkUserCenter(r100);
        if (r102 != null) goto L6;
        return false;
    L6:
        if (Lists.isEmpty(r102.getOnlineUserList()) == false) goto L8;
        return false;
    L8:
        Iterator<AnchorLinkUser> r103 = r102.getOnlineUserList().iterator();
    L10:
        if (r103.hasNext() == false) goto L21;
        AnchorLinkUser r104 = r103.next();
        if (r104 == null) goto L16;
        IBaseUser r105 = r104.getUser();
        if (r105 == null) goto L16;
        String r106 = r105.getIdString();
    L18:
        if (Intrinsics.areEqual(r106, r101) == false) goto L10;
        return true;
    L16:
        r106 = null;
        goto L18
    L21:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public Widget createMediaMultiAnchorWidget(Object r100, x32.b r101) {
        if ((r100 instanceof v0) == true) goto L6;
        r100 = null;
    L6:
        return new MediaMultiLinkAnchorWidget((v0) r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public void finishMediaAnchorLink(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "reqSrc");
        b.R0.getClass();
        b r102 = b.a.a();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.jg(r100, r101, true);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.medialink.IMediaLinkOutService
    public BaseMediaLinkControlWidget createRevMediaControlWidget(Room r100, BaseMediaLinkControlWidget.a r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (r100.isMediaRoom() == false) goto L6;
        return new MediaLinkControlWidget(r101, r102);
    L6:
        return new RevMediaLinkControlWidget(r101, r102);
    }
}
