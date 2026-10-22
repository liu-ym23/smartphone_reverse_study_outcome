package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\u00020\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0015\u0010\u0012R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0018\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b \u0010!R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0006\u001a\u0004\b$\u0010\u0004R\u001c\u0010)\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0006\u001a\u0004\b'\u0010\rR\u001c\u0010,\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0006\u001a\u0004\b*\u0010!¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IPart;", "Lvh7/c;", "", "getFontSize", "()Ljava/lang/Integer;", "getFontSize$annotations", "()V", "fontSize", "getInterval", "getInterval$annotations", VideoThumbInfo.KEY_INTERVAL, "", "getText", "()Ljava/lang/String;", "getText$annotations", "text", "", "getCuttable", "()Z", "getCuttable$annotations", "cuttable", "getDeleted", "getDeleted$annotations", "deleted", "getFontColor", "getFontColor$annotations", "fontColor", "getBold", "()Ljava/lang/Boolean;", "getBold$annotations", CommodityText.BOLD, "Lpy/k;", "getImage", "()Lpy/k;", "getImage$annotations", "image", "getPartType", "getPartType$annotations", "partType", "getBackgroundColor", "getBackgroundColor$annotations", "backgroundColor", "getLeftImage", "getLeftImage$annotations", "leftImage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IPart extends c<IPart> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "background_color")
        public static /* synthetic */ void getBackgroundColor$annotations() {
        }

        @FieldName(name = CommodityText.BOLD)
        public static /* synthetic */ void getBold$annotations() {
        }

        @FieldName(name = "cuttable")
        public static /* synthetic */ void getCuttable$annotations() {
        }

        @FieldName(name = "deleted")
        public static /* synthetic */ void getDeleted$annotations() {
        }

        @FieldName(name = "font_color")
        public static /* synthetic */ void getFontColor$annotations() {
        }

        @FieldName(name = "fontSize")
        public static /* synthetic */ void getFontSize$annotations() {
        }

        @FieldName(name = "image")
        public static /* synthetic */ void getImage$annotations() {
        }

        @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
        public static /* synthetic */ void getInterval$annotations() {
        }

        @FieldName(name = "left_image")
        public static /* synthetic */ void getLeftImage$annotations() {
        }

        @FieldName(name = "part_type")
        public static /* synthetic */ void getPartType$annotations() {
        }

        @FieldName(name = "text")
        public static /* synthetic */ void getText$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "background_color")
    String getBackgroundColor();

    @FieldName(name = CommodityText.BOLD)
    Boolean getBold();

    @FieldName(name = "cuttable")
    boolean getCuttable();

    @FieldName(name = "deleted")
    boolean getDeleted();

    @FieldName(name = "font_color")
    String getFontColor();

    @FieldName(name = "fontSize")
    Integer getFontSize();

    @FieldName(name = "image")
    k getImage();

    @FieldName(name = VideoThumbInfo.KEY_INTERVAL)
    Integer getInterval();

    @FieldName(name = "left_image")
    k getLeftImage();

    @FieldName(name = "part_type")
    Integer getPartType();

    @FieldName(name = "text")
    String getText();
}
