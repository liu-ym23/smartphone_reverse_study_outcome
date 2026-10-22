package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.behavior;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class CommonToolbarUiHandler$playAnimationOnce$1 extends Lambda implements Function0<String> {
    public static final CommonToolbarUiHandler$playAnimationOnce$1 INSTANCE = null;

    static {
        INSTANCE = new CommonToolbarUiHandler$playAnimationOnce$1();
    }

    public CommonToolbarUiHandler$playAnimationOnce$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "is others running.";
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
