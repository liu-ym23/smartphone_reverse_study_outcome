package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes8.dex */
public interface a0<CMD> {

    public static final class a {
        public static /* synthetic */ void a(a0 r100, pp1.c r101, q2 r102) {
            r100.addBubble(r101, 1, r102, IToolbarBubbleManager$addBubble$2.INSTANCE);
        }
    }

    public interface b {
    }

    b addBubble(CMD r100, int r101, z<CMD> r102, Function0<Unit> r103);

    b addBubbleLocal(CMD r100, int r101, z<CMD> r102, Function0<Unit> r103);

    <T> z<T> createToolbarBubble(DataCenter r100, Context r101, View r102);

    boolean dismissBubble(b r100);

    void lock(Object r100);

    void tryStartNextBubble();

    void unlock(Object r100);
}
