package com.bytedance.android.live.openplatform.impl.minigameanchor.mount;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import com.bytedance.android.live.openplatform.impl.base.context.OpenPlatformContext;
import com.bytedance.android.live.openplatform.impl.minigameanchor.applog.AnchorMiniGameAppLogContextService;
import com.bytedance.android.livesdk.widget.x0;
import com.larus.nova.R;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f85256a = 0;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f85257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformContext f85258b;

        public a(Function0 r100, OpenPlatformContext r101) {
            this.f85257a = r100;
            this.f85258b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f85257a.invoke();
            r100.dismiss();
            OpenPlatformContext r102 = this.f85258b;
            if (r102 == null) goto L8;
            AnchorMiniGameAppLogContextService r103 = (AnchorMiniGameAppLogContextService) r102.getService(AnchorMiniGameAppLogContextService.class);
            if (r103 == null) goto L9;
            HashMap<String, String> r104 = new HashMap();
            r104.put("screen_split_rate", "0.3");
            r104.put("click_type", "exit");
            Unit r105 = Unit.INSTANCE;
            r103.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_click", r104);
            return;
        L9:
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OpenPlatformContext f85259a;

        public b(OpenPlatformContext r100) {
            this.f85259a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
            OpenPlatformContext r102 = this.f85259a;
            if (r102 == null) goto L8;
            AnchorMiniGameAppLogContextService r103 = (AnchorMiniGameAppLogContextService) r102.getService(AnchorMiniGameAppLogContextService.class);
            if (r103 == null) goto L9;
            HashMap<String, String> r104 = new HashMap();
            r104.put("screen_split_rate", "0.3");
            r104.put("click_type", "cancel");
            Unit r105 = Unit.INSTANCE;
            r103.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_click", r104);
            return;
        L9:
            return;
        }
    }

    static {
    }

    public static String a(String r100) {
        if (r100 == null) goto L20;
        int r101 = r100.hashCode();
        if (r101 == (-1768820280)) goto L18;
        if (r101 == (-1659249440)) goto L15;
        if (r101 != (-906336856)) goto L20;
        if (r100.equals("search") == false) goto L20;
        return "function_panel_search";
    L15:
        if (r100.equals("use_recently") == false) goto L20;
        return "function_panel_recently";
    L18:
        if (r100.equals("game_tab") == false) goto L20;
        return "function_panel_microgame";
    L20:
        return "";
    }

    public static boolean b(Context r100) {
        if ((r100 instanceof Activity) == false) goto L10;
        Activity r101 = (Activity) r100;
        if (r101.isFinishing() == false) goto L7;
        return false;
    L7:
        if (r101.isDestroyed() == true) goto L20;
        return true;
    L20:
        return false;
    L10:
        if ((r100 instanceof ContextWrapper) == false) goto L21;
        Context r102 = ((ContextWrapper) r100).getBaseContext();
        if ((r102 instanceof Activity) == false) goto L22;
        Activity r103 = (Activity) r102;
        if (r103.isFinishing() == false) goto L16;
        return false;
    L16:
        if (r103.isDestroyed() == true) goto L24;
        return true;
    L24:
        return false;
    L22:
        return false;
    L21:
        return false;
    }

    public static void c(Context r100, OpenPlatformContext r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r102, "onConfirm");
        x0.b r103 = new x0.b(r100, 4);
        x0.d r104 = r103.f162238a;
        r104.f162252k = false;
        r104.f162253l = false;
        r103.l(R.string.ttlive_open_platform_mg_exit_mount_title);
        r103.i(0, R.string.ttlive_open_platform_mg_exit_mount_exit, new a(r102, r101));
        r103.i(1, R.string.ttlive_open_platform_mg_exit_mount_cancel, new b(r101));
        r103.k(0, true);
        r103.n();
        if (r101 == null) goto L8;
        AnchorMiniGameAppLogContextService r105 = (AnchorMiniGameAppLogContextService) r101.getService(AnchorMiniGameAppLogContextService.class);
        if (r105 == null) goto L9;
        HashMap<String, String> r106 = new HashMap();
        r106.put("screen_split_rate", "0.3");
        Unit r107 = Unit.INSTANCE;
        r105.reportLiveRoomMgAppLog("livesdk_anchor_mg_remove_pop_show", r106);
        return;
    L9:
        return;
    }
}
