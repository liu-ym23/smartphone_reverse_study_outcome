package com.bytedance.android.shopping.anchorv4.helper.shot;

import com.bytedance.android.livehostapi.business.IHostShare;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f166981b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f166982c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f166983a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.helper.shot.a$a, reason: collision with other inner class name */
    public static final class C2522a {
    }

    static {
        f166981b = new String[]{IHostShare.ShareType.SCREENSHOT, "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "screenrecorder", "截屏", "截屏录屏"};
        f166982c = new String[]{"tmp.png"};
    }

    public a() {
        this.f166983a = new LinkedHashSet();
    }
}
