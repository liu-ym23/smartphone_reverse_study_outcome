package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.live.base.annotation.ForMain;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001)R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001b\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR$\u0010\u001f\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR6\u0010(\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010 j\n\u0012\u0004\u0012\u00020!\u0018\u0001`\"8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b'\u0010\b\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IAIPublicScreenContainer;", "Lvh7/c;", "", "getRole", "()J", "setRole", "(J)V", "getRole$annotations", "()V", "role", "", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "getNickName$annotations", "nickName", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "getIcon$annotations", "icon", "getWelcomeTip", "setWelcomeTip", "getWelcomeTip$annotations", "welcomeTip", "getAreaSchema", "setAreaSchema", "getAreaSchema$annotations", "areaSchema", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAbility;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAbilities", "()Ljava/util/List;", "setAbilities", "(Ljava/util/List;)V", "getAbilities$annotations", "abilities", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@ForMain
public interface IAIPublicScreenContainer extends c<IAIPublicScreenContainer> {
    public static final Companion Companion = null;
    public static final long ROLE_AI_BROKER = 2;
    public static final long ROLE_PUBLIC_SCREEN_HELPER = 0;
    public static final long ROLE_PUBLIC_SCREEN_HELPER_NEW = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/IAIPublicScreenContainer$Companion;", "", "()V", "ROLE_AI_BROKER", "", "ROLE_PUBLIC_SCREEN_HELPER", "ROLE_PUBLIC_SCREEN_HELPER_NEW", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final long ROLE_AI_BROKER = 2;
        public static final long ROLE_PUBLIC_SCREEN_HELPER = 0;
        public static final long ROLE_PUBLIC_SCREEN_HELPER_NEW = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "abilities")
        public static /* synthetic */ void getAbilities$annotations() {
        }

        @FieldName(name = "area_schema")
        public static /* synthetic */ void getAreaSchema$annotations() {
        }

        @FieldName(name = "icon")
        public static /* synthetic */ void getIcon$annotations() {
        }

        @FieldName(name = "nick_name")
        public static /* synthetic */ void getNickName$annotations() {
        }

        @FieldName(name = "role")
        public static /* synthetic */ void getRole$annotations() {
        }

        @FieldName(name = "welcome_tip")
        public static /* synthetic */ void getWelcomeTip$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "abilities")
    List<IAbility> getAbilities();

    @FieldName(name = "area_schema")
    String getAreaSchema();

    @FieldName(name = "icon")
    k getIcon();

    @FieldName(name = "nick_name")
    String getNickName();

    @FieldName(name = "role")
    long getRole();

    @FieldName(name = "welcome_tip")
    String getWelcomeTip();

    @FieldName(name = "abilities#setter")
    void setAbilities(List<? extends IAbility> r100);

    @FieldName(name = "area_schema#setter")
    void setAreaSchema(String r100);

    @FieldName(name = "icon#setter")
    void setIcon(k r100);

    @FieldName(name = "nick_name#setter")
    void setNickName(String r100);

    @FieldName(name = "role#setter")
    void setRole(long r100);

    @FieldName(name = "welcome_tip#setter")
    void setWelcomeTip(String r100);
}
