package com.bytedance.android.live.broadcastgame.xplay;

import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.livesdk.config.hk1;
import com.bytedance.android.livesdk.config.uz0;
import com.bytedance.android.livesdk.config.y20;
import com.bytedance.android.livesdk.crash.SourceType;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f62074a = 0;

    static {
    }

    public static hk1 a(XplayScene r100, IXplayCoreService.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "startParams");
        Map<String, ? extends hk1> r102 = uz0.f121412a.getValue().get(String.valueOf(r100.getSceneId()));
        StringBuilder r103 = new StringBuilder();
        r103.append(r101.f61844e);
        r103.append('_');
        r103.append(r101.f61845f);
        String r104 = r103.toString();
        hk1 r105 = null;
        if (r102 == null) goto L5;
        hk1 r106 = r102.get(r104);
    L6:
        if (r102 == null) goto L8;
        r105 = r102.get("default");
    L8:
        if (r106 != null) goto L10;
        r106 = r105;
    L10:
        if (r106 == null) goto L12;
        return r106;
    L12:
        return hk1.f120385a;
    L5:
        r106 = null;
        goto L6
    }

    public static String b(XplayScene r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Map<String, ? extends Map<String, ? extends String>> r103 = y20.f121650a.getValue();
        if (r103 != null) goto L5;
        r103 = MapsKt.emptyMap();
    L5:
        if (r101 == false) goto L9;
        Map<String, ? extends String> r104 = r103.get(String.valueOf(r100.getSceneId()));
        if (r104 != null) goto L18;
    L16:
        return null;
    L18:
        return r104.get("anchor");
    L9:
        if (r102 == false) goto L13;
        Map<String, ? extends String> r105 = r103.get(String.valueOf(r100.getSceneId()));
        if (r105 == null) goto L16;
        return r105.get("enter_anim");
    L13:
        Map<String, ? extends String> r106 = r103.get(String.valueOf(r100.getSceneId()));
        if (r106 == null) goto L16;
        return r106.get(SourceType.DEFAULT);
    }
}
