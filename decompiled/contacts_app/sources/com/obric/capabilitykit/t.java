package com.obric.capabilitykit;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Parcelable;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityClassData;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.logger.Logger;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.oui.material.MaterialConfigBuilder;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004J \u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0002JV\u0010\u001c\u001aR\u0012\u0004\u0012\u00020\u0004\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f0\u001e0\u001dj(\u0012\u0004\u0012\u00020\u0004\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030 0\u001f0\u001e`!J-\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0017\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'J\u001d\u0010(\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0002\u0010)J\"\u0010*\u001a\u0004\u0018\u00010\u00012\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0002J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010,\u001a\u00020\u0004H\u0002J \u00100\u001a\n\u0012\u0004\u0012\u0002H2\u0018\u000101\"\u0004\b\u0000\u00102*\b\u0012\u0004\u0012\u0002H203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentExecutor;", "", "()V", "TAG", "", "entitesGson", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "getEntitesGson", "()Lcom/google/gson/Gson;", "intentMap", "com/obric/capabilitykit/execution/IntentExecutor$intentMap$1", "Lcom/obric/capabilitykit/execution/IntentExecutor$intentMap$1;", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "cancelTaskByMessageId", "", "messageId", "reason", "jobId", "genFailedResult", "Lcom/obric/capabilitykit/common/intent/IntentResult;", AccountConst.KEY_ERROR_CODE, "", "getIntentMap", "Ljava/util/LinkedHashMap;", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "handleIntentCalling", "context", "Landroid/content/Context;", "intentCalling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "(Landroid/content/Context;Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isTaskRunning", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Boolean;", "parseJsonInputParams", "intentName", "typeName", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "queryIntentParamType", "Ljava/lang/reflect/Type;", "cachedConstructor", "Ljava/lang/reflect/Constructor;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "AppEntityTypeAdapter", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class t {
    public static final t a = null;
    private static final String b = "IntentExecutor";
    private static final Lazy c = null;
    private static final d d = null;
    private static final Gson e = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/execution/IntentExecutor$AppEntityTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "deserialize", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements JsonDeserializer<AppEntity> {
        public a() {
        }

        public AppEntity a(JsonElement r1, Type r2, JsonDeserializationContext r3) {
            Integer r0 = null;
            if (r1 == null) goto L5;
            JsonObject r4 = r1.getAsJsonObject();
        L6:
            if (r4 == null) goto L10;
            JsonElement r5 = r4.get("type");
            if (r5 == null) goto L10;
            r0 = Integer.valueOf(r5.getAsInt());
        L10:
            EntityClassData<? extends AppEntity> r6 = EntityType.INSTANCE.getClassMap().get(r0);
            if (r6 == null) goto L17;
            GenericDeclaration r7 = r6.getClazz();
            if (r7 == null) goto L17;
            Object r8 = UtilsKt.getGson().fromJson(r1, r7);
            Intrinsics.checkNotNullExpressionValue(r8, "gson.fromJson(json, targetClass)");
            return (AppEntity) r8;
        L17:
            throw new IllegalArgumentException("Unknown entity type: " + r0);
        L5:
            r4 = null;
            goto L6
        }

        @Override // com.google.gson.JsonDeserializer
        public /* bridge */ /* synthetic */ AppEntity deserialize(JsonElement r1, Type r2, JsonDeserializationContext r3) {
            return a(r1, r2, r3);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor", f = "IntentExecutor.kt", i = {0, 0, 0, 1, 1, 1}, l = {124, 129}, m = "handleIntentCalling", n = {"this", "context", "intentCalling", "this", "context", "intentCalling"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class b extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public final /* synthetic */ t e;
        public int f;

        public b(t r1, Continuation<? super b> r2) {
            this.e = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.d = r2;
            this.f |= Integer.MIN_VALUE;
            return this.e.a(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor$handleIntentCalling$result$1", f = "IntentExecutor.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntentResult<? extends Object>>, Object> {
        public int a;
        public final /* synthetic */ IntentFunction<Parcelable, ?> b;
        public final /* synthetic */ Parcelable c;
        public final /* synthetic */ DispatchContext d;

        public c(IntentFunction<Parcelable, ?> r1, Parcelable r2, DispatchContext r3, Continuation<? super c> r4) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            super(2, r4);
        }

        public final Object a(CoroutineScope r1, Continuation<? super IntentResult<? extends Object>> r2) {
            return ((c) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new c(this.b, this.c, this.d, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super IntentResult<? extends Object>> r2) {
            return a(r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            IntentFunction<Parcelable, ?> r6 = this.b;
            Parcelable r2 = this.c;
            DispatchContext r3 = this.d;
            this.a = 1;
            r5 = r6.doAction(r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002R\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u00030\u0001j(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003`\u0006J8\u0010\t\u001a\u00020\n2.\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003\u0018\u00010\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/execution/IntentExecutor$intentMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends LinkedHashMap<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> {
        private final int a;

        public d() {
            this.a = 10;
        }

        public /* bridge */ Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> a() {
            return super.entrySet();
        }

        public final /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> a(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        public final /* bridge */ Set a(Object r2, Set r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, r3);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> a(String r1, Set<Pair<String, IntentFunction<?, ?>>> r2) {
            return (Set) super.getOrDefault(r1, r2);
        }

        public /* bridge */ boolean a(String r1) {
            return super.containsKey(r1);
        }

        public /* bridge */ boolean a(Set<Pair<String, IntentFunction<?, ?>>> r1) {
            return super.containsValue(r1);
        }

        public /* bridge */ Set<String> b() {
            return super.keySet();
        }

        public final /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> b(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> b(String r1) {
            return (Set) super.get(r1);
        }

        public /* bridge */ boolean b(String r1, Set<Pair<String, IntentFunction<?, ?>>> r2) {
            return super.remove(r1, r2);
        }

        public /* bridge */ int c() {
            return super.size();
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> c(String r1) {
            return (Set) super.remove(r1);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r2) {
            if (TypeIntrinsics.isMutableSet(r2) == true) goto L7;
            return false;
        L7:
            return a((Set) r2);
        }

        public /* bridge */ Collection<Set<Pair<String, IntentFunction<?, ?>>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r2);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r2, Object r3) {
            if ((r2 instanceof String) == true) goto L6;
            return r3;
        L6:
            return a((String) r2, (Set) r3);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r2) {
            if ((r2 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r2);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r3, Object r4) {
            if ((r3 instanceof String) == true) goto L6;
            return false;
        L6:
            if (TypeIntrinsics.isMutableSet(r4) == true) goto L9;
            return false;
        L9:
            return b((String) r3, (Set) r4);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> r1) {
            if (size() <= this.a) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Set<Pair<String, IntentFunction<?, ?>>>> values() {
            return d();
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<KeyguardManager> {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
            super(0);
        }

        public final KeyguardManager a() {
            Object r1 = AppHost.Companion.getApplication().getSystemService("keyguard");
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        a = new t();
        c = LazyKt.lazy(e.a);
        d = new d();
        e = new GsonBuilder().registerTypeAdapter(AppEntity.class, new a()).create();
    }

    private t() {
    }

    public static /* synthetic */ IntentResult a(t r0, String r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = 1;
    L9:
        return r0.a(r1, r2);
    }

    private final IntentResult<?> a(String r14, int r15) {
        return new IntentResult(r15, null, null, r14, false, false, 0, null, null, null, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null);
    }

    private final <T> Constructor<T> a(Class<T> r1) {
        return r1.getConstructor(new Class[0]);
    }

    private final Type a(String r4) {
        return Class.forName(r4);
    L4:
        e = move-exception;
        Logger.INSTANCE.e(b, "queryIntentParamType -- invalid typeName=" + r4 + "; e=" + e);
        return null;
    }

    private final Object b(String r3, String r4, String r5) {
        Type r2 = a(r4);
        if (r2 != null) goto L10;
        return null;
    L10:
        return e.fromJson(r5, r2);
    L7:
        e = move-exception;
        Logger.INSTANCE.e(b, "handleIntentCalling -- parsing InputParams for intent: `" + r3 + "`: jsonException=" + e);
        return null;
    }

    private final KeyguardManager c() {
        return (KeyguardManager) c.getValue();
    }

    public final Gson a() {
        return e;
    }

    public final Boolean a(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r6, "jobId");
        d r4 = d;
        monitor-enter(r4);
        Set r0 = (Set) r4.get(r5);     // Catch: Throwable -> L22
        if (r0 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r0, "intentMap[messageId]");     // Catch: Throwable -> L22
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L22
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(((Pair) r2).getFirst(), r6) == false) goto L8;
    L13:
        Pair r3 = (Pair) r2;     // Catch: Throwable -> L22
    L16:
        monitor-exit(r4);
        if (r3 == null) goto L30;
        IntentFunction r7 = (IntentFunction) r3.getSecond();
        if (r7 != null) goto L21;
        return null;
    L21:
        return r7.isTaskOnGoing(new DispatchContext(AppHost.Companion.getApplication(), Long.valueOf(Long.parseLong(r5)), MapsKt.emptyMap()));
    L30:
        return null;
    L12:
        r2 = null;
        goto L13
    L15:
        r3 = null;
    L22:
        th = move-exception;
        throw th;
    }

    public final Object a(Context r18, IntentCalling r19, String r20, Continuation<? super IntentResult<?>> r21) {
        t r1 = this;
        Context r2 = r18;
        IntentCalling r3 = r19;
        if ((r21 instanceof b) == false) goto L7;
        b r4 = (b) r21;
        int r5 = r4.f;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.f = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.d;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.f;
        if (r7 == 0) goto L22;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        IntentCalling r8 = (IntentCalling) r4.c;
        r2 = (Context) r4.b;
        t r9 = (t) r4.a;
    L97:
        ResultKt.throwOnFailure(r0);     // Catch: Exception -> L18 ClassCastException -> L20
        t r16 = r9;
        r3 = r8;
        r1 = r16;
    L74:
        IntentResult r10 = (IntentResult) r0;     // Catch: Exception -> L78 ClassCastException -> L80
        if (r10 != null) goto L101;
        String r11 = r2.getString(R.string.obric_action_exec_started);
        Intrinsics.checkNotNullExpressionValue(r11, "context.getString(R.stri…bric_action_exec_started)");
        return new IntentResult(0, null, null, r11, false, false, 0, null, null, null, PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, null);
    L101:
        return r10;
    L80:
        ClassCastException e2 = e;
    L83:
        Logger.INSTANCE.e(b, "execIntentAsync -- the injection of InputParams for intent: `" + r3.getIntentName() + "` failed at execution; e=" + e2);
        String r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        int r13 = -1007;
    L28:
        return r1.a(r12, r13);
    L78:
        Exception e3 = e;
    L82:
        Logger.INSTANCE.e(b, "execIntentAsync -- the execution for intent: `" + r3.getIntentName() + "` failed; e=" + e3, e3);
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1008;
        goto L28
    L20:
        e2 = e;
        t r17 = r9;
        r3 = r8;
        r1 = r17;
    L18:
        e3 = e;
        t r110 = r9;
        r3 = r8;
        r1 = r110;
        goto L82
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r8 = (IntentCalling) r4.c;
        r2 = (Context) r4.b;
        r9 = (t) r4.a;
        goto L97
    L22:
        ResultKt.throwOnFailure(r0);
        Logger r14 = Logger.INSTANCE;
        r14.d(b, "handleIntentCalling = " + r19.getIntentName() + '/' + r19.getQuestionId());
        Class<?> r15 = Class.forName(r19.getImplClassName());     // Catch: ClassNotFoundException -> L90
        Intrinsics.checkNotNullExpressionValue(r15, "intentClazz");
        Constructor r22 = r1.a(r15);
        if (r22 != null) goto L95;
        r14.d(b, "handleIntentCalling - impl `" + r19.getImplClassName() + "`: no constructor");
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1001;
        goto L28
    L95:
        Object r23 = r22.newInstance(new Object[0]);     // Catch: Exception -> L88
        Class<?> r111 = null;
        if ((r23 instanceof IntentFunction) == false) goto L34;
        Object r24 = r23;
    L35:
        IntentFunction r25 = (IntentFunction) r24;
        if (r25 != null) goto L38;
        r14.d(b, "handleIntentCalling - impl `" + r19.getImplClassName() + "`: cannot cast intent object (" + r23 + ") to IntentFunction<Parcelable, *>");
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1003;
        goto L28
    L38:
        d r26 = d;
        monitor-enter(r26);
        String r112 = String.valueOf(r19.getQuestionId());     // Catch: Throwable -> L85
        Set r113 = r26.get(r112);     // Catch: Throwable -> L85
        if (r113 != null) goto L43;
        r113 = new LinkedHashSet();     // Catch: Throwable -> L85
        r26.put(r112, r113);     // Catch: Throwable -> L85
    L43:
        r113.add(TuplesKt.to(r20, r25));     // Catch: Throwable -> L85
        monitor-exit(r26);
        if (r19.getInputParamsParcel() == null) goto L49;
        Object r27 = r19.getInputParamsParcel();
        Intrinsics.checkNotNull(r27);
    L56:
        if ((r27 instanceof Parcelable) == false) goto L58;
        Object r114 = r27;
    L59:
        Parcelable r115 = (Parcelable) r114;
        if (r115 != null) goto L65;
        StringBuilder r28 = new StringBuilder("execIntentAsync -- casting InputParams for intent: `").append(r19.getIntentName()).append("` failed; required type = `Parcelable`; tried `");
        if (r27 == null) goto L64;
        r111 = r27.getClass();
    L64:
        r14.e(b, r28.append(r111).append('`').toString());
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1006;
        goto L28
    L65:
        DispatchContext r29 = new DispatchContext(r2, Boxing.boxLong(r19.getQuestionId()), r19.getExt());
        if (r25.isBlock() == false) goto L71;
        r4.a = r1;     // Catch: Exception -> L78 ClassCastException -> L80
        r4.b = r2;     // Catch: Exception -> L78 ClassCastException -> L80
        r4.c = r3;     // Catch: Exception -> L78 ClassCastException -> L80
        r4.f = 1;     // Catch: Exception -> L78 ClassCastException -> L80
        r0 = r25.doAction(r115, r29, r4);     // Catch: Exception -> L78 ClassCastException -> L80
        if (r0 != r6) goto L74;
        return r6;
    L71:
        c r30 = new c(r25, r115, r29, null);     // Catch: Exception -> L78 ClassCastException -> L80
        r4.a = r1;     // Catch: Exception -> L78 ClassCastException -> L80
        r4.b = r2;     // Catch: Exception -> L78 ClassCastException -> L80
        r4.c = r3;     // Catch: Exception -> L78 ClassCastException -> L80
        r4.f = 2;     // Catch: Exception -> L78 ClassCastException -> L80
        r0 = TimeoutKt.withTimeoutOrNull(WsConstants.EXIT_DELAY_TIME, r30, r4);     // Catch: Exception -> L78 ClassCastException -> L80
        if (r0 != r6) goto L74;
        return r6;
    L58:
        r114 = null;
        goto L59
    L49:
        if (r19.getInputParamTypeName() != null) goto L51;
    L84:
        r14.e(b, "handleIntentCalling -- InputParams not available: (" + r3 + ')');
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1005;
        goto L28
    L51:
        if (r19.getInputParams() == null) goto L84;
        String r31 = r19.getIntentName();
        String r116 = r19.getInputParamTypeName();
        Intrinsics.checkNotNull(r116);
        String r117 = r19.getInputParams();
        Intrinsics.checkNotNull(r117);
        r27 = r1.b(r31, r116, r117);
        if (r27 != null) goto L56;
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1004;
    L85:
        th = move-exception;
        throw th;
    L34:
        r24 = null;
    L88:
        e = move-exception;
        Logger.INSTANCE.e(b, "handleIntentCalling - impl `" + r19.getImplClassName() + "`: creation of intent object failed; e=" + e, e);
        r12 = r2.getString(R.string.obric_intent_app_exec_failed);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…c_intent_app_exec_failed)");
        r13 = -1002;
    L90:
        Logger.INSTANCE.d(b, "handleIntentCalling - impl `" + r19.getImplClassName() + "`: not found");
        r12 = r2.getString(R.string.obric_action_not_support);
        Intrinsics.checkNotNullExpressionValue(r12, "context.getString(R.stri…obric_action_not_support)");
        r13 = -1000;
    L7:
        r4 = new b(r1, r21);
        goto L8
    }

    public final boolean a(String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "messageId");
        Intrinsics.checkNotNullParameter(r6, "reason");
        Intrinsics.checkNotNullParameter(r7, "jobId");
        Logger.INSTANCE.i(b, "ready to cancel task messageId " + r5 + ", reason=" + r6);
        d r4 = d;
        monitor-enter(r4);
        Set r0 = (Set) r4.get(r5);     // Catch: Throwable -> L18
        Pair r1 = null;
        Object r2 = null;
        if (r0 == null) goto L13;
        Intrinsics.checkNotNullExpressionValue(r0, "intentMap[messageId]");     // Catch: Throwable -> L18
        Iterator r3 = r0.iterator();     // Catch: Throwable -> L18
    L8:
        if (r3.hasNext() == false) goto L12;
        Object r8 = r3.next();     // Catch: Throwable -> L18
        if (Intrinsics.areEqual(((Pair) r8).getFirst(), r7) == false) goto L8;
        r2 = r8;
    L12:
        r1 = (Pair) r2;     // Catch: Throwable -> L18
    L13:
        monitor-exit(r4);
        if (r1 == null) goto L16;
        boolean r9 = ((IntentFunction) r1.getSecond()).cancelTask(r6);
        Logger.INSTANCE.i(b, "Task cancellation for messageId " + r5 + ", jobId " + r7 + ": " + r9 + ", reason=" + r6);
        return r9;
    L16:
        Logger.INSTANCE.w(b, "No targetIntent found for messageId " + r5);
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    public final LinkedHashMap<String, Set<Pair<String, IntentFunction<?, ?>>>> b() {
        return d;
    }
}
