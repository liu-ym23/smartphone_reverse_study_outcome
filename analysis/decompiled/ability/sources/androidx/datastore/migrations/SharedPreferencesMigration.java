package androidx.datastore.migrations;

import C7.f;
import C7.r;
import D7.v;
import J7.c;
import S7.a;
import S7.n;
import S7.o;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.autofill.HintConstants;
import androidx.datastore.core.DataMigration;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010#\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u00013B\u008c\u0001\b\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012$\b\u0002\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012(\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015Bz\b\u0017\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012$\b\u0002\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012(\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0016B|\b\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012$\b\u0002\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t\u0012(\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b \u0010!J\u001b\u0010#\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010\u0010\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010$J\u0013\u0010%\u001a\u00020\u0019H\u0096@ø\u0001\u0000¢\u0006\u0004\b%\u0010&R3\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\t8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\r\u0010'R9\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e8\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u0010\u0010(R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010)R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010*R\u001b\u0010/\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001c\u00101\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Landroidx/datastore/migrations/SharedPreferencesMigration;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/DataMigration;", "Lkotlin/Function0;", "Landroid/content/SharedPreferences;", "produceSharedPreferences", "", "", "keysToMigrate", "Lkotlin/Function2;", "LH7/c;", "", "", "shouldRunMigration", "Lkotlin/Function3;", "Landroidx/datastore/migrations/SharedPreferencesView;", "migrate", "Landroid/content/Context;", "context", HintConstants.AUTOFILL_HINT_NAME, AppAgent.CONSTRUCT, "(LS7/a;Ljava/util/Set;LS7/n;LS7/o;Landroid/content/Context;Ljava/lang/String;)V", "(LS7/a;Ljava/util/Set;LS7/n;LS7/o;)V", "sharedPreferencesName", "(Landroid/content/Context;Ljava/lang/String;Ljava/util/Set;LS7/n;LS7/o;)V", "LC7/r;", "deleteSharedPreferences", "(Landroid/content/Context;Ljava/lang/String;)V", "Ljava/io/File;", "getSharedPrefsFile", "(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;", "prefsFile", "getSharedPrefsBackup", "(Ljava/io/File;)Ljava/io/File;", "currentData", "shouldMigrate", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "cleanUp", "(LH7/c;)Ljava/lang/Object;", "LS7/n;", "LS7/o;", "Landroid/content/Context;", "Ljava/lang/String;", "sharedPrefs$delegate", "LC7/f;", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "sharedPrefs", "", "keySet", "Ljava/util/Set;", "Api24Impl", "datastore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedPreferencesMigration<T> implements DataMigration<T> {
    private final Context context;
    private final Set<String> keySet;
    private final o migrate;
    private final String name;

    /* renamed from: sharedPrefs$delegate, reason: from kotlin metadata */
    private final f sharedPrefs;
    private final n shouldRunMigration;

    @c(c = "androidx.datastore.migrations.SharedPreferencesMigration$1", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(cVar);
        }

        public final Object invoke(T t9, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(t9, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return Boolean.TRUE;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass1) obj, (H7.c<? super Boolean>) obj2);
        }
    }

    @c(c = "androidx.datastore.migrations.SharedPreferencesMigration$2", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        int label;

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(cVar);
        }

        public final Object invoke(T t9, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(t9, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return Boolean.TRUE;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass2) obj, (H7.c<? super Boolean>) obj2);
        }
    }

    @c(c = "androidx.datastore.migrations.SharedPreferencesMigration$3", f = "SharedPreferencesMigration.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "it"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements n {
        int label;

        public AnonymousClass3(H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass3(cVar);
        }

        public final Object invoke(T t9, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass3) create(t9, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            return Boolean.TRUE;
        }

        @Override // S7.n
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke((AnonymousClass3) obj, (H7.c<? super Boolean>) obj2);
        }
    }

    @RequiresApi(24)
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/datastore/migrations/SharedPreferencesMigration$Api24Impl;", "", "()V", "deleteSharedPreferences", "", "context", "Landroid/content/Context;", HintConstants.AUTOFILL_HINT_NAME, "", "datastore_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Api24Impl {
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final boolean deleteSharedPreferences(Context context, String name) {
            k.f(context, "context");
            k.f(name, "name");
            return context.deleteSharedPreferences(name);
        }
    }

    @c(c = "androidx.datastore.migrations.SharedPreferencesMigration", f = "SharedPreferencesMigration.kt", l = {147}, m = "shouldMigrate")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07471 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SharedPreferencesMigration<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07471(SharedPreferencesMigration<T> sharedPreferencesMigration, H7.c<? super C07471> cVar) {
            super(cVar);
            this.this$0 = sharedPreferencesMigration;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.shouldMigrate(null, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a produceSharedPreferences, o migrate) {
        this(produceSharedPreferences, (Set) null, (n) null, migrate, 6, (e) null);
        k.f(produceSharedPreferences, "produceSharedPreferences");
        k.f(migrate, "migrate");
    }

    private final void deleteSharedPreferences(Context context, String name) throws IOException {
        if (!Api24Impl.deleteSharedPreferences(context, name)) {
            throw new IOException(k.l(name, "Unable to delete SharedPreferences: "));
        }
    }

    private final SharedPreferences getSharedPrefs() {
        return (SharedPreferences) this.sharedPrefs.getF4884a();
    }

    private final File getSharedPrefsBackup(File prefsFile) {
        return new File(k.l(".bak", prefsFile.getPath()));
    }

    private final File getSharedPrefsFile(Context context, String name) {
        return new File(new File(context.getApplicationInfo().dataDir, "shared_prefs"), k.l(".xml", name));
    }

    @Override // androidx.datastore.core.DataMigration
    public Object cleanUp(H7.c<? super r> cVar) throws IOException {
        r rVar;
        Context context;
        String str;
        SharedPreferences.Editor editorEdit = getSharedPrefs().edit();
        Set<String> set = this.keySet;
        if (set == null) {
            editorEdit.clear();
        } else {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                editorEdit.remove((String) it.next());
            }
        }
        if (!editorEdit.commit()) {
            throw new IOException("Unable to delete migrated keys from SharedPreferences.");
        }
        if (getSharedPrefs().getAll().isEmpty() && (context = this.context) != null && (str = this.name) != null) {
            deleteSharedPreferences(context, str);
        }
        Set<String> set2 = this.keySet;
        r rVar2 = r.f317a;
        if (set2 == null) {
            rVar = null;
        } else {
            set2.clear();
            rVar = rVar2;
        }
        return rVar == CoroutineSingletons.f4909a ? rVar : rVar2;
    }

    @Override // androidx.datastore.core.DataMigration
    public Object migrate(T t9, H7.c<? super T> cVar) {
        return this.migrate.invoke(new SharedPreferencesView(getSharedPrefs(), this.keySet), t9, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.datastore.core.DataMigration
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object shouldMigrate(T r5, H7.c<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.datastore.migrations.SharedPreferencesMigration.C07471
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = (androidx.datastore.migrations.SharedPreferencesMigration.C07471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1 r0 = new androidx.datastore.migrations.SharedPreferencesMigration$shouldMigrate$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r4 = r0.L$0
            androidx.datastore.migrations.SharedPreferencesMigration r4 = (androidx.datastore.migrations.SharedPreferencesMigration) r4
            kotlin.b.b(r6)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.b.b(r6)
            S7.n r6 = r4.shouldRunMigration
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.invoke(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r5 = r6.booleanValue()
            if (r5 != 0) goto L4e
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            return r4
        L4e:
            java.util.Set<java.lang.String> r5 = r4.keySet
            r6 = 0
            if (r5 != 0) goto L69
            android.content.SharedPreferences r4 = r4.getSharedPrefs()
            java.util.Map r4 = r4.getAll()
            java.lang.String r5 = "sharedPrefs.all"
            kotlin.jvm.internal.k.e(r4, r5)
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L67
            goto L93
        L67:
            r3 = r6
            goto L93
        L69:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            android.content.SharedPreferences r4 = r4.getSharedPrefs()
            boolean r0 = r5 instanceof java.util.Collection
            if (r0 == 0) goto L7d
            r0 = r5
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L7d
            goto L67
        L7d:
            java.util.Iterator r5 = r5.iterator()
        L81:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r5.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = r4.contains(r0)
            if (r0 == 0) goto L81
        L93:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.migrations.SharedPreferencesMigration.shouldMigrate(java.lang.Object, H7.c):java.lang.Object");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a produceSharedPreferences, Set<String> keysToMigrate, o migrate) {
        this(produceSharedPreferences, keysToMigrate, (n) null, migrate, 4, (e) null);
        k.f(produceSharedPreferences, "produceSharedPreferences");
        k.f(keysToMigrate, "keysToMigrate");
        k.f(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, o migrate) {
        this(context, sharedPreferencesName, null, null, migrate, 12, null);
        k.f(context, "context");
        k.f(sharedPreferencesName, "sharedPreferencesName");
        k.f(migrate, "migrate");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(Context context, String sharedPreferencesName, Set<String> keysToMigrate, o migrate) {
        this(context, sharedPreferencesName, keysToMigrate, null, migrate, 8, null);
        k.f(context, "context");
        k.f(sharedPreferencesName, "sharedPreferencesName");
        k.f(keysToMigrate, "keysToMigrate");
        k.f(migrate, "migrate");
    }

    private SharedPreferencesMigration(a aVar, Set<String> set, n nVar, o oVar, Context context, String str) {
        this.shouldRunMigration = nVar;
        this.migrate = oVar;
        this.context = context;
        this.name = str;
        this.sharedPrefs = kotlin.a.a(aVar);
        this.keySet = set == SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS() ? null : v.i1(set);
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, n nVar, o oVar, Context context, String str, int i, e eVar) {
        this(aVar, (Set<String>) set, (i & 4) != 0 ? new AnonymousClass1(null) : nVar, oVar, context, str);
    }

    public /* synthetic */ SharedPreferencesMigration(a aVar, Set set, n nVar, o oVar, int i, e eVar) {
        this(aVar, (Set<String>) ((i & 2) != 0 ? SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS() : set), (i & 4) != 0 ? new AnonymousClass2(null) : nVar, oVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(a produceSharedPreferences, Set<String> keysToMigrate, n shouldRunMigration, o migrate) {
        this(produceSharedPreferences, keysToMigrate, shouldRunMigration, migrate, (Context) null, (String) null);
        k.f(produceSharedPreferences, "produceSharedPreferences");
        k.f(keysToMigrate, "keysToMigrate");
        k.f(shouldRunMigration, "shouldRunMigration");
        k.f(migrate, "migrate");
    }

    public /* synthetic */ SharedPreferencesMigration(Context context, String str, Set set, n nVar, o oVar, int i, e eVar) {
        this(context, str, (i & 4) != 0 ? SharedPreferencesMigrationKt.getMIGRATE_ALL_KEYS() : set, (i & 8) != 0 ? new AnonymousClass3(null) : nVar, oVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedPreferencesMigration(final Context context, final String sharedPreferencesName, Set<String> keysToMigrate, n shouldRunMigration, o migrate) {
        this(new a() { // from class: androidx.datastore.migrations.SharedPreferencesMigration.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final SharedPreferences invoke() {
                SharedPreferences sharedPreferences = context.getSharedPreferences(sharedPreferencesName, 0);
                k.e(sharedPreferences, "context.getSharedPreferences(sharedPreferencesName, Context.MODE_PRIVATE)");
                return sharedPreferences;
            }
        }, keysToMigrate, shouldRunMigration, migrate, context, sharedPreferencesName);
        k.f(context, "context");
        k.f(sharedPreferencesName, "sharedPreferencesName");
        k.f(keysToMigrate, "keysToMigrate");
        k.f(shouldRunMigration, "shouldRunMigration");
        k.f(migrate, "migrate");
    }
}
