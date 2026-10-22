package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068gX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/sb;", "Lvh7/c;", "Lpy/k;", "getTitleImage", "()Lpy/k;", "titleImage", "", "getTitle", "()Ljava/lang/String;", "title", "getTopTip", "topTip", "getBottomTip", "bottomTip", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface sb extends vh7.c<sb> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bottom_tip")
    String getBottomTip();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = "title_image")
    py.k getTitleImage();

    @FieldName(name = "top_tip")
    String getTopTip();
}
