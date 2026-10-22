package com.bytedance.android.live.liveinteract.api.chatroom.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkApplyType;", "", "", "value", "I", "getValue", "()I", EffectConstants.NORMAL, "SONG", "MATCH", "CITY", "CITYSONG", "STRONG_REACH", "PREPARE_APPLY", "PUBLIC_AREA_COMMENT", "KTV_MULTI_CHORUS", "GUEST_LINK_AGAIN", "REAL_TIME_CHORUS_INVITE", "LINK_FROM_LINK_RESULT", "ANCHOR_POINT_ENTER", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkApplyType extends Enum<LinkApplyType> {
    public static final LinkApplyType ANCHOR_POINT_ENTER = null;
    public static final LinkApplyType CITY = null;
    public static final LinkApplyType CITYSONG = null;
    public static final LinkApplyType GUEST_LINK_AGAIN = null;
    public static final LinkApplyType KTV_MULTI_CHORUS = null;
    public static final LinkApplyType LINK_FROM_LINK_RESULT = null;
    public static final LinkApplyType MATCH = null;
    public static final LinkApplyType NORMAL = null;
    public static final LinkApplyType PREPARE_APPLY = null;
    public static final LinkApplyType PUBLIC_AREA_COMMENT = null;
    public static final LinkApplyType REAL_TIME_CHORUS_INVITE = null;
    public static final LinkApplyType SONG = null;
    public static final LinkApplyType STRONG_REACH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkApplyType[] f71429a = null;
    private final int value;

    public static LinkApplyType valueOf(String r100) {
        return (LinkApplyType) r27.a.a(LinkApplyType.class, r100);
    }

    public static LinkApplyType[] values() {
        return (LinkApplyType[]) f71429a.clone();
    }

    static {
        LinkApplyType r100 = new LinkApplyType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        LinkApplyType r101 = new LinkApplyType("SONG", 1, 1);
        SONG = r101;
        LinkApplyType r102 = new LinkApplyType("MATCH", 2, 2);
        MATCH = r102;
        LinkApplyType r103 = new LinkApplyType("CITY", 3, 4);
        CITY = r103;
        LinkApplyType r104 = new LinkApplyType("CITYSONG", 4, 5);
        CITYSONG = r104;
        LinkApplyType r105 = new LinkApplyType("STRONG_REACH", 5, 8);
        STRONG_REACH = r105;
        LinkApplyType r106 = new LinkApplyType("PREPARE_APPLY", 6, 32);
        PREPARE_APPLY = r106;
        LinkApplyType r107 = new LinkApplyType("PUBLIC_AREA_COMMENT", 7, 256);
        PUBLIC_AREA_COMMENT = r107;
        LinkApplyType r108 = new LinkApplyType("KTV_MULTI_CHORUS", 8, 512);
        KTV_MULTI_CHORUS = r108;
        LinkApplyType r109 = new LinkApplyType("GUEST_LINK_AGAIN", 9, 1024);
        GUEST_LINK_AGAIN = r109;
        LinkApplyType r110 = new LinkApplyType("REAL_TIME_CHORUS_INVITE", 10, 2048);
        REAL_TIME_CHORUS_INVITE = r110;
        LinkApplyType r111 = new LinkApplyType("LINK_FROM_LINK_RESULT", 11, 4096);
        LINK_FROM_LINK_RESULT = r111;
        LinkApplyType r112 = new LinkApplyType("ANCHOR_POINT_ENTER", 12, 8192);
        ANCHOR_POINT_ENTER = r112;
        f71429a = new LinkApplyType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    public LinkApplyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
