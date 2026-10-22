package com.obric.autogui.vdplayer.api.virtualdisplay;

import android.view.MotionEvent;
import com.obric.autogui.common.api.space.monitor.DisplayHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: IVirtualDisplayApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IVirtualDisplayApi {

    /* JADX INFO: compiled from: IVirtualDisplayApi.kt */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f31710a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f31711b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ a[] f31712c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f31713d = null;

        private static final /* synthetic */ a[] a() {
            return new a[]{f31710a, f31711b};
        }

        private a(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f31710a = new a("INVISIBLE", 0);
            f31711b = new a("INOPERABLE", 1);
            a[] r0 = a();
            f31712c = r0;
            f31713d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f31712c.clone(), a[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IVirtualDisplayApi.kt */
    public interface b {
        void a();

        void a(MotionEvent r1);

        void b();

        void c();

        void d();

        void e();
    }

    void bind(DisplayHost r1);

    boolean enableCallUser(boolean r1, DisplayHost r2, b r3);

    int getCurrentRotation();

    boolean getIsSecureLayer();

    a getSecureCoverHint();

    int getStatusBarAppearance();

    void mute(boolean r1);

    void registerSecureChangedListener(d.h.a.b<? super Boolean, x> r1);

    void registerStatusBarAppearanceListener(d.h.a.b<? super Integer, x> r1);

    void unbind(DisplayHost r1);

    void unregisterListeners();
}
