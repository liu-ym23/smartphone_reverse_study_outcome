package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\f\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0007\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/IGetMVTabListResponse;", "Lvh7/c;", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVTab;", "getTabList", "()Ljava/util/List;", "getTabList$annotations", "()V", "tabList", "getDefaultTab", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVTab;", "getDefaultTab$annotations", "defaultTab", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IGetMVTabListResponse extends vh7.c<IGetMVTabListResponse> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "default_tab")
    IMVTab getDefaultTab();

    @FieldName(name = "tab_list")
    List<IMVTab> getTabList();
}
