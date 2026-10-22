package com.bytedance.android.annie.lynx.service.latch;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.bridge.JSBridgeManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements IHybridComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSBridgeManager f39562a;

    public e() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void addOnPreDrawListener() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String containerId() {
        return "LatchMockHybridComponent";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final View getHybridView() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ boolean isPopup() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setOnScrollChangeListener(IHybridComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    @Override // a7.b
    public final /* synthetic */ void setRadius(float r100) {
    }

    @Override // a7.b
    public final /* synthetic */ void setRadius(float r100, float r101, float r102, float r103) {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void show() {
    }

    public static void a() {
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String getBizKey() {
        JSBridgeManager r100 = this.f39562a;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r100 = null;
    L7:
        return r100.g();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void release() {
        JSBridgeManager r100 = this.f39562a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r100 = null;
    L6:
        r100.release();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        return IHybridComponent.HybridType.LYNX;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void setJSBridgeListener(IHybridComponent.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map r100) {
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r100, Map r101) {
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        JSBridgeManager r102 = this.f39562a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r102 = null;
    L6:
        r102.registerMethod(r100, r101);
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void sendJsEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        a();
        throw null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r100, com.bytedance.ies.web.jsbridge2.g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        JSBridgeManager r102 = this.f39562a;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsBridgeManager");
        r102 = null;
    L6:
        r102.registerMethod(r100, r101);
    }
}
