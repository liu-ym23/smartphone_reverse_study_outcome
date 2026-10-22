package com.bytedance.android.ec.common.api.marketing;

import android.app.Activity;
import android.view.View;
import java.util.Map;
import kf.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\tH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000f\u001a\u00020\u000bH&J\u001a\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\tH&J\n\u0010\u0015\u001a\u0004\u0018\u00010\rH&¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/common/api/marketing/IMarketingLiveLynxViewService;", "", "Landroid/app/Activity;", "activity", "", "url", "Lkf/a;", "callback", "createLynxComponent", "", "m", "", "renderTemplate", "Landroid/view/View;", "getView", "release", "eventName", "params", "sendJSEvent", "data", "updateGlobalProps", "getKitView", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IMarketingLiveLynxViewService {
    IMarketingLiveLynxViewService createLynxComponent(Activity r100, String r101, a r102);

    View getKitView();

    View getView();

    void release();

    void renderTemplate(String r100, Map<String, ? extends Object> r101);

    void sendJSEvent(String r100, Object r101);

    void updateGlobalProps(Map<String, ? extends Object> r100);
}
