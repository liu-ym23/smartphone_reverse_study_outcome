package com.bytedance.ai.view.input;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000½\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u0001Z\b\u0007\u0018\u0000 t2\u00020\u00012\u00020\u0002:\u0001tB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010W\u001a\u00020BH\u0002J\b\u0010X\u001a\u00020BH\u0002J\u0016\u0010\\\u001a\u00020]2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020B06H\u0003J\b\u0010c\u001a\u00020BH\u0003J$\u0010d\u001a\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020K0e2\u0006\u0010f\u001a\u00020'2\u0006\u0010g\u001a\u00020hH\u0002J\b\u0010i\u001a\u00020BH\u0002J\b\u0010j\u001a\u00020BH\u0002J\b\u0010k\u001a\u00020'H\u0016J\b\u0010l\u001a\u00020BH\u0016J\b\u0010m\u001a\u00020BH\u0016J\b\u0010n\u001a\u00020BH\u0016J\b\u0010o\u001a\u00020BH\u0016J\u0006\u0010p\u001a\u00020BJ\u0016\u0010q\u001a\u00020B2\u0006\u0010r\u001a\u00020/2\u0006\u0010s\u001a\u00020/R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0014\u001a\n \u000f*\u0004\u0018\u00010\u00150\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u000f*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001b\u0010\u001cR#\u0010\u001e\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0013\u001a\u0004\b\u001f\u0010\u0011R#\u0010!\u001a\n \u000f*\u0004\u0018\u00010\"0\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0013\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u000106X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R5\u0010>\u001a\u001d\u0012\u0013\u0012\u00110/¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020B0?X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR_\u0010G\u001aG\u0012\u0013\u0012\u00110I¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110K¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110K¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020-0HX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR&\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020T0S06X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00108\"\u0004\bV\u0010:R\u0010\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0004\n\u0002\u0010[R\u0010\u0010_\u001a\u00020]8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020]8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/bytedance/ai/view/input/ChatInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/floating/IChatInput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ability", "Lcom/bytedance/ai/view/input/Ability;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/view/input/Ability;)V", "getAbility", "()Lcom/bytedance/ai/view/input/Ability;", "config", "Lcom/bytedance/ai/api/model/ability/FloatingSpeakerConfig;", "_inputAreaContainer", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "get_inputAreaContainer", "()Landroid/view/ViewGroup;", "_inputAreaContainer$delegate", "Lkotlin/Lazy;", "_speakText", "Landroid/widget/TextView;", "get_speakText", "()Landroid/widget/TextView;", "_speakText$delegate", "_inputText", "Landroid/widget/EditText;", "get_inputText", "()Landroid/widget/EditText;", "_inputText$delegate", "_inputArea", "get_inputArea", "_inputArea$delegate", "_actionArea", "Landroid/widget/LinearLayout;", "get_actionArea", "()Landroid/widget/LinearLayout;", "_actionArea$delegate", "_actionInput", "Landroid/view/View;", "_actionSpeak", "_actionSend", "_chatStatusJob", "Lkotlinx/coroutines/Job;", "_speakOnInputFlag", "", "value", "", "placeHolder", "getPlaceHolder", "()Ljava/lang/String;", "setPlaceHolder", "(Ljava/lang/String;)V", "botId", "Lkotlin/Function0;", "getBotId", "()Lkotlin/jvm/functions/Function0;", "setBotId", "(Lkotlin/jvm/functions/Function0;)V", "cvsId", "getCvsId", "setCvsId", "onSend", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getOnSend", "()Lkotlin/jvm/functions/Function1;", "setOnSend", "(Lkotlin/jvm/functions/Function1;)V", "onSpeakEvent", "Lkotlin/Function3;", "", "action", "", "globalX", "globalY", "getOnSpeakEvent", "()Lkotlin/jvm/functions/Function3;", "setOnSpeakEvent", "(Lkotlin/jvm/functions/Function3;)V", "chatStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ai/view/input/FloatingChatStatus;", "getChatStatus", "setChatStatus", "setupStatusChangedEvent", "setupInputArea", "startSpeakRunnable", "com/bytedance/ai/view/input/ChatInput$startSpeakRunnable$1", "Lcom/bytedance/ai/view/input/ChatInput$startSpeakRunnable$1;", "onSpeakTouchHook", "Landroid/view/View$OnTouchListener;", SendEventContainerMethodParamModel.EventKinds.onClick, "onEditTextTouchListener", "speakerTouchListener", "lastPressTime", "", "setupSpeakArea", "getGlobalActionXY", "Lkotlin/Pair;", "view", "event", "Landroid/view/MotionEvent;", "setupActionArea", "setupInputContainer", "displayView", LiveCommonConstants.REASON_ON_DEDTROY, ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "performActionInputClick", "performActionSpeakClick", "requestInputFocus", "updateInputText", "text", "mode", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatInput extends ConstraintLayout {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f37680v = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ai.view.input.a f37681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f37682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f37683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f37684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f37685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f37686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f37687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f37688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f37689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f37690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f37691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f37692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<String> f37693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function0<String> f37694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function1<? super String, Unit> f37695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function3<? super Integer, ? super Float, ? super Float, Boolean> f37696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<? extends z0<FloatingChatStatus>> f37697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f37698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final j f37699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final q f37700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f37701u;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MotionEvent f37702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f37703b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ChatInput f37704c;

        @Override // java.lang.Runnable
        public final void run() {
            this.f37704c.f37700t.onTouch(this.f37703b, this.f37702a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(ChatInput r100) {
            this.f37704c = r100;
        }
    }

    static {
    }

    private final LinearLayout get_actionArea() {
        return (LinearLayout) this.f37686f.getValue();
    }

    private final ViewGroup get_inputArea() {
        return (ViewGroup) this.f37685e.getValue();
    }

    private final ViewGroup get_inputAreaContainer() {
        return (ViewGroup) this.f37682b.getValue();
    }

    private final EditText get_inputText() {
        return (EditText) this.f37684d.getValue();
    }

    private final TextView get_speakText() {
        return (TextView) this.f37683c.getValue();
    }

    public final void hideKeyboard() {
        get_inputText().clearFocus();
    }

    public final void i6() {
        get_inputText().requestFocus();
        EditText r100 = get_inputText();
        Intrinsics.checkNotNullParameter(this, "<this>");
        Intrinsics.checkNotNullParameter(r100, "view");
        Context r101 = getContext();
        InputMethodManager r102 = null;
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r101;
    L6:
        if (r103 == null) goto L18;
        Window r104 = r103.getWindow();
        if (r104 != null) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L12;
        new WindowInsetsControllerCompat(r104, r100).show(WindowInsetsCompat.Type.ime());
        return;
    L12:
        Object r105 = getContext().getSystemService("input_method");
        if ((r105 instanceof InputMethodManager) == false) goto L15;
        r102 = (InputMethodManager) r105;
    L15:
        if (r102 == null) goto L21;
        r102.showSoftInput(r100, 0);
        return;
    L21:
        return;
    L18:
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final com.bytedance.ai.view.input.a getAbility() {
        return this.f37681a;
    }

    public Function0<String> getBotId() {
        return this.f37693m;
    }

    public Function0<z0<FloatingChatStatus>> getChatStatus() {
        return this.f37697q;
    }

    public Function0<String> getCvsId() {
        return this.f37694n;
    }

    public Function1<String, Unit> getOnSend() {
        return this.f37695o;
    }

    public Function3<Integer, Float, Float, Boolean> getOnSpeakEvent() {
        return this.f37696p;
    }

    public String getPlaceHolder() {
        return this.f37692l;
    }

    public static void Y5(ChatInput r100) {
        Function1<String, Unit> r101 = r100.getOnSend();
        if (r101 == null) goto L5;
        r101.invoke(r100.get_inputText().getText().toString());
    L5:
        r100.get_inputText().setText("");
        r100.hideKeyboard();
        Function0<z0<FloatingChatStatus>> r102 = r100.getChatStatus();
        if (r102 == null) goto L11;
        z0<FloatingChatStatus> r103 = r102.invoke();
        if (r103 == null) goto L12;
        r103.tryEmit(FloatingChatStatus.READY_TO_INPUT);
        return;
    L12:
        return;
    }

    public static final /* synthetic */ EditText b6(ChatInput r100) {
        return r100.get_inputText();
    }

    public static final /* synthetic */ TextView c6(ChatInput r100) {
        return r100.get_speakText();
    }

    public void setBotId(Function0<String> r100) {
        this.f37693m = r100;
    }

    public void setChatStatus(Function0<? extends z0<FloatingChatStatus>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37697q = r100;
    }

    public void setCvsId(Function0<String> r100) {
        this.f37694n = r100;
    }

    public void setOnSend(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37695o = r100;
    }

    public void setOnSpeakEvent(Function3<? super Integer, ? super Float, ? super Float, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37696p = r100;
    }

    public void setPlaceHolder(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f37692l = r100;
        get_inputText().setHint(r100);
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.bytedance.ai.view.input.j] */
    public ChatInput(final Context r100, com.bytedance.ai.view.input.a r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "ability");
        super(r100);
        this.f37681a = r110;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r101 = AppletRuntimeManager.f36749d;
        if (r101 == null) goto L5;
        g2.a r102 = r101.h();
    L6:
        this.f37682b = LazyKt.lazy(new com.bytedance.ai.view.input.b(this));
        this.f37683c = LazyKt.lazy(new k(this));
        this.f37684d = LazyKt.lazy(new l(this));
        this.f37685e = LazyKt.lazy(new m(this));
        this.f37686f = LazyKt.lazy(new n(this));
        if (r102 == null) goto L13;
        Function1<Context, View> r103 = r102.f479640g;
        if (r103 == null) goto L13;
        View r104 = r103.invoke(r100);
        if (r104 == null) goto L13;
        r104.setVisibility(8);
    L14:
        this.f37687g = r104;
        if (r102 == null) goto L21;
        Function1<Context, View> r105 = r102.f479641h;
        if (r105 == null) goto L21;
        final View r106 = r105.invoke(r100);
        if (r106 == null) goto L21;
        r106.setVisibility(8);
    L22:
        this.f37688h = r106;
        if (r102 == null) goto L29;
        Function1<Context, View> r107 = r102.f479642i;
        if (r107 == null) goto L29;
        View r108 = r107.invoke(r100);
        if (r108 == null) goto L29;
        r108.setVisibility(8);
    L30:
        this.f37689i = r108;
        if (r102 == null) goto L36;
        Function0<String> r109 = r102.f479634a;
        if (r109 == null) goto L36;
        String r111 = r109.invoke();
        if (r111 == null) goto L36;
    L37:
        this.f37692l = r111;
        this.f37693m = r110.f37738a;
        this.f37694n = r110.f37739b;
        this.f37695o = new o(this);
        this.f37696p = r110.f37742e;
        this.f37697q = r110.f37741d;
        View.inflate(r100, R.layout.applet_floating_input_layout, this);
        ConstraintLayout.LayoutParams r112 = new ConstraintLayout.LayoutParams(0, -2);
        r112.bottomToBottom = 0;
        r112.leftToLeft = 0;
        r112.rightToRight = 0;
        setLayoutParams(r112);
        if (r102 == null) goto L42;
        Function1<ViewGroup, Unit> r113 = r102.f479636c;
        if (r113 == null) goto L42;
        r113.invoke(get_inputArea());
    L42:
        if (r102 == null) goto L46;
        Function1<ViewGroup, Unit> r114 = r102.f479635b;
        if (r114 == null) goto L46;
        r114.invoke(get_inputAreaContainer());
    L46:
        TextView r115 = get_speakText();
        if (r115 == null) goto L54;
        r115.setVisibility(8);
        if (r102 == null) goto L53;
        Function1<TextView, Unit> r116 = r102.f479638e;
        if (r116 == null) goto L53;
        r116.invoke(r115);
    L53:
        r115.setOnTouchListener(new r(this));
    L54:
        if (r104 == null) goto L56;
        r104.setVisibility(8);
        r104.setOnClickListener(new s(this));
        get_actionArea().addView(r104);
    L56:
        if (r106 == null) goto L58;
        r106.setVisibility(8);
        r106.setOnClickListener(new c(this));
        get_actionArea().addView(r106);
        final Function0 r117 = new d(r106);
        r106.setOnTouchListener(new j(this, r117));
    L58:
        if (r108 == null) goto L60;
        r108.setVisibility(8);
        r108.setOnClickListener(new e(this));
        get_actionArea().addView(r108);
    L60:
        final EditText r118 = get_inputText();
        r118.setHint(getPlaceHolder());
        Intrinsics.checkNotNull(r118);
        r118.addTextChangedListener(new t(this));
        if (r102 == null) goto L65;
        Function1<EditText, Unit> r119 = r102.f479639f;
        if (r119 == null) goto L65;
        r119.invoke(r118);
    L65:
        get_inputText().setOnFocusChangeListener(new g(r118, this));
        get_inputText().post(new h(r118, this));
        this.f37690j = BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(com.bytedance.ai.infra.thread_pool.b.f36604e), null, null, new ChatInput$setupStatusChangedEvent$1(this, null), 3, null);
        this.f37698r = new b(this);
        final Function0 r120 = new p(this, r100);
        this.f37699s = new j(this, r120);
        this.f37700t = new q(this);
        return;
    L36:
        r111 = "";
    L29:
        r108 = null;
    L21:
        r106 = null;
    L13:
        r104 = null;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public static void S5(EditText r100, ChatInput r101) {
        if (r100.hasFocus() == true) goto L6;
        r101.get_inputText().setOnTouchListener(r101.f37699s);
        return;
    }

    public static void U5(ChatInput r100, Context r101) {
        r100.requestFocus();
        InputMethodManager r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.getSystemService("input_method");
    L7:
        if ((r103 instanceof InputMethodManager) == false) goto L9;
        r102 = (InputMethodManager) r103;
    L9:
        if (r102 == null) goto L12;
        r102.showSoftInput(r100.get_inputText(), 0);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public static Unit Z5(final ChatInput r100, final Context r101) {
        r100.get_inputText().post(new f(r100, r101));
        return Unit.INSTANCE;
    }

    public static void T5(EditText r100, ChatInput r101, boolean r102) {
        InputMethodManager r103 = null;
        if (r102 == true) goto L14;
        Context r104 = r100.getContext();
        if (r104 == null) goto L7;
        Object r105 = r104.getSystemService("input_method");
    L9:
        if ((r105 instanceof InputMethodManager) == false) goto L11;
        r103 = (InputMethodManager) r105;
    L11:
        if (r103 == null) goto L13;
        r103.hideSoftInputFromWindow(r101.get_inputText().getWindowToken(), 0);
    L13:
        r101.get_inputText().setOnTouchListener(r101.f37699s);
        return;
    L7:
        r105 = null;
        goto L9
    L14:
        r101.get_inputText().setOnTouchListener(null);
    }

    public static void V5(String r100, ChatInput r101, String r102) {
        if (Intrinsics.areEqual(r100, "replace") == false) goto L5;
        r101.get_inputText().setText(r102);
    L6:
        Editable r103 = r101.get_inputText().getText();
        boolean r104 = false;
        if (r103 != null) goto L9;
    L14:
        if (r104 == false) goto L17;
        r101.get_inputText().setSelection(r101.get_inputText().getText().length());
        return;
    L17:
        return;
    L9:
        if (r103.length() <= 0) goto L11;
        boolean r105 = true;
    L12:
        if (r105 != true) goto L14;
        r104 = true;
        goto L14
    L11:
        r105 = false;
        goto L12
    L5:
        r101.get_inputText().append(r102);
        goto L6
    }

    public static void R5(ChatInput r100, Function0 r101, View r102, MotionEvent r103) {
        int r104 = r103.getActionMasked();
        if (r104 != 0) goto L5;
        b r105 = r100.f37698r;
        r105.f37703b = r102;
        r105.f37702a = MotionEvent.obtain(r103);
        r100.get_inputText().postDelayed(r100.f37698r, ViewConfiguration.getLongPressTimeout());
        return;
    L5:
        if (r104 == 1) goto L15;
        if (r104 == 2) goto L12;
        if (r104 == 3) goto L15;
        return;
    L12:
        if (r100.getChatStatus().invoke().getValue() != FloatingChatStatus.ON_SPEAK) goto L20;
        r100.f37700t.onTouch(r102, r103);
        return;
    L20:
        return;
    L15:
        if (r100.getChatStatus().invoke().getValue() != FloatingChatStatus.ON_SPEAK) goto L17;
        r100.f37700t.onTouch(r102, r103);
        return;
    L17:
        r100.get_inputText().removeCallbacks(r100.f37698r);
        r101.invoke();
    }
}
