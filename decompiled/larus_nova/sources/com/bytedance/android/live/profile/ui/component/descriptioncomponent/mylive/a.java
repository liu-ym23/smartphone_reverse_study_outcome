package com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.BaseProfileInfo;
import com.bytedance.android.live.base.model.user.NewProfileUser;
import com.bytedance.android.live.base.model.user.ProfileCustomSkin;
import com.bytedance.android.live.base.model.user.ProfileSkin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.profile.ui.base.ComponentType;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends com.bytedance.android.live.profile.ui.base.k {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f86610i = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f86611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HSImageView f86612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f86613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f86614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f86615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f86616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.profile.ui.base.h f86617h;

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.ui.component.descriptioncomponent.mylive.a$a, reason: collision with other inner class name */
    public static final class C1329a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f86618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f86619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f86620c;

        public b(a r100, String r101, String r102) {
            this.f86618a = r100;
            this.f86619b = r101;
            this.f86620c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextView r100 = this.f86618a.f86613d;     // Catch: Throwable -> L6
            int r101 = ColorProtector.parseColor(this.f86619b);     // Catch: Throwable -> L6
            int r102 = ColorProtector.parseColor(this.f86620c);     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.getPaint().setShader(new LinearGradient(0.0f, r100.getHeight(), 0.0f, 0.0f, r101, r102, Shader.TileMode.CLAMP));     // Catch: Throwable -> L6
            r100.invalidate();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public void update(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "newUser");
    }

    static {
        f86610i = UtilityKotlinExtentionsKt.i(30);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void onComponentDestroy() {
        com.bytedance.android.live.profile.ui.base.m r100 = com.bytedance.android.live.profile.ui.base.i.n(this.f86617h);
        if (r100 == null) goto L5;
        r100.a(this.f86615f);
    L5:
        this.f86616g = false;
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final ComponentType getComponentType() {
        return ComponentType.MyLiveAvatarNameComponent.INSTANCE;
    }

    public a(com.bytedance.android.live.profile.profilecontext.a r100) {
        Intrinsics.checkNotNullParameter(r100, "profileContext");
        this.f86617h = r100;
        this.f86614e = LazyKt.lazy(new ProfileMyLiveAvatarNameComponent$panelAvatar$2(this));
        this.f86615f = new c(this);
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void b(com.bytedance.android.live.profile.ui.base.d r100) {
        ((com.bytedance.android.live.profile.ui.base.e) r100).f(R.layout.ttlive_profile_my_live_avatar_name_layout, true);
        this.f86611b = i(R.id.root);
        this.f86612c = (HSImageView) i(R.id.avatar);
        this.f86613d = (TextView) i(R.id.name);
        com.bytedance.android.live.profile.ui.base.m r101 = com.bytedance.android.live.profile.ui.base.i.n(this.f86617h);
        if (r101 == null) goto L6;
        r101.d(this.f86615f);
        return;
    }

    @Override // com.bytedance.android.live.profile.ui.base.k, com.bytedance.android.live.profile.ui.base.g
    public final void d(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
    }

    @Override // com.bytedance.android.live.profile.ui.base.g
    public final void g(NewProfileUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        BaseProfileInfo r101 = r100.baseProfileInfo;
        if (r101 == null) goto L7;
        py.k r102 = r101.avatarThumb;
        if (r102 == null) goto L7;
        ImageLoader.bindImage(this.f86612c, r102, UtilityKotlinExtentionsKt.i(24), UtilityKotlinExtentionsKt.i(24));
    L7:
        TextView r103 = this.f86613d;
        if (r103 == null) goto L10;
        r103.setText(r100.getDisplayName());
    L10:
        ProfileSkin r104 = r100.mProfileSkin;
        String r105 = null;
        if (r104 == null) goto L19;
        ProfileCustomSkin r106 = r104.skin;
        if (r106 == null) goto L19;
        ProfileCustomSkin.BgUI r107 = r106.bgSkin;
        if (r107 == null) goto L19;
        ProfileCustomSkin.GradientColor r108 = r107.bgColor;
        if (r108 == null) goto L19;
        String r109 = r108.from;
    L20:
        View r110 = this.f86611b;
        if (r110 == null) goto L55;
        com.bytedance.android.live.profile.ui.util.m.f(r110, r109);
    L55:
        ProfileSkin r111 = r100.mProfileSkin;     // Catch: Exception -> L52
        if (r111 == null) goto L28;
        ProfileCustomSkin r112 = r111.skin;     // Catch: Exception -> L52
        if (r112 == null) goto L28;
        ProfileCustomSkin.GradientColor r113 = r112.nickNameColor;     // Catch: Exception -> L52
    L29:
        if (r113 == null) goto L31;
        String r114 = r113.from;     // Catch: Exception -> L52
    L32:
        if (r113 == null) goto L34;
        r105 = r113.f58938to;     // Catch: Exception -> L52
    L34:
        boolean r115 = true;
        if (r114 != null) goto L37;
    L40:
        boolean r116 = true;
    L41:
        if (r116 == true) goto L57;
        if (r105 != null) goto L44;
    L47:
        if (r115 == true) goto L58;
        TextView r117 = this.f86613d;     // Catch: Exception -> L52
        if (r117 == null) goto L59;
        r117.post(new b(this, r114, r105));     // Catch: Exception -> L52
        return;
    L59:
        return;
    L58:
        return;
    L44:
        if (r105.length() == 0) goto L47;
        r115 = false;
        goto L47
    L57:
        return;
    L37:
        if (r114.length() == 0) goto L40;
        r116 = false;
        goto L41
    L31:
        r114 = null;
    L28:
        r113 = null;
    L52:
        e = move-exception;
        ALogger.e("ProfileMyLiveAvatarNameComponent", "load name color error: " + e.getMessage());
        return;
    L19:
        r109 = null;
        goto L20
    }
}
