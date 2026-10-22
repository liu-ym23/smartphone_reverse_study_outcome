package com.obric.appstore.buss.myapp.update;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.IAppInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements IAppInfo {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppInfo f10772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10773b;

        public a(AppInfo r10, boolean r11) {
            q.g(r10, "appInfo");
            super(null);
            this.f10772a = r10;
            this.f10773b = r11;
        }

        public final boolean a() {
            return this.f10773b;
        }

        @Override // com.obric.appstore.buss.myapp.update.e, com.bytedanceos.common.model.IAppInfo
        public AppInfo getAppInfo() {
            return this.f10772a;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10775b;

        public b(int r10, boolean r11) {
            super(null);
            this.f10774a = r10;
            this.f10775b = r11;
        }

        public final int a() {
            return this.f10774a;
        }

        public final boolean b() {
            return this.f10775b;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10777b;

        public c(int r10, boolean r11) {
            super(null);
            this.f10776a = r10;
            this.f10777b = r11;
        }

        public final int a() {
            return this.f10776a;
        }

        public final boolean b() {
            return this.f10777b;
        }
    }

    public static final class d extends e {
    }

    public /* synthetic */ e(DefaultConstructorMarker r10) {
        this();
    }

    @Override // com.bytedanceos.common.model.IAppInfo
    public AppInfo getAppInfo() {
        return IAppInfo.DefaultImpls.getAppInfo(this);
    }

    public e() {
    }
}
