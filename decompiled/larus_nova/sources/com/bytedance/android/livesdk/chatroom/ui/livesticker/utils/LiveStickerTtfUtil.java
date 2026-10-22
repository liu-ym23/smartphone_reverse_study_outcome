package com.bytedance.android.livesdk.chatroom.ui.livesticker.utils;

import android.graphics.Typeface;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdkapi.depend.model.live.DecorationFontConfig;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveStickerTtfUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<String> f113697a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Long, Typeface> f113698b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NextLiveData<Integer> f113699c = null;

    static {
        f113697a = LazyKt.lazy(LiveStickerTtfUtil$ttfFilePath$1.INSTANCE);
        f113698b = new ConcurrentHashMap();
        NextLiveData<Integer> r100 = new NextLiveData();
        r100.setValue(0);
        f113699c = r100;
    }

    @JvmStatic
    public static final boolean a(Long r100) {
        if (r100 == null) goto L5;
        r100.longValue();
        return FileUtils.checkFileExists(c(r100.longValue()));
    L5:
        return false;
    }

    @JvmStatic
    public static final void b(DecorationFontConfig r100) {
        if (r100 == null) goto L11;
        long r101 = r100.getFontId();
        String r102 = r100.getDownloadUrl();
        if (r102 != null) goto L7;
        return;
    L7:
        if (a(Long.valueOf(r101)) == false) goto L9;
        return;
    L9:
        Downloader.with(s1.getContext()).url(r102).name(r101 + ".temp").savePath(f113697a.getValue()).monitorScene("live_anchor_sticker_ttf").subThreadListener(new b(r101)).download();
        return;
    }

    public static String c(long r100) {
        return f113697a.getValue() + r100 + ".ttf";
    }
}
