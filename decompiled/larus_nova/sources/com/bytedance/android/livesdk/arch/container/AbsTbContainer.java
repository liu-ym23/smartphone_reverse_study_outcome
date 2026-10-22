package com.bytedance.android.livesdk.arch.container;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.arch.comp.h;
import com.bytedance.android.livesdk.arch.lifecycle.ITbLifecycle;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbsTbContainer implements com.bytedance.android.livesdk.arch.container.a<com.bytedance.android.livesdk.arch.comp.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f103744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MiddlewareRoomContext f103745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f103746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<com.bytedance.android.livesdk.arch.comp.b, a> f103747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ot2.d f103748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f103749f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f103750a;

        public a(com.bytedance.android.livesdk.arch.comp.b r100) {
            Intrinsics.checkNotNullParameter(r100, "tbComp");
        }
    }

    public abstract com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a g();

    @Override // com.bytedance.android.livesdk.arch.container.a
    public abstract /* synthetic */ d getType();

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final void onUnload() {
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a) this.f103746c.getValue()).onDestroy();
        ((ConcurrentHashMap) this.f103747d).clear();
        com.bytedance.android.livesdk.arch.context.a.C1567a r100 = com.bytedance.android.livesdk.arch.context.a.K0;
        MiddlewareRoomContext r101 = this.f103745b;
        DataCenter r102 = this.f103744a;
        r100.getClass();
        com.bytedance.android.livesdk.arch.context.a r103 = com.bytedance.android.livesdk.arch.context.a.C1567a.a(r101, r102);
        if (r103 == null) goto L10;
        com.bytedance.android.livesdk.arch.record.a<com.bytedance.android.livesdk.arch.comp.b> r104 = r103.recordManager(getType());
        if (r104 == null) goto L12;
        List r105 = CollectionsKt.plus(r104.a(), r104.f());
        r104.j();
        Iterator r106 = r105.iterator();
    L8:
        if (r106.hasNext() == false) goto L13;
        ((com.bytedance.android.livesdk.arch.comp.b) r106.next()).b();
        goto L8
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final /* bridge */ /* synthetic */ void a(h r100) {
        h(false, r100);
    }

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final int b(int r100) {
        Iterator r101 = ((ConcurrentHashMap) this.f103747d).entrySet().iterator();
    L3:
        int r102 = 0;
        a r103 = null;
        if (r101.hasNext() == false) goto L13;
        Object r104 = r101.next();
        ToolbarMatchInterface r105 = ((com.bytedance.android.livesdk.arch.comp.b) ((Map.Entry) r104).getKey()).d();
        if (r105 != null) goto L8;
    L10:
        boolean r106 = false;
    L11:
        if (r106 == false) goto L3;
    L14:
        Map.Entry r107 = (Map.Entry) r104;
        if (r107 == null) goto L18;
        r103 = (a) r107.getValue();
    L18:
        if (r103 != null) goto L20;
        return -1;
    L20:
        ViewGroup r108 = this.f103749f;
        if (r108 == null) goto L33;
        Sequence<View> r109 = UtilityKotlinExtentionsKt.g(r108);
        if (r109 == null) goto L33;
        Iterator<View> r110 = r109.iterator();
    L26:
        if (r110.hasNext() == false) goto L33;
        View r111 = r110.next();
        if (Intrinsics.areEqual(r103.f103750a, r111) == true) goto L29;
        if (r111.getVisibility() != 0) goto L26;
        r102 = r102 + 1;
        goto L26
    L29:
        return r102;
    L33:
        return -1;
    L8:
        if (r105.getComponentId() != r100) goto L10;
        r106 = true;
        goto L11
    L13:
        r104 = null;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        h(false, r100);
        ((ConcurrentHashMap) this.f103747d).remove(r100);
    }

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final View e(com.bytedance.android.livesdk.arch.comp.b r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        if (((ConcurrentHashMap) this.f103747d).get(r100) != null) goto L7;
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a) this.f103746c.getValue()).a(r100, this.f103749f);
        Unit r101 = Unit.INSTANCE;
        a r102 = (a) ((ConcurrentHashMap) this.f103747d).get(r100);
        if (r102 == null) goto L7;
        return r102.f103750a;
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final void f(com.bytedance.android.livesdk.arch.comp.b r100) {
        Intrinsics.checkNotNullParameter(r100, "comp");
        a r101 = (a) ((ConcurrentHashMap) this.f103747d).get(r100);
        if (r101 == null) goto L5;
        View r102 = r101.f103750a;
    L7:
        if (r102 == null) goto L9;
        h(true, r100);
        return;
    L9:
        ((com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.a) this.f103746c.getValue()).a(r100, this.f103749f);
        h(true, r100);
        return;
    L5:
        r102 = null;
        goto L7
    }

    public AbsTbContainer(ot2.d r100, ViewGroup r101) {
        this.f103748e = r100;
        this.f103749f = r101;
        this.f103746c = LazyKt.lazy(new AbsTbContainer$contentHelper$2(this));
        this.f103747d = new ConcurrentHashMap();
    }

    @Override // com.bytedance.android.livesdk.arch.container.a
    public final void c(RoomContext r100, DataCenter r101) {
        this.f103744a = r101;
        this.f103745b = r100;
        com.bytedance.android.livesdk.arch.context.a.K0.getClass();
        com.bytedance.android.livesdk.arch.context.a r102 = com.bytedance.android.livesdk.arch.context.a.C1567a.a(r100, r101);
        if (r102 == null) goto L6;
        r102.initContainer(getType(), this);
        return;
    }

    public final void h(boolean r100, com.bytedance.android.livesdk.arch.comp.b r101) {
        Intrinsics.checkNotNullParameter(r101, "comp");
        a r102 = (a) ((ConcurrentHashMap) this.f103747d).get(r101);
        if (r102 == null) goto L21;
        View r103 = r102.f103750a;
        if (r103 == null) goto L21;
        if (r103.getVisibility() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r100 == false) goto L12;
        UtilityKotlinExtentionsKt.w(r103);
    L13:
        if (r104 == r100) goto L21;
        ot2.d r105 = this.f103748e;
        if (r105 == null) goto L21;
        ToolbarMatchInterface r106 = r101.d();
        if (r106 == null) goto L19;
        Integer r107 = Integer.valueOf(r106.getComponentId());
    L20:
        r105.onChildViewChanged(r100, r107.intValue(), r103);
        goto L21
    L19:
        r107 = null;
        goto L20
    L12:
        UtilityKotlinExtentionsKt.t(r103);
        goto L13
    L9:
        r104 = false;
    L21:
        if (r100 == false) goto L26;
        if (r101.g() == true) goto L29;
        r101.a(ITbLifecycle.State.Showed);
        return;
    L29:
        return;
    L26:
        if (r101.g() == false) goto L31;
        r101.a(ITbLifecycle.State.Hidden);
        return;
    }
}
