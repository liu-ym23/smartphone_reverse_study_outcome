package b16;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import b36.e;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.kit.bridge.h;
import com.bytedance.ies.bullet.service.base.o;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import ia.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m16.b;
import t36.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f16926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BulletContext f16927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BulletContainerView f16928c;

    public a() {
    }

    @Override // ia.c
    public final void bindContainerId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "containerId");
    }

    @Override // ia.c
    public final boolean canBackPress() {
        throw null;
    }

    @Override // ia.c
    public final boolean canGoBack() {
        return false;
    }

    @Override // ia.c
    public final void enterBackground() {
    }

    @Override // ia.c
    public final void enterForeground() {
    }

    @Override // ia.c
    public final String getBDXTag() {
        return "";
    }

    @Override // ia.c
    public final d getCurrentSchema() {
        return null;
    }

    @Override // ia.c
    public final Context getSystemContext() {
        return null;
    }

    @Override // ia.c
    public final String getViewType() {
        return "page";
    }

    @Override // ia.c
    public final void hideError() {
    }

    @Override // ia.c
    public final void hideLoading() {
    }

    @Override // ia.c
    public final void interceptBackPress(boolean r100) {
    }

    @Override // ia.c
    public final void loadSchema(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    @Override // ia.c
    public final void onVisibleChange(boolean r100, Boolean r101) {
    }

    @Override // ia.c
    public final <T> void registerWeakHolder(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
    }

    @Override // ia.c
    public final void release() {
    }

    @Override // ia.c
    public final void reloadTemplate(Map<String, ? extends Object> r100) {
    }

    @Override // ia.c
    public final void sendEvent(h r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
    }

    @Override // ia.c
    public final void showLoading(String r100) {
    }

    @Override // ia.c
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    @Override // ia.c
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "globalProps");
    }

    @Override // ia.c
    public final void updateScreenMetrics(int r100, int r101) {
    }

    @Override // ia.c
    public final void close() {
        Activity r100 = this.f16926a;
        if (r100 == null) goto L6;
        r100.finish();
        return;
    }

    @Override // ia.c
    public final String getBid() {
        BulletContext r100 = this.f16927b;
        if (r100 == null) goto L6;
        String r101 = r100.f246438f;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "default_bid";
    }

    @Override // ia.c
    public final String getContainerId() {
        BulletContext r100 = this.f16927b;
        if (r100 == null) goto L6;
        String r101 = r100.getSessionId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // ia.c
    public final b getContextProviderFactory() {
        BulletContainerView r100 = this.f16928c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getProviderFactory();
    }

    @Override // ia.c
    public final String getCurrentUrl() {
        BulletContainerView r100 = this.f16928c;
        e r101 = null;
        if (r100 == null) goto L5;
        o r102 = r100.getKitView();
    L7:
        if ((r102 instanceof e) == false) goto L9;
        r101 = (e) r102;
    L9:
        if (r101 == null) goto L12;
        String r103 = r101.getCurrentUrl();
        if (r103 == null) goto L12;
        return r103;
    L12:
        return "";
    L5:
        r102 = null;
        goto L7
    }

    @Override // ia.c
    public final View getKitView() {
        BulletContainerView r100 = this.f16928c;
        if (r100 == null) goto L7;
        o r101 = r100.getKitView();
        if (r101 == null) goto L7;
        return r101.realView();
    L7:
        return null;
    }

    @Override // ia.c
    public final d getSchemaData() {
        BulletContext r100 = this.f16927b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f246437e;
    }

    @Override // ia.c
    public final WeakReference<Context> getWeakContext() {
        return new WeakReference(this.f16926a);
    }

    @Override // ia.c
    public final void goBack() {
        BulletContainerView r100 = this.f16928c;
        boolean r101 = false;
        if (r100 == null) goto L9;
        o r102 = r100.getKitView();
        if (r102 == null) goto L9;
        if (r102.onBackPressed() != true) goto L9;
        r101 = true;
    L9:
        if (r101 == true) goto L14;
        Activity r103 = this.f16926a;
        if (r103 == null) goto L15;
        r103.onBackPressed();
        return;
    L15:
        return;
    }

    @Override // ia.c
    public final Map<String, Long> getPerfMap() {
        return MapsKt.emptyMap();
    }

    @Override // ia.c
    public final LaunchMode getBDXLaunchMode() {
        return LaunchMode.MODE_UNSPECIFIED;
    }

    @Override // ia.c
    public final KitType getKitType() {
        return KitType.WEB;
    }

    @Override // ia.c
    public final void onEngineReady(b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
    }

    @Override // ia.c
    public final void reload(Map<String, ? extends Object> r100) {
        BulletContainerView r101 = this.f16928c;
        if (r101 == null) goto L8;
        o r102 = r101.getKitView();
        if (r102 == null) goto L9;
        r102.m();
        return;
    L9:
        return;
    }
}
