package com.bytedance.android.shopping.slice.action;

import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.action.d;
import com.bytedance.android.ecom.arch.slice.action.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/PDPDrillHandler;", "Lcom/bytedance/android/ecom/arch/slice/action/e;", "", "", "", "Lcom/bytedance/android/ecom/arch/slice/action/SlcCommonAction;", "action", "actionParams", "Lcom/bytedance/android/ecom/arch/slice/action/c;", "actionUIContext", "Lcom/bytedance/android/ecom/arch/slice/action/d;", "checkParam", "Lcom/bytedance/android/ecom/arch/slice/action/ActionContext;", "actionContext", "", "onHandle", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PDPDrillHandler extends e<Map<String, ? extends Object>> {
    /* JADX INFO: renamed from: onHandle, reason: avoid collision after fix types in other method */
    public void onHandle2(ActionContext r100, SlcCommonAction r101, Map<String, ? extends Object> r102, c r103) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r101, "action");
    }

    public PDPDrillHandler() {
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public d<Map<String, ? extends Object>> checkParam(SlcCommonAction r100, Map<String, ? extends Object> r101, c r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        int r103 = d.f49983d;
        return d.a.b(r101);
    }

    @Override // com.bytedance.android.ecom.arch.slice.action.e
    public /* bridge */ /* synthetic */ void onHandle(ActionContext r100, SlcCommonAction r101, Map<String, ? extends Object> r102, c r103) {
        onHandle2(r100, r101, r102, r103);
    }
}
