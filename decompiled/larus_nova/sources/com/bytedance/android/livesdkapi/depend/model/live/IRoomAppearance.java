package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR6\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\b\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR6\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u001e\u0018\u0001`\u00178&@&X§\u000e¢\u0006\u0012\u0012\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR$\u0010)\u001a\u0004\u0018\u00010#8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\b\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010-\u001a\u0004\u0018\u00010#8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b,\u0010\b\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R$\u00101\u001a\u0004\u0018\u00010#8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b0\u0010\b\u001a\u0004\b.\u0010%\"\u0004\b/\u0010'¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomAppearance;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IHeadBubble;", "getBubble", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IHeadBubble;", "setBubble", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IHeadBubble;)V", "getBubble$annotations", "()V", "bubble", "", "getPreviewStyle", "()J", "setPreviewStyle", "(J)V", "getPreviewStyle$annotations", "previewStyle", "getMTopRightShowType", "setMTopRightShowType", "getMTopRightShowType$annotations", "mTopRightShowType", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getToolbarConfigList", "()Ljava/util/List;", "setToolbarConfigList", "(Ljava/util/List;)V", "getToolbarConfigList$annotations", "toolbarConfigList", "Lcom/bytedance/android/livesdkapi/depend/model/live/IContentTag;", "getContentTags", "setContentTags", "getContentTags$annotations", "contentTags", "Lpy/k;", "getCoverDynamicMask", "()Lpy/k;", "setCoverDynamicMask", "(Lpy/k;)V", "getCoverDynamicMask$annotations", "coverDynamicMask", "getHorizontalBackground", "setHorizontalBackground", "getHorizontalBackground$annotations", "horizontalBackground", "getBlurImage", "setBlurImage", "getBlurImage$annotations", "blurImage", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IRoomAppearance extends c<IRoomAppearance> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "blur_placeholder_img")
        public static /* synthetic */ void getBlurImage$annotations() {
        }

        @FieldName(name = "head_bubble")
        public static /* synthetic */ void getBubble$annotations() {
        }

        @FieldName(name = "content_tags")
        public static /* synthetic */ void getContentTags$annotations() {
        }

        @FieldName(name = "cover_dynamic_mask")
        public static /* synthetic */ void getCoverDynamicMask$annotations() {
        }

        @FieldName(name = "horizontal_background")
        public static /* synthetic */ void getHorizontalBackground$annotations() {
        }

        @FieldName(name = "up_right_stats_display_type")
        public static /* synthetic */ void getMTopRightShowType$annotations() {
        }

        @FieldName(name = "preview_style")
        public static /* synthetic */ void getPreviewStyle$annotations() {
        }

        @FieldName(name = "toolbar_list")
        public static /* synthetic */ void getToolbarConfigList$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "blur_placeholder_img")
    k getBlurImage();

    @FieldName(name = "head_bubble")
    IHeadBubble getBubble();

    @FieldName(name = "content_tags")
    List<IContentTag> getContentTags();

    @FieldName(name = "cover_dynamic_mask")
    k getCoverDynamicMask();

    @FieldName(name = "horizontal_background")
    k getHorizontalBackground();

    @FieldName(name = "up_right_stats_display_type")
    long getMTopRightShowType();

    @FieldName(name = "preview_style")
    long getPreviewStyle();

    @FieldName(name = "toolbar_list")
    List<IVSToolbarConfigData> getToolbarConfigList();

    @FieldName(name = "blur_placeholder_img#setter")
    void setBlurImage(k r100);

    @FieldName(name = "head_bubble#setter")
    void setBubble(IHeadBubble r100);

    @FieldName(name = "content_tags#setter")
    void setContentTags(List<? extends IContentTag> r100);

    @FieldName(name = "cover_dynamic_mask#setter")
    void setCoverDynamicMask(k r100);

    @FieldName(name = "horizontal_background#setter")
    void setHorizontalBackground(k r100);

    @FieldName(name = "up_right_stats_display_type#setter")
    void setMTopRightShowType(long r100);

    @FieldName(name = "preview_style#setter")
    void setPreviewStyle(long r100);

    @FieldName(name = "toolbar_list#setter")
    void setToolbarConfigList(List<? extends IVSToolbarConfigData> r100);
}
