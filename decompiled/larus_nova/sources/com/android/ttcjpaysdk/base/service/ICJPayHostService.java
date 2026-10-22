package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "后续去掉")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\bH&J\u001c\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH&¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayHostService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getXBridgeMethods", "", "", "Ljava/lang/Class;", "", "isLivePluginAvailable", "", "networkParamsLoadToUrl", "url", "isApi", "openSchemaRouter", "schema", "activity", "Landroid/app/Activity;", "setWXIndependentSign", "", "isSign", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayHostService extends ICJPayService {

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String networkParamsLoadToUrl$default(ICJPayHostService r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = true;
        L7:
            return r100.networkParamsLoadToUrl(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: networkParamsLoadToUrl");
        }

        public static /* synthetic */ boolean openSchemaRouter$default(ICJPayHostService r100, String r101, Activity r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L7;
            r102 = null;
        L7:
            return r100.openSchemaRouter(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSchemaRouter");
        }
    }

    Map<String, Class<? extends Object>> getXBridgeMethods();

    boolean isLivePluginAvailable();

    String networkParamsLoadToUrl(String r100, boolean r101);

    boolean openSchemaRouter(String r100, Activity r101);

    void setWXIndependentSign(boolean r100);
}
