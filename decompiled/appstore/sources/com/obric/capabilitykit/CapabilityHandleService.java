package com.obric.capabilitykit;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.apphost.AppHost;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.ICapabilityActionHandler;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.UtilsKt;
import com.obric.capabilitykit.common.execution.IntentCalling;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentFunction;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.logger.Logger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.j0;
import kotlin.collections.n;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.apache.http.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0017\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService;", "Landroid/app/Service;", "()V", "binder", "Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "onBind", "Landroid/os/IBinder;", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "onCreate", "", "onDestroy", "CapabilityHandleBinder", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CapabilityHandleService extends Service {

    @NotNull
    private static final Map<String, List<String>> ALLOWED_PACKAGES = null;

    @NotNull
    public static final a Companion = null;

    @NotNull
    public static final String TAG = "CapabilityHandleService";
    private static final int VERSION = 1;

    @NotNull
    private final CapabilityHandleBinder binder;

    @Keep
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J*\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J&\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\nH\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/CapabilityHandleService$CapabilityHandleBinder;", "Lcom/obric/capabilitykit/common/ICapabilityActionHandler$Stub;", "shouldEnsureCaller", "", "(Z)V", "doJobInternal", "", "calling", "Lcom/obric/capabilitykit/common/execution/IntentCalling;", "messageId", "", "jobId", "(Lcom/obric/capabilitykit/common/execution/IntentCalling;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureCaller", "getVersion", "", "handleAction", "s", "handleIntentCalling", "isTaskRunning", "onTransact", ServerElements.CODE, "data", "Landroid/os/Parcel;", "reply", "flags", "openUriFile", "uri", "Landroid/net/Uri;", "forReceiver", "Lcom/obric/capabilitykit/common/execution/fileaccess/IUriFileReceiver;", "receiverPackage", "stopAction", "reason", "stopComplexTask", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class CapabilityHandleBinder extends ICapabilityActionHandler.Stub {
        private final boolean shouldEnsureCaller;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder", f = "CapabilityHandleService.kt", i = {0, 0}, l = {118}, m = "doJobInternal", n = {"messageId", "jobId"}, s = {"L$0", "L$1"})
        public static final class a extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f11180a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f11181b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f11182c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f11183d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f11184e;

            public a(CapabilityHandleBinder r10, Continuation<? super a> r11) {
                this.f11183d = r10;
                super(r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                this.f11182c = r10;
                this.f11184e |= Integer.MIN_VALUE;
                return CapabilityHandleBinder.access$doJobInternal(this.f11183d, null, null, null, this);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/Job;", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class b extends Lambda implements Function1<Pair<? extends String, ? extends Job>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f11185a;

            public b(String r10) {
                this.f11185a = r10;
                super(1);
            }

            @NotNull
            public final Boolean a(@NotNull Pair<String, ? extends Job> r10) {
                kotlin.jvm.internal.q.g(r10, "it");
                return Boolean.valueOf(kotlin.jvm.internal.q.b(r10.getFirst(), this.f11185a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends String, ? extends Job> r10) {
                return a(r10);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00050\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "", "Lcom/obric/capabilitykit/common/intent/IntentFunction;", "invoke", "(Lkotlin/Pair;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class c extends Lambda implements Function1<Pair<? extends String, ? extends IntentFunction<?, ?>>, Boolean> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f11186a;

            public c(String r10) {
                this.f11186a = r10;
                super(1);
            }

            @NotNull
            public final Boolean a(@NotNull Pair<String, ? extends IntentFunction<?, ?>> r10) {
                kotlin.jvm.internal.q.g(r10, "it");
                return Boolean.valueOf(kotlin.jvm.internal.q.b(r10.getFirst(), this.f11186a));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Pair<? extends String, ? extends IntentFunction<?, ?>> r10) {
                return a(r10);
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0005\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "byte", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class d extends Lambda implements Function1<Byte, CharSequence> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f11187a = null;

            static {
                f11187a = new d();
            }

            public d() {
                super(1);
            }

            @NotNull
            public final CharSequence a(byte r10) {
                String r11 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r10)}, 1));
                kotlin.jvm.internal.q.f(r11, "java.lang.String.format(format, *args)");
                return r11;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte r10) {
                return a(r10.byteValue());
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleAction$1$1$1", f = "CapabilityHandleService.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
        public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f11188a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ IMAppAction f11189b;

            public e(IMAppAction r10, Continuation<? super e> r11) {
                this.f11189b = r10;
                super(2, r11);
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((e) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new e(this.f11189b, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return a(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.f11188a;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L7;
                kotlin.c.b(r10);
            L13:
                IMAppAction r13 = (IMAppAction) r10;
                Logger.INSTANCE.i(CapabilityHandleService.TAG, "sendActionExecuteResult: " + this.f11189b.getQuestionId() + TokenParser.SP + r13.getContent());
                AtomicCapabilitySdk.INSTANCE.sendActionExecuteResult$capabilitykit_release(r13);
            L15:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                if (this.f11189b.getReplyId() != 0) goto L15;
                ActionDispatcher r14 = ActionDispatcher.INSTANCE;
                IMAppAction r15 = this.f11189b;
                kotlin.jvm.internal.q.f(r15, "action");
                this.f11188a = 1;
                r10 = r14.onActionReceived(r15, this);
                if (r10 != r11) goto L13;
                return r11;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$1", f = "CapabilityHandleService.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
        public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f11190a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f11191b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IntentCalling f11192c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f11193d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f11194e;

            public f(CapabilityHandleBinder r10, IntentCalling r11, String r12, String r13, Continuation<? super f> r14) {
                this.f11191b = r10;
                this.f11192c = r11;
                this.f11193d = r12;
                this.f11194e = r13;
                super(2, r14);
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((f) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new f(this.f11191b, this.f11192c, this.f11193d, this.f11194e, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return a(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.f11190a;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L7;
                kotlin.c.b(r10);
            L12:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                CapabilityHandleBinder r13 = this.f11191b;
                IntentCalling r14 = this.f11192c;
                String r15 = this.f11193d;
                String r16 = this.f11194e;
                this.f11190a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r13, r14, r15, r16, this) != r11) goto L12;
                return r11;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$handleIntentCalling$1$1$job$2", f = "CapabilityHandleService.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
        public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f11195a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CapabilityHandleBinder f11196b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IntentCalling f11197c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f11198d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ String f11199e;

            public g(CapabilityHandleBinder r10, IntentCalling r11, String r12, String r13, Continuation<? super g> r14) {
                this.f11196b = r10;
                this.f11197c = r11;
                this.f11198d = r12;
                this.f11199e = r13;
                super(2, r14);
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((g) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new g(this.f11196b, this.f11197c, this.f11198d, this.f11199e, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return a(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                Object r11 = kotlin.coroutines.intrinsics.a.d();
                int r12 = this.f11195a;
                if (r12 == 0) goto L8;
                if (r12 != 1) goto L7;
                kotlin.c.b(r10);
            L12:
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                kotlin.c.b(r10);
                CapabilityHandleBinder r13 = this.f11196b;
                IntentCalling r14 = this.f11197c;
                String r15 = this.f11198d;
                String r16 = this.f11199e;
                this.f11195a = 1;
                if (CapabilityHandleBinder.access$doJobInternal(r13, r14, r15, r16, this) != r11) goto L12;
                return r11;
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$openUriFile$1$1", f = "CapabilityHandleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f11200a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Uri f11201b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IUriFileReceiver f11202c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f11203d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ int f11204e;

            public h(Uri r10, IUriFileReceiver r11, String r12, int r13, Continuation<? super h> r14) {
                this.f11201b = r10;
                this.f11202c = r11;
                this.f11203d = r12;
                this.f11204e = r13;
                super(2, r14);
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((h) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new h(this.f11201b, this.f11202c, this.f11203d, this.f11204e, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return a(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                kotlin.coroutines.intrinsics.a.d();
                if (this.f11200a != 0) goto L7;
                kotlin.c.b(r10);
                Logger.INSTANCE.d(CapabilityHandleService.TAG, "openUriFile: " + this.f11201b + "; opening for receiver: " + this.f11202c);
                new u(this.f11201b, this.f11202c, this.f11203d).b(this.f11204e);
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.obric.capabilitykit.CapabilityHandleService$CapabilityHandleBinder$stopAction$1$1$1", f = "CapabilityHandleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f11205a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f11206b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f11207c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ String f11208d;

            public i(String r10, String r11, String r12, Continuation<? super i> r13) {
                this.f11206b = r10;
                this.f11207c = r11;
                this.f11208d = r12;
                super(2, r13);
            }

            @Nullable
            public final Object a(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
                return ((i) create(r10, r11)).invokeSuspend(Unit.f21064a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
                return new i(this.f11206b, this.f11207c, this.f11208d, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
                return a(r10, r11);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object r10) {
                kotlin.coroutines.intrinsics.a.d();
                if (this.f11205a != 0) goto L7;
                kotlin.c.b(r10);
                t.f11407a.f(this.f11206b, this.f11207c, this.f11208d);
                return Unit.f21064a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public CapabilityHandleBinder(boolean r10) {
            this.shouldEnsureCaller = r10;
        }

        public static /* synthetic */ boolean a(Function1 r10, Object r11) {
            return doJobInternal$lambda$10$lambda$9(r10, r11);
        }

        public static final /* synthetic */ Object access$doJobInternal(CapabilityHandleBinder r10, IntentCalling r11, String r12, String r13, Continuation r14) {
            return r10.doJobInternal(r11, r12, r13, r14);
        }

        public static /* synthetic */ boolean b(Function1 r10, Object r11) {
            return doJobInternal$lambda$10$lambda$8(r10, r11);
        }

        private final Object doJobInternal(IntentCalling r10, String r11, String r12, Continuation<? super Unit> r13) {
            if ((r13 instanceof a) == false) goto L7;
            a r14 = (a) r13;
            int r15 = r14.f11184e;
            if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
            r14.f11184e = r15 - Integer.MIN_VALUE;
        L8:
            Object r16 = r14.f11182c;
            Object r17 = kotlin.coroutines.intrinsics.a.d();
            int r18 = r14.f11184e;
            if (r18 == 0) goto L14;
            if (r18 != 1) goto L13;
            r12 = (String) r14.f11181b;
            r11 = (String) r14.f11180a;
            kotlin.c.b(r16);
        L17:
            Pair r19 = (Pair) r16;
            IntentResult<?> r20 = (IntentResult) r19.getFirst();
            AtomicCapabilitySdk.INSTANCE.sendIntentExecutionResult$capabilitykit_release(r20, (IMAppAction) r19.getSecond());
            if (r20.isFinal() == false) goto L36;
            com.obric.capabilitykit.c r21 = com.obric.capabilitykit.c.f11239a;
            LinkedHashMap r22 = r21.g();
            monitor-enter(r22);
        L26:
            th = move-exception;
            throw th;
        L23:
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "doJobInternal jobId: " + r12 + " isFinal = true " + r21.g());     // Catch: Throwable -> L26
            Set r23 = (Set) r21.g().get(r11);     // Catch: Throwable -> L26
            if (r23 == null) goto L28;
            final b r24 = new b(r12);     // Catch: Throwable -> L26
            tf.a.a(r23.removeIf(new cb.c(r24)));     // Catch: Throwable -> L26
        L28:
            Set r25 = (Set) t.f11407a.h().get(r11);     // Catch: Throwable -> L26
            if (r25 == null) goto L31;
            final c r26 = new c(r12);     // Catch: Throwable -> L26
            tf.a.a(r25.removeIf(new cb.d(r26)));     // Catch: Throwable -> L26
        L31:
            monitor-exit(r22);
        L36:
            return Unit.f21064a;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            kotlin.c.b(r16);
            s r27 = s.f11380a;
            r14.f11180a = r11;
            r14.f11181b = r12;
            r14.f11184e = 1;
            r16 = r27.c(r10, r12, r14);
            if (r16 != r17) goto L17;
            return r17;
        L7:
            r14 = new a(this, r13);
            goto L8
        }

        private static final boolean doJobInternal$lambda$10$lambda$8(Function1 r10, Object r11) {
            kotlin.jvm.internal.q.g(r10, "$tmp0");
            return ((Boolean) r10.invoke(r11)).booleanValue();
        }

        private static final boolean doJobInternal$lambda$10$lambda$9(Function1 r10, Object r11) {
            kotlin.jvm.internal.q.g(r10, "$tmp0");
            return ((Boolean) r10.invoke(r11)).booleanValue();
        }

        private final boolean ensureCaller() {
            if (this.shouldEnsureCaller == true) goto L5;
            return true;
        L5:
            PackageManager r10 = AppHost.Companion.getApplication().getPackageManager();
            if (r10.checkSignatures(1000, Binder.getCallingUid()) != 0) goto L8;
            return true;
        L8:
            String r11 = r10.getNameForUid(Binder.getCallingUid());
            if (r11 == null) goto L14;
            if (r10.checkSignatures("android", r11) != 0) goto L14;
            return true;
        L14:
            if (r11 != null) goto L16;
        L38:
            return false;
        L16:
            if (PackageUtils.INSTANCE.isPrivilegedApp(r11) != true) goto L38;
            List r12 = (List) CapabilityHandleService.access$getALLOWED_PACKAGES$cp().get(r11);
            if (r11 != null) goto L20;
        L37:
            Logger.INSTANCE.e(CapabilityHandleService.TAG, r11 + " not in allowed packages");
            goto L38
        L20:
            if (r11.length() == 0) goto L37;
            if (r12 == null) goto L37;
            if (r12.isEmpty() == true) goto L37;
            Signature[] r13 = r10.getPackageInfo(r11, 64).signatures;     // Catch: PackageManager.NameNotFoundException -> L35
            MessageDigest r14 = MessageDigest.getInstance("SHA-256");     // Catch: PackageManager.NameNotFoundException -> L35
            kotlin.jvm.internal.q.f(r13, "signatures");     // Catch: PackageManager.NameNotFoundException -> L35
            int r15 = r13.length;     // Catch: PackageManager.NameNotFoundException -> L35
            int r16 = 0;
        L28:
            if (r16 >= r15) goto L37;
            r14.update(r13[r16].toByteArray());     // Catch: PackageManager.NameNotFoundException -> L35
            byte[] r17 = r14.digest();     // Catch: PackageManager.NameNotFoundException -> L35
            kotlin.jvm.internal.q.f(r17, "messageDigest.digest()");     // Catch: PackageManager.NameNotFoundException -> L35
            if (r12.contains(n.B(r17, "", null, null, 0, null, d.f11187a, 30, null)) == true) goto L33;
            r16 = r16 + 1;
            goto L28
        L33:
            return true;
        L35:
            e = move-exception;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "ensureCaller failed", e);
            goto L37
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int getVersion() {
            return 1;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleAction(@Nullable String r10) {
            Logger r11 = Logger.INSTANCE;
            r11.w(CapabilityHandleService.TAG, "handleAction: AppAction is deprecated and is replaced by the AppIntent framework.");
            r11.d(CapabilityHandleService.TAG, "doAction: " + r10);     // Catch: Throwable -> L8
            IMAppAction r12 = (IMAppAction) UtilsKt.getGson().fromJson(r10, IMAppAction.class);     // Catch: Throwable -> L8
            if (r12 == null) goto L12;
            kotlin.jvm.internal.q.f(r12, "action");     // Catch: Throwable -> L8
            StringBuilder r13 = new StringBuilder();     // Catch: Throwable -> L8
            r13.append("doAction questionId:");     // Catch: Throwable -> L8
            r13.append(r12.getQuestionId());     // Catch: Throwable -> L8
            r13.append(", dispatchStarted=");     // Catch: Throwable -> L8
            ActionDispatcher r14 = ActionDispatcher.INSTANCE;     // Catch: Throwable -> L8
            r13.append(r14.getDispatchStartedQuestion());     // Catch: Throwable -> L8
            r11.i(CapabilityHandleService.TAG, r13.toString());     // Catch: Throwable -> L8
            Long r15 = r12.getQuestionId();     // Catch: Throwable -> L8
            if (r15 == null) goto L10;
            long r16 = r15.longValue();     // Catch: Throwable -> L8
        L11:
            r14.launchWithTrace(r16, new e(r12, null));     // Catch: Throwable -> L8
            goto L12
        L10:
            r16 = -1;
        L12:
            if (r12 == null) goto L21;
            return true;
        L21:
            return false;
        L8:
            th = move-exception;
            Throwable r17 = Result.m38exceptionOrNullimpl(Result.m35constructorimpl(kotlin.c.a(th)));
            if (r17 == null) goto L18;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleAction fail: " + kotlin.a.b(r17));
        L18:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean handleIntentCalling(@Nullable IntentCalling r12) {
            Logger r10 = Logger.INSTANCE;     // Catch: Throwable -> L8
            StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L8
            r11.append("doIntent: name=");     // Catch: Throwable -> L8
            String r13 = null;
            if (r12 == null) goto L10;
            String r14 = r12.getIntentName();     // Catch: Throwable -> L8
        L11:
            r11.append(r14);     // Catch: Throwable -> L8
            r10.d(CapabilityHandleService.TAG, r11.toString());     // Catch: Throwable -> L8
            if (r12 != null) goto L14;
        L36:
            if (r12 == null) goto L46;
            return true;
        L46:
            return false;
        L14:
            r10.i(CapabilityHandleService.TAG, "handleIntentCalling questionId:" + r12.getQuestionId());     // Catch: Throwable -> L8
            String r15 = String.valueOf(r12.getQuestionId());     // Catch: Throwable -> L8
            String r16 = UUID.randomUUID().toString();     // Catch: Throwable -> L8
            kotlin.jvm.internal.q.f(r16, "randomUUID().toString()");     // Catch: Throwable -> L8
            r10.i(CapabilityHandleService.TAG, "handleIntentCalling jobId: " + r16);     // Catch: Throwable -> L8
            Map<String, String> r17 = r12.getExt();     // Catch: Throwable -> L8
            if (r17 == null) goto L20;
            r13 = r17.get(Ext.KEY_IS_PARALLEL);     // Catch: Throwable -> L8
        L20:
            if (kotlin.jvm.internal.q.b(r13, "true") == false) goto L23;
            CoroutineScope r18 = ActionDispatcher.INSTANCE.getParallelScope();     // Catch: Throwable -> L8
            Function2 r19 = new f(this, r12, r15, r16, null);     // Catch: Throwable -> L8
        L22:
            Job r110 = kotlinx.coroutines.h.d(r18, null, null, r19, 3, null);     // Catch: Throwable -> L8
            com.obric.capabilitykit.c r20 = com.obric.capabilitykit.c.f11239a;     // Catch: Throwable -> L8
            LinkedHashMap r21 = r20.g();     // Catch: Throwable -> L8
            monitor-enter(r21);     // Catch: Throwable -> L8
            LinkedHashMap r22 = r20.g();     // Catch: Throwable -> L29
            Object r23 = r22.get(r15);     // Catch: Throwable -> L29
            if (r23 != null) goto L31;
            r23 = new LinkedHashSet();     // Catch: Throwable -> L29
            r22.put(r15, r23);     // Catch: Throwable -> L29
        L31:
            ((Set) r23).add(kotlin.d.a(r16, r110));     // Catch: Throwable -> L29
            monitor-exit(r21);     // Catch: Throwable -> L8
            goto L36
        L29:
            th = move-exception;
            throw th;     // Catch: Throwable -> L8
        L23:
            r18 = ActionDispatcher.INSTANCE.getScope();     // Catch: Throwable -> L8
            r19 = new g(this, r12, r15, r16, null);     // Catch: Throwable -> L8
            goto L22
        L10:
            r14 = null;
        L8:
            th = move-exception;
            Throwable r111 = Result.m38exceptionOrNullimpl(Result.m35constructorimpl(kotlin.c.a(th)));
            if (r111 == null) goto L42;
            Logger.INSTANCE.i(CapabilityHandleService.TAG, "handleIntentCalling fail: " + kotlin.a.b(r111));
        L42:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public int isTaskRunning(@NotNull String r10, @NotNull String r11) {
            kotlin.jvm.internal.q.g(r10, "messageId");
            kotlin.jvm.internal.q.g(r11, "jobId");
            com.obric.capabilitykit.c r12 = com.obric.capabilitykit.c.f11239a;
            LinkedHashMap r13 = r12.g();
            monitor-enter(r13);
            Set r14 = (Set) r12.g().get(r10);     // Catch: Throwable -> L12
            int r15 = 0;
            if (r14 == null) goto L26;
            kotlin.jvm.internal.q.f(r14, "jobMap[messageId]");     // Catch: Throwable -> L12
            Iterator r16 = r14.iterator();     // Catch: Throwable -> L12
        L8:
            if (r16.hasNext() == false) goto L14;
            Object r17 = r16.next();     // Catch: Throwable -> L12
            if (kotlin.jvm.internal.q.b(((Pair) r17).getFirst(), r11) == false) goto L8;
        L15:
            Pair r18 = (Pair) r17;     // Catch: Throwable -> L12
            if (r18 == null) goto L26;
            Job r19 = (Job) r18.component2();     // Catch: Throwable -> L12
            if (r19.isActive() == false) goto L20;
            Job.a.b(r19, null, 1, null);     // Catch: Throwable -> L12
        L20:
            Boolean r20 = t.f11407a.b(r10, r11);     // Catch: Throwable -> L12
            if (kotlin.jvm.internal.q.b(r20, Boolean.TRUE) == false) goto L23;
            r15 = 1;
            goto L26
        L23:
            if (kotlin.jvm.internal.q.b(r20, Boolean.FALSE) == false) goto L26;
            r15 = 2;
            goto L26
        L14:
            r17 = null;
        L26:
            monitor-exit(r13);
            return r15;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler.Stub, android.os.Binder
        public boolean onTransact(int r10, @NotNull Parcel r11, @Nullable Parcel r12, int r13) {
            kotlin.jvm.internal.q.g(r11, "data");
        L7:
            th = move-exception;
            Logger.INSTANCE.w(CapabilityHandleService.TAG, "onTransact throws error. It is likely that an error occurred during parameter transferring. th=" + th, th);
            throw th;
        L4:
            if (ensureCaller() == true) goto L10;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "onTransact " + r10 + ", caller not matched.");     // Catch: Throwable -> L7
            return false;
        L10:
            return super.onTransact(r10, r11, r12, r13);
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean openUriFile(@Nullable Uri r20, @Nullable IUriFileReceiver r21, @Nullable String r22) {
            if (ensureCaller() == true) goto L25;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile: " + r20 + ", caller not matched.");
            return false;
        L25:
            Logger r10 = Logger.INSTANCE;     // Catch: Throwable -> L15
            r10.d(CapabilityHandleService.TAG, "openUriFile: " + r20 + ", receiver: " + r21 + ", receiverPackage&Pid: " + r22);     // Catch: Throwable -> L15
            if (r20 == null) goto L19;
            if (r21 == null) goto L19;
            if (r22 == null) goto L19;
            List r11 = StringsKt__StringsKt.l0(r22, new String[]{";"}, false, 0, 6, null);     // Catch: Throwable -> L15
            if (r11.size() == 2) goto L17;
            r10.e(CapabilityHandleService.TAG, "openUriFile: " + r20 + ", unknown receiver pid");     // Catch: Throwable -> L15
            return false;
        L17:
            kotlinx.coroutines.h.d(ActionDispatcher.INSTANCE.getScope(), null, null, new h(r20, r21, (String) r11.get(0), Integer.parseInt((String) r11.get(1)), null), 3, null);     // Catch: Throwable -> L15
            return true;
        L19:
            r10.e(CapabilityHandleService.TAG, "openUriFile: " + r20 + ", invalid params.");     // Catch: Throwable -> L15
            return false;
        L15:
            th = move-exception;
            Throwable r12 = Result.m38exceptionOrNullimpl(Result.m35constructorimpl(kotlin.c.a(th)));
            if (r12 == null) goto L24;
            Logger.INSTANCE.e(CapabilityHandleService.TAG, "openUriFile fail: " + kotlin.a.b(r12));
        L24:
            return false;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopAction(@NotNull String r13, @NotNull String r14) {
            kotlin.jvm.internal.q.g(r13, "messageId");
            kotlin.jvm.internal.q.g(r14, "reason");
            Logger r12 = Logger.INSTANCE;
            StringBuilder r10 = new StringBuilder();
            r10.append("stopAction: ");
            r10.append(r13);
            r10.append(" reason: ");
            r10.append(r14);
            r10.append(" jobMap ");
            com.obric.capabilitykit.c r11 = com.obric.capabilitykit.c.f11239a;
            r10.append(r11.g());
            r12.d(CapabilityHandleService.TAG, r10.toString());
            LinkedHashMap r15 = r11.g();
            monitor-enter(r15);
            Set r16 = (Set) r11.g().get(r13);     // Catch: Throwable -> L12
            boolean r17 = true;
            if (r16 == null) goto L15;
            kotlin.jvm.internal.q.f(r16, "jobMap[messageId]");     // Catch: Throwable -> L12
            Iterator r18 = r16.iterator();     // Catch: Throwable -> L12
        L8:
            if (r18.hasNext() == false) goto L15;
            Pair r19 = (Pair) r18.next();     // Catch: Throwable -> L12
            String r20 = (String) r19.component1();     // Catch: Throwable -> L12
            Job r21 = (Job) r19.component2();     // Catch: Throwable -> L12
            if (r21.isActive() == false) goto L14;
            Job.a.b(r21, null, 1, null);     // Catch: Throwable -> L12
        L14:
            kotlinx.coroutines.h.d(ActionDispatcher.INSTANCE.getScope(), null, null, new i(r13, r14, r20, null), 3, null);     // Catch: Throwable -> L12
        L15:
            if (com.obric.capabilitykit.c.f11239a.g().remove(r13) != null) goto L19;
            r17 = false;
        L19:
            monitor-exit(r15);
            return r17;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.capabilitykit.common.ICapabilityActionHandler
        public boolean stopComplexTask(@NotNull String r10) {
            kotlin.jvm.internal.q.g(r10, "messageId");
            return stopAction(r10, "user stop in complex task");
        }
    }

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new a(null);
        ALLOWED_PACKAGES = j0.f(d.a(PackageUtils.NOVA_PKG_NAME, kotlin.collections.s.e("ff04b47ec9dd20b79f758af67a184926db00ac55cfd2a01e03fba9a1dca9de2a")));
    }

    public CapabilityHandleService() {
        this.binder = new CapabilityHandleBinder(true);
    }

    public static final /* synthetic */ Map access$getALLOWED_PACKAGES$cp() {
        return ALLOWED_PACKAGES;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent r10) {
        kotlin.jvm.internal.q.g(r10, MemorySourceLinkType.INTENT);
        Logger.INSTANCE.i(TAG, "onBind");
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        AppHost.Companion r10 = AppHost.Companion;
        Application r11 = getApplication();
        kotlin.jvm.internal.q.f(r11, "application");
        r10.setAppHost(new cb.s(r11));
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.INSTANCE.i(TAG, "onDestroy");
    }
}
