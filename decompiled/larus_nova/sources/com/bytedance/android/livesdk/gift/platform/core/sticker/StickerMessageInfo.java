package com.bytedance.android.livesdk.gift.platform.core.sticker;

import android.os.Handler;
import com.bytedance.android.livesdk.gift.platform.core.model.w;
import com.bytedance.android.livesdk.message.model.o7;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class StickerMessageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed6.b<o7> f131884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f131885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f131886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o7 f131887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, Integer> f131888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f131889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f131890g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f131891h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f131892i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f131893j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f131894k;

    public StickerMessageInfo(Handler r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f131894k = r100;
        final StickerMessageInfo$otherMessages$1 r101 = new StickerMessageInfo$otherMessages$1(this);
        this.f131884a = new ed6.b(new a(r101));
        this.f131888e = new HashMap();
        this.f131890g = 0;
        this.f131893j = -1;
    }
}
