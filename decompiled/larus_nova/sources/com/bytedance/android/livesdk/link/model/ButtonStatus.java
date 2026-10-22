package com.bytedance.android.livesdk.link.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/ButtonStatus;", "", "Normal", "Forbidden", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ButtonStatus extends Enum<ButtonStatus> {
    public static final ButtonStatus Forbidden = null;
    public static final ButtonStatus Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ButtonStatus[] f147021a = null;

    static {
        ButtonStatus r100 = new ButtonStatus("Normal", 0);
        Normal = r100;
        ButtonStatus r101 = new ButtonStatus("Forbidden", 1);
        Forbidden = r101;
        f147021a = new ButtonStatus[]{r100, r101};
    }

    public static ButtonStatus valueOf(String r100) {
        return (ButtonStatus) r27.a.a(ButtonStatus.class, r100);
    }

    public static ButtonStatus[] values() {
        return (ButtonStatus[]) f147021a.clone();
    }

    public ButtonStatus(String r100, int r101) {
        super(r100, r101);
    }
}
