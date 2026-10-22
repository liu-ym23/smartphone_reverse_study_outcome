package com.bytedance.android.livesdk.performance.event;

import android.app.Activity;
import android.view.MotionEvent;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public abstract class EventType<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f154574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f154575c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f154576d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f154577a;

    public static final class a extends EventType<Map<String, ? extends Object>> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f154578e = null;

        static {
            f154578e = new a();
        }

        public a() {
            super("ANIM");
        }
    }

    public static final class b extends EventType<Unit> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f154579e = null;

        static {
            f154579e = new b();
        }

        public b() {
            super("CARD");
        }
    }

    public static final class c extends EventType<Boolean> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f154580e = null;

        static {
            f154580e = new c();
        }

        public c() {
            super("CLEAR_SCREEN");
        }
    }

    public static final class d extends EventType<Activity> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f154581e = null;

        static {
            f154581e = new d();
        }

        public d() {
            super("CONTAINER_PAUSE");
        }
    }

    public static final class e extends EventType<Activity> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f154582e = null;

        static {
            f154582e = new e();
        }

        public e() {
            super("CONTAINER_STOP");
        }
    }

    public static final class f {
        public f() {
        }
    }

    public static final class g extends EventType<Unit> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final g f154583e = null;

        static {
            f154583e = new g();
        }

        public g() {
            super("DIALOG");
        }
    }

    public static final class h extends EventType<Unit> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final h f154584e = null;

        static {
            f154584e = new h();
        }

        public h() {
            super("ENTER_ROOM");
        }
    }

    public static final class i extends EventType<Unit> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final i f154585e = null;

        static {
            f154585e = new i();
        }

        public i() {
            super("EXIT_ROOM");
        }
    }

    public static final class j extends EventType<Unit> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final j f154586e = null;

        static {
            f154586e = new j();
        }

        public j() {
            super("FULL_SCREEN");
        }
    }

    public static final class k extends EventType<Boolean> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final k f154587e = null;

        static {
            f154587e = new k();
        }

        public k() {
            super("SCROLL");
        }
    }

    public static final class l extends EventType<MotionEvent> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final l f154588e = null;

        static {
            f154588e = new l();
        }

        public l() {
            super("Touch");
        }
    }

    public static final class m extends EventType<Unit> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final m f154589e = null;

        static {
            f154589e = new m();
        }

        public m() {
            super("TRIGGER_DEGRADE");
        }
    }

    static {
        f154576d = new f();
        f154574b = LazyKt.lazy(EventType$Companion$allEventTypes$2.INSTANCE);
        f154575c = LazyKt.lazy(EventType$Companion$nameToEventMap$2.INSTANCE);
    }

    public EventType(String r100) {
        this.f154577a = r100;
    }
}
