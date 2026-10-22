package com.stepos.ailauncher.taskstore.provider;

import La.H;
import Ua.C1062j;
import Ua.M;
import Wa.n;
import Y8.j;
import Y8.t;
import Z8.C1168p;
import Z8.C1172u;
import Z8.C1174w;
import Z8.Y;
import Z8.r;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.amap.MapAspectFrameLayout;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao;
import com.stepos.ailauncher.taskstore.dao.TaskInfoCardUpsertOutcome;
import com.stepos.ailauncher.taskstore.database.TaskStoreDatabase;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.provider.c;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import g9.h;
import j1.C4760g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.i;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONException;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import p9.p;
import w6.C5739a;
import z6.C6363a;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Y2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014JQ\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\u001c\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010\u001e\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0010\u0010\u0017\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010 \u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010\t2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b.\u0010/J\u0017\u00101\u001a\u00020-2\u0006\u00100\u001a\u00020-H\u0002¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\t2\u0006\u00103\u001a\u00020\tH\u0002¢\u0006\u0004\b6\u00105J)\u00109\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010-2\u0006\u00108\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\b;\u0010<J\u0013\u0010=\u001a\u00020\f*\u00020\"H\u0002¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\tH\u0002¢\u0006\u0004\bB\u0010CJ#\u0010E\u001a\u00020)2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0010\"\u00020\u0007H\u0002¢\u0006\u0004\bE\u0010FJ'\u0010I\u001a\u0004\u0018\u00010\t*\u00020\f2\u0006\u0010G\u001a\u00020\t2\b\u0010H\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bI\u0010JJ\u001f\u0010M\u001a\b\u0012\u0004\u0012\u00020\t0L2\b\u0010K\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bM\u0010NJ'\u0010P\u001a\u0004\u0018\u00010O*\u00020\f2\u0006\u0010G\u001a\u00020\t2\b\u0010H\u001a\u0004\u0018\u00010OH\u0002¢\u0006\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020U8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bV\u0010W¨\u0006["}, d2 = {"Lcom/stepos/ailauncher/taskstore/provider/TaskInfoCardProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "", "onCreate", "()Z", "Landroid/net/Uri;", "uri", "", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", "", "valuesArray", "", "bulkInsert", "(Landroid/net/Uri;[Landroid/content/ContentValues;)I", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", ChatTracker.CLICK_DELETE, "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "method", "arg", "Landroid/os/Bundle;", "extras", "call", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "op", "f", "(Ljava/lang/String;)Z", "LY8/t;", "e", "(Ljava/lang/String;)V", "v", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "c", "(Landroid/content/ContentValues;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", Const.LBS_FAIL_BD_ENTITY, "r", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "raw", "m", "(Ljava/lang/String;)Ljava/lang/String;", "l", "existing", "taskId", "k", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;Ljava/lang/String;Landroid/content/ContentValues;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Landroid/os/Bundle;)Landroid/os/Bundle;", "s", "(Landroid/os/Bundle;)Landroid/content/ContentValues;", "Landroid/content/Context;", "q", "()Landroid/content/Context;", Const.INTENT_KEY_UMID, "()Ljava/lang/String;", "uris", "o", "([Landroid/net/Uri;)V", "key", "fallback", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "json", "", "p", "(Ljava/lang/String;)Ljava/util/Set;", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/ContentValues;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "Landroid/content/UriMatcher;", "uriMatcher", "Landroid/content/UriMatcher;", "Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/taskstore/database/TaskStoreDatabase;", "database", "Companion", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardProvider extends ContentProvider {
    private static final a Companion = new a(null);
    private static final String LEGACY_COL_LABEL = "label";
    private static final int MATCH_CARDS = 1;
    private static final int MATCH_CARDS_BY_ID = 2;
    private static final String TAG = "TaskInfoCardProvider";
    private final UriMatcher uriMatcher;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/provider/TaskInfoCardProvider$a;", "", "<init>", "()V", "", "TAG", "Ljava/lang/String;", "", "MATCH_CARDS", "I", "MATCH_CARDS_BY_ID", "LEGACY_COL_LABEL", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider$bulkInsert$2", f = "TaskInfoCardProvider.kt", l = {175}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider$bulkInsert$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
        final /* synthetic */ TaskInfoCardDao $dao;
        final /* synthetic */ List<TaskInfoCardEntity> $entities;
        final /* synthetic */ Ref$IntRef $written;
        final /* synthetic */ List<TaskInfoCardEntity> $writtenCards;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List<TaskInfoCardEntity> list, TaskInfoCardDao taskInfoCardDao, Ref$IntRef ref$IntRef, List<TaskInfoCardEntity> list2, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$entities = list;
            this.$dao = taskInfoCardDao;
            this.$written = ref$IntRef;
            this.$writtenCards = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass2(this.$entities, this.$dao, this.$written, this.$writtenCards, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0042 -> B:14:0x0045). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r5.label
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r5.L$1
                com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r1 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r1
                java.lang.Object r3 = r5.L$0
                java.util.Iterator r3 = (java.util.Iterator) r3
                kotlin.C4849c.b(r6)
                goto L45
            L17:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L1f:
                kotlin.C4849c.b(r6)
                java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity> r6 = r5.$entities
                java.util.Iterator r6 = r6.iterator()
                r3 = r6
            L29:
                boolean r6 = r3.hasNext()
                if (r6 == 0) goto L5a
                java.lang.Object r6 = r3.next()
                r1 = r6
                com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r1 = (com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity) r1
                com.stepos.ailauncher.taskstore.dao.TaskInfoCardDao r6 = r5.$dao
                r5.L$0 = r3
                r5.L$1 = r1
                r5.label = r2
                java.lang.Object r6 = r6.y(r1, r5)
                if (r6 != r0) goto L45
                return r0
            L45:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L29
                kotlin.jvm.internal.Ref$IntRef r6 = r5.$written
                int r4 = r6.f34818a
                int r4 = r4 + r2
                r6.f34818a = r4
                java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity> r6 = r5.$writtenCards
                r6.add(r1)
                goto L29
            L5a:
                Y8.t r5 = Y8.t.f7040a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lkotlin/Pair;", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "<anonymous>", "(LUa/M;)Lkotlin/Pair;"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider$update$1", f = "TaskInfoCardProvider.kt", l = {MapAspectFrameLayout.DESIGN_WIDTH, 372}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider$update$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<M, InterfaceC4014c<? super Pair<? extends TaskInfoCardUpsertOutcome, ? extends TaskInfoCardEntity>>, Object> {
        final /* synthetic */ TaskInfoCardDao $dao;
        final /* synthetic */ String $targetTaskId;
        final /* synthetic */ ContentValues $v;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ TaskInfoCardProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(TaskInfoCardDao taskInfoCardDao, String str, TaskInfoCardProvider taskInfoCardProvider, ContentValues contentValues, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$dao = taskInfoCardDao;
            this.$targetTaskId = str;
            this.this$0 = taskInfoCardProvider;
            this.$v = contentValues;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$dao, this.$targetTaskId, this.this$0, this.$v, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super Pair<? extends TaskInfoCardUpsertOutcome, TaskInfoCardEntity>> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            TaskInfoCardEntity taskInfoCardEntity;
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 == 0) {
                C4849c.b(obj);
                TaskInfoCardDao taskInfoCardDao = this.$dao;
                String str = this.$targetTaskId;
                this.label = 1;
                obj = taskInfoCardDao.l(str, this);
                if (obj != objG) {
                }
                return objG;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                taskInfoCardEntity = (TaskInfoCardEntity) this.L$1;
                C4849c.b(obj);
                return j.a(obj, taskInfoCardEntity);
            }
            C4849c.b(obj);
            TaskInfoCardEntity taskInfoCardEntity2 = (TaskInfoCardEntity) obj;
            TaskInfoCardEntity taskInfoCardEntityK = this.this$0.k(taskInfoCardEntity2, this.$targetTaskId, this.$v);
            TaskInfoCardDao taskInfoCardDao2 = this.$dao;
            this.L$0 = h.a(taskInfoCardEntity2);
            this.L$1 = taskInfoCardEntityK;
            this.label = 2;
            obj = taskInfoCardDao2.r(taskInfoCardEntityK, this);
            if (obj != objG) {
                taskInfoCardEntity = taskInfoCardEntityK;
                return j.a(obj, taskInfoCardEntity);
            }
            return objG;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super Pair<? extends TaskInfoCardUpsertOutcome, ? extends TaskInfoCardEntity>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super Pair<? extends TaskInfoCardUpsertOutcome, TaskInfoCardEntity>>) interfaceC4014c);
        }
    }

    public TaskInfoCardProvider() {
        UriMatcher uriMatcher = new UriMatcher(-1);
        uriMatcher.addURI(c.AUTHORITY, c.a.TABLE, 1);
        uriMatcher.addURI(c.AUTHORITY, "task_info/*", 2);
        uriMatcher.addURI(c.AUTHORITY, c.a.TABLE_ALIAS, 1);
        uriMatcher.addURI(c.AUTHORITY, "task_info_cards/*", 2);
        this.uriMatcher = uriMatcher;
    }

    public static final CharSequence n(TaskInfoStatus it) {
        kotlin.jvm.internal.p.i(it, "it");
        String lowerCase = it.name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] valuesArray) {
        kotlin.jvm.internal.p.i(uri, "uri");
        kotlin.jvm.internal.p.i(valuesArray, "valuesArray");
        if (!f("bulkInsert")) {
            return 0;
        }
        String strD = d();
        Log.i(TAG, "bulkInsert: caller=" + strD + ", uri=" + uri + ", count=" + valuesArray.length);
        if (this.uriMatcher.match(uri) != 1) {
            throw new IllegalArgumentException(("bulkInsert 仅支持集合 URI=" + c.a.CONTENT_URI + "，传入：" + uri).toString());
        }
        if (valuesArray.length == 0) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(valuesArray.length);
        for (ContentValues contentValues : valuesArray) {
            arrayList.add(c(contentValues));
        }
        TaskInfoCardDao taskInfoCardDaoM0 = i().m0();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ArrayList arrayList2 = new ArrayList();
        C1062j.b(null, new AnonymousClass2(arrayList, taskInfoCardDaoM0, ref$IntRef, arrayList2, null), 1, null);
        if (!arrayList2.isEmpty()) {
            TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
            C6363a c6363a = C6363a.INSTANCE;
            ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(c6363a.a((TaskInfoCardEntity) it.next()));
            }
            taskStoreModule.I(arrayList3);
        }
        if (ref$IntRef.f34818a > 0) {
            o(uri);
        }
        int length = valuesArray.length;
        int i10 = ref$IntRef.f34818a;
        Log.i(TAG, "bulkInsert: caller=" + strD + ", total=" + length + ", written=" + i10 + ", dropped=" + (valuesArray.length - i10));
        return ref$IntRef.f34818a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity c(android.content.ContentValues r48) {
        /*
            Method dump skipped, instructions count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider.c(android.content.ContentValues):com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity");
    }

    @Override // android.content.ContentProvider
    public Bundle call(String method, String arg, Bundle extras) {
        kotlin.jvm.internal.p.i(method, "method");
        if (!f("call")) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("written", false);
            return bundle;
        }
        String strD = d();
        Log.i(TAG, "call: caller=" + strD + ", method=" + method + ", arg=" + arg + ", extrasKeys=" + (extras != null ? extras.keySet() : null));
        if (kotlin.jvm.internal.p.d(method, "create_task")) {
            return j(extras);
        }
        Log.w(TAG, "call: unknown method=" + method + ", caller=" + strD);
        throw new SecurityException("call denied: unknown method");
    }

    public final String d() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getCallingPackage());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str == null) {
            str = "<unknown>";
        }
        return str + "(uid=" + Binder.getCallingUid() + ",pid=" + Binder.getCallingPid() + ")";
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        kotlin.jvm.internal.p.i(uri, "uri");
        if (!f(ChatTracker.CLICK_DELETE)) {
            return -1;
        }
        Log.w(TAG, "delete: NOT SUPPORTED (returns -1), caller=" + d() + ", uri=" + uri + ", selection=" + selection + ", selectionArgs=" + (selectionArgs != null ? r.T0(selectionArgs) : null));
        return -1;
    }

    public final void e(String op) {
        Context context = getContext();
        if (context == null) {
            throw new SecurityException(op + " denied: no context");
        }
        C5.d.INSTANCE.g(context, "TaskInfoCardProvider." + op);
    }

    public final boolean f(String op) {
        e(op);
        if (!TaskStoreDatabase.INSTANCE.i()) {
            return true;
        }
        Log.w(TAG, op + ": store unavailable (disk), caller=" + d());
        return false;
    }

    public final Long g(ContentValues contentValues, String str, Long l10) {
        return contentValues.containsKey(str) ? contentValues.getAsLong(str) : l10;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        kotlin.jvm.internal.p.i(uri, "uri");
        e("getType");
        int iMatch = this.uriMatcher.match(uri);
        String str = iMatch != 1 ? iMatch != 2 ? null : c.a.CONTENT_ITEM_TYPE : c.a.CONTENT_TYPE;
        Log.d(TAG, "getType: caller=" + d() + ", uri=" + uri + ", type=" + str);
        return str;
    }

    public final String h(ContentValues contentValues, String str, String str2) {
        return contentValues.containsKey(str) ? contentValues.getAsString(str) : str2;
    }

    public final TaskStoreDatabase i() {
        return TaskStoreDatabase.INSTANCE.b(q());
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        kotlin.jvm.internal.p.i(uri, "uri");
        if (!f("insert")) {
            return null;
        }
        String strD = d();
        Log.i(TAG, "insert: caller=" + strD + ", uri=" + uri + ", valuesKeys=" + (values != null ? values.keySet() : null));
        if (this.uriMatcher.match(uri) != 1) {
            throw new IllegalArgumentException(("insert 仅支持集合 URI=" + c.a.CONTENT_URI + "，传入：" + uri).toString());
        }
        if (values == null) {
            throw new IllegalArgumentException("ContentValues 不能为空");
        }
        try {
            TaskInfoCardEntity taskInfoCardEntityC = c(values);
            TaskInfoCardUpsertOutcome taskInfoCardUpsertOutcome = (TaskInfoCardUpsertOutcome) C1062j.b(null, new TaskInfoCardProvider$insert$outcome$1(i().m0(), taskInfoCardEntityC, null), 1, null);
            if (taskInfoCardUpsertOutcome == TaskInfoCardUpsertOutcome.WRITTEN) {
                TaskStoreModule.INSTANCE.I(C1172u.e(C6363a.INSTANCE.a(taskInfoCardEntityC)));
            }
            if (taskInfoCardUpsertOutcome == TaskInfoCardUpsertOutcome.STALE) {
                Log.w(TAG, "insert: dropped (stale updatedAt), caller=" + strD + ", taskId=" + taskInfoCardEntityC.getTaskId());
                return null;
            }
            Uri uriA = c.a.a(taskInfoCardEntityC.getTaskId());
            if (taskInfoCardUpsertOutcome == TaskInfoCardUpsertOutcome.UNCHANGED) {
                Log.i(TAG, "insert: unchanged (duplicate frame), caller=" + strD + ", taskId=" + taskInfoCardEntityC.getTaskId());
                return uriA;
            }
            o(uri, uriA);
            Log.i(TAG, "insert: written, caller=" + strD + ", taskId=" + taskInfoCardEntityC.getTaskId() + ", type=" + taskInfoCardEntityC.getType() + ", status=" + taskInfoCardEntityC.getStatus() + ", itemUri=" + uriA);
            return uriA;
        } catch (IllegalArgumentException e10) {
            Log.w(TAG, "insert: build entity failed, caller=" + strD + ", msg=" + e10.getMessage());
            throw e10;
        }
    }

    public final Bundle j(Bundle extras) throws JSONException {
        String str;
        n nVar;
        TaskInfoCardEntity taskInfoCardEntityCopy$default;
        Log.w(TAG, "handleCreateTask extras " + extras);
        String strD = d();
        if (extras == null) {
            throw new IllegalArgumentException("create_task 调用 extras 不能为空");
        }
        try {
            TaskInfoCardEntity taskInfoCardEntityC = c(s(extras));
            TaskInfoCardDao taskInfoCardDaoM0 = i().m0();
            TaskInfoCardEntity taskInfoCardEntity = (TaskInfoCardEntity) C1062j.b(null, new TaskInfoCardProvider$handleCreateTask$existing$1(taskInfoCardDaoM0, taskInfoCardEntityC, null), 1, null);
            if (taskInfoCardEntity != null) {
                String strC = C5739a.INSTANCE.c(taskInfoCardEntity.getExtensionsJson(), taskInfoCardEntityC.getExtensionsJson());
                if (!kotlin.jvm.internal.p.d(strC, taskInfoCardEntityC.getExtensionsJson())) {
                    String taskId = taskInfoCardEntityC.getTaskId();
                    String extensionsJson = taskInfoCardEntity.getExtensionsJson();
                    Set<String> setP = extensionsJson != null ? p(extensionsJson) : null;
                    String extensionsJson2 = taskInfoCardEntityC.getExtensionsJson();
                    Log.i(TAG, "handleCreateTask: recording_phase monotonic merge, taskId=" + taskId + ", existingExt keys=" + setP + ", incomingExt keys=" + (extensionsJson2 != null ? p(extensionsJson2) : null));
                }
                str = strD;
                nVar = null;
                taskInfoCardEntityCopy$default = TaskInfoCardEntity.copy$default(taskInfoCardEntityC, null, null, null, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, 0L, null, strC, null, null, false, null, null, null, null, -268435457, 15, null);
            } else {
                str = strD;
                nVar = null;
                taskInfoCardEntityCopy$default = taskInfoCardEntityC;
            }
            TaskInfoCardUpsertOutcome taskInfoCardUpsertOutcome = (TaskInfoCardUpsertOutcome) C1062j.b(nVar, new TaskInfoCardProvider$handleCreateTask$outcome$1(taskInfoCardDaoM0, taskInfoCardEntityCopy$default, nVar), 1, nVar);
            boolean z10 = taskInfoCardUpsertOutcome == TaskInfoCardUpsertOutcome.WRITTEN;
            if (z10) {
                TaskStoreModule.INSTANCE.I(C1172u.e(C6363a.INSTANCE.a(taskInfoCardEntityCopy$default)));
            }
            Uri uriA = c.a.a(taskInfoCardEntityC.getTaskId());
            Log.w(TAG, "handleCreateTask outcome = " + taskInfoCardUpsertOutcome);
            if (z10) {
                o(c.a.CONTENT_URI, uriA);
                TaskCreatedSideEffects.INSTANCE.b(taskInfoCardEntityCopy$default.getTaskId(), taskInfoCardEntityCopy$default.getType(), extras);
                Log.w(TAG, "handleCreateTask: written, caller=" + str + ", taskId=" + taskInfoCardEntityCopy$default.getTaskId() + ", type=" + taskInfoCardEntityCopy$default.getType() + ", status=" + taskInfoCardEntityCopy$default.getStatus() + ", itemUri=" + uriA + ", sideEffectDispatched=true");
            } else {
                String str2 = str;
                if (taskInfoCardUpsertOutcome == TaskInfoCardUpsertOutcome.UNCHANGED) {
                    Log.w(TAG, "handleCreateTask: unchanged (duplicate frame), caller=" + str2 + ", taskId=" + taskInfoCardEntityCopy$default.getTaskId() + ", type=" + taskInfoCardEntityCopy$default.getType() + ", sideEffectDispatched=false");
                } else {
                    Log.w(TAG, "handleCreateTask: dropped (stale updatedAt), caller=" + str2 + ", taskId=" + taskInfoCardEntityCopy$default.getTaskId() + ", type=" + taskInfoCardEntityCopy$default.getType());
                }
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("written", taskInfoCardUpsertOutcome.isPersisted());
            bundle.putString("task_id", taskInfoCardEntityCopy$default.getTaskId());
            bundle.putString("uri", uriA.toString());
            return bundle;
        } catch (IllegalArgumentException e10) {
            Log.w(TAG, "handleCreateTask: build entity failed, caller=" + strD + ", msg=" + e10.getMessage());
            throw e10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity k(com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity r50, java.lang.String r51, android.content.ContentValues r52) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.provider.TaskInfoCardProvider.k(com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity, java.lang.String, android.content.ContentValues):com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity");
    }

    public final String l(String raw) {
        Object objB;
        String upperCase = H.D1(raw).toString().toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(TaskInfoEventType.valueOf(upperCase).name());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) == null) {
            return (String) objB;
        }
        throw new IllegalArgumentException("非法 event_type=" + raw + "，合法值：CREATED / UPDATED / COMPLETED / ANSWER / FAILED");
    }

    public final String m(String raw) {
        Object objB;
        String upperCase = H.D1(raw).toString().toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(upperCase, "toUpperCase(...)");
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(TaskInfoStatus.valueOf(upperCase).name());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.e(objB) == null) {
            return (String) objB;
        }
        throw new IllegalArgumentException("非法 status=" + raw + "，合法值：" + r.w0(TaskInfoStatus.values(), null, null, null, 0, null, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.provider.d
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TaskInfoCardProvider.n((TaskInfoStatus) obj);
            }
        }, 31, null));
    }

    public final void o(Uri... uris) {
        ContentResolver contentResolver;
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        for (Uri uri : uris) {
            contentResolver.notifyChange(uri, null);
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Object objB;
        Context context = getContext();
        if (context == null) {
            Log.w(TAG, "onCreate: context is null, provider init aborted");
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TaskStoreModule taskStoreModule = TaskStoreModule.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.p.h(applicationContext, "getApplicationContext(...)");
            taskStoreModule.q(applicationContext);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "onCreate: TaskStoreModule.init failed (degraded)", thE);
        }
        Log.i(TAG, "onCreate: TaskInfoCardProvider initialized, authority=com.stepos.ailauncher.taskstore.provider, storeUnavailable=" + TaskStoreDatabase.INSTANCE.i());
        return true;
    }

    public final Set<String> p(String json) {
        Object objB;
        if (json == null || H.x0(json)) {
            return Y.e();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Iterator<String> itKeys = new JSONObject(json).keys();
            kotlin.jvm.internal.p.h(itKeys, "keys(...)");
            objB = Result.b(SequencesKt___SequencesKt.f0(Ka.t.h(itKeys)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Set setE = Y.e();
        if (Result.g(objB)) {
            objB = setE;
        }
        return (Set) objB;
    }

    public final Context q() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("ContentProvider context 为空");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        String[] strArr;
        List listT0;
        ContentResolver contentResolver;
        String[] strArr2;
        List listT02;
        kotlin.jvm.internal.p.i(uri, "uri");
        Object[] objArr = null;
        if (!f("query")) {
            return null;
        }
        String strD = d();
        Log.i(TAG, "query: caller=" + strD + ", uri=" + uri + ", projection=" + (projection != null ? r.T0(projection) : null) + ", selection=" + selection + ", selectionArgs=" + (selectionArgs != null ? r.T0(selectionArgs) : null) + ", sortOrder=" + sortOrder);
        int iMatch = this.uriMatcher.match(uri);
        if (iMatch == 1) {
            strArr = (selectionArgs == null || (listT0 = r.T0(selectionArgs)) == null) ? null : (String[]) listT0.toArray(new String[0]);
        } else {
            if (iMatch != 2) {
                Log.w(TAG, "query: unknown uri, caller=" + strD + ", uri=" + uri);
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            String lastPathSegment = uri.getLastPathSegment();
            if (lastPathSegment == null) {
                throw new IllegalArgumentException("URI 缺少 taskId 路径段：" + uri);
            }
            if (selection == null || H.x0(selection)) {
                strArr = new String[]{lastPathSegment};
                selection = "task_id = ?";
            } else {
                selection = "task_id = ? AND (" + selection + ")";
                String[] strArr3 = {lastPathSegment};
                if (selectionArgs == null || (listT02 = r.T0(selectionArgs)) == null || (strArr2 = (String[]) listT02.toArray(new String[0])) == null) {
                    strArr2 = new String[0];
                }
                strArr = (String[]) C1168p.G(strArr3, strArr2);
            }
        }
        if (strArr != null) {
            int length = strArr.length;
            Object[] objArr2 = new Object[length];
            for (int i10 = 0; i10 < length; i10++) {
                objArr2[i10] = strArr[i10];
            }
            objArr = objArr2;
        }
        C4760g c4760gF = C4760g.INSTANCE.a(c.a.TABLE).c(projection).f(selection, objArr);
        if (sortOrder == null) {
            sortOrder = "created_at ASC";
        }
        Cursor cursorQuery = i().u().getReadableDatabase().query(c4760gF.e(sortOrder).d());
        Context context = getContext();
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            cursorQuery.setNotificationUri(contentResolver, uri);
        }
        Log.i(TAG, "query: caller=" + strD + ", rows=" + cursorQuery.getCount());
        return cursorQuery;
    }

    public final TaskInfoCardEntity r(TaskInfoCardEntity entity) {
        if (!H.x0(entity.getUid())) {
            return entity;
        }
        String strK = TaskStoreModule.INSTANCE.k();
        return strK.length() > 0 ? TaskInfoCardEntity.copy$default(entity, null, strK, null, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, 0L, null, null, null, null, false, null, null, null, null, -3, 15, null) : entity;
    }

    public final ContentValues s(Bundle bundle) {
        ContentValues contentValues = new ContentValues(bundle.size());
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                contentValues.putNull(str);
            } else if (obj instanceof String) {
                contentValues.put(str, (String) obj);
            } else if (obj instanceof Integer) {
                contentValues.put(str, (Integer) obj);
            } else if (obj instanceof Long) {
                contentValues.put(str, (Long) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put(str, (Boolean) obj);
            } else if (obj instanceof Float) {
                contentValues.put(str, (Float) obj);
            } else if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
            } else if (obj instanceof Short) {
                contentValues.put(str, (Short) obj);
            } else if (obj instanceof Byte) {
                contentValues.put(str, (Byte) obj);
            } else if (obj instanceof byte[]) {
                contentValues.put(str, (byte[]) obj);
            } else {
                contentValues.put(str, obj.toString());
            }
        }
        return contentValues;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        String asString;
        kotlin.jvm.internal.p.i(uri, "uri");
        if (!f(com.stepos.ailauncher.chat.trace.a.BUTTON_UPDATE)) {
            return 0;
        }
        if (values == null) {
            throw new IllegalArgumentException("ContentValues 不能为空");
        }
        int iMatch = this.uriMatcher.match(uri);
        if (iMatch == 1) {
            asString = values.getAsString("task_id");
            if (asString == null) {
                throw new IllegalArgumentException("update 集合 URI 时 ContentValues 必须包含 task_id");
            }
        } else {
            if (iMatch != 2) {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            asString = uri.getLastPathSegment();
            if (asString == null) {
                throw new IllegalArgumentException("URI 缺少 taskId 路径段：" + uri);
            }
        }
        String str = asString;
        Log.i(TAG, "update: caller=" + d() + ", taskId=" + str + ", valuesKeys=" + values.keySet() + ", status=" + values.getAsString("status") + ", title=[" + values.getAsString("title") + "]");
        Pair pair = (Pair) C1062j.b(null, new AnonymousClass1(i().m0(), str, this, values, null), 1, null);
        TaskInfoCardUpsertOutcome taskInfoCardUpsertOutcome = (TaskInfoCardUpsertOutcome) pair.a();
        TaskInfoCardEntity taskInfoCardEntity = (TaskInfoCardEntity) pair.b();
        if (taskInfoCardUpsertOutcome == TaskInfoCardUpsertOutcome.STALE) {
            return 0;
        }
        if (taskInfoCardUpsertOutcome != TaskInfoCardUpsertOutcome.UNCHANGED) {
            o(uri, c.a.a(str));
            TaskStoreModule.INSTANCE.I(C1172u.e(C6363a.INSTANCE.a(taskInfoCardEntity)));
            return 1;
        }
        Log.i(TAG, "update: unchanged (duplicate frame), taskId=" + str);
        return 1;
    }
}
