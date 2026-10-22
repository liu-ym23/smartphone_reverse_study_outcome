package com.bytedance.android.live.profit.scoreboard.dto;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/dto/f;", "Lvh7/c;", "", "getIndex", "()J", "getIndex$annotations", "()V", "index", "", "getName", "()Ljava/lang/String;", "getName$annotations", "name", "getDescription", "getDescription$annotations", "description", "", "Lcom/bytedance/android/live/profit/scoreboard/dto/c;", "getGiftChoices", "()Ljava/util/List;", "getGiftChoices$annotations", "giftChoices", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface f extends vh7.c<f> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "description")
    String getDescription();

    @FieldName(name = "gift_choices")
    List<c> getGiftChoices();

    @FieldName(name = "index")
    long getIndex();

    @FieldName(name = "name")
    String getName();
}
