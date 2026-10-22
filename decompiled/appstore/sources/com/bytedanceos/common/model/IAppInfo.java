package com.bytedanceos.common.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/common/model/IAppInfo;", "", "appInfo", "Lcom/bytedanceos/common/model/AppInfo;", "getAppInfo", "()Lcom/bytedanceos/common/model/AppInfo;", "Companion", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IAppInfo {

    @NotNull
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/common/model/IAppInfo$Companion;", "", "()V", "EMPTY", "Lcom/bytedanceos/common/model/AppInfo;", "getEMPTY", "()Lcom/bytedanceos/common/model/AppInfo;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        @NotNull
        private static final AppInfo EMPTY = null;

        static {
            $$INSTANCE = new Companion();
            EMPTY = new AppInfo();
        }

        private Companion() {
        }

        @NotNull
        public final AppInfo getEMPTY() {
            return EMPTY;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static AppInfo getAppInfo(@NotNull IAppInfo r10) {
            return IAppInfo.Companion.getEMPTY();
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @NotNull
    AppInfo getAppInfo();
}
