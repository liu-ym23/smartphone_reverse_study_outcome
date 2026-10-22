package com.bytedance.android.livesdk.ktvapi.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/PanelType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "ORDER_SONG_PANEL", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PanelType extends Enum<PanelType> {
    public static final PanelType ORDER_SONG_PANEL = null;
    public static final PanelType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelType[] f142325a = null;
    private final String value;

    static {
        PanelType r100 = new PanelType("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        PanelType r101 = new PanelType("ORDER_SONG_PANEL", 1, com.bytedance.android.livesdk.logger.PanelType.ORDER_SONG_PANEL);
        ORDER_SONG_PANEL = r101;
        f142325a = new PanelType[]{r100, r101};
    }

    public static PanelType valueOf(String r100) {
        return (PanelType) a.a(PanelType.class, r100);
    }

    public static PanelType[] values() {
        return (PanelType[]) f142325a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public PanelType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
