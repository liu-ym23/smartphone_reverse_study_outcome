package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemStatusCheckConfig;", "", "()V", "javaUsedPctThreshold", "", "getJavaUsedPctThreshold", "()D", "setJavaUsedPctThreshold", "(D)V", "openScenesFlag", "", "getOpenScenesFlag", "()I", "setOpenScenesFlag", "(I)V", "Scene", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMemStatusCheckConfig {

    @SerializedName("java_used_pct_threshold")
    private double javaUsedPctThreshold;

    @SerializedName("open_scenes_flag")
    private int openScenesFlag;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemStatusCheckConfig$Scene;", "", ForwardDependency$ForwardLocation.FLAG, "", "(Ljava/lang/String;II)V", "getFlag", "()I", "PRE_PREPARE", "PREVIEW_PRE_PULL_STREAM", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Scene extends Enum<Scene> {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final Scene PREVIEW_PRE_PULL_STREAM = null;
        public static final Scene PRE_PREPARE = null;
        private final int flag;

        static {
            Scene r100 = new Scene("PRE_PREPARE", 0, 1);
            PRE_PREPARE = r100;
            Scene r101 = new Scene("PREVIEW_PRE_PULL_STREAM", 1, 2);
            PREVIEW_PRE_PULL_STREAM = r101;
            $VALUES = new Scene[]{r100, r101};
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        public final int getFlag() {
            return this.flag;
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.flag = r102;
        }
    }

    public LiveMemStatusCheckConfig() {
    }

    public final double getJavaUsedPctThreshold() {
        return this.javaUsedPctThreshold;
    }

    public final int getOpenScenesFlag() {
        return this.openScenesFlag;
    }

    public final void setJavaUsedPctThreshold(double r100) {
        this.javaUsedPctThreshold = r100;
    }

    public final void setOpenScenesFlag(int r100) {
        this.openScenesFlag = r100;
    }
}
