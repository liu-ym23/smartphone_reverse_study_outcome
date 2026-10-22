package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"adjustContentPadding", "", "isPortrait", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class BaseMatchNativeWidget$adjustPad$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ BaseMatchNativeWidget this$0;

    public BaseMatchNativeWidget$adjustPad$1(BaseMatchNativeWidget r100) {
        this.this$0 = r100;
        super(1);
    }

    public final void invoke(boolean r100) {
        if (r100 == false) goto L7;
        View r101 = this.this$0.contentView;
        if (r101 == null) goto L11;
        r101.setPadding(0, (int) UtilityKotlinExtentionsKt.h(16), 0, 0);
        return;
    L11:
        return;
    L7:
        View r102 = this.this$0.contentView;
        if (r102 == null) goto L13;
        r102.setPadding(0, 0, 0, 0);
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
