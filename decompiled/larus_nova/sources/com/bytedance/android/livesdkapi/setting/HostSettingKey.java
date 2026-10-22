package com.bytedance.android.livesdkapi.setting;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/setting/HostSettingKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "LIVE_SAAS_CASH_EXCHANGE_ENABLE", "LIVE_SAAS_CASH_EXCHANGE_NEW_STYLE", "LIVE_SAAS_CASH_EXCHANGE_ENTER_TEXT", "LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TITLE", "LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TEXT", "LIVE_SAAS_CASH_EXCHANGE_TIPS", "LIVE_EXCHANGE_AUTHORIZE_ENABLE", "LIVE_EXCHANGE_AUTHORIZATION_ALERT_TEXT", "LIVE_SAAS_EXCHANGE_HOST_NAME", "LIVE_HARDWARE_DECODE_H264_ENABLE", "LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HostSettingKey extends Enum<HostSettingKey> {
    private static final /* synthetic */ HostSettingKey[] $VALUES = null;
    public static final HostSettingKey LIVE_EXCHANGE_AUTHORIZATION_ALERT_TEXT = null;
    public static final HostSettingKey LIVE_EXCHANGE_AUTHORIZE_ENABLE = null;
    public static final HostSettingKey LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE = null;
    public static final HostSettingKey LIVE_HARDWARE_DECODE_H264_ENABLE = null;
    public static final HostSettingKey LIVE_SAAS_CASH_EXCHANGE_ENABLE = null;
    public static final HostSettingKey LIVE_SAAS_CASH_EXCHANGE_ENTER_TEXT = null;
    public static final HostSettingKey LIVE_SAAS_CASH_EXCHANGE_NEW_STYLE = null;
    public static final HostSettingKey LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TEXT = null;
    public static final HostSettingKey LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TITLE = null;
    public static final HostSettingKey LIVE_SAAS_CASH_EXCHANGE_TIPS = null;
    public static final HostSettingKey LIVE_SAAS_EXCHANGE_HOST_NAME = null;
    private final String key;

    public static HostSettingKey valueOf(String r100) {
        return (HostSettingKey) a.a(HostSettingKey.class, r100);
    }

    public static HostSettingKey[] values() {
        return (HostSettingKey[]) $VALUES.clone();
    }

    static {
        HostSettingKey r100 = new HostSettingKey("LIVE_SAAS_CASH_EXCHANGE_ENABLE", 0, "live_saas_cash_exchange_enable");
        LIVE_SAAS_CASH_EXCHANGE_ENABLE = r100;
        HostSettingKey r101 = new HostSettingKey("LIVE_SAAS_CASH_EXCHANGE_NEW_STYLE", 1, "live_saas_cash_exchange_new_style");
        LIVE_SAAS_CASH_EXCHANGE_NEW_STYLE = r101;
        HostSettingKey r102 = new HostSettingKey("LIVE_SAAS_CASH_EXCHANGE_ENTER_TEXT", 2, "live_saas_cash_exchange_enter_text");
        LIVE_SAAS_CASH_EXCHANGE_ENTER_TEXT = r102;
        HostSettingKey r103 = new HostSettingKey("LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TITLE", 3, "live_saas_cash_exchange_pay_dialog_title");
        LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TITLE = r103;
        HostSettingKey r104 = new HostSettingKey("LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TEXT", 4, "live_saas_cash_exchange_pay_dialog_text");
        LIVE_SAAS_CASH_EXCHANGE_PAY_DIALOG_TEXT = r104;
        HostSettingKey r105 = new HostSettingKey("LIVE_SAAS_CASH_EXCHANGE_TIPS", 5, "live_saas_cash_exchange_tips");
        LIVE_SAAS_CASH_EXCHANGE_TIPS = r105;
        HostSettingKey r106 = new HostSettingKey("LIVE_EXCHANGE_AUTHORIZE_ENABLE", 6, "live_saas_cash_exchange_enable_authorize");
        LIVE_EXCHANGE_AUTHORIZE_ENABLE = r106;
        HostSettingKey r107 = new HostSettingKey("LIVE_EXCHANGE_AUTHORIZATION_ALERT_TEXT", 7, "live_saas_cash_exchange_authorize_alert_text");
        LIVE_EXCHANGE_AUTHORIZATION_ALERT_TEXT = r107;
        HostSettingKey r108 = new HostSettingKey("LIVE_SAAS_EXCHANGE_HOST_NAME", 8, "live_saas_exchange_host_name");
        LIVE_SAAS_EXCHANGE_HOST_NAME = r108;
        HostSettingKey r109 = new HostSettingKey("LIVE_HARDWARE_DECODE_H264_ENABLE", 9, "live_hardware_decode_h264_enable");
        LIVE_HARDWARE_DECODE_H264_ENABLE = r109;
        HostSettingKey r110 = new HostSettingKey("LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE", 10, "live_hardward_decode_bytevc1_enable");
        LIVE_HARDWARD_DECODE_BYTEVC1_ENABLE = r110;
        $VALUES = new HostSettingKey[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getKey() {
        return this.key;
    }

    private HostSettingKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
