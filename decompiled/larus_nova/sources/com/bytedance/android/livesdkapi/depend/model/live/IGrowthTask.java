package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004R6\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u000f8&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IGrowthTask;", "Lvh7/c;", "", "getTaskKey", "()Ljava/lang/String;", "getTaskKey$annotations", "()V", "taskKey", "getMainText", "getMainText$annotations", n.KEY_MAIN_TEXT, "getSubText", "getSubText$annotations", n.KEY_SUB_TEXT, "", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getExtra", "()Ljava/util/Map;", "getExtra$annotations", "extra", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IGrowthTask extends c<IGrowthTask> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "extra")
        public static /* synthetic */ void getExtra$annotations() {
        }

        @FieldName(name = "main_text")
        public static /* synthetic */ void getMainText$annotations() {
        }

        @FieldName(name = "sub_text")
        public static /* synthetic */ void getSubText$annotations() {
        }

        @FieldName(name = DbJsonConstants.DBJSON_KEY_TASK_KEY)
        public static /* synthetic */ void getTaskKey$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "extra")
    Map<String, String> getExtra();

    @FieldName(name = "main_text")
    String getMainText();

    @FieldName(name = "sub_text")
    String getSubText();

    @FieldName(name = DbJsonConstants.DBJSON_KEY_TASK_KEY)
    String getTaskKey();
}
