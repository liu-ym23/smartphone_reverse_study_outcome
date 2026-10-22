package com.bytedance.android.live.core.widget.simple;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class SimpleViewHolder extends BaseViewHolder {
    private Map<String, Object> extra;
    private SparseArray<View> mViews;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public void bind(Object r100, int r101) {
    }

    public <T> T getItem() {
        return (T) this.extra.get("__________");
    }

    public SimpleViewHolder(View r100) {
        super(r100);
        this.extra = new HashMap();
        this.mViews = new SparseArray();
        this.itemView.setTag(this);
    }

    public int getInt(String r100) {
        Object r101 = this.extra.get(r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        if ((r101 instanceof String) == false) goto L15;
        return CastIntegerProtector.parseInt((String) r101);
    L9:
        return 0;
    L15:
        return ((Integer) r101).intValue();
    L12:
        return 0;
    }

    public long getLong(String r100) {
        Object r101 = this.extra.get(r100);
        if (r101 != null) goto L6;
        return 0;
    L6:
        if ((r101 instanceof String) == false) goto L15;
        return CastLongProtector.parseLong((String) r101);
    L17:
        return 0;
    L15:
        return ((Long) r101).longValue();
    L18:
        return 0;
    }

    public <V extends View> V getView(int r100) {
        V r101 = (V) this.mViews.get(r100);
        if (r101 != null) goto L6;
        V r102 = (V) this.itemView.findViewById(r100);
        this.mViews.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public SimpleViewHolder hide(int r100) {
        View r101 = getView(r100);
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        return this;
    }

    public void setItem(Object r100) {
        this.extra.put("__________", r100);
    }

    public SimpleViewHolder show(int r100) {
        View r101 = getView(r100);
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        return this;
    }

    public void put(String r100, Object r101) {
        this.extra.put(r100, r101);
    }

    public SimpleViewHolder setBackgroundResource(int r100, int r101) {
        getView(r100).setBackgroundResource(r101);
        return this;
    }

    public SimpleViewHolder setImageBitmap(int r100, Bitmap r101) {
        ((ImageView) getView(r100)).setImageBitmap(r101);
        return this;
    }

    public SimpleViewHolder setImageResource(int r100, int r101) {
        ((ImageView) getView(r100)).setImageResource(r101);
        return this;
    }

    public SimpleViewHolder setOnClickListener(int r100, View.OnClickListener r101) {
        getView(r100).setOnClickListener(r101);
        return this;
    }

    public SimpleViewHolder setText(int r100, CharSequence r101) {
        ((TextView) getView(r100)).setText(r101);
        return this;
    }

    public SimpleViewHolder setTextColor(int r100, int r101) {
        ((TextView) getView(r100)).setTextColor(r101);
        return this;
    }

    public SimpleViewHolder setText(int r100, String r101) {
        ((TextView) getView(r100)).setText(r101);
        return this;
    }
}
