package com.bytedance.android.livesdk.ktvimpl.ktvroom.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.fresco.FrescoLoader;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MicPosTagInfo;
import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/KtvMvSingerInfoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "show", "", "setSingingInfoVisibility", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "l", "Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "getKtvContext", "()Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;", "setKtvContext", "(Lcom/bytedance/android/livesdk/ktvimpl/base/KtvContext;)V", IKtvService.KEY_OF_KTVCONTEXT_FOR_DATACENTER, "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMvSingerInfoView extends ConstraintLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f144923m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f144924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f144925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f144926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f144927d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f144928e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f144929f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f144930g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f144931h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f144932i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public KtvRoomViewModel f144933j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d9 f144934k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public KtvContext f144935l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144936a;

        public b(KtvMvSingerInfoView r100) {
            this.f144936a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            KtvMvSingerInfoView r101 = this.f144936a;
            KtvRoomViewModel r102 = r101.f144933j;
            if (r102 == null) goto L6;
            String r103 = r102.getCurrentSingerUserId();
            if (r103 == null) goto L6;
        L7:
            r101.Y5(r103);
            ALogger.i("KtvMvSingerInfoView", "ktvRoomLabelChangeEvent, updateListUserRole");
            return;
        L6:
            r103 = "";
            goto L7
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144937a;

        public c(KtvMvSingerInfoView r100) {
            this.f144937a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L44;
            KtvMvSingerInfoView r102 = this.f144937a;
            KtvContext r103 = r102.f144935l;
            if (r103 == null) goto L7;
            boolean r104 = r103.isCurrentUserIsSinger();
        L9:
            if (r104 == false) goto L19;
            TextView r105 = r102.f144927d;
            if (r105 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerNicknameTv");
        L13:
            if (r105 != null) goto L15;
        L28:
            KtvContext r106 = r102.f144935l;
            String r107 = null;
            if (r106 == null) goto L39;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r108 = r106.getKtvCoreViewModel();
            if (r108 == null) goto L39;
            com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r109 = r108.getValue();
            if (r109 == null) goto L39;
            KtvRoomLyricsStateMachineConfig.d r110 = r109.getCurState();
            if (r110 == null) goto L39;
            MusicPanel r111 = r110.b();
            if (r111 == null) goto L39;
            KtvMusic r112 = r111.f153577a;
        L40:
            if (r112 == null) goto L42;
            r107 = r112.getMTitle();
        L42:
            r102.Z5(r107);
            return;
        L39:
            r112 = null;
            goto L40
        L15:
            if (r101.length() <= 3) goto L18;
            r101 = r101.substring(0, 3) + "...";
        L18:
            r105.setText(r101);
            goto L28
        L19:
            TextView r113 = r102.f144927d;
            if (r113 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerNicknameTv");
        L22:
            if (r113 == null) goto L28;
            if (r101.length() <= 5) goto L27;
            r101 = r101.substring(0, 5) + "...";
        L27:
            r113.setText(r101);
            goto L28
        L7:
            r104 = false;
            goto L9
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144938a;

        public d(KtvMvSingerInfoView r100) {
            this.f144938a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            String r101 = (String) r100;
            if (r101 == null) goto L6;
            KtvMvSingerInfoView r102 = this.f144938a;
            int r103 = KtvMvSingerInfoView.f144923m;
            r102.Z5(r101);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144939a;

        public e(KtvMvSingerInfoView r100) {
            this.f144939a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            py.k r101 = (py.k) r100;
            if (r101 == null) goto L15;
            KtvMvSingerInfoView r102 = this.f144939a;
            int r103 = KtvMvSingerInfoView.f144923m;
            r102.getClass();
            int r104 = s1.f(64.0f);
            int r105 = s1.f(64.0f);
            FrescoLoader r106 = FrescoLoader.with(r102.getContext()).load(r101);
            if (r106 == null) goto L16;
            FrescoLoader r107 = r106.roundAsCircle();
            if (r107 == null) goto L17;
            FrescoLoader r108 = r107.resize(r104, r105);
            if (r108 == null) goto L18;
            HSImageView r109 = r102.f144924a;
            if (r109 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarIv");
        L13:
            r108.into(r109);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144940a;

        public f(KtvMvSingerInfoView r100) {
            this.f144940a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x r101 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x) r100;
            if (r101 == null) goto L6;
            KtvMvSingerInfoView r102 = this.f144940a;
            Integer r103 = Integer.valueOf((int) r101.f145578c);
            int r104 = KtvMvSingerInfoView.f144923m;
            r102.V5(r103);
            KtvMvSingerInfoView r105 = this.f144940a;
            r105.f144932i = r101.f145576a;
            return;
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144941a;

        public g(KtvMvSingerInfoView r100) {
            this.f144941a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L26;
            HSImageView r101 = this.f144941a.f144925b;
            if (r101 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L7:
            if (r101 == null) goto L9;
            r101.setVisibility(0);
        L9:
            KtvMvSingerInfoView r102 = this.f144941a;
            HSImageView r103 = r102.f144925b;
            if (r103 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L13:
            if (KtvSettingHelper.z() == false) goto L18;
            d9 r104 = r102.f144934k;
            if (TextUtils.isEmpty(r104.stageSingEffect) == false) goto L17;
            r104.stageSingEffect = d9.f120011d;
        L17:
            String r105 = r104.stageSingEffect;
        L22:
            if (r103 != null) goto L24;
            return;
        L24:
            if (r103.getVisibility() != 0) goto L38;
            r103.setController(Fresco.newDraweeControllerBuilder().setUri(r105).setAutoPlayAnimations(true).build());
            return;
        L38:
            return;
        L18:
            d9 r106 = r102.f144934k;
            if (TextUtils.isEmpty(r106.stageSingEffect) == false) goto L21;
            r106.stageSingEffect = d9.f120010c;
        L21:
            r105 = r106.stageSingEffect;
            goto L22
        L26:
            HSImageView r107 = this.f144941a.f144925b;
            if (r107 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L29:
            if (r107 == null) goto L31;
            r107.setController(null);
        L31:
            HSImageView r108 = this.f144941a.f144925b;
            if (r108 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarAnimIv");
        L34:
            if (r108 == null) goto L40;
            r108.setVisibility(8);
            return;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMvSingerInfoView f144943a;

        public i(KtvMvSingerInfoView r100) {
            this.f144943a = r100;
        }

        public final void a() {
            TextView r100 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r100 == null) goto L6;
            r100.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        L6:
            if (KtvSettingHelper.z() == false) goto L10;
            TextView r101 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r101 == null) goto L10;
            r101.setMarqueeRepeatLimit(3);
        L10:
            TextView r102 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r102 == null) goto L13;
            r102.setSingleLine(true);
        L13:
            TextView r103 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r103 == null) goto L16;
            r103.setSelected(true);
        L16:
            TextView r104 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r104 == null) goto L19;
            r104.setEnabled(true);
        L19:
            TextView r105 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r105 == null) goto L22;
            r105.setFocusable(true);
        L22:
            TextView r106 = KtvMvSingerInfoView.R5(this.f144943a);
            if (r106 == null) goto L26;
            r106.setFocusableInTouchMode(true);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public KtvMvSingerInfoView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvMvSingerInfoView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final KtvContext getKtvContext() {
        return this.f144935l;
    }

    public static final /* synthetic */ TextView R5(KtvMvSingerInfoView r100) {
        TextView r101 = r100.f144928e;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L5:
        return r101;
    }

    public final void T5(MicPosTagInfo r100) {
        if (r100 == null) goto L30;
        TextView r101 = this.f144926c;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L7:
        if (r101 == null) goto L9;
        r101.setVisibility(0);
    L9:
        TextView r102 = this.f144926c;
        if (r102 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L12:
        py.k r103 = r100.getBgColorImg();
        if (r103 == null) goto L29;
        KtvUtilsKt.i(r102, r103);
        String r104 = r100.getPositionTagName();
        if (r104 == null) goto L22;
        TextView r105 = this.f144926c;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L19:
        if (r105 == null) goto L22;
        r105.setText(r104);
    L22:
        if (TextUtils.isEmpty(r100.getTextColor()) == true) goto L36;
        TextView r106 = this.f144926c;
        if (r106 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L26:
        if (r106 == null) goto L37;
        r106.setTextColor(ColorProtector.parseColor(r100.getTextColor()));
        return;
    L37:
        return;
    L36:
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.api.IImageModel");
    L30:
        TextView r107 = this.f144926c;
        if (r107 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerTagTv");
    L33:
        if (r107 == null) goto L39;
        r107.setVisibility(8);
        return;
    }

    public final void U5(long r100) {
        String r101 = new SimpleDateFormat("mm:ss", Locale.US).format(Long.valueOf(r100));
        TextView r102 = this.f144929f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountDownTv");
    L5:
        if (r102 == null) goto L8;
        r102.setText(r101);
        return;
    }

    public final void V5(Integer r100) {
        TextView r101 = this.f144930g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L5:
        if (r101 == null) goto L8;
        r101.setText(String.valueOf(r100));
        return;
    }

    public final void Y5(String r100) {
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        MicPosTagInfo r102 = null;
        if (r101 == null) goto L18;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r103 = r101.getLinkUserInfoCenter();
        if (r103 == null) goto L18;
        Iterable r104 = r103.getOnlineUserList();
        if (r104 == null) goto L18;
        Iterator r105 = r104.iterator();
        LinkPlayerInfo r106 = null;
    L10:
        if (r105.hasNext() == false) goto L20;
        ILinkPlayerInfoBridge r107 = (ILinkPlayerInfoBridge) r105.next();
        IBaseUser r108 = r107.getUser();
        if (r108 == null) goto L14;
        String r109 = r108.getIdString();
    L16:
        if (Intrinsics.areEqual(r100, r109) == false) goto L10;
        r106 = (LinkPlayerInfo) r107;
        goto L10
    L14:
        r109 = null;
    L20:
        if (r106 == null) goto L24;
        MicPosTagInfo r110 = r106.micPosTagInfo;
        if (r110 == null) goto L24;
        long r111 = r110.getTagType();
    L26:
        if (r111 <= 0) goto L30;
        if (r106 == null) goto L29;
        r102 = r106.micPosTagInfo;
    L29:
        T5(r102);
        return;
    L30:
        T5(null);
        return;
    L24:
        r111 = 0;
    L18:
        r106 = null;
        goto L20
    }

    public final void Z5(String r100) {
        KtvContext r101 = this.f144935l;
        if (r101 == null) goto L5;
        boolean r102 = r101.isCurrentUserIsSinger();
    L7:
        if (r102 == false) goto L13;
        TextView r103 = this.f144928e;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L11:
        if (r103 == null) goto L18;
        r103.setMaxEms(4);
    L18:
        TextView r104 = this.f144928e;
        if (r104 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L21:
        if (r104 == null) goto L23;
        r104.setText(r100);
    L23:
        i0.c().post(new i(this));
        return;
    L13:
        TextView r105 = this.f144928e;
        if (r105 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mSongNameTv");
    L16:
        if (r105 == null) goto L18;
        r105.setMaxEms(5);
        goto L18
    L5:
        r102 = false;
        goto L7
    }

    public final void setKtvContext(KtvContext r100) {
        this.f144935l = r100;
    }

    public final void setSingingInfoVisibility(boolean r100) {
        View r101 = this.f144931h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSingingInfoContainer");
    L5:
        if (r101 == null) goto L11;
        if (r100 == false) goto L8;
        int r102 = 0;
    L9:
        r101.setVisibility(r102);
        return;
    L8:
        r102 = 8;
        goto L9
    }

    public KtvMvSingerInfoView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f144934k = vm2.k.a();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_ktv_mv_singer_info_layout, this);
        this.f144924a = (HSImageView) findViewById(R.id.ktv_mv_singer_avatar);
        this.f144925b = (HSImageView) findViewById(R.id.ktv_mv_singer_avatar_anim);
        this.f144926c = (TextView) findViewById(R.id.ktv_mv_singer_singing_tag);
        this.f144927d = (TextView) findViewById(R.id.ktv_mv_singer_nickname);
        this.f144928e = (TextView) findViewById(R.id.ktv_mv_song_title);
        TextView r103 = (TextView) findViewById(R.id.ktv_mv_song_count_down);
        this.f144929f = r103;
        if (r103 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSongCountDownTv");
    L5:
        r103.setText("00:00");
        this.f144930g = (TextView) findViewById(R.id.ktv_mv_hot_info);
        this.f144931h = findViewById(R.id.ktv_singer_info_container);
        HSImageView r104 = this.f144924a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerAvatarIv");
    L8:
        r104.setOnClickListener(new w(this));
        TextView r105 = this.f144930g;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSingerHotInfoTv");
    L11:
        r105.setOnClickListener(new x(this));
    }

    public final void S5(LifecycleOwner r100, KtvRoomViewModel r101, CompositeDisposable r102) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "mCompositeDisposable");
        this.f144933j = r101;
        if (r101 == null) goto L7;
        MutableLiveData<oe2.f> r103 = r101.getStageUiState();
        if (r103 == null) goto L7;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r103, r100, KtvMvSingerInfoView$onAttach$1.INSTANCE, new c(this));
    L7:
        KtvRoomViewModel r104 = this.f144933j;
        if (r104 == null) goto L12;
        MutableLiveData<oe2.f> r105 = r104.getStageUiState();
        if (r105 == null) goto L12;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r105, r100, KtvMvSingerInfoView$onAttach$3.INSTANCE, new d(this));
    L12:
        KtvRoomViewModel r106 = this.f144933j;
        if (r106 == null) goto L17;
        MutableLiveData<oe2.f> r107 = r106.getStageUiState();
        if (r107 == null) goto L17;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r107, r100, KtvMvSingerInfoView$onAttach$5.INSTANCE, new e(this));
    L17:
        KtvRoomViewModel r108 = this.f144933j;
        if (r108 == null) goto L22;
        NextLiveData<com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.x> r109 = r108.getKtvsingHotInfo();
        if (r109 == null) goto L22;
        r109.observe(r100, new f(this));
    L22:
        KtvRoomViewModel r110 = this.f144933j;
        if (r110 == null) goto L27;
        MutableLiveData<oe2.f> r111 = r110.getStageUiState();
        if (r111 == null) goto L27;
        com.bytedance.android.livesdk.ktvapi.util.d.a(r111, r100, KtvMvSingerInfoView$onAttach$8.INSTANCE, new g(this));
    L27:
        KtvRoomViewModel r112 = this.f144933j;
        if (r112 == null) goto L32;
        NextLiveData<Pair<Boolean, com.bytedance.android.live.ktv.common.model.bean.a>> r113 = r112.getCountDownEvent();
        if (r113 == null) goto L32;
        final KtvMvSingerInfoView$onAttach$10 r114 = new KtvMvSingerInfoView$onAttach$10(this);
        r113.observe(r100, new h(r114));
    L32:
        KtvContext r115 = this.f144935l;
        if (r115 == null) goto L42;
        com.bytedance.live.datacontext.k<Object> r116 = r115.getKtvRoomLabelChangeEvent();
        if (r116 == null) goto L43;
        PublishSubject r117 = r116.onEvent();
        if (r117 == null) goto L44;
        Disposable r118 = r117.subscribe(new b(this));
        if (r118 == null) goto L45;
        r102.add(r118);
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }

    public /* synthetic */ KtvMvSingerInfoView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
