package com.bytedance.android.livesdkapi.depend.message;

import am3.g;
import com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00148\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/MVUrlStruct;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/IMVUrlStruct;", "()V", "height", "", "getHeight", "()J", "setHeight", "(J)V", "uri", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "urlKey", "getUrlKey", "setUrlKey", "urlList", "", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "width", "getWidth", "setWidth", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MVUrlStruct extends FlexModelBase<IMVUrlStruct> implements IMVUrlStruct, h {

    @SerializedName("height")
    protected long height;

    @SerializedName("uri")
    protected String uri;

    @SerializedName("url_key")
    protected String urlKey;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urlList;

    @SerializedName("width")
    protected long width;

    public MVUrlStruct() {
        super(IMVUrlStruct.class);
        this.uri = "";
        this.urlList = CollectionsKt.emptyList();
        this.urlKey = "";
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public long getHeight() {
        return this.height;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public String getUri() {
        return this.uri;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public String getUrlKey() {
        return this.urlKey;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public List<String> getUrlList() {
        return this.urlList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public long getWidth() {
        return this.width;
    }

    public MVUrlStruct(g r100) {
        super(IMVUrlStruct.class);
        this.urlList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.uri = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.urlList.add(am3.h.c(r100));
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.width = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.height = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.urlKey = am3.h.c(r100);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L21:
        r100.d(r101);
        setThreadSafe(true);
        if (this.uri != null) goto L25;
        this.uri = "";
    L25:
        if (this.urlList.isEmpty() == false) goto L28;
        this.urlList = CollectionsKt.emptyList();
    L28:
        if (this.urlKey != null) goto L49;
        this.urlKey = "";
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public void setHeight(long r100) {
        this.height = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public void setUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uri = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public void setUrlKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.urlKey = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public void setUrlList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.urlList = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.IMVUrlStruct
    public void setWidth(long r100) {
        this.width = r100;
    }
}
