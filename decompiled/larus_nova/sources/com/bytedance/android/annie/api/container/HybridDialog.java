package com.bytedance.android.annie.api.container;

import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.business.container.AnnieXLiveDialog;
import com.bytedance.crash.d;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/api/container/HybridDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/annie/api/card/IHybridComponent;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie-api_release"}, k = 1, mv = {1, 4, 3})
public abstract class HybridDialog extends DialogFragment implements IHybridComponent {

    public interface a {
        void onDismiss();

        void onScroll(int r100);

        void onShow();
    }

    public boolean S90() {
        return this instanceof AnnieXLiveDialog;
    }

    public abstract void T90(a r100);

    public void U90(boolean r100) {
    }

    public abstract void V90(boolean r100);

    public abstract void W90(boolean r100);

    public abstract void X90(Function0<Unit> r100);

    public void Y90(boolean r100) {
    }

    public abstract void Z90(boolean r100);

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void addOnPreDrawListener() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ Map getExtraPerfInfo() {
        return null;
    }

    public abstract IHybridComponent getHybridComponent();

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final /* synthetic */ void goBack() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void hide() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public /* synthetic */ boolean isPopup() {
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

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void close() {
        dismissAllowingStateLoss();     // Catch: Exception -> L4
    L8:
        IHybridComponent r100 = getHybridComponent();
        if (r100 == null) goto L11;
        r100.close();
    L11:
        release();
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L8;
        d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L8
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final String containerId() {
        IHybridComponent r100 = getHybridComponent();
        if (r100 == null) goto L6;
        String r101 = r100.containerId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final View getHybridView() {
        IHybridComponent r100 = getHybridComponent();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHybridView();
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final IHybridComponent.HybridType hybridType() {
        IHybridComponent r100 = getHybridComponent();
        if (r100 == null) goto L7;
        IHybridComponent.HybridType r101 = r100.hybridType();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return IHybridComponent.HybridType.H5;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public void release() {
        IHybridComponent r100 = getHybridComponent();
        if (r100 == null) goto L6;
        r100.release();
        return;
    }

    public HybridDialog() {
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateData(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        IHybridComponent r101 = getHybridComponent();
        if (r101 == null) goto L6;
        r101.updateData(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void updateGlobalProps(Map<String, ? extends Object> r100) {
        IHybridComponent r101 = getHybridComponent();
        if (r101 == null) goto L6;
        r101.updateGlobalProps(r100);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void load(String r100, Map<String, ? extends Object> r101) {
        IHybridComponent r102 = getHybridComponent();
        if (r102 == null) goto L6;
        r102.load(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final void registerMethod(String r100, f.b r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        IHybridComponent r102 = getHybridComponent();
        if (r102 == null) goto L6;
        r102.registerMethod(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "data");
        IHybridComponent r102 = getHybridComponent();
        if (r102 == null) goto L6;
        r102.sendJsEvent(r100, r101);
        return;
    }

    @Override // com.bytedance.android.annie.api.card.IHybridComponent
    public final <P, R> void registerMethod(String r100, g<P, R> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, e.f25671s);
        IHybridComponent r102 = getHybridComponent();
        if (r102 == null) goto L6;
        r102.registerMethod(r100, r101);
        return;
    }
}
