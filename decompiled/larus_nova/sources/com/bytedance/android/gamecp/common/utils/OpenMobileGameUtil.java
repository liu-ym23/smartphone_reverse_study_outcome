package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class OpenMobileGameUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57180a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/common/utils/OpenMobileGameUtil$GameStatus;", "", "", "value", "I", "getValue", "()I", "GAME_STATUS_INSTALLED", "GAME_STATUS_INSTALLED_BUT_FAILED_TO_OPEN", "GAME_STATUS_UNINSTALL", "GAME_STATUS_CONSIDER_OPEN_FAIL", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GameStatus extends Enum<GameStatus> {
        public static final GameStatus GAME_STATUS_CONSIDER_OPEN_FAIL = null;
        public static final GameStatus GAME_STATUS_INSTALLED = null;
        public static final GameStatus GAME_STATUS_INSTALLED_BUT_FAILED_TO_OPEN = null;
        public static final GameStatus GAME_STATUS_UNINSTALL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GameStatus[] f57181a = null;
        private final int value;

        static {
            GameStatus r100 = new GameStatus("GAME_STATUS_INSTALLED", 0, 0);
            GAME_STATUS_INSTALLED = r100;
            GameStatus r101 = new GameStatus("GAME_STATUS_INSTALLED_BUT_FAILED_TO_OPEN", 1, 1);
            GAME_STATUS_INSTALLED_BUT_FAILED_TO_OPEN = r101;
            GameStatus r102 = new GameStatus("GAME_STATUS_UNINSTALL", 2, 2);
            GAME_STATUS_UNINSTALL = r102;
            GameStatus r103 = new GameStatus("GAME_STATUS_CONSIDER_OPEN_FAIL", 3, 3);
            GAME_STATUS_CONSIDER_OPEN_FAIL = r103;
            f57181a = new GameStatus[]{r100, r101, r102, r103};
        }

        public static GameStatus valueOf(String r100) {
            return (GameStatus) r27.a.a(GameStatus.class, r100);
        }

        public static GameStatus[] values() {
            return (GameStatus[]) f57181a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public GameStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public OpenMobileGameUtil() {
    }

    public static void c() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L13
        LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L13
        r101.put("jump_reason", "cg_play_jump");     // Catch: Throwable -> L13
        HashMap<String, String> r102 = GamecpTracker.f56755a;     // Catch: Throwable -> L13
        HashMap r103 = (HashMap) GamecpTracker.k(null, null);     // Catch: Throwable -> L13
        Iterator r104 = r103.keySet().iterator();     // Catch: Throwable -> L13
    L4:
        if (r104.hasNext() == false) goto L8;
        String r105 = (String) r104.next();     // Catch: Throwable -> L13
        String r106 = (String) r103.get(r105);     // Catch: Throwable -> L13
        if (r106 == null) goto L4;
        r101.put(r105, r106);     // Catch: Throwable -> L13
        goto L4
    L8:
        bw.l r107 = com.bytedance.android.gamecp.host_api.a.b().getHostRouteOutCertDataService();     // Catch: Throwable -> L13
        if (r107 == null) goto L11;
        r107.W0();     // Catch: Throwable -> L13
    L11:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    static {
    }

    public static GameStatus b(String r100, String r101, Context r102) {
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        Intent r103 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101));
        boolean r104 = false;
        int r105 = r102.getPackageManager().queryIntentActivities(r103, 0).size();
        boolean r106 = true;
        if (r105 <= 0) goto L8;
        boolean r107 = true;
    L9:
        if (r100 != null) goto L11;
    L14:
        boolean r108 = true;
    L15:
        if (r108 == false) goto L29;
    L21:
        GameStatus r109 = GameStatus.GAME_STATUS_UNINSTALL;
        if (r107 == false) goto L25;
        if (r106 == false) goto L25;
        return GameStatus.GAME_STATUS_INSTALLED;
    L25:
        if (r107 == true) goto L32;
        if (r106 == true) goto L28;
        return r109;
    L28:
        return GameStatus.GAME_STATUS_INSTALLED_BUT_FAILED_TO_OPEN;
    L32:
        return r109;
    L29:
        r102.getPackageManager().getPackageInfo(r100, 1);     // Catch: PackageManager.NameNotFoundException -> L19
        r104 = true;
    L20:
        r106 = r104;
        goto L21
    L11:
        if (StringsKt.isBlank(r100) == true) goto L14;
        r108 = false;
        goto L15
    L8:
        r107 = false;
        goto L9
    }

    public static void a(Context r100, String r101, String r102, GameStatus r103, Function1 r104, Function0 r105) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r106 = o0.f57250a[r103.ordinal()];
        if (r106 == 1) goto L13;
        if (r106 != 2) goto L8;
    L12:
        r104.invoke(r100);
        return;
    L8:
        if (r106 == 3) goto L12;
        if (r106 == 4) goto L12;
        return;
    L13:
        Intent r107 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, UriProtector.parse(r101));
        r107.addFlags(268435456);
    L21:
        r104.invoke(r100);
        return;
    L15:
        if ((!StringsKt.isBlank(r102)) == false) goto L17;
        r107.setPackage(r102);     // Catch: Exception -> L21
    L17:
        c();     // Catch: Exception -> L21
        r100.startActivity(r107);     // Catch: Exception -> L21
        HashMap<String, String> r108 = GamecpTracker.f56755a;     // Catch: Exception -> L21
        GamecpTracker.B("dygame_result_show", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(PrefetchTiming.ROUTER, e1.a(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("previous_page", "initiate_team_page")}))), TuplesKt.to("product_type", "pull_game_success")}));     // Catch: Exception -> L21
        if (r105 == null) goto L26;
        Unit r109 = (Unit) r105.invoke();     // Catch: Exception -> L21
        return;
    }

    public static void d(final String r110, final String r111, final GameStatus r112, final int r113, final Function0 r114, final Function1 r115) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r111, "packageName");
        Intrinsics.checkNotNullParameter(r112, "handleResult");
        Intrinsics.checkNotNullParameter(r115, "openFail");
        if (r113 > 0) goto L9;
        Activity r100 = c.b();
        if ((r100 instanceof Context) == true) goto L7;
        r100 = null;
    L7:
        a(r100, r110, r111, r112, r115, r114);
        return;
    L9:
        UtilityKotlinExtentionsKt.g(100, false, false, new OpenMobileGameUtil$tryOpenGame$1(r110, r111, r112, r113, r114, r115), 6);
    }

    public static /* synthetic */ void e(String r100, String r101, GameStatus r102, Function0 r110, Function1 r111, int r112) {
        if ((r112 & 8) == 0) goto L5;
        int r103 = 3;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r110 = null;
    L9:
        d(r100, r101, r102, r103, r110, r111);
        return;
    L5:
        r103 = 0;
        goto L7
    }
}
