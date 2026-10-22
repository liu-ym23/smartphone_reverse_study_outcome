package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.utils.r3;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
public final class RewardItemViewBinder extends me.drakeet.multitype.b<m0, RewardItemViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f61257b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.opengame.view.RewardItemViewBinder$1, reason: invalid class name */
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

    public RewardItemViewBinder(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f61257b = r100;
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, m0 r101) {
        RewardItemViewHolder r102 = (RewardItemViewHolder) r100;
        m0 r103 = r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "info");
        r102.f61258a.setText(s1.C(R.string.ttlive_game_reward_message, new Object[]{r103.f60257g, Integer.valueOf(r103.f60256f), r3.c(), Integer.valueOf(r103.f60255e)}));
        TextView r104 = r102.f61259b;
        String r105 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(r103.f60251a));     // Catch: Exception -> L8
        if (r105 == null) goto L7;
        String r106 = r105.substring(11, 16);     // Catch: Exception -> L8
    L9:
        r104.setText(r106);
        r102.itemView.setOnClickListener(new x(r102, r103));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L8
    L8:
        r106 = "";
        goto L9
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new RewardItemViewHolder(LayoutInflater.from(r101.getContext()).inflate(R.layout.ttlive_open_platform_audience_reward_msg_list_item, r101, false), this.f61257b);
    }
}
