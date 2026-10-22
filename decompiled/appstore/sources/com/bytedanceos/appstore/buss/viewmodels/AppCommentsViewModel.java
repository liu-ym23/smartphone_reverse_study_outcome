package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.l0;
import com.bytedanceos.appstore.buss.entity.netwrap.PushAddCommentEntity;
import h7.d;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AppCommentsViewModel extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f8887k = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f8889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f8890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData f8891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData f8892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8893i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f8894j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f8887k = new a(null);
    }

    public AppCommentsViewModel(String r10) {
        q.g(r10, "packageName");
        this.f8888d = r10;
        this.f8890f = kotlin.b.b(AppCommentsViewModel$commentsLiveData$2.INSTANCE);
        this.f8891g = new MutableLiveData();
        this.f8892h = new MutableLiveData();
        this.f8893i = 1;
        this.f8894j = 30;
        j();
    }

    public final void f(PushAddCommentEntity r10) {
        q.g(r10, "entity");
        Job r11 = this.f8889e;
        if (r11 == null) goto L5;
        Job.a.b(r11, null, 1, null);
    L5:
        this.f8889e = h.d(l0.a(this), null, null, new AppCommentsViewModel$addComment$1(this, r10, null), 3, null);
    }

    public final void g() {
        h.d(l0.a(this), null, null, new AppCommentsViewModel$checkComment$1(this, null), 3, null);
    }

    public final MutableLiveData h() {
        return this.f8892h;
    }

    public final MutableLiveData i() {
        return this.f8891g;
    }

    public final void j() {
        h.d(l0.a(this), null, null, new AppCommentsViewModel$getComments$1(this, null), 3, null);
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8890f.getValue();
    }

    public final int l() {
        return this.f8893i;
    }

    public final String m() {
        return this.f8888d;
    }

    public final int n() {
        return this.f8894j;
    }

    public final void o() {
        int r10 = this.f8893i;
        if (r10 <= 1) goto L6;
        this.f8893i = r10 - 1;
        return;
    }

    public void p(LifecycleOwner r10) {
        q.g(r10, "owner");
        k().o(r10);
        this.f8891g.o(r10);
        this.f8892h.o(r10);
    }

    public final void q(int r10) {
        this.f8893i = r10;
    }
}
