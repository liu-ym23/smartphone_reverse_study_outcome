package com.bytedance.android.live.liveinteract.api.chatroom.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0087\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/liveinteract/api/chatroom/model/LinkMatchType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, UserProfileEvent.POSITION_NONE, "MATCH", "SHAKE_MATCH", "SING_MATCH", "MORE", "AGAIN_MATCH", "AGAIN_SHAKE", "MORE_ROOM", "RECOMMEND_ROOM", "TRY_AGAIN", "linkbase-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LinkMatchType extends Enum<LinkMatchType> {
    public static final LinkMatchType AGAIN_MATCH = null;
    public static final LinkMatchType AGAIN_SHAKE = null;
    public static final a Companion = null;
    public static final LinkMatchType MATCH = null;
    public static final LinkMatchType MORE = null;
    public static final LinkMatchType MORE_ROOM = null;
    public static final LinkMatchType NONE = null;
    public static final LinkMatchType RECOMMEND_ROOM = null;
    public static final LinkMatchType SHAKE_MATCH = null;
    public static final LinkMatchType SING_MATCH = null;
    public static final LinkMatchType TRY_AGAIN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LinkMatchType[] f71430a = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LinkMatchType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            LinkMatchType r101 = LinkMatchType.MATCH;
            if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L19;
            LinkMatchType r102 = LinkMatchType.SHAKE_MATCH;
            if (Intrinsics.areEqual(r100, r102.getValue()) == true) goto L20;
            LinkMatchType r103 = LinkMatchType.SING_MATCH;
            if (Intrinsics.areEqual(r100, r103.getValue()) == true) goto L21;
            LinkMatchType r104 = LinkMatchType.TRY_AGAIN;
            if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L22;
            LinkMatchType r105 = LinkMatchType.RECOMMEND_ROOM;
            if (Intrinsics.areEqual(r100, r105.getValue()) == false) goto L18;
            return r105;
        L18:
            return LinkMatchType.NONE;
        L22:
            return r104;
        L21:
            return r103;
        L20:
            return r102;
        L19:
            return r101;
        }
    }

    @JvmStatic
    public static final LinkMatchType getMatchType(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static LinkMatchType valueOf(String r100) {
        return (LinkMatchType) r27.a.a(LinkMatchType.class, r100);
    }

    public static LinkMatchType[] values() {
        return (LinkMatchType[]) f71430a.clone();
    }

    static {
        LinkMatchType r100 = new LinkMatchType(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        LinkMatchType r101 = new LinkMatchType("MATCH", 1, "match");
        MATCH = r101;
        LinkMatchType r102 = new LinkMatchType("SHAKE_MATCH", 2, "shake_match");
        SHAKE_MATCH = r102;
        LinkMatchType r103 = new LinkMatchType("SING_MATCH", 3, "sing_match");
        SING_MATCH = r103;
        LinkMatchType r104 = new LinkMatchType("MORE", 4, "more");
        MORE = r104;
        LinkMatchType r105 = new LinkMatchType("AGAIN_MATCH", 5, "again_match");
        AGAIN_MATCH = r105;
        LinkMatchType r106 = new LinkMatchType("AGAIN_SHAKE", 6, "again_shake");
        AGAIN_SHAKE = r106;
        LinkMatchType r107 = new LinkMatchType("MORE_ROOM", 7, "more_room");
        MORE_ROOM = r107;
        LinkMatchType r108 = new LinkMatchType("RECOMMEND_ROOM", 8, "recommend_room");
        RECOMMEND_ROOM = r108;
        LinkMatchType r109 = new LinkMatchType("TRY_AGAIN", 9, "try_again");
        TRY_AGAIN = r109;
        f71430a = new LinkMatchType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    public LinkMatchType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
