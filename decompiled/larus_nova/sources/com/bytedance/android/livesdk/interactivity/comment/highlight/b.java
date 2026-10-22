package com.bytedance.android.livesdk.interactivity.comment.highlight;

import am3.g;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.ugm.api.webcast_replay_biz.HighlightUrl")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\r\"\u0004\b \u0010\u000fR$\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR$\u0010$\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000b\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR$\u0010'\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/¨\u00065"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "", "", "id", "J", "e", "()J", "setId", "(J)V", "", "m3u8Url", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "setM3u8Url", "(Ljava/lang/String;)V", "", "tsUrls", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", "setTsUrls", "(Ljava/util/List;)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "coverImage", "Lcom/bytedance/android/live/base/model/ImageModel;", "c", "()Lcom/bytedance/android/live/base/model/ImageModel;", "setCoverImage", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", "title", "h", com.alipay.sdk.m.x.d.f25925o, ContainerPosition.BODY, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBody", "subTitle", "getSubTitle", "setSubTitle", "challenge", "b", "setChallenge", DyPayConstant.KEY_START_TIME, "Ljava/lang/Long;", ce.f26391f, "()Ljava/lang/Long;", "setStartTime", "(Ljava/lang/Long;)V", "endTime", "d", "setEndTime", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName(ContainerPosition.BODY)
    protected String body;

    @SerializedName("challenge")
    protected String challenge;

    @SerializedName("cover")
    protected ImageModel coverImage;

    @SerializedName("end_time")
    protected Long endTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("hl_id")
    protected long f134996id;

    @SerializedName("m3u8_url")
    protected String m3u8Url;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected Long startTime;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    protected String subTitle;

    @SerializedName("title")
    protected String title;

    @SerializedName("ts_urls")
    protected List<String> tsUrls;

    public b() {
    }

    public final String a() {
        return this.body;
    }

    public final String b() {
        return this.challenge;
    }

    public final ImageModel c() {
        return this.coverImage;
    }

    public final Long d() {
        return this.endTime;
    }

    public final long e() {
        return this.f134996id;
    }

    public final String f() {
        return this.m3u8Url;
    }

    public final Long g() {
        return this.startTime;
    }

    public final String h() {
        return this.title;
    }

    public final List<String> i() {
        return this.tsUrls;
    }

    public b(g r100) {
        this.tsUrls = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        switch(r102) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            case 10: goto L7;
            default: goto L6;
        };
    L7:
        this.endTime = Long.valueOf(r100.j());
        goto L3
    L8:
        this.startTime = Long.valueOf(r100.j());
        goto L3
    L9:
        this.coverImage = x.a(r100);
        goto L3
    L10:
        this.subTitle = am3.h.c(r100);
        goto L3
    L11:
        this.title = am3.h.c(r100);
        goto L3
    L12:
        this.body = am3.h.c(r100);
        goto L3
    L13:
        this.challenge = am3.h.c(r100);
        goto L3
    L14:
        this.tsUrls.add(am3.h.c(r100));
        goto L3
    L15:
        this.m3u8Url = am3.h.c(r100);
        goto L3
    L16:
        this.f134996id = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
    }
}
