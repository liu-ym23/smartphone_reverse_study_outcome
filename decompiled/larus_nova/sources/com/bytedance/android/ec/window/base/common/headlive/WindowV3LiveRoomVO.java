package com.bytedance.android.ec.window.base.common.headlive;

import com.alipay.sdk.m.x.d;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.model.ECUrlModel;
import com.facebook.imagepipeline.request.ImageRequest;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import yn.p;
import yn.q;
import yn.s;
import yn.u;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 H2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\bF\u0010GR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R:\u0010E\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010<\u0012\f\u0012\n\u0012\u0004\u0012\u00020>\u0018\u00010=\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006I"}, d2 = {"Lcom/bytedance/android/ec/window/base/common/headlive/WindowV3LiveRoomVO;", "Ljava/io/Serializable;", "", "roomId", "Ljava/lang/String;", "getRoomId", "()Ljava/lang/String;", "setRoomId", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getCover", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setCover", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "streamData", "getStreamData", "setStreamData", "enterUrl", "getEnterUrl", "setEnterUrl", "anchorId", "getAnchorId", "setAnchorId", "popUrl", "getPopUrl", "setPopUrl", "Lyn/q;", "liveGift", "Lyn/q;", "getLiveGift", "()Lyn/q;", "setLiveGift", "(Lyn/q;)V", "Lyn/s;", "liveProduct", "Lyn/s;", "getLiveProduct", "()Lyn/s;", "setLiveProduct", "(Lyn/s;)V", "", "liveType", "Ljava/lang/Integer;", "getLiveType", "()Ljava/lang/Integer;", "setLiveType", "(Ljava/lang/Integer;)V", "", "hasLiveTab", "Z", "getHasLiveTab", "()Z", "setHasLiveTab", "(Z)V", "Lkotlin/Pair;", "Lcom/bytedance/android/ec/core/imagex/r;", "", "Lcom/facebook/imagepipeline/request/ImageRequest;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Pair;", "getCoverImageRequest", "()Lkotlin/Pair;", "setCoverImageRequest", "(Lkotlin/Pair;)V", "coverImageRequest", "<init>", "()V", "Companion", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowV3LiveRoomVO implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Pair<? extends r, ImageRequest[]> f49152a;
    private String anchorId;
    private ECUrlModel cover;
    private String enterUrl;
    private boolean hasLiveTab;
    private q liveGift;
    private s liveProduct;
    private Integer liveType;
    private String popUrl;
    private String roomId;
    private String streamData;
    private String title;

    public static final class a {
        public a() {
        }

        public static WindowV3LiveRoomVO a(u r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            WindowV3LiveRoomVO r101 = new WindowV3LiveRoomVO();
            r101.setRoomId(r100.i());
            r101.setTitle(r100.k());
            r101.setCover(r100.b());
            r101.setStreamData(r100.j());
            r101.setEnterUrl(r100.c());
            r101.setAnchorId(r100.a());
            r101.setPopUrl(r100.h());
            p r102 = r100.e();
            s r103 = null;
            if (r102 == null) goto L5;
            int r104 = q.f568492a;
            Intrinsics.checkNotNullParameter(r102, "dto");
            q r105 = new q();
        L6:
            r101.setLiveGift(r105);
            yn.r r106 = r100.f();
            if (r106 == null) goto L11;
            int r107 = s.f568493b;
            Intrinsics.checkNotNullParameter(r106, "dto");
            r103 = new s();
            r103.f568494a = r106.b();
            Integer r108 = r106.a();
            if (r108 == null) goto L11;
            r108.intValue();
        L11:
            r101.setLiveProduct(r103);
            r101.setLiveType(r100.g());
            r101.setHasLiveTab(r100.d());
            return r101;
        L5:
            r105 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public WindowV3LiveRoomVO() {
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final ECUrlModel getCover() {
        return this.cover;
    }

    public final Pair<r, ImageRequest[]> getCoverImageRequest() {
        return this.f49152a;
    }

    public final String getEnterUrl() {
        return this.enterUrl;
    }

    public final boolean getHasLiveTab() {
        return this.hasLiveTab;
    }

    public final q getLiveGift() {
        return this.liveGift;
    }

    public final s getLiveProduct() {
        return this.liveProduct;
    }

    public final Integer getLiveType() {
        return this.liveType;
    }

    public final String getPopUrl() {
        return this.popUrl;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setAnchorId(String r100) {
        this.anchorId = r100;
    }

    public final void setCover(ECUrlModel r100) {
        this.cover = r100;
    }

    public final void setCoverImageRequest(Pair<? extends r, ImageRequest[]> r100) {
        this.f49152a = r100;
    }

    public final void setEnterUrl(String r100) {
        this.enterUrl = r100;
    }

    public final void setHasLiveTab(boolean r100) {
        this.hasLiveTab = r100;
    }

    public final void setLiveGift(q r100) {
        this.liveGift = r100;
    }

    public final void setLiveProduct(s r100) {
        this.liveProduct = r100;
    }

    public final void setLiveType(Integer r100) {
        this.liveType = r100;
    }

    public final void setPopUrl(String r100) {
        this.popUrl = r100;
    }

    public final void setRoomId(String r100) {
        this.roomId = r100;
    }

    public final void setStreamData(String r100) {
        this.streamData = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
