package com.bytedance.android.livesdk.message.model;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/qb;", "Lvh7/c;", "Lcom/bytedance/android/livesdk/message/model/ok;", "getTextBg", "()Lcom/bytedance/android/livesdk/message/model/ok;", "setTextBg", "(Lcom/bytedance/android/livesdk/message/model/ok;)V", "getTextBg$annotations", "()V", "textBg", "", "getPlaceholder", "()J", "setPlaceholder", "(J)V", "getPlaceholder$annotations", GXTemplateKey.GAIAX_PLACEHOLDER, "", "getWrdsSubKeyFlex", "()Ljava/lang/String;", "wrdsSubKeyFlex", "getMessageIdFlex", "messageIdFlex", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface qb extends vh7.c<qb> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    long getMessageIdFlex();

    @FieldName(name = GXTemplateKey.GAIAX_PLACEHOLDER)
    long getPlaceholder();

    @FieldName(name = "text_bg")
    ok getTextBg();

    String getWrdsSubKeyFlex();

    @FieldName(name = "placeholder#setter")
    void setPlaceholder(long r100);

    @FieldName(name = "text_bg#setter")
    void setTextBg(ok r100);
}
