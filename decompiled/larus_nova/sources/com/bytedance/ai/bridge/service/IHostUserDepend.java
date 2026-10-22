package com.bytedance.ai.bridge.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
public interface IHostUserDepend {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILoginStatusCallback;", "", "onSuccess", "", "onFail", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ILoginStatusCallback {
        void onFail();

        void onSuccess();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostUserDepend$ILogoutStatusCallback;", "", "onSuccess", "", "onFail", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ILogoutStatusCallback {
        void onFail();

        void onSuccess();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostUserDepend$LoginParamsExt;", "", "<init>", "()V", "keepOpen", "", "getKeepOpen", "()Z", "setKeepOpen", "(Z)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoginParamsExt {
        private boolean keepOpen;

        public LoginParamsExt() {
            this.keepOpen = true;
        }

        public final boolean getKeepOpen() {
            return this.keepOpen;
        }

        public final void setKeepOpen(boolean r100) {
            this.keepOpen = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/bridge/service/IHostUserDepend$UserModelExt;", "", "<init>", "()V", "shortID", "", "getShortID", "()Ljava/lang/String;", "setShortID", "(Ljava/lang/String;)V", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserModelExt {
        private String shortID;

        public UserModelExt() {
        }

        public final String getShortID() {
            return this.shortID;
        }

        public final void setShortID(String r100) {
            this.shortID = r100;
        }
    }

    String getAvatarURL();

    void getBoundPhone();

    String getNickname();

    String getSecUid();

    String getUniqueID();

    String getUserId();

    void getUserModelExt();

    boolean hasLogin();
}
