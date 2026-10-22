package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.ChorusCDNInfo.PushInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00048V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/PushInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/y2;", "", "", "<set-?>", "urls$delegate", "Ljava/lang/Object;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "urls", "pushUrl$delegate", "getPushUrl", "()Ljava/lang/String;", "setPushUrl", "(Ljava/lang/String;)V", "pushUrl", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PushInfoFlexImpl extends FlexModelBase<y2> implements y2, vh7.h {

    @SerializedName("push_url")
    protected String _$$pushUrl;

    @SerializedName("main_urls")
    protected List<String> _$$urls;

    public PushInfoFlexImpl() {
        super(y2.class);
        this._$$urls = $defaultValue_urls$();
        this._$$pushUrl = "";
    }

    public PushInfoFlexImpl(am3.g r100) {
        super(y2.class);
        this._$$urls = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$urls.add(am3.h.c(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._$$pushUrl = am3.h.c(r100);
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$urls.isEmpty() == false) goto L16;
        this._$$urls = $defaultValue_urls$();
    L16:
        if (this._$$pushUrl != null) goto L28;
        this._$$pushUrl = "";
        return;
    }

    public final List<String> $defaultValue_urls$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.y2
    public final String getPushUrl() {
        return this._$$pushUrl;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.y2
    public final List<String> getUrls() {
        return this._$$urls;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.y2
    public final void setPushUrl(String r100) {
        this._$$pushUrl = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.y2
    public final void setUrls(List<String> r100) {
        this._$$urls = r100;
    }
}
