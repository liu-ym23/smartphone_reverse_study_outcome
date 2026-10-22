package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSCameraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSCameraInfo;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/CameraDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CameraDiffUtilCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<IVSCameraInfo> f159645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<IVSCameraInfo> f159646b;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return this.f159646b.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return this.f159645a.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraDiffUtilCallback(List<? extends IVSCameraInfo> r100, List<? extends IVSCameraInfo> r101) {
        Intrinsics.checkNotNullParameter(r100, "oldList");
        Intrinsics.checkNotNullParameter(r101, "newList");
        this.f159645a = r100;
        this.f159646b = r101;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        IVSCameraInfo r102 = (IVSCameraInfo) ListProtector.get(this.f159645a, r100);
        IVSCameraInfo r103 = (IVSCameraInfo) ListProtector.get(this.f159646b, r101);
        py.k r104 = r102.getCover();
        if (r104 != null) goto L5;
    L13:
        return false;
    L5:
        if (r104.equalsOnlyUri(r103.getCover()) != true) goto L13;
        if (Intrinsics.areEqual(r102.getTitle(), r103.getTitle()) == false) goto L13;
        boolean r105 = r102.viewRight();
        IMainVSCameraInfo r106 = (IMainVSCameraInfo) r103.castToOrNull(IMainVSCameraInfo.class);
        if (r106 == null) goto L13;
        if (r105 != r106.viewRight()) goto L13;
        return true;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        if (((IVSCameraInfo) ListProtector.get(this.f159645a, r100)).getCameraId() != ((IVSCameraInfo) ListProtector.get(this.f159646b, r101)).getCameraId()) goto L5;
        return true;
    L5:
        return false;
    }
}
