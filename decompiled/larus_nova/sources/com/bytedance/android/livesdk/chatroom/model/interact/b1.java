package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R$\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\r\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/b1;", "Lvh7/c;", "", "", "", "getSavedTagIds", "()Ljava/util/List;", "setSavedTagIds", "(Ljava/util/List;)V", "savedTagIds", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;", "getSavedTagInfos", "setSavedTagInfos", "savedTagInfos", "", "getSavedDesc", "()Ljava/lang/String;", "setSavedDesc", "(Ljava/lang/String;)V", "savedDesc", "getReviewedDesc", "setReviewedDesc", "reviewedDesc", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b1 extends vh7.c<b1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    String getReviewedDesc();

    String getSavedDesc();

    List<Long> getSavedTagIds();

    List<j1> getSavedTagInfos();

    void setReviewedDesc(String r100);

    void setSavedDesc(String r100);

    void setSavedTagIds(List<Long> r100);

    void setSavedTagInfos(List<? extends j1> r100);
}
