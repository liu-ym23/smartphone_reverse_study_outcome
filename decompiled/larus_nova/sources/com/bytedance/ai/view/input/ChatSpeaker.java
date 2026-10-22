package com.bytedance.ai.view.input;

import android.content.Context;
import android.graphics.Rect;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u00105\u001a\u000206H\u0016J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,H\u0002J\u0018\u0010=\u001a\u00020\u00192\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,H\u0002J\u0018\u0010>\u001a\u00020\u00132\u0006\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020,H\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R=\u0010\u0014\u001a%\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015j\u0004\u0018\u0001`\u001aX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R2\u0010)\u001a\u001a\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00130*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R \u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020 X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010#R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u00130 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ai/view/input/ChatSpeaker;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/ai/floating/IChatSpeaker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "ability", "Lcom/bytedance/ai/view/input/Ability;", "<init>", "(Landroid/content/Context;Lcom/bytedance/ai/view/input/Ability;)V", "getAbility", "()Lcom/bytedance/ai/view/input/Ability;", "config", "Lcom/bytedance/ai/api/model/ability/FloatingSpeakerConfig;", "_tips", "Lcom/bytedance/ai/floating/ChatSpeakTipsAbility;", "_visualizer", "Lcom/bytedance/ai/floating/ChatSpeakVisualizerAbility;", "_cancelStatus", "Lkotlin/Pair;", "", "onSpeakStatusChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSpeak", "", "Lcom/bytedance/ai/floating/SpeakStatusCallback;", "getOnSpeakStatusChanged", "()Lkotlin/jvm/functions/Function1;", "setOnSpeakStatusChanged", "(Lkotlin/jvm/functions/Function1;)V", "botId", "Lkotlin/Function0;", "", "getBotId", "()Lkotlin/jvm/functions/Function0;", "setBotId", "(Lkotlin/jvm/functions/Function0;)V", "cvsId", "getCvsId", "setCvsId", "onSpeakEvent", "Lkotlin/Function3;", "", "", "getOnSpeakEvent", "()Lkotlin/jvm/functions/Function3;", "setOnSpeakEvent", "(Lkotlin/jvm/functions/Function3;)V", "chatStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/bytedance/ai/view/input/FloatingChatStatus;", "getChatStatus", "displayView", "Landroid/view/View;", "isSubmit", "_onSpeakAbility", "Lcom/bytedance/ai/floating/OnSpeakAbility;", "handleMove", "globalX", "globalY", "handleRelease", "touchOutsideOfVisualizer", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatSpeaker extends ConstraintLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f37707l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f37708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g2.a f37709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y4.a f37710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y4.b f37711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Pair<Boolean, Boolean> f37712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f37713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<String> f37714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<String> f37715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function3<? super Integer, ? super Float, ? super Float, Boolean> f37716i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function0<z0<FloatingChatStatus>> f37717j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final y4.c f37718k;

    public final a getAbility() {
        return this.f37708a;
    }

    public Function0<String> getBotId() {
        return this.f37714g;
    }

    public Function0<z0<FloatingChatStatus>> getChatStatus() {
        return this.f37717j;
    }

    public Function0<String> getCvsId() {
        return this.f37715h;
    }

    public Function3<Integer, Float, Float, Boolean> getOnSpeakEvent() {
        return this.f37716i;
    }

    public Function1<Boolean, Unit> getOnSpeakStatusChanged() {
        return this.f37713f;
    }

    public final boolean R5(float r100) {
        y4.b r101 = this.f37711d;
        if (r101 == null) goto L14;
        Function0<Rect> r102 = r101.f565910b;
        if (r102 == null) goto L14;
        Rect r103 = r102.invoke();
        if (r103 == null) goto L14;
        if (r100 >= r103.top) goto L12;
    L13:
        return true;
    L12:
        if (r100 > r103.bottom) goto L13;
    L14:
        return false;
    }

    public void setBotId(Function0<String> r100) {
        this.f37714g = r100;
    }

    public void setCvsId(Function0<String> r100) {
        this.f37715h = r100;
    }

    public void setOnSpeakEvent(Function3<? super Integer, ? super Float, ? super Float, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f37716i = r100;
    }

    public void setOnSpeakStatusChanged(Function1<? super Boolean, Unit> r100) {
        this.f37713f = r100;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.bytedance.ai.view.input.w] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.ai.view.input.x] */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.bytedance.ai.view.input.y] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.bytedance.ai.view.input.v] */
    public ChatSpeaker(Context r110, a r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "ability");
        super(r110);
        this.f37708a = r111;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r112 = AppletRuntimeManager.f36749d;
        if (r112 == null) goto L5;
        g2.a r113 = r112.h();
    L6:
        this.f37709b = r113;
        this.f37712e = new Pair(null, Boolean.FALSE);
        this.f37713f = r111.f37743f;
        this.f37714g = r111.f37738a;
        this.f37715h = r111.f37739b;
        this.f37716i = new u(this);
        this.f37717j = r111.f37741d;
        ConstraintLayout.LayoutParams r100 = new ConstraintLayout.LayoutParams(0, -2);
        r100.bottomToBottom = 0;
        r100.leftToLeft = 0;
        r100.rightToRight = 0;
        setLayoutParams(r100);
        this.f37718k = new y4.c(new w(this), new x(this), new y(this), new v(this), r111.f37740c, r111.f37745h);
        if (r113 == null) goto L14;
        Function1<ConstraintLayout, Pair<y4.a, y4.b>> r114 = r113.f479637d;
        if (r114 == null) goto L15;
        Pair<y4.a, y4.b> r115 = r114.invoke(this);
        if (r115 == null) goto L16;
        this.f37710c = r115.getFirst();
        this.f37711d = r115.getSecond();
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r113 = null;
        goto L6
    }
}
