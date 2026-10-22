package com.bytedance.android.live.revlink.impl.mergepk.pkbase;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/pkbase/PKBizType;", "", "ClassicDouble", "ClassicMulti", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum PKBizType extends Enum<PKBizType> {
    public static final PKBizType ClassicDouble = null;
    public static final PKBizType ClassicMulti = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PKBizType[] f92679a = null;

    static {
        PKBizType r100 = new PKBizType("ClassicDouble", 0);
        ClassicDouble = r100;
        PKBizType r101 = new PKBizType("ClassicMulti", 1);
        ClassicMulti = r101;
        f92679a = new PKBizType[]{r100, r101};
    }

    public static PKBizType valueOf(String r100) {
        return (PKBizType) r27.a.a(PKBizType.class, r100);
    }

    public static PKBizType[] values() {
        return (PKBizType[]) f92679a.clone();
    }

    public PKBizType(String r100, int r101) {
        super(r100, r101);
    }
}
