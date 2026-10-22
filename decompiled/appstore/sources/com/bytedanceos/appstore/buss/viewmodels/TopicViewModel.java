package com.bytedanceos.appstore.buss.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import kotlin.Lazy;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.h;

/* JADX INFO: loaded from: classes2.dex */
public final class TopicViewModel extends k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f8990g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f8991h;

    public TopicViewModel(String r10, int r11, int r12, int r13) {
        q.g(r10, "id");
        this.f8987d = r10;
        this.f8988e = r11;
        this.f8989f = r12;
        this.f8990g = r13;
        this.f8991h = kotlin.b.b(TopicViewModel$topicAppsLiveData$2.INSTANCE);
        j();
    }

    public static final /* synthetic */ String f(TopicViewModel r10) {
        return r10.f8987d;
    }

    public static final /* synthetic */ int g(TopicViewModel r10) {
        return r10.f8990g;
    }

    public static final /* synthetic */ int h(TopicViewModel r10) {
        return r10.f8988e;
    }

    public static final /* synthetic */ int i(TopicViewModel r10) {
        return r10.f8989f;
    }

    public final void j() {
        h.d(l0.a(this), null, null, new TopicViewModel$getTopicApps$1(this, null), 3, null);
    }

    public final MutableLiveData k() {
        return (MutableLiveData) this.f8991h.getValue();
    }
}
