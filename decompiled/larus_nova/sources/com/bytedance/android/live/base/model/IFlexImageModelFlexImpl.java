package com.bytedance.android.live.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.im.FlexImageStruct")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\u0004\u0018\u00010\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u001b\u0010\u0018\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/base/model/IFlexImageModelFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/base/model/d;", "", "", "urlList$delegate", "Ljava/lang/Object;", "getUrlList", "()Ljava/util/List;", "urlList", "uri$delegate", "getUri", "()Ljava/lang/String;", "uri", "", "flexSetting$delegate", "getFlexSetting", "flexSetting", "textSetting$delegate", "getTextSetting", "textSetting", "topBorderHeight$delegate", "getTopBorderHeight", "()J", "topBorderHeight", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IFlexImageModelFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("flex_setting")
    protected List<Long> _$$flexSetting;

    @SerializedName("text_setting")
    protected List<Long> _$$textSetting;

    @SerializedName("top_border_height")
    protected long _$$topBorderHeight;

    @SerializedName("uri")
    protected String _$$uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> _$$urlList;

    public IFlexImageModelFlexImpl() {
        super(d.class);
        this._$$urlList = $defaultValue_urlList$();
        this._$$flexSetting = $defaultValue_flexSetting$();
        this._$$textSetting = $defaultValue_textSetting$();
    }

    public final List<Long> $defaultValue_flexSetting$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Long> $defaultValue_textSetting$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<String> $defaultValue_urlList$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.live.base.model.d
    public final List<Long> getFlexSetting() {
        return this._$$flexSetting;
    }

    @Override // com.bytedance.android.live.base.model.d
    public final List<Long> getTextSetting() {
        return this._$$textSetting;
    }

    @Override // com.bytedance.android.live.base.model.d
    public final long getTopBorderHeight() {
        return this._$$topBorderHeight;
    }

    @Override // com.bytedance.android.live.base.model.d
    public final String getUri() {
        return this._$$uri;
    }

    @Override // com.bytedance.android.live.base.model.d
    public final List<String> getUrlList() {
        return this._$$urlList;
    }

    public IFlexImageModelFlexImpl(am3.g r100) {
        super(d.class);
        this._$$urlList = new ArrayList();
        this._$$flexSetting = new ArrayList();
        this._$$textSetting = new ArrayList();
        setThreadSafe(false);
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L23;
        am3.g.a r103 = decodeExtensionFields(r102, r100);
        if (r102 == 1) goto L21;
        if (r102 != 2) goto L10;
        this._$$uri = am3.h.c(r100);
        goto L3
    L10:
        if (r102 == 3) goto L18;
        if (r102 != 4) goto L14;
        List r104 = this._$$textSetting;
    L19:
        Comparable r105 = Long.valueOf(r100.j());
    L22:
        r104.add(r105);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this._$$topBorderHeight = r100.j();
        goto L3
    L15:
        am3.h.d(r103, r100);
        goto L3
    L18:
        r104 = this._$$flexSetting;
        goto L19
    L21:
        r104 = this._$$urlList;
        r105 = am3.h.c(r100);
        goto L22
    L23:
        r100.d(r101);
        setThreadSafe(true);
        if (this._$$urlList.isEmpty() == false) goto L27;
        this._$$urlList = $defaultValue_urlList$();
    L27:
        if (this._$$flexSetting.isEmpty() == false) goto L30;
        this._$$flexSetting = $defaultValue_flexSetting$();
    L30:
        if (this._$$textSetting.isEmpty() == false) goto L47;
        this._$$textSetting = $defaultValue_textSetting$();
        return;
    }
}
