package com.bytedance.android.live.base.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/base/model/HideMode;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UnknownMode", "HorizontalHide", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum HideMode extends Enum<HideMode> {
    public static final a Companion = null;
    public static final HideMode HorizontalHide = null;
    public static final HideMode UnknownMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HideMode[] f58822a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.live.base.model.HideMode$a] */
    static {
        HideMode r100 = new HideMode("UnknownMode", 0, 0);
        UnknownMode = r100;
        HideMode r101 = new HideMode("HorizontalHide", 1, 1);
        HorizontalHide = r101;
        f58822a = new HideMode[]{r100, r101};
        Companion = new a();
    }

    public static HideMode valueOf(String r100) {
        return (HideMode) r27.a.a(HideMode.class, r100);
    }

    public static HideMode[] values() {
        return (HideMode[]) f58822a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public HideMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
