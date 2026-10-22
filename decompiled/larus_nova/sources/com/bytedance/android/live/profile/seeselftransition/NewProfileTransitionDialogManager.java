package com.bytedance.android.live.profile.seeselftransition;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.profile.NewLiveProfileDialogFragment;
import com.bytedance.android.live.profile.p004enum.ProfileMode;
import com.bytedance.android.livesdk.chatroom.utils.i2;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profile/seeselftransition/NewProfileTransitionDialogManager;", "Lcom/bytedance/android/live/profile/seeselftransition/a;", "", "Landroidx/lifecycle/LifecycleObserver;", "", "dismiss", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewProfileTransitionDialogManager implements com.bytedance.android.live.profile.seeselftransition.a, LifecycleObserver {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f86146l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function0<Unit> f86147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f86148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f86149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.live.profile.seeselftransition.b f86150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.live.profile.seeselftransition.b f86151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FragmentManager f86152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ValueAnimator f86153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f86154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f86155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Disposable f86156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f86157k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewProfileTransitionDialogManager f86158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.profile.seeselftransition.b f86159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.live.profile.seeselftransition.b f86160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f86161d;

        public b(NewProfileTransitionDialogManager r100, com.bytedance.android.live.profile.seeselftransition.b r101, com.bytedance.android.live.profile.seeselftransition.b r102, FragmentManager r103) {
            this.f86158a = r100;
            this.f86159b = r101;
            this.f86160c = r102;
            this.f86161d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            Bitmap r102 = (Bitmap) r101.getFirst();
            if (r102 != null) goto L5;
            ALogger.e("TransitionDialogManager", "get show to hide bitmap error");
            NewProfileTransitionDialogManager r103 = this.f86158a;
            int r104 = NewProfileTransitionDialogManager.f86146l;
            r103.f();
            return;
        L5:
            Bitmap r105 = (Bitmap) r101.getSecond();
            if (r105 != null) goto L8;
            ALogger.e("TransitionDialogManager", "get hide to show bitmap error");
            NewProfileTransitionDialogManager r106 = this.f86158a;
            int r107 = NewProfileTransitionDialogManager.f86146l;
            r106.f();
            return;
        L8:
            this.f86159b.Wl(new k(1, r102));
            this.f86160c.Wl(new k(2, r105));
            this.f86160c.BJ(this.f86158a, ProfileMode.USER_CURRENT);
            FragmentManager r108 = this.f86161d;
            if (r108 == null) goto L11;
            this.f86160c.show(r108, "SeeSelfTransitionDialogManager_Current");
        L11:
            this.f86159b.BJ(this.f86158a, ProfileMode.USER_BEFORE);
            FragmentManager r109 = this.f86161d;
            if (r109 == null) goto L14;
            this.f86159b.show(r109, "SeeSelfTransitionDialogManager_Before");
        L14:
            this.f86158a.f86148b = 3;
            this.f86159b.getLifecycleOwner().getLifecycle().addObserver(this.f86158a);
            this.f86160c.getLifecycleOwner().getLifecycle().addObserver(this.f86158a);
        }
    }

    static {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void dismiss() {
        ALogger.i("TransitionDialogManager", "dismiss");
        com.bytedance.android.live.profile.seeselftransition.b r100 = this.f86150d;
        if (r100 == null) goto L5;
        r100.d80();
    L5:
        com.bytedance.android.live.profile.seeselftransition.b r101 = this.f86151e;
        if (r101 == null) goto L8;
        r101.d80();
    L8:
        f();
    }

    public final void f() {
        Function0<Unit> r100 = this.f86147a;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke();
    L5:
        this.f86147a = null;
        this.f86148b = 4;
        this.f86150d = null;
        this.f86151e = null;
        ValueAnimator r102 = this.f86153g;
        if (r102 != null) goto L8;
    L12:
        this.f86153g = null;
        this.f86154h = 0;
        Disposable r103 = this.f86155i;
        if (r103 == null) goto L15;
        r103.dispose();
    L15:
        this.f86155i = null;
        this.f86149c = false;
        this.f86152f = null;
        Disposable r104 = this.f86156j;
        if (r104 == null) goto L18;
        r104.dispose();
    L18:
        this.f86156j = null;
        return;
    L8:
        if (r102.isRunning() != true) goto L12;
        ValueAnimator r105 = this.f86153g;
        if (r105 == null) goto L12;
        r105.end();
        goto L12
    }

    public final void g() {
        ALogger.i("TransitionDialogManager", "open dialog");
        if (this.f86148b != 4) goto L5;
        return;
    L5:
        this.f86149c = true;
        if (((Boolean) this.f86157k.getValue()).booleanValue() == false) goto L8;
        i(this.f86152f);
        return;
    L8:
        h(this.f86152f);
    }

    public final boolean isShowing() {
        if (this.f86148b >= 4) goto L5;
        return true;
    L5:
        return false;
    }

    public NewProfileTransitionDialogManager() {
        this.f86157k = LazyKt.lazy(NewProfileTransitionDialogManager$getBitmapOpt$2.INSTANCE);
    }

    public static final /* synthetic */ void c(NewProfileTransitionDialogManager r100) {
        r100.dismiss();
    }

    public final void h(FragmentManager r100) {
        if (this.f86150d != null) goto L5;
        return;
    L5:
        if (this.f86151e == null) goto L39;
        this.f86148b = 2;
        if (this.f86149c == true) goto L10;
        return;
    L10:
        ALogger.i("TransitionDialogManager", "show dialog");
        com.bytedance.android.live.profile.seeselftransition.b r101 = this.f86150d;
        if (r101 != null) goto L13;
        return;
    L13:
        com.bytedance.android.live.profile.seeselftransition.b r102 = this.f86151e;
        if (r102 != null) goto L16;
        return;
    L16:
        File r103 = com.bytedance.android.livesdk.gecko.offline.f.a(i2.b("/profile/transition/ttlive_profile_transition_show_to_hide.png"));
        Bitmap r104 = null;
        if (r103 != null) goto L19;
        Bitmap r105 = null;
    L20:
        if (r105 != null) goto L23;
        ALogger.e("TransitionDialogManager", "get show to hide bitmap error");
        f();
        return;
    L23:
        File r106 = com.bytedance.android.livesdk.gecko.offline.f.a(i2.b("/profile/transition/ttlive_profile_transition_hide_to_show.png"));
        if (r106 == null) goto L27;
        r104 = BitmapFactory.decodeFile(r106.getAbsolutePath());
    L27:
        if (r104 != null) goto L30;
        ALogger.e("TransitionDialogManager", "get hide to show bitmap error");
        f();
        return;
    L30:
        r101.Wl(new k(1, r105));
        r102.Wl(new k(2, r104));
        r102.BJ(this, ProfileMode.USER_CURRENT);
        if (r100 == null) goto L33;
        r102.show(r100, "SeeSelfTransitionDialogManager_Current");
    L33:
        r101.BJ(this, ProfileMode.USER_BEFORE);
        if (r100 == null) goto L36;
        r101.show(r100, "SeeSelfTransitionDialogManager_Before");
    L36:
        this.f86148b = 3;
        r101.getLifecycleOwner().getLifecycle().addObserver(this);
        r102.getLifecycleOwner().getLifecycle().addObserver(this);
        return;
    L19:
        r105 = BitmapFactory.decodeFile(r103.getAbsolutePath());
        goto L20
    }

    public final void i(FragmentManager r100) {
        if (this.f86150d != null) goto L5;
        return;
    L5:
        if (this.f86151e == null) goto L19;
        this.f86148b = 2;
        if (this.f86149c == true) goto L10;
        return;
    L10:
        ALogger.i("TransitionDialogManager", "show dialog");
        com.bytedance.android.live.profile.seeselftransition.b r101 = this.f86150d;
        if (r101 != null) goto L13;
        return;
    L13:
        com.bytedance.android.live.profile.seeselftransition.b r102 = this.f86151e;
        if (r102 != null) goto L16;
        return;
    L16:
        Observable r103 = Observable.create(new f("/profile/transition/ttlive_profile_transition_show_to_hide.png")).subscribeOn(Schedulers.io());
        g r104 = g.f86169a;
        this.f86156j = Observable.zip(r103.map(r104), Observable.create(new f("/profile/transition/ttlive_profile_transition_hide_to_show.png")).subscribeOn(Schedulers.io()).map(r104), e.f86165a).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(TuplesKt.to(null, null)).subscribe(new b(this, r101, r102, r100));
        return;
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.a
    public final void a(ProfileMode r100, NewLiveProfileDialogFragment r101) {
        Intrinsics.checkNotNullParameter(r100, "dialogMode");
        Intrinsics.checkNotNullParameter(r101, "dialogFragment");
        ALogger.i("TransitionDialogManager", "user request exit");
        dismiss();
    }

    @Override // com.bytedance.android.live.profile.seeselftransition.a
    public final void b(ProfileMode r110, NewLiveProfileDialogFragment r210) {
        Intrinsics.checkNotNullParameter(r110, "dialogMode");
        Intrinsics.checkNotNullParameter(r210, "dialogFragment");
        ALogger.i("TransitionDialogManager", "one dialog entered: mode: " + r110);
        int r100 = this.f86154h + 1;
        this.f86154h = r100;
        if (r100 != 2) goto L12;
        com.bytedance.android.live.profile.seeselftransition.b r101 = this.f86150d;
        if (r101 == null) goto L13;
        com.bytedance.android.live.profile.seeselftransition.b r102 = this.f86151e;
        if (r102 == null) goto L14;
        PointF r103 = r101.v10();
        ALogger.i("TransitionDialogManager", "getDressUpCardLocation, before: " + r103 + ", current: " + r102.v10());
        r101.ks(r103);
        r102.ks(r103);
        Pair<Integer, Integer> r104 = r101.Ls();
        int r105 = r104.component1().intValue();
        int r106 = r104.component2().intValue();
        Pair<Integer, Integer> r107 = r102.Ls();
        int r108 = Math.max(Math.max(r105, Math.max(r106, r107.component1().intValue())), r107.component2().intValue());
        float r109 = (float) (Math.sqrt(((double) (r108 * r108)) * 2.0d) * 1.5d);
        ALogger.i("TransitionDialogManager", "markMaxOffset: " + r109);
        double r111 = (double) AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        float r112 = (float) (((double) 200) / r111);
        ValueAnimator r113 = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe("beforeIconScale", new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(r112, 0.4f), Keyframe.ofFloat(1.0f, 0.4f)}), PropertyValuesHolder.ofKeyframe("currentIconScale", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.4f), Keyframe.ofFloat(r112, 0.4f), Keyframe.ofFloat((float) (450 / r111), 1.04f), Keyframe.ofFloat((float) (600 / r111), 0.98f), Keyframe.ofFloat((float) (750 / r111), 1.005f), Keyframe.ofFloat((float) (900 / r111), 1.0f), Keyframe.ofFloat(1.0f, 1.0f)}), PropertyValuesHolder.ofKeyframe("dialogMark", new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(r112, 0.0f), Keyframe.ofFloat((float) (r111 / r111), r109)})});
        r113.setDuration(AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
        r113.addUpdateListener(new i(r101, r102));
        r113.addListener(new j(this, r101, r102));
        r113.start();
        Unit r114 = Unit.INSTANCE;
        this.f86153g = r113;
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void d(com.bytedance.android.live.profile.seeselftransition.b r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        ALogger.i("TransitionDialogManager", "add before dialog");
        this.f86148b = 1;
        this.f86150d = r100;
        this.f86152f = r101;
        if (((Boolean) this.f86157k.getValue()).booleanValue() == false) goto L5;
        i(r101);
        return;
    L5:
        h(r101);
    }

    public final void e(com.bytedance.android.live.profile.seeselftransition.b r100, FragmentManager r101) {
        Intrinsics.checkNotNullParameter(r100, "dialogFragment");
        Intrinsics.checkNotNullParameter(r101, "fragmentManager");
        ALogger.i("TransitionDialogManager", "add current dialog");
        this.f86148b = 1;
        this.f86151e = r100;
        this.f86152f = r101;
        if (((Boolean) this.f86157k.getValue()).booleanValue() == false) goto L5;
        i(r101);
        return;
    L5:
        h(r101);
    }
}
