package com.android.ttcjpaysdk.base.service;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u000b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ISignAndPayService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getFragment", "Landroidx/fragment/app/Fragment;", "callback", "Lcom/android/ttcjpaysdk/base/service/ISignAndPayCallback;", "getPackageName", "", "interceptBackPressed", "", WidgetService.PARAM_FRAGMENT, "isSignAndPayFragment", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISignAndPayService extends ICJPayService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getPackageName(ISignAndPayService r100) {
            return null;
        }
    }

    Fragment getFragment(ISignAndPayCallback r100);

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    String getPackageName();

    boolean interceptBackPressed(Fragment r100);

    boolean isSignAndPayFragment(Fragment r100);
}
