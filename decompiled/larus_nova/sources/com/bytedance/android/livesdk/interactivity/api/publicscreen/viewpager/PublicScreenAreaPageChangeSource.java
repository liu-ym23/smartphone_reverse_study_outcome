package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPageChangeSource;", "", "Init", "Manual", "PublicScreenComment", "ChannelCreate", "ChannelJoin", "ChannelReplyJoin", "ChannelQuit", "ManageDialog", "SecretChat", "TabClick", "PageInvalid", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenAreaPageChangeSource extends Enum<PublicScreenAreaPageChangeSource> {
    public static final PublicScreenAreaPageChangeSource ChannelCreate = null;
    public static final PublicScreenAreaPageChangeSource ChannelJoin = null;
    public static final PublicScreenAreaPageChangeSource ChannelQuit = null;
    public static final PublicScreenAreaPageChangeSource ChannelReplyJoin = null;
    public static final PublicScreenAreaPageChangeSource Init = null;
    public static final PublicScreenAreaPageChangeSource ManageDialog = null;
    public static final PublicScreenAreaPageChangeSource Manual = null;
    public static final PublicScreenAreaPageChangeSource PageInvalid = null;
    public static final PublicScreenAreaPageChangeSource PublicScreenComment = null;
    public static final PublicScreenAreaPageChangeSource SecretChat = null;
    public static final PublicScreenAreaPageChangeSource TabClick = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenAreaPageChangeSource[] f133661a = null;

    static {
        PublicScreenAreaPageChangeSource r100 = new PublicScreenAreaPageChangeSource("Init", 0);
        Init = r100;
        PublicScreenAreaPageChangeSource r101 = new PublicScreenAreaPageChangeSource("Manual", 1);
        Manual = r101;
        PublicScreenAreaPageChangeSource r102 = new PublicScreenAreaPageChangeSource("PublicScreenComment", 2);
        PublicScreenComment = r102;
        PublicScreenAreaPageChangeSource r103 = new PublicScreenAreaPageChangeSource("ChannelCreate", 3);
        ChannelCreate = r103;
        PublicScreenAreaPageChangeSource r104 = new PublicScreenAreaPageChangeSource("ChannelJoin", 4);
        ChannelJoin = r104;
        PublicScreenAreaPageChangeSource r105 = new PublicScreenAreaPageChangeSource("ChannelReplyJoin", 5);
        ChannelReplyJoin = r105;
        PublicScreenAreaPageChangeSource r106 = new PublicScreenAreaPageChangeSource("ChannelQuit", 6);
        ChannelQuit = r106;
        PublicScreenAreaPageChangeSource r107 = new PublicScreenAreaPageChangeSource("ManageDialog", 7);
        ManageDialog = r107;
        PublicScreenAreaPageChangeSource r108 = new PublicScreenAreaPageChangeSource("SecretChat", 8);
        SecretChat = r108;
        PublicScreenAreaPageChangeSource r109 = new PublicScreenAreaPageChangeSource("TabClick", 9);
        TabClick = r109;
        PublicScreenAreaPageChangeSource r110 = new PublicScreenAreaPageChangeSource("PageInvalid", 10);
        PageInvalid = r110;
        f133661a = new PublicScreenAreaPageChangeSource[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public static PublicScreenAreaPageChangeSource valueOf(String r100) {
        return (PublicScreenAreaPageChangeSource) r27.a.a(PublicScreenAreaPageChangeSource.class, r100);
    }

    public static PublicScreenAreaPageChangeSource[] values() {
        return (PublicScreenAreaPageChangeSource[]) f133661a.clone();
    }

    public PublicScreenAreaPageChangeSource(String r100, int r101) {
        super(r100, r101);
    }
}
