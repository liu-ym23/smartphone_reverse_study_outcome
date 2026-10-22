package com.bytedance.android.live.emoji.online;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiRes;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class OnlineSmallEmojiResManager {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final OnlineSmallEmojiResManager f68913i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnlineSmallEmojiResInfo f68914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f68915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f68916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnlineSmallEmojiCache f68917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f68918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile int f68919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f68920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f68921h;

    public static final class a {
    }

    public final LinkedHashMap<String, String> b() {
        return (LinkedHashMap) this.f68916c.getValue();
    }

    static {
        f68913i = new OnlineSmallEmojiResManager();
    }

    public final boolean d() {
        if (this.f68919f != 2) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        ALogger.d("OnlineEmojiResManager", "  not enabled: " + this.f68919f);
    L8:
        return r100;
    L5:
        r100 = false;
        goto L6
    }

    public OnlineSmallEmojiResManager() {
        this.f68915b = LazyKt.lazy(OnlineSmallEmojiResManager$emojiNameIdMap$2.INSTANCE);
        this.f68916c = LazyKt.lazy(OnlineSmallEmojiResManager$panelEmojiNameMap$2.INSTANCE);
        this.f68918e = "";
    }

    public final void a(OnlineSmallEmojiRes r100) {
        c r101 = c.f68928c;
        int r102 = this.f68919f;
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L7;
        boolean r103 = false;
    L8:
        if (r103 == true) goto L10;
    L15:
        String r104 = r100.getMd5();
        Intrinsics.checkNotNull(r104);
        r101.a(new String[]{r104});
        return;
    L10:
        if (this.f68918e.length() <= 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L15;
        String r106 = r100.getMd5();
        Intrinsics.checkNotNull(r106);
        r101.a(new String[]{this.f68918e, r106});
        return;
    L12:
        r105 = false;
    L7:
        r103 = true;
        goto L8
    }

    public final String c(String r100) {
        StringBuilder r101 = new StringBuilder(MSkiaImageRegionDecoder.FILE_PREFIX);
        OnlineSmallEmojiResInfo r102 = this.f68914a;
        Intrinsics.checkNotNull(r102);
        r101.append(r102.getPicFileDirPath());
        r101.append(File.separator);
        r101.append(r100);
        return r101.toString();
    }
}
