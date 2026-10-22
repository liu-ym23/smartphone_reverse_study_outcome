package com.bytedance.android.livesdk.chatroom.viewmodel;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes8.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f114782a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set<Integer> f114783a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f114784b = null;

        public a() {
        }

        static {
            f114784b = new a();
            f114783a = SetsKt.setOf(new Integer[]{12, 8, 16});
        }
    }

    static {
        f114782a = a.f114784b;
    }

    BehaviorSubject a();

    j b();

    void c(j r100);

    BehaviorSubject d();

    void e(j r100);

    void f(k r100);

    void g(k r100);

    int getWindowCount();

    j h();

    BehaviorSubject i();

    BehaviorSubject j();

    boolean k();

    void reset();

    j t();
}
