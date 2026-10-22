package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\t\u0010\u0005R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0007\u001a\u0004\b\f\u0010\u0005R\u001a\u0010\u0011\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowArea;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowAreaDef;", "", "getX", "()J", "getX$annotations", "()V", "x", "getY", "getY$annotations", "y", "getH", "getH$annotations", "h", "getW", "getW$annotations", "w", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IThemeShowArea extends c<IThemeShowArea>, IThemeShowAreaDef {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "h")
        public static /* synthetic */ void getH$annotations() {
        }

        @FieldName(name = "w")
        public static /* synthetic */ void getW$annotations() {
        }

        @FieldName(name = "x")
        public static /* synthetic */ void getX$annotations() {
        }

        @FieldName(name = "y")
        public static /* synthetic */ void getY$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    @FieldName(name = "h")
    long getH();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    @FieldName(name = "w")
    long getW();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    @FieldName(name = "x")
    long getX();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowAreaDef
    @FieldName(name = "y")
    long getY();
}
