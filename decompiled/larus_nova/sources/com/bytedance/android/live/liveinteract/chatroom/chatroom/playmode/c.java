package com.bytedance.android.live.liveinteract.chatroom.chatroom.playmode;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.playmode.IncompatibleTag;
import com.larus.nova.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IncompatibleTag f72178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xh0.h f72179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<Integer, String> f72180c;

    public final String c() {
        StringBuilder r100 = new StringBuilder();
        Iterator<Map.Entry<Integer, String>> r101 = this.f72180c.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        Map.Entry<Integer, String> r102 = r101.next();
        r100.append("[key: " + r102.getKey().intValue() + " toast: " + r102.getValue() + "], ");
        goto L4
    L7:
        return r100.toString();
    }

    public final void a(Pair<Integer, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "newRule");
        if (this.f72180c.containsKey(r100.getFirst()) == true) goto L6;
        this.f72180c.put(r100.getFirst(), r100.getSecond());
        return;
    }

    public final xh0.g b(List<Integer> r110, Map<Integer, ? extends xh0.b> r111) {
        Intrinsics.checkNotNullParameter(r110, "currentRuleKeys");
        Intrinsics.checkNotNullParameter(r111, "loadedPlayModes");
        Iterator<Integer> r100 = r110.iterator();
    L4:
        if (r100.hasNext() == false) goto L34;
        int r101 = r100.next().intValue();
        if (this.f72180c.containsKey(Integer.valueOf(r101)) == false) goto L4;
        String r112 = this.f72180c.get(Integer.valueOf(r101));
        if (r112 != null) goto L10;
    L13:
        boolean r113 = true;
    L15:
        if (r113 == true) goto L18;
        String r114 = this.f72180c.get(Integer.valueOf(r101));
    L27:
        IncompatibleTag r102 = this.f72178a;
        StringBuilder r103 = new StringBuilder();
        r103.append(this.f72178a);
        r103.append('_');
        r103.append(r101);
        String r104 = r103.toString();
        if (r114 != null) goto L30;
        String r105 = "";
    L32:
        return new xh0.g(r102, r101, false, r104, r105);
    L30:
        r105 = r114;
        goto L32
    L18:
        if (b.f72177a[this.f72178a.ordinal()] == 1) goto L20;
        r114 = "";
        goto L27
    L20:
        xh0.b r115 = (xh0.b) ((ConcurrentHashMap) r111).get(Integer.valueOf(r101));
        if (r115 == null) goto L25;
        xh0.h r116 = r115.getPlayModeInfo();
        if (r116 == null) goto L25;
        String r117 = r116.f563853b;
    L26:
        r114 = s1.C(R.string.ttlive_playmode_incompatible_text, new Object[]{r117, this.f72179b.f563853b});
    L25:
        r117 = null;
        goto L26
    L10:
        if (r112.length() == 0) goto L13;
        r113 = false;
        goto L15
    L34:
        if (r110.size() != 1) goto L38;
        Integer r118 = (Integer) CollectionsKt.firstOrNull(r110);
        if (r118 == null) goto L38;
        int r106 = r118.intValue();
    L40:
        return new xh0.g(this.f72178a, r106, true, null, 24);
    L38:
        r106 = -1;
        goto L40
    }

    public c(IncompatibleTag r100, xh0.h r101, HashMap<Integer, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "incompatibleTag");
        Intrinsics.checkNotNullParameter(r101, "playModeInfo");
        Intrinsics.checkNotNullParameter(r102, "incompatibleRules");
        this.f72178a = r100;
        this.f72179b = r101;
        this.f72180c = r102;
    }
}
