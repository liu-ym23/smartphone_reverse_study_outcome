package com.stepos.stepclaw.memory;

import a6.f0;
import a6.i0;
import a6.r0;
import android.app.Application;
import b5.a0;
import c5.z;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.net.StepOSHeadersProvider;
import com.stepos.stepclaw.base.track.ToolCallReportPhase;
import com.stepos.stepclaw.base.util.StepModel;
import com.stepos.stepclaw.bridge.spi.ConfigIpcContract;
import com.stepos.stepclaw.bridge.spi.Reporter;
import com.stepos.stepclaw.bridge.spi.ReporterBridge;
import com.stepos.stepclaw.memory.MemoryFormatMigrator;
import com.stepos.stepclaw.memory.embedding.EmbeddingClient;
import com.stepos.stepclaw.memory.embedding.EmbeddingProvider;
import com.stepos.stepclaw.memory.embedding.EmbeddingQueue;
import com.stepos.stepclaw.memory.embedding.EmbeddingStorage;
import com.stepos.stepclaw.memory.embedding.RemoteEmbeddingProvider;
import com.stepos.stepclaw.memory.lightmem.LightMemClient;
import com.stepos.stepclaw.memory.lightmem.evolution.OfflineEvolutionService;
import com.stepos.stepclaw.memory.lightmem.local.LocalEmbeddingProvider;
import com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine;
import com.stepos.stepclaw.memory.lightmem.remote.AutoCatchResponse;
import com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem;
import com.stepos.stepclaw.memory.lightmem.remote.MessageItem;
import com.stepos.stepclaw.memory.search.BM25Retriever;
import com.stepos.stepclaw.memory.search.FormatStage;
import com.stepos.stepclaw.memory.search.MemoryRetriever;
import com.stepos.stepclaw.memory.search.MemorySearchConfig;
import com.stepos.stepclaw.memory.search.QueryRewriteStage;
import com.stepos.stepclaw.memory.search.RerankStage;
import com.stepos.stepclaw.memory.search.RetrievalResult;
import com.stepos.stepclaw.memory.search.RetrievalStage;
import com.stepos.stepclaw.memory.search.SearchPipeline;
import com.stepos.stepclaw.memory.search.VectorRetriever;
import com.stepos.stepclaw.memory.storage.MemoryStorage;
import com.stepos.stepclaw.memory.storage.cache.TieredCacheConfig;
import com.stepos.stepclaw.memory.storage.file.MemoryFile;
import com.stepos.stepclaw.memory.storage.file.MemoryRecord;
import com.stepos.stepclaw.memory.storage.index.MemoryIndexManager;
import com.stepos.stepclaw.memory.upload.MemoryUploadService;
import com.stepos.stepclaw.memory.upload.UploadBatchResult;
import com.stepos.stepclaw.memory.utils.AndroidMemoryLogger;
import com.stepos.stepclaw.memory.utils.MemoryLogger;
import com.stepos.stepclaw.memory.utils.PerfTrace;
import com.stepos.stepclaw.openclaw.memory.FsAppendMmrResult;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.w;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u009a\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b7\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJM\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0015\u001a\u00020\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0086@¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u00062\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0004\b%\u0010&J9\u0010+\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\t2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\b\b\u0002\u0010*\u001a\u00020\t¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J!\u00104\u001a\u00020\u00062\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020201¢\u0006\u0004\b4\u00105J1\u0010;\u001a\u00020\u00062\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\t2\u0012\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u001a08¢\u0006\u0004\b;\u0010<J\u001f\u0010?\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b?\u0010@J?\u0010E\u001a\u00020\t2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002090\u001a2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bE\u0010FJ'\u0010G\u001a\u00020\u00062\f\u0010A\u001a\b\u0012\u0004\u0012\u0002090\u001a2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bG\u0010HJ\u0013\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0\u001a¢\u0006\u0004\bI\u0010\u001cJ>\u0010N\u001a\b\u0012\u0004\u0012\u00020M0\u001a2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010J2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001aH\u0086@¢\u0006\u0004\bN\u0010OJL\u0010R\u001a\u00020\t2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010J2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\b\b\u0002\u0010P\u001a\u00020\u00042\b\b\u0002\u0010Q\u001a\u00020\u0004H\u0086@¢\u0006\u0004\bR\u0010SJ*\u0010V\u001a\u0004\u0018\u00010U2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\tH\u0086@¢\u0006\u0004\bV\u0010WJ\u0012\u0010Y\u001a\u0004\u0018\u00010XH\u0086@¢\u0006\u0004\bY\u0010ZJ\u000f\u0010\\\u001a\u00020\u0006H\u0000¢\u0006\u0004\b[\u0010\u0003J\u0018\u0010_\u001a\u00020\u00062\u0006\u0010^\u001a\u00020]H\u0082@¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\u0006H\u0002¢\u0006\u0004\ba\u0010\u0003J!\u0010c\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0801H\u0002¢\u0006\u0004\bc\u0010dJ)\u0010f\u001a\u00020\u00062\u0018\u0010e\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020b0801H\u0002¢\u0006\u0004\bf\u00105J%\u0010j\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020g2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\t0hH\u0002¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020b2\u0006\u0010l\u001a\u00020\tH\u0002¢\u0006\u0004\bm\u0010nJ'\u0010p\u001a\u00020\u00062\u0006\u0010o\u001a\u00020b2\u0006\u0010\u0013\u001a\u00020g2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010r\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\br\u0010sJ\u000f\u0010u\u001a\u00020tH\u0002¢\u0006\u0004\bu\u0010vJ-\u0010x\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\t2\b\u0010w\u001a\u0004\u0018\u00010\t2\b\u0010D\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\bx\u0010yJ7\u0010{\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\t2\b\u0010w\u001a\u0004\u0018\u00010\t2\b\u0010z\u001a\u0004\u0018\u00010\t2\b\u0010D\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b{\u0010|J\u0019\u0010}\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b}\u0010\fJ\u000f\u0010~\u001a\u00020\tH\u0002¢\u0006\u0004\b~\u0010\u001eJ/\u0010\u0082\u0001\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\t2\b\u0010\u0081\u0001\u001a\u00030\u0080\u00012\b\u0010C\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J.\u0010\u0085\u0001\u001a\u00020\u00042\u0006\u0010\u007f\u001a\u00020\t2\u0007\u0010\u0084\u0001\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0087\u0001\u001a\u00020\t8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u0089\u0001\u001a\u00020\t8\u0006X\u0086T¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0088\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008d\u00018\u0002X\u0082T¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0010\u0010\u0093\u0001R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0012\u0010\u0094\u0001R\u001b\u0010\u0095\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001b\u0010\u0097\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009c\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001c\u0010 \u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001c\u0010£\u0001\u001a\u0005\u0018\u00010¢\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b£\u0001\u0010¤\u0001R\u001c\u0010¦\u0001\u001a\u0005\u0018\u00010¥\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¦\u0001\u0010§\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010¨\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001b\u0010«\u0001\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001c\u0010®\u0001\u001a\u0005\u0018\u00010\u00ad\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u001c\u0010±\u0001\u001a\u0005\u0018\u00010°\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0017\u0010³\u0001R\u0018\u0010µ\u0001\u001a\u00030´\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u001b\u0010·\u0001\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u0096\u0001R+\u0010¸\u0001\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020b08018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010»\u0001\u001a\u00030º\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R)\u0010¾\u0001\u001a\u00020\u00042\u0007\u0010½\u0001\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0006\b¾\u0001\u0010¿\u0001\u001a\u0005\bÀ\u0001\u0010 R\u0019\u0010Á\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010¿\u0001R\u001d\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\t0h8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R*\u0010Ä\u0001\u001a\u00020-2\u0007\u0010½\u0001\u001a\u00020-8\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001R'\u0010È\u0001\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bÈ\u0001\u0010¿\u0001\u001a\u0005\bÉ\u0001\u0010 \"\u0005\bÊ\u0001\u0010\bR\u0018\u0010Í\u0001\u001a\u00030´\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0019\u0010Ð\u0001\u001a\u0004\u0018\u00010\u000f8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0019\u0010Ö\u0001\u001a\u0004\u0018\u00010g8@X\u0080\u0004¢\u0006\b\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u0019\u0010Ù\u0001\u001a\u0004\u0018\u00010]8@X\u0080\u0004¢\u0006\b\u001a\u0006\b×\u0001\u0010Ø\u0001R\u001a\u0010Ü\u0001\u001a\u0005\u0018\u00010\u0099\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u001a\u0010ß\u0001\u001a\u0005\u0018\u00010\u009f\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u001a\u0010â\u0001\u001a\u0005\u0018\u00010¢\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bà\u0001\u0010á\u0001R\u0018\u0010ä\u0001\u001a\u0004\u0018\u00010t8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bã\u0001\u0010vR\u0018\u0010ç\u0001\u001a\u00030\u008a\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bå\u0001\u0010æ\u0001R\u001a\u0010ê\u0001\u001a\u0005\u0018\u00010\u00ad\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bè\u0001\u0010é\u0001R\u001a\u0010í\u0001\u001a\u0005\u0018\u00010\u009c\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bë\u0001\u0010ì\u0001R\u001a\u0010ð\u0001\u001a\u0005\u0018\u00010°\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\bî\u0001\u0010ï\u0001¨\u0006ñ\u0001"}, d2 = {"Lcom/stepos/stepclaw/memory/MemoryEngine;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "debug", "Lb5/a0;", "setDebug", "(Z)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "newUrl", "updateBaseUrl", "(Ljava/lang/String;)V", "Landroid/app/Application;", "application", "Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "client", "La6/f0;", "scope", "baseDir", "enableVectorFeature", "defaultEmbeddingProviderId", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "headersProvider", "init", "(Landroid/app/Application;Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;La6/f0;Ljava/lang/String;ZLjava/lang/String;Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "listEmbeddingProviderIds", "()Ljava/util/List;", "activeEmbeddingProviderId", "()Ljava/lang/String;", "isActiveEmbeddingProviderAvailable", "()Z", "providerId", "switchEmbeddingProvider", "(Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "categories", "backfillEmbeddings", "(Ljava/util/List;)V", ConfigIpcContract.KEY_BASE_URL, ConfigIpcContract.KEY_API_KEY, "apiKeys", ConfigIpcContract.KEY_MODEL, "updateEmbeddingConfig", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", "config", "updateSearchConfig", "(Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "thresholds", "updateSearchScoreThresholds", "(Ljava/util/Map;)V", OperationResult.EXTRA_MESSAGE, "sessionKey", "Lkotlin/Function0;", "Lcom/stepos/stepclaw/memory/lightmem/remote/MessageItem;", "historyProvider", "beforeSendMessage", "(Ljava/lang/String;Ljava/lang/String;Lp5/a;)V", "toolName", "argsJson", "beforeToolCall", "(Ljava/lang/String;Ljava/lang/String;)V", "messages", "prompt", "sessionId", "traceId", "autoRecall", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "autoCapture", "(Ljava/util/List;Ljava/lang/String;)V", "getStepMemCategories", "Ljava/util/Date;", "fromDate", "toDate", "Lcom/stepos/stepclaw/memory/storage/file/MemoryRecord;", "readStepMem", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "groupByCategory", "flattenContent", "readStepMemAsString", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/List;ZZLf5/c;)Ljava/lang/Object;", "episodicFileName", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionPipelineResult;", "runOfflineEvolutionEpisodicPipeline", "(Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "Lcom/stepos/stepclaw/memory/upload/UploadBatchResult;", "forceUploadMemories", "(Lf5/c;)Ljava/lang/Object;", "rebuildSearchPipeline$step_memory_release", "rebuildSearchPipeline", "Lcom/stepos/stepclaw/memory/storage/MemoryStorage;", "storage", "backfillEmbeddingsInternal", "(Lcom/stepos/stepclaw/memory/storage/MemoryStorage;Lf5/c;)Ljava/lang/Object;", "maybeTriggerDeferredBackfill", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", "buildDefaultProviderRegistry", "()Ljava/util/Map;", "registry", "validateProviderRegistry", "Ljava/io/File;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "knownProviderIds", "cleanupLegacyEmbeddingDirs", "(Ljava/io/File;Ljava/util/Set;)V", "requestedId", "resolveInitialProvider", "(Ljava/lang/String;)Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", ConfigIpcContract.KEY_PROVIDER, "installEmbeddingComponents", "(Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;Ljava/io/File;La6/f0;)V", "triggerRebuildAfterSwitch", "(La6/f0;)V", "Lcom/stepos/stepclaw/memory/search/SearchPipeline;", "buildSearchPipeline", "()Lcom/stepos/stepclaw/memory/search/SearchPipeline;", "paramsJson", "reportAutoRecallBefore", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "resultJson", "reportAutoRecallAfter", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "maybeAutoTriggerEvolution", "getDailyMemoryFileName", "category", "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "item", "writeCategoryMemoryToDaily", "(Ljava/lang/String;Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "memory", "writeCategoryMemoryToDailyRemote", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lf5/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "DEFAULT_EMBEDDING_PROVIDER_ID", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", "localInferenceEngine", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "OFFLINE_EVOLUTION_PENDING_THRESHOLD", "I", "Ljava/util/concurrent/atomic/AtomicInteger;", "episodicPendingCounter", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "La6/f0;", "memoryStorageRoot", "Ljava/io/File;", "memoryStorage", "Lcom/stepos/stepclaw/memory/storage/MemoryStorage;", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "indexManager", "Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "Lcom/stepos/stepclaw/memory/search/BM25Retriever;", "bm25Retriever", "Lcom/stepos/stepclaw/memory/search/BM25Retriever;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "embeddingClient", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "embeddingStorage", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingQueue;", "embeddingQueue", "Lcom/stepos/stepclaw/memory/embedding/EmbeddingQueue;", "Lcom/stepos/stepclaw/memory/search/VectorRetriever;", "vectorRetriever", "Lcom/stepos/stepclaw/memory/search/VectorRetriever;", "searchPipeline", "Lcom/stepos/stepclaw/memory/search/SearchPipeline;", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService;", "offlineEvolutionService", "Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService;", "Lcom/stepos/stepclaw/memory/upload/MemoryUploadService;", "uploadService", "Lcom/stepos/stepclaw/memory/upload/MemoryUploadService;", "Lcom/stepos/stepclaw/base/net/StepOSHeadersProvider;", "Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger;", "logger", "Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger;", "embeddingBaseDir", "providerRegistry", "Ljava/util/Map;", "Li6/a;", "switchMutex", "Li6/a;", "value", "rebuildInFlight", "Z", "getRebuildInFlight", "embeddingBackfillSkippedAtInit", "RESERVED_CATEGORY_NAMES", "Ljava/util/Set;", "searchConfig", "Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", "getSearchConfig", "()Lcom/stepos/stepclaw/memory/search/MemorySearchConfig;", "autoRecallCaptureEnabled", "getAutoRecallCaptureEnabled", "setAutoRecallCaptureEnabled", "getDumpLogger$step_memory_release", "()Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger;", "dumpLogger", "getDumpClient$step_memory_release", "()Lcom/stepos/stepclaw/memory/lightmem/LightMemClient;", "dumpClient", "getDumpScope$step_memory_release", "()La6/f0;", "dumpScope", "getDumpStorageRoot$step_memory_release", "()Ljava/io/File;", "dumpStorageRoot", "getDumpStorage$step_memory_release", "()Lcom/stepos/stepclaw/memory/storage/MemoryStorage;", "dumpStorage", "getDumpIndexManager$step_memory_release", "()Lcom/stepos/stepclaw/memory/storage/index/MemoryIndexManager;", "dumpIndexManager", "getDumpEmbeddingClient$step_memory_release", "()Lcom/stepos/stepclaw/memory/embedding/EmbeddingClient;", "dumpEmbeddingClient", "getDumpEmbeddingStorage$step_memory_release", "()Lcom/stepos/stepclaw/memory/embedding/EmbeddingStorage;", "dumpEmbeddingStorage", "getDumpSearchPipeline$step_memory_release", "dumpSearchPipeline", "getDumpLocalInferenceEngine$step_memory_release", "()Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferenceEngine;", "dumpLocalInferenceEngine", "getDumpOfflineEvolutionService$step_memory_release", "()Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionService;", "dumpOfflineEvolutionService", "getDumpBm25Retriever$step_memory_release", "()Lcom/stepos/stepclaw/memory/search/BM25Retriever;", "dumpBm25Retriever", "getDumpUploadService$step_memory_release", "()Lcom/stepos/stepclaw/memory/upload/MemoryUploadService;", "dumpUploadService", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MemoryEngine {
    public static final String DEFAULT_EMBEDDING_PROVIDER_ID = "local-stepinfer-emb";
    private static final int OFFLINE_EVOLUTION_PENDING_THRESHOLD = 64;
    private static final String TAG = "MemoryEngine";
    private static volatile boolean autoRecallCaptureEnabled;
    private static BM25Retriever bm25Retriever;
    private static LightMemClient client;
    private static volatile boolean embeddingBackfillSkippedAtInit;
    private static File embeddingBaseDir;
    private static EmbeddingClient embeddingClient;
    private static EmbeddingQueue embeddingQueue;
    private static EmbeddingStorage embeddingStorage;
    private static StepOSHeadersProvider headersProvider;
    private static MemoryIndexManager indexManager;
    private static MemoryStorage memoryStorage;
    private static File memoryStorageRoot;
    private static OfflineEvolutionService offlineEvolutionService;
    private static volatile boolean rebuildInFlight;
    private static f0 scope;
    private static SearchPipeline searchPipeline;
    private static MemoryUploadService uploadService;
    private static VectorRetriever vectorRetriever;
    public static final MemoryEngine INSTANCE = new MemoryEngine();
    private static final LocalInferenceEngine localInferenceEngine = new LocalInferenceEngine();
    private static final AtomicInteger episodicPendingCounter = new AtomicInteger(0);
    private static final AndroidMemoryLogger logger = new AndroidMemoryLogger();
    private static Map<String, ? extends p5.a> providerRegistry = c5.t.f1093a;
    private static final i6.a switchMutex = new i6.c();
    private static final Set<String> RESERVED_CATEGORY_NAMES = c5.l.k0(new String[]{"episodic", "user_profile", "fact", "agent", "agent_identity", "agent_boundary", "agent_method", "procedural"});
    private static MemorySearchConfig searchConfig = MemorySearchConfig.INSTANCE.getDEFAULT();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$autoCapture$3", f = "MemoryEngine.kt", l = {784, 808, 784, 808}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$autoCapture$3, reason: invalid class name */
    public static final class AnonymousClass3 extends h5.i implements p5.p {
        final /* synthetic */ LightMemClient $c;
        final /* synthetic */ List<MessageItem> $messages;
        final /* synthetic */ String $sessionId;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        int I$6;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, LightMemClient lightMemClient, List<MessageItem> list, f5.c cVar) {
            super(2, cVar);
            this.$sessionId = str;
            this.$c = lightMemClient;
            this.$messages = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$1() {
            return "memory_auto_ingestion: no memories captured";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$2$1(String str, List list, w wVar) {
            int size = list.size();
            return m0.f.e(a8.b.u("memory_auto_ingestion [", size, str, "]: ", " items, "), wVar.f3684a, " written");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$3(w wVar) {
            return a8.b.k(wVar.f3684a, "memory_auto_ingestion success: total ", " memories written");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$4(int i8, w wVar) {
            return "[autoCapture] episodicPendingCounter=" + i8 + " (added " + wVar.f3684a + ")";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$5(AutoCatchResponse autoCatchResponse) {
            return m0.f.c("memory_auto_ingestion: ", autoCatchResponse.getMessage());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0$6(Exception exc) {
            return m0.f.c("memory_auto_ingestion failed: ", exc.getMessage());
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass3(this.$sessionId, this.$c, this.$messages, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass3) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:101:0x03fe, B:102:0x0400], limit reached: 235 */
        /* JADX WARN: Path cross not found for [B:40:0x0207, B:41:0x0209], limit reached: 235 */
        /* JADX WARN: Path cross not found for [B:4:0x0012, B:30:0x01ba], limit reached: 235 */
        /* JADX WARN: Removed duplicated region for block: B:118:0x0460 A[Catch: Exception -> 0x05d1, TryCatch #7 {Exception -> 0x05d1, blocks: (B:116:0x045a, B:118:0x0460, B:120:0x047c, B:170:0x05ed, B:172:0x05fe, B:174:0x0619), top: B:202:0x045a }] */
        /* JADX WARN: Removed duplicated region for block: B:137:0x0543 A[Catch: Exception -> 0x054c, TRY_LEAVE, TryCatch #2 {Exception -> 0x054c, blocks: (B:135:0x053b, B:137:0x0543), top: B:192:0x053b }] */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0558  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x0583  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x05ed A[Catch: Exception -> 0x05d1, TRY_ENTER, TryCatch #7 {Exception -> 0x05d1, blocks: (B:116:0x045a, B:118:0x0460, B:120:0x047c, B:170:0x05ed, B:172:0x05fe, B:174:0x0619), top: B:202:0x045a }] */
        /* JADX WARN: Removed duplicated region for block: B:176:0x062b A[Catch: Exception -> 0x0422, TRY_ENTER, TRY_LEAVE, TryCatch #16 {Exception -> 0x0422, blocks: (B:97:0x03ec, B:99:0x03f4, B:112:0x042c, B:114:0x043b, B:102:0x0400, B:103:0x0408, B:105:0x040e, B:176:0x062b), top: B:219:0x03ec }] */
        /* JADX WARN: Removed duplicated region for block: B:182:0x0657  */
        /* JADX WARN: Removed duplicated region for block: B:183:0x065e  */
        /* JADX WARN: Removed duplicated region for block: B:186:0x0666  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x04b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:237:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01fd A[Catch: Exception -> 0x0341, TryCatch #17 {Exception -> 0x0341, blocks: (B:51:0x024e, B:53:0x0254, B:55:0x026c, B:36:0x01f5, B:38:0x01fd, B:50:0x023b, B:41:0x0209, B:42:0x0211, B:32:0x01cd), top: B:220:0x01cd }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0254 A[Catch: Exception -> 0x0341, TryCatch #17 {Exception -> 0x0341, blocks: (B:51:0x024e, B:53:0x0254, B:55:0x026c, B:36:0x01f5, B:38:0x01fd, B:50:0x023b, B:41:0x0209, B:42:0x0211, B:32:0x01cd), top: B:220:0x01cd }] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0294 A[Catch: Exception -> 0x0302, TRY_ENTER, TryCatch #15 {Exception -> 0x0302, blocks: (B:62:0x02f1, B:64:0x02f9, B:59:0x0294, B:72:0x031e), top: B:217:0x02f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x02f9 A[Catch: Exception -> 0x0302, TRY_LEAVE, TryCatch #15 {Exception -> 0x0302, blocks: (B:62:0x02f1, B:64:0x02f9, B:59:0x0294, B:72:0x031e), top: B:217:0x02f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x030c  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0356 A[Catch: Exception -> 0x0339, TryCatch #11 {Exception -> 0x0339, blocks: (B:75:0x032e, B:84:0x0356, B:86:0x036a, B:88:0x0385, B:89:0x0394), top: B:210:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0394 A[Catch: Exception -> 0x0339, TRY_LEAVE, TryCatch #11 {Exception -> 0x0339, blocks: (B:75:0x032e, B:84:0x0356, B:86:0x036a, B:88:0x0385, B:89:0x0394), top: B:210:0x0010 }] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x03f4 A[Catch: Exception -> 0x0422, TryCatch #16 {Exception -> 0x0422, blocks: (B:97:0x03ec, B:99:0x03f4, B:112:0x042c, B:114:0x043b, B:102:0x0400, B:103:0x0408, B:105:0x040e, B:176:0x062b), top: B:219:0x03ec }] */
        /* JADX WARN: Type inference failed for: r0v9, types: [com.stepos.stepclaw.memory.utils.AndroidMemoryLogger] */
        /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r10v2 */
        /* JADX WARN: Type inference failed for: r10v3 */
        /* JADX WARN: Type inference failed for: r10v6 */
        /* JADX WARN: Type inference failed for: r1v1, types: [com.stepos.stepclaw.memory.utils.AndroidMemoryLogger] */
        /* JADX WARN: Type inference failed for: r1v8, types: [com.stepos.stepclaw.memory.utils.AndroidMemoryLogger] */
        /* JADX WARN: Type inference failed for: r20v0 */
        /* JADX WARN: Type inference failed for: r20v1 */
        /* JADX WARN: Type inference failed for: r20v12 */
        /* JADX WARN: Type inference failed for: r20v2 */
        /* JADX WARN: Type inference failed for: r4v11, types: [com.stepos.stepclaw.memory.utils.AndroidMemoryLogger] */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v45 */
        /* JADX WARN: Type inference failed for: r5v46 */
        /* JADX WARN: Type inference failed for: r5v49 */
        /* JADX WARN: Type inference failed for: r5v5 */
        /* JADX WARN: Type inference failed for: r5v50 */
        /* JADX WARN: Type inference failed for: r5v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object, java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r8v18 */
        /* JADX WARN: Type inference failed for: r8v33 */
        /* JADX WARN: Type inference failed for: r8v4 */
        /* JADX WARN: Type inference failed for: r8v40 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:121:0x048d -> B:194:0x04b3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:134:0x0528 -> B:192:0x053b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:168:0x05d9 -> B:169:0x05e4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x027b -> B:204:0x028e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x02ec -> B:217:0x02f1). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0346 -> B:83:0x034e). Please report as a decompilation issue!!! */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r33) {
            /*
                Method dump skipped, instructions count: 1647
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$backfillEmbeddings$1", f = "MemoryEngine.kt", l = {531, 533}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$backfillEmbeddings$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.i implements p5.p {
        final /* synthetic */ List<String> $categories;
        final /* synthetic */ EmbeddingClient $embClient;
        final /* synthetic */ EmbeddingStorage $embStore;
        final /* synthetic */ Set<String> $permCats;
        final /* synthetic */ MemoryStorage $storage;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MemoryStorage memoryStorage, List<String> list, EmbeddingStorage embeddingStorage, EmbeddingClient embeddingClient, Set<String> set, f5.c cVar) {
            super(2, cVar);
            this.$storage = memoryStorage;
            this.$categories = list;
            this.$embStore = embeddingStorage;
            this.$embClient = embeddingClient;
            this.$permCats = set;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$0(List list, List list2) {
            return "backfillEmbeddings: " + list.size() + " entries to check (categories=" + list2 + ")";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(int i8) {
            return a8.b.k(i8, "backfillEmbeddings: done, wrote ", " new embeddings");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$2(Exception exc) {
            return m0.f.c("backfillEmbeddings failed: ", exc.getMessage());
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new AnonymousClass1(this.$storage, this.$categories, this.$embStore, this.$embClient, this.$permCats, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
        
            if (r15 == r0) goto L19;
         */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                g5.a r0 = g5.a.f2984a
                int r1 = r14.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L21
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r14 = r14.L$0
                java.util.List r14 = (java.util.List) r14
                a.a.c0(r15)     // Catch: java.lang.Exception -> L7e
                goto L65
            L14:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r15)
                throw r14
            L1c:
                a.a.c0(r15)     // Catch: java.lang.Exception -> L7e
                r7 = r14
                goto L37
            L21:
                a.a.c0(r15)
                r15 = r3
                com.stepos.stepclaw.memory.storage.MemoryStorage r3 = r14.$storage     // Catch: java.lang.Exception -> L7e
                java.util.List<java.lang.String> r6 = r14.$categories     // Catch: java.lang.Exception -> L7e
                r14.label = r15     // Catch: java.lang.Exception -> L7e
                r4 = 0
                r5 = 0
                r8 = 3
                r9 = 0
                r7 = r14
                java.lang.Object r15 = com.stepos.stepclaw.memory.storage.MemoryStorage.readEntries$default(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L7e
                if (r15 != r0) goto L37
                goto L64
            L37:
                r4 = r15
                java.util.List r4 = (java.util.List) r4     // Catch: java.lang.Exception -> L7e
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r8 = com.stepos.stepclaw.memory.MemoryEngine.access$getLogger$p()     // Catch: java.lang.Exception -> L7e
                java.lang.String r9 = "MemoryEngine"
                java.util.List<java.lang.String> r14 = r7.$categories     // Catch: java.lang.Exception -> L7e
                com.stepos.stepclaw.memory.t r11 = new com.stepos.stepclaw.memory.t     // Catch: java.lang.Exception -> L7e
                r15 = 0
                r11.<init>(r4, r15, r14)     // Catch: java.lang.Exception -> L7e
                r12 = 2
                r13 = 0
                r10 = 0
                com.stepos.stepclaw.memory.utils.MemoryLogger.logI$default(r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Exception -> L7e
                com.stepos.stepclaw.memory.embedding.EmbeddingStorage r3 = r7.$embStore     // Catch: java.lang.Exception -> L7e
                com.stepos.stepclaw.memory.embedding.EmbeddingClient r5 = r7.$embClient     // Catch: java.lang.Exception -> L7e
                java.util.Set<java.lang.String> r6 = r7.$permCats     // Catch: java.lang.Exception -> L7e
                r14 = 0
                r7.L$0 = r14     // Catch: java.lang.Exception -> L7e
                r7.label = r2     // Catch: java.lang.Exception -> L7e
                r8 = r7
                r7 = 0
                r9 = 8
                r10 = 0
                java.lang.Object r15 = com.stepos.stepclaw.memory.embedding.EmbeddingStorage.embedAndStore$default(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L7e
                if (r15 != r0) goto L65
            L64:
                return r0
            L65:
                java.lang.Number r15 = (java.lang.Number) r15     // Catch: java.lang.Exception -> L7e
                int r14 = r15.intValue()     // Catch: java.lang.Exception -> L7e
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r0 = com.stepos.stepclaw.memory.MemoryEngine.access$getLogger$p()     // Catch: java.lang.Exception -> L7e
                java.lang.String r1 = "MemoryEngine"
                com.stepos.stepclaw.memory.j r3 = new com.stepos.stepclaw.memory.j     // Catch: java.lang.Exception -> L7e
                r15 = 1
                r3.<init>(r14, r15)     // Catch: java.lang.Exception -> L7e
                r4 = 2
                r5 = 0
                r2 = 0
                com.stepos.stepclaw.memory.utils.MemoryLogger.logI$default(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L7e
                goto L92
            L7e:
                r0 = move-exception
                r14 = r0
                com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r0 = com.stepos.stepclaw.memory.MemoryEngine.access$getLogger$p()
                com.stepos.stepclaw.memory.k r3 = new com.stepos.stepclaw.memory.k
                r15 = 3
                r3.<init>(r14, r15)
                r4 = 2
                r5 = 0
                java.lang.String r1 = "MemoryEngine"
                r2 = 0
                com.stepos.stepclaw.memory.utils.MemoryLogger.logW$default(r0, r1, r2, r3, r4, r5)
            L92:
                b5.a0 r14 = b5.a0.f883a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine", f = "MemoryEngine.kt", l = {292, 294}, m = "backfillEmbeddingsInternal", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$backfillEmbeddingsInternal$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00331 extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C00331(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryEngine.this.backfillEmbeddingsInternal(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/search/RetrievalResult;", "rankedResults", "Lb5/a0;", "<anonymous>", "(Ljava/util/List;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$buildSearchPipeline$1", f = "MemoryEngine.kt", l = {630}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$buildSearchPipeline$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00341 extends h5.i implements p5.p {
        /* synthetic */ Object L$0;
        int label;

        public C00341(f5.c cVar) {
            super(2, cVar);
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            C00341 c00341 = new C00341(cVar);
            c00341.L$0 = obj;
            return c00341;
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            List list = (List) this.L$0;
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            if (i8 == 0) {
                a.a.c0(obj);
                MemoryIndexManager memoryIndexManager = MemoryEngine.indexManager;
                if (memoryIndexManager != null) {
                    ArrayList arrayList = new ArrayList(c5.o.n0(list, 10));
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((RetrievalResult) it.next()).getDocId());
                    }
                    this.L$0 = null;
                    this.label = 1;
                    if (memoryIndexManager.recordAccess(arrayList, this) == aVar) {
                        return aVar;
                    }
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                a.a.c0(obj);
            }
            return a0.f883a;
        }

        @Override // p5.p
        public final Object invoke(List<RetrievalResult> list, f5.c cVar) {
            return ((C00341) create(list, cVar)).invokeSuspend(a0.f883a);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$init$1", f = "MemoryEngine.kt", l = {175, 177}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$init$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00351 extends h5.i implements p5.p {
        final /* synthetic */ Application $application;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00351(Application application, f5.c cVar) {
            super(2, cVar);
            this.$application = application;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00351(this.$application, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00351) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
        
            if (r7.loadAlgorithm(r0, r6) == r1) goto L23;
         */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.String r0 = "LocalInferenceEngine not supported: "
                g5.a r1 = g5.a.f2984a
                int r2 = r6.label
                java.lang.String r3 = "MemoryEngine"
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L26
                if (r2 == r5) goto L22
                if (r2 != r4) goto L1a
                java.lang.Object r6 = r6.L$0
                com.stepos.stepclaw.memory.lightmem.local.LocalInferSupportState r6 = (com.stepos.stepclaw.memory.lightmem.local.LocalInferSupportState) r6
                a.a.c0(r7)     // Catch: java.lang.Exception -> L18
                goto L52
            L18:
                r6 = move-exception
                goto L69
            L1a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L22:
                a.a.c0(r7)     // Catch: java.lang.Exception -> L18
                goto L38
            L26:
                a.a.c0(r7)
                com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine r7 = com.stepos.stepclaw.memory.MemoryEngine.access$getLocalInferenceEngine$p()     // Catch: java.lang.Exception -> L18
                android.app.Application r2 = r6.$application     // Catch: java.lang.Exception -> L18
                r6.label = r5     // Catch: java.lang.Exception -> L18
                java.lang.Object r7 = r7.checkSupport(r2, r6)     // Catch: java.lang.Exception -> L18
                if (r7 != r1) goto L38
                goto L51
            L38:
                com.stepos.stepclaw.memory.lightmem.local.LocalInferSupportState r7 = (com.stepos.stepclaw.memory.lightmem.local.LocalInferSupportState) r7     // Catch: java.lang.Exception -> L18
                boolean r2 = r7.isReady()     // Catch: java.lang.Exception -> L18
                r5 = 0
                if (r2 == 0) goto L58
                com.stepos.stepclaw.memory.lightmem.local.LocalInferenceEngine r7 = com.stepos.stepclaw.memory.MemoryEngine.access$getLocalInferenceEngine$p()     // Catch: java.lang.Exception -> L18
                android.app.Application r0 = r6.$application     // Catch: java.lang.Exception -> L18
                r6.L$0 = r5     // Catch: java.lang.Exception -> L18
                r6.label = r4     // Catch: java.lang.Exception -> L18
                java.lang.Object r6 = r7.loadAlgorithm(r0, r6)     // Catch: java.lang.Exception -> L18
                if (r6 != r1) goto L52
            L51:
                return r1
            L52:
                com.stepos.stepclaw.memory.MemoryEngine r6 = com.stepos.stepclaw.memory.MemoryEngine.INSTANCE     // Catch: java.lang.Exception -> L18
                com.stepos.stepclaw.memory.MemoryEngine.access$maybeTriggerDeferredBackfill(r6)     // Catch: java.lang.Exception -> L18
                goto L6e
            L58:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L18
                r6.<init>(r0)     // Catch: java.lang.Exception -> L18
                r6.append(r7)     // Catch: java.lang.Exception -> L18
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L18
                r7 = 4
                com.stepos.stepclaw.base.util.ALog.w$default(r3, r6, r5, r7, r5)     // Catch: java.lang.Exception -> L18
                goto L6e
            L69:
                java.lang.String r7 = "LocalInferenceEngine init failed"
                com.stepos.stepclaw.base.util.ALog.e(r3, r7, r6)
            L6e:
                b5.a0 r6 = b5.a0.f883a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.C00351.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$init$3", f = "MemoryEngine.kt", l = {251, 253, 268}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$init$3, reason: invalid class name and case insensitive filesystem */
    public static final class C00363 extends h5.i implements p5.p {
        final /* synthetic */ File $dir;
        final /* synthetic */ StepOSHeadersProvider $headersProvider;
        final /* synthetic */ MemoryIndexManager $idxMgr;
        final /* synthetic */ MemoryStorage $storage;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00363(MemoryStorage memoryStorage, MemoryIndexManager memoryIndexManager, StepOSHeadersProvider stepOSHeadersProvider, File file, f5.c cVar) {
            super(2, cVar);
            this.$storage = memoryStorage;
            this.$idxMgr = memoryIndexManager;
            this.$headersProvider = stepOSHeadersProvider;
            this.$dir = file;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final a0 invokeSuspend$lambda$0$0(OfflineEvolutionService offlineEvolutionService) {
            offlineEvolutionService.clearStaleCaches();
            return a0.f883a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String invokeSuspend$lambda$1(MemoryFormatMigrator.MigrationResult migrationResult) {
            return "MemoryFormatMigrator wiped data: index=" + migrationResult.getIndexWiped() + " embedding=" + migrationResult.getEmbeddingWiped() + " offlineCaches=" + migrationResult.getOfflineCachesCleared();
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00363(this.$storage, this.$idxMgr, this.$headersProvider, this.$dir, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00363) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00de, code lost:
        
            if (r13.uploadIfNeeded(r12) == r0) goto L36;
         */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00b3 A[Catch: Exception -> 0x00e1, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e1, blocks: (B:8:0x0024, B:13:0x0039, B:32:0x00af, B:34:0x00b3, B:16:0x0046, B:29:0x009e, B:19:0x004d, B:21:0x0062, B:23:0x006a, B:25:0x007d, B:26:0x008f), top: B:41:0x0008 }] */
        @Override // h5.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.C00363.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine", f = "MemoryEngine.kt", l = {882}, m = "readStepMemAsString", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00371 extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public C00371(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryEngine.this.readStepMemAsString(null, null, null, false, false, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine", f = "MemoryEngine.kt", l = {1025}, m = "switchEmbeddingProvider", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$switchEmbeddingProvider$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00381 extends h5.c {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C00381(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryEngine.this.switchEmbeddingProvider(null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine$triggerRebuildAfterSwitch$1", f = "MemoryEngine.kt", l = {513}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$triggerRebuildAfterSwitch$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00391 extends h5.i implements p5.p {
        final /* synthetic */ MemoryStorage $storage;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00391(MemoryStorage memoryStorage, f5.c cVar) {
            super(2, cVar);
            this.$storage = memoryStorage;
        }

        @Override // h5.a
        public final f5.c create(Object obj, f5.c cVar) {
            return new C00391(this.$storage, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, f5.c cVar) {
            return ((C00391) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            g5.a aVar = g5.a.f2984a;
            int i8 = this.label;
            try {
                if (i8 == 0) {
                    a.a.c0(obj);
                    MemoryEngine memoryEngine = MemoryEngine.INSTANCE;
                    MemoryStorage memoryStorage = this.$storage;
                    this.label = 1;
                    if (memoryEngine.backfillEmbeddingsInternal(memoryStorage, this) == aVar) {
                        return aVar;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                }
                MemoryEngine.rebuildInFlight = false;
                return a0.f883a;
            } catch (Throwable th) {
                MemoryEngine.rebuildInFlight = false;
                throw th;
            }
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine", f = "MemoryEngine.kt", l = {929, 935, 957, 961}, m = "writeCategoryMemoryToDaily", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$writeCategoryMemoryToDaily$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00401 extends h5.c {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public C00401(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryEngine.this.writeCategoryMemoryToDaily(null, null, null, this);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @h5.e(c = "com.stepos.stepclaw.memory.MemoryEngine", f = "MemoryEngine.kt", l = {969}, m = "writeCategoryMemoryToDailyRemote", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.stepclaw.memory.MemoryEngine$writeCategoryMemoryToDailyRemote$1, reason: invalid class name and case insensitive filesystem */
    public static final class C00411 extends h5.c {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public C00411(f5.c cVar) {
            super(cVar);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MemoryEngine.this.writeCategoryMemoryToDailyRemote(null, null, null, this);
        }
    }

    private MemoryEngine() {
    }

    public static /* synthetic */ void autoCapture$default(MemoryEngine memoryEngine, List list, String str, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = null;
        }
        memoryEngine.autoCapture(list, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoCapture$lambda$0() {
        return "autoCapture skipped";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoCapture$lambda$1() {
        return "autoCapture: starting";
    }

    public static /* synthetic */ String autoRecall$default(MemoryEngine memoryEngine, List list, String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str = null;
        }
        if ((i8 & 4) != 0) {
            str2 = null;
        }
        if ((i8 & 8) != 0) {
            str3 = null;
        }
        return memoryEngine.autoRecall(list, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoRecall$lambda$0() {
        return "autoRecall skipped";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoRecall$lambda$1() {
        return "autoRecall but no prompt!";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoRecall$lambda$2(String str) {
        return m0.f.c("autoRecall: ", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoRecall$lambda$3$0(Exception exc) {
        return m0.f.c("autoRecall failed: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String autoRecall$lambda$4$0(String str) {
        return "autoRecall: result=".concat(str.length() > 0 ? "found" : "empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void backfillEmbeddings$default(MemoryEngine memoryEngine, List list, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = c5.s.f1092a;
        }
        memoryEngine.backfillEmbeddings(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
    
        if (r0 == r2) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object backfillEmbeddingsInternal(com.stepos.stepclaw.memory.storage.MemoryStorage r20, f5.c r21) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.backfillEmbeddingsInternal(com.stepos.stepclaw.memory.storage.MemoryStorage, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String backfillEmbeddingsInternal$lambda$0(EmbeddingClient embeddingClient2) {
        return m0.f.d("backfill skipped: provider '", embeddingClient2.getProviderId(), "' isAvailable=false; will retry once provider becomes ready");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String backfillEmbeddingsInternal$lambda$1(List list) {
        return a8.b.k(list.size(), "initialize: backfilling ", " entries for embedding...");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String backfillEmbeddingsInternal$lambda$2(int i8) {
        return a8.b.j(i8, "initialize: embedding backfill done, wrote ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String backfillEmbeddingsInternal$lambda$3(Exception exc) {
        return m0.f.c("initialize: embedding backfill failed: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String beforeSendMessage$lambda$0(String str, String str2) {
        return a8.b.q("beforeSendMessage -> [", str, "]: [", str2, "]");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String beforeToolCall$lambda$0(String str, String str2) {
        return a8.b.q("beforeToolCall -> [", str, "]: [", str2, "]");
    }

    private final Map<String, p5.a> buildDefaultProviderRegistry() {
        b5.g[] gVarArr = {new b5.g("local-stepinfer-emb", new b(18)), new b5.g("remote-bge-m3", new b(19)), new b5.g("remote-qwen3-embedding-4b", new b(20))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(z.T(3));
        z.X(gVarArr, linkedHashMap);
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmbeddingProvider buildDefaultProviderRegistry$lambda$0() {
        return new LocalEmbeddingProvider(localInferenceEngine);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmbeddingProvider buildDefaultProviderRegistry$lambda$1(String str) {
        return new RemoteEmbeddingProvider("remote-bge-m3", "Remote SiliconFlow BAAI/bge-m3", str, c5.s.f1092a, EmbeddingClient.DEFAULT_MODEL, logger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EmbeddingProvider buildDefaultProviderRegistry$lambda$2(String str) {
        return new RemoteEmbeddingProvider("remote-qwen3-embedding-4b", "Remote SiliconFlow Qwen3-Embedding-4B", str, c5.s.f1092a, "Qwen/Qwen3-Embedding-4B", logger);
    }

    private final SearchPipeline buildSearchPipeline() {
        LightMemClient lightMemClient = client;
        MemorySearchConfig memorySearchConfig = searchConfig;
        VectorRetriever vectorRetriever2 = vectorRetriever;
        if (!memorySearchConfig.getEnableVectorRetrieval()) {
            vectorRetriever2 = null;
        }
        ArrayList arrayListD0 = c5.l.d0(new MemoryRetriever[]{bm25Retriever, vectorRetriever2});
        LocalInferenceEngine localInferenceEngine2 = localInferenceEngine;
        if (lightMemClient == null) {
            throw new IllegalStateException("LightMemClient not initialized");
        }
        StepModel stepModel = StepModel.INSTANCE;
        String modelName = stepModel.getModelName();
        String apiToken = stepModel.getApiToken();
        List<String> categories = memorySearchConfig.getCategories();
        AndroidMemoryLogger androidMemoryLogger = logger;
        return new SearchPipeline(new QueryRewriteStage(lightMemClient, modelName, apiToken, categories, androidMemoryLogger, memorySearchConfig.getMaxQueryLength(), localInferenceEngine2), new RetrievalStage(arrayListD0, memorySearchConfig.getTopKPerCategory(), memorySearchConfig.getRrfK(), androidMemoryLogger), new RerankStage(memorySearchConfig.getScoreThresholds(), memorySearchConfig.getDefaultScoreThreshold(), memorySearchConfig.getEnableHalfLifeRerank(), memorySearchConfig.getHalfLifeSMin(), memorySearchConfig.getHalfLifeSMax(), memorySearchConfig.getHalfLifeBeta(), memorySearchConfig.getMemoryFactorWeight(), androidMemoryLogger), new FormatStage(memorySearchConfig.getMaxEntries(), memorySearchConfig.getMaxFormatTokens(), memorySearchConfig.getCategoryTokenWeights(), androidMemoryLogger), androidMemoryLogger, new C00341(null));
    }

    private final void cleanupLegacyEmbeddingDirs(File baseDir, Set<String> knownProviderIds) {
        Set<String> setCleanupLegacyDirs = EmbeddingStorage.INSTANCE.cleanupLegacyDirs(baseDir, knownProviderIds);
        if (setCleanupLegacyDirs.isEmpty()) {
            return;
        }
        MemoryLogger.logI$default(logger, TAG, null, new c(8, setCleanupLegacyDirs), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String cleanupLegacyEmbeddingDirs$lambda$0(Set set) {
        return "cleanupLegacy: deleted dirs=" + set;
    }

    private final String getDailyMemoryFileName() {
        return a8.b.n(new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date()), ".md");
    }

    public static /* synthetic */ void init$default(MemoryEngine memoryEngine, Application application, LightMemClient lightMemClient, f0 f0Var, String str, boolean z, String str2, StepOSHeadersProvider stepOSHeadersProvider, int i8, Object obj) throws IOException {
        if ((i8 & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i8 & 32) != 0) {
            str2 = "local-stepinfer-emb";
        }
        memoryEngine.init(application, lightMemClient, f0Var, str, z2, str2, (i8 & 64) != 0 ? null : stepOSHeadersProvider);
    }

    private final void installEmbeddingComponents(EmbeddingProvider provider, File baseDir, f0 scope2) {
        EmbeddingClient embeddingClient2 = new EmbeddingClient(provider);
        String id = provider.getId();
        AndroidMemoryLogger androidMemoryLogger = logger;
        EmbeddingStorage embeddingStorage2 = new EmbeddingStorage(baseDir, id, androidMemoryLogger);
        EmbeddingQueue embeddingQueue2 = new EmbeddingQueue(androidMemoryLogger);
        embeddingQueue2.start(scope2, embeddingClient2, embeddingStorage2);
        embeddingClient = embeddingClient2;
        embeddingStorage = embeddingStorage2;
        embeddingQueue = embeddingQueue2;
        vectorRetriever = new VectorRetriever(embeddingClient2, embeddingStorage2, androidMemoryLogger);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeAutoTriggerEvolution(String sessionId) {
        f0 f0Var = scope;
        if (f0Var == null) {
            return;
        }
        OfflineEvolutionService offlineEvolutionService2 = offlineEvolutionService;
        if (offlineEvolutionService2 == null) {
            logger.logW(TAG, sessionId, new b(13));
        } else {
            offlineEvolutionService2.maybeAutoTrigger(f0Var, sessionId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String maybeAutoTriggerEvolution$lambda$0() {
        return "[maybeAutoTriggerEvolution] offlineEvolutionService not initialized";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeTriggerDeferredBackfill() {
        EmbeddingClient embeddingClient2;
        if (embeddingBackfillSkippedAtInit && (embeddingClient2 = embeddingClient) != null && embeddingClient2.getProvider().isAvailable()) {
            embeddingBackfillSkippedAtInit = false;
            MemoryLogger.logI$default(logger, TAG, null, new n(embeddingClient2, 0), 2, null);
            backfillEmbeddings$default(this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String maybeTriggerDeferredBackfill$lambda$0(EmbeddingClient embeddingClient2) {
        return m0.f.d("deferred backfill: provider '", embeddingClient2.getProviderId(), "' is now ready, retrying backfill");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object readStepMem$default(MemoryEngine memoryEngine, Date date, Date date2, List list, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            date = null;
        }
        if ((i8 & 2) != 0) {
            date2 = null;
        }
        if ((i8 & 4) != 0) {
            list = c5.s.f1092a;
        }
        return memoryEngine.readStepMem(date, date2, list, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object readStepMemAsString$default(MemoryEngine memoryEngine, Date date, Date date2, List list, boolean z, boolean z2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            date = null;
        }
        if ((i8 & 2) != 0) {
            date2 = null;
        }
        if ((i8 & 4) != 0) {
            list = c5.s.f1092a;
        }
        if ((i8 & 8) != 0) {
            z = false;
        }
        if ((i8 & 16) != 0) {
            z2 = true;
        }
        return memoryEngine.readStepMemAsString(date, date2, list, z, z2, cVar);
    }

    private static final String readStepMemAsString$formatContent(boolean z, String input, String str) {
        if (z) {
            Pattern patternCompile = Pattern.compile("\\r?\\n");
            kotlin.jvm.internal.p.d(patternCompile, "compile(...)");
            kotlin.jvm.internal.p.e(input, "input");
            String strReplaceAll = patternCompile.matcher(input).replaceAll(" ");
            kotlin.jvm.internal.p.d(strReplaceAll, "replaceAll(...)");
            return strReplaceAll;
        }
        Pattern patternCompile2 = Pattern.compile("\\r?\\n");
        kotlin.jvm.internal.p.d(patternCompile2, "compile(...)");
        String replacement = "\n" + str;
        kotlin.jvm.internal.p.e(input, "input");
        kotlin.jvm.internal.p.e(replacement, "replacement");
        String strReplaceAll2 = patternCompile2.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.p.d(strReplaceAll2, "replaceAll(...)");
        return strReplaceAll2;
    }

    public static /* synthetic */ String readStepMemAsString$formatContent$default(boolean z, String str, String str2, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            str2 = "  ";
        }
        return readStepMemAsString$formatContent(z, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence readStepMemAsString$lambda$2(boolean z, Map.Entry entry) {
        kotlin.jvm.internal.p.e(entry, "<destruct>");
        return a8.b.o(m0.f.c("### ", (String) entry.getKey()), "\n", c5.m.A0((List) entry.getValue(), "\n", null, null, new p(z, 0), 30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence readStepMemAsString$lambda$2$0(boolean z, MemoryRecord entry) {
        kotlin.jvm.internal.p.e(entry, "entry");
        return a8.b.n(!x5.n.t1(entry.getDate()) ? m0.f.d("[", entry.getDate(), "] ") : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, readStepMemAsString$formatContent$default(z, entry.getContent(), null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence readStepMemAsString$lambda$4(boolean z, MemoryRecord entry) {
        kotlin.jvm.internal.p.e(entry, "entry");
        boolean zT1 = x5.n.t1(entry.getDate());
        String strD = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        String strD2 = !zT1 ? m0.f.d("[", entry.getDate(), "]") : SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (!x5.n.t1(entry.getCategory())) {
            strD = m0.f.d("[", entry.getCategory(), "]");
        }
        return strD2 + strD + " " + readStepMemAsString$formatContent$default(z, entry.getContent(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportAutoRecallAfter(String sessionId, String paramsJson, String resultJson, String traceId) {
        Reporter reporter = ReporterBridge.INSTANCE.getReporter();
        if (reporter != null) {
            reporter.onToolCall(sessionId, null, "memory_search", paramsJson, resultJson, null, null, (resultJson == null || x5.n.t1(resultJson)) ? "empty" : null, ToolCallReportPhase.AFTER, null, traceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportAutoRecallBefore(String sessionId, String paramsJson, String traceId) {
        Reporter reporter = ReporterBridge.INSTANCE.getReporter();
        if (reporter != null) {
            reporter.onToolCall(sessionId, null, "memory_search", paramsJson, null, null, null, null, ToolCallReportPhase.BEFORE, null, traceId);
        }
    }

    private final EmbeddingProvider resolveInitialProvider(String requestedId) {
        Map<String, ? extends p5.a> map = providerRegistry;
        p5.a aVar = map.get(requestedId);
        if (aVar == null) {
            MemoryLogger.logW$default(logger, TAG, null, new d(requestedId, 7), 2, null);
            return (EmbeddingProvider) ((p5.a) z.S(map, "local-stepinfer-emb")).invoke();
        }
        EmbeddingProvider embeddingProvider = (EmbeddingProvider) aVar.invoke();
        if (!embeddingProvider.isAvailable()) {
            MemoryLogger.logW$default(logger, TAG, null, new d(requestedId, 3), 2, null);
        }
        return embeddingProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveInitialProvider$lambda$0(String str) {
        return m0.f.d("resolveInitialProvider: id '", str, "' not registered, falling back to local-stepinfer-emb");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resolveInitialProvider$lambda$1(String str) {
        return m0.f.d("resolveInitialProvider: '", str, "' not available right now; vector ops will be skipped (BM25-only) until it becomes ready");
    }

    public static /* synthetic */ Object runOfflineEvolutionEpisodicPipeline$default(MemoryEngine memoryEngine, String str, String str2, f5.c cVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = null;
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        return memoryEngine.runOfflineEvolutionEpisodicPipeline(str, str2, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String runOfflineEvolutionEpisodicPipeline$lambda$0() {
        return "[runOfflineEvolutionEpisodicPipeline] offlineEvolutionService not initialized";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String switchEmbeddingProvider$lambda$0$0(String str) {
        return m0.f.d("switchEmbeddingProvider: already active=", str, ", no-op");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String switchEmbeddingProvider$lambda$0$1(String str, String str2) {
        return a8.b.p("switchEmbeddingProvider: ", str, " -> ", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String switchEmbeddingProvider$lambda$0$2(File file, boolean z) {
        return "switchEmbeddingProvider: previous dir " + file.getName() + " deleted=" + z;
    }

    private final void triggerRebuildAfterSwitch(f0 scope2) {
        MemoryStorage memoryStorage2 = memoryStorage;
        if (memoryStorage2 == null) {
            return;
        }
        rebuildInFlight = true;
        h6.e eVar = r0.f210a;
        i0.q(scope2, h6.d.f3059c, new C00391(memoryStorage2, null), 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateEmbeddingConfig$default(MemoryEngine memoryEngine, String str, String str2, List list, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        if ((i8 & 4) != 0) {
            list = c5.s.f1092a;
        }
        if ((i8 & 8) != 0) {
            str3 = EmbeddingClient.DEFAULT_MODEL;
        }
        memoryEngine.updateEmbeddingConfig(str, str2, list, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateEmbeddingConfig$lambda$0() {
        return "updateEmbeddingConfig ignored: embedding feature not initialized";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String updateEmbeddingConfig$lambda$1(EmbeddingClient embeddingClient2) {
        return m0.f.d("updateEmbeddingConfig ignored: active provider '", embeddingClient2.getProviderId(), "' is not a remote provider; use switchEmbeddingProvider");
    }

    private final void validateProviderRegistry(Map<String, ? extends p5.a> registry) {
        if (registry.isEmpty()) {
            throw new IllegalArgumentException("EmbeddingProvider registry must not be empty");
        }
        for (String str : registry.keySet()) {
            if (RESERVED_CATEGORY_NAMES.contains(str)) {
                throw new IllegalArgumentException(m0.f.d("EmbeddingProvider id '", str, "' collides with reserved memory category name").toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01af, code lost:
    
        if (r0 == r10) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e5 A[Catch: Exception -> 0x0171, TryCatch #6 {Exception -> 0x0171, blocks: (B:36:0x00e1, B:38:0x00e5, B:40:0x00e9), top: B:95:0x00e1 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: Exception -> 0x0163, TRY_LEAVE, TryCatch #5 {Exception -> 0x0163, blocks: (B:47:0x012a, B:50:0x0136, B:54:0x0142, B:56:0x014a), top: B:93:0x012a }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeCategoryMemoryToDaily(java.lang.String r27, com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem r28, java.lang.String r29, f5.c r30) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.writeCategoryMemoryToDaily(java.lang.String, com.stepos.stepclaw.memory.lightmem.remote.CatchMemoryItem, java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeCategoryMemoryToDaily$lambda$2(String str, CatchMemoryItem catchMemoryItem) {
        return a8.b.q("writeMemory: category=", str, ", content=", AndroidMemoryLogger.INSTANCE.escapeForLog(catchMemoryItem.getContent()), ", ok=true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeCategoryMemoryToDaily$lambda$3(Exception exc) {
        return m0.f.c("writeMemory failed, fallback to remote: ", exc.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeCategoryMemoryToDailyRemote(java.lang.String r15, java.lang.String r16, java.lang.String r17, f5.c r18) {
        /*
            r14 = this;
            r0 = r18
            java.lang.String r1 = "stepmem/"
            boolean r2 = r0 instanceof com.stepos.stepclaw.memory.MemoryEngine.C00411
            if (r2 == 0) goto L18
            r2 = r0
            com.stepos.stepclaw.memory.MemoryEngine$writeCategoryMemoryToDailyRemote$1 r2 = (com.stepos.stepclaw.memory.MemoryEngine.C00411) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L18
            int r3 = r3 - r4
            r2.label = r3
        L16:
            r10 = r2
            goto L1e
        L18:
            com.stepos.stepclaw.memory.MemoryEngine$writeCategoryMemoryToDailyRemote$1 r2 = new com.stepos.stepclaw.memory.MemoryEngine$writeCategoryMemoryToDailyRemote$1
            r2.<init>(r0)
            goto L16
        L1e:
            java.lang.Object r0 = r10.result
            g5.a r2 = g5.a.f2984a
            int r3 = r10.label
            java.lang.String r13 = "MemoryEngine"
            r4 = 1
            if (r3 == 0) goto L4a
            if (r3 != r4) goto L42
            java.lang.Object r14 = r10.L$3
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r10.L$2
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r1 = r10.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r1 = r10.L$0
            java.lang.String r1 = (java.lang.String) r1
            a.a.c0(r0)     // Catch: java.lang.Exception -> L3f
            goto L86
        L3f:
            r0 = move-exception
        L40:
            r14 = r0
            goto L9c
        L42:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L4a:
            a.a.c0(r0)
            java.lang.String r14 = r14.getDailyMemoryFileName()     // Catch: java.lang.Exception -> L98
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L98
            r0.<init>(r1)     // Catch: java.lang.Exception -> L98
            r0.append(r15)     // Catch: java.lang.Exception -> L98
            java.lang.String r15 = "/"
            r0.append(r15)     // Catch: java.lang.Exception -> L98
            r0.append(r14)     // Catch: java.lang.Exception -> L98
            java.lang.String r14 = r0.toString()     // Catch: java.lang.Exception -> L98
            com.stepos.stepclaw.openclaw.memory.MemoryTools r3 = com.stepos.stepclaw.openclaw.memory.MemoryTools.INSTANCE     // Catch: java.lang.Exception -> L98
            r15 = 0
            r10.L$0 = r15     // Catch: java.lang.Exception -> L98
            r10.L$1 = r15     // Catch: java.lang.Exception -> L98
            r15 = r17
            r10.L$2 = r15     // Catch: java.lang.Exception -> L3f
            r10.L$3 = r14     // Catch: java.lang.Exception -> L3f
            r10.label = r4     // Catch: java.lang.Exception -> L3f
            r6 = 0
            r8 = 0
            r11 = 12
            r12 = 0
            r4 = r14
            r5 = r16
            java.lang.Object r0 = com.stepos.stepclaw.openclaw.memory.MemoryTools.fsAppendMmr$default(r3, r4, r5, r6, r8, r10, r11, r12)     // Catch: java.lang.Exception -> L3f
            if (r0 != r2) goto L85
            return r2
        L85:
            r14 = r4
        L86:
            com.stepos.stepclaw.openclaw.memory.FsAppendMmrResult r0 = (com.stepos.stepclaw.openclaw.memory.FsAppendMmrResult) r0     // Catch: java.lang.Exception -> L3f
            com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r1 = com.stepos.stepclaw.memory.MemoryEngine.logger     // Catch: java.lang.Exception -> L3f
            com.stepos.stepclaw.memory.t r2 = new com.stepos.stepclaw.memory.t     // Catch: java.lang.Exception -> L3f
            r3 = 2
            r2.<init>(r14, r3, r0)     // Catch: java.lang.Exception -> L3f
            r1.logD(r13, r15, r2)     // Catch: java.lang.Exception -> L3f
            boolean r14 = r0.getOk()     // Catch: java.lang.Exception -> L3f
            goto La8
        L98:
            r0 = move-exception
            r15 = r17
            goto L40
        L9c:
            com.stepos.stepclaw.memory.utils.AndroidMemoryLogger r0 = com.stepos.stepclaw.memory.MemoryEngine.logger
            com.stepos.stepclaw.memory.k r1 = new com.stepos.stepclaw.memory.k
            r2 = 5
            r1.<init>(r14, r2)
            r0.logW(r13, r15, r1)
            r14 = 0
        La8:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.writeCategoryMemoryToDailyRemote(java.lang.String, java.lang.String, java.lang.String, f5.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeCategoryMemoryToDailyRemote$lambda$0(String str, FsAppendMmrResult fsAppendMmrResult) {
        return "writeCategoryMemoryToDaily (remote): path=" + str + ", ok=" + fsAppendMmrResult.getOk() + ", appended=" + fsAppendMmrResult.getAppendedCount() + ", skipped=" + fsAppendMmrResult.getSkippedCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String writeCategoryMemoryToDailyRemote$lambda$1(Exception exc) {
        return m0.f.c("writeCategoryMemoryToDaily (remote) failed: ", exc.getMessage());
    }

    public final String activeEmbeddingProviderId() {
        EmbeddingClient embeddingClient2 = embeddingClient;
        if (embeddingClient2 != null) {
            return embeddingClient2.getProviderId();
        }
        return null;
    }

    public final void autoCapture(List<MessageItem> messages, String sessionId) {
        f0 f0Var;
        kotlin.jvm.internal.p.e(messages, "messages");
        if (!autoRecallCaptureEnabled) {
            logger.logD(TAG, sessionId, new b(15));
            return;
        }
        LightMemClient lightMemClient = client;
        if (lightMemClient == null || (f0Var = scope) == null) {
            return;
        }
        logger.logD(TAG, sessionId, new b(16));
        h6.e eVar = r0.f210a;
        i0.q(f0Var, h6.d.f3059c, new AnonymousClass3(sessionId, lightMemClient, messages, null), 2);
    }

    public final String autoRecall(List<MessageItem> messages, String prompt, String sessionId, String traceId) {
        String str;
        f5.i iVar = f5.i.f2626a;
        kotlin.jvm.internal.p.e(messages, "messages");
        boolean z = autoRecallCaptureEnabled;
        String strConcat = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        if (!z) {
            logger.logD(TAG, sessionId, new b(11));
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        ArrayList arrayListO0 = c5.m.O0(messages);
        if (prompt == null || x5.n.t1(prompt)) {
            MemoryLogger.logE$default(logger, TAG, sessionId, null, new b(12), 4, null);
            return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        arrayListO0.add(new MessageItem("user", prompt, (String) null, 4, (kotlin.jvm.internal.i) null));
        logger.logD(TAG, sessionId, new d(prompt, 4));
        PerfTrace perfTrace = PerfTrace.INSTANCE;
        if (perfTrace.getEnabled()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                str = (String) i0.u(iVar, new MemoryEngine$autoRecall$4$1(sessionId, prompt, traceId, arrayListO0, null));
            } catch (Exception e9) {
                logger.logW(TAG, sessionId, new k(e9, 4));
                str = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
            }
            if (sessionId != null) {
                strConcat = " | traceId=".concat(sessionId);
            }
            MemoryLogger logger2 = perfTrace.getLogger();
            if (logger2 != null) {
                logger2.logD(TAG, sessionId, new PerfTrace.AnonymousClass1("[MEMORY] autoRecall", jCurrentTimeMillis, strConcat));
            }
            strConcat = str;
        } else {
            try {
                strConcat = (String) i0.u(iVar, new MemoryEngine$autoRecall$4$1(sessionId, prompt, traceId, arrayListO0, null));
            } catch (Exception e10) {
                logger.logW(TAG, sessionId, new k(e10, 4));
            }
        }
        logger.logD(TAG, sessionId, new d(strConcat, 5));
        return strConcat;
    }

    public final void backfillEmbeddings(List<String> categories) {
        MemoryStorage memoryStorage2;
        EmbeddingStorage embeddingStorage2;
        EmbeddingClient embeddingClient2;
        Set<String> permanentCategories;
        TieredCacheConfig cacheConfig;
        kotlin.jvm.internal.p.e(categories, "categories");
        f0 f0Var = scope;
        if (f0Var == null || (memoryStorage2 = memoryStorage) == null || (embeddingStorage2 = embeddingStorage) == null || (embeddingClient2 = embeddingClient) == null) {
            return;
        }
        MemoryIndexManager memoryIndexManager = indexManager;
        if (memoryIndexManager == null || (cacheConfig = memoryIndexManager.getCacheConfig()) == null || (permanentCategories = cacheConfig.getPermanentCategories()) == null) {
            permanentCategories = c5.u.f1094a;
        }
        Set<String> set = permanentCategories;
        h6.e eVar = r0.f210a;
        i0.q(f0Var, h6.d.f3059c, new AnonymousClass1(memoryStorage2, categories, embeddingStorage2, embeddingClient2, set, null), 2);
    }

    public final void beforeSendMessage(String message, String sessionKey, p5.a historyProvider) {
        kotlin.jvm.internal.p.e(message, "message");
        kotlin.jvm.internal.p.e(sessionKey, "sessionKey");
        kotlin.jvm.internal.p.e(historyProvider, "historyProvider");
        MemoryLogger.logI$default(logger, TAG, null, new o(sessionKey, message, 0), 2, null);
    }

    public final void beforeToolCall(String toolName, String argsJson) {
        kotlin.jvm.internal.p.e(toolName, "toolName");
        MemoryLogger.logI$default(logger, TAG, null, new o(toolName, argsJson, 1), 2, null);
    }

    public final Object forceUploadMemories(f5.c cVar) {
        MemoryUploadService memoryUploadService = uploadService;
        if (memoryUploadService == null) {
            return null;
        }
        Object objUploadAll = memoryUploadService.uploadAll(cVar);
        return objUploadAll == g5.a.f2984a ? objUploadAll : (UploadBatchResult) objUploadAll;
    }

    public final boolean getAutoRecallCaptureEnabled() {
        return autoRecallCaptureEnabled;
    }

    public final BM25Retriever getDumpBm25Retriever$step_memory_release() {
        return bm25Retriever;
    }

    public final LightMemClient getDumpClient$step_memory_release() {
        return client;
    }

    public final EmbeddingClient getDumpEmbeddingClient$step_memory_release() {
        return embeddingClient;
    }

    public final EmbeddingStorage getDumpEmbeddingStorage$step_memory_release() {
        return embeddingStorage;
    }

    public final MemoryIndexManager getDumpIndexManager$step_memory_release() {
        return indexManager;
    }

    public final LocalInferenceEngine getDumpLocalInferenceEngine$step_memory_release() {
        return localInferenceEngine;
    }

    public final AndroidMemoryLogger getDumpLogger$step_memory_release() {
        return logger;
    }

    public final OfflineEvolutionService getDumpOfflineEvolutionService$step_memory_release() {
        return offlineEvolutionService;
    }

    public final f0 getDumpScope$step_memory_release() {
        return scope;
    }

    public final SearchPipeline getDumpSearchPipeline$step_memory_release() {
        return searchPipeline;
    }

    public final MemoryStorage getDumpStorage$step_memory_release() {
        return memoryStorage;
    }

    public final File getDumpStorageRoot$step_memory_release() {
        return memoryStorageRoot;
    }

    public final MemoryUploadService getDumpUploadService$step_memory_release() {
        return uploadService;
    }

    public final boolean getRebuildInFlight() {
        return rebuildInFlight;
    }

    public final MemorySearchConfig getSearchConfig() {
        return searchConfig;
    }

    public final List<String> getStepMemCategories() {
        List<String> categories;
        MemoryStorage memoryStorage2 = memoryStorage;
        return (memoryStorage2 == null || (categories = memoryStorage2.getCategories()) == null) ? c5.s.f1092a : categories;
    }

    public final void init(Application application, LightMemClient client2, f0 scope2, String baseDir, boolean enableVectorFeature, String defaultEmbeddingProviderId, StepOSHeadersProvider headersProvider2) throws IOException {
        kotlin.jvm.internal.p.e(application, "application");
        kotlin.jvm.internal.p.e(client2, "client");
        kotlin.jvm.internal.p.e(scope2, "scope");
        kotlin.jvm.internal.p.e(baseDir, "baseDir");
        kotlin.jvm.internal.p.e(defaultEmbeddingProviderId, "defaultEmbeddingProviderId");
        client = client2;
        scope = scope2;
        headersProvider = headersProvider2;
        i0.q(scope2, null, new C00351(application, null), 3);
        PerfTrace perfTrace = PerfTrace.INSTANCE;
        AndroidMemoryLogger androidMemoryLogger = logger;
        perfTrace.setLogger(androidMemoryLogger);
        File file = new File(baseDir);
        memoryStorageRoot = file;
        embeddingBaseDir = file;
        MemoryStorage memoryStorage2 = new MemoryStorage(file, androidMemoryLogger);
        memoryStorage = memoryStorage2;
        memoryStorage2.migrateAgentToAgentIdentity();
        MemoryIndexManager memoryIndexManager = new MemoryIndexManager(file, memoryStorage2.getFileManager(), null, null, androidMemoryLogger, 12, null);
        indexManager = memoryIndexManager;
        bm25Retriever = new BM25Retriever(memoryIndexManager, androidMemoryLogger);
        if (enableVectorFeature) {
            Map<String, p5.a> mapBuildDefaultProviderRegistry = buildDefaultProviderRegistry();
            providerRegistry = mapBuildDefaultProviderRegistry;
            validateProviderRegistry(mapBuildDefaultProviderRegistry);
            cleanupLegacyEmbeddingDirs(file, providerRegistry.keySet());
            installEmbeddingComponents(resolveInitialProvider(defaultEmbeddingProviderId), file, scope2);
        }
        searchPipeline = buildSearchPipeline();
        offlineEvolutionService = new OfflineEvolutionService(client2, memoryStorage2, memoryIndexManager, file, androidMemoryLogger, new b(17), embeddingStorage);
        i0.q(scope2, h6.d.f3059c, new C00363(memoryStorage2, memoryIndexManager, headersProvider2, file, null), 2);
    }

    public final boolean isActiveEmbeddingProviderAvailable() {
        EmbeddingProvider provider;
        EmbeddingClient embeddingClient2 = embeddingClient;
        if (embeddingClient2 == null || (provider = embeddingClient2.getProvider()) == null) {
            return false;
        }
        return provider.isAvailable();
    }

    public final List<String> listEmbeddingProviderIds() {
        return c5.m.N0(providerRegistry.keySet());
    }

    public final Object readStepMem(Date date, Date date2, List<String> list, f5.c cVar) {
        MemoryStorage memoryStorage2 = memoryStorage;
        if (memoryStorage2 == null) {
            return c5.s.f1092a;
        }
        return memoryStorage2.readEntries(date != null ? MemoryFile.INSTANCE.getDATE_FORMAT().format(date) : null, date2 != null ? MemoryFile.INSTANCE.getDATE_FORMAT().format(date2) : null, list, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object readStepMemAsString(java.util.Date r7, java.util.Date r8, java.util.List<java.lang.String> r9, boolean r10, boolean r11, f5.c r12) {
        /*
            r6 = this;
            boolean r0 = r12 instanceof com.stepos.stepclaw.memory.MemoryEngine.C00371
            if (r0 == 0) goto L13
            r0 = r12
            com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$1 r0 = (com.stepos.stepclaw.memory.MemoryEngine.C00371) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$1 r0 = new com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            g5.a r1 = g5.a.f2984a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r11 = r0.Z$1
            boolean r10 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r6 = r0.L$1
            java.util.Date r6 = (java.util.Date) r6
            java.lang.Object r6 = r0.L$0
            java.util.Date r6 = (java.util.Date) r6
            a.a.c0(r12)
            goto L56
        L37:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3f:
            a.a.c0(r12)
            r12 = 0
            r0.L$0 = r12
            r0.L$1 = r12
            r0.L$2 = r12
            r0.Z$0 = r10
            r0.Z$1 = r11
            r0.label = r3
            java.lang.Object r12 = r6.readStepMem(r7, r8, r9, r0)
            if (r12 != r1) goto L56
            return r1
        L56:
            java.util.List r12 = (java.util.List) r12
            boolean r6 = r12.isEmpty()
            if (r6 == 0) goto L61
            java.lang.String r6 = ""
            return r6
        L61:
            if (r10 == 0) goto Laf
            com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$$inlined$sortedByDescending$1 r6 = new com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$$inlined$sortedByDescending$1
            r6.<init>()
            java.util.List r6 = c5.m.J0(r12, r6)
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Iterator r6 = r6.iterator()
        L75:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L9a
            java.lang.Object r8 = r6.next()
            r9 = r8
            com.stepos.stepclaw.memory.storage.file.MemoryRecord r9 = (com.stepos.stepclaw.memory.storage.file.MemoryRecord) r9
            java.lang.String r9 = r9.getCategory()
            java.lang.Object r10 = r7.get(r9)
            if (r10 != 0) goto L94
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r7.put(r9, r10)
        L94:
            java.util.List r10 = (java.util.List) r10
            r10.add(r8)
            goto L75
        L9a:
            java.util.Set r0 = r7.entrySet()
            com.stepos.stepclaw.memory.p r4 = new com.stepos.stepclaw.memory.p
            r6 = 1
            r4.<init>(r11, r6)
            r5 = 30
            java.lang.String r1 = "\n\n"
            r2 = 0
            r3 = 0
            java.lang.String r6 = c5.m.A0(r0, r1, r2, r3, r4, r5)
            return r6
        Laf:
            com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$$inlined$sortedByDescending$2 r6 = new com.stepos.stepclaw.memory.MemoryEngine$readStepMemAsString$$inlined$sortedByDescending$2
            r6.<init>()
            java.util.List r0 = c5.m.J0(r12, r6)
            com.stepos.stepclaw.memory.p r4 = new com.stepos.stepclaw.memory.p
            r6 = 2
            r4.<init>(r11, r6)
            r5 = 30
            java.lang.String r1 = "\n"
            r2 = 0
            r3 = 0
            java.lang.String r6 = c5.m.A0(r0, r1, r2, r3, r4, r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.readStepMemAsString(java.util.Date, java.util.Date, java.util.List, boolean, boolean, f5.c):java.lang.Object");
    }

    public final void rebuildSearchPipeline$step_memory_release() {
        if (bm25Retriever != null) {
            searchPipeline = buildSearchPipeline();
        }
    }

    public final Object runOfflineEvolutionEpisodicPipeline(String str, String str2, f5.c cVar) {
        OfflineEvolutionService offlineEvolutionService2 = offlineEvolutionService;
        if (offlineEvolutionService2 != null) {
            return offlineEvolutionService2.runPipeline(str, str2, cVar);
        }
        logger.logW(TAG, str, new b(14));
        return null;
    }

    public final void setAutoRecallCaptureEnabled(boolean z) {
        autoRecallCaptureEnabled = z;
    }

    public final void setDebug(boolean debug) {
        AndroidMemoryLogger androidMemoryLogger = logger;
        androidMemoryLogger.setDebugEnable(debug);
        androidMemoryLogger.setPersistEnabled(debug);
        PerfTrace.INSTANCE.setEnabled(debug);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r13v12, types: [i6.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object switchEmbeddingProvider(java.lang.String r13, f5.c r14) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.stepclaw.memory.MemoryEngine.switchEmbeddingProvider(java.lang.String, f5.c):java.lang.Object");
    }

    public final void updateBaseUrl(String newUrl) {
        kotlin.jvm.internal.p.e(newUrl, "newUrl");
        LightMemClient lightMemClient = client;
        if (lightMemClient != null) {
            lightMemClient.updateBaseUrl(newUrl);
        }
    }

    public final void updateEmbeddingConfig(String baseUrl, String apiKey, List<String> apiKeys, String model) {
        kotlin.jvm.internal.p.e(baseUrl, "baseUrl");
        kotlin.jvm.internal.p.e(apiKey, "apiKey");
        kotlin.jvm.internal.p.e(apiKeys, "apiKeys");
        kotlin.jvm.internal.p.e(model, "model");
        EmbeddingClient embeddingClient2 = embeddingClient;
        if (embeddingClient2 == null) {
            MemoryLogger.logW$default(logger, TAG, null, new b(21), 2, null);
            return;
        }
        if (!(embeddingClient2.getProvider() instanceof RemoteEmbeddingProvider)) {
            MemoryLogger.logW$default(logger, TAG, null, new n(embeddingClient2, 2), 2, null);
            return;
        }
        embeddingClient2.updateBaseUrl(baseUrl);
        if (!apiKeys.isEmpty()) {
            embeddingClient2.updateApiKeys(apiKeys);
        } else if (!x5.n.t1(apiKey)) {
            embeddingClient2.updateApiKey(apiKey);
        }
        if (x5.n.t1(model)) {
            return;
        }
        embeddingClient2.updateModel(model);
    }

    public final void updateSearchConfig(MemorySearchConfig config) {
        kotlin.jvm.internal.p.e(config, "config");
        searchConfig = config;
        if (bm25Retriever != null) {
            searchPipeline = buildSearchPipeline();
        }
    }

    public final void updateSearchScoreThresholds(Map<String, Float> thresholds) {
        kotlin.jvm.internal.p.e(thresholds, "thresholds");
        MemorySearchConfig memorySearchConfig = searchConfig;
        updateSearchConfig(memorySearchConfig.copy((31743 & 1) != 0 ? memorySearchConfig.categories : null, (31743 & 2) != 0 ? memorySearchConfig.maxQueryLength : 0, (31743 & 4) != 0 ? memorySearchConfig.topKPerCategory : 0, (31743 & 8) != 0 ? memorySearchConfig.rrfK : 0, (31743 & 16) != 0 ? memorySearchConfig.enableVectorRetrieval : false, (31743 & 32) != 0 ? memorySearchConfig.enableHalfLifeRerank : false, (31743 & 64) != 0 ? memorySearchConfig.halfLifeSMin : 0.0d, (31743 & 128) != 0 ? memorySearchConfig.halfLifeSMax : 0.0d, (31743 & 256) != 0 ? memorySearchConfig.halfLifeBeta : 0.0d, (31743 & 512) != 0 ? memorySearchConfig.memoryFactorWeight : 0.0d, (31743 & 1024) != 0 ? memorySearchConfig.scoreThresholds : thresholds, (31743 & 2048) != 0 ? memorySearchConfig.defaultScoreThreshold : 0.0f, (31743 & 4096) != 0 ? memorySearchConfig.maxEntries : 0, (31743 & 8192) != 0 ? memorySearchConfig.maxFormatTokens : 0, (31743 & ReaderJsonLexerKt.BATCH_SIZE) != 0 ? memorySearchConfig.categoryTokenWeights : null));
    }
}
