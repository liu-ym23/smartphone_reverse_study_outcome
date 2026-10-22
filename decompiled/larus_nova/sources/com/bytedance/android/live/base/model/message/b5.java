package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface b5 extends vh7.c<b5> {
    public static final int BOLD = 700;

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    boolean enableColorMapping();

    String getColor();

    int getFontSize();

    /* synthetic */ boolean getIgnoreColorMapping();

    /* synthetic */ boolean getItalic();

    /* synthetic */ boolean getUseHeighLight();

    /* synthetic */ boolean getUseRemoteColor();

    int getWeight();

    boolean isItalic();

    boolean isUseHeighLight();

    boolean isUseRemoteColor();

    void setColor(String r100);

    void setFontSize(int r100);

    void setUseRemoteColor(boolean r100);

    void setWeight(int r100);
}
