package com.bytedance.android.livesdkapi.listener;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/listener/ILoginOrLogoutListener;", "", "onAccountResult", "", "type", "", "success", "", "loginReasonType", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILoginOrLogoutListener {
    public static final int ACCOUNT_LOGIN = 1;
    public static final int ACCOUNT_LOGIN_END = 4;
    public static final int ACCOUNT_LOGOUT = 3;
    public static final int ACCOUNT_SWITCH = 2;
    public static final int ACCOUNT_SWITCH_LOGOUT = 5;
    public static final Companion Companion = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/listener/ILoginOrLogoutListener$Companion;", "", "()V", "ACCOUNT_LOGIN", "", "ACCOUNT_LOGIN_END", "ACCOUNT_LOGOUT", "ACCOUNT_SWITCH", "ACCOUNT_SWITCH_LOGOUT", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int ACCOUNT_LOGIN = 1;
        public static final int ACCOUNT_LOGIN_END = 4;
        public static final int ACCOUNT_LOGOUT = 3;
        public static final int ACCOUNT_SWITCH = 2;
        public static final int ACCOUNT_SWITCH_LOGOUT = 5;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onAccountResult(int r100, boolean r101, int r102);
}
