package com.obric.matrix.platform.sdk.ones.account.api;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/AccountDef;", "", "LogoutScene", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AccountDef {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/account/api/AccountDef$LogoutScene;", "", "Companion", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface LogoutScene {
        public static final int CANCEL_ACCOUNT_LOGOUT = 2;

        @NotNull
        public static final a Companion = null;
        public static final int FRONTIER_LOGOUT = 4;
        public static final int OTHER_LOGOUT = 3;
        public static final int SESSION_LOGOUT = 1;
        public static final int USER_LOGOUT = 0;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f11878a = null;

            static {
                f11878a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f11878a;
        }
    }
}
