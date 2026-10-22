package com.smt.obric.appstore.ui.app;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/smt/obric/appstore/ui/app/AppStatusEvent;", "", "a", "b", "c", "d", "Lcom/smt/obric/appstore/ui/app/AppStatusEvent$a;", "Lcom/smt/obric/appstore/ui/app/AppStatusEvent$b;", "Lcom/smt/obric/appstore/ui/app/AppStatusEvent$c;", "Lcom/smt/obric/appstore/ui/app/AppStatusEvent$d;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AppStatusEvent {

    public static final class a implements AppStatusEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18151a = null;

        static {
            f18151a = new a();
        }

        public a() {
        }
    }

    public static final class b implements AppStatusEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f18152a = null;

        static {
            f18152a = new b();
        }

        public b() {
        }
    }

    public static final class c implements AppStatusEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18153a;

        public c(boolean r10) {
            this.f18153a = r10;
        }

        public final boolean a() {
            return this.f18153a;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f18153a == ((c) r10).f18153a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f18153a);
        }

        public String toString() {
            return "EnqueuedWaitWiFi(byUser=" + this.f18153a + ')';
        }
    }

    public static final class d implements AppStatusEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f18154a = null;

        static {
            f18154a = new d();
        }

        public d() {
        }
    }
}
