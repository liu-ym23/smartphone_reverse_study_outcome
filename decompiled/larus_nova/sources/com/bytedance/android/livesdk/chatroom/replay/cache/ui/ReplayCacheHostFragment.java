package com.bytedance.android.livesdk.chatroom.replay.cache.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.replay.cache.c;
import com.larus.nova.R;
import fm3.d;
import fq1.g;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zk1.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheHostFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "b", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayCacheHostFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f108155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f108156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HSImageView f108157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f108158g;

    public static final class a implements h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReplayCacheHostFragment f108159a;

        @Override // zk1.h.b
        public final void onError() {
        }

        @Override // zk1.h.b
        public final void onSuccess() {
        }

        @Override // zk1.h.b
        public final void a() {
            ReplayCacheHostFragment r100 = this.f108159a;
            View r101 = r100.f108156e;
            if (r101 == null) goto L5;
            r101.setVisibility(0);
        L5:
            RecyclerView r102 = r100.f108158g;
            if (r102 == null) goto L9;
            r102.setVisibility(8);
            return;
        }

        public a(ReplayCacheHostFragment r100) {
            this.f108159a = r100;
        }
    }

    public static final class b {
    }

    static {
    }

    public ReplayCacheHostFragment() {
        h r100 = new h(true);
        this.f108155d = r100;
        r100.f572591l = new a(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        HashMap r103 = new HashMap();
        r103.put("is_vs", "1");
        c.c("vs_my_download_item_click", r103);
        View r104 = r100.inflate(R.layout.ttlive_fragment_replay_cache_host, r101, false);
        this.f108156e = r104.findViewById(R.id.vs_cache_list_empty_view);
        this.f108157f = (HSImageView) r104.findViewById(R.id.replay_cache_empty_image);
        RecyclerView r105 = (RecyclerView) r104.findViewById(R.id.vs_cache_host_rv);
        this.f108158g = r105;
        if (r105 == null) goto L5;
        r105.setItemAnimator(null);
    L5:
        RecyclerView r106 = this.f108158g;
        if (r106 == null) goto L8;
        r106.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    L8:
        h r107 = this.f108155d;
        r107.f572583d = getContext();
        RecyclerView r108 = this.f108158g;
        if (r108 == null) goto L11;
        r108.setAdapter(new ReplayCacheAdapter(this.f108155d));
    L11:
        HashMap r109 = new HashMap();
        r109.put("is_vs", "1");
        c.c("vs_my_download_list_page_show", r109);
        g r110 = fq1.h.a();
        HSImageView r111 = this.f108157f;
        if (d.b() == false) goto L14;
        String r112 = "/replay/ttlive_bg_vs_cache_host_empty.png";
    L15:
        r110.f(r111, r112);
        return r104;
    L14:
        r112 = "/replay/ttlive_bg_vs_cache_host_empty_dark.png";
        goto L15
    }
}
