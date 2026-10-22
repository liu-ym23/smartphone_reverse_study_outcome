package com.stepos.ailauncher.sheet.internal;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/sheet/internal/K;", "", "<init>", "()V", "", "bottom", "bottomLimit", Const.INTENT_KEY_APIKEY, "(FF)F", "width", "height", "radius", Const.INTENT_KEY_PKGNAME, "(FFF)F", "BOTTOM_GAP_DP", "F", "sheet_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K {
    public static final float BOTTOM_GAP_DP = 5.0f;
    public static final K INSTANCE = new K();

    public final float a(float bottom, float bottomLimit) {
        return Math.min(0.0f, bottomLimit - bottom);
    }

    public final float b(float width, float height, float radius) {
        return C5685n.m(radius, 0.0f, C5685n.e(Math.min(width, height) * 0.5f, 0.0f));
    }
}
