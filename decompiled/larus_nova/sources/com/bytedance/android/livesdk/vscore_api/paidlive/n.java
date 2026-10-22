package com.bytedance.android.livesdk.vscore_api.paidlive;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f159477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function1<StateMachine.c<? extends l, ? extends j, ? extends k>, Unit>> f159478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateMachine<l, j, k> f159479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PaidSceneEnum f159480d;

    public final l b() {
        return this.f159479c.b();
    }

    public final void a(Function1<? super StateMachine.c<? extends l, ? extends j, ? extends k>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        ((ArrayList) this.f159478b).add(r100);
    }

    public n(PaidSceneEnum r100, PaidSceneViewEntry r101) {
        Intrinsics.checkNotNullParameter(r100, "sceneTag");
        Intrinsics.checkNotNullParameter(r101, "sceneViewEntry");
        this.f159480d = r100;
        this.f159477a = "PaidSceneStateMachine[" + hashCode() + "](" + r100.name() + ")(" + r101 + ')';
        this.f159478b = new ArrayList();
        StateMachine.a r102 = StateMachine.f66079c;
        PaidSceneStateMachine$createStateMachine$1 r103 = new PaidSceneStateMachine$createStateMachine$1(this);
        r102.getClass();
        this.f159479c = StateMachine.a.a(r103);
    }

    public static void c(n r100, j r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        r100.f159479c.d(r101, null);
    }
}
