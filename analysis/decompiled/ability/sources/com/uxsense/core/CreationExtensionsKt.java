package com.uxsense.core;

import C7.r;
import S7.n;
import com.uxsense.base.metadata.Creation;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import com.uxsense.search.ApexSearchIndexManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import kotlin.text.Regex;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0007\u0010\b\u001a8\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0086@¢\u0006\u0004\b\u0007\u0010\u000b\u001a.\u0010\u000f\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u000f\u0010\u0010\u001a0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0086@¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0016\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a$\u0010\u0018\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0018\u0010\u0019\u001a@\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0086@¢\u0006\u0004\b\u001d\u0010\u001e\u001a0\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\t0\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\fH\u0086@¢\u0006\u0004\b\u001f\u0010\u0019\"\u001c\u0010\"\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#\"\u001c\u0010$\u001a\n !*\u0004\u0018\u00010 0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#¨\u0006%"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "appName", "Lcom/uxsense/base/metadata/Creation;", "creation", "Lcom/uxsense/file/FileResult;", "LC7/r;", "saveCreation", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;LH7/c;)Ljava/lang/Object;", "", "subDirs", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Lcom/uxsense/base/metadata/Creation;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "", "userId", "creationId", "loadCreationById", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJLH7/c;)Ljava/lang/Object;", "creations", "saveCreations", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;Ljava/util/List;LH7/c;)Ljava/lang/Object;", "createdAt", "Ljava/nio/file/Path;", "getCreationDateDir", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JJ)Ljava/nio/file/Path;", "archiveOldCreations", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "Ljava/time/LocalDate;", "startDate", "endDate", "loadCreationsByDateRange", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLjava/time/LocalDate;Ljava/time/LocalDate;LH7/c;)Ljava/lang/Object;", "loadAllCreations", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "DATE_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "MONTH_FORMATTER", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CreationExtensionsKt {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    @J7.c(c = "com.uxsense.core.CreationExtensionsKt$loadAllCreations$2", f = "CreationExtensions.kt", l = {311}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult$Success;", "", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult$Success;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CreationExtensionsKt$loadAllCreations$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ ApexMetadataFileManager $this_loadAllCreations;
        final /* synthetic */ long $userId;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_loadAllCreations = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_loadAllCreations, this.$appName, this.$userId, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
        
            r10 = r6.getStorage_$uxsense_release();
            r11 = com.uxsense.base.metadata.Creation.Companion.serializer();
            r13.L$0 = r14;
            r13.L$1 = r8;
            r13.L$2 = r6;
            r13.L$3 = r7;
            r13.L$4 = r5;
            r13.L$5 = r1;
            r13.label = 1;
            r9 = r10.readJson(r9, r11, r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00bf, code lost:
        
            if (r9 != r0) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00c1, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00c2, code lost:
        
            r9 = r14;
            r14 = r9;
            r8 = r8;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0069 A[Catch: all -> 0x00dd, TryCatch #5 {all -> 0x00dd, blocks: (B:38:0x00d6, B:19:0x0063, B:21:0x0069, B:23:0x0077, B:46:0x00e4, B:47:0x00e7, B:44:0x00e2), top: B:65:0x00d6, inners: #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008b A[Catch: all -> 0x002b, TryCatch #4 {all -> 0x002b, blocks: (B:6:0x0023, B:34:0x00c5, B:36:0x00cb, B:26:0x0085, B:28:0x008b, B:30:0x00a1), top: B:63:0x0023 }] */
        /* JADX WARN: Type inference failed for: r8v0 */
        /* JADX WARN: Type inference failed for: r8v1 */
        /* JADX WARN: Type inference failed for: r8v10 */
        /* JADX WARN: Type inference failed for: r8v11 */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v13 */
        /* JADX WARN: Type inference failed for: r8v2 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.AutoCloseable] */
        /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r8v6 */
        /* JADX WARN: Type inference failed for: r8v8, types: [java.lang.AutoCloseable] */
        /* JADX WARN: Type inference failed for: r8v9 */
        /* JADX WARN: Type inference failed for: r9v7, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x007f -> B:26:0x0085). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00c2 -> B:34:0x00c5). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 248
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.CreationExtensionsKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult.Success<? extends List<Creation>>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CreationExtensionsKt$loadCreationById$2", f = "CreationExtensions.kt", l = {311}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/base/metadata/Creation;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CreationExtensionsKt$loadCreationById$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12522 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ long $creationId;
        final /* synthetic */ ApexMetadataFileManager $this_loadCreationById;
        final /* synthetic */ long $userId;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12522(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super C12522> cVar) {
            super(2, cVar);
            this.$this_loadCreationById = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$creationId = j6;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12522(this.$this_loadCreationById, this.$appName, this.$userId, this.$creationId, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Throwable th;
            AutoCloseable autoCloseable;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                Path creationsDir = this.$this_loadCreationById.getCreationsDir(this.$appName, this.$userId);
                if (!Files.exists(creationsDir, new LinkOption[0])) {
                    return null;
                }
                Stream<Path> list = Files.list(creationsDir);
                long j5 = this.$creationId;
                ApexMetadataFileManager apexMetadataFileManager = this.$this_loadCreationById;
                try {
                    for (Path path : list) {
                        if (Files.isDirectory(path, new LinkOption[0])) {
                            Path pathResolve = path.resolve(j5 + ".json");
                            if (Files.exists(pathResolve, new LinkOption[0])) {
                                FileStorageManager storage_$uxsense_release = apexMetadataFileManager.getStorage_$uxsense_release();
                                k.c(pathResolve);
                                x9.b bVarSerializer = Creation.INSTANCE.serializer();
                                this.L$0 = list;
                                this.label = 1;
                                Object json = storage_$uxsense_release.readJson(pathResolve, bVarSerializer, this);
                                if (json == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                                obj = json;
                                autoCloseable = list;
                            }
                        }
                    }
                    com.stepos.ability.task.executor.e.s(list, null);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    autoCloseable = list;
                    throw th;
                }
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            autoCloseable = (AutoCloseable) this.L$0;
            try {
                kotlin.b.b(obj);
            } catch (Throwable th3) {
                th = th3;
                try {
                    throw th;
                } catch (Throwable th4) {
                    com.stepos.ability.task.executor.e.s(autoCloseable, th);
                    throw th4;
                }
            }
            FileResult fileResult = (FileResult) obj;
            Creation creation = fileResult instanceof FileResult.Success ? (Creation) ((FileResult.Success) fileResult).getData() : null;
            com.stepos.ability.task.executor.e.s(autoCloseable, null);
            return creation;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Creation> cVar) {
            return ((C12522) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CreationExtensionsKt$loadCreationsByDateRange$2", f = "CreationExtensions.kt", l = {311}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult$Success;", "", "Lcom/uxsense/base/metadata/Creation;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult$Success;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CreationExtensionsKt$loadCreationsByDateRange$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12532 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ LocalDate $endDate;
        final /* synthetic */ LocalDate $startDate;
        final /* synthetic */ ApexMetadataFileManager $this_loadCreationsByDateRange;
        final /* synthetic */ long $userId;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12532(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, LocalDate localDate, LocalDate localDate2, H7.c<? super C12532> cVar) {
            super(2, cVar);
            this.$this_loadCreationsByDateRange = apexMetadataFileManager;
            this.$appName = str;
            this.$userId = j5;
            this.$startDate = localDate;
            this.$endDate = localDate2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12532(this.$this_loadCreationsByDateRange, this.$appName, this.$userId, this.$startDate, this.$endDate, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0125, code lost:
        
            r13 = r9.getStorage_$uxsense_release();
            r14 = com.uxsense.base.metadata.Creation.Companion.serializer();
            r16.L$0 = r15;
            r16.L$1 = r12;
            r16.L$2 = r5;
            r16.L$3 = r8;
            r16.L$4 = r9;
            r16.L$5 = r10;
            r16.L$6 = r7;
            r16.L$7 = r6;
            r16.Z$0 = r2;
            r16.label = 1;
            r11 = r13.readJson(r11, r14, r16);
            r12 = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0149, code lost:
        
            if (r11 != r1) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x014b, code lost:
        
            return r1;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Path cross not found for [B:23:0x008b, B:35:0x00de], limit reached: 96 */
        /* JADX WARN: Path cross not found for [B:57:0x0170, B:62:0x017d], limit reached: 96 */
        /* JADX WARN: Removed duplicated region for block: B:21:0x007d A[Catch: all -> 0x00b4, TryCatch #1 {all -> 0x00b4, blocks: (B:65:0x0182, B:19:0x0077, B:21:0x007d, B:23:0x008b, B:25:0x00ab, B:31:0x00d2, B:33:0x00d8, B:37:0x00e3, B:39:0x00f4, B:43:0x00fd, B:72:0x018e, B:73:0x0191, B:29:0x00bb, B:70:0x018c), top: B:84:0x0008, inners: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[Catch: all -> 0x003a, TryCatch #3 {all -> 0x003a, blocks: (B:6:0x002e, B:53:0x014c, B:46:0x0109, B:48:0x010f, B:50:0x0125, B:55:0x0152, B:57:0x0170, B:59:0x0176, B:62:0x017d), top: B:87:0x002e }] */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0192  */
        /* JADX WARN: Type inference failed for: r12v10 */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.AutoCloseable] */
        /* JADX WARN: Type inference failed for: r13v18, types: [java.util.List] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00de -> B:67:0x0186). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00f2 -> B:67:0x0186). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00fa -> B:67:0x0186). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0105 -> B:46:0x0109). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0149 -> B:53:0x014c). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 421
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.CreationExtensionsKt.C12532.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult.Success<? extends List<Creation>>> cVar) {
            return ((C12532) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CreationExtensionsKt$saveCreation$3", f = "CreationExtensions.kt", l = {311}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CreationExtensionsKt$saveCreation$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ Creation $creation;
        final /* synthetic */ List<String> $subDirs;
        final /* synthetic */ ApexMetadataFileManager $this_saveCreation;
        long J$0;
        int label;

        @J7.c(c = "com.uxsense.core.CreationExtensionsKt$saveCreation$3$1", f = "CreationExtensions.kt", l = {75}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.core.CreationExtensionsKt$saveCreation$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            final /* synthetic */ String $appName;
            final /* synthetic */ Creation $creation;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(String str, Creation creation, H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$appName = str;
                this.$creation = creation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass1(this.$appName, this.$creation, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    ApexSearchIndexManager apexSearchIndexManager = ApexSearchIndexManager.INSTANCE;
                    String str = this.$appName;
                    Creation creation = this.$creation;
                    this.label = 1;
                    if (apexSearchIndexManager.indexCreation(str, creation, this) == coroutineSingletons) {
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

        @J7.c(c = "com.uxsense.core.CreationExtensionsKt$saveCreation$3$2", f = "CreationExtensions.kt", l = {78}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.core.CreationExtensionsKt$saveCreation$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements n {
            final /* synthetic */ String $appName;
            final /* synthetic */ ApexMetadataFileManager $this_saveCreation;
            final /* synthetic */ long $userId;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, H7.c<? super AnonymousClass2> cVar) {
                super(2, cVar);
                this.$this_saveCreation = apexMetadataFileManager;
                this.$appName = str;
                this.$userId = j5;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new AnonymousClass2(this.$this_saveCreation, this.$appName, this.$userId, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    kotlin.b.b(obj);
                    ApexMetadataFileManager apexMetadataFileManager = this.$this_saveCreation;
                    String str = this.$appName;
                    long j5 = this.$userId;
                    this.label = 1;
                    if (CreationExtensionsKt.archiveOldCreations(apexMetadataFileManager, str, j5, this) == coroutineSingletons) {
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
                return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Creation creation, List<String> list, ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.$creation = creation;
            this.$subDirs = list;
            this.$this_saveCreation = apexMetadataFileManager;
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass3(this.$creation, this.$subDirs, this.$this_saveCreation, this.$appName, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Path creationDateDir;
            long j5;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    kotlin.b.b(obj);
                    long userId = this.$creation.getUserId();
                    long creationId = this.$creation.getCreationId();
                    if (this.$subDirs.isEmpty()) {
                        creationDateDir = CreationExtensionsKt.getCreationDateDir(this.$this_saveCreation, this.$appName, userId, this.$creation.getCreatedAt());
                    } else {
                        creationDateDir = this.$this_saveCreation.getCreationsDir(this.$appName, userId);
                        Iterator<String> it = this.$subDirs.iterator();
                        while (it.hasNext()) {
                            creationDateDir = creationDateDir.resolve(it.next());
                            k.e(creationDateDir, "resolve(...)");
                        }
                    }
                    if (!Files.exists(creationDateDir, new LinkOption[0])) {
                        Files.createDirectories(creationDateDir, new FileAttribute[0]);
                    }
                    Path pathResolve = creationDateDir.resolve(creationId + ".json");
                    FileStorageManager storage_$uxsense_release = this.$this_saveCreation.getStorage_$uxsense_release();
                    k.c(pathResolve);
                    Creation creation = this.$creation;
                    x9.b bVarSerializer = Creation.INSTANCE.serializer();
                    this.J$0 = userId;
                    this.label = 1;
                    if (storage_$uxsense_release.writeJson(pathResolve, creation, bVarSerializer, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    j5 = userId;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j6 = this.J$0;
                    kotlin.b.b(obj);
                    j5 = j6;
                }
                AbstractC1683A.n(this.$this_saveCreation.getScope_$uxsense_release(), null, new AnonymousClass1(this.$appName, this.$creation, null), 3);
                if (this.$subDirs.isEmpty()) {
                    AbstractC1683A.n(this.$this_saveCreation.getScope_$uxsense_release(), null, new AnonymousClass2(this.$this_saveCreation, this.$appName, j5, null), 3);
                }
                return new FileResult.Success(r.f317a);
            } catch (Exception e) {
                return new FileResult.Error(new FileException.WriteError(this.$this_saveCreation.getCreationsDir(this.$appName, this.$creation.getUserId()), e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((AnonymousClass3) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @J7.c(c = "com.uxsense.core.CreationExtensionsKt$saveCreations$2", f = "CreationExtensions.kt", l = {135}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CreationExtensionsKt$saveCreations$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12542 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ List<Creation> $creations;
        final /* synthetic */ ApexMetadataFileManager $this_saveCreations;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12542(List<Creation> list, ApexMetadataFileManager apexMetadataFileManager, String str, H7.c<? super C12542> cVar) {
            super(2, cVar);
            this.$creations = list;
            this.$this_saveCreations = apexMetadataFileManager;
            this.$appName = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12542(this.$creations, this.$this_saveCreations, this.$appName, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0079 A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:6:0x0013, B:34:0x00b2, B:28:0x0092, B:25:0x0073, B:27:0x0079, B:38:0x00bb, B:30:0x0098, B:13:0x0026, B:15:0x002e, B:17:0x0034, B:18:0x0041, B:20:0x0047, B:22:0x005d, B:23:0x0065, B:24:0x006b), top: B:42:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0098 A[Catch: Exception -> 0x0018, TryCatch #0 {Exception -> 0x0018, blocks: (B:6:0x0013, B:34:0x00b2, B:28:0x0092, B:25:0x0073, B:27:0x0079, B:38:0x00bb, B:30:0x0098, B:13:0x0026, B:15:0x002e, B:17:0x0034, B:18:0x0041, B:20:0x0047, B:22:0x005d, B:23:0x0065, B:24:0x006b), top: B:42:0x0007 }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00b8 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00bb A[Catch: Exception -> 0x0018, TRY_LEAVE, TryCatch #0 {Exception -> 0x0018, blocks: (B:6:0x0013, B:34:0x00b2, B:28:0x0092, B:25:0x0073, B:27:0x0079, B:38:0x00bb, B:30:0x0098, B:13:0x0026, B:15:0x002e, B:17:0x0034, B:18:0x0041, B:20:0x0047, B:22:0x005d, B:23:0x0065, B:24:0x006b), top: B:42:0x0007 }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0079 -> B:28:0x0092). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00af -> B:34:0x00b2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r9.label
                C7.r r2 = C7.r.f317a
                r3 = 1
                if (r1 == 0) goto L23
                if (r1 != r3) goto L1b
                java.lang.Object r1 = r9.L$1
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r4 = r9.L$0
                java.util.Iterator r4 = (java.util.Iterator) r4
                kotlin.b.b(r10)     // Catch: java.lang.Exception -> L18
                goto Lb2
            L18:
                r10 = move-exception
                goto Lc1
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L23:
                kotlin.b.b(r10)
                java.util.List<com.uxsense.base.metadata.Creation> r10 = r9.$creations     // Catch: java.lang.Exception -> L18
                boolean r10 = r10.isEmpty()     // Catch: java.lang.Exception -> L18
                if (r10 == 0) goto L34
                com.uxsense.file.FileResult$Success r10 = new com.uxsense.file.FileResult$Success     // Catch: java.lang.Exception -> L18
                r10.<init>(r2)     // Catch: java.lang.Exception -> L18
                return r10
            L34:
                java.util.List<com.uxsense.base.metadata.Creation> r10 = r9.$creations     // Catch: java.lang.Exception -> L18
                java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch: java.lang.Exception -> L18
                java.util.LinkedHashMap r1 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> L18
                r1.<init>()     // Catch: java.lang.Exception -> L18
                java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Exception -> L18
            L41:
                boolean r4 = r10.hasNext()     // Catch: java.lang.Exception -> L18
                if (r4 == 0) goto L6b
                java.lang.Object r4 = r10.next()     // Catch: java.lang.Exception -> L18
                r5 = r4
                com.uxsense.base.metadata.Creation r5 = (com.uxsense.base.metadata.Creation) r5     // Catch: java.lang.Exception -> L18
                long r5 = r5.getUserId()     // Catch: java.lang.Exception -> L18
                java.lang.Long r7 = new java.lang.Long     // Catch: java.lang.Exception -> L18
                r7.<init>(r5)     // Catch: java.lang.Exception -> L18
                java.lang.Object r5 = r1.get(r7)     // Catch: java.lang.Exception -> L18
                if (r5 != 0) goto L65
                java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Exception -> L18
                r5.<init>()     // Catch: java.lang.Exception -> L18
                r1.put(r7, r5)     // Catch: java.lang.Exception -> L18
            L65:
                java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Exception -> L18
                r5.add(r4)     // Catch: java.lang.Exception -> L18
                goto L41
            L6b:
                java.util.Set r10 = r1.entrySet()     // Catch: java.lang.Exception -> L18
                java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Exception -> L18
            L73:
                boolean r1 = r10.hasNext()     // Catch: java.lang.Exception -> L18
                if (r1 == 0) goto Lbb
                java.lang.Object r1 = r10.next()     // Catch: java.lang.Exception -> L18
                java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Exception -> L18
                java.lang.Object r4 = r1.getKey()     // Catch: java.lang.Exception -> L18
                java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> L18
                r4.longValue()     // Catch: java.lang.Exception -> L18
                java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Exception -> L18
                java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> L18
                java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L18
            L92:
                boolean r4 = r1.hasNext()     // Catch: java.lang.Exception -> L18
                if (r4 == 0) goto L73
                java.lang.Object r4 = r1.next()     // Catch: java.lang.Exception -> L18
                com.uxsense.base.metadata.Creation r4 = (com.uxsense.base.metadata.Creation) r4     // Catch: java.lang.Exception -> L18
                com.uxsense.core.ApexMetadataFileManager r5 = r9.$this_saveCreations     // Catch: java.lang.Exception -> L18
                java.lang.String r6 = r9.$appName     // Catch: java.lang.Exception -> L18
                r9.L$0 = r10     // Catch: java.lang.Exception -> L18
                r9.L$1 = r1     // Catch: java.lang.Exception -> L18
                r9.label = r3     // Catch: java.lang.Exception -> L18
                java.lang.Object r4 = com.uxsense.core.CreationExtensionsKt.saveCreation(r5, r6, r4, r9)     // Catch: java.lang.Exception -> L18
                if (r4 != r0) goto Laf
                return r0
            Laf:
                r8 = r4
                r4 = r10
                r10 = r8
            Lb2:
                com.uxsense.file.FileResult r10 = (com.uxsense.file.FileResult) r10     // Catch: java.lang.Exception -> L18
                boolean r5 = r10 instanceof com.uxsense.file.FileResult.Error     // Catch: java.lang.Exception -> L18
                if (r5 == 0) goto Lb9
                return r10
            Lb9:
                r10 = r4
                goto L92
            Lbb:
                com.uxsense.file.FileResult$Success r10 = new com.uxsense.file.FileResult$Success     // Catch: java.lang.Exception -> L18
                r10.<init>(r2)     // Catch: java.lang.Exception -> L18
                return r10
            Lc1:
                com.uxsense.file.FileResult$Error r0 = new com.uxsense.file.FileResult$Error
                com.uxsense.file.FileException$WriteError r1 = new com.uxsense.file.FileException$WriteError
                com.uxsense.core.ApexMetadataFileManager r2 = r9.$this_saveCreations
                java.lang.String r9 = r9.$appName
                java.nio.file.Path r9 = r2.getAppRootDir(r9)
                r1.<init>(r9, r10)
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.core.CreationExtensionsKt.C12542.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12542) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object archiveOldCreations(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, H7.c<? super r> cVar) throws IOException {
        Path creationsDir = apexMetadataFileManager.getCreationsDir(str, j5);
        boolean zExists = Files.exists(creationsDir, new LinkOption[0]);
        r rVar = r.f317a;
        if (!zExists) {
            return rVar;
        }
        Instant instantMinus = Instant.now().minus(30L, (TemporalUnit) ChronoUnit.DAYS);
        Stream<Path> list = Files.list(creationsDir);
        try {
            final d dVar = new d(2);
            for (Path path : list.filter(new Predicate() { // from class: com.uxsense.core.b
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return CreationExtensionsKt.archiveOldCreations$lambda$3$lambda$1(dVar, obj);
                }
            })) {
                LocalDate localDate = LocalDate.parse(path.getFileName().toString(), DATE_FORMATTER);
                if (localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().isBefore(instantMinus)) {
                    Path pathResolve = creationsDir.resolve(localDate.format(MONTH_FORMATTER));
                    if (!Files.exists(pathResolve, new LinkOption[0])) {
                        Files.createDirectories(pathResolve, new FileAttribute[0]);
                    }
                    list = Files.list(path);
                    try {
                        for (Path path2 : list) {
                            Files.move(path2, pathResolve.resolve(path2.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                        }
                        com.stepos.ability.task.executor.e.s(list, null);
                        Files.deleteIfExists(path);
                    } finally {
                    }
                }
            }
            com.stepos.ability.task.executor.e.s(list, null);
            return rVar;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean archiveOldCreations$lambda$3$lambda$0(Path path) {
        if (Files.isDirectory(path, new LinkOption[0])) {
            if (new Regex("\\d{4}-\\d{2}-\\d{2}").d(path.getFileName().toString())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean archiveOldCreations$lambda$3$lambda$1(S7.k kVar, Object obj) {
        return ((Boolean) kVar.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path getCreationDateDir(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6) {
        Instant instantOfEpochMilli = Instant.ofEpochMilli(j6);
        Path pathResolve = apexMetadataFileManager.getCreationsDir(str, j5).resolve(ChronoUnit.DAYS.between(instantOfEpochMilli, Instant.now()) <= 30 ? instantOfEpochMilli.atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER) : instantOfEpochMilli.atZone(ZoneId.systemDefault()).toLocalDate().format(MONTH_FORMATTER));
        k.e(pathResolve, "resolve(...)");
        return pathResolve;
    }

    public static final Object loadAllCreations(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, H7.c<? super FileResult<? extends List<Creation>>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(apexMetadataFileManager, str, j5, null), cVar);
    }

    public static final Object loadCreationById(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, long j6, H7.c<? super Creation> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12522(apexMetadataFileManager, str, j5, j6, null), cVar);
    }

    public static final Object loadCreationsByDateRange(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, LocalDate localDate, LocalDate localDate2, H7.c<? super FileResult<? extends List<Creation>>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12532(apexMetadataFileManager, str, j5, localDate, localDate2, null), cVar);
    }

    public static final Object saveCreation(ApexMetadataFileManager apexMetadataFileManager, String str, Creation creation, List<String> list, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass3(creation, list, apexMetadataFileManager, str, null), cVar);
    }

    public static final Object saveCreations(ApexMetadataFileManager apexMetadataFileManager, String str, List<Creation> list, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new C12542(list, apexMetadataFileManager, str, null), cVar);
    }

    public static final Object saveCreation(ApexMetadataFileManager apexMetadataFileManager, String str, Creation creation, H7.c<? super FileResult<r>> cVar) {
        return saveCreation(apexMetadataFileManager, str, creation, EmptyList.f4893a, cVar);
    }
}
