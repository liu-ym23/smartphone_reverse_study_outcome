package com.stepos.agentframework.chatui.appui;

import La.D;
import La.H;
import Y8.t;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001c*\u00020\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u000b*\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/c;", "", "<init>", "()V", "", "id", "Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "hostView", "LY8/t;", "c", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;)V", "Landroid/content/Context;", "context", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/agentframework/chatui/appui/BaseAppUIHostView;", "k", "(Landroid/content/Context;Ljava/lang/String;)V", "", "liveFlags", "liveSessionIds", "l", "(Landroid/content/Context;Ljava/util/Set;Ljava/util/Set;)V", "e", "(Landroid/content/Context;)V", Const.INTENT_KEY_UMID, "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;)Ljava/lang/String;", "Landroid/app/Activity;", "f", "(Landroid/content/Context;)Landroid/app/Activity;", "m", "(Landroid/content/Context;)Landroid/content/Context;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "TAG", "Ljava/lang/String;", "", "cache", "Ljava/util/Map;", "", "lifecycleWatcherInstalled", "Z", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class c {
    private static final String KEY_SEP = "#";
    private final String TAG = "AppUICache";
    private final Map<String, BaseAppUIHostView> cache = new LinkedHashMap();
    private volatile boolean lifecycleWatcherInstalled;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<c> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.appui.b
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return c.j();
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatui/appui/c$a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/appui/c;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatui/appui/c;", "getInstance$annotations", "instance", "", "KEY_SEP", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.appui.c$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final c a() {
            return (c) c.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"com/stepos/agentframework/chatui/appui/c$b", "Landroid/app/Application$ActivityLifecycleCallbacks;", "Landroid/app/Activity;", "activity", "LY8/t;", "onActivityDestroyed", "(Landroid/app/Activity;)V", "Landroid/os/Bundle;", "savedInstanceState", "onActivityCreated", "(Landroid/app/Activity;Landroid/os/Bundle;)V", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            p.i(activity, "activity");
            c.this.e(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            p.i(activity, "activity");
            p.i(outState, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            p.i(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            p.i(activity, "activity");
        }
    }

    public static final c j() {
        return new c();
    }

    public final void c(String id, BaseAppUIHostView hostView) {
        p.i(id, "id");
        p.i(hostView, "hostView");
        Context context = hostView.getContext();
        p.h(context, "getContext(...)");
        i(context);
        Context context2 = hostView.getContext();
        p.h(context2, "getContext(...)");
        String strD = d(context2, id);
        BaseAppUIHostView baseAppUIHostViewPut = this.cache.put(strD, hostView);
        if (baseAppUIHostViewPut == null || baseAppUIHostViewPut == hostView) {
            return;
        }
        C4148a.k(this.TAG, "addHostView: destroy displaced host key=" + strD, false, 4, null);
        baseAppUIHostViewPut.b();
    }

    public final String d(Context context, String id) {
        return h(context) + "#" + id;
    }

    public final void e(Context context) {
        p.i(context, "context");
        String str = h(context) + "#";
        Iterator<Map.Entry<String, BaseAppUIHostView>> it = this.cache.entrySet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Map.Entry<String, BaseAppUIHostView> next = it.next();
            if (D.X(next.getKey(), str, false, 2, null)) {
                next.getValue().b();
                it.remove();
                i10++;
            }
        }
        if (i10 > 0) {
            C4148a.k(this.TAG, "clearForHost: prefix=" + str + " removed=" + i10 + " remain=" + this.cache.size(), false, 4, null);
        }
    }

    public final Activity f(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final BaseAppUIHostView g(Context context, String id) {
        p.i(context, "context");
        p.i(id, "id");
        return this.cache.get(d(context, id));
    }

    public final String h(Context context) {
        Context contextF = f(context);
        if (contextF == null) {
            contextF = m(context);
        }
        String hexString = Integer.toHexString(System.identityHashCode(contextF));
        p.h(hexString, "toHexString(...)");
        return hexString;
    }

    public final void i(Context context) {
        if (this.lifecycleWatcherInstalled) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application == null) {
            return;
        }
        synchronized (this) {
            if (this.lifecycleWatcherInstalled) {
                return;
            }
            this.lifecycleWatcherInstalled = true;
            application.registerActivityLifecycleCallbacks(new b());
            t tVar = t.f7040a;
        }
    }

    public final void k(Context context, String id) {
        p.i(context, "context");
        p.i(id, "id");
        String strD = d(context, id);
        C4148a.k(this.TAG, "removeHostView: " + strD, false, 4, null);
        this.cache.remove(strD);
    }

    public final void l(Context context, Set<String> liveFlags, Set<String> liveSessionIds) {
        p.i(context, "context");
        p.i(liveFlags, "liveFlags");
        p.i(liveSessionIds, "liveSessionIds");
        String str = h(context) + "#";
        Iterator<Map.Entry<String, BaseAppUIHostView>> it = this.cache.entrySet().iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            Map.Entry<String, BaseAppUIHostView> next = it.next();
            if (D.X(next.getKey(), str, false, 2, null) && !liveFlags.contains(H.p1(next.getKey(), "#", null, 2, null))) {
                BaseAppUIHostView value = next.getValue();
                String chatSessionId = value.getChatSessionId();
                if (chatSessionId.length() <= 0 || !liveSessionIds.contains(chatSessionId)) {
                    if (value.getParent() != null) {
                        i11++;
                    } else {
                        value.b();
                        it.remove();
                        i10++;
                    }
                }
            }
        }
        if (i10 > 0 || i11 > 0) {
            C4148a.k(this.TAG, "retainForHost: prefix=" + str + " removed=" + i10 + " skippedAttached=" + i11 + " live=" + liveFlags.size() + " sessions=" + liveSessionIds.size() + " remain=" + this.cache.size(), false, 4, null);
        }
    }

    public final Context m(Context context) {
        Context baseContext;
        while ((context instanceof ContextWrapper) && (baseContext = ((ContextWrapper) context).getBaseContext()) != null) {
            context = baseContext;
        }
        return context;
    }
}
