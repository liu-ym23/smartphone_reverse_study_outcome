package com.bytedance.android.livesdk.interactivity.chatchannel.v2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.interactivity.chatchannel.widget.adapter.ChannelLinkSeatUserItemDecoration;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import ec2.e1;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;
import r62.b;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R0\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/v2/view/ChannelTrayListViewV2;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lkotlin/Function1;", "Lp62/a;", "", "c", "Lkotlin/jvm/functions/Function1;", "getTrayClickCallback", "()Lkotlin/jvm/functions/Function1;", "setTrayClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "trayClickCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelTrayListViewV2 extends ConstraintLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f134411e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f134412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultiTypeAdapter f134413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super p62.a, Unit> f134414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f134415d;

    public ChannelTrayListViewV2(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelTrayListViewV2(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b r100 = this.f134415d;
        if (r100 == null) goto L6;
        MainThreadPostUtils.d(r100);
        return;
    }

    public final Function1<p62.a, Unit> getTrayClickCallback() {
        return this.f134414c;
    }

    public final void setTrayClickCallback(Function1<? super p62.a, Unit> r100) {
        this.f134414c = r100;
    }

    public ChannelTrayListViewV2(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        ViewGroup.inflate(r100, R.layout.ttlive_chat_channel_seat_list_view_v2, this);
        RecyclerView r103 = (RecyclerView) findViewById(R.id.all_channel_rv);
        this.f134412a = r103;
        MultiTypeAdapter r104 = new MultiTypeAdapter();
        this.f134413b = r104;
        r104.z2(p62.a.class, new ChannelTrayListViewBinder(new r62.a(this)));
        SSLinearLayoutManager r105 = new SSLinearLayoutManager(getContext(), 0);
        r103.setAdapter(r104);
        r103.setLayoutManager(r105);
        r103.addItemDecoration(new ChannelLinkSeatUserItemDecoration(UtilityKotlinExtentionsKt.i(8)));
        r104.notifyDataSetChanged();
        if (e1.f472014a.getValue().booleanValue() == true) goto L5;
        r103.setHorizontalFadingEdgeEnabled(false);
        r103.setVerticalFadingEdgeEnabled(false);
    L5:
        r103.addOnScrollListener(new ChannelTrayListViewV2$initRecyclerView$2(this));
    }

    public /* synthetic */ ChannelTrayListViewV2(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
