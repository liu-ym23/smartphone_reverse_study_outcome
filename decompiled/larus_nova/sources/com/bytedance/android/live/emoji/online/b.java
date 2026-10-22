package com.bytedance.android.live.emoji.online;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class b implements r90.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f68925a = 0;

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // r90.c
    public final int c() {
        OnlineSmallEmojiResManager r100 = OnlineSmallEmojiResManager.f68913i;
        return OnlineSmallEmojiResManager.f68913i.b().size();
    }

    @Override // r90.c
    public final List b(List r100) {
        if (r100 == null) goto L35;
        OnlineSmallEmojiResManager r101 = OnlineSmallEmojiResManager.f68913i;
        if (r101.d() == false) goto L48;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L19;
        String r104 = (String) r103.next();
        String r105 = r101.b().get(r104);
        if (r105 != null) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == true) goto L8;
        r102.put(r104, r105);
        goto L8
    L12:
        if (r105.length() == 0) goto L15;
        r106 = false;
        goto L16
    L19:
        if (r102.size() >= 8) goto L30;
        LinkedHashMap<String, String> r107 = r101.b();
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r109 = r107.entrySet().iterator();
    L22:
        if (r109.hasNext() == false) goto L26;
        Map.Entry<String, String> r110 = r109.next();
        if (r102.keySet().contains(r110.getKey()) == true) goto L22;
        r108.put(r110.getKey(), r110.getValue());
        goto L22
    L26:
        Iterator r111 = CollectionsKt.take(r108.entrySet(), 8 - r102.size()).iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        Map.Entry r112 = (Map.Entry) r111.next();
        r102.put(r112.getKey(), r112.getValue());
    L30:
        ArrayList r113 = new ArrayList();
        Iterator r114 = r102.entrySet().iterator();
    L32:
        if (r114.hasNext() == false) goto L49;
        Map.Entry r115 = (Map.Entry) r114.next();
        BaseEmoji r116 = new BaseEmoji();
        r116.setDescription((String) r115.getKey());
        r116.setLocalFilePath(r101.c((String) r115.getValue()));
        Unit r117 = Unit.INSTANCE;
        r113.add(r116);
        goto L32
    L49:
        return r113;
    L48:
        return new ArrayList();
    L35:
        return new ArrayList();
    }

    @Override // r90.c
    public final List d(int r100) {
        OnlineSmallEmojiResManager r101 = OnlineSmallEmojiResManager.f68913i;
        if (r101.d() == false) goto L28;
        ArrayList r102 = new ArrayList();
        if (r101.b().size() <= 0) goto L23;
        Iterator<Map.Entry<String, String>> r103 = r101.b().entrySet().iterator();
        int r104 = 0;
        int r105 = 0;
    L10:
        if (r103.hasNext() == false) goto L18;
        Map.Entry<String, String> r106 = r103.next();
        if (r105 >= 0) goto L14;
    L16:
        r105 = r105 + 1;
        if (r105 < (0 + r100)) goto L10;
    L14:
        if (r105 >= (0 + r100)) goto L16;
        BaseEmoji r107 = new BaseEmoji();
        r107.setDescription(r106.getKey());
        r107.setLocalFilePath(r101.c(r106.getValue()));
        Unit r108 = Unit.INSTANCE;
        r102.add(r107);
    L18:
        int r109 = r100 - r102.size();
        if (r109 <= 0) goto L23;
    L20:
        if (r104 >= r109) goto L23;
        r102.add(new BaseEmoji());
        r104 = r104 + 1;
    L23:
        return r102;
    L28:
        return new ArrayList();
    }

    @Override // r90.c
    public final Drawable a(Context r100, String r101) {
        if (r100 == null) goto L40;
        if (r101 != null) goto L6;
    L9:
        boolean r102 = true;
    L10:
        if (r102 == true) goto L41;
        OnlineSmallEmojiResManager r103 = OnlineSmallEmojiResManager.f68913i;
        if (r103.d() == false) goto L34;
        OnlineSmallEmojiCache r104 = r103.f68917d;
        if (r104 == null) goto L34;
        if (r103.d() == false) goto L22;
        String r105 = (String) ((LinkedHashMap) r103.f68915b.getValue()).get(r101);
        if (r105 != null) goto L23;
        ALogger.d("OnlineEmojiResManager", "  mapResource not found: " + r101);
    L23:
        int r106 = OnlineSmallEmojiCache.f68909d;
        if (r105 == null) goto L34;
        monitor-enter(r104);
        Bitmap r107 = (Bitmap) ((LruCache) r104.f68910a.getValue()).get(r105);     // Catch: Throwable -> L31
        monitor-exit(r104);
        if (r107 != null) goto L35;
        r107 = r104.a(r105);
    L35:
        if (r107 != null) goto L37;
        return null;
    L37:
        return new BitmapDrawable(r100.getResources(), r107);
    L31:
        th = move-exception;
        throw th;
    L22:
        r105 = null;
    L34:
        r107 = null;
        goto L35
    L41:
        return null;
    L6:
        if (r101.length() == 0) goto L9;
        r102 = false;
        goto L10
    L40:
        return null;
    }
}
