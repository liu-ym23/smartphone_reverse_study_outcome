package androidx.datastore.core;

import J0.d;
import J0.f;
import J0.g;
import J0.i;
import J0.j;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.M;
import Xa.k;
import Xa.u;
import Y8.h;
import Y8.t;
import Z8.F;
import androidx.datastore.core.SingleProcessDataStore;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.ailauncher.chat.trace.a;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import p9.p;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 T*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003\u001602Br\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u00120\b\u0002\u0010\u000e\u001a*\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t0\b\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0016\u001a\u00028\u00002\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001d\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010!\u001a\u00020\f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0082@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0013\u0010%\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b%\u0010$J\u0013\u0010&\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b&\u0010$J\u0013\u0010'\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b'\u0010$J\u0013\u0010(\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b(\u0010$J?\u0010+\u001a\u00028\u00002\"\u0010\u0015\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t2\u0006\u0010*\u001a\u00020)H\u0082@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0013\u0010-\u001a\u00020\f*\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010/R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R \u0010;\u001a\b\u0012\u0004\u0012\u00028\u0000068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082D¢\u0006\u0006\n\u0004\b=\u0010>R\u001b\u0010D\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR&\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000F0E8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bG\u0010H\u0012\u0004\bI\u0010JRC\u0010N\u001a,\u0012&\u0012$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\r0\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\bL\u0010MR \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000P0O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010R\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", ExifInterface.GPS_DIRECTION_TRUE, "LJ0/d;", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "LJ0/i;", "serializer", "", "Lkotlin/Function2;", "LJ0/g;", "Le9/c;", "LY8/t;", "", "initTasksList", "LJ0/a;", "corruptionHandler", "LUa/M;", "scope", "<init>", "(Lp9/a;LJ0/i;Ljava/util/List;LJ0/a;LUa/M;)V", "transform", Const.INTENT_KEY_APIKEY, "(Lp9/p;Le9/c;)Ljava/lang/Object;", "newData", "z", "(Ljava/lang/Object;Le9/c;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$b$a;", "read", "r", "(Landroidx/datastore/core/SingleProcessDataStore$b$a;Le9/c;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$b$b;", a.BUTTON_UPDATE, "s", "(Landroidx/datastore/core/SingleProcessDataStore$b$b;Le9/c;)Ljava/lang/Object;", "u", "(Le9/c;)Ljava/lang/Object;", "v", "t", "x", "w", "Lkotlin/coroutines/d;", "callerContext", "y", "(Lp9/p;Lkotlin/coroutines/d;Le9/c;)Ljava/lang/Object;", "p", "(Ljava/io/File;)V", "Lp9/a;", Const.INTENT_KEY_PKGNAME, "LJ0/i;", "c", "LJ0/a;", Const.INTENT_KEY_UMID, "LUa/M;", "LXa/b;", "e", "LXa/b;", "getData", "()LXa/b;", "data", "", "f", "Ljava/lang/String;", "SCRATCH_SUFFIX", Const.INTENT_KEY_BACKGROUND_COMMAND, "LY8/h;", "q", "()Ljava/io/File;", Const.STR_FILE, "LXa/k;", "LJ0/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "LXa/k;", "getDownstreamFlow$annotations", "()V", "downstreamFlow", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/List;", "initTasks", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Landroidx/datastore/core/SimpleActor;", "actor", "k", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SingleProcessDataStore<T> implements d<T> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l, reason: collision with root package name */
    public static final Set<String> f13286l = new LinkedHashSet();

    /* renamed from: m, reason: collision with root package name */
    public static final Object f13287m = new Object();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5063a<File> produceFile;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final i<T> serializer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final J0.a<T> corruptionHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Xa.b<T> data;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final String SCRATCH_SUFFIX;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final h file;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final k<j<T>> downstreamFlow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public List<? extends p<? super g<T>, ? super InterfaceC4014c<? super t>, ? extends Object>> initTasks;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final SimpleActor<b<T>> actor;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$a;", "", "<init>", "()V", "", "", "activeFiles", "Ljava/util/Set;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Set;", "activeFilesLock", "Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final Set<String> a() {
            return SingleProcessDataStore.f13286l;
        }

        public final Object b() {
            return SingleProcessDataStore.f13287m;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$b;", ExifInterface.GPS_DIRECTION_TRUE, "", "<init>", "()V", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Landroidx/datastore/core/SingleProcessDataStore$b$a;", "Landroidx/datastore/core/SingleProcessDataStore$b$b;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class b<T> {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$b$a;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/SingleProcessDataStore$b;", "LJ0/j;", "lastState", "<init>", "(LJ0/j;)V", Const.INTENT_KEY_APIKEY, "LJ0/j;", "()LJ0/j;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class a<T> extends b<T> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final j<T> lastState;

            public a(j<T> jVar) {
                super(null);
                this.lastState = jVar;
            }

            public j<T> a() {
                return this.lastState;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002BT\u0012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eR6\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00038\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u00078\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0015R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u0013\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$b$b;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/datastore/core/SingleProcessDataStore$b;", "Lkotlin/Function2;", "Le9/c;", "", "transform", "LUa/u;", "ack", "LJ0/j;", "lastState", "Lkotlin/coroutines/d;", "callerContext", "<init>", "(Lp9/p;LUa/u;LJ0/j;Lkotlin/coroutines/d;)V", Const.INTENT_KEY_APIKEY, "Lp9/p;", Const.INTENT_KEY_UMID, "()Lp9/p;", Const.INTENT_KEY_PKGNAME, "LUa/u;", "()LUa/u;", "c", "LJ0/j;", "()LJ0/j;", "Lkotlin/coroutines/d;", "()Lkotlin/coroutines/d;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: androidx.datastore.core.SingleProcessDataStore$b$b, reason: collision with other inner class name */
        public static final class C0162b<T> extends b<T> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final p<T, InterfaceC4014c<? super T>, Object> transform;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final InterfaceC1083u<T> ack;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public final j<T> lastState;

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            public final kotlin.coroutines.d callerContext;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0162b(p<? super T, ? super InterfaceC4014c<? super T>, ? extends Object> transform, InterfaceC1083u<T> ack, j<T> jVar, kotlin.coroutines.d callerContext) {
                super(null);
                kotlin.jvm.internal.p.i(transform, "transform");
                kotlin.jvm.internal.p.i(ack, "ack");
                kotlin.jvm.internal.p.i(callerContext, "callerContext");
                this.transform = transform;
                this.ack = ack;
                this.lastState = jVar;
                this.callerContext = callerContext;
            }

            public final InterfaceC1083u<T> a() {
                return this.ack;
            }

            /* renamed from: b, reason: from getter */
            public final kotlin.coroutines.d getCallerContext() {
                return this.callerContext;
            }

            public j<T> c() {
                return this.lastState;
            }

            public final p<T, InterfaceC4014c<? super T>, Object> d() {
                return this.transform;
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$c;", "Ljava/io/OutputStream;", "Ljava/io/FileOutputStream;", "fileOutputStream", "<init>", "(Ljava/io/FileOutputStream;)V", "", Const.INTENT_KEY_PKGNAME, "LY8/t;", "write", "(I)V", "", "([B)V", SingleFileBundle.KEY_BYTES, W4.a.ENABLE_OFF, "len", "([BII)V", "close", "()V", "flush", Const.INTENT_KEY_APIKEY, "Ljava/io/FileOutputStream;", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends OutputStream {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final FileOutputStream fileOutputStream;

        public c(FileOutputStream fileOutputStream) {
            kotlin.jvm.internal.p.i(fileOutputStream, "fileOutputStream");
            this.fileOutputStream = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.fileOutputStream.flush();
        }

        @Override // java.io.OutputStream
        public void write(int b10) throws IOException {
            this.fileOutputStream.write(b10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b10) throws IOException {
            kotlin.jvm.internal.p.i(b10, "b");
            this.fileOutputStream.write(b10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bytes, int off, int len) throws IOException {
            kotlin.jvm.internal.p.i(bytes, "bytes");
            this.fileOutputStream.write(bytes, off, len);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore(InterfaceC5063a<? extends File> produceFile, i<T> serializer, List<? extends p<? super g<T>, ? super InterfaceC4014c<? super t>, ? extends Object>> initTasksList, J0.a<T> corruptionHandler, M scope) {
        kotlin.jvm.internal.p.i(produceFile, "produceFile");
        kotlin.jvm.internal.p.i(serializer, "serializer");
        kotlin.jvm.internal.p.i(initTasksList, "initTasksList");
        kotlin.jvm.internal.p.i(corruptionHandler, "corruptionHandler");
        kotlin.jvm.internal.p.i(scope, "scope");
        this.produceFile = produceFile;
        this.serializer = serializer;
        this.corruptionHandler = corruptionHandler;
        this.scope = scope;
        this.data = Xa.d.B(new SingleProcessDataStore$data$1(this, null));
        this.SCRATCH_SUFFIX = ".tmp";
        this.file = C4848b.b(new InterfaceC5063a<File>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SingleProcessDataStore<T> f13320a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f13320a = this;
            }

            @Override // p9.InterfaceC5063a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final File invoke() {
                File file = (File) this.f13320a.produceFile.invoke();
                String it = file.getAbsolutePath();
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                synchronized (companion.b()) {
                    if (companion.a().contains(it)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Set<String> setA = companion.a();
                    kotlin.jvm.internal.p.h(it, "it");
                    setA.add(it);
                }
                return file;
            }
        });
        this.downstreamFlow = u.a(J0.k.f3693a);
        this.initTasks = F.m1(initTasksList);
        this.actor = new SimpleActor<>(scope, new InterfaceC5074l<Throwable, t>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ SingleProcessDataStore<T> f13303a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f13303a = this;
            }

            public final void a(Throwable th) {
                if (th != null) {
                    this.f13303a.downstreamFlow.setValue(new f(th));
                }
                SingleProcessDataStore.Companion companion = SingleProcessDataStore.INSTANCE;
                Object objB = companion.b();
                SingleProcessDataStore<T> singleProcessDataStore = this.f13303a;
                synchronized (objB) {
                    companion.a().remove(singleProcessDataStore.q().getAbsolutePath());
                    t tVar = t.f7040a;
                }
            }

            @Override // p9.InterfaceC5074l
            public /* bridge */ /* synthetic */ t invoke(Throwable th) {
                a(th);
                return t.f7040a;
            }
        }, new p<b<T>, Throwable, t>() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            public final void a(SingleProcessDataStore.b<T> msg, Throwable th) {
                kotlin.jvm.internal.p.i(msg, "msg");
                if (msg instanceof SingleProcessDataStore.b.C0162b) {
                    InterfaceC1083u<T> interfaceC1083uA = ((SingleProcessDataStore.b.C0162b) msg).a();
                    if (th == null) {
                        th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    interfaceC1083uA.e(th);
                }
            }

            @Override // p9.p
            public /* bridge */ /* synthetic */ t invoke(Object obj, Throwable th) {
                a((SingleProcessDataStore.b) obj, th);
                return t.f7040a;
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }

    @Override // J0.d
    public Object a(p<? super T, ? super InterfaceC4014c<? super T>, ? extends Object> pVar, InterfaceC4014c<? super T> interfaceC4014c) {
        InterfaceC1083u interfaceC1083uC = C1087w.c(null, 1, null);
        this.actor.e(new b.C0162b(pVar, interfaceC1083uC, this.downstreamFlow.getValue(), interfaceC4014c.getContext()));
        return interfaceC1083uC.a1(interfaceC4014c);
    }

    @Override // J0.d
    public Xa.b<T> getData() {
        return this.data;
    }

    public final void p(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(kotlin.jvm.internal.p.r("Unable to create parent directories of ", file));
        }
    }

    public final File q() {
        return (File) this.file.getValue();
    }

    public final Object r(b.a<T> aVar, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        j<T> value = this.downstreamFlow.getValue();
        if (!(value instanceof J0.b)) {
            if (value instanceof J0.h) {
                if (value == aVar.a()) {
                    Object objV = v(interfaceC4014c);
                    return objV == C4063a.g() ? objV : t.f7040a;
                }
            } else {
                if (kotlin.jvm.internal.p.d(value, J0.k.f3693a)) {
                    Object objV2 = v(interfaceC4014c);
                    return objV2 == C4063a.g() ? objV2 : t.f7040a;
                }
                if (value instanceof f) {
                    throw new IllegalStateException("Can't read in final state.");
                }
            }
        }
        return t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b9, code lost:
    
        if (r8 == r1) goto L45;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(androidx.datastore.core.SingleProcessDataStore.b.C0162b<T> r9, e9.InterfaceC4014c<? super Y8.t> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.s(androidx.datastore.core.SingleProcessDataStore$b$b, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(e9.InterfaceC4014c<? super Y8.t> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.t(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.f13351d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13351d = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f13349b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f13351d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f13348a
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L45
        L2d:
            r5 = move-exception
            goto L48
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r5)
            r0.f13348a = r4     // Catch: java.lang.Throwable -> L2d
            r0.f13351d = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = r4.t(r0)     // Catch: java.lang.Throwable -> L2d
            if (r4 != r1) goto L45
            return r1
        L45:
            Y8.t r4 = Y8.t.f7040a
            return r4
        L48:
            Xa.k<J0.j<T>> r4 = r4.downstreamFlow
            J0.h r0 = new J0.h
            r0.<init>(r5)
            r4.setValue(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.u(e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(e9.InterfaceC4014c<? super Y8.t> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.f13355d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13355d = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f13353b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f13355d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f13352a
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.C4849c.b(r5)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L45
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            kotlin.C4849c.b(r5)
            r0.f13352a = r4     // Catch: java.lang.Throwable -> L2d
            r0.f13355d = r3     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r4 = r4.t(r0)     // Catch: java.lang.Throwable -> L2d
            if (r4 != r1) goto L4f
            return r1
        L45:
            Xa.k<J0.j<T>> r4 = r4.downstreamFlow
            J0.h r0 = new J0.h
            r0.<init>(r5)
            r4.setValue(r0)
        L4f:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.v(e9.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.SingleProcessDataStore$readData$1, e9.c] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v2, types: [J0.i, J0.i<T>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(e9.InterfaceC4014c<? super T> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.f13361f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13361f = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f13359d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f13361f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r5 = r0.f13358c
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.Object r1 = r0.f13357b
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r0 = r0.f13356a
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L35
            goto L61
        L35:
            r5 = move-exception
            goto L6c
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.C4849c.b(r6)
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L72
            java.io.File r2 = r5.q()     // Catch: java.io.FileNotFoundException -> L72
            r6.<init>(r2)     // Catch: java.io.FileNotFoundException -> L72
            J0.i<T> r2 = r5.serializer     // Catch: java.lang.Throwable -> L67
            r0.f13356a = r5     // Catch: java.lang.Throwable -> L67
            r0.f13357b = r6     // Catch: java.lang.Throwable -> L67
            r4 = 0
            r0.f13358c = r4     // Catch: java.lang.Throwable -> L67
            r0.f13361f = r3     // Catch: java.lang.Throwable -> L67
            java.lang.Object r0 = r2.a(r6, r0)     // Catch: java.lang.Throwable -> L67
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r1 = r6
            r6 = r0
            r0 = r5
            r5 = r4
        L61:
            l9.b.a(r1, r5)     // Catch: java.io.FileNotFoundException -> L65
            return r6
        L65:
            r5 = move-exception
            goto L75
        L67:
            r0 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            r1 = r6
        L6c:
            throw r5     // Catch: java.lang.Throwable -> L6d
        L6d:
            r6 = move-exception
            l9.b.a(r1, r5)     // Catch: java.io.FileNotFoundException -> L65
            throw r6     // Catch: java.io.FileNotFoundException -> L65
        L72:
            r6 = move-exception
            r0 = r5
            r5 = r6
        L75:
            java.io.File r6 = r0.q()
            boolean r6 = r6.exists()
            if (r6 != 0) goto L86
            J0.i<T> r5 = r0.serializer
            java.lang.Object r5 = r5.getDefaultValue()
            return r5
        L86:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.w(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0083 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(e9.InterfaceC4014c<? super T> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.f13366e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13366e = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f13364c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f13366e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L55
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r7 = r0.f13363b
            java.lang.Object r0 = r0.f13362a
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.C4849c.b(r8)     // Catch: java.io.IOException -> L35
            return r7
        L35:
            r7 = move-exception
            goto L88
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            java.lang.Object r7 = r0.f13363b
            androidx.datastore.core.CorruptionException r7 = (androidx.datastore.core.CorruptionException) r7
            java.lang.Object r2 = r0.f13362a
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.C4849c.b(r8)
            goto L77
        L4b:
            java.lang.Object r7 = r0.f13362a
            androidx.datastore.core.SingleProcessDataStore r7 = (androidx.datastore.core.SingleProcessDataStore) r7
            kotlin.C4849c.b(r8)     // Catch: androidx.datastore.core.CorruptionException -> L53
            return r8
        L53:
            r8 = move-exception
            goto L64
        L55:
            kotlin.C4849c.b(r8)
            r0.f13362a = r7     // Catch: androidx.datastore.core.CorruptionException -> L53
            r0.f13366e = r5     // Catch: androidx.datastore.core.CorruptionException -> L53
            java.lang.Object r7 = r7.w(r0)     // Catch: androidx.datastore.core.CorruptionException -> L53
            if (r7 != r1) goto L63
            goto L83
        L63:
            return r7
        L64:
            J0.a<T> r2 = r7.corruptionHandler
            r0.f13362a = r7
            r0.f13363b = r8
            r0.f13366e = r4
            java.lang.Object r2 = r2.a(r8, r0)
            if (r2 != r1) goto L73
            goto L83
        L73:
            r6 = r2
            r2 = r7
            r7 = r8
            r8 = r6
        L77:
            r0.f13362a = r7     // Catch: java.io.IOException -> L85
            r0.f13363b = r8     // Catch: java.io.IOException -> L85
            r0.f13366e = r3     // Catch: java.io.IOException -> L85
            java.lang.Object r7 = r2.z(r8, r0)     // Catch: java.io.IOException -> L85
            if (r7 != r1) goto L84
        L83:
            return r1
        L84:
            return r8
        L85:
            r8 = move-exception
            r0 = r7
            r7 = r8
        L88:
            Y8.d.a(r0, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.x(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(p9.p<? super T, ? super e9.InterfaceC4014c<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.d r9, e9.InterfaceC4014c<? super T> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.f13372f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13372f = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f13370d
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f13372f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L49
            if (r2 == r5) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r7 = r0.f13368b
            java.lang.Object r8 = r0.f13367a
            androidx.datastore.core.SingleProcessDataStore r8 = (androidx.datastore.core.SingleProcessDataStore) r8
            kotlin.C4849c.b(r10)
            goto L8f
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            java.lang.Object r7 = r0.f13369c
            java.lang.Object r8 = r0.f13368b
            J0.b r8 = (J0.b) r8
            java.lang.Object r9 = r0.f13367a
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            kotlin.C4849c.b(r10)
            goto L74
        L49:
            kotlin.C4849c.b(r10)
            Xa.k<J0.j<T>> r10 = r7.downstreamFlow
            java.lang.Object r10 = r10.getValue()
            J0.b r10 = (J0.b) r10
            r10.a()
            java.lang.Object r2 = r10.b()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r8, r2, r3)
            r0.f13367a = r7
            r0.f13368b = r10
            r0.f13369c = r2
            r0.f13372f = r5
            java.lang.Object r8 = Ua.C1056g.j(r9, r6, r0)
            if (r8 != r1) goto L6f
            goto L8c
        L6f:
            r9 = r10
            r10 = r8
            r8 = r9
            r9 = r7
            r7 = r2
        L74:
            r8.a()
            boolean r8 = kotlin.jvm.internal.p.d(r7, r10)
            if (r8 == 0) goto L7e
            return r7
        L7e:
            r0.f13367a = r9
            r0.f13368b = r10
            r0.f13369c = r3
            r0.f13372f = r4
            java.lang.Object r7 = r9.z(r10, r0)
            if (r7 != r1) goto L8d
        L8c:
            return r1
        L8d:
            r8 = r9
            r7 = r10
        L8f:
            Xa.k<J0.j<T>> r8 = r8.downstreamFlow
            J0.b r9 = new J0.b
            if (r7 == 0) goto L9a
            int r10 = r7.hashCode()
            goto L9b
        L9a:
            r10 = 0
        L9b:
            r9.<init>(r7, r10)
            r8.setValue(r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.y(p9.p, kotlin.coroutines.d, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(T r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r0
            int r1 = r0.f13383h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13383h = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f13381f
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f13383h
            r3 = 1
            if (r2 == 0) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r7 = r0.f13380e
            java.io.FileOutputStream r7 = (java.io.FileOutputStream) r7
            java.lang.Object r8 = r0.f13379d
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object r1 = r0.f13378c
            java.io.Closeable r1 = (java.io.Closeable) r1
            java.lang.Object r2 = r0.f13377b
            java.io.File r2 = (java.io.File) r2
            java.lang.Object r0 = r0.f13376a
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L3d
            goto L89
        L3d:
            r7 = move-exception
            goto Lc2
        L40:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L48:
            kotlin.C4849c.b(r9)
            java.io.File r9 = r7.q()
            r7.p(r9)
            java.io.File r2 = new java.io.File
            java.io.File r9 = r7.q()
            java.lang.String r9 = r9.getAbsolutePath()
            java.lang.String r4 = r7.SCRATCH_SUFFIX
            java.lang.String r9 = kotlin.jvm.internal.p.r(r9, r4)
            r2.<init>(r9)
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.io.IOException -> Lbe
            r9.<init>(r2)     // Catch: java.io.IOException -> Lbe
            J0.i<T> r4 = r7.serializer     // Catch: java.lang.Throwable -> Lc0
            androidx.datastore.core.SingleProcessDataStore$c r5 = new androidx.datastore.core.SingleProcessDataStore$c     // Catch: java.lang.Throwable -> Lc0
            r5.<init>(r9)     // Catch: java.lang.Throwable -> Lc0
            r0.f13376a = r7     // Catch: java.lang.Throwable -> Lc0
            r0.f13377b = r2     // Catch: java.lang.Throwable -> Lc0
            r0.f13378c = r9     // Catch: java.lang.Throwable -> Lc0
            r6 = 0
            r0.f13379d = r6     // Catch: java.lang.Throwable -> Lc0
            r0.f13380e = r9     // Catch: java.lang.Throwable -> Lc0
            r0.f13383h = r3     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r8 = r4.b(r8, r5, r0)     // Catch: java.lang.Throwable -> Lc0
            if (r8 != r1) goto L85
            return r1
        L85:
            r0 = r7
            r7 = r9
            r1 = r7
            r8 = r6
        L89:
            java.io.FileDescriptor r7 = r7.getFD()     // Catch: java.lang.Throwable -> L3d
            r7.sync()     // Catch: java.lang.Throwable -> L3d
            Y8.t r7 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L3d
            l9.b.a(r1, r8)     // Catch: java.io.IOException -> Lbe
            java.io.File r7 = r0.q()     // Catch: java.io.IOException -> Lbe
            boolean r7 = r2.renameTo(r7)     // Catch: java.io.IOException -> Lbe
            if (r7 == 0) goto La2
            Y8.t r7 = Y8.t.f7040a
            return r7
        La2:
            java.io.IOException r7 = new java.io.IOException     // Catch: java.io.IOException -> Lbe
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lbe
            r8.<init>()     // Catch: java.io.IOException -> Lbe
            java.lang.String r9 = "Unable to rename "
            r8.append(r9)     // Catch: java.io.IOException -> Lbe
            r8.append(r2)     // Catch: java.io.IOException -> Lbe
            java.lang.String r9 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r8.append(r9)     // Catch: java.io.IOException -> Lbe
            java.lang.String r8 = r8.toString()     // Catch: java.io.IOException -> Lbe
            r7.<init>(r8)     // Catch: java.io.IOException -> Lbe
            throw r7     // Catch: java.io.IOException -> Lbe
        Lbe:
            r7 = move-exception
            goto Lc8
        Lc0:
            r7 = move-exception
            r1 = r9
        Lc2:
            throw r7     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r8 = move-exception
            l9.b.a(r1, r7)     // Catch: java.io.IOException -> Lbe
            throw r8     // Catch: java.io.IOException -> Lbe
        Lc8:
            boolean r8 = r2.exists()
            if (r8 == 0) goto Ld1
            r2.delete()
        Ld1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.z(java.lang.Object, e9.c):java.lang.Object");
    }
}
