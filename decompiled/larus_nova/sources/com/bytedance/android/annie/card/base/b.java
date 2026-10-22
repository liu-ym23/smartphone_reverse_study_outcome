package com.bytedance.android.annie.card.base;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface b {
    void b(c0 r100);

    void c(JSONObject r100, c0 r101);

    void g(View r100, String r101);

    void h(View r100, com.bytedance.android.annie.card.web.resource.a r101);

    void i(LynxView r100, String r101, String r102);

    void j(View r100, String r101, String r102);

    void k(View r100, String r101, Bitmap r102, boolean r103);

    void l(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Long> r103);

    void m(boolean r100);

    void n(LynxView r100);

    void onBeforeCreateRenderData(View r100);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLoadRequest(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Object> r103);

    void onBeforeLynxEnvInitialize(boolean r100);

    void onCardLoadStart();

    void onCreateRenderData(View r100, Set<String> r101);

    void onEngineLoadEnd();

    void onEngineLoadStart();

    void onGlobalPropsInitialized();

    void onInitialPropsInitialized();

    void onJsbRegistered();

    void onLynxEnvInitialized();

    void onRelease();

    @Deprecated(message = "使用 onTemplateLoaded(view: View?, resourceInfo: ResourceInfo) 替代")
    void onTemplateLoaded(View r100, boolean r101);
}
