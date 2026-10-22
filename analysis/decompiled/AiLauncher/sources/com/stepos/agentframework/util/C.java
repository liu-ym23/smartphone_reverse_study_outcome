package com.stepos.agentframework.util;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/stepos/agentframework/util/C;", "", "<init>", "()V", "", "CHAT_TTS_AUTO_PLAY", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "CHAT_DEEPSEEK_SELECTED", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class C {
    public static final C INSTANCE = new C();
    private static final String CHAT_TTS_AUTO_PLAY = "chat_tts_auto_play";
    private static final String CHAT_DEEPSEEK_SELECTED = "chat_deepseek_selected";

    public final String a() {
        return CHAT_DEEPSEEK_SELECTED;
    }

    public final String b() {
        return CHAT_TTS_AUTO_PLAY;
    }
}
