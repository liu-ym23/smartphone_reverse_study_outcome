package b7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes43.dex */
public interface b {
    void onAttachView(View r100, IHybridComponent.HybridType r101, String r102);

    void onAttachedToWindow(String r100);

    void onBeforeCreateRenderData(View r100);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLoadRequest(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Object> r103);

    void onBeforeLynxEnvInitialize(boolean r100);

    void onBeforeOpenContainer();

    void onCardLoadStart();

    void onContainerError(View r100, int r101, String r102);

    void onContainerInitEnd();

    void onContainerInitStart();

    void onCreateRenderData(View r100, Set<String> r101);

    void onEngineLoadEnd();

    void onEngineLoadStart();

    boolean onFallback(int r100, String r101);

    void onGlobalPropsInitialized();

    void onInit(c7.a r100);

    void onInitialPropsInitialized();

    void onInnerFallback(int r100, String r101);

    void onJsbRegistered();

    void onLoadFail(View r100, String r101, String r102);

    void onLoadStart(View r100, boolean r101);

    void onLoadSuccess(View r100);

    void onLynxEnvInitialized();

    void onLynxFirstScreen();

    void onPrepareComponentEnd();

    void onPrepareComponentStart();

    void onPrepareInitDataEnd();

    void onPrepareInitDataStart(String r100, String r101, boolean r102);

    void onPrepareTemplateEnd(boolean r100);

    void onPrepareTemplateEnd(boolean r100, String r101);

    void onPrepareTemplateStart();

    void onRelease();
}
