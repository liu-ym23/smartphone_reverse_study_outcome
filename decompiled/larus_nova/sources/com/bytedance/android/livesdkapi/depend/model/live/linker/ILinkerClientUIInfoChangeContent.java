package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.message.ClientUIInfo;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR(\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerClientUIInfoChangeContent;", "Lvh7/c;", "", "getUiLayout", "()Ljava/lang/Long;", "getUiLayout$annotations", "()V", "uiLayout", "getVersion", "getVersion$annotations", "version", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "getLinkedListUsers", "()Ljava/util/List;", "getLinkedListUsers$annotations", "linkedListUsers", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo", "()Lcom/bytedance/android/livesdkapi/depend/message/ClientUIInfo;", "getClientUIInfo$annotations", "clientUIInfo", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerClientUIInfoChangeContent extends c<ILinkerClientUIInfoChangeContent> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "client_ui_info")
        public static /* synthetic */ void getClientUIInfo$annotations() {
        }

        @FieldName(name = "linked_list_users")
        public static /* synthetic */ void getLinkedListUsers$annotations() {
        }

        @FieldName(name = "linker_content_map")
        public static /* synthetic */ void getLinkerContentMap$annotations() {
        }

        @FieldName(name = "ui_layout")
        public static /* synthetic */ void getUiLayout$annotations() {
        }

        @FieldName(name = "version")
        public static /* synthetic */ void getVersion$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "client_ui_info")
    ClientUIInfo getClientUIInfo();

    @FieldName(name = "linked_list_users")
    List<k> getLinkedListUsers();

    @FieldName(name = "linker_content_map")
    Map<Long, RoomLinkerContent> getLinkerContentMap();

    @FieldName(name = "ui_layout")
    Long getUiLayout();

    @FieldName(name = "version")
    Long getVersion();
}
