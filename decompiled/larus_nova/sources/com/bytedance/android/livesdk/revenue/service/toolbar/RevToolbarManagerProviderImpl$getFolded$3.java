package com.bytedance.android.livesdk.revenue.service.toolbar;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import zr2.o;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/x3;", "p1", "Lzr2/o;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/x3;)Lzr2/o;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class RevToolbarManagerProviderImpl$getFolded$3 extends FunctionReferenceImpl implements Function1<x3, o> {
    public static final RevToolbarManagerProviderImpl$getFolded$3 INSTANCE = null;

    static {
        INSTANCE = new RevToolbarManagerProviderImpl$getFolded$3();
    }

    public RevToolbarManagerProviderImpl$getFolded$3() {
        super(1, o.class, "<init>", "<init>(Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ToolbarManager;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final o invoke2(x3 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        return new o(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ o invoke(x3 r100) {
        return invoke2(r100);
    }
}
