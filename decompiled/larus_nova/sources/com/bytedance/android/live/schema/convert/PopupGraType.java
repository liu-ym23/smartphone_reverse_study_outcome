package com.bytedance.android.live.schema.convert;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/schema/convert/PopupGraType;", "", "BOTTOM", FlowDoraWifiScene.OTHER, "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PopupGraType extends Enum<PopupGraType> {
    public static final PopupGraType BOTTOM = null;
    public static final PopupGraType OTHER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PopupGraType[] f100510a = null;

    static {
        PopupGraType r100 = new PopupGraType("BOTTOM", 0);
        BOTTOM = r100;
        PopupGraType r101 = new PopupGraType(FlowDoraWifiScene.OTHER, 1);
        OTHER = r101;
        f100510a = new PopupGraType[]{r100, r101};
    }

    public static PopupGraType valueOf(String r100) {
        return (PopupGraType) a.a(PopupGraType.class, r100);
    }

    public static PopupGraType[] values() {
        return (PopupGraType[]) f100510a.clone();
    }

    public PopupGraType(String r100, int r101) {
        super(r100, r101);
    }
}
