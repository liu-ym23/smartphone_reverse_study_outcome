package com.bytedance.android.live.broadcastgame.xplay;

import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f62031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PublishSubject<Float> f62032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<a> f62033c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f62034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f62035b;

        public a(float r100) {
            this.f62035b = r100;
        }
    }

    public c1() {
        this.f62032b = PublishSubject.create();
        this.f62033c = new ArrayList();
    }
}
