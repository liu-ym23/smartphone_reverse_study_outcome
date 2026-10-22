package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.reddot.RedDotDelegate;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public abstract class ExtendedToolbarButton implements a2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<ToolbarButton, WeakReference<b>> f115617g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f115618h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f115619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f115620b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RedDotDelegate f115621c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f115622d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f115623e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HighLightMode f115624f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/viewmodule/toolbar/ExtendedToolbarButton$HighLightMode;", "", "DISABLE", "TRUE", "FALSE", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HighLightMode extends Enum<HighLightMode> {
        public static final HighLightMode DISABLE = null;
        public static final HighLightMode FALSE = null;
        public static final HighLightMode TRUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HighLightMode[] f115625a = null;

        static {
            HighLightMode r100 = new HighLightMode("DISABLE", 0);
            DISABLE = r100;
            HighLightMode r101 = new HighLightMode("TRUE", 1);
            TRUE = r101;
            HighLightMode r102 = new HighLightMode("FALSE", 2);
            FALSE = r102;
            f115625a = new HighLightMode[]{r100, r101, r102};
        }

        public static HighLightMode valueOf(String r100) {
            return (HighLightMode) r27.a.a(HighLightMode.class, r100);
        }

        public static HighLightMode[] values() {
            return (HighLightMode[]) f115625a.clone();
        }

        public HighLightMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static b a(ToolbarButton r100) {
            Intrinsics.checkNotNullParameter(r100, "button");
            Map<ToolbarButton, WeakReference<b>> r101 = ExtendedToolbarButton.f115617g;
            WeakReference r102 = (WeakReference) ((LinkedHashMap) r101).get(r100);
            if (r102 == null) goto L8;
            b r103 = (b) r102.get();
            if (r103 == null) goto L8;
            return r103;
        L8:
            b r104 = new b(r100);
            r101.put(r100, new WeakReference(r104));
            return r104;
        }
    }

    public static final class b extends ExtendedToolbarButton {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ToolbarButton f115626i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f115626i, ((b) r100).f115626i) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            ToolbarButton r100 = this.f115626i;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "LocalIcon(icon=" + this.f115626i + ")";
        }

        public b(ToolbarButton r100) {
            Intrinsics.checkNotNullParameter(r100, "icon");
            super(true);
            this.f115626i = r100;
        }
    }

    public static class c extends ExtendedToolbarButton {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f115627i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f115628j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f115629k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f115630l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f115631m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f115632n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f115633o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List<String> f115634p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f115635q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f115636r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final String f115637s;

        public c(List<String> r100, String r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r103, "id");
            super(false);
            this.f115634p = r100;
            this.f115635q = r101;
            this.f115636r = r102;
            this.f115637s = r103;
            this.f115630l = "";
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f115638t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final List<String> f115639u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final String f115640v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f115641w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final String f115642x;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L16;
            d r101 = (d) r100;
            if (this.f115638t == r101.f115638t) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115639u, r101.f115639u) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f115640v, r101.f115640v) == true) goto L12;
            return false;
        L12:
            if (this.f115641w == r101.f115641w) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.f115642x, r101.f115642x) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            boolean r100 = this.f115638t;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            List<String> r104 = this.f115639u;
            int r105 = 0;
            if (r104 == null) goto L8;
            int r106 = r104.hashCode();
        L9:
            int r107 = (r103 + r106) * 31;
            String r108 = this.f115640v;
            if (r108 == null) goto L12;
            int r109 = r108.hashCode();
        L13:
            int r110 = (r107 + r109) * 31;
            boolean r111 = this.f115641w;
            if (r111 == true) goto L17;
            r101 = r111;
        L17:
            int r112 = (r110 + r101) * 31;
            String r113 = this.f115642x;
            if (r113 == null) goto L21;
            r105 = r113.hashCode();
        L21:
            return r112 + r105;
        L12:
            r109 = 0;
            goto L13
        L8:
            r106 = 0;
            goto L9
        }

        public final String toString() {
            return "NetworkIconWithSwitch(isOn=" + this.f115638t + ", switchUrl=" + this.f115639u + ", switchTitle=" + this.f115640v + ", switchIsNew=" + this.f115641w + ", switchId=" + this.f115642x + ")";
        }

        public d(boolean r100, List r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r101, "switchUrl");
            Intrinsics.checkNotNullParameter(r102, "switchTitle");
            Intrinsics.checkNotNullParameter(r103, "switchId");
            super(r101, r102, false, r103);
            this.f115638t = r100;
            this.f115639u = r101;
            this.f115640v = r102;
            this.f115641w = false;
            this.f115642x = r103;
        }
    }

    @JvmStatic
    public static final b e(ToolbarButton r100) {
        f115618h.getClass();
        return a.a(r100);
    }

    static {
        f115618h = new a();
        f115617g = new LinkedHashMap();
    }

    public final String f() {
        if ((this instanceof b) == false) goto L6;
        return ((b) this).f115626i.name();
    L6:
        if ((this instanceof c) == false) goto L10;
        return ((c) this).f115635q;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final String g() {
        if ((this instanceof b) == false) goto L24;
        b r100 = (b) this;
        if (r100.f115626i.getTitleId() != 0) goto L7;
        String r101 = "";
    L12:
        String r102 = r100.f115626i.getTitleStr();
        if (r102 != null) goto L15;
        return r101;
    L15:
        if (r102.length() <= 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 != true) goto L30;
        String r104 = r100.f115626i.getTitleStr();
        if (r104 != null) goto L31;
        return r101;
    L31:
        return r104;
    L30:
        return r101;
    L17:
        r103 = false;
        goto L18
    L7:
        IMiddlewareHostApp r105 = (IMiddlewareHostApp) jc1.k.f(IMiddlewareHostApp.class);
        if (r105 == null) goto L11;
        r101 = r105.replaceBrand(r100.f115626i.getTitleId());
        if (r101 != null) goto L12;
    L11:
        r101 = com.bytedance.android.live.core.utils.s1.B(r100.f115626i.getTitleId());
        goto L12
    L24:
        if ((this instanceof c) == false) goto L28;
        return ((c) this).f115635q;
    L28:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2
    public final String debugName() {
        return f();
    }

    public ExtendedToolbarButton(boolean r100) {
        HighLightMode r101 = HighLightMode.DISABLE;
        this.f115623e = r100;
        this.f115624f = r101;
        this.f115622d = -1;
    }
}
