package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.comment.ReplayCommentStatisticLog;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.PanelType;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.InputLinearLayout;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/SelectDanmuEmojiPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter;", "Lrl1/a;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/VSInputPanelLayout$a;", "Lqq1/a;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectDanmuEmojiPresenter extends DanmuPanelBasePresenter implements rl1.a, VSInputPanelLayout.a, qq1.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f109113m;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SelectDanmuEmojiPresenter f109114a;

        public a(SelectDanmuEmojiPresenter r100) {
            this.f109114a = r100;
        }

        public final void a() {
            int r100 = this.f109114a.j();
            SelectDanmuEmojiPresenter r101 = this.f109114a;
            if (r100 <= r101.f109096g) goto L35;
            DataCenter r102 = r101.f510285b;
            if (r102 == null) goto L7;
            r102.put("VSDanmuInputKeyboardHeight", Integer.valueOf(r100));
        L7:
            SelectDanmuEmojiPresenter r103 = this.f109114a;
            if (r103.f510285b == null) goto L36;
            VSInputPanelLayout r104 = r103.l().uJ();
            Context r105 = r103.l().getContext();
            DataCenter r106 = r103.f510285b;
            Intrinsics.checkNotNull(r106);
            DataCenter r107 = r103.f510285b;
            BehaviorSubject<String> r108 = null;
            if (r107 == null) goto L13;
            Boolean r109 = (Boolean) r107.get("VSScreenVertical");
        L14:
            boolean r110 = Intrinsics.areEqual(r109, Boolean.TRUE);
            DataCenter r111 = r103.f510285b;
            if (r111 == null) goto L18;
            Integer r112 = (Integer) r111.get("VSDanmuInputKeyboardHeight");
            if (r112 == null) goto L18;
        L19:
            int r113 = r112.intValue();
            DataCenter r114 = r103.f510285b;
            if (r114 == null) goto L23;
            Integer r115 = (Integer) r114.get("VSDanmuInputEmojiPanelType");
            if (r115 == null) goto L23;
        L24:
            int r116 = r115.intValue();
            nl1.a r117 = r103.f109100k;
            if (r117 == null) goto L27;
            r108 = r117.f519543e;
        L27:
            ql1.c r118 = new ql1.c(r105, r106, new ql1.d(r110, r113, r116, r108));
            r104.getClass();
            Intrinsics.checkNotNullParameter(r103, "panelContext");
            Intrinsics.checkNotNullParameter(r118, "panelProvider");
            PanelType r119 = r118.f533712a;
            if (r104.f109078d.get(r119) != null) goto L37;
            View r120 = r118.a(r103);
            if (r120 == null) goto L38;
            r104.f109078d.put(r119, r120);
            r104.addView(r120);
            r120.setVisibility(8);
            return;
        L38:
            return;
        L37:
            return;
        L23:
            r115 = 1;
        L18:
            r112 = 0;
            goto L19
        L13:
            r109 = null;
            goto L14
        L36:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // rl1.a
    public final void a() {
        DataCenter r100 = this.f510285b;
        if (r100 == null) goto L6;
        r100.put(ObservedKeys.EMOJI_DELETE, Boolean.TRUE);
        return;
    }

    @Override // rl1.a
    public final void b() {
        nl1.a r100 = this.f109100k;
        if (r100 == null) goto L8;
        BehaviorSubject<Boolean> r101 = r100.f519540b;
        if (r101 == null) goto L9;
        r101.onNext(Boolean.TRUE);
        return;
    L9:
        return;
    }

    @Override // rl1.a
    public final void dismissDialog() {
        nl1.a r100 = this.f109100k;
        if (r100 == null) goto L8;
        BehaviorSubject<Boolean> r101 = r100.f519539a;
        if (r101 == null) goto L9;
        r101.onNext(Boolean.TRUE);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final List<String> k() {
        return CollectionsKt.mutableListOf(new String[]{ObservedKeys.DANMU_INPUT});
    }

    public final void n() {
        DataCenter r100 = this.f510285b;
        if (r100 == null) goto L5;
        Boolean r101 = (Boolean) r100.get("VSCanSendEmojiDanmu");
    L7:
        if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L13;
        ImageView r102 = this.f109113m;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("ivDanmakuEmoji");
    L11:
        r102.setOnClickListener(com.bytedance.android.livesdk.chatroom.vs_base.base.view.d.a(new SelectDanmuEmojiPresenter$onEmojiInit$1(this)));
        return;
    L13:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // lq1.a
    public final void f() {
        super.f();
        VSInputPanelLayout r100 = l().uJ();
        r100.getClass();
        Intrinsics.checkNotNullParameter(this, "onPanelSwitchListener");
        r100.f109079e.remove(this);
        InputLinearLayout r101 = this.f109097h;
        if (r101 == null) goto L8;
        qq1.b r102 = r101.getKeyBoardObservable();
        if (r102 == null) goto L9;
        r102.b(this);
        return;
    L9:
        return;
    }

    public SelectDanmuEmojiPresenter() {
    }

    @Override // rl1.a
    public final void c(IBaseEmoji r100) {
        if (r100 == null) goto L12;
        int r101 = pl1.a.f529750a;
        DataCenter r102 = this.f510285b;
        Intrinsics.checkNotNullParameter(r100, "emoji");
        if (r100.isLatestUseEmoji() == false) goto L12;
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("vs_emoji_id", String.valueOf(r100.getIconId()));
        String r104 = r100.getDescription();
        if (r104 != null) goto L9;
        r104 = "";
    L9:
        r103.put("vs_emoji_name", r104);
        r103.put("vs_emoji_position", String.valueOf(r100.getPosition()));
        pl1.a.a(r103);
        Unit r105 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter("keyboard_recently_emoji_click", "eventName");
        Intrinsics.checkNotNullParameter(r103, "param");
        if (r102 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r102).e("keyboard_recently_emoji_click", r103, new Object[0]);
    L12:
        DataCenter r106 = this.f510285b;
        if (r106 == null) goto L16;
        r106.put(ObservedKeys.EMOJI_SELECT, r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void g(DanmuPanelBasePresenter.IView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.g(r100);
        ViewGroup r101 = this.f109093d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L5:
        this.f109113m = (ImageView) r101.findViewById(R.id.btn_danmaku_emoji);
        DataCenter r102 = this.f510285b;
        if (r102 == null) goto L8;
        Boolean r103 = (Boolean) r102.get("VSCanSendEmojiDanmu");
    L10:
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L15;
        ImageView r104 = this.f109113m;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("ivDanmakuEmoji");
    L14:
        UtilityKotlinExtentionsKt.w(r104);
    L19:
        VSInputPanelLayout r105 = l().uJ();
        r105.getClass();
        Intrinsics.checkNotNullParameter(this, "onPanelSwitchListener");
        r105.f109079e.add(this);
        InputLinearLayout r106 = this.f109097h;
        if (r106 == null) goto L25;
        qq1.b r107 = r106.getKeyBoardObservable();
        if (r107 == null) goto L26;
        r107.a(this);
        return;
    L26:
        return;
    L25:
        return;
    L15:
        ImageView r108 = this.f109113m;
        if (r108 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("ivDanmakuEmoji");
    L18:
        UtilityKotlinExtentionsKt.t(r108);
        goto L19
    L8:
        r103 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void m(KVData r100) {
        if (r100 == null) goto L10;
        String r101 = r100.getKey();
        if (r101.hashCode() == (-1891227055)) goto L7;
        return;
    L7:
        if (r101.equals(ObservedKeys.DANMU_INPUT) == false) goto L11;
        String r102 = (String) r100.getData();
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        m((KVData) r100);
    }

    @Override // qq1.a
    public final void X6(boolean r100, int r101) {
        if (r100 == false) goto L5;
        l().uJ().postDelayed(new a(this), 500);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout.a
    public final void d(PanelType r100, PanelType r101) {
        Intrinsics.checkNotNullParameter(r100, "previousPanelType");
        Intrinsics.checkNotNullParameter(r101, "currentPanelType");
        DataCenter r102 = this.f510285b;
        if (r102 == null) goto L5;
        Pair r103 = (Pair) r102.get("VSDanmuInputDialogEmojiInput");
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        if (r101 != PanelType.EMOJI) goto L17;
        LinkedHashMap r104 = new LinkedHashMap();
        pl1.a.a(r104);
        DataCenter r105 = this.f510285b;
        if (r105 != null) goto L12;
        int r106 = ReplayCommentStatisticLog.f108856a;
    L13:
        ImageView r107 = this.f109113m;
        if (r107 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("ivDanmakuEmoji");
    L16:
        r107.setImageResource(((Number) r103.getSecond()).intValue());
        return;
    L12:
        HashMap r108 = ReplayCommentStatisticLog.a(r105);
        r108.putAll(r104);
        com.bytedance.android.livesdk.chatroom.vs_base.log.d.a(r105).d("input_comment_emoji_panel_show", r108, new Object[0]);
        goto L13
    L17:
        ImageView r109 = this.f109113m;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("ivDanmakuEmoji");
    L20:
        r109.setImageResource(((Number) r103.getFirst()).intValue());
        return;
    L5:
        r103 = null;
        goto L6
    }
}
