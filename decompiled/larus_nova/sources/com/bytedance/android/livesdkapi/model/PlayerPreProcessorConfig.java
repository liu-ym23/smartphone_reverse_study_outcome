package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b$\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001e\u0010%\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdkapi/model/PlayerPreProcessorConfig;", "", "()V", "enable", "", "getEnable", "()Ljava/lang/Integer;", "setEnable", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "ioPreProcessorEnable", "getIoPreProcessorEnable", "setIoPreProcessorEnable", "preBackSourceEnable", "getPreBackSourceEnable", "setPreBackSourceEnable", "preBackSourceSendLater", "getPreBackSourceSendLater", "setPreBackSourceSendLater", "preBackSourceTTL", "getPreBackSourceTTL", "setPreBackSourceTTL", "preCreatedPlayerEnable", "getPreCreatedPlayerEnable", "setPreCreatedPlayerEnable", "preIOEnable", "getPreIOEnable", "setPreIOEnable", "preIOTimeout", "getPreIOTimeout", "setPreIOTimeout", "preIOTimeoutDur", "getPreIOTimeoutDur", "setPreIOTimeoutDur", "preIOWinSize", "getPreIOWinSize", "setPreIOWinSize", "preRedirectEnable", "getPreRedirectEnable", "setPreRedirectEnable", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerPreProcessorConfig {
    public static final PlayerPreProcessorConfig INSTANCE = null;
    private static Integer enable;
    private static Integer ioPreProcessorEnable;
    private static Integer preBackSourceEnable;
    private static Integer preBackSourceSendLater;
    private static Integer preBackSourceTTL;
    private static Integer preCreatedPlayerEnable;
    private static Integer preIOEnable;
    private static Integer preIOTimeout;
    private static Integer preIOTimeoutDur;
    private static Integer preIOWinSize;
    private static Integer preRedirectEnable;

    private PlayerPreProcessorConfig() {
    }

    static {
        INSTANCE = new PlayerPreProcessorConfig();
        enable = 0;
        preCreatedPlayerEnable = 0;
        preIOEnable = 0;
        preIOTimeout = 0;
        preIOWinSize = 0;
        preIOTimeoutDur = 500;
        ioPreProcessorEnable = 0;
        preRedirectEnable = 0;
        preBackSourceEnable = 0;
        preBackSourceSendLater = 0;
        preBackSourceTTL = 1;
    }

    public final Integer getEnable() {
        return enable;
    }

    public final Integer getIoPreProcessorEnable() {
        return ioPreProcessorEnable;
    }

    public final Integer getPreBackSourceEnable() {
        return preBackSourceEnable;
    }

    public final Integer getPreBackSourceSendLater() {
        return preBackSourceSendLater;
    }

    public final Integer getPreBackSourceTTL() {
        return preBackSourceTTL;
    }

    public final Integer getPreCreatedPlayerEnable() {
        return preCreatedPlayerEnable;
    }

    public final Integer getPreIOEnable() {
        return preIOEnable;
    }

    public final Integer getPreIOTimeout() {
        return preIOTimeout;
    }

    public final Integer getPreIOTimeoutDur() {
        return preIOTimeoutDur;
    }

    public final Integer getPreIOWinSize() {
        return preIOWinSize;
    }

    public final Integer getPreRedirectEnable() {
        return preRedirectEnable;
    }

    public final void setEnable(Integer r100) {
        enable = r100;
    }

    public final void setIoPreProcessorEnable(Integer r100) {
        ioPreProcessorEnable = r100;
    }

    public final void setPreBackSourceEnable(Integer r100) {
        preBackSourceEnable = r100;
    }

    public final void setPreBackSourceSendLater(Integer r100) {
        preBackSourceSendLater = r100;
    }

    public final void setPreBackSourceTTL(Integer r100) {
        preBackSourceTTL = r100;
    }

    public final void setPreCreatedPlayerEnable(Integer r100) {
        preCreatedPlayerEnable = r100;
    }

    public final void setPreIOEnable(Integer r100) {
        preIOEnable = r100;
    }

    public final void setPreIOTimeout(Integer r100) {
        preIOTimeout = r100;
    }

    public final void setPreIOTimeoutDur(Integer r100) {
        preIOTimeoutDur = r100;
    }

    public final void setPreIOWinSize(Integer r100) {
        preIOWinSize = r100;
    }

    public final void setPreRedirectEnable(Integer r100) {
        preRedirectEnable = r100;
    }
}
