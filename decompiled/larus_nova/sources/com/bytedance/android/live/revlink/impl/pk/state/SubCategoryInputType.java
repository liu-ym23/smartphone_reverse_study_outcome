package com.bytedance.android.live.revlink.impl.pk.state;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/state/SubCategoryInputType;", "", "InputUndefined", "InputRadio", "InputCheckBox", "InputText", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum SubCategoryInputType extends Enum<SubCategoryInputType> {
    public static final SubCategoryInputType InputCheckBox = null;
    public static final SubCategoryInputType InputRadio = null;
    public static final SubCategoryInputType InputText = null;
    public static final SubCategoryInputType InputUndefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SubCategoryInputType[] f96866a = null;

    static {
        SubCategoryInputType r100 = new SubCategoryInputType("InputUndefined", 0);
        InputUndefined = r100;
        SubCategoryInputType r101 = new SubCategoryInputType("InputRadio", 1);
        InputRadio = r101;
        SubCategoryInputType r102 = new SubCategoryInputType("InputCheckBox", 2);
        InputCheckBox = r102;
        SubCategoryInputType r103 = new SubCategoryInputType("InputText", 3);
        InputText = r103;
        f96866a = new SubCategoryInputType[]{r100, r101, r102, r103};
    }

    public static SubCategoryInputType valueOf(String r100) {
        return (SubCategoryInputType) a.a(SubCategoryInputType.class, r100);
    }

    public static SubCategoryInputType[] values() {
        return (SubCategoryInputType[]) f96866a.clone();
    }

    public SubCategoryInputType(String r100, int r101) {
        super(r100, r101);
    }
}
