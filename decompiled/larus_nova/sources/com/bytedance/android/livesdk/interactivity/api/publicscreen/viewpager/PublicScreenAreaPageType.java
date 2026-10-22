package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageType;", "", "PublicScreen", "ChatChannel", "Square", "Empty", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenAreaPageType extends Enum<PublicScreenAreaPageType> {
    public static final PublicScreenAreaPageType ChatChannel = null;
    public static final PublicScreenAreaPageType Empty = null;
    public static final PublicScreenAreaPageType PublicScreen = null;
    public static final PublicScreenAreaPageType Square = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenAreaPageType[] f133662a = null;

    static {
        PublicScreenAreaPageType r100 = new PublicScreenAreaPageType("PublicScreen", 0);
        PublicScreen = r100;
        PublicScreenAreaPageType r101 = new PublicScreenAreaPageType("ChatChannel", 1);
        ChatChannel = r101;
        PublicScreenAreaPageType r102 = new PublicScreenAreaPageType("Square", 2);
        Square = r102;
        PublicScreenAreaPageType r103 = new PublicScreenAreaPageType("Empty", 3);
        Empty = r103;
        f133662a = new PublicScreenAreaPageType[]{r100, r101, r102, r103};
    }

    public static PublicScreenAreaPageType valueOf(String r100) {
        return (PublicScreenAreaPageType) r27.a.a(PublicScreenAreaPageType.class, r100);
    }

    public static PublicScreenAreaPageType[] values() {
        return (PublicScreenAreaPageType[]) f133662a.clone();
    }

    public PublicScreenAreaPageType(String r100, int r101) {
        super(r100, r101);
    }
}
