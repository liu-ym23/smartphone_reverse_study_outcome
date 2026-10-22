package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR:\u0010\u0019\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u0001`\u00138&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\b\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IReplayStreamUrl;", "Lvh7/c;", "", "getPlayAlignOffset", "()J", "setPlayAlignOffset", "(J)V", "getPlayAlignOffset$annotations", "()V", "playAlignOffset", "", "getDefaultResolutionKey", "()Ljava/lang/String;", "setDefaultResolutionKey", "(Ljava/lang/String;)V", "getDefaultResolutionKey$annotations", "defaultResolutionKey", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IStreamAddr;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getStreamAddrList", "()Ljava/util/List;", "setStreamAddrList", "(Ljava/util/List;)V", "getStreamAddrList$annotations", "streamAddrList", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IReplayStreamUrl extends c<IReplayStreamUrl> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "default_resolution_key")
        public static /* synthetic */ void getDefaultResolutionKey$annotations() {
        }

        @FieldName(name = "play_align_offset")
        public static /* synthetic */ void getPlayAlignOffset$annotations() {
        }

        @FieldName(name = "stream_addr_list")
        public static /* synthetic */ void getStreamAddrList$annotations() {
        }
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @FieldName(name = "default_resolution_key")
    String getDefaultResolutionKey();

    @FieldName(name = "play_align_offset")
    long getPlayAlignOffset();

    @FieldName(name = "stream_addr_list")
    List<IStreamAddr> getStreamAddrList();

    @FieldName(name = "default_resolution_key#setter")
    void setDefaultResolutionKey(String r100);

    @FieldName(name = "play_align_offset#setter")
    void setPlayAlignOffset(long r100);

    @FieldName(name = "stream_addr_list#setter")
    void setStreamAddrList(List<? extends IStreamAddr> r100);
}
