package com.obric.appstore.buss.myapp.sysapp;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.model.IAppInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements IAppInfo {

    /* JADX INFO: renamed from: com.obric.appstore.buss.myapp.sysapp.a$a, reason: collision with other inner class name */
    public static final class C0168a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AppInfo f10728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f10729b;

        public C0168a(AppInfo r10, boolean r11) {
            q.g(r10, "appInfo");
            super(null);
            this.f10728a = r10;
            this.f10729b = r11;
        }

        public final boolean a() {
            return this.f10729b;
        }

        @Override // com.obric.appstore.buss.myapp.sysapp.a, com.bytedanceos.common.model.IAppInfo
        public AppInfo getAppInfo() {
            return this.f10728a;
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker r10) {
        this();
    }

    @Override // com.bytedanceos.common.model.IAppInfo
    public abstract AppInfo getAppInfo();

    public a() {
    }
}
