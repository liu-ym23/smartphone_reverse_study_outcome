package com.bytedance.android.live.ktv.common.karaokestation.view.secondleveltab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.commonui.CustomViewTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.livesdk.r3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e extends me.drakeet.multitype.b<y, SecondLevelTabItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Context, CustomViewTab> f69719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<y, Unit> f69720c;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Function1<? super Context, CustomViewTab> r100, Function1<? super y, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "createCustomViewTabAction");
        this.f69719b = r100;
        this.f69720c = r101;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, y r101) {
        SecondLevelTabItemViewHolder r102 = (SecondLevelTabItemViewHolder) r100;
        y r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "viewHolder");
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "data");
        r102.f69703b = r103;
        CustomViewTab r104 = r102.f69702a;
        if (r104 == null) goto L5;
        r104.setTabName(r103.f69579d);
    L5:
        CustomViewTab r105 = r102.f69702a;
        if (r105 != null) goto L8;
    L12:
        CustomViewTab r106 = null;
        if (r103.f69585j == false) goto L19;
        CustomViewTab r107 = r102.f69702a;
        if ((r107 instanceof View) == false) goto L18;
        r106 = r107;
    L18:
        r3.a(r106, "已选中" + r103.f69579d);
    L25:
        if (r103.f69585j == false) goto L29;
        CustomViewTab r108 = r102.f69702a;
        if (r108 == null) goto L33;
        r108.onSelected(true);
        return;
    L33:
        return;
    L29:
        CustomViewTab r109 = r102.f69702a;
        if (r109 == null) goto L35;
        r109.c4(true);
        return;
    L35:
        return;
    L19:
        CustomViewTab r110 = r102.f69702a;
        if ((r110 instanceof View) == false) goto L23;
        r106 = r110;
    L23:
        r3.a(r106, String.valueOf(r103.f69579d));
        goto L25
    L8:
        if (r103.f69590o == false) goto L10;
        int r111 = 0;
    L11:
        r105.G5(r111);
        goto L12
    L10:
        r111 = 8;
        goto L11
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SecondLevelTabItemViewHolder(this.f69719b.invoke(r101.getContext()), this.f69720c);
    }
}
