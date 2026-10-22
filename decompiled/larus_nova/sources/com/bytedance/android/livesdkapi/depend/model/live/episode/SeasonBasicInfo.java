package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBasicInfo;", "Lvh7/c;", "", "getSeasonType", "()Ljava/lang/Integer;", "getSeasonType$annotations", "()V", "seasonType", "SeasonTypeEnum", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface SeasonBasicInfo extends c<SeasonBasicInfo> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        @FieldName(name = "season_type")
        public static /* synthetic */ void getSeasonType$annotations() {
        }

        @FieldName(name = "season_type")
        public static Integer getSeasonType(SeasonBasicInfo r100) {
            return 0;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/SeasonBasicInfo$SeasonTypeEnum;", "", "()V", "MOVIE", "", "TELEPLAY", "VS", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SeasonTypeEnum {
        public static final SeasonTypeEnum INSTANCE = null;
        public static final int MOVIE = 3;
        public static final int TELEPLAY = 2;
        public static final int VS = 1;

        private SeasonTypeEnum() {
        }

        static {
            INSTANCE = new SeasonTypeEnum();
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "season_type")
    Integer getSeasonType();
}
