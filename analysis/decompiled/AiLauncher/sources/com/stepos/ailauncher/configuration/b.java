package com.stepos.ailauncher.configuration;

import O6.r;
import Y8.h;
import android.content.ComponentCallbacks;
import android.content.res.Configuration;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.t;
import net.sqlcipher.database.SQLiteDatabase;
import p9.InterfaceC5063a;
import s9.C5449a;
import s9.InterfaceC5453e;
import s9.ObservableProperty;
import w9.InterfaceC5752k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R+\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR+\u0010#\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0016\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR+\u0010'\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR+\u0010+\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001a¨\u0006."}, d2 = {"Lcom/stepos/ailauncher/configuration/b;", "", "<init>", "()V", "Lcom/stepos/ailauncher/configuration/c;", "observer", "LY8/t;", "l", "(Lcom/stepos/ailauncher/configuration/c;)V", "n", "f", "Landroid/content/res/Configuration;", "oldConf", "newConf", "", "m", "(Landroid/content/res/Configuration;Landroid/content/res/Configuration;)Z", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "<set-?>", "uiModeChanged$delegate", "Ls9/e;", "getUiModeChanged", "()Z", "k", "(Z)V", "uiModeChanged", "densityChanged$delegate", "getDensityChanged", Const.INTENT_KEY_BACKGROUND_COMMAND, "densityChanged", "fontScaleChanged$delegate", "getFontScaleChanged", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "fontScaleChanged", "fontWeightChanged$delegate", "getFontWeightChanged", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "fontWeightChanged", "localChanged$delegate", "getLocalChanged", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "localChanged", "Companion", Const.INTENT_KEY_APIKEY, "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final String TAG = "ConfigurationChangedDistributor";

    /* renamed from: densityChanged$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e densityChanged;

    /* renamed from: fontScaleChanged$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fontScaleChanged;

    /* renamed from: fontWeightChanged$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e fontWeightChanged;
    private final CopyOnWriteArrayList<com.stepos.ailauncher.configuration.c> listeners = new CopyOnWriteArrayList<>();

    /* renamed from: localChanged$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e localChanged;

    /* renamed from: uiModeChanged$delegate, reason: from kotlin metadata */
    private final InterfaceC5453e uiModeChanged;
    static final /* synthetic */ InterfaceC5752k<Object>[] $$delegatedProperties = {t.f(new MutablePropertyReference1Impl(b.class, "uiModeChanged", "getUiModeChanged()Z", 0)), t.f(new MutablePropertyReference1Impl(b.class, "densityChanged", "getDensityChanged()Z", 0)), t.f(new MutablePropertyReference1Impl(b.class, "fontScaleChanged", "getFontScaleChanged()Z", 0)), t.f(new MutablePropertyReference1Impl(b.class, "fontWeightChanged", "getFontWeightChanged()Z", 0)), t.f(new MutablePropertyReference1Impl(b.class, "localChanged", "getLocalChanged()Z", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Configuration mCurrentConfiguration = new Configuration(C3197a.INSTANCE.a().getResources().getConfiguration());
    private static final h<b> INSTANCE$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.configuration.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return b.b();
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/configuration/b$a;", "", "<init>", "()V", "Landroid/content/res/Configuration;", "mCurrentConfiguration", "Landroid/content/res/Configuration;", Const.INTENT_KEY_PKGNAME, "()Landroid/content/res/Configuration;", "Lcom/stepos/ailauncher/configuration/b;", "INSTANCE$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/configuration/b;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.configuration.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final b a() {
            return (b) b.INSTANCE$delegate.getValue();
        }

        public final Configuration b() {
            return b.mCurrentConfiguration;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/configuration/b$b", "Landroid/content/ComponentCallbacks;", "Landroid/content/res/Configuration;", "newConfig", "LY8/t;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "onLowMemory", "()V", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.configuration.b$b, reason: collision with other inner class name */
    public static final class ComponentCallbacksC0304b implements ComponentCallbacks {
        public ComponentCallbacksC0304b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            p.i(newConfig, "newConfig");
            Log.d(b.TAG, "onConfigurationChanged");
            Companion companion = b.INSTANCE;
            int iDiff = newConfig.diff(companion.b());
            b bVar = b.this;
            bVar.k(((iDiff & 512) != 0) | bVar.m(companion.b(), newConfig));
            b.this.j((iDiff & 4) != 0);
            b.this.g((iDiff & 4096) != 0);
            b.this.h((1073741824 & iDiff) != 0);
            b.this.i((iDiff & SQLiteDatabase.CREATE_IF_NECESSARY) != 0);
            companion.b().setTo(newConfig);
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            Log.i(b.TAG, "Low memory");
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/configuration/b$c", "Ls9/c;", "Lw9/k;", "property", "oldValue", "newValue", "LY8/t;", "afterChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends ObservableProperty<Boolean> {
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, b bVar) {
            super(obj);
            this.this$0 = bVar;
        }

        @Override // s9.ObservableProperty
        public void afterChange(InterfaceC5752k<?> property, Boolean oldValue, Boolean newValue) {
            p.i(property, "property");
            boolean zBooleanValue = newValue.booleanValue();
            oldValue.getClass();
            if (zBooleanValue) {
                for (com.stepos.ailauncher.configuration.c cVar : this.this$0.listeners) {
                    Log.d(b.TAG, "ui mode changed");
                    if (cVar instanceof com.stepos.ailauncher.configuration.g) {
                        ((com.stepos.ailauncher.configuration.g) cVar).b();
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/configuration/b$d", "Ls9/c;", "Lw9/k;", "property", "oldValue", "newValue", "LY8/t;", "afterChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ObservableProperty<Boolean> {
        public d(Object obj) {
            super(obj);
        }

        @Override // s9.ObservableProperty
        public void afterChange(InterfaceC5752k<?> property, Boolean oldValue, Boolean newValue) {
            p.i(property, "property");
            boolean zBooleanValue = newValue.booleanValue();
            oldValue.getClass();
            if (zBooleanValue) {
                Log.d(b.TAG, "density changed, M2481 reboot");
                System.exit(0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/configuration/b$e", "Ls9/c;", "Lw9/k;", "property", "oldValue", "newValue", "LY8/t;", "afterChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class e extends ObservableProperty<Boolean> {
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj, b bVar) {
            super(obj);
            this.this$0 = bVar;
        }

        @Override // s9.ObservableProperty
        public void afterChange(InterfaceC5752k<?> property, Boolean oldValue, Boolean newValue) {
            p.i(property, "property");
            boolean zBooleanValue = newValue.booleanValue();
            oldValue.getClass();
            if (zBooleanValue) {
                for (com.stepos.ailauncher.configuration.c cVar : this.this$0.listeners) {
                    Log.d(b.TAG, "fontScale changed");
                    if (cVar instanceof com.stepos.ailauncher.configuration.d) {
                        ((com.stepos.ailauncher.configuration.d) cVar).a();
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/configuration/b$f", "Ls9/c;", "Lw9/k;", "property", "oldValue", "newValue", "LY8/t;", "afterChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class f extends ObservableProperty<Boolean> {
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Object obj, b bVar) {
            super(obj);
            this.this$0 = bVar;
        }

        @Override // s9.ObservableProperty
        public void afterChange(InterfaceC5752k<?> property, Boolean oldValue, Boolean newValue) {
            p.i(property, "property");
            boolean zBooleanValue = newValue.booleanValue();
            oldValue.getClass();
            if (zBooleanValue) {
                for (com.stepos.ailauncher.configuration.c cVar : this.this$0.listeners) {
                    Log.d(b.TAG, "fontWeight changed");
                    if (cVar instanceof com.stepos.ailauncher.configuration.e) {
                        ((com.stepos.ailauncher.configuration.e) cVar).d();
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/ailauncher/configuration/b$g", "Ls9/c;", "Lw9/k;", "property", "oldValue", "newValue", "LY8/t;", "afterChange", "(Lw9/k;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends ObservableProperty<Boolean> {
        final /* synthetic */ b this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Object obj, b bVar) {
            super(obj);
            this.this$0 = bVar;
        }

        @Override // s9.ObservableProperty
        public void afterChange(InterfaceC5752k<?> property, Boolean oldValue, Boolean newValue) {
            p.i(property, "property");
            boolean zBooleanValue = newValue.booleanValue();
            oldValue.getClass();
            if (zBooleanValue) {
                for (com.stepos.ailauncher.configuration.c cVar : this.this$0.listeners) {
                    Log.d(b.TAG, "fontScale changed");
                    if (cVar instanceof com.stepos.ailauncher.configuration.f) {
                        ((com.stepos.ailauncher.configuration.f) cVar).c();
                    }
                }
            }
        }
    }

    public b() {
        C5449a c5449a = C5449a.f40169a;
        Boolean bool = Boolean.FALSE;
        this.uiModeChanged = new c(bool, this);
        this.densityChanged = new d(bool);
        this.fontScaleChanged = new e(bool, this);
        this.fontWeightChanged = new f(bool, this);
        this.localChanged = new g(bool, this);
    }

    public static final b b() {
        return new b();
    }

    public final void f() {
        C3197a.INSTANCE.a().registerComponentCallbacks(new ComponentCallbacksC0304b());
        Log.i(TAG, "configuration registered");
    }

    public final void g(boolean z10) {
        this.densityChanged.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z10));
    }

    public final void h(boolean z10) {
        this.fontScaleChanged.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z10));
    }

    public final void i(boolean z10) {
        this.fontWeightChanged.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z10));
    }

    public final void j(boolean z10) {
        this.localChanged.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z10));
    }

    public final void k(boolean z10) {
        this.uiModeChanged.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z10));
    }

    public final void l(com.stepos.ailauncher.configuration.c observer) {
        p.i(observer, "observer");
        if (this.listeners.contains(observer)) {
            return;
        }
        this.listeners.add(observer);
    }

    public final boolean m(Configuration oldConf, Configuration newConf) {
        Object obj;
        Object obj2;
        p.i(oldConf, "oldConf");
        p.i(newConf, "newConf");
        try {
            obj = r.b(oldConf).b("configurationExt").get(oldConf);
            obj2 = r.b(newConf).b("configurationExt").get(newConf);
        } catch (Exception unused) {
        }
        return r.b(obj).b("themeChanged").a(obj) != r.b(obj2).b("themeChanged").a(obj2);
    }

    public final void n(com.stepos.ailauncher.configuration.c observer) {
        p.i(observer, "observer");
        this.listeners.remove(observer);
    }
}
