package com.bytedance.ai.view.input;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class q implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChatInput f37777a;

    public /* synthetic */ q(ChatInput r100) {
        this.f37777a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        ChatInput r100 = this.f37777a;
        int r101 = ChatInput.f37680v;
        int r102 = r111.getActionMasked();
        Intrinsics.checkNotNull(r110);
        Intrinsics.checkNotNull(r111);
        r100.getClass();
        int[] r103 = new int[2];
        r110.getLocationOnScreen(r103);
        boolean r112 = false;
        Pair r113 = new Pair(Float.valueOf(r103[0] + r111.getX()), Float.valueOf(r103[1] + r111.getY()));
        if (r102 == 0) goto L39;
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L15;
    L56:
        return true;
    L10:
        if ((System.currentTimeMillis() - r100.f37701u) < 300) goto L56;
        Function3<Integer, Float, Float, Boolean> r114 = r100.getOnSpeakEvent();
        if (r114 == 0) goto L56;
        Boolean r115 = (Boolean) r114.invoke(2, r113.getFirst(), r113.getSecond());
    L15:
        Function0<z0<FloatingChatStatus>> r116 = r100.getChatStatus();
        if (r116 == null) goto L20;
        z0<FloatingChatStatus> r117 = r116.invoke();
        if (r117 == null) goto L20;
        FloatingChatStatus r118 = r117.getValue();
    L22:
        if (r118 != FloatingChatStatus.ON_SPEAK) goto L56;
        if (r100.f37691k == false) goto L31;
        Function0<z0<FloatingChatStatus>> r119 = r100.getChatStatus();
        if (r119 == null) goto L36;
        z0<FloatingChatStatus> r120 = r119.invoke();
        if (r120 == null) goto L36;
        r120.tryEmit(FloatingChatStatus.READY_TO_INPUT);
    L36:
        Function3<Integer, Float, Float, Boolean> r121 = r100.getOnSpeakEvent();
        if (r121 == 0) goto L56;
        Boolean r122 = (Boolean) r121.invoke(1, r113.getFirst(), r113.getSecond());
        goto L56
    L31:
        Function0<z0<FloatingChatStatus>> r123 = r100.getChatStatus();
        if (r123 == null) goto L36;
        z0<FloatingChatStatus> r124 = r123.invoke();
        if (r124 == null) goto L36;
        r124.tryEmit(FloatingChatStatus.READY_TO_SPEAK);
    L20:
        r118 = null;
        goto L22
    L39:
        long r104 = System.currentTimeMillis();
        if ((r104 - r100.f37701u) < 300) goto L56;
        Function3<Integer, Float, Float, Boolean> r105 = r100.getOnSpeakEvent();
        if (r105 != 0) goto L45;
    L47:
        if (r112 == false) goto L56;
        if (r100.getChatStatus().invoke().getValue() != FloatingChatStatus.READY_TO_INPUT) goto L51;
        r100.f37691k = true;
    L51:
        r100.f37701u = r104;
        Function0<z0<FloatingChatStatus>> r125 = r100.getChatStatus();
        if (r125 == null) goto L56;
        z0<FloatingChatStatus> r126 = r125.invoke();
        if (r126 == null) goto L56;
        r126.tryEmit(FloatingChatStatus.ON_SPEAK);
        goto L56
    L45:
        if (((Boolean) r105.invoke(0, r113.getFirst(), r113.getSecond())).booleanValue() != true) goto L47;
        r112 = true;
        goto L47
    }
}
