package com.stepos.ailauncher.contract.api.express;

import android.content.Context;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\t¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/contract/api/express/IExpressService;", "", "Landroid/content/Context;", "context", "LY8/t;", "init", "(Landroid/content/Context;)V", "", "isEnabled", "()Z", "", "", "getSupportedPackages", "()Ljava/util/List;", "onSettingsChanged", "()V", "shouldSuppressAiKeyWake", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IExpressService {

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean shouldSuppressAiKeyWake(IExpressService iExpressService) {
            return IExpressService.super.shouldSuppressAiKeyWake();
        }
    }

    List<String> getSupportedPackages();

    void init(Context context);

    boolean isEnabled();

    void onSettingsChanged();

    default boolean shouldSuppressAiKeyWake() {
        return false;
    }
}
