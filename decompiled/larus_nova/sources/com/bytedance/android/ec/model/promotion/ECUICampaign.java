package com.bytedance.android.ec.model.promotion;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.CampaignProgress;
import com.bytedance.android.ec.model.response.CountDown;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECPromotionAuctionInfo;
import com.bytedance.android.ec.model.response.ECPromotionCampaign;
import com.bytedance.android.ec.model.response.MultiGroupInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import wl.a;
import wl.b;

/* JADX INFO: loaded from: classes44.dex */
public class ECUICampaign implements Serializable {
    public ECPromotionAuctionInfo auctionInfo;
    public int campaignType;
    public long endTime;
    public boolean fakeSecKill;
    public ECUIPingGroup groupData;
    public boolean isPreheat;
    public String label;
    public long leftStock;
    public long logicalClock;
    public String marketPrice;
    public String maxPrice;
    public MultiGroupInfo multiGroupInfo;
    public long originPrice;

    /* JADX INFO: renamed from: pic, reason: collision with root package name */
    public String f47895pic;
    public ECPreSaleData preSaleData;
    public String price;
    public String priceHeader;
    public String priceStr;
    public CampaignProgress progress;
    public long progressEndTime;
    public String progressText;
    public String secIcon;
    public ECUrlModel skillIcon;
    public long startTime;
    public long stock;
    public int style;
    public String timeEndLabel;
    public String timeStartLabel;

    public ECUICampaign() {
    }

    public boolean isAuction() {
        if (this.campaignType == Campaign.AUCTION.getRaw()) goto L5;
    L7:
        return false;
    L5:
        if (this.auctionInfo == null) goto L7;
        return true;
    }

    public Boolean isCampaign() {
        if (this.campaignType != Campaign.SECKILL.getRaw()) goto L5;
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L5:
        r100 = false;
        goto L7
    }

    public Boolean isGoodsSubsidy() {
        if (this.campaignType != Campaign.PLATFORM.getRaw()) goto L5;
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L5:
        r100 = false;
        goto L7
    }

    public Boolean isInSecKillOrLimitBuy() {
        boolean r100 = true;
        if (this.campaignType != Campaign.SECKILL.getRaw()) goto L7;
        if (this.fakeSecKill == true) goto L7;
    L11:
        return Boolean.valueOf(r100);
    L7:
        if (this.campaignType == Campaign.LIMIT_BUY.getRaw()) goto L11;
        r100 = false;
        goto L11
    }

