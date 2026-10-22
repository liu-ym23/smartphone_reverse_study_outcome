package com.bytedance.android.livesdkapi.depend.model.live.follow;

import java.util.HashMap;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
public interface IFollowPair {
    public static final int BEEN_FOLLOWED = 3;
    public static final int EACH_FOLLOWED = 2;
    public static final int FOLLOW_APPLY_ING = 4;
    public static final int FOLLOW_BACK = 3;
    public static final int HAS_FOLLOWED = 1;
    public static final int NOT_FOLLOW = 0;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type Default = null;
        public static final Type FromWeb = null;

        static {
            Type r100 = new Type("Default", 0);
            Default = r100;
            Type r101 = new Type("FromWeb", 1);
            FromWeb = r101;
            $VALUES = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    HashMap<String, String> getExtraParams();

    int getFollowStatus();

    String getFromLabel();

    long getRoomId();

    String getSecUserId();

    Type getType();

    String getUrl();

    String getUserIdString();

    boolean isFollow();

    boolean isSyncFollow();

    void setExtraParams(HashMap<String, String> r100);

    void setFollow(boolean r100);

    void setFollowStatus(int r100);

    void setFromLabel(String r100);

    void setRoomId(long r100);

    void setSecUserId(String r100);

    void setType(Type r100);

    void setUrl(String r100);
}
