package android.view;

import V0.CreationExtras;
import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import android.view.U;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import g1.e;
import g1.h;
import io.ktor.http.ContentType;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o9.C5013a;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ/\u0010\u0011\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0014\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00132\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0018\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001a\u001a\u00028\u0000\"\b\b\u0000\u0010\f*\u00020\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010!R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Landroidx/lifecycle/M;", "Landroidx/lifecycle/U$e;", "Landroidx/lifecycle/U$c;", "Landroid/app/Application;", ContentType.Application.TYPE, "Lg1/h;", "owner", "Landroid/os/Bundle;", "defaultArgs", "<init>", "(Landroid/app/Application;Lg1/h;Landroid/os/Bundle;)V", "Landroidx/lifecycle/Q;", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "modelClass", "LV0/a;", "extras", Const.INTENT_KEY_APIKEY, "(Lw9/d;LV0/a;)Landroidx/lifecycle/Q;", "Ljava/lang/Class;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Class;LV0/a;)Landroidx/lifecycle/Q;", "", "key", "e", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/Q;", "c", "(Ljava/lang/Class;)Landroidx/lifecycle/Q;", "viewModel", "LY8/t;", Const.INTENT_KEY_UMID, "(Landroidx/lifecycle/Q;)V", "Landroid/app/Application;", "Landroidx/lifecycle/U$c;", "factory", "Landroid/os/Bundle;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lg1/e;", "f", "Lg1/e;", "savedStateRegistry", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class M extends U.e implements U.c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Application application;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final U.c factory;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Bundle defaultArgs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Lifecycle lifecycle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public e savedStateRegistry;

    @SuppressLint({"LambdaLast"})
    public M(Application application, h owner, Bundle bundle) {
        p.i(owner, "owner");
        this.savedStateRegistry = owner.getSavedStateRegistry();
        this.lifecycle = owner.getLifecycle();
        this.defaultArgs = bundle;
        this.application = application;
        this.factory = application != null ? U.a.INSTANCE.a(application) : new U.a();
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
        String str = (String) extras.a(U.f14251c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(I.f14182a) == null || extras.a(I.f14183b) == null) {
            if (this.lifecycle != null) {
                return (T) e(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(U.a.f14255h);
        boolean zIsAssignableFrom = C1383a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? N.c(modelClass, N.f14205b) : N.c(modelClass, N.f14204a);
        return constructorC == null ? (T) this.factory.b(modelClass, extras) : (!zIsAssignableFrom || application == null) ? (T) N.d(modelClass, constructorC, I.a(extras)) : (T) N.d(modelClass, constructorC, application, I.a(extras));
    }

    @Override // androidx.lifecycle.U.c
    public <T extends Q> T c(Class<T> modelClass) {
        p.i(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) e(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.U.e
    public void d(Q viewModel) {
        p.i(viewModel, "viewModel");
        if (this.lifecycle != null) {
            e eVar = this.savedStateRegistry;
            p.f(eVar);
            Lifecycle lifecycle = this.lifecycle;
            p.f(lifecycle);
            C1392j.a(viewModel, eVar, lifecycle);
        }
    }

    public final <T extends Q> T e(String key, Class<T> modelClass) {
        T t10;
        Application application;
        p.i(key, "key");
        p.i(modelClass, "modelClass");
        Lifecycle lifecycle = this.lifecycle;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = C1383a.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.application == null) ? N.c(modelClass, N.f14205b) : N.c(modelClass, N.f14204a);
        if (constructorC == null) {
            return this.application != null ? (T) this.factory.c(modelClass) : (T) U.d.INSTANCE.a().c(modelClass);
        }
        e eVar = this.savedStateRegistry;
        p.f(eVar);
        H hB = C1392j.b(eVar, lifecycle, key, this.defaultArgs);
        if (!zIsAssignableFrom || (application = this.application) == null) {
            t10 = (T) N.d(modelClass, constructorC, hB.getHandle());
        } else {
            p.f(application);
            t10 = (T) N.d(modelClass, constructorC, application, hB.getHandle());
        }
        t10.a("androidx.lifecycle.savedstate.vm.tag", hB);
        return t10;
    }
}
