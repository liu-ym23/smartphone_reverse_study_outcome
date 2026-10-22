package com.bytedance.android.ec.core.anchorv3;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.Printer;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public abstract class BasePdpMessageOptWorker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f43739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f43740g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f43741h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f43742i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f43743j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f43744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Printer f43745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f43746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f43747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Function1<Boolean, Unit>> f43748e;

    public static final class a {
        public a() {
        }

        public static Object b(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$getLifecycleStateRequest");
            if (r100.what == 159) goto L6;
            return null;
        L6:
            if (BasePdpMessageOptWorker.f43739f == null) goto L18;
        L16:
            Field r101 = BasePdpMessageOptWorker.f43739f;     // Catch: Exception -> L15
            if (r101 == null) goto L20;
            return r101.get(r100.obj);
        L20:
            return null;
        L21:
            return null;
        L18:
            Field r102 = r100.obj.getClass().getDeclaredField("mLifecycleStateRequest");     // Catch: Exception -> L9
            r102.setAccessible(true);     // Catch: Exception -> L9
        L10:
            BasePdpMessageOptWorker.f43739f = r102;
        L9:
            r102 = null;
            goto L10
        }

        public static final Message a(a r100, MessageQueue r101) {
            r100.getClass();
            Field r102 = (Field) BasePdpMessageOptWorker.f43740g.getValue();     // Catch: Exception -> L13
            if (r102 == null) goto L6;
            Object r103 = r102.get(r101);     // Catch: Exception -> L13
        L8:
            if ((r103 instanceof Message) == true) goto L10;
            r103 = null;
        L10:
            return (Message) r103;
        L6:
            r103 = null;
        L16:
            return null;
        }
    }

    public static final class b implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasePdpMessageOptWorker f43749a;

        public b(BasePdpMessageOptWorker r100) {
            this.f43749a = r100;
        }

        @Override // android.util.Printer
        public final void println(String r100) {
            Printer r101 = this.f43749a.f43745b;
            if (r101 == null) goto L5;
            r101.println(r100);
        L5:
            Boolean r102 = this.f43749a.f43746c;
            if (r102 != null) goto L8;
            Boolean r103 = Boolean.valueOf(StringsKt.startsWith$default(r100, "<", false, 2, null));
        L9:
            this.f43749a.f43746c = r103;
            if (PdpMessageOpt.f43751a == false) goto L13;
            PdpMessageOpt.e("loopMessage isAfter=" + r103 + ' ' + r100);
        L13:
            if (r103.booleanValue() == false) goto L16;
            this.f43749a.d();
            return;
        L16:
            return;
        L8:
            r103 = Boolean.valueOf(!r102.booleanValue());
            goto L9
        }
    }

    public abstract void a(Object r100);

    public abstract void b();

    public abstract void c(boolean r100);

    public abstract void d();

    public abstract void e(boolean r100);

    public abstract void g();

    public abstract void i();

    static {
        f43743j = new a();
        f43740g = LazyKt.lazy(BasePdpMessageOptWorker$Companion$field_MessageQueue_mMessage$2.INSTANCE);
        f43741h = LazyKt.lazy(BasePdpMessageOptWorker$Companion$field_Message_next$2.INSTANCE);
        f43742i = LazyKt.lazy(BasePdpMessageOptWorker$Companion$field_Looper_mLogging$2.INSTANCE);
    }

    public final void f() {
        if (this.f43747d == true) goto L6;
        this.f43747d = true;
        boolean r100 = PdpMessageOpt.f43751a;
        Intrinsics.checkNotNullParameter("schedule force do frame", "msg");
        ForceDoFrameMessage.a();
        return;
    }

    public final void h() {
        if (this.f43744a == false) goto L5;
        return;
    L5:
        this.f43744a = true;
        a r100 = f43743j;
        Looper r101 = Looper.getMainLooper();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$getCurLogging");
        Printer r102 = null;
        Field r103 = (Field) f43742i.getValue();     // Catch: Exception -> L17
        if (r103 == null) goto L9;
        Object r104 = r103.get(r101);     // Catch: Exception -> L17
    L11:
        if ((r104 instanceof Printer) == true) goto L13;
        r104 = null;
    L13:
        r102 = (Printer) r104;     // Catch: Exception -> L17
        goto L15
    L9:
        r104 = null;
    L15:
        this.f43745b = r102;
        Looper.getMainLooper().setMessageLogging(new b(this));
    }

    public BasePdpMessageOptWorker() {
        this.f43748e = new ArrayList();
    }
}
