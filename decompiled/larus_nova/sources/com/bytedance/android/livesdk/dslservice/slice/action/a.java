package com.bytedance.android.livesdk.dslservice.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.h;
import yt1.i;
import yt1.j;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, h> f122921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f122922b;

    public a(i r100) {
        this.f122922b = r100;
        this.f122921a = new HashMap();
    }

    @Override // yt1.i
    public final boolean a(IAction r100, View r101, j r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "targetView");
        Intrinsics.checkNotNullParameter(r102, "curTemplateHolder");
        i r103 = this.f122922b;
        if (r103 != null) goto L5;
    L7:
        h r104 = this.f122921a.get(r100.getType());
        if (r104 != null) goto L10;
        return false;
    L10:
        if ((r100 instanceof SlcCommonAction) == false) goto L12;
        ((SlcCommonAction) r100).getData();
        r104.b(r100.getParams(), r102);
    L12:
        return true;
    L5:
        if (r103.a(r100, r101, r102) != true) goto L7;
        return true;
    }
}
