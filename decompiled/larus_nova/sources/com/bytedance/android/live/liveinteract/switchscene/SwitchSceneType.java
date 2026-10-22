package com.bytedance.android.live.liveinteract.switchscene;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/switchscene/SwitchSceneType;", "", "Request", ServiceType.IM, "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SwitchSceneType extends Enum<SwitchSceneType> {
    public static final SwitchSceneType Message = null;
    public static final SwitchSceneType Request = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchSceneType[] f78622a = null;

    static {
        SwitchSceneType r100 = new SwitchSceneType("Request", 0);
        Request = r100;
        SwitchSceneType r101 = new SwitchSceneType(ServiceType.IM, 1);
        Message = r101;
        f78622a = new SwitchSceneType[]{r100, r101};
    }

    public static SwitchSceneType valueOf(String r100) {
        return (SwitchSceneType) a.a(SwitchSceneType.class, r100);
    }

    public static SwitchSceneType[] values() {
        return (SwitchSceneType[]) f78622a.clone();
    }

    public SwitchSceneType(String r100, int r101) {
        super(r100, r101);
    }
}
