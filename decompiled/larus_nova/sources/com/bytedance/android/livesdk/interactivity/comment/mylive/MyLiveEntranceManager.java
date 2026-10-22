package com.bytedance.android.livesdk.interactivity.comment.mylive;

import am2.x;
import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.api.base.utils.InteractivityOpt;
import com.bytedance.android.livesdk.interactivity.api.h;
import com.bytedance.android.livesdk.interactivity.api.i;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.f;
import py.k;
import yt0.c;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/mylive/MyLiveEntranceManager;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MyLiveEntranceManager implements Observer<KVData> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f135315k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HSImageView f135316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HSImageView f135317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CompositeDisposable f135318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f135319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f135320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f135321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IRoom f135322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f135323h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final DataContext f135324i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DataCenter f135325j;

    public static final class a {
    }

    static {
    }

    public final IBaseUser b() {
        DataCenter r100 = this.f135325j;
        if (r100 != null) goto L5;
        return null;
    L5:
        return (IBaseUser) r100.get("data_user_in_room", null);
    }

    public final Context getContext() {
        return this.f135321f;
    }

    public static final void a(MyLiveEntranceManager r100) {
        r100.getClass();
        HashMap r101 = new HashMap();
        IBaseUser r102 = r100.b();
        if (r102 != null) goto L5;
    L7:
        r101.put("my_live_status", "head_portrait");
    L8:
        j0.l().sendLog("livesdk_my_live_button_click", r101, new Object[]{IRoom.class, x.class});
        return;
    L5:
        if (r102.isMysteryMan() != true) goto L7;
        r101.put("my_live_status", "mystery_man");
        goto L8
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        k r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.getKey();
    L7:
        if ((!Intrinsics.areEqual("data_user_in_room", r103)) == false) goto L10;
        return;
    L10:
        if (this.f135316a != null) goto L12;
        return;
    L12:
        if (this.f135317b == null) goto L55;
        UIUtils.setViewVisibility(this.f135323h, 0);
        HSImageView r104 = this.f135316a;
        IBaseUser r105 = b();
        if (r105 == null) goto L16;
        r102 = r105.getAvatarThumbKt();
    L16:
        int r106 = this.f135319d;
        ImageLoader.bindAvatar(r104, r102, r106, r106);
        IBaseUser r107 = b();
        if (r107 != null) goto L19;
    L22:
        IBaseUser r108 = b();
        if (r108 == null) goto L33;
        f r109 = r108.getBorder();
        if (r109 == null) goto L33;
        com.bytedance.android.live.profit.dress.a r110 = (com.bytedance.android.live.profit.dress.a) c.a().getDressData(r109.getDressId(), 1, "myLive");
        if (r110 == null) goto L30;
        k r111 = r110.f87077a;
        if (r111 == null) goto L30;
    L31:
        if (r111 == null) goto L33;
        HSImageView r112 = this.f135317b;
        int r113 = this.f135320e;
        ImageLoader.bindAvatar(r112, r111, r113, r113);
    L30:
        r111 = r109.getIcon();
    L33:
        ALogger.i("MyLive", "bind userInRoom User data");
        h r114 = i.a(this.f135324i, this.f135325j);
        if (r114 == null) goto L50;
        m<Boolean> r115 = r114.getMyLiveEntranceHasShow();
        if (r115 == null) goto L50;
        if (r115.getValue().booleanValue() == true) goto L50;
        HashMap r116 = new HashMap();
        IBaseUser r117 = b();
        if (r117 != null) goto L42;
    L44:
        r116.put("my_live_status", "head_portrait");
    L45:
        j0.l().sendLog("livesdk_my_live_button_show", r116, new Object[]{IRoom.class, x.class});
        h r118 = i.a(this.f135324i, this.f135325j);
        if (r118 == null) goto L50;
        m<Boolean> r119 = r118.getMyLiveEntranceHasShow();
        if (r119 == null) goto L50;
        r119.setValue(Boolean.TRUE);
        goto L50
    L42:
        if (r117.isMysteryMan() != true) goto L44;
        r116.put("my_live_status", "mystery_man");
    L50:
        IBaseUser r120 = b();
        if (r120 == null) goto L56;
        this.f135323h.setOnClickListener(new y62.c(r120, this));
        return;
    L56:
        return;
    L19:
        if (r107.isMysteryMan() != true) goto L22;
        if (y62.a.f566323b == false) goto L33;
    L55:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public MyLiveEntranceManager(Context r100, IRoom r101, FrameLayout r102, DataContext r103, DataCenter r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "room");
        Intrinsics.checkNotNullParameter(r102, "myLiveContainer");
        this.f135321f = r100;
        this.f135322g = r101;
        this.f135323h = r102;
        this.f135324i = r103;
        this.f135325j = r104;
        this.f135319d = InteractivityOpt.a(32.0f);
        this.f135320e = InteractivityOpt.a(40.0f);
    }
}
