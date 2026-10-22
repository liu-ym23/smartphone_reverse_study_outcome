package com.bytedance.android.livesdk.chatroom.replay.cache.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment;
import com.bytedance.crash.d;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zk1.l;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/cache/ui/ReplayCacheDialog;", "Lcom/bytedance/android/livesdk/chatroom/vs_base/view/ReplayAdaptiveDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReplayCacheDialog extends ReplayAdaptiveDialogFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f108149k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Context f108150f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DataCenter f108151g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f108152h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f108153i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f108154j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment
    public final String S90() {
        return "ReplayCacheDialog[" + hashCode() + ']';
    }

    public ReplayCacheDialog() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.view.ReplayAdaptiveDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = this.f108150f;
        if (r102 != null) goto L5;
    L14:
        dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L17;
        d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L17:
        return;
    L5:
        if ((r102 instanceof FragmentActivity) == false) goto L14;
        ReplayListCacheWidget r104 = new ReplayListCacheWidget(new l(this), this.f118223e, this.f108152h);
        WidgetManager r105 = WidgetManager.of(this, getView());
        r105.setDataCenter(this.f108151g);
        r105.load(R.id.vs_cache_container, r104);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_replay_dialog_cache, r101, false);
        this.f108153i = r103;
        if (r103 == null) goto L5;
        View r104 = r103.findViewById(R.id.vs_cache_container);
    L6:
        this.f108154j = r104;
        return this.f108153i;
    L5:
        r104 = null;
        goto L6
    }
}
