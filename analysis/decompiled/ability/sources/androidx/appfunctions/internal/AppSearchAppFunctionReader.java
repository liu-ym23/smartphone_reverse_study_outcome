package androidx.appfunctions.internal;

import C7.r;
import D7.A;
import D7.v;
import D7.w;
import H4.o;
import S7.n;
import Z6.k;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionDeprecationMetadata;
import androidx.appfunctions.metadata.AppFunctionDeprecationMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.appfunctions.metadata.AppFunctionMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionMetadataKt;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionResponseMetadata;
import androidx.appfunctions.metadata.AppFunctionResponseMetadataDocument;
import androidx.appfunctions.metadata.AppFunctionRuntimeMetadata;
import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.appsearch.app.SearchResult;
import androidx.appsearch.app.SearchSpec;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.appsearch.observer.DocumentChangeInfo;
import androidx.appsearch.observer.ObserverCallback;
import androidx.appsearch.observer.ObserverSpec;
import androidx.appsearch.observer.SchemaChangeInfo;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k9.C1650a;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.m;
import kotlin.time.DurationUnit;
import m9.c0;
import o9.InterfaceC1779e;
import o9.InterfaceC1786l;
import p9.C1792a;
import p9.d;
import z2.l;

@RequiresApi(31)
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 O2\u00020\u0001:\u0002POB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J4\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J&\u0010%\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\"\u0018\u0001*\u00020!2\u0006\u0010$\u001a\u00020#H\u0082\b¢\u0006\u0004\b%\u0010&J-\u0010(\u001a\u0004\u0018\u00010'2\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010/\u001a\u00020.2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b/\u00100J\u0019\u00103\u001a\u0004\u0018\u0001022\u0006\u00101\u001a\u00020#H\u0002¢\u0006\u0004\b3\u00104J\u001f\u00107\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\tH\u0002¢\u0006\u0004\b7\u00108J)\u0010<\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00122\u0006\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b<\u0010=J#\u0010?\u001a\u0004\u0018\u00010>2\u0006\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0004\b?\u0010@J?\u0010A\u001a\u0004\u0018\u00010\u00172\u0006\u00105\u001a\u00020\t2\u0006\u00109\u001a\u00020*2\b\u0010:\u001a\u0004\u0018\u0001022\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\bA\u0010BJ\u0019\u0010D\u001a\u0004\u0018\u00010C2\u0006\u00109\u001a\u00020*H\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u00020.2\u0006\u00101\u001a\u00020*H\u0002¢\u0006\u0004\bF\u0010GJ#\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120H2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\bI\u0010JJ\"\u0010K\u001a\u0004\u0018\u00010'2\u0006\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0096@¢\u0006\u0004\bK\u0010LR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010MR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010N¨\u0006Q"}, d2 = {"Landroidx/appfunctions/internal/AppSearchAppFunctionReader;", "Landroidx/appfunctions/internal/AppFunctionReader;", "Landroid/content/Context;", "context", "Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "schemaAppFunctionInventory", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroidx/appfunctions/internal/SchemaAppFunctionInventory;)V", "", "", "packageNames", "Landroidx/appsearch/observer/ObserverSpec;", "buildObserverSpec", "(Ljava/util/Set;)Landroidx/appsearch/observer/ObserverSpec;", "Landroidx/appsearch/app/GlobalSearchSession;", "session", "Landroidx/appfunctions/AppFunctionSearchSpec;", "searchFunctionSpec", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "performSearch", "(Landroidx/appsearch/app/GlobalSearchSession;Landroidx/appfunctions/AppFunctionSearchSpec;LH7/c;)Ljava/lang/Object;", "", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "searchTopLevelComponent", "(Landroidx/appsearch/app/GlobalSearchSession;Ljava/util/Set;LH7/c;)Ljava/lang/Object;", "Landroidx/appsearch/app/SearchResult;", "searchResult", "", "sharedTopLevelComponentsByPackage", "LC7/r;", "extractAppFunctionComponentsMetadataFromSearchResult", "(Landroidx/appsearch/app/SearchResult;Ljava/util/Map;)V", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/appsearch/app/GenericDocument;", "genericDocument", "safeCastToDocumentClass", "(Landroidx/appsearch/app/GenericDocument;)Ljava/lang/Object;", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "convertSearchResultToAppFunctionMetadata", "(Landroidx/appsearch/app/SearchResult;Ljava/util/Map;)Landroidx/appfunctions/metadata/AppFunctionMetadata;", "Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;", "staticMetadata", "Landroidx/appfunctions/metadata/AppFunctionRuntimeMetadata;", "runtimeMetadata", "", "computeEffectivelyEnabled", "(Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;Landroidx/appfunctions/metadata/AppFunctionRuntimeMetadata;)Z", "document", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "buildSchemaMetadataFromGdForLegacyIndexer", "(Landroidx/appsearch/app/GenericDocument;)Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "packageName", "functionId", "getAppFunctionId", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "appFunctionMetadataDocument", "schemaMetadata", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "getAppFunctionParameterMetadata", "(Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;)Ljava/util/List;", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "getAppFunctionResponseMetadata", "(Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;)Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "getAppFunctionComponentsMetadata", "(Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;Ljava/util/Map;)Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "getAppFunctionDeprecationMetadata", "(Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;)Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "isAppFunctionMetadataDocumentFromDynamicIndexer", "(Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;)Z", "Lp9/c;", "searchAppFunctions", "(Landroidx/appfunctions/AppFunctionSearchSpec;)Lp9/c;", "getAppFunctionMetadata", "(Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "Companion", "AppSearchChannelObserver", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppSearchAppFunctionReader implements AppFunctionReader {

    @Deprecated
    public static final String APP_FUNCTIONS_NAMESPACE = "app_functions";

    @Deprecated
    public static final String APP_FUNCTIONS_RUNTIME_DATABASE_NAME = "appfunctions-db";

    @Deprecated
    public static final String APP_FUNCTIONS_RUNTIME_NAMESPACE = "app_functions_runtime";

    @Deprecated
    public static final String APP_FUNCTIONS_STATIC_DATABASE_NAME = "apps-db";
    private static final Companion Companion = new Companion(null);
    private static final long OBSERVER_DEBOUNCE_MILLIS;
    private static final SearchSpec RUNTIME_SEARCH_SPEC;

    @Deprecated
    public static final String SYSTEM_PACKAGE_NAME = "android";
    private final Context context;
    private final SchemaAppFunctionInventory schemaAppFunctionInventory;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0003R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/appfunctions/internal/AppSearchAppFunctionReader$AppSearchChannelObserver;", "Landroidx/appsearch/observer/ObserverCallback;", AppAgent.CONSTRUCT, "()V", "Landroidx/appsearch/observer/SchemaChangeInfo;", "changeInfo", "LC7/r;", "onSchemaChanged", "(Landroidx/appsearch/observer/SchemaChangeInfo;)V", "Landroidx/appsearch/observer/DocumentChangeInfo;", "onDocumentChanged", "(Landroidx/appsearch/observer/DocumentChangeInfo;)V", "Lp9/c;", "observe", "()Lp9/c;", "close", "Lo9/e;", "updateChannel", "Lo9/e;", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AppSearchChannelObserver implements ObserverCallback {
        private final InterfaceC1779e updateChannel = k.b(0, 6, null);

        public final void close() {
            this.updateChannel.s(null);
        }

        public final p9.c observe() {
            return new C1792a(this.updateChannel, false);
        }

        @Override // androidx.appsearch.observer.ObserverCallback
        public void onDocumentChanged(DocumentChangeInfo changeInfo) {
            kotlin.jvm.internal.k.f(changeInfo, "changeInfo");
            this.updateChannel.a(r.f317a);
        }

        @Override // androidx.appsearch.observer.ObserverCallback
        public void onSchemaChanged(SchemaChangeInfo changeInfo) {
            kotlin.jvm.internal.k.f(changeInfo, "changeInfo");
            this.updateChannel.a(r.f317a);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000e8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/internal/AppSearchAppFunctionReader$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lk9/a;", "OBSERVER_DEBOUNCE_MILLIS", "J", "getOBSERVER_DEBOUNCE_MILLIS-UwyO8pc", "()J", "Landroidx/appsearch/app/SearchSpec;", "RUNTIME_SEARCH_SPEC", "Landroidx/appsearch/app/SearchSpec;", "getRUNTIME_SEARCH_SPEC", "()Landroidx/appsearch/app/SearchSpec;", "", "SYSTEM_PACKAGE_NAME", "Ljava/lang/String;", "APP_FUNCTIONS_NAMESPACE", "APP_FUNCTIONS_RUNTIME_NAMESPACE", "APP_FUNCTIONS_STATIC_DATABASE_NAME", "APP_FUNCTIONS_RUNTIME_DATABASE_NAME", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        /* renamed from: getOBSERVER_DEBOUNCE_MILLIS-UwyO8pc, reason: not valid java name */
        public final long m7getOBSERVER_DEBOUNCE_MILLISUwyO8pc() {
            return AppSearchAppFunctionReader.OBSERVER_DEBOUNCE_MILLIS;
        }

        public final SearchSpec getRUNTIME_SEARCH_SPEC() {
            return AppSearchAppFunctionReader.RUNTIME_SEARCH_SPEC;
        }

        private Companion() {
        }
    }

    @J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader", f = "AppSearchAppFunctionReader.kt", l = {358, 370, 380, 406}, m = "getAppFunctionMetadata", v = 1)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$getAppFunctionMetadata$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchAppFunctionReader.this.getAppFunctionMetadata(null, null, this);
        }
    }

    @J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader", f = "AppSearchAppFunctionReader.kt", l = {174, 181}, m = "performSearch", v = 1)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$performSearch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03191 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C03191(H7.c<? super C03191> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchAppFunctionReader.this.performSearch(null, null, this);
        }
    }

    @J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$1", f = "AppSearchAppFunctionReader.kt", l = {84}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lp9/d;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03201 extends SuspendLambda implements n {
        private /* synthetic */ Object L$0;
        int label;

        public C03201(H7.c<? super C03201> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C03201 c03201 = new C03201(cVar);
            c03201.L$0 = obj;
            return c03201;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                d dVar = (d) this.L$0;
                EmptyList emptyList = EmptyList.f4893a;
                this.label = 1;
                if (dVar.emit(emptyList, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(d dVar, H7.c<? super r> cVar) {
            return ((C03201) create(dVar, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2", f = "AppSearchAppFunctionReader.kt", l = {88, 91, 91, 112}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lo9/l;", "", "Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "LC7/r;", "<anonymous>", "(Lo9/l;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ AppFunctionSearchSpec $searchFunctionSpec;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AppFunctionSearchSpec appFunctionSearchSpec, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$searchFunctionSpec = appFunctionSearchSpec;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final r invokeSuspend$lambda$0(c0 c0Var, AppSearchChannelObserver appSearchChannelObserver, GlobalSearchSession globalSearchSession) throws AppSearchException {
            c0Var.cancel(null);
            appSearchChannelObserver.close();
            globalSearchSession.unregisterObserverCallback(AppSearchAppFunctionReader.SYSTEM_PACKAGE_NAME, appSearchChannelObserver);
            globalSearchSession.close();
            return r.f317a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = AppSearchAppFunctionReader.this.new AnonymousClass2(this.$searchFunctionSpec, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x00e6, code lost:
        
            if (kotlinx.coroutines.channels.b.a(r11, r4, r16) != r1) goto L39;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00a2  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws androidx.appsearch.exceptions.AppSearchException {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchAppFunctionReader.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1786l interfaceC1786l, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1786l, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader", f = "AppSearchAppFunctionReader.kt", l = {214}, m = "searchTopLevelComponent", v = 1)
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchTopLevelComponent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03211 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C03211(H7.c<? super C03211> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppSearchAppFunctionReader.this.searchTopLevelComponent(null, null, this);
        }
    }

    static {
        int i = C1650a.d;
        OBSERVER_DEBOUNCE_MILLIS = l.I(1, DurationUnit.d);
        SearchSpec searchSpecBuild = new SearchSpec.Builder().addFilterNamespaces(APP_FUNCTIONS_RUNTIME_NAMESPACE).addFilterDocumentClasses(AppFunctionRuntimeMetadata.class).addFilterPackageNames(SYSTEM_PACKAGE_NAME).setVerbatimSearchEnabled(true).build();
        kotlin.jvm.internal.k.e(searchSpecBuild, "build(...)");
        RUNTIME_SEARCH_SPEC = searchSpecBuild;
    }

    public AppSearchAppFunctionReader(Context context, SchemaAppFunctionInventory schemaAppFunctionInventory) {
        kotlin.jvm.internal.k.f(context, "context");
        this.context = context;
        this.schemaAppFunctionInventory = schemaAppFunctionInventory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ObserverSpec buildObserverSpec(Set<String> packageNames) {
        ObserverSpec.Builder builder = new ObserverSpec.Builder();
        ArrayList arrayList = new ArrayList();
        for (String str : packageNames) {
            A.e0(o.N(B7.a.k("AppFunctionStaticMetadata-", str), B7.a.k("AppFunctionRuntimeMetadata-", str), B7.a.k("AppFunctionComponentMetadataDocument-", str)), arrayList);
        }
        ObserverSpec observerSpecBuild = builder.addFilterSchemas(arrayList).build();
        kotlin.jvm.internal.k.e(observerSpecBuild, "build(...)");
        return observerSpecBuild;
    }

    private final AppFunctionSchemaMetadata buildSchemaMetadataFromGdForLegacyIndexer(GenericDocument document) {
        String propertyString = document.getPropertyString("schemaName");
        String propertyString2 = document.getPropertyString("schemaCategory");
        long propertyLong = document.getPropertyLong("schemaVersion");
        if (propertyString != null && propertyString2 != null && propertyLong != 0) {
            return new AppFunctionSchemaMetadata(propertyString2, propertyString, propertyLong);
        }
        if (propertyString == null && propertyString2 == null && propertyLong == 0) {
            return null;
        }
        StringBuilder sbW = B7.a.w("Unexpected state: schemaName=", propertyString, ", schemaCategory=", propertyString2, ", schemaVersion=");
        sbW.append(propertyLong);
        Log.e(Constants.APP_FUNCTIONS_TAG, sbW.toString());
        return null;
    }

    private final boolean computeEffectivelyEnabled(AppFunctionMetadataDocument staticMetadata, AppFunctionRuntimeMetadata runtimeMetadata) {
        int enabled = (int) runtimeMetadata.getEnabled();
        if (enabled == 0) {
            return staticMetadata.isEnabledByDefault();
        }
        if (enabled == 1) {
            return true;
        }
        if (enabled == 2) {
            return false;
        }
        throw new IllegalStateException("Unknown AppFunction state: " + runtimeMetadata.getEnabled() + '.');
    }

    private final AppFunctionMetadata convertSearchResultToAppFunctionMetadata(SearchResult searchResult, Map<String, AppFunctionComponentsMetadata> sharedTopLevelComponentsByPackage) {
        Object documentClass;
        Object documentClass2;
        AppFunctionResponseMetadata appFunctionResponseMetadata;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata;
        String propertyString = searchResult.getGenericDocument().getPropertyString("functionId");
        if (propertyString == null) {
            throw new IllegalStateException("Required value was null.");
        }
        String propertyString2 = searchResult.getGenericDocument().getPropertyString("packageName");
        if (propertyString2 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        GenericDocument genericDocument = searchResult.getGenericDocument();
        kotlin.jvm.internal.k.e(genericDocument, "getGenericDocument(...)");
        try {
            documentClass = genericDocument.toDocumentClass(AppFunctionMetadataDocument.class);
        } catch (Exception e) {
            Log.e(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument.getId() + " to " + m.f4928a.b(AppFunctionMetadataDocument.class).m(), e);
            documentClass = null;
        }
        AppFunctionMetadataDocument appFunctionMetadataDocument = (AppFunctionMetadataDocument) documentClass;
        if (appFunctionMetadataDocument != null) {
            List<SearchResult> joinedResults = searchResult.getJoinedResults();
            kotlin.jvm.internal.k.e(joinedResults, "getJoinedResults(...)");
            SearchResult searchResult2 = (SearchResult) v.W0(joinedResults);
            if (searchResult2 == null) {
                Log.e(Constants.APP_FUNCTIONS_TAG, "Runtime metadata not found for " + appFunctionMetadataDocument.getId());
                return null;
            }
            GenericDocument genericDocument2 = searchResult2.getGenericDocument();
            kotlin.jvm.internal.k.e(genericDocument2, "getGenericDocument(...)");
            try {
                documentClass2 = genericDocument2.toDocumentClass(AppFunctionRuntimeMetadata.class);
            } catch (Exception e6) {
                Log.e(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument2.getId() + " to " + m.f4928a.b(AppFunctionRuntimeMetadata.class).m(), e6);
                documentClass2 = null;
            }
            AppFunctionRuntimeMetadata appFunctionRuntimeMetadata = (AppFunctionRuntimeMetadata) documentClass2;
            if (appFunctionRuntimeMetadata != null) {
                GenericDocument genericDocument3 = searchResult.getGenericDocument();
                kotlin.jvm.internal.k.e(genericDocument3, "getGenericDocument(...)");
                AppFunctionSchemaMetadata appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer = buildSchemaMetadataFromGdForLegacyIndexer(genericDocument3);
                List<AppFunctionParameterMetadata> appFunctionParameterMetadata = getAppFunctionParameterMetadata(appFunctionMetadataDocument, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer);
                if (appFunctionParameterMetadata != null && (appFunctionResponseMetadata = getAppFunctionResponseMetadata(appFunctionMetadataDocument, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer)) != null && (appFunctionComponentsMetadata = getAppFunctionComponentsMetadata(propertyString2, appFunctionMetadataDocument, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer, sharedTopLevelComponentsByPackage)) != null) {
                    AppFunctionDeprecationMetadata appFunctionDeprecationMetadata = getAppFunctionDeprecationMetadata(appFunctionMetadataDocument);
                    boolean zComputeEffectivelyEnabled = computeEffectivelyEnabled(appFunctionMetadataDocument, appFunctionRuntimeMetadata);
                    String description = appFunctionMetadataDocument.getDescription();
                    if (description == null) {
                        description = "";
                    }
                    return new AppFunctionMetadata(propertyString, propertyString2, zComputeEffectivelyEnabled, appFunctionSchemaMetadataBuildSchemaMetadataFromGdForLegacyIndexer, appFunctionParameterMetadata, appFunctionResponseMetadata, appFunctionComponentsMetadata, description, appFunctionDeprecationMetadata);
                }
            }
        }
        return null;
    }

    private final void extractAppFunctionComponentsMetadataFromSearchResult(SearchResult searchResult, Map<String, AppFunctionComponentsMetadata> sharedTopLevelComponentsByPackage) {
        Object documentClass;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata;
        String propertyString = searchResult.getGenericDocument().getPropertyString("packageName");
        if (propertyString == null) {
            throw new IllegalStateException("Required value was null.");
        }
        GenericDocument genericDocument = searchResult.getGenericDocument();
        kotlin.jvm.internal.k.e(genericDocument, "getGenericDocument(...)");
        try {
            documentClass = genericDocument.toDocumentClass(AppFunctionComponentsMetadataDocument.class);
        } catch (Exception e) {
            Log.e(Constants.APP_FUNCTIONS_TAG, "Failed to convert search result " + genericDocument.getId() + " to " + m.f4928a.b(AppFunctionComponentsMetadataDocument.class).m(), e);
            documentClass = null;
        }
        AppFunctionComponentsMetadataDocument appFunctionComponentsMetadataDocument = (AppFunctionComponentsMetadataDocument) documentClass;
        if (appFunctionComponentsMetadataDocument == null || (appFunctionComponentsMetadata = appFunctionComponentsMetadataDocument.toAppFunctionComponentsMetadata()) == null || appFunctionComponentsMetadata.getDataTypes().isEmpty()) {
            return;
        }
        sharedTopLevelComponentsByPackage.put(propertyString, appFunctionComponentsMetadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final AppFunctionComponentsMetadata getAppFunctionComponentsMetadata(String packageName, AppFunctionMetadataDocument appFunctionMetadataDocument, AppFunctionSchemaMetadata schemaMetadata, Map<String, AppFunctionComponentsMetadata> sharedTopLevelComponentsByPackage) {
        SchemaAppFunctionInventory schemaAppFunctionInventory;
        Map map = null;
        Object[] objArr = 0;
        if (isAppFunctionMetadataDocumentFromDynamicIndexer(appFunctionMetadataDocument)) {
            AppFunctionComponentsMetadata appFunctionComponentsMetadata = sharedTopLevelComponentsByPackage.get(packageName);
            return appFunctionComponentsMetadata == null ? new AppFunctionComponentsMetadata(map, 1, objArr == true ? 1 : 0) : appFunctionComponentsMetadata;
        }
        if (schemaMetadata == null || (schemaAppFunctionInventory = this.schemaAppFunctionInventory) == null) {
            return null;
        }
        return schemaAppFunctionInventory.getComponentsMetadata();
    }

    private final AppFunctionDeprecationMetadata getAppFunctionDeprecationMetadata(AppFunctionMetadataDocument appFunctionMetadataDocument) {
        AppFunctionDeprecationMetadataDocument deprecation = appFunctionMetadataDocument.getDeprecation();
        if (deprecation != null) {
            return deprecation.toAppFunctionDeprecationMetadata();
        }
        return null;
    }

    private final String getAppFunctionId(String packageName, String functionId) {
        return packageName + JsonPointer.SEPARATOR + functionId;
    }

    private final List<AppFunctionParameterMetadata> getAppFunctionParameterMetadata(AppFunctionMetadataDocument appFunctionMetadataDocument, AppFunctionSchemaMetadata schemaMetadata) {
        SchemaAppFunctionInventory schemaAppFunctionInventory;
        Map<AppFunctionSchemaMetadata, CompileTimeAppFunctionMetadata> schemaFunctionsMap;
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata;
        if (!isAppFunctionMetadataDocumentFromDynamicIndexer(appFunctionMetadataDocument)) {
            if (schemaMetadata == null || (schemaAppFunctionInventory = this.schemaAppFunctionInventory) == null || (schemaFunctionsMap = schemaAppFunctionInventory.getSchemaFunctionsMap()) == null || (compileTimeAppFunctionMetadata = schemaFunctionsMap.get(schemaMetadata)) == null) {
                return null;
            }
            return compileTimeAppFunctionMetadata.getParameters();
        }
        List<AppFunctionParameterMetadataDocument> parameters = appFunctionMetadataDocument.getParameters();
        if (parameters == null) {
            return EmptyList.f4893a;
        }
        List<AppFunctionParameterMetadataDocument> list = parameters;
        ArrayList arrayList = new ArrayList(w.c0(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionParameterMetadataDocument) it.next()).toAppFunctionParameterMetadata());
        }
        return arrayList;
    }

    private final AppFunctionResponseMetadata getAppFunctionResponseMetadata(AppFunctionMetadataDocument appFunctionMetadataDocument, AppFunctionSchemaMetadata schemaMetadata) {
        SchemaAppFunctionInventory schemaAppFunctionInventory;
        Map<AppFunctionSchemaMetadata, CompileTimeAppFunctionMetadata> schemaFunctionsMap;
        CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata;
        if (isAppFunctionMetadataDocumentFromDynamicIndexer(appFunctionMetadataDocument)) {
            AppFunctionResponseMetadataDocument response = appFunctionMetadataDocument.getResponse();
            if (response != null) {
                return response.toAppFunctionResponseMetadata();
            }
            throw new IllegalStateException("Required value was null.");
        }
        if (schemaMetadata == null || (schemaAppFunctionInventory = this.schemaAppFunctionInventory) == null || (schemaFunctionsMap = schemaAppFunctionInventory.getSchemaFunctionsMap()) == null || (compileTimeAppFunctionMetadata = schemaFunctionsMap.get(schemaMetadata)) == null) {
            return null;
        }
        return compileTimeAppFunctionMetadata.getResponse();
    }

    private final boolean isAppFunctionMetadataDocumentFromDynamicIndexer(AppFunctionMetadataDocument document) {
        return document.getResponse() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00d2, code lost:
    
        if (r11 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object performSearch(androidx.appsearch.app.GlobalSearchSession r9, androidx.appfunctions.AppFunctionSearchSpec r10, H7.c<? super java.util.List<androidx.appfunctions.metadata.AppFunctionPackageMetadata>> r11) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchAppFunctionReader.performSearch(androidx.appsearch.app.GlobalSearchSession, androidx.appfunctions.AppFunctionSearchSpec, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionMetadata performSearch$lambda$0(AppSearchAppFunctionReader appSearchAppFunctionReader, Map map, SearchResult searchResult) {
        kotlin.jvm.internal.k.f(searchResult, "searchResult");
        return appSearchAppFunctionReader.convertSearchResultToAppFunctionMetadata(searchResult, map);
    }

    private final <T> T safeCastToDocumentClass(GenericDocument genericDocument) {
        try {
            kotlin.jvm.internal.k.m();
            throw null;
        } catch (Exception unused) {
            genericDocument.getId();
            kotlin.jvm.internal.k.m();
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object searchTopLevelComponent(androidx.appsearch.app.GlobalSearchSession r8, java.util.Set<java.lang.String> r9, H7.c<? super java.util.Map<java.lang.String, androidx.appfunctions.metadata.AppFunctionComponentsMetadata>> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.appfunctions.internal.AppSearchAppFunctionReader.C03211
            if (r0 == 0) goto L13
            r0 = r10
            androidx.appfunctions.internal.AppSearchAppFunctionReader$searchTopLevelComponent$1 r0 = (androidx.appfunctions.internal.AppSearchAppFunctionReader.C03211) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.appfunctions.internal.AppSearchAppFunctionReader$searchTopLevelComponent$1 r0 = new androidx.appfunctions.internal.AppSearchAppFunctionReader$searchTopLevelComponent$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r7 = r0.L$0
            java.util.Map r7 = (java.util.Map) r7
            kotlin.b.b(r10)
            return r7
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            kotlin.b.b(r10)
            androidx.appsearch.app.SearchSpec$Builder r10 = new androidx.appsearch.app.SearchSpec$Builder
            r10.<init>()
            java.lang.String r2 = "app_functions"
            java.lang.String[] r2 = new java.lang.String[]{r2}
            androidx.appsearch.app.SearchSpec$Builder r10 = r10.addFilterNamespaces(r2)
            if (r9 != 0) goto L49
            kotlin.collections.EmptySet r9 = kotlin.collections.EmptySet.f4895a
        L49:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r9 = r9.iterator()
        L54:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L78
            java.lang.Object r4 = r9.next()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "AppFunctionComponentMetadataDocument-"
            r5.<init>(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.util.List r4 = H4.o.M(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            D7.A.e0(r4, r2)
            goto L54
        L78:
            androidx.appsearch.app.SearchSpec$Builder r9 = r10.addFilterSchemas(r2)
            java.lang.String r10 = "android"
            java.lang.String[] r10 = new java.lang.String[]{r10}
            androidx.appsearch.app.SearchSpec$Builder r9 = r9.addFilterPackageNames(r10)
            androidx.appsearch.app.SearchSpec$Builder r9 = r9.setVerbatimSearchEnabled(r3)
            androidx.appsearch.app.SearchSpec$Builder r9 = r9.setNumericSearchEnabled(r3)
            androidx.appsearch.app.SearchSpec$Builder r9 = r9.setListFilterQueryLanguageEnabled(r3)
            androidx.appsearch.app.SearchSpec r9 = r9.build()
            java.lang.String r10 = "build(...)"
            kotlin.jvm.internal.k.e(r9, r10)
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            java.lang.String r2 = ""
            androidx.appsearch.app.SearchResults r8 = r8.search(r2, r9)
            java.lang.String r9 = "search(...)"
            kotlin.jvm.internal.k.e(r8, r9)
            R3.b r9 = new R3.b
            r2 = 9
            r9.<init>(r2, r7, r10)
            r0.L$0 = r10
            r0.label = r3
            java.lang.Object r7 = androidx.appfunctions.internal.AppSearchUtilsKt.readAll(r8, r9, r0)
            if (r7 != r1) goto Lbd
            return r1
        Lbd:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchAppFunctionReader.searchTopLevelComponent(androidx.appsearch.app.GlobalSearchSession, java.util.Set, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r searchTopLevelComponent$lambda$1(AppSearchAppFunctionReader appSearchAppFunctionReader, Map map, SearchResult searchResult) {
        kotlin.jvm.internal.k.f(searchResult, "searchResult");
        appSearchAppFunctionReader.extractAppFunctionComponentsMetadataFromSearchResult(searchResult, map);
        return r.f317a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    @Override // androidx.appfunctions.internal.AppFunctionReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object getAppFunctionMetadata(java.lang.String r31, java.lang.String r32, H7.c<? super androidx.appfunctions.metadata.AppFunctionMetadata> r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 589
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchAppFunctionReader.getAppFunctionMetadata(java.lang.String, java.lang.String, H7.c):java.lang.Object");
    }

    @Override // androidx.appfunctions.internal.AppFunctionReader
    public p9.c searchAppFunctions(AppFunctionSearchSpec searchFunctionSpec) {
        kotlin.jvm.internal.k.f(searchFunctionSpec, "searchFunctionSpec");
        Set<String> packageNames = searchFunctionSpec.getPackageNames();
        return (packageNames == null || !packageNames.isEmpty()) ? kotlinx.coroutines.flow.d.c(new AnonymousClass2(searchFunctionSpec, null)) : new p9.m(new C03201(null));
    }
}
