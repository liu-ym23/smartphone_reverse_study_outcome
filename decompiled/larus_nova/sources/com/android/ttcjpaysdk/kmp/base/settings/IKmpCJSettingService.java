package com.android.ttcjpaysdk.kmp.base.settings;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H&J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/settings/IKmpCJSettingService;", "Lcom/bytedance/kmp/spi/IKmpService;", "getConfig", "", "key", "getConfigEnhanced", "", "defaultValue", "useCache", "getABStringValue", "isExposure", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJSettingService extends a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ boolean getConfigEnhanced$default(IKmpCJSettingService r100, String r101, boolean r102, boolean r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 4) == 0) goto L7;
            r103 = true;
        L7:
            return r100.getConfigEnhanced(r101, r102, r103);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfigEnhanced");
        }
    }

    String getABStringValue(String r100, String r101, boolean r102);

    String getConfig(String r100);

    boolean getConfigEnhanced(String r100, boolean r101, boolean r102);
}
