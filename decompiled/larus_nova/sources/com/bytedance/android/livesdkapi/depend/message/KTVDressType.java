package com.bytedance.android.livesdkapi.depend.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/KTVDressType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "KTV_DRESS_TYPE_UNKNOWN", "KTV_DRESS_TYPE_TAG", "KTV_DRESS_TYPE_MIDI_SKIN", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KTVDressType extends Enum<KTVDressType> {
    private static final /* synthetic */ KTVDressType[] $VALUES = null;
    public static final KTVDressType KTV_DRESS_TYPE_MIDI_SKIN = null;
    public static final KTVDressType KTV_DRESS_TYPE_TAG = null;
    public static final KTVDressType KTV_DRESS_TYPE_UNKNOWN = null;
    private final int value;

    static {
        KTVDressType r100 = new KTVDressType("KTV_DRESS_TYPE_UNKNOWN", 0, 0);
        KTV_DRESS_TYPE_UNKNOWN = r100;
        KTVDressType r101 = new KTVDressType("KTV_DRESS_TYPE_TAG", 1, 1);
        KTV_DRESS_TYPE_TAG = r101;
        KTVDressType r102 = new KTVDressType("KTV_DRESS_TYPE_MIDI_SKIN", 2, 2);
        KTV_DRESS_TYPE_MIDI_SKIN = r102;
        $VALUES = new KTVDressType[]{r100, r101, r102};
    }

    public static KTVDressType valueOf(String r100) {
        return (KTVDressType) a.a(KTVDressType.class, r100);
    }

    public static KTVDressType[] values() {
        return (KTVDressType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    private KTVDressType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
