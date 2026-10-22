package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00138&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\nR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001b\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewButtonData;", "Lvh7/c;", "", "getType", "()Ljava/lang/Long;", "getType$annotations", "()V", "type", "", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "getLotteryId", "getLotteryId$annotations", "lotteryId", "getBoxId", "getBoxId$annotations", "boxId", "", "getButtonPriority", "()Ljava/lang/Integer;", "getButtonPriority$annotations", "buttonPriority", "getEnterSchema", "getEnterSchema$annotations", "enterSchema", "getExtra", "getExtra$annotations", "extra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPreviewButtonData extends c<IPreviewButtonData> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "box_id")
        public static /* synthetic */ void getBoxId$annotations() {
        }

        @FieldName(name = "button_priority")
        public static /* synthetic */ void getButtonPriority$annotations() {
        }

        @FieldName(name = "enter_schema")
        public static /* synthetic */ void getEnterSchema$annotations() {
        }

        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "lottery_id")
        public static /* synthetic */ void getLotteryId$annotations() {
        }

        @FieldName(name = "text")
        public static /* synthetic */ void getText$annotations() {
        }

        @FieldName(name = "type")
        public static /* synthetic */ void getType$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "box_id")
    Long getBoxId();

    @FieldName(name = "button_priority")
    Integer getButtonPriority();

    @FieldName(name = "enter_schema")
    String getEnterSchema();

    @FieldName(name = "extra")
    String getExtra();

    @FieldName(name = "lottery_id")
    Long getLotteryId();

    @FieldName(name = "text")
    String getText();

    @FieldName(name = "type")
    Long getType();
}
