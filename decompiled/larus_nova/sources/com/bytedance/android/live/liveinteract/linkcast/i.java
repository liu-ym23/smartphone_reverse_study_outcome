package com.bytedance.android.live.liveinteract.linkcast;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.api.interactgame.IMiddlewareInteractGameService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAnchorService;
import com.bytedance.android.live.openplatform.api.IMiddlewareOpenPlatformAudienceService;
import com.bytedance.android.live.openplatform.api.constant.MountedMiniAppSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f74332a = 0;

    public static final class a {
        public static c a(LinkScreenCastType r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "linkCastType");
            Intrinsics.checkNotNullParameter(r101, "appId");
            int r102 = h.f74328a[r100.ordinal()];
            boolean r103 = false;
            if (r102 != 1) goto L5;
            Boolean r104 = m.i().isAnchor();
            if (r104 == null) goto L18;
            r103 = r104.booleanValue();
        L18:
            com.bytedance.android.live.broadcastgame.api.model.h r105 = ((IMiddlewareInteractGameService) k.n(IMiddlewareInteractGameService.class)).fetchGameIconInfo(r101, r103);
            if (r105 != null) goto L24;
        L21:
            return null;
        L24:
            return new c(r105.f59344a, r105.f59346c, r105.f59345b);
        L5:
            if (r102 != 2) goto L21;
            Boolean r106 = m.i().isAnchor();
            if (r106 == null) goto L10;
            r103 = r106.booleanValue();
        L10:
            if (r103 == false) goto L12;
            ko0.c r107 = ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).getMiniAppLiveCastEntranceInfo();
        L13:
            if (r107 == null) goto L21;
            return new c(r107.f504358a, r107.f504360c, r107.f504359b);
        L12:
            r107 = ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).getMiniAppLiveCastEntranceInfo();
            goto L13
        }

        public static void b(LinkScreenCastType r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "linkCastType");
            Intrinsics.checkNotNullParameter(r101, "appId");
            int r102 = h.f74329b[r100.ordinal()];
            if (r102 != 1) goto L5;
            Room r103 = m.i().getCurrentRoom();
            if (r103 == null) goto L19;
            IBaseUser r104 = r103.getOwner();
            if (r104 == null) goto L19;
            String r105 = r104.getIdString();
        L21:
            if (Intrinsics.areEqual(r105, ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n()) == false) goto L23;
            ((IMiddlewareInteractGameService) k.n(IMiddlewareInteractGameService.class)).anchorLaunchGame(r101);
            return;
        L23:
            ((IMiddlewareInteractGameService) k.n(IMiddlewareInteractGameService.class)).audienceLaunchGame();
            return;
        L19:
            r105 = null;
            goto L21
        L5:
            if (r102 != 2) goto L28;
            Boolean r106 = m.i().isAnchor();
            if (r106 == null) goto L10;
            boolean r107 = r106.booleanValue();
        L11:
            if (r107 == false) goto L13;
            ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).openLiveCastingMiniApp();
            return;
        L13:
            ((IMiddlewareOpenPlatformAudienceService) k.n(IMiddlewareOpenPlatformAudienceService.class)).openMountedMiniApp(MountedMiniAppSource.ConnectionPanel);
            return;
        L10:
            r107 = false;
            goto L11
        }

        public static void c(LinkScreenCastType r100, boolean r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "linkCastType");
            Intrinsics.checkNotNullParameter(r102, "reason");
            int r104 = h.f74331d[r100.ordinal()];
            if (r104 != 1) goto L5;
            ((IMiddlewareInteractGameService) k.n(IMiddlewareInteractGameService.class)).notifyStopLinkCastResult(r101);
            return;
        L5:
            if (r104 != 2) goto L11;
            JSONObject r105 = new JSONObject();
            r105.put("key_stop_reason", r102);
            ((IMiddlewareOpenPlatformAnchorService) k.n(IMiddlewareOpenPlatformAnchorService.class)).notifyMiniAppStopLinkCastResult(r101, r105, r103);
            return;
        }
    }

    static {
    }
}
