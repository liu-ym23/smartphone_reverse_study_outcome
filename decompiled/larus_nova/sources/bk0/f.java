package bk0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f19285a;

    /* JADX WARN: Multi-variable type inference failed */
    public f(List<? extends e> r100) {
        Intrinsics.checkNotNullParameter(r100, "mIconFilters");
        this.f19285a = r100;
    }

    public final List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> a(List<? extends com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r100) {
        Intrinsics.checkNotNullParameter(r100, "icons");
        ArrayList r101 = new ArrayList();
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L15;
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r103 = (com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g) r102.next();
        Iterator<e> r104 = this.f19285a.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        if (r104.next().a(r103) == true) goto L7;
        boolean r105 = false;
    L12:
        if (r105 == false) goto L4;
        r101.add(r103);
        goto L4
    L11:
        r105 = true;
        goto L12
    L15:
        return CollectionsKt.toList(r101);
    }
}
