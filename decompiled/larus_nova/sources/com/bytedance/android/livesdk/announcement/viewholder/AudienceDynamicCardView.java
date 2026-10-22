package com.bytedance.android.livesdk.announcement.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class AudienceDynamicCardView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f103619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f103620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f103621c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f103622a;

        public b() {
            this(0);
        }

        public /* synthetic */ b(int r100) {
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
            s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            s1.h(R.color.ttlive_douyin_dark_BGPrimary2);
            s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            s1.h(R.color.ttlive_douyin_dark_TextQuaternary2);
            int r101 = s1.h(R.color.ttlive_douyin_dark_TextSecondary);
            Drawable r102 = s1.m(R.drawable.ttlive_bg_light_announcement_subscribed);
            Drawable r103 = s1.m(R.drawable.ttlive_bg_dark_announcement_unsubscribed);
            Drawable r104 = s1.m(R.drawable.ttlive_ic_announcement_unlike);
            Drawable r105 = s1.m(R.drawable.ttlive_ic_announcement_like);
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
            this(r101, r102, r103, r104, r105);
        }

        public b(int r100, Drawable r101, Drawable r102, Drawable r103, Drawable r104) {
            Intrinsics.checkNotNullParameter(r101, "subscribeBgDrawable");
            Intrinsics.checkNotNullParameter(r102, "unsubscribeBgDrawable");
            Intrinsics.checkNotNullParameter(r103, "subscribeIconDrawable");
            Intrinsics.checkNotNullParameter(r104, "unsubscribeIconDrawable");
            this.f103622a = r100;
        }
    }

    static {
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public AudienceDynamicCardView(Context r100, boolean r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r102, "secUid");
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        Intrinsics.checkNotNullParameter(r104, "anchorId");
        super(r100);
        this.f103621c = r101;
        this.f103619a = new LinkedHashMap();
        Lazy r105 = LazyKt.lazy(new AudienceDynamicCardView$themeInfo$2(this));
        this.f103620b = r105;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_audience_announcement_dynamic, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        if (this.f103619a != null) goto L5;
        this.f103619a = new LinkedHashMap();
    L5:
        View r106 = this.f103619a.get(Integer.valueOf(R.id.mTvAnnouncementCardContent));
        if (r106 != null) goto L11;
        r106 = findViewById(R.id.mTvAnnouncementCardContent);
        if (r106 == null) goto L10;
        this.f103619a.put(Integer.valueOf(R.id.mTvAnnouncementCardContent), r106);
        goto L11
    L10:
        r106 = null;
    L11:
        ((TextView) r106).setTextColor(((b) r105.getValue()).f103622a);
    }
}
