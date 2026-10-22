package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.business;

import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements a20.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f61435a;

    @Override // a20.f
    public final void clear() {
        ((ArrayList) this.f61435a).clear();
    }

    public d() {
        this.f61435a = new ArrayList();
    }

    @Override // a20.f
    public final List<String> a() {
        return this.f61435a;
    }

    @Override // a20.f
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (((ArrayList) this.f61435a).contains(r100) == false) goto L11;
        ((ArrayList) this.f61435a).remove(r100);
    L11:
        ((ArrayList) this.f61435a).add(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // a20.f
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        if (((ArrayList) this.f61435a).contains(r100) == false) goto L11;
        ((ArrayList) this.f61435a).remove(r100);
    L11:
        ListProtector.add(this.f61435a, 0, r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // a20.f
    public final void d(List<InteractEntranceCell> r100) {
        Intrinsics.checkNotNullParameter(r100, IconList.ELEM_NAME);
        if (((ArrayList) this.f61435a).isEmpty() == false) goto L9;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L20;
        InteractEntranceCell r102 = (InteractEntranceCell) r101.next();
        List<String> r103 = this.f61435a;
        ArrayList r104 = (ArrayList) r103;
        r104.add(r102.h());
        goto L6
    L20:
        return;
    L9:
        if (ft0.f120230a.getValue().e() == false) goto L14;
        ((ArrayList) this.f61435a).clear();
        Iterator<T> r105 = r100.iterator();
    L12:
        if (r105.hasNext() == false) goto L28;
        InteractEntranceCell r106 = (InteractEntranceCell) r105.next();
        List<String> r107 = this.f61435a;
        ArrayList r108 = (ArrayList) r107;
        r108.add(r106.h());
        goto L12
    L28:
        return;
    L14:
        Iterator<T> r109 = r100.iterator();
    L16:
        if (r109.hasNext() == false) goto L29;
        String r110 = ((InteractEntranceCell) r109.next()).h();
        if (((ArrayList) this.f61435a).contains(r110) == true) goto L16;
        ((ArrayList) this.f61435a).add(r110);
        goto L16
    }
}
