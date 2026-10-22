package com.stepos.alphame.common.data;

import B0.g;
import S.InterfaceC0103i;
import V.b;
import V.f;
import Z2.F;
import Z2.I;
import android.util.Log;
import androidx.annotation.Keep;
import b3.InterfaceC0379h;
import b3.InterfaceC0380i;
import b3.o;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.net.SyslogConstants;
import com.airbnb.lottie.h;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.entity.pb.PoiResult;
import f1.AbstractC0557a;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import net.zetetic.database.DatabaseUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t0.J;

@Keep
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\f\u0010d\u001a\b\u0012\u0004\u0012\u00020_0c¢\u0006\u0004\bf\u0010gJ#\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\f\u0010\rJ \u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u00020\u00112\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0014\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0017J&\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u0012\u0010\tJ+\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\u0006\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ1\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ&\u0010 \u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H\u0086@¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0011H\u0086@¢\u0006\u0004\b\"\u0010\u000fJ\r\u0010#\u001a\u00020\u0011¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b%\u0010&J#\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020'¢\u0006\u0004\b(\u0010)J#\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020*¢\u0006\u0004\b+\u0010,J#\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020-¢\u0006\u0004\b.\u0010/J#\u00101\u001a\b\u0012\u0004\u0012\u0002000\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u000200¢\u0006\u0004\b1\u00102J)\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b3\u00104J#\u00106\u001a\b\u0012\u0004\u0012\u0002050\u001b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u000205¢\u0006\u0004\b6\u00107J\u001f\u00108\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b8\u00109J \u0010:\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0082@¢\u0006\u0004\b:\u0010;J\u001f\u0010<\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020'H\u0002¢\u0006\u0004\b<\u0010=J \u0010>\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020'H\u0082@¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020*H\u0002¢\u0006\u0004\b@\u0010AJ \u0010B\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020*H\u0082@¢\u0006\u0004\bB\u0010CJ\u001f\u0010D\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020-H\u0002¢\u0006\u0004\bD\u0010EJ \u0010F\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020-H\u0082@¢\u0006\u0004\bF\u0010GJ\u001f\u0010H\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u000200H\u0002¢\u0006\u0004\bH\u0010IJ \u0010J\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u000200H\u0082@¢\u0006\u0004\bJ\u0010KJ\u001f\u0010L\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u000205H\u0002¢\u0006\u0004\bL\u0010MJ \u0010N\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u000205H\u0082@¢\u0006\u0004\bN\u0010OJ\u001f\u0010P\u001a\u0002052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u000205H\u0002¢\u0006\u0004\bP\u0010QJ\u001f\u0010R\u001a\u00020-2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020-H\u0002¢\u0006\u0004\bR\u0010SJ\u001f\u0010T\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020*H\u0002¢\u0006\u0004\bT\u0010UJ\u001f\u0010V\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020'H\u0002¢\u0006\u0004\bV\u0010WJ\u001f\u0010X\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\bX\u0010YJ\u001f\u0010Z\u001a\u0002002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u000200H\u0002¢\u0006\u0004\bZ\u0010[J&\u0010a\u001a\u00020\u00112\u0006\u0010]\u001a\u00020\\2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020_0^H\u0082@¢\u0006\u0004\ba\u0010bR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020_0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010e¨\u0006h"}, d2 = {"Lcom/stepos/alphame/common/data/DataStorePreferences;", "", "Value", "", Action.KEY_ATTRIBUTE, "defaultValue", "getData", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getAsyncData", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "LV/f;", "getAllData", "()Ljava/util/Map;", "getAsyncAllData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "map", "", "putAsyncData", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "putData", "(Ljava/util/Map;)V", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "readSetString", "(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;", "Lb3/h;", "readAsyncSetString", "(Ljava/lang/String;Ljava/util/Set;)Lb3/h;", "writeSetString", "(Ljava/lang/String;Ljava/util/Set;)V", "writeAsyncSetString", "(Ljava/lang/String;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAsync", "clear", "()V", "readAsyncStringData", "(Ljava/lang/String;Ljava/lang/String;)Lb3/h;", "", "readAsyncBooleanData", "(Ljava/lang/String;Z)Lb3/h;", "", "readAsyncDoubleData", "(Ljava/lang/String;D)Lb3/h;", "", "readAsyncFloatData", "(Ljava/lang/String;F)Lb3/h;", "", "readAsyncLongData", "(Ljava/lang/String;J)Lb3/h;", "readFlowData", "(Ljava/lang/String;Ljava/lang/Object;)Lb3/h;", "", "readAsyncIntData", "(Ljava/lang/String;I)Lb3/h;", "saveString", "(Ljava/lang/String;Ljava/lang/String;)V", "saveAsyncString", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveBoolean", "(Ljava/lang/String;Z)V", "saveAsyncBoolean", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDoubleData", "(Ljava/lang/String;D)V", "saveAsyncDoubleData", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveFloatData", "(Ljava/lang/String;F)V", "saveAsyncFloatData", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveLongData", "(Ljava/lang/String;J)V", "saveAsyncLongData", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveIntData", "(Ljava/lang/String;I)V", "saveAsyncIntData", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readIntData", "(Ljava/lang/String;I)I", "readFloatData", "(Ljava/lang/String;F)F", "readDoubleData", "(Ljava/lang/String;D)D", "readBoolean", "(Ljava/lang/String;Z)Z", "readString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "readLong", "(Ljava/lang/String;J)J", "", "e", "Lb3/i;", "LV/h;", "collector", "checkCollectorAction", "(Ljava/lang/Throwable;Lb3/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LS/i;", "mDataStore", "LS/i;", "<init>", "(LS/i;)V", "common_release"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nDataStorePreferences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,412:1\n47#2:413\n49#2:417\n47#2:418\n49#2:422\n47#2:423\n49#2:427\n47#2:428\n49#2:432\n47#2:433\n49#2:437\n47#2:438\n49#2:442\n47#2:443\n49#2:447\n47#2:448\n49#2:452\n50#3:414\n55#3:416\n50#3:419\n55#3:421\n50#3:424\n55#3:426\n50#3:429\n55#3:431\n50#3:434\n55#3:436\n50#3:439\n55#3:441\n50#3:444\n55#3:446\n50#3:449\n55#3:451\n106#4:415\n106#4:420\n106#4:425\n106#4:430\n106#4:435\n106#4:440\n106#4:445\n106#4:450\n*S KotlinDebug\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n70#1:413\n70#1:417\n174#1:418\n174#1:422\n265#1:423\n265#1:427\n272#1:428\n272#1:432\n277#1:433\n277#1:437\n284#1:438\n284#1:442\n291#1:443\n291#1:447\n316#1:448\n316#1:452\n70#1:414\n70#1:416\n174#1:419\n174#1:421\n265#1:424\n265#1:426\n272#1:429\n272#1:431\n277#1:434\n277#1:436\n284#1:439\n284#1:441\n291#1:444\n291#1:446\n316#1:449\n316#1:451\n70#1:415\n174#1:420\n265#1:425\n272#1:430\n277#1:435\n284#1:440\n291#1:445\n316#1:450\n*E\n"})
/* loaded from: classes.dex */
public final class DataStorePreferences {

