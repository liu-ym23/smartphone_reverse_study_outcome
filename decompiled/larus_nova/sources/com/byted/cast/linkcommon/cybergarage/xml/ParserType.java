package com.byted.cast.linkcommon.cybergarage.xml;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public final enum ParserType extends Enum<ParserType> {
    private static final /* synthetic */ ParserType[] $VALUES = null;
    public static final ParserType DEVICE = null;
    public static final ParserType SERVICE = null;
    private final String typeName;

    static {
        ParserType r100 = new ParserType(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, 0, "device");
        DEVICE = r100;
        ParserType r101 = new ParserType(HTTP.SERVICE, 1, "service");
        SERVICE = r101;
        $VALUES = new ParserType[]{r100, r101};
    }

    public static ParserType[] values() {
        return (ParserType[]) $VALUES.clone();
    }

    public String getTypeName() {
        return this.typeName;
    }

    public static ParserType valueOf(String r100) {
        return (ParserType) a.a(ParserType.class, r100);
    }

    private ParserType(String r100, int r101, String r102) {
        super(r100, r101);
        this.typeName = r102;
    }
}
