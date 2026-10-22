package com.bytedance.android.livesdkapi.depend.message.crossroom;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.f;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CrossRoomLinkmicUIInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0013\u0010\u0014RG\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fRG\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/CrossRoomLinkmicUIInfo;", "", "", "Lcom/bytedance/android/livesdkapi/depend/message/crossroom/UserInfo;", "<set-?>", "userInfos$delegate", "Ljava/lang/Object;", "getUserInfos", "()Ljava/util/Map;", "setUserInfos", "(Ljava/util/Map;)V", "userInfos", "", "openUserInfos$delegate", "getOpenUserInfos", "setOpenUserInfos", "openUserInfos", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CrossRoomLinkmicUIInfoFlexImpl extends FlexModelBase<CrossRoomLinkmicUIInfo> implements CrossRoomLinkmicUIInfo, h {

    @SerializedName("open_user_infos")
    protected Map<String, ? extends UserInfo> _$$openUserInfos;

    @SerializedName("user_infos")
    protected Map<Long, ? extends UserInfo> _$$userInfos;

    public CrossRoomLinkmicUIInfoFlexImpl() {
        super(CrossRoomLinkmicUIInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo
    public final Map<String, UserInfo> getOpenUserInfos() {
        return this._$$openUserInfos;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo
    public final Map<Long, UserInfo> getUserInfos() {
        return this._$$userInfos;
    }

    public CrossRoomLinkmicUIInfoFlexImpl(g r110) {
        super(CrossRoomLinkmicUIInfo.class);
        this._$$userInfos = new HashMap();
        this._$$openUserInfos = new HashMap();
        setThreadSafe(false);
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L42;
        g.a r102 = decodeExtensionFields(r101, r110);
        Object r103 = null;
        if (r101 == 2) goto L26;
        if (r101 != 5000) goto L9;
        long r111 = r110.c();
        Object r104 = null;
    L11:
        int r105 = r110.f();
        if (r105 == (-1)) goto L18;
        if (r105 != 1) goto L14;
        r103 = am3.h.c(r110);
        goto L11
    L14:
        if (r105 != 2) goto L15;
        r104 = f.a(r110, UserInfo.class);
        goto L11
    L15:
        am3.h.e(r110);
        goto L11
    L18:
        r110.d(r111);
        Map r106 = this._$$openUserInfos;
        if (r103 == null) goto L25;
        if (r104 == null) goto L23;
    L37:
        r106.put(r103, r104);
        goto L3
    L23:
        throw new IllegalStateException("Value must not be null");
    L25:
        throw new IllegalStateException("Key must not be null");
    L9:
        am3.h.d(r102, r110);
        goto L3
    L26:
        long r112 = r110.c();
        r104 = null;
    L27:
        int r107 = r110.f();
        if (r107 == (-1)) goto L34;
        if (r107 != 1) goto L30;
        r103 = Long.valueOf(r110.j());
        goto L27
    L30:
        if (r107 != 2) goto L31;
        r104 = f.a(r110, UserInfo.class);
        goto L27
    L31:
        am3.h.e(r110);
        goto L27
    L34:
        r110.d(r112);
        r106 = this._$$userInfos;
        if (r103 == null) goto L41;
        if (r104 != null) goto L37;
        throw new IllegalStateException("Value must not be null");
    L41:
        throw new IllegalStateException("Key must not be null");
    L42:
        r110.d(r100);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo
    public final void setOpenUserInfos(Map<String, ? extends UserInfo> r100) {
        this._$$openUserInfos = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.message.crossroom.CrossRoomLinkmicUIInfo
    public final void setUserInfos(Map<Long, ? extends UserInfo> r100) {
        this._$$userInfos = r100;
    }
}
