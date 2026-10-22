package com.bytedance.applet.aibridge.login;

import com.larus.bmhome.utils.t3;
import com.larus.bmhome.utils.v2;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements tj9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsOpenLoginPanelMethodIDL.a f191186a;

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.larus.bmhome.utils.t3, java.lang.Object] */
    @Override // tj9.a
    public final void a() {
        final String r100 = this.f191186a.getMsgId();
        if (r100 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(this.f191186a.getReSendAfterLogin(), Boolean.TRUE) == true) goto L8;
        return;
    L8:
        final Ref.ObjectRef r101 = new Ref.ObjectRef();
        final AbsOpenLoginPanelMethodIDL.a r102 = this.f191186a;
        ?? r103 = new t3(new pv3.a(r101, r102, r100));
        r101.element = r103;
        List<t3> r104 = v2.f315131a;
        t3 r105 = (t3) r103;
        Intrinsics.checkNotNullParameter(r103, "task");
        ((ArrayList) v2.f315131a).add(r103);
    }

    public b(AbsOpenLoginPanelMethodIDL.a r100) {
        this.f191186a = r100;
    }
}
