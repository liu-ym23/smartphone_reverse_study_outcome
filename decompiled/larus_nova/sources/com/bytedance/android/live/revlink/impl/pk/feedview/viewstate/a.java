package com.bytedance.android.live.revlink.impl.pk.feedview.viewstate;

import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.revlink.impl.pk.feedview.bridge.c;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<String> f96638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f96639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<JSONObject> f96640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<String> f96641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<String> f96642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Boolean> f96643f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1484a f96644g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f96645h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f96646i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final FrameLayout f96647j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f96648k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.impl.pk.scopeservice.a f96649l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function0<Pair<Integer, Integer>> f96650m;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.a$a, reason: collision with other inner class name */
    public static final class C1484a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f96651a;

        public C1484a(a r100) {
            this.f96651a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            MutableLiveData<String> r101 = this.f96651a.f96641d;
            r101.setValue((String) r100);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f96652a;

        public b(a r100) {
            this.f96652a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            MutableLiveData<String> r101 = this.f96652a.f96642e;
            r101.setValue((String) r100);
        }
    }

    public a(FrameLayout r100, com.bytedance.android.live.revlink.impl.pk.feedview.viewstate.b r101, c r102, com.bytedance.android.live.revlink.impl.pk.scopeservice.a r103, Function0<Pair<Integer, Integer>> r104) {
        Intrinsics.checkNotNullParameter(r100, "lynxContainer");
        Intrinsics.checkNotNullParameter(r101, "viewState");
        Intrinsics.checkNotNullParameter(r102, "bridget");
        Intrinsics.checkNotNullParameter(r103, "service");
        Intrinsics.checkNotNullParameter(r104, "getPlayerWH");
        this.f96647j = r100;
        this.f96648k = r102;
        this.f96649l = r103;
        this.f96650m = r104;
        this.f96638a = new MutableLiveData();
        this.f96639b = new MutableLiveData();
        this.f96640c = new MutableLiveData();
        this.f96641d = new MutableLiveData();
        this.f96642e = new MutableLiveData();
        this.f96643f = new MutableLiveData(Boolean.FALSE);
        this.f96644g = new C1484a(this);
        this.f96645h = new b(this);
    }
}
