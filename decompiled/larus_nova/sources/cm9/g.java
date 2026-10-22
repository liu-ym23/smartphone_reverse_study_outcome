package cm9;

import com.larus.navigation.api.h;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f24226a;

    static {
    }

    public static void b() {
        com.larus.navigation.api.c.d("navi_tts", "stop");
        com.larus.navigation.api.b r100 = h.f359661a;     // Catch: Exception -> L7
        com.larus.navigation.api.b r101 = h.f359661a;     // Catch: Exception -> L7
        if (r101 == null) goto L12;
        r101.stop();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        int r102 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("navi_tts", "stop failed: " + e.getMessage(), e);
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        if (f24226a == true) goto L7;
        com.larus.navigation.api.c.d("navi_tts", "play: disabled, skip");
        return;
    L7:
        if (StringsKt.isBlank(r100) == false) goto L10;
        com.larus.navigation.api.c.d("navi_tts", "play: empty text, skip");
        return;
    L10:
        com.larus.navigation.api.b r101 = h.f359661a;
        com.larus.navigation.api.b r102 = h.f359661a;
        if (r102 != null) goto L14;
        com.larus.navigation.api.c.b("navi_tts", "play: no controller registered");
        return;
    L14:
        int r103 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.d("navi_tts", "play: force=true, " + StringsKt.take(r100, 50));
        r102.a(r100);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        int r104 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("navi_tts", "play failed: " + e.getMessage(), e);
    }
}
