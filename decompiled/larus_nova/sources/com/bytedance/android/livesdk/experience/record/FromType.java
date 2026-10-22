package com.bytedance.android.livesdk.experience.record;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/experience/record/FromType;", "", "ContentResolver", "Display", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FromType extends Enum<FromType> {
    public static final FromType ContentResolver = null;
    public static final FromType Display = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FromType[] f123386a = null;

    static {
        FromType r100 = new FromType("ContentResolver", 0);
        ContentResolver = r100;
        FromType r101 = new FromType("Display", 1);
        Display = r101;
        f123386a = new FromType[]{r100, r101};
    }

    public static FromType valueOf(String r100) {
        return (FromType) a.a(FromType.class, r100);
    }

    public static FromType[] values() {
        return (FromType[]) f123386a.clone();
    }

    public FromType(String r100, int r101) {
        super(r100, r101);
    }
}
