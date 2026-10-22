package com.bytedance.android.format.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/format/model/FormatLiveRoomType;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "SINGLE", "SHARED", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FormatLiveRoomType extends Enum<FormatLiveRoomType> {
    public static final a Companion = null;
    public static final FormatLiveRoomType SHARED = null;
    public static final FormatLiveRoomType SINGLE = null;
    public static final FormatLiveRoomType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatLiveRoomType[] f51338a = null;
    private final int value;

    /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.android.format.model.FormatLiveRoomType$a] */
    static {
        FormatLiveRoomType r100 = new FormatLiveRoomType("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        FormatLiveRoomType r101 = new FormatLiveRoomType("SINGLE", 1, 0);
        SINGLE = r101;
        FormatLiveRoomType r102 = new FormatLiveRoomType("SHARED", 2, 1);
        SHARED = r102;
        f51338a = new FormatLiveRoomType[]{r100, r101, r102};
        Companion = new a();
    }

    public static FormatLiveRoomType valueOf(String r100) {
        return (FormatLiveRoomType) r27.a.a(FormatLiveRoomType.class, r100);
    }

    public static FormatLiveRoomType[] values() {
        return (FormatLiveRoomType[]) f51338a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FormatLiveRoomType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
