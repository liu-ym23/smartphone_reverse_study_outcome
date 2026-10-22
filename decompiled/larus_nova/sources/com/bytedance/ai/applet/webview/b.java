package com.bytedance.ai.applet.webview;

import com.ss.android.lark.chameleon.WebMediaPermissionResources;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f35224a;

    public static final class a {
    }

    static {
    }

    public b() {
        this.f35224a = MapsKt.mapOf(new Pair[]{TuplesKt.to(WebMediaPermissionResources.VIDEO_CAPTURE, "android.permission.CAMERA"), TuplesKt.to(WebMediaPermissionResources.AUDIO_CAPTURE, "android.permission.RECORD_AUDIO")});
    }
}
