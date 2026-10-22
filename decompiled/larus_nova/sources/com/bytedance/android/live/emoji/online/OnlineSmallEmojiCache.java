package com.bytedance.android.live.emoji.online;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.common.utility.BitmapUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class OnlineSmallEmojiCache {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f68909d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f68910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnlineSmallEmojiResInfo f68912c;

    public static final class a {
    }

    static {
    }

    public OnlineSmallEmojiCache(OnlineSmallEmojiResInfo r100) {
        this.f68912c = r100;
        this.f68910a = LazyKt.lazy(OnlineSmallEmojiCache$lruCache$2.INSTANCE);
        this.f68911b = LazyKt.lazy(OnlineSmallEmojiCache$weakRefCache$2.INSTANCE);
    }

    public final Bitmap a(String r110) {
        String r100 = c.f68926a;
        String r101 = this.f68912c.getPicFileDirPath();
        Intrinsics.checkNotNullParameter(r101, "picFileDirPath");
        Intrinsics.checkNotNullParameter(r110, "picFileName");
        boolean r102 = true;
        List r103 = CollectionsKt.mutableListOf(new String[]{r110});
        Bitmap r104 = null;
        if (r103.isEmpty() == false) goto L5;
        r103.toString();
    L30:
        LinkedHashMap r105 = null;
    L31:
        if (r105 != null) goto L33;
    L45:
        if (r104 == null) goto L53;
        monitor-enter(this);
        ((LruCache) this.f68910a.getValue()).put(r110, r104);     // Catch: Throwable -> L50
        monitor-exit(this);
    L50:
        th = move-exception;
        throw th;
    L53:
        return r104;
    L33:
        if (r105.size() == 1) goto L36;
        r102 = false;
    L36:
        if (r102 == true) goto L39;
        r105 = null;
    L39:
        if (r105 == null) goto L45;
        ArrayList r106 = new ArrayList(r105.size());
        Iterator r107 = r105.entrySet().iterator();
    L42:
        if (r107.hasNext() == false) goto L44;
        r106.add((Bitmap) ((Map.Entry) r107.next()).getValue());
        goto L42
    L44:
        r104 = (Bitmap) ListProtector.get(r106, 0);
        goto L45
    L5:
        PolarisFileWrapper r108 = new PolarisFileWrapper(r101);
        if (r108.exists() == true) goto L8;
    L29:
        r103.toString();
        goto L30
    L8:
        if (r108.isDirectory() == false) goto L29;
        File[] r109 = r108.listFiles(new d(r103));
        if (r109 != null) goto L13;
    L19:
        boolean r111 = true;
    L20:
        if (r111 == false) goto L22;
        r103.toString();
        goto L30
    L22:
        r105 = new LinkedHashMap();
        int r112 = r109.length;
        int r113 = 0;
    L23:
        if (r113 >= r112) goto L31;
        File r114 = r109[r113];
        Bitmap r115 = BitmapUtils.decodeBitmap(r114, c.f68927b);
        if (r115 == null) goto L27;
        r105.put(r114.getName(), r115);
    L28:
        r113 = r113 + 1;
        goto L23
    L27:
        r114.getName();
        r103.toString();
        goto L28
    L13:
        if (r109.length != 0) goto L15;
        boolean r116 = true;
    L16:
        if (r116 == true) goto L19;
        r111 = false;
        goto L20
    L15:
        r116 = false;
        goto L16
    }
}
