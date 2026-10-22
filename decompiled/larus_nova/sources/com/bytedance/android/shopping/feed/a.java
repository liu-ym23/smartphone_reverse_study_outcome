package com.bytedance.android.shopping.feed;

import android.os.Looper;
import android.os.MessageQueue;
import java.util.LinkedList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<T> f174321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f174322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f174323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2602a f174324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<T> f174325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f174326f;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.feed.a$a, reason: collision with other inner class name */
    public static final class C2602a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f174327a;

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            a r100 = this.f174327a;
            if (r100.f174322b < r100.f174326f) goto L5;
        L7:
            r100.f174323c = false;
        L8:
            return false;
        L5:
            if (r100.f174323c == false) goto L7;
            this.f174327a.f174321a.add(r100.f174325e.invoke());
            this.f174327a.f174322b++;
            Looper.myQueue().addIdleHandler(this);
            goto L8
        }

        public C2602a(a r100) {
            this.f174327a = r100;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends T> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "creator");
        this.f174325e = r100;
        this.f174326f = r101;
        this.f174321a = new LinkedList();
        this.f174324d = new C2602a(this);
    }
}
