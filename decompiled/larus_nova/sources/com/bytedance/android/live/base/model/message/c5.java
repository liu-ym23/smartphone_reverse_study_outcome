package com.bytedance.android.live.base.model.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface c5 extends vh7.c<c5>, d5 {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    b5 getFormat();

    e5 getGiftValue();

    f5 getHeartValue();

    ITextPieceImage getImageValue();

    g5 getPatternRefValue();

    String getRefKey();

    String getSchemaKey();

    String getStringValue();

    @Override // com.bytedance.android.live.base.model.message.d5
    int getType();

    i5 getUserValue();

    boolean isNormalPiece();

    void setFormat(b5 r100);

    void setGiftValue(e5 r100);

    void setHeartValue(f5 r100);

    void setImageValue(ITextPieceImage r100);

    void setNormalPiece(boolean r100);

    void setPatternRefValue(g5 r100);

    void setRefKey(String r100);

    void setSchemaKey(String r100);

    void setStringValue(String r100);

    void setType(int r100);

    void setUserValue(i5 r100);
}
