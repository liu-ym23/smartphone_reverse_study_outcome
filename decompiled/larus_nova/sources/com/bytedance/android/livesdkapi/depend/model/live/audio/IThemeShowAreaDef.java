package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IThemeShowAreaDef;", "", "h", "", "getH$annotations", "()V", "getH", "()J", "w", "getW$annotations", "getW", "x", "getX$annotations", "getX", "y", "getY$annotations", "getY", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IThemeShowAreaDef {

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

    long getH();

    long getW();

    long getX();

    long getY();
}
