package com.bytedance.android.live.liveinteract.multiscene;

import com.bytedance.android.livesdk.chatroom.model.interact.m1;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0012\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/multiscene/RoomBattleThemeParam;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/chatroom/model/interact/m1;", "", "toString", "", "themeId", "J", "getThemeId", "()J", "setThemeId", "(J)V", "", "themeType", "I", "getThemeType", "()I", "setThemeType", "(I)V", "themeTitle", "Ljava/lang/String;", "getThemeTitle", "()Ljava/lang/String;", "setThemeTitle", "(Ljava/lang/String;)V", "themeDescription", "getThemeDescription", "setThemeDescription", "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomBattleThemeParam extends FlexModelBase<m1> implements m1, vh7.h {

    @SerializedName("theme_description")
    protected String themeDescription;

    @SerializedName("theme_id")
    protected long themeId;

    @SerializedName("theme_title")
    protected String themeTitle;

    @SerializedName("theme_type")
    protected int themeType;

    public RoomBattleThemeParam() {
        super(m1.class);
        this.themeType = RoomBattleThemeType.UNKNOWN.getValue();
    }

    public String toString() {
        return "RoomBattleThemeParam(themeId=" + getThemeId() + ", themeType=" + getThemeType() + ", themeTitle=" + getThemeTitle() + ", themeDescription=" + getThemeDescription() + ')';
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public String getThemeDescription() {
        return this.themeDescription;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public long getThemeId() {
        return this.themeId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public String getThemeTitle() {
        return this.themeTitle;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public int getThemeType() {
        return this.themeType;
    }

    public RoomBattleThemeParam(am3.g r100) {
        super(m1.class);
        boolean r101 = false;
        setThreadSafe(false);
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L18;
        am3.g.a r104 = decodeExtensionFields(r103, r100);
        if (r103 != 1) goto L8;
        this.themeId = r100.j();
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.themeType = r100.i();
        r101 = r101 | true;
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.themeTitle = am3.h.c(r100);
        goto L3
    L12:
        if (r103 != 4) goto L13;
        this.themeDescription = am3.h.c(r100);
        goto L3
    L13:
        am3.h.d(r104, r100);
        goto L3
    L18:
        r100.d(r102);
        setThreadSafe(true);
        if ((r101 & true) == true) goto L37;
        this.themeType = RoomBattleThemeType.UNKNOWN.getValue();
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public void setThemeDescription(String r100) {
        this.themeDescription = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public void setThemeId(long r100) {
        this.themeId = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public void setThemeTitle(String r100) {
        this.themeTitle = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.m1
    public void setThemeType(int r100) {
        this.themeType = r100;
    }
}
