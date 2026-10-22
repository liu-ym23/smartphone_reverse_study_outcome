package A4;

import Y8.h;
import Y8.t;
import android.appwidget.AppWidgetHost;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import h8.C4148a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0003J\r\u0010\u001a\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0003J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R.\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010#\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010+\u001a\n **\u0004\u0018\u00010)0)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"LA4/b;", "", "<init>", "()V", "LY8/t;", "m", "", "flag", "Landroid/appwidget/AppWidgetHostView;", "e", "(Ljava/lang/String;)Landroid/appwidget/AppWidgetHostView;", "pkg", "cls", "", "height", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Landroid/appwidget/AppWidgetHostView;", "appWidgetId", "Landroid/content/ComponentName;", "targetComponent", "l", "(ILandroid/content/ComponentName;)V", "", Const.INTENT_KEY_UMID, "()[I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "k", "(Landroid/view/View;)V", "", "cache", "Ljava/util/Map;", "idCache", "f", "()Ljava/util/Map;", "setIdCache", "(Ljava/util/Map;)V", "Landroid/appwidget/AppWidgetManager;", "kotlin.jvm.PlatformType", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "Landroid/appwidget/AppWidgetHost;", "appWidgetHost", "Landroid/appwidget/AppWidgetHost;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class b {
    private static final int APPWIDGET_HOST_ID = 16392;
    public static final String TAG = "WidgetHolder";
    private AppWidgetHost appWidgetHost;
    private AppWidgetManager appWidgetManager;
    private Map<String, AppWidgetHostView> cache = new LinkedHashMap();
    private Map<String, Integer> idCache = new LinkedHashMap();

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final h<b> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: A4.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return b.g();
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LA4/b$a;", "", "<init>", "()V", "LA4/b;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()LA4/b;", "instance", "", "TAG", "Ljava/lang/String;", "", "APPWIDGET_HOST_ID", "I", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: A4.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final b a() {
            return (b) b.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    public b() {
        ChatCoreSdk chatCoreSdk = ChatCoreSdk.INSTANCE;
        this.appWidgetManager = AppWidgetManager.getInstance(chatCoreSdk.c());
        this.appWidgetHost = new AppWidgetHost(chatCoreSdk.c(), APPWIDGET_HOST_ID);
    }

    public static final b g() {
        return new b();
    }

    public final void c() {
        Iterator<Map.Entry<String, AppWidgetHostView>> it = this.cache.entrySet().iterator();
        while (it.hasNext()) {
            k(it.next().getValue());
        }
        this.cache.clear();
        this.idCache.clear();
    }

    public final int[] d() {
        return this.appWidgetHost.getAppWidgetIds();
    }

    public final AppWidgetHostView e(String flag) {
        p.i(flag, "flag");
        AppWidgetHostView appWidgetHostView = this.cache.get(flag);
        if (appWidgetHostView != null) {
            k(appWidgetHostView);
        }
        return appWidgetHostView;
    }

    public final Map<String, Integer> f() {
        return this.idCache;
    }

    public final AppWidgetHostView h(String flag, String pkg, String cls, int height) {
        p.i(flag, "flag");
        p.i(pkg, "pkg");
        p.i(cls, "cls");
        if (this.cache.containsKey(flag)) {
            AppWidgetHostView appWidgetHostView = this.cache.get(flag);
            p.f(appWidgetHostView);
            k(appWidgetHostView);
            return this.cache.get(flag);
        }
        int iAllocateAppWidgetId = this.appWidgetHost.allocateAppWidgetId();
        C4148a.k(TAG, "newHostView: " + pkg + " " + cls + " height:" + height, false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("newHostView: ");
        sb2.append(iAllocateAppWidgetId);
        C4148a.k(TAG, sb2.toString(), false, 4, null);
        ComponentName componentName = new ComponentName(pkg, cls);
        AppWidgetManager appWidgetManager = this.appWidgetManager;
        p.f(appWidgetManager);
        boolean zBindAppWidgetIdIfAllowed = appWidgetManager.bindAppWidgetIdIfAllowed(iAllocateAppWidgetId, componentName);
        C4148a.k(TAG, "newHostView bind: " + zBindAppWidgetIdIfAllowed, false, 4, null);
        if (!zBindAppWidgetIdIfAllowed) {
            l(iAllocateAppWidgetId, componentName);
            return null;
        }
        AppWidgetManager appWidgetManager2 = this.appWidgetManager;
        p.f(appWidgetManager2);
        AppWidgetHostView appWidgetHostViewCreateView = this.appWidgetHost.createView(ChatCoreSdk.INSTANCE.c(), iAllocateAppWidgetId, appWidgetManager2.getAppWidgetInfo(iAllocateAppWidgetId));
        this.appWidgetHost.startListening();
        appWidgetHostViewCreateView.setPadding(0, 0, 0, 0);
        appWidgetHostViewCreateView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        Map<String, AppWidgetHostView> map = this.cache;
        p.f(appWidgetHostViewCreateView);
        map.put(flag, appWidgetHostViewCreateView);
        this.idCache.put(flag, Integer.valueOf(iAllocateAppWidgetId));
        return appWidgetHostViewCreateView;
    }

    public final void i() {
        int[] iArrD = d();
        String string = Arrays.toString(iArrD);
        p.h(string, "toString(...)");
        C4148a.k(TAG, "deleteWidgetIds: " + string, false, 4, null);
        if (iArrD != null) {
            for (int i10 : iArrD) {
                this.appWidgetHost.deleteAppWidgetId(i10);
            }
        }
        c();
        m();
    }

    public final void j(String flag) {
        Object objB;
        p.i(flag, "flag");
        AppWidgetHostView appWidgetHostViewRemove = this.cache.remove(flag);
        if (appWidgetHostViewRemove != null) {
            k(appWidgetHostViewRemove);
        }
        Integer numRemove = this.idCache.remove(flag);
        if (numRemove != null) {
            int iIntValue = numRemove.intValue();
            try {
                Result.Companion companion = Result.INSTANCE;
                this.appWidgetHost.deleteAppWidgetId(iIntValue);
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.u(TAG, "deleteAppWidgetId failed, widgetId:" + iIntValue + " err:" + thE.getMessage(), false, 4, null);
            }
            Result.a(objB);
        }
    }

    public final void k(View view) {
        p.i(view, "view");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void l(int appWidgetId, ComponentName targetComponent) {
        p.i(targetComponent, "targetComponent");
        C4148a.k(TAG, "request bind widget Permission", false, 4, null);
    }

    public final void m() {
        this.appWidgetHost.stopListening();
    }
}
