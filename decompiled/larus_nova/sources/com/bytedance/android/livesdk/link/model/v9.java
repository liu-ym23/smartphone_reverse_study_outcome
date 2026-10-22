package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/v9;", "Lvh7/c;", "", "getTitle", "()Ljava/lang/String;", "getTitle$annotations", "()V", "title", "getDesc", "getDesc$annotations", SocialConstants.PARAM_APP_DESC, "getRuleUrl", "getRuleUrl$annotations", "ruleUrl", "Lcom/bytedance/android/livesdk/link/model/p3;", "getButton", "()Lcom/bytedance/android/livesdk/link/model/p3;", "getButton$annotations", "button", "Lcom/bytedance/android/livesdk/link/model/b4;", "getCountDown", "()Lcom/bytedance/android/livesdk/link/model/b4;", "getCountDown$annotations", "countDown", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface v9 extends vh7.c<v9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "button")
    p3 getButton();

    @FieldName(name = "count_down")
    b4 getCountDown();

    @FieldName(name = SocialConstants.PARAM_APP_DESC)
    String getDesc();

    @FieldName(name = "help_icon_url")
    String getRuleUrl();

    @FieldName(name = "title")
    String getTitle();
}
