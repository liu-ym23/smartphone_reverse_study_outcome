package com.bytedance.android.livesdk.log;

import android.os.Bundle;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdk.utils.v3;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f153409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f153410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, String> f153411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f153412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f153413e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static HashMap<String, String> f153414f;

    public static Map b() {
        if (f153414f != null) goto L32;
        long r100 = f153413e;
        boolean r101 = false;
        if (r100 != 0) goto L7;
    L13:
        boolean r102 = false;
    L15:
        if (f153410b != 0) goto L17;
    L19:
        if (r102 == true) goto L21;
        if (r101 == false) goto L32;
    L21:
        HashMap<String, String> r103 = new HashMap();
        if (r102 == false) goto L26;
        Map<String, String> r104 = f153411c;
        if (r104 == null) goto L26;
        r103.putAll(r104);
    L26:
        if (r101 == false) goto L30;
        Map<String, String> r105 = f153409a;
        if (r105 == null) goto L30;
        r103.putAll(r105);
    L30:
        f153414f = r103;
        goto L32
    L17:
        if (f153409a == null) goto L19;
        r101 = true;
        goto L19
    L7:
        if (f153411c == null) goto L13;
        if (f153412d == false) goto L11;
    L12:
        r102 = true;
        goto L15
    L11:
        if (f153410b != r100) goto L13;
    L32:
        return f153414f;
    }

    static {
    }

    public static long c(Bundle r100) {
        if (r100 == null) goto L4;
        Object r101 = r100.get(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_ID);
    L6:
        if ((r101 instanceof Number) == false) goto L9;
        return ((Number) r101).longValue();
    L9:
        if ((r101 instanceof String) == true) goto L14;
        return 0;
    L14:
        return d5.c((String) r101);
    L4:
        r101 = null;
        goto L6
    }

    public static void d(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "arguments");
        Object r101 = r100.get(ILiveRoomPlayFragmentConstant.ITEM_LOG_PB);
        if ((r101 instanceof Map) == true) goto L5;
        r101 = null;
    L5:
        f153409a = (Map) r101;
        f153410b = c(r100);
        f153414f = null;
    }

    public static void a(Bundle r100, FeedItem r101) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        Intrinsics.checkNotNullParameter(r101, "feedItem");
        String r102 = r101.itemLogPb;
        int r103 = v3.f159190a;
        JSONObject r104 = null;
        if (r102 != null) goto L24;
    L7:
        if (r104 != null) goto L10;
        return;
    L10:
        if (r104.length() != 0) goto L12;
        return;
    L12:
        HashMap r105 = new HashMap();
        Iterator<String> r106 = r104.keys();
    L14:
        if (r106.hasNext() == false) goto L21;
        String r107 = r106.next();
        Object r108 = r104.opt(r107);
        if (r108 == null) goto L19;
        String r109 = r108.toString();
        if (r109 == null) goto L19;
    L20:
        r105.put(r107, r109);
    L19:
        r109 = "";
        goto L20
    L21:
        r100.putSerializable(ILiveRoomPlayFragmentConstant.ITEM_LOG_PB, r105);
        return;
    L24:
        r104 = new JSONObject(r102);     // Catch: Throwable -> L23
        goto L7
    }
}
