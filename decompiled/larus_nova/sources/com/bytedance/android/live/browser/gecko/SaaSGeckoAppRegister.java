package com.bytedance.android.live.browser.gecko;

import android.content.Context;
import com.bytedance.android.livehostapi.platform.IHostWebView;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import u20.a;
import u20.b;

/* JADX INFO: loaded from: classes45.dex */
@GeckoRegister(boeAccessKey = "68f927652a5370ec9f4ae1dbaf56fd85", prodAccessKey = "5fb33cde3ebff01c8433ddc22aac0816", testAccessKey = "36723dc3e85a23e701d1697d57de07ed")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/browser/gecko/SaaSGeckoAppRegister;", "Lcom/bytedance/geckox/settings/IGeckoRegister;", "()V", "registerCustomParams", "", "", "Lcom/bytedance/geckox/OptionCheckUpdateParams$CustomValue;", "registerRootDir", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaaSGeckoAppRegister implements IGeckoRegister {
    public SaaSGeckoAppRegister() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        int r100 = b.b();
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 <= 0) goto L5;
        r101.put("ecomSaaSVersion", new a(r100));
    L5:
        return r101;
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r100) {
        int r101 = b.f548402a;
        IHostWebView r102 = (IHostWebView) k.f(IHostWebView.class);
        if (r102 == null) goto L5;
        String r103 = r102.getHostGeckoCacheDir();
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        return r103;
    L14:
        return com.bytedance.geckox.b.a.f245076a.getContext().getFilesDir().getAbsolutePath() + File.separator + "offlineX";
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
