package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R6\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u0013\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\"\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001c8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\n\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/o;", "Lvh7/c;", "", "Lcom/bytedance/android/live/profit/privilege/model/touch/n;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getText", "()Ljava/util/List;", "setText", "(Ljava/util/List;)V", "getText$annotations", "()V", "text", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgImg", "()Lpy/k;", "setBgImg", "(Lpy/k;)V", "getBgImg$annotations", "bgImg", "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "getJumpUrl$annotations", "jumpUrl", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getButtonType", "()Ljava/lang/Long;", "setButtonType", "(Ljava/lang/Long;)V", "getButtonType$annotations", "buttonType", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface o extends vh7.c<o> {

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

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE)
    Long getButtonType();

    @FieldName(name = "jump_url")
    String getJumpUrl();

    @FieldName(name = "text")
    List<n> getText();

    @FieldName(name = "bg_img#setter")
    void setBgImg(py.k r100);

    @FieldName(name = "button_type#setter")
    void setButtonType(Long r100);

    @FieldName(name = "jump_url#setter")
    void setJumpUrl(String r100);

    @FieldName(name = "text#setter")
    void setText(List<? extends n> r100);
}
