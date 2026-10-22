package com.bytedance.android.livesdk.preview;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdkapi.roomplayer.EnterFromMerge;
import com.bytedance.android.livesdkapi.roomplayer.EnterMethod;
import com.bytedance.android.livesdkapi.roomplayer.ILivePreviewCoverView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePreviewFragment;
import com.bytedance.android.livesdkapi.roomplayer.ILivePurePreviewView;
import com.bytedance.android.livesdkapi.roomplayer.LiveMetricsBuilder;
import com.bytedance.android.livesdkapi.roomplayer.LiveMetricsParams;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public class c1 implements t {
    public static final a Companion = null;
    private static final String TAG = "LivePreviewService";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public c1() {
    }

    private final String getAppId() {
        IHostContext r100 = (IHostContext) jc1.k.f(IHostContext.class);
        if (r100 != null) goto L7;
        return "";
    L7:
        return String.valueOf(r100.appId());
    }

    private final jp2.d.a parseAdArguments(String r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return (jp2.d.a) new Gson().fromJson(r100, jp2.d.a.class);
    L7:
        th = move-exception;
        Log.getStackTraceString(th);
        return null;
    }

    public ty.a getILivePreviewLayout(ty.a.C7794a r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = getAppId();
        SettingKey<List<String>> r102 = LiveConfigSettingKeys.RECOMMEND_ENABLE_APPID_WHITELIST;
        if (r102.getValue().contains(r101) == false) goto L8;
        throw null;
    L8:
        if (r102.getValue().contains("*") == true) goto L11;
        return null;
    L11:
        throw null;
    }

    @Override // com.bytedance.android.livesdk.preview.t
    public ILivePreviewFragment getLivePreviewFragment(LiveMetricsParams r100) {
        if (LiveConfigSettingKeys.LIVE_USE_PREVIEW_LAYOUT_ENABLE.getValue().booleanValue() == true) goto L10;
        FeedLivePreviewFragment r101 = new FeedLivePreviewFragment();
        if (r100 == null) goto L9;
        r101.f156318e = r100;
    L9:
        return r101;
    L10:
        return new FeedLivePreviewFragmentV2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.preview.t
    public ILivePreviewCoverView makePreviewCoverView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object[] r101 = 0 == true ? 1 : 0;
        return new LivePreviewCoverView(r100, null, r101, 30);
    }

    public ty.a getILivePreviewLayout(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        w0 r102 = new w0(r100);
        if (r101 == null) goto L5;
        r102.f156654h.putAll(r101);
    L5:
        r102.a();
        return r102;
    }

    @Override // com.bytedance.android.livesdk.preview.t
    public ry.k makePreviewCoverView(Context r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        return new LivePreviewCoverView(r100, new LiveMetricsBuilder().enterFromMerge(EnterFromMerge.HOMEPAGE_HOT).enterMethod(EnterMethod.LIVE_CELL).build(), r101, 24);
    }

    @Override // com.bytedance.android.livesdk.preview.t
    public ILivePurePreviewView makePurePreviewView(Context r100, LiveMetricsParams r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        return new LivePurePreviewView(r100, r101, 12);
    }

    @Override // com.bytedance.android.livesdk.preview.t
    public ILivePreviewCoverView makePreviewCoverView(Context r100, LiveMetricsParams r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        return new LivePreviewCoverView(r100, r101, null, 28);
    }

    @Override // com.bytedance.android.livesdk.preview.t
    public ILivePreviewCoverView makePreviewCoverView(Context r100, LiveMetricsParams r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "bundle");
        return new LivePreviewCoverView(r100, r101, r102, 24);
    }

    public ty.e makeStandalonePreviewView(Context r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = getAppId();
        SettingKey<List<String>> r104 = LiveConfigSettingKeys.RECOMMEND_ENABLE_APPID_WHITELIST;
        if (r104.getValue().contains(r103) == false) goto L5;
    L8:
        if (r102 != null) goto L11;
        r102 = new Bundle();
    L11:
        if (LiveConfigSettingKeys.LIVE_TOB_AD_POSITION.getValue().contains("" + r101) == true) goto L13;
    L15:
        r102.putLong("scene", r101);
        Map<String, Long> r105 = u.f156605a;
        String r106 = r102.getString("live_ad_extra", null);
        if (r106 != null) goto L42;
    L17:
        String r107 = null;
    L23:
        if (TextUtils.isEmpty(r107) == true) goto L41;
        jp2.d.a r108 = parseAdArguments(r107);
        if (r108 == null) goto L41;
        if (r108.b() == false) goto L41;
        int r109 = r108.position;
        if (r109 == r101) goto L32;
        r102.putLong("scene", r109);
    L32:
        if ((!Intrinsics.areEqual(r108.openRoomId, r102.getString("open_room_id", null))) == false) goto L35;
        r102.putString("open_room_id", r108.openRoomId);
    L35:
        if ((!Intrinsics.areEqual(r108.requestId, r102.getString("request_id", ""))) == false) goto L37;
        r102.putString("request_id", r108.requestId);
    L37:
        String r110 = r108.a();
        if (TextUtils.isEmpty(r110) == true) goto L41;
        r102.putString("data_live_effect_ad_log_extra_string", r110);
    L41:
        return new StandalonePreviewCoverView(r100, r102, 12);
    L42:
        r107 = com.bytedance.android.livesdk.utils.a.a(r106);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        ALogger.e("LiveAdHelper", e);
        goto L17
    L13:
        if (TextUtils.isEmpty(r102.getString("live_ad_extra")) == false) goto L15;
        return null;
    L5:
        if (r104.getValue().contains("*") == true) goto L8;
        com.bytedance.android.livesdk.log.b0.o().getClass();
        com.bytedance.android.live.core.log.g.i("IStandalonePreviewView", "getRoomInfoList: appId=" + r103 + " not in whitelist");
        return null;
    }

    public ty.d getLiveView(Context r110, int r111, String r112, boolean r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = null;
        if (r211 == null) goto L41;
        if (TextUtils.isEmpty(r211.getString("request_id", "")) == true) goto L41;
        if (LiveConfigSettingKeys.LIVE_TOB_AD_POSITION.getValue().contains("" + r111) == true) goto L10;
    L12:
        Bundle r101 = new Bundle();
        r101.putString("enter_from_merge", jp2.d.a(r111));
        r101.putString("enter_method", jp2.d.b(r111));
        r101.putString("open_room_id", r112);
        r101.putLong("scene", r111);
        r101.putString("request_id", r211.getString("request_id", ""));
        Map<String, Long> r102 = u.f156605a;
        String r103 = r211.getString("live_ad_extra", null);
        if (r103 == null) goto L20;
        r100 = com.bytedance.android.livesdk.utils.a.a(r103);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        ALogger.e("LiveAdHelper", e);
    L20:
        if (TextUtils.isEmpty(r100) == true) goto L39;
        jp2.d.a r104 = parseAdArguments(r100);
        if (r104 == null) goto L39;
        if (r104.b() == false) goto L39;
        int r105 = r104.position;
        if (r105 == r111) goto L29;
        r101.putString("enter_from_merge", jp2.d.a(r105));
        r101.putString("enter_method", jp2.d.b(r104.position));
        r101.putLong("scene", r104.position);
    L29:
        if ((!Intrinsics.areEqual(r104.openRoomId, r112)) == false) goto L32;
        r101.putString("open_room_id", r104.openRoomId);
    L32:
        if ((!Intrinsics.areEqual(r104.requestId, r211.getString("request_id", ""))) == false) goto L34;
        r101.putString("request_id", r104.requestId);
    L34:
        String r106 = r104.a();
        if (TextUtils.isEmpty(r106) == true) goto L39;
        r101.putString("data_live_effect_ad_log_extra_string", r106);
    L39:
        return new com.bytedance.android.livesdk.provider.outer.d(r110, r101, r210);
    L10:
        if (TextUtils.isEmpty(r211.getString("live_ad_extra")) == false) goto L12;
        return null;
    L41:
        return null;
    }
}
