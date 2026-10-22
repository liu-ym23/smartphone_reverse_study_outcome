package com.bytedance.android.live.liveinteract.digitavatar.videoavatar;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.digitavatar.AvatarGender;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarContext;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarMsgController;
import com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog;
import com.bytedance.android.live.liveinteract.digitavatar.h0;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/digitavatar/videoavatar/VideoDigitAvatarRecognitionDialog;", "Lcom/bytedance/android/live/liveinteract/digitavatar/DigitAvatarRecognitionDialog;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class VideoDigitAvatarRecognitionDialog extends DigitAvatarRecognitionDialog {
    public static final /* synthetic */ int P = 0;
    public e M;
    public com.bytedance.android.live.pushstream.d N;
    public Integer O;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void ba0() {
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void W90() {
        super.W90();
        DataCenter r100 = this.f72580z;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
    L11:
        DigitAvatarContext.a r102 = DigitAvatarContext.Companion;
        DigitAvatarContext r103 = r102.getContext();
        if (r103 == null) goto L14;
        VideoShowMode r104 = r103.getCurrentVideoShowMode();
    L15:
        VideoShowMode r105 = VideoShowMode.DIGIT_AVATAR;
        if (r104 != r105) goto L25;
        DigitAvatarRecognitionDialog.RecognitionType r106 = this.f72578x;
        if (r106 != DigitAvatarRecognitionDialog.RecognitionType.CAMERA) goto L20;
    L21:
        f2.b(R.string.ttlive_ktv_avatar_auditing_use_default_tips, 0);
    L22:
        DigitAvatarContext r107 = r102.getContext();
        if (r107 == null) goto L33;
        r107.getRequestUpdateAvatar().post(new h0(r107.getDigitAvatar().getValue().f72676b));
        return;
    L33:
        return;
    L20:
        if (r106 != DigitAvatarRecognitionDialog.RecognitionType.PHOTO) goto L22;
    L25:
        DigitAvatarContext r108 = r102.getContext();
        if (r108 == null) goto L28;
        r108.setSkipFrequencyCheck(true);
    L28:
        DigitAvatarContext r109 = r102.getContext();
        if (r109 == null) goto L35;
        DigitAvatarContext.setVideoShowMode$default(r109, r105, null, 2, null);
        return;
    L35:
        return;
    L14:
        r104 = null;
        goto L15
    L10:
        if (hd0.c.f().h() == true) goto L11;
        return;
    L5:
        if (a0.d(r100, false) != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        e r100 = this.M;
        if (r100 == null) goto L8;
        DownloadTask r101 = r100.f72715a;
        if (r101 == null) goto L7;
        r101.subThreadListener(null);
    L7:
        r100.f72716b.clear();
    L8:
        DigitAvatarContext r102 = DigitAvatarContext.Companion.getContext();
        if (r102 == null) goto L31;
        VideoShowMode r103 = r102.getCurrentVideoShowMode();
        if (r103 == null) goto L32;
        VideoShowMode r104 = VideoShowMode.VIDEO;
        if (r103 == r104) goto L17;
        if (r103 == VideoShowMode.DIGIT_AVATAR) goto L17;
        return;
    L17:
        if (((Boolean) vm2.h.A6.getValue(null, vm2.h.f556082a[389(0x185, float:5.45E-43)])).booleanValue() == false) goto L27;
        if (r103 != r104) goto L27;
        Integer r105 = this.O;
        if (r105 == null) goto L27;
        if (r105.intValue() != 2) goto L27;
        com.bytedance.android.live.pushstream.d r106 = this.N;
        if (r106 == null) goto L34;
        r106.Z0(2, new uv0.a(LiveRequestSourceRole.Business, "VideoDigitAvatarRecognitionDialog.switchBack", null));
        return;
    L34:
        return;
    L27:
        com.bytedance.android.live.pushstream.d r107 = this.N;
        if (r107 == null) goto L36;
        r107.Z0(1, new uv0.a(LiveRequestSourceRole.Business, "VideoDigitAvatarRecognitionDialog.switchFront", null));
        return;
    L36:
        return;
    L32:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (((Boolean) vm2.d.f555800c3.getValue(null, vm2.d.f555776a[208(0xd0, float:2.91E-43)])).booleanValue() == false) goto L6;
        m60.c.d(getContext(), new String[]{"android.permission.CAMERA"});
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (((Boolean) vm2.d.f555800c3.getValue(null, vm2.d.f555776a[208(0xd0, float:2.91E-43)])).booleanValue() == true) goto L5;
    L7:
        ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).setIsOpenCropImagePage(false);
        return;
    L5:
        if (m60.c.d(getContext(), new String[]{"android.permission.CAMERA"}) == false) goto L7;
        ((IMiddlewareRoomService) jc1.k.n(IMiddlewareRoomService.class)).isOpenCropImagePage();
        goto L7
    }

    public VideoDigitAvatarRecognitionDialog() {
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog
    public final void V90(AvatarGender r100) {
        Intrinsics.checkNotNullParameter(r100, "gender");
        Intrinsics.checkNotNullParameter(r100, "gender");
        e r101 = this.M;
        if (r101 == null) goto L6;
        r101.b(r100, false);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.DigitAvatarRecognitionDialog, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        DataCenter r101 = this.f72580z;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        e r104 = null;
        if (r103 == false) goto L13;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.pushstream.d> r105 = com.bytedance.android.live.liveinteract.api.utils.m.n(this.f72580z, null, 2).getLiveStream();
        if (r105 == null) goto L16;
        com.bytedance.android.live.pushstream.d r106 = r105.getValue();
    L17:
        this.N = r106;
        if (r106 == null) goto L22;
        d0 r107 = r106.getLiveCore();
        if (r107 == null) goto L22;
        this.O = Integer.valueOf(r107.g());
    L22:
        com.bytedance.android.live.pushstream.d r108 = this.N;
        if (r108 == null) goto L25;
        r108.Z0(5, new uv0.a(LiveRequestSourceRole.Business, "VideoDigitAvatarRecognitionDialog.switchRadioInit", null));
    L25:
        DigitAvatarContext r109 = DigitAvatarContext.Companion.getContext();
        if (r109 == null) goto L28;
        VideoShowMode r110 = r109.getCurrentVideoShowMode();
    L30:
        if (r110 != VideoShowMode.VIDEO) goto L42;
        IMiddlewareUserService r111 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r111 == null) goto L34;
        com.bytedance.android.livesdk.user.e r112 = r111.user();
    L35:
        if (r112 == null) goto L42;
        py.k r113 = r111.user().b().getAvatarMedium();
        if (r113 != null) goto L41;
        String r114 = r111.user().b().getAvatarUrl();
        if (TextUtils.isEmpty(r114) == true) goto L41;
        ArrayList r115 = new ArrayList();
        Intrinsics.checkNotNull(r114);
        r115.add(r114);
        r113 = qy.a.b(null, r115);
    L41:
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r113, new g(this));
        goto L42
    L34:
        r112 = null;
    L42:
        DigitAvatarMsgController r116 = this.D;
        if (r116 == null) goto L51;
        DataCenter r117 = this.f72580z;
        if (r117 != null) goto L47;
    L49:
        r102 = false;
    L50:
        r104 = new e(r116, r102, false);
        goto L51
    L47:
        if (a0.d(r117, false) != true) goto L49;
    L51:
        this.M = r104;
        return;
    L28:
        r110 = null;
    L16:
        r106 = null;
        goto L17
    L13:
        rj0.l.f537955n2.getClass();
        rj0.l r118 = rj0.l.a.a();
        if (r118 == null) goto L16;
        r106 = r118.getLiveStream();
        goto L17
    L5:
        if (a0.d(r101, false) != true) goto L7;
        r103 = true;
        goto L8
    }
}
