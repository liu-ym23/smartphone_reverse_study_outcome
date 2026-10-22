package com.bytedance.android.livesdk.vscore_impl.paidlive.scene;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.platformplayer.layout.b0;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneEnum;
import com.bytedance.android.livesdk.vscore_api.paid.PaidSceneViewEntry;
import com.bytedance.android.livesdk.vscore_api.paidlive.j;
import com.bytedance.android.livesdk.vscore_api.paidlive.k;
import com.bytedance.android.livesdk.vscore_api.paidlive.l;
import com.bytedance.android.livesdk.vscore_api.paidlive.model.PaidSceneContext;
import com.bytedance.android.livesdk.vscore_api.paidlive.n;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public abstract class BasePaidScene implements com.bytedance.android.livesdk.vscore_api.paidlive.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PaidSceneViewEntry f160547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Class<? extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g>, com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> f160548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PaidSceneContext f160549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Disposable f160550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CompositeDisposable f160551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public n f160552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.livesdk.vscore_api.paidlive.scope.b f160553g;

    public void A(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void D() {
    }

    public void E(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public void J(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public void K0(boolean r100) {
    }

    public void S0() {
    }

    public void Y(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public void e0(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public void j0(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void j9(Room r100) {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void onDestroy() {
        K0(true);
        Map<com.bytedance.android.livesdk.vscore_api.paidlive.scope.b, Map<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.scope.a>> r100 = cv2.a.f465482a;
        PaidSceneEnum r101 = i0();
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r102 = this.f160553g;
        Intrinsics.checkNotNullParameter(r101, "paidSceneEnum");
        Intrinsics.checkNotNullParameter(r102, "paidScope");
        ALogger.e("PaidSceneScopeUtil", "start leaveSceneScope:" + r101.name() + " in PaidScope:" + r102);
        Map<com.bytedance.android.livesdk.vscore_api.paidlive.scope.b, Map<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.scope.a>> r103 = cv2.a.f465482a;
        Map<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.scope.a> r104 = (Map) ((LinkedHashMap) r103).get(r102);
        if (r104 == null) goto L15;
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.a r105 = r104.get(r101);
        if (r105 != null) goto L7;
    L12:
        r104.remove(r101);
        r103.put(r102, r104);
        ALogger.e("PaidSceneScopeUtil", "remove:" + r101.name() + " in PaidScope:" + r102);
        if (r104.isEmpty() == false) goto L15;
        r103.remove(r102);
        ALogger.e("PaidSceneScopeUtil", "all map remove:" + r101.name() + " in PaidScope:" + r102 + ", currentSize:" + r103.size());
        goto L15
    L7:
        if (com.bytedance.android.scope.l.b(r105) == true) goto L10;
        r105 = null;
    L10:
        if (r105 == null) goto L12;
        com.bytedance.android.scope.l.c(r105);
    L15:
        Disposable r106 = this.f160550d;
        if (r106 == null) goto L18;
        r106.dispose();
    L18:
        Iterator<Map.Entry<Class<? extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g>, com.bytedance.android.livesdk.vscore_api.paidlive.ability.g>> r107 = this.f160548b.entrySet().iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        r107.next().getValue().onStop();
        goto L20
    L22:
        this.f160548b.clear();
        this.f160551e.clear();
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public int pk() {
        return -1;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void v0(long r100) {
    }

    public void w(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public void x(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    public void y(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void z(IRoom r100) {
    }

    public final String N() {
        return "PaidScene[" + hashCode() + "][" + i0() + "][" + this.f160553g.w0() + ']';
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public final l o2() {
        return this.f160552f.b();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void onInit() {
        Pair r100 = com.bytedance.live.datacontext.d.a(AnonymousClass1.INSTANCE);
        PaidSceneContext r101 = (PaidSceneContext) r100.component1();
        Disposable r102 = (Disposable) r100.component2();
        this.f160549c = r101;
        this.f160550d = r102;
        Map<com.bytedance.android.livesdk.vscore_api.paidlive.scope.b, Map<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.scope.a>> r103 = cv2.a.f465482a;
        PaidSceneEnum r104 = i0();
        PaidSceneContext r105 = this.f160549c;
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r106 = this.f160553g;
        Intrinsics.checkNotNullParameter(r104, "paidSceneEnum");
        Intrinsics.checkNotNullParameter(r105, "paidSceneContext");
        Intrinsics.checkNotNullParameter(r106, "paidScope");
        ALogger.e("PaidSceneScopeUtil", "start createSceneScope:" + r104.name() + " in PaidScope:" + r106);
        Map<com.bytedance.android.livesdk.vscore_api.paidlive.scope.b, Map<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.scope.a>> r107 = cv2.a.f465482a;
        Map r108 = (Map) ((LinkedHashMap) r107).get(r106);
        if (r108 != null) goto L6;
        r108 = new LinkedHashMap();
    L6:
        if (r108.containsKey(r104) == false) goto L8;
        ALogger.e("PaidSceneScopeUtil", "duplicate key, skip");
    L28:
        this.f160552f = new n(i0(), this.f160547a);
        this.f160549c.getSceneStateMachine().setValue(this.f160552f);
        this.f160552f.a(new BasePaidScene$createStateMachine$1(this));
        this.f160551e = new CompositeDisposable();
        return;
    L8:
        com.bytedance.android.livesdk.vscore_api.paidlive.scope.h r109 = new com.bytedance.android.livesdk.vscore_api.paidlive.scope.h(r106);
        Intrinsics.checkNotNullParameter(r109, "scope");
        Intrinsics.checkNotNullParameter(r104, "value");
        r109.f159511e = r104;
        Intrinsics.checkNotNullParameter(r105, "value");
        r109.f159512f = r105;
        Object r110 = e33.k.f470908a;
        if (r109.f159511e != r110) goto L11;
        String r111 = "sceneEnum";
    L26:
        if (r111 != null) goto L31;
        com.bytedance.android.scope.l.a(r109);
        r108.put(r104, r109);
        r107.put(r106, (Map<PaidSceneEnum, com.bytedance.android.livesdk.vscore_api.paidlive.scope.a>) r108);
        goto L28
    L31:
        throw new UninitializedPropertyAccessException(r111);
    L11:
        if (r105 != r110) goto L14;
        r111 = "sceneContext";
        goto L26
    L14:
        if (r109.f159513g != r110) goto L17;
        r111 = "id";
        goto L26
    L17:
        if (r109.f159514h != r110) goto L20;
        r111 = "fragmentHashCode";
        goto L26
    L20:
        if (r109.f159515i != r110) goto L23;
        r111 = "paidSceneViewEntry";
        goto L26
    L23:
        if (r109.f159516j != r110) goto L25;
        r111 = "paidScopeDataProvider";
        goto L26
    L25:
        r111 = null;
        goto L26
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public boolean kh() {
        l r100 = o2();
        r100.getClass();
        return !(r100 instanceof l.c);
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public final PaidSceneContext Xb() {
        return this.f160549c;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public PaidSceneEnum i0() {
        return PaidSceneEnum.PAID_ROOM;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public final PaidSceneViewEntry k5() {
        return this.f160547a;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public Boolean vf() {
        return Boolean.FALSE;
    }

    public BasePaidScene(com.bytedance.android.livesdk.vscore_api.paidlive.scope.b r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f160553g = r100;
        PaidSceneViewEntry r101 = r100.w0();
        this.f160547a = r101;
        this.f160548b = new HashMap();
        this.f160549c = new PaidSceneContext();
        this.f160551e = new CompositeDisposable();
        this.f160552f = new n(i0(), r101);
    }

    public final void U(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i(N(), r100);
    }

    public final void X(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.w(N(), r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X0(StateMachine.c.b<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "validTransition");
        k r101 = (k) r100.f66102d;
        if ((r101 instanceof k.e) == false) goto L6;
        A(r100);
        return;
    L6:
        if ((r101 instanceof k.g) == false) goto L9;
        J(r100);
        return;
    L9:
        if ((r101 instanceof k.d) == false) goto L12;
        y(r100);
        return;
    L12:
        if ((r101 instanceof k.f) == false) goto L15;
        E(r100);
        return;
    L15:
        if ((r101 instanceof k.b) == false) goto L18;
        x(r100);
        return;
    L18:
        if ((r101 instanceof k.m) == false) goto L21;
        j0(r100);
        return;
    L21:
        if ((r101 instanceof k.h) == false) goto L24;
        Y(r100);
        return;
    L24:
        if ((r101 instanceof k.c) == false) goto L27;
        e0(r100);
        return;
    L27:
        if ((r101 instanceof k.C2443k) == false) goto L30;
        K0(false);
        return;
    L30:
        if ((r101 instanceof k.a) == false) goto L33;
        w(r100);
        return;
    L33:
        if ((r101 instanceof k.l) == false) goto L46;
        S0();
        return;
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public void bb(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Intrinsics.checkNotNullParameter(r100, "listener");
    }

    @Override // java.lang.Comparable
    public final int compareTo(com.bytedance.android.livesdk.vscore_api.paidlive.e r100) {
        com.bytedance.android.livesdk.vscore_api.paidlive.e r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (Intrinsics.areEqual(this, r101) == false) goto L6;
        return 0;
    L6:
        return i0().getPriority() - r101.i0().getPriority();
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public final <T extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> T getAbility(Class<? extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f160548b.containsKey(r100) == true) goto L6;
        return null;
    L6:
        if (this.f160548b.get(r100) == null) goto L18;
        T r101 = (T) this.f160548b.get(r100);     // Catch: Exception -> L15
        if (r101 == null) goto L12;
        return r101;
    L12:
        throw new RuntimeException("是不是传错东西进来了？");     // Catch: Exception -> L15
        goto L19
    L18:
        return null;
    L19:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x0(StateMachine.c<? extends l, ? extends j, ? extends k> r100) {
        Intrinsics.checkNotNullParameter(r100, "transition");
        j r101 = null;
        if ((r100 instanceof StateMachine.c.b) == true) goto L5;
        StateMachine.c<? extends l, ? extends j, ? extends k> r102 = null;
    L6:
        StateMachine.c.b<? extends l, ? extends j, ? extends k> r103 = (StateMachine.c.b) r102;
        if (r103 == null) goto L9;
        l r104 = (l) r103.f66099a;
        l r105 = (l) r103.f66101c;
        j r106 = (j) r103.f66100b;
        X0(r103);
        if (this.f160549c.isCleared() == false) goto L23;
        return;
    L23:
        this.f160549c.getCurrentState().setValue(r105);
        return;
    L9:
        if ((r100 instanceof StateMachine.c.a) == true) goto L11;
        r100 = null;
    L11:
        StateMachine.c.a r107 = (StateMachine.c.a) r100;
        StringBuilder r108 = new StringBuilder("onStateTransition, InValid transition from: ");
        if (r107 == null) goto L14;
        l r109 = (l) r107.f66097a;
    L15:
        r108.append(r109);
        r108.append(",event: ");
        if (r107 == null) goto L18;
        r101 = (j) r107.f66098b;
    L18:
        r108.append(r101);
        U(r108.toString());
        return;
    L14:
        r109 = null;
        goto L15
    L5:
        r102 = r100;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.vscore_api.paidlive.e
    public final void I6(Class<? extends com.bytedance.android.livesdk.vscore_api.paidlive.ability.g> r100, com.bytedance.android.livesdk.vscore_api.paidlive.ability.g r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "instance");
        this.f160548b.put(r100, r101);
    }
}