    public boolean isLimitBuy() {
        if (this.campaignType != Campaign.LIMIT_BUY.getRaw()) goto L9;
        String r100 = this.progressText;
        if (r100 == null) goto L9;
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isLimitQuantityBuy() {
        if (this.campaignType != Campaign.LIMIT_QUANTITY_BUY.getRaw()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLimitTimeBuy() {
        if (this.campaignType != Campaign.LIMIT_BUY.getRaw()) goto L5;
        return true;
    L5:
        return false;
    }

    public Boolean isPreSale() {
        if (this.campaignType == Campaign.PRE_SALE.getRaw()) goto L5;
    L7:
        boolean r100 = false;
    L9:
        return Boolean.valueOf(r100);
    L5:
        if (this.preSaleData == null) goto L7;
        r100 = true;
        goto L9
    }

    public Boolean isPreheat() {
        if (this.campaignType != Campaign.PREHEAT.getRaw()) goto L5;
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L5:
        r100 = false;
        goto L7
    }

    public Boolean isRealSeckill() {
        if (this.campaignType != Campaign.SECKILL.getRaw()) goto L11;
        boolean r100 = true;
        if (this.fakeSecKill == true) goto L11;
        String r101 = this.progressText;
        if (r101 == null) goto L11;
        if (TextUtils.isEmpty(r101) == true) goto L11;
    L13:
        return Boolean.valueOf(r100);
    L11:
        r100 = false;
        goto L13
    }

    public Boolean isSecKill() {
        if (this.campaignType != Campaign.SECKILL.getRaw()) goto L5;
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L5:
        r100 = false;
        goto L7
    }

    public Boolean isShopVipProduct() {
        if (this.campaignType != Campaign.SHOP_VIP_PRODUCT.getRaw()) goto L5;
        boolean r100 = true;
    L7:
        return Boolean.valueOf(r100);
    L5:
        r100 = false;
        goto L7
    }

    public boolean inCampaignForetime() {
        if (SystemClock.elapsedRealtime() < this.startTime) goto L5;
    L7:
        return false;
    L5:
        if (this.isPreheat == false) goto L7;
        return true;
    }

    public boolean inCampaignTime() {
        long r100 = SystemClock.elapsedRealtime();
        if (r100 >= this.startTime) goto L5;
    L7:
        return false;
    L5:
        if (r100 > this.endTime) goto L7;
        return true;
    }

    public boolean isCampaignNotStarted() {
        long r100 = SystemClock.elapsedRealtime();
        if (this.startTime <= r100) goto L5;
        return true;
    L5:
        return false;
    }

    public Boolean isGroup() {
        if (inCampaignTime() == true) goto L5;
    L9:
        boolean r100 = false;
    L11:
        return Boolean.valueOf(r100);
    L5:
        if (this.campaignType != Campaign.GROUP.getRaw()) goto L9;
        if (this.groupData == null) goto L9;
        r100 = true;
        goto L11
    }

    public Boolean isMultiGroupBuy() {
        if (inCampaignTime() == true) goto L5;
    L12:
        boolean r100 = false;
    L14:
        return Boolean.valueOf(r100);
    L5:
        if (this.campaignType != Campaign.MULTI_GROUP_BUY.getRaw()) goto L12;
        MultiGroupInfo r101 = this.multiGroupInfo;
        if (r101 == null) goto L12;
        if (r101.getSkuIsGroupBuying().booleanValue() == false) goto L12;
        r100 = true;
        goto L14
    }

    public boolean shouldShowLimitBuy() {
        if (isLimitBuy() == true) goto L5;
    L9:
        return false;
    L5:
        if (inCampaignTime() == false) goto L7;
    L8:
        return true;
    L7:
        if (inCampaignForetime() == false) goto L9;
        goto L8
    }

    public boolean shouldShowLimitBuyV2() {
        if (isLimitTimeBuy() == true) goto L5;
    L9:
        return false;
    L5:
        if (inCampaignTime() == false) goto L7;
    L8:
        return true;
    L7:
        if (inCampaignForetime() == false) goto L9;
        goto L8
    }

    public boolean shouldUpdateCampaign() {
        long r100 = SystemClock.elapsedRealtime();
        if (this.endTime >= r100) goto L5;
    L8:
        return true;
    L5:
        if (r100 > this.startTime) goto L8;
        return false;
    }

    public static ECUICampaign convertCampaign(ECPromotionCampaign r100, long r101) {
        return convertCampaign(r100, r101, 0);
    }

    public static ECUICampaign convertCampaign(ECPromotionCampaign r100, long r101, long r110) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ECUICampaign r102 = new ECUICampaign();
        r102.label = r100.label;
        r102.price = b.a(r100.price);
        r102.priceStr = r100.priceStr;
        r102.originPrice = r100.price;
        r102.f47895pic = r100.f47906pic;
        long r103 = 0;
        if (r110 > 0) goto L9;
        r110 = SystemClock.elapsedRealtime();
    L9:
        long r104 = r101 * 1000;
        r102.startTime = ((r100.startTime * 1000) + r110) - r104;
        r102.endTime = (r110 + (r100.endTime * 1000)) - r104;
        r102.timeStartLabel = r100.timeStartLabel;
        r102.timeEndLabel = r100.timeEndLabel;
        r102.stock = r100.stock;
        r102.leftStock = r100.leftStock;
        r102.progressText = r100.progressText;
        r102.maxPrice = b.a(r100.maxPrice);
        r102.secIcon = r100.secIcon;
        r102.skillIcon = r100.skillIcon;
        r102.campaignType = r100.campaignType;
        CampaignProgress r105 = r100.progress;
        r102.progress = r105;
        if (r105 == null) goto L14;
        CountDown r106 = r105.getCountDown();
        if (r106 == null) goto L14;
        long r107 = (SystemClock.elapsedRealtime() + (r106.getEndTime() * 1000)) - (r106.getServerTime() * 1000);
    L16:
        r102.progressEndTime = r107;
        r102.isPreheat = r100.isPreheat;
        if (r100.groupData == null) goto L31;
        r102.groupData = new ECUIPingGroup();
        if (r100.groupData.getAvatarList() != null) goto L21;
    L30:
        r102.groupData.setGroupId(r100.groupData.getGroupId());
        r102.groupData.setGroupLabel(r100.groupData.getGroupLabel());
        r102.groupData.setButtonText(r100.groupData.getButtonText());
        r102.groupData.setGroupSize(r100.groupData.getGroupSize());
        r102.groupData.setJoined(r100.groupData.getJoined());
        r102.groupData.setEndTime(Long.valueOf(r102.endTime));
        r102.groupData.setPersent(r100.groupData.getPersent());
        goto L31
    L21:
        if (r100.groupData.getAvatarList().size() <= 0) goto L30;
        ArrayList r108 = new ArrayList();
        Iterator<String> r109 = r100.groupData.getAvatarList().iterator();
    L24:
        if (r109.hasNext() == false) goto L29;
        String r111 = r109.next();
        if (TextUtils.isEmpty(r111) == true) goto L24;
        r108.add(r111);
        goto L24
    L29:
        r102.groupData.setAvatarList(r108);
    L31:
        r102.preSaleData = r100.preSaleData;
        r102.marketPrice = b.a(r100.marketPrice);
        r102.priceHeader = r100.priceHeader;
        r102.auctionInfo = r100.auctionInfo;
        long r112 = r100.logicalClock;
        r102.logicalClock = r112;
        r102.style = r100.style;
        r102.fakeSecKill = r100.fakeSecKill;
        if (r112 <= 0) goto L36;
        if (r112 <= 0) goto L35;
        int r113 = a.f560165b;
        r103 = System.currentTimeMillis() - r112;
    L35:
        a.f560164a = r103;
    L36:
        r102.multiGroupInfo = r100.multiGroupInfo;
        return r102;
    L14:
        r107 = 0;
        goto L16
    }
}
