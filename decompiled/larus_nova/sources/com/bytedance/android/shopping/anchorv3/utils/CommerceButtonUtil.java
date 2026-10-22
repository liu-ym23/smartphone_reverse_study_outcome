package com.bytedance.android.shopping.anchorv3.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
public final class CommerceButtonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165296a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/utils/CommerceButtonUtil$ButtonStatus;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CAN_BUY", "SELL_OUT", "PRE_SELL", "OFF_SALE", "SEC_KILL", "APPOINTMENT", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ButtonStatus extends Enum<ButtonStatus> {
        public static final ButtonStatus APPOINTMENT = null;
        public static final ButtonStatus CAN_BUY = null;
        public static final ButtonStatus OFF_SALE = null;
        public static final ButtonStatus PRE_SELL = null;
        public static final ButtonStatus SEC_KILL = null;
        public static final ButtonStatus SELL_OUT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ButtonStatus[] f165297a = null;
        private final String type;

        static {
            ButtonStatus r100 = new ButtonStatus("CAN_BUY", 0, "0");
            CAN_BUY = r100;
            ButtonStatus r101 = new ButtonStatus("SELL_OUT", 1, "1");
            SELL_OUT = r101;
            ButtonStatus r102 = new ButtonStatus("PRE_SELL", 2, "2");
            PRE_SELL = r102;
            ButtonStatus r103 = new ButtonStatus("OFF_SALE", 3, "3");
            OFF_SALE = r103;
            ButtonStatus r104 = new ButtonStatus("SEC_KILL", 4, "4");
            SEC_KILL = r104;
            ButtonStatus r105 = new ButtonStatus("APPOINTMENT", 5, "5");
            APPOINTMENT = r105;
            f165297a = new ButtonStatus[]{r100, r101, r102, r103, r104, r105};
        }

        public static ButtonStatus valueOf(String r100) {
            return (ButtonStatus) r27.a.a(ButtonStatus.class, r100);
        }

        public static ButtonStatus[] values() {
            return (ButtonStatus[]) f165297a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public ButtonStatus(String r100, int r101, String r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    static {
    }
}
