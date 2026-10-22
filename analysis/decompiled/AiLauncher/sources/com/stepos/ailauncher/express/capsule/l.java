package com.stepos.ailauncher.express.capsule;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.longpress.p0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/express/capsule/l;", "", "<init>", "()V", "", "data", "", Const.INTENT_KEY_APIKEY, "([S)F", "NOISE_FLOOR_RMS", "F", "express_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    public static final l INSTANCE = new l();
    public static final float NOISE_FLOOR_RMS = 120.0f;

    public final float a(short[] data) {
        kotlin.jvm.internal.p.i(data, "data");
        return p0.INSTANCE.a(data, 120.0f);
    }
}
