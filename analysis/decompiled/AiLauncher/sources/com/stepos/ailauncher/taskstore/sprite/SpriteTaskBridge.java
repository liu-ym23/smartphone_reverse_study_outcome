package com.stepos.ailauncher.taskstore.sprite;

import Ua.C1060i;
import Ua.L0;
import Ua.M;
import Ua.Y;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import eb.InterfaceC4021a;
import eb.f;
import h8.C4148a;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.d;
import x6.InterfaceC5853a;
import x6.b;

@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004*\u0001\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0082@¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sprite/SpriteTaskBridge;", "", "<init>", "()V", "Landroid/content/Context;", "context", "LY8/t;", "f", "(Landroid/content/Context;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Le9/c;)Ljava/lang/Object;", "", "TAG", "Ljava/lang/String;", "LUa/M;", "scope", "LUa/M;", "Leb/a;", "mutex", "Leb/a;", "Lx6/a;", "listener", "Lx6/a;", "com/stepos/ailauncher/taskstore/sprite/SpriteTaskBridge$writeObserver$1", "writeObserver", "Lcom/stepos/ailauncher/taskstore/sprite/SpriteTaskBridge$writeObserver$1;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpriteTaskBridge {
    private static final String TAG = "SpriteTaskBridge";
    public static final SpriteTaskBridge INSTANCE = new SpriteTaskBridge();
    private static final M scope = d.a(L0.b(null, 1, null).plus(Y.b()));
    private static final InterfaceC4021a mutex = f.b(false, 1, null);
    private static final InterfaceC5853a listener = new InterfaceC5853a() { // from class: com.stepos.ailauncher.taskstore.sprite.a
        @Override // x6.InterfaceC5853a
        public final void a(TaskInfoCard taskInfoCard) {
            SpriteTaskBridge.e(taskInfoCard);
        }
    };
    private static final SpriteTaskBridge$writeObserver$1 writeObserver = new SpriteTaskBridge$writeObserver$1();

    public static final void e(TaskInfoCard card) {
        p.i(card, "card");
        C1060i.d(scope, null, null, new SpriteTaskBridge$listener$1$1(card, null), 3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$handle$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$handle$1 r0 = (com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$handle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$handle$1 r0 = new com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge$handle$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.result
            java.lang.Object r6 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            java.lang.Object r5 = r0.L$1
            com.stepos.ailauncher.taskstore.repository.a r5 = (com.stepos.ailauncher.taskstore.repository.a) r5
            java.lang.Object r5 = r0.L$0
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r5
            kotlin.C4849c.b(r4)
            goto L57
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            kotlin.C4849c.b(r4)
            com.stepos.ailauncher.taskstore.TaskStoreModule r4 = com.stepos.ailauncher.taskstore.TaskStoreModule.INSTANCE
            com.stepos.ailauncher.taskstore.repository.a r4 = r4.n()
            java.util.Set r1 = z6.C6364b.a()
            r0.L$0 = r5
            java.lang.Object r3 = g9.h.a(r4)
            r0.L$1 = r3
            r0.label = r2
            java.lang.Object r4 = r4.n(r1, r0)
            if (r4 != r6) goto L57
            return r6
        L57:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r6 = new java.util.ArrayList
            r0 = 10
            int r0 = Z8.C1174w.x(r4, r0)
            r6.<init>(r0)
            java.util.Iterator r4 = r4.iterator()
        L6a:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L7e
            java.lang.Object r0 = r4.next()
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r0 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCard) r0
            com.stepos.ailauncher.foundation.task.entity.UiTask r0 = z6.C6364b.c(r0)
            r6.add(r0)
            goto L6a
        L7e:
            com.stepos.ailauncher.foundation.task.entity.UiTask r4 = z6.C6364b.c(r5)
            U5.b r0 = U5.b.INSTANCE
            r0.v(r4, r6)
            b6.b r0 = b6.b.INSTANCE
            r0.b(r4, r6)
            java.lang.String r4 = r5.getTaskId()
            com.stepos.ailauncher.taskstore.entity.TaskInfoStatus r5 = r5.getStatus()
            int r6 = r6.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "taskUpdate: taskId="
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = " status="
            r0.append(r4)
            r0.append(r5)
            java.lang.String r4 = " activeCount="
            r0.append(r4)
            r0.append(r6)
            java.lang.String r4 = r0.toString()
            r5 = 4
            r6 = 0
            java.lang.String r0 = "SpriteTaskBridge"
            r1 = 0
            h8.C4148a.d(r0, r4, r1, r5, r6)
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge.d(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, e9.c):java.lang.Object");
    }

    public final void f(Context context) {
        p.i(context, "context");
        b.b(context, listener);
        TaskStoreModule.INSTANCE.K(writeObserver);
        C4148a.d(TAG, "SpriteTaskBridge registered on TaskInfoCardClient + writeObserver", false, 4, null);
    }
}
