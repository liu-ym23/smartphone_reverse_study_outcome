package com.bytedance.android.live.saas.middleware.store;

import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦\u0002J\b\u0010\u0007\u001a\u00020\bH&J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u0003\u0018\u00010\nH&J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0004H&J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000eH&J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0010H&J\u001a\u0010\u0011\u001a\u00020\u00122\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0012H&J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0006H&J(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0016H&J\u001c\u0010\u0017\u001a\u00020\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H&J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/store/IMiddlewareSharedPref;", "", "clear", "contains", "", "key", "", "end", "", "getAll", "", "getBoolean", "defaultValue", "getFloat", "", "getInt", "", "getLong", "", "getString", "getStringSet", "", "", "put", "object", "putEnd", "remove", "middleware_release"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareSharedPref {
    IMiddlewareSharedPref clear();

    boolean contains(String r100);

    void end();

    Map<String, ?> getAll();

    boolean getBoolean(String r100, boolean r101);

    float getFloat(String r100, float r101);

    int getInt(String r100, int r101);

    long getLong(String r100, long r101);

    String getString(String r100, String r101);

    Set<String> getStringSet(String r100, Set<String> r101);

    IMiddlewareSharedPref put(String r100, Object r101);

    void putEnd(String r100, Object r101);

    IMiddlewareSharedPref remove(String r100);
}
