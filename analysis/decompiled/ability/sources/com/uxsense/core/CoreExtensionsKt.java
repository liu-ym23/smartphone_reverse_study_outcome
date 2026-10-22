package com.uxsense.core;

import C7.r;
import S7.n;
import androidx.autofill.HintConstants;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import com.uxsense.file.FileStorageManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aB\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0086@¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000f\"\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013\"\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/uxsense/core/ApexMetadataFileManager;", "", "appName", "LC9/d;", "jsonArray", HintConstants.AUTOFILL_HINT_NAME, "tag", "Lcom/uxsense/file/FileResult;", "LC7/r;", "save", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;LC9/d;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "date", "Ljava/nio/file/Path;", "getMetadataDir", "(Lcom/uxsense/core/ApexMetadataFileManager;Ljava/lang/String;JLjava/lang/String;)Ljava/nio/file/Path;", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "DATE_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "MONTH_FORMATTER", "uxsense_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CoreExtensionsKt {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");

    @J7.c(c = "com.uxsense.core.CoreExtensionsKt$save$2", f = "CoreExtensions.kt", l = {71}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.core.CoreExtensionsKt$save$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ String $appName;
        final /* synthetic */ C9.d $jsonArray;
        final /* synthetic */ String $name;
        final /* synthetic */ String $tag;
        final /* synthetic */ ApexMetadataFileManager $this_save;
        long J$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApexMetadataFileManager apexMetadataFileManager, String str, String str2, String str3, C9.d dVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$this_save = apexMetadataFileManager;
            this.$appName = str;
            this.$tag = str2;
            this.$name = str3;
            this.$jsonArray = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$this_save, this.$appName, this.$tag, this.$name, this.$jsonArray, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            AnonymousClass2 anonymousClass2;
            Exception exc;
            long j5;
            Path pathResolve;
            FileStorageManager storage_$uxsense_release;
            String string;
            long j6;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    Path metadataDir = CoreExtensionsKt.getMetadataDir(this.$this_save, this.$appName, jCurrentTimeMillis, this.$tag);
                    if (!Files.exists(metadataDir, new LinkOption[0])) {
                        try {
                            Files.createDirectories(metadataDir, new FileAttribute[0]);
                        } catch (Exception e) {
                            exc = e;
                            anonymousClass2 = this;
                            j5 = jCurrentTimeMillis;
                            return new FileResult.Error(new FileException.WriteError(CoreExtensionsKt.getMetadataDir$default(anonymousClass2.$this_save, anonymousClass2.$appName, j5, null, 4, null), exc));
                        }
                    }
                    String strValueOf = this.$name;
                    if (strValueOf == null) {
                        strValueOf = String.valueOf(this.$this_save.getIdGenerator_$uxsense_release().nextId());
                    }
                    pathResolve = metadataDir.resolve(strValueOf + ".json");
                    storage_$uxsense_release = this.$this_save.getStorage_$uxsense_release();
                    k.c(pathResolve);
                    string = this.$jsonArray.toString();
                    this.J$0 = jCurrentTimeMillis;
                    this.label = 1;
                    anonymousClass2 = this;
                } catch (Exception e6) {
                    e = e6;
                    anonymousClass2 = this;
                }
                try {
                    if (FileStorageManager.writeText$default(storage_$uxsense_release, pathResolve, string, false, anonymousClass2, 4, null) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    j6 = jCurrentTimeMillis;
                } catch (Exception e9) {
                    e = e9;
                    exc = e;
                    j5 = jCurrentTimeMillis;
                    return new FileResult.Error(new FileException.WriteError(CoreExtensionsKt.getMetadataDir$default(anonymousClass2.$this_save, anonymousClass2.$appName, j5, null, 4, null), exc));
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j6 = this.J$0;
                try {
                    kotlin.b.b(obj);
                    anonymousClass2 = this;
                } catch (Exception e10) {
                    exc = e10;
                    anonymousClass2 = this;
                    j5 = j6;
                    return new FileResult.Error(new FileException.WriteError(CoreExtensionsKt.getMetadataDir$default(anonymousClass2.$this_save, anonymousClass2.$appName, j5, null, 4, null), exc));
                }
            }
            try {
                return new FileResult.Success(r.f317a);
            } catch (Exception e11) {
                exc = e11;
                j5 = j6;
                return new FileResult.Error(new FileException.WriteError(CoreExtensionsKt.getMetadataDir$default(anonymousClass2.$this_save, anonymousClass2.$appName, j5, null, 4, null), exc));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Path getMetadataDir(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, String str2) {
        if (str2 != null) {
            Path pathResolve = apexMetadataFileManager.getAppRootDir(str).resolve(str2);
            k.c(pathResolve);
            return pathResolve;
        }
        Path pathResolve2 = apexMetadataFileManager.getAppRootDir(str).resolve(Instant.ofEpochMilli(j5).atZone(ZoneId.systemDefault()).toLocalDate().format(DATE_FORMATTER));
        k.c(pathResolve2);
        return pathResolve2;
    }

    public static /* synthetic */ Path getMetadataDir$default(ApexMetadataFileManager apexMetadataFileManager, String str, long j5, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return getMetadataDir(apexMetadataFileManager, str, j5, str2);
    }

    public static final Object save(ApexMetadataFileManager apexMetadataFileManager, String str, C9.d dVar, String str2, String str3, H7.c<? super FileResult<r>> cVar) {
        u9.d dVar2 = AbstractC1691I.f5315a;
        return AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(apexMetadataFileManager, str, str3, str2, dVar, null), cVar);
    }

    public static /* synthetic */ Object save$default(ApexMetadataFileManager apexMetadataFileManager, String str, C9.d dVar, String str2, String str3, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return save(apexMetadataFileManager, str, dVar, str2, str3, cVar);
    }
}
