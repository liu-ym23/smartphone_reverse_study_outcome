package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R6\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR*\u0010\u001e\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001d\u0010\n\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010%\u001a\u0004\u0018\u00010\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\n\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\n\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/a;", "Lvh7/c;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getMainText", "()Ljava/util/List;", "setMainText", "(Ljava/util/List;)V", "getMainText$annotations", "()V", com.bytedance.android.livesdk.gift.model.n.KEY_MAIN_TEXT, "Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "getMainTextButton", "()Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "setMainTextButton", "(Lcom/bytedance/android/live/profit/privilege/model/touch/o;)V", "getMainTextButton$annotations", "mainTextButton", "getDeputyText", "setDeputyText", "getDeputyText$annotations", "deputyText", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "getBgImg$annotations", "bgImg", "Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "getProgressBar", "()Lcom/bytedance/android/live/profit/privilege/model/touch/k;", "setProgressBar", "(Lcom/bytedance/android/live/profit/privilege/model/touch/k;)V", "getProgressBar$annotations", "progressBar", "getUpperRightText", "setUpperRightText", "getUpperRightText$annotations", "upperRightText", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a extends vh7.c<a> {

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.privilege.model.touch.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1353a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_img")
    py.k getBgImg();

    @FieldName(name = "deputy_text")
    List<n> getDeputyText();

    @FieldName(name = "main_text")
    List<n> getMainText();

    @FieldName(name = "main_text_button")
    o getMainTextButton();

    @FieldName(name = "progress_bar")
    k getProgressBar();

    @FieldName(name = "upper_right_text")
    List<n> getUpperRightText();

    @FieldName(name = "bg_img#setter")
    void setBgImg(py.k r100);

    @FieldName(name = "deputy_text#setter")
    void setDeputyText(List<? extends n> r100);

    @FieldName(name = "main_text#setter")
    void setMainText(List<? extends n> r100);

    @FieldName(name = "main_text_button#setter")
    void setMainTextButton(o r100);

    @FieldName(name = "progress_bar#setter")
    void setProgressBar(k r100);

    @FieldName(name = "upper_right_text#setter")
    void setUpperRightText(List<? extends n> r100);
}
