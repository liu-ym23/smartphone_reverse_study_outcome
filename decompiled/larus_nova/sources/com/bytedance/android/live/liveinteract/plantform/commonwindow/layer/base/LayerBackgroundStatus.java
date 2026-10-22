package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/commonwindow/layer/base/LayerBackgroundStatus;", "", "Normal", ServiceType.AUDIO, "Leave", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LayerBackgroundStatus extends Enum<LayerBackgroundStatus> {
    public static final LayerBackgroundStatus Audio = null;
    public static final LayerBackgroundStatus Leave = null;
    public static final LayerBackgroundStatus Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayerBackgroundStatus[] f75664a = null;

    static {
        LayerBackgroundStatus r100 = new LayerBackgroundStatus("Normal", 0);
        Normal = r100;
        LayerBackgroundStatus r101 = new LayerBackgroundStatus(ServiceType.AUDIO, 1);
        Audio = r101;
        LayerBackgroundStatus r102 = new LayerBackgroundStatus("Leave", 2);
        Leave = r102;
        f75664a = new LayerBackgroundStatus[]{r100, r101, r102};
    }

    public static LayerBackgroundStatus valueOf(String r100) {
        return (LayerBackgroundStatus) a.a(LayerBackgroundStatus.class, r100);
    }

    public static LayerBackgroundStatus[] values() {
        return (LayerBackgroundStatus[]) f75664a.clone();
    }

    public LayerBackgroundStatus(String r100, int r101) {
        super(r100, r101);
    }
}
