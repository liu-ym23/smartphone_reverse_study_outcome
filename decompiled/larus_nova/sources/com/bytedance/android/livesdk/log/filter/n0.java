package com.bytedance.android.livesdk.log.filter;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.s8;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.reflect.TypeToken;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class n0 extends com.bytedance.android.livesdk.log.filter.a<am2.x> implements t {
    public TypeToken<HashMap<String, Object>> A;
    public final boolean B;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f153306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f153307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f153308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f153309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f153310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f153311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f153312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f153313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f153314k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f153315l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f153316m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f153317n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f153318o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f153319p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f153320q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f153321r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f153322s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Map<String, String> f153323t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Map<String, String> f153324u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f153325v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f153326w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f153327x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f153328y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f153329z;

    public class a extends TypeToken<HashMap<String, Object>> {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void o() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String D() {
        return this.f153322s.get("group_member_id");
    }

    public final void J() {
        this.f153320q.clear();
    }

    public final void K() {
        this.f153323t.clear();
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String q() {
        Map<String, String> r100 = this.f153291b;
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.get(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO);
        if (r101 != null) goto L8;
    L22:
        return null;
    L8:
        if (r101.isEmpty() == true) goto L22;
        if (this.A != null) goto L13;
        this.A = new a();
    L13:
        HashMap r102 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.get(), r101, this.A.getType());
        if (r102 != null) goto L16;
        return "";
    L16:
        if ((r102.get("anchor_identity") instanceof String) == true) goto L19;
        return "";
    L19:
        return (String) r102.get("anchor_identity");
    }

    public n0() {
        this.f153319p = 0;
        this.f153320q = Collections.synchronizedMap(new HashMap());
        this.f153321r = Collections.synchronizedMap(new HashMap());
        this.f153322s = Collections.synchronizedMap(new HashMap());
        this.f153323t = Collections.synchronizedMap(new HashMap());
        this.f153324u = Collections.synchronizedMap(new HashMap());
        this.f153325v = -1;
        this.f153328y = null;
        this.f153329z = null;
        this.A = null;
        this.B = s8.f157862a.getValue().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String A() {
        return this.f153317n;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String B() {
        return this.f153308e;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String b() {
        return this.f153306c;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String d() {
        return this.f153307d;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String e() {
        return this.f153315l;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String f() {
        return this.f153316m;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String g() {
        return this.f153318o;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final int getApplyType() {
        return this.f153325v;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String getMatchType() {
        return this.f153309f;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String getRoomTag() {
        return this.f153310g;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String i() {
        return this.f153329z;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final boolean j() {
        return this.f153327x;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String k() {
        return this.f153314k;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String l() {
        return this.f153313j;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String m() {
        return this.f153326w;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String p() {
        return this.f153312i;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String w() {
        return this.f153311h;
    }

    public static void N(Map r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (tb1.c.f545229a == true) goto L7;
        return;
    L7:
        if (r100.containsKey("enter_from_ad_type") == true) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty((CharSequence) r100.get("enter_from_ad_type")) == true) goto L14;
        r100.put("enter_from_merge", (String) r100.get("enter_from_ad_type"));
        r100.remove("enter_from_ad_type");
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void F(String r100) {
        this.f153313j = r100;
    }

    public final void L(Map<String, String> r100) {
        this.f153323t.putAll(r100);
    }

    public final void M(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<String> r101 = r100.keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        String r102 = r101.next();
        this.f153321r.put(r102, r100.getString(r102, ""));
        goto L6
    }

    public final void O(String r100) {
        this.f153326w = r100;
    }

    public final void P(int r100) {
        this.f153325v = r100;
    }

    public final void Q(String r100) {
        this.f153314k = r100;
    }

    public final void R(String r100) {
        this.f153317n = r100;
    }

    public final void S(String r100) {
        this.f153316m = r100;
    }

    public final void T(String r100) {
        this.f153307d = r100;
    }

    public final void U(String r100) {
        this.f153312i = r100;
    }

    public final void V(String r100) {
        this.f153318o = r100;
    }

    public final void W(String r100) {
        this.f153308e = r100;
    }

    public final void X(String r100) {
        this.f153309f = r100;
    }

    public final void Y(String r100) {
        this.f153329z = r100;
    }

    public final void Z(String r100) {
        this.f153328y = r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        r100.putAll(this.f153323t);
        r100.putAll(this.f153320q);
        r100.putAll(this.f153321r);
        if (this.B == false) goto L5;
        r100.putAll(this.f153322s);
    L5:
        r100.putAll(this.f153324u);
        N(r100);
        String r101 = this.f153312i;
        if (r101 == null) goto L8;
        r100.put("distribute_source", r101);
    L8:
        r100.put("room_rank", String.valueOf(this.f153319p));
        IHostBusiness r102 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r102 == null) goto L14;
        String r103 = r102.getDesktopParams();
        if (r103 == null) goto L15;
        r100.put(WindowEvent.Params.LAUNCH_METHOD, r103);
        return;
    L15:
        return;
    }

    public final void a0(String r100) {
        this.f153310g = r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final String h(String r100) {
        return this.f153320q.get(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void r(boolean r100) {
        if (r100 == false) goto L4;
        this.f153322s.clear();
        return;
    L4:
        this.f153321r.clear();
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void s(Map<String, String> r100) {
        this.f153320q.putAll(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void t(String r100) {
        this.f153315l = r100;
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void E(String r100, String r101) {
        this.f153320q.put(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.log.filter.t
    public final void G(Map<String, String> r100, boolean r101) {
        if (r101 == false) goto L4;
        this.f153322s.putAll(r100);
        return;
    L4:
        this.f153321r.putAll(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, am2.x r101) {
        am2.x r102 = r101;
        super.u(r100, r102);
        r100.putAll(this.f153320q);
        r100.putAll(this.f153321r);
        r100.putAll(this.f153322s);
        r100.putAll(this.f153324u);
        if (r102 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r102.f4350b) == true) goto L9;
        r100.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r102.f4350b);
    L9:
        if (StringUtils.isEmpty(r102.f4351c) == true) goto L12;
        r100.put("event_module", r102.f4351c);
    L12:
        if (StringUtils.isEmpty(null) == true) goto L15;
        r100.put("source", null);
    L15:
        if (StringUtils.isEmpty(r102.f4352d) == true) goto L18;
        r100.put("enter_from", r102.f4352d);
    L18:
        if (StringUtils.isEmpty(r102.f4349a) == true) goto L21;
        r100.put("event_belong", r102.f4349a);
    L21:
        if (StringUtils.isEmpty(r102.f4353e) == true) goto L24;
        r100.put("event_type", r102.f4353e);
    L24:
        if (StringUtils.isEmpty(r102.f4354f) == true) goto L27;
        r100.put("action_type", r102.f4354f);
    L27:
        if (StringUtils.isEmpty(null) == true) goto L29;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_TOP_MESSAGE_TYPE, null);
    L29:
        N(r100);
        String r103 = this.f153312i;
        if (r103 == null) goto L32;
        r100.put("distribute_source", r103);
    L32:
        r100.put("room_rank", String.valueOf(this.f153319p));
        IHostBusiness r104 = (IHostBusiness) jc1.k.f(IHostBusiness.class);
        if (r104 == null) goto L38;
        String r105 = r104.getDesktopParams();
        if (r105 == null) goto L39;
        r100.put(WindowEvent.Params.LAUNCH_METHOD, r105);
        return;
    L39:
        return;
    }
}