    @NotNull
    private final InterfaceC0103i mDataStore;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$clear$1", f = "DataStorePreferences.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$clear$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.label = 1;
                if (dataStorePreferences.clearAsync(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "it", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$clearAsync$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$clearAsync$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            bVar.c();
            bVar.f1915a.clear();
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LZ2/F;", "", "LV/f;", "", "<anonymous>", "(LZ2/F;)Ljava/util/Map;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$getAllData$1", f = "DataStorePreferences.kt", i = {}, l = {PoiResult.Contents.PROVINCE_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nDataStorePreferences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$getAllData$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,412:1\n47#2:413\n49#2:417\n50#3:414\n55#3:416\n106#4:415\n*S KotlinDebug\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$getAllData$1\n*L\n60#1:413\n60#1:417\n60#1:414\n60#1:416\n60#1:415\n*E\n"})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAllData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04361 extends SuspendLambda implements Function2<F, Continuation<? super Map<f, ? extends Object>>, Object> {
        int label;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$1", f = "DataStorePreferences.kt", i = {}, l = {PoiResult.Contents.CITY_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00551 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;
            final /* synthetic */ DataStorePreferences this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00551(DataStorePreferences dataStorePreferences, Continuation<? super C00551> continuation) {
                super(3, continuation);
                this.this$0 = dataStorePreferences;
            }

            @Override // kotlin.jvm.functions.Function3
            @Nullable
            public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
                C00551 c00551 = new C00551(this.this$0, continuation);
                c00551.L$0 = interfaceC0380i;
                c00551.L$1 = th;
                return c00551.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i4 = this.label;
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                    Throwable th = (Throwable) this.L$1;
                    DataStorePreferences dataStorePreferences = this.this$0;
                    this.L$0 = null;
                    this.label = 1;
                    if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
        }

