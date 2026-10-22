package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ExecuteCommandConfig;", "", "command", "", "info", "Lorg/json/JSONObject;", "(ILorg/json/JSONObject;)V", "getCommand", "()I", "getInfo", "()Lorg/json/JSONObject;", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExecuteCommandConfig {
    public static final Companion Companion = null;
    public static final int LIVE_STRATEGY_CHARACTER_FETCH = 52;
    public static final int LIVE_STRATEGY_CONFIG = 54;
    public static final int LIVE_STREAM_PREPROCESS = 50;
    private final int command;
    private final JSONObject info;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/ExecuteCommandConfig$Companion;", "", "()V", "LIVE_STRATEGY_CHARACTER_FETCH", "", "LIVE_STRATEGY_CONFIG", "LIVE_STREAM_PREPROCESS", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final int getCommand() {
        return this.command;
    }

    public final JSONObject getInfo() {
        return this.info;
    }

    public ExecuteCommandConfig(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "info");
        this.command = r100;
        this.info = r101;
    }
}
