package com.bytedance.android.annie.card.web;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.ies.web.jsbridge2.c0;
import com.lynx.tasm.LynxView;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public class e implements com.bytedance.android.annie.card.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.annie.card.base.b f39204a;

    public e() {
        this(null);
    }

    public void A(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
    }

    public void B(WebView r100) {
    }

    public void C() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void b(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void c(JSONObject r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, NotificationCompat.CATEGORY_CALL);
    }

    public void d(WebView r100) {
    }

    public void e(WebView r100) {
    }

    public void f(String r100, ValueCallback<String> r101) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void n(LynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    public void o() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onBeforeLynxEnvInitialize(boolean r100) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final /* synthetic */ void onLynxEnvInitialized() {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onRelease() {
    }

    public void p(String r100, GeolocationPermissions.Callback r101) {
    }

    public void q(WebView r100) {
    }

    public void r() {
    }

    public void s(WebView r100, String r101) {
    }

    public void t(WebView r100, int r101) {
    }

    public void u(WebView r100, WebResourceRequest r101, WebResourceError r102) {
    }

    public void v(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
    }

    public void w() {
    }

    public void x(String r100) {
    }

    public void y() {
    }

    public void z(View r100, WebChromeClient.CustomViewCallback r101) {
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeGlobalPropsInitialize() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onBeforeGlobalPropsInitialize();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeInitialPropsInitialize() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onBeforeInitialPropsInitialize();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeJsbRegister() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onBeforeJsbRegister();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onCardLoadStart() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onCardLoadStart();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onEngineLoadEnd() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onEngineLoadEnd();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onEngineLoadStart() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onEngineLoadStart();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onGlobalPropsInitialized() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onGlobalPropsInitialized();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onInitialPropsInitialized() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onInitialPropsInitialized();
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onJsbRegistered() {
        com.bytedance.android.annie.card.base.b r100 = this.f39204a;
        if (r100 == null) goto L6;
        r100.onJsbRegistered();
        return;
    }

    public e(com.bytedance.android.annie.card.base.b r100) {
        this.f39204a = r100;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void m(boolean r100) {
        com.bytedance.android.annie.card.base.b r101 = this.f39204a;
        if (r101 == null) goto L6;
        r101.m(r100);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        com.bytedance.android.annie.card.base.b r101 = this.f39204a;
        if (r101 == null) goto L6;
        r101.onBeforeCreateRenderData(r100);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void g(View r100, String r101) {
        com.bytedance.android.annie.card.base.b r102 = this.f39204a;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void h(View r100, com.bytedance.android.annie.card.web.resource.a r101) {
        Intrinsics.checkNotNullParameter(r101, "resourceInfo");
        com.bytedance.android.annie.card.base.b r102 = this.f39204a;
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        com.bytedance.android.annie.card.base.b r102 = this.f39204a;
        if (r102 == null) goto L6;
        r102.onCreateRenderData(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onTemplateLoaded(View r100, boolean r101) {
        com.bytedance.android.annie.card.base.b r102 = this.f39204a;
        if (r102 == null) goto L6;
        r102.onTemplateLoaded(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void i(LynxView r100, String r101, String r102) {
        com.bytedance.android.annie.card.base.b r103 = this.f39204a;
        if (r103 == null) goto L6;
        r103.i(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void j(View r100, String r101, String r102) {
        com.bytedance.android.annie.card.base.b r103 = this.f39204a;
        if (r103 == null) goto L6;
        r103.j(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public void k(View r100, String r101, Bitmap r102, boolean r103) {
        com.bytedance.android.annie.card.base.b r104 = this.f39204a;
        if (r104 == null) goto L6;
        r104.k(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void l(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Long> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "resType");
        Intrinsics.checkNotNullParameter(r102, "type");
        Intrinsics.checkNotNullParameter(r103, "performInfo");
        com.bytedance.android.annie.card.base.b r104 = this.f39204a;
        if (r104 == null) goto L6;
        r104.l(r100, r101, r102, r103);
        return;
    }

    @Override // com.bytedance.android.annie.card.base.b
    public final void onBeforeLoadRequest(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "resType");
        Intrinsics.checkNotNullParameter(r102, "type");
        com.bytedance.android.annie.card.base.b r104 = this.f39204a;
        if (r104 == null) goto L6;
        r104.onBeforeLoadRequest(r100, r101, r102, r103);
        return;
    }
}
