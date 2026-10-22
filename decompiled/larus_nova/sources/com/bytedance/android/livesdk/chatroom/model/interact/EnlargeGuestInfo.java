package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001f\u0010\b\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019¨\u0006\""}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "Lvh7/c;", "", "getEnlargeGuestType", "()I", "setEnlargeGuestType", "(I)V", "getEnlargeGuestType$annotations", "()V", "enlargeGuestType", "", "getSourceUILayoutMaxMembers", "()J", "setSourceUILayoutMaxMembers", "(J)V", "getSourceUILayoutMaxMembers$annotations", "sourceUILayoutMaxMembers", "getMaxMemberExceptEnlarge", "setMaxMemberExceptEnlarge", "getMaxMemberExceptEnlarge$annotations", "maxMemberExceptEnlarge", "", "get_enlargedUserIdList", "()Ljava/util/List;", "set_enlargedUserIdList", "(Ljava/util/List;)V", "get_enlargedUserIdList$annotations", "_enlargedUserIdList", "", "get_enlargedOpenIdList", "set_enlargedOpenIdList", "get_enlargedOpenIdList$annotations", "_enlargedOpenIdList", "EnlargeGuestType", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface EnlargeGuestInfo extends vh7.c<EnlargeGuestInfo> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo$EnlargeGuestType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "EnlargeGuestType_Unkown", "EnlargeGuestType_Single", "EnlargeGuestType_Double", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum EnlargeGuestType extends Enum<EnlargeGuestType> {
        public static final a Companion = null;
        public static final EnlargeGuestType EnlargeGuestType_Double = null;
        public static final EnlargeGuestType EnlargeGuestType_Single = null;
        public static final EnlargeGuestType EnlargeGuestType_Unkown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnlargeGuestType[] f106926a = null;

        public static final class a {
            public a() {
            }
        }

        static {
            EnlargeGuestType r100 = new EnlargeGuestType("EnlargeGuestType_Unkown", 0);
            EnlargeGuestType_Unkown = r100;
            EnlargeGuestType r101 = new EnlargeGuestType("EnlargeGuestType_Single", 1);
            EnlargeGuestType_Single = r101;
            EnlargeGuestType r102 = new EnlargeGuestType("EnlargeGuestType_Double", 2);
            EnlargeGuestType_Double = r102;
            f106926a = new EnlargeGuestType[]{r100, r101, r102};
            Companion = new a();
        }

        public static EnlargeGuestType valueOf(String r100) {
            return (EnlargeGuestType) r27.a.a(EnlargeGuestType.class, r100);
        }

        public static EnlargeGuestType[] values() {
            return (EnlargeGuestType[]) f106926a.clone();
        }

        public EnlargeGuestType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "guest_type")
    int getEnlargeGuestType();

    @FieldName(name = "max_members_except_enlarge")
    long getMaxMemberExceptEnlarge();

    @FieldName(name = "source_ui_layout_max_members")
    long getSourceUILayoutMaxMembers();

    @FieldName(name = "enlarged_open_ids")
    List<String> get_enlargedOpenIdList();

    @FieldName(name = "enlarged_user_ids")
    List<Long> get_enlargedUserIdList();

    @FieldName(name = "guest_type#setter")
    void setEnlargeGuestType(int r100);

    @FieldName(name = "max_members_except_enlarge#setter")
    void setMaxMemberExceptEnlarge(long r100);

    @FieldName(name = "source_ui_layout_max_members#setter")
    void setSourceUILayoutMaxMembers(long r100);

    @FieldName(name = "enlarged_open_ids#setter")
    void set_enlargedOpenIdList(List<String> r100);

    @FieldName(name = "enlarged_user_ids#setter")
    void set_enlargedUserIdList(List<Long> r100);
}
