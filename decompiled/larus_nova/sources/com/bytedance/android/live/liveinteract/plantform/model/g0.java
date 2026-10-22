package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\bg\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00011R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\b\u001a\u0004\b\u0019\u0010\u0004\"\u0004\b\u001a\u0010\u0006R*\u0010$\u001a\n\u0018\u00010\u001dj\u0004\u0018\u0001`\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\b\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020%8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\b\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010/\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\b\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000e¨\u00062"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/model/g0;", "Lvh7/c;", "", "getTagType", "()J", "setTagType", "(J)V", "getTagType$annotations", "()V", "tagType", "", "getPositionTagName", "()Ljava/lang/String;", "setPositionTagName", "(Ljava/lang/String;)V", "getPositionTagName$annotations", "positionTagName", "getTextColor", "setTextColor", "getTextColor$annotations", "textColor", "getBgColor", "setBgColor", "getBgColor$annotations", "bgColor", "getTagTypeId", "setTagTypeId", "getTagTypeId$annotations", "tagTypeId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBgColorImg", "()Lpy/k;", "setBgColorImg", "(Lpy/k;)V", "getBgColorImg$annotations", "bgColorImg", "", "getOpenTagDescPage", "()Z", "setOpenTagDescPage", "(Z)V", "getOpenTagDescPage$annotations", "openTagDescPage", "getSchema", "setSchema", "getSchema$annotations", "schema", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface g0 extends vh7.c<g0> {
    public static final a Companion = null;
    public static final int HASH_CODE_37 = 37;
    public static final long TAG_TYPE_ANCHOR = 3;
    public static final long TAG_TYPE_HOST = 1;
    public static final long TAG_TYPE_RESIDENT_SINGER = 2;
    public static final long TYPE_ADVENTURE_AVTING = 11;
    public static final long TYPE_ADVENTURE_INVITING = 10;
    public static final long TYPE_ADVENTURE_TOAVT = 9;
    public static final long TYPE_HIGH_SCORE_SINGER = 4;
    public static final long TYPE_KSONG_GENERAL = 5;
    public static final int TYPE_MULTI_CHORUS_LEADER_SINGER = 13;
    public static final int TYPE_MULTI_CHORUS_VICE_SINGER = 14;
    public static final long serialVersionUID = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f77235a = null;

        public a() {
        }

        static {
            f77235a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f77235a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "bg_color_value")
    String getBgColor();

    @FieldName(name = "bg_color_img")
    py.k getBgColorImg();

    @FieldName(name = "open_tag_desc_page")
    boolean getOpenTagDescPage();

    @FieldName(name = "tag_name")
    String getPositionTagName();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    long getTagType();

    @FieldName(name = "tag_type_id")
    long getTagTypeId();

    @FieldName(name = "text_color_value")
    String getTextColor();

    @FieldName(name = "bg_color_value#setter")
    void setBgColor(String r100);

    @FieldName(name = "bg_color_img#setter")
    void setBgColorImg(py.k r100);

    @FieldName(name = "open_tag_desc_page#setter")
    void setOpenTagDescPage(boolean r100);

    @FieldName(name = "tag_name#setter")
    void setPositionTagName(String r100);

    @FieldName(name = "schema#setter")
    void setSchema(String r100);

    @FieldName(name = "tag_type#setter")
    void setTagType(long r100);

    @FieldName(name = "tag_type_id#setter")
    void setTagTypeId(long r100);

    @FieldName(name = "text_color_value#setter")
    void setTextColor(String r100);
}
