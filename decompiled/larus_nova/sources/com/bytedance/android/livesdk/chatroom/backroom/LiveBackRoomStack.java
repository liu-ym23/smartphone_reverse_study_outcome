package com.bytedance.android.livesdk.chatroom.backroom;

import android.os.Bundle;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.backroom.utils.BackSourceConfigs;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStack;
import com.bytedance.android.livesdkapi.depend.live.IBackRoomStackKt;
import com.bytedance.android.livesdkapi.depend.live.StackContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yf1.c;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveBackRoomStack implements IBackRoomStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f105107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<xf1.a> f105108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<c> f105109c;

    public static final class a {
    }

    static {
    }

    public final Stack<Bundle> a() {
        return (Stack) this.f105107a.getValue();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IBackRoomStack
    public final void clear() {
        a().clear();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IBackRoomStack
    public final Bundle peekRoomInfo() {
        Stack<Bundle> r100 = a();
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.peek();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IBackRoomStack
    public final Bundle popRoomInfo() {
        Stack<Bundle> r100 = a();
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return r100.pop();
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IBackRoomStack
    public final int size() {
        return a().size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveBackRoomStack(List<? extends xf1.a> r100, List<? extends c> r101) {
        Intrinsics.checkNotNullParameter(r100, "filters");
        Intrinsics.checkNotNullParameter(r101, "transforms");
        this.f105108b = r100;
        this.f105109c = r101;
        this.f105107a = LazyKt.lazy(LiveBackRoomStack$mRooms$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.IBackRoomStack
    public final void pushRoomInfo(Bundle r100, Bundle r110, StackContext r111) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.clone();
    L7:
        if ((r102 instanceof Bundle) == true) goto L9;
        r102 = null;
    L9:
        Bundle r103 = (Bundle) r102;
        if (r103 == null) goto L60;
        Iterator<T> r104 = this.f105108b.iterator();
    L14:
        if (r104.hasNext() == false) goto L18;
        xf1.a r105 = (xf1.a) r104.next();
        if (r105.a(r103, r110, r111) == false) goto L14;
        ALogger.d("LiveBackRoomStack", "pushToStack: " + r105);
        r103 = null;
    L18:
        if (r103 != null) goto L20;
        ALogger.i("LiveBackRoomStack", "abort push to stack, filtered by at least one of " + this.f105108b);
        return;
    L20:
        Iterator<T> r106 = this.f105109c.iterator();
    L22:
        if (r106.hasNext() == false) goto L24;
        ((c) r106.next()).a(r103, r110, r111);
        goto L22
    L24:
        Lazy r112 = BackSourceConfigs.f105113a;
        if (r110 == null) goto L27;
        String r113 = com.bytedance.android.livesdk.chatroom.backroom.utils.a.a(r110);
    L28:
        Lazy r107 = BackSourceConfigs.f105115c;
        boolean r108 = false;
        if (((List) r107.getValue()).contains(IBackRoomStackKt.JUMP_SOURCE_ALL) == false) goto L31;
    L34:
        boolean r114 = true;
    L35:
        if (r114 == false) goto L37;
        a().clear();
        a().push(r103);
    L48:
        StringBuilder r115 = new StringBuilder("pushToStack: ");
        r115.append(r103);
        r115.append(", success: ");
        if ((!a().isEmpty()) == true) goto L51;
    L53:
        r115.append(r108);
        ALogger.d("LiveBackRoomStack", r115.toString());
        return;
    L51:
        if (Intrinsics.areEqual(a().peek(), r103) == false) goto L53;
        r108 = true;
        goto L53
    L37:
        if (r110 == null) goto L39;
        r101 = com.bytedance.android.livesdk.chatroom.backroom.utils.a.a(r110);
    L39:
        Lazy r116 = BackSourceConfigs.f105114b;
        if (((List) r116.getValue()).contains(IBackRoomStackKt.JUMP_SOURCE_ALL) == false) goto L42;
    L45:
        boolean r117 = true;
    L46:
        if (r117 == false) goto L48;
        a().push(r103);
        goto L48
    L42:
        if (CollectionsKt.contains((List) r116.getValue(), r101) == true) goto L45;
        r117 = false;
        goto L46
    L31:
        if (CollectionsKt.contains((List) r107.getValue(), r113) == true) goto L34;
        r114 = false;
        goto L35
    L27:
        r113 = null;
        goto L28
    L60:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
