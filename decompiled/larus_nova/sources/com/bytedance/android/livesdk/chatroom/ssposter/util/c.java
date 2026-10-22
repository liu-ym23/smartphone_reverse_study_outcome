package com.bytedance.android.livesdk.chatroom.ssposter.util;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends BaseQrCodeShareHelper implements ILiveQrCodeShareHelper {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static c f111579m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f111580n = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f111581h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f111582i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ImageModel f111583j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f111584k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f111585l;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper
    public final float f() {
        return 280.0f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper
    public final int g() {
        return R.layout.ttlive_match_room_qr_code_share_view_no_match_info;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper, com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final int getOriginalPicViewId() {
        return R.id.preview_original_bg;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper, com.bytedance.android.livehostapi.business.depend.share.IQrCodeShareHelper
    public final int getWatermarkContainerId() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper
    public final int i() {
        return R.layout.ttlive_match_room_qr_code_share_view_no_match_info;
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper
    public final String j() {
        return "MatchRoomQrCodeShareHelper";
    }

    static {
        f111580n = new a();
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper
    public final void n() {
        ArrayList r100 = new ArrayList();
        if (this.f111582i == false) goto L7;
        ImageModel r101 = this.f111583j;
        if (r101 == null) goto L7;
        r100.add(new b(r101, MatchRoomQrCodeShareHelper$generateImageInfoList$1$1.INSTANCE));
    L7:
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f111532b = r100;
        super.n();
    }

    public c() {
        this.f111581h = -1;
        new ArrayList();
        this.f111584k = "";
        this.f111585l = "";
        List<k> r100 = CollectionsKt.mutableListOf(new k[]{new k(new MatchRoomQrCodeShareHelper$generateTextInfoList$1(this)), new k(new MatchRoomQrCodeShareHelper$generateTextInfoList$2(this))});
        Intrinsics.checkNotNullParameter(r100, "list");
        this.f111533c = r100;
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final String getRelatedReviewContent() {
        return ILiveQrCodeShareHelper.DefaultImpls.getRelatedReviewContent(this);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final void setMatchSchedule(String r100) {
        Intrinsics.checkNotNullParameter(r100, "matchSchedule");
        ILiveQrCodeShareHelper.DefaultImpls.setMatchSchedule(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final void setMatchTiming(String r100) {
        Intrinsics.checkNotNullParameter(r100, "matchTiming");
        ILiveQrCodeShareHelper.DefaultImpls.setMatchTiming(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final void setOriginalPic(ImageModel r100) {
        Intrinsics.checkNotNullParameter(r100, "imageModel");
        ILiveQrCodeShareHelper.DefaultImpls.setOriginalPic(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final void setRaceLogo(ImageModel r100) {
        Intrinsics.checkNotNullParameter(r100, "raceLogo");
        ILiveQrCodeShareHelper.DefaultImpls.setRaceLogo(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final void setSavePicBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        ILiveQrCodeShareHelper.DefaultImpls.setSavePicBitmap(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final Object setTicketJson(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        return ILiveQrCodeShareHelper.DefaultImpls.setTicketJson(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.share.ILiveQrCodeShareHelper
    public final void setViewCutBitmap(Bitmap r100) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        ILiveQrCodeShareHelper.DefaultImpls.setViewCutBitmap(this, r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.ssposter.util.BaseQrCodeShareHelper
    public final void c(View r100, Bitmap r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, SimplayerImageStrategy.RESULT_BITMAP);
        ImageView r103 = (ImageView) r100.findViewById(R.id.preview_original_bg);
        if (r103 == null) goto L5;
        r103.setImageBitmap(r101);
    L5:
        ALogger.i("MatchRoomQrCodeShareHelper", "addOriginalPicToView is called");
    }
}
