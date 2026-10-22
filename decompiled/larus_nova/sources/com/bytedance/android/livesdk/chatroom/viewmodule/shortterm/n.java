package com.bytedance.android.livesdk.chatroom.viewmodule.shortterm;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.android.live.core.utils.TimeUtils;
import j40.f4;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f115575a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f115576b = null;

    static {
        f115575a = new ArrayList();
        f115576b = new ArrayList();
    }

    public static boolean a(com.bytedance.android.live.base.model.n r100) {
        if (r100 == null) goto L44;
        com.bytedance.android.live.base.model.q r101 = r100.shortTouchInfo;
        if (r101 == null) goto L44;
        if (r101.f58926a == true) goto L10;
        return false;
    L10:
        int r102 = 1;
        if (r101.showAnimation == 1) goto L14;
        return false;
    L14:
        if (TextUtils.isEmpty(r101.imageUrl) == false) goto L16;
        return false;
    L16:
        int r103 = r100.type;
        com.bytedance.android.live.base.model.q r104 = r100.shortTouchInfo;
        int r105 = r104.animationType;
        if (r105 != 1) goto L19;
        return true;
    L19:
        if (r105 == 2) goto L42;
        if (r105 == 3) goto L40;
        if (r105 != 4) goto L25;
        Map<String, String> r106 = f4.f497211n.getValue();
        if (r106.containsKey(String.valueOf(r103)) == true) goto L37;
        return true;
    L37:
        return !TextUtils.equals(r106.get(String.valueOf(r103)), new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date()));
    L25:
        if (r105 == 5) goto L27;
        return false;
    L27:
        long r107 = r100.timeStamp;
        int r108 = r104.animationShowTimes;
        int r109 = q.f115581a;
        com.bytedance.android.livesdk.sharedpref.e<SparseArray<Pair<Long, Integer>>> r110 = f4.f497212o;
        Pair<Long, Integer> r111 = r110.getValue().get(r103);
        if (r111 != null) goto L30;
    L32:
        r110.getValue().put(r103, new Pair(Long.valueOf(r107), Integer.valueOf(r102)));
        return false;
    L30:
        if (TimeUtils.isToday(r111.getFirst().longValue(), r107) == false) goto L32;
        r102 = 1 + r111.getSecond().intValue();
        goto L32
    L40:
        return !((ArrayList) f115575a).contains(Integer.valueOf(r103));
    L42:
        return !((ArrayList) f115576b).contains(Integer.valueOf(r103));
    L44:
        return false;
    }
}
