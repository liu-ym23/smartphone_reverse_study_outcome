package com.stepos.ailauncher.contract.api.wecom;

import android.content.Context;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/wecom/IWecomConnectService;", "", "", "cliName", "", "connected", "Landroid/content/Context;", "hostContext", "Landroidx/fragment/app/Fragment;", "createConfigFragment", "(Ljava/lang/String;ZLandroid/content/Context;)Landroidx/fragment/app/Fragment;", "connectedState", "()Ljava/lang/Boolean;", "uninstalling", "()Z", "context", "LY8/t;", "confirmUninstall", "(Landroid/content/Context;)V", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IWecomConnectService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static void confirmUninstall(IWecomConnectService iWecomConnectService, Context context) {
            p.i(context, "context");
            IWecomConnectService.super.confirmUninstall(context);
        }

        @Deprecated
        public static Boolean connectedState(IWecomConnectService iWecomConnectService) {
            return IWecomConnectService.super.connectedState();
        }

        @Deprecated
        public static Fragment createConfigFragment(IWecomConnectService iWecomConnectService, String str, boolean z10, Context context) {
            return IWecomConnectService.super.createConfigFragment(str, z10, context);
        }

        @Deprecated
        public static boolean uninstalling(IWecomConnectService iWecomConnectService) {
            return IWecomConnectService.super.uninstalling();
        }
    }

    static /* synthetic */ Fragment createConfigFragment$default(IWecomConnectService iWecomConnectService, String str, boolean z10, Context context, int i10, Object obj) {
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
        return iWecomConnectService.createConfigFragment(str, z10, context);
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

    default boolean uninstalling() {
        return false;
    }
}
