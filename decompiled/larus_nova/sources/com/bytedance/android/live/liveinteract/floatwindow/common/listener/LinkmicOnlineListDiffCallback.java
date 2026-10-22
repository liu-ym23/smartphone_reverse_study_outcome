package com.bytedance.android.live.liveinteract.floatwindow.common.listener;

import android.os.Bundle;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/liveinteract/floatwindow/common/listener/LinkmicOnlineListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkmicOnlineListDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f73305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Object> f73306b;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f73306b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f73305a.size();
    }

    public LinkmicOnlineListDiffCallback(List<? extends Object> r100, List<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldDatas");
        Intrinsics.checkNotNullParameter(r101, "newDatas");
        this.f73305a = r100;
        this.f73306b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        Object r102 = ListProtector.get(this.f73305a, r100);
        Object r103 = ListProtector.get(this.f73306b, r101);
        if ((!Intrinsics.areEqual(r102.getClass(), r103.getClass())) == false) goto L6;
        return false;
    L6:
        if ((r102 instanceof ILinkPlayerInfoBridge) == true) goto L8;
    L16:
        return false;
    L8:
        if ((r103 instanceof ILinkPlayerInfoBridge) == false) goto L16;
        ILinkPlayerInfoBridge r104 = (ILinkPlayerInfoBridge) r102;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r103;
        if (r104.getTalkState() == r105.getTalkState()) goto L12;
    L14:
        return false;
    L12:
        if (r104.getSilenceStatus() != r105.getSilenceStatus()) goto L14;
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        Object r102 = ListProtector.get(this.f73305a, r100);
        Object r103 = ListProtector.get(this.f73306b, r101);
        if ((!Intrinsics.areEqual(r102.getClass(), r103.getClass())) == false) goto L6;
        return false;
    L6:
        if ((r102 instanceof ILinkPlayerInfoBridge) == true) goto L8;
    L19:
        return true;
    L8:
        if ((r103 instanceof ILinkPlayerInfoBridge) == false) goto L19;
        IBaseUser r104 = ((ILinkPlayerInfoBridge) r102).getUser();
        String r105 = null;
        if (r104 == null) goto L12;
        String r106 = r104.getIdString();
    L13:
        IBaseUser r107 = ((ILinkPlayerInfoBridge) r103).getUser();
        if (r107 == null) goto L17;
        r105 = r107.getIdString();
    L17:
        if ((!Intrinsics.areEqual(r106, r105)) == false) goto L19;
        return false;
    L12:
        r106 = null;
        goto L13
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final Object getChangePayload(int r100, int r101) {
        Bundle r102 = new Bundle();
        Object r103 = ListProtector.get(this.f73305a, r100);
        Object r104 = ListProtector.get(this.f73306b, r101);
        if ((r103 instanceof ILinkPlayerInfoBridge) == true) goto L5;
    L12:
        return r102;
    L5:
        if ((r104 instanceof ILinkPlayerInfoBridge) == false) goto L12;
        ILinkPlayerInfoBridge r105 = (ILinkPlayerInfoBridge) r103;
        ILinkPlayerInfoBridge r106 = (ILinkPlayerInfoBridge) r104;
        if (r105.getTalkState() == r106.getTalkState()) goto L10;
        r102.putInt("payload_key_talk_state_change", r106.getTalkState());
    L10:
        if (r105.getSilenceStatus() == r106.getSilenceStatus()) goto L12;
        r102.putInt("payload_key_mute_state_change", r106.getSilenceStatus());
        goto L12
    }
}
