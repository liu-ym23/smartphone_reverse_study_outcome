package com.stepos.ailauncher.contract.api.feishu;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/feishu/IFeishuConnectService;", "", "Landroid/content/Context;", "context", "", "cliName", "LY8/t;", "openConfigPage", "(Landroid/content/Context;Ljava/lang/String;)V", "", "connected", "hostContext", "Landroidx/fragment/app/Fragment;", "createConfigFragment", "(Ljava/lang/String;ZLandroid/content/Context;)Landroidx/fragment/app/Fragment;", "connectedState", "()Ljava/lang/Boolean;", "uninstalling", "()Z", "confirmUninstall", "(Landroid/content/Context;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IFeishuConnectService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void confirmUninstall(IFeishuConnectService iFeishuConnectService, Context context) {
            p.i(context, "context");
            IFeishuConnectService.super.confirmUninstall(context);
        }

        @Deprecated
        public static Boolean connectedState(IFeishuConnectService iFeishuConnectService) {
            return IFeishuConnectService.super.connectedState();
        }

        @Deprecated
        public static Fragment createConfigFragment(IFeishuConnectService iFeishuConnectService, String str, boolean z10, Context context) {
            return IFeishuConnectService.super.createConfigFragment(str, z10, context);
        }

        @Deprecated
        public static boolean uninstalling(IFeishuConnectService iFeishuConnectService) {
            return IFeishuConnectService.super.uninstalling();
        }
    }

    static /* synthetic */ Fragment createConfigFragment$default(IFeishuConnectService iFeishuConnectService, String str, boolean z10, Context context, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createConfigFragment");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            context = null;
        }
        return iFeishuConnectService.createConfigFragment(str, z10, context);
    }

    static /* synthetic */ void openConfigPage$default(IFeishuConnectService iFeishuConnectService, Context context, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openConfigPage");
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        iFeishuConnectService.openConfigPage(context, str);
    }

    default void confirmUninstall(Context context) {
        p.i(context, "context");
    }

    default Boolean connectedState() {
        return null;
    }

    default Fragment createConfigFragment(String cliName, boolean connected, Context hostContext) {
        return null;
    }

    void openConfigPage(Context context, String cliName);

    default boolean uninstalling() {
        return false;
    }
}
