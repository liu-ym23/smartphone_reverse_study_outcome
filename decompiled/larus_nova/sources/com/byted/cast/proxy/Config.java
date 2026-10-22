package com.byted.cast.proxy;

/* JADX INFO: loaded from: classes39.dex */
public class Config {
    private String appId;
    private String appSecret;
    private String deviceId;
    private int discardFrameDelay;
    private String domain;
    private boolean enableDebug;
    private boolean isAVFrameOpt;
    private boolean isOpenInputOpt;
    private ILogger logger;
    private IMonitor monitor;
    private INetwork network;
    private int queueLength;
    private IServerListener serverListener;
    private int socketBufferLength;
    private int socketTimeout;
    private boolean switchSocketOptimization;
    private CastProxyType type;

    public static class Builder {
        private String appId;
        private String appSecret;
        private String deviceId;
        private int discardFrameDelay;
        private String domain;
        private boolean enableDebug;
        private boolean isAVFrameOpt;
        private boolean isOpenInputOpt;
        private ILogger logger;
        private IMonitor monitor;
        private INetwork network;
        private int queueLength;
        private IServerListener serverListener;
        private int socketBufferLength;
        private int socketTimeout;
        private boolean switchSocketOptimization;
        private CastProxyType type;

        public Config build() {
            Config r100 = new Config();
            Config.access$002(r100, this.appId);
            Config.access$102(r100, this.appSecret);
            Config.access$202(r100, this.deviceId);
            Config.access$302(r100, this.enableDebug);
            Config.access$402(r100, this.monitor);
            Config.access$502(r100, this.serverListener);
            Config.access$602(r100, this.network);
            Config.access$702(r100, this.discardFrameDelay);
            Config.access$802(r100, this.socketTimeout);
            Config.access$902(r100, this.socketBufferLength);
            Config.access$1002(r100, this.queueLength);
            Config.access$1102(r100, this.switchSocketOptimization);
            Config.access$1202(r100, this.isAVFrameOpt);
            Config.access$1302(r100, this.isOpenInputOpt);
            Config.access$1402(r100, this.logger);
            Config.access$1502(r100, this.domain);
            Config.access$1602(r100, this.type);
            return r100;
        }

        public Builder() {
            this.logger = new AnonymousClass1(this);
        }

        public Builder appId(String r100) {
            this.appId = r100;
            return this;
        }

        public Builder appSecret(String r100) {
            this.appSecret = r100;
            return this;
        }

        public Builder castProxyType(CastProxyType r100) {
            this.type = r100;
            return this;
        }

        public Builder deviceId(String r100) {
            this.deviceId = r100;
            return this;
        }

        public Builder discardFrameDelay(int r100) {
            this.discardFrameDelay = r100;
            return this;
        }

        public Builder enableDebug(boolean r100) {
            this.enableDebug = r100;
            return this;
        }

        public Builder isAVFrameOpt(boolean r100) {
            this.isAVFrameOpt = r100;
            return this;
        }

        public Builder isOpenInputOpt(boolean r100) {
            this.isOpenInputOpt = r100;
            return this;
        }

        public Builder logger(ILogger r100) {
            this.logger = r100;
            return this;
        }

        public Builder monitor(IMonitor r100) {
            this.monitor = r100;
            return this;
        }

        public Builder network(INetwork r100) {
            this.network = r100;
            return this;
        }

        public Builder proxy(String r100) {
            this.domain = r100;
            return this;
        }

        public Builder queueLength(int r100) {
            this.queueLength = r100;
            return this;
        }

        public Builder serverListener(IServerListener r100) {
            this.serverListener = r100;
            return this;
        }

        public Builder socketBufferLength(int r100) {
            this.socketBufferLength = r100;
            return this;
        }

        public Builder socketTimeout(int r100) {
            this.socketTimeout = r100;
            return this;
        }

        public Builder switchSocketOptimization(boolean r100) {
            this.switchSocketOptimization = r100;
            return this;
        }
    }

    public Config() {
        this.switchSocketOptimization = true;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public CastProxyType getCastProxyType() {
        return this.type;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getDiscardFrameDelay() {
        return this.discardFrameDelay;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public IMonitor getMonitor() {
        return this.monitor;
    }

    public INetwork getNetwork() {
        return this.network;
    }

    public String getProxy() {
        return this.domain;
    }

    public int getQueueLength() {
        return this.queueLength;
    }

    public IServerListener getServerListener() {
        return this.serverListener;
    }

    public int getSocketBufferLength() {
        return this.socketBufferLength;
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public boolean getSwitchSocketOptimization() {
        return this.switchSocketOptimization;
    }

    public boolean isAVFrameOpt() {
        return this.isAVFrameOpt;
    }

    public boolean isEnableDebug() {
        return this.enableDebug;
    }

    public boolean isOpenInputOpt() {
        return this.isOpenInputOpt;
    }

    public static /* synthetic */ String access$002(Config r100, String r101) {
        r100.appId = r101;
        return r101;
    }

    public static /* synthetic */ int access$1002(Config r100, int r101) {
        r100.queueLength = r101;
        return r101;
    }

    public static /* synthetic */ String access$102(Config r100, String r101) {
        r100.appSecret = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1102(Config r100, boolean r101) {
        r100.switchSocketOptimization = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1202(Config r100, boolean r101) {
        r100.isAVFrameOpt = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1302(Config r100, boolean r101) {
        r100.isOpenInputOpt = r101;
        return r101;
    }

    public static /* synthetic */ ILogger access$1402(Config r100, ILogger r101) {
        r100.logger = r101;
        return r101;
    }

    public static /* synthetic */ String access$1502(Config r100, String r101) {
        r100.domain = r101;
        return r101;
    }

    public static /* synthetic */ CastProxyType access$1602(Config r100, CastProxyType r101) {
        r100.type = r101;
        return r101;
    }

    public static /* synthetic */ String access$202(Config r100, String r101) {
        r100.deviceId = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$302(Config r100, boolean r101) {
        r100.enableDebug = r101;
        return r101;
    }

    public static /* synthetic */ IMonitor access$402(Config r100, IMonitor r101) {
        r100.monitor = r101;
        return r101;
    }

    public static /* synthetic */ IServerListener access$502(Config r100, IServerListener r101) {
        r100.serverListener = r101;
        return r101;
    }

    public static /* synthetic */ INetwork access$602(Config r100, INetwork r101) {
        r100.network = r101;
        return r101;
    }

    public static /* synthetic */ int access$702(Config r100, int r101) {
        r100.discardFrameDelay = r101;
        return r101;
    }

    public static /* synthetic */ int access$802(Config r100, int r101) {
        r100.socketTimeout = r101;
        return r101;
    }

    public static /* synthetic */ int access$902(Config r100, int r101) {
        r100.socketBufferLength = r101;
        return r101;
    }
}
