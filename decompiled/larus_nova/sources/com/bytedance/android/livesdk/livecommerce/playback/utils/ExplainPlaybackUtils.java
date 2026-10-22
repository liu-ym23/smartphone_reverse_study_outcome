package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import si2.k;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f149977a = 0;

    public static Context b() {
        return ECAppInfoService.f48114e.getApplicationContext();
    }

    public static boolean d() {
        if (ECSettingKeys.D() != LiveReplayPageOptEnums.DEFAULT.getTrial()) goto L5;
        return true;
    L5:
        return false;
    }

    static {
    }

    public static FilterNullArrayList a(ExplainPlaybackRequest r110) {
        Intrinsics.checkNotNullParameter(r110, "requestParams");
        FilterNullArrayList r100 = new FilterNullArrayList();
        r100.add(new k("promotion_id", r110.getPromotionId()));
        String r101 = r110.getOriginFragmentId();
        if (r101 != null) goto L5;
        r101 = "0";
    L5:
        r100.add(new k("fragment_id", r101));
        hh2.g r102 = hh2.f.f485165a.f485167a;
        boolean r103 = false;
        if (r102 == null) goto L10;
        Boolean r104 = r102.l();
        if (r104 == null) goto L10;
        boolean r105 = r104.booleanValue();
    L12:
        if (r105 == false) goto L14;
        r100.add(new k("author_id", "0"));
        r100.add(new k("author_open_id", r110.getAuthorId()));
    L15:
        r100.add(new k("room_id", r110.getRoomId()));
        r100.add(new k("source_page", r110.getSourcePage()));
        r100.add(new k(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r110.getEntranceInfo()));
        r100.add(new k(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r110.getCarrierSource()));
        r100.add(new k("need_adapt_addr", String.valueOf(r110.getNeedAdaptAddr())));
        r100.add(new k("modelType", String.valueOf(r110.getModelType())));
        String r106 = r110.getEnterScene();
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        r100.add(new k("enter_scene", r106));
        if (d() == true) goto L27;
        r100.add(new k("need_room_replays", String.valueOf(r110.getEnableMultiCard())));
        r100.add(new k("is_first_page", String.valueOf(r110.isFirstPage())));
        r100.add(new k("page_size", String.valueOf(r110.getPageSize())));
        List<String> r111 = r110.getPromotionIDs();
        List<String> r107 = r111;
        if (r107 != null) goto L23;
    L24:
        r103 = true;
    L25:
        if (r103 == true) goto L27;
        r100.add(new k("promotion_ids", CollectionsKt.joinToString$default(r111, ",", null, null, 0, null, ExplainPlaybackUtils$convertInputParamsToCommentaryParams$1$1.INSTANCE, 30, null)));
        goto L27
    L23:
        if (r107.isEmpty() == false) goto L25;
    L27:
        return r100;
    L14:
        r100.add(new k("author_id", r110.getAuthorId()));
    L10:
        r105 = false;
        goto L12
    }

    public static boolean e(String r100) {
        return TextUtils.equals(r100, "search");
    }

    public static String c(Context r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        long r102 = r101 / ((long) 1000);
        long r103 = 60;
        long r104 = r102 % r103;
        long r105 = (r102 / r103) % r103;
        long r106 = 10;
        if (r104 >= r106) goto L5;
        String r107 = th.a.h(r100, R.string.ec_explain_playback_sec_kill_zero_placeholder, new Object[]{Long.valueOf(r104)});
    L7:
        if (r105 >= r106) goto L9;
        String r108 = th.a.h(r100, R.string.ec_explain_playback_sec_kill_zero_placeholder, new Object[]{Long.valueOf(r105)});
    L10:
        StringCompanionObject r110 = StringCompanionObject.INSTANCE;
        return String.format(th.a.g(r100, R.string.ec_explain_playback_video_date), Arrays.copyOf(new Object[]{r108, r107}, 2));
    L9:
        r108 = String.valueOf(r105);
        goto L10
    L5:
        r107 = String.valueOf(r104);
        goto L7
    }
}
