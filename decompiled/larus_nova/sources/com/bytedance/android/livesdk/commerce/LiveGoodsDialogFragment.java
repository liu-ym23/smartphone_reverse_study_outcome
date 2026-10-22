package com.bytedance.android.livesdk.commerce;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.network.NetworkStat;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolderType;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.android.livesdk.LiveDialogFragment;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.utils.V3Utils$TYPE;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated(message = "instead by com.bytedance.android.livesdk.livecommerce.broadcast.ui.LiveRoomPromotionListFragment")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/LiveGoodsDialogFragment;", "Lcom/bytedance/android/livesdk/LiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGoodsDialogFragment extends LiveDialogFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f119526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f119527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f119528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RecyclerView f119529g;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsDialogFragment f119530a;

        public b(LiveGoodsDialogFragment r100) {
            this.f119530a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f119530a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsDialogFragment f119531a;

        public c(LiveGoodsDialogFragment r100) {
            this.f119531a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Integer r101 = (Integer) r100;
            if (r101 != null) goto L5;
        L13:
            TextView r102 = this.f119531a.f119528f;
            if (r102 == null) goto L19;
            r102.setVisibility(8);
            return;
        L19:
            return;
        L5:
            if (r101.intValue() <= 0) goto L13;
            TextView r103 = this.f119531a.f119528f;
            if (r103 == null) goto L10;
            r103.setVisibility(0);
        L10:
            TextView r104 = this.f119531a.f119528f;
            if (r104 == null) goto L17;
            r104.setText(s1.C(R.string.ttlive_live_start_live_commodity_goods_count, new Object[]{r101}));
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f119532a;

        public d(Ref.ObjectRef r100) {
            this.f119532a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            NetworkStat r101 = (NetworkStat) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101 != NetworkStat.LOADING) goto L8;
            ((LoadingStatusView) this.f119532a.element).showLoading();
            return;
        L8:
            ((LoadingStatusView) this.f119532a.element).setVisibility(8);
        }
    }

    public static final class e extends SimpleViewHolderType<com.bytedance.android.livesdk.commerce.d, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsDialogFragment f119533a;

        @Override // com.bytedance.android.live.core.widget.simple.SimpleViewHolderType
        public final int getLayoutResId() {
            return R.layout.ttlive_item_live_goods;
        }

        public e(LiveGoodsDialogFragment r100) {
            this.f119533a = r100;
        }

        @Override // com.bytedance.android.live.core.widget.simple.ViewHolderType
        public final boolean match(Object r100) {
            return r100 instanceof com.bytedance.android.livesdk.commerce.d;
        }

        @Override // com.bytedance.android.live.core.widget.simple.SimpleViewHolderType
        public final void unBind(SimpleViewHolder r100, Object r101) {
            com.bytedance.android.livesdk.commerce.d r102 = (com.bytedance.android.livesdk.commerce.d) r101;
            Intrinsics.checkNotNullParameter(r100, "simpleViewHolder");
            Intrinsics.checkNotNullParameter(r102, "data");
            if ((System.currentTimeMillis() - r100.getLong(ILoadStallMonitor.START_TIME)) <= 100) goto L6;
            String r103 = V3Utils$TYPE.access$000(V3Utils$TYPE.SHOW);
            HashMap r104 = new HashMap();
            r104.put("event_type", r103);
            r104.put("event_belong", "");
            r104.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "");
            r104.put("room_id", String.valueOf(this.f119533a.f119527e));
            r104.put("anchor_id", String.valueOf(this.f119533a.f119526d));
            r104.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r102.e());
            ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).f().logV3("hotsoonlive_commodity_show", r104);
            return;
        }

        @Override // com.bytedance.android.live.core.widget.simple.SimpleViewHolderType
        public final void bind(SimpleViewHolder r100, Object r101, int r102) {
            com.bytedance.android.livesdk.commerce.d r103 = (com.bytedance.android.livesdk.commerce.d) r101;
            Intrinsics.checkNotNullParameter(r100, "simpleViewHolder");
            Intrinsics.checkNotNullParameter(r103, "data");
            r100.setText(R.id.title, r103.g());
            r100.setText(R.id.price_1, String.valueOf(r103.d() / 100));
            if (TextUtils.isEmpty(r103.c()) == true) goto L5;
            r100.setText(R.id.mark, r103.c());
        L6:
            int r104 = r103.d() % 100;
            StringBuilder r105 = new StringBuilder();
            if (r104 <= 10) goto L9;
            String r106 = ".";
        L10:
            r105.append(r106);
            r105.append(r104);
            r100.setText(R.id.price_2, r105.toString());
            r100.setText(R.id.sales, s1.C(R.string.ttlive_live_start_live_commodity_goods_sales, new Object[]{Integer.valueOf(r103.f())}));
            ImageUtil.loadImage((ImageView) r100.getView(R.id.cover), r103.a());
            r100.itemView.setOnClickListener(new com.bytedance.android.livesdk.commerce.f(this, r103));
            r100.put(ILoadStallMonitor.START_TIME, Long.valueOf(System.currentTimeMillis()));
            return;
        L9:
            r106 = ".0";
            goto L10
        L5:
            r100.hide(R.id.mark);
            goto L6
        }
    }

    public static final class f extends SimpleViewHolderType<com.bytedance.android.livesdk.commerce.e, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveGoodsViewModel f119534a;

        @Override // com.bytedance.android.live.core.widget.simple.SimpleViewHolderType
        public final int getLayoutResId() {
            return R.layout.ttlive_item_live_goods_banner;
        }

        public f(LiveGoodsViewModel r100) {
            this.f119534a = r100;
        }

        @Override // com.bytedance.android.live.core.widget.simple.ViewHolderType
        public final boolean match(Object r100) {
            return r100 instanceof com.bytedance.android.livesdk.commerce.e;
        }

        @Override // com.bytedance.android.live.core.widget.simple.SimpleViewHolderType
        public final void bind(SimpleViewHolder r100, Object r101, int r102) {
            com.bytedance.android.livesdk.commerce.e r103 = (com.bytedance.android.livesdk.commerce.e) r101;
            Intrinsics.checkNotNullParameter(r100, "simpleViewHolder");
            Intrinsics.checkNotNullParameter(r103, "data");
            r100.setText(R.id.text, r103.b());
            r100.setOnClickListener(R.id.delete, new g(this, r103));
        }
    }

    static {
    }

    public LiveGoodsDialogFragment() {
        setNoTitleAndCancelOutside(true);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L8;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L9;
        r102.setLayout(-1, -2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
        setCancelable(true);
        Bundle r101 = getArguments();
        if (r101 == null) goto L13;
        this.f119526d = r101.getLong("user_id");
        this.f119527e = r101.getLong("room_id");
        return;
    L13:
        dismiss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L15;
        com.bytedance.crash.d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        if (r101 == null) goto L7;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L7;
        r102.setGravity(80);
        r102.setLayout(-1, -2);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.setSoftInputMode(3);
        r102.clearFlags(2);
    L7:
        return r101;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.bytedance.android.live.uikit.recyclerview.LoadingStatusView] */
    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        r100.findViewById(R.id.close).setOnClickListener(new b(this));
        this.f119528f = (TextView) r100.findViewById(R.id.count);
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = (LoadingStatusView) r100.findViewById(R.id.status_view);
        RecyclerView r103 = (RecyclerView) r100.findViewById(R.id.list);
        this.f119529g = r103;
        if (r103 == null) goto L5;
        r103.setLayoutManager(new SSLinearLayoutManager(getActivity(), 1));
    L5:
        LiveGoodsViewModel r104 = (LiveGoodsViewModel) ViewModelProviders.of(this).get(LiveGoodsViewModel.class);
        r104.getTotalNum().observe(this, new c(this));
        r104.refreshStat().observe(this, new d(r102));
        r104.setUserId(this.f119526d).addViewHolderType(new e(this)).addViewHolderType(new f(r104)).bind(this.f119529g).load();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_dialog_goods_layout, r101, false);
    }
}
