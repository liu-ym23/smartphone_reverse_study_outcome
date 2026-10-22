package com.bytedance.android.livesdk.announcement.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes7.dex */
public final class AnchorDynamicCardView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f103597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f103598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f103599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f103600d;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.announcement.viewholder.AnchorDynamicCardView$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f103601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f103602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f103603c;

        public b() {
            this(0);
        }

        public /* synthetic */ b(int r100) {
            s1.h(R.color.ttlive_douyin_dark_TextPrimary);
            s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            s1.h(R.color.ttlive_douyin_dark_BGPrimary2);
            Drawable r101 = s1.m(R.drawable.ttlive_bg_announcement_card);
            s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            int r102 = s1.h(R.color.ttlive_douyin_dark_Link);
            s1.h(R.color.ttlive_douyin_dark_TextQuaternary2);
            int r103 = s1.h(R.color.ttlive_douyin_dark_TextSecondary);
            s1.h(R.color.ttlive_douyin_dark_TextTertiary);
            Drawable r104 = s1.m(R.drawable.ttlive_bg_announcement_auditing);
            s1.h(R.color.ttlive_douyin_dark_ConstTextInverse);
            Drawable r105 = s1.m(R.drawable.ttlive_bg_announcement_light_audit_failed);
            s1.h(R.color.ttlive_douyin_dark_Link);
            this(r101, r102, r103, r104, r105, s1.h(R.color.ttlive_douyin_dark_TextTertiary));
        }

        public b(Drawable r100, int r101, int r102, Drawable r103, Drawable r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "cardBgDrawable");
            Intrinsics.checkNotNullParameter(r103, "auditingBgDrawable");
            Intrinsics.checkNotNullParameter(r104, "auditFailedBgDrawable");
            this.f103601a = r101;
            this.f103602b = r102;
            this.f103603c = r105;
        }
    }

    static {
    }

    public final View a(int r100) {
        if (this.f103597a != null) goto L5;
        this.f103597a = new LinkedHashMap();
    L5:
        View r101 = this.f103597a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f103597a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public AnchorDynamicCardView(Context r100, boolean r101, String r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r102, "anchorId");
        Intrinsics.checkNotNullParameter(r103, "announcementSwitchChangeAction");
        super(r100);
        this.f103599c = r101;
        this.f103600d = r103;
        this.f103597a = new LinkedHashMap();
        Lazy r104 = LazyKt.lazy(new AnchorDynamicCardView$themeInfo$2(this));
        this.f103598b = r104;
        LayoutInflater.from(getContext()).inflate(R.layout.ttlive_view_anchor_announcement_dynamic, this);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        ((TextView) a(R.id.mTvAnnouncementCardAnchorContent)).setTextColor(((b) r104.getValue()).f103602b);
        ((TextView) a(R.id.mIvAnnouncementCardAnchorEdit)).setTextColor(((b) r104.getValue()).f103601a);
        ((TextView) a(R.id.mTvAnnouncementCardAnchorSubscribeNumber)).setTextColor(((b) r104.getValue()).f103603c);
    }
}
