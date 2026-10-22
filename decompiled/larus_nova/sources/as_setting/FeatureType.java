package as_setting;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public final enum FeatureType extends Enum<FeatureType> implements WireEnum {
    private static final /* synthetic */ FeatureType[] $VALUES = null;
    public static final ProtoAdapter<FeatureType> ADAPTER = null;
    public static final FeatureType DEFAULT = null;
    public static final FeatureType NAUTILUS = null;
    private final int value;

    static {
        FeatureType r100 = new FeatureType("DEFAULT", 0, 0);
        DEFAULT = r100;
        FeatureType r101 = new FeatureType("NAUTILUS", 1, 1);
        NAUTILUS = r101;
        $VALUES = new FeatureType[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(FeatureType.class);
    }

    public static FeatureType[] values() {
        return (FeatureType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FeatureType fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return NAUTILUS;
    L10:
        return DEFAULT;
    }

    public static FeatureType valueOf(String r100) {
        return (FeatureType) a.a(FeatureType.class, r100);
    }

    private FeatureType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
