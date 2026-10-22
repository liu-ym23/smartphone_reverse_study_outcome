package com.bytedance.android.livesdk.feed.tab.repository;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public class n implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f124503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xw1.c f124504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<com.bytedance.android.livesdk.feed.feed.e> f124505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> f124506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Gson f124507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Long, com.bytedance.android.livesdk.feed.feed.e> f124508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.android.livesdk.feed.feed.f f124509g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final xw1.b f124510h;

    public class a extends TypeToken<List<com.bytedance.android.livesdk.feed.feed.e>> {
        public a() {
        }
    }

    public class b extends TypeToken<com.bytedance.android.livesdk.feed.feed.f> {
        public b() {
        }
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final void d() {
        this.f124505c = null;
        Context r100 = this.f124503a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f124507e == null) goto L9;
        SharedPreferences.Editor r101 = r100.getSharedPreferences("ttlive_tabs_cache", 0).edit();
        r101.putString(this.f124510h.b(), GsonProtectorUtils.toJson(this.f124507e, new ArrayList()));
        SharedPrefsEditorCompat.apply(r101);
        return;
    }

    public final synchronized void g() {
        monitor-enter(this);
        List<com.bytedance.android.livesdk.feed.feed.e> r100 = this.f124505c;     // Catch: Throwable -> L22
        boolean r101 = true;
        if (r100 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        if (r102 == true) goto L20;
        i((List) h(new a(), this.f124510h.b()));     // Catch: Throwable -> L22
        List<com.bytedance.android.livesdk.feed.feed.e> r103 = this.f124505c;     // Catch: Throwable -> L22
        if (r103 != null) goto L13;
    L15:
        r101 = false;
    L16:
        if (r101 == true) goto L18;
        i(this.f124504b.a());     // Catch: Throwable -> L22
    L18:
        monitor-exit(this);
        return;
    L13:
        if (r103.isEmpty() == true) goto L15;
    L20:
        monitor-exit(this);
        return;
    L6:
        if (r100.isEmpty() == true) goto L8;
        r102 = true;
    L22:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final Observable<List<com.bytedance.android.livesdk.feed.feed.e>> e() {
        return Observable.create(new m(this)).subscribeOn(Schedulers.io());
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final com.bytedance.android.livesdk.feed.feed.f getExtra() {
        com.bytedance.android.livesdk.feed.feed.f r100 = (com.bytedance.android.livesdk.feed.feed.f) h(new b(), this.f124510h.a());
        this.f124509g = r100;
        return r100;
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final List<com.bytedance.android.livesdk.feed.feed.e> b() {
        g();
        return new ArrayList(this.f124505c);
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final synchronized boolean a(List<com.bytedance.android.livesdk.feed.feed.e> r100) {
        monitor-enter(this);
        if (r100 != null) goto L42;
    L40:
        monitor-exit(this);
        return false;
    L42:
    L37:
        th = move-exception;
        throw th;
    L6:
        if (r100.isEmpty() == true) goto L40;
        if (r100.isEmpty() == true) goto L10;
        boolean r101 = true;
    L11:
        if (r101 == false) goto L20;
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r102 = r100.iterator();     // Catch: Throwable -> L37
    L15:
        if (r102.hasNext() == false) goto L21;
        com.bytedance.android.livesdk.feed.feed.e r103 = r102.next();     // Catch: Throwable -> L37
        if (r103 == null) goto L20;
        if (r103.q() == true) goto L15;
    L21:
        boolean r104 = true;
    L22:
        if (r104 == false) goto L40;
        if (this.f124506d.a(r100, this.f124505c) == false) goto L28;
        monitor-exit(this);
        return false;
    L28:
        i(new ArrayList(r100));     // Catch: Throwable -> L37
        String r105 = GsonProtectorUtils.toJson(this.f124507e, r100);     // Catch: JsonIOException -> L33 Throwable -> L37
        SharedPreferences.Editor r106 = this.f124503a.getSharedPreferences("ttlive_tabs_cache", 0).edit();     // Catch: Throwable -> L37
        r106.putString(this.f124510h.b(), r105);     // Catch: Throwable -> L37
        SharedPrefsEditorCompat.apply(r106);     // Catch: Throwable -> L37
        monitor-exit(this);
        return true;
    L33:
        e = move-exception;
        Logger.e("BaseLocalFeedTabDataSource", "saveFeedTab: ", e);     // Catch: Throwable -> L37
        return false;
    L20:
        r104 = false;
        goto L22
    L10:
        r101 = false;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final boolean c(com.bytedance.android.livesdk.feed.feed.f r100) {
        if (r100 == null) goto L16;
        com.bytedance.android.livesdk.feed.feed.f r101 = this.f124509g;
        if (r101 == null) goto L17;
        if (r100.now >= r101.now) goto L17;
        return true;
    L17:
        String r102 = GsonProtectorUtils.toJson(this.f124507e, r100);     // Catch: JsonIOException -> L13
        SharedPreferences.Editor r103 = this.f124503a.getSharedPreferences("ttlive_tabs_cache", 0).edit();
        r103.putString(this.f124510h.a(), r102);
        SharedPrefsEditorCompat.apply(r103);
        this.f124509g = r100;
        return true;
    L13:
        e = move-exception;
        Logger.e("BaseLocalFeedTabDataSource", "saveFeedTabExtra: ", e);
        return false;
    L16:
        return true;
    }

    @Override // com.bytedance.android.livesdk.feed.tab.repository.q
    public final com.bytedance.android.livesdk.feed.feed.e f(long r100) {
        g();
        Map<Long, com.bytedance.android.livesdk.feed.feed.e> r101 = this.f124508f;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        return (com.bytedance.android.livesdk.feed.feed.e) r102.get(Long.valueOf(r100));
    }

    public final synchronized void i(List<com.bytedance.android.livesdk.feed.feed.e> r100) {
        monitor-enter(this);
        int r101 = o.f124518a;     // Catch: Throwable -> L26
        if (r100 != null) goto L6;
        List<com.bytedance.android.livesdk.feed.feed.e> r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L26
    L14:
        this.f124505c = r102;     // Catch: Throwable -> L26
        if (Lists.isEmpty(r102) == true) goto L24;
        Iterator<com.bytedance.android.livesdk.feed.feed.e> r103 = r102.iterator();     // Catch: Throwable -> L26
    L18:
        if (r103.hasNext() == false) goto L24;
        com.bytedance.android.livesdk.feed.feed.e r104 = r103.next();     // Catch: Throwable -> L26
        if (r104 == null) goto L18;
        Map<Long, com.bytedance.android.livesdk.feed.feed.e> r105 = this.f124508f;     // Catch: Throwable -> L26
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;     // Catch: Throwable -> L26
        r106.put(Long.valueOf(r104.f()), r104);     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return;
    L6:
        List<com.bytedance.android.livesdk.feed.feed.e> r107 = r100;     // Catch: Throwable -> L26
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));     // Catch: Throwable -> L26
        Iterator<T> r109 = r107.iterator();     // Catch: Throwable -> L26
    L8:
        if (r109.hasNext() == false) goto L13;
        com.bytedance.android.livesdk.feed.feed.e r110 = (com.bytedance.android.livesdk.feed.feed.e) r109.next();     // Catch: Throwable -> L26
        if (r110.getType() > 0) goto L12;
        r110.E(1);     // Catch: Throwable -> L26
    L12:
        r108.add(r110);     // Catch: Throwable -> L26
        goto L8
    L13:
        r102 = r108;
    L26:
        th = move-exception;
        throw th;
    }

    public final Object h(TypeToken r100, String r101) {
        String r102 = this.f124503a.getSharedPreferences("ttlive_tabs_cache", 0).getString(r101, "");
        if (StringUtils.isEmpty(r102) == false) goto L10;
        return null;
    L10:
        return JsonUtil.parse(r102, r100.getType());
    L7:
        e = move-exception;
        Logger.throwException(e);
        return null;
    }

    public n(xw1.b r100, xw1.d r101, Context r102, com.bytedance.android.livesdk.feed.n r103) {
        this.f124508f = new ConcurrentHashMap();
        this.f124509g = null;
        this.f124510h = r100;
        this.f124504b = r101;
        this.f124503a = r102;
        this.f124506d = r103;
        int r104 = com.bytedance.android.livesdk.feed.services.d.f124383a;
        this.f124507e = (Gson) com.bytedance.android.livesdk.feed.services.c.b(Gson.class);
    }
}
