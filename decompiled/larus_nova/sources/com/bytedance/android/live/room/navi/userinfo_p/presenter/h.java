package com.bytedance.android.live.room.navi.userinfo_p.presenter;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements e91.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f100141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f100142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f100143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UserInfoTabPresenter f100144d;

    public static final class a implements n81.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f100145b;

        @Override // n81.b
        public final void onShow() {
            IRoom r100 = this.f100145b.f100144d.b();
            if (r100 == null) goto L6;
            String r101 = com.bytedance.android.live.room.navi.userinfo_p.utils.b.a(r100);
            if (r101 == null) goto L6;
        L7:
            UserInfoTabPresenter.x(r101);
            return;
        L6:
            r101 = "";
            goto L7
        }

        public a(h r100) {
            this.f100145b = r100;
        }
    }

    @Override // e91.b
    public final void a() {
        UIUtils.setViewVisibility(this.f100144d.f100102g, 8);
        UIUtils.setViewVisibility(this.f100144d.f100107l, 8);
        UIUtils.setViewVisibility(this.f100144d.f100105j, 8);
    }

    @Override // e91.b
    public final ViewGroup getContainer() {
        return this.f100144d.f100106k;
    }

    @Override // e91.b
    public final void onShow() {
        IRoom r100 = this.f100144d.b();
        if (r100 != null) goto L5;
    L7:
        UserInfoTabPresenter.h(this.f100144d);
        ViewGroup r101 = this.f100144d.f100106k;
        if (r101 == null) goto L11;
        n81.b.f518243a.getClass();
        r101.setTag(R.id.ttlive_tag_user_info_tab_label_content_description_key, new a(this));
        return;
    L11:
        return;
    L5:
        if (r100.isVipRoom() != true) goto L7;
        UserInfoTabPresenter r102 = this.f100144d;
        r102.getClass();
        j0.l().sendLog("livesdk_livevip_exclusive_live_show", null, new Object[]{r102.f100114s, IRoom.class});
        goto L7
    }

    @Override // e91.b
    public final void onUnload() {
        UIUtils.setViewVisibility(this.f100144d.f100102g, this.f100141a);
        UIUtils.setViewVisibility(this.f100144d.f100107l, this.f100142b);
        UIUtils.setViewVisibility(this.f100144d.f100105j, this.f100143c);
    }

    public h(UserInfoTabPresenter r100) {
        this.f100144d = r100;
        View r101 = r100.f100102g;
        int r102 = 8;
        if (r101 == null) goto L5;
        int r103 = r101.getVisibility();
    L6:
        this.f100141a = r103;
        TextView r104 = r100.f100107l;
        if (r104 == null) goto L9;
        int r105 = r104.getVisibility();
    L10:
        this.f100142b = r105;
        TextView r106 = r100.f100105j;
        if (r106 == null) goto L13;
        r102 = r106.getVisibility();
    L13:
        this.f100143c = r102;
        return;
    L9:
        r105 = 8;
        goto L10
    L5:
        r103 = 8;
        goto L6
    }

    @Override // e91.b
    public final void b(Bitmap r100, ImageView r101, k r102) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, "certImg");
        Intrinsics.checkNotNullParameter(r102, "imageModel");
        if (r100.getHeight() == 0) goto L6;
        r101.setLayoutParams(new FrameLayout.LayoutParams(s1.f((int) ((((double) r100.getWidth()) * 10.0d) / ((double) r100.getHeight()))), s1.f(10)));
        return;
    }
}
