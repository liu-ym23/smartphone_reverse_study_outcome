package com.stepos.datacenter.entity;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/datacenter/entity/MediaType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "AUDIO", "VIDEO", "FILE", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MediaType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ MediaType[] $VALUES;
    public static final MediaType TEXT = new MediaType("TEXT", 0);
    public static final MediaType IMAGE = new MediaType("IMAGE", 1);
    public static final MediaType AUDIO = new MediaType("AUDIO", 2);
    public static final MediaType VIDEO = new MediaType("VIDEO", 3);
    public static final MediaType FILE = new MediaType("FILE", 4);

    private static final /* synthetic */ MediaType[] $values() {
        return new MediaType[]{TEXT, IMAGE, AUDIO, VIDEO, FILE};
    }

    static {
        MediaType[] mediaTypeArr$values = $values();
        $VALUES = mediaTypeArr$values;
        $ENTRIES = a.a(mediaTypeArr$values);
    }

    private MediaType(String str, int i10) {
    }

    public static InterfaceC4149a<MediaType> getEntries() {
        return $ENTRIES;
    }

    public static MediaType valueOf(String str) {
        return (MediaType) Enum.valueOf(MediaType.class, str);
    }

    public static MediaType[] values() {
        return (MediaType[]) $VALUES.clone();
    }
}
