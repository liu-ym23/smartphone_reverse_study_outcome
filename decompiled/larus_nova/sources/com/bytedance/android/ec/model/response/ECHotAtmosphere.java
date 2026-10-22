package com.bytedance.android.ec.model.response;

import android.graphics.Color;
import android.text.TextUtils;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public class ECHotAtmosphere implements Serializable {
    public static final int TYPE_AUCTION_BID = 10001;
    public static final int TYPE_AUCTION_SUCCESS = 10002;
    public static final int TYPE_AUCTION_V2 = 100;
    public static final int TYPE_GOOD_COMMENT_RATE = 4;
    public static final int TYPE_SALE_NUM = 2;
    public static final int TYPE_SALE_RANK = 3;
    public static final int TYPE_STOCK = 1;
    public static final int UI_TYPE_0 = 0;
    public static final int UI_TYPE_1 = 1;
    public static final int UI_TYPE_2 = 2;
    public static final int UI_TYPE_INTRO = 5000;
    public int afterTextIconResId;
    public String auctionType;

    @SerializedName("bg_color")
    public String bgColor;

    @SerializedName("bg_colors")
    public List<String> bgColors;
    private int[] bgColorsCacheList;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("border_colors")
    public List<String> borderColors;
    private int[] borderColorsCacheList;

    @IgnoreProtoFieldCheck
    @SerializedName("delay")
    public int delay;

    @SerializedName("img")
    public String img;

    @SerializedName("left_margin")
    public int leftMargin;
    private int localCacheNum;
    private long localCacheNumLong;

    @SerializedName("num")
    public String num;

    @Expose
    public String prefix;

    @SerializedName("top_img")
    public String topImg;

    @SerializedName("type")
    public int type;

    @SerializedName("ui_type")
    public int uiType;

    public ECHotAtmosphere copy() {
        return copyTo(new ECHotAtmosphere());
    }

    public int[] getCacheBgColors() {
        if (this.bgColorsCacheList != null) goto L6;
        this.bgColorsCacheList = parseColors(this.bgColors);
    L6:
        return this.bgColorsCacheList;
    }

    public int[] getCacheBorderColors() {
        if (this.borderColorsCacheList != null) goto L6;
        this.borderColorsCacheList = parseColors(this.borderColors);
    L6:
        return this.borderColorsCacheList;
    }

    public int getNumInt() {
        if (this.localCacheNum != Integer.MIN_VALUE) goto L8;
        this.localCacheNum = CastIntegerProtector.parseInt(this.num);     // Catch: Exception -> L6
    L6:
        this.localCacheNum = 0;
    L8:
        return this.localCacheNum;
    }

    public long getNumLong() {
        if (this.localCacheNumLong != Long.MIN_VALUE) goto L8;
        this.localCacheNumLong = CastLongProtector.parseLong(this.num);     // Catch: Exception -> L6
    L6:
        this.localCacheNumLong = 0;
    L8:
        return this.localCacheNumLong;
    }

    public String getTypeStr() {
        int r100 = this.type;
        if (r100 != 1) goto L5;
        return "inventory";
    L5:
        if (r100 != 2) goto L7;
        return "hot_sale";
    L7:
        if (r100 != 3) goto L9;
        return "sale_rank";
    L9:
        if (r100 == 4) goto L12;
        return "";
    L12:
        return "good_comment";
    }

    public ECHotAtmosphere() {
        this.bgColor = null;
        this.borderColor = null;
        this.leftMargin = 0;
        this.delay = 0;
        this.uiType = 0;
        this.bgColorsCacheList = null;
        this.borderColorsCacheList = null;
        this.localCacheNum = Integer.MIN_VALUE;
        this.localCacheNumLong = Long.MIN_VALUE;
    }

    private int[] parseColors(List<String> r100) {
        ArrayList r101 = new ArrayList(3);
        if (r100 == null) goto L11;
        Iterator<String> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        r101.add(Integer.valueOf(Color.parseColor(r102.next())));     // Catch: Exception -> L10
    L11:
        int[] r103 = new int[r101.size()];
        int r104 = 0;
    L13:
        if (r104 >= r101.size()) goto L15;
        r103[r104] = ((Integer) ListProtector.get(r101, r104)).intValue();
        r104 = r104 + 1;
        goto L13
    L15:
        return r103;
    }

    public ECHotAtmosphere copyTo(ECHotAtmosphere r100) {
        r100.img = this.img;
        r100.type = this.type;
        r100.num = this.num;
        r100.delay = this.delay;
        r100.leftMargin = this.leftMargin;
        r100.uiType = this.uiType;
        r100.borderColor = this.borderColor;
        r100.bgColor = this.bgColor;
        r100.bgColors = this.bgColors;
        r100.borderColors = this.borderColors;
        r100.topImg = this.topImg;
        r100.auctionType = this.auctionType;
        r100.afterTextIconResId = this.afterTextIconResId;
        return r100;
    }

    public boolean isEquals(ECHotAtmosphere r100) {
        if (r100 != null) goto L4;
    L10:
        return false;
    L4:
        if (r100.type != this.type) goto L10;
        if (TextUtils.equals(this.num, r100.num) == false) goto L10;
        if (r100.uiType != this.uiType) goto L10;
        return true;
    }
}
