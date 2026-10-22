package com.bytedance.android.livesdk.revenue.service.sti;

import com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/sti/framework/ITiltedIconTemplate;", "p1", "Lsr2/b;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdkapi/sti/framework/ITiltedIconTemplate;)Lsr2/b;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class IconTemplateProvider$Companion$2 extends FunctionReferenceImpl implements Function1<ITiltedIconTemplate, sr2.b> {
    public static final IconTemplateProvider$Companion$2 INSTANCE = null;

    static {
        INSTANCE = new IconTemplateProvider$Companion$2();
    }

    public IconTemplateProvider$Companion$2() {
        super(1, sr2.b.class, "<init>", "<init>(Lcom/bytedance/android/livesdkapi/sti/framework/ITiltedIconTemplate;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final sr2.b invoke2(ITiltedIconTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new sr2.b(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ sr2.b invoke(ITiltedIconTemplate r100) {
        return invoke2(r100);
    }
}
