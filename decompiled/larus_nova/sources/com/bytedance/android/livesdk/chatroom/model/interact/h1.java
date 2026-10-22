package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/h1;", "Lvh7/c;", "", "getNumOfLink", "()Ljava/lang/Long;", "getNumOfLink$annotations", "()V", "numOfLink", "", "getAvgGrade", "()Ljava/lang/Float;", "getAvgGrade$annotations", "avgGrade", "getPaidCount", "getPaidCount$annotations", "paidCount", "getLimitedTime", "getLimitedTime$annotations", "limitedTime", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;", "getPaidTags", "()Ljava/util/List;", "getPaidTags$annotations", "paidTags", "", "getPaidDesc", "()Ljava/lang/String;", "getPaidDesc$annotations", "paidDesc", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface h1 extends vh7.c<h1> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avg_grade")
    Float getAvgGrade();

    @FieldName(name = "limited_time")
    Long getLimitedTime();

    @FieldName(name = "num_of_link")
    Long getNumOfLink();

    @FieldName(name = "paid_count")
    Long getPaidCount();

    @FieldName(name = "paid_desc")
    String getPaidDesc();

    @FieldName(name = "paid_tags")
    List<j1> getPaidTags();
}
