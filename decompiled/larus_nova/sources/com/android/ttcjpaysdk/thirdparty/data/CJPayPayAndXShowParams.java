package com.android.ttcjpaysdk.thirdparty.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.base.ui.data.CJPayUIComponent;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.tencent.open.SocialConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0004\"#$%B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010 \u001a\u00020!R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R:\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "choose", "", "exts", "Lorg/json/JSONObject;", "exts_pb", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getExts_pb", "()Ljava/util/HashMap;", "setExts_pb", "(Ljava/util/HashMap;)V", "icon_url", "option_type", "show_check_box", "show_info_detail_list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$ShowInfo;", "Lkotlin/collections/ArrayList;", "show_type", BdpAppEventConstant.PARAMS_SUB_TITLE, "title", "title_component_list", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayUIComponent;", "type", "ui_control_config", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$UIControlConfig;", "voucher_label", "afterProtoDecode", "", "Companion", "ProtocolExts", "ShowInfo", "UIControlConfig", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPayAndXShowParams implements Serializable, CJPayObject {
    public static final Companion Companion = null;
    public static final String SHOW_TYPE_EASY_RECOMMEND = "easy_recommend";
    public static final String SHOW_TYPE_HIGH_RECOMMEND = "high_recommend";
    public boolean choose;
    public JSONObject exts;
    private HashMap<String, String> exts_pb;
    public String icon_url;
    public String option_type;
    public boolean show_check_box;
    public ArrayList<ShowInfo> show_info_detail_list;
    public String show_type;
    public String sub_title;
    public String title;
    public ArrayList<CJPayUIComponent> title_component_list;
    public String type;
    public UIControlConfig ui_control_config;
    public String voucher_label;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$Companion;", "", "()V", "SHOW_TYPE_EASY_RECOMMEND", "", "SHOW_TYPE_HIGH_RECOMMEND", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\nJ\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$ProtocolExts;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "guide_message", "", "protocol_group_names", "protocol_list", "getProtocolGroupNames", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getProtocolList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCardProtocolBean;", "Lkotlin/collections/ArrayList;", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ProtocolExts implements Serializable, CJPayObject {
        public String guide_message;
        public String protocol_group_names;
        public String protocol_list;

        public final HashMap<String, String> getProtocolGroupNames() {
            Map<String, String> r100 = KtSafeMethodExtensionKt.toMap(new JSONObject(this.protocol_group_names));     // Catch: Exception -> L9
            if ((r100 instanceof HashMap) == false) goto L5;
            HashMap<String, String> r101 = (HashMap) r100;     // Catch: Exception -> L9
        L6:
            if (r101 != null) goto L14;
            return new HashMap();
        L14:
            return r101;
        L5:
            r101 = null;
        L9:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayPayAndXShowParams#getProtocolGroupNames", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayPayAndXShowParams#getProtocolGroupNames", e);
            return new HashMap();
        }

        public final ArrayList<CJPayCardProtocolBean> getProtocolList() {
            final ArrayList<CJPayCardProtocolBean> r100 = new ArrayList();
            KtSafeMethodExtensionKt.forEach(new JSONArray(this.protocol_list), new CJPayPayAndXShowParams$ProtocolExts$getProtocolList$1(r100));     // Catch: Exception -> L5
        L7:
            return r100;
        L5:
            e = move-exception;
            CJBasicCommonUtils.reportCatchException("CJPayPayAndXShowParams#getProtocolList", e);
            CJBasicCommonUtils.logCatch("CJCatch", "CJPayPayAndXShowParams#getProtocolList", e);
            goto L7
        }

        public ProtocolExts() {
            this.guide_message = "";
            this.protocol_group_names = "";
            this.protocol_list = "";
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$ShowInfo;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", SocialConstants.PARAM_APP_DESC, "", "if_append_agreement", "", "name", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ShowInfo implements Serializable, CJPayObject {
        public String desc;
        public boolean if_append_agreement;
        public String name;

        public ShowInfo() {
            this.name = "";
            this.desc = "";
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$UIControlConfig;", "Ljava/io/Serializable;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "()V", "blue_v_enabled", "", "recommend_voucher_display_style", "shouldShowBlueV", "", "Companion", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class UIControlConfig implements Serializable, CJPayObject {
        public static final Companion Companion = null;
        public static final String VOUCHER_POSITION_TAG = "tag";
        public static final String VOUCHER_POSITION_TITLE_APPEND = "title_append";
        public String blue_v_enabled;
        public String recommend_voucher_display_style;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPayAndXShowParams$UIControlConfig$Companion;", "", "()V", "VOUCHER_POSITION_TAG", "", "VOUCHER_POSITION_TITLE_APPEND", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public final boolean shouldShowBlueV() {
            return Intrinsics.areEqual(this.blue_v_enabled, "1");
        }

        public UIControlConfig() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final void afterProtoDecode() {
        HashMap<String, String> r100 = this.exts_pb;
        if (r100 != null) goto L5;
    L10:
        JSONObject r101 = null;
    L11:
        this.exts = r101;
        this.exts_pb = null;
        return;
    L5:
        if ((!r100.isEmpty()) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r101 = new JSONObject(r100);
        goto L11
    }

    public CJPayPayAndXShowParams() {
        this.type = "";
        this.show_type = "";
        this.title = "";
        this.sub_title = "";
        this.icon_url = "";
        this.choose = true;
        this.voucher_label = "";
    }

    public final HashMap<String, String> getExts_pb() {
        return this.exts_pb;
    }

    public final void setExts_pb(HashMap<String, String> r100) {
        this.exts_pb = r100;
    }
}
