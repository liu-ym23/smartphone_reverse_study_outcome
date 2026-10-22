package com.stepos.ailauncher.chat.manager;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.common.utils.C3197a;
import com.stepos.ailauncher.network.model.DictionaryItem;
import com.stepos.ailauncher.network.repository.DictionaryRepository;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\b\u0010\u0006J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\t\u0010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b\n\u0010\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0004\b\f\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000e\u0010\u0006J\u0010\u0010\u000f\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u000f\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\rH\u0082@¢\u0006\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010#\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/manager/ChatConfigManager;", "", "<init>", "()V", "", "p", "(Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "o", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "l", "", "n", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "f", "r", "Lcom/stepos/ailauncher/network/repository/DictionaryRepository;", "repository$delegate", "LY8/h;", "m", "()Lcom/stepos/ailauncher/network/repository/DictionaryRepository;", "repository", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/ailauncher/network/model/DictionaryItem;", "configs", "Ljava/util/concurrent/ConcurrentHashMap;", "lastUpdateTime", "J", "", "retryLimit", "I", "tryCount", "k", "()Ljava/lang/String;", "pkgName", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "appVersion", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatConfigManager {
    private static final String KEY_LISTEN_TIMEOUT = "listen_timeout_s";
    private static final String KEY_LONG_PRESS_TIMEOUT = "long_press_timeout_s";
    private static final String KEY_PRESS_TO_TALK_RELEASE_GRACE = "press_to_talk_release_grace_ms";
    private static final String KEY_TTS_DEFAULT_VOICE_ID = "tts_default_voice_id";
    private static final String KEY_TTS_MODEL_NAME = "tts_model_name";
    private static final String KEY_VAD_SILENCE_DURATION = "vad_silence_duration_ms";
    private static final String KEY_WAKE_MUTE_TIMEOUT = "wake_mute_timeout_s";
    private long lastUpdateTime;
    private int tryCount;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<ChatConfigManager> instance$delegate = C4848b.a(LazyThreadSafetyMode.SYNCHRONIZED, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.b0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ChatConfigManager.q();
        }
    });

    /* renamed from: repository$delegate, reason: from kotlin metadata */
    private final Y8.h repository = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.manager.a0
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ChatConfigManager.t();
        }
    });
    private final ConcurrentHashMap<String, DictionaryItem> configs = new ConcurrentHashMap<>();
    private int retryLimit = 3;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/chat/manager/ChatConfigManager$a;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/manager/ChatConfigManager;", "instance$delegate", "LY8/h;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/manager/ChatConfigManager;", "instance", "", "KEY_WAKE_MUTE_TIMEOUT", "Ljava/lang/String;", "KEY_LISTEN_TIMEOUT", "KEY_VAD_SILENCE_DURATION", "KEY_LONG_PRESS_TIMEOUT", "KEY_PRESS_TO_TALK_RELEASE_GRACE", "KEY_TTS_MODEL_NAME", "KEY_TTS_DEFAULT_VOICE_ID", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.manager.ChatConfigManager$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final ChatConfigManager a() {
            return (ChatConfigManager) ChatConfigManager.instance$delegate.getValue();
        }

        public Companion() {
        }
    }

    public static final ChatConfigManager q() {
        return new ChatConfigManager();
    }

    public static final CharSequence s(Map.Entry it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.getKey() + "=" + ((DictionaryItem) it.getValue()).getValue();
    }

    public static final DictionaryRepository t() {
        return DictionaryRepository.INSTANCE.create(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[PHI: r2 r10
      0x008c: PHI (r2v3 java.lang.Long) = (r2v2 java.lang.Long), (r2v10 java.lang.Long) binds: [B:29:0x0089, B:19:0x0059] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r10v6 java.lang.Object) = (r10v5 java.lang.Object), (r10v1 java.lang.Object) binds: [B:29:0x0089, B:19:0x0059] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.f(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$applyTtsDefaultVoiceId$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$applyTtsDefaultVoiceId$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$applyTtsDefaultVoiceId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$applyTtsDefaultVoiceId$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$applyTtsDefaultVoiceId$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.n(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 != 0) goto L44
            Y8.t r4 = Y8.t.f7040a
            return r4
        L44:
            com.stepos.ailauncher.chat.manager.U0 r4 = com.stepos.ailauncher.chat.manager.U0.INSTANCE
            r4.w(r5)
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.g(e9.c):java.lang.Object");
    }

    public final String h() {
        return C6.a.INSTANCE.b(C3197a.INSTANCE.a());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(e9.InterfaceC4014c<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$getListenTimeoutMs$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getListenTimeoutMs$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$getListenTimeoutMs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getListenTimeoutMs$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$getListenTimeoutMs$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.network.model.DictionaryItem> r4 = r4.configs
            java.lang.String r5 = "listen_timeout_s"
            java.lang.Object r4 = r4.get(r5)
            com.stepos.ailauncher.network.model.DictionaryItem r4 = (com.stepos.ailauncher.network.model.DictionaryItem) r4
            if (r4 == 0) goto L62
            java.lang.String r4 = r4.getValue()
            if (r4 == 0) goto L62
            java.lang.Long r4 = La.C.y(r4)
            if (r4 == 0) goto L62
            long r4 = r4.longValue()
            r0 = 1000(0x3e8, float:1.401E-42)
            long r0 = (long) r0
            long r4 = r4 * r0
            java.lang.Long r4 = g9.C4109a.g(r4)
            return r4
        L62:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.i(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(e9.InterfaceC4014c<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$getLongPressTimeoutMs$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getLongPressTimeoutMs$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$getLongPressTimeoutMs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getLongPressTimeoutMs$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$getLongPressTimeoutMs$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.network.model.DictionaryItem> r4 = r4.configs
            java.lang.String r5 = "long_press_timeout_s"
            java.lang.Object r4 = r4.get(r5)
            com.stepos.ailauncher.network.model.DictionaryItem r4 = (com.stepos.ailauncher.network.model.DictionaryItem) r4
            if (r4 == 0) goto L62
            java.lang.String r4 = r4.getValue()
            if (r4 == 0) goto L62
            java.lang.Long r4 = La.C.y(r4)
            if (r4 == 0) goto L62
            long r4 = r4.longValue()
            r0 = 1000(0x3e8, float:1.401E-42)
            long r0 = (long) r0
            long r4 = r4 * r0
            java.lang.Long r4 = g9.C4109a.g(r4)
            return r4
        L62:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.j(e9.c):java.lang.Object");
    }

    public final String k() {
        String packageName = C3197a.INSTANCE.a().getPackageName();
        kotlin.jvm.internal.p.h(packageName, "getPackageName(...)");
        return packageName;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object l(e9.InterfaceC4014c<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$getPressToTalkReleaseGraceMs$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getPressToTalkReleaseGraceMs$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$getPressToTalkReleaseGraceMs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getPressToTalkReleaseGraceMs$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$getPressToTalkReleaseGraceMs$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.network.model.DictionaryItem> r4 = r4.configs
            java.lang.String r5 = "press_to_talk_release_grace_ms"
            java.lang.Object r4 = r4.get(r5)
            com.stepos.ailauncher.network.model.DictionaryItem r4 = (com.stepos.ailauncher.network.model.DictionaryItem) r4
            if (r4 == 0) goto L55
            java.lang.String r4 = r4.getValue()
            if (r4 == 0) goto L55
            java.lang.Long r4 = La.C.y(r4)
            return r4
        L55:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.l(e9.c):java.lang.Object");
    }

    public final DictionaryRepository m() {
        return (DictionaryRepository) this.repository.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(e9.InterfaceC4014c<? super java.lang.String> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$getTtsDefaultVoiceId$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getTtsDefaultVoiceId$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$getTtsDefaultVoiceId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getTtsDefaultVoiceId$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$getTtsDefaultVoiceId$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.network.model.DictionaryItem> r4 = r4.configs
            java.lang.String r5 = "tts_default_voice_id"
            java.lang.Object r4 = r4.get(r5)
            com.stepos.ailauncher.network.model.DictionaryItem r4 = (com.stepos.ailauncher.network.model.DictionaryItem) r4
            r5 = 0
            if (r4 == 0) goto L62
            java.lang.String r4 = r4.getValue()
            if (r4 == 0) goto L62
            java.lang.CharSequence r4 = La.H.D1(r4)
            java.lang.String r4 = r4.toString()
            if (r4 == 0) goto L62
            int r0 = r4.length()
            if (r0 <= 0) goto L62
            return r4
        L62:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.n(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(e9.InterfaceC4014c<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$getVadSilenceDurationMs$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getVadSilenceDurationMs$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$getVadSilenceDurationMs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getVadSilenceDurationMs$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$getVadSilenceDurationMs$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.network.model.DictionaryItem> r4 = r4.configs
            java.lang.String r5 = "vad_silence_duration_ms"
            java.lang.Object r4 = r4.get(r5)
            com.stepos.ailauncher.network.model.DictionaryItem r4 = (com.stepos.ailauncher.network.model.DictionaryItem) r4
            if (r4 == 0) goto L55
            java.lang.String r4 = r4.getValue()
            if (r4 == 0) goto L55
            java.lang.Long r4 = La.C.y(r4)
            return r4
        L55:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.o(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(e9.InterfaceC4014c<? super java.lang.Long> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stepos.ailauncher.chat.manager.ChatConfigManager$getWakeMuteTimeoutMs$1
            if (r0 == 0) goto L13
            r0 = r5
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getWakeMuteTimeoutMs$1 r0 = (com.stepos.ailauncher.chat.manager.ChatConfigManager$getWakeMuteTimeoutMs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.chat.manager.ChatConfigManager$getWakeMuteTimeoutMs$1 r0 = new com.stepos.ailauncher.chat.manager.ChatConfigManager$getWakeMuteTimeoutMs$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3d
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            r0.label = r3
            java.lang.Object r5 = r4.r(r0)
            if (r5 != r1) goto L3d
            return r1
        L3d:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.stepos.ailauncher.network.model.DictionaryItem> r4 = r4.configs
            java.lang.String r5 = "wake_mute_timeout_s"
            java.lang.Object r4 = r4.get(r5)
            com.stepos.ailauncher.network.model.DictionaryItem r4 = (com.stepos.ailauncher.network.model.DictionaryItem) r4
            if (r4 == 0) goto L63
            java.lang.String r4 = r4.getValue()
            if (r4 == 0) goto L63
            java.lang.Long r4 = La.C.y(r4)
            if (r4 == 0) goto L63
            long r4 = r4.longValue()
            r0 = 1000(0x3e8, float:1.401E-42)
            long r0 = (long) r0
            long r4 = r4 * r0
            java.lang.Long r4 = g9.C4109a.g(r4)
            return r4
        L63:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.p(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b6 -> B:31:0x00b9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.chat.manager.ChatConfigManager.r(e9.c):java.lang.Object");
    }
}
