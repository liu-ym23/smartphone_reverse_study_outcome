package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.view.StablePrefixGradientEditText;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.utils.t2;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ml1.b;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00038\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\r\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/VSInputPanelLayout;", "Landroid/widget/FrameLayout;", "Lqq1/a;", "", "<set-?>", "c", "I", "getKeyboardHeight", "()I", "keyboardHeight", "Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/PanelType;", "getCurrentPanelType", "()Lcom/bytedance/android/livesdk/chatroom/replay/interactionmsg/danmaku/send/PanelType;", "currentPanelType", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSInputPanelLayout extends FrameLayout implements qq1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PanelType f109075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PanelType f109076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f109077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<PanelType, View> f109078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f109079e;

    public interface a {
        void d(PanelType r100, PanelType r101);
    }

    public VSInputPanelLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VSInputPanelLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final PanelType getCurrentPanelType() {
        return this.f109075a;
    }

    public final int getKeyboardHeight() {
        return this.f109077c;
    }

    @Override // qq1.a
    public final void X6(boolean r100, int r101) {
        if (r100 == false) goto L8;
        this.f109077c = this.f109077c;
        PanelType r102 = this.f109075a;
        this.f109076b = PanelType.NONE;
        this.f109075a = PanelType.KEYBOARD;
        Iterator<Map.Entry<PanelType, View>> r103 = this.f109078d.entrySet().iterator();
    L5:
        if (r103.hasNext() == false) goto L7;
        UtilityKotlinExtentionsKt.h(r103.next().getValue());
        goto L5
    L7:
        a(r102, getCurrentPanelType());
        return;
    L8:
        PanelType r104 = getCurrentPanelType();
        PanelType r105 = PanelType.KEYBOARD;
        if (r104 != r105) goto L17;
        View r106 = this.f109078d.get(this.f109076b);
        if (r106 == null) goto L13;
        UtilityKotlinExtentionsKt.j(r106);
    L13:
        this.f109075a = this.f109076b;
        this.f109076b = PanelType.NONE;
        UtilityKotlinExtentionsKt.j(this);
        a(r105, getCurrentPanelType());
        return;
    }

    public final void a(PanelType r100, PanelType r101) {
        Iterator<a> r102 = this.f109079e.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        a r103 = r102.next();
        View r104 = this.f109078d.get(r100);
        View r105 = this.f109078d.get(r101);
        r103.d(r100, r101);
        goto L4
    }

    public final void b(PanelType r100, StablePrefixGradientEditText r101) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        if (getCurrentPanelType() != r100) goto L5;
        return;
    L5:
        PanelType r102 = getCurrentPanelType();
        this.f109076b = r100;
        int r103 = ml1.a.f514355a[r100.ordinal()];
        if (r103 != 1) goto L8;
        this.f109075a = PanelType.NONE;
        t2.a(getContext(), r101);
        UtilityKotlinExtentionsKt.h(this);
        return;
    L8:
        if (r103 != 2) goto L10;
        t2.b(getContext(), r101);
        postDelayed(new b(this), 60);
        return;
    L10:
        if (getCurrentPanelType() != PanelType.KEYBOARD) goto L12;
        t2.a(getContext(), r101);
        return;
    L12:
        PanelType r104 = getCurrentPanelType();
        PanelType r105 = PanelType.NONE;
        if (r104 == r105) goto L25;
        View r106 = this.f109078d.get(getCurrentPanelType());
        if (r106 == null) goto L17;
        UtilityKotlinExtentionsKt.h(r106);
    L17:
        View r107 = this.f109078d.get(this.f109076b);
        if (r107 == null) goto L20;
        UtilityKotlinExtentionsKt.j(r107);
    L20:
        this.f109076b = r105;
        this.f109075a = r100;
        a(r102, getCurrentPanelType());
        return;
    }

    public VSInputPanelLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        PanelType r103 = PanelType.NONE;
        this.f109075a = r103;
        this.f109076b = r103;
        this.f109078d = new HashMap();
        this.f109079e = new CopyOnWriteArrayList();
        b(r103, null);
    }

    public /* synthetic */ VSInputPanelLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
