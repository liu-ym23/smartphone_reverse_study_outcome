package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/InputTextLengthPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputTextLengthPresenter extends DanmuPanelBasePresenter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f109110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f109111n;

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final List<String> k() {
        return CollectionsKt.mutableListOf(new String[]{ObservedKeys.VS_DANMU_INPUT_LENGTH});
    }

    public InputTextLengthPresenter() {
        this.f109111n = 50;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void g(DanmuPanelBasePresenter.IView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.g(r100);
        ViewGroup r101 = this.f109093d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L5:
        this.f109110m = (TextView) r101.findViewById(R.id.ttlive_vs_danmu_overinput_length);
        DataCenter r102 = this.f510285b;
        if (r102 == null) goto L10;
        Integer r103 = (Integer) r102.get("VSDanmuInputMaxInputLength");
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
    L11:
        this.f109111n = r104;
        return;
    L10:
        r104 = 50;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void m(KVData r100) {
        if (r100 == null) goto L26;
        String r101 = r100.getKey();
        if (r101.hashCode() == 840681844) goto L7;
        return;
    L7:
        if (r101.equals(ObservedKeys.VS_DANMU_INPUT_LENGTH) == false) goto L27;
        Integer r102 = (Integer) r100.getData();
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
    L13:
        if (r103 > this.f109111n) goto L18;
        TextView r104 = this.f109110m;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("textLengthIndicator");
    L17:
        UtilityKotlinExtentionsKt.h(r104);
        return;
    L18:
        TextView r105 = this.f109110m;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("textLengthIndicator");
    L21:
        r105.setText(String.valueOf(this.f109111n - r103));
        TextView r106 = this.f109110m;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("textLengthIndicator");
    L24:
        UtilityKotlinExtentionsKt.j(r106);
        return;
    L11:
        r103 = 50;
        goto L13
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        m((KVData) r100);
    }
}
