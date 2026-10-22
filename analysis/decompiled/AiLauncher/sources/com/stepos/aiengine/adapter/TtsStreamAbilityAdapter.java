package com.stepos.aiengine.adapter;

import La.H;
import La.K;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.TtsStreamAbilityAdapter;
import com.stepos.aiengine.algorithm.tts.ITtsStreamSession;
import com.stepos.aiengine.algorithm.tts.ITtsStreaming;
import com.stepos.aiengine.algorithm.tts.TtsStreamListener;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.trace.AiTraceKeys;
import com.stepos.aiengine.args.ExecutionBundle;
import com.stepos.core.AbilityHandle;
import com.stepos.core.InferenceCallback;
import com.stepos.core.callback.InferResult;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.TextContent;
import com.stepos.core.data.base.Content;
import com.stepos.core.error.AIEngineError;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0016B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/aiengine/adapter/TtsStreamAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/tts/ITtsStreaming;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", M5.b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener;", "listener", "Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;", "openSession", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Lcom/stepos/aiengine/algorithm/tts/TtsStreamListener;)Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;", "Lcom/stepos/core/data/ContentParams;", Const.INTENT_KEY_PKGNAME, "(Landroid/os/Bundle;)Lcom/stepos/core/data/ContentParams;", "c", "Lcom/stepos/core/data/ContentParams$Builder;", "builder", "", Const.INTENT_KEY_APIKEY, "(Landroid/os/Bundle;Lcom/stepos/core/data/ContentParams$Builder;)Z", "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TtsStreamAbilityAdapter implements ITtsStreaming {

    @Deprecated
    public static final String MSG_OPEN_REJECTED = "语音合成暂不可用，请稍后重试";

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR$\u0010\f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/aiengine/adapter/TtsStreamAbilityAdapter$b;", "Lcom/stepos/aiengine/algorithm/tts/ITtsStreamSession;", "Lcom/stepos/core/AbilityHandle;", "handle", "", "inferId", "Lcom/stepos/aiengine/adapter/TtsStreamResultDispatcher;", "dispatcher", "Landroid/os/Bundle;", "executionParams", "Lkotlin/Function1;", "Lcom/stepos/core/data/ContentParams;", "paramsBuilder", "<init>", "(Lcom/stepos/core/AbilityHandle;Ljava/lang/String;Lcom/stepos/aiengine/adapter/TtsStreamResultDispatcher;Landroid/os/Bundle;Lp9/l;)V", "text", "", "feedText", "(Ljava/lang/String;)Z", "LY8/t;", "close", "()V", "cancel", "()Z", "isOpen", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "c", "Lcom/stepos/aiengine/adapter/TtsStreamResultDispatcher;", Const.INTENT_KEY_UMID, "Lp9/l;", "e", "Landroid/os/Bundle;", "executionParamsRef", "Ljava/util/concurrent/atomic/AtomicBoolean;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "inputClosed", Const.INTENT_KEY_BACKGROUND_COMMAND, "terminated", "Ljava/util/concurrent/atomic/AtomicInteger;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/atomic/AtomicInteger;", "feedSeq", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ITtsStreamSession {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AbilityHandle handle;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final String inferId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final TtsStreamResultDispatcher dispatcher;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5074l<Bundle, ContentParams> paramsBuilder;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public final Bundle executionParamsRef;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final AtomicBoolean inputClosed;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public final AtomicBoolean terminated;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public final AtomicInteger feedSeq;

        /* JADX WARN: Multi-variable type inference failed */
        public b(AbilityHandle handle, String inferId, TtsStreamResultDispatcher dispatcher, Bundle bundle, InterfaceC5074l<? super Bundle, ContentParams> paramsBuilder) {
            p.i(handle, "handle");
            p.i(inferId, "inferId");
            p.i(dispatcher, "dispatcher");
            p.i(paramsBuilder, "paramsBuilder");
            this.handle = handle;
            this.inferId = inferId;
            this.dispatcher = dispatcher;
            this.paramsBuilder = paramsBuilder;
            this.executionParamsRef = bundle;
            this.inputClosed = new AtomicBoolean(false);
            this.terminated = new AtomicBoolean(false);
            this.feedSeq = new AtomicInteger(0);
        }

        public final void a() {
            this.terminated.set(true);
            this.inputClosed.set(true);
        }

        @Override // com.stepos.aiengine.algorithm.tts.ITtsStreamSession
        public boolean cancel() {
            if (!this.terminated.compareAndSet(false, true)) {
                return false;
            }
            this.inputClosed.set(true);
            this.dispatcher.notifyUserCancelled();
            this.handle.cancel(this.inferId);
            return true;
        }

        @Override // com.stepos.aiengine.algorithm.tts.ITtsStreamSession
        public void close() {
            if (this.inputClosed.compareAndSet(false, true)) {
                TextContent textContent = new TextContent("");
                textContent.setParams(new ContentParams.Builder().putBoolean(TtsStreamResultDispatcher.KEY_TTS_FEED_EOF, true).putInt(TtsStreamResultDispatcher.KEY_TTS_FEED_TOTAL, this.feedSeq.get()).build());
                this.handle.feedInput(this.inferId, textContent);
                this.handle.completeInput(this.inferId);
            }
        }

        @Override // com.stepos.aiengine.algorithm.tts.ITtsStreamSession
        public boolean feedText(String text) {
            p.i(text, "text");
            if (this.inputClosed.get() || this.terminated.get()) {
                return false;
            }
            if (text.length() == 0) {
                return true;
            }
            int andIncrement = this.feedSeq.getAndIncrement();
            TextContent textContent = new TextContent(text);
            ContentParams contentParamsInvoke = this.paramsBuilder.invoke(this.executionParamsRef);
            if (contentParamsInvoke == null) {
                contentParamsInvoke = ContentParams.INSTANCE.empty();
            }
            textContent.setParams(contentParamsInvoke.withInt(TtsStreamResultDispatcher.KEY_TTS_FEED_SEQ, andIncrement));
            this.handle.feedInput(this.inferId, textContent);
            return true;
        }

        @Override // com.stepos.aiengine.algorithm.tts.ITtsStreamSession
        public boolean isOpen() {
            return !this.terminated.get();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.aiengine.adapter.TtsStreamAbilityAdapter$openSession$1, reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements InterfaceC5074l<Bundle, ContentParams> {
        public AnonymousClass1(Object obj) {
            super(1, obj, TtsStreamAbilityAdapter.class, "buildTtsStreamParams", "buildTtsStreamParams(Landroid/os/Bundle;)Lcom/stepos/core/data/ContentParams;", 0);
        }

        @Override // p9.InterfaceC5074l
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public final ContentParams invoke(Bundle bundle) {
            return ((TtsStreamAbilityAdapter) this.receiver).c(bundle);
        }
    }

    public TtsStreamAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    public final boolean a(Bundle args, ContentParams.Builder builder) {
        boolean z10;
        ExecutionBundle.Companion companion = ExecutionBundle.INSTANCE;
        if (companion.hasExecutionParams(args)) {
            companion.fromBundle(args).applyTo(builder);
            z10 = true;
        } else {
            z10 = false;
        }
        String string = args.getString("tts.voice");
        if (string != null) {
            if (H.x0(string)) {
                string = null;
            }
            if (string != null) {
                builder.putString("tts.voice", string);
                z10 = true;
            }
        }
        String string2 = args.getString("tts.instruction");
        if (string2 != null) {
            if (H.x0(string2)) {
                string2 = null;
            }
            if (string2 != null) {
                builder.putString("tts.instruction", string2);
                z10 = true;
            }
        }
        if (args.containsKey("tts.speed")) {
            builder.putFloat("tts.speed", args.getFloat("tts.speed", 1.0f));
            z10 = true;
        }
        if (args.containsKey("tts.volume")) {
            builder.putFloat("tts.volume", args.getFloat("tts.volume", 1.0f));
            z10 = true;
        }
        String string3 = args.getString("tts.mode");
        if (string3 != null) {
            if (H.x0(string3)) {
                string3 = null;
            }
            if (string3 != null) {
                builder.putString("tts.mode", string3);
                z10 = true;
            }
        }
        String string4 = args.getString("tts.text_normalization");
        if (string4 != null) {
            if (H.x0(string4)) {
                string4 = null;
            }
            if (string4 != null) {
                builder.putString("tts.text_normalization", string4);
                z10 = true;
            }
        }
        String string5 = args.getString("trace_id");
        if (string5 != null) {
            String str = H.x0(string5) ? null : string5;
            if (str != null) {
                builder.putString(AiTraceKeys.CP_TRACE_ID, K.R1(str, 128));
                z10 = true;
            }
        }
        if (TaskPriorityArg.INSTANCE.applyTo(builder, args)) {
            return true;
        }
        return z10;
    }

    public final ContentParams b(Bundle args) {
        ContentParams.Builder builderPutBoolean = new ContentParams.Builder().putBoolean(TtsStreamResultDispatcher.KEY_TTS_STREAM_START, true).putBoolean(TtsStreamResultDispatcher.KEY_TTS_FEED_ORDERED, true);
        if (args != null) {
            a(args, builderPutBoolean);
        }
        return builderPutBoolean.build();
    }

    public final ContentParams c(Bundle args) {
        if (args == null) {
            return null;
        }
        ContentParams.Builder builder = new ContentParams.Builder();
        if (a(args, builder)) {
            return builder.build();
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.stepos.aiengine.adapter.TtsStreamAbilityAdapter$b] */
    @Override // com.stepos.aiengine.algorithm.tts.ITtsStreaming
    public ITtsStreamSession openSession(AlgorithmToken token, Bundle args, TtsStreamListener listener) {
        p.i(token, "token");
        p.i(listener, "listener");
        TextContent textContent = new TextContent("");
        textContent.setParams(b(args));
        final TtsStreamResultDispatcher ttsStreamResultDispatcher = new TtsStreamResultDispatcher(listener);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        String strInfer = this.handle.infer(String.valueOf(token.getIdentity()), (String) textContent, (InferenceCallback) new InferenceCallback<Content>() { // from class: com.stepos.aiengine.adapter.TtsStreamAbilityAdapter$openSession$inferId$1
            @Override // com.stepos.core.InferenceCallback
            public void onNext(String inferId, InferResult<? extends Content> result) {
                p.i(inferId, "inferId");
                p.i(result, "result");
                if (result instanceof InferResult.Error) {
                    ttsStreamResultDispatcher.onInferResult(inferId, result);
                    TtsStreamAbilityAdapter.b bVar = ref$ObjectRef.f34820a;
                    if (bVar != null) {
                        bVar.a();
                        return;
                    }
                    return;
                }
                if (p.d(result, InferResult.Complete.INSTANCE)) {
                    ttsStreamResultDispatcher.onInferResult(inferId, result);
                    TtsStreamAbilityAdapter.b bVar2 = ref$ObjectRef.f34820a;
                    if (bVar2 != null) {
                        bVar2.a();
                        return;
                    }
                    return;
                }
                if (!(result instanceof InferResult.Cancelled)) {
                    ttsStreamResultDispatcher.onInferResult(inferId, result);
                    return;
                }
                ttsStreamResultDispatcher.onInferResult(inferId, result);
                TtsStreamAbilityAdapter.b bVar3 = ref$ObjectRef.f34820a;
                if (bVar3 != null) {
                    bVar3.a();
                }
            }
        });
        if (H.x0(strInfer)) {
            listener.onError(AIEngineError.NOT_INITIALIZED, MSG_OPEN_REJECTED);
            return null;
        }
        ?? bVar = new b(this.handle, strInfer, ttsStreamResultDispatcher, args, new AnonymousClass1(this));
        ref$ObjectRef.f34820a = bVar;
        return (ITtsStreamSession) bVar;
    }
}
