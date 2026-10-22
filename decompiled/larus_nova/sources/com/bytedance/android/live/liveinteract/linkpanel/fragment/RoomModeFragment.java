package com.bytedance.android.live.liveinteract.linkpanel.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "RoomMode", "RoomModeAdapter", "b", "RoomModeItemViewHolder", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RoomModeFragment extends BaseFragment {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f74577g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f74578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f74579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f74580f;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomMode;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "AUDIO_CHAT_ROOM", "RADIO", "KTV", "CHORUS", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum RoomMode extends Enum<RoomMode> {
        public static final RoomMode AUDIO_CHAT_ROOM = null;
        public static final RoomMode CHORUS = null;
        public static final RoomMode KTV = null;
        public static final RoomMode RADIO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RoomMode[] f74581a = null;
        private final String value;

        static {
            RoomMode r100 = new RoomMode("AUDIO_CHAT_ROOM", 0, "room");
            AUDIO_CHAT_ROOM = r100;
            RoomMode r101 = new RoomMode("RADIO", 1, "radio");
            RADIO = r101;
            RoomMode r102 = new RoomMode("KTV", 2, "ktv");
            KTV = r102;
            RoomMode r103 = new RoomMode("CHORUS", 3, "chorus");
            CHORUS = r103;
            f74581a = new RoomMode[]{r100, r101, r102, r103};
        }

        public static RoomMode valueOf(String r100) {
            return (RoomMode) r27.a.a(RoomMode.class, r100);
        }

        public static RoomMode[] values() {
            return (RoomMode[]) f74581a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public RoomMode(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomModeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomModeItemViewHolder;", "Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class RoomModeAdapter extends RecyclerView.Adapter<RoomModeItemViewHolder> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f74582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomModeFragment f74583b;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int getItemCount() {
            return this.f74582a.size();
        }

        public RoomModeAdapter(RoomModeFragment r100, List<b> r101) {
            Intrinsics.checkNotNullParameter(r101, "roomModeList");
            this.f74583b = r100;
            this.f74582a = r101;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
            RoomModeItemViewHolder r102 = (RoomModeItemViewHolder) r100;
            Intrinsics.checkNotNullParameter(r102, "holder");
            r102.f74584a = ((b) ListProtector.get(this.f74582a, r101)).f74594e;
            ImageView r103 = r102.f74586c;
            if (r103 == null) goto L5;
            r103.setImageResource(((b) ListProtector.get(this.f74582a, r101)).f74590a);
        L5:
            View r104 = r102.f74585b;
            if (r104 == null) goto L8;
            r104.setBackgroundResource(((b) ListProtector.get(this.f74582a, r101)).f74591b);
        L8:
            TextView r105 = r102.f74587d;
            if (r105 == null) goto L11;
            r105.setText(((b) ListProtector.get(this.f74582a, r101)).f74592c);
        L11:
            TextView r106 = r102.f74588e;
            if (r106 == null) goto L14;
            r106.setText(((b) ListProtector.get(this.f74582a, r101)).f74593d);
        L14:
            RoomModeFragment r107 = this.f74583b;
            int r108 = RoomModeFragment.f74577g;
            if (((RoomMode) r107.f74579e.getValue()) != r102.f74584a) goto L20;
            View r109 = r102.f74585b;
            if (r109 == null) goto L21;
            r109.setSelected(true);
            return;
        L21:
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "parent");
            View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.ttlive_item_room_mode, r100, false);
            return new RoomModeItemViewHolder(this.f74583b, r102);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/linkpanel/fragment/RoomModeFragment$RoomModeItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
    public final class RoomModeItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RoomMode f74584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f74585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f74586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f74587d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final TextView f74588e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RoomModeFragment f74589f;

        public RoomModeItemViewHolder(RoomModeFragment r100, View r101) {
            Intrinsics.checkNotNullParameter(r101, "itemView");
            this.f74589f = r100;
            super(r101);
            View r102 = r101.findViewById(R.id.room_container);
            this.f74585b = r102;
            this.f74586c = (ImageView) r101.findViewById(R.id.room_mode_icon);
            this.f74587d = (TextView) r101.findViewById(R.id.room_mode_label);
            this.f74588e = (TextView) r101.findViewById(R.id.room_mode_hint);
            if (r102 == null) goto L6;
            r102.setOnClickListener(new com.bytedance.android.livesdk.utils.w0(new AnonymousClass1(this), 500));
            return;
        }
    }

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f74590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f74591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f74592c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f74593d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final RoomMode f74594e;

        public b(int r100, int r101, int r102, int r103, RoomMode r104) {
            Intrinsics.checkNotNullParameter(r104, "mode");
            this.f74590a = r100;
            this.f74591b = r101;
            this.f74592c = r102;
            this.f74593d = r103;
            this.f74594e = r104;
        }
    }

    static {
    }

    public RoomModeFragment() {
        this.f74579e = LazyKt.lazy(new RoomModeFragment$currentRoomMode$2(this));
        this.f74580f = LazyKt.lazy(new RoomModeFragment$roomModeList$2(this));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        RecyclerView r102 = (RecyclerView) r100.findViewById(R.id.rv_room_mode);
        this.f74578d = r102;
        if (r102 == null) goto L5;
        r102.setAdapter(new RoomModeAdapter(this, (List) this.f74580f.getValue()));
    L5:
        RecyclerView r103 = this.f74578d;
        if (r103 == null) goto L8;
        r103.setLayoutManager(new GridLayoutManager(getContext(), 2));
    L8:
        RecyclerView r104 = this.f74578d;
        if (r104 == null) goto L12;
        r104.addItemDecoration(new AnonymousClass1());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_fragment_link_panel_room_mode, r101, false);
    }
}
