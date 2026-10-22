package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g<T extends a2, R extends a2> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f115922f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1719g<T> f115923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e<T> f115924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<R> f115925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i<R> f115926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d<T, R> f115927e;

    public static final class a {
        public static void a(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "startInfo");
            Intrinsics.checkNotNullParameter(r101, "list");
            StringBuilder r102 = new StringBuilder(r100 + " [");
            Iterator r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r102.append(((a2) r103.next()).debugName() + " ");
            goto L4
        L6:
            r102.append("]");
            ALogger.i("MorePanelDataManager", r102.toString());
        }
    }

    public interface b<T extends a2> extends a2 {
        boolean a(T r100);
    }

    public interface c<T extends a2> extends a2 {
        boolean b();

        List<T> c();

        void d();

        void onLoad();

        void onUnLoad();
    }

    public static final class d<T extends a2, R extends a2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h<R> f115928a;

        public d() {
        }
    }

    public static final class e<T extends a2> extends f<b<T>, T> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(List<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "list");
            Iterator r101 = ((ArrayList) r100).iterator();
        L4:
            if (r101.hasNext() == false) goto L14;
            a2 r102 = (a2) r101.next();
            Iterator r103 = this.f115929a.iterator();
            boolean r104 = false;
        L7:
            if (r103.hasNext() == false) goto L12;
            b r105 = (b) r103.next();
            boolean r106 = r105.a(r102);
            if (r106 == false) goto L11;
            int r107 = g.f115922f;
            a.a("Delete by " + r105.debugName() + HTTP.HEADER_LINE_DELIM, CollectionsKt.arrayListOf(new a2[]{r102}));
        L11:
            r104 = r106;
            goto L7
        L12:
            if (r104 == false) goto L4;
            r101.remove();
            goto L4
        }
    }

    public static abstract class f<Handler, Button extends a2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList<Handler> f115929a;

        public f() {
            this.f115929a = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.g$g, reason: collision with other inner class name */
    public static final class C1719g<T extends a2> extends f<c<T>, T> {
        public C1719g() {
        }
    }

    public interface h<R extends a2> {
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.data.e a(a2 r100);
    }

    public interface i<T extends a2> {
        void a(List<T> r100);
    }

    static {
    }

    public g() {
        new ArrayList();
        this.f115923a = new C1719g();
        this.f115924b = new e();
        this.f115925c = new e();
        this.f115927e = new d();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final void a(c<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "loader");
        if (r100.b() == false) goto L6;
        r100.onLoad();
        this.f115923a.f115929a.add((Handler) r100);
        return;
    }
}
