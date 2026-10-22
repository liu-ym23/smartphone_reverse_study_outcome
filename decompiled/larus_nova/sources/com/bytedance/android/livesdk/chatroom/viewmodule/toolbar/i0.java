package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class i0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f116327d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b f116328e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f116329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f116330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<d> f116331c;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f116332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f116333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONObject f116334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f116335d;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final Map<String, Object> getResult() {
            JSONObject r100 = this.f116334c;
            if (r100 == null) goto L7;
            Map<String, Object> r101 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(this.f116332a, r100)});
            if (r101 == null) goto L7;
            return r101;
        L7:
            return new LinkedHashMap();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final boolean isFinished() {
            return this.f116333b;
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "urlPath");
            this.f116335d = r100;
            this.f116332a = "beats";
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "callBack");
            int r101 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.f116801a;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a(this.f116335d, new h0(this, r100), null, 4);
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f116336a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f116337b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f116338c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f116339d;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final Map<String, Object> getResult() {
            if (this.f116338c.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L9;
            return new LinkedHashMap();
        L9:
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(this.f116336a, this.f116338c)});
        L5:
            r100 = false;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final boolean isFinished() {
            return this.f116337b;
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "urlPath");
            this.f116339d = r100;
            this.f116336a = "cover";
            this.f116338c = "";
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "callBack");
            int r101 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.f116801a;
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils.d.a(this.f116339d, null, new m0(this, r100), 2);
        }
    }

    public interface d {
        void a(g r100);

        Map<String, Object> getResult();

        boolean isFinished();
    }

    public static final class e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f116340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f116341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public JSONArray f116342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f116343d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f116344e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f116345f;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final Map<String, Object> getResult() {
            JSONArray r100 = this.f116342c;
            if (r100 == null) goto L7;
            String r101 = this.f116340a;
            Intrinsics.checkNotNull(r100);
            return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r101, r100)});
        L7:
            return new LinkedHashMap();
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final boolean isFinished() {
            return this.f116343d;
        }

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.d
        public final void a(g r100) {
            Intrinsics.checkNotNullParameter(r100, "callBack");
            this.f116341b = Single.create(new n0(this)).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new o0(this, r100), new p0(this, r100));
        }

        public e(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "localPath");
            this.f116344e = r100;
            this.f116345f = r101;
            this.f116340a = "lyrics";
        }
    }

    public interface f {
        void onFinish();
    }

    public static final class g implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i0 f116346a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.i0.f
        public final void onFinish() {
            List<d> r100 = this.f116346a.f116331c;
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            Object r103 = r102.next();
            if ((!((d) r103).isFinished()) == false) goto L4;
            r101.add(r103);
            goto L4
        L9:
            if (r101.isEmpty() == false) goto L19;
            f r104 = this.f116346a.f116330b;
            if (r104 == null) goto L20;
            r104.onFinish();
            return;
        L20:
            return;
        }

        public g(i0 r100) {
            this.f116346a = r100;
        }
    }

    static {
        f116328e = new b();
        f116327d = new ArrayList();
    }

    public i0() {
        this.f116329a = new g(this);
        this.f116331c = new ArrayList();
    }

    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if ((r100 instanceof a) == false) goto L5;
        ((ArrayList) this.f116331c).add(r100);
        return;
    L5:
        ListProtector.add(this.f116331c, 0, r100);
    }
}
