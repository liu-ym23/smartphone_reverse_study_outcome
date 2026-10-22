package com.android.ttcjpaysdk.kmp.base.route;

import java.util.Map;
import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J&\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0007H&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/route/IKmpCJRouteService;", "Lcom/bytedance/kmp/spi/IKmpService;", "releaseById", "", "id", "", "useAnimation", "", "openH5Page", "url", "params", "", "removeAllPageAbove", "pageId", "include", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJRouteService extends a {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void removeAllPageAbove$default(IKmpCJRouteService r100, String r101, boolean r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 2) == 0) goto L6;
            r102 = false;
        L6:
            r100.removeAllPageAbove(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeAllPageAbove");
        }
    }

    void openH5Page(String r100, Map<String, String> r101);

    void releaseById(String r100, boolean r101);

    void removeAllPageAbove(String r100, boolean r101);
}
