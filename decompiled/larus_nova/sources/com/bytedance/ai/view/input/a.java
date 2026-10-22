package com.bytedance.ai.view.input;

import com.bytedance.ai.bridge.method.floatinginput.InputMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f37738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f37739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f37740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<z0<FloatingChatStatus>> f37741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function3<Integer, Float, Float, Boolean> f37742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Boolean, Unit> f37743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Integer> f37744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function2<String, String, Boolean> f37745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<z0<InputMode>> f37746i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f37738a, r101.f37738a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f37739b, r101.f37739b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f37740c, r101.f37740c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f37741d, r101.f37741d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f37742e, r101.f37742e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f37743f, r101.f37743f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f37744g, r101.f37744g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f37745h, r101.f37745h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f37746i, r101.f37746i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f37738a.hashCode() * 31) + this.f37739b.hashCode()) * 31) + this.f37740c.hashCode()) * 31) + this.f37741d.hashCode()) * 31) + this.f37742e.hashCode()) * 31) + this.f37743f.hashCode()) * 31) + this.f37744g.hashCode()) * 31;
        Function2<String, String, Boolean> r101 = this.f37745h;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f37746i.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "Ability(botId=" + this.f37738a + ", conversationId=" + this.f37739b + ", appendQuery=" + this.f37740c + ", chatStatus=" + this.f37741d + ", onSpeakEvent=" + this.f37742e + ", onSpeakStatusCallback=" + this.f37743f + ", offset=" + this.f37744g + ", redirectQuery=" + this.f37745h + ", inputMode=" + this.f37746i + ')';
    }

    public a(z r100, a0 r101, b0 r102, c0 r103, d0 r104, e0 r105, f0 r106, g0 r107, h0 r110) {
        Intrinsics.checkNotNullParameter(r100, "botId");
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "appendQuery");
        Intrinsics.checkNotNullParameter(r103, "chatStatus");
        Intrinsics.checkNotNullParameter(r104, "onSpeakEvent");
        Intrinsics.checkNotNullParameter(r105, "onSpeakStatusCallback");
        Intrinsics.checkNotNullParameter(r106, "offset");
        Intrinsics.checkNotNullParameter(r110, "inputMode");
        this.f37738a = r100;
        this.f37739b = r101;
        this.f37740c = r102;
        this.f37741d = r103;
        this.f37742e = r104;
        this.f37743f = r105;
        this.f37744g = r106;
        this.f37745h = r107;
        this.f37746i = r110;
    }
}
