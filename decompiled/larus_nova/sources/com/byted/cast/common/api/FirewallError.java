package com.byted.cast.common.api;

/* JADX INFO: loaded from: classes39.dex */
public class FirewallError {
    public static final int CHK_RES_ALL_IN_BLOCKED = -5;
    public static final int CHK_RES_BONJOUR_ALL_IN_BLOCKED = -6;
    public static final int CHK_RES_BONJOUR_ALL_OUT_BLOCKED = -7;
    public static final int CHK_RES_BONJOUR_MIX_BLOCKED = -12;
    public static final int CHK_RES_BONJOUR_TCP_IN_BLOCKED = -10;
    public static final int CHK_RES_BONJOUR_TCP_OUT_BLOCKED = -11;
    public static final int CHK_RES_BONJOUR_UDP_IN_BLOCKED = -8;
    public static final int CHK_RES_BONJOUR_UDP_OUT_BLOCKED = -9;
    public static final int CHK_RES_MEDIASDK_ALL_IN_BLOCKED = -13;
    public static final int CHK_RES_MEDIASDK_ALL_OUT_BLOCKED = -14;
    public static final int CHK_RES_MEDIASDK_MIX_BLOCKED = -19;
    public static final int CHK_RES_MEDIASDK_TCP_IN_BLOCKED = -17;
    public static final int CHK_RES_MEDIASDK_TCP_OUT_BLOCKED = -18;
    public static final int CHK_RES_MEDIASDK_UDP_IN_BLOCKED = -15;
    public static final int CHK_RES_MEDIASDK_UDP_OUT_BLOCKED = -16;
    public static final int CHK_RES_MULTI_DIFF_ACTIVE = -4;
    public static final int CHK_RES_NOT_INSTALLED = -2;
    public static final int CHK_RES_NOT_RUNNING = -3;
    public static final int CHK_RES_PASS = 0;
    public static final int CHK_RES_SYS_ERROR = -1;
    public static final int FIREWALL_ERROR_ALL_IN_BLOCKED = 600005;
    public static final int FIREWALL_ERROR_BONJOUR_ALL_IN_BLOCKED = 600006;
    public static final int FIREWALL_ERROR_BONJOUR_ALL_OUT_BLOCKED = 600007;
    public static final int FIREWALL_ERROR_BONJOUR_MIX_BLOCKED = 600012;
    public static final int FIREWALL_ERROR_BONJOUR_TCP_IN_BLOCKED = 600010;
    public static final int FIREWALL_ERROR_BONJOUR_TCP_OUT_BLOCKED = 600011;
    public static final int FIREWALL_ERROR_BONJOUR_UDP_IN_BLOCKED = 600008;
    public static final int FIREWALL_ERROR_BONJOUR_UDP_OUT_BLOCKED = 600009;
    public static final int FIREWALL_ERROR_MEDIASDK_ALL_IN_BLOCKED = 600013;
    public static final int FIREWALL_ERROR_MEDIASDK_ALL_OUT_BLOCKED = 600014;
    public static final int FIREWALL_ERROR_MEDIASDK_MIX_BLOCKED = 600019;
    public static final int FIREWALL_ERROR_MEDIASDK_TCP_IN_BLOCKED = 600017;
    public static final int FIREWALL_ERROR_MEDIASDK_TCP_OUT_BLOCKED = 600018;
    public static final int FIREWALL_ERROR_MEDIASDK_UDP_IN_BLOCKED = 600015;
    public static final int FIREWALL_ERROR_MEDIASDK_UDP_OUT_BLOCKED = 600016;
    public static final int FIREWALL_ERROR_MULTI_DIFF_ACTIVE = 600004;
    public static final int FIREWALL_ERROR_NOT_INSTALLED = 600002;
    public static final int FIREWALL_ERROR_NOT_RUNNING = 600003;
    public static final int FIREWALL_ERROR_SYS_ERROR = 600001;
    public static final int FIREWALL_OK = 600000;

    public FirewallError() {
    }

