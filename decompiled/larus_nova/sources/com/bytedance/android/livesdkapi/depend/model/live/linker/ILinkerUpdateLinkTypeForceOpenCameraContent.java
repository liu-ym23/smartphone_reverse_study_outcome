package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.link.model.bridge.j1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001a\u0010\u0012R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001d\u0010\u0012¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerUpdateLinkTypeForceOpenCameraContent;", "Lvh7/c;", "", "getFromUserId", "()Ljava/lang/Long;", "getFromUserId$annotations", "()V", "fromUserId", "getToUserId", "getToUserId$annotations", "toUserId", "", "getLinkType", "()Ljava/lang/Integer;", "getLinkType$annotations", "linkType", "", "getToast", "()Ljava/lang/String;", "getToast$annotations", "toast", "Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getLinkmicMediaInfo", "()Lcom/bytedance/android/livesdk/link/model/bridge/j1;", "getLinkmicMediaInfo$annotations", "linkmicMediaInfo", "getFromOpenId", "getFromOpenId$annotations", "fromOpenId", "getToOpenId", "getToOpenId$annotations", "toOpenId", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerUpdateLinkTypeForceOpenCameraContent extends c<ILinkerUpdateLinkTypeForceOpenCameraContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "from_open_id")
        public static /* synthetic */ void getFromOpenId$annotations() {
        }

        @FieldName(name = "from_user_id")
        public static /* synthetic */ void getFromUserId$annotations() {
        }

        @FieldName(name = "link_type")
        public static /* synthetic */ void getLinkType$annotations() {
        }

        @FieldName(name = "linkmic_media_info")
        public static /* synthetic */ void getLinkmicMediaInfo$annotations() {
        }

        @FieldName(name = "to_open_id")
        public static /* synthetic */ void getToOpenId$annotations() {
        }

        @FieldName(name = a.KEY_TO_USER_ID)
        public static /* synthetic */ void getToUserId$annotations() {
        }

        @FieldName(name = "toast")
        public static /* synthetic */ void getToast$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "from_open_id")
    String getFromOpenId();

    @FieldName(name = "from_user_id")
    Long getFromUserId();

    @FieldName(name = "link_type")
    Integer getLinkType();

    @FieldName(name = "linkmic_media_info")
    j1 getLinkmicMediaInfo();

    @FieldName(name = "to_open_id")
    String getToOpenId();

    @FieldName(name = a.KEY_TO_USER_ID)
    Long getToUserId();

    @FieldName(name = "toast")
    String getToast();
}
