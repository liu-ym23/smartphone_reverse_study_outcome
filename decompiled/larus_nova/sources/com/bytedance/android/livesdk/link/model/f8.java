package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001e\u0010\u0010\u001a\u00060\u000bj\u0002`\f8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/f8;", "Lvh7/c;", "", "getCount", "()J", "getCount$annotations", "()V", "count", "getTargetCount", "getTargetCount$annotations", "targetCount", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDesc", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDesc$annotations", SocialConstants.PARAM_APP_DESC, "", "getTitle", "()Ljava/lang/String;", "getTitle$annotations", "title", "", "getShowProgress", "()Z", "getShowProgress$annotations", "showProgress", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f8 extends vh7.c<f8> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "cur_count")
    long getCount();

    @FieldName(name = SocialConstants.PARAM_APP_DESC)
    com.bytedance.android.live.base.model.message.a5 getDesc();

    @FieldName(name = "show_progress")
    boolean getShowProgress();

    @FieldName(name = "target_count")
    long getTargetCount();

    @FieldName(name = "title")
    String getTitle();
}
