package androidx.datastore.core;

import C7.f;
import C7.r;
import D7.v;
import H7.h;
import S7.a;
import S7.n;
import androidx.annotation.GuardedBy;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.datastore.core.handlers.NoOpCorruptionHandler;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentframework.adapter.bff.BffConstant;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.i;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;
import p9.c;
import p9.j;
import p9.m;
import u9.d;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 M*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003MNOBr\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00120\b\u0002\u0010\u000e\u001a*\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t0\b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0016\u001a\u00028\u00002\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001e\u001a\u00020\f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\"\u001a\u00020\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0082@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b&\u0010%J\u0013\u0010'\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010%J\u0013\u0010(\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b(\u0010%J\u0013\u0010)\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b)\u0010%J?\u0010,\u001a\u00028\u00002\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t2\u0006\u0010+\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\f*\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00100R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00101R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00102R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u00103R \u00105\u001a\b\u0012\u0004\u0012\u00028\u0000048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0014\u0010:\u001a\u0002098\u0002X\u0082D¢\u0006\u0006\n\u0004\b:\u0010;R\u001b\u0010@\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R&\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000B0A8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bC\u0010D\u0012\u0004\bE\u0010FRC\u0010G\u001a,\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\bG\u0010HR \u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000J0I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010L\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/DataStore;", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/Serializer;", "serializer", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "LH7/c;", "LC7/r;", "", "initTasksList", "Landroidx/datastore/core/CorruptionHandler;", "corruptionHandler", "Lm9/z;", "scope", AppAgent.CONSTRUCT, "(LS7/a;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lm9/z;)V", "transform", "updateData", "(LS7/n;LH7/c;)Ljava/lang/Object;", "newData", "writeData$datastore_core", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "writeData", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "read", "handleRead", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;LH7/c;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "update", "handleUpdate", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;LH7/c;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "(LH7/c;)Ljava/lang/Object;", "readAndInitOrPropagateFailure", "readAndInit", "readDataOrHandleCorruption", "readData", "LH7/h;", "callerContext", "transformAndWrite", "(LS7/n;LH7/h;LH7/c;)Ljava/lang/Object;", "createParentDirectories", "(Ljava/io/File;)V", "LS7/a;", "Landroidx/datastore/core/Serializer;", "Landroidx/datastore/core/CorruptionHandler;", "Lm9/z;", "Lp9/c;", SettingsConfig.KEY_DATA, "Lp9/c;", "getData", "()Lp9/c;", "", "SCRATCH_SUFFIX", "Ljava/lang/String;", "file$delegate", "LC7/f;", "getFile", "()Ljava/io/File;", BffConstant.Type.File, "Lp9/j;", "Landroidx/datastore/core/State;", "downstreamFlow", "Lp9/j;", "getDownstreamFlow$annotations", "()V", "initTasks", "Ljava/util/List;", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "actor", "Landroidx/datastore/core/SimpleActor;", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class SingleProcessDataStore<T> implements DataStore<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @GuardedBy("activeFilesLock")
    private static final Set<String> activeFiles = new LinkedHashSet();
    private static final Object activeFilesLock = new Object();
    private final String SCRATCH_SUFFIX;
    private final SimpleActor<Message<T>> actor;
    private final CorruptionHandler<T> corruptionHandler;
    private final c data;
    private final j downstreamFlow;

    /* renamed from: file$delegate, reason: from kotlin metadata */
    private final f file;
    private List<? extends n> initTasks;
    private final a produceFile;
    private final InterfaceC1733z scope;
    private final Serializer<T> serializer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Companion;", "", "()V", "activeFiles", "", "", "getActiveFiles$datastore_core", "()Ljava/util/Set;", "activeFilesLock", "getActiveFilesLock$datastore_core", "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Set<String> getActiveFiles$datastore_core() {
            return SingleProcessDataStore.activeFiles;
        }

        public final Object getActiveFilesLock$datastore_core() {
            return SingleProcessDataStore.activeFilesLock;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "lastState", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class Message<T> {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/SingleProcessDataStore$Message;", "lastState", "Landroidx/datastore/core/State;", "(Landroidx/datastore/core/State;)V", "getLastState", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Read<T> extends Message<T> {
            private final State<T> lastState;

            public Read(State<T> state) {
                super(null);
                this.lastState = state;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            public State<T> getLastState() {
                return this.lastState;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002BT\u0012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR6\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00038\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/SingleProcessDataStore$Message;", "Lkotlin/Function2;", "LH7/c;", "", "transform", "Lm9/p;", "ack", "Landroidx/datastore/core/State;", "lastState", "LH7/h;", "callerContext", AppAgent.CONSTRUCT, "(LS7/n;Lm9/p;Landroidx/datastore/core/State;LH7/h;)V", "LS7/n;", "getTransform", "()LS7/n;", "Lm9/p;", "getAck", "()Lm9/p;", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "LH7/h;", "getCallerContext", "()LH7/h;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class Update<T> extends Message<T> {
            private final InterfaceC1723p ack;
            private final h callerContext;
            private final State<T> lastState;
            private final n transform;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Update(n transform, InterfaceC1723p ack, State<T> state, h callerContext) {
                super(null);
                k.f(transform, "transform");
                k.f(ack, "ack");
                k.f(callerContext, "callerContext");
                this.transform = transform;
                this.ack = ack;
                this.lastState = state;
                this.callerContext = callerContext;
            }

            public final InterfaceC1723p getAck() {
                return this.ack;
            }

            public final h getCallerContext() {
                return this.callerContext;
            }

            @Override // androidx.datastore.core.SingleProcessDataStore.Message
            public State<T> getLastState() {
                return this.lastState;
            }

            public final n getTransform() {
                return this.transform;
            }
        }

        public /* synthetic */ Message(e eVar) {
            this();
        }

        public abstract State<T> getLastState();

        private Message() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "Ljava/io/FileOutputStream;", "fileOutputStream", AppAgent.CONSTRUCT, "(Ljava/io/FileOutputStream;)V", "", "b", "LC7/r;", "write", "(I)V", "", "([B)V", SingleFileBundle.KEY_BYTES, "off", "len", "([BII)V", "close", "()V", "flush", "Ljava/io/FileOutputStream;", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class UncloseableOutputStream extends OutputStream {
        private final FileOutputStream fileOutputStream;

        public UncloseableOutputStream(FileOutputStream fileOutputStream) {
            k.f(fileOutputStream, "fileOutputStream");
            this.fileOutputStream = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        public final FileOutputStream getFileOutputStream() {
            return this.fileOutputStream;
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b) throws IOException {
            k.f(b, "b");
            this.fileOutputStream.write(b);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes, int off, int len) throws IOException {
            k.f(bytes, "bytes");
            this.fileOutputStream.write(bytes, off, len);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$handleUpdate$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.handleUpdate(null, this);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, TypedValues.PositionType.TYPE_SIZE_PERCENT}, m = "readAndInit")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInit$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07411 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07411(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super C07411> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInit(this);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07421 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07421(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super C07421> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateAndThrowFailure(this);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07431 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07431(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super C07431> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readAndInitOrPropagateFailure(this);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$readData$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07441(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super C07441> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readData(this);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07451(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super C07451> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.readDataOrHandleCorruption(this);
        }
    }

    @J7.c(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {TypedValues.CycleType.TYPE_VISIBILITY, 410}, m = "transformAndWrite")
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1, reason: invalid class name and case insensitive filesystem */
    public static final class C07461 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SingleProcessDataStore<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C07461(SingleProcessDataStore<T> singleProcessDataStore, H7.c<? super C07461> cVar) {
            super(cVar);
            this.this$0 = singleProcessDataStore;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.transformAndWrite(null, null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SingleProcessDataStore(a aVar, Serializer serializer, List list, CorruptionHandler corruptionHandler, InterfaceC1733z interfaceC1733z, int i, e eVar) {
        List list2 = (i & 4) != 0 ? EmptyList.f4893a : list;
        CorruptionHandler noOpCorruptionHandler = (i & 8) != 0 ? new NoOpCorruptionHandler() : corruptionHandler;
        if ((i & 16) != 0) {
            d dVar = AbstractC1691I.f5315a;
            interfaceC1733z = AbstractC1683A.b(u9.c.f6743a.plus(AbstractC1683A.c()));
        }
        this(aVar, serializer, list2, noOpCorruptionHandler, interfaceC1733z);
    }

    private final void createParentDirectories(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(k.l(file, "Unable to create parent directories of "));
        }
    }

    private static /* synthetic */ void getDownstreamFlow$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getFile() {
        return (File) this.file.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handleRead(Message.Read<T> read, H7.c<? super r> cVar) {
        Object andInitOrPropagateFailure;
        State<T> state = (State) ((i) this.downstreamFlow).getValue();
        boolean z10 = state instanceof Data;
        r rVar = r.f317a;
        if (!z10) {
            if (state instanceof ReadException) {
                return (state == read.getLastState() && (andInitOrPropagateFailure = readAndInitOrPropagateFailure(cVar)) == CoroutineSingletons.f4909a) ? andInitOrPropagateFailure : rVar;
            }
            if (k.b(state, UnInitialized.INSTANCE)) {
                Object andInitOrPropagateFailure2 = readAndInitOrPropagateFailure(cVar);
                return andInitOrPropagateFailure2 == CoroutineSingletons.f4909a ? andInitOrPropagateFailure2 : rVar;
            }
            if (state instanceof Final) {
                throw new IllegalStateException("Can't read in final state.");
            }
        }
        return rVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b7, code lost:
    
        if (r8 != r1) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleUpdate(androidx.datastore.core.SingleProcessDataStore.Message.Update<T> r9, H7.c<? super C7.r> r10) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.handleUpdate(androidx.datastore.core.SingleProcessDataStore$Message$Update, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInit(H7.c<? super C7.r> r12) throws androidx.datastore.core.CorruptionException, java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInit(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(H7.c<? super C7.r> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.C07421
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore.C07421) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.b.b(r5)     // Catch: java.lang.Throwable -> L2b
            goto L43
        L2b:
            r5 = move-exception
            goto L46
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.b.b(r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
            r0.label = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r4 = r4.readAndInit(r0)     // Catch: java.lang.Throwable -> L2b
            if (r4 != r1) goto L43
            return r1
        L43:
            C7.r r4 = C7.r.f317a
            return r4
        L46:
            p9.j r4 = r4.downstreamFlow
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r0.<init>(r5)
            kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) r4
            r4.getClass()
            r1 = 0
            r4.j(r1, r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInitOrPropagateAndThrowFailure(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readAndInitOrPropagateFailure(H7.c<? super C7.r> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore.C07431
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore.C07431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.b.b(r5)     // Catch: java.lang.Throwable -> L2b
            goto L53
        L2b:
            r5 = move-exception
            goto L43
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.b.b(r5)
            r0.L$0 = r4     // Catch: java.lang.Throwable -> L2b
            r0.label = r3     // Catch: java.lang.Throwable -> L2b
            java.lang.Object r4 = r4.readAndInit(r0)     // Catch: java.lang.Throwable -> L2b
            if (r4 != r1) goto L53
            return r1
        L43:
            p9.j r4 = r4.downstreamFlow
            androidx.datastore.core.ReadException r0 = new androidx.datastore.core.ReadException
            r0.<init>(r5)
            kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.i) r4
            r4.getClass()
            r5 = 0
            r4.j(r5, r0)
        L53:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInitOrPropagateFailure(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [H7.c, androidx.datastore.core.SingleProcessDataStore$readData$1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.datastore.core.Serializer, androidx.datastore.core.Serializer<T>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readData(H7.c<? super T> r6) throws java.io.FileNotFoundException {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore.C07441
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore.C07441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.L$2
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Object r1 = r0.L$1
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.b.b(r6)     // Catch: java.lang.Throwable -> L33
            goto L5f
        L33:
            r5 = move-exception
            goto L6a
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.b.b(r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L70
            java.io.File r2 = r5.getFile()     // Catch: java.io.FileNotFoundException -> L70
            r6.<init>(r2)     // Catch: java.io.FileNotFoundException -> L70
            androidx.datastore.core.Serializer<T> r2 = r5.serializer     // Catch: java.lang.Throwable -> L65
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L65
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L65
            r4 = 0
            r0.L$2 = r4     // Catch: java.lang.Throwable -> L65
            r0.label = r3     // Catch: java.lang.Throwable -> L65
            java.lang.Object r0 = r2.readFrom(r6, r0)     // Catch: java.lang.Throwable -> L65
            if (r0 != r1) goto L5b
            return r1
        L5b:
            r1 = r6
            r6 = r0
            r0 = r5
            r5 = r4
        L5f:
            D7.N.t(r1, r5)     // Catch: java.io.FileNotFoundException -> L63
            return r6
        L63:
            r5 = move-exception
            goto L73
        L65:
            r0 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            r1 = r6
        L6a:
            throw r5     // Catch: java.lang.Throwable -> L6b
        L6b:
            r6 = move-exception
            D7.N.t(r1, r5)     // Catch: java.io.FileNotFoundException -> L63
            throw r6     // Catch: java.io.FileNotFoundException -> L63
        L70:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L73:
            java.io.File r6 = r0.getFile()
            boolean r6 = r6.exists()
            if (r6 != 0) goto L84
            androidx.datastore.core.Serializer<T> r5 = r0.serializer
            java.lang.Object r5 = r5.getDefaultValue()
            return r5
        L84:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readData(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readDataOrHandleCorruption(H7.c<? super T> r8) throws androidx.datastore.core.CorruptionException, java.io.FileNotFoundException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore.C07451
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore.C07451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L53
            if (r2 == r5) goto L49
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r7 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.b.b(r8)     // Catch: java.io.IOException -> L33
            return r7
        L33:
            r7 = move-exception
            goto L86
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            java.lang.Object r7 = r0.L$1
            androidx.datastore.core.CorruptionException r7 = (androidx.datastore.core.CorruptionException) r7
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.b.b(r8)
            goto L75
        L49:
            java.lang.Object r7 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r7 = (androidx.datastore.core.SingleProcessDataStore) r7
            kotlin.b.b(r8)     // Catch: androidx.datastore.core.CorruptionException -> L51
            return r8
        L51:
            r8 = move-exception
            goto L62
        L53:
            kotlin.b.b(r8)
            r0.L$0 = r7     // Catch: androidx.datastore.core.CorruptionException -> L51
            r0.label = r5     // Catch: androidx.datastore.core.CorruptionException -> L51
            java.lang.Object r7 = r7.readData(r0)     // Catch: androidx.datastore.core.CorruptionException -> L51
            if (r7 != r1) goto L61
            goto L81
        L61:
            return r7
        L62:
            androidx.datastore.core.CorruptionHandler<T> r2 = r7.corruptionHandler
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r2.handleCorruption(r8, r0)
            if (r2 != r1) goto L71
            goto L81
        L71:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L75:
            r0.L$0 = r7     // Catch: java.io.IOException -> L83
            r0.L$1 = r8     // Catch: java.io.IOException -> L83
            r0.label = r3     // Catch: java.io.IOException -> L83
            java.lang.Object r7 = r2.writeData$datastore_core(r8, r0)     // Catch: java.io.IOException -> L83
            if (r7 != r1) goto L82
        L81:
            return r1
        L82:
            return r8
        L83:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L86:
            S0.b.e0(r0, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readDataOrHandleCorruption(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object transformAndWrite(S7.n r8, H7.h r9, H7.c<? super T> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore.C07461
            if (r0 == 0) goto L13
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore.C07461) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$1
            java.lang.Object r8 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r8 = (androidx.datastore.core.SingleProcessDataStore) r8
            kotlin.b.b(r10)
            goto L8f
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            java.lang.Object r7 = r0.L$2
            java.lang.Object r8 = r0.L$1
            androidx.datastore.core.Data r8 = (androidx.datastore.core.Data) r8
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            kotlin.b.b(r10)
            goto L74
        L47:
            kotlin.b.b(r10)
            p9.j r10 = r7.downstreamFlow
            kotlinx.coroutines.flow.i r10 = (kotlinx.coroutines.flow.i) r10
            java.lang.Object r10 = r10.getValue()
            androidx.datastore.core.Data r10 = (androidx.datastore.core.Data) r10
            r10.checkHashCode()
            java.lang.Object r2 = r10.getValue()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r8, r2, r5)
            r0.L$0 = r7
            r0.L$1 = r10
            r0.L$2 = r2
            r0.label = r4
            java.lang.Object r8 = m9.AbstractC1683A.w(r9, r6, r0)
            if (r8 != r1) goto L6f
            goto L8c
        L6f:
            r9 = r10
            r10 = r8
            r8 = r9
            r9 = r7
            r7 = r2
        L74:
            r8.checkHashCode()
            boolean r8 = kotlin.jvm.internal.k.b(r7, r10)
            if (r8 == 0) goto L7e
            return r7
        L7e:
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r7 = r9.writeData$datastore_core(r10, r0)
            if (r7 != r1) goto L8d
        L8c:
            return r1
        L8d:
            r8 = r9
            r7 = r10
        L8f:
            p9.j r8 = r8.downstreamFlow
            androidx.datastore.core.Data r9 = new androidx.datastore.core.Data
            if (r7 == 0) goto L9a
            int r10 = r7.hashCode()
            goto L9b
        L9a:
            r10 = 0
        L9b:
            r9.<init>(r7, r10)
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.i) r8
            r8.getClass()
            r8.j(r5, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.transformAndWrite(S7.n, H7.h, H7.c):java.lang.Object");
    }

    @Override // androidx.datastore.core.DataStore
    public c getData() {
        return this.data;
    }

    @Override // androidx.datastore.core.DataStore
    public Object updateData(n nVar, H7.c<? super T> cVar) {
        C1724q c1724q = new C1724q();
        this.actor.offer(new Message.Update(nVar, c1724q, (State) ((i) this.downstreamFlow).getValue(), cVar.getContext()));
        Object objZ = c1724q.z(cVar);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        return objZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeData$datastore_core(T r9, H7.c<? super C7.r> r10) throws java.io.IOException {
        /*
            r8 = this;
            java.lang.String r0 = "Unable to rename "
            boolean r1 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r1 == 0) goto L15
            r1 = r10
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r1 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.label = r2
            goto L1a
        L15:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r1 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r1.<init>(r8, r10)
        L1a:
            java.lang.Object r10 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r3 = r1.label
            r4 = 1
            if (r3 == 0) goto L48
            if (r3 != r4) goto L40
            java.lang.Object r8 = r1.L$4
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
            java.lang.Object r9 = r1.L$3
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r2 = r1.L$2
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r3 = r1.L$1
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r1 = r1.L$0
            androidx.datastore.core.SingleProcessDataStore r1 = (androidx.datastore.core.SingleProcessDataStore) r1
            kotlin.b.b(r10)     // Catch: java.lang.Throwable -> L3d
            goto L89
        L3d:
            r8 = move-exception
            goto Lbb
        L40:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L48:
            kotlin.b.b(r10)
            java.io.File r10 = r8.getFile()
            r8.createParentDirectories(r10)
            java.io.File r3 = new java.io.File
            java.io.File r10 = r8.getFile()
            java.lang.String r10 = r10.getAbsolutePath()
            java.lang.String r5 = r8.SCRATCH_SUFFIX
            java.lang.String r10 = kotlin.jvm.internal.k.l(r5, r10)
            r3.<init>(r10)
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch: java.io.IOException -> Lb7
            r10.<init>(r3)     // Catch: java.io.IOException -> Lb7
            androidx.datastore.core.Serializer<T> r5 = r8.serializer     // Catch: java.lang.Throwable -> Lb9
            androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream r6 = new androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream     // Catch: java.lang.Throwable -> Lb9
            r6.<init>(r10)     // Catch: java.lang.Throwable -> Lb9
            r1.L$0 = r8     // Catch: java.lang.Throwable -> Lb9
            r1.L$1 = r3     // Catch: java.lang.Throwable -> Lb9
            r1.L$2 = r10     // Catch: java.lang.Throwable -> Lb9
            r7 = 0
            r1.L$3 = r7     // Catch: java.lang.Throwable -> Lb9
            r1.L$4 = r10     // Catch: java.lang.Throwable -> Lb9
            r1.label = r4     // Catch: java.lang.Throwable -> Lb9
            java.lang.Object r9 = r5.writeTo(r9, r6, r1)     // Catch: java.lang.Throwable -> Lb9
            if (r9 != r2) goto L85
            return r2
        L85:
            r1 = r8
            r8 = r10
            r2 = r8
            r9 = r7
        L89:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch: java.lang.Throwable -> L3d
            r8.sync()     // Catch: java.lang.Throwable -> L3d
            D7.N.t(r2, r9)     // Catch: java.io.IOException -> Lb7
            java.io.File r8 = r1.getFile()     // Catch: java.io.IOException -> Lb7
            boolean r8 = r3.renameTo(r8)     // Catch: java.io.IOException -> Lb7
            if (r8 == 0) goto La0
            C7.r r8 = C7.r.f317a
            return r8
        La0:
            java.io.IOException r8 = new java.io.IOException     // Catch: java.io.IOException -> Lb7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lb7
            r9.<init>(r0)     // Catch: java.io.IOException -> Lb7
            r9.append(r3)     // Catch: java.io.IOException -> Lb7
            java.lang.String r10 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r10)     // Catch: java.io.IOException -> Lb7
            java.lang.String r9 = r9.toString()     // Catch: java.io.IOException -> Lb7
            r8.<init>(r9)     // Catch: java.io.IOException -> Lb7
            throw r8     // Catch: java.io.IOException -> Lb7
        Lb7:
            r8 = move-exception
            goto Lc1
        Lb9:
            r8 = move-exception
            r2 = r10
        Lbb:
            throw r8     // Catch: java.lang.Throwable -> Lbc
        Lbc:
            r9 = move-exception
            D7.N.t(r2, r8)     // Catch: java.io.IOException -> Lb7
            throw r9     // Catch: java.io.IOException -> Lb7
        Lc1:
            boolean r9 = r3.exists()
            if (r9 == 0) goto Lca
            r3.delete()
        Lca:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.writeData$datastore_core(java.lang.Object, H7.c):java.lang.Object");
    }

    public SingleProcessDataStore(a produceFile, Serializer<T> serializer, List<? extends n> initTasksList, CorruptionHandler<T> corruptionHandler, InterfaceC1733z scope) {
        k.f(produceFile, "produceFile");
        k.f(serializer, "serializer");
        k.f(initTasksList, "initTasksList");
        k.f(corruptionHandler, "corruptionHandler");
        k.f(scope, "scope");
        this.produceFile = produceFile;
        this.serializer = serializer;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = new m(new SingleProcessDataStore$data$1(this, null));
        this.SCRATCH_SUFFIX = ".tmp";
        this.file = kotlin.a.a(new a(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // S7.a
            public final File invoke() {
                File file = (File) ((SingleProcessDataStore) this.this$0).produceFile.invoke();
                String it = file.getAbsolutePath();
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                synchronized (companion.getActiveFilesLock$datastore_core()) {
                    if (companion.getActiveFiles$datastore_core().contains(it)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Set<String> activeFiles$datastore_core = companion.getActiveFiles$datastore_core();
                    k.e(it, "it");
                    activeFiles$datastore_core.add(it);
                }
                return file;
            }
        });
        this.downstreamFlow = p9.e.c(UnInitialized.INSTANCE);
        this.initTasks = v.f1(initTasksList);
        this.actor = new SimpleActor<>(scope, new S7.k(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1
            final /* synthetic */ SingleProcessDataStore<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return r.f317a;
            }

            public final void invoke(Throwable th) {
                if (th != null) {
                    j jVar = ((SingleProcessDataStore) this.this$0).downstreamFlow;
                    Final r1 = new Final(th);
                    i iVar = (i) jVar;
                    iVar.getClass();
                    iVar.j(null, r1);
                }
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                Object activeFilesLock$datastore_core = companion.getActiveFilesLock$datastore_core();
                SingleProcessDataStore<T> singleProcessDataStore = this.this$0;
                synchronized (activeFilesLock$datastore_core) {
                    companion.getActiveFiles$datastore_core().remove(singleProcessDataStore.getFile().getAbsolutePath());
                }
            }
        }, new n() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((SingleProcessDataStore.Message) obj, (Throwable) obj2);
                return r.f317a;
            }

            public final void invoke(SingleProcessDataStore.Message<T> msg, Throwable th) {
                k.f(msg, "msg");
                if (msg instanceof SingleProcessDataStore.Message.Update) {
                    InterfaceC1723p ack = ((SingleProcessDataStore.Message.Update) msg).getAck();
                    if (th == null) {
                        th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    ((C1724q) ack).g0(th);
                }
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }
}
