package com.bytedance.ai.view.input;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00192\b\u00108\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u00109\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0019H\u0016J\b\u0010=\u001a\u00020\u0012H\u0016J3\u0010>\u001a\u00020\u00122)\u0010?\u001a%\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\rj\u0004\u0018\u0001`\u0013H\u0016J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020/H\u0016J\b\u0010B\u001a\u00020\u0012H\u0014J \u0010C\u001a\u00020\u00122\u0018\u0010D\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\"J\u0006\u0010E\u001a\u00020\u0012J\u0016\u0010F\u001a\u00020\u00122\u0006\u0010G\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0019J\b\u0010H\u001a\u00020\u0012H\u0002J\b\u0010I\u001a\u00020\u0012H\u0002J\u0010\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020\bH\u0002J\u0012\u0010L\u001a\u00020\u000e2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016R3\u0010\u000b\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rj\u0002`\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u000eX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020/01X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/bytedance/ai/view/input/FloatingSpeakerView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/floating/IFloatingSpeaker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "_speakStatusCallbackHolder", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onSpeak", "", "Lcom/bytedance/ai/floating/SpeakStatusCallback;", "_inputView", "Lcom/bytedance/ai/view/input/ChatInput;", "_speakerView", "Lcom/bytedance/ai/view/input/ChatSpeaker;", "_botId", "", "_conversationId", "_appendQuery", "_chatStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ai/view/input/FloatingChatStatus;", "_chatStatusJob", "Lkotlinx/coroutines/Job;", "redirectQuery", "Lkotlin/Function2;", "value", "marginBottom", "getMarginBottom", "()I", "setMarginBottom", "(I)V", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "_inputModeFlow", "Lcom/bytedance/ai/bridge/method/floatinginput/InputMode;", "inputModeFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getInputModeFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_ability", "Lcom/bytedance/ai/view/input/Ability;", "updateBotId", "botId", "conversationId", "setPlaceHolder", "placeHolder", "setAppendQuery", "appendQuery", "clearAppendQuery", "addSpeakStatusCallback", "callback", "changeInputMode", "mode", "onDetachedFromWindow", "setRedirectQuery", "redirect", "requestInputFocus", "updateInputText", "text", "onSpeakerCreate", "onSpeakerDestroy", "setMarginBottomLocked", GXTemplateKey.FLEXBOX_MARGIN, "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FloatingSpeakerView extends ConstraintLayout {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f37721n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Function1<Boolean, Unit>> f37722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ChatInput f37723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ChatSpeaker f37724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f37725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f37726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f37727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateFlowImpl f37728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f37729h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function2<? super String, ? super String, Boolean> f37730i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f37731j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f37732k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final StateFlowImpl f37733l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b1 f37734m;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37735a = null;

        static {
            int[] r100 = new int[InputMode.values().length];
            r100[InputMode.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[InputMode.ASR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f37735a = r100;
        }
    }

    public FloatingSpeakerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FloatingSpeakerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ChatInput r100 = this.f37723b;
        if (r100 == null) goto L7;
        Job r101 = r100.f37690j;
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        this.f37723b = null;
        this.f37724c = null;
        Job r102 = this.f37729h;
        if (r102 == null) goto L10;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L10:
        this.f37729h = null;
        this.f37728g.setValue(FloatingChatStatus.READY_TO_INPUT);
    }

    public boolean getEnable() {
        return this.f37732k;
    }

    public i1<InputMode> getInputModeFlow() {
        return this.f37734m;
    }

    public int getMarginBottom() {
        return this.f37731j;
    }

    private final void setMarginBottomLocked(int r100) {
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), r100);
    }

    public final void R5(InputMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        int r101 = a.f37735a[r100.ordinal()];
        if (r101 != 1) goto L5;
        ChatInput r102 = this.f37723b;
        if (r102 == null) goto L22;
        View r103 = r102.f37687g;
        if (r103 == null) goto L23;
        r103.performClick();
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r101 != 2) goto L12;
        ChatInput r104 = this.f37723b;
        if (r104 == null) goto L19;
        View r105 = r104.f37688h;
        if (r105 == null) goto L20;
        r105.performClick();
        return;
    L20:
        return;
    L19:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (getEnable() == true) goto L7;
        return true;
    L7:
        return super.dispatchTouchEvent(r100);
    }

    public void setAppendQuery(String r100) {
        Intrinsics.checkNotNullParameter(r100, "appendQuery");
        this.f37727f = r100;
    }

    public void setEnable(boolean r100) {
        this.f37732k = r100;
    }

    public void setMarginBottom(int r100) {
        this.f37731j = r100;
        setMarginBottomLocked(r100);
    }

    public void setPlaceHolder(String r100) {
        String r101 = null;
        if (r100 != null) goto L5;
    L11:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r102 = AppletRuntimeManager.f36749d;
        if (r102 == null) goto L18;
        g2.a r103 = r102.h();
        if (r103 == null) goto L18;
        Function0<String> r104 = r103.f479634a;
        if (r104 == null) goto L18;
        r101 = r104.invoke();
    L18:
        if (r101 == null) goto L23;
        ChatInput r105 = this.f37723b;
        if (r105 == null) goto L24;
        r105.setPlaceHolder(r101);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (com.bytedance.ai.utils.f.g(r100) == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        r101 = r100;
        goto L18
    }

    public final void setRedirectQuery(Function2<? super String, ? super String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "redirect");
        this.f37730i = r100;
    }

    public final void S5(final String r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "mode");
        final ChatInput r102 = this.f37723b;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "mode");
        p2.c.a().post(new i(r101, r102, r100));
        return;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.bytedance.ai.view.input.g0] */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.bytedance.ai.view.input.h0] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.bytedance.ai.view.input.z] */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.ai.view.input.a0] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.view.input.b0] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ai.view.input.c0] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.ai.view.input.d0] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.ai.view.input.e0] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedance.ai.view.input.f0] */
    public FloatingSpeakerView(Context r110, AttributeSet r111, int r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111, r112);
        this.f37722a = new LinkedHashSet();
        this.f37728g = j1.a(FloatingChatStatus.READY_TO_INPUT);
        this.f37732k = true;
        StateFlowImpl r100 = j1.a(InputMode.TEXT);
        this.f37733l = r100;
        this.f37734m = kotlinx.coroutines.flow.e.b(r100);
        com.bytedance.ai.view.input.a r101 = new com.bytedance.ai.view.input.a(new z(this), new a0(this), new b0(this), new c0(this), new d0(this), new e0(this), new f0(this), new g0(this), new h0(this));
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.enable}, r112, 0);
        setEnable(r113.getBoolean(0, true));     // Catch: Throwable -> L6
        r113.recycle();
        ChatInput r114 = new ChatInput(getContext(), r101);
        r114.setVisibility(8);
        addView(r114);
        this.f37723b = r114;
        ChatSpeaker r115 = new ChatSpeaker(getContext(), r101);
        r115.setVisibility(8);
        addView(r115);
        this.f37724c = r115;
        this.f37729h = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36604e), null, null, new FloatingSpeakerView$onSpeakerCreate$3(this, null), 3, null);
        return;
    L6:
        th = move-exception;
        r113.recycle();
        throw th;
    }

    public /* synthetic */ FloatingSpeakerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