        public C04361(Continuation<? super C04361> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04361(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Map<f, ? extends Object>> continuation) {
            return ((C04361) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                final o oVar = new o(DataStorePreferences.this.mDataStore.b(), new C00551(DataStorePreferences.this, null));
                InterfaceC0379h interfaceC0379h = new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1

                    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
                    @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$getAllData$1\n*L\n1#1,134:1\n53#2:135\n48#3:136\n60#4:137\n*E\n"})
                    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                    public static final class AnonymousClass2 implements InterfaceC0380i {
                        final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            @Nullable
                            public final Object invokeSuspend(@NotNull Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(InterfaceC0380i interfaceC0380i) {
                            this.$this_unsafeFlow$inlined = interfaceC0380i;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // b3.InterfaceC0380i
                        @org.jetbrains.annotations.Nullable
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L31
                                if (r2 != r3) goto L29
                                kotlin.ResultKt.throwOnFailure(r6)
                                goto L45
                            L29:
                                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                r4.<init>(r5)
                                throw r4
                            L31:
                                kotlin.ResultKt.throwOnFailure(r6)
                                b3.i r4 = r4.$this_unsafeFlow$inlined
                                V.h r5 = (V.h) r5
                                java.util.Map r5 = r5.a()
                                r0.label = r3
                                java.lang.Object r4 = r4.emit(r5, r0)
                                if (r4 != r1) goto L45
                                return r1
                            L45:
                                kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                return r4
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$getAllData$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                        }
                    }

                    @Override // b3.InterfaceC0379h
                    @Nullable
                    public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                        Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
                this.label = 1;
                obj = I.k(interfaceC0379h, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$2", f = "DataStorePreferences.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04372 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04372(Continuation<? super C04372> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04372 c04372 = DataStorePreferences.this.new C04372(continuation);
            c04372.L$0 = interfaceC0380i;
            c04372.L$1 = th;
            return c04372.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences", f = "DataStorePreferences.kt", i = {}, l = {48}, m = "getAsyncData", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAsyncData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04381<Value> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C04381(Continuation<? super C04381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStorePreferences.this.getAsyncData(null, null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$putAsyncData$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nDataStorePreferences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$putAsyncData$2\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,412:1\n215#2,2:413\n*S KotlinDebug\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$putAsyncData$2\n*L\n77#1:413,2\n*E\n"})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$putAsyncData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04392 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, Object> $map;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04392(Map<String, ? extends Object> map, Continuation<? super C04392> continuation) {
            super(2, continuation);
            this.$map = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04392 c04392 = new C04392(this.$map, continuation);
            c04392.L$0 = obj;
            return c04392;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04392) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            for (Map.Entry<String, Object> entry : this.$map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    f key = h.s(entry.getKey());
                    Object value2 = entry.getValue();
                    Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Int");
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(key, "key");
                    bVar.d(key, (Integer) value2);
                } else if (value instanceof Long) {
                    f key2 = h.x(entry.getKey());
                    Object value3 = entry.getValue();
                    Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Long");
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(key2, "key");
                    bVar.d(key2, (Long) value3);
                } else if (value instanceof Float) {
                    f key3 = h.o(entry.getKey());
                    Object value4 = entry.getValue();
                    Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Float");
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(key3, "key");
                    bVar.d(key3, (Float) value4);
                } else if (value instanceof Double) {
                    f key4 = h.l(entry.getKey());
                    Object value5 = entry.getValue();
                    Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type kotlin.Double");
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(key4, "key");
                    bVar.d(key4, (Double) value5);
                } else if (value instanceof Boolean) {
                    f key5 = h.e(entry.getKey());
                    Object value6 = entry.getValue();
                    Intrinsics.checkNotNull(value6, "null cannot be cast to non-null type kotlin.Boolean");
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(key5, "key");
                    bVar.d(key5, (Boolean) value6);
                } else {
                    if (!(value instanceof String)) {
                        throw new IllegalArgumentException("unSupport " + entry.getValue() + " type");
                    }
                    f key6 = h.I(entry.getKey());
                    Object value7 = entry.getValue();
                    Intrinsics.checkNotNull(value7, "null cannot be cast to non-null type kotlin.String");
                    bVar.getClass();
                    Intrinsics.checkNotNullParameter(key6, "key");
                    bVar.d(key6, (String) value7);
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$putData$1", f = "DataStorePreferences.kt", i = {}, l = {DatabaseUtils.STATEMENT_OTHER}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$putData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04401 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ Map<String, Object> $map;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$putData$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        @SourceDebugExtension({"SMAP\nDataStorePreferences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$putData$1$1\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,412:1\n215#2,2:413\n*S KotlinDebug\n*F\n+ 1 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences$putData$1$1\n*L\n100#1:413,2\n*E\n"})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$putData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00561 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
            final /* synthetic */ Map<String, Object> $map;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00561(Map<String, ? extends Object> map, Continuation<? super C00561> continuation) {
                super(2, continuation);
                this.$map = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00561 c00561 = new C00561(this.$map, continuation);
                c00561.L$0 = obj;
                return c00561;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
                return ((C00561) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                b bVar = (b) this.L$0;
                for (Map.Entry<String, Object> entry : this.$map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        f key = h.s(entry.getKey());
                        Object value2 = entry.getValue();
                        Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Int");
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter(key, "key");
                        bVar.d(key, (Integer) value2);
                    } else if (value instanceof Long) {
                        f key2 = h.x(entry.getKey());
                        Object value3 = entry.getValue();
                        Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Long");
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter(key2, "key");
                        bVar.d(key2, (Long) value3);
                    } else if (value instanceof Float) {
                        f key3 = h.o(entry.getKey());
                        Object value4 = entry.getValue();
                        Intrinsics.checkNotNull(value4, "null cannot be cast to non-null type kotlin.Float");
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter(key3, "key");
                        bVar.d(key3, (Float) value4);
                    } else if (value instanceof Double) {
                        f key4 = h.l(entry.getKey());
                        Object value5 = entry.getValue();
                        Intrinsics.checkNotNull(value5, "null cannot be cast to non-null type kotlin.Double");
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter(key4, "key");
                        bVar.d(key4, (Double) value5);
                    } else if (value instanceof Boolean) {
                        f key5 = h.e(entry.getKey());
                        Object value6 = entry.getValue();
                        Intrinsics.checkNotNull(value6, "null cannot be cast to non-null type kotlin.Boolean");
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter(key5, "key");
                        bVar.d(key5, (Boolean) value6);
                    } else {
                        if (!(value instanceof String)) {
                            throw new IllegalArgumentException("unSupport " + entry.getValue() + " type");
                        }
                        f key6 = h.I(entry.getKey());
                        Object value7 = entry.getValue();
                        Intrinsics.checkNotNull(value7, "null cannot be cast to non-null type kotlin.String");
                        bVar.getClass();
                        Intrinsics.checkNotNullParameter(key6, "key");
                        bVar.d(key6, (String) value7);
                    }
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04401(Map<String, ? extends Object> map, Continuation<? super C04401> continuation) {
            super(2, continuation);
            this.$map = map;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04401(this.$map, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04401) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0103i interfaceC0103i = DataStorePreferences.this.mDataStore;
                C00561 c00561 = new C00561(this.$map, null);
                this.label = 1;
                obj = AbstractC0557a.r(interfaceC0103i, c00561, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$1", f = "DataStorePreferences.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04411 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04411(Continuation<? super C04411> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04411 c04411 = DataStorePreferences.this.new C04411(continuation);
            c04411.L$0 = interfaceC0380i;
            c04411.L$1 = th;
            return c04411.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$1", f = "DataStorePreferences.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04421 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04421(Continuation<? super C04421> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04421 c04421 = DataStorePreferences.this.new C04421(continuation);
            c04421.L$0 = interfaceC0380i;
            c04421.L$1 = th;
            return c04421.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$1", f = "DataStorePreferences.kt", i = {}, l = {282}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04431 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04431(Continuation<? super C04431> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04431 c04431 = DataStorePreferences.this.new C04431(continuation);
            c04431.L$0 = interfaceC0380i;
            c04431.L$1 = th;
            return c04431.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$1", f = "DataStorePreferences.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04441 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04441(Continuation<? super C04441> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04441 c04441 = DataStorePreferences.this.new C04441(continuation);
            c04441.L$0 = interfaceC0380i;
            c04441.L$1 = th;
            return c04441.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$1", f = "DataStorePreferences.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04451 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04451(Continuation<? super C04451> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04451 c04451 = DataStorePreferences.this.new C04451(continuation);
            c04451.L$0 = interfaceC0380i;
            c04451.L$1 = th;
            return c04451.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "e", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$1", f = "DataStorePreferences.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04461 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04461(Continuation<? super C04461> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04461 c04461 = DataStorePreferences.this.new C04461(continuation);
            c04461.L$0 = interfaceC0380i;
            c04461.L$1 = th;
            return c04461.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lb3/i;", "LV/h;", "", "it", "", "<anonymous>", "(Lb3/i;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$1", f = "DataStorePreferences.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04471 extends SuspendLambda implements Function3<InterfaceC0380i, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public C04471(Continuation<? super C04471> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
            C04471 c04471 = DataStorePreferences.this.new C04471(continuation);
            c04471.L$0 = interfaceC0380i;
            c04471.L$1 = th;
            return c04471.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0380i interfaceC0380i = (InterfaceC0380i) this.L$0;
                Throwable th = (Throwable) this.L$1;
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                this.L$0 = null;
                this.label = 1;
                if (dataStorePreferences.checkCollectorAction(th, interfaceC0380i, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readBoolean$1", f = "DataStorePreferences.kt", i = {}, l = {361}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readBoolean$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04481 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.BooleanRef $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readBoolean$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readBoolean$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00571 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.BooleanRef $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00571(Ref.BooleanRef booleanRef, String str, Continuation<? super C00571> continuation) {
                super(2, continuation);
                this.$resultValue = booleanRef;
                this.$key = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00571 c00571 = new C00571(this.$resultValue, this.$key, continuation);
                c00571.L$0 = obj;
                return c00571;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00571) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.BooleanRef booleanRef = this.$resultValue;
                Boolean bool = (Boolean) hVar.b(h.e(this.$key));
                booleanRef.element = bool != null ? bool.booleanValue() : this.$resultValue.element;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04481(Ref.BooleanRef booleanRef, String str, Continuation<? super C04481> continuation) {
            super(2, continuation);
            this.$resultValue = booleanRef;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04481(this.$resultValue, this.$key, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04481) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00571 c00571 = new C00571(this.$resultValue, this.$key, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00571, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readDoubleData$1", f = "DataStorePreferences.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readDoubleData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04491 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.DoubleRef $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readDoubleData$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readDoubleData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00581 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.DoubleRef $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00581(Ref.DoubleRef doubleRef, String str, Continuation<? super C00581> continuation) {
                super(2, continuation);
                this.$resultValue = doubleRef;
                this.$key = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00581 c00581 = new C00581(this.$resultValue, this.$key, continuation);
                c00581.L$0 = obj;
                return c00581;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00581) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.DoubleRef doubleRef = this.$resultValue;
                Double d4 = (Double) hVar.b(h.l(this.$key));
                doubleRef.element = d4 != null ? d4.doubleValue() : this.$resultValue.element;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04491(Ref.DoubleRef doubleRef, String str, Continuation<? super C04491> continuation) {
            super(2, continuation);
            this.$resultValue = doubleRef;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04491(this.$resultValue, this.$key, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04491) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00581 c00581 = new C00581(this.$resultValue, this.$key, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00581, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readFloatData$1", f = "DataStorePreferences.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readFloatData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04501 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.FloatRef $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readFloatData$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readFloatData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00591 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.FloatRef $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00591(Ref.FloatRef floatRef, String str, Continuation<? super C00591> continuation) {
                super(2, continuation);
                this.$resultValue = floatRef;
                this.$key = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00591 c00591 = new C00591(this.$resultValue, this.$key, continuation);
                c00591.L$0 = obj;
                return c00591;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00591) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.FloatRef floatRef = this.$resultValue;
                Float f4 = (Float) hVar.b(h.o(this.$key));
                floatRef.element = f4 != null ? f4.floatValue() : this.$resultValue.element;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04501(Ref.FloatRef floatRef, String str, Continuation<? super C04501> continuation) {
            super(2, continuation);
            this.$resultValue = floatRef;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04501(this.$resultValue, this.$key, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04501) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00591 c00591 = new C00591(this.$resultValue, this.$key, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00591, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readIntData$1", f = "DataStorePreferences.kt", i = {}, l = {322}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readIntData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04511 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.IntRef $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readIntData$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readIntData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00601 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.IntRef $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00601(Ref.IntRef intRef, String str, Continuation<? super C00601> continuation) {
                super(2, continuation);
                this.$resultValue = intRef;
                this.$key = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00601 c00601 = new C00601(this.$resultValue, this.$key, continuation);
                c00601.L$0 = obj;
                return c00601;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00601) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.IntRef intRef = this.$resultValue;
                Integer num = (Integer) hVar.b(h.s(this.$key));
                intRef.element = num != null ? num.intValue() : this.$resultValue.element;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04511(Ref.IntRef intRef, String str, Continuation<? super C04511> continuation) {
            super(2, continuation);
            this.$resultValue = intRef;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04511(this.$resultValue, this.$key, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04511) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00601 c00601 = new C00601(this.$resultValue, this.$key, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00601, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readLong$1", f = "DataStorePreferences.kt", i = {}, l = {388}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readLong$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04521 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.LongRef $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readLong$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readLong$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00611 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.LongRef $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00611(Ref.LongRef longRef, String str, Continuation<? super C00611> continuation) {
                super(2, continuation);
                this.$resultValue = longRef;
                this.$key = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00611 c00611 = new C00611(this.$resultValue, this.$key, continuation);
                c00611.L$0 = obj;
                return c00611;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00611) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.LongRef longRef = this.$resultValue;
                Long l4 = (Long) hVar.b(h.x(this.$key));
                longRef.element = l4 != null ? l4.longValue() : this.$resultValue.element;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04521(Ref.LongRef longRef, String str, Continuation<? super C04521> continuation) {
            super(2, continuation);
            this.$resultValue = longRef;
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04521(this.$resultValue, this.$key, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04521) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00611 c00611 = new C00611(this.$resultValue, this.$key, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00611, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readSetString$1", f = "DataStorePreferences.kt", i = {}, l = {Opcodes.IFLE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readSetString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04531 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ Set<String> $defaultValue;
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.ObjectRef<Set<String>> $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readSetString$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readSetString$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00621 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ Set<String> $defaultValue;
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.ObjectRef<Set<String>> $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00621(Ref.ObjectRef<Set<String>> objectRef, String str, Set<String> set, Continuation<? super C00621> continuation) {
                super(2, continuation);
                this.$resultValue = objectRef;
                this.$key = str;
                this.$defaultValue = set;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00621 c00621 = new C00621(this.$resultValue, this.$key, this.$defaultValue, continuation);
                c00621.L$0 = obj;
                return c00621;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00621) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.ObjectRef<Set<String>> objectRef = this.$resultValue;
                String name = this.$key;
                Intrinsics.checkNotNullParameter(name, "name");
                Set set = (Set) hVar.b(new f(name));
                T t4 = set;
                if (set == null) {
                    t4 = this.$defaultValue;
                }
                objectRef.element = t4;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04531(Ref.ObjectRef<Set<String>> objectRef, String str, Set<String> set, Continuation<? super C04531> continuation) {
            super(2, continuation);
            this.$resultValue = objectRef;
            this.$key = str;
            this.$defaultValue = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04531(this.$resultValue, this.$key, this.$defaultValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04531) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00621 c00621 = new C00621(this.$resultValue, this.$key, this.$defaultValue, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00621, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "LV/h;", "<anonymous>", "(LZ2/F;)LV/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readString$1", f = "DataStorePreferences.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04541 extends SuspendLambda implements Function2<F, Continuation<? super V.h>, Object> {
        final /* synthetic */ String $defaultValue;
        final /* synthetic */ String $key;
        final /* synthetic */ Ref.ObjectRef<String> $resultValue;
        int label;

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/h;", "it", "", "<anonymous>", "(LV/h;)Z"}, k = 3, mv = {1, 9, 0})
        @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readString$1$1", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readString$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00631 extends SuspendLambda implements Function2<V.h, Continuation<? super Boolean>, Object> {
            final /* synthetic */ String $defaultValue;
            final /* synthetic */ String $key;
            final /* synthetic */ Ref.ObjectRef<String> $resultValue;
            /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00631(Ref.ObjectRef<String> objectRef, String str, String str2, Continuation<? super C00631> continuation) {
                super(2, continuation);
                this.$resultValue = objectRef;
                this.$key = str;
                this.$defaultValue = str2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                C00631 c00631 = new C00631(this.$resultValue, this.$key, this.$defaultValue, continuation);
                c00631.L$0 = obj;
                return c00631;
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull V.h hVar, @Nullable Continuation<? super Boolean> continuation) {
                return ((C00631) create(hVar, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                V.h hVar = (V.h) this.L$0;
                Ref.ObjectRef<String> objectRef = this.$resultValue;
                String str = (String) hVar.b(h.I(this.$key));
                T t4 = str;
                if (str == null) {
                    t4 = this.$defaultValue;
                }
                objectRef.element = t4;
                return Boxing.boxBoolean(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04541(Ref.ObjectRef<String> objectRef, String str, String str2, Continuation<? super C04541> continuation) {
            super(2, continuation);
            this.$resultValue = objectRef;
            this.$key = str;
            this.$defaultValue = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04541(this.$resultValue, this.$key, this.$defaultValue, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super V.h> continuation) {
            return ((C04541) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC0379h interfaceC0379hB = DataStorePreferences.this.mDataStore.b();
                C00631 c00631 = new C00631(this.$resultValue, this.$key, this.$defaultValue, null);
                this.label = 1;
                obj = I.l(interfaceC0379hB, c00631, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveAsyncBoolean$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveAsyncBoolean$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04552 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04552(String str, boolean z4, Continuation<? super C04552> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04552 c04552 = new C04552(this.$key, this.$value, continuation);
            c04552.L$0 = obj;
            return c04552;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04552) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            f key = h.e(this.$key);
            Boolean boolBoxBoolean = Boxing.boxBoolean(this.$value);
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, boolBoxBoolean);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveAsyncDoubleData$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveAsyncDoubleData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04562 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ double $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04562(String str, double d4, Continuation<? super C04562> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = d4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04562 c04562 = new C04562(this.$key, this.$value, continuation);
            c04562.L$0 = obj;
            return c04562;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04562) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            f key = h.l(this.$key);
            Double dBoxDouble = Boxing.boxDouble(this.$value);
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, dBoxDouble);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveAsyncFloatData$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveAsyncFloatData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04572 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ float $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04572(String str, float f4, Continuation<? super C04572> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = f4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04572 c04572 = new C04572(this.$key, this.$value, continuation);
            c04572.L$0 = obj;
            return c04572;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04572) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            f key = h.o(this.$key);
            Float fBoxFloat = Boxing.boxFloat(this.$value);
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, fBoxFloat);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveAsyncIntData$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveAsyncIntData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04582 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ int $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04582(String str, int i4, Continuation<? super C04582> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04582 c04582 = new C04582(this.$key, this.$value, continuation);
            c04582.L$0 = obj;
            return c04582;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04582) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            f key = h.s(this.$key);
            Integer numBoxInt = Boxing.boxInt(this.$value);
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, numBoxInt);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveAsyncLongData$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveAsyncLongData$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04592 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ long $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04592(String str, long j4, Continuation<? super C04592> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = j4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04592 c04592 = new C04592(this.$key, this.$value, continuation);
            c04592.L$0 = obj;
            return c04592;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04592) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            f key = h.x(this.$key);
            Long lBoxLong = Boxing.boxLong(this.$value);
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, lBoxLong);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveAsyncString$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveAsyncString$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04602 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04602(String str, String str2, Continuation<? super C04602> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04602 c04602 = new C04602(this.$key, this.$value, continuation);
            c04602.L$0 = obj;
            return c04602;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04602) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            f key = h.I(this.$key);
            String str = this.$value;
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, str);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveBoolean$1", f = "DataStorePreferences.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveBoolean$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04611 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ boolean $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04611(String str, boolean z4, Continuation<? super C04611> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04611(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04611) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                boolean z4 = this.$value;
                this.label = 1;
                if (dataStorePreferences.saveAsyncBoolean(str, z4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveDoubleData$1", f = "DataStorePreferences.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveDoubleData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04621 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ double $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04621(String str, double d4, Continuation<? super C04621> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = d4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04621(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04621) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                double d4 = this.$value;
                this.label = 1;
                if (dataStorePreferences.saveAsyncDoubleData(str, d4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveFloatData$1", f = "DataStorePreferences.kt", i = {}, l = {236}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveFloatData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04631 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ float $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04631(String str, float f4, Continuation<? super C04631> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = f4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04631(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04631) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                float f4 = this.$value;
                this.label = 1;
                if (dataStorePreferences.saveAsyncFloatData(str, f4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveIntData$1", f = "DataStorePreferences.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveIntData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04641 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ int $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04641(String str, int i4, Continuation<? super C04641> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = i4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04641(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04641) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                int i5 = this.$value;
                this.label = 1;
                if (dataStorePreferences.saveAsyncIntData(str, i5, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveLongData$1", f = "DataStorePreferences.kt", i = {}, l = {245}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveLongData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04651 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ long $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04651(String str, long j4, Continuation<? super C04651> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = j4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04651(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04651) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                long j4 = this.$value;
                this.label = 1;
                if (dataStorePreferences.saveAsyncLongData(str, j4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$saveString$1", f = "DataStorePreferences.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$saveString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04661 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04661(String str, String str2, Continuation<? super C04661> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04661(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04661) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                String str2 = this.$value;
                this.label = 1;
                if (dataStorePreferences.saveAsyncString(str, str2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LV/b;", "mutablePreferences", "", "<anonymous>", "(LV/b;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$writeAsyncSetString$2", f = "DataStorePreferences.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$writeAsyncSetString$2, reason: invalid class name and case insensitive filesystem */
    public static final class C04672 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Set<String> $value;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04672(String str, Set<String> set, Continuation<? super C04672> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            C04672 c04672 = new C04672(this.$key, this.$value, continuation);
            c04672.L$0 = obj;
            return c04672;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull b bVar, @Nullable Continuation<? super Unit> continuation) {
            return ((C04672) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            b bVar = (b) this.L$0;
            String name = this.$key;
            Intrinsics.checkNotNullParameter(name, "name");
            f key = new f(name);
            Set<String> set = this.$value;
            bVar.getClass();
            Intrinsics.checkNotNullParameter(key, "key");
            bVar.d(key, set);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LZ2/F;", "", "<anonymous>", "(LZ2/F;)V"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$writeSetString$1", f = "DataStorePreferences.kt", i = {}, l = {Opcodes.RETURN}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$writeSetString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04681 extends SuspendLambda implements Function2<F, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ Set<String> $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04681(String str, Set<String> set, Continuation<? super C04681> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$value = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return DataStorePreferences.this.new C04681(this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull F f4, @Nullable Continuation<? super Unit> continuation) {
            return ((C04681) create(f4, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                DataStorePreferences dataStorePreferences = DataStorePreferences.this;
                String str = this.$key;
                Set<String> set = this.$value;
                this.label = 1;
                if (dataStorePreferences.writeAsyncSetString(str, set, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public DataStorePreferences(@NotNull InterfaceC0103i mDataStore) {
        Intrinsics.checkNotNullParameter(mDataStore, "mDataStore");
        this.mDataStore = mDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object checkCollectorAction(Throwable th, InterfaceC0380i interfaceC0380i, Continuation<? super Unit> continuation) throws Throwable {
        if (!(th instanceof IOException)) {
            throw th;
        }
        th.printStackTrace();
        Object objEmit = interfaceC0380i.emit(new b(true), continuation);
        return objEmit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objEmit : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InterfaceC0379h readAsyncSetString$default(DataStorePreferences dataStorePreferences, String str, Set set, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            set = new HashSet();
        }
        return dataStorePreferences.readAsyncSetString(str, set);
    }

    private final boolean readBoolean(String key, boolean defaultValue) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = defaultValue;
        J.M(new C04481(booleanRef, key, null));
        return booleanRef.element;
    }

    private final double readDoubleData(String key, double defaultValue) {
        Ref.DoubleRef doubleRef = new Ref.DoubleRef();
        doubleRef.element = defaultValue;
        J.M(new C04491(doubleRef, key, null));
        return doubleRef.element;
    }

    private final float readFloatData(String key, float defaultValue) {
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = defaultValue;
        J.M(new C04501(floatRef, key, null));
        return floatRef.element;
    }

    private final int readIntData(String key, int defaultValue) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = defaultValue;
        J.M(new C04511(intRef, key, null));
        return intRef.element;
    }

    private final long readLong(String key, long defaultValue) {
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = defaultValue;
        J.M(new C04521(longRef, key, null));
        return longRef.element;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Set readSetString$default(DataStorePreferences dataStorePreferences, String str, Set set, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            set = new HashSet();
        }
        return dataStorePreferences.readSetString(str, set);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String readString(String key, String defaultValue) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = defaultValue;
        J.M(new C04541(objectRef, key, defaultValue, null));
        return (String) objectRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveAsyncBoolean(String str, boolean z4, Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04552(str, z4, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveAsyncDoubleData(String str, double d4, Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04562(str, d4, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveAsyncFloatData(String str, float f4, Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04572(str, f4, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveAsyncIntData(String str, int i4, Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04582(str, i4, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveAsyncLongData(String str, long j4, Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04592(str, j4, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object saveAsyncString(String str, String str2, Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04602(str, str2, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    private final void saveBoolean(String key, boolean value) {
        J.M(new C04611(key, value, null));
    }

    private final void saveDoubleData(String key, double value) {
        J.M(new C04621(key, value, null));
    }

    private final void saveFloatData(String key, float value) {
        J.M(new C04631(key, value, null));
    }

    private final void saveIntData(String key, int value) {
        J.M(new C04641(key, value, null));
    }

    private final void saveLongData(String key, long value) {
        J.M(new C04651(key, value, null));
    }

    private final void saveString(String key, String value) {
        J.M(new C04661(key, value, null));
    }

    public final void clear() {
        J.M(new AnonymousClass1(null));
    }

    @Nullable
    public final Object clearAsync(@NotNull Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new AnonymousClass2(null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    @NotNull
    public final Map<f, Object> getAllData() {
        return (Map) J.M(new C04361(null));
    }

    @Nullable
    public final Object getAsyncAllData(@NotNull Continuation<? super Map<f, ? extends Object>> continuation) {
        final o oVar = new o(this.mDataStore.b(), new C04372(null));
        return I.k(new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n70#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r4 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.util.Map r5 = r5.a()
                        r0.label = r3
                        java.lang.Object r4 = r4.emit(r5, r0)
                        if (r4 != r1) goto L45
                        return r1
                    L45:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$getAsyncAllData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation2) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <Value> java.lang.Object getAsyncData(@org.jetbrains.annotations.NotNull java.lang.String r5, Value r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super Value> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.alphame.common.data.DataStorePreferences.C04381
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.alphame.common.data.DataStorePreferences$getAsyncData$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences.C04381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.alphame.common.data.DataStorePreferences$getAsyncData$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$getAsyncData$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L92
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6 instanceof java.lang.Integer
            if (r7 == 0) goto L43
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            b3.h r4 = r4.readAsyncIntData(r5, r6)
            goto L89
        L43:
            boolean r7 = r6 instanceof java.lang.Long
            if (r7 == 0) goto L52
            java.lang.Number r6 = (java.lang.Number) r6
            long r6 = r6.longValue()
            b3.h r4 = r4.readAsyncLongData(r5, r6)
            goto L89
        L52:
            boolean r7 = r6 instanceof java.lang.Float
            if (r7 == 0) goto L61
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            b3.h r4 = r4.readAsyncFloatData(r5, r6)
            goto L89
        L61:
            boolean r7 = r6 instanceof java.lang.Double
            if (r7 == 0) goto L70
            java.lang.Number r6 = (java.lang.Number) r6
            double r6 = r6.doubleValue()
            b3.h r4 = r4.readAsyncDoubleData(r5, r6)
            goto L89
        L70:
            boolean r7 = r6 instanceof java.lang.Boolean
            if (r7 == 0) goto L7f
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            b3.h r4 = r4.readAsyncBooleanData(r5, r6)
            goto L89
        L7f:
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L93
            java.lang.String r6 = (java.lang.String) r6
            b3.h r4 = r4.readAsyncStringData(r5, r6)
        L89:
            r0.label = r3
            java.lang.Object r7 = Z2.I.k(r4, r0)
            if (r7 != r1) goto L92
            return r1
        L92:
            return r7
        L93:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "can Not find the "
            java.lang.String r7 = " type"
            java.lang.String r5 = B0.g.n(r6, r5, r7)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences.getAsyncData(java.lang.String, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Value> Value getData(@NotNull String key, Value defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (defaultValue instanceof Integer) {
            return (Value) Integer.valueOf(readIntData(key, ((Number) defaultValue).intValue()));
        }
        if (defaultValue instanceof Float) {
            return (Value) Float.valueOf(readFloatData(key, ((Number) defaultValue).floatValue()));
        }
        if (defaultValue instanceof Double) {
            return (Value) Double.valueOf(readDoubleData(key, ((Number) defaultValue).doubleValue()));
        }
        if (defaultValue instanceof Boolean) {
            return (Value) Boolean.valueOf(readBoolean(key, ((Boolean) defaultValue).booleanValue()));
        }
        if (defaultValue instanceof String) {
            return (Value) readString(key, (String) defaultValue);
        }
        if (defaultValue instanceof Long) {
            return (Value) Long.valueOf(readLong(key, ((Number) defaultValue).longValue()));
        }
        throw new IllegalArgumentException(g.n("can not find the ", key, " type"));
    }

    @Nullable
    public final Object putAsyncData(@NotNull Map<String, ? extends Object> map, @NotNull Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04392(map, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    public final void putData(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        J.M(new C04401(map, null));
    }

    @NotNull
    public final InterfaceC0379h readAsyncBooleanData(@NotNull final String key, final boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        final o oVar = new o(this.mDataStore.b(), new C04411(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n272#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ boolean $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, boolean z4) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = z4;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r6 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.lang.String r2 = r4.$key$inlined
                        V.f r2 = com.airbnb.lottie.h.e(r2)
                        java.lang.Object r5 = r5.b(r2)
                        java.lang.Boolean r5 = (java.lang.Boolean) r5
                        if (r5 == 0) goto L4b
                        boolean r4 = r5.booleanValue()
                        goto L4d
                    L4b:
                        boolean r4 = r4.$defaultValue$inlined
                    L4d:
                        java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L5a
                        return r1
                    L5a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncBooleanData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final InterfaceC0379h readAsyncDoubleData(@NotNull final String key, final double defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        final o oVar = new o(this.mDataStore.b(), new C04421(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n277#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ double $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, double d4) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = d4;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r6 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.lang.String r2 = r4.$key$inlined
                        V.f r2 = com.airbnb.lottie.h.l(r2)
                        java.lang.Object r5 = r5.b(r2)
                        java.lang.Double r5 = (java.lang.Double) r5
                        if (r5 == 0) goto L4b
                        double r4 = r5.doubleValue()
                        goto L4d
                    L4b:
                        double r4 = r4.$defaultValue$inlined
                    L4d:
                        java.lang.Double r4 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L5a
                        return r1
                    L5a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncDoubleData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final InterfaceC0379h readAsyncFloatData(@NotNull final String key, final float defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        final o oVar = new o(this.mDataStore.b(), new C04431(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n284#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ float $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, float f4) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = f4;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r6 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.lang.String r2 = r4.$key$inlined
                        V.f r2 = com.airbnb.lottie.h.o(r2)
                        java.lang.Object r5 = r5.b(r2)
                        java.lang.Float r5 = (java.lang.Float) r5
                        if (r5 == 0) goto L4b
                        float r4 = r5.floatValue()
                        goto L4d
                    L4b:
                        float r4 = r4.$defaultValue$inlined
                    L4d:
                        java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L5a
                        return r1
                    L5a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncFloatData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final InterfaceC0379h readAsyncIntData(@NotNull final String key, final int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        final o oVar = new o(this.mDataStore.b(), new C04441(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n316#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ int $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, int i4) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = i4;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r6 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.lang.String r2 = r4.$key$inlined
                        V.f r2 = com.airbnb.lottie.h.s(r2)
                        java.lang.Object r5 = r5.b(r2)
                        java.lang.Integer r5 = (java.lang.Integer) r5
                        if (r5 == 0) goto L4b
                        int r4 = r5.intValue()
                        goto L4d
                    L4b:
                        int r4 = r4.$defaultValue$inlined
                    L4d:
                        java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L5a
                        return r1
                    L5a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncIntData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final InterfaceC0379h readAsyncLongData(@NotNull final String key, final long defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        final o oVar = new o(this.mDataStore.b(), new C04451(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n291#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ long $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, long j4) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = j4;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L5a
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r6 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.lang.String r2 = r4.$key$inlined
                        V.f r2 = com.airbnb.lottie.h.x(r2)
                        java.lang.Object r5 = r5.b(r2)
                        java.lang.Long r5 = (java.lang.Long) r5
                        if (r5 == 0) goto L4b
                        long r4 = r5.longValue()
                        goto L4d
                    L4b:
                        long r4 = r4.$defaultValue$inlined
                    L4d:
                        java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r4, r0)
                        if (r4 != r1) goto L5a
                        return r1
                    L5a:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncLongData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final InterfaceC0379h readAsyncSetString(@NotNull final String key, @NotNull final Set<String> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        final o oVar = new o(this.mDataStore.b(), new C04461(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n174#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ Set $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, Set set) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = set;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L57
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.throwOnFailure(r7)
                        b3.i r7 = r5.$this_unsafeFlow$inlined
                        V.h r6 = (V.h) r6
                        java.lang.String r2 = r5.$key$inlined
                        java.lang.String r4 = "name"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
                        V.f r4 = new V.f
                        r4.<init>(r2)
                        java.lang.Object r6 = r6.b(r4)
                        java.util.Set r6 = (java.util.Set) r6
                        if (r6 != 0) goto L4e
                        java.util.Set r6 = r5.$defaultValue$inlined
                    L4e:
                        r0.label = r3
                        java.lang.Object r5 = r7.emit(r6, r0)
                        if (r5 != r1) goto L57
                        return r1
                    L57:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncSetString$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    @NotNull
    public final InterfaceC0379h readAsyncStringData(@NotNull final String key, @NotNull final String defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        final o oVar = new o(this.mDataStore.b(), new C04471(null));
        return new InterfaceC0379h() { // from class: com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lb3/i;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
            @SourceDebugExtension({"SMAP\nCollect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collect.kt\nkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 4 DataStorePreferences.kt\ncom/stepos/alphame/common/data/DataStorePreferences\n*L\n1#1,134:1\n53#2:135\n48#3:136\n265#4:137\n*E\n"})
            /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements InterfaceC0380i {
                final /* synthetic */ String $defaultValue$inlined;
                final /* synthetic */ String $key$inlined;
                final /* synthetic */ InterfaceC0380i $this_unsafeFlow$inlined;

                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1$2", f = "DataStorePreferences.kt", i = {}, l = {SyslogConstants.LOG_LOCAL1}, m = "emit", n = {}, s = {})
                /* renamed from: com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(InterfaceC0380i interfaceC0380i, String str, String str2) {
                    this.$this_unsafeFlow$inlined = interfaceC0380i;
                    this.$key$inlined = str;
                    this.$defaultValue$inlined = str2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // b3.InterfaceC0380i
                @org.jetbrains.annotations.Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1$2$1 r0 = (com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1$2$1 r0 = new com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L51
                    L29:
                        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        r4.<init>(r5)
                        throw r4
                    L31:
                        kotlin.ResultKt.throwOnFailure(r6)
                        b3.i r6 = r4.$this_unsafeFlow$inlined
                        V.h r5 = (V.h) r5
                        java.lang.String r2 = r4.$key$inlined
                        V.f r2 = com.airbnb.lottie.h.I(r2)
                        java.lang.Object r5 = r5.b(r2)
                        java.lang.String r5 = (java.lang.String) r5
                        if (r5 != 0) goto L48
                        java.lang.String r5 = r4.$defaultValue$inlined
                    L48:
                        r0.label = r3
                        java.lang.Object r4 = r6.emit(r5, r0)
                        if (r4 != r1) goto L51
                        return r1
                    L51:
                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                        return r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.common.data.DataStorePreferences$readAsyncStringData$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // b3.InterfaceC0379h
            @Nullable
            public Object collect(@NotNull InterfaceC0380i interfaceC0380i, @NotNull Continuation continuation) {
                Object objCollect = oVar.collect(new AnonymousClass2(interfaceC0380i, key, defaultValue), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <Value> InterfaceC0379h readFlowData(@NotNull String key, Value defaultValue) {
        InterfaceC0379h asyncStringData;
        Intrinsics.checkNotNullParameter(key, "key");
        if (defaultValue instanceof Integer) {
            asyncStringData = readAsyncIntData(key, ((Number) defaultValue).intValue());
        } else if (defaultValue instanceof Long) {
            asyncStringData = readAsyncLongData(key, ((Number) defaultValue).longValue());
        } else if (defaultValue instanceof Float) {
            asyncStringData = readAsyncFloatData(key, ((Number) defaultValue).floatValue());
        } else if (defaultValue instanceof Double) {
            asyncStringData = readAsyncDoubleData(key, ((Number) defaultValue).doubleValue());
        } else if (defaultValue instanceof Boolean) {
            asyncStringData = readAsyncBooleanData(key, ((Boolean) defaultValue).booleanValue());
        } else {
            if (!(defaultValue instanceof String)) {
                throw new IllegalArgumentException(g.n("can Not find the ", key, " type"));
            }
            asyncStringData = readAsyncStringData(key, (String) defaultValue);
        }
        Intrinsics.checkNotNull(asyncStringData, "null cannot be cast to non-null type kotlinx.coroutines.flow.Flow<Value of com.stepos.alphame.common.data.DataStorePreferences.readFlowData>");
        return asyncStringData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Set<String> readSetString(@NotNull String key, @NotNull Set<String> defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = defaultValue;
        J.M(new C04531(objectRef, key, defaultValue, null));
        return (Set) objectRef.element;
    }

    @Nullable
    public final Object writeAsyncSetString(@NotNull String str, @NotNull Set<String> set, @NotNull Continuation<? super Unit> continuation) {
        Object objR = AbstractC0557a.r(this.mDataStore, new C04672(str, set, null), continuation);
        return objR == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objR : Unit.INSTANCE;
    }

    public final void writeSetString(@NotNull String key, @NotNull Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        J.M(new C04681(key, value, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final <Value> Object putAsyncData(@NotNull String str, Value value, @NotNull Continuation<? super Unit> continuation) {
        if (value instanceof Integer) {
            Object objSaveAsyncIntData = saveAsyncIntData(str, ((Number) value).intValue(), continuation);
            return objSaveAsyncIntData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSaveAsyncIntData : Unit.INSTANCE;
        }
        if (value instanceof Long) {
            Object objSaveAsyncLongData = saveAsyncLongData(str, ((Number) value).longValue(), continuation);
            return objSaveAsyncLongData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSaveAsyncLongData : Unit.INSTANCE;
        }
        if (value instanceof Float) {
            Object objSaveAsyncFloatData = saveAsyncFloatData(str, ((Number) value).floatValue(), continuation);
            return objSaveAsyncFloatData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSaveAsyncFloatData : Unit.INSTANCE;
        }
        if (value instanceof Double) {
            Object objSaveAsyncDoubleData = saveAsyncDoubleData(str, ((Number) value).doubleValue(), continuation);
            return objSaveAsyncDoubleData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSaveAsyncDoubleData : Unit.INSTANCE;
        }
        if (value instanceof Boolean) {
            Object objSaveAsyncBoolean = saveAsyncBoolean(str, ((Boolean) value).booleanValue(), continuation);
            return objSaveAsyncBoolean == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSaveAsyncBoolean : Unit.INSTANCE;
        }
        if (value instanceof String) {
            Object objSaveAsyncString = saveAsyncString(str, (String) value, continuation);
            return objSaveAsyncString == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSaveAsyncString : Unit.INSTANCE;
        }
        throw new IllegalArgumentException("unSupport " + value + " type");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Value> void putData(@NotNull String key, Value value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Log.d("alphame", "putData2" + Log.getStackTraceString(new Throwable()));
        if (value instanceof Integer) {
            saveIntData(key, ((Number) value).intValue());
            return;
        }
        if (value instanceof Long) {
            saveLongData(key, ((Number) value).longValue());
            return;
        }
        if (value instanceof Float) {
            saveFloatData(key, ((Number) value).floatValue());
            return;
        }
        if (value instanceof Double) {
            saveDoubleData(key, ((Number) value).doubleValue());
            return;
        }
        if (value instanceof Boolean) {
            saveBoolean(key, ((Boolean) value).booleanValue());
        } else {
            if (value instanceof String) {
                saveString(key, (String) value);
                return;
            }
            throw new IllegalArgumentException("unSupport " + value + " type");
        }
    }
}
