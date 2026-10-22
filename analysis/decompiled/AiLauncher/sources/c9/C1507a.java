package c9;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aQ\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "start", "isDaemon", "Ljava/lang/ClassLoader;", "contextClassLoader", "", "name", "", "priority", "Lkotlin/Function0;", "LY8/t;", "block", "Ljava/lang/Thread;", Const.INTENT_KEY_APIKEY, "(ZZLjava/lang/ClassLoader;Ljava/lang/String;ILp9/a;)Ljava/lang/Thread;", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: c9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1507a {

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"c9/a$a", "Ljava/lang/Thread;", "LY8/t;", "run", "()V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: c9.a$a, reason: collision with other inner class name */
    public static final class C0193a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5063a<t> f15495a;

        public C0193a(InterfaceC5063a<t> interfaceC5063a) {
            this.f15495a = interfaceC5063a;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f15495a.invoke();
        }
    }

    public static final Thread a(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, InterfaceC5063a<t> block) {
        p.i(block, "block");
        C0193a c0193a = new C0193a(block);
        if (z11) {
            c0193a.setDaemon(true);
        }
        if (i10 > 0) {
            c0193a.setPriority(i10);
        }
        if (str != null) {
            c0193a.setName(str);
        }
        if (classLoader != null) {
            c0193a.setContextClassLoader(classLoader);
        }
        if (z10) {
            c0193a.start();
        }
        return c0193a;
    }

    public static /* synthetic */ Thread b(boolean z10, boolean z11, ClassLoader classLoader, String str, int i10, InterfaceC5063a interfaceC5063a, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            classLoader = null;
        }
        if ((i11 & 8) != 0) {
            str = null;
        }
        if ((i11 & 16) != 0) {
            i10 = -1;
        }
        int i12 = i10;
        String str2 = str;
        return a(z10, z11, classLoader, str2, i12, interfaceC5063a);
    }
}
