package y7;

import A7.C0754w;
import A7.C0757z;
import Z8.C1173v;
import Z8.C1174w;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import z7.C6370e;
import z7.C6375j;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0013\u001a\u00020\r2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001a\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010 \u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00020\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020#8F¢\u0006\u0006\u001a\u0004\b!\u0010$R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00068F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Ly7/E;", "", "Landroid/view/View;", "view", "", "crossWindow", "", "Ly7/E$a;", "entries", "<init>", "(Landroid/view/View;ZLjava/util/List;)V", "", "px", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(F)V", "Lkotlin/Function1;", "LA7/z;", "block", "e", "(Lp9/l;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "LA7/w;", "f", "()LA7/w;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Z", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "viewRef", "c", "Ljava/util/List;", "", "()I", "activeCount", "", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "activeIds", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean crossWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final WeakReference<View> viewRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public List<a> entries;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000e"}, d2 = {"Ly7/E$a;", "", "", "capabilityId", "Ly7/s;", "binding", "<init>", "(Ljava/lang/String;Ly7/s;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "Ly7/s;", "()Ly7/s;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String capabilityId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final s binding;

        public a(String capabilityId, s binding) {
            kotlin.jvm.internal.p.i(capabilityId, "capabilityId");
            kotlin.jvm.internal.p.i(binding, "binding");
            this.capabilityId = capabilityId;
            this.binding = binding;
        }

        /* renamed from: a, reason: from getter */
        public final s getBinding() {
            return this.binding;
        }

        /* renamed from: b, reason: from getter */
        public final String getCapabilityId() {
            return this.capabilityId;
        }
    }

    public E(View view, boolean z10, List<a> entries) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(entries, "entries");
        this.crossWindow = z10;
        this.viewRef = new WeakReference<>(view);
        this.entries = entries;
    }

    public static final Y8.t h(E e10) {
        e10.i();
        return Y8.t.f7040a;
    }

    public final void b(float px) {
        View view = this.viewRef.get();
        if (view == null) {
            return;
        }
        if (this.crossWindow) {
            C6370e.f45191a.q(view, px);
        } else {
            C6375j.f45214a.A(view, px);
        }
    }

    public final int c() {
        return this.entries.size();
    }

    public final List<String> d() {
        List<a> list = this.entries;
        ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((a) it.next()).getCapabilityId());
        }
        return arrayList;
    }

    public final void e(InterfaceC5074l<? super C0757z, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        C0754w c0754wF = f();
        if (c0754wF != null) {
            c0754wF.q(block);
        }
    }

    public final C0754w f() {
        Object next;
        Iterator<T> it = this.entries.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (kotlin.jvm.internal.p.d(((a) next).getCapabilityId(), "glass_text")) {
                break;
            }
        }
        a aVar = (a) next;
        s binding = aVar != null ? aVar.getBinding() : null;
        if (binding instanceof C0754w) {
            return (C0754w) binding;
        }
        return null;
    }

    public final void g() {
        if (this.entries.isEmpty()) {
            return;
        }
        if (this.crossWindow) {
            i();
        } else {
            C6375j.f45214a.o(new InterfaceC5063a() { // from class: y7.D
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return E.h(this.f43871a);
                }
            });
        }
        this.entries = C1173v.m();
    }

    public final void i() {
        for (a aVar : this.entries) {
            try {
                Result.Companion companion = Result.INSTANCE;
                aVar.getBinding().release();
                Result.b(Y8.t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
        }
    }
}
