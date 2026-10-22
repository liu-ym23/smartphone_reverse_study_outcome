package com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import qt0.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/groupmember/GroupLiveMemberDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupLiveMemberDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f86521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<a> f86522b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f86522b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        List<a> r100 = this.f86521a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public GroupLiveMemberDiffCallback(List<a> r100, List<a> r101) {
        Intrinsics.checkNotNullParameter(r101, "newList");
        this.f86521a = r100;
        this.f86522b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        List<a> r102 = this.f86521a;
        Integer r103 = null;
        if (r102 == null) goto L9;
        a r104 = (a) ListProtector.get(r102, r100);
        if (r104 == null) goto L9;
        k r105 = r104.f534765b;
        if (r105 == null) goto L9;
        String r106 = r105.getUri();
    L10:
        k r107 = ((a) ListProtector.get(this.f86522b, r101)).f534765b;
        if (r107 == null) goto L13;
        String r108 = r107.getUri();
    L15:
        if (Intrinsics.areEqual(r106, r108) == false) goto L32;
        List<a> r109 = this.f86521a;
        if (r109 == null) goto L21;
        a r110 = (a) ListProtector.get(r109, r100);
        if (r110 == null) goto L21;
        String r111 = r110.f534766c;
    L23:
        if (Intrinsics.areEqual(r111, ((a) ListProtector.get(this.f86522b, r101)).f534766c) == false) goto L32;
        List<a> r112 = this.f86521a;
        if (r112 == null) goto L30;
        a r113 = (a) ListProtector.get(r112, r100);
        if (r113 == null) goto L30;
        r103 = r113.f534767d;
    L30:
        if (Intrinsics.areEqual(r103, ((a) ListProtector.get(this.f86522b, r101)).f534767d) == false) goto L32;
        return true;
    L21:
        r111 = null;
    L32:
        return false;
    L13:
        r108 = null;
    L9:
        r106 = null;
        goto L10
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        List<a> r102 = this.f86521a;
        if (r102 == null) goto L7;
        a r103 = (a) ListProtector.get(r102, r100);
        if (r103 == null) goto L7;
        String r104 = r103.f534764a;
    L9:
        return Intrinsics.areEqual(r104, ((a) ListProtector.get(this.f86522b, r101)).f534764a);
    L7:
        r104 = null;
        goto L9
    }
}
