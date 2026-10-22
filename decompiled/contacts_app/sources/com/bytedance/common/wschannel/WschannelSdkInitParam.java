package com.bytedance.common.wschannel;

import android.app.Application;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.app.OnMessageReceiveListener;

/* JADX INFO: loaded from: classes2.dex */
public class WschannelSdkInitParam {
    private Application application;
    public final OnBindWsChannelServiceListener bindWsChannelServiceListener;
    private boolean calculateAppState;
    private boolean delayStartPushProcess;
    private boolean isEnableOfflineDetect;
    private OnMessageReceiveListener listener;
    private ConfigProvider<Boolean> optLogic;

    public static class Builder {
        private Application application;
        private OnBindWsChannelServiceListener bindWsChannelServiceListener;
        private boolean calculateAppState;
        private boolean delayStartPushProcess;
        private boolean isEnableOfflineDetect;
        private OnMessageReceiveListener messageReceiveListener;

        public Builder() {
            this.delayStartPushProcess = false;
            this.calculateAppState = true;
            this.isEnableOfflineDetect = false;
        }

        public Builder application(Application r1) {
            this.application = r1;
            return this;
        }

        public Builder messageReceiveListener(OnMessageReceiveListener r1) {
            this.messageReceiveListener = r1;
            return this;
        }

        public Builder delayStartPushProcess(boolean r1) {
            this.delayStartPushProcess = r1;
            return this;
        }

        public Builder calculateAppState(boolean r1) {
            this.calculateAppState = r1;
            return this;
        }

        public Builder enableOfflineDetect(boolean r1) {
            this.isEnableOfflineDetect = r1;
            return this;
        }

        public Builder bindWsChannelServiceListener(OnBindWsChannelServiceListener r1) {
            this.bindWsChannelServiceListener = r1;
            return this;
        }

        public WschannelSdkInitParam build() {
            return new WschannelSdkInitParam(this.application, this.messageReceiveListener, this.delayStartPushProcess, this.calculateAppState, this.isEnableOfflineDetect, this.bindWsChannelServiceListener);
        }
    }

    public WschannelSdkInitParam(Application r1, OnMessageReceiveListener r2, boolean r3, boolean r4, boolean r5, OnBindWsChannelServiceListener r6) {
        this.application = r1;
        this.listener = r2;
        this.delayStartPushProcess = r3;
        this.calculateAppState = r4;
        this.isEnableOfflineDetect = r5;
        this.bindWsChannelServiceListener = r6;
    }

    public Application getApplication() {
        return this.application;
    }

    public OnMessageReceiveListener getListener() {
        return this.listener;
    }

    public boolean isEnableOfflineDetect() {
        return this.isEnableOfflineDetect;
    }

    public boolean isDelayStartPushProcess() {
        return this.delayStartPushProcess;
    }

    public boolean isCalculateAppState() {
        return this.calculateAppState;
    }

    public ConfigProvider<Boolean> getOptLogic() {
        return this.optLogic;
    }

    public void setOptLogic(ConfigProvider<Boolean> r1) {
        this.optLogic = r1;
    }

    public void setOnMessageReceiveListener(OnMessageReceiveListener r1) {
        this.listener = r1;
    }
}
