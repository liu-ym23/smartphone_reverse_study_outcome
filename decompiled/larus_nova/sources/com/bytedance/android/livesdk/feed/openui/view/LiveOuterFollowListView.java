package com.bytedance.android.livesdk.feed.openui.view;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.feed.constant.FeedType;
import com.bytedance.android.livesdkapi.feed.model.HorFollowListParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveOuterFollowListView implements ry.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f124249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f124250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Integer, Unit> f124251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HorizontalLiveListView f124252d;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOuterFollowListView f124253a;

        public a(LiveOuterFollowListView r100) {
            this.f124253a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 == null) goto L8;
            boolean r102 = r101.booleanValue();
            Function1<? super Boolean, Unit> r103 = this.f124253a.f124250b;
            if (r103 == null) goto L9;
            Unit r104 = r103.invoke(Boolean.valueOf(r102));
            return;
        L9:
            return;
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOuterFollowListView f124254a;

        public b(LiveOuterFollowListView r100) {
            this.f124254a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Boolean r101 = (Boolean) r100;
            if (r101 == null) goto L8;
            boolean r102 = r101.booleanValue();
            Function1<? super Boolean, Unit> r103 = this.f124254a.f124249a;
            if (r103 == null) goto L9;
            Unit r104 = r103.invoke(Boolean.valueOf(r102));
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveOuterFollowListView f124255a;

        public c(LiveOuterFollowListView r100) {
            this.f124255a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 == null) goto L8;
            int r102 = r101.intValue();
            Function1<? super Integer, Unit> r103 = this.f124255a.f124251c;
            if (r103 == null) goto L9;
            Unit r104 = r103.invoke(Integer.valueOf(r102));
            return;
        L9:
            return;
        }
    }

    public final void a(final sy.a<Boolean> r100) {
        this.f124250b = new LiveOuterFollowListView$setEmptyListener$1(r100);
    }

    public final void b(final sy.a<Boolean> r100) {
        this.f124249a = new LiveOuterFollowListView$setErrorListener$1(r100);
    }

    public final void c(final sy.a<Integer> r100) {
        this.f124251c = new LiveOuterFollowListView$setRoomCountListener$1(r100);
    }

    public LiveOuterFollowListView(Context r100, Bundle r101, ry.f r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101 != null) goto L5;
        r101 = new Bundle();
    L6:
        String r103 = r101.getString("enter_from_merge", "homepage_follow");
        String r104 = r101.getString("feed_type");
        if (r104 == null) goto L20;
        int r105 = r104.hashCode();
        if (r105 == (-1925189774)) goto L18;
        if (r105 != (-290803120)) goto L20;
        if (r104.equals("hot_feed") == false) goto L20;
        FeedType r106 = FeedType.HOT_FEED;
    L21:
        int r107 = r101.getInt("background_color", -1);
        HorFollowListParams.Builder r108 = new HorFollowListParams.Builder(r103).feedType(r106).backgroundColor(r107);
        if (r101.containsKey("live_tag_color") == false) goto L25;
        r108.liveTagColor(r101.getInt("live_tag_color"));
    L25:
        if (r101.containsKey("live_tag_radius") == false) goto L27;
        r108.liveTagRadius(r101.getInt("live_tag_radius"));
    L27:
        if (r102 == null) goto L29;
        r108.avatarBorderAnimController(r102);
    L29:
        HorizontalLiveListView r109 = new HorizontalLiveListView(r108.build(), r100, null, 0);
        this.f124252d = r109;
        MutableLiveData<Boolean> r110 = r109.f124230j;
        if (r110 == null) goto L32;
        r110.observe(r109, new a(this));
    L32:
        MutableLiveData<Boolean> r111 = r109.f124228h;
        if (r111 == null) goto L35;
        r111.observe(r109, new b(this));
    L35:
        MutableLiveData<Integer> r112 = r109.f124232l;
        if (r112 == null) goto L39;
        r112.observe(r109, new c(this));
        return;
    L39:
        return;
    L18:
        if (r104.equals("common_feed") == false) goto L20;
        r106 = FeedType.COMMON_FEED;
    L20:
        r106 = FeedType.FOLLOW_FEED;
        goto L21
    L5:
        Intrinsics.checkNotNull(r101);
        goto L6
    }
}
