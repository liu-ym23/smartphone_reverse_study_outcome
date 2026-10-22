package com.tmall.wireless.tangram.structure.entitycard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.TangramBuilder;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.card.BannerCard;
import com.tmall.wireless.tangram.structure.cell.BannerCell;
import com.tmall.wireless.tangram.util.LogUtils;
import com.tmall.wireless.tangram.util.Utils;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BannerEntityCard extends BannerCell {
    public int cardType;

    public BannerEntityCard() {
    }

    private boolean addCellInternal(MVHelper r10, BaseCell r11, boolean r12) {
        if (r11 == null) goto L18;
        r11.parentId = this.f18213id;
        r11.parent = null;
        r11.nestedParent = this;
        r11.serviceManager = this.serviceManager;
        if (r10 != null) goto L6;
        return false;
    L6:
        if (r10.isValid(r11, this.serviceManager) == true) goto L8;
        return false;
    L8:
        if (this.mHeader == null) goto L10;
        int r13 = this.mCells.size() + 1;
    L11:
        r11.pos = r13;
        if (r12 == false) goto L14;
    L16:
        this.mCells.add(r11);
        return true;
    L14:
        if (this.mIsActivated == false) goto L16;
        r11.added();
        goto L16
    L10:
        r13 = this.mCells.size();
        goto L11
    L18:
        return false;
    }

    private BaseCell createCell(@NonNull MVHelper r10, @NonNull JSONObject r11, boolean r12) {
        if (r11 == null) goto L16;
        int r13 = r11.optInt("type", -1);
        if (r10 == null) goto L16;
        if (r10.resolver().getViewClass(r13) == null) goto L16;
        if (r10.resolver().isCompatibleType(r13) == false) goto L13;
        BaseCell r14 = (BaseCell) Utils.newInstance(r10.resolver().getCellClass(r13));
        if (r14 != null) goto L14;
        return null;
    L14:
        parseCell(r10, r11, r14, r12);
        r14.type = r13;
        r14.serviceManager = this.serviceManager;
        r14.nestedParent = this;
        return r14;
    L13:
        r14 = new BaseCell(r13);
    L16:
        return null;
    }

    public List<BaseCell> getCells() {
        return this.mCells;
    }

    public void parseCell(@NonNull MVHelper r10, @NonNull JSONObject r11, @NonNull BaseCell r12, boolean r13) {
        r10.parseCell(r10, r12, r11);
        if (r13 == true) goto L5;
        return;
    L5:
        if (addCellInternal(r10, r12, false) == false) goto L7;
        return;
    L7:
        if (TangramBuilder.isPrintLog() == false) goto L12;
        LogUtils.w("BannerCell", "Parse invalid cell with data: " + r11.toString());
        return;
    }

    public void parseFooterCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        BaseCell r12 = createCell(r10, r11, false);
        this.mFooter = r12;
        if (r12 != null) goto L7;
        return;
    L7:
        if (this.mHeader == null) goto L9;
        int r13 = getCells().size() + 1;
    L10:
        r12.pos = r13;
        BaseCell r14 = this.mFooter;
        r14.parent = null;
        r14.nestedParent = this;
        r14.parentId = this.f18213id;
        return;
    L9:
        r13 = getCells().size();
        goto L10
    }

    public void parseHeaderCell(@NonNull MVHelper r10, @Nullable JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        BaseCell r12 = createCell(r10, r11, false);
        this.mHeader = r12;
        if (r12 == null) goto L8;
        r12.pos = 0;
        r12.parent = null;
        r12.nestedParent = this;
        r12.parentId = this.f18213id;
        return;
    }

    @Override // com.tmall.wireless.tangram.structure.BaseCell
    public void parseStyle(@Nullable JSONObject r10) {
        Style r11 = new Style();
        this.style = r11;
        r11.parseWith(r10);
        setRatio(this.style.aspectRatio);
        int r12 = this.style.bgColor;
        if (r12 != 0) goto L5;
        setBgColor(-1);
    L6:
        this.margin = this.style.margin;
        if (r10 == null) goto L10;
        setIndicatorRadius(Style.dp2px(r10.optDouble(BannerCard.ATTR_INDICATOR_RADIUS)));
        setIndicatorColor(Style.parseColor(r10.optString("indicatorColor", Style.DEFAULT_BG_COLOR)));
        setIndicatorDefaultColor(Style.parseColor(r10.optString("defaultIndicatorColor", Style.DEFAULT_BG_COLOR)));
        setAutoScrollInternal(r10.optInt(BannerCard.ATTR_AUTOSCROLL));
        setInfinite(r10.optBoolean(BannerCard.ATTR_INFINITE));
        setInfiniteMinCount(r10.optInt(BannerCard.ATTR_INFINITE_MIN_COUNT));
        setIndicatorFocus(r10.optString(BannerCard.ATTR_INDICATOR_FOCUS));
        setIndicatorNor(r10.optString(BannerCard.ATTR_INDICATOR_NORMAL));
        setIndicatorGravity(r10.optString(BannerCard.ATTR_INDICATOR_GRA));
        setIndicatorPos(r10.optString(BannerCard.ATTR_INDICATOR_POS));
        setIndicatorGap(Style.dp2px(r10.optInt(BannerCard.ATTR_INDICATOR_GAP)));
        setIndicatorMargin(Style.dp2px(r10.optInt(BannerCard.ATTR_INDICATOR_MARGIN)));
        setIndicatorHeight(Style.dp2px(r10.optInt(BannerCard.ATTR_INDICATOR_HEIGHT)));
        setPageWidth(r10.optDouble(BannerCard.ATTR_PAGE_WIDTH));
        sethGap(Style.dp2px(r10.optInt("hGap")));
        this.itemMargin[0] = Style.dp2px(r10.optInt(BannerCard.ATTR_ITEM_MARGIN_LEFT));
        this.itemMargin[1] = Style.dp2px(r10.optInt(BannerCard.ATTR_ITEM_MARGIN_RIGHT));
        return;
    L10:
        return;
    L5:
        setBgColor(r12);
        goto L6
    }

    @Override // com.tmall.wireless.tangram.structure.BaseCell
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        String r12 = this.f18213id;
        if (r12 != null) goto L5;
        r12 = "";
    L5:
        this.f18213id = r10.optString("id", r12);
        int r13 = r10.optInt("type");
        this.cardType = r13;
        if (Utils.isSupportHeaderFooter(r13) == false) goto L8;
        parseHeaderCell(r11, r10.optJSONObject("header"));
    L8:
        JSONArray r14 = r10.optJSONArray(Card.KEY_ITEMS);
        if (r14 == null) goto L14;
        int r15 = r14.length();
        int r16 = 0;
    L11:
        if (r16 >= r15) goto L14;
        createCell(r11, r14.optJSONObject(r16), true);
        r16 = r16 + 1;
    L14:
        if (Utils.isSupportHeaderFooter(this.cardType) == false) goto L16;
        parseFooterCell(r11, r10.optJSONObject(Card.KEY_FOOTER));
    L16:
        parseStyle(r10.optJSONObject("style"));
    }
}
