package com.bytedance.ai.applet.db;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.bytedance.ai.bridge.remote.UserAuthService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p4.p;

/* JADX INFO: loaded from: classes43.dex */
public final class WidgetContextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WidgetContextHelper f34570a = null;

    /* JADX INFO: renamed from: com.bytedance.ai.applet.db.WidgetContextHelper$insert$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ai.applet.db.WidgetContextHelper", f = "WidgetContextHelper.kt", i = {0}, l = {22}, m = "insert", n = {"cardId"}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ WidgetContextHelper this$0;

        public AnonymousClass1(WidgetContextHelper r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.insert(null, null, null, null, this);
        }
    }

    static {
        f34570a = new WidgetContextHelper();
    }

    public WidgetContextHelper() {
    }

    public static a a() {
        WidgetContextDatabase.a r100 = WidgetContextDatabase.f34566a;
        WidgetContextDatabase r101 = WidgetContextDatabase.f34567b;
        if (r101 != null) goto L14;
        monitor-enter(r100);
        r101 = WidgetContextDatabase.f34567b;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        RoomDatabase r102 = Room.databaseBuilder(o2.a.a(), WidgetContextDatabase.class, "applet_widget_context.db").fallbackToDestructiveMigration().addCallback(new WidgetContextDatabase$Companion$get$1$1()).build();     // Catch: Throwable -> L10
        WidgetContextDatabase.f34567b = (WidgetContextDatabase) r102;     // Catch: Throwable -> L10
        r101 = (WidgetContextDatabase) r102;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
    L10:
        th = move-exception;
        throw th;
    L14:
        return r101.c();
    }

    public final Object c(String r100, Continuation<? super i> r101) {
        if ((r101 instanceof WidgetContextHelper$queryByCardId$1) == false) goto L7;
        WidgetContextHelper$queryByCardId$1 r102 = (WidgetContextHelper$queryByCardId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L22
    L20:
        return (i) r104;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        a r107 = a();     // Catch: Exception -> L22
        r102.L$0 = r100;     // Catch: Exception -> L22
        r102.label = 1;     // Catch: Exception -> L22
        r104 = r107.a(r100, r102);     // Catch: Exception -> L22
        if (r104 != r105) goto L20;
        return r105;
    L22:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("WidgetContextHelper", "queryByCardId: query widget context failed, cardId=" + r100, e);
        return null;
    L7:
        r102 = new WidgetContextHelper$queryByCardId$1(this, r101);
        goto L8
    }

    public final Object d(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof WidgetContextHelper$queryConversationIdByCardId$1) == false) goto L7;
        WidgetContextHelper$queryConversationIdByCardId$1 r102 = (WidgetContextHelper$queryConversationIdByCardId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        i r108 = (i) r104;
        if (r108 == null) goto L20;
        String r109 = r108.f34588c;
    L21:
        if (r109 != null) goto L23;
    L26:
        if (r107 == true) goto L28;
        return r109;
    L28:
        com.bytedance.ai.utils.g r110 = com.bytedance.ai.utils.g.f37637a;
        r110.e("WidgetContextHelper", "queryConversationIdByCardId: can not find conversationId by cardId " + r100 + " from db");
        UserAuthService r111 = UserAuthService.f36075a;
        p r112 = UserAuthService.l(r100);
        if (r112 == null) goto L33;
        String r113 = r112.e();
        if (r113 == null) goto L33;
        return r113;
    L33:
        r110.e("WidgetContextHelper", "queryConversationIdByCardId: can not find conversationId by cardId " + r100 + " from server");
        return null;
    L23:
        if (r109.length() == 0) goto L26;
        r107 = false;
        goto L26
    L20:
        r109 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = c(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new WidgetContextHelper$queryConversationIdByCardId$1(this, r101);
        goto L8
    }

    public final Object e(String r100, Continuation<? super String> r101) {
        if ((r101 instanceof WidgetContextHelper$queryMessageIdByCardId$1) == false) goto L7;
        WidgetContextHelper$queryMessageIdByCardId$1 r102 = (WidgetContextHelper$queryMessageIdByCardId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = (String) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L17:
        i r108 = (i) r104;
        if (r108 == null) goto L20;
        String r109 = r108.f34587b;
    L21:
        if (r109 != null) goto L23;
    L26:
        if (r107 == true) goto L28;
        return r109;
    L28:
        com.bytedance.ai.utils.g r110 = com.bytedance.ai.utils.g.f37637a;
        r110.e("WidgetContextHelper", "queryMessageIdByCardId: can not find messageId by cardId " + r100 + " from db");
        UserAuthService r111 = UserAuthService.f36075a;
        p r112 = UserAuthService.l(r100);
        if (r112 == null) goto L33;
        String r113 = r112.f();
        if (r113 == null) goto L33;
        return r113;
    L33:
        r110.e("WidgetContextHelper", "queryMessageIdByCardId: can not find messageId by cardId " + r100 + " from server");
        return null;
    L23:
        if (r109.length() == 0) goto L26;
        r107 = false;
        goto L26
    L20:
        r109 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r102.L$0 = r100;
        r102.label = 1;
        r104 = c(r100, r102);
        if (r104 != r105) goto L17;
        return r105;
    L7:
        r102 = new WidgetContextHelper$queryMessageIdByCardId$1(this, r101);
        goto L8
    }

    public static void b(String r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "cardId");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r112, "conversationId");
        Intrinsics.checkNotNullParameter(r113, "botId");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new WidgetContextHelper$insertAsync$1(r110, r111, r112, r113, null), 3, null);
    }

    public final Object insert(String r100, String r101, String r102, String r103, Continuation<? super Boolean> r104) {
        if ((r104 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r105 = (AnonymousClass1) r104;
        int r106 = r105.label;
        if ((r106 & Integer.MIN_VALUE) == 0) goto L7;
        r105.label = r106 - Integer.MIN_VALUE;
    L8:
        Object r107 = r105.result;
        Object r108 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r109 = r105.label;
        boolean r110 = true;
        if (r109 == 0) goto L16;
        if (r109 != 1) goto L15;
        String r111 = (String) r105.L$0;
        ResultKt.throwOnFailure(r107);     // Catch: Exception -> L24
    L20:
        if (((Number) r107).longValue() != (-1)) goto L28;
    L26:
        r110 = false;
    L28:
        return Boxing.boxBoolean(r110);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r107);
        a r112 = a();     // Catch: Exception -> L24
        i r113 = new i(r100, r101, r102, r103);     // Catch: Exception -> L24
        r105.L$0 = r100;     // Catch: Exception -> L24
        r105.label = 1;     // Catch: Exception -> L24
        r107 = r112.b(r113, r105);     // Catch: Exception -> L24
        if (r107 != r108) goto L20;
        return r108;
    L24:
        e = move-exception;
        com.bytedance.ai.utils.g.f37637a.e("WidgetContextHelper", "insert: insert widget context failed, cardId=" + r100, e);
    L7:
        r105 = new AnonymousClass1(this, r104);
        goto L8
    }
}
