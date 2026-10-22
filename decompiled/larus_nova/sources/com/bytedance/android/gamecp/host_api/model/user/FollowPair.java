package com.bytedance.android.gamecp.host_api.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public class FollowPair {

    @SerializedName("follow_status")
    public int followStatus;

    @SerializedName("prompts")
    public String prompts;

    public static final enum Type extends Enum<Type> {
        public static final Type Default = null;
        public static final Type FromWeb = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f57400a = null;

        static {
            Type r100 = new Type("Default", 0);
            Default = r100;
            Type r101 = new Type("FromWeb", 1);
            FromWeb = r101;
            f57400a = new Type[]{r100, r101};
        }

        public static Type[] values() {
            return (Type[]) f57400a.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public FollowPair() {
        Type r100 = Type.Default;
    }
}
