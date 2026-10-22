package com.stepos.ailauncher.network.repository;

import La.H;
import Ua.C1060i;
import Ua.M;
import Ua.Y;
import Y8.h;
import Y8.t;
import Z8.C1173v;
import Z8.C1174w;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.network.model.DictionaryItem;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import h8.C4148a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import o6.C5009a;
import org.json.JSONArray;
import org.json.JSONObject;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0012J!\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0005H\u0086@¢\u0006\u0004\b\u001c\u0010\u0007J/\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u000e0\u001d¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010'\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010.\u001a\n -*\u0004\u0018\u00010,0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u0010\u0012R\u0014\u00109\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u0010\u0012¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/network/repository/DictionaryRepositoryManager;", "", "<init>", "()V", "", "", "refreshAndCacheSuggestions", "(Le9/c;)Ljava/lang/Object;", "getCachedSuggestions", "()Ljava/util/List;", "", "shouldRefresh", "()Z", "suggestions", "LY8/t;", "saveSuggestionsCache", "(Ljava/util/List;)V", "cacheDataKey", "()Ljava/lang/String;", "cacheTimeKey", "Lcom/stepos/ailauncher/network/model/DictionaryItem;", "item", "parseSuggestionsFromDictionary", "(Lcom/stepos/ailauncher/network/model/DictionaryItem;)Ljava/util/List;", "LUa/M;", "scope", "preloadUiConfig", "(LUa/M;)V", "loadSettingsVoiceList", "Lkotlin/Function1;", "onSuggestionsReady", "loadSuggestionsForChatPage", "(LUa/M;Lp9/l;)V", "TAG", "Ljava/lang/String;", "KEY_HOME_CARD", "KEY_VOICE_DETAILS", "CACHE_PREFIX", "", "CACHE_TTL_MS", "J", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "suggestionListType", "Ljava/lang/reflect/Type;", "Lcom/stepos/ailauncher/network/repository/DictionaryRepository;", "repository$delegate", "LY8/h;", "getRepository", "()Lcom/stepos/ailauncher/network/repository/DictionaryRepository;", "repository", "getPkgName", "pkgName", "getAppVersion", "appVersion", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DictionaryRepositoryManager {
    private static final String CACHE_PREFIX = "dictionary_suggestions_cache";
    private static final long CACHE_TTL_MS = 21600000;
    private static final String KEY_HOME_CARD = "home_card";
    private static final String KEY_VOICE_DETAILS = "voices-details";
    private static final String TAG = "DictionaryRepositoryManager";
    public static final DictionaryRepositoryManager INSTANCE = new DictionaryRepositoryManager();
    private static final Gson gson = new Gson();
    private static final Type suggestionListType = new TypeToken<List<? extends String>>() { // from class: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$suggestionListType$1
    }.getType();

    /* renamed from: repository$delegate, reason: from kotlin metadata */
    private static final h repository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.network.repository.a
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return DictionaryRepositoryManager.repository_delegate$lambda$0();
        }
    });

    @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.DictionaryRepositoryManager", f = "DictionaryRepositoryManager.kt", l = {52}, m = "loadSettingsVoiceList", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSettingsVoiceList$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryRepositoryManager.this.loadSettingsVoiceList(this);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSuggestionsForChatPage$1", f = "DictionaryRepositoryManager.kt", l = {64, 66}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSuggestionsForChatPage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C33781 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ InterfaceC5074l<List<String>, t> $onSuggestionsReady;
        Object L$0;
        int label;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
        @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSuggestionsForChatPage$1$1", f = "DictionaryRepositoryManager.kt", l = {}, m = "invokeSuspend", v = 1)
        /* renamed from: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSuggestionsForChatPage$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03211 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ InterfaceC5074l<List<String>, t> $onSuggestionsReady;
            final /* synthetic */ List<String> $refreshed;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C03211(InterfaceC5074l<? super List<String>, t> interfaceC5074l, List<String> list, InterfaceC4014c<? super C03211> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$onSuggestionsReady = interfaceC5074l;
                this.$refreshed = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                return new C03211(this.$onSuggestionsReady, this.$refreshed, interfaceC4014c);
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((C03211) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                C4063a.g();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                this.$onSuggestionsReady.invoke(this.$refreshed);
                return t.f7040a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C33781(InterfaceC5074l<? super List<String>, t> interfaceC5074l, InterfaceC4014c<? super C33781> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$onSuggestionsReady = interfaceC5074l;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C33781(this.$onSuggestionsReady, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C33781) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        
            if (Ua.C1056g.j(r1, r3, r6) == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r6 = r6.L$0
                java.util.List r6 = (java.util.List) r6
                kotlin.C4849c.b(r7)
                goto L59
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L1e:
                kotlin.C4849c.b(r7)
                goto L30
            L22:
                kotlin.C4849c.b(r7)
                com.stepos.ailauncher.network.repository.DictionaryRepositoryManager r7 = com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.INSTANCE
                r6.label = r3
                java.lang.Object r7 = com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.access$refreshAndCacheSuggestions(r7, r6)
                if (r7 != r0) goto L30
                goto L58
            L30:
                java.util.List r7 = (java.util.List) r7
                r1 = r7
                java.util.Collection r1 = (java.util.Collection) r1
                if (r1 == 0) goto L59
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L3e
                goto L59
            L3e:
                Ua.A0 r1 = Ua.Y.c()
                com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSuggestionsForChatPage$1$1 r3 = new com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSuggestionsForChatPage$1$1
                p9.l<java.util.List<java.lang.String>, Y8.t> r4 = r6.$onSuggestionsReady
                r5 = 0
                r3.<init>(r4, r7, r5)
                java.lang.Object r7 = g9.h.a(r7)
                r6.L$0 = r7
                r6.label = r2
                java.lang.Object r6 = Ua.C1056g.j(r1, r3, r6)
                if (r6 != r0) goto L59
            L58:
                return r0
            L59:
                Y8.t r6 = Y8.t.f7040a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.C33781.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$preloadUiConfig$1", f = "DictionaryRepositoryManager.kt", l = {41}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$preloadUiConfig$1, reason: invalid class name and case insensitive filesystem */
    public static final class C33791 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        int label;

        public C33791(InterfaceC4014c<? super C33791> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new C33791(interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((C33791) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                DictionaryRepositoryManager dictionaryRepositoryManager = DictionaryRepositoryManager.INSTANCE;
                if (dictionaryRepositoryManager.shouldRefresh()) {
                    this.label = 1;
                    if (dictionaryRepositoryManager.refreshAndCacheSuggestions(this) == objG) {
                        return objG;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            return t.f7040a;
        }
    }

    @InterfaceC4112d(c = "com.stepos.ailauncher.network.repository.DictionaryRepositoryManager", f = "DictionaryRepositoryManager.kt", l = {76}, m = "refreshAndCacheSuggestions", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$refreshAndCacheSuggestions$1, reason: invalid class name and case insensitive filesystem */
    public static final class C33801 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C33801(InterfaceC4014c<? super C33801> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DictionaryRepositoryManager.this.refreshAndCacheSuggestions(this);
        }
    }

    private DictionaryRepositoryManager() {
    }

    private final String cacheDataKey() {
        return "dictionary_suggestions_cache:" + getPkgName() + ":home_card:data";
    }

    private final String cacheTimeKey() {
        return "dictionary_suggestions_cache:" + getPkgName() + ":home_card:time";
    }

    private final String getAppVersion() {
        return C6.a.INSTANCE.b(C3197a.INSTANCE.a());
    }

    private final List<String> getCachedSuggestions() {
        String strT = C5009a.t(C5009a.INSTANCE, cacheDataKey(), null, false, 6, null);
        if (H.x0(strT)) {
            return null;
        }
        try {
            List list = (List) gson.fromJson(strT, suggestionListType);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (!H.x0((String) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(H.D1((String) it.next()).toString());
                }
                if (!arrayList2.isEmpty()) {
                    return arrayList2;
                }
            }
            return null;
        } catch (Exception e10) {
            C4148a.t(TAG, "getCachedSuggestions parse failed", e10, false, 8, null);
            return null;
        }
    }

    private final String getPkgName() {
        String packageName = C3197a.INSTANCE.a().getPackageName();
        kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
        return packageName;
    }

    private final DictionaryRepository getRepository() {
        return (DictionaryRepository) repository.getValue();
    }

    private final List<String> parseSuggestionsFromDictionary(DictionaryItem item) {
        String value;
        if (item != null && (value = item.getValue()) != null) {
            try {
                JSONArray jSONArrayOptJSONArray = new JSONObject(value).optJSONArray(DidiCardProvider.KEY_ITEMS);
                if (jSONArrayOptJSONArray == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                    String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("text") : null;
                    if (strOptString == null) {
                        strOptString = "";
                    }
                    String string = H.D1(strOptString).toString();
                    if (string.length() > 0) {
                        arrayList.add(string);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            } catch (Exception e10) {
                C4148a.t(TAG, "parseSuggestionsFromDictionary failed", e10, false, 8, null);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshAndCacheSuggestions(e9.InterfaceC4014c<? super java.util.List<java.lang.String>> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.C33801
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$refreshAndCacheSuggestions$1 r0 = (com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.C33801) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$refreshAndCacheSuggestions$1 r0 = new com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$refreshAndCacheSuggestions$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r7)     // Catch: java.lang.Exception -> L61
            goto L4b
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.C4849c.b(r7)
            com.stepos.ailauncher.network.repository.DictionaryRepository r7 = r6.getRepository()     // Catch: java.lang.Exception -> L61
            java.lang.String r2 = r6.getPkgName()     // Catch: java.lang.Exception -> L61
            java.lang.String r4 = r6.getAppVersion()     // Catch: java.lang.Exception -> L61
            java.lang.String r5 = "home_card"
            r0.label = r3     // Catch: java.lang.Exception -> L61
            java.lang.Object r7 = r7.queryByKey(r2, r4, r5, r0)     // Catch: java.lang.Exception -> L61
            if (r7 != r1) goto L4b
            return r1
        L4b:
            com.stepos.ailauncher.network.model.DictionaryItem r7 = (com.stepos.ailauncher.network.model.DictionaryItem) r7     // Catch: java.lang.Exception -> L61
            java.util.List r7 = r6.parseSuggestionsFromDictionary(r7)     // Catch: java.lang.Exception -> L61
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L61
            if (r0 == 0) goto L60
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Exception -> L61
            if (r0 == 0) goto L5d
            goto L60
        L5d:
            r6.saveSuggestionsCache(r7)     // Catch: java.lang.Exception -> L61
        L60:
            return r7
        L61:
            r0 = move-exception
            r6 = r0
            r2 = r6
            r4 = 8
            r5 = 0
            java.lang.String r0 = "DictionaryRepositoryManager"
            java.lang.String r1 = "refreshAndCacheSuggestions failed"
            r3 = 0
            h8.C4148a.t(r0, r1, r2, r3, r4, r5)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.refreshAndCacheSuggestions(e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DictionaryRepository repository_delegate$lambda$0() {
        return DictionaryRepository.INSTANCE.create(false);
    }

    private final void saveSuggestionsCache(List<String> suggestions) {
        C5009a c5009a = C5009a.INSTANCE;
        String strCacheDataKey = cacheDataKey();
        String json = gson.toJson(suggestions);
        kotlin.jvm.internal.p.h(json, "toJson(...)");
        C5009a.G(c5009a, strCacheDataKey, json, false, 4, null);
        C5009a.E(c5009a, cacheTimeKey(), System.currentTimeMillis(), false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldRefresh() {
        List<String> cachedSuggestions = getCachedSuggestions();
        if (cachedSuggestions == null || cachedSuggestions.isEmpty()) {
            return true;
        }
        long jO = C5009a.o(C5009a.INSTANCE, cacheTimeKey(), 0L, false, 4, null);
        return jO <= 0 || System.currentTimeMillis() - jO > 21600000;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadSettingsVoiceList(e9.InterfaceC4014c<? super java.lang.String> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSettingsVoiceList$1 r0 = (com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSettingsVoiceList$1 r0 = new com.stepos.ailauncher.network.repository.DictionaryRepositoryManager$loadSettingsVoiceList$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L4c
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            com.stepos.ailauncher.network.repository.DictionaryRepository r5 = r4.getRepository()
            java.lang.String r2 = r4.getPkgName()
            java.lang.String r4 = r4.getAppVersion()
            r0.label = r3
            java.lang.String r3 = "voices-details"
            java.lang.Object r5 = r5.queryByKey(r2, r4, r3, r0)
            if (r5 != r1) goto L4c
            return r1
        L4c:
            com.stepos.ailauncher.network.model.DictionaryItem r5 = (com.stepos.ailauncher.network.model.DictionaryItem) r5
            if (r5 == 0) goto L55
            java.lang.String r4 = r5.getValue()
            return r4
        L55:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.network.repository.DictionaryRepositoryManager.loadSettingsVoiceList(e9.c):java.lang.Object");
    }

    public final void loadSuggestionsForChatPage(M scope, InterfaceC5074l<? super List<String>, t> onSuggestionsReady) {
        kotlin.jvm.internal.p.i(scope, "scope");
        kotlin.jvm.internal.p.i(onSuggestionsReady, "onSuggestionsReady");
        List<String> cachedSuggestions = getCachedSuggestions();
        if (cachedSuggestions == null) {
            cachedSuggestions = C1173v.m();
        }
        onSuggestionsReady.invoke(cachedSuggestions);
        if (shouldRefresh()) {
            C1060i.d(scope, Y.b(), null, new C33781(onSuggestionsReady, null), 2, null);
        }
    }

    public final void preloadUiConfig(M scope) {
        kotlin.jvm.internal.p.i(scope, "scope");
        C1060i.d(scope, Y.b(), null, new C33791(null), 2, null);
    }
}
