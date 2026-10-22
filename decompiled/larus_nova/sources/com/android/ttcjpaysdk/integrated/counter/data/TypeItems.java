package com.android.ttcjpaysdk.integrated.counter.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.ui.data.UIComponent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class TypeItems implements CJPayObject {
    public String account;
    public String account_name;
    public String account_type;
    public SubPayTypeInfo creditPayTypeData;
    public ArrayList<DynamicSubTitleInfo> dynamic_sub_title;
    public GlobalPayTypeItemInfo global_paytype_item;
    public String icon_url;
    public int index;
    public String mark;
    public ArrayList<String> mark_array;
    public String mobile_mask;
    public String need_pwd;
    public PayTypeItemInfo paytype_item;
    public String paytype_item_info;
    public String ptcode;
    public JSONObject retain_info_v2;
    public HashMap<String, RetainInfoV2> retain_info_v2_map;
    public int sign_status;
    public int status;
    public String sub_title;
    public String sub_title_color;
    public String subway;
    public String tips_msg;
    public String title;
    public String tt_icon_url;
    public String tt_mark;
    public String tt_sub_title;
    public String tt_sub_title_icon;
    public String tt_title;

    public static class DefaultRetainInfo implements CJPayObject {
        public String bottomRetainButtonText;
        public String title;
        public String topRetainButtonText;

        public DefaultRetainInfo() {
            this.title = "";
            this.topRetainButtonText = "";
            this.bottomRetainButtonText = "";
        }
    }

    public static class DialogButtonInfo implements CJPayObject {
        public String action;
        public String leftLabel;
        public String rightLabel;

        public DialogButtonInfo() {
            this.rightLabel = "";
            this.leftLabel = "";
            this.action = "";
        }
    }

    public static class DialogSubPayTypeInfo implements CJPayObject {
        public String iconUrl;
        public int index;
        public String title;

        public DialogSubPayTypeInfo() {
            this.index = 0;
            this.iconUrl = "";
            this.title = "";
        }
    }

    public static class DialogVoucherMsg implements CJPayObject {
        public String color;
        public String msg;
        public String msgExt;
        public String type;

        public DialogVoucherMsg() {
            this.msg = "";
            this.color = "";
            this.type = "";
            this.msgExt = "";
        }
    }

    public static class RetainInfoV2 implements CJPayObject {
        public DefaultRetainInfo defaultRetainInfo;
        public String lynxSchema;
        public String retainEventReportPath;
        public String saasScene;
        public String type;
        public VoucherRetainInfo voucherRetainInfo;

        public RetainInfoV2() {
            this.type = "";
            this.lynxSchema = "";
            this.defaultRetainInfo = new DefaultRetainInfo();
            this.voucherRetainInfo = new VoucherRetainInfo();
            this.saasScene = "";
            this.retainEventReportPath = "";
        }
    }

    public static class RetainMsgV2 implements CJPayObject {
        public String iconUrl;
        public VoucherLabelPiece labelPiece;
        public String leftMsg;
        public String leftMsgType;
        public String rightMsg;
        public String tagMsg;
        public String tagPosition;
        public long voucherType;

        public RetainMsgV2() {
            this.leftMsg = "";
            this.leftMsgType = "";
            this.rightMsg = "";
            this.voucherType = 0;
            this.tagMsg = "";
            this.tagPosition = "";
            this.iconUrl = "";
            this.labelPiece = new VoucherLabelPiece();
        }
    }

    public static class RetainMsgV3 implements CJPayObject {
        public List<UIComponent> combineLeftMsgs;
        public List<UIComponent> combineTitle;
        public List<UIComponent> leftMsgs;
        public long promotionAmount;
        public long promotionAmountCombinePay;
        public List<UIComponent> rightMsgs;
        public List<UIComponent> subRightMsgs;
        public List<UIComponent> subTitle;
        public List<UIComponent> title;
        public Map<String, String> trackerParams;

        public RetainMsgV3() {
            this.title = new ArrayList();
            this.subTitle = new ArrayList();
            this.combineTitle = new ArrayList();
            this.leftMsgs = new ArrayList();
            this.combineLeftMsgs = new ArrayList();
            this.rightMsgs = new ArrayList();
            this.subRightMsgs = new ArrayList();
            this.promotionAmount = 0;
            this.promotionAmountCombinePay = 0;
            this.trackerParams = new HashMap();
        }
    }

    public static class RetainMsgV3List implements CJPayObject {
        public List<RetainMsgV3> list;

        public RetainMsgV3List() {
            this.list = new ArrayList();
        }
    }

    public static class VoucherLabelPiece implements CJPayObject {
        public long amount;
        public String amountDesc;
        public String amountPrefix;
        public String name;
        public String tagDesc;

        public VoucherLabelPiece() {
            this.name = "";
            this.tagDesc = "";
            this.amountPrefix = "";
            this.amountDesc = "";
            this.amount = 0;
        }
    }

    public static class VoucherRetainInfo implements CJPayObject {
        public String amount;
        public String bottomRetainButtonText;
        public DialogButtonInfo buttonInfo;
        public String cancelButtonType;
        public int countdown;
        public String countdownMsg;
        public String expandSucessMsg;
        public List<String> filterIndex;
        public String index;
        public Map<String, String> infoForMonitor;
        public String isCombinePay;
        public String isDiscount;
        public String mainMsg;
        public String mainPictureUrl;
        public String mark;
        public boolean noCloseIcon;
        public List<RetainMsgV2> retainMsgList;
        public String retainPlan;
        public List<UIComponent> retainQuestionnaire;
        public String retainType;
        public String style;
        public DialogSubPayTypeInfo subPayTypeInfo;
        public Map<String, RetainMsgV3List> subRetainMsgListPb;
        public String title;
        public String topRetainButtonAction;
        public String topRetainButtonText;
        public DialogVoucherMsg voucherMsg;

        public VoucherRetainInfo() {
            this.title = "";
            this.style = "";
            this.retainPlan = "";
            this.retainType = "";
            this.topRetainButtonText = "";
            this.retainMsgList = new ArrayList();
            this.isDiscount = "";
            this.filterIndex = new ArrayList();
            this.topRetainButtonAction = "";
            this.bottomRetainButtonText = "";
            this.infoForMonitor = new HashMap();
            this.index = "";
            this.isCombinePay = "";
            this.retainQuestionnaire = new ArrayList();
            this.noCloseIcon = false;
            this.countdown = 0;
            this.countdownMsg = "";
            this.expandSucessMsg = "";
            this.buttonInfo = new DialogButtonInfo();
            this.cancelButtonType = "";
            this.voucherMsg = new DialogVoucherMsg();
            this.mainPictureUrl = "";
            this.subPayTypeInfo = new DialogSubPayTypeInfo();
            this.mainMsg = "";
            this.mark = "";
            this.amount = "";
            this.subRetainMsgListPb = new HashMap();
        }
    }

    public void afterProtoDecode() {
        if (this.retain_info_v2_map == null) goto L6;
        this.retain_info_v2 = new JSONObject(this.retain_info_v2_map);
        this.retain_info_v2_map = null;
        return;
    }

    public TypeItems() {
        this.ptcode = "";
        this.index = -1;
        this.status = 0;
        this.subway = "";
        this.icon_url = "";
        this.title = "";
        this.sub_title = "";
        this.sub_title_color = "";
        this.dynamic_sub_title = new ArrayList();
        this.mark = "";
        this.mark_array = new ArrayList();
        this.tips_msg = "";
        this.need_pwd = "";
        this.tt_mark = "";
        this.mobile_mask = "";
        this.tt_title = "";
        this.tt_sub_title = "";
        this.tt_sub_title_icon = "";
        this.tt_icon_url = "";
        this.account_type = "";
        this.account = "";
        this.account_name = "";
        this.global_paytype_item = new GlobalPayTypeItemInfo();
        this.paytype_item = new PayTypeItemInfo();
        this.paytype_item_info = "";
        this.creditPayTypeData = new SubPayTypeInfo();
        this.sign_status = 0;
        this.retain_info_v2_map = null;
    }
}
