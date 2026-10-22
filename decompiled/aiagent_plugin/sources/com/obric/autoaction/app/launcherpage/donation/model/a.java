package com.obric.autoaction.app.launcherpage.donation.model;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DonationTask.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f23803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f23804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Question f23805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<c> f23806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f23807e;
    private long f;
    private String g;
    private List<String> h;
    private String i;

    public a(String r3, String r4, Question r5, List<c> r6, int r7, long r8, String r10) {
        List<c> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        o.e(r3, DbHelper.COL_ID);
        o.e(r4, "target");
        o.e(r9, "operations");
        this.f23803a = r3;
        this.f23804b = r4;
        this.f23805c = r5;
        this.f23806d = r9;
        this.f23807e = r7;
        this.f = r8;
        this.g = r10;
    }

    public /* synthetic */ a(String r11, String r12, Question r13, List r14, int r15, long r16, String r18, int r19, h r20) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        if ((r19 & 64) == 0) goto L5;
        String r9 = null;
    L6:
        this(r11, r12, r13, r5, r15, r16, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final String a() {
        return this.f23803a;
    }

    public final String b() {
        return this.f23804b;
    }

    public final Question c() {
        return this.f23805c;
    }

    public final List<c> d() {
        return this.f23806d;
    }

    public final void a(int r1) {
        this.f23807e = r1;
    }

    public final int e() {
        return this.f23807e;
    }

    public final void a(long r1) {
        this.f = r1;
    }

    public final long f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final void a(List<String> r3) {
        this.h = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final List<String> h() {
        return this.h;
    }

    public final void a(String r1) {
        this.i = r1;
    }

    public final String i() {
        return this.i;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L5;
        return true;
    L5:
        Class<?> r2 = getClass();
        if (r9 == null) goto L8;
        Class<?> r3 = r9.getClass();
    L10:
        if (o.a(r2, r3) == true) goto L12;
        return false;
    L12:
        o.a(r9, "null cannot be cast to non-null type com.obric.autoaction.app.launcherpage.donation.model.DonationTask");
        a r4 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f23803a, ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).f23803a) == true) goto L16;
        return false;
    L16:
        if (o.a(this.f23805c, ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).f23805c) == true) goto L19;
        return false;
    L19:
        if (o.a(this.f23804b, ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).f23804b) == true) goto L22;
        return false;
    L22:
        if (this.f23807e == ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).f23807e) goto L25;
        return false;
    L25:
        if (this.f == ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).f) goto L28;
        return false;
    L28:
        if (o.a(this.g, ((a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin")).g) == true) goto L30;
        return false;
    L30:
        return true;
    L8:
        r3 = null;
        goto L10
    }

    public int hashCode() {
        int r0 = ((this.f23803a.hashCode() * 31) + this.f23804b.hashCode()) * 31;
        Question r1 = this.f23805c;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (((((r0 + r3) * 31) + this.f23807e) * 31) + Long.hashCode(this.f)) * 31;
        String r5 = this.g;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final JSONObject j() {
        JSONObject r0 = new JSONObject();
        Question r1 = this.f23805c;
        if (r1 == null) goto L5;
        JSONObject r2 = r1.toJson();
    L6:
        r0.put("question", r2);
        r0.put("target", this.f23804b);
        r0.put("app_list", new JSONArray((Collection) ZeusTransformUtils.preCheckCast(this.h, Collection.class, "com.obric.aiagent.plugin")));
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(this.f23806d, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        Object r6 = r5.next();
        if (ZeusTransformUtils.instanceOf(((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin")).a(), OScreenEvent.OAppStateEvent.class) == false) goto L8;
        r4.add(r6);
        goto L8
    L12:
        Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r8 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r7, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        OScreenEvent r10 = ((c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.aiagent.plugin")).a();
        o.a(r10, "null cannot be cast to non-null type com.obric.autogui.common.api.platform.screen.capture.OScreenEvent.OAppStateEvent");
        r8.add(((OScreenEvent.OAppStateEvent) ZeusTransformUtils.preCheckCast(r10, OScreenEvent.OAppStateEvent.class, "com.obric.aiagent.plugin")).getAppName());
        goto L14
    L16:
        r0.put("use_app_list", new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        r0.put("location", this.i);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(this.f23806d, Iterable.class, "com.obric.aiagent.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r11, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r13 = r11.iterator();
    L18:
        if (r13.hasNext() == false) goto L20;
        r12.add(((c) ZeusTransformUtils.preCheckCast(r13.next(), c.class, "com.obric.aiagent.plugin")).f());
        goto L18
    L20:
        r0.put("answer", new JSONArray((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")));
        return r0;
    L5:
        r2 = null;
        goto L6
    }
}
