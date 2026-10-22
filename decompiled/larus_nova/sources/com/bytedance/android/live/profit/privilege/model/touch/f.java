package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R*\u0010\n\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R6\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\t\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R6\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\t\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\t\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R*\u0010)\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\t\u001a\u0004\b&\u0010\u0005\"\u0004\b'\u0010\u0007R$\u00100\u001a\u0004\u0018\u00010*8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\t\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/f;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "getIcon$annotations", "()V", "icon", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMainText", "()Ljava/util/List;", "setMainText", "(Ljava/util/List;)V", "getMainText$annotations", com.bytedance.android.livesdk.gift.model.n.KEY_MAIN_TEXT, "getDeputyText", "setDeputyText", "getDeputyText$annotations", "deputyText", "Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "getProgressBar", "()Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "setProgressBar", "(Lcom/bytedance/android/live/profit/privilege/model/touch/k;)V", "getProgressBar$annotations", "progressBar", "Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "getButton", "()Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "setButton", "(Lcom/bytedance/android/live/profit/privilege/model/touch/o;)V", "getButton$annotations", "button", "getBgImg", "setBgImg", "getBgImg$annotations", "bgImg", "", "getMainTextBgAttr", "()Ljava/lang/String;", "setMainTextBgAttr", "(Ljava/lang/String;)V", "getMainTextBgAttr$annotations", "mainTextBgAttr", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_img")
    py.k getBgImg();

    @FieldName(name = "button")
    o getButton();

    @FieldName(name = "deputy_text")
    List<n> getDeputyText();

    @FieldName(name = "icon")
    py.k getIcon();

    @FieldName(name = "main_text")
    List<n> getMainText();

    @FieldName(name = "main_text_bg_attr")
    String getMainTextBgAttr();

    @FieldName(name = "progress_bar")
    k getProgressBar();

    @FieldName(name = "bg_img#setter")
    void setBgImg(py.k r100);

    @FieldName(name = "button#setter")
    void setButton(o r100);

    @FieldName(name = "deputy_text#setter")
    void setDeputyText(List<? extends n> r100);

    @FieldName(name = "icon#setter")
    void setIcon(py.k r100);

    @FieldName(name = "main_text#setter")
    void setMainText(List<? extends n> r100);

    @FieldName(name = "main_text_bg_attr#setter")
    void setMainTextBgAttr(String r100);

    @FieldName(name = "progress_bar#setter")
    void setProgressBar(k r100);
}
