package com.bytedance.android.livesdkapi.depend.model.live;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AvatorLabelType;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAvatorLabelType;", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "AvatorLabelTypeNone", "AvatorLabelTypeName", "AvatorLabelTypeEarn", "AvatorLabelTypeDigg", "AvatorLabelTypeAuthentication", "AvatorLabelRichText", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AvatorLabelType extends Enum<AvatorLabelType> implements IAvatorLabelType {
    private static final /* synthetic */ AvatorLabelType[] $VALUES = null;
    public static final AvatorLabelType AvatorLabelRichText = null;
    public static final AvatorLabelType AvatorLabelTypeAuthentication = null;
    public static final AvatorLabelType AvatorLabelTypeDigg = null;
    public static final AvatorLabelType AvatorLabelTypeEarn = null;
    public static final AvatorLabelType AvatorLabelTypeName = null;
    public static final AvatorLabelType AvatorLabelTypeNone = null;
    private final int value;

    static {
        AvatorLabelType r100 = new AvatorLabelType("AvatorLabelTypeNone", 0, 0);
        AvatorLabelTypeNone = r100;
        AvatorLabelType r101 = new AvatorLabelType("AvatorLabelTypeName", 1, 1);
        AvatorLabelTypeName = r101;
        AvatorLabelType r102 = new AvatorLabelType("AvatorLabelTypeEarn", 2, 3);
        AvatorLabelTypeEarn = r102;
        AvatorLabelType r103 = new AvatorLabelType("AvatorLabelTypeDigg", 3, 4);
        AvatorLabelTypeDigg = r103;
        AvatorLabelType r104 = new AvatorLabelType("AvatorLabelTypeAuthentication", 4, 5);
        AvatorLabelTypeAuthentication = r104;
        AvatorLabelType r105 = new AvatorLabelType("AvatorLabelRichText", 5, 7);
        AvatorLabelRichText = r105;
        $VALUES = new AvatorLabelType[]{r100, r101, r102, r103, r104, r105};
    }

    public static AvatorLabelType valueOf(String r100) {
        return (AvatorLabelType) a.a(AvatorLabelType.class, r100);
    }

    public static AvatorLabelType[] values() {
        return (AvatorLabelType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private AvatorLabelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
