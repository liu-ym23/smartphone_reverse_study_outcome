package androidx.lifecycle;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import androidx.lifecycle.viewmodel.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u0000 !2\u00020\u0001:\u0005\u001d\u001e\u001f !B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B#\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0004\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u0004\u0010\u000fB\u0019\b\u0016\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u0010J&\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0087\u0002¢\u0006\u0002\u0010\u0016J&\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0002¢\u0006\u0002\u0010\u0018J.\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0015H\u0087\u0002¢\u0006\u0002\u0010\u001bJ.\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0096\u0002¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/lifecycle/ViewModelProvider;", "", "impl", "Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;", "<init>", "(Landroidx/lifecycle/viewmodel/ViewModelProviderImpl;)V", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Landroidx/lifecycle/ViewModelStore;Landroidx/lifecycle/ViewModelProvider$Factory;Landroidx/lifecycle/viewmodel/CreationExtras;)V", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "(Landroidx/lifecycle/ViewModelStoreOwner;Landroidx/lifecycle/ViewModelProvider$Factory;)V", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Landroidx/lifecycle/ViewModel;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Factory", "OnRequeryFactory", "NewInstanceFactory", "AndroidViewModelFactory", "Companion", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class ViewModelProvider {
    public static final Companion Companion = null;
    public static final CreationExtras.Key<String> VIEW_MODEL_KEY = null;
    private final ViewModelProviderImpl impl;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tJ-\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011J%\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016¢\u0006\u0002\u0010\u0012J-\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "application", "Landroid/app/Application;", "unused", "", "<init>", "(Landroid/app/Application;I)V", "()V", "(Landroid/app/Application;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app", "(Ljava/lang/Class;Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        public static final CreationExtras.Key<Application> APPLICATION_KEY = null;
        public static final Companion Companion = null;
        private static AndroidViewModelFactory _instance;
        private final Application application;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory$Companion;", "", "<init>", "()V", "_instance", "Landroidx/lifecycle/ViewModelProvider$AndroidViewModelFactory;", "getInstance", "application", "Landroid/app/Application;", "APPLICATION_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public final AndroidViewModelFactory getInstance(Application r100) {
                Intrinsics.checkNotNullParameter(r100, "application");
                if (AndroidViewModelFactory.access$get_instance$cp() != null) goto L5;
                AndroidViewModelFactory.access$set_instance$cp(new AndroidViewModelFactory(r100));
            L5:
                AndroidViewModelFactory r101 = AndroidViewModelFactory.access$get_instance$cp();
                Intrinsics.checkNotNull(r101);
                return r101;
            }
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        @JvmStatic
        public static final AndroidViewModelFactory getInstance(Application r100) {
            return Companion.getInstance(r100);
        }

        static {
            Companion = new Companion(null);
            CreationExtras.Companion r100 = CreationExtras.Companion;
            APPLICATION_KEY = new ViewModelProvider$AndroidViewModelFactory$special$$inlined$Key$1();
        }

        public static final /* synthetic */ AndroidViewModelFactory access$get_instance$cp() {
            return _instance;
        }

        public AndroidViewModelFactory(Application r100) {
            Intrinsics.checkNotNullParameter(r100, "application");
            this(r100, 0);
        }

        public static final /* synthetic */ void access$set_instance$cp(AndroidViewModelFactory r100) {
            _instance = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            Application r101 = this.application;
            if (r101 == null) goto L7;
            return (T) create(r100, r101);
        L7:
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        private AndroidViewModelFactory(Application r100, int r101) {
            this.application = r100;
        }

        private final <T extends ViewModel> T create(Class<T> r100, Application r101) {
            if (AndroidViewModel.class.isAssignableFrom(r100) == false) goto L20;
            T r102 = r100.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{r101});     // Catch: InvocationTargetException -> L7 InstantiationException -> L10 IllegalAccessException -> L13 NoSuchMethodException -> L16
            Intrinsics.checkNotNull(r102);
            return r102;
        L13:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r100, e);
        L10:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r100, e);
        L16:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r100, e);
        L7:
            e = move-exception;
            throw new RuntimeException("Cannot create an instance of " + r100, e);
        L20:
            return (T) super.create(r100);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r100, CreationExtras r101) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            Intrinsics.checkNotNullParameter(r101, "extras");
            if (this.application != null) goto L14;
            Application r102 = (Application) r101.get(APPLICATION_KEY);
            if (r102 == null) goto L9;
            return (T) create(r100, r102);
        L9:
            if (AndroidViewModel.class.isAssignableFrom(r100) == true) goto L13;
            return (T) super.create(r100);
        L13:
            throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
        L14:
            return (T) create(r100);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Companion;", "", "<init>", "()V", "create", "Landroidx/lifecycle/ViewModelProvider;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", ComplianceConstants.ComplianceRequest.MARKET_STORE, "Landroidx/lifecycle/ViewModelStore;", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final ViewModelProvider create(ViewModelStoreOwner r100, Factory r101, CreationExtras r102) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            Intrinsics.checkNotNullParameter(r101, "factory");
            Intrinsics.checkNotNullParameter(r102, "extras");
            return new ViewModelProvider(r100.getViewModelStore(), r101, r102);
        }

        @JvmStatic
        public final ViewModelProvider create(ViewModelStore r100, Factory r101, CreationExtras r102) {
            Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
            Intrinsics.checkNotNullParameter(r101, "factory");
            Intrinsics.checkNotNullParameter(r102, "extras");
            return new ViewModelProvider(r100, r101, r102);
        }

        public static /* synthetic */ ViewModelProvider create$default(Companion r100, ViewModelStoreOwner r101, Factory r102, CreationExtras r103, int r104, Object r105) {
            if ((r104 & 2) == 0) goto L6;
            r102 = androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE.getDefaultFactory$lifecycle_viewmodel(r101);
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel(r101);
        L9:
            return r100.create(r101, r102, r103);
        }

        public static /* synthetic */ ViewModelProvider create$default(Companion r100, ViewModelStore r101, Factory r102, CreationExtras r103, int r104, Object r105) {
            if ((r104 & 2) == 0) goto L6;
            r102 = DefaultViewModelProviderFactory.INSTANCE;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = CreationExtras.Empty.INSTANCE;
        L9:
            return r100.create(r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ%\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\u0016¢\u0006\u0002\u0010\u0007J-\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\nJ-\u0010\u0002\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory;", "", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Factory {
        public static final Companion Companion = null;

        /* JADX INFO: renamed from: androidx.lifecycle.ViewModelProvider$Factory$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            static {
                Companion r100 = Factory.Companion;
            }

            @JvmStatic
            public static Factory from(ViewModelInitializer<?>... r100) {
                return Factory.Companion.from(r100);
            }

            public static ViewModel $default$create(Factory r100, Class r101) {
                Intrinsics.checkNotNullParameter(r101, "modelClass");
                return androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE.unsupportedCreateViewModel$lifecycle_viewmodel();
            }

            public static ViewModel $default$create(Factory r100, KClass r101, CreationExtras r102) {
                Intrinsics.checkNotNullParameter(r101, "modelClass");
                Intrinsics.checkNotNullParameter(r102, "extras");
                return r100.create(JvmClassMappingKt.getJavaClass(r101), r102);
            }

            public static ViewModel $default$create(Factory r100, Class r101, CreationExtras r102) {
                Intrinsics.checkNotNullParameter(r101, "modelClass");
                Intrinsics.checkNotNullParameter(r102, "extras");
                return r100.create(r101);
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\b0\u0007\"\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$Factory$Companion;", "", "<init>", "()V", "from", "Landroidx/lifecycle/ViewModelProvider$Factory;", "initializers", "", "Landroidx/lifecycle/viewmodel/ViewModelInitializer;", "([Landroidx/lifecycle/viewmodel/ViewModelInitializer;)Landroidx/lifecycle/ViewModelProvider$Factory;", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            static {
                $$INSTANCE = new Companion();
            }

            private Companion() {
            }

            @JvmStatic
            public final Factory from(ViewModelInitializer<?>... r100) {
                Intrinsics.checkNotNullParameter(r100, "initializers");
                return androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel((ViewModelInitializer[]) Arrays.copyOf(r100, r100.length));
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }

        <T extends ViewModel> T create(Class<T> r100);

        <T extends ViewModel> T create(Class<T> r100, CreationExtras r101);

        <T extends ViewModel> T create(KClass<T> r100, CreationExtras r101);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\bH\u0016¢\u0006\u0002\u0010\tJ-\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ-\u0010\u0004\u001a\u0002H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00050\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "extras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "(Ljava/lang/Class;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Landroidx/lifecycle/viewmodel/CreationExtras;)Landroidx/lifecycle/ViewModel;", "Companion", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = null;
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = null;
        private static NewInstanceFactory _instance;

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00058GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory$Companion;", "", "<init>", "()V", "_instance", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "instance", "getInstance$annotations", "getInstance", "()Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "VIEW_MODEL_KEY", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            @JvmStatic
            public static /* synthetic */ void getInstance$annotations() {
            }

            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.access$get_instance$cp() != null) goto L5;
                NewInstanceFactory.access$set_instance$cp(new NewInstanceFactory());
            L5:
                NewInstanceFactory r100 = NewInstanceFactory.access$get_instance$cp();
                Intrinsics.checkNotNull(r100);
                return r100;
            }
        }

        public NewInstanceFactory() {
        }

        public static final NewInstanceFactory getInstance() {
            return Companion.getInstance();
        }

        static {
            Companion = new Companion(null);
            VIEW_MODEL_KEY = ViewModelProvider.VIEW_MODEL_KEY;
        }

        public static final /* synthetic */ NewInstanceFactory access$get_instance$cp() {
            return _instance;
        }

        public static final /* synthetic */ void access$set_instance$cp(NewInstanceFactory r100) {
            _instance = r100;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            return (T) JvmViewModelProviders.INSTANCE.createViewModel(r100);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(KClass<T> r100, CreationExtras r101) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            Intrinsics.checkNotNullParameter(r101, "extras");
            return (T) create(JvmClassMappingKt.getJavaClass(r100), r101);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> r100, CreationExtras r101) {
            Intrinsics.checkNotNullParameter(r100, "modelClass");
            Intrinsics.checkNotNullParameter(r101, "extras");
            return (T) create(r100);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Landroidx/lifecycle/ViewModelProvider$OnRequeryFactory;", "", "<init>", "()V", "onRequery", "", "viewModel", "Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class OnRequeryFactory {
        public OnRequeryFactory() {
        }

        public void onRequery(ViewModel r100) {
            Intrinsics.checkNotNullParameter(r100, "viewModel");
        }
    }

    public ViewModelProvider(ViewModelStore r100, Factory r101) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "factory");
        this(r100, r101, null, 4, null);
    }

    @JvmStatic
    public static final ViewModelProvider create(ViewModelStore r100, Factory r101, CreationExtras r102) {
        return Companion.create(r100, r101, r102);
    }

    @JvmStatic
    public static final ViewModelProvider create(ViewModelStoreOwner r100, Factory r101, CreationExtras r102) {
        return Companion.create(r100, r101, r102);
    }

    static {
        Companion = new Companion(null);
        CreationExtras.Companion r100 = CreationExtras.Companion;
        VIEW_MODEL_KEY = new ViewModelProvider$special$$inlined$Key$1();
    }

    public ViewModelProvider(ViewModelStoreOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        ViewModelStore r101 = r100.getViewModelStore();
        androidx.lifecycle.viewmodel.internal.ViewModelProviders r102 = androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE;
        this(r101, r102.getDefaultFactory$lifecycle_viewmodel(r100), r102.getDefaultCreationExtras$lifecycle_viewmodel(r100));
    }

    public <T extends ViewModel> T get(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return (T) get(JvmClassMappingKt.getKotlinClass(r100));
    }

    private ViewModelProvider(ViewModelProviderImpl r100) {
        this.impl = r100;
    }

    public final <T extends ViewModel> T get(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "modelClass");
        return (T) ViewModelProviderImpl.getViewModel$lifecycle_viewmodel$default(this.impl, r100, null, 2, null);
    }

    public ViewModelProvider(ViewModelStoreOwner r100, Factory r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "factory");
        this(r100.getViewModelStore(), r101, androidx.lifecycle.viewmodel.internal.ViewModelProviders.INSTANCE.getDefaultCreationExtras$lifecycle_viewmodel(r100));
    }

    public <T extends ViewModel> T get(String r100, Class<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "modelClass");
        return (T) this.impl.getViewModel$lifecycle_viewmodel(JvmClassMappingKt.getKotlinClass(r101), r100);
    }

    public final <T extends ViewModel> T get(String r100, KClass<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "modelClass");
        return (T) this.impl.getViewModel$lifecycle_viewmodel(r101, r100);
    }

    public ViewModelProvider(ViewModelStore r100, Factory r101, CreationExtras r102) {
        Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
        Intrinsics.checkNotNullParameter(r101, "factory");
        Intrinsics.checkNotNullParameter(r102, "defaultCreationExtras");
        this(new ViewModelProviderImpl(r100, r101, r102));
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore r100, Factory r101, CreationExtras r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = CreationExtras.Empty.INSTANCE;
    L5:
        this(r100, r101, r102);
    }
}
