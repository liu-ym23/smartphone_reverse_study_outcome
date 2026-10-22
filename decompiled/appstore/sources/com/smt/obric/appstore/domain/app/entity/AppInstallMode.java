package com.smt.obric.appstore.domain.app.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 \u00062\u00020\u0001:\u0004\u0007\b\t\nR\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode;", "", "", "getOrdinal", "()I", "ordinal", "Companion", "a", "b", "c", "d", "Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode$b;", "Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode$c;", "Lcom/smt/obric/appstore/domain/app/entity/AppInstallMode$d;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AppInstallMode {

    @NotNull
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f17961a = null;

        static {
            f17961a = new a();
        }

        public a() {
        }

        public final AppInstallMode a(int r10) {
            c r11 = c.f17964a;
            if (r10 == r11.getOrdinal()) goto L13;
            d r12 = d.f17966a;
            if (r10 == r12.getOrdinal()) goto L14;
            b r13 = b.f17962a;
            if (r10 == r13.getOrdinal()) goto L15;
            return null;
        L15:
            return r13;
        L14:
            return r12;
        L13:
            return r11;
        }
    }

    public static final class b implements AppInstallMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f17962a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17963b = 0;

        static {
            f17962a = new b();
            f17963b = 3;
        }

        public b() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppInstallMode
        public int getOrdinal() {
            return f17963b;
        }
    }

    public static final class c implements AppInstallMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f17964a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17965b = 0;

        static {
            f17964a = new c();
            f17965b = 1;
        }

        public c() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppInstallMode
        public int getOrdinal() {
            return f17965b;
        }
    }

    public static final class d implements AppInstallMode {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f17966a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17967b = 0;

        static {
            f17966a = new d();
            f17967b = 2;
        }

        public d() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppInstallMode
        public int getOrdinal() {
            return f17967b;
        }
    }

    static {
        Companion = a.f17961a;
    }

    int getOrdinal();
}
