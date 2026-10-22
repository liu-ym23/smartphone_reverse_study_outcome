package com.bytedance.android.live.room.share.summersinging;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.bytedance.android.livesdk.widget.LiveBottomSheetDialog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\t\b\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/room/share/summersinging/GroupPhotoDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "Lcom/bytedance/android/live/room/share/summersinging/a;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GroupPhotoDialogFragment extends LiveDialogFragment implements com.bytedance.android.live.room.share.summersinging.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final com.bytedance.android.live.base.model.data.f.a f100324q = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f100325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintLayout f100326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ImageView f100327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageView f100328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f100329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f100330i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f100331j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ImageView f100332k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f100333l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f100334m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.live.base.model.data.f f100335n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DataCenter f100336o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final p f100337p;

    public static final class a {
    }

    public static final class b implements LiveBottomSheetDialog.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f100338a = null;

        static {
            f100338a = new b();
        }

        public b() {
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final boolean disableDragDown() {
            return true;
        }

        @Override // com.bytedance.android.livesdk.widget.LiveBottomSheetDialog.m
        public final /* synthetic */ boolean shouldInterceptSlide(int r100) {
            return true;
        }
    }

    static {
        com.bytedance.android.live.base.model.data.f.a r100 = new com.bytedance.android.live.base.model.data.f.a();
        r100.locationX = 56;
        r100.locationY = 101;
        f100324q = r100;
    }

    public GroupPhotoDialogFragment() {
        this(new com.bytedance.android.live.base.model.data.f(), null, new p(null, null, null));
        ALogger.e("GroupPhotoDialogFragment", "call default constructor");
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final String SD() {
        DataCenter r100 = this.f100336o;
        if (r100 == null) goto L9;
        Room r101 = z.o(r100);
        if (r101 == null) goto L9;
        User r102 = r101.mo8271getOwner();
        if (r102 == null) goto L9;
        return r102.getRemarkNameOrNickname();
    L9:
        return null;
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final Room k2() {
        DataCenter r100 = this.f100336o;
        if (r100 != null) goto L7;
        return null;
    L7:
        return z.o(r100);
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final void uy() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r100 = DialogFragmentLancet.sLastShowStack;
        if (r100 == null) goto L11;
        com.bytedance.crash.d.d(r100, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.live.room.share.summersinging.a
    public final ConstraintLayout fD() {
        return this.f100326e;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        ViewGroup r102 = (ViewGroup) r101.findViewById(R.id.ttlive_design_bottom_sheet);
        if (r102 == null) goto L9;
        a1.k(r102, -1);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_NoEnterExitAnimationDialog);
        setBottomSheetSlideProcessor(b.f100338a);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L11
        ValueAnimator r101 = this.f100333l;     // Catch: Throwable -> L11
        if (r101 == null) goto L5;
        r101.cancel();     // Catch: Throwable -> L11
    L5:
        l r102 = this.f100334m;     // Catch: Throwable -> L11
        Disposable r103 = r102.f100358c;     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        r103.dispose();     // Catch: Throwable -> L11
    L8:
        r102.f100357b = false;     // Catch: Throwable -> L11
        super.onDismiss(r100);     // Catch: Throwable -> L11
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L11:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public GroupPhotoDialogFragment(com.bytedance.android.live.base.model.data.f r100, DataCenter r101, p r102) {
        Intrinsics.checkNotNullParameter(r100, "groupPhotoDetail");
        Intrinsics.checkNotNullParameter(r102, "imageBitmapStore");
        this.f100335n = r100;
        this.f100336o = r101;
        this.f100337p = r102;
        this.f100334m = new l(this);
    }

    public static void S90(View r100, int r101, int r102) {
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r103.width = UtilityKotlinExtentionsKt.i(r101);
        r103.height = UtilityKotlinExtentionsKt.i(r102);
        r100.setLayoutParams(r103);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        View r100 = r110.inflate(R.layout.ttlive_dialog_group_photo, r111, false);
        this.f100325d = r100;
        this.f100326e = (ConstraintLayout) r100.findViewById(R.id.photo_content_layout);
        if (o.a() == false) goto L7;
        ConstraintLayout r101 = this.f100326e;
        if (r101 == null) goto L7;
        a1.l(r101, UtilityKotlinExtentionsKt.i(29));
    L7:
        this.f100327f = (ImageView) r100.findViewById(R.id.content);
        this.f100328g = (ImageView) r100.findViewById(R.id.avatar);
        this.f100329h = (ImageView) r100.findViewById(R.id.small_avatar);
        this.f100330i = (ImageView) r100.findViewById(R.id.qr_code);
        this.f100331j = (TextView) r100.findViewById(R.id.qr_code_text);
        py.k r102 = this.f100335n.groupPhoto;
        if (r102 != null) goto L11;
    L14:
        ImageView r103 = this.f100329h;
        if (r103 == null) goto L17;
        r103.post(new c(this));
    L17:
        l r104 = this.f100334m;
        View r105 = this.f100325d;
        ImageView r106 = null;
        if (r105 == null) goto L20;
        ConstraintLayout r107 = (ConstraintLayout) r105.findViewById(R.id.share_layout);
    L21:
        r104.f100356a = r107;
        if (r107 == null) goto L26;
        HSImageView r108 = (HSImageView) r107.findViewById(R.id.share_friend_icon);
        if (r108 == null) goto L26;
        i2.h(r108, "/share/groupphoto/share_friend.png");
    L26:
        if (r107 == null) goto L30;
        HSImageView r109 = (HSImageView) r107.findViewById(R.id.share_weixin_icon);
        if (r109 == null) goto L30;
        i2.h(r109, "/share/groupphoto/share_weixin.png");
    L30:
        if (r107 == null) goto L34;
        HSImageView r113 = (HSImageView) r107.findViewById(R.id.share_qq_icon);
        if (r113 == null) goto L34;
        i2.h(r113, "/share/groupphoto/share_qq.png");
    L34:
        if (r107 == null) goto L38;
        HSImageView r114 = (HSImageView) r107.findViewById(R.id.share_download_icon);
        if (r114 == null) goto L38;
        i2.h(r114, "/share/groupphoto/share_download.png");
    L38:
        if (r107 == null) goto L42;
        LinearLayout r115 = (LinearLayout) r107.findViewById(R.id.share_friend);
        if (r115 == null) goto L42;
        r115.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$1(r104)));
    L42:
        if (r107 == null) goto L46;
        LinearLayout r116 = (LinearLayout) r107.findViewById(R.id.share_weixin);
        if (r116 == null) goto L46;
        r116.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$2(r104)));
    L46:
        if (r107 == null) goto L50;
        LinearLayout r117 = (LinearLayout) r107.findViewById(R.id.share_qq);
        if (r117 == null) goto L50;
        r117.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$3(r104)));
    L50:
        if (r107 == null) goto L54;
        LinearLayout r118 = (LinearLayout) r107.findViewById(R.id.share_download);
        if (r118 == null) goto L54;
        r118.setOnClickListener(new m(new GroupPhotoShareLayoutViewHolder$initView$4(r104)));
    L54:
        View r119 = this.f100325d;
        if (r119 == null) goto L57;
        r106 = (ImageView) r119.findViewById(R.id.cancel_icon);
    L57:
        this.f100332k = r106;
        if (r106 == null) goto L60;
        r106.setOnClickListener(new com.bytedance.android.live.room.share.summersinging.b(this));
    L60:
        ImageView r120 = this.f100327f;
        if (r120 == null) goto L63;
        r120.setImageBitmap(this.f100337p.f100364a);
    L63:
        View r121 = this.f100325d;
        if (r121 == null) goto L75;
        Context r122 = r121.getContext();
        if (r122 == null) goto L75;
        Resources r123 = r122.getResources();
        if (r123 == null) goto L75;
        RoundedBitmapDrawable r124 = RoundedBitmapDrawableFactory.create(r123, this.f100337p.f100365b);
        r124.setCornerRadius(UtilityKotlinExtentionsKt.h(200));
        ImageView r125 = this.f100328g;
        if (r125 == null) goto L72;
        r125.setImageDrawable(r124);
    L72:
        ImageView r126 = this.f100328g;
        if (r126 == null) goto L75;
        r126.setColorFilter(s1.h(R.color.ttlive_group_photo_avatar_filter_color));
    L75:
        ImageView r127 = this.f100329h;
        if (r127 == null) goto L78;
        r127.setImageBitmap(this.f100337p.f100365b);
    L78:
        ImageView r128 = this.f100329h;
        if (r128 == null) goto L82;
        r128.setColorFilter(s1.h(R.color.ttlive_group_photo_avatar_filter_color));
    L82:
        if (this.f100337p.f100366c == null) goto L99;
        double r129 = 62;
        py.k r130 = this.f100335n.groupPhoto;
        if (r130 == null) goto L86;
        int r131 = r130.getWidth();
    L87:
        double r132 = r129 * (((double) r131) / 308.0d);
        ALogger.i("GroupPhotoDialogFragment", "qrCode size " + r132);
        ImageView r133 = this.f100330i;
        if (r133 == null) goto L90;
        a1.p(r133, (int) UtilityKotlinExtentionsKt.h((float) r132));
    L90:
        ImageView r134 = this.f100330i;
        if (r134 == null) goto L93;
        a1.k(r134, (int) UtilityKotlinExtentionsKt.h((float) r132));
    L93:
        ImageView r135 = this.f100330i;
        if (r135 == null) goto L96;
        r135.setImageBitmap(this.f100337p.f100366c);
    L96:
        TextView r136 = this.f100331j;
        if (r136 == null) goto L105;
        r136.setText(this.f100335n.shareContent);
    L105:
        ConstraintLayout r137 = this.f100334m.f100356a;
        if (r137 == null) goto L108;
        UtilityKotlinExtentionsKt.d(r137, 150);
    L108:
        ImageView r138 = this.f100332k;
        if (r138 == null) goto L111;
        UtilityKotlinExtentionsKt.d(r138, 150);
    L111:
        ConstraintLayout r139 = this.f100326e;
        if (r139 == null) goto L114;
        r139.setVisibility(0);
    L114:
        Keyframe r140 = Keyframe.ofFloat(0.34305316f, UtilityKotlinExtentionsKt.h(-1));
        r140.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Unit r141 = Unit.INSTANCE;
        float r142 = 0;
        Keyframe r143 = Keyframe.ofFloat(1.0f, UtilityKotlinExtentionsKt.h(r142));
        r143.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Keyframe[] r144 = {Keyframe.ofFloat(0.0f, UtilityKotlinExtentionsKt.h(2)), r140, r143};
        Keyframe r145 = Keyframe.ofFloat(1.0f, UtilityKotlinExtentionsKt.h(r142));
        r145.setInterpolator(PathInterpolatorCompat.create(0.14f, 0.68f, 0.58f, 1.0f));
        Keyframe[] r146 = {Keyframe.ofFloat(0.0f, UtilityKotlinExtentionsKt.h(50)), r145};
        Keyframe r147 = Keyframe.ofFloat(0.57118356f, 0.99f);
        r147.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Keyframe r148 = Keyframe.ofFloat(1.0f, 1.0f);
        r148.setInterpolator(PathInterpolatorCompat.create(0.16f, 0.66f, 0.48f, 1.0f));
        Keyframe[] r149 = {Keyframe.ofFloat(0.0f, 1.2f), r147, r148};
        Keyframe r150 = Keyframe.ofFloat(0.85763294f, 0.0f);
        r150.setInterpolator(PathInterpolatorCompat.create(0.21f, 0.7f, 0.25f, 1.0f));
        Keyframe[] r151 = {Keyframe.ofFloat(0.0f, -10.0f), r150, Keyframe.ofFloat(1.0f, 0.0f)};
        Keyframe r152 = Keyframe.ofFloat(0.2572899f, 1.0f);
        r152.setInterpolator(new LinearInterpolator());
        ValueAnimator r153 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("xOffset", r144), PropertyValuesHolder.ofKeyframe("yOffset", r146), PropertyValuesHolder.ofKeyframe("scale", r149), PropertyValuesHolder.ofKeyframe("rotation", r151), PropertyValuesHolder.ofKeyframe("alpha", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), r152, Keyframe.ofFloat(1.0f, 1.0f)})});
        r153.setDuration(583);
        r153.addUpdateListener(new d(this));
        r153.start();
        this.f100333l = r153;
        return r100;
    L86:
        r131 = 308;
        goto L87
    L99:
        ImageView r154 = this.f100330i;
        if (r154 == null) goto L102;
        r154.setVisibility(8);
    L102:
        TextView r155 = this.f100331j;
        if (r155 == null) goto L105;
        r155.setVisibility(8);
        goto L105
    L20:
        r107 = null;
        goto L21
    L11:
        if (o.a() == false) goto L13;
        S90(this.f100327f, 260, 400);
        goto L14
    L13:
        S90(this.f100327f, r102.getWidth(), r102.getHeight());
        goto L14
    }
}
