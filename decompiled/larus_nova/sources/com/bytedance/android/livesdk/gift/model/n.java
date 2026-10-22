package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.hihonor.honorid.core.data.UserInfo;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u0083\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0084\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R*\u0010\u0015\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0019\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\u001aj\b\u0012\u0004\u0012\u00020\u001b`\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010*\u001a\u00060#j\u0002`$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\b\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010.\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\b\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R$\u00102\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\b\u001a\u0004\b/\u0010\u0004\"\u0004\b0\u0010\u0006R$\u00106\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\b\u001a\u0004\b3\u0010\u0004\"\u0004\b4\u0010\u0006R&\u0010:\u001a\u00060#j\u0002`$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b9\u0010\b\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R&\u0010>\u001a\u00060#j\u0002`$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b=\u0010\b\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R&\u0010B\u001a\u00060#j\u0002`$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bA\u0010\b\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R$\u0010F\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\b\u001a\u0004\bC\u0010\u0004\"\u0004\bD\u0010\u0006R$\u0010M\u001a\u0004\u0018\u00010G8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bL\u0010\b\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR*\u0010Q\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bP\u0010\b\u001a\u0004\bN\u0010\u0011\"\u0004\bO\u0010\u0013R$\u0010U\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\bT\u0010\b\u001a\u0004\bR\u0010\u0004\"\u0004\bS\u0010\u0006R\"\u0010\\\u001a\u00020V8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b[\u0010\b\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR&\u0010`\u001a\u00060#j\u0002`$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b_\u0010\b\u001a\u0004\b]\u0010&\"\u0004\b^\u0010(RF\u0010i\u001a&\u0012\u0004\u0012\u00020b\u0012\b\u0012\u00060#j\u0002`$0aj\u0012\u0012\u0004\u0012\u00020b\u0012\b\u0012\u00060#j\u0002`$`c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bh\u0010\b\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001a\u0010m\u001a\u00020b8&X§\u0004¢\u0006\f\u0012\u0004\bl\u0010\b\u001a\u0004\bj\u0010kR\u001a\u0010p\u001a\u00020V8&X§\u0004¢\u0006\f\u0012\u0004\bo\u0010\b\u001a\u0004\bn\u0010XR\u001c\u0010u\u001a\u0004\u0018\u00010q8&X§\u0004¢\u0006\f\u0012\u0004\bt\u0010\b\u001a\u0004\br\u0010sR\u001a\u0010x\u001a\u00020b8&X§\u0004¢\u0006\f\u0012\u0004\bw\u0010\b\u001a\u0004\bv\u0010kR\u001a\u0010{\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bz\u0010\b\u001a\u0004\by\u0010\u0004R\"\u0010~\u001a\n\u0018\u00010\u000ej\u0004\u0018\u0001`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b}\u0010\b\u001a\u0004\b|\u0010\u0011R=\u0010\u0082\u0001\u001a\"\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u007f\u0018\u00010aj\u0010\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020\u007f\u0018\u0001`c8&X§\u0004¢\u0006\u000e\u0012\u0005\b\u0081\u0001\u0010\b\u001a\u0005\b\u0080\u0001\u0010e¨\u0006\u0085\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/n;", "Lvh7/c;", "", "getMainText", "()Ljava/lang/String;", "setMainText", "(Ljava/lang/String;)V", "getMainText$annotations", "()V", n.KEY_MAIN_TEXT, "getSubText", "setSubText", "getSubText$annotations", n.KEY_SUB_TEXT, "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIconImg", "()Lpy/k;", "setIconImg", "(Lpy/k;)V", "getIconImg$annotations", n.KEY_ICON_IMG, "getGiftDescribeImg", "setGiftDescribeImg", "getGiftDescribeImg$annotations", n.KEY_GIFT_DESCRIBE_IMG, "", "Lcom/bytedance/android/livesdk/gift/model/e3;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPluginsFlex", "()Ljava/util/List;", "setPluginsFlex", "(Ljava/util/List;)V", "getPluginsFlex$annotations", "pluginsFlex", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getTotalDiamonds", "()J", "setTotalDiamonds", "(J)V", "getTotalDiamonds$annotations", n.KEY_TOTAL_DIAMONDS, "getGiftCellIcon", "setGiftCellIcon", "getGiftCellIcon$annotations", "giftCellIcon", "getMainTextAfterSend", "setMainTextAfterSend", "getMainTextAfterSend$annotations", n.KEY_MAIN_TEXT_AFTER_SEND, "getCardName", "setCardName", "getCardName$annotations", "cardName", "getStartTime", "setStartTime", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getEndTime", "setEndTime", "getEndTime$annotations", "endTime", "getConfigId", "setConfigId", "getConfigId$annotations", "configId", "getConfigIdStr", "setConfigIdStr", "getConfigIdStr$annotations", "configIdStr", "Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "getLockInfo", "()Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "setLockInfo", "(Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;)V", "getLockInfo$annotations", "lockInfo", "getStatusIconImg", "setStatusIconImg", "getStatusIconImg$annotations", "statusIconImg", "getLabelText", "setLabelText", "getLabelText$annotations", "labelText", "", "getShowRemindDot", "()Z", "setShowRemindDot", "(Z)V", "getShowRemindDot$annotations", "showRemindDot", "getUpdateTime", "setUpdateTime", "getUpdateTime$annotations", UserInfo.UPDATE_TIME, "", "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getPageTypeToDefaultChoseActionMap", "()Ljava/util/Map;", "setPageTypeToDefaultChoseActionMap", "(Ljava/util/Map;)V", "getPageTypeToDefaultChoseActionMap$annotations", "pageTypeToDefaultChoseActionMap", "getCardType", "()I", "getCardType$annotations", "cardType", "getNotCache", "getNotCache$annotations", "notCache", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "getComboHintInfo", "()Lcom/bytedance/android/livesdk/gift/model/ComboHintInfo;", "getComboHintInfo$annotations", "comboHintInfo", "getGiftSelectedStyle", "getGiftSelectedStyle$annotations", "giftSelectedStyle", "getSendButtonText", "getSendButtonText$annotations", "sendButtonText", "getDynamicGiftIcon", "getDynamicGiftIcon$annotations", "dynamicGiftIcon", "Lcom/bytedance/android/livesdk/gift/model/b2;", "getDefaultGiftTextMap", "getDefaultGiftTextMap$annotations", "defaultGiftTextMap", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface n extends vh7.c<n> {
    public static final int CARD_TYPE_ANCHOR_DIY = 1;
    public static final int CARD_TYPE_DEFAULT = 0;
    public static final int CHANGE_PANEL_ICON_AFTER_SEND_CARD = 4;
    public static final int CHANGE_PANEL_ICON_BEFORE_SEND_CARD = 1;
    public static final int CHANGE_PANEL_ICON_NO_CARE_SEND_CARD = 16;
    public static final int CHANGE_PANEL_NAME_AFTER_SEND_CARD = 8;
    public static final int CHANGE_PANEL_NAME_BEFORE_SEND_CARD = 2;
    public static final int CHANGE_PANEL_NAME_NO_CARE_SEND_CARD = 32;
    public static final a Companion = null;
    public static final String KEY_GIFT_DESCRIBE_IMG = "giftDescribeImg";
    public static final String KEY_ICON_IMG = "iconImg";
    public static final String KEY_MAIN_TEXT = "mainText";
    public static final String KEY_MAIN_TEXT_AFTER_SEND = "mainTextAfterSend";
    public static final String KEY_MAIN_TEXT_COLOR = "mainTextColor";
    public static final String KEY_PLUGINS = "plugins";
    public static final String KEY_SUB_TEXT = "subText";
    public static final String KEY_SUB_TEXT_COLOR = "subTextColor";
    public static final String KEY_TOTAL_DIAMONDS = "totalDiamonds";
    public static final int USE_BASE_GIFT_DIAMOND = 64;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f126393a = null;

        public a() {
        }

        static {
            f126393a = new a();
        }

        public static boolean a(int r100, n r101) {
            if ((f(r100, r101) & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean b(int r100, n r101) {
            if ((f(r100, r101) & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public static boolean c(int r100, n r101) {
            if ((f(r100, r101) & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean d(int r100, n r101) {
            if ((f(r100, r101) & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean e(int r100, n r101) {
            if ((f(r100, r101) & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public static int f(int r100, n r101) {
            if (r101 == null) goto L8;
            Map<Integer, Long> r102 = r101.getPageTypeToDefaultChoseActionMap();
            if (r102 == null) goto L8;
            Long r103 = r102.get(Integer.valueOf(r100));
            if (r103 == null) goto L8;
            return (int) r103.longValue();
        L8:
            return 0;
        }

        public static boolean g(int r100, n r101) {
            if (r101 != null) goto L6;
            return false;
        L6:
            if ((f(r100, r101) & 64) != 64) goto L9;
            return true;
        L9:
            return false;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f126393a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "card_name")
    String getCardName();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE)
    int getCardType();

    @FieldName(name = "combo_hint_info")
    ComboHintInfo getComboHintInfo();

    @FieldName(name = "config_id")
    long getConfigId();

    @FieldName(name = "config_id_str")
    String getConfigIdStr();

    @FieldName(name = "default_gift_text")
    Map<Integer, b2> getDefaultGiftTextMap();

    @FieldName(name = "gift_icon_asset_img")
    py.k getDynamicGiftIcon();

    @FieldName(name = "end_time")
    long getEndTime();

    @FieldName(name = "gift_cell_icon")
    py.k getGiftCellIcon();

    @FieldName(name = "gift_describe_img")
    py.k getGiftDescribeImg();

    @FieldName(name = "gift_selected_style")
    int getGiftSelectedStyle();

    @FieldName(name = "icon_img")
    py.k getIconImg();

    @FieldName(name = "label_text")
    String getLabelText();

    @FieldName(name = "lock_info")
    CardLockInfo getLockInfo();

    @FieldName(name = "main_text")
    String getMainText();

    @FieldName(name = "main_text_after_send")
    String getMainTextAfterSend();

    @FieldName(name = "not_cache")
    boolean getNotCache();

    @FieldName(name = "tab_chose_action")
    Map<Integer, Long> getPageTypeToDefaultChoseActionMap();

    @FieldName(name = KEY_PLUGINS)
    List<e3> getPluginsFlex();

    @FieldName(name = "send_button_text")
    String getSendButtonText();

    @FieldName(name = "show_remind_point")
    boolean getShowRemindDot();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @FieldName(name = "status_icon_img")
    py.k getStatusIconImg();

    @FieldName(name = "sub_text")
    String getSubText();

    @FieldName(name = "total_diamonds")
    long getTotalDiamonds();

    @FieldName(name = "update_time")
    long getUpdateTime();

    @FieldName(name = "card_name#setter")
    void setCardName(String r100);

    @FieldName(name = "config_id#setter")
    void setConfigId(long r100);

    @FieldName(name = "config_id_str#setter")
    void setConfigIdStr(String r100);

    @FieldName(name = "end_time#setter")
    void setEndTime(long r100);

    @FieldName(name = "gift_cell_icon#setter")
    void setGiftCellIcon(py.k r100);

    @FieldName(name = "gift_describe_img#setter")
    void setGiftDescribeImg(py.k r100);

    @FieldName(name = "icon_img#setter")
    void setIconImg(py.k r100);

    @FieldName(name = "label_text#setter")
    void setLabelText(String r100);

    @FieldName(name = "lock_info#setter")
    void setLockInfo(CardLockInfo r100);

    @FieldName(name = "main_text#setter")
    void setMainText(String r100);

    @FieldName(name = "main_text_after_send#setter")
    void setMainTextAfterSend(String r100);

    @FieldName(name = "tab_chose_action#setter")
    void setPageTypeToDefaultChoseActionMap(Map<Integer, Long> r100);

    @FieldName(name = "plugins#setter")
    void setPluginsFlex(List<? extends e3> r100);

    @FieldName(name = "show_remind_point#setter")
    void setShowRemindDot(boolean r100);

    @FieldName(name = "start_time#setter")
    void setStartTime(long r100);

    @FieldName(name = "status_icon_img#setter")
    void setStatusIconImg(py.k r100);

    @FieldName(name = "sub_text#setter")
    void setSubText(String r100);

    @FieldName(name = "total_diamonds#setter")
    void setTotalDiamonds(long r100);

    @FieldName(name = "update_time#setter")
    void setUpdateTime(long r100);
}
