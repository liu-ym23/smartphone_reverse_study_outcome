package com.bytedance.android.live.liveinteract.enlarge.dialog.diff;

import android.os.Bundle;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.enlarge.dialog.viewbinder.MultiEnlargeGuestSelectViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/enlarge/dialog/diff/MultiEnlargeSelectGuestDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiEnlargeSelectGuestDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MultiEnlargeGuestSelectViewBinder.b> f72775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<MultiEnlargeGuestSelectViewBinder.b> f72776b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f72776b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f72775a.size();
    }

    public MultiEnlargeSelectGuestDiffCallback(List<MultiEnlargeGuestSelectViewBinder.b> r100, List<MultiEnlargeGuestSelectViewBinder.b> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldDatas");
        Intrinsics.checkNotNullParameter(r101, "newDatas");
        this.f72775a = r100;
        this.f72776b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        MultiEnlargeGuestSelectViewBinder.b r102 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.f72775a, r100);
        MultiEnlargeGuestSelectViewBinder.b r103 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.f72776b, r101);
        if (r102.f72788a != r103.f72788a) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        MultiEnlargeGuestSelectViewBinder.b r102 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.f72775a, r100);
        MultiEnlargeGuestSelectViewBinder.b r103 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.f72776b, r101);
        String r104 = null;
        if (r102 == null) goto L9;
        ILinkPlayerInfoBridge r105 = r102.f72789b;
        if (r105 == null) goto L9;
        IBaseUser r106 = r105.getUser();
        if (r106 == null) goto L9;
        String r107 = r106.getIdString();
    L10:
        if (r103 == null) goto L17;
        ILinkPlayerInfoBridge r108 = r103.f72789b;
        if (r108 == null) goto L17;
        IBaseUser r109 = r108.getUser();
        if (r109 == null) goto L17;
        r104 = r109.getIdString();
    L17:
        if ((!Intrinsics.areEqual(r107, r104)) == false) goto L20;
        return false;
    L20:
        return true;
    L9:
        r107 = null;
        goto L10
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r100, int r101) {
        MultiEnlargeGuestSelectViewBinder.b r102 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.f72775a, r100);
        MultiEnlargeGuestSelectViewBinder.b r103 = (MultiEnlargeGuestSelectViewBinder.b) ListProtector.get(this.f72776b, r101);
        Bundle r104 = new Bundle();
        boolean r105 = r102.f72788a;
        boolean r106 = r103.f72788a;
        if (r105 == r106) goto L5;
        r104.putBoolean("payload_key_guest_selected_state_update", r106);
    L5:
        return r104;
    }
}
