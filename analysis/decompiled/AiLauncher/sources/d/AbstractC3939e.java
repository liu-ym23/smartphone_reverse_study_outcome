package d;

import Ka.t;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.InterfaceC1395m;
import android.view.Lifecycle;
import android.view.LifecycleOwner;
import androidx.activity.result.ActivityResult;
import com.autonavi.aps.amapapi.config.Const;
import e.AbstractC3969a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import kotlin.random.Random;
import p9.InterfaceC5063a;
import x0.C5841b;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\b&\u0018\u0000 .2\u00020\u0001:\u00037=:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\n\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000bH'¢\u0006\u0004\b\u000e\u0010\u000fJQ\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\u0017\u0010\u0018JI\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\"\u0010 J)\u0010'\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$H\u0007¢\u0006\u0004\b'\u0010(J%\u0010*\u001a\u00020&\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010)\u001a\u00028\u0000H\u0007¢\u0006\u0004\b*\u0010+J?\u0010.\u001a\u00020\r\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010$2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b0\u0010\u001cJ\u000f\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b1\u00102J\u001f\u00104\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u00105R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0010068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0006068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020<068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u00108R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00100?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\b\u0012\u0006\u0012\u0002\b\u00030,068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00108R\"\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u00108R\u0014\u0010F\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010E¨\u0006G"}, d2 = {"Ld/e;", "", "<init>", "()V", "I", "O", "", "requestCode", "Le/a;", "contract", "input", "Landroidx/core/app/c;", "options", "LY8/t;", "k", "(ILe/a;Ljava/lang/Object;Landroidx/core/app/c;)V", "", "key", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Ld/a;", "callback", "Ld/b;", "n", "(Ljava/lang/String;Landroidx/lifecycle/LifecycleOwner;Le/a;Ld/a;)Ld/b;", "o", "(Ljava/lang/String;Le/a;Ld/a;)Ld/b;", "r", "(Ljava/lang/String;)V", "Landroid/os/Bundle;", "outState", "m", "(Landroid/os/Bundle;)V", "savedInstanceState", "l", "resultCode", "Landroid/content/Intent;", "data", "", "f", "(IILandroid/content/Intent;)Z", "result", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ILjava/lang/Object;)Z", "Ld/e$a;", "callbackAndContract", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;ILandroid/content/Intent;Ld/e$a;)V", "q", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()I", "rc", "e", "(ILjava/lang/String;)V", "", Const.INTENT_KEY_APIKEY, "Ljava/util/Map;", "rcToKey", Const.INTENT_KEY_PKGNAME, "keyToRc", "Ld/e$c;", "c", "keyToLifecycleContainers", "", Const.INTENT_KEY_UMID, "Ljava/util/List;", "launchedKeys", "keyToCallback", "parsedPendingResults", "Landroid/os/Bundle;", "pendingResults", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: d.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3939e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Map<Integer, String> rcToKey = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Integer> keyToRc = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Map<String, c> keyToLifecycleContainers = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<String> launchedKeys = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final transient Map<String, a<?>> keyToCallback = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<String, Object> parsedPendingResults = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Bundle pendingResults = new Bundle();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR!\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e¨\u0006\u000f"}, d2 = {"Ld/e$a;", "O", "", "Ld/a;", "callback", "Le/a;", "contract", "<init>", "(Ld/a;Le/a;)V", Const.INTENT_KEY_APIKEY, "Ld/a;", "()Ld/a;", Const.INTENT_KEY_PKGNAME, "Le/a;", "()Le/a;", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: d.e$a */
    public static final class a<O> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC3935a<O> callback;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final AbstractC3969a<?, O> contract;

        public a(InterfaceC3935a<O> callback, AbstractC3969a<?, O> contract) {
            p.i(callback, "callback");
            p.i(contract, "contract");
            this.callback = callback;
            this.contract = contract;
        }

        public final InterfaceC3935a<O> a() {
            return this.callback;
        }

        public final AbstractC3969a<?, O> b() {
            return this.contract;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011¨\u0006\u0013"}, d2 = {"Ld/e$c;", "", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "<init>", "(Landroidx/lifecycle/Lifecycle;)V", "Landroidx/lifecycle/m;", "observer", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/m;)V", Const.INTENT_KEY_PKGNAME, "()V", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "", "Ljava/util/List;", "observers", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: d.e$c */
    public static final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Lifecycle lifecycle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final List<InterfaceC1395m> observers;

        public c(Lifecycle lifecycle) {
            p.i(lifecycle, "lifecycle");
            this.lifecycle = lifecycle;
            this.observers = new ArrayList();
        }

        public final void a(InterfaceC1395m observer) {
            p.i(observer, "observer");
            this.lifecycle.a(observer);
            this.observers.add(observer);
        }

        public final void b() {
            Iterator<T> it = this.observers.iterator();
            while (it.hasNext()) {
                this.lifecycle.d((InterfaceC1395m) it.next());
            }
            this.observers.clear();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"d/e$d", "Ld/b;", "input", "Landroidx/core/app/c;", "options", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Landroidx/core/app/c;)V", "c", "()V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: d.e$d */
    public static final class d<I> extends AbstractC3936b<I> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32043b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC3969a<I, O> f32044c;

        public d(String str, AbstractC3969a<I, O> abstractC3969a) {
            this.f32043b = str;
            this.f32044c = abstractC3969a;
        }

        @Override // d.AbstractC3936b
        public void b(I input, androidx.core.app.c options) throws Exception {
            Object obj = AbstractC3939e.this.keyToRc.get(this.f32043b);
            Object obj2 = this.f32044c;
            if (obj != null) {
                int iIntValue = ((Number) obj).intValue();
                AbstractC3939e.this.launchedKeys.add(this.f32043b);
                try {
                    AbstractC3939e.this.k(iIntValue, this.f32044c, input, options);
                    return;
                } catch (Exception e10) {
                    AbstractC3939e.this.launchedKeys.remove(this.f32043b);
                    throw e10;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj2 + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // d.AbstractC3936b
        public void c() {
            AbstractC3939e.this.r(this.f32043b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"d/e$e", "Ld/b;", "input", "Landroidx/core/app/c;", "options", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;Landroidx/core/app/c;)V", "c", "()V", "activity_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: d.e$e, reason: collision with other inner class name */
    public static final class C0383e<I> extends AbstractC3936b<I> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f32046b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC3969a<I, O> f32047c;

        public C0383e(String str, AbstractC3969a<I, O> abstractC3969a) {
            this.f32046b = str;
            this.f32047c = abstractC3969a;
        }

        @Override // d.AbstractC3936b
        public void b(I input, androidx.core.app.c options) throws Exception {
            Object obj = AbstractC3939e.this.keyToRc.get(this.f32046b);
            Object obj2 = this.f32047c;
            if (obj != null) {
                int iIntValue = ((Number) obj).intValue();
                AbstractC3939e.this.launchedKeys.add(this.f32046b);
                try {
                    AbstractC3939e.this.k(iIntValue, this.f32047c, input, options);
                    return;
                } catch (Exception e10) {
                    AbstractC3939e.this.launchedKeys.remove(this.f32046b);
                    throw e10;
                }
            }
            throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + obj2 + " and input " + input + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
        }

        @Override // d.AbstractC3936b
        public void c() {
            AbstractC3939e.this.r(this.f32046b);
        }
    }

    public static final Integer j() {
        return Integer.valueOf(Random.INSTANCE.g(2147418112) + 65536);
    }

    public static final void p(AbstractC3939e abstractC3939e, String str, InterfaceC3935a interfaceC3935a, AbstractC3969a abstractC3969a, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        p.i(lifecycleOwner, "<unused var>");
        p.i(event, "event");
        if (Lifecycle.Event.ON_START != event) {
            if (Lifecycle.Event.ON_STOP == event) {
                abstractC3939e.keyToCallback.remove(str);
                return;
            } else {
                if (Lifecycle.Event.ON_DESTROY == event) {
                    abstractC3939e.r(str);
                    return;
                }
                return;
            }
        }
        abstractC3939e.keyToCallback.put(str, new a<>(interfaceC3935a, abstractC3969a));
        if (abstractC3939e.parsedPendingResults.containsKey(str)) {
            Object obj = abstractC3939e.parsedPendingResults.get(str);
            abstractC3939e.parsedPendingResults.remove(str);
            interfaceC3935a.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) C5841b.a(abstractC3939e.pendingResults, str, ActivityResult.class);
        if (activityResult != null) {
            abstractC3939e.pendingResults.remove(str);
            interfaceC3935a.a(abstractC3969a.c(activityResult.getResultCode(), activityResult.getData()));
        }
    }

    public final void e(int rc2, String key) {
        this.rcToKey.put(Integer.valueOf(rc2), key);
        this.keyToRc.put(key, Integer.valueOf(rc2));
    }

    public final boolean f(int requestCode, int resultCode, Intent data) {
        String str = this.rcToKey.get(Integer.valueOf(requestCode));
        if (str == null) {
            return false;
        }
        h(str, resultCode, data, this.keyToCallback.get(str));
        return true;
    }

    public final <O> boolean g(int requestCode, O result) {
        String str = this.rcToKey.get(Integer.valueOf(requestCode));
        if (str == null) {
            return false;
        }
        a<?> aVar = this.keyToCallback.get(str);
        if ((aVar != null ? aVar.a() : null) == null) {
            this.pendingResults.remove(str);
            this.parsedPendingResults.put(str, result);
            return true;
        }
        InterfaceC3935a<?> interfaceC3935aA = aVar.a();
        p.g(interfaceC3935aA, "null cannot be cast to non-null type androidx.activity.result.ActivityResultCallback<O of androidx.activity.result.ActivityResultRegistry.dispatchResult>");
        if (!this.launchedKeys.remove(str)) {
            return true;
        }
        interfaceC3935aA.a(result);
        return true;
    }

    public final <O> void h(String key, int resultCode, Intent data, a<O> callbackAndContract) {
        if ((callbackAndContract != null ? callbackAndContract.a() : null) == null || !this.launchedKeys.contains(key)) {
            this.parsedPendingResults.remove(key);
            this.pendingResults.putParcelable(key, new ActivityResult(resultCode, data));
        } else {
            callbackAndContract.a().a(callbackAndContract.b().c(resultCode, data));
            this.launchedKeys.remove(key);
        }
    }

    public final int i() {
        for (Number number : t.r(new InterfaceC5063a() { // from class: d.d
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AbstractC3939e.j();
            }
        })) {
            if (!this.rcToKey.containsKey(Integer.valueOf(number.intValue()))) {
                return number.intValue();
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public abstract <I, O> void k(int requestCode, AbstractC3969a<I, O> contract, I input, androidx.core.app.c options);

    public final void l(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = savedInstanceState.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        ArrayList<String> stringArrayList2 = savedInstanceState.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        if (stringArrayList2 != null) {
            this.launchedKeys.addAll(stringArrayList2);
        }
        Bundle bundle = savedInstanceState.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
        if (bundle != null) {
            this.pendingResults.putAll(bundle);
        }
        int size = stringArrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            String str = stringArrayList.get(i10);
            if (this.keyToRc.containsKey(str)) {
                Integer numRemove = this.keyToRc.remove(str);
                if (!this.pendingResults.containsKey(str)) {
                    z.d(this.rcToKey).remove(numRemove);
                }
            }
            Integer num = integerArrayList.get(i10);
            p.h(num, "get(...)");
            int iIntValue = num.intValue();
            String str2 = stringArrayList.get(i10);
            p.h(str2, "get(...)");
            e(iIntValue, str2);
        }
    }

    public final void m(Bundle outState) {
        p.i(outState, "outState");
        outState.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.keyToRc.values()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.keyToRc.keySet()));
        outState.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.launchedKeys));
        outState.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(this.pendingResults));
    }

    public final <I, O> AbstractC3936b<I> n(final String key, LifecycleOwner lifecycleOwner, final AbstractC3969a<I, O> contract, final InterfaceC3935a<O> callback) {
        p.i(key, "key");
        p.i(lifecycleOwner, "lifecycleOwner");
        p.i(contract, "contract");
        p.i(callback, "callback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getState().isAtLeast(Lifecycle.State.STARTED)) {
            throw new IllegalStateException(("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.getState() + ". LifecycleOwners must call register before they are STARTED.").toString());
        }
        q(key);
        c cVar = this.keyToLifecycleContainers.get(key);
        if (cVar == null) {
            cVar = new c(lifecycle);
        }
        cVar.a(new InterfaceC1395m() { // from class: d.c
            @Override // android.view.InterfaceC1395m
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                AbstractC3939e.p(this.f32026a, key, callback, contract, lifecycleOwner2, event);
            }
        });
        this.keyToLifecycleContainers.put(key, cVar);
        return new d(key, contract);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> AbstractC3936b<I> o(String key, AbstractC3969a<I, O> contract, InterfaceC3935a<O> callback) {
        p.i(key, "key");
        p.i(contract, "contract");
        p.i(callback, "callback");
        q(key);
        this.keyToCallback.put(key, new a<>(callback, contract));
        if (this.parsedPendingResults.containsKey(key)) {
            Object obj = this.parsedPendingResults.get(key);
            this.parsedPendingResults.remove(key);
            callback.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) C5841b.a(this.pendingResults, key, ActivityResult.class);
        if (activityResult != null) {
            this.pendingResults.remove(key);
            callback.a(contract.c(activityResult.getResultCode(), activityResult.getData()));
        }
        return new C0383e(key, contract);
    }

    public final void q(String key) {
        if (this.keyToRc.get(key) != null) {
            return;
        }
        e(i(), key);
    }

    public final void r(String key) {
        Integer numRemove;
        p.i(key, "key");
        if (!this.launchedKeys.contains(key) && (numRemove = this.keyToRc.remove(key)) != null) {
            this.rcToKey.remove(numRemove);
        }
        this.keyToCallback.remove(key);
        if (this.parsedPendingResults.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + this.parsedPendingResults.get(key));
            this.parsedPendingResults.remove(key);
        }
        if (this.pendingResults.containsKey(key)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + key + ": " + ((ActivityResult) C5841b.a(this.pendingResults, key, ActivityResult.class)));
            this.pendingResults.remove(key);
        }
        c cVar = this.keyToLifecycleContainers.get(key);
        if (cVar != null) {
            cVar.b();
            this.keyToLifecycleContainers.remove(key);
        }
    }
}
