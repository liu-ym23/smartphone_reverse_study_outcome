package com.bytedance.android.live.profit.privilege.model.danmu;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0013\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001b\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010 \u001a\u0004\u0018\u00010\u001c8&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\b\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010#R\"\u0010(\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\b\u001a\u0004\b&\u0010\u0016R\"\u0010+\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\b\u001a\u0004\b)\u0010\u0016R\"\u0010.\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\b\u001a\u0004\b,\u0010\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/b;", "Lvh7/c;", "", "getStatus", "()I", "setStatus", "(I)V", "getStatus$annotations", "()V", "status", "getStyle", "setStyle", "getStyle$annotations", "style", "", "getDiamondCount", "()J", "getDiamondCount$annotations", "diamondCount", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImg", "()Lpy/k;", "getImg$annotations", "img", "getLandscapeImg", "getLandscapeImg$annotations", "landscapeImg", "", "getToast", "()Ljava/lang/String;", "getToast$annotations", "toast", "getCommentToast", "setCommentToast", "(Ljava/lang/String;)V", "getCommentToast$annotations", "commentToast", "getEntranceImg", "getEntranceImg$annotations", "entranceImg", "getImgV2", "getImgV2$annotations", "imgV2", "getLandscapeImgV2", "getLandscapeImgV2$annotations", "landscapeImgV2", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b extends vh7.c<b> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "comment_toast")
    String getCommentToast();

    @FieldName(name = "diamond_count")
    long getDiamondCount();

    @FieldName(name = "entrance_img")
    k getEntranceImg();

    @FieldName(name = "img")
    k getImg();

    @FieldName(name = "img_v2")
    k getImgV2();

    @FieldName(name = "landscape_img")
    k getLandscapeImg();

    @FieldName(name = "landscape_img_v2")
    k getLandscapeImgV2();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "style")
    int getStyle();

    @FieldName(name = "toast")
    String getToast();

    @FieldName(name = "comment_toast#setter")
    void setCommentToast(String r100);

    @FieldName(name = "status#setter")
    void setStatus(int r100);

    @FieldName(name = "style#setter")
    void setStyle(int r100);
}
