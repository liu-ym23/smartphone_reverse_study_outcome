package com.bytedance.android.shopping.store.tabkit.cache;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/cache/UrlInfo;", "", "url", "", "(Ljava/lang/String;)V", "data", "Ljava/util/concurrent/ConcurrentHashMap;", "getData", "()Ljava/util/concurrent/ConcurrentHashMap;", "expires", "", "path", "getPath", "()Ljava/lang/String;", "setPath", "query", "", "getQuery", "()Ljava/util/Map;", "hasExpired", "", "isSame", "info", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UrlInfo {
    private final ConcurrentHashMap<String, String> data;
    private final long expires;
    private String path;
    private final Map<String, String> query;

    public final boolean hasExpired() {
        if (System.currentTimeMillis() <= this.expires) goto L5;
        return true;
    L5:
        return false;
    }

    public final ConcurrentHashMap<String, String> getData() {
        return this.data;
    }

    public final String getPath() {
        return this.path;
    }

    public final Map<String, String> getQuery() {
        return this.query;
    }

    public UrlInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.expires = System.currentTimeMillis() + ((long) 30000);
        this.query = new LinkedHashMap();
        this.data = new ConcurrentHashMap();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L11
        Iterator<T> r103 = UriProtector.getQueryParameterNames(r102).iterator();     // Catch: Throwable -> L11
    L5:
        if (r103.hasNext() == false) goto L9;
        String r104 = (String) r103.next();     // Catch: Throwable -> L11
        String r105 = UriProtector.getQueryParameter(r102, r104);     // Catch: Throwable -> L11
        if (r105 == null) goto L5;
        this.query.put(r104, r105);     // Catch: Throwable -> L11
        goto L5
    L9:
        this.path = r102.buildUpon().clearQuery().toString();     // Catch: Throwable -> L11
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final boolean isSame(UrlInfo r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<Map.Entry<String, String>> r101 = this.query.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<String, String> r102 = r101.next();
        List<String> r103 = TabKitRouterCache.f186633a;
        if (TabKitRouterCache.f186633a.contains(r102.getKey()) == true) goto L7;
        if ((!Intrinsics.areEqual(r102.getValue(), r100.query.get(r102.getKey()))) == false) goto L7;
        return false;
    L14:
        return true;
    }

    public final void setPath(String r100) {
        this.path = r100;
    }
}
