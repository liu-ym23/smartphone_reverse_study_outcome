package com.stepos.ailauncher.chat.voice.motionkit;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0014\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/chat/voice/motionkit/w;", "", "<init>", "()V", "", "", "", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    public static final w INSTANCE = new w();

    public final Map<String, float[]> a() {
        return kotlin.collections.a.l(Y8.j.a("glowDelayS", new float[]{0.0f}), Y8.j.a("rippleDelayS", new float[]{0.0f}), Y8.j.a("waterDelayS", new float[]{0.0f}), Y8.j.a("waveStartAtS", new float[]{0.3f}), Y8.j.a("waveIntroDurS", new float[]{0.6f}));
    }
}
