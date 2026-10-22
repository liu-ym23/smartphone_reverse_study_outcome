package com.bytedance.android.livesdkapi.depend.model.live.linker;

import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\r\u001a\u00020\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0015\u0010\u0012RB\u0010\u001e\u001a*\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\u0014\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/ILinkerLinkedListChangeContentDef;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getVersion", "()J", "getVersion$annotations", "()V", "version", "", "getPushType", "()I", "getPushType$annotations", "pushType", "", "Lcom/bytedance/android/livesdk/link/model/bridge/k;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getLinkUsers", "()Ljava/util/List;", "getLinkUsers$annotations", "linkUsers", "getPreOnlineUsers", "getPreOnlineUsers$annotations", "preOnlineUsers", "", "Lcom/bytedance/android/livesdk/link/model/bridge/g2;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getLinkerContentMap", "()Ljava/util/Map;", "getLinkerContentMap$annotations", "linkerContentMap", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface ILinkerLinkedListChangeContentDef {

    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "linked_users")
        public static /* synthetic */ void getLinkUsers$annotations() {
        }

        @FieldName(name = "linker_content_map")
        public static /* synthetic */ void getLinkerContentMap$annotations() {
        }

        @FieldName(name = "pre_link_users")
        public static /* synthetic */ void getPreOnlineUsers$annotations() {
        }

        @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_ENTER_PUSH_TYPE)
        public static /* synthetic */ void getPushType$annotations() {
        }

        @FieldName(name = "version")
        public static /* synthetic */ void getVersion$annotations() {
        }
    }

    List<k> getLinkUsers();

    Map<Long, g2> getLinkerContentMap();

    List<k> getPreOnlineUsers();

    int getPushType();

    long getVersion();
}
