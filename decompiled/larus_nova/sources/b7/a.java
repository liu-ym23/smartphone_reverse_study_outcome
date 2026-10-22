package b7;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class a implements b {
    public a() {
    }

    public boolean enableInvoke(String r100, JSONObject r101, String r102) {
        return true;
    }

    @Override // b7.b
    public void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
    }

    @Override // b7.b
    public /* synthetic */ void onAttachedToWindow(String r100) {
    }

    @Override // b7.b
    public void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
    }

    @Override // b7.b
    public void onBeforeGlobalPropsInitialize() {
    }

    @Override // b7.b
    public void onBeforeInitialPropsInitialize() {
    }

    @Override // b7.b
    public void onBeforeJsbRegister() {
    }

    @Override // b7.b
    public void onBeforeLoadRequest(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "resType");
        Intrinsics.checkNotNullParameter(r102, "type");
    }

    @Override // b7.b
    public void onBeforeLynxEnvInitialize(boolean r100) {
    }

    @Override // b7.b
    public void onBeforeOpenContainer() {
    }

    @Override // b7.b
    public void onCardLoadStart() {
    }

    @Override // b7.b
    public void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
    }

    @Override // b7.b
    public void onContainerInitEnd() {
    }

    @Override // b7.b
    public void onContainerInitStart() {
    }

    @Override // b7.b
    public void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
    }

    @Override // b7.b
    public void onEngineLoadEnd() {
    }

    @Override // b7.b
    public void onEngineLoadStart() {
    }

    @Override // b7.b
    public boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        return false;
    }

    @Override // b7.b
    public void onGlobalPropsInitialized() {
    }

    @Override // b7.b
    public void onInit(c7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
    }

    @Override // b7.b
    public void onInitialPropsInitialized() {
    }

    @Override // b7.b
    public void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
    }

    @Override // b7.b
    public void onJsbRegistered() {
    }

    @Override // b7.b
    public void onLoadFail(View r100, String r101, String r102) {
    }

    @Override // b7.b
    public void onLoadStart(View r100, boolean r101) {
    }

    @Override // b7.b
    public void onLoadSuccess(View r100) {
    }

    @Override // b7.b
    public void onLynxEnvInitialized() {
    }

    @Override // b7.b
    public /* synthetic */ void onLynxFirstScreen() {
    }

    @Override // b7.b
    public void onPrepareComponentEnd() {
    }

    @Override // b7.b
    public void onPrepareComponentStart() {
    }

    @Override // b7.b
    public void onPrepareInitDataEnd() {
    }

    @Override // b7.b
    public void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
    }

    @Override // b7.b
    public void onPrepareTemplateEnd(boolean r100) {
    }

    @Override // b7.b
    public void onPrepareTemplateEnd(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "resFrom");
    }

    @Override // b7.b
    public void onPrepareTemplateStart() {
    }

    @Override // b7.b
    public void onRelease() {
    }
}
