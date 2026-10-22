package com.bytedance.android.live.base.api.push;

import r27.a;

/* JADX INFO: loaded from: classes45.dex */
public interface ILivePush {

    public static final enum ClickType extends Enum<ClickType> {
        public static final ClickType CLOSE = null;
        public static final ClickType LIVE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClickType[] f58813a = null;
        private final String value;

        static {
            ClickType r100 = new ClickType("LIVE", 0, "live");
            LIVE = r100;
            ClickType r101 = new ClickType("CLOSE", 1, "close");
            CLOSE = r101;
            f58813a = new ClickType[]{r100, r101};
        }

        public static ClickType[] values() {
            return (ClickType[]) f58813a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ClickType valueOf(String r100) {
            return (ClickType) a.a(ClickType.class, r100);
        }

        public ClickType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum PushType extends Enum<PushType> {
        public static final PushType CLOD_LAUNCH = null;
        public static final PushType SELF_DRIVING = null;
        public static final PushType VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PushType[] f58814a = null;
        private final int value;

        static {
            PushType r100 = new PushType("SELF_DRIVING", 0, 1);
            SELF_DRIVING = r100;
            PushType r101 = new PushType("CLOD_LAUNCH", 1, 2);
            CLOD_LAUNCH = r101;
            PushType r102 = new PushType("VIDEO", 2, 3);
            VIDEO = r102;
            f58814a = new PushType[]{r100, r101, r102};
        }

        public static PushType[] values() {
            return (PushType[]) f58814a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static PushType valueOf(String r100) {
            return (PushType) a.a(PushType.class, r100);
        }

        public PushType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }
}
