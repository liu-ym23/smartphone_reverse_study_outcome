package com.bytedance.android.live.recharge.platform.business.model.exchange;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/exchange/a;", "Lvh7/c;", "Lcom/bytedance/android/live/recharge/platform/business/model/exchange/c;", "", "getUserType", "()I", "getUserType$annotations", "()V", "userType", "", "getPrompt", "()Ljava/lang/String;", "getPrompt$annotations", EventConstant.Key.RETAIN_PROMPT, "getPromptBody", "getPromptBody$annotations", "promptBody", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface a extends vh7.c<a>, c {

    /* JADX INFO: renamed from: com.bytedance.android.live.recharge.platform.business.model.exchange.a$a, reason: collision with other inner class name */
    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C1386a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ String getOrderId();

    @FieldName(name = EventConstant.Key.RETAIN_PROMPT)
    String getPrompt();

    @FieldName(name = "prompt_body")
    String getPromptBody();

    @FieldName(name = "user_type")
    int getUserType();
}
