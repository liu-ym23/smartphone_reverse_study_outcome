package com.android.ttcjpaysdk.facelive.anniexextension;

import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.event.CJPayFinishH5ActivityEvent;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import fe4.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/anniexextension/FaceCheckPageLifecycle;", "Lfe4/a;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "CJTag", "", "onBackPressClick", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "containerContext", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "<init>", "(Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;)V", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0})
public final class FaceCheckPageLifecycle implements a, ICJTag {
    private final ContainerContext containerContext;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "FaceCheckPageLifecycle";
    }

    @Override // fe4.a
    public boolean isInterceptorBackPress() {
        return false;
    }

    @Override // fe4.a
    public void onInterceptorBackPress() {
    }

    @Override // fe4.a
    public void onPageCreate() {
    }

    @Override // fe4.a
    public void onPageDestroy() {
    }

    @Override // fe4.a
    public void onPageResume() {
    }

    @Override // fe4.a
    public void onBackPressClick() {
        String r100 = this.containerContext.a("enter_from");
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (StringsKt.isBlank(r100) == false) goto L8;
        ICJTag.DefaultImpls.e$default(this, "[onBackPress] enterFrom is blank", null, 2, null);
    L8:
        i("[onBackPressClick] enterFrom=".concat(r100));
        EventManager.INSTANCE.notify(new CJPayFinishH5ActivityEvent(r100));
    }

    public FaceCheckPageLifecycle(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.containerContext = r100;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }
}
