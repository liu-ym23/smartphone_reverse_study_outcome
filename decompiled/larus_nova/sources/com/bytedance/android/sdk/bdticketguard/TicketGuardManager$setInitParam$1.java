package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/b1;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/sdk/bdticketguard/b1;)Z", "isAccountParam"}, k = 3, mv = {1, 4, 0})
public final class TicketGuardManager$setInitParam$1 extends Lambda implements Function1<b1, Boolean> {
    public static final TicketGuardManager$setInitParam$1 INSTANCE = null;

    static {
        INSTANCE = new TicketGuardManager$setInitParam$1();
    }

    public TicketGuardManager$setInitParam$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(b1 r100) {
        return StringsKt.startsWith$default(r100.getClass().getName(), "com.bytedance.sdk.account.ticketguard", false, 2, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(b1 r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
