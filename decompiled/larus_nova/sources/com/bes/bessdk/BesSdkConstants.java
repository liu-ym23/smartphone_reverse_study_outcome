package com.bes.bessdk;

import java.util.UUID;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final class BesSdkConstants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UUID f33662a = null;

    public static final enum BesConnectState extends Enum<BesConnectState> {
        public static final BesConnectState BES_CONFIG_ERROR = null;
        public static final BesConnectState BES_CONNECT = null;
        public static final BesConnectState BES_CONNECT_NOTOTA = null;
        public static final BesConnectState BES_CONNECT_TOTA = null;
        public static final BesConnectState BES_NO_CONNECT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BesConnectState[] f33663a = null;

        static {
            BesConnectState r100 = new BesConnectState("BES_CONFIG_ERROR", 0);
            BES_CONFIG_ERROR = r100;
            BesConnectState r101 = new BesConnectState("BES_NO_CONNECT", 1);
            BES_NO_CONNECT = r101;
            BesConnectState r102 = new BesConnectState("BES_CONNECT_NOTOTA", 2);
            BES_CONNECT_NOTOTA = r102;
            BesConnectState r103 = new BesConnectState("BES_CONNECT_TOTA", 3);
            BES_CONNECT_TOTA = r103;
            BesConnectState r104 = new BesConnectState("BES_CONNECT", 4);
            BES_CONNECT = r104;
            f33663a = new BesConnectState[]{r100, r101, r102, r103, r104};
        }

        public static BesConnectState[] values() {
            return (BesConnectState[]) f33663a.clone();
        }

        public static BesConnectState valueOf(String r100) {
            return (BesConnectState) a.a(BesConnectState.class, r100);
        }

        public BesConnectState(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        f33662a = UUID.fromString("66666666-6666-6666-6666-666666666666");
        UUID.fromString("77777777-7777-7777-7777-777777777777");
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        UUID.fromString("86868686-8686-8686-8686-868686868686");
        UUID.fromString("97979797-9797-9797-9797-979797979797");
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        UUID.fromString("01000100-0000-1000-8000-009078563412");
        UUID.fromString("03000300-0000-1000-8000-009278563412");
        UUID.fromString("02000200-0000-1000-8000-009178563412");
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        UUID.fromString("00001801-0000-1000-8000-00805f9b34fb");
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
        UUID.fromString("65786365-6c70-6f69-6e74-2e636f820000");
        UUID.fromString("65786365-6c70-6f69-6e74-2e636f820002");
        UUID.fromString("65786365-6c70-6f69-6e74-2e636f820001");
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }
}
