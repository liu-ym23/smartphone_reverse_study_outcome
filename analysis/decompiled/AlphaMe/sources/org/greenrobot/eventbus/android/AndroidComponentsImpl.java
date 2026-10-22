package org.greenrobot.eventbus.android;

import X.r;
import Z2.I;
import h3.C0611u;
import m3.h;

/* loaded from: classes2.dex */
public class AndroidComponentsImpl {

    /* renamed from: c, reason: collision with root package name */
    public static final AndroidComponentsImpl f13811c;

    /* renamed from: a, reason: collision with root package name */
    public final h f13812a;

    /* renamed from: b, reason: collision with root package name */
    public final C0611u f13813b;

    static {
        AndroidComponentsImpl androidComponentsImpl = null;
        if (I.v()) {
            try {
                androidComponentsImpl = (AndroidComponentsImpl) AndroidComponentsImpl.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
            }
        }
        f13811c = androidComponentsImpl;
    }

    public AndroidComponentsImpl() {
        r rVar = new r("EventBus", 5);
        C0611u c0611u = new C0611u(17);
        this.f13812a = rVar;
        this.f13813b = c0611u;
    }
}
