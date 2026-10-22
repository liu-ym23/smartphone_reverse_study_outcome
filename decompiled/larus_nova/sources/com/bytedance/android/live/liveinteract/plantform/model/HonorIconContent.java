package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\nR*\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/HonorIconContent;", "", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "getIcon$annotations", "()V", "<init>", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class HonorIconContent implements vh7.h {
    private py.k icon;

    public HonorIconContent() {
    }

    public HonorIconContent(am3.g r100) {
        long r101 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r101);
    }

    @FieldName(name = "icon")
    public static /* synthetic */ void getIcon$annotations() {
    }

    public final py.k getIcon() {
        return this.icon;
    }

    public final void setIcon(py.k r100) {
        this.icon = r100;
    }
}
