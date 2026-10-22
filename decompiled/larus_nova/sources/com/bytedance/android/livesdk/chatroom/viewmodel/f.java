package com.bytedance.android.livesdk.chatroom.viewmodel;

import io.reactivex.subjects.BehaviorSubject;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes8.dex */
public interface f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f114785a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Set<Integer> f114786a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f114787b = null;

        public a() {
        }

        static {
            f114787b = new a();
            f114786a = SetsKt.setOf(new Integer[]{5, 9, 10, 16});
        }
    }

    static {
        f114785a = a.f114787b;
    }

    BehaviorSubject a();

    BehaviorSubject b();

    void c(i r100);

    void d(i r100);

    void e();

    boolean f(int r100, int r101);

    i g();

    void reset();

    i t();
}
