package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.livesdk.link.model.bridge.n1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.data.MultiAnchorExtra")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/MultiAnchorExtra;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/link/model/bridge/n1;", "", "toString", "", "mInviteRole", "I", "getMInviteRole", "()I", "setMInviteRole", "(I)V", "getInviteRole", "inviteRole", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiAnchorExtra extends FlexModelBase<n1> implements n1, vh7.h {
    public static final a Companion = null;
    public static final int ROLE_INVITEE = 3;
    public static final int ROLE_INVITEE_FOLLOWER = 4;
    public static final int ROLE_INVITER = 1;
    public static final int ROLE_INVITER_FOLLOWER = 2;

    @SerializedName("invite_role")
    protected int mInviteRole;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public MultiAnchorExtra() {
        super(n1.class);
    }

    public String toString() {
        return "MultiAnchorExtra{inviteRole=" + this.mInviteRole + '}';
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.n1
    public int getInviteRole() {
        return this.mInviteRole;
    }

    public final int getMInviteRole() {
        return this.mInviteRole;
    }

    public MultiAnchorExtra(am3.g r100) {
        super(n1.class);
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L7;
        this.mInviteRole = r100.i();
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L9:
        r100.d(r101);
        setThreadSafe(true);
    }

    public final void setMInviteRole(int r100) {
        this.mInviteRole = r100;
    }
}
