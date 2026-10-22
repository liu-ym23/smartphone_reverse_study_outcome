package com.bytedance.android.ec.base.api.ai.framework.component;

import android.view.View;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "extra", "", "", "getExtra", "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "onClickCloseListener", "Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickCloseListener;", "getOnClickCloseListener", "()Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickCloseListener;", "setOnClickCloseListener", "(Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickCloseListener;)V", "onClickMenuListener", "Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickMenuListener;", "getOnClickMenuListener", "()Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickMenuListener;", "setOnClickMenuListener", "(Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickMenuListener;)V", "scene", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getView", "()Landroid/view/View;", "OnClickCloseListener", "OnClickMenuListener", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class CapsuleComponent {
    private Map<String, ? extends Object> extra;
    private OnClickCloseListener onClickCloseListener;
    private OnClickMenuListener onClickMenuListener;
    private String scene;
    private final View view;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickCloseListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "view", "Landroid/view/View;", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
    public interface OnClickCloseListener {
        void onClick(View r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bç\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/framework/component/CapsuleComponent$OnClickMenuListener;", "", SendEventContainerMethodParamModel.EventKinds.onClick, "", "view", "Landroid/view/View;", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
    public interface OnClickMenuListener {
        void onClick(View r100);
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final OnClickCloseListener getOnClickCloseListener() {
        return this.onClickCloseListener;
    }

    public final OnClickMenuListener getOnClickMenuListener() {
        return this.onClickMenuListener;
    }

    public final String getScene() {
        return this.scene;
    }

    public final View getView() {
        return this.view;
    }

    public CapsuleComponent(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.view = r100;
    }

    public final void setExtra(Map<String, ? extends Object> r100) {
        this.extra = r100;
    }

    public final void setOnClickCloseListener(OnClickCloseListener r100) {
        this.onClickCloseListener = r100;
    }

    public final void setOnClickMenuListener(OnClickMenuListener r100) {
        this.onClickMenuListener = r100;
    }

    public final void setScene(String r100) {
        this.scene = r100;
    }
}