    public static int getFirewallErr(int r100) {
        switch(r100) {
            case -19: goto L41;
            case -18: goto L39;
            case -17: goto L37;
            case -16: goto L35;
            case -15: goto L33;
            case -14: goto L31;
            case -13: goto L29;
            case -12: goto L27;
            case -11: goto L25;
            case -10: goto L23;
            case -9: goto L21;
            case -8: goto L19;
            case -7: goto L17;
            case -6: goto L15;
            case -5: goto L13;
            case -4: goto L11;
            case -3: goto L9;
            case -2: goto L7;
            case -1: goto L5;
            default: goto L3;
        };
    L3:
        return FIREWALL_OK;
    L5:
        return FIREWALL_ERROR_SYS_ERROR;
    L7:
        return FIREWALL_ERROR_NOT_INSTALLED;
    L9:
        return FIREWALL_ERROR_NOT_RUNNING;
    L11:
        return FIREWALL_ERROR_MULTI_DIFF_ACTIVE;
    L13:
        return FIREWALL_ERROR_ALL_IN_BLOCKED;
    L15:
        return FIREWALL_ERROR_BONJOUR_ALL_IN_BLOCKED;
    L17:
        return FIREWALL_ERROR_BONJOUR_ALL_OUT_BLOCKED;
    L19:
        return FIREWALL_ERROR_BONJOUR_UDP_IN_BLOCKED;
    L21:
        return FIREWALL_ERROR_BONJOUR_UDP_OUT_BLOCKED;
    L23:
        return FIREWALL_ERROR_BONJOUR_TCP_IN_BLOCKED;
    L25:
        return FIREWALL_ERROR_BONJOUR_TCP_OUT_BLOCKED;
    L27:
        return FIREWALL_ERROR_BONJOUR_MIX_BLOCKED;
    L29:
        return FIREWALL_ERROR_MEDIASDK_ALL_IN_BLOCKED;
    L31:
        return FIREWALL_ERROR_MEDIASDK_ALL_OUT_BLOCKED;
    L33:
        return FIREWALL_ERROR_MEDIASDK_UDP_IN_BLOCKED;
    L35:
        return FIREWALL_ERROR_MEDIASDK_UDP_OUT_BLOCKED;
    L37:
        return FIREWALL_ERROR_MEDIASDK_TCP_IN_BLOCKED;
    L39:
        return FIREWALL_ERROR_MEDIASDK_TCP_OUT_BLOCKED;
    L41:
        return FIREWALL_ERROR_MEDIASDK_MIX_BLOCKED;
    }

    public static String getFirewallErrorMsg(int r100) {
        switch(r100) {
            case -19: goto L41;
            case -18: goto L39;
            case -17: goto L37;
            case -16: goto L35;
            case -15: goto L33;
            case -14: goto L31;
            case -13: goto L29;
            case -12: goto L27;
            case -11: goto L25;
            case -10: goto L23;
            case -9: goto L21;
            case -8: goto L19;
            case -7: goto L17;
            case -6: goto L15;
            case -5: goto L13;
            case -4: goto L11;
            case -3: goto L9;
            case -2: goto L7;
            case -1: goto L5;
            default: goto L3;
        };
    L3:
        return "Firewall is not blocked";
    L5:
        return "Firewall system error, maybe env is ok";
    L7:
        return "Bonjour service not installed";
    L9:
        return "Bonjour service not running";
    L11:
        return "Firewall multi active networks, and policies are different，maybe env is ok";
    L13:
        return "Firewall block all in";
    L15:
        return "Firewall bonjour block all in";
    L17:
        return "Firewall bonjour block all out";
    L19:
        return "Firewall bonjour block udp in";
    L21:
        return "Firewall bonjour block udp out";
    L23:
        return "Firewall bonjour block tcp in";
    L25:
        return "Firewall bonjour block tcp out";
    L27:
        return "Firewall bonjour block mix";
    L29:
        return "Firewall mediasdk block all in";
    L31:
        return "Firewall mediasdk block all out";
    L33:
        return "Firewall mediasdk block udp in";
    L35:
        return "Firewall mediasdk block udp out";
    L37:
        return "Firewall mediasdk block tcp in";
    L39:
        return "Firewall mediasdk block tcp out";
    L41:
        return "Firewall mediasdk block mix";
    }

    public static boolean mayConnect(int r100) {
        if (r100 == (-5)) goto L7;
        switch(r100) {
            case -19: goto L9;
            case -18: goto L9;
            case -17: goto L9;
            case -16: goto L9;
            case -15: goto L9;
            case -14: goto L9;
            case -13: goto L9;
            default: goto L5;
        };
    L5:
        return true;
    L9:
        return false;
    L7:
        return false;
    }
}
