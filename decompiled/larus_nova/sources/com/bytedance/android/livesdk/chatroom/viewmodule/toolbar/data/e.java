package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.s;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements com.bytedance.android.livesdk.chatroom.e, a2, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f115909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f115910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f115911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f115912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f115913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f115914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f115915g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f115916h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f115917i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f115918j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s<Object> f115919k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f115920l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ExtendedToolbarButton f115921m;

    public final ToolbarButton e() {
        ExtendedToolbarButton r100 = this.f115921m;
        if ((r100 instanceof ExtendedToolbarButton.b) == true) goto L5;
        return null;
    L5:
        return ((ExtendedToolbarButton.b) r100).f115626i;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b
    public final String getComponentName() {
        ExtendedToolbarButton r100 = this.f115921m;
        if ((r100 instanceof ExtendedToolbarButton.b) == true) goto L5;
        r100 = null;
    L5:
        ExtendedToolbarButton.b r101 = (ExtendedToolbarButton.b) r100;
        if (r101 == null) goto L11;
        ToolbarButton r102 = r101.f115626i;
        if (r102 == null) goto L11;
        String r103 = r102.name();
        if (r103 == null) goto L11;
        return r103;
    L11:
        return "null";
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f115909a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f115910b) * 31;
        List<String> r103 = this.f115911c;
        if (r103 == null) goto L9;
        int r104 = r103.hashCode();
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.f115912d == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f115913e == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = ((((((r107 + r108) * 31) + this.f115914f.hashCode()) * 31) + this.f115916h.hashCode()) * 31) + this.f115917i;
        ExtendedToolbarButton r110 = this.f115921m;
        if ((r110 instanceof ExtendedToolbarButton.c) == false) goto L26;
        int r111 = r109 * 31;
        if (((ExtendedToolbarButton.c) r110).f115636r == true) goto L25;
        r100 = 1237;
    L25:
        return r111 + r100;
    L26:
        return r109;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return this.f115914f;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.control.b
    public final int getComponentId() {
        return this.f115915g;
    }

    @Override // com.bytedance.android.livesdk.chatroom.e
    public final s<Object> getCustomView() {
        return this.f115919k;
    }

    @Override // com.bytedance.android.livesdk.chatroom.e
    public final int getGroupType() {
        return this.f115917i;
    }

    public e(ExtendedToolbarButton r100) {
        Intrinsics.checkNotNullParameter(r100, "extendedToolbarButton");
        this.f115921m = r100;
        this.f115914f = "";
        this.f115915g = -1;
        this.f115916h = "";
        this.f115917i = 2;
        this.f115920l = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        ExtendedToolbarButton r101 = null;
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(e.class, r102)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L50;
        e r103 = (e) r100;
        if (this.f115909a == r103.f115909a) goto L17;
        return false;
    L17:
        if (this.f115910b == r103.f115910b) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(this.f115911c, r103.f115911c)) == false) goto L23;
        return false;
    L23:
        if (this.f115912d == r103.f115912d) goto L26;
        return false;
    L26:
        if (this.f115913e == r103.f115913e) goto L29;
        return false;
    L29:
        if ((!Intrinsics.areEqual(this.f115914f, r103.f115914f)) == false) goto L32;
        return false;
    L32:
        if ((!Intrinsics.areEqual(this.f115916h, r103.f115916h)) == false) goto L35;
        return false;
    L35:
        if (this.f115917i == r103.f115917i) goto L37;
        return false;
    L37:
        ExtendedToolbarButton r104 = this.f115921m;
        if ((r104 instanceof ExtendedToolbarButton.c) == false) goto L48;
        boolean r105 = ((ExtendedToolbarButton.c) r104).f115636r;
        ExtendedToolbarButton r106 = r103.f115921m;
        if ((r106 instanceof ExtendedToolbarButton.c) == false) goto L43;
        r101 = r106;
    L43:
        ExtendedToolbarButton.c r107 = (ExtendedToolbarButton.c) r101;
        if (r107 != null) goto L46;
    L47:
        return false;
    L46:
        if (r105 != r107.f115636r) goto L47;
    L48:
        return true;
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.MoreDialogButtonModel");
    L8:
        r102 = null;
        goto L10
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f115914f = r100;
    }
}
