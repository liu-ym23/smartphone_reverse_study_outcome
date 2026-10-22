package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r8\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/UserHighScoreSongTag;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/message/model/fc;", "", "highScoreSongCount", "Ljava/lang/String;", "getHighScoreSongCount", "()Ljava/lang/String;", "setHighScoreSongCount", "(Ljava/lang/String;)V", "icon", "getIcon", "setIcon", "", "bgColor", "Ljava/util/List;", "getBgColor", "()Ljava/util/List;", "setBgColor", "(Ljava/util/List;)V", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class UserHighScoreSongTag extends FlexModelBase<fc> implements fc, vh7.h {

    @SerializedName("bg_color")
    protected List<String> bgColor;

    @SerializedName("high_score_song_count")
    protected String highScoreSongCount;

    @SerializedName("icon")
    protected String icon;

    public UserHighScoreSongTag() {
        super(fc.class);
        this.highScoreSongCount = "";
        this.icon = "";
        this.bgColor = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.message.model.fc
    public List<String> getBgColor() {
        return this.bgColor;
    }

    @Override // com.bytedance.android.livesdk.message.model.fc
    public String getHighScoreSongCount() {
        return this.highScoreSongCount;
    }

    @Override // com.bytedance.android.livesdk.message.model.fc
    public String getIcon() {
        return this.icon;
    }

    public UserHighScoreSongTag(am3.g r100) {
        super(fc.class);
        this.bgColor = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 != 1) goto L8;
        this.highScoreSongCount = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.icon = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.bgColor.add(am3.h.c(r100));
        goto L3
    L11:
        am3.h.d(r103, r100);
        goto L3
    L15:
        r100.d(r101);
        setThreadSafe(true);
        if (this.highScoreSongCount != null) goto L19;
        this.highScoreSongCount = "";
    L19:
        if (this.icon != null) goto L22;
        this.icon = "";
    L22:
        if (this.bgColor.isEmpty() == false) goto L37;
        this.bgColor = new ArrayList();
        return;
    }

    public void setBgColor(List<String> r100) {
        this.bgColor = r100;
    }

    public void setHighScoreSongCount(String r100) {
        this.highScoreSongCount = r100;
    }

    public void setIcon(String r100) {
        this.icon = r100;
    }
}
