package com.bytedance.android.livesdk.interactivity.api.barrage.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/barrage/model/BarrageSettingArea;", "", "", "area", "I", "getArea", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CLOSE", "TOP", "HALF", "FULL", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum BarrageSettingArea extends Enum<BarrageSettingArea> {
    public static final BarrageSettingArea CLOSE = null;
    public static final a Companion = null;
    public static final BarrageSettingArea FULL = null;
    public static final BarrageSettingArea HALF = null;
    public static final BarrageSettingArea TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BarrageSettingArea[] f132887a = null;
    private final int area;

    public static final class a {
        public a() {
        }
    }

    static {
        BarrageSettingArea r100 = new BarrageSettingArea("CLOSE", 0, 0);
        CLOSE = r100;
        BarrageSettingArea r101 = new BarrageSettingArea("TOP", 1, 1);
        TOP = r101;
        BarrageSettingArea r102 = new BarrageSettingArea("HALF", 2, 2);
        HALF = r102;
        BarrageSettingArea r103 = new BarrageSettingArea("FULL", 3, 3);
        FULL = r103;
        f132887a = new BarrageSettingArea[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static BarrageSettingArea valueOf(String r100) {
        return (BarrageSettingArea) r27.a.a(BarrageSettingArea.class, r100);
    }

    public static BarrageSettingArea[] values() {
        return (BarrageSettingArea[]) f132887a.clone();
    }

    public final int getArea() {
        return this.area;
    }

    public BarrageSettingArea(String r100, int r101, int r102) {
        super(r100, r101);
        this.area = r102;
    }
}
