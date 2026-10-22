package com.bytedance.android.livesdk.chatroom.helper;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarBubbleManager;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a0;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0;", "Lpp1/c;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/a0;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class RoomContextInitHelper$initializeInVideo$1 extends Lambda implements Function0<a0<pp1.c>> {
    public static final RoomContextInitHelper$initializeInVideo$1 INSTANCE = null;

    static {
        INSTANCE = new RoomContextInitHelper$initializeInVideo$1();
    }

    public RoomContextInitHelper$initializeInVideo$1() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final a0<pp1.c> invoke() {
        return new ToolbarBubbleManager();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ a0<pp1.c> invoke() {
        return invoke();
    }
}
