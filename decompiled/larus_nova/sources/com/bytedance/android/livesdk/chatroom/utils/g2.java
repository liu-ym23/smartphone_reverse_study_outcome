package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.model.feed.FeedExtra;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.live.core.feed.LiveFeedType;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.ArgumentsBuilder;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f114475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CompositeDisposable f114476b;

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Throwable f114477a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Throwable f114478b = null;

        static {
            f114477a = new IllegalStateException("is fetching");
            new IllegalStateException("no tab data");
            new IllegalStateException("request is empty");
            f114478b = new RuntimeException("enter room failed.");
        }
    }

    public static Bundle b(FeedItem r100, FeedExtra r101) {
        String r102 = null;
        if (r100 != null) goto L5;
    L30:
        return null;
    L5:
        if (r100.getItem() == null) goto L30;
        if ((r100.getItem() instanceof Room) == false) goto L30;
        Bundle r103 = ArgumentsBuilder.buildRoomArgs((Room) r100.getItem());
        if (r101 != null) goto L31;
    L28:
        com.bytedance.android.livesdk.log.n.a(r103, r100);
        return r103;
    L31:
        r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_LOG_PB, String.valueOf(r101.getLogPb()));     // Catch: Exception -> L26
        r103.putString("log_pb", String.valueOf(r101.getLogPb()));     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r101.reqId) == true) goto L14;
    L16:
        r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_REQUEST_ID, r101.reqId);     // Catch: Exception -> L26
        r103.putString("request_id", r101.reqId);     // Catch: Exception -> L26
        if (r100.isRecommendCard == false) goto L19;
        r102 = "pop_card";
    L19:
        r103.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_FROM_MERGE_RECOMMEND, r102);     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r100.liveReason) == true) goto L23;
        r103.putString("live_reason", r100.liveReason);     // Catch: Exception -> L26
    L23:
        if (TextUtils.isEmpty(r100.adRawString) == true) goto L28;
        r103.putString("data_live_effect_ad_log_extra_string", r100.adRawString);     // Catch: Exception -> L26
        goto L28
    L14:
        if (TextUtils.isEmpty(String.valueOf(r101.getLogPb())) == true) goto L16;
        r101.reqId = JSONObjectProtectorUtils.getString(new JSONObject(r101.getLogPb().toString()), "impr_id");     // Catch: Exception -> L26
    L26:
        e = move-exception;
        ALogger.e("NewFeedStyleEntranceUtils", e);
        goto L28
    }

    public static void a(final Map r210, final v r211, final ILiveCallback r212) {
        if (f114475a == false) goto L7;
        if (r212 == null) goto L43;
        r212.onFailed(a.f114477a);
        return;
    L43:
        return;
    L7:
        f114475a = true;
        final long r100 = SystemClock.elapsedRealtime();
        final long r101 = System.currentTimeMillis();
        if (r210.containsKey("enter_from_merge") == false) goto L10;
        String r102 = (String) r210.get("enter_from_merge");
    L11:
        if (r211 == null) goto L16;
        if (TextUtils.isEmpty(r102) == false) goto L16;
        r102 = "live_merge_task";
    L16:
        if (r210.containsKey("enter_method") == false) goto L18;
        String r103 = (String) r210.get("enter_method");
    L19:
        String r213 = r102 + "-" + r103;
        if (f114476b != null) goto L22;
        f114476b = new CompositeDisposable();
    L22:
        final String r104 = com.bytedance.android.live.core.feed.c.a(r102, r103, LiveFeedType.INNER_FLOW).getLiveFeedUrl();
        CompositeDisposable r105 = f114476b;
        long r110 = 0;
        if (r210.containsKey(ILiveRoomPlayFragmentConstant.FORCE_IS_DRAW) == true) goto L25;
    L28:
        long r111 = r110;
        if (r105 == null) goto L44;
        HashMap r106 = new HashMap();
    L37:
        e = move-exception;
        ALogger.e("NewFeedStyleEntranceUtils", e);
    L39:
        Map<String, Long> r107 = com.bytedance.android.livesdk.preview.u.f156605a;
        r106.putAll(com.bytedance.android.livesdk.preview.u.d());
        CompositeDisposable r108 = f114476b;
        com.bytedance.android.livesdk.service.l.d().getClass();
        r108.add(((FeedApi) com.bytedance.android.live.network.c.b().e(FeedApi.class)).feed(r104, 0, "enter_auto_feed_draw_refresh", r111, -1, "", r213, null, r106).map(new c2()).doOnNext(new d2()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e2(r212, r211, r210, r104, r100, r101), new f2(r212)));
        return;
    L32:
        if (r210.containsKey(ILiveRoomPlayFragmentConstant.EXTRA_FEED_EXTRA_PARAMS) == false) goto L39;
        String r109 = (String) r210.get(ILiveRoomPlayFragmentConstant.EXTRA_FEED_EXTRA_PARAMS);     // Catch: Exception -> L37
        if (StringUtils.isEmpty(r109) == true) goto L39;
        r106.putAll((HashMap) LiveGsonHelper.get().fromJson(r109, HashMap.class));     // Catch: Exception -> L37
        goto L39
    L44:
        return;
    L25:
        if ("1".equals((String) r210.get(ILiveRoomPlayFragmentConstant.FORCE_IS_DRAW)) == false) goto L27;
        r110 = 1;
    L27:
        r210.remove(ILiveRoomPlayFragmentConstant.FORCE_IS_DRAW);
        goto L28
    L18:
        r103 = "live_cover";
        goto L19
    L10:
        r102 = "live_merge";
        goto L11
    }
}
