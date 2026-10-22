package com.smt.obric.appstore.domain.app.entity;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u000e\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0001\b\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/smt/obric/appstore/domain/app/entity/AppStatus;", "", "", "getOrdinal", "()I", "ordinal", "a", "b", "c", "d", "DownloadStatus", "e", "f", "g", "h", "i", "j", "k", "l", "m", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$DownloadStatus;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$g;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$h;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$i;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$j;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$k;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$l;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$m;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AppStatus {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001\u0082\u0001\u0006\u0002\u0003\u0004\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/smt/obric/appstore/domain/app/entity/AppStatus$DownloadStatus;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$a;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$b;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$c;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$d;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$e;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus$f;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface DownloadStatus extends AppStatus {
    }

    public static final class a implements DownloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17968a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17969b = 0;

        static {
            f17968a = new a();
            f17969b = 7;
        }

        public a() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17969b;
        }
    }

    public static final class b implements DownloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f17970a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17971b = 0;

        static {
            f17970a = new b();
            f17971b = 5;
        }

        public b() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17971b;
        }
    }

    public static final class c implements DownloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f17972a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17973b = 0;

        static {
            f17972a = new c();
            f17973b = 3;
        }

        public c() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17973b;
        }
    }

    public static final class d implements DownloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f17974a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17975b = 0;

        static {
            f17974a = new d();
            f17975b = 4;
        }

        public d() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17975b;
        }
    }

    public static final class e implements DownloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f17976a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17977b = 0;

        static {
            f17976a = new e();
            f17977b = 6;
        }

        public e() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17977b;
        }
    }

    public static final class f implements DownloadStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f17978a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17979b = 0;

        static {
            f17978a = new f();
            f17979b = 8;
        }

        public f() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17979b;
        }
    }

    public static final class g implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f17980a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17981b = 0;

        static {
            f17980a = new g();
            f17981b = 13;
        }

        public g() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17981b;
        }
    }

    public static final class h implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f17982a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17983b = 0;

        static {
            f17982a = new h();
            f17983b = 12;
        }

        public h() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17983b;
        }
    }

    public static final class i implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f17984a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17985b = 0;

        static {
            f17984a = new i();
            f17985b = 11;
        }

        public i() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17985b;
        }
    }

    public static final class j implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f17986a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17987b = 0;

        static {
            f17986a = new j();
            f17987b = 10;
        }

        public j() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17987b;
        }
    }

    public static final class k implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f17988a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17989b = 0;

        static {
            f17988a = new k();
            f17989b = 1;
        }

        public k() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17989b;
        }
    }

    public static final class l implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f17990a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17991b = 0;

        static {
            f17990a = new l();
            f17991b = 14;
        }

        public l() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17991b;
        }
    }

    public static final class m implements AppStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f17992a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f17993b = 0;

        static {
            f17992a = new m();
            f17993b = 2;
        }

        public m() {
        }

        @Override // com.smt.obric.appstore.domain.app.entity.AppStatus
        public int getOrdinal() {
            return f17993b;
        }
    }

    int getOrdinal();
}
