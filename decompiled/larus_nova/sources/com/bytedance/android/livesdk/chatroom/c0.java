package com.bytedance.android.livesdk.chatroom;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.feed.FeedApi;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livesdk.chatroom.drawer.LiveDrawerHelper;
import com.bytedance.android.livesdk.config.bc1;
import com.bytedance.android.livesdk.config.ep;
import com.bytedance.android.livesdk.config.jp;
import com.bytedance.android.livesdk.config.mj1;
import com.bytedance.android.livesdk.config.mp;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.LiveDrawerUrlHelper;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class c0 implements ILiveOntologyInfoManager {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static c0 f105566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static int f105567s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f105568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f105569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f105570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f105571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f105572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f105573f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f105574g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f105575h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f105576i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f105577j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f105578k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b0 f105579l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap<String, Long> f105580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<Long> f105581n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f105582o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f105583p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f105584q;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f105585a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ng2.c f105586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ng2.c f105587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<Long, Integer> f105588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ c0 f105589e;

        public final void a() {
            if (this.f105586b != null) goto L6;
            ng2.c r100 = new ng2.c();
            r100.j(new UrlBuilder(FeedApi.DEFAULT_FEED_API).addParam(FeedApi.NEED_MAP_KEY, 1).addParam(FeedApi.SOURCE_KEY, "drawer_hot_drawer_cover").build());
            r100.i(new UrlBuilder(FeedApi.DEFAULT_FEED_API).addParam(FeedApi.NEED_MAP_KEY, 1).addParam(FeedApi.SOURCE_KEY, "drawer_hot_drawer_cover").addParam(FeedApi.IS_FROM_DRAW, 1).build());
            c0 r101 = this.f105589e;
            r100.h(Boolean.valueOf(LiveDrawerUrlHelper.isParamInList(r101.f105571d, r101.f105572e, jp.f120542a.getValue())));
            this.f105586b = r100;
            return;
        }

        public a(c0 r110, boolean r111) {
            this.f105589e = r110;
            if (TextUtils.isEmpty(r110.f105571d) == false) goto L5;
        L7:
            this.f105588d = new HashMap();
            String r100 = this.f105585a;
            ng2.c r101 = new ng2.c();
            ng2.c r102 = null;
            String r103 = LiveDrawerUrlHelper.getSourceKey(r110.f105571d, r110.f105572e, ep.f120144a.getValue(), null);
            if (LiveDrawerUrlHelper.isParamInList(r110.f105571d, r110.f105572e, com.bytedance.android.livesdk.chatroom.utils.p0.f114579a) == false) goto L10;
        L11:
            r103 = "drawer_hot_drawer_cover";
        L13:
            if (TextUtils.isEmpty(r103) == true) goto L15;
            r101.j(new UrlBuilder(FeedApi.DEFAULT_FEED_API).addParam(FeedApi.NEED_MAP_KEY, 1).addParam(FeedApi.SOURCE_KEY, r103).build());
            r101.i(new UrlBuilder(FeedApi.DEFAULT_FEED_API).addParam(FeedApi.NEED_MAP_KEY, 1).addParam(FeedApi.SOURCE_KEY, r103).addParam(FeedApi.IS_FROM_DRAW, 1).build());
            r101.h(Boolean.valueOf(LiveDrawerUrlHelper.isParamInList(r110.f105571d, r110.f105572e, jp.f120542a.getValue())));
        L48:
            this.f105586b = r101;
            ng2.c r112 = new ng2.c();
            c0 r104 = this.f105589e;
            String r105 = LiveDrawerUrlHelper.getSourceKey(r104.f105571d, r104.f105572e, mj1.f120762a.getValue(), null);
            if (TextUtils.isEmpty(r105) == true) goto L51;
            r112.j(new UrlBuilder(FeedApi.DEFAULT_VS_FEED_API).addParam(FeedApi.NEED_MAP_KEY, 1).addParam(FeedApi.SOURCE_KEY, r105).build());
            r112.i(new UrlBuilder(FeedApi.DEFAULT_VS_FEED_API).addParam(FeedApi.SOURCE_KEY, r105).addParam(FeedApi.IS_FROM_DRAW, 1).addParam(FeedApi.IS_DRAW_KEY, 1).addParam(FeedApi.NEED_MAP_KEY, 1).build());
            c0 r106 = this.f105589e;
            r112.h(Boolean.valueOf(LiveDrawerUrlHelper.isParamInList(r106.f105571d, r106.f105572e, jp.f120542a.getValue())));
            r102 = r112;
        L51:
            this.f105587c = r102;
            if (r111 == false) goto L68;
            a();
            return;
        L68:
            return;
        L15:
            List<? extends ng2.c> r113 = mp.f120773a.getValue();
            if (r113 != null) goto L18;
        L47:
            r101 = null;
            goto L48
        L18:
            if (TextUtils.isEmpty(r100) == true) goto L47;
            Iterator<? extends ng2.c> r114 = r113.iterator();
            r101 = null;
        L22:
            if (r114.hasNext() == false) goto L41;
            ng2.c r107 = r114.next();
            if (r107 == null) goto L22;
            if (r107.b() == null) goto L22;
            if (TextUtils.equals(r107.b(), r100) == true) goto L30;
            if (r107.b().startsWith("*") == false) goto L37;
            if (r100.endsWith(r107.b().replace("*", "")) == false) goto L37;
        L40:
            r101 = r107;
        L37:
            if (r107.b().endsWith("*") == false) goto L22;
            if (r100.startsWith(r107.b().replace("*", "")) == false) goto L22;
        L30:
            r101 = r107;
            goto L48
        L41:
            if (r101 == null) goto L48;
            if (tb1.c.f545229a == false) goto L48;
            List<DrawerLayout.DrawerListener> r115 = LiveDrawerHelper.f105874a;
            if (LiveDrawerHelper.c(this.f105589e.f105571d) == false) goto L48;
            r101.i(c0.a(this.f105589e, r101.a()));
            r101.j(c0.a(this.f105589e, r101.e()));
            goto L48
        L10:
            if (com.bytedance.android.livesdk.chatroom.utils.p0.f114580b.contains(r110.f105571d) == false) goto L13;
        L5:
            if (TextUtils.isEmpty(r110.f105572e) == true) goto L7;
            this.f105585a = r110.f105571d + "_" + r110.f105572e;
            goto L7
        }

        public a(c0 r100, ng2.c r101) {
            this.f105589e = r100;
            if (TextUtils.isEmpty(r100.f105571d) == false) goto L5;
        L7:
            this.f105588d = new HashMap();
            this.f105586b = r101;
            return;
        L5:
            if (TextUtils.isEmpty(r100.f105572e) == true) goto L7;
            this.f105585a = r100.f105571d + "_" + r100.f105572e;
            goto L7
        }
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isLiveRoomCanPreview() {
        return false;
    }

    public static c0 b() {
        if (f105566r != null) goto L15;
        monitor-enter(c0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f105566r != null) goto L9;
        f105566r = new c0();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c0.class);     // Catch: Throwable -> L11
    L15:
        return f105566r;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final void enableMakeSureLiveDrawerUrlNotNULL() {
        a r100 = this.f105569b;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f105583p = true;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getDrawerUrl() {
        if (this.f105568a == false) goto L11;
        a r100 = this.f105569b;
        if (r100 == null) goto L13;
        ng2.c r101 = r100.f105586b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.e();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getEnterFromMerge() {
        if (this.f105568a == true) goto L5;
        return null;
    L5:
        if (this.f105569b != null) goto L8;
        return null;
    L8:
        return this.f105571d;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getEnterMethod() {
        if (this.f105568a == true) goto L5;
        return null;
    L5:
        if (this.f105569b != null) goto L8;
        return null;
    L8:
        return this.f105572e;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getInnerUrl() {
        if (this.f105568a == false) goto L11;
        a r100 = this.f105569b;
        if (r100 == null) goto L13;
        ng2.c r101 = r100.f105586b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.a();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final ng2.c getLiveDrawerUrl() {
        if (this.f105568a == false) goto L9;
        a r100 = this.f105569b;
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.f105586b;
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getReqFrom() {
        if (this.f105568a == false) goto L11;
        a r100 = this.f105569b;
        if (r100 == null) goto L13;
        ng2.c r101 = r100.f105586b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.c();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getTitle() {
        if (this.f105568a == false) goto L11;
        a r100 = this.f105569b;
        if (r100 == null) goto L13;
        ng2.c r101 = r100.f105586b;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.d();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getVSDrawerUrl() {
        if (this.f105568a == false) goto L11;
        a r100 = this.f105569b;
        if (r100 == null) goto L13;
        ng2.c r101 = r100.f105587c;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.e();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final String getVSInnerUrl() {
        if (this.f105568a == false) goto L11;
        a r100 = this.f105569b;
        if (r100 == null) goto L13;
        ng2.c r101 = r100.f105587c;
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.a();
    L13:
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isAuthRewardRoom() {
        if (this.f105584q == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isEnableMultiTab() {
        if (this.f105568a == false) goto L13;
        a r100 = this.f105569b;
        if (r100 == null) goto L16;
        ng2.c r101 = r100.f105586b;
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.f() == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isEnableReplaceRecommend() {
        if (this.f105568a == false) goto L13;
        a r100 = this.f105569b;
        if (r100 == null) goto L16;
        ng2.c r101 = r100.f105586b;
        if (r101 != null) goto L10;
        return false;
    L10:
        if (r101.g() == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    L13:
        return false;
    }

    public c0() {
        this.f105568a = false;
        this.f105574g = false;
        this.f105576i = 0;
        this.f105577j = 3;
        this.f105578k = 0;
        this.f105582o = false;
        this.f105583p = false;
        this.f105584q = -1;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final int getCreatedTimes() {
        return f105567s;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final int getDrawerJumpFromTabType() {
        return this.f105578k;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final long getFirstRoomId() {
        return this.f105573f;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final int getInnerFlowTrackDelaySeconds() {
        return this.f105577j;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isEmbeddedLiveRoom() {
        return this.f105574g;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isFromMatchRoom() {
        return this.f105582o;
    }

    public static boolean e(Room r100) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.getTvInfo() != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals("homepage_fresh", b().getEnterFromMerge()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final void clear(FragmentActivity r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f105579l == null) goto L7;
        r100.getLifecycle().removeObserver(this.f105579l);
        this.f105579l = null;
    L7:
        this.f105568a = false;
        this.f105569b = null;
        this.f105570c = null;
        this.f105572e = null;
        this.f105571d = null;
        this.f105574g = false;
        HashMap<String, Long> r101 = this.f105580m;
        if (r101 == null) goto L10;
        r101.clear();
        this.f105580m = null;
    L10:
        List<Long> r102 = this.f105581n;
        if (r102 == null) goto L14;
        ((ArrayList) r102).clear();
        this.f105581n = null;
        return;
    }

    public final void d(Room r100) {
        if (r100 != null) goto L4;
    L16:
        this.f105569b = this.f105570c;
        return;
    L4:
        if (e(r100) == false) goto L16;
        bc1 r101 = bc1.f119857a;
        if (r101.getValue() == null) goto L16;
        ng2.c r102 = r101.getValue();
        String r103 = null;
        if (TextUtils.isEmpty(r102.e()) == false) goto L10;
        String r104 = null;
    L12:
        if (TextUtils.isEmpty(r102.a()) == true) goto L15;
        r103 = UriProtector.parse(r102.e()).buildUpon().appendQueryParameter("city_code", TTLiveSDK.hostService().appContext().getNearbyCityCode()).build().toString();
    L15:
        r102.i(r103);
        r102.j(r104);
        this.f105569b = new a(this, r102);
        return;
    L10:
        r104 = UriProtector.parse(r102.e()).buildUpon().appendQueryParameter("city_code", TTLiveSDK.hostService().appContext().getNearbyCityCode()).build().toString();
        goto L12
    }

    public final void f(FragmentActivity r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.hashCode() == this.f105575h) goto L7;
        return;
    L7:
        if (r100.isFinishing() == false) goto L16;
        this.f105568a = false;
        this.f105569b = null;
        this.f105570c = null;
        this.f105572e = null;
        this.f105571d = null;
        this.f105574g = false;
        this.f105584q = -1;
        HashMap<String, Long> r101 = this.f105580m;
        if (r101 == null) goto L11;
        r101.clear();
        this.f105580m = null;
    L11:
        List<Long> r102 = this.f105581n;
        if (r102 == null) goto L17;
        r102.clear();
        this.f105581n = null;
        return;
    L17:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final Integer getBackRoomInfo(long r100) {
        int r101 = -1;
        if (this.f105568a == false) goto L14;
        a r102 = this.f105569b;
        if (r102 == null) goto L14;
        if (r102.f105588d.get(Long.valueOf(r100)) == null) goto L12;
        r101 = this.f105569b.f105588d.get(Long.valueOf(r100)).intValue();
    L12:
        return Integer.valueOf(r101);
    L14:
        return -1;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isFirstRoom(long r100) {
        long r101 = this.f105573f;
        if (r101 > 0) goto L5;
    L7:
        return false;
    L5:
        if (r101 != r100) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean isInnerFlowAdRoom(long r100) {
        List<Long> r101 = this.f105581n;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(Long.valueOf(r100)) == false) goto L7;
        return true;
    }

    public static String a(c0 r100, String r101) {
        r100.getClass();
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r101;
    L6:
        return UriProtector.parse(r101).buildUpon().appendQueryParameter("city_code", TTLiveSDK.hostService().appContext().getNearbyCityCode()).build().toString();
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [com.bytedance.android.livesdk.chatroom.b0] */
    public final void c(FragmentActivity r100, Bundle r101) {
        if (this.f105568a == true) goto L24;
        if (r100 == null) goto L25;
        this.f105568a = true;
        f105567s++;
        if (r101 != null) goto L9;
        a r102 = null;
    L22:
        this.f105570c = r102;
        this.f105569b = r102;
        this.f105575h = r100.hashCode();
        this.f105580m = new HashMap();
        this.f105581n = new ArrayList();
        this.f105579l = new b0(this);
        r100.getLifecycle().addObserver(this.f105579l);
        return;
    L9:
        Bundle r103 = m0.a(r101);
        this.f105571d = r101.getString("enter_from_merge");
        this.f105572e = r101.getString("enter_method");
        this.f105574g = r101.getBoolean(ILiveRoomPageFragmentConstant.EXTRA_IS_EMBEDDED_LIVE_ROOM, false);
        if (TextUtils.isEmpty(this.f105571d) == false) goto L14;
        if (r103 == null) goto L14;
        this.f105571d = r103.getString("enter_from_merge");
    L14:
        if (TextUtils.isEmpty(this.f105572e) == false) goto L17;
        if (r103 == null) goto L17;
        this.f105572e = r103.getString("enter_method");
    L17:
        int r104 = r101.getInt(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_POPUP_REWARD_AUTH, -1);
        this.f105584q = r104;
        if (r104 != (-1)) goto L21;
        if (r103 == null) goto L21;
        this.f105584q = r103.getInt(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_POPUP_REWARD_AUTH, -1);
    L21:
        this.f105573f = r101.getLong(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
        r102 = new a(this, this.f105583p);
        goto L22
    L25:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final void recordBackRoomInfo(long r100, int r101) {
        if (this.f105568a == false) goto L9;
        a r102 = this.f105569b;
        if (r102 == null) goto L10;
        r102.f105588d.put(Long.valueOf(r100), Integer.valueOf(r101));
        return;
    L10:
        return;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveOntologyInfoManager
    public final boolean shouldHandleCommerceJob(long r100, Bundle r110) {
        if (this.f105580m != null) goto L6;
        this.f105580m = new HashMap();
    L6:
        if (this.f105581n != null) goto L9;
        this.f105581n = new ArrayList();
    L9:
        if (r110.getBoolean("enter_from_effect_ad", false) == false) goto L11;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == true) goto L23;
        Bundle r102 = m0.a(r110);
        boolean r103 = r110.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FORCE_AD_LIVE_ROOM, false);
        if (r103 == true) goto L20;
        if (r102 == null) goto L20;
        r103 = r102.getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_FORCE_AD_LIVE_ROOM, false);
    L20:
        if (r103 == true) goto L23;
        boolean r104 = false;
    L24:
        String r105 = "";
        if (r104 == false) goto L45;
        if (r110.getBoolean("enter_from_effect_ad", false) == false) goto L30;
        Serializable r106 = r110.getSerializable(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP);
    L34:
        if ((r106 instanceof HashMap) == false) goto L37;
        r105 = (String) ((HashMap) r106).get("value");
    L37:
        if (r110.getBoolean("enter_from_inner_flow_ad", false) == false) goto L42;
        if (this.f105581n.contains(Long.valueOf(r100)) == true) goto L42;
        this.f105581n.add(Long.valueOf(r100));
    L42:
        if (r110.getInt("inner_flow_ad_delay_track_seconds", -1) < 0) goto L45;
        this.f105577j = r110.getInt("inner_flow_ad_delay_track_seconds");
        goto L45
    L30:
        if (r110.getBoolean("enter_from_dou_plus", false) == false) goto L32;
        r106 = r110.getSerializable("live_douplus_log_extra");
        goto L34
    L32:
        r106 = null;
    L45:
        if (TextUtils.isEmpty(r105) == true) goto L52;
        if (this.f105580m.containsKey(r105) == false) goto L52;
        if (this.f105580m.get(r105) == null) goto L52;
        long r107 = this.f105580m.get(r105).longValue();
    L60:
        if (r107 != r100) goto L63;
        return true;
    L63:
        return false;
    L52:
        if (TextUtils.isEmpty(r105) == false) goto L54;
    L58:
        r107 = 0;
        goto L60
    L54:
        if (this.f105580m.containsKey(r105) == true) goto L58;
        if (r100 == 0) goto L58;
        this.f105580m.put(r105, Long.valueOf(r100));
        r107 = r100;
    L23:
        r104 = true;
        goto L24
    L11:
        if (r110.getBoolean("enter_from_dou_plus", false) == true) goto L14;
        r101 = false;
        goto L15
    }
}
