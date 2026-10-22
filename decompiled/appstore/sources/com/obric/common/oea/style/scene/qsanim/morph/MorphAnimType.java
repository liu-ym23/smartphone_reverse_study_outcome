package com.obric.common.oea.style.scene.qsanim.morph;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/morph/MorphAnimType;", "", "(Ljava/lang/String;I)V", "SCALE_UP", "SCALE_DOWN", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final enum MorphAnimType extends Enum<MorphAnimType> {
    private static final /* synthetic */ MorphAnimType[] $VALUES = null;
    public static final MorphAnimType SCALE_DOWN = null;
    public static final MorphAnimType SCALE_UP = null;

    static {
        MorphAnimType r10 = new MorphAnimType("SCALE_UP", 0);
        SCALE_UP = r10;
        MorphAnimType r11 = new MorphAnimType("SCALE_DOWN", 1);
        SCALE_DOWN = r11;
        $VALUES = new MorphAnimType[]{r10, r11};
    }

    private MorphAnimType(String r10, int r11) {
        super(r10, r11);
    }

    public static MorphAnimType valueOf(String r10) {
        return (MorphAnimType) Enum.valueOf(MorphAnimType.class, r10);
    }

    public static MorphAnimType[] values() {
        return (MorphAnimType[]) $VALUES.clone();
    }
}
