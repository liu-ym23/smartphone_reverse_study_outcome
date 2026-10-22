package com.bytedance.android.live.revlink.impl.pk.dialog;

import android.view.View;
import com.bytedance.android.live.revlink.impl.pk.ui.PkItemExposeRecyclerView;
import com.bytedance.android.live.revlink.impl.pk.utils.FixedForAppBarLayoutManager;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchDataContext;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes47.dex */
public final class m<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkRandomMatchDialogV2 f95981a;

    public m(PkRandomMatchDialogV2 r100) {
        this.f95981a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        y31.k r101 = (y31.k) r100;
        if (r101 != null) goto L22;
        PkAutoMatchDataContext r102 = this.f95981a.f95457o;
        if (r102 == null) goto L7;
        List<?> r103 = r102.getMUserListWhenInvite();
    L8:
        if (r103 == null) goto L18;
        PkRandomMatchDialogV2 r104 = this.f95981a;
        r104.f95453k = r103;
        MultiTypeAdapter r105 = r104.f95452j;
        if (r105 == null) goto L12;
        r105.f513437a = r103;
    L12:
        View r106 = r104.f95455m;
        if (r106 == null) goto L15;
        r106.post(new l(this));
    L15:
        MultiTypeAdapter r107 = this.f95981a.f95452j;
        if (r107 == null) goto L18;
        r107.notifyDataSetChanged();
    L18:
        PkItemExposeRecyclerView r108 = this.f95981a.f95451i;
        if (r108 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
    L21:
        r108.setLayoutManager(new FixedForAppBarLayoutManager(this.f95981a.getContext()));
        return;
    L7:
        r103 = null;
        goto L8
    L22:
        PkRandomMatchDialogV2 r109 = this.f95981a;
        String r110 = PkRandomMatchDialogV2.f95446r;
        r109.Z90(r101, false);
    }
}
