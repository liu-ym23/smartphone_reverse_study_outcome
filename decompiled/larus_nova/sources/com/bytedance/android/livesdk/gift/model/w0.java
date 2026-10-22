package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R2\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0012\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0011\u0010\n\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\n\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001d\u001a\u0004\u0018\u00010\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R*\u0010%\u001a\n\u0018\u00010\u001ej\u0004\u0018\u0001`\u001f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\n\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010)\u001a\u00020\f8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b(\u0010\n\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\u0010R\"\u0010+\u001a\u00020*8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b/\u0010\n\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00103\u001a\u00020\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b2\u0010\n\u001a\u0004\b0\u0010\u0015\"\u0004\b1\u0010\u0017¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/w0;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/gift/model/y0;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getGroupShowUsers", "()Ljava/util/List;", "setGroupShowUsers", "(Ljava/util/List;)V", "getGroupShowUsers$annotations", "()V", "groupShowUsers", "", "getDescriptionStyle", "()J", "setDescriptionStyle", "(J)V", "getDescriptionStyle$annotations", "descriptionStyle", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "getTitle$annotations", "title", "getSubTitle", "setSubTitle", "getSubTitle$annotations", "subTitle", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getBackgroundImage", "()Lpy/k;", "setBackgroundImage", "(Lpy/k;)V", "getBackgroundImage$annotations", "backgroundImage", "getGroupShowScene", "setGroupShowScene", "getGroupShowScene$annotations", "groupShowScene", "", "isLiveShow", "()Z", "setLiveShow", "(Z)V", "isLiveShow$annotations", "getToastText", "setToastText", "getToastText$annotations", "toastText", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w0 extends vh7.c<w0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "background_image")
    py.k getBackgroundImage();

    @FieldName(name = "description_style")
    long getDescriptionStyle();

    @FieldName(name = "group_show_scene")
    long getGroupShowScene();

    @FieldName(name = "group_show_users")
    List<y0> getGroupShowUsers();

    @FieldName(name = BdpAppEventConstant.PARAMS_SUB_TITLE)
    String getSubTitle();

    @FieldName(name = "title")
    String getTitle();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    String getToastText();

    @FieldName(name = "is_live_show")
    boolean isLiveShow();

    @FieldName(name = "background_image#setter")
    void setBackgroundImage(py.k r100);

    @FieldName(name = "description_style#setter")
    void setDescriptionStyle(long r100);

    @FieldName(name = "group_show_scene#setter")
    void setGroupShowScene(long r100);

    @FieldName(name = "group_show_users#setter")
    void setGroupShowUsers(List<? extends y0> r100);

    @FieldName(name = "is_live_show#setter")
    void setLiveShow(boolean r100);

    @FieldName(name = "sub_title#setter")
    void setSubTitle(String r100);

    @FieldName(name = "title#setter")
    void setTitle(String r100);

    @FieldName(name = "toast_text#setter")
    void setToastText(String r100);
}
