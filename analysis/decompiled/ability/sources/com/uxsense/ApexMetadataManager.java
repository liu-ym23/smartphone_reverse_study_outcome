package com.uxsense;

import C7.r;
import S7.n;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.core.JsonPointer;
import com.uxsense.base.parse.ParseRule;
import com.uxsense.core.ApexMetadataFileManager;
import com.uxsense.core.base.parse.KViewNode;
import com.uxsense.file.FileStorageManager;
import com.uxsense.parse.MetadataParseResult;
import com.uxsense.user.AccountEntry;
import com.uxsense.utils.ALog;
import com.uxsense.utils.LockFreeSnowflakeGenerator;
import j9.m;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.flow.i;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import m9.r0;
import p9.j;
import p9.t;
import z2.l;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003UVWB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jñ\u0001\u0010\"\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b%\u0010&J\u0015\u0010'\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b'\u0010&J\r\u0010(\u001a\u00020 ¢\u0006\u0004\b(\u0010\u0003J\u0015\u0010)\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*J\u0019\u0010+\u001a\u00020 2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b+\u0010&J.\u0010.\u001a\u00020 2\u0006\u0010-\u001a\u00020,2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eH\u0082@¢\u0006\u0004\b.\u0010/J.\u00100\u001a\u00020 2\u0006\u0010-\u001a\u00020,2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001eH\u0082@¢\u0006\u0004\b0\u0010/J \u00103\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00062\u0006\u00102\u001a\u000201H\u0082@¢\u0006\u0004\b3\u00104J \u00106\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00062\u0006\u00105\u001a\u000201H\u0082@¢\u0006\u0004\b6\u00104J\u0018\u00108\u001a\u00020\f2\u0006\u00107\u001a\u000201H\u0082@¢\u0006\u0004\b8\u00109J\u0018\u0010:\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010?\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010B\u001a\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010E\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020H0G8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u001d\u0010L\u001a\b\u0012\u0004\u0012\u00020H0K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR0\u0010S\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00180Qj\b\u0012\u0004\u0012\u00020\u0018`R0P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010T¨\u0006X"}, d2 = {"Lcom/uxsense/ApexMetadataManager;", "", AppAgent.CONSTRUCT, "()V", "", "androidUserId", "", "packageName", "activityClassName", "windowTitle", "Lcom/uxsense/core/base/parse/KViewNode;", "root", "", "parseNow", "nickname", "uuid", "", "userId", "screenshotPath", "autoSave", "creationId", "chatId", "senderId", "rootCommentId", "Lcom/uxsense/user/AccountEntry;", "account", "", "Lcom/uxsense/base/parse/ParseRule;", "rules", "creationSubDirs", "Lkotlin/Function1;", "Lcom/uxsense/ApexMetadataManager$CaptureResult;", "LC7/r;", "callback", "capture", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/uxsense/core/base/parse/KViewNode;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lcom/uxsense/user/AccountEntry;Ljava/util/List;Ljava/util/List;LS7/k;)V", "appName", "parseApp", "(Ljava/lang/String;)V", "parseUser", "parseAll", "getCacheFileCount", "(Ljava/lang/String;)I", "clearCache", "Lcom/uxsense/base/parse/ParseCache;", "parseCache", "parseAndCallback", "(Lcom/uxsense/base/parse/ParseCache;LS7/k;LH7/c;)Ljava/lang/Object;", "saveCacheAndCallback", "Ljava/nio/file/Path;", "appRoot", "parseAppInternal", "(Ljava/lang/String;Ljava/nio/file/Path;LH7/c;)Ljava/lang/Object;", "cacheDir", "parseCacheDir", "cacheFile", "parseCacheFile", "(Ljava/nio/file/Path;LH7/c;)Ljava/lang/Object;", "clearAppCache", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "TAG", "Ljava/lang/String;", "Lm9/z;", "scope", "Lm9/z;", "Lcom/uxsense/file/FileStorageManager;", "storage", "Lcom/uxsense/file/FileStorageManager;", "Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "accountIdGenerator", "Lcom/uxsense/utils/LockFreeSnowflakeGenerator;", "Lp9/j;", "Lcom/uxsense/ApexMetadataManager$ParseState;", "_parseState", "Lp9/j;", "Lp9/t;", "parseState", "Lp9/t;", "getParseState", "()Lp9/t;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "accountCache", "Ljava/util/Map;", "CaptureResult", "ParseState", "ParseError", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApexMetadataManager {
    public static final ApexMetadataManager INSTANCE = new ApexMetadataManager();
    private static final String TAG = "ApexMetadataManager";
    private static final j _parseState;
    private static final Map<String, HashSet<AccountEntry>> accountCache;
    private static final LockFreeSnowflakeGenerator accountIdGenerator;
    private static final t parseState;
    private static final InterfaceC1733z scope;
    private static final FileStorageManager storage;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/uxsense/ApexMetadataManager$CaptureResult;", "", AppAgent.CONSTRUCT, "()V", "Success", "Error", "Cached", "Lcom/uxsense/ApexMetadataManager$CaptureResult$Cached;", "Lcom/uxsense/ApexMetadataManager$CaptureResult$Error;", "Lcom/uxsense/ApexMetadataManager$CaptureResult$Success;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class CaptureResult {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/uxsense/ApexMetadataManager$CaptureResult$Cached;", "Lcom/uxsense/ApexMetadataManager$CaptureResult;", "cacheFile", "Ljava/nio/file/Path;", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;)V", "getCacheFile", "()Ljava/nio/file/Path;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Cached extends CaptureResult {
            private final Path cacheFile;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Cached(Path cacheFile) {
                super(null);
                k.f(cacheFile, "cacheFile");
                this.cacheFile = cacheFile;
            }

            public static /* synthetic */ Cached copy$default(Cached cached, Path path, int i, Object obj) {
                if ((i & 1) != 0) {
                    path = cached.cacheFile;
                }
                return cached.copy(path);
            }

            /* renamed from: component1, reason: from getter */
            public final Path getCacheFile() {
                return this.cacheFile;
            }

            public final Cached copy(Path cacheFile) {
                k.f(cacheFile, "cacheFile");
                return new Cached(cacheFile);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Cached) && k.b(this.cacheFile, ((Cached) other).cacheFile);
            }

            public final Path getCacheFile() {
                return this.cacheFile;
            }

            public int hashCode() {
                return this.cacheFile.hashCode();
            }

            public String toString() {
                return "Cached(cacheFile=" + this.cacheFile + ')';
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/uxsense/ApexMetadataManager$CaptureResult$Error;", "Lcom/uxsense/ApexMetadataManager$CaptureResult;", "message", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/Exception;)V", "getMessage", "()Ljava/lang/String;", "getException", "()Ljava/lang/Exception;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error extends CaptureResult {
            private final Exception exception;
            private final String message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String message, Exception exc) {
                super(null);
                k.f(message, "message");
                this.message = message;
                this.exception = exc;
            }

            public static /* synthetic */ Error copy$default(Error error, String str, Exception exc, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = error.message;
                }
                if ((i & 2) != 0) {
                    exc = error.exception;
                }
                return error.copy(str, exc);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            /* renamed from: component2, reason: from getter */
            public final Exception getException() {
                return this.exception;
            }

            public final Error copy(String message, Exception exception) {
                k.f(message, "message");
                return new Error(message, exception);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return k.b(this.message, error.message) && k.b(this.exception, error.exception);
            }

            public final Exception getException() {
                return this.exception;
            }

            public final String getMessage() {
                return this.message;
            }

            public int hashCode() {
                int iHashCode = this.message.hashCode() * 31;
                Exception exc = this.exception;
                return iHashCode + (exc == null ? 0 : exc.hashCode());
            }

            public String toString() {
                return "Error(message=" + this.message + ", exception=" + this.exception + ')';
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/uxsense/ApexMetadataManager$CaptureResult$Success;", "Lcom/uxsense/ApexMetadataManager$CaptureResult;", "metadata", "", "Lcom/uxsense/parse/MetadataParseResult;", AppAgent.CONSTRUCT, "(Ljava/util/List;)V", "getMetadata", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success extends CaptureResult {
            private final List<MetadataParseResult> metadata;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(List<MetadataParseResult> metadata) {
                super(null);
                k.f(metadata, "metadata");
                this.metadata = metadata;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = success.metadata;
                }
                return success.copy(list);
            }

            public final List<MetadataParseResult> component1() {
                return this.metadata;
            }

            public final Success copy(List<MetadataParseResult> metadata) {
                k.f(metadata, "metadata");
                return new Success(metadata);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && k.b(this.metadata, ((Success) other).metadata);
            }

            public final List<MetadataParseResult> getMetadata() {
                return this.metadata;
            }

            public int hashCode() {
                return this.metadata.hashCode();
            }

            public String toString() {
                return B7.a.r(new StringBuilder("Success(metadata="), this.metadata, ')');
            }
        }

        public /* synthetic */ CaptureResult(kotlin.jvm.internal.e eVar) {
            this();
        }

        private CaptureResult() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/uxsense/ApexMetadataManager$ParseError;", "", "cacheFile", "Ljava/nio/file/Path;", "reason", "", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", AppAgent.CONSTRUCT, "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Exception;)V", "getCacheFile", "()Ljava/nio/file/Path;", "getReason", "()Ljava/lang/String;", "getException", "()Ljava/lang/Exception;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ParseError {
        private final Path cacheFile;
        private final Exception exception;
        private final String reason;

        public ParseError(Path cacheFile, String reason, Exception exc) {
            k.f(cacheFile, "cacheFile");
            k.f(reason, "reason");
            this.cacheFile = cacheFile;
            this.reason = reason;
            this.exception = exc;
        }

        public static /* synthetic */ ParseError copy$default(ParseError parseError, Path path, String str, Exception exc, int i, Object obj) {
            if ((i & 1) != 0) {
                path = parseError.cacheFile;
            }
            if ((i & 2) != 0) {
                str = parseError.reason;
            }
            if ((i & 4) != 0) {
                exc = parseError.exception;
            }
            return parseError.copy(path, str, exc);
        }

        /* renamed from: component1, reason: from getter */
        public final Path getCacheFile() {
            return this.cacheFile;
        }

        /* renamed from: component2, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: component3, reason: from getter */
        public final Exception getException() {
            return this.exception;
        }

        public final ParseError copy(Path cacheFile, String reason, Exception exception) {
            k.f(cacheFile, "cacheFile");
            k.f(reason, "reason");
            return new ParseError(cacheFile, reason, exception);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParseError)) {
                return false;
            }
            ParseError parseError = (ParseError) other;
            return k.b(this.cacheFile, parseError.cacheFile) && k.b(this.reason, parseError.reason) && k.b(this.exception, parseError.exception);
        }

        public final Path getCacheFile() {
            return this.cacheFile;
        }

        public final Exception getException() {
            return this.exception;
        }

        public final String getReason() {
            return this.reason;
        }

        public int hashCode() {
            int iC = B7.a.c(this.cacheFile.hashCode() * 31, 31, this.reason);
            Exception exc = this.exception;
            return iC + (exc == null ? 0 : exc.hashCode());
        }

        public String toString() {
            return "ParseError(cacheFile=" + this.cacheFile + ", reason=" + this.reason + ", exception=" + this.exception + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/uxsense/ApexMetadataManager$ParseState;", "", AppAgent.CONSTRUCT, "()V", "Idle", "Parsing", "Completed", "Lcom/uxsense/ApexMetadataManager$ParseState$Completed;", "Lcom/uxsense/ApexMetadataManager$ParseState$Idle;", "Lcom/uxsense/ApexMetadataManager$ParseState$Parsing;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ParseState {

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/uxsense/ApexMetadataManager$ParseState$Completed;", "Lcom/uxsense/ApexMetadataManager$ParseState;", "successCount", "", "failedCount", "errors", "", "Lcom/uxsense/ApexMetadataManager$ParseError;", AppAgent.CONSTRUCT, "(IILjava/util/List;)V", "getSuccessCount", "()I", "getFailedCount", "getErrors", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Completed extends ParseState {
            private final List<ParseError> errors;
            private final int failedCount;
            private final int successCount;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Completed(int i, int i6, List<ParseError> errors) {
                super(null);
                k.f(errors, "errors");
                this.successCount = i;
                this.failedCount = i6;
                this.errors = errors;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Completed copy$default(Completed completed, int i, int i6, List list, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    i = completed.successCount;
                }
                if ((i10 & 2) != 0) {
                    i6 = completed.failedCount;
                }
                if ((i10 & 4) != 0) {
                    list = completed.errors;
                }
                return completed.copy(i, i6, list);
            }

            /* renamed from: component1, reason: from getter */
            public final int getSuccessCount() {
                return this.successCount;
            }

            /* renamed from: component2, reason: from getter */
            public final int getFailedCount() {
                return this.failedCount;
            }

            public final List<ParseError> component3() {
                return this.errors;
            }

            public final Completed copy(int successCount, int failedCount, List<ParseError> errors) {
                k.f(errors, "errors");
                return new Completed(successCount, failedCount, errors);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Completed)) {
                    return false;
                }
                Completed completed = (Completed) other;
                return this.successCount == completed.successCount && this.failedCount == completed.failedCount && k.b(this.errors, completed.errors);
            }

            public final List<ParseError> getErrors() {
                return this.errors;
            }

            public final int getFailedCount() {
                return this.failedCount;
            }

            public final int getSuccessCount() {
                return this.successCount;
            }

            public int hashCode() {
                return this.errors.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.failedCount, Integer.hashCode(this.successCount) * 31, 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Completed(successCount=");
                sb.append(this.successCount);
                sb.append(", failedCount=");
                sb.append(this.failedCount);
                sb.append(", errors=");
                return B7.a.r(sb, this.errors, ')');
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/uxsense/ApexMetadataManager$ParseState$Idle;", "Lcom/uxsense/ApexMetadataManager$ParseState;", AppAgent.CONSTRUCT, "()V", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Idle extends ParseState {
            public static final Idle INSTANCE = new Idle();

            private Idle() {
                super(null);
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/uxsense/ApexMetadataManager$ParseState$Parsing;", "Lcom/uxsense/ApexMetadataManager$ParseState;", "current", "", "total", "appName", "", AppAgent.CONSTRUCT, "(IILjava/lang/String;)V", "getCurrent", "()I", "getTotal", "getAppName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Parsing extends ParseState {
            private final String appName;
            private final int current;
            private final int total;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Parsing(int i, int i6, String appName) {
                super(null);
                k.f(appName, "appName");
                this.current = i;
                this.total = i6;
                this.appName = appName;
            }

            public static /* synthetic */ Parsing copy$default(Parsing parsing, int i, int i6, String str, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    i = parsing.current;
                }
                if ((i10 & 2) != 0) {
                    i6 = parsing.total;
                }
                if ((i10 & 4) != 0) {
                    str = parsing.appName;
                }
                return parsing.copy(i, i6, str);
            }

            /* renamed from: component1, reason: from getter */
            public final int getCurrent() {
                return this.current;
            }

            /* renamed from: component2, reason: from getter */
            public final int getTotal() {
                return this.total;
            }

            /* renamed from: component3, reason: from getter */
            public final String getAppName() {
                return this.appName;
            }

            public final Parsing copy(int current, int total, String appName) {
                k.f(appName, "appName");
                return new Parsing(current, total, appName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Parsing)) {
                    return false;
                }
                Parsing parsing = (Parsing) other;
                return this.current == parsing.current && this.total == parsing.total && k.b(this.appName, parsing.appName);
            }

            public final String getAppName() {
                return this.appName;
            }

            public final int getCurrent() {
                return this.current;
            }

            public final int getTotal() {
                return this.total;
            }

            public int hashCode() {
                return this.appName.hashCode() + androidx.constraintlayout.core.dsl.a.a(this.total, Integer.hashCode(this.current) * 31, 31);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("Parsing(current=");
                sb.append(this.current);
                sb.append(", total=");
                sb.append(this.total);
                sb.append(", appName=");
                return B7.a.g(')', this.appName, sb);
            }
        }

        public /* synthetic */ ParseState(kotlin.jvm.internal.e eVar) {
            this();
        }

        private ParseState() {
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager$capture$1", f = "ApexMetadataManager.kt", l = {239, 242, 239, 242}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ApexMetadataManager$capture$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ AccountEntry $account;
        final /* synthetic */ String $activityClassName;
        final /* synthetic */ int $androidUserId;
        final /* synthetic */ boolean $autoSave;
        final /* synthetic */ S7.k $callback;
        final /* synthetic */ Long $chatId;
        final /* synthetic */ Long $creationId;
        final /* synthetic */ List<String> $creationSubDirs;
        final /* synthetic */ String $nickname;
        final /* synthetic */ String $packageName;
        final /* synthetic */ boolean $parseNow;
        final /* synthetic */ KViewNode $root;
        final /* synthetic */ Long $rootCommentId;
        final /* synthetic */ List<ParseRule> $rules;
        final /* synthetic */ String $screenshotPath;
        final /* synthetic */ Long $senderId;
        final /* synthetic */ Long $userId;
        final /* synthetic */ String $uuid;
        final /* synthetic */ String $windowTitle;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, int i, String str2, String str3, Long l, String str4, String str5, KViewNode kViewNode, boolean z10, String str6, Long l5, Long l9, Long l10, Long l11, AccountEntry accountEntry, List<ParseRule> list, List<String> list2, boolean z11, S7.k kVar, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$packageName = str;
            this.$androidUserId = i;
            this.$nickname = str2;
            this.$uuid = str3;
            this.$userId = l;
            this.$activityClassName = str4;
            this.$windowTitle = str5;
            this.$root = kViewNode;
            this.$autoSave = z10;
            this.$screenshotPath = str6;
            this.$creationId = l5;
            this.$chatId = l9;
            this.$senderId = l10;
            this.$rootCommentId = l11;
            this.$account = accountEntry;
            this.$rules = list;
            this.$creationSubDirs = list2;
            this.$parseNow = z11;
            this.$callback = kVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$packageName, this.$androidUserId, this.$nickname, this.$uuid, this.$userId, this.$activityClassName, this.$windowTitle, this.$root, this.$autoSave, this.$screenshotPath, this.$creationId, this.$chatId, this.$senderId, this.$rootCommentId, this.$account, this.$rules, this.$creationSubDirs, this.$parseNow, this.$callback, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
        
            if (r2.saveCacheAndCallback(r11, r5, r31) == r1) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0144, code lost:
        
            if (r8.saveCacheAndCallback(r11, r5, r31) == r1) goto L70;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x014c A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #4 {all -> 0x002e, blocks: (B:9:0x0029, B:54:0x0147, B:56:0x014c), top: B:66:0x0010 }] */
        /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.coroutines.intrinsics.CoroutineSingletons] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v2, types: [long] */
        /* JADX WARN: Type inference failed for: r1v22 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v9, types: [long] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v12 */
        /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r6v20 */
        /* JADX WARN: Type inference failed for: r6v21 */
        /* JADX WARN: Type inference failed for: r6v22 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r7v0 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v17 */
        /* JADX WARN: Type inference failed for: r7v18 */
        /* JADX WARN: Type inference failed for: r7v19 */
        /* JADX WARN: Type inference failed for: r7v2, types: [com.uxsense.trace.ApexTrace] */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v8, types: [com.uxsense.trace.ApexTrace] */
        /* JADX WARN: Type inference failed for: r7v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r32) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 376
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexMetadataManager.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager$clearCache$1", f = "ApexMetadataManager.kt", l = {525, 529}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ApexMetadataManager$clearCache$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12031 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        @J7.c(c = "com.uxsense.ApexMetadataManager$clearCache$1$1", f = "ApexMetadataManager.kt", l = {533}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.ApexMetadataManager$clearCache$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01691 extends SuspendLambda implements n {
            final /* synthetic */ Path $basePath;
            Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01691(Path path, H7.c<? super C01691> cVar) {
                super(2, cVar);
                this.$basePath = path;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$2$lambda$0(Path path) {
                return Files.isDirectory(path, new LinkOption[0]);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$2$lambda$1(S7.k kVar, Object obj) {
                return ((Boolean) kVar.invoke(obj)).booleanValue();
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01691(this.$basePath, cVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.AutoCloseable] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                Iterator it;
                Stream<Path> stream;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                try {
                    if (i == 0) {
                        kotlin.b.b(obj);
                        Stream<Path> list = Files.list(this.$basePath);
                        it = ((List) list.filter(new d(new c(0), 0)).collect(Collectors.toList())).iterator();
                        stream = list;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (Iterator) this.L$1;
                        ?? r32 = (AutoCloseable) this.L$0;
                        kotlin.b.b(obj);
                        stream = r32;
                    }
                    while (it.hasNext()) {
                        Path path = (Path) it.next();
                        ApexMetadataManager apexMetadataManager = ApexMetadataManager.INSTANCE;
                        String string = path.getFileName().toString();
                        this.L$0 = stream;
                        this.L$1 = it;
                        this.label = 1;
                        if (apexMetadataManager.clearAppCache(string, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    com.stepos.ability.task.executor.e.s(stream, null);
                    return r.f317a;
                } finally {
                }
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01691) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12031(String str, H7.c<? super C12031> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12031(this.$appName, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        
            if (r1.clearAppCache(r5, r4) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004c, code lost:
        
            if (m9.AbstractC1683A.f(r1, r4) == r0) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004e, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L19
                if (r1 == r3) goto L15
                if (r1 != r2) goto Ld
                goto L15
            Ld:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L15:
                kotlin.b.b(r5)
                goto L4f
            L19:
                kotlin.b.b(r5)
                java.lang.String r5 = r4.$appName
                if (r5 == 0) goto L2b
                com.uxsense.ApexMetadataManager r1 = com.uxsense.ApexMetadataManager.INSTANCE
                r4.label = r3
                java.lang.Object r4 = com.uxsense.ApexMetadataManager.access$clearAppCache(r1, r5, r4)
                if (r4 != r0) goto L4f
                goto L4e
            L2b:
                com.uxsense.core.ApexMetadataFileManager r5 = com.uxsense.core.ApexMetadataFileManager.INSTANCE
                java.lang.String r1 = ""
                java.nio.file.Path r5 = r5.getAppRootDir(r1)
                java.nio.file.Path r5 = r5.getParent()
                r1 = 0
                java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]
                boolean r1 = java.nio.file.Files.exists(r5, r1)
                if (r1 == 0) goto L4f
                com.uxsense.ApexMetadataManager$clearCache$1$1 r1 = new com.uxsense.ApexMetadataManager$clearCache$1$1
                r3 = 0
                r1.<init>(r5, r3)
                r4.label = r2
                java.lang.Object r4 = m9.AbstractC1683A.f(r1, r4)
                if (r4 != r0) goto L4f
            L4e:
                return r0
            L4f:
                C7.r r4 = C7.r.f317a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexMetadataManager.C12031.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C12031) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager$parseAll$1", f = "ApexMetadataManager.kt", l = {372}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ApexMetadataManager$parseAll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12041 extends SuspendLambda implements n {
        int label;

        @J7.c(c = "com.uxsense.ApexMetadataManager$parseAll$1$1", f = "ApexMetadataManager.kt", l = {377}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.ApexMetadataManager$parseAll$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01701 extends SuspendLambda implements n {
            final /* synthetic */ Path $basePath;
            Object L$0;
            Object L$1;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01701(Path path, H7.c<? super C01701> cVar) {
                super(2, cVar);
                this.$basePath = path;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$2$lambda$0(Path path) {
                return Files.isDirectory(path, new LinkOption[0]);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invokeSuspend$lambda$2$lambda$1(S7.k kVar, Object obj) {
                return ((Boolean) kVar.invoke(obj)).booleanValue();
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C01701(this.$basePath, cVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.AutoCloseable] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                Iterator it;
                Stream<Path> stream;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                try {
                    if (i == 0) {
                        kotlin.b.b(obj);
                        Stream<Path> list = Files.list(this.$basePath);
                        it = ((List) list.filter(new d(new c(1), 1)).collect(Collectors.toList())).iterator();
                        stream = list;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (Iterator) this.L$1;
                        ?? r32 = (AutoCloseable) this.L$0;
                        kotlin.b.b(obj);
                        stream = r32;
                    }
                    while (it.hasNext()) {
                        Path path = (Path) it.next();
                        String string = path.getFileName().toString();
                        ApexMetadataManager apexMetadataManager = ApexMetadataManager.INSTANCE;
                        this.L$0 = stream;
                        this.L$1 = it;
                        this.label = 1;
                        if (apexMetadataManager.parseAppInternal(string, path, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    com.stepos.ability.task.executor.e.s(stream, null);
                    return r.f317a;
                } finally {
                }
            }

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C01701) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        public C12041(H7.c<? super C12041> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12041(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            r rVar = r.f317a;
            if (i == 0) {
                kotlin.b.b(obj);
                Path parent = ApexMetadataFileManager.INSTANCE.getAppRootDir("").getParent();
                if (!Files.exists(parent, new LinkOption[0])) {
                    ALog.w$default(ApexMetadataManager.TAG, "Base path not found: " + parent, null, 4, null);
                    return rVar;
                }
                ALog.i$default(ApexMetadataManager.TAG, "Starting to parse all apps", null, 4, null);
                C01701 c01701 = new C01701(parent, null);
                this.label = 1;
                if (AbstractC1683A.f(c01701, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return rVar;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C12041) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager", f = "ApexMetadataManager.kt", l = {264, 264}, m = "parseAndCallback")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexMetadataManager$parseAndCallback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12051 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C12051(H7.c<? super C12051> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexMetadataManager.this.parseAndCallback(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager$parseApp$1", f = "ApexMetadataManager.kt", l = {338}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ApexMetadataManager$parseApp$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12061 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12061(String str, H7.c<? super C12061> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12061(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            r rVar = r.f317a;
            if (i == 0) {
                kotlin.b.b(obj);
                Path appRootDir = ApexMetadataFileManager.INSTANCE.getAppRootDir(this.$appName);
                if (!Files.exists(appRootDir, new LinkOption[0])) {
                    ALog.w$default(ApexMetadataManager.TAG, "App root directory not found: " + appRootDir, null, 4, null);
                    return rVar;
                }
                ALog.i$default(ApexMetadataManager.TAG, "Starting to parse app: " + this.$appName, null, 4, null);
                ApexMetadataManager apexMetadataManager = ApexMetadataManager.INSTANCE;
                String str = this.$appName;
                this.label = 1;
                if (apexMetadataManager.parseAppInternal(str, appRootDir, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return rVar;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C12061) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager$parseAppInternal$2", f = "ApexMetadataManager.kt", l = {396}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ApexMetadataManager$parseAppInternal$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Path $appRoot;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Path path, String str, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$appRoot = path;
            this.$appName = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$2$lambda$0(Path path) {
            return Files.isDirectory(path, new LinkOption[0]) && j9.t.g0(path.getFileName().toString()) != null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$2$lambda$1(S7.k kVar, Object obj) {
            return ((Boolean) kVar.invoke(obj)).booleanValue();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$appRoot, this.$appName, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.AutoCloseable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Iterator it;
            String str;
            Stream<Path> stream;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    Stream<Path> list = Files.list(this.$appRoot);
                    String str2 = this.$appName;
                    it = ((List) list.filter(new d(new c(2), 2)).collect(Collectors.toList())).iterator();
                    str = str2;
                    stream = list;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.L$2;
                    str = (String) this.L$1;
                    ?? r42 = (AutoCloseable) this.L$0;
                    kotlin.b.b(obj);
                    stream = r42;
                }
                while (it.hasNext()) {
                    Path pathResolve = ((Path) it.next()).resolve("cache");
                    if (Files.exists(pathResolve, new LinkOption[0])) {
                        ApexMetadataManager apexMetadataManager = ApexMetadataManager.INSTANCE;
                        k.c(pathResolve);
                        this.L$0 = stream;
                        this.L$1 = str;
                        this.L$2 = it;
                        this.label = 1;
                        if (apexMetadataManager.parseCacheDir(str, pathResolve, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                com.stepos.ability.task.executor.e.s(stream, null);
                return r.f317a;
            } finally {
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager", f = "ApexMetadataManager.kt", l = {427}, m = "parseCacheDir")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexMetadataManager$parseCacheDir$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12071 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C12071(H7.c<? super C12071> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexMetadataManager.this.parseCacheDir(null, null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager", f = "ApexMetadataManager.kt", l = {564, 475}, m = "parseCacheFile")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexMetadataManager$parseCacheFile$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C12081(H7.c<? super C12081> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexMetadataManager.this.parseCacheFile(null, this);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager$parseUser$1", f = "ApexMetadataManager.kt", l = {356}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.ApexMetadataManager$parseUser$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12091 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12091(String str, H7.c<? super C12091> cVar) {
            super(2, cVar);
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12091(this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            r rVar = r.f317a;
            if (i == 0) {
                kotlin.b.b(obj);
                Path viewNodeCacheDir = ApexMetadataFileManager.INSTANCE.getViewNodeCacheDir(this.$appName);
                if (!Files.exists(viewNodeCacheDir, new LinkOption[0])) {
                    ALog.w$default(ApexMetadataManager.TAG, "Cache directory not found: " + viewNodeCacheDir, null, 4, null);
                    return rVar;
                }
                ALog.i$default(ApexMetadataManager.TAG, "Starting to parse user: " + this.$appName, null, 4, null);
                ApexMetadataManager apexMetadataManager = ApexMetadataManager.INSTANCE;
                String str = this.$appName;
                this.label = 1;
                if (apexMetadataManager.parseCacheDir(str, viewNodeCacheDir, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return rVar;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C12091) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.ApexMetadataManager", f = "ApexMetadataManager.kt", l = {564}, m = "saveCacheAndCallback")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.ApexMetadataManager$saveCacheAndCallback$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C12101(H7.c<? super C12101> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ApexMetadataManager.this.saveCacheAndCallback(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        scope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        storage = new FileStorageManager(null, 1, 0 == true ? 1 : 0);
        accountIdGenerator = new LockFreeSnowflakeGenerator(0L, 0L, 3, null);
        i iVarC = p9.e.c(ParseState.Idle.INSTANCE);
        _parseState = iVarC;
        parseState = new p9.l(iVarC);
        accountCache = new LinkedHashMap();
    }

    private ApexMetadataManager() {
    }

    public static void capture$default(ApexMetadataManager apexMetadataManager, int i, String str, String str2, String str3, KViewNode kViewNode, boolean z10, String str4, String str5, Long l, String str6, boolean z11, Long l5, Long l9, Long l10, Long l11, AccountEntry accountEntry, List list, List list2, S7.k kVar, int i6, Object obj) {
        S7.k kVar2;
        ApexMetadataManager apexMetadataManager2;
        int i10;
        String str7;
        KViewNode kViewNode2;
        String str8 = (i6 & 4) != 0 ? "" : str2;
        String str9 = (i6 & 8) != 0 ? "" : str3;
        boolean z12 = (i6 & 32) != 0 ? true : z10;
        String str10 = (i6 & 64) != 0 ? null : str4;
        String str11 = (i6 & 128) != 0 ? null : str5;
        Long l12 = (i6 & 256) != 0 ? null : l;
        String str12 = (i6 & 512) != 0 ? null : str6;
        boolean z13 = (i6 & 1024) != 0 ? true : z11;
        Long l13 = (i6 & 2048) != 0 ? null : l5;
        Long l14 = (i6 & 4096) != 0 ? null : l9;
        Long l15 = (i6 & 8192) != 0 ? null : l10;
        Long l16 = (i6 & 16384) != 0 ? null : l11;
        AccountEntry accountEntry2 = (32768 & i6) != 0 ? null : accountEntry;
        List list3 = (65536 & i6) != 0 ? EmptyList.f4893a : list;
        List list4 = (131072 & i6) != 0 ? EmptyList.f4893a : list2;
        if ((i6 & 262144) != 0) {
            kVar2 = null;
            i10 = i;
            str7 = str;
            kViewNode2 = kViewNode;
            apexMetadataManager2 = apexMetadataManager;
        } else {
            kVar2 = kVar;
            apexMetadataManager2 = apexMetadataManager;
            i10 = i;
            str7 = str;
            kViewNode2 = kViewNode;
        }
        apexMetadataManager2.capture(i10, str7, str8, str9, kViewNode2, z12, str10, str11, l12, str12, z13, l13, l14, l15, l16, accountEntry2, list3, list4, kVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object clearAppCache(String str, H7.c<? super r> cVar) throws IOException {
        Path appRootDir = ApexMetadataFileManager.INSTANCE.getAppRootDir(str);
        boolean zExists = Files.exists(appRootDir, new LinkOption[0]);
        r rVar = r.f317a;
        if (!zExists) {
            return rVar;
        }
        Stream<Path> list = Files.list(appRootDir);
        try {
            list.filter(new d(new c(3), 5)).forEach(new b(new a(str, 1), 1));
            com.stepos.ability.task.executor.e.s(list, null);
            return rVar;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearAppCache$lambda$23$lambda$14(Path path) {
        return Files.isDirectory(path, new LinkOption[0]) && j9.t.g0(path.getFileName().toString()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearAppCache$lambda$23$lambda$15(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r clearAppCache$lambda$23$lambda$21(String str, Path path) throws IOException {
        Path pathResolve = path.resolve("cache");
        if (Files.exists(pathResolve, new LinkOption[0])) {
            Stream<Path> list = Files.list(pathResolve);
            try {
                list.filter(new d(new c(6), 6)).forEach(new b(new c(7), 2));
                com.stepos.ability.task.executor.e.s(list, null);
                ALog.i$default(TAG, "Cleared cache for " + str + JsonPointer.SEPARATOR + path.getFileName(), null, 4, null);
            } finally {
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearAppCache$lambda$23$lambda$21$lambda$20$lambda$16(Path path) {
        k.c(path);
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean clearAppCache$lambda$23$lambda$21$lambda$20$lambda$17(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r clearAppCache$lambda$23$lambda$21$lambda$20$lambda$18(Path path) throws IOException {
        Files.deleteIfExists(path);
        return r.f317a;
    }

    public static /* synthetic */ void clearCache$default(ApexMetadataManager apexMetadataManager, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        apexMetadataManager.clearCache(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r getCacheFileCount$lambda$13$lambda$11(Ref$IntRef ref$IntRef, Path path) throws IOException {
        Path pathResolve = path.resolve("cache");
        if (Files.exists(pathResolve, new LinkOption[0])) {
            int i = ref$IntRef.f4918a;
            Stream<Path> list = Files.list(pathResolve);
            try {
                int iCount = (int) list.filter(new d(new c(4), 3)).count();
                com.stepos.ability.task.executor.e.s(list, null);
                ref$IntRef.f4918a = i + iCount;
            } finally {
            }
        }
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getCacheFileCount$lambda$13$lambda$11$lambda$10$lambda$8(Path path) {
        k.c(path);
        return Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getCacheFileCount$lambda$13$lambda$11$lambda$10$lambda$9(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getCacheFileCount$lambda$13$lambda$6(Path path) {
        return Files.isDirectory(path, new LinkOption[0]) && j9.t.g0(path.getFileName().toString()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getCacheFileCount$lambda$13$lambda$7(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseAndCallback(com.uxsense.base.parse.ParseCache r9, S7.k r10, H7.c<? super C7.r> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexMetadataManager.parseAndCallback(com.uxsense.base.parse.ParseCache, S7.k, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object parseAppInternal(String str, Path path, H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(path, str, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(7:28|61|29|30|63|31|(1:33)(7:34|65|35|(0)(0)|38|26|(2:51|52)(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:11|(3:69|12|13)|65|35|(1:37)(1:41)|38|26|(7:28|61|29|30|63|31|(1:33)(7:34|65|35|(0)(0)|38|26|(2:51|52)(0)))(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0137, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0148, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x016b, code lost:
    
        r7 = new com.uxsense.ApexMetadataManager.ParseError(r12, "Unknown error", r0);
        r14.add(r7);
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00cb, code lost:
    
        r7 = new com.uxsense.ApexMetadataManager.ParseError(r12, r8, r0);
        r14.add(r7);
        r0 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0113 A[Catch: Exception -> 0x0137, TryCatch #3 {Exception -> 0x0137, blocks: (B:35:0x010b, B:37:0x0113, B:41:0x013a), top: B:65:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013a A[Catch: Exception -> 0x0137, TRY_LEAVE, TryCatch #3 {Exception -> 0x0137, blocks: (B:35:0x010b, B:37:0x0113, B:41:0x013a), top: B:65:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0108 -> B:65:0x010b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseCacheDir(java.lang.String r18, java.nio.file.Path r19, H7.c<? super C7.r> r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexMetadataManager.parseCacheDir(java.lang.String, java.nio.file.Path, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseCacheDir$lambda$5$lambda$3(Path path) {
        String string;
        k.c(path);
        if (Files.isRegularFile(path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
            Path fileName = path.getFileName();
            String strI0 = "";
            if (fileName != null && (string = fileName.toString()) != null) {
                strI0 = m.I0('.', string, "");
            }
            if (strI0.length() == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean parseCacheDir$lambda$5$lambda$4(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (r5 == r7) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object parseCacheFile(java.nio.file.Path r6, H7.c<? super java.lang.Boolean> r7) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexMetadataManager.parseCacheFile(java.nio.file.Path, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object saveCacheAndCallback(com.uxsense.base.parse.ParseCache r10, S7.k r11, H7.c<? super C7.r> r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.ApexMetadataManager.saveCacheAndCallback(com.uxsense.base.parse.ParseCache, S7.k, H7.c):java.lang.Object");
    }

    public final void capture(int androidUserId, String packageName, String activityClassName, String windowTitle, KViewNode root, boolean parseNow, String nickname, String uuid, Long userId, String screenshotPath, boolean autoSave, Long creationId, Long chatId, Long senderId, Long rootCommentId, AccountEntry account, List<ParseRule> rules, List<String> creationSubDirs, S7.k callback) {
        k.f(packageName, "packageName");
        k.f(activityClassName, "activityClassName");
        k.f(windowTitle, "windowTitle");
        k.f(root, "root");
        k.f(rules, "rules");
        k.f(creationSubDirs, "creationSubDirs");
        AbstractC1683A.n(scope, null, new AnonymousClass1(packageName, androidUserId, nickname, uuid, userId, activityClassName, windowTitle, root, autoSave, screenshotPath, creationId, chatId, senderId, rootCommentId, account, rules, creationSubDirs, parseNow, callback, null), 3);
    }

    public final void clearCache(String appName) {
        AbstractC1683A.n(scope, null, new C12031(appName, null), 3);
    }

    public final int getCacheFileCount(String appName) throws IOException {
        k.f(appName, "appName");
        Path appRootDir = ApexMetadataFileManager.INSTANCE.getAppRootDir(appName);
        if (!Files.exists(appRootDir, new LinkOption[0])) {
            return 0;
        }
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        Stream<Path> list = Files.list(appRootDir);
        try {
            list.filter(new d(new c(5), 4)).forEach(new b(new a(ref$IntRef, 0), 0));
            com.stepos.ability.task.executor.e.s(list, null);
            return ref$IntRef.f4918a;
        } finally {
        }
    }

    public final t getParseState() {
        return parseState;
    }

    public final void parseAll() {
        AbstractC1683A.n(scope, null, new C12041(null), 3);
    }

    public final void parseApp(String appName) {
        k.f(appName, "appName");
        AbstractC1683A.n(scope, null, new C12061(appName, null), 3);
    }

    public final void parseUser(String appName) {
        k.f(appName, "appName");
        AbstractC1683A.n(scope, null, new C12091(appName, null), 3);
    }
}
