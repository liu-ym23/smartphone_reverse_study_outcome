package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.PaidLinkmicTag")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/PaidLinkmicTag;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/j1;", "", "id", "Ljava/lang/Long;", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "pic", "Lcom/bytedance/android/live/base/model/ImageModel;", "getPic", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setPic", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PaidLinkmicTag extends FlexModelBase<j1> implements j1, vh7.h {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    protected Long f106937id;

    @SerializedName("name")
    protected String name;

    /* JADX INFO: renamed from: pic, reason: collision with root package name */
    @SerializedName("pic")
    protected ImageModel f106938pic;

    public PaidLinkmicTag() {
        super(j1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.j1
    public /* bridge */ /* synthetic */ py.k getPic() {
        return getPic();
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.j1
    public Long getId() {
        return this.f106937id;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.j1
    public String getName() {
        return this.name;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.j1
    public ImageModel getPic() {
        return this.f106938pic;
    }

    public PaidLinkmicTag(am3.g r100) {
        super(j1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.f106937id = Long.valueOf(r100.j());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.name = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.f106938pic = com.bytedance.android.live.base.model.x.a(r100);
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.j1
    public void setId(Long r100) {
        this.f106937id = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.j1
    public void setName(String r100) {
        this.name = r100;
    }

    public void setPic(ImageModel r100) {
        this.f106938pic = r100;
    }
}
