package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g3 extends x3 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map<ExtendedToolbarButton, e2> f116310o;

    public g3() {
        super(false);
        this.f116310o = new LinkedHashMap();
    }

    public final List<e2> I(Panel r100) {
        Intrinsics.checkNotNullParameter(r100, "panel");
        Collection r101 = ((LinkedHashMap) this.f116310o).values();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((e2) r104).a() != r100) goto L8;
        boolean r105 = true;
    L9:
        if (r105 == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        r105 = false;
        goto L9
    L11:
        return r102;
    }

    public final void J(e2 r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f116310o.put(r100.f116238b.extended(), r100);
        ExtendedToolbarButton r101 = r100.f116238b.extended();
        c0.b r102 = r100.f116237a;
        if (r102 != null) goto L8;
        r102 = r100.f116239c.invoke(r100.f116238b.extended());
        if (r100.f116240d == false) goto L8;
        r100.f116237a = r102;
    L8:
        super.p(r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3
    public final c0.b s(ExtendedToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        e2 r101 = (e2) ((LinkedHashMap) this.f116310o).get(r100);
        if (r101 == null) goto L12;
        c0.b r102 = r101.f116237a;
        if (r102 != null) goto L10;
        r102 = r101.f116239c.invoke(r101.f116238b.extended());
        if (r101.f116240d == false) goto L10;
        r101.f116237a = r102;
    L10:
        if (r102 == null) goto L12;
        return r102;
    L12:
        return super.s(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0
    public final void p(ExtendedToolbarButton r100, c0.b r101) {
        Intrinsics.checkNotNullParameter(r100, "button");
        if ((r101 instanceof e2) == false) goto L6;
        J((e2) r101);
        return;
    L6:
        super.p(r100, r101);
    }
}
