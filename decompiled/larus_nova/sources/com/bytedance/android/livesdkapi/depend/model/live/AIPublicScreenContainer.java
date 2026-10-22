package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import py.k;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.AIPublicScreenContainer")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001)B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R$\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R*\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AIPublicScreenContainer;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAIPublicScreenContainer;", "", "toString", "", "role", "J", "getRole", "()J", "setRole", "(J)V", "nickName", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "setNickName", "(Ljava/lang/String;)V", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "welcomeTip", "getWelcomeTip", "setWelcomeTip", "areaSchema", "getAreaSchema", "setAreaSchema", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/IAbility;", "abilities", "Ljava/util/List;", "getAbilities", "()Ljava/util/List;", "setAbilities", "(Ljava/util/List;)V", "<init>", "()V", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AIPublicScreenContainer extends FlexModelBase<IAIPublicScreenContainer> implements IAIPublicScreenContainer, h {
    public static final Companion Companion = null;
    public static final long ROLE_AI_BROKER = 2;
    public static final long ROLE_PUBLIC_SCREEN_HELPER = 0;
    public static final long ROLE_PUBLIC_SCREEN_HELPER_NEW = 1;

    @SerializedName("abilities")
    protected List<? extends IAbility> abilities;

    @SerializedName("area_schema")
    protected String areaSchema;

    @SerializedName("icon")
    protected k icon;

    @SerializedName("nick_name")
    protected String nickName;

    @SerializedName("role")
    protected long role;

    @SerializedName("welcome_tip")
    protected String welcomeTip;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/AIPublicScreenContainer$Companion;", "", "()V", "ROLE_AI_BROKER", "", "ROLE_PUBLIC_SCREEN_HELPER", "ROLE_PUBLIC_SCREEN_HELPER_NEW", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public AIPublicScreenContainer() {
        super(IAIPublicScreenContainer.class);
    }

    public String toString() {
        return "AIPublicScreenContainer{role=" + getRole() + ", nickName='" + getNickName() + "', icon=" + getIcon() + ", welcomeTip='" + getWelcomeTip() + "', areaSchema='" + getAreaSchema() + "', abilities=" + getAbilities() + '}';
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public List<IAbility> getAbilities() {
        return this.abilities;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public String getAreaSchema() {
        return this.areaSchema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public String getNickName() {
        return this.nickName;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public long getRole() {
        return this.role;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public String getWelcomeTip() {
        return this.welcomeTip;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    public AIPublicScreenContainer(g r100) {
        super(IAIPublicScreenContainer.class);
        this.abilities = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L14;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L7;
        };
    L8:
        this.abilities.add(f.a(r100, IAbility.class));
        goto L3
    L9:
        this.areaSchema = am3.h.c(r100);
        goto L3
    L10:
        this.welcomeTip = am3.h.c(r100);
        goto L3
    L11:
        this.icon = f.a(r100, k.class);
        goto L3
    L12:
        this.nickName = am3.h.c(r100);
        goto L3
    L13:
        this.role = r100.j();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L14:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public void setAbilities(List<? extends IAbility> r100) {
        this.abilities = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public void setAreaSchema(String r100) {
        this.areaSchema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public void setIcon(k r100) {
        this.icon = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public void setNickName(String r100) {
        this.nickName = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public void setRole(long r100) {
        this.role = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IAIPublicScreenContainer
    public void setWelcomeTip(String r100) {
        this.welcomeTip = r100;
    }
}
