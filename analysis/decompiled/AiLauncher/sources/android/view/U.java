package android.view;

import V0.CreationExtras;
import W0.h;
import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentType;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0005\u0014\u001e\u001f\u0017\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000fJ(\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0087\u0002¢\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u0017\u001a\u00028\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0087\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001d¨\u0006 "}, d2 = {"Landroidx/lifecycle/U;", "", "LV0/c;", "impl", "<init>", "(LV0/c;)V", "Landroidx/lifecycle/V;", "store", "Landroidx/lifecycle/U$c;", "factory", "LV0/a;", "defaultCreationExtras", "(Landroidx/lifecycle/V;Landroidx/lifecycle/U$c;LV0/a;)V", "Landroidx/lifecycle/W;", "owner", "(Landroidx/lifecycle/W;)V", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "modelClass", "c", "(Lw9/d;)Landroidx/lifecycle/Q;", "Ljava/lang/Class;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Class;)Landroidx/lifecycle/Q;", "", "key", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lw9/d;)Landroidx/lifecycle/Q;", "LV0/c;", "e", Const.INTENT_KEY_UMID, "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class U {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    public static final CreationExtras.c<String> f14251c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final V0.c impl;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/U$b;", "", "<init>", "()V", "Landroidx/lifecycle/W;", "owner", "Landroidx/lifecycle/U$c;", "factory", "LV0/a;", "extras", "Landroidx/lifecycle/U;", Const.INTENT_KEY_PKGNAME, "(Landroidx/lifecycle/W;Landroidx/lifecycle/U$c;LV0/a;)Landroidx/lifecycle/U;", "Landroidx/lifecycle/V;", "store", Const.INTENT_KEY_APIKEY, "(Landroidx/lifecycle/V;Landroidx/lifecycle/U$c;LV0/a;)Landroidx/lifecycle/U;", "LV0/a$c;", "", "VIEW_MODEL_KEY", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: androidx.lifecycle.U$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public static /* synthetic */ U c(Companion companion, W w10, c cVar, CreationExtras creationExtras, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                cVar = h.f6590a.b(w10);
            }
            if ((i10 & 4) != 0) {
                creationExtras = h.f6590a.a(w10);
            }
            return companion.b(w10, cVar, creationExtras);
        }

        public final U a(V store, c factory, CreationExtras extras) {
            p.i(store, "store");
            p.i(factory, "factory");
            p.i(extras, "extras");
            return new U(store, factory, extras);
        }

        public final U b(W owner, c factory, CreationExtras extras) {
            p.i(owner, "owner");
            p.i(factory, "factory");
            p.i(extras, "extras");
            return new U(owner.getViewModelStore(), factory, extras);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\r\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000fÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/U$c;", "", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "c", "(Ljava/lang/Class;)Landroidx/lifecycle/Q;", "LV0/a;", "extras", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;LV0/a;)Landroidx/lifecycle/Q;", "Lw9/d;", Const.INTENT_KEY_APIKEY, "(Lw9/d;LV0/a;)Landroidx/lifecycle/Q;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = Companion.f14258a;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/lifecycle/U$c$a;", "", "<init>", "()V", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.lifecycle.U$c$a, reason: from kotlin metadata */
        public static final class Companion {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ Companion f14258a = new Companion();
        }

        default <T extends Q> T a(InterfaceC5745d<T> modelClass, CreationExtras extras) {
            p.i(modelClass, "modelClass");
            p.i(extras, "extras");
            return (T) b(C5013a.b(modelClass), extras);
        }

        default <T extends Q> T b(Class<T> modelClass, CreationExtras extras) {
            p.i(modelClass, "modelClass");
            p.i(extras, "extras");
            return (T) c(modelClass);
        }

        default <T extends Q> T c(Class<T> modelClass) {
            p.i(modelClass, "modelClass");
            return (T) h.f6590a.d();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0005*\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/lifecycle/U$d;", "Landroidx/lifecycle/U$c;", "<init>", "()V", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "c", "(Ljava/lang/Class;)Landroidx/lifecycle/Q;", "LV0/a;", "extras", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;LV0/a;)Landroidx/lifecycle/Q;", "Lw9/d;", Const.INTENT_KEY_APIKEY, "(Lw9/d;LV0/a;)Landroidx/lifecycle/Q;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class d implements c {

        /* renamed from: c, reason: collision with root package name */
        public static d f14260c;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name */
        public static final CreationExtras.c<String> f14261d = U.f14251c;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/lifecycle/U$d$a;", "", "<init>", "()V", "Landroidx/lifecycle/U$d;", Const.INTENT_KEY_APIKEY, "()Landroidx/lifecycle/U$d;", "getInstance$annotations", "instance", "_instance", "Landroidx/lifecycle/U$d;", "LV0/a$c;", "", "VIEW_MODEL_KEY", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.lifecycle.U$d$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final d a() {
                if (d.f14260c == null) {
                    d.f14260c = new d();
                }
                d dVar = d.f14260c;
                p.f(dVar);
                return dVar;
            }

            public Companion() {
            }
        }

        @Override // androidx.lifecycle.U.c
        public <T extends Q> T a(InterfaceC5745d<T> modelClass, CreationExtras extras) {
            p.i(modelClass, "modelClass");
            p.i(extras, "extras");
            return (T) b(C5013a.b(modelClass), extras);
        }

        @Override // androidx.lifecycle.U.c
        public <T extends Q> T b(Class<T> modelClass, CreationExtras extras) {
            p.i(modelClass, "modelClass");
            p.i(extras, "extras");
            return (T) c(modelClass);
        }

        @Override // androidx.lifecycle.U.c
        public <T extends Q> T c(Class<T> modelClass) {
            p.i(modelClass, "modelClass");
            return (T) W0.e.f6585a.a(modelClass);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/lifecycle/U$e;", "", "<init>", "()V", "Landroidx/lifecycle/Q;", "viewModel", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroidx/lifecycle/Q;)V", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class e {
        public void d(Q viewModel) {
            p.i(viewModel, "viewModel");
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"androidx/lifecycle/U$f", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements CreationExtras.c<String> {
    }

    static {
        CreationExtras.Companion companion = CreationExtras.INSTANCE;
        f14251c = new f();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public U(V store, c factory) {
        this(store, factory, null, 4, null);
        p.i(store, "store");
        p.i(factory, "factory");
    }

    public <T extends Q> T a(Class<T> modelClass) {
        p.i(modelClass, "modelClass");
        return (T) c(C5013a.e(modelClass));
    }

    public final <T extends Q> T b(String key, InterfaceC5745d<T> modelClass) {
        p.i(key, "key");
        p.i(modelClass, "modelClass");
        return (T) this.impl.d(modelClass, key);
    }

    public final <T extends Q> T c(InterfaceC5745d<T> modelClass) {
        p.i(modelClass, "modelClass");
        return (T) V0.c.e(this.impl, modelClass, null, 2, null);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tJ/\u0010\u0010\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0015\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Landroidx/lifecycle/U$a;", "Landroidx/lifecycle/U$d;", "Landroid/app/Application;", ContentType.Application.TYPE, "", "unused", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "modelClass", "LV0/a;", "extras", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;LV0/a;)Landroidx/lifecycle/Q;", "c", "(Ljava/lang/Class;)Landroidx/lifecycle/Q;", "app", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/Q;", "e", "Landroid/app/Application;", "f", Const.INTENT_KEY_APIKEY, "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class a extends d {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: g, reason: collision with root package name */
        public static a f14254g;

        /* renamed from: h, reason: collision with root package name */
        public static final CreationExtras.c<Application> f14255h;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final Application application;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/U$a$a;", "", "<init>", "()V", "Landroid/app/Application;", ContentType.Application.TYPE, "Landroidx/lifecycle/U$a;", Const.INTENT_KEY_APIKEY, "(Landroid/app/Application;)Landroidx/lifecycle/U$a;", "_instance", "Landroidx/lifecycle/U$a;", "LV0/a$c;", "APPLICATION_KEY", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* renamed from: androidx.lifecycle.U$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(i iVar) {
                this();
            }

            public final a a(Application application) {
                p.i(application, "application");
                if (a.f14254g == null) {
                    a.f14254g = new a(application);
                }
                a aVar = a.f14254g;
                p.f(aVar);
                return aVar;
            }

            public Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"androidx/lifecycle/U$a$b", "LV0/a$c;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class b implements CreationExtras.c<Application> {
        }

        static {
            CreationExtras.Companion companion = CreationExtras.INSTANCE;
            f14255h = new b();
        }

        public a(Application application, int i10) {
            this.application = application;
        }

        @Override // androidx.lifecycle.U.d, androidx.lifecycle.U.c
        public <T extends Q> T b(Class<T> modelClass, CreationExtras extras) {
            p.i(modelClass, "modelClass");
            p.i(extras, "extras");
            if (this.application != null) {
                return (T) c(modelClass);
            }
            Application application = (Application) extras.a(f14255h);
            if (application != null) {
                return (T) h(modelClass, application);
            }
            if (C1383a.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.c(modelClass);
        }

        @Override // androidx.lifecycle.U.d, androidx.lifecycle.U.c
        public <T extends Q> T c(Class<T> modelClass) {
            p.i(modelClass, "modelClass");
            Application application = this.application;
            if (application != null) {
                return (T) h(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        public final <T extends Q> T h(Class<T> modelClass, Application app) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            if (!C1383a.class.isAssignableFrom(modelClass)) {
                return (T) super.c(modelClass);
            }
            try {
                T tNewInstance = modelClass.getConstructor(Application.class).newInstance(app);
                p.f(tNewInstance);
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e13);
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Application application) {
            this(application, 0);
            p.i(application, "application");
        }
    }

    public U(V0.c cVar) {
        this.impl = cVar;
    }

    public /* synthetic */ U(V v10, c cVar, CreationExtras creationExtras, int i10, i iVar) {
        this(v10, cVar, (i10 & 4) != 0 ? CreationExtras.b.f6465c : creationExtras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public U(V store, c factory, CreationExtras defaultCreationExtras) {
        this(new V0.c(store, factory, defaultCreationExtras));
        p.i(store, "store");
        p.i(factory, "factory");
        p.i(defaultCreationExtras, "defaultCreationExtras");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public U(W owner) {
        p.i(owner, "owner");
        V viewModelStore = owner.getViewModelStore();
        h hVar = h.f6590a;
        this(viewModelStore, hVar.b(owner), hVar.a(owner));
    }
}
