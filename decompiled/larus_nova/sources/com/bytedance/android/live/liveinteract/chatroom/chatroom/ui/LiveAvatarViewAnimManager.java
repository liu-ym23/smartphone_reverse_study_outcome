package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class LiveAvatarViewAnimManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f72401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f72402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f72403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f72404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f72405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f72406f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LiveAvatarCircleView f72407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f72408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f72409c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f72407a, r101.f72407a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f72408b, r101.f72408b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f72409c, r101.f72409c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            LiveAvatarCircleView r100 = this.f72407a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            View r104 = this.f72408b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            View r107 = this.f72409c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "LiveAnimViews(circleView=" + this.f72407a + ", tagView=" + this.f72408b + ", avatarView=" + this.f72409c + ")";
        }

        public a(LiveAvatarCircleView r100, View r101, View r102) {
            this.f72407a = r100;
            this.f72408b = r101;
            this.f72409c = r102;
        }
    }

    public LiveAvatarViewAnimManager() {
        this.f72401a = new ArrayList();
        this.f72402b = 1100;
        this.f72403c = 640;
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        this.f72404d = LazyKt.lazy(r100, new LiveAvatarViewAnimManager$animatorSet$2(this));
        this.f72405e = LazyKt.lazy(r100, new LiveAvatarViewAnimManager$valueAnimator$2(this));
        this.f72406f = LazyKt.lazy(r100, new LiveAvatarViewAnimManager$animator$2(this));
    }
}
