package com.bytedance.android.live.virtuallive.model;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
public final class VirtualXplayMessageFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f102645a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/virtuallive/model/VirtualXplayMessageFactory$VirtualAvatarAddedType;", "", "", "type", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "OWNED", "USER_ADDED", "SYSTEM_PRIORITY", "SYSTEM_NORMAL", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum VirtualAvatarAddedType extends Enum<VirtualAvatarAddedType> {
        public static final a Companion = null;
        public static final VirtualAvatarAddedType OWNED = null;
        public static final VirtualAvatarAddedType SYSTEM_NORMAL = null;
        public static final VirtualAvatarAddedType SYSTEM_PRIORITY = null;
        public static final VirtualAvatarAddedType UNKNOWN = null;
        public static final VirtualAvatarAddedType USER_ADDED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VirtualAvatarAddedType[] f102646a = null;
        private final int type;

        public static final class a {
            public a() {
            }
        }

        static {
            VirtualAvatarAddedType r100 = new VirtualAvatarAddedType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            VirtualAvatarAddedType r101 = new VirtualAvatarAddedType("OWNED", 1, 1);
            OWNED = r101;
            VirtualAvatarAddedType r102 = new VirtualAvatarAddedType("USER_ADDED", 2, 2);
            USER_ADDED = r102;
            VirtualAvatarAddedType r103 = new VirtualAvatarAddedType("SYSTEM_PRIORITY", 3, 3);
            SYSTEM_PRIORITY = r103;
            VirtualAvatarAddedType r104 = new VirtualAvatarAddedType("SYSTEM_NORMAL", 4, 4);
            SYSTEM_NORMAL = r104;
            f102646a = new VirtualAvatarAddedType[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        public static VirtualAvatarAddedType valueOf(String r100) {
            return (VirtualAvatarAddedType) r27.a.a(VirtualAvatarAddedType.class, r100);
        }

        public static VirtualAvatarAddedType[] values() {
            return (VirtualAvatarAddedType[]) f102646a.clone();
        }

        public static final /* synthetic */ int access$getType$p(VirtualAvatarAddedType r100) {
            return r100.type;
        }

        public VirtualAvatarAddedType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00052\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/virtuallive/model/VirtualXplayMessageFactory$VirtualAvatarType;", "", "", "type", "I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UNKNOWN", "FREE", "TIRAL", "PRIVATE", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum VirtualAvatarType extends Enum<VirtualAvatarType> {
        public static final a Companion = null;
        public static final VirtualAvatarType FREE = null;
        public static final VirtualAvatarType PRIVATE = null;
        public static final VirtualAvatarType TIRAL = null;
        public static final VirtualAvatarType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VirtualAvatarType[] f102647a = null;
        private final int type;

        public static final class a {
            public a() {
            }
        }

        static {
            VirtualAvatarType r100 = new VirtualAvatarType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            VirtualAvatarType r101 = new VirtualAvatarType("FREE", 1, 1);
            FREE = r101;
            VirtualAvatarType r102 = new VirtualAvatarType("TIRAL", 2, 2);
            TIRAL = r102;
            VirtualAvatarType r103 = new VirtualAvatarType("PRIVATE", 3, 3);
            PRIVATE = r103;
            f102647a = new VirtualAvatarType[]{r100, r101, r102, r103};
            Companion = new a();
        }

        public static VirtualAvatarType valueOf(String r100) {
            return (VirtualAvatarType) r27.a.a(VirtualAvatarType.class, r100);
        }

        public static VirtualAvatarType[] values() {
            return (VirtualAvatarType[]) f102647a.clone();
        }

        public static final /* synthetic */ int access$getType$p(VirtualAvatarType r100) {
            return r100.type;
        }

        public VirtualAvatarType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
    }
}
