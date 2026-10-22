package com.bytedance.ai.applet.app.view;

import android.content.Context;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f34507a = 0;

    static {
    }

    public o() {
    }

    public static m a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new m(5, c(r110, "larus_appEntry_3rdPartyApp_menuOption_about", R.string.applet_share_sheet_menu_about), Integer.valueOf(R.drawable.ic_applet_share_sheet_about), 5, true, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_BURY_DATA_OPTIMIZE);
    }

    public static m b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new m(6, c(r110, "larus_appEntry_3rdPartyApp_menuOption_report", R.string.applet_share_sheet_menu_feedback), Integer.valueOf(R.drawable.ic_applet_share_sheet_feedback), 6, true, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_BURY_DATA_OPTIMIZE);
    }

    public static m d(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new m(1, c(r110, "larus_appEntry_3rdPartyApp_menuOption_pin", R.string.applet_share_sheet_menu_pin), Integer.valueOf(R.drawable.ic_applet_share_sheet_pin), 1, true, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_BURY_DATA_OPTIMIZE);
    }

    public static m e(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new m(3, c(r110, "larus_appEntry_3rdPartyApp_menuOption_reload", R.string.applet_share_sheet_menu_reenter), Integer.valueOf(R.drawable.ic_applet_share_sheet_refresh), 3, true, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_BURY_DATA_OPTIMIZE);
    }

    public static m f(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new m(2, c(r110, "larus_appEntry_3rdPartyApp_menuOption_settings", R.string.applet_share_sheet_menu_settings), Integer.valueOf(R.drawable.ic_applet_share_sheet_settings), 2, true, null, null, null, TTVideoEngineInterface.PLAYER_OPTION_GSKEY_BURY_DATA_OPTIMIZE);
    }

    public static String c(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "targetKey");
        com.bytedance.ai.utils.l.f37675a.getClass();
        return com.bytedance.ai.utils.l.d(r100, r101, r102);
    }
}
