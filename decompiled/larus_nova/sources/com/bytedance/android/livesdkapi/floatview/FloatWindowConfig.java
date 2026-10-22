package com.bytedance.android.livesdkapi.floatview;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0004R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0015\"\u0004\b\u0018\u0010\u0004R:\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u001aj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/floatview/FloatWindowConfig;", "", "fromOuterService", "", "(Z)V", "enterConfig", "Lcom/bytedance/android/livesdkapi/floatview/FloatWindowEnterConfig;", "getEnterConfig", "()Lcom/bytedance/android/livesdkapi/floatview/FloatWindowEnterConfig;", "setEnterConfig", "(Lcom/bytedance/android/livesdkapi/floatview/FloatWindowEnterConfig;)V", "enterFromMerge", "", "getEnterFromMerge", "()Ljava/lang/String;", "setEnterFromMerge", "(Ljava/lang/String;)V", "enterMethod", "getEnterMethod", "setEnterMethod", "getFromOuterService", "()Z", "setFromOuterService", "isAutoPlay", "setAutoPlay", "logExtras", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getLogExtras", "()Ljava/util/HashMap;", "setLogExtras", "(Ljava/util/HashMap;)V", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FloatWindowConfig {
    private FloatWindowEnterConfig enterConfig;
    private String enterFromMerge;
    private String enterMethod;
    private boolean fromOuterService;
    private boolean isAutoPlay;
    private HashMap<String, String> logExtras;

    public final FloatWindowEnterConfig getEnterConfig() {
        return this.enterConfig;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final boolean getFromOuterService() {
        return this.fromOuterService;
    }

    public final HashMap<String, String> getLogExtras() {
        return this.logExtras;
    }

    public final boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public FloatWindowConfig(boolean r100) {
        this.fromOuterService = r100;
        this.enterFromMerge = "";
        this.enterMethod = "";
    }

    public final void setAutoPlay(boolean r100) {
        this.isAutoPlay = r100;
    }

    public final void setEnterConfig(FloatWindowEnterConfig r100) {
        this.enterConfig = r100;
    }

    public final void setEnterFromMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromMerge = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setFromOuterService(boolean r100) {
        this.fromOuterService = r100;
    }

    public final void setLogExtras(HashMap<String, String> r100) {
        this.logExtras = r100;
    }
}
