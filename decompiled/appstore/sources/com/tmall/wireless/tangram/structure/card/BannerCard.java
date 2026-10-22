package com.tmall.wireless.tangram.structure.card;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.MVResolver;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.cell.BannerCell;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BannerCard extends Card {
    public static final String ATTR_AUTOSCROLL = "autoScroll";
    public static final String ATTR_HGAP = "hGap";
    public static final String ATTR_INDICATOR_COLOR = "indicatorColor";
    public static final String ATTR_INDICATOR_DEFAULT_INDICATOR_COLOR = "defaultIndicatorColor";
    public static final String ATTR_INDICATOR_FOCUS = "indicatorImg1";
    public static final String ATTR_INDICATOR_GAP = "indicatorGap";
    public static final String ATTR_INDICATOR_GRA = "indicatorGravity";
    public static final String ATTR_INDICATOR_HEIGHT = "indicatorHeight";
    public static final String ATTR_INDICATOR_MARGIN = "indicatorMargin";
    public static final String ATTR_INDICATOR_NORMAL = "indicatorImg2";
    public static final String ATTR_INDICATOR_POS = "indicatorPosition";
    public static final String ATTR_INDICATOR_RADIUS = "indicatorRadius";
    public static final String ATTR_INFINITE = "infinite";
    public static final String ATTR_INFINITE_MIN_COUNT = "infiniteMinCount";
    public static final String ATTR_ITEM_MARGIN_LEFT = "scrollMarginLeft";
    public static final String ATTR_ITEM_MARGIN_RIGHT = "scrollMarginRight";
    public static final String ATTR_PAGE_WIDTH = "pageRatio";
    private BannerCell cell;

    public BannerCard() {
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(LayoutHelper r10) {
        LinearLayoutHelper r11 = new LinearLayoutHelper();
        r11.setItemCount(getCells().size());
        return r11;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseFooterCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        BannerCell r12 = this.cell;
        r12.mFooter = createCell(r10, r11, false);
        BannerCell r13 = this.cell;
        BaseCell r14 = r13.mFooter;
        if (r14 == null) goto L9;
        r14.parent = this;
        r14.parentId = this.f18212id;
        BaseCell r15 = r13.mHeader;
        int r16 = getCells().size();
        if (r15 == null) goto L7;
        r16 = r16 + 1;
    L7:
        r14.pos = r16;
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseHeaderCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        BannerCell r12 = this.cell;
        r12.mHeader = createCell(r10, r11, false);
        BaseCell r13 = this.cell.mHeader;
        if (r13 == null) goto L6;
        r13.parent = this;
        r13.parentId = this.f18212id;
        r13.pos = 0;
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(@Nullable JSONObject r10) {
        super.parseStyle(r10);
        if (r10 != null) goto L5;
        return;
    L5:
        this.cell.setIndicatorRadius(Style.dp2px(r10.optDouble(ATTR_INDICATOR_RADIUS)));
        this.cell.setIndicatorColor(Style.parseColor(r10.optString("indicatorColor", Style.DEFAULT_BG_COLOR)));
        this.cell.setIndicatorDefaultColor(Style.parseColor(r10.optString("defaultIndicatorColor", Style.DEFAULT_BG_COLOR)));
        this.cell.setAutoScrollInternal(r10.optInt(ATTR_AUTOSCROLL));
        this.cell.setInfinite(r10.optBoolean(ATTR_INFINITE));
        this.cell.setInfiniteMinCount(r10.optInt(ATTR_INFINITE_MIN_COUNT));
        this.cell.setIndicatorFocus(r10.optString(ATTR_INDICATOR_FOCUS));
        this.cell.setIndicatorNor(r10.optString(ATTR_INDICATOR_NORMAL));
        this.cell.setIndicatorGravity(r10.optString(ATTR_INDICATOR_GRA));
        this.cell.setIndicatorPos(r10.optString(ATTR_INDICATOR_POS));
        this.cell.setIndicatorGap(Style.dp2px(r10.optInt(ATTR_INDICATOR_GAP)));
        this.cell.setIndicatorMargin(Style.dp2px(r10.optInt(ATTR_INDICATOR_MARGIN)));
        this.cell.setIndicatorHeight(Style.dp2px(r10.optInt(ATTR_INDICATOR_HEIGHT)));
        this.cell.setPageWidth(r10.optDouble(ATTR_PAGE_WIDTH));
        this.cell.sethGap(Style.dp2px(r10.optInt("hGap")));
        this.cell.itemMargin[0] = Style.dp2px(r10.optInt(ATTR_ITEM_MARGIN_LEFT));
        this.cell.itemMargin[1] = Style.dp2px(r10.optInt(ATTR_ITEM_MARGIN_RIGHT));
        Style r11 = this.style;
        if (r11 == null) goto L9;
        this.cell.setRatio(r11.aspectRatio);
        this.cell.margin = new int[]{0, 0, 0, 0};
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        if (this.cell != null) goto L5;
        this.cell = new BannerCell();
    L5:
        super.parseWith(r10, r11);
        JSONObject r12 = new JSONObject();
        r12.put("type", -2);     // Catch: Exception -> L10
        r12.put(MVResolver.KEY_BIZ_ID, this.f18212id);     // Catch: Exception -> L10
        r11.parseCell(r11, this.cell, r12);     // Catch: Exception -> L10
        if (super.getCells().isEmpty() == true) goto L15;
        this.cell.mCells.addAll(super.getCells());     // Catch: Exception -> L10
        super.setCells(Collections.singletonList(this.cell));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        setCells(null);
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void setCells(@Nullable List<BaseCell> r10) {
        if (r10 != null) goto L4;
    L7:
        super.setCells(null);
    L8:
        notifyDataChange();
        return;
    L4:
        if (r10.isEmpty() == true) goto L7;
        super.setCells(Collections.singletonList(this.cell));
        this.cell.setData(r10);
        goto L8
    }
}
