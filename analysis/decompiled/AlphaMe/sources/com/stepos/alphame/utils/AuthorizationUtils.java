package com.stepos.alphame.utils;

import com.stepos.alphame.EngineContract;
import com.stepos.alphame.engine.EngineFunc;
import com.stepos.alphame.engine.ExecuteItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/alphame/utils/AuthorizationUtils;", "", "()V", "isAuthorized", "", "executeItem", "Lcom/stepos/alphame/engine/ExecuteItem;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AuthorizationUtils {

    @NotNull
    public static final AuthorizationUtils INSTANCE = new AuthorizationUtils();

    private AuthorizationUtils() {
    }

    public final boolean isAuthorized(@NotNull ExecuteItem executeItem) {
        Intrinsics.checkNotNullParameter(executeItem, "executeItem");
        EngineFunc engineFunc = executeItem.func;
        if (engineFunc == null || !EngineContract.getAuthorizationFunList().contains(engineFunc.name)) {
            return true;
        }
        AlphaMeLogger.eLog("personal-info denied: func=" + engineFunc.name + ", pid=" + executeItem.appClient.pid);
        return false;
    }
}
