package cd4;

import android.content.Context;
import com.bytedance.caijing.sdk.infra.base.impl.jsb.xbridge.base.IXPayBaseMethod;

/* JADX INFO: loaded from: classes15.dex */
public interface e {
    String a();

    com.bytedance.caijing.sdk.infra.base.impl.container.c b();

    void c(boolean r100);

    id4.c d();

    void e(Class r100, IXPayBaseMethod r101);

    gd4.a f();

    com.bytedance.caijing.sdk.infra.base.impl.container.a getContainerAbility();

    com.bytedance.caijing.sdk.infra.base.impl.container.b getContainerContext();

    com.bytedance.caijing.sdk.infra.base.impl.container.d getEvent();

    com.bytedance.caijing.sdk.infra.base.impl.container.f getKitView();

    gd4.b getPageConfig();

    com.bytedance.caijing.sdk.infra.base.impl.container.g getWebView();

    Context provideContext();
}
