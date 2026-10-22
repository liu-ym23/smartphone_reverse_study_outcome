package com.obric.capabilitykit;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Parcelable;
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
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.k0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f11407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f11408b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f11409c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Gson f11410d = null;

    public static final class a implements JsonDeserializer {
        public a() {
        }

        public AppEntity a(JsonElement r10, Type r11, JsonDeserializationContext r12) {
            Integer r13 = null;
            if (r10 == null) goto L5;
            JsonObject r14 = r10.getAsJsonObject();
        L6:
            if (r14 == null) goto L10;
            JsonElement r15 = r14.get("type");
            if (r15 == null) goto L10;
            r13 = Integer.valueOf(r15.getAsInt());
        L10:
            EntityClassData<? extends AppEntity> r16 = EntityType.INSTANCE.getClassMap().get(r13);
            if (r16 == null) goto L17;
            GenericDeclaration r17 = r16.getClazz();
            if (r17 == null) goto L17;
            Object r18 = UtilsKt.getGson().fromJson(r10, r17);
            kotlin.jvm.internal.q.f(r18, "gson.fromJson(json, targetClass)");
            return (AppEntity) r18;
        L17:
            throw new IllegalArgumentException("Unknown entity type: " + r13);
        L5:
            r14 = null;
            goto L6
        }

        @Override // com.google.gson.JsonDeserializer
        public /* bridge */ /* synthetic */ Object deserialize(JsonElement r10, Type r11, JsonDeserializationContext r12) {
            return a(r10, r11, r12);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor", f = "IntentExecutor.kt", i = {0, 0, 0, 1, 1, 1}, l = {124, 129}, m = "handleIntentCalling", n = {"this", "context", "intentCalling", "this", "context", "intentCalling"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f11411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f11412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f11413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f11414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ t f11415e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11416f;

        public b(t r10, Continuation<? super b> r11) {
            this.f11415e = r10;
            super(r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            this.f11414d = r10;
            this.f11416f |= Integer.MIN_VALUE;
            return this.f11415e.c(null, null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.capabilitykit.execution.IntentExecutor$handleIntentCalling$result$1", f = "IntentExecutor.kt", i = {}, l = {130}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntentResult<? extends Object>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IntentFunction<Parcelable, ?> f11418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Parcelable f11419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DispatchContext f11420d;

        public c(IntentFunction<Parcelable, ?> r10, Parcelable r11, DispatchContext r12, Continuation<? super c> r13) {
            this.f11418b = r10;
            this.f11419c = r11;
            this.f11420d = r12;
            super(2, r13);
        }

        @Nullable
        public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super IntentResult<? extends Object>> r11) {
            return ((c) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new c(this.f11418b, this.f11419c, this.f11420d, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super IntentResult<? extends Object>> r11) {
            return a(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r10) {
            Object r11 = kotlin.coroutines.intrinsics.a.d();
            int r12 = this.f11417a;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            kotlin.c.b(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r10);
            IntentFunction<Parcelable, ?> r13 = this.f11418b;
            Parcelable r14 = this.f11419c;
            DispatchContext r15 = this.f11420d;
            this.f11417a = 1;
            r10 = r13.doAction(r14, r15, this);
            if (r10 != r11) goto L11;
            return r11;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002R\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u00030\u0001j(\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003`\u0006J8\u0010\t\u001a\u00020\n2.\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u00040\u0003\u0018\u00010\fH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"com/obric/capabilitykit/execution/IntentExecutor$intentMap$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/Pair;", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "Lkotlin/collections/LinkedHashMap;", "MAX_SIZE", "", "removeEldestEntry", "", "eldest", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends LinkedHashMap<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f11421a;

        public d() {
            this.f11421a = 10;
        }

        public /* bridge */ Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> a() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> b() {
            return super.keySet();
        }

        public /* bridge */ int c() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return false;
        L7:
            return a((String) r10);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object r10) {
            if (y.m(r10) == true) goto L7;
            return false;
        L7:
            return a((Set) r10);
        }

        public /* bridge */ Collection<Set<Pair<String, IntentFunction<?, ?>>>> d() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Set<Pair<String, IntentFunction<?, ?>>>>> entrySet() {
            return a();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r10);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object r10, Object r11) {
            if ((r10 instanceof String) == true) goto L6;
            return r11;
        L6:
            return a((String) r10, (Set) r11);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return b();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r10);
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(@Nullable Map.Entry<String, Set<Pair<? extends String, ? extends IntentFunction<?, ?>>>> r10) {
            if (size() <= this.f11421a) goto L5;
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

        public final /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> a(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return b((String) r10);
        }

        public final /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> b(Object r10) {
            if ((r10 instanceof String) == true) goto L7;
            return null;
        L7:
            return c((String) r10);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> c(String r10) {
            return (Set) super.remove(r10);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object r10, Object r11) {
            if ((r10 instanceof String) == true) goto L6;
            return false;
        L6:
            if (y.m(r11) == true) goto L9;
            return false;
        L9:
            return b((String) r10, (Set) r11);
        }

        public final /* bridge */ Set a(Object r10, Set r11) {
            if ((r10 instanceof String) == true) goto L6;
            return r11;
        L6:
            return a((String) r10, r11);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> b(String r10) {
            return (Set) super.get(r10);
        }

        public /* bridge */ Set<Pair<String, IntentFunction<?, ?>>> a(String r10, Set<Pair<String, IntentFunction<?, ?>>> r11) {
            return (Set) super.getOrDefault(r10, r11);
        }

        public /* bridge */ boolean b(String r10, Set<Pair<String, IntentFunction<?, ?>>> r11) {
            return super.remove(r10, r11);
        }

        public /* bridge */ boolean a(String r10) {
            return super.containsKey(r10);
        }

        public /* bridge */ boolean a(Set<Pair<String, IntentFunction<?, ?>>> r10) {
            return super.containsValue(r10);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/KeyguardManager;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<KeyguardManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f11422a = null;

        static {
            f11422a = new e();
        }

        public e() {
            super(0);
        }

        @NotNull
        public final KeyguardManager a() {
            Object r10 = AppHost.Companion.getApplication().getSystemService("keyguard");
            kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type android.app.KeyguardManager");
            return (KeyguardManager) r10;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KeyguardManager invoke() {
            return a();
        }
    }

    static {
        f11407a = new t();
        f11408b = kotlin.b.b(e.f11422a);
        f11409c = new d();
        f11410d = new GsonBuilder().registerTypeAdapter(AppEntity.class, new a()).create();
    }

    public t() {
    }

    public final IntentResult a(String r14, int r15) {
        return new IntentResult(r15, null, null, r14, false, false, 0, null, null, null, 1014, null);
    }

    public final Boolean b(String r10, String r11) {
        kotlin.jvm.internal.q.g(r10, "messageId");
        kotlin.jvm.internal.q.g(r11, "jobId");
        d r12 = f11409c;
        monitor-enter(r12);
        Set r13 = (Set) r12.get(r10);     // Catch: Throwable -> L12
        if (r13 == null) goto L17;
        kotlin.jvm.internal.q.f(r13, "intentMap[messageId]");     // Catch: Throwable -> L12
        Iterator r14 = r13.iterator();     // Catch: Throwable -> L12
    L8:
        if (r14.hasNext() == false) goto L14;
        Object r15 = r14.next();     // Catch: Throwable -> L12
        if (kotlin.jvm.internal.q.b(((Pair) r15).getFirst(), r11) == false) goto L8;
    L15:
        Pair r16 = (Pair) r15;     // Catch: Throwable -> L12
    L18:
        monitor-exit(r12);
        if (r16 == null) goto L31;
        IntentFunction r17 = (IntentFunction) r16.getSecond();
        if (r17 != null) goto L23;
        return null;
    L23:
        return r17.isTaskOnGoing(new DispatchContext(AppHost.Companion.getApplication(), Long.valueOf(Long.parseLong(r10)), k0.h()));
    L31:
        return null;
    L14:
        r15 = null;
        goto L15
    L17:
        r16 = null;
    L12:
        th = move-exception;
        throw th;
    }

    public final Object c(Context r18, IntentCalling r19, String r20, Continuation r21) {
        t r10 = this;
        Context r11 = r18;
        IntentCalling r12 = r19;
        if ((r21 instanceof b) == false) goto L7;
        b r13 = (b) r21;
        int r14 = r13.f11416f;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.f11416f = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.f11414d;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.f11416f;
        if (r17 == 0) goto L22;
        if (r17 == 1) goto L21;
        if (r17 != 2) goto L20;
        IntentCalling r22 = (IntentCalling) r13.f11413c;
        r11 = (Context) r13.f11412b;
        t r23 = (t) r13.f11411a;
    L100:
        kotlin.c.b(r15);     // Catch: Exception -> L15 ClassCastException -> L17
        t r110 = r23;
        r12 = r22;
        r10 = r110;
    L80:
        IntentResult r24 = (IntentResult) r15;     // Catch: Exception -> L73 ClassCastException -> L75
        if (r24 != null) goto L102;
        String r25 = r11.getString(R$string.obric_action_exec_started);
        kotlin.jvm.internal.q.f(r25, "context.getString(R.stri…bric_action_exec_started)");
        return new IntentResult(0, null, null, r25, false, false, 0, null, null, null, 1014, null);
    L102:
        return r24;
    L75:
        ClassCastException e10 = e;
    L85:
        Logger.INSTANCE.e("IntentExecutor", "execIntentAsync -- the injection of InputParams for intent: `" + r12.getIntentName() + "` failed at execution; e=" + e10);
        String r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        int r27 = -1007;
    L28:
        return r10.a(r26, r27);
    L73:
        Exception e11 = e;
    L84:
        Logger.INSTANCE.e("IntentExecutor", "execIntentAsync -- the execution for intent: `" + r12.getIntentName() + "` failed; e=" + e11, e11);
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1008;
        goto L28
    L17:
        e10 = e;
        t r111 = r23;
        r12 = r22;
        r10 = r111;
    L15:
        e11 = e;
        t r112 = r23;
        r12 = r22;
        r10 = r112;
        goto L84
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L21:
        r22 = (IntentCalling) r13.f11413c;
        r11 = (Context) r13.f11412b;
        r23 = (t) r13.f11411a;
        goto L100
    L22:
        kotlin.c.b(r15);
        Logger r28 = Logger.INSTANCE;
        r28.d("IntentExecutor", "handleIntentCalling = " + r19.getIntentName() + '/' + r19.getQuestionId());
        Class<?> r29 = Class.forName(r19.getImplClassName());     // Catch: ClassNotFoundException -> L91
        kotlin.jvm.internal.q.f(r29, "intentClazz");
        Constructor r30 = r10.d(r29);
        if (r30 != null) goto L29;
        r28.d("IntentExecutor", "handleIntentCalling - impl `" + r19.getImplClassName() + "`: no constructor");
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1001;
        goto L28
    L29:
        Class<?> r31 = null;
        Object r32 = r30.newInstance(null);     // Catch: Exception -> L89
        if ((r32 instanceof IntentFunction) == false) goto L34;
        Object r113 = r32;
    L35:
        IntentFunction r114 = (IntentFunction) r113;
        if (r114 != null) goto L38;
        r28.d("IntentExecutor", "handleIntentCalling - impl `" + r19.getImplClassName() + "`: cannot cast intent object (" + r32 + ") to IntentFunction<Parcelable, *>");
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1003;
        goto L28
    L38:
        d r33 = f11409c;
        monitor-enter(r33);
        String r115 = String.valueOf(r19.getQuestionId());     // Catch: Throwable -> L43
        Set r116 = r33.get(r115);     // Catch: Throwable -> L43
        if (r116 != null) goto L45;
        r116 = new LinkedHashSet();     // Catch: Throwable -> L43
        r33.put(r115, r116);     // Catch: Throwable -> L43
    L45:
        r116.add(kotlin.d.a(r20, r114));     // Catch: Throwable -> L43
        monitor-exit(r33);
        if (r19.getInputParamsParcel() == null) goto L51;
        Object r34 = r19.getInputParamsParcel();
        kotlin.jvm.internal.q.d(r34);
    L58:
        if ((r34 instanceof Parcelable) == false) goto L60;
        Object r117 = r34;
    L61:
        Parcelable r118 = (Parcelable) r117;
        if (r118 != null) goto L67;
        StringBuilder r35 = new StringBuilder();
        r35.append("execIntentAsync -- casting InputParams for intent: `");
        r35.append(r19.getIntentName());
        r35.append("` failed; required type = `Parcelable`; tried `");
        if (r34 == null) goto L66;
        r31 = r34.getClass();
    L66:
        r35.append(r31);
        r35.append('`');
        r28.e("IntentExecutor", r35.toString());
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1006;
        goto L28
    L67:
        DispatchContext r36 = new DispatchContext(r11, tf.a.d(r19.getQuestionId()), r19.getExt());
        if (r114.isBlock() == false) goto L77;
        r13.f11411a = r10;     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11412b = r11;     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11413c = r12;     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11416f = 1;     // Catch: Exception -> L73 ClassCastException -> L75
        r15 = r114.doAction(r118, r36, r13);     // Catch: Exception -> L73 ClassCastException -> L75
        if (r15 != r16) goto L80;
        return r16;
    L77:
        c r37 = new c(r114, r118, r36, null);     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11411a = r10;     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11412b = r11;     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11413c = r12;     // Catch: Exception -> L73 ClassCastException -> L75
        r13.f11416f = 2;     // Catch: Exception -> L73 ClassCastException -> L75
        r15 = TimeoutKt.d(WsConstants.EXIT_DELAY_TIME, r37, r13);     // Catch: Exception -> L73 ClassCastException -> L75
        if (r15 != r16) goto L80;
        return r16;
    L60:
        r117 = null;
        goto L61
    L51:
        if (r19.getInputParamTypeName() != null) goto L53;
    L86:
        r28.e("IntentExecutor", "handleIntentCalling -- InputParams not available: (" + r12 + ')');
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1005;
        goto L28
    L53:
        if (r19.getInputParams() == null) goto L86;
        String r38 = r19.getIntentName();
        String r119 = r19.getInputParamTypeName();
        kotlin.jvm.internal.q.d(r119);
        String r120 = r19.getInputParams();
        kotlin.jvm.internal.q.d(r120);
        r34 = r10.g(r38, r119, r120);
        if (r34 != null) goto L58;
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1004;
    L43:
        th = move-exception;
        throw th;
    L34:
        r113 = null;
    L89:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "handleIntentCalling - impl `" + r19.getImplClassName() + "`: creation of intent object failed; e=" + e, e);
        r26 = r11.getString(R$string.obric_intent_app_exec_failed);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…c_intent_app_exec_failed)");
        r27 = -1002;
    L91:
        Logger.INSTANCE.d("IntentExecutor", "handleIntentCalling - impl `" + r19.getImplClassName() + "`: not found");
        r26 = r11.getString(R$string.obric_action_not_support);
        kotlin.jvm.internal.q.f(r26, "context.getString(R.stri…obric_action_not_support)");
        r27 = -1000;
    L7:
        r13 = new b(r10, r21);
        goto L8
    }

    public final Constructor d(Class r10) {
        return r10.getConstructor(null);
    }

    public final Type e(String r10) {
        return Class.forName(r10);
    L4:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "queryIntentParamType -- invalid typeName=" + r10 + "; e=" + e);
        return null;
    }

    public final boolean f(String r10, String r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "messageId");
        kotlin.jvm.internal.q.g(r11, "reason");
        kotlin.jvm.internal.q.g(r12, "jobId");
        Logger.INSTANCE.i("IntentExecutor", "ready to cancel task messageId " + r10 + ", reason=" + r11);
        d r13 = f11409c;
        monitor-enter(r13);
        Set r14 = (Set) r13.get(r10);     // Catch: Throwable -> L12
        Pair r15 = null;
        Object r16 = null;
        if (r14 == null) goto L15;
        kotlin.jvm.internal.q.f(r14, "intentMap[messageId]");     // Catch: Throwable -> L12
        Iterator r17 = r14.iterator();     // Catch: Throwable -> L12
    L8:
        if (r17.hasNext() == false) goto L14;
        Object r18 = r17.next();     // Catch: Throwable -> L12
        if (kotlin.jvm.internal.q.b(((Pair) r18).getFirst(), r12) == false) goto L8;
        r16 = r18;
    L14:
        r15 = (Pair) r16;     // Catch: Throwable -> L12
    L15:
        monitor-exit(r13);
        if (r15 == null) goto L18;
        boolean r19 = ((IntentFunction) r15.getSecond()).cancelTask(r11);
        Logger.INSTANCE.i("IntentExecutor", "Task cancellation for messageId " + r10 + ", jobId " + r12 + ": " + r19 + ", reason=" + r11);
        return r19;
    L18:
        Logger.INSTANCE.w("IntentExecutor", "No targetIntent found for messageId " + r10);
        return false;
    L12:
        th = move-exception;
        throw th;
    }

    public final Object g(String r10, String r11, String r12) {
        Type r13 = e(r11);
        if (r13 != null) goto L10;
        return null;
    L10:
        return f11410d.fromJson(r12, r13);
    L7:
        e = move-exception;
        Logger.INSTANCE.e("IntentExecutor", "handleIntentCalling -- parsing InputParams for intent: `" + r10 + "`: jsonException=" + e);
        return null;
    }

    public final LinkedHashMap h() {
        return f11409c;
    }
}
