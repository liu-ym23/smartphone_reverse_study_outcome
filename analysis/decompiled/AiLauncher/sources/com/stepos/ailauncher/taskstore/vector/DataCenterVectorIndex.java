package com.stepos.ailauncher.taskstore.vector;

import La.H;
import U6.e;
import Y8.j;
import Y8.t;
import Z8.C1165m;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.task.space.credential.P;
import com.stepos.ailauncher.taskstore.dao.InterfaceC3710a;
import com.stepos.ailauncher.taskstore.database.TaskStoreDatabase;
import com.stepos.ailauncher.taskstore.provider.c;
import com.stepos.datacenter.api.DataCenter;
import com.stepos.datacenter.core.result.DataCenterError;
import com.stepos.datacenter.core.result.DataCenterResult;
import com.stepos.datacenter.vector.CapacityPolicy;
import com.stepos.datacenter.vector.CollectionDescriptor;
import com.stepos.datacenter.vector.DistanceMetric;
import com.stepos.datacenter.vector.StorageDType;
import e7.VectorStoreConfig;
import e7.o;
import e9.InterfaceC4014c;
import f9.C4063a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001sB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\f\u0010\rJ\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0019\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001f\u001a\u00020\n*\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$H\u0082@¢\u0006\u0004\b&\u0010'J\u0018\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020(H\u0082@¢\u0006\u0004\b*\u0010+J\u0018\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020(H\u0082@¢\u0006\u0004\b-\u0010+J1\u00100\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010(2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020$H\u0002¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020(H\u0082@¢\u0006\u0004\b2\u0010\u0006J\u0010\u00103\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b3\u0010\u0006J\u0018\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u00020(H\u0082@¢\u0006\u0004\b5\u0010+J\u0017\u00107\u001a\u00020$2\u0006\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020$2\u0006\u00106\u001a\u00020\bH\u0002¢\u0006\u0004\b;\u00108J\u001f\u0010>\u001a\u00020$2\u0006\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$H\u0002¢\u0006\u0004\b>\u0010?J\u0013\u0010@\u001a\u00020\u000e*\u00020\u000eH\u0002¢\u0006\u0004\b@\u0010AJ\u001b\u0010C\u001a\u00020\n*\u00020\u000e2\u0006\u0010B\u001a\u00020\u000eH\u0002¢\u0006\u0004\bC\u0010DJ\u0015\u0010G\u001a\u00020\u00042\u0006\u0010F\u001a\u00020E¢\u0006\u0004\bG\u0010HJ\u0018\u0010J\u001a\u00020\u00042\u0006\u0010I\u001a\u00020$H\u0086@¢\u0006\u0004\bJ\u0010'J\u001e\u0010K\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0004\bK\u0010LJ\u001e\u0010M\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0004\bM\u0010LR\u0014\u0010N\u001a\u00020$8\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010P\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bP\u0010OR\u0014\u0010Q\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bQ\u0010OR\u0014\u0010R\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\bR\u0010\u0005R\u0014\u0010S\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\bS\u0010\u0005R\u0014\u0010T\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bT\u0010OR\u0014\u0010U\u001a\u00020$8\u0002X\u0082T¢\u0006\u0006\n\u0004\bU\u0010OR\u0014\u0010W\u001a\u00020V8\u0002X\u0082T¢\u0006\u0006\n\u0004\bW\u0010@R\u0014\u0010X\u001a\u00020V8\u0002X\u0082T¢\u0006\u0006\n\u0004\bX\u0010@R\u0014\u0010Y\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010\u0005R\u0014\u0010Z\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\bZ\u0010\u0005R\u0014\u0010[\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b[\u0010\u0005R\u0014\u0010]\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^R\u001a\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00010_8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010cR\u0016\u0010e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010cR\u0018\u0010f\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0014\u0010n\u001a\u00020k8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bp\u0010q¨\u0006t"}, d2 = {"Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex;", "", "<init>", "()V", "LY8/t;", "I", "(Le9/c;)Ljava/lang/Object;", "", "Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$a;", "records", "", "repairMissingVectorIndex", "B", "(Ljava/util/List;ZLe9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/taskstore/vector/a;", Const.LBS_FAIL_BD_ENTITY, "forceVectorSave", "N", "(Lcom/stepos/ailauncher/taskstore/vector/a;ZLe9/c;)Ljava/lang/Object;", "existing", "samePayload", "J", "(Lcom/stepos/ailauncher/taskstore/vector/a;Lcom/stepos/ailauncher/taskstore/vector/a;ZLe9/c;)Ljava/lang/Object;", "P", "(Lcom/stepos/ailauncher/taskstore/vector/a;Le9/c;)Ljava/lang/Object;", "H", "v", "Lcom/stepos/datacenter/vector/CollectionDescriptor;", "o", "()Lcom/stepos/datacenter/vector/CollectionDescriptor;", "Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;", "D", "(Lcom/stepos/datacenter/core/result/DataCenterResult$Failure;)Z", "descriptor", "u", "(Lcom/stepos/datacenter/vector/CollectionDescriptor;)V", "", "bizKey", "s", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "", "storedRowCount", "K", "(ILe9/c;)Ljava/lang/Object;", "vectorCount", "G", P.ENTRY_REPAIR, "strategy", ExifInterface.LONGITUDE_EAST, "(ILjava/lang/Integer;ZLjava/lang/String;)V", "r", "w", "expectedRows", "O", "record", "p", "(Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$a;)Ljava/lang/String;", "M", "(Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$a;)Lcom/stepos/ailauncher/taskstore/vector/a;", "q", "type", "id", "n", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "F", "(Lcom/stepos/ailauncher/taskstore/vector/a;)Lcom/stepos/ailauncher/taskstore/vector/a;", "other", "z", "(Lcom/stepos/ailauncher/taskstore/vector/a;Lcom/stepos/ailauncher/taskstore/vector/a;)Z", "Landroid/content/Context;", "context", "C", "(Landroid/content/Context;)V", "taskId", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "L", "TYPE_TASK", "Ljava/lang/String;", "TAG", "LEGACY_SESSION_MESSAGE_TYPE", "DEFAULT_VECTOR_DIMENSION", "SEARCH_TEXT_VERSION", "VECTOR_COLLECTION", "VECTOR_EMBEDDING_MODEL", "", "MIN_COSINE_SIMILARITY", "STRICT_MIN_COSINE_SIMILARITY", "SMALL_CORPUS_THRESHOLD", "MAX_DEBUG_MATCH_RECORDS", "DEBUG_MATCH_CANDIDATE_LIMIT", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "LZ8/m;", "debugMatchRecords", "LZ8/m;", "initialized", "Z", "collectionEnsured", "vectorBackendAwaited", "minSimilarityOverride", "Ljava/lang/Float;", "Lcom/stepos/ailauncher/taskstore/dao/a;", "launcherVectorDao", "Lcom/stepos/ailauncher/taskstore/dao/a;", "Lcom/stepos/datacenter/api/DataCenter;", "x", "()Lcom/stepos/datacenter/api/DataCenter;", "dataCenter", "Lcom/stepos/datacenter/api/e;", "y", "()Lcom/stepos/datacenter/api/e;", "vectors", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCenterVectorIndex {
    private static final int DEBUG_MATCH_CANDIDATE_LIMIT = 5;
    private static final int DEFAULT_VECTOR_DIMENSION = 512;
    private static final String LEGACY_SESSION_MESSAGE_TYPE = "session_message";
    private static final int MAX_DEBUG_MATCH_RECORDS = 20;
    private static final float MIN_COSINE_SIMILARITY = 0.4f;
    private static final int SEARCH_TEXT_VERSION = 3;
    private static final int SMALL_CORPUS_THRESHOLD = 5;
    private static final float STRICT_MIN_COSINE_SIMILARITY = 0.62f;
    private static final String TAG = "DataCenterVectorIndex";
    public static final String TYPE_TASK = "task";
    private static final String VECTOR_COLLECTION = "task_store_memory_v2";
    private static final String VECTOR_EMBEDDING_MODEL = "bge-small-zh@v1";
    private static volatile boolean collectionEnsured;
    private static volatile boolean initialized;
    private static InterfaceC3710a launcherVectorDao;
    private static volatile Float minSimilarityOverride;
    private static volatile boolean vectorBackendAwaited;
    public static final DataCenterVectorIndex INSTANCE = new DataCenterVectorIndex();
    private static final Gson gson = new Gson();
    private static final C1165m<Object> debugMatchRecords = new C1165m<>();

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\u0019R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b\"\u0010\u0019R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b&\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b'\u0010\u0019R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b+\u0010\u0019R\u0017\u0010\f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b,\u0010\u0019R\u0017\u0010\r\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b-\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b.\u0010\u0019R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b/\u0010\u0019R\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b0\u0010\u0019R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b1\u0010\u0019R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u00102\u001a\u0004\b3\u00104R\u0017\u0010\u0014\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0014\u00102\u001a\u0004\b5\u00104R\u0017\u0010\u0015\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b6\u0010\u0019¨\u00067"}, d2 = {"Lcom/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$a;", "", "", "taskId", "parentTaskId", "", "subTaskIds", "eventType", "type", "", "version", "title", "subTitle", c.a.COL_SUMMARY, "intention", "status", "statusText", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "", "createTime", "updateTime", "searchableContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "l", Const.INTENT_KEY_UMID, "Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "n", "Ljava/lang/Integer;", "p", "()Ljava/lang/Integer;", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "k", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "J", Const.INTENT_KEY_APIKEY, "()J", "o", "e", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$a, reason: from toString */
    public static final /* data */ class TaskVectorRecord {
        private final long createTime;
        private final String eventType;
        private final String intention;
        private final String parentTaskId;
        private final String searchableContent;
        private final String sessionKey;
        private final String status;
        private final String statusText;
        private final List<String> subTaskIds;
        private final String subTitle;
        private final String summary;
        private final String taskId;
        private final String title;
        private final String type;
        private final long updateTime;
        private final Integer version;

        public TaskVectorRecord(String taskId, String str, List<String> subTaskIds, String eventType, String type, Integer num, String title, String subTitle, String summary, String intention, String status, String statusText, String str2, long j10, long j11, String searchableContent) {
            p.i(taskId, "taskId");
            p.i(subTaskIds, "subTaskIds");
            p.i(eventType, "eventType");
            p.i(type, "type");
            p.i(title, "title");
            p.i(subTitle, "subTitle");
            p.i(summary, "summary");
            p.i(intention, "intention");
            p.i(status, "status");
            p.i(statusText, "statusText");
            p.i(searchableContent, "searchableContent");
            this.taskId = taskId;
            this.parentTaskId = str;
            this.subTaskIds = subTaskIds;
            this.eventType = eventType;
            this.type = type;
            this.version = num;
            this.title = title;
            this.subTitle = subTitle;
            this.summary = summary;
            this.intention = intention;
            this.status = status;
            this.statusText = statusText;
            this.sessionKey = str2;
            this.createTime = j10;
            this.updateTime = j11;
            this.searchableContent = searchableContent;
        }

        /* renamed from: a, reason: from getter */
        public final long getCreateTime() {
            return this.createTime;
        }

        /* renamed from: b, reason: from getter */
        public final String getEventType() {
            return this.eventType;
        }

        /* renamed from: c, reason: from getter */
        public final String getIntention() {
            return this.intention;
        }

        /* renamed from: d, reason: from getter */
        public final String getParentTaskId() {
            return this.parentTaskId;
        }

        /* renamed from: e, reason: from getter */
        public final String getSearchableContent() {
            return this.searchableContent;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TaskVectorRecord)) {
                return false;
            }
            TaskVectorRecord taskVectorRecord = (TaskVectorRecord) other;
            return p.d(this.taskId, taskVectorRecord.taskId) && p.d(this.parentTaskId, taskVectorRecord.parentTaskId) && p.d(this.subTaskIds, taskVectorRecord.subTaskIds) && p.d(this.eventType, taskVectorRecord.eventType) && p.d(this.type, taskVectorRecord.type) && p.d(this.version, taskVectorRecord.version) && p.d(this.title, taskVectorRecord.title) && p.d(this.subTitle, taskVectorRecord.subTitle) && p.d(this.summary, taskVectorRecord.summary) && p.d(this.intention, taskVectorRecord.intention) && p.d(this.status, taskVectorRecord.status) && p.d(this.statusText, taskVectorRecord.statusText) && p.d(this.sessionKey, taskVectorRecord.sessionKey) && this.createTime == taskVectorRecord.createTime && this.updateTime == taskVectorRecord.updateTime && p.d(this.searchableContent, taskVectorRecord.searchableContent);
        }

        /* renamed from: f, reason: from getter */
        public final String getSessionKey() {
            return this.sessionKey;
        }

        /* renamed from: g, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        /* renamed from: h, reason: from getter */
        public final String getStatusText() {
            return this.statusText;
        }

        public int hashCode() {
            int iHashCode = this.taskId.hashCode() * 31;
            String str = this.parentTaskId;
            int iHashCode2 = (((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.subTaskIds.hashCode()) * 31) + this.eventType.hashCode()) * 31) + this.type.hashCode()) * 31;
            Integer num = this.version;
            int iHashCode3 = (((((((((((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.intention.hashCode()) * 31) + this.status.hashCode()) * 31) + this.statusText.hashCode()) * 31;
            String str2 = this.sessionKey;
            return ((((((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.updateTime)) * 31) + this.searchableContent.hashCode();
        }

        public final List<String> i() {
            return this.subTaskIds;
        }

        /* renamed from: j, reason: from getter */
        public final String getSubTitle() {
            return this.subTitle;
        }

        /* renamed from: k, reason: from getter */
        public final String getSummary() {
            return this.summary;
        }

        /* renamed from: l, reason: from getter */
        public final String getTaskId() {
            return this.taskId;
        }

        /* renamed from: m, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* renamed from: n, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* renamed from: o, reason: from getter */
        public final long getUpdateTime() {
            return this.updateTime;
        }

        /* renamed from: p, reason: from getter */
        public final Integer getVersion() {
            return this.version;
        }

        public String toString() {
            return "TaskVectorRecord(taskId=" + this.taskId + ", parentTaskId=" + this.parentTaskId + ", subTaskIds=" + this.subTaskIds + ", eventType=" + this.eventType + ", type=" + this.type + ", version=" + this.version + ", title=" + this.title + ", subTitle=" + this.subTitle + ", summary=" + this.summary + ", intention=" + this.intention + ", status=" + this.status + ", statusText=" + this.statusText + ", sessionKey=" + this.sessionKey + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ", searchableContent=" + this.searchableContent + ")";
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\b\u0010\u0006J\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\t\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\nH\u0096@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"com/stepos/ailauncher/taskstore/vector/DataCenterVectorIndex$b", "LU6/e$a;", "Lcom/stepos/ailauncher/taskstore/vector/a;", Const.LBS_FAIL_BD_ENTITY, "", "f", "(Lcom/stepos/ailauncher/taskstore/vector/a;Le9/c;)Ljava/lang/Object;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "", "ids", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Le9/c;)Ljava/lang/Object;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements e.a<LauncherVectorEntity> {
        final /* synthetic */ InterfaceC3710a $dao;

        public b(InterfaceC3710a interfaceC3710a) {
            this.$dao = interfaceC3710a;
        }

        @Override // U6.e.a
        public Object b(List<Long> list, InterfaceC4014c<? super List<? extends LauncherVectorEntity>> interfaceC4014c) {
            return this.$dao.b(list, interfaceC4014c);
        }

        @Override // U6.e.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Object a(LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objD = this.$dao.d(launcherVectorEntity, interfaceC4014c);
            return objD == C4063a.g() ? objD : t.f7040a;
        }

        @Override // U6.e.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object c(LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super Long> interfaceC4014c) {
            return this.$dao.c(launcherVectorEntity, interfaceC4014c);
        }

        @Override // U6.e.a
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object d(LauncherVectorEntity launcherVectorEntity, InterfaceC4014c<? super t> interfaceC4014c) {
            Object objC = this.$dao.c(launcherVectorEntity, interfaceC4014c);
            return objC == C4063a.g() ? objC : t.f7040a;
        }
    }

    public final Object A(List<TaskVectorRecord> list, InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        Object objB = B(list, false, interfaceC4014c);
        return objB == C4063a.g() ? objB : t.f7040a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x02cf, code lost:
    
        if (O(r2, r3) == r4) goto L93;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:59:0x01d9, B:63:0x01e0], limit reached: 98 */
    /* JADX WARN: Path cross not found for [B:79:0x025a, B:83:0x0261], limit reached: 98 */
    /* JADX WARN: Removed duplicated region for block: B:53:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02d5  */
    /* JADX WARN: Type inference failed for: r16v0, types: [com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex] */
    /* JADX WARN: Type inference failed for: r6v26, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01cd -> B:57:0x01d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x024a -> B:77:0x0252). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.util.List<com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.TaskVectorRecord> r17, boolean r18, e9.InterfaceC4014c<? super Y8.t> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 728
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.B(java.util.List, boolean, e9.c):java.lang.Object");
    }

    public final void C(Context context) {
        Object objB;
        p.i(context, "context");
        if (initialized) {
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TaskStoreDatabase.Companion lVar = TaskStoreDatabase.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            p.h(applicationContext, "getApplicationContext(...)");
            InterfaceC3710a interfaceC3710aL0 = lVar.b(applicationContext).l0();
            DataCenter.Companion companion2 = DataCenter.INSTANCE;
            Context applicationContext2 = context.getApplicationContext();
            p.h(applicationContext2, "getApplicationContext(...)");
            companion2.init(applicationContext2, new VectorStoreConfig(512, 0, 2, null));
            companion2.getInstance().bindEntities(j.a(kotlin.jvm.internal.t.b(LauncherVectorEntity.class), new b(interfaceC3710aL0)));
            launcherVectorDao = interfaceC3710aL0;
            initialized = true;
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            Log.w(TAG, "DataCenter init failed: " + thE.getMessage(), thE);
        }
    }

    public final boolean D(DataCenterResult.Failure failure) {
        if (failure.getError() == DataCenterError.ALREADY_EXISTS) {
            return true;
        }
        String message = failure.getMessage();
        Throwable cause = failure.getCause();
        String strA0 = F.A0(C1173v.r(message, cause != null ? cause.getMessage() : null), " ", null, null, 0, null, null, 62, null);
        Locale ROOT = Locale.ROOT;
        p.h(ROOT, "ROOT");
        String lowerCase = strA0.toLowerCase(ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return H.g0(lowerCase, "already_exists", false, 2, null) || H.g0(lowerCase, "already exists", false, 2, null) || H.g0(lowerCase, "已存在", false, 2, null);
    }

    public final void E(int storedRowCount, Integer vectorCount, boolean repair, String strategy) {
        Object obj = vectorCount;
        if (vectorCount == null) {
            obj = "unknown";
        }
        Log.i(TAG, "Startup vector sync decision: collection=task_store_memory_v2, storedRows=" + storedRowCount + ", vectorCount=" + obj + ", repair=" + repair + ", strategy=" + strategy);
    }

    public final LauncherVectorEntity F(LauncherVectorEntity launcherVectorEntity) {
        return p.d(launcherVectorEntity.getEntityClassName(), "LauncherVectorEntity") ? launcherVectorEntity : LauncherVectorEntity.b(launcherVectorEntity, 0L, null, null, "LauncherVectorEntity", null, null, null, null, 0L, 503, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object G(int r7, e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareCollectionReplay$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareCollectionReplay$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareCollectionReplay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareCollectionReplay$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareCollectionReplay$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            java.lang.String r4 = "DataCenterVectorIndex"
            r5 = 1
            if (r2 == 0) goto L40
            if (r2 == r5) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$0
            com.stepos.datacenter.core.result.DataCenterResult r6 = (com.stepos.datacenter.core.result.DataCenterResult) r6
            kotlin.C4849c.b(r8)
            return r8
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            int r7 = r0.I$0
            kotlin.C4849c.b(r8)
            goto L84
        L40:
            kotlin.C4849c.b(r8)
            if (r7 > 0) goto L5e
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "Startup vector sync replay without reset: collection=task_store_memory_v2, vectors="
            r6.append(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            android.util.Log.i(r4, r6)
            java.lang.Boolean r6 = g9.C4109a.a(r5)
            return r6
        L5e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "Startup vector sync reset collection before replay: collection=task_store_memory_v2, vectors="
            r8.append(r2)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            android.util.Log.i(r4, r8)
            com.stepos.datacenter.api.e r8 = r6.y()
            r0.I$0 = r7
            r0.label = r5
            java.lang.String r2 = "task_store_memory_v2"
            java.lang.Object r8 = r8.b(r2, r0)
            if (r8 != r1) goto L84
            goto L9d
        L84:
            com.stepos.datacenter.core.result.DataCenterResult r8 = (com.stepos.datacenter.core.result.DataCenterResult) r8
            boolean r2 = r8 instanceof com.stepos.datacenter.core.result.DataCenterResult.Success
            r5 = 0
            if (r2 == 0) goto L9f
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.collectionEnsured = r5
            java.lang.Object r8 = g9.h.a(r8)
            r0.L$0 = r8
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.v(r0)
            if (r6 != r1) goto L9e
        L9d:
            return r1
        L9e:
            return r6
        L9f:
            boolean r6 = r8 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure
            if (r6 == 0) goto Lce
            com.stepos.datacenter.core.result.DataCenterResult$Failure r8 = (com.stepos.datacenter.core.result.DataCenterResult.Failure) r8
            com.stepos.datacenter.core.result.DataCenterError r6 = r8.getError()
            java.lang.String r7 = r8.getMessage()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Drop vector collection before replay failed: "
            r8.append(r0)
            r8.append(r6)
            java.lang.String r6 = " "
            r8.append(r6)
            r8.append(r7)
            java.lang.String r6 = r8.toString()
            android.util.Log.w(r4, r6)
            java.lang.Boolean r6 = g9.C4109a.a(r5)
            return r6
        Lce:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.G(int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r8 == r1) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object H(e9.InterfaceC4014c<? super java.lang.Boolean> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareVectorWrite$1
            if (r0 == 0) goto L13
            r0 = r8
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareVectorWrite$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareVectorWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareVectorWrite$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$prepareVectorWrite$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.C4849c.b(r8)
            return r8
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            kotlin.C4849c.b(r8)
            goto L4c
        L38:
            kotlin.C4849c.b(r8)
            boolean r8 = com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.vectorBackendAwaited
            if (r8 != 0) goto L63
            com.stepos.datacenter.api.DataCenter$Companion r8 = com.stepos.datacenter.api.DataCenter.INSTANCE
            r0.label = r4
            r5 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r8 = r8.awaitVectorBackendReady(r5, r0)
            if (r8 != r1) goto L4c
            goto L6b
        L4c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L61
            java.lang.String r7 = "DataCenterVectorIndex"
            java.lang.String r8 = "Vector backend is not ready; skip vector write"
            android.util.Log.w(r7, r8)
            r7 = 0
            java.lang.Boolean r7 = g9.C4109a.a(r7)
            return r7
        L61:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.vectorBackendAwaited = r4
        L63:
            r0.label = r3
            java.lang.Object r7 = r7.v(r0)
            if (r7 != r1) goto L6c
        L6b:
            return r1
        L6c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.H(e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
    
        if (r1 == r3) goto L54;
     */
    /* JADX WARN: Path cross not found for [B:44:0x00eb, B:48:0x00f2], limit reached: 56 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00e0 -> B:42:0x00e3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object I(e9.InterfaceC4014c<? super Y8.t> r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.I(e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x01cd, code lost:
    
        if (r8.c(r5, r3) == r4) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity r28, com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity r29, boolean r30, e9.InterfaceC4014c<? super java.lang.Boolean> r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.J(com.stepos.ailauncher.taskstore.vector.a, com.stepos.ailauncher.taskstore.vector.a, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object K(int r9, e9.InterfaceC4014c<? super java.lang.Boolean> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$shouldReplayStoredRows$1
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$shouldReplayStoredRows$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$shouldReplayStoredRows$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$shouldReplayStoredRows$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$shouldReplayStoredRows$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L45
            if (r2 == r6) goto L3f
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            kotlin.C4849c.b(r10)
            return r10
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            int r9 = r0.I$0
            kotlin.C4849c.b(r10)
            goto L7c
        L3f:
            int r9 = r0.I$0
            kotlin.C4849c.b(r10)
            goto L5f
        L45:
            kotlin.C4849c.b(r10)
            if (r9 > 0) goto L54
            java.lang.String r10 = "SKIP_NO_INDEXABLE_ROWS"
            r8.E(r9, r5, r7, r10)
            java.lang.Boolean r8 = g9.C4109a.a(r7)
            return r8
        L54:
            r0.I$0 = r9
            r0.label = r6
            java.lang.Object r10 = r8.H(r0)
            if (r10 != r1) goto L5f
            goto La0
        L5f:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L71
            java.lang.String r10 = "SKIP_BACKEND_NOT_READY"
            r8.E(r9, r5, r7, r10)
            java.lang.Boolean r8 = g9.C4109a.a(r7)
            return r8
        L71:
            r0.I$0 = r9
            r0.label = r4
            java.lang.Object r10 = r8.r(r0)
            if (r10 != r1) goto L7c
            goto La0
        L7c:
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r10 < 0) goto La2
            if (r10 >= r9) goto La2
            java.lang.Integer r2 = g9.C4109a.f(r10)
            if (r10 != 0) goto L8f
            java.lang.String r4 = "REPLAY_EMPTY_COLLECTION"
            goto L91
        L8f:
            java.lang.String r4 = "RESET_AND_REPLAY"
        L91:
            r8.E(r9, r2, r6, r4)
            r0.I$0 = r9
            r0.I$1 = r10
            r0.label = r3
            java.lang.Object r8 = r8.G(r10, r0)
            if (r8 != r1) goto La1
        La0:
            return r1
        La1:
            return r8
        La2:
            if (r10 >= 0) goto Lb5
            java.lang.String r10 = "SKIP_HEALTH_UNAVAILABLE"
            r8.E(r9, r5, r7, r10)
            java.lang.String r8 = "DataCenterVectorIndex"
            java.lang.String r9 = "Vector collection health unavailable; skip forced replay"
            int r8 = android.util.Log.w(r8, r9)
            g9.C4109a.f(r8)
            goto Lc3
        Lb5:
            java.lang.Integer r0 = g9.C4109a.f(r10)
            if (r10 != r9) goto Lbe
            java.lang.String r10 = "SKIP_HEALTHY"
            goto Lc0
        Lbe:
            java.lang.String r10 = "SKIP_VECTOR_COUNT_AHEAD"
        Lc0:
            r8.E(r9, r0, r7, r10)
        Lc3:
            java.lang.Boolean r8 = g9.C4109a.a(r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.K(int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
    
        if (B(r6, true, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object L(java.util.List<com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.TaskVectorRecord> r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$syncStoredTaskRecords$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$syncStoredTaskRecords$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$syncStoredTaskRecords$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$syncStoredTaskRecords$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$syncStoredTaskRecords$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            java.util.List r5 = (java.util.List) r5
            kotlin.C4849c.b(r7)
            goto L5d
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.C4849c.b(r7)
            goto L4e
        L40:
            kotlin.C4849c.b(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r5.I(r0)
            if (r7 != r1) goto L4e
            goto L5c
        L4e:
            java.lang.Object r7 = g9.h.a(r6)
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r5 = r5.B(r6, r4, r0)
            if (r5 != r1) goto L5d
        L5c:
            return r1
        L5d:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.L(java.util.List, e9.c):java.lang.Object");
    }

    public final LauncherVectorEntity M(TaskVectorRecord taskVectorRecord) {
        long jLongValue;
        String strP = p(taskVectorRecord);
        if (H.x0(strP)) {
            return null;
        }
        String strN = n("task", taskVectorRecord.getTaskId());
        String taskId = taskVectorRecord.getTaskId();
        String title = taskVectorRecord.getTitle();
        String strQ = q(taskVectorRecord);
        Long lValueOf = Long.valueOf(taskVectorRecord.getUpdateTime());
        if (lValueOf.longValue() <= 0) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            jLongValue = lValueOf.longValue();
        } else {
            Long lValueOf2 = Long.valueOf(taskVectorRecord.getCreateTime());
            Long l10 = lValueOf2.longValue() > 0 ? lValueOf2 : null;
            jLongValue = l10 != null ? l10.longValue() : System.currentTimeMillis();
        }
        return new LauncherVectorEntity(0L, strN, "task", null, taskId, title, strP, strQ, jLongValue, 9, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0112, code lost:
    
        if (r1 != r3) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf A[Catch: all -> 0x0045, TryCatch #0 {all -> 0x0045, blocks: (B:14:0x0040, B:59:0x0115, B:21:0x005a, B:40:0x00b5, B:43:0x00bf, B:47:0x00dd, B:54:0x00eb, B:56:0x00f0, B:24:0x0064, B:30:0x0082, B:32:0x008a, B:34:0x008f, B:36:0x0097, B:27:0x0072), top: B:64:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object N(com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity r26, boolean r27, e9.InterfaceC4014c<? super java.lang.Boolean> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.N(com.stepos.ailauncher.taskstore.vector.a, boolean, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object O(int r5, e9.InterfaceC4014c<? super Y8.t> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$verifyVectorReplay$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$verifyVectorReplay$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$verifyVectorReplay$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$verifyVectorReplay$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$verifyVectorReplay$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r5 = r0.I$0
            kotlin.C4849c.b(r6)
            goto L41
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.C4849c.b(r6)
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.r(r0)
            if (r6 != r1) goto L41
            return r1
        L41:
            java.lang.Number r6 = (java.lang.Number) r6
            int r4 = r6.intValue()
            if (r4 < 0) goto L69
            if (r4 >= r5) goto L69
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Vector collection replay incomplete: collection=task_store_memory_v2, vectors="
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ", storedRows="
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
            java.lang.String r5 = "DataCenterVectorIndex"
            android.util.Log.w(r5, r4)
        L69:
            Y8.t r4 = Y8.t.f7040a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.O(int, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object P(com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity r8, e9.InterfaceC4014c<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$writeVectorIndex$1
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$writeVectorIndex$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$writeVectorIndex$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$writeVectorIndex$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$writeVectorIndex$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 != r4) goto L35
            java.lang.Object r7 = r0.L$1
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex r7 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex) r7
            java.lang.Object r7 = r0.L$0
            r8 = r7
            com.stepos.ailauncher.taskstore.vector.a r8 = (com.stepos.ailauncher.taskstore.vector.LauncherVectorEntity) r8
            kotlin.C4849c.b(r9)     // Catch: java.lang.Throwable -> L33
            goto L5b
        L33:
            r7 = move-exception
            goto L6a
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3d:
            kotlin.C4849c.b(r9)
            kotlin.Result$a r9 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L33
            com.stepos.datacenter.api.DataCenter$Companion r9 = com.stepos.datacenter.api.DataCenter.INSTANCE     // Catch: java.lang.Throwable -> L33
            com.stepos.datacenter.api.DataCenter r9 = r9.getInstance()     // Catch: java.lang.Throwable -> L33
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L33
            java.lang.Object r7 = g9.h.a(r7)     // Catch: java.lang.Throwable -> L33
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L33
            r0.I$0 = r3     // Catch: java.lang.Throwable -> L33
            r0.label = r4     // Catch: java.lang.Throwable -> L33
            java.lang.Object r9 = r9.save(r8, r0)     // Catch: java.lang.Throwable -> L33
            if (r9 != r1) goto L5b
            return r1
        L5b:
            java.lang.Number r9 = (java.lang.Number) r9     // Catch: java.lang.Throwable -> L33
            long r0 = r9.longValue()     // Catch: java.lang.Throwable -> L33
            java.lang.Long r7 = g9.C4109a.g(r0)     // Catch: java.lang.Throwable -> L33
            java.lang.Object r7 = kotlin.Result.b(r7)     // Catch: java.lang.Throwable -> L33
            goto L74
        L6a:
            kotlin.Result$a r9 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L74:
            java.lang.Throwable r9 = kotlin.Result.e(r7)
            java.lang.String r0 = "DataCenterVectorIndex"
            if (r9 == 0) goto La0
            java.lang.String r1 = r8.getBizKey()
            java.lang.String r2 = r9.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Vector index write threw for "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = ": "
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = r5.toString()
            android.util.Log.w(r0, r1, r9)
        La0:
            r1 = -1
            java.lang.Long r9 = g9.C4109a.g(r1)
            boolean r1 = kotlin.Result.g(r7)
            if (r1 == 0) goto Lad
            r7 = r9
        Lad:
            java.lang.Number r7 = (java.lang.Number) r7
            long r1 = r7.longValue()
            r5 = 0
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 < 0) goto Lba
            goto Lbb
        Lba:
            r4 = r3
        Lbb:
            if (r4 != 0) goto Ldc
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.vectorBackendAwaited = r3
            java.lang.String r7 = r8.getBizKey()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Vector index write failed for "
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = "; keep row retryable"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            android.util.Log.w(r0, r7)
        Ldc:
            java.lang.Boolean r7 = g9.C4109a.a(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.P(com.stepos.ailauncher.taskstore.vector.a, e9.c):java.lang.Object");
    }

    public final String n(String type, String id) {
        return type + ServerSentEventKt.COLON + id;
    }

    public final CollectionDescriptor o() {
        return new CollectionDescriptor(VECTOR_COLLECTION, 512, 0, DistanceMetric.COSINE, (StorageDType) null, VECTOR_EMBEDDING_MODEL, true, 0L, 0, (String) null, (List) null, 0, (Map) null, (CapacityPolicy) null, 16276, (i) null);
    }

    public final String p(TaskVectorRecord record) {
        String title = record.getTitle();
        if (H.x0(title)) {
            title = null;
        }
        String str = title != null ? "任务标题：" + title : null;
        String subTitle = record.getSubTitle();
        if (H.x0(subTitle)) {
            subTitle = null;
        }
        String str2 = subTitle != null ? "任务副标题：" + subTitle : null;
        String summary = record.getSummary();
        if (H.x0(summary)) {
            summary = null;
        }
        String str3 = summary != null ? "任务摘要：" + summary : null;
        String intention = record.getIntention();
        if (H.x0(intention)) {
            intention = null;
        }
        String str4 = intention != null ? "任务意图：" + intention : null;
        String statusText = record.getStatusText();
        if (H.x0(statusText)) {
            statusText = null;
        }
        String str5 = statusText != null ? "任务状态：" + statusText : null;
        String searchableContent = record.getSearchableContent();
        List listR = C1173v.r(str, str2, str3, str4, str5, !H.x0(searchableContent) ? searchableContent : null);
        ArrayList arrayList = new ArrayList(C1174w.x(listR, 10));
        Iterator it = listR.iterator();
        while (it.hasNext()) {
            arrayList.add(H.D1((String) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!H.x0((String) obj)) {
                arrayList2.add(obj);
            }
        }
        return F.A0(arrayList2, "\n", null, null, 0, null, null, 62, null);
    }

    public final String q(TaskVectorRecord record) {
        String json = gson.toJson(kotlin.collections.a.m(j.a("taskId", record.getTaskId()), j.a("parentTaskId", record.getParentTaskId()), j.a("subTaskIds", record.i()), j.a("eventType", record.getEventType()), j.a("type", record.getType()), j.a("version", record.getVersion()), j.a("status", record.getStatus()), j.a("statusText", record.getStatusText()), j.a(SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, record.getSessionKey()), j.a("createTime", Long.valueOf(record.getCreateTime())), j.a("updateTime", Long.valueOf(record.getUpdateTime())), j.a("searchTextVersion", 3), j.a("source", c.a.TABLE)));
        p.h(json, "toJson(...)");
        return json;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object r(e9.InterfaceC4014c<? super java.lang.Integer> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$collectionVectorCount$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$collectionVectorCount$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$collectionVectorCount$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$collectionVectorCount$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$collectionVectorCount$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = -1
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 != r4) goto L30
            java.lang.Object r5 = r0.L$0
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex r5 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex) r5
            kotlin.C4849c.b(r6)     // Catch: java.lang.Throwable -> L2e
            goto L53
        L2e:
            r5 = move-exception
            goto L73
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            kotlin.C4849c.b(r6)
            kotlin.Result$a r6 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2e
            com.stepos.datacenter.api.e r6 = r5.y()     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = g9.h.a(r5)     // Catch: java.lang.Throwable -> L2e
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L2e
            r5 = 0
            r0.I$0 = r5     // Catch: java.lang.Throwable -> L2e
            r0.label = r4     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r6 = r6.e(r0)     // Catch: java.lang.Throwable -> L2e
            if (r6 != r1) goto L53
            return r1
        L53:
            com.stepos.datacenter.vector.CollectionHealthReport r6 = (com.stepos.datacenter.vector.CollectionHealthReport) r6     // Catch: java.lang.Throwable -> L2e
            java.util.Map r5 = r6.getByCollection()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r6 = "task_store_memory_v2"
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> L2e
            com.stepos.datacenter.vector.CollectionHealth r5 = (com.stepos.datacenter.vector.CollectionHealth) r5     // Catch: java.lang.Throwable -> L2e
            if (r5 == 0) goto L69
            int r5 = r5.getVectorCount()     // Catch: java.lang.Throwable -> L2e
            goto L6a
        L69:
            r5 = r3
        L6a:
            java.lang.Integer r5 = g9.C4109a.f(r5)     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L2e
            goto L7d
        L73:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L7d:
            java.lang.Throwable r6 = kotlin.Result.e(r5)
            if (r6 == 0) goto L9d
            java.lang.String r0 = r6.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Scan vector collection health failed: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "DataCenterVectorIndex"
            android.util.Log.w(r1, r0, r6)
        L9d:
            java.lang.Integer r6 = g9.C4109a.f(r3)
            boolean r0 = kotlin.Result.g(r5)
            if (r0 == 0) goto La8
            r5 = r6
        La8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.r(e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00d5, code lost:
    
        if (r11.remove(r9, r0) == r1) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:15:0x0037, B:22:0x004f, B:50:0x00b8, B:25:0x005c, B:43:0x0097, B:45:0x009f, B:47:0x00a3, B:52:0x00bd, B:28:0x0064, B:36:0x007e, B:56:0x00da, B:39:0x0083, B:31:0x006b, B:33:0x006f), top: B:61:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:15:0x0037, B:22:0x004f, B:50:0x00b8, B:25:0x005c, B:43:0x0097, B:45:0x009f, B:47:0x00a3, B:52:0x00bd, B:28:0x0064, B:36:0x007e, B:56:0x00da, B:39:0x0083, B:31:0x006b, B:33:0x006f), top: B:61:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.String r10, e9.InterfaceC4014c<? super java.lang.Boolean> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.s(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0078, code lost:
    
        if (w(r0) == r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(java.lang.String r6, e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$deleteTask$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$deleteTask$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$deleteTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$deleteTask$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$deleteTask$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.C4849c.b(r7)
            goto L7b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.C4849c.b(r7)
            goto L64
        L40:
            kotlin.C4849c.b(r7)
            boolean r7 = com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.initialized
            if (r7 == 0) goto L81
            boolean r7 = La.H.x0(r6)
            if (r7 == 0) goto L4e
            goto L81
        L4e:
            java.lang.String r7 = "task"
            java.lang.String r7 = r5.n(r7, r6)
            java.lang.Object r2 = g9.h.a(r6)
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r5.s(r7, r0)
            if (r7 != r1) goto L64
            goto L7a
        L64:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L7e
            java.lang.Object r6 = g9.h.a(r6)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r5 = r5.w(r0)
            if (r5 != r1) goto L7b
        L7a:
            return r1
        L7b:
            Y8.t r5 = Y8.t.f7040a
            return r5
        L7e:
            Y8.t r5 = Y8.t.f7040a
            return r5
        L81:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.t(java.lang.String, e9.c):java.lang.Object");
    }

    public final void u(CollectionDescriptor descriptor) {
        o oVarD = y().d();
        if (oVarD != null && oVarD.e(descriptor.getId()) == null) {
            DataCenterResult<CollectionDescriptor> dataCenterResultL = oVarD.l(descriptor);
            if (dataCenterResultL instanceof DataCenterResult.Success) {
                return;
            }
            if (!(dataCenterResultL instanceof DataCenterResult.Failure)) {
                throw new NoWhenBranchMatchedException();
            }
            DataCenterResult.Failure failure = (DataCenterResult.Failure) dataCenterResultL;
            if (failure.getError() != DataCenterError.ALREADY_EXISTS) {
                Log.w(TAG, "Register existing vector collection failed: " + failure.getError() + " " + failure.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$ensureVectorCollection$1
            if (r0 == 0) goto L13
            r0 = r6
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$ensureVectorCollection$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$ensureVectorCollection$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$ensureVectorCollection$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$ensureVectorCollection$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.stepos.datacenter.vector.CollectionDescriptor r0 = (com.stepos.datacenter.vector.CollectionDescriptor) r0
            kotlin.C4849c.b(r6)
            goto L57
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.C4849c.b(r6)
            boolean r6 = com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.collectionEnsured
            if (r6 == 0) goto L41
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        L41:
            com.stepos.datacenter.vector.CollectionDescriptor r6 = r5.o()
            com.stepos.datacenter.api.e r2 = r5.y()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r0 = r2.a(r6, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r4 = r0
            r0 = r6
            r6 = r4
        L57:
            com.stepos.datacenter.core.result.DataCenterResult r6 = (com.stepos.datacenter.core.result.DataCenterResult) r6
            boolean r1 = r6 instanceof com.stepos.datacenter.core.result.DataCenterResult.Success
            if (r1 == 0) goto L60
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.collectionEnsured = r3
            goto L99
        L60:
            boolean r1 = r6 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure
            if (r1 == 0) goto L9e
            com.stepos.datacenter.core.result.DataCenterResult$Failure r6 = (com.stepos.datacenter.core.result.DataCenterResult.Failure) r6
            boolean r1 = r5.D(r6)
            if (r1 == 0) goto L72
            r5.u(r0)
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.collectionEnsured = r3
            goto L99
        L72:
            com.stepos.datacenter.core.result.DataCenterError r5 = r6.getError()
            java.lang.String r6 = r6.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Create vector collection failed: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = " "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = r0.toString()
            java.lang.String r6 = "DataCenterVectorIndex"
            android.util.Log.w(r6, r5)
            r3 = 0
        L99:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        L9e:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.v(e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(e9.InterfaceC4014c<? super Y8.t> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$flushVectorCollections$1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$flushVectorCollections$1 r0 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$flushVectorCollections$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$flushVectorCollections$1 r0 = new com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex$flushVectorCollections$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.label
            java.lang.String r3 = "Flush vector collections failed: "
            java.lang.String r4 = "DataCenterVectorIndex"
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 != r5) goto L33
            java.lang.Object r6 = r0.L$0
            com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex r6 = (com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex) r6
            kotlin.C4849c.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L56
        L31:
            r6 = move-exception
            goto L9a
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.C4849c.b(r7)
            kotlin.Result$a r7 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L31
            com.stepos.datacenter.api.e r7 = r6.y()     // Catch: java.lang.Throwable -> L31
            java.lang.Object r6 = g9.h.a(r6)     // Catch: java.lang.Throwable -> L31
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L31
            r6 = 0
            r0.I$0 = r6     // Catch: java.lang.Throwable -> L31
            r0.label = r5     // Catch: java.lang.Throwable -> L31
            java.lang.Object r7 = r7.c(r0)     // Catch: java.lang.Throwable -> L31
            if (r7 != r1) goto L56
            return r1
        L56:
            com.stepos.datacenter.core.result.DataCenterResult r7 = (com.stepos.datacenter.core.result.DataCenterResult) r7     // Catch: java.lang.Throwable -> L31
            boolean r6 = r7 instanceof com.stepos.datacenter.core.result.DataCenterResult.Success     // Catch: java.lang.Throwable -> L31
            if (r6 == 0) goto L5f
            Y8.t r6 = Y8.t.f7040a     // Catch: java.lang.Throwable -> L31
            goto L8f
        L5f:
            boolean r6 = r7 instanceof com.stepos.datacenter.core.result.DataCenterResult.Failure     // Catch: java.lang.Throwable -> L31
            if (r6 == 0) goto L94
            r6 = r7
            com.stepos.datacenter.core.result.DataCenterResult$Failure r6 = (com.stepos.datacenter.core.result.DataCenterResult.Failure) r6     // Catch: java.lang.Throwable -> L31
            com.stepos.datacenter.core.result.DataCenterError r6 = r6.getError()     // Catch: java.lang.Throwable -> L31
            com.stepos.datacenter.core.result.DataCenterResult$Failure r7 = (com.stepos.datacenter.core.result.DataCenterResult.Failure) r7     // Catch: java.lang.Throwable -> L31
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L31
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31
            r0.<init>()     // Catch: java.lang.Throwable -> L31
            r0.append(r3)     // Catch: java.lang.Throwable -> L31
            r0.append(r6)     // Catch: java.lang.Throwable -> L31
            java.lang.String r6 = " "
            r0.append(r6)     // Catch: java.lang.Throwable -> L31
            r0.append(r7)     // Catch: java.lang.Throwable -> L31
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L31
            int r6 = android.util.Log.w(r4, r6)     // Catch: java.lang.Throwable -> L31
            java.lang.Integer r6 = g9.C4109a.f(r6)     // Catch: java.lang.Throwable -> L31
        L8f:
            java.lang.Object r6 = kotlin.Result.b(r6)     // Catch: java.lang.Throwable -> L31
            goto La4
        L94:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L31
            r6.<init>()     // Catch: java.lang.Throwable -> L31
            throw r6     // Catch: java.lang.Throwable -> L31
        L9a:
            kotlin.Result$a r7 = kotlin.Result.INSTANCE
            java.lang.Object r6 = kotlin.C4849c.a(r6)
            java.lang.Object r6 = kotlin.Result.b(r6)
        La4:
            java.lang.Throwable r6 = kotlin.Result.e(r6)
            if (r6 == 0) goto Lc0
            java.lang.String r7 = r6.getMessage()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            android.util.Log.w(r4, r7, r6)
        Lc0:
            Y8.t r6 = Y8.t.f7040a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.vector.DataCenterVectorIndex.w(e9.c):java.lang.Object");
    }

    public final DataCenter x() {
        return DataCenter.INSTANCE.getInstance();
    }

    public final com.stepos.datacenter.api.e y() {
        return x().getVectors();
    }

    public final boolean z(LauncherVectorEntity launcherVectorEntity, LauncherVectorEntity launcherVectorEntity2) {
        return p.d(launcherVectorEntity.getBizKey(), launcherVectorEntity2.getBizKey()) && p.d(launcherVectorEntity.getBizType(), launcherVectorEntity2.getBizType()) && p.d(launcherVectorEntity.getEntityClassName(), launcherVectorEntity2.getEntityClassName()) && p.d(launcherVectorEntity.getBizId(), launcherVectorEntity2.getBizId()) && p.d(launcherVectorEntity.getTitle(), launcherVectorEntity2.getTitle()) && p.d(launcherVectorEntity.getContent(), launcherVectorEntity2.getContent()) && p.d(launcherVectorEntity.getMetadata(), launcherVectorEntity2.getMetadata()) && launcherVectorEntity.getUpdateTime() == launcherVectorEntity2.getUpdateTime();
    }
}
