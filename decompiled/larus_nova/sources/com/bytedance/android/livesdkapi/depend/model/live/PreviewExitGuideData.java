package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PreviewExposeData.PreviewExitGuide")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00118\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0016X\u0097D¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR \u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR \u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\"\u0010$\u001a\u0004\u0018\u00010\u00158\u0016@\u0016X\u0097\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b%\u0010\u0017\"\u0004\b&\u0010'R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)8\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PreviewExitGuideData;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IPreviewExitGuideData;", "()V", "buttText", "", "getButtText", "()Ljava/lang/String;", "setButtText", "(Ljava/lang/String;)V", "icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "lastLiveRecord", "", "getLastLiveRecord", "()Ljava/lang/Long;", "lessFreq", "", "getLessFreq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", n.KEY_MAIN_TEXT, "getMainText", "setMainText", "schema", "getSchema", "setSchema", n.KEY_SUB_TEXT, "getSubText", "setSubText", "tag", "getTag", "type", "getType", "setType", "(Ljava/lang/Integer;)V", "userList", "", "Lcom/bytedance/android/live/base/model/user/User;", "getUserList", "()Ljava/util/List;", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewExitGuideData extends FlexModelBase<IPreviewExitGuideData> implements IPreviewExitGuideData, h {

    @SerializedName("button_text")
    protected String buttText;

    @SerializedName("icon")
    protected ImageModel icon;

    @SerializedName("latest_live_record")
    protected long lastLiveRecord;

    @IgnoreProtoFieldCheck
    @SerializedName("less_freq")
    protected Integer lessFreq;

    @SerializedName("main_text")
    protected String mainText;

    @SerializedName(a.KEY_SCHEMA_URL)
    protected String schema;

    @SerializedName("sub_text")
    protected String subText;

    @SerializedName("tag")
    protected String tag;

    @SerializedName("type")
    protected Integer type;

    @SerializedName("user_list")
    protected List<User> userList;

    public PreviewExitGuideData() {
        super(IPreviewExitGuideData.class);
        this.schema = "";
        this.type = 0;
        this.lessFreq = 0;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public Long getLastLiveRecord() {
        return Long.valueOf(this.lastLiveRecord);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public /* bridge */ /* synthetic */ k getIcon() {
        return getIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public String getButtText() {
        return this.buttText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public Integer getLessFreq() {
        return this.lessFreq;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public String getMainText() {
        return this.mainText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public String getSchema() {
        return this.schema;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public String getSubText() {
        return this.subText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public String getTag() {
        return this.tag;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public Integer getType() {
        return this.type;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public List<User> getUserList() {
        return this.userList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.IPreviewExitGuideData
    public ImageModel getIcon() {
        return this.icon;
    }

    public PreviewExitGuideData(g r100) {
        super(IPreviewExitGuideData.class);
        this.userList = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        g.a r103 = decodeExtensionFields(r102, r100);
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L8:
        this.lessFreq = Integer.valueOf(r100.i());
        goto L3
    L9:
        this.tag = am3.h.c(r100);
        goto L3
    L10:
        this.userList.add(new User(r100));
        goto L3
    L11:
        this.lastLiveRecord = r100.j();
        goto L3
    L12:
        this.buttText = am3.h.c(r100);
        goto L3
    L13:
        this.type = Integer.valueOf(r100.i());
        goto L3
    L14:
        this.schema = am3.h.c(r100);
        goto L3
    L15:
        this.subText = am3.h.c(r100);
        goto L3
    L16:
        this.mainText = am3.h.c(r100);
        goto L3
    L17:
        this.icon = x.a(r100);
        goto L3
    L7:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r100.d(r101);
        setThreadSafe(true);
        if (this.schema != null) goto L22;
        this.schema = "";
    L22:
        if (this.type != null) goto L25;
        this.type = 0;
    L25:
        if (this.lessFreq != null) goto L52;
        this.lessFreq = 0;
        return;
    }

    public void setButtText(String r100) {
        this.buttText = r100;
    }

    public void setIcon(ImageModel r100) {
        this.icon = r100;
    }

    public void setMainText(String r100) {
        this.mainText = r100;
    }

    public void setSchema(String r100) {
        this.schema = r100;
    }

    public void setSubText(String r100) {
        this.subText = r100;
    }

    public void setType(Integer r100) {
        this.type = r100;
    }
}
