package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.openplatform.api.constant.LaunchParamConstant$Scene;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.model.MiniAppEntranceCell;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mh1.p;

/* JADX INFO: loaded from: classes46.dex */
public final class MiniAppEntranceClickHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public so0.a f84138a;

    public static final class CheckToolbarConflictNode extends com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC1277a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lp0.a f84139a;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC1277a
        public final void a(final com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a r100) {
            Intrinsics.checkNotNullParameter(r100, "chains");
            lp0.a r101 = this.f84139a;
            if (r101 == null) goto L11;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r102 = r101.getRoot();
            if (r102 == null) goto L11;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c r103 = r102.dE();
            if (r103 == null) goto L11;
            final p r104 = r103.f84115d;
            if (r104 == null) goto L11;
            r104.a(new MiniAppEntranceClickHandler$CheckToolbarConflictNode$process$$inlined$let$lambda$1(r104, r100), MiniAppEntranceClickHandler$CheckToolbarConflictNode$process$1$2.INSTANCE);
            return;
        L11:
            r100.a();
        }

        public CheckToolbarConflictNode(lp0.a r100, MiniAppEntranceCell r101) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            this.f84139a = r100;
        }
    }

    public static final class a extends com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC1277a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final lp0.a f84140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MiniAppEntranceCell f84141b;

        @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC1277a
        public final void a(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a r210) {
            Intrinsics.checkNotNullParameter(r210, "chain");
            lp0.a r100 = this.f84140a;
            if (r100 == null) goto L9;
            so0.a r101 = r100.w();
            if (r101 == null) goto L9;
            OpenPlatformContext r102 = r101.a();
            if (r102 == null) goto L9;
            DataCenter r103 = r102.getDataCenter();
        L10:
            if (r103 == null) goto L12;
            r103.put("cmd_live_toolbarmore_dialog_dismiss", 0);
        L12:
            MiniAppEntranceCell r104 = this.f84141b;
            String r110 = mp0.b.a(r104.groupId);
            if (lp0.b.d(this.f84140a) == false) goto L24;
            so0.a r105 = f.f84165a.f84138a;
            if (r105 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L17:
            String r106 = r104.schema;
            if (r106 != null) goto L20;
            r106 = "";
        L20:
            String r107 = LaunchParamConstant$Scene.f83955a;
            List r108 = r104.serverScenes;
            if (r108 != null) goto L23;
            r108 = new ArrayList();
        L23:
            r105.openMiniApp(r106, new ko0.b(r107, "live", "preview", "solid_entrance", "live_take_page", r110, null, null, null, false, false, r108, 8128));
            return;
        L24:
            so0.a r109 = f.f84165a.f84138a;
            if (r109 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
        L27:
            String r111 = r104.schema;
            if (r111 != null) goto L30;
            r111 = "";
        L30:
            String r112 = LaunchParamConstant$Scene.f83955a;
            List r113 = r104.serverScenes;
            if (r113 != null) goto L33;
            r113 = new ArrayList();
        L33:
            r109.i(r111, new ko0.b(r112, "live", "preview", "solid_entrance", "live_take_page", r110, null, null, null, false, false, r113, 8128));
            return;
        L9:
            r103 = null;
            goto L10
        }

        public a(lp0.a r100, MiniAppEntranceCell r101) {
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            this.f84140a = r100;
            this.f84141b = r101;
        }
    }

    public MiniAppEntranceClickHandler() {
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r100 = ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().f530019a.f530021b.get();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f84138a = r100;
    }

    public static void a(lp0.a r100, MiniAppEntranceCell r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        if (lp0.b.d(r100) == false) goto L13;
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r103 = AnchorMiniAppDataContext.a.a();
        if (r103 == null) goto L13;
        m<Boolean> r104 = r103.getMicroAppMountPunishing();
        if (r104 == null) goto L13;
        if (r104.getValue().booleanValue() != true) goto L13;
        f2.b(R.string.ttlive_mini_app_entrance_punish_tip, 0);
        return;
    L13:
        if (lp0.b.a(r100) == null) goto L18;
        String r105 = r101.appId;
        if (r105 != null) goto L17;
        r105 = "";
    L17:
        String r106 = mp0.b.a(r101.groupId);
        boolean r107 = lp0.b.d(r100);
        String r108 = r101.a();
        Integer r109 = Integer.valueOf(r102);
        Intrinsics.checkNotNullParameter(r105, "mpId");
        Intrinsics.checkNotNullParameter(r106, "enterPosition");
        u.l().e(BdpAppEventConstant.EVENT_MP_CLICK, mp0.a.a(r105, r106, r107, r108, r109), new Object[0]);
    L18:
        ArrayList r110 = new ArrayList();
        if (lp0.b.d(r100) == false) goto L21;
        CheckToolbarConflictNode r111 = new CheckToolbarConflictNode(r100, r101);
        Intrinsics.checkNotNullParameter(r111, "node");
        r110.add(r111);
    L21:
        a r112 = new a(r100, r101);
        Intrinsics.checkNotNullParameter(r112, "node");
        r110.add(r112);
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a r113 = new com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a();
        Iterator r114 = r110.iterator();
    L23:
        if (r114.hasNext() == false) goto L25;
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC1277a r115 = (com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a.AbstractC1277a) r114.next();
        ((ArrayList) r113.f84142a).add(r115);
        goto L23
    L25:
        r113.f84143b = 0;
        r113.a();
    }
}
