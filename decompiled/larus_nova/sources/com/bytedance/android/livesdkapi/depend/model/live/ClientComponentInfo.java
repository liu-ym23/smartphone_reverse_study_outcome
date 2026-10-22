package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponentInfo;", "", "()V", "containerId", "", "getContainerId", "()Ljava/lang/String;", "setContainerId", "(Ljava/lang/String;)V", "containerLayout", "Lcom/bytedance/android/livesdkapi/depend/model/live/ContainerLayout;", "getContainerLayout", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ContainerLayout;", "setContainerLayout", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ContainerLayout;)V", "dslModel", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "getDslModel", "()Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;", "setDslModel", "(Lcom/bytedance/android/livesdkapi/depend/model/live/LiveDSLModel;)V", "dslTarget", "getDslTarget", "setDslTarget", "functionDetail", "Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponentFunctionInfo;", "getFunctionDetail", "()Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponentFunctionInfo;", "setFunctionDetail", "(Lcom/bytedance/android/livesdkapi/depend/model/live/ClientComponentFunctionInfo;)V", "isOpen", "", "()Ljava/lang/Boolean;", "setOpen", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ClientComponentInfo implements h {

    @SerializedName("container_id")
    protected String containerId;

    @SerializedName("container_layout")
    protected ContainerLayout containerLayout;

    @SerializedName("dsl_detail")
    protected LiveDSLModel dslModel;

    @SerializedName("dsl_layout")
    protected String dslTarget;

    @SerializedName("function_detail")
    protected ClientComponentFunctionInfo functionDetail;

    @SerializedName("is_open")
    protected Boolean isOpen;

    public ClientComponentInfo() {
        this.isOpen = Boolean.FALSE;
    }

    public final String getContainerId() {
        return this.containerId;
    }

    public final ContainerLayout getContainerLayout() {
        return this.containerLayout;
    }

    public final LiveDSLModel getDslModel() {
        return this.dslModel;
    }

    public final String getDslTarget() {
        return this.dslTarget;
    }

    public final ClientComponentFunctionInfo getFunctionDetail() {
        return this.functionDetail;
    }

    public final Boolean isOpen() {
        return this.isOpen;
    }

    public ClientComponentInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.containerLayout = new ContainerLayout(r100);
        goto L3
    L8:
        this.dslTarget = am3.h.c(r100);
        goto L3
    L9:
        this.dslModel = new LiveDSLModel(r100);
        goto L3
    L10:
        this.isOpen = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L11:
        this.functionDetail = new ClientComponentFunctionInfo(r100);
        goto L3
    L12:
        this.containerId = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.isOpen != null) goto L33;
        this.isOpen = Boolean.FALSE;
        return;
    }

    public final void setContainerId(String r100) {
        this.containerId = r100;
    }

    public final void setContainerLayout(ContainerLayout r100) {
        this.containerLayout = r100;
    }

    public final void setDslModel(LiveDSLModel r100) {
        this.dslModel = r100;
    }

    public final void setDslTarget(String r100) {
        this.dslTarget = r100;
    }

    public final void setFunctionDetail(ClientComponentFunctionInfo r100) {
        this.functionDetail = r100;
    }

    public final void setOpen(Boolean r100) {
        this.isOpen = r100;
    }
}
