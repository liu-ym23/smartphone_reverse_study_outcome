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
@ProtoMessage("webcast.data.TeamfightTeamConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0097D¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0016X\u0097\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/TeamFightTeamConfig;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/y1;", "", "maxMember", "J", "getMaxMember", "()J", "", "Lcom/bytedance/android/livesdk/chatroom/model/interact/TeamFightTeamConfigUser;", "guestList", "Ljava/util/List;", "getGuestList", "()Ljava/util/List;", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TeamFightTeamConfig extends FlexModelBase<y1> implements y1, vh7.h {

    @SerializedName("guest_list")
    protected List<TeamFightTeamConfigUser> guestList;

    @SerializedName("max_member")
    protected long maxMember;

    public TeamFightTeamConfig() {
        super(y1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y1
    public List<TeamFightTeamConfigUser> getGuestList() {
        return this.guestList;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.y1
    public long getMaxMember() {
        return this.maxMember;
    }

    public TeamFightTeamConfig(am3.g r100) {
        super(y1.class);
        this.guestList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.maxMember = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.guestList.add(new TeamFightTeamConfigUser(r100));
        goto L3
    L9:
        am3.h.d(r103, r100);
        goto L3
    L12:
        r100.d(r101);
        setThreadSafe(true);
    }
}
