package com.bytedanceos.common.ad.param;

/* JADX INFO: loaded from: classes2.dex */
public class AdReportParam {

    public static class ClickPosType {
        public static final String IMAGE = "1";
        public static final String SKIP = "0";

        public ClickPosType() {
        }
    }

    public static final enum Event extends Enum<Event> {
        private static final /* synthetic */ Event[] $VALUES = null;
        public static final Event SPLASH_CLICK = null;
        public static final Event SPLASH_EXPOSURE = null;
        private String clickPosType;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f9585id;
        private String name;

        private static /* synthetic */ Event[] $values() {
            return new Event[]{SPLASH_EXPOSURE, SPLASH_CLICK};
        }

        static {
            SPLASH_EXPOSURE = new Event("SPLASH_EXPOSURE", 0, "S020015", "Server_AppMall_OpenScreenExposure");
            SPLASH_CLICK = new Event("SPLASH_CLICK", 1, "S020016", "Server_AppMall_OpenScreenClick");
            $VALUES = $values();
        }

        private Event(String r10, int r11, String r12, String r13) {
            super(r10, r11);
            this.clickPosType = "";
            this.f9585id = r12;
            this.name = r13;
        }

        public static Event valueOf(String r10) {
            return (Event) Enum.valueOf(Event.class, r10);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public String getClickPosType() {
            return this.clickPosType;
        }

        public String getId() {
            return this.f9585id;
        }

        public String getName() {
            return this.name;
        }

        public void setClickPosType(String r10) {
            this.clickPosType = r10;
        }

        public void setId(String r10) {
            this.f9585id = r10;
        }

        public void setName(String r10) {
            this.name = r10;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f9585id + "_" + this.name;
        }
    }

    public static class ProductName {
        public static final String APP_STORE = "Bytedance_App_AppStore";
        public static final String GAME_STORE = "Bytedance_App_GameStore";

        public ProductName() {
        }
    }

    public AdReportParam() {
    }
}
