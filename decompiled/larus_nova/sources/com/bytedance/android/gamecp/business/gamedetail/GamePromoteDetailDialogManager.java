package com.bytedance.android.gamecp.business.gamedetail;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.base.gamedetail.ShowType;
import com.bytedance.android.gamecp.common.utils.e1;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.disposables.CompositeDisposable;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Stack;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wu.b3;
import xr.s;

/* JADX INFO: loaded from: classes44.dex */
public final class GamePromoteDetailDialogManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Stack<WeakReference<? extends DialogFragment>> f53442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CompositeDisposable f53443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f53444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final GamePromoteDetailDialogManager f53445d = null;

    public GamePromoteDetailDialogManager() {
    }

    static {
        f53445d = new GamePromoteDetailDialogManager();
        f53442a = new Stack();
        f53443b = new CompositeDisposable();
    }

    public static void a(Bundle r100) {
        bw.i r101 = com.bytedance.android.gamecp.host_api.a.b().getLiveService();
        int r102 = bw.a.f20978a;
        r101.B();
    }

    public static void b(boolean r100) {
        if (b3.f561285a.getValue().booleanValue() == false) goto L5;
        com.bytedance.android.gamecp.host_api.a.b().getHostFoldPadService().j2();
    L5:
        Stack<WeakReference<? extends DialogFragment>> r101 = f53442a;
        boolean r102 = false;
        if (r101.isEmpty() == false) goto L8;
        LocalTestManager.a(new Class[]{uv.a.class});
    L33:
        f53443b.dispose();
        f53443b = new CompositeDisposable();
        return;
    L8:
        WeakReference<? extends DialogFragment> r103 = r101.pop();
        FragmentActivity r104 = null;
        if (r103 == null) goto L11;
        DialogFragment r105 = r103.get();
    L12:
        if (r100 == false) goto L33;
        if (r105 == null) goto L15;
        r104 = r105.getActivity();
    L15:
        if (r104 != null) goto L17;
    L19:
        boolean r106 = false;
    L20:
        if (r104 == null) goto L25;
        if (r104.isDestroyed() == true) goto L25;
        r102 = true;
    L25:
        if ((r106 & r102) == false) goto L33;
        if (r105 == null) goto L33;
        r105.dismiss();     // Catch: Exception -> L29
    L29:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r107 = DialogFragmentLancet.sLastShowStack;
        if (r107 == null) goto L33;
        com.bytedance.crash.d.d(r107, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L33
    L17:
        if (r104.isFinishing() == true) goto L19;
        r106 = true;
        goto L20
    L11:
        r105 = null;
        goto L12
    }

    public static /* synthetic */ void c(GamePromoteDetailDialogManager r100) {
        r100.getClass();
        b(true);
    }

    public static void d(Context r100, Bundle r101, boolean r110) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (b3.f561285a.getValue().booleanValue() == true) goto L7;
        ShowType r102 = ShowType.NORMAL;
    L11:
        if (r102 != ShowType.NORMAL) goto L19;
        if (r101 == null) goto L19;
        if (f53444c == true) goto L19;
        if (Intrinsics.areEqual(f.b(r101, "is_fullscreen"), "1") == false) goto L19;
        f53444c = true;
        f53445d.getClass();
        a(r101);
        return;
    L19:
        f53444c = false;
        FragmentActivity r103 = com.bytedance.android.gamecp.common.utils.g.b(r100);
        if (r103 != null) goto L22;
        r103 = com.bytedance.android.gamecp.common.utils.g.b(com.bytedance.android.gamecp.common.utils.c.a());
    L22:
        Map r104 = null;
        if (r103 == null) goto L25;
        FragmentManager r105 = r103.getSupportFragmentManager();
    L26:
        if (r105 != null) goto L28;
    L97:
        if (r101 == null) goto L110;
        f53445d.getClass();
        a(r101);
        return;
    L110:
        return;
    L28:
        if (r105.isStateSaved() == true) goto L97;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L38
        if (r101 == null) goto L35;
        int r107 = r101.getInt(AudienceGamePromoteDetailActionHandler.PARA_ALL_CHANNEL_INSTALL_ENABLE, 1);     // Catch: Throwable -> L38
        mw.a r108 = (mw.a) s.a(mw.a.class);     // Catch: Throwable -> L38
        if (r108 == null) goto L35;
        r108.setAllChannelInstallEnable(r107);     // Catch: Throwable -> L38
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L38
    L36:
        Result.m9449constructorimpl(r109);     // Catch: Throwable -> L38
    L40:
        Bundle r111 = new Bundle();
        if (r101 == null) goto L44;
        r111.putAll(r101);
    L44:
        if (r110 == false) goto L46;
        r111.putInt(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE, com.bytedance.android.gamecp.business.gamedetail.page.root.b.f55465i);
    L47:
        String r112 = r111.getString("report_params");
        if (r112 == null) goto L77;
        if (r112.length() <= 0) goto L52;
        boolean r113 = true;
    L53:
        if (r113 == true) goto L56;
        r112 = null;
    L56:
        if (r112 == null) goto L77;
        JsonElement r114 = GsonHelper.a.f57436d.parse(r112);     // Catch: Throwable -> L74
        if (r114 == null) goto L103;
        JsonObject r115 = r114.getAsJsonObject();     // Catch: Throwable -> L74
        if (r115 == null) goto L103;
        if ((true ^ r115.isJsonNull()) == true) goto L65;
        r115 = null;
    L65:
        if (r115 == null) goto L103;
        if (r115.has(CloudControlInf.ROUTE) == false) goto L72;
        String r116 = e1.a(r115.get(CloudControlInf.ROUTE));     // Catch: Throwable -> L74
        if (r116 != null) goto L71;
        r116 = SliceInitService.DEFAULT_SWITCH;
    L71:
        r104 = (Map) GsonHelper.get().fromJson(r116, new l().getType());     // Catch: Throwable -> L74
        goto L103
    L72:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L74
    L103:
    L74:
        th = move-exception;
        x8.a.c("Error parsing json", th, false);
        Unit r118 = Unit.INSTANCE;
        goto L77
    L52:
        r113 = false;
    L77:
        if (r111.get("track_previous_route") != null) goto L80;
        if (r104 == null) goto L80;
        r111.putSerializable("track_previous_route", (Serializable) r104);
    L80:
        r111.putInt("show_type", r102.getType());
        if (r103 != null) goto L83;
    L90:
        AudienceGamePromoteDialogV2.f53378u.getClass();
        AudienceGamePromoteDialogV2 r119 = AudienceGamePromoteDialogV2.a.a(r111);
        LandscapeRestrictionOperation r120 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r119, "AudienceGameOrderDialog", r120);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r119, r120) == false) goto L108;
    L95:
        f53442a.push(new WeakReference(r119));
        return;
    L108:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L100
    L94:
        r119.show(r105, "AudienceGameOrderDialog");
        goto L95
    L83:
        if (r102 != ShowType.SPLIT_SCREEN) goto L90;
        bw.g r121 = com.bytedance.android.gamecp.host_api.a.b().getHostFoldPadService();
        r121.t0(r103);
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L87
        Result.m9449constructorimpl(new JSONObject(r111.getString("extra", SliceInitService.DEFAULT_SWITCH)).put("is_show_video_cover", 0));     // Catch: Throwable -> L87
    L89:
        AudienceGamePromoteDialogV2.f53378u.getClass();
        final AudienceGamePromoteDialogV2 r123 = AudienceGamePromoteDialogV2.a.a(r111);
        r121.Y0(r103, new GamePromoteDetailDialogManager$showGameOrderDetailDialog$6(r123));
        r111.putInt("show_type", ShowType.NORMAL.getType());
    L87:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L89
    L46:
        r111.putInt(AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE, com.bytedance.android.gamecp.business.gamedetail.page.root.b.f55466j);
    L35:
        r109 = null;
    L38:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L40
    L25:
        r105 = null;
        goto L26
    L7:
        if (r101 == null) goto L9;
        int r126 = f.f55299a;
        f.a(r101, AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE, 0);
    L9:
        bw.g r127 = com.bytedance.android.gamecp.host_api.a.b().getHostFoldPadService();
        r127.isPad();
        r127.isFoldDevice();
        r102 = ShowType.NORMAL;
        goto L11
    }
}
