package com.bytedance.android.livesdk.chatroom.vs_base.base.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vr1.e0;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/view/InputLinearLayout;", "Landroid/widget/LinearLayout;", "Lqq1/b;", "getKeyBoardObservable", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InputLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qq1.b f117954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f117955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f117956c;

    public final qq1.b getKeyBoardObservable() {
        return this.f117954a;
    }

    public InputLinearLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        qq1.b r101 = this.f117954a;
        Context r102 = getContext();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "rootView");
        vr1.e r103 = r101.f534465a;
        if (r103 == null) goto L9;
        e0 r104 = r103.a(r102, this);
        if (r104 == null) goto L10;
        r101.c(r104.f556808a, r104.f556809b);
        return;
    L10:
        return;
    }

    public InputLinearLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f117956c;
        int r103 = this.f117955b;
        if (r102 != r103) goto L10;
        qq1.b r104 = this.f117954a;
        Context r105 = getContext();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        vr1.e r106 = r104.f534465a;
        if (r106 == null) goto L11;
        e0 r107 = r106.b(r105, r101);
        if (r107 == null) goto L11;
        r104.c(r107.f556808a, r107.f556809b);
    L11:
        super.onMeasure(r100, r101);
        return;
    L10:
        this.f117956c = r103;
        goto L11
    }

    public InputLinearLayout(Context r100, AttributeSet r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r102 == null) goto L5;
        int r103 = r102.intValue();
    L6:
        super(r100, r101, r103);
        this.f117954a = new qq1.b(this);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r110, int r111, int r112) {
        super.onLayout(r100, r101, r110, r111, r112);
        qq1.b r102 = this.f117954a;
        Context r103 = getContext();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, RootDescription.ROOT_ELEMENT);
        vr1.e r104 = r102.f534465a;
        if (r104 == null) goto L9;
        e0 r105 = r104.c(r103, this, r101, r110, r111, r112);
        if (r105 == null) goto L10;
        r102.c(r105.f556808a, r105.f556809b);
        return;
    L10:
        return;
    }
}
