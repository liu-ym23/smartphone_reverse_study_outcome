package com.bytedance.android.ec.adapter.impl.converter;

import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.ExternalViewGroupAction;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalViewGroup;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class e implements Function3<IExternalViewGroup, IExternalView, ExternalViewGroupAction, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f42782a;

    public e(Function3 r100) {
        this.f42782a = r100;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(IExternalViewGroup r100, IExternalView r101, ExternalViewGroupAction r102) {
        IExternalViewGroup r103 = r100;
        IExternalView r104 = r101;
        ExternalViewGroupAction r105 = r102;
        Intrinsics.checkNotNullParameter(r103, "p1");
        Intrinsics.checkNotNullParameter(r104, "p2");
        Intrinsics.checkNotNullParameter(r105, "p3");
        Function3 r106 = this.f42782a;
        Intrinsics.checkNotNullParameter(r103, "$this$convert2EC");
        wd.f r107 = j.f42786b.a(r103);
        Intrinsics.checkNotNullParameter(r104, "$this$convert2EC");
        wd.e r108 = c.C0779c.f42773b.d(r104);
        int r109 = d.f42781a[r105.ordinal()];
        if (r109 != 1) goto L5;
        ECExternalViewGroupAction r110 = ECExternalViewGroupAction.Add;
    L10:
        r106.invoke(r107, r108, r110);
        return Unit.INSTANCE;
    L5:
        if (r109 != 2) goto L8;
        r110 = ECExternalViewGroupAction.Remove;
        goto L10
    L8:
        throw new NoWhenBranchMatchedException();
    }
}
