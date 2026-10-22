package com.android.ttcjpaysdk.base.ui.widget;

import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ScrollAnimTextView$degradeAnimLogic$2 extends Lambda implements Function0<Boolean> {
    public static final ScrollAnimTextView$degradeAnimLogic$2 INSTANCE = null;

    static {
        INSTANCE = new ScrollAnimTextView$degradeAnimLogic$2();
    }

    public ScrollAnimTextView$degradeAnimLogic$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(CJPaySettingsManager.getInstance().isDegradeAmountAnim());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
