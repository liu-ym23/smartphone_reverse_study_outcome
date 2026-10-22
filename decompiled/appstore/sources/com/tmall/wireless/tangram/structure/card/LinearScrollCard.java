package com.tmall.wireless.tangram.structure.card;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bytedanceos.common.toolbox.i;
import com.tmall.wireless.tangram.MVHelper;
import com.tmall.wireless.tangram.MVResolver;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.dataparser.concrete.Style;
import com.tmall.wireless.tangram.structure.BaseCell;
import com.tmall.wireless.tangram.structure.cell.LinearScrollCell;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class LinearScrollCard extends Card {
    private static final String LOG_TAG = "LinearScrollCard";
    private LinearScrollCell cell;

    public LinearScrollCard() {
        this.cell = new LinearScrollCell();
    }

    private int parseColor(String r10, int r11) {
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return r11;
    L8:
        return Color.parseColor(r10);
    L7:
        return r11;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    @Nullable
    public LayoutHelper convertLayoutHelper(@Nullable LayoutHelper r10) {
        GridLayoutHelper r11 = new GridLayoutHelper(1);
        r11.setItemCount(getCells().size());
        Style r12 = this.style;
        if (r12 != null) goto L5;
    L7:
        return r11;
    L5:
        if (Float.isNaN(r12.aspectRatio) == true) goto L7;
        r11.setAspectRatio(this.style.aspectRatio);
        goto L7
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseStyle(@Nullable JSONObject r10) {
        super.parseStyle(r10);
        if (r10 == null) goto L18;
        this.cell.pageWidth = optDoubleParam(LinearScrollCell.KEY_PAGE_WIDTH);
        this.cell.pageHeight = optDoubleParam(LinearScrollCell.KEY_PAGE_HEIGHT);
        if (Double.isNaN(this.cell.pageWidth) == true) goto L8;
        LinearScrollCell r11 = this.cell;
        r11.pageWidth = Style.dp2px(r11.pageWidth);
    L8:
        if (Double.isNaN(this.cell.pageHeight) == true) goto L10;
        LinearScrollCell r12 = this.cell;
        r12.pageHeight = Style.dp2px(r12.pageHeight);
    L10:
        this.cell.defaultIndicatorColor = parseColor(optStringParam("defaultIndicatorColor"), LinearScrollCell.DEFAULT_DEFAULT_INDICATOR_COLOR);
        this.cell.indicatorColor = parseColor(optStringParam("indicatorColor"), LinearScrollCell.DEFAULT_INDICATOR_COLOR);
        if (r10.has(LinearScrollCell.KEY_HAS_INDICATOR) == false) goto L14;
        this.cell.hasIndicator = r10.optBoolean(LinearScrollCell.KEY_HAS_INDICATOR);
    L14:
        if (r10.has(LinearScrollCell.KEY_FOOTER_TYPE) == false) goto L16;
        this.cell.footerType = r10.optString(LinearScrollCell.KEY_FOOTER_TYPE);
    L16:
        this.cell.bgColor = parseColor(r10.optString(Style.KEY_BG_COLOR), 0);
        this.cell.retainScrollState = r10.optBoolean(LinearScrollCell.KEY_RETAIN_SCROLL_STATE, true);
        return;
    }

    @Override // com.tmall.wireless.tangram.dataparser.concrete.Card
    public void parseWith(@NonNull JSONObject r10, @NonNull MVHelper r11) {
        super.parseWith(r10, r11);
        JSONObject r12 = new JSONObject();
        r12.put("type", -3);     // Catch: Exception -> L7
        r12.put(MVResolver.KEY_BIZ_ID, this.f18212id);     // Catch: Exception -> L7
        r11.parseCell(r11, this.cell, r12);     // Catch: Exception -> L7
        if (super.getCells().isEmpty() == true) goto L12;
        this.cell.cells.addAll(super.getCells());     // Catch: Exception -> L7
        super.setCells(Collections.singletonList(this.cell));     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        i.b(LOG_TAG, i.d(e));
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
        this.cell.setCells(r10);
        super.setCells(Collections.singletonList(this.cell));
        goto L8
    }
}
