package com.bytedanceos.appstore.buss.viewmodels;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.k0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.utils.FeedBackUtil;
import kotlin.Lazy;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public final class AppFeedBackViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f8910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f8911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f8913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8914h;

    public static final class a extends ViewModelProvider.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Context f8915d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f8916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f8917f;

        public a(Context r10, String r11, int r12) {
            q.g(r10, ServerElements.CONTENT);
            q.g(r11, "packageName");
            this.f8915d = r10;
            this.f8916e = r11;
            this.f8917f = r12;
        }

        @Override // androidx.lifecycle.ViewModelProvider.b, androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10) {
            q.g(r10, "modelClass");
            return new AppFeedBackViewModel(this.f8915d, this.f8916e, this.f8917f);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public k0 create(Class r10, CreationExtras r11) {
            q.g(r10, "modelClass");
            q.g(r11, "extras");
            return new AppFeedBackViewModel(this.f8915d, this.f8916e, this.f8917f);
        }
    }

    public AppFeedBackViewModel(Context r10, String r11, int r12) {
        q.g(r10, ServerElements.CONTENT);
        q.g(r11, "packageName");
        this.f8910d = r10;
        this.f8911e = r11;
        this.f8912f = r12;
        this.f8913g = kotlin.b.b(AppFeedBackViewModel$appFeedBackLiveData$2.INSTANCE);
        this.f8914h = kotlin.b.b(new AppFeedBackViewModel$feedBackImage$2(this));
    }

    public static final /* synthetic */ int f(AppFeedBackViewModel r10) {
        return r10.f8912f;
    }

    public static final /* synthetic */ Context g(AppFeedBackViewModel r10) {
        return r10.f8910d;
    }

    public static final /* synthetic */ String h(AppFeedBackViewModel r10) {
        return r10.f8911e;
    }

    public final MutableLiveData i() {
        return (MutableLiveData) this.f8913g.getValue();
    }

    public final FeedBackUtil j() {
        return (FeedBackUtil) this.f8914h.getValue();
    }
}
