package com.obric.audiocodecsdk.encoder;

import kotlin.Metadata;

/* JADX INFO: compiled from: EncoderFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/audiocodecsdk/encoder/EncoderType;", "", "(Ljava/lang/String;I)V", "WAV", "AAC", "MP3", "UNKNOWN", "sdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum EncoderType extends Enum<EncoderType> {
    private static final /* synthetic */ EncoderType[] $VALUES = null;
    public static final EncoderType AAC = null;
    public static final EncoderType MP3 = null;
    public static final EncoderType UNKNOWN = null;
    public static final EncoderType WAV = null;

    private static final /* synthetic */ EncoderType[] $values() {
        return new EncoderType[]{WAV, AAC, MP3, UNKNOWN};
    }

    public static EncoderType valueOf(String r1) {
        return (EncoderType) Enum.valueOf(EncoderType.class, r1);
    }

    public static EncoderType[] values() {
        return (EncoderType[]) $VALUES.clone();
    }

    private EncoderType(String r1, int r2) {
        super(r1, r2);
    }

    static {
        WAV = new EncoderType("WAV", 0);
        AAC = new EncoderType("AAC", 1);
        MP3 = new EncoderType("MP3", 2);
        UNKNOWN = new EncoderType("UNKNOWN", 3);
        $VALUES = $values();
    }
}
