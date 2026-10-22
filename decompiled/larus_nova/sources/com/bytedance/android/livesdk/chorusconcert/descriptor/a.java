package com.bytedance.android.livesdk.chorusconcert.descriptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.layer.initialization.LayerIndex;
import com.bytedance.android.live.core.tetris.layer.view.ElementConstraint;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.VSSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chorusconcert.VSChorusConcertWidget;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.MultiTabManagerImpl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import d90.d;
import d90.e;
import h70.b;
import j70.f;
import j70.n;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lu2.c;
import vr1.u;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends n<d> {
    @Override // j70.o
    public final boolean h() {
        return false;
    }

    public a() {
    }

    @Override // j70.o
    public final Class<? extends Widget> c() {
        return VSChorusConcertWidget.class;
    }

    @Override // j70.d
    public final boolean B(b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        IRoom r102 = e.k(r101);
        boolean r103 = false;
        if (r102 != null) goto L6;
    L42:
        return r103;
    L6:
        if (VSSettingKeys.LIVE_VS_CHORUS_ENABLE_ACTIVE.getValue().booleanValue() == true) goto L9;
        ALogger.i("VsChorusConcertWidgetDescriptor ", "return false cause live_vs_chorus_enable_active is false");
        goto L42
    L9:
        if (MultiTabManagerImpl.f159902e.h(r101.f467480h) == false) goto L12;
        ALogger.i("VsChorusConcertWidgetDescriptor ", "return false cause room ismultitabroom");
        goto L42
    L12:
        if (c.c(r102) == false) goto L14;
    L41:
        ALogger.i("VsChorusConcertWidgetDescriptor ", "return false cause room.hasMultiCamera()" + c.c(r102) + " || room.hasLinkedRoom()" + c.b(r102) + ' ');
        goto L42
    L14:
        if (c.b(r102) == true) goto L41;
        IRoom r104 = e.k(r101);
        if (r104 == null) goto L24;
        z5 r105 = r104.getLinkerDetail();
        if (r105 == null) goto L24;
        List<Long> r106 = r105.getPlayModes();
        if (r106 == null) goto L24;
        if (r106.contains(Long.valueOf(39)) != true) goto L24;
    L28:
        boolean r107 = true;
    L30:
        IRoom r108 = e.k(r101);
        if (r108 != null) goto L33;
    L36:
        StringBuilder r109 = new StringBuilder("return");
        r109.append(r103);
        r109.append("  isChorusRoom");
        r109.append(r107);
        r109.append(" isMergeVSRoom");
        IRoom r110 = e.k(r101);
        if (r110 == null) goto L39;
        Boolean r111 = Boolean.valueOf(r110.isMergeVSRoom());
    L40:
        r109.append(r111);
        ALogger.i("VsChorusConcertWidgetDescriptor", r109.toString());
        goto L42
    L39:
        r111 = null;
        goto L40
    L33:
        if (r108.isMergeVSRoom() != true) goto L36;
        if (r107 == false) goto L36;
        r103 = true;
    L24:
        es1.a r112 = es1.a.f473681j.c(r102.getId(), r101.getContext(), true);
        if (r112 != null) goto L27;
    L29:
        r107 = false;
        goto L30
    L27:
        if (r112.f473684c != true) goto L29;
        goto L28
    }

    @Override // j70.d
    public final f C(b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        r101.f467478f.getClass();
        return d.a.I3;
    }

    @Override // j70.d
    public final LayerIndex E(b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (d90.f.a(r101) == false) goto L6;
        return LayerIndex.INDEX_6;
    L6:
        return LayerIndex.INDEX_3;
    }

    @Override // j70.h
    public final double H(b r100) {
        Intrinsics.checkNotNullParameter((d) r100, "layerContext");
        return 0.1d;
    }

    @Override // j70.h
    public final ElementConstraint J(b r100) {
        d r101 = (d) r100;
        Intrinsics.checkNotNullParameter(r101, "layerContext");
        if (d90.f.a(r101) == false) goto L12;
        u r102 = r.u(r101.f467480h, null, 2);
        if (r102 == null) goto L12;
        m<Boolean> r103 = r102.A();
        if (r103 == null) goto L12;
        if (r103.getValue().booleanValue() != true) goto L12;
        ElementConstraint r104 = new ElementConstraint(-1.0f, 110.0f);
        r104.a(f.f497556d, VsChorusConcertWidgetDescriptor$generateConstraint$1.INSTANCE);
        return r104;
    L12:
        if (d90.f.a(r101) == false) goto L20;
        u r105 = r.u(r101.f467480h, null, 2);
        if (r105 == null) goto L20;
        m<Boolean> r106 = r105.A();
        if (r106 == null) goto L20;
        if (r106.getValue().booleanValue() == true) goto L20;
        ElementConstraint r107 = new ElementConstraint(-1.0f, 110.0f);
        r101.f467478f.getClass();
        r107.k(d.a.f467510f1, VsChorusConcertWidgetDescriptor$generateConstraint$2.INSTANCE);
        return r107;
    L20:
        ElementConstraint r108 = new ElementConstraint(-1.0f, 110.0f);
        r108.a(f.f497556d, VsChorusConcertWidgetDescriptor$generateConstraint$3.INSTANCE);
        return r108;
    }
}
