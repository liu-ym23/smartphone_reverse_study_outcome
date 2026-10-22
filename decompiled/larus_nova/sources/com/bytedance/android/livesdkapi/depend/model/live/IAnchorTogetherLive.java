package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019R6\u0010(\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IAnchorTogetherLive;", "Lvh7/c;", "", "getLiveTogetherStatus", "()J", "setLiveTogetherStatus", "(J)V", "getLiveTogetherStatus$annotations", "()V", "liveTogetherStatus", "getEntranceScene", "setEntranceScene", "getEntranceScene$annotations", "entranceScene", "", "getShowEntrance", "()Z", "setShowEntrance", "(Z)V", "getShowEntrance$annotations", "showEntrance", "", "getAvatarTitle", "()Ljava/lang/String;", "setAvatarTitle", "(Ljava/lang/String;)V", "getAvatarTitle$annotations", "avatarTitle", "getSchemaUrl", "setSchemaUrl", "getSchemaUrl$annotations", "schemaUrl", "", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTogetherAnchor", "()Ljava/util/List;", "setTogetherAnchor", "(Ljava/util/List;)V", "getTogetherAnchor$annotations", "togetherAnchor", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IAnchorTogetherLive extends c<IAnchorTogetherLive> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "title")
        public static /* synthetic */ void getAvatarTitle$annotations() {
        }

        @FieldName(name = "scene")
        public static /* synthetic */ void getEntranceScene$annotations() {
        }

        @FieldName(name = "is_together_live")
        public static /* synthetic */ void getLiveTogetherStatus$annotations() {
        }

        @FieldName(name = a.KEY_SCHEMA_URL)
        public static /* synthetic */ void getSchemaUrl$annotations() {
        }

        @FieldName(name = a.KEY_IS_SHOW)
        public static /* synthetic */ void getShowEntrance$annotations() {
        }

        @FieldName(name = "user_list")
        public static /* synthetic */ void getTogetherAnchor$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "title")
    String getAvatarTitle();

    @FieldName(name = "scene")
    long getEntranceScene();

    @FieldName(name = "is_together_live")
    long getLiveTogetherStatus();

    @FieldName(name = a.KEY_SCHEMA_URL)
    String getSchemaUrl();

    @FieldName(name = a.KEY_IS_SHOW)
    boolean getShowEntrance();

    @FieldName(name = "user_list")
    List<IBaseUser> getTogetherAnchor();

    @FieldName(name = "title#setter")
    void setAvatarTitle(String r100);

    @FieldName(name = "scene#setter")
    void setEntranceScene(long r100);

    @FieldName(name = "is_together_live#setter")
    void setLiveTogetherStatus(long r100);

    @FieldName(name = "schema_url#setter")
    void setSchemaUrl(String r100);

    @FieldName(name = "is_show#setter")
    void setShowEntrance(boolean r100);

    @FieldName(name = "user_list#setter")
    void setTogetherAnchor(List<? extends IBaseUser> r100);
}
