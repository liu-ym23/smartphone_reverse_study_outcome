package com.bytedance.android.livesdk.log.alog;

import com.bytedance.android.livesdkapi.depend.log.LogFilterName;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
public final enum TTLiveALogTag extends Enum<TTLiveALogTag> {
    public static final TTLiveALogTag Click = null;
    public static final TTLiveALogTag Exception = null;
    public static final TTLiveALogTag Feed = null;
    public static final TTLiveALogTag Gift = null;
    public static final TTLiveALogTag Msg = null;
    public static final TTLiveALogTag Net = null;
    public static final TTLiveALogTag Page = null;
    public static final TTLiveALogTag Pk = null;
    public static final TTLiveALogTag PullStream = null;
    public static final TTLiveALogTag PushStream = null;
    public static final TTLiveALogTag Recharge = null;
    public static final TTLiveALogTag Room = null;
    public static final TTLiveALogTag Screen_Shot = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TTLiveALogTag[] f153276a = null;
    public String info;

    static {
        TTLiveALogTag r100 = new TTLiveALogTag(LogFilterName.ROOM, 0, "ttlive_room");
        Room = r100;
        TTLiveALogTag r101 = new TTLiveALogTag("Gift", 1, "ttlive_gift");
        Gift = r101;
        TTLiveALogTag r102 = new TTLiveALogTag("PushStream", 2, "ttlive_pushstream");
        PushStream = r102;
        TTLiveALogTag r103 = new TTLiveALogTag("PullStream", 3, "ttlive_pullstream");
        PullStream = r103;
        TTLiveALogTag r104 = new TTLiveALogTag("Net", 4, "ttlive_net");
        Net = r104;
        TTLiveALogTag r105 = new TTLiveALogTag("Click", 5, "ttlive_click");
        Click = r105;
        TTLiveALogTag r110 = new TTLiveALogTag("Feed", 6, "ttlive_feed");
        Feed = r110;
        TTLiveALogTag r111 = new TTLiveALogTag("Msg", 7, "ttlive_msg");
        Msg = r111;
        TTLiveALogTag r112 = new TTLiveALogTag("Exception", 8, "ttlive_exception");
        Exception = r112;
        TTLiveALogTag r113 = new TTLiveALogTag("Page", 9, "ttlive_page");
        Page = r113;
        TTLiveALogTag r114 = new TTLiveALogTag("Recharge", 10, "ttlive_recharge");
        Recharge = r114;
        TTLiveALogTag r106 = new TTLiveALogTag("Pk", 11, "ttlive_pk");
        Pk = r106;
        TTLiveALogTag r107 = new TTLiveALogTag("Screen_Shot", 12, "ttlive_screenshot");
        Screen_Shot = r107;
        f153276a = new TTLiveALogTag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public static TTLiveALogTag[] values() {
        return (TTLiveALogTag[]) f153276a.clone();
    }

    public static TTLiveALogTag valueOf(String r100) {
        return (TTLiveALogTag) a.a(TTLiveALogTag.class, r100);
    }

    public TTLiveALogTag(String r100, int r101, String r102) {
        super(r100, r101);
        this.info = r102;
    }
}
