package com.bytedance.android.ecom.slice.ext.template.gecko.loader;

import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.slice.ext.template.gecko.i;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ecom/slice/ext/template/gecko/i;", "loadResult", "Lcom/bytedance/android/ecom/arch/slice/render/r;", "viewInfo", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/ecom/slice/ext/template/gecko/i;Lcom/bytedance/android/ecom/arch/slice/render/r;)V", "com/bytedance/android/ecom/slice/ext/template/gecko/loader/SlcGeckoTemplatePageLoader$loadTemplate$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class SlcGeckoTemplatePageLoader$loadTemplate$$inlined$let$lambda$1 extends Lambda implements Function2<i, r, Unit> {
    final /* synthetic */ Map $customEventParams$inlined;
    final /* synthetic */ Function2 $listener$inlined;
    final /* synthetic */ com.bytedance.android.ecom.arch.slice.render.i $templateInfo$inlined;
    final /* synthetic */ SlcGeckoTemplatePageLoader this$0;

    public SlcGeckoTemplatePageLoader$loadTemplate$$inlined$let$lambda$1(SlcGeckoTemplatePageLoader r100, com.bytedance.android.ecom.arch.slice.render.i r101, Map r102, Function2 r103) {
        this.this$0 = r100;
        this.$templateInfo$inlined = r101;
        this.$customEventParams$inlined = r102;
        this.$listener$inlined = r103;
        super(2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(i r100, r r101) {
        if (r100.f51261a != null) goto L6;
        if (r101 != null) goto L6;
        this.this$0.e(this.$templateInfo$inlined, this.$customEventParams$inlined, this.$listener$inlined);
        return;
    L6:
        this.$listener$inlined.invoke(r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(i r100, r r101) {
        invoke2(r100, r101);
        return Unit.INSTANCE;
    }
}
