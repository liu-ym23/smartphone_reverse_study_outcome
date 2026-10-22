package com.bumptech.glide.monitor;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R#\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR!\u0010\f\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bumptech/glide/monitor/GlideMonitorSettings;", "", "<init>", "()V", "TAG", "", "remoteSetting", "kotlin.jvm.PlatformType", "getRemoteSetting", "()Ljava/lang/String;", "remoteSetting$delegate", "Lkotlin/Lazy;", "monitor", "Lcom/bumptech/glide/monitor/GlideMonitorSettings$GlideMonitorConfig;", "getMonitor$annotations", "getMonitor", "()Lcom/bumptech/glide/monitor/GlideMonitorSettings$GlideMonitorConfig;", "monitor$delegate", "GlideMonitorSetting", "GlideMonitorConfig", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideMonitorSettings {
    public static final GlideMonitorSettings INSTANCE = null;
    private static final String TAG = "GlideMonitorSettings";
    private static final Lazy monitor$delegate = null;
    private static final Lazy remoteSetting$delegate = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bumptech/glide/monitor/GlideMonitorSettings$GlideMonitorConfig;", "", "enable", "", "dispatcherTimeOut", "loadTimeOut", "bigImageSize", "decodeTimeOut", "<init>", "(IIIII)V", "getEnable", "()I", "setEnable", "(I)V", "getDispatcherTimeOut", "setDispatcherTimeOut", "getLoadTimeOut", "setLoadTimeOut", "getBigImageSize", "setBigImageSize", "getDecodeTimeOut", "setDecodeTimeOut", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GlideMonitorConfig {

        @SerializedName("big_image_size")
        private int bigImageSize;

        @SerializedName("decode_time_out")
        private int decodeTimeOut;

        @SerializedName("dispatcher_time_out")
        private int dispatcherTimeOut;

        @SerializedName("enable")
        private int enable;

        @SerializedName("load_time_out")
        private int loadTimeOut;

        public GlideMonitorConfig() {
            this(0, 0, 0, 0, 0, 31, null);
        }

        public final int getBigImageSize() {
            return this.bigImageSize;
        }

        public final int getDecodeTimeOut() {
            return this.decodeTimeOut;
        }

        public final int getDispatcherTimeOut() {
            return this.dispatcherTimeOut;
        }

        public final int getEnable() {
            return this.enable;
        }

        public final int getLoadTimeOut() {
            return this.loadTimeOut;
        }

        public final void setBigImageSize(int r100) {
            this.bigImageSize = r100;
        }

        public final void setDecodeTimeOut(int r100) {
            this.decodeTimeOut = r100;
        }

        public final void setDispatcherTimeOut(int r100) {
            this.dispatcherTimeOut = r100;
        }

        public final void setEnable(int r100) {
            this.enable = r100;
        }

        public final void setLoadTimeOut(int r100) {
            this.loadTimeOut = r100;
        }

        public GlideMonitorConfig(int r100, int r101, int r102, int r103, int r104) {
            this.enable = r100;
            this.dispatcherTimeOut = r101;
            this.loadTimeOut = r102;
            this.bigImageSize = r103;
            this.decodeTimeOut = r104;
        }

        public /* synthetic */ GlideMonitorConfig(int r100, int r101, int r102, int r103, int r104, int r105, DefaultConstructorMarker r110) {
            if ((r105 & 1) == 0) goto L6;
            r100 = 1;
        L6:
            if ((r105 & 2) == 0) goto L8;
            int r111 = 5000;
        L10:
            if ((r105 & 4) == 0) goto L12;
            int r106 = 10000;
        L14:
            if ((r105 & 8) == 0) goto L16;
            int r107 = 10240;
        L18:
            if ((r105 & 16) == 0) goto L20;
            int r108 = 200;
        L21:
            this(r100, r111, r106, r107, r108);
            return;
        L20:
            r108 = r104;
            goto L21
        L16:
            r107 = r103;
            goto L18
        L12:
            r106 = r102;
            goto L14
        L8:
            r111 = r101;
            goto L10
        }
    }

    @AppConfig(key = "image_load_sdk_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bumptech/glide/monitor/GlideMonitorSettings$GlideMonitorSetting;", "", "<init>", "()V", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GlideMonitorSetting {
        public GlideMonitorSetting() {
        }
    }

    private GlideMonitorSettings() {
    }

    @JvmStatic
    public static /* synthetic */ void getMonitor$annotations() {
    }

    static {
        INSTANCE = new GlideMonitorSettings();
        remoteSetting$delegate = LazyKt.lazy(GlideMonitorSettings$remoteSetting$2.INSTANCE);
        monitor$delegate = LazyKt.lazy(GlideMonitorSettings$monitor$2.INSTANCE);
    }

    public static final GlideMonitorConfig getMonitor() {
        return (GlideMonitorConfig) monitor$delegate.getValue();
    }

    private final String getRemoteSetting() {
        return (String) remoteSetting$delegate.getValue();
    }

    public static final /* synthetic */ String access$getRemoteSetting(GlideMonitorSettings r100) {
        return r100.getRemoteSetting();
    }
}
