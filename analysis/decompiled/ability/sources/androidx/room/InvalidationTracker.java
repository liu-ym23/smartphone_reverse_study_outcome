package androidx.room;

import C7.r;
import D7.q;
import D7.v;
import S7.n;
import android.content.Context;
import android.content.Intent;
import android.view.LiveData;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.autofill.HintConstants;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.support.AutoCloser;
import androidx.sqlite.SQLiteConnection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.e;
import m9.InterfaceC1733z;
import p9.h;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 s2\u00020\u0001:\u0003tusBS\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fB%\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005¢\u0006\u0004\b\u000b\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\u0010H\u0080@¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u0010¢\u0006\u0004\b\u001f\u0010\u001dJ$\u0010\"\u001a\u00020!2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u0005H\u0087@¢\u0006\u0004\b\"\u0010#J9\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070%2\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t\"\u00020\u00052\b\b\u0002\u0010$\u001a\u00020!H\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0000¢\u0006\u0004\b,\u0010+J\u0017\u0010.\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b.\u0010+J\u0017\u0010/\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0017¢\u0006\u0004\b/\u0010+J\u000f\u00100\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u0010\u001dJ\u000f\u00101\u001a\u00020\u0010H\u0017¢\u0006\u0004\b1\u0010\u001dJ\u001d\u00104\u001a\u00020\u00102\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0000¢\u0006\u0004\b2\u00103J;\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u001052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t2\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000006H\u0017¢\u0006\u0004\b9\u0010:JC\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u001052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t2\u0006\u0010;\u001a\u00020!2\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u000006H\u0017¢\u0006\u0004\b9\u0010<JI\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008\"\u0004\b\u0000\u001052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t2\u0006\u0010;\u001a\u00020!2\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00018\u00000=H\u0007¢\u0006\u0004\b9\u0010>J'\u0010F\u001a\u00020\u00102\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010C\u001a\u00020BH\u0000¢\u0006\u0004\bD\u0010EJ\u000f\u0010H\u001a\u00020\u0010H\u0000¢\u0006\u0004\bG\u0010\u001dJ\u000f\u0010I\u001a\u00020\u0010H\u0002¢\u0006\u0004\bI\u0010\u001dJ\u0017\u0010J\u001a\u00020!2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\bJ\u0010KJ\u0017\u0010L\u001a\u00020!2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\bL\u0010KJ\u0015\u0010N\u001a\b\u0012\u0004\u0012\u00020(0MH\u0002¢\u0006\u0004\bN\u0010OJ\u001d\u0010R\u001a\u00020\u00102\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020P0\u0007H\u0002¢\u0006\u0004\bR\u00103R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010S\u001a\u0004\bT\u0010UR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010VR&\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010VR\"\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010W\u001a\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R \u0010_\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020^0]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010VR\u0018\u0010b\u001a\u00060`j\u0002`a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010dR\u001a\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00100e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u001a\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00100e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010gR\u0014\u0010j\u001a\u00020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010l\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010o\u001a\u0004\u0018\u00010n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bq\u0010r¨\u0006v"}, d2 = {"Landroidx/room/InvalidationTracker;", "", "Landroidx/room/RoomDatabase;", "database", "", "", "shadowTablesMap", "", "viewTables", "", "tableNames", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)V", "(Landroidx/room/RoomDatabase;[Ljava/lang/String;)V", "Landroidx/room/support/AutoCloser;", "autoCloser", "LC7/r;", "setAutoCloser$room_runtime", "(Landroidx/room/support/AutoCloser;)V", "setAutoCloser", "Landroidx/sqlite/SQLiteConnection;", "connection", "internalInit$room_runtime", "(Landroidx/sqlite/SQLiteConnection;)V", "internalInit", "sync$room_runtime", "(LH7/c;)Ljava/lang/Object;", "sync", "syncBlocking$room_runtime", "()V", "syncBlocking", "refreshAsync", "tables", "", "refresh", "([Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "emitInitialState", "Lp9/c;", "createFlow", "([Ljava/lang/String;Z)Lp9/c;", "Landroidx/room/InvalidationTracker$Observer;", "observer", "addObserver", "(Landroidx/room/InvalidationTracker$Observer;)V", "addRemoteObserver$room_runtime", "addRemoteObserver", "addWeakObserver", "removeObserver", "refreshVersionsAsync", "refreshVersionsSync", "notifyObserversByTableNames$room_runtime", "(Ljava/util/Set;)V", "notifyObserversByTableNames", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/concurrent/Callable;", "computeFunction", "Landroidx/lifecycle/LiveData;", "createLiveData", "([Ljava/lang/String;Ljava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "inTransaction", "([Ljava/lang/String;ZLjava/util/concurrent/Callable;)Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "([Ljava/lang/String;ZLS7/k;)Landroidx/lifecycle/LiveData;", "Landroid/content/Context;", "context", HintConstants.AUTOFILL_HINT_NAME, "Landroid/content/Intent;", "serviceIntent", "initMultiInstanceInvalidation$room_runtime", "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "initMultiInstanceInvalidation", "stop$room_runtime", "stop", "onAutoCloseCallback", "addObserverOnly", "(Landroidx/room/InvalidationTracker$Observer;)Z", "removeObserverOnly", "", "getAllObservers", "()Ljava/util/List;", "", "tableIds", "notifyInvalidatedObservers", "Landroidx/room/RoomDatabase;", "getDatabase$room_runtime", "()Landroidx/room/RoomDatabase;", "Ljava/util/Map;", "[Ljava/lang/String;", "getTableNames$room_runtime", "()[Ljava/lang/String;", "Landroidx/room/TriggerBasedInvalidationTracker;", "implementation", "Landroidx/room/TriggerBasedInvalidationTracker;", "", "Landroidx/room/ObserverWrapper;", "observerMap", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/concurrent/ReentrantLock;", "observerMapLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/room/support/AutoCloser;", "Lkotlin/Function0;", "onRefreshScheduled", "LS7/a;", "onRefreshCompleted", "Landroidx/room/InvalidationLiveDataContainer;", "invalidationLiveDataContainer", "Landroidx/room/InvalidationLiveDataContainer;", "multiInstanceInvalidationIntent", "Landroid/content/Intent;", "Landroidx/room/MultiInstanceInvalidationClient;", "multiInstanceInvalidationClient", "Landroidx/room/MultiInstanceInvalidationClient;", "trackerLock", "Ljava/lang/Object;", "Companion", "Observer", "MultiInstanceClientInitState", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public class InvalidationTracker {
    private AutoCloser autoCloser;
    private final RoomDatabase database;
    private final TriggerBasedInvalidationTracker implementation;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private Intent multiInstanceInvalidationIntent;
    private final Map<Observer, ObserverWrapper> observerMap;
    private final ReentrantLock observerMapLock;
    private final S7.a onRefreshCompleted;
    private final S7.a onRefreshScheduled;
    private final Map<String, String> shadowTablesMap;
    private final String[] tableNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/room/InvalidationTracker$MultiInstanceClientInitState;", "", "context", "Landroid/content/Context;", HintConstants.AUTOFILL_HINT_NAME, "", "serviceIntent", "Landroid/content/Intent;", AppAgent.CONSTRUCT, "(Landroid/content/Context;Ljava/lang/String;Landroid/content/Intent;)V", "getContext", "()Landroid/content/Context;", "getName", "()Ljava/lang/String;", "getServiceIntent", "()Landroid/content/Intent;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class MultiInstanceClientInitState {
        private final Context context;
        private final String name;
        private final Intent serviceIntent;

        public MultiInstanceClientInitState(Context context, String name, Intent serviceIntent) {
            k.f(context, "context");
            k.f(name, "name");
            k.f(serviceIntent, "serviceIntent");
            this.context = context;
            this.name = name;
            this.serviceIntent = serviceIntent;
        }

        public static /* synthetic */ MultiInstanceClientInitState copy$default(MultiInstanceClientInitState multiInstanceClientInitState, Context context, String str, Intent intent, int i, Object obj) {
            if ((i & 1) != 0) {
                context = multiInstanceClientInitState.context;
            }
            if ((i & 2) != 0) {
                str = multiInstanceClientInitState.name;
            }
            if ((i & 4) != 0) {
                intent = multiInstanceClientInitState.serviceIntent;
            }
            return multiInstanceClientInitState.copy(context, str, intent);
        }

        /* renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component3, reason: from getter */
        public final Intent getServiceIntent() {
            return this.serviceIntent;
        }

        public final MultiInstanceClientInitState copy(Context context, String name, Intent serviceIntent) {
            k.f(context, "context");
            k.f(name, "name");
            k.f(serviceIntent, "serviceIntent");
            return new MultiInstanceClientInitState(context, name, serviceIntent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MultiInstanceClientInitState)) {
                return false;
            }
            MultiInstanceClientInitState multiInstanceClientInitState = (MultiInstanceClientInitState) other;
            return k.b(this.context, multiInstanceClientInitState.context) && k.b(this.name, multiInstanceClientInitState.name) && k.b(this.serviceIntent, multiInstanceClientInitState.serviceIntent);
        }

        public final Context getContext() {
            return this.context;
        }

        public final String getName() {
            return this.name;
        }

        public final Intent getServiceIntent() {
            return this.serviceIntent;
        }

        public int hashCode() {
            return this.serviceIntent.hashCode() + B7.a.c(this.context.hashCode() * 31, 31, this.name);
        }

        public String toString() {
            return "MultiInstanceClientInitState(context=" + this.context + ", name=" + this.name + ", serviceIntent=" + this.serviceIntent + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006B%\b\u0014\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003¢\u0006\u0004\b\u0005\u0010\tJ\u001d\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00118PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/room/InvalidationTracker$Observer;", "", "", "", "tables", AppAgent.CONSTRUCT, "([Ljava/lang/String;)V", "firstTable", "rest", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "LC7/r;", "onInvalidated", "(Ljava/util/Set;)V", "[Ljava/lang/String;", "getTables$room_runtime", "()[Ljava/lang/String;", "", "isRemote$room_runtime", "()Z", "isRemote", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class Observer {
        private final String[] tables;

        public Observer(String[] tables) {
            k.f(tables, "tables");
            this.tables = tables;
        }

        /* renamed from: getTables$room_runtime, reason: from getter */
        public final String[] getTables() {
            return this.tables;
        }

        public boolean isRemote$room_runtime() {
            return false;
        }

        public abstract void onInvalidated(Set<String> tables);

        public Observer(String firstTable, String... rest) {
            k.f(firstTable, "firstTable");
            k.f(rest, "rest");
            Z0.a aVar = new Z0.a(2);
            aVar.D(firstTable);
            aVar.E(rest);
            ArrayList arrayList = (ArrayList) aVar.f1582a;
            this((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }

    @J7.c(c = "androidx.room.InvalidationTracker$addObserver$1", f = "InvalidationTracker.android.kt", l = {253}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.InvalidationTracker$addObserver$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        int label;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return InvalidationTracker.this.new AnonymousClass1(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = InvalidationTracker.this.implementation;
                this.label = 1;
                if (triggerBasedInvalidationTracker.syncTriggers$room_runtime(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.room.InvalidationTracker$refreshVersionsSync$1", f = "InvalidationTracker.android.kt", l = {345}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.InvalidationTracker$refreshVersionsSync$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07821 extends SuspendLambda implements n {
        int label;

        public C07821(H7.c<? super C07821> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return InvalidationTracker.this.new C07821(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                S7.a aVar = InvalidationTracker.this.onRefreshScheduled;
                S7.a aVar2 = InvalidationTracker.this.onRefreshCompleted;
                this.label = 1;
                if (InvalidationTracker.this.implementation.refreshInvalidation$room_runtime(new String[0], aVar, aVar2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C07821) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "androidx.room.InvalidationTracker$removeObserver$1", f = "InvalidationTracker.android.kt", l = {310}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: androidx.room.InvalidationTracker$removeObserver$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07831 extends SuspendLambda implements n {
        int label;

        public C07831(H7.c<? super C07831> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return InvalidationTracker.this.new C07831(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = InvalidationTracker.this.implementation;
                this.label = 1;
                if (triggerBasedInvalidationTracker.syncTriggers$room_runtime(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C07831) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase database, Map<String, String> shadowTablesMap, Map<String, Set<String>> viewTables, String... tableNames) {
        k.f(database, "database");
        k.f(shadowTablesMap, "shadowTablesMap");
        k.f(viewTables, "viewTables");
        k.f(tableNames, "tableNames");
        this.database = database;
        this.shadowTablesMap = shadowTablesMap;
        this.viewTables = viewTables;
        this.tableNames = tableNames;
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = new TriggerBasedInvalidationTracker(database, shadowTablesMap, viewTables, tableNames, database.getUseTempTrackingTable(), new InvalidationTracker$implementation$1(this));
        this.implementation = triggerBasedInvalidationTracker;
        this.observerMap = new LinkedHashMap();
        this.observerMapLock = new ReentrantLock();
        final int i = 0;
        this.onRefreshScheduled = new S7.a(this) { // from class: androidx.room.b
            public final /* synthetic */ InvalidationTracker b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                InvalidationTracker invalidationTracker = this.b;
                switch (i6) {
                    case 0:
                        return InvalidationTracker.onRefreshScheduled$lambda$0(invalidationTracker);
                    case 1:
                        return InvalidationTracker.onRefreshCompleted$lambda$1(invalidationTracker);
                    default:
                        return Boolean.valueOf(InvalidationTracker._init_$lambda$2(invalidationTracker));
                }
            }
        };
        final int i6 = 1;
        this.onRefreshCompleted = new S7.a(this) { // from class: androidx.room.b
            public final /* synthetic */ InvalidationTracker b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                InvalidationTracker invalidationTracker = this.b;
                switch (i62) {
                    case 0:
                        return InvalidationTracker.onRefreshScheduled$lambda$0(invalidationTracker);
                    case 1:
                        return InvalidationTracker.onRefreshCompleted$lambda$1(invalidationTracker);
                    default:
                        return Boolean.valueOf(InvalidationTracker._init_$lambda$2(invalidationTracker));
                }
            }
        };
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(database);
        this.trackerLock = new Object();
        final int i10 = 2;
        triggerBasedInvalidationTracker.setOnAllowRefresh$room_runtime(new S7.a(this) { // from class: androidx.room.b
            public final /* synthetic */ InvalidationTracker b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i10;
                InvalidationTracker invalidationTracker = this.b;
                switch (i62) {
                    case 0:
                        return InvalidationTracker.onRefreshScheduled$lambda$0(invalidationTracker);
                    case 1:
                        return InvalidationTracker.onRefreshCompleted$lambda$1(invalidationTracker);
                    default:
                        return Boolean.valueOf(InvalidationTracker._init_$lambda$2(invalidationTracker));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$2(InvalidationTracker invalidationTracker) {
        return !invalidationTracker.database.inCompatibilityMode() || invalidationTracker.database.isOpenInternal$room_runtime();
    }

    private final boolean addObserverOnly(Observer observer) {
        Pair<String[], int[]> pairValidateTableNames$room_runtime = this.implementation.validateTableNames$room_runtime(observer.getTables());
        String[] strArr = (String[]) pairValidateTableNames$room_runtime.f4886a;
        int[] iArr = (int[]) pairValidateTableNames$room_runtime.b;
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArr);
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper observerWrapperPut = this.observerMap.containsKey(observer) ? (ObserverWrapper) kotlin.collections.a.N(observer, this.observerMap) : this.observerMap.put(observer, observerWrapper);
            reentrantLock.unlock();
            return observerWrapperPut == null && this.implementation.onObserverAdded$room_runtime(iArr);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static /* synthetic */ p9.c createFlow$default(InvalidationTracker invalidationTracker, String[] strArr, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createFlow");
        }
        if ((i & 2) != 0) {
            z10 = true;
        }
        return invalidationTracker.createFlow(strArr, z10);
    }

    private final List<Observer> getAllObservers() {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            return v.f1(this.observerMap.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyInvalidatedObservers(Set<Integer> tableIds) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List listF1 = v.f1(this.observerMap.values());
            reentrantLock.unlock();
            Iterator it = listF1.iterator();
            while (it.hasNext()) {
                ((ObserverWrapper) it.next()).notifyByTableIds$room_runtime(tableIds);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAutoCloseCallback() {
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    List<Observer> allObservers = getAllObservers();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : allObservers) {
                        if (!((Observer) obj).isRemote$room_runtime()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        multiInstanceInvalidationClient.stop();
                    }
                }
                this.implementation.resetSync$room_runtime();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onRefreshCompleted$lambda$1(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.decrementCountAndScheduleClose();
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onRefreshScheduled$lambda$0(InvalidationTracker invalidationTracker) {
        AutoCloser autoCloser = invalidationTracker.autoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        return r.f317a;
    }

    private final boolean removeObserverOnly(Observer observer) {
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            ObserverWrapper observerWrapperRemove = this.observerMap.remove(observer);
            return observerWrapperRemove != null && this.implementation.onObserverRemoved$room_runtime(observerWrapperRemove.getTableIds());
        } finally {
            reentrantLock.unlock();
        }
    }

    @WorkerThread
    public void addObserver(Observer observer) {
        k.f(observer, "observer");
        if (addObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new AnonymousClass1(null));
        }
    }

    public final void addRemoteObserver$room_runtime(Observer observer) {
        k.f(observer, "observer");
        if (!observer.isRemote$room_runtime()) {
            throw new IllegalStateException("isRemote was false of observer argument");
        }
        addObserverOnly(observer);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void addWeakObserver(Observer observer) {
        k.f(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    public final p9.c createFlow(String... tables) {
        k.f(tables, "tables");
        return createFlow$default(this, tables, false, 2, null);
    }

    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] tableNames, Callable<T> computeFunction) {
        k.f(tableNames, "tableNames");
        k.f(computeFunction, "computeFunction");
        return createLiveData(tableNames, false, (Callable) computeFunction);
    }

    /* renamed from: getDatabase$room_runtime, reason: from getter */
    public final RoomDatabase getDatabase() {
        return this.database;
    }

    /* renamed from: getTableNames$room_runtime, reason: from getter */
    public final String[] getTableNames() {
        return this.tableNames;
    }

    public final void initMultiInstanceInvalidation$room_runtime(Context context, String name, Intent serviceIntent) {
        k.f(context, "context");
        k.f(name, "name");
        k.f(serviceIntent, "serviceIntent");
        this.multiInstanceInvalidationIntent = serviceIntent;
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, name, this);
    }

    public final void internalInit$room_runtime(SQLiteConnection connection) {
        k.f(connection, "connection");
        this.implementation.configureConnection(connection);
        synchronized (this.trackerLock) {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
                if (multiInstanceInvalidationClient != null) {
                    Intent intent = this.multiInstanceInvalidationIntent;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    multiInstanceInvalidationClient.start(intent);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void notifyObserversByTableNames$room_runtime(Set<String> tables) {
        k.f(tables, "tables");
        ReentrantLock reentrantLock = this.observerMapLock;
        reentrantLock.lock();
        try {
            List<ObserverWrapper> listF1 = v.f1(this.observerMap.values());
            reentrantLock.unlock();
            for (ObserverWrapper observerWrapper : listF1) {
                if (!observerWrapper.getObserver().isRemote$room_runtime()) {
                    observerWrapper.notifyByTableNames$room_runtime(tables);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Object refresh(String[] strArr, H7.c<? super Boolean> cVar) {
        return this.implementation.refreshInvalidation$room_runtime(strArr, this.onRefreshScheduled, this.onRefreshCompleted, cVar);
    }

    public final void refreshAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    public void refreshVersionsAsync() {
        this.implementation.refreshInvalidationAsync$room_runtime(this.onRefreshScheduled, this.onRefreshCompleted);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new C07821(null));
    }

    @WorkerThread
    public void removeObserver(Observer observer) {
        k.f(observer, "observer");
        if (removeObserverOnly(observer)) {
            RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new C07831(null));
        }
    }

    public final void setAutoCloser$room_runtime(AutoCloser autoCloser) {
        k.f(autoCloser, "autoCloser");
        this.autoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new InvalidationTracker$setAutoCloser$1(this));
    }

    public final void stop$room_runtime() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
        }
    }

    public final Object sync$room_runtime(H7.c<? super r> cVar) throws Throwable {
        Object objSyncTriggers$room_runtime = this.implementation.syncTriggers$room_runtime(cVar);
        return objSyncTriggers$room_runtime == CoroutineSingletons.f4909a ? objSyncTriggers$room_runtime : r.f317a;
    }

    @WorkerThread
    public final void syncBlocking$room_runtime() {
        RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new InvalidationTracker$syncBlocking$1(this, null));
    }

    public final p9.c createFlow(String[] tables, boolean emitInitialState) {
        k.f(tables, "tables");
        Pair<String[], int[]> pairValidateTableNames$room_runtime = this.implementation.validateTableNames$room_runtime(tables);
        String[] strArr = (String[]) pairValidateTableNames$room_runtime.f4886a;
        p9.c cVarCreateFlow$room_runtime = this.implementation.createFlow$room_runtime(strArr, (int[]) pairValidateTableNames$room_runtime.b, emitInitialState);
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.multiInstanceInvalidationClient;
        p9.c cVarCreateFlow = multiInstanceInvalidationClient != null ? multiInstanceInvalidationClient.createFlow(strArr) : null;
        if (cVarCreateFlow == null) {
            return cVarCreateFlow$room_runtime;
        }
        p9.c[] cVarArr = {cVarCreateFlow$room_runtime, cVarCreateFlow};
        int i = h.f5560a;
        return new e(q.K(cVarArr), EmptyCoroutineContext.f4908a, -2, BufferOverflow.f5184a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        k.f(tableNames, "tableNames");
        k.f(computeFunction, "computeFunction");
        this.implementation.validateTableNames$room_runtime(tableNames);
        return this.invalidationLiveDataContainer.create(tableNames, inTransaction, computeFunction);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final <T> LiveData<T> createLiveData(String[] tableNames, boolean inTransaction, S7.k computeFunction) {
        k.f(tableNames, "tableNames");
        k.f(computeFunction, "computeFunction");
        this.implementation.validateTableNames$room_runtime(tableNames);
        return this.invalidationLiveDataContainer.create(tableNames, inTransaction, computeFunction);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @C7.c
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase database, String... tableNames) {
        this(database, kotlin.collections.a.M(), kotlin.collections.a.M(), (String[]) Arrays.copyOf(tableNames, tableNames.length));
        k.f(database, "database");
        k.f(tableNames, "tableNames");
    }
}
