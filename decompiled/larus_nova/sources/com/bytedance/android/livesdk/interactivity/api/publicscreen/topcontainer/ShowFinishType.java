package com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/topcontainer/ShowFinishType;", "", EffectConstants.NORMAL, "TIMEOUT", "INTERRUPT", "DESTROY", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ShowFinishType extends Enum<ShowFinishType> {
    public static final ShowFinishType DESTROY = null;
    public static final ShowFinishType INTERRUPT = null;
    public static final ShowFinishType NORMAL = null;
    public static final ShowFinishType TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShowFinishType[] f133550a = null;

    static {
        ShowFinishType r100 = new ShowFinishType(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ShowFinishType r101 = new ShowFinishType("TIMEOUT", 1);
        TIMEOUT = r101;
        ShowFinishType r102 = new ShowFinishType("INTERRUPT", 2);
        INTERRUPT = r102;
        ShowFinishType r103 = new ShowFinishType("DESTROY", 3);
        DESTROY = r103;
        f133550a = new ShowFinishType[]{r100, r101, r102, r103};
    }

    public static ShowFinishType valueOf(String r100) {
        return (ShowFinishType) a.a(ShowFinishType.class, r100);
    }

    public static ShowFinishType[] values() {
        return (ShowFinishType[]) f133550a.clone();
    }

    public ShowFinishType(String r100, int r101) {
        super(r100, r101);
    }
}
