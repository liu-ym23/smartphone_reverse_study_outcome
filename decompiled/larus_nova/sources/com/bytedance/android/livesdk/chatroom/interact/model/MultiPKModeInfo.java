package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.MultiPKModeInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR,\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/MultiPKModeInfo;", "", "()V", "modeTab", "", "getModeTab", "()I", "setModeTab", "(I)V", "userIdToTeamId", "", "", "", "getUserIdToTeamId", "()Ljava/util/Map;", "setUserIdToTeamId", "(Ljava/util/Map;)V", "version", "getVersion", "()J", "setVersion", "(J)V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiPKModeInfo implements vh7.h {

    @SerializedName("mode_tab")
    protected int modeTab;

    @SerializedName("open_user_id_to_team_id")
    protected Map<String, Long> userIdToTeamId;

    @SerializedName("version")
    protected long version;

    public MultiPKModeInfo() {
    }

    public final int getModeTab() {
        return this.modeTab;
    }

    public final Map<String, Long> getUserIdToTeamId() {
        return this.userIdToTeamId;
    }

    public final long getVersion() {
        return this.version;
    }

    public MultiPKModeInfo(am3.g r110) {
        this.userIdToTeamId = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L31;
        if (r101 != 1) goto L8;
        this.modeTab = r110.i();
        goto L3
    L8:
        if (r101 != 3) goto L10;
        this.version = r110.j();
        goto L3
    L10:
        if (r101 != 5000) goto L11;
        long r102 = r110.c();
        String r103 = null;
        Long r104 = null;
    L13:
        int r105 = r110.f();
        if (r105 == (-1)) goto L21;
        if (r105 != 1) goto L17;
        r103 = am3.h.c(r110);
        goto L13
    L17:
        if (r105 != 2) goto L18;
        r104 = Long.valueOf(r110.j());
        goto L13
    L18:
        am3.h.e(r110);
        goto L13
    L21:
        r110.d(r102);
        Map<String, Long> r106 = this.userIdToTeamId;
        if (r103 == null) goto L28;
        if (r104 == null) goto L26;
        r106.put(r103, r104);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L11:
        am3.h.e(r110);
        goto L3
    L31:
        r110.d(r100);
    }

    public final void setModeTab(int r100) {
        this.modeTab = r100;
    }

    public final void setUserIdToTeamId(Map<String, Long> r100) {
        this.userIdToTeamId = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }
}
