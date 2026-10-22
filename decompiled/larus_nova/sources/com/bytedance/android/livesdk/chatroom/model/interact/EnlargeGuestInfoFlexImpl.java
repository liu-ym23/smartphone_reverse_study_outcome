package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.EnlargeGuestInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b#\u0010$R+\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R;\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00172\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR;\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00172\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001c¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/EnlargeGuestInfo;", "", "<set-?>", "enlargeGuestType$delegate", "Ljava/lang/Object;", "getEnlargeGuestType", "()I", "setEnlargeGuestType", "(I)V", "enlargeGuestType", "", "sourceUILayoutMaxMembers$delegate", "getSourceUILayoutMaxMembers", "()J", "setSourceUILayoutMaxMembers", "(J)V", "sourceUILayoutMaxMembers", "maxMemberExceptEnlarge$delegate", "getMaxMemberExceptEnlarge", "setMaxMemberExceptEnlarge", "maxMemberExceptEnlarge", "", "_enlargedUserIdList$delegate", "get_enlargedUserIdList", "()Ljava/util/List;", "set_enlargedUserIdList", "(Ljava/util/List;)V", "_enlargedUserIdList", "", "_enlargedOpenIdList$delegate", "get_enlargedOpenIdList", "set_enlargedOpenIdList", "_enlargedOpenIdList", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EnlargeGuestInfoFlexImpl extends FlexModelBase<EnlargeGuestInfo> implements EnlargeGuestInfo, vh7.h {

    @SerializedName("enlarged_open_ids")
    protected List<String> _$$_enlargedOpenIdList;

    @SerializedName("enlarged_user_ids")
    protected List<Long> _$$_enlargedUserIdList;

    @SerializedName("guest_type")
    protected int _$$enlargeGuestType;

    @SerializedName("max_members_except_enlarge")
    protected long _$$maxMemberExceptEnlarge;

    @SerializedName("source_ui_layout_max_members")
    protected long _$$sourceUILayoutMaxMembers;

    public EnlargeGuestInfoFlexImpl() {
        super(EnlargeGuestInfo.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final int getEnlargeGuestType() {
        return this._$$enlargeGuestType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final long getMaxMemberExceptEnlarge() {
        return this._$$maxMemberExceptEnlarge;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final long getSourceUILayoutMaxMembers() {
        return this._$$sourceUILayoutMaxMembers;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final List<String> get_enlargedOpenIdList() {
        return this._$$_enlargedOpenIdList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final List<Long> get_enlargedUserIdList() {
        return this._$$_enlargedUserIdList;
    }

    public EnlargeGuestInfoFlexImpl(am3.g r100) {
        super(EnlargeGuestInfo.class);
        this._$$_enlargedUserIdList = new ArrayList();
        this._$$_enlargedOpenIdList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L22;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this._$$enlargeGuestType = r100.i();
        goto L3
    L8:
        if (r102 == 2) goto L19;
        if (r102 != 3) goto L12;
        this._$$sourceUILayoutMaxMembers = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this._$$maxMemberExceptEnlarge = r100.j();
        goto L3
    L14:
        if (r102 != 5000) goto L15;
        List r104 = this._$$_enlargedOpenIdList;
        Comparable r105 = am3.h.c(r100);
    L20:
        r104.add(r105);
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L19:
        r104 = this._$$_enlargedUserIdList;
        r105 = Long.valueOf(r100.j());
        goto L20
    L22:
        r100.d(r101);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final void setEnlargeGuestType(int r100) {
        this._$$enlargeGuestType = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final void setMaxMemberExceptEnlarge(long r100) {
        this._$$maxMemberExceptEnlarge = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final void setSourceUILayoutMaxMembers(long r100) {
        this._$$sourceUILayoutMaxMembers = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final void set_enlargedOpenIdList(List<String> r100) {
        this._$$_enlargedOpenIdList = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo
    public final void set_enlargedUserIdList(List<Long> r100) {
        this._$$_enlargedUserIdList = r100;
    }
}
