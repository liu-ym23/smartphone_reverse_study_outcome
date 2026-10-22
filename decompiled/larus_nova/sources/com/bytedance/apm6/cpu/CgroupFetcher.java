package com.bytedance.apm6.cpu;

import android.os.Process;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final class CgroupFetcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f190761a = 0;

    public static final enum CGROUP_LEVEL extends Enum<CGROUP_LEVEL> {
        public static final CGROUP_LEVEL BACKGROUND = null;
        public static final CGROUP_LEVEL FOREGROUND = null;
        public static final CGROUP_LEVEL TOP_APP = null;
        public static final CGROUP_LEVEL UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CGROUP_LEVEL[] f190762a = null;
        private final int value;

        static {
            CGROUP_LEVEL r100 = new CGROUP_LEVEL("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            CGROUP_LEVEL r101 = new CGROUP_LEVEL("TOP_APP", 1, 0);
            TOP_APP = r101;
            CGROUP_LEVEL r102 = new CGROUP_LEVEL("FOREGROUND", 2, 1);
            FOREGROUND = r102;
            CGROUP_LEVEL r103 = new CGROUP_LEVEL("BACKGROUND", 3, 2);
            BACKGROUND = r103;
            f190762a = new CGROUP_LEVEL[]{r100, r101, r102, r103};
        }

        public static CGROUP_LEVEL[] values() {
            return (CGROUP_LEVEL[]) f190762a.clone();
        }

        public static CGROUP_LEVEL valueOf(int r100) {
            if (r100 == (-1)) goto L18;
            if (r100 == 0) goto L16;
            if (r100 == 1) goto L14;
            if (r100 == 2) goto L12;
            return UNKNOWN;
        L12:
            return BACKGROUND;
        L14:
            return FOREGROUND;
        L16:
            return TOP_APP;
        L18:
            return UNKNOWN;
        }

        public static CGROUP_LEVEL valueOf(String r100) {
            return (CGROUP_LEVEL) a.a(CGROUP_LEVEL.class, r100);
        }

        public CGROUP_LEVEL(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f190761a = Process.myPid();
    }
}
