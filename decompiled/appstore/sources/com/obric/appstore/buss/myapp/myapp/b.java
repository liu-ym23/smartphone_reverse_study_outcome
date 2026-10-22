package com.obric.appstore.buss.myapp.myapp;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.IAppInfo;
import com.obric.appstore.R;
import com.obric.appstore.ui.adapter.ITitle;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements IAppInfo, ITitle {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0167b f10715b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10716a;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AppInfo f10717c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f10718d;

        public /* synthetic */ a(AppInfo r10, int r11, boolean r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 4) == 0) goto L5;
            r12 = false;
        L5:
            this(r10, r11, r12);
        }

        @Override // com.obric.appstore.buss.myapp.myapp.b, com.bytedanceos.common.model.IAppInfo
        public AppInfo getAppInfo() {
            return this.f10717c;
        }

        @Override // com.obric.appstore.ui.adapter.ITitle
        public boolean getShowTopDivider() {
            return this.f10718d;
        }

        public a(AppInfo r10, int r11, boolean r12) {
            q.g(r10, "appInfo");
            super(r11, null);
            this.f10717c = r10;
            this.f10718d = r12;
        }
    }

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.myapp.b$b, reason: collision with other inner class name */
    public static final class C0167b {
        public /* synthetic */ C0167b(DefaultConstructorMarker r10) {
            this();
        }

        public C0167b() {
        }
    }

    public static final class c extends b implements ITitle {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f10720d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f10721e;

        public c(int r10, int r11, boolean r12) {
            super(r10, null);
            this.f10719c = r10;
            this.f10720d = r11;
            this.f10721e = r12;
        }

        @Override // com.obric.appstore.buss.myapp.myapp.b
        public int a() {
            return this.f10719c;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.f10719c == r11.f10719c) goto L12;
            return false;
        L12:
            if (this.f10720d == r11.f10720d) goto L15;
            return false;
        L15:
            if (this.f10721e == r11.f10721e) goto L17;
            return false;
        L17:
            return true;
        }

        @Override // com.obric.appstore.ui.adapter.ITitle
        public boolean getShowTopDivider() {
            return this.f10721e;
        }

        @Override // com.obric.appstore.buss.myapp.myapp.b, com.obric.appstore.ui.adapter.ITitle
        public String getTitle() {
            int r10 = a();
            if (r10 != 0) goto L5;
            String r11 = BaseApplication.c().getString(R.string.downloading_with_count, new Object[]{Integer.valueOf(this.f10720d)});
            q.f(r11, "getString(...)");
            return r11;
        L5:
            if (r10 == 1) goto L7;
            return "";
        L7:
            String r12 = BaseApplication.c().getString(R.string.myapp_installed_apps_with_count, new Object[]{Integer.valueOf(this.f10720d)});
            q.f(r12, "getString(...)");
            return r12;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f10719c) * 31) + Integer.hashCode(this.f10720d)) * 31) + Boolean.hashCode(this.f10721e);
        }

        public String toString() {
            return "TitleItem(type=" + this.f10719c + ", count=" + this.f10720d + ", showTopDivider=" + this.f10721e + ')';
        }
    }

    static {
        f10715b = new C0167b(null);
    }

    public /* synthetic */ b(int r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    public int a() {
        return this.f10716a;
    }

    @Override // com.bytedanceos.common.model.IAppInfo
    public AppInfo getAppInfo() {
        return IAppInfo.DefaultImpls.getAppInfo(this);
    }

    @Override // com.obric.appstore.ui.adapter.ITitle
    public String getTitle() {
        return ITitle.a.a(this);
    }

    public b(int r10) {
        this.f10716a = r10;
    }
}
