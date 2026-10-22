package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseTimingUpdater<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o<T>> f133391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f133392b;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/BaseTimingUpdater$Companion$HandlerMessage;", "", "UPDATE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum HandlerMessage extends Enum<HandlerMessage> {
            public static final HandlerMessage UPDATE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ HandlerMessage[] f133393a = null;

            static {
                HandlerMessage r100 = new HandlerMessage();
                UPDATE = r100;
                f133393a = new HandlerMessage[]{r100};
            }

            public static HandlerMessage valueOf(String r100) {
                return (HandlerMessage) r27.a.a(HandlerMessage.class, r100);
            }

            public static HandlerMessage[] values() {
                return (HandlerMessage[]) f133393a.clone();
            }

            public HandlerMessage() {
                super("UPDATE", 0);
            }
        }
    }

    public static final class a implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseTimingUpdater f133394a;

        public a(BaseTimingUpdater r100) {
            this.f133394a = r100;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            if (r100.what != Companion.HandlerMessage.UPDATE.ordinal()) goto L7;
            BaseTimingUpdater.a(this.f133394a);
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    public abstract void c();

    public abstract long d();

    public final void f() {
        this.f133392b.removeCallbacksAndMessages(null);
        this.f133392b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public void g() {
        this.f133392b.removeCallbacksAndMessages(null);
        this.f133392b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public final void h() {
        this.f133392b.removeCallbacksAndMessages(null);
        update();
    }

    public void i() {
        this.f133392b.removeCallbacksAndMessages(null);
    }

    public final void j() {
        this.f133392b.removeCallbacksAndMessages(null);
        update();
        this.f133392b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public BaseTimingUpdater() {
        this.f133391a = new ArrayList();
        this.f133392b = new Handler(Looper.getMainLooper(), new a(this));
    }

    private final void update() {
        c();
        this.f133392b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public static final /* synthetic */ void a(BaseTimingUpdater r100) {
        r100.update();
    }

    public final void b(o<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f133391a).add(r100);
    }

    public final void e(T r100) {
        Iterator<T> r101 = this.f133391a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((o) r101.next()).a(r100);
        goto L4
    }
}
