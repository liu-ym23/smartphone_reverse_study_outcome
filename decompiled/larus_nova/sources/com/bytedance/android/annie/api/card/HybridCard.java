package com.bytedance.android.annie.api.card;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.sdk.m.p.e;
import com.amap.api.col.s.ce;
import com.bytedance.android.annie.api.view.RadiusLayout;
import com.bytedance.android.annie.card.base.b;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R\"\u0010\"\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\"\u0010$\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006."}, d2 = {"Lcom/bytedance/android/annie/api/card/HybridCard;", "Lcom/bytedance/android/annie/api/view/RadiusLayout;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "Landroid/view/View;", "getHybridView", "Lcom/bytedance/android/annie/api/card/IHybridComponent$a;", "listener", "", "setJSBridgeListener", "", "radius", "setRadius", "c", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "getMCurrentHybridComponent", "()Lcom/bytedance/android/annie/api/card/IHybridComponent;", "setMCurrentHybridComponent", "(Lcom/bytedance/android/annie/api/card/IHybridComponent;)V", "mCurrentHybridComponent", "", "d", "Z", "getDestroyedFlag", "()Z", "setDestroyedFlag", "(Z)V", "destroyedFlag", "e", "getMReleasedFlag", "setMReleasedFlag", "mReleasedFlag", ce.f26391f, "getLoadSuccess", "setLoadSuccess", "loadSuccess", "h", "isPreRender", "setPreRender", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public abstract class HybridCard extends RadiusLayout implements IHybridComponent {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f38392i = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IHybridComponent f38393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f38394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f38395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f38396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f38397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f38398h;

    public HybridCard(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HybridCard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void a(Uri r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
    }

    public void b() {
    }

    public void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxCallback");
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean canGoBack() {
        return false;
    }

    public void d() {
    }

    public abstract void e(Activity r100);

    public void f(int r100, int r101) {
    }

    public abstract void g(boolean r100, String r101);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public abstract /* synthetic */ String getBizKey();

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* bridge */ /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void hide() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setOnScrollChangeListener(IHybridComponent.b r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void show() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void addOnPreDrawListener() {
        IHybridComponent r100 = this.f38393c;
        if (r100 == null) goto L6;
        r100.addOnPreDrawListener();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        IHybridComponent r100 = this.f38393c;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public String containerId() {
        IHybridComponent r100 = this.f38393c;
        if (r100 == null) goto L6;
        String r101 = r100.containerId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public View getHybridView() {
        IHybridComponent r100 = this.f38393c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHybridView();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        IHybridComponent r100 = this.f38393c;
        if (r100 == null) goto L7;
        IHybridComponent.HybridType r101 = r100.hybridType();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return IHybridComponent.HybridType.H5;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        IHybridComponent r100 = this.f38393c;
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public final boolean getDestroyedFlag() {
        return this.f38394d;
    }

    public final boolean getLoadSuccess() {
        return this.f38397g;
    }

    public final IHybridComponent getMCurrentHybridComponent() {
        return this.f38393c;
    }

    public final boolean getMReleasedFlag() {
        return this.f38395e;
    }

    public final void setDestroyedFlag(boolean r100) {
        this.f38394d = r100;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void setJSBridgeListener(IHybridComponent.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        IHybridComponent r101 = this.f38393c;
        if (r101 == null) goto L6;
        r101.setJSBridgeListener(r100);
        return;
    }

    public final void setLoadSuccess(boolean r100) {
        this.f38397g = r100;
    }

    public final void setMCurrentHybridComponent(IHybridComponent r100) {
        this.f38393c = r100;
    }

    public final void setMReleasedFlag(boolean r100) {
        this.f38395e = r100;
    }

    public final void setPreRender(boolean r100) {
        this.f38398h = r100;
    }

    @Override // com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r100) {
        if (hybridType() != IHybridComponent.HybridType.LYNX) goto L5;
        super.setRadius(r100);
        return;
    L5:
        IHybridComponent r101 = this.f38393c;
        if (r101 == null) goto L10;
        r101.setRadius(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IHybridComponent r101 = this.f38393c;
        if (r101 == null) goto L6;
        r101.updateData(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void load(String r100, Map<String, ? extends Object> r101) {
        this.f38396f = true;
        IHybridComponent r102 = this.f38393c;
        if (r102 == null) goto L6;
        r102.load(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        IHybridComponent r102 = this.f38393c;
        if (r102 == null) goto L6;
        r102.registerMethod(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        IHybridComponent r102 = this.f38393c;
        if (r102 == null) goto L6;
        r102.sendJsEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r100, g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        IHybridComponent r102 = this.f38393c;
        if (r102 == null) goto L6;
        r102.registerMethod(r100, r101);
        return;
    }

    public HybridCard(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ HybridCard(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // com.bytedance.android.annie.api.view.RadiusLayout, a7.b
    public void setRadius(float r100, float r101, float r102, float r103) {
        if (hybridType() != IHybridComponent.HybridType.LYNX) goto L5;
        super.setRadius(r100, r101, r102, r103);
        return;
    L5:
        IHybridComponent r104 = this.f38393c;
        if (r104 == null) goto L10;
        r104.setRadius(r100, r101, r102, r103);
        return;
    }
}
