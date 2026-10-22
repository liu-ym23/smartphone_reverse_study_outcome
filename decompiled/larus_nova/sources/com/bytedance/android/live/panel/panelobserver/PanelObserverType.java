package com.bytedance.android.live.panel.panelobserver;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/panel/panelobserver/PanelObserverType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CoverObserver", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PanelObserverType extends Enum<PanelObserverType> {
    public static final PanelObserverType CoverObserver = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PanelObserverType[] f85378a = null;
    private final String type;

    static {
        PanelObserverType r100 = new PanelObserverType();
        CoverObserver = r100;
        f85378a = new PanelObserverType[]{r100};
    }

    public PanelObserverType() {
        super("CoverObserver", 0);
        this.type = "CoverObserver";
    }

    public static PanelObserverType valueOf(String r100) {
        return (PanelObserverType) a.a(PanelObserverType.class, r100);
    }

    public static PanelObserverType[] values() {
        return (PanelObserverType[]) f85378a.clone();
    }

    public final String getType() {
        return this.type;
    }
}
