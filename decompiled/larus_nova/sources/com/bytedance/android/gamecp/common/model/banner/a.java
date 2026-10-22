package com.bytedance.android.gamecp.common.model.banner;

import am3.g;
import com.alipay.sdk.m.x.d;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.api.feed.Banner.Item")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR,\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR$\u0010*\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR$\u0010-\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u000b\u001a\u0004\b.\u0010\r\"\u0004\b/\u0010\u000fR\"\u00100\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 ¨\u00066"}, d2 = {"Lcom/bytedance/android/gamecp/common/model/banner/a;", "Lcom/bytedance/android/gamecp/host_api/model/d;", "", DBDefinition.ID, "J", "get_id", "()J", "set_id", "(J)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "", "urlList", "Ljava/util/List;", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "uri", "getUri", "setUri", "", "height", "I", "getHeight", "()I", "setHeight", "(I)V", "width", "getWidth", "setWidth", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "text", "getText", "setText", "extra", "getExtra", "setExtra", "avgColor", "getAvgColor", "setAvgColor", "bannerType", "getBannerType", "setBannerType", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements com.bytedance.android.gamecp.host_api.model.d, h {

    @SerializedName("id")
    protected long _id;

    @SerializedName("avg_color")
    protected String avgColor;

    @SerializedName("banner_type")
    protected int bannerType;

    @IgnoreProtoFieldCheck
    @SerializedName("extra")
    private String extra;

    @SerializedName("height")
    protected int height;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL)
    protected String schemaUrl;

    @IgnoreProtoFieldCheck
    @SerializedName("text")
    private String text;

    @SerializedName("title")
    protected String title;

    @SerializedName("uri")
    protected String uri;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    protected List<String> urlList;

    @SerializedName("width")
    protected int width;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.common.model.banner.a$a, reason: collision with other inner class name */
    public static final class C0910a {
    }

    static {
    }

    public a() {
    }

    public a(g r100) {
        this.urlList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L6;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L6;
            case 11: goto L7;
            default: goto L6;
        };
    L7:
        this.bannerType = (int) r100.j();
        goto L3
    L8:
        this.schemaUrl = am3.h.c(r100);
        goto L3
    L9:
        this._id = r100.j();
        goto L3
    L10:
        this.width = (int) r100.j();
        goto L3
    L11:
        this.height = (int) r100.j();
        goto L3
    L12:
        this.uri = am3.h.c(r100);
        goto L3
    L13:
        this.urlList.add(am3.h.c(r100));
        goto L3
    L14:
        this.title = am3.h.c(r100);
        goto L3
    L15:
        this.avgColor = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L16:
        r100.d(r101);
    }
}
