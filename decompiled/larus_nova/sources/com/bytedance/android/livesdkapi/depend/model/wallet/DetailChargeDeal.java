package com.bytedance.android.livesdkapi.depend.model.wallet;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class DetailChargeDeal {
    private JSONObject bizExtra;
    private int chargeOrderBusinessScene;
    private int chargeOrderSource;
    private String chargeReason;
    private String chargeScene;
    private String chargeStyle;
    private int combineAmount;
    private long customPrice;
    private long diamondId;
    private HashMap<String, String> extra;
    private Map<String, String> extraMap;
    private String functionType;
    private boolean hideStatusBar;
    private boolean iapPay;
    private String iapProductId;
    private String idStr;
    private boolean isFisrtCharge;
    private String liveType;
    private int noPasswordType;
    private String oneStepScene;
    private boolean openCombinePay;
    private long ownerUserId;
    private int price;
    private Map<String, String> queriesMap;
    private int rechargeDialogHeight;
    private String requestPage;
    private long roomId;
    private boolean selectCombinePay;
    private boolean showFastPay;
    private int totalDiamond;
    private String tradeName;
    private int tradeType;

    /* JADX INFO: renamed from: com.bytedance.android.livesdkapi.depend.model.wallet.DetailChargeDeal$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private JSONObject bizExtra;
        private int chargeOrderBusinessScene;
        private int chargeOrderSource;
        private String chargeReason;
        private String chargeScene;
        private String chargeStyle;
        private int combineAmount;
        private long customPrice;
        private long diamondId;
        private HashMap<String, String> extra;
        private Map<String, String> extraMap;
        private String functionType;
        private boolean hideStatusBar;
        private String iapProductId;
        private String idStr;
        private boolean isFirstCharge;
        private boolean isIapPay;
        private String liveType;
        private int noPasswordType;
        private String oneStepScene;
        private boolean openCombinePay;
        private long ownerUserId;
        private int price;
        private Map<String, String> queriesMap;
        private int rechargeDialogHeight;
        private String requestPage;
        private long roomId;
        private boolean selectCombinePay;
        private boolean showFastPay;
        private int totalDiamond;
        private String tradeName;
        private int tradeType;

        public DetailChargeDeal build() {
            DetailChargeDeal r100 = new DetailChargeDeal(null);
            r100.setCustomPrice(this.customPrice);
            r100.setDiamondId(this.diamondId);
            r100.setExtra(this.extra);
            r100.setBizExtra(this.bizExtra);
            r100.setHideStatusBar(this.hideStatusBar);
            r100.setRechargeDialogHeight(this.rechargeDialogHeight);
            r100.setChargeOrderBusinessScene(this.chargeOrderBusinessScene);
            r100.setChargeOrderSource(this.chargeOrderSource);
            r100.setShowFastPay(this.showFastPay);
            r100.setCombineAmount(this.combineAmount);
            r100.setOpenCombinePay(this.openCombinePay);
            r100.setSelectCombinePay(this.selectCombinePay);
            r100.setPrice(this.price);
            r100.setRequestPage(this.requestPage);
            r100.setRoomId(this.roomId);
            r100.setOwnerUserId(this.ownerUserId);
            r100.setIdStr(this.idStr);
            r100.setTradeName(this.tradeName);
            r100.setTradeType(this.tradeType);
            r100.setTotalDiamond(this.totalDiamond);
            r100.setChargeReason(this.chargeReason);
            r100.setChargeStyle(this.chargeStyle);
            r100.setChargeScene(this.chargeScene);
            r100.setLiveType(this.liveType);
            r100.setFunctionType(this.functionType);
            r100.setIsFirstCharge(this.isFirstCharge);
            r100.setIapProductId(this.iapProductId);
            r100.setIapPay(this.isIapPay);
            r100.setOneStepScene(this.oneStepScene);
            r100.setNoPasswordType(this.noPasswordType);
            r100.setQueriesMap(this.queriesMap);
            r100.setExtraMap(this.extraMap);
            return r100;
        }

        public Builder() {
        }

        public Builder bizExtra(JSONObject r100) {
            this.bizExtra = r100;
            return this;
        }

        public Builder chargeOrderBusinessScene(int r100) {
            this.chargeOrderBusinessScene = r100;
            return this;
        }

        public Builder chargeOrderSource(int r100) {
            this.chargeOrderSource = r100;
            return this;
        }

        public Builder chargeReason(String r100) {
            this.chargeReason = r100;
            return this;
        }

        public Builder chargeScene(String r100) {
            this.chargeScene = r100;
            return this;
        }

        public Builder chargeStyle(String r100) {
            this.chargeStyle = r100;
            return this;
        }

        public Builder combineAmount(int r100) {
            this.combineAmount = r100;
            return this;
        }

        public Builder customPrice(long r100) {
            this.customPrice = r100;
            return this;
        }

        public Builder diamondId(long r100) {
            this.diamondId = r100;
            return this;
        }

        public Builder extra(HashMap<String, String> r100) {
            this.extra = r100;
            return this;
        }

        public Builder extraMap(Map<String, String> r100) {
            this.extraMap = r100;
            return this;
        }

        public Builder functionType(String r100) {
            this.functionType = r100;
            return this;
        }

        public Builder hideStatusBar(boolean r100) {
            this.hideStatusBar = r100;
            return this;
        }

        public Builder iapProductId(String r100) {
            this.iapProductId = r100;
            return this;
        }

        public Builder idStr(String r100) {
            this.idStr = r100;
            return this;
        }

        public Builder isFirstCharge(boolean r100) {
            this.isFirstCharge = r100;
            return this;
        }

        public Builder isIapPay(boolean r100) {
            this.isIapPay = r100;
            return this;
        }

        public Builder liveType(String r100) {
            this.liveType = r100;
            return this;
        }

        public Builder noPasswordOrderType(int r100) {
            this.noPasswordType = r100;
            return this;
        }

        public Builder oneStepScene(String r100) {
            this.oneStepScene = r100;
            return this;
        }

        public Builder openCombinePay(boolean r100) {
            this.openCombinePay = r100;
            return this;
        }

        public Builder ownerUserId(long r100) {
            this.ownerUserId = r100;
            return this;
        }

        public Builder price(int r100) {
            this.price = r100;
            return this;
        }

        public Builder queriesMap(Map<String, String> r100) {
            this.queriesMap = r100;
            return this;
        }

        public Builder rechargeDialogHeight(int r100) {
            this.rechargeDialogHeight = r100;
            return this;
        }

        public Builder requestPage(String r100) {
            this.requestPage = r100;
            return this;
        }

        public Builder roomId(long r100) {
            this.roomId = r100;
            return this;
        }

        public Builder selectCombinePay(boolean r100) {
            this.selectCombinePay = r100;
            return this;
        }

        public Builder showFastPay(boolean r100) {
            this.showFastPay = r100;
            return this;
        }

        public Builder totalDiamond(int r100) {
            this.totalDiamond = r100;
            return this;
        }

        public Builder tradeName(String r100) {
            this.tradeName = r100;
            return this;
        }

        public Builder tradeType(int r100) {
            this.tradeType = r100;
            return this;
        }
    }

    private DetailChargeDeal() {
        this.noPasswordType = 0;
    }

    public JSONObject getBizExtra() {
        return this.bizExtra;
    }

    public int getChargeOrderBusinessScene() {
        return this.chargeOrderBusinessScene;
    }

    public int getChargeOrderSource() {
        return this.chargeOrderSource;
    }

    public String getChargeReason() {
        return this.chargeReason;
    }

    public String getChargeScene() {
        return this.chargeScene;
    }

    public String getChargeStyle() {
        return this.chargeStyle;
    }

    public int getCombineAmount() {
        return this.combineAmount;
    }

    public long getCustomPrice() {
        return this.customPrice;
    }

    public long getDiamondId() {
        return this.diamondId;
    }

    public HashMap<String, String> getExtra() {
        return this.extra;
    }

    public Map<String, String> getExtraMap() {
        return this.extraMap;
    }

    public String getFunctionType() {
        return this.functionType;
    }

    public String getIapProductId() {
        return this.iapProductId;
    }

    public String getIdStr() {
        return this.idStr;
    }

    public String getLiveType() {
        return this.liveType;
    }

    public int getNoPasswordType() {
        return this.noPasswordType;
    }

    public boolean getOpenCombinePay() {
        return this.openCombinePay;
    }

    public long getOwnerUserId() {
        return this.ownerUserId;
    }

    public int getPrice() {
        return this.price;
    }

    public Map<String, String> getQueriesMap() {
        return this.queriesMap;
    }

    public int getRechargeDialogHeight() {
        return this.rechargeDialogHeight;
    }

    public String getRequestPage() {
        return this.requestPage;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public boolean getSelectCombinePay() {
        return this.selectCombinePay;
    }

    public boolean getShowFastPay() {
        return this.showFastPay;
    }

    public int getTotalDiamond() {
        return this.totalDiamond;
    }

    public String getTradeName() {
        return this.tradeName;
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public boolean isFirstCharge() {
        return this.isFisrtCharge;
    }

    public boolean isHideStatusBar() {
        return this.hideStatusBar;
    }

    public boolean isIapPay() {
        return this.iapPay;
    }

    public String oneStepScene() {
        return this.oneStepScene;
    }

    public /* synthetic */ DetailChargeDeal(AnonymousClass1 r100) {
        this();
    }

    public void setBizExtra(JSONObject r100) {
        this.bizExtra = r100;
    }

    public void setChargeOrderBusinessScene(int r100) {
        this.chargeOrderBusinessScene = r100;
    }

    public void setChargeOrderSource(int r100) {
        this.chargeOrderSource = r100;
    }

    public void setChargeReason(String r100) {
        this.chargeReason = r100;
    }

    public void setChargeScene(String r100) {
        this.chargeScene = r100;
    }

    public void setChargeStyle(String r100) {
        this.chargeStyle = r100;
    }

    public void setCombineAmount(int r100) {
        this.combineAmount = r100;
    }

    public void setCustomPrice(long r100) {
        this.customPrice = r100;
    }

    public void setDiamondId(long r100) {
        this.diamondId = r100;
    }

    public void setExtra(HashMap<String, String> r100) {
        this.extra = r100;
    }

    public void setExtraMap(Map<String, String> r100) {
        this.extraMap = r100;
    }

    public void setFunctionType(String r100) {
        this.functionType = r100;
    }

    public void setHideStatusBar(boolean r100) {
        this.hideStatusBar = r100;
    }

    public void setIapPay(boolean r100) {
        this.iapPay = r100;
    }

    public void setIapProductId(String r100) {
        this.iapProductId = r100;
    }

    public void setIdStr(String r100) {
        this.idStr = r100;
    }

    public void setIsFirstCharge(boolean r100) {
        this.isFisrtCharge = r100;
    }

    public void setLiveType(String r100) {
        this.liveType = r100;
    }

    public void setNoPasswordType(int r100) {
        this.noPasswordType = r100;
    }

    public void setOneStepScene(String r100) {
        this.oneStepScene = r100;
    }

    public void setOpenCombinePay(boolean r100) {
        this.openCombinePay = r100;
    }

    public void setOwnerUserId(long r100) {
        this.ownerUserId = r100;
    }

    public void setPrice(int r100) {
        this.price = r100;
    }

    public void setQueriesMap(Map<String, String> r100) {
        this.queriesMap = r100;
    }

    public void setRechargeDialogHeight(int r100) {
        this.rechargeDialogHeight = r100;
    }

    public void setRequestPage(String r100) {
        this.requestPage = r100;
    }

    public void setRoomId(long r100) {
        this.roomId = r100;
    }

    public void setSelectCombinePay(boolean r100) {
        this.selectCombinePay = r100;
    }

    public void setShowFastPay(boolean r100) {
        this.showFastPay = r100;
    }

    public void setTotalDiamond(int r100) {
        this.totalDiamond = r100;
    }

    public void setTradeName(String r100) {
        this.tradeName = r100;
    }

    public void setTradeType(int r100) {
        this.tradeType = r100;
    }
}
