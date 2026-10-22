package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.ReplayMessageTracer;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.PanelType;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.view.StablePrefixGradientEditText;
import com.bytedance.android.livesdk.chatroom.vs_base.base.setting.ReplayConfigSettingKeys;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.utils.t2;
import com.bytedance.android.livesdk.utils.u3;
import com.bytedance.android.livesdkapi.depend.model.live.emoji.IBaseEmoji;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.larus.nova.R;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mq1.o;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/InputDanmuTextPresenter;", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/presenter/DanmuPanelBasePresenter;", "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputDanmuTextPresenter extends DanmuPanelBasePresenter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public StablePrefixGradientEditText f109102m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f109103n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f109104o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f109105p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f109106q;

    public static final class a implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputDanmuTextPresenter f109107a;

        public a(InputDanmuTextPresenter r100) {
            this.f109107a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 != 4) goto L19;
            Editable r103 = InputDanmuTextPresenter.n(this.f109107a).getText();
            if (r103 != null) goto L7;
        L10:
            boolean r104 = true;
        L11:
            if (r104 == false) goto L13;
            return false;
        L13:
            nl1.a r105 = this.f109107a.f109100k;
            if (r105 == null) goto L18;
            BehaviorSubject<Boolean> r106 = r105.f519540b;
            if (r106 == null) goto L18;
            r106.onNext(Boolean.TRUE);
        L18:
            return true;
        L7:
            if (StringsKt.isBlank(r103) == true) goto L10;
            r104 = false;
            goto L11
        L19:
            return false;
        }
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputDanmuTextPresenter f109108a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(InputDanmuTextPresenter r100) {
            this.f109108a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (r100 == null) goto L5;
            String r101 = r100.toString();
            if (r101 == null) goto L5;
        L6:
            String r102 = r101;
            int r103 = TextUtils.getTrimmedLength(r102);
            u3.a r104 = u3.a(r100, this.f109108a.f109103n.intValue());
            if (r104 == null) goto L9;
            r103 = r104.f159178b;
        L9:
            this.f109108a.getClass();
            DataCenter r105 = this.f109108a.f510285b;
            if (r105 == null) goto L12;
            r105.put(ObservedKeys.VS_DANMU_INPUT_LENGTH, Integer.valueOf(r103));
        L12:
            InputDanmuTextPresenter r106 = this.f109108a;
            DataCenter r107 = r106.f510285b;
            if (r107 == null) goto L16;
            r107.put(ObservedKeys.DANMU_INPUT, StringsKt.replaceFirst$default(r102, InputDanmuTextPresenter.n(r106).getPrefixStr(), "", false, 4, null));
            return;
        L16:
            return;
        L5:
            r101 = "";
            goto L6
        }
    }

    public static final class c implements VSInputPanelLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputDanmuTextPresenter f109109a;

        public c(InputDanmuTextPresenter r100) {
            this.f109109a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.VSInputPanelLayout.a
        public final void d(PanelType r100, PanelType r101) {
            Intrinsics.checkNotNullParameter(r100, "previousPanelType");
            Intrinsics.checkNotNullParameter(r101, "currentPanelType");
            ReplayMessageTracer.b("switch danmaku input panel: " + r100 + " to " + r101);
            int r102 = com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.b.f109130a[r101.ordinal()];
            if (r102 != 1) goto L5;
            t2.a(this.f109109a.getContext(), InputDanmuTextPresenter.n(this.f109109a));
            nl1.a r103 = this.f109109a.f109100k;
            if (r103 == null) goto L17;
            BehaviorSubject<Boolean> r104 = r103.f519539a;
            if (r104 == null) goto L17;
            r104.onNext(Boolean.TRUE);
        L17:
            o r105 = s.d();
            if (r105 == null) goto L25;
            r105.onInputStateChange(false);
            return;
        L25:
            return;
        L5:
            if (r102 == 2) goto L9;
            o r106 = s.d();
            if (r106 == null) goto L21;
            r106.onInputStateChange(true);
            return;
        L21:
            return;
        L9:
            o r107 = s.d();
            if (r107 == null) goto L23;
            r107.onInputStateChange(true);
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final List<String> k() {
        return CollectionsKt.mutableListOf(new String[]{ObservedKeys.EMOJI_SELECT, ObservedKeys.EMOJI_DELETE});
    }

    public InputDanmuTextPresenter() {
        s1.h(R.color.ttlive_vs_danmaku_input_color);
        this.f109103n = ReplayConfigSettingKeys.REPLAY_COMMENT_WORDS_COUNT_LIMIT.getValue();
        this.f109104o = new b(this);
        this.f109105p = new c(this);
        this.f109106q = new a(this);
    }

    public static final /* synthetic */ StablePrefixGradientEditText n(InputDanmuTextPresenter r100) {
        StablePrefixGradientEditText r101 = r100.f109102m;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void g(DanmuPanelBasePresenter.IView r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        super.g(r100);
        DataCenter r101 = this.f510285b;
        if (r101 == null) goto L5;
        Integer r102 = (Integer) r101.get("VSDanmuInputMaxInputLength");
    L6:
        this.f109103n = r102;
        DataCenter r103 = this.f510285b;
        if (r103 == null) goto L11;
        Integer r104 = (Integer) r103.get("VSDanmuInputTextColor");
        if (r104 == null) goto L11;
        r104.intValue();
    L11:
        ViewGroup r105 = this.f109093d;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L14:
        this.f109102m = (StablePrefixGradientEditText) r105.findViewById(R.id.danmu_editor);
        Rect r106 = new Rect();
        r106.top -= (int) UIUtils.dip2Px(getContext(), 10.0f);
        r106.bottom -= (int) UIUtils.dip2Px(getContext(), 10.0f);
        StablePrefixGradientEditText r107 = this.f109102m;
        if (r107 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L17:
        StablePrefixGradientEditText r108 = this.f109102m;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L20:
        r107.setTouchDelegate(new TouchDelegate(r106, r108));
        StablePrefixGradientEditText r109 = this.f109102m;
        if (r109 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L23:
        r109.setTextEmojiSize(this.f109101l);
        StablePrefixGradientEditText r110 = this.f109102m;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L26:
        r110.addTextChangedListener(this.f109104o);
        DataCenter r111 = this.f510285b;
        if (r111 == null) goto L44;
        String r112 = (String) r111.get("VSInputInitText");
        if (r112 == null) goto L44;
        StablePrefixGradientEditText r113 = this.f109102m;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L33:
        r113.setText(r112);
        StablePrefixGradientEditText r114 = this.f109102m;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L36:
        StablePrefixGradientEditText r115 = this.f109102m;
        if (r115 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L39:
        Editable r116 = r115.getText();
        if (r116 == null) goto L42;
        int r117 = r116.length();
    L43:
        r114.setSelection(r117);
        goto L44
    L42:
        r117 = 0;
    L44:
        DataCenter r118 = this.f510285b;
        if (r118 == null) goto L52;
        String r119 = (String) r118.get("VSDanmuInputPanelHintText");
        if (r119 == null) goto L52;
        StablePrefixGradientEditText r120 = this.f109102m;
        if (r120 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L51:
        r120.setHint(r119);
    L52:
        StablePrefixGradientEditText r121 = this.f109102m;
        if (r121 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L55:
        r121.setOnEditorActionListener(this.f109106q);
        nl1.a r122 = this.f109100k;
        if (r122 == null) goto L62;
        BehaviorSubject<Boolean> r123 = r122.f519539a;
        if (r123 == null) goto L62;
        ObservableSubscribeProxy r124 = (ObservableSubscribeProxy) r123.as(AutoDispose.bind(this.f510284a));
        if (r124 == null) goto L62;
        r124.subscribe(new com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.c(this));
    L62:
        nl1.a r125 = this.f109100k;
        if (r125 == null) goto L69;
        BehaviorSubject<PanelType> r126 = r125.f519541c;
        if (r126 == null) goto L69;
        ObservableSubscribeProxy r127 = (ObservableSubscribeProxy) r126.as(AutoDispose.bind(this.f510284a));
        if (r127 == null) goto L69;
        r127.subscribe(new d(this));
    L69:
        nl1.a r128 = this.f109100k;
        if (r128 == null) goto L76;
        BehaviorSubject<Boolean> r129 = r128.f519542d;
        if (r129 == null) goto L76;
        ObservableSubscribeProxy r130 = (ObservableSubscribeProxy) r129.as(AutoDispose.bind(this.f510284a));
        if (r130 == null) goto L76;
        r130.subscribe(new e(this));
    L76:
        VSInputPanelLayout r131 = h();
        c r132 = this.f109105p;
        r131.getClass();
        Intrinsics.checkNotNullParameter(r132, "onPanelSwitchListener");
        r131.f109079e.add(r132);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter
    public final void m(KVData r100) {
        if (r100 == null) goto L31;
        String r101 = r100.getKey();
        int r102 = r101.hashCode();
        if (r102 == 983704977) goto L25;
        if (r102 == 1413141730) goto L9;
        return;
    L9:
        if (r101.equals(ObservedKeys.EMOJI_SELECT) == false) goto L32;
        IBaseEmoji r103 = (IBaseEmoji) r100.getData();
        if (r103 != null) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r103.getDescription()) == true) goto L38;
        StablePrefixGradientEditText r104 = this.f109102m;
        if (r104 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L18:
        int r105 = r104.getSelectionStart();
        StablePrefixGradientEditText r106 = this.f109102m;
        if (r106 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L21:
        Editable r107 = r106.getText();
        if (r107 == null) goto L34;
        r107.insert(r105, r.e().c(r103.getDescription(), this.f109101l));
        return;
    L34:
        return;
    L38:
        return;
    L32:
        return;
    L25:
        if (r101.equals(ObservedKeys.EMOJI_DELETE) == false) goto L36;
        KeyEvent r108 = new KeyEvent(0, 67);
        StablePrefixGradientEditText r109 = this.f109102m;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("etSingleLineInput");
    L29:
        r109.dispatchKeyEvent(r108);
        return;
    L36:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter.DanmuPanelBasePresenter, androidx.lifecycle.Observer
    public final /* bridge */ /* synthetic */ void onChanged(Object r100) {
        m((KVData) r100);
    }
}
