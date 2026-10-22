package com.uxsense.file;

import C7.r;
import D7.N;
import D7.w;
import J7.c;
import S7.n;
import a.AbstractC0291a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.SingleFileBundle;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import com.uxsense.file.FileException;
import com.uxsense.file.FileResult;
import j9.AbstractC1607a;
import j9.m;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.AccessDeniedException;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.a;
import kotlinx.serialization.SerializationException;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import p9.d;
import x9.InterfaceC2123a;
import x9.f;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J@\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00122\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\u0082@¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ&\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0086@¢\u0006\u0004\b\"\u0010#J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b$\u0010\u001fJ!\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00150%2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J6\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190%2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0086@¢\u0006\u0004\b)\u0010*J0\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u00152\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\rH\u0086@¢\u0006\u0004\b.\u0010/J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b0\u0010\u001fJ\u0018\u00101\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b1\u0010\u001fJ\u001e\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b3\u0010\u001fJ:\u00107\u001a\b\u0012\u0004\u0012\u00020\b0\u0015\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00104\u001a\u00028\u00002\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0086@¢\u0006\u0004\b7\u00108J2\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u000009H\u0086@¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020\b¢\u0006\u0004\b=\u0010>J6\u0010B\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00150?2\u0018\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190@0?H\u0086@¢\u0006\u0004\bB\u0010CR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010DR \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020 0E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006H"}, d2 = {"Lcom/uxsense/file/FileStorageManager;", "", "Lcom/uxsense/file/FileStorageConfig;", "config", AppAgent.CONSTRUCT, "(Lcom/uxsense/file/FileStorageConfig;)V", "Ljava/nio/file/Path;", SingleFileBundle.KEY_PATH, "LC7/r;", "ensureParentExists", "(Ljava/nio/file/Path;)V", "Ljava/io/IOException;", "e", "", "isWrite", "Lcom/uxsense/file/FileResult$Error;", "handleIOException", "(Ljava/nio/file/Path;Ljava/io/IOException;Z)Lcom/uxsense/file/FileResult$Error;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "LH7/c;", "Lcom/uxsense/file/FileResult;", "block", "executeWithRetry", "(LS7/k;LH7/c;)Ljava/lang/Object;", "", "content", "append", "writeText", "(Ljava/nio/file/Path;Ljava/lang/String;ZLH7/c;)Ljava/lang/Object;", "readText", "(Ljava/nio/file/Path;LH7/c;)Ljava/lang/Object;", "", SingleFileBundle.KEY_BYTES, "writeBytes", "(Ljava/nio/file/Path;[BLH7/c;)Ljava/lang/Object;", "readBytes", "Lp9/c;", "readLines", "(Ljava/nio/file/Path;)Lp9/c;", "lines", "writeLines", "(Ljava/nio/file/Path;Lp9/c;ZLH7/c;)Ljava/lang/Object;", "sourcePath", "targetPath", "overwrite", "copyFile", "(Ljava/nio/file/Path;Ljava/nio/file/Path;ZLH7/c;)Ljava/lang/Object;", "deleteFile", "exists", "", "getFileSize", SettingsConfig.KEY_DATA, "Lx9/f;", "serializer", "writeJson", "(Ljava/nio/file/Path;Ljava/lang/Object;Lx9/f;LH7/c;)Ljava/lang/Object;", "Lx9/a;", "deserializer", "readJson", "(Ljava/nio/file/Path;Lx9/a;LH7/c;)Ljava/lang/Object;", "clearCache", "()V", "", "Lkotlin/Pair;", "operations", "batchWrite", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "Lcom/uxsense/file/FileStorageConfig;", "", "cache", "Ljava/util/Map;", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileStorageManager {
    private final Map<Path, byte[]> cache;
    private final FileStorageConfig config;

    @c(c = "com.uxsense.file.FileStorageManager$batchWrite$2", f = "FileStorageManager.kt", l = {TypedValues.PositionType.TYPE_SIZE_PERCENT}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lm9/z;", "", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Ljava/util/List;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$batchWrite$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ List<Pair<Path, String>> $operations;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FileStorageManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(List<? extends Pair<? extends Path, String>> list, FileStorageManager fileStorageManager, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$operations = list;
            this.this$0 = fileStorageManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$operations, this.this$0, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            InterfaceC1733z interfaceC1733z = (InterfaceC1733z) this.L$0;
            List<Pair<Path, String>> list = this.$operations;
            FileStorageManager fileStorageManager = this.this$0;
            ArrayList arrayList = new ArrayList(w.c0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                arrayList.add(AbstractC1683A.d(interfaceC1733z, null, new FileStorageManager$batchWrite$2$1$1(fileStorageManager, (Path) pair.f4886a, (String) pair.b, null), 3));
            }
            this.label = 1;
            Object objB = a.b(arrayList, this);
            return objB == coroutineSingletons ? coroutineSingletons : objB;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super List<? extends FileResult<r>>> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$copyFile$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$copyFile$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12652 extends SuspendLambda implements n {
        final /* synthetic */ boolean $overwrite;
        final /* synthetic */ Path $sourcePath;
        final /* synthetic */ Path $targetPath;
        int label;
        final /* synthetic */ FileStorageManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12652(Path path, FileStorageManager fileStorageManager, Path path2, boolean z10, H7.c<? super C12652> cVar) {
            super(2, cVar);
            this.$sourcePath = path;
            this.this$0 = fileStorageManager;
            this.$targetPath = path2;
            this.$overwrite = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12652(this.$sourcePath, this.this$0, this.$targetPath, this.$overwrite, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                if (!Files.exists(this.$sourcePath, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    return new FileResult.Error(new FileException.FileNotFound(this.$sourcePath));
                }
                this.this$0.ensureParentExists(this.$targetPath);
                StandardCopyOption[] standardCopyOptionArr = this.$overwrite ? new StandardCopyOption[]{StandardCopyOption.REPLACE_EXISTING} : new StandardCopyOption[0];
                Path path = this.$sourcePath;
                Path path2 = this.$targetPath;
                CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(standardCopyOptionArr, standardCopyOptionArr.length);
                k.e(Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
                return new FileResult.Success(r.f317a);
            } catch (IOException e) {
                return new FileResult.Error(new FileException.WriteError(this.$targetPath, e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12652) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$deleteFile$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$deleteFile$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12662 extends SuspendLambda implements n {
        final /* synthetic */ Path $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12662(Path path, H7.c<? super C12662> cVar) {
            super(2, cVar);
            this.$path = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12662(this.$path, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                FileStorageManager.this.cache.remove(this.$path);
                return new FileResult.Success(Boolean.valueOf(Files.deleteIfExists(this.$path)));
            } catch (IOException e) {
                return new FileResult.Error(new FileException.WriteError(this.$path, e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Boolean>> cVar) {
            return ((C12662) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager", f = "FileStorageManager.kt", l = {528, 533}, m = "executeWithRetry")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: com.uxsense.file.FileStorageManager$executeWithRetry$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileStorageManager.this.executeWithRetry(null, this);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$exists$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$exists$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12672 extends SuspendLambda implements n {
        final /* synthetic */ Path $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12672(Path path, H7.c<? super C12672> cVar) {
            super(2, cVar);
            this.$path = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12672(this.$path, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            boolean zExists = false;
            try {
                zExists = Files.exists(this.$path, new LinkOption[0]);
            } catch (Exception unused) {
            }
            return Boolean.valueOf(zExists);
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((C12672) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$getFileSize$2", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$getFileSize$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12682 extends SuspendLambda implements n {
        final /* synthetic */ Path $path;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12682(Path path, H7.c<? super C12682> cVar) {
            super(2, cVar);
            this.$path = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C12682(this.$path, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                return !Files.exists(this.$path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) ? new FileResult.Error(new FileException.FileNotFound(this.$path)) : new FileResult.Success(new Long(Files.size(this.$path)));
            } catch (IOException e) {
                return new FileResult.Error(new FileException.ReadError(this.$path, e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<Long>> cVar) {
            return ((C12682) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$readBytes$2", f = "FileStorageManager.kt", l = {301}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$readBytes$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12692 extends SuspendLambda implements n {
        final /* synthetic */ Path $path;
        int label;

        @c(c = "com.uxsense.file.FileStorageManager$readBytes$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/uxsense/file/FileResult;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: com.uxsense.file.FileStorageManager$readBytes$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.k {
            final /* synthetic */ Path $path;
            int label;
            final /* synthetic */ FileStorageManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FileStorageManager fileStorageManager, Path path, H7.c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = fileStorageManager;
                this.$path = path;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$path, cVar);
            }

            @Override // S7.k
            public final Object invoke(H7.c<? super FileResult<byte[]>> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                try {
                    if (this.this$0.config.getEnableCache() && this.this$0.cache.containsKey(this.$path)) {
                        Object obj2 = this.this$0.cache.get(this.$path);
                        k.c(obj2);
                        return new FileResult.Success(obj2);
                    }
                    if (!Files.exists(this.$path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                        return new FileResult.Error(new FileException.FileNotFound(this.$path));
                    }
                    byte[] allBytes = Files.readAllBytes(this.$path);
                    k.e(allBytes, "readAllBytes(...)");
                    if (this.this$0.config.getEnableCache()) {
                        this.this$0.cache.put(this.$path, allBytes);
                    }
                    return new FileResult.Success(allBytes);
                } catch (IOException e) {
                    return this.this$0.handleIOException(this.$path, e, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12692(Path path, H7.c<? super C12692> cVar) {
            super(2, cVar);
            this.$path = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12692(this.$path, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            FileStorageManager fileStorageManager = FileStorageManager.this;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fileStorageManager, this.$path, null);
            this.label = 1;
            Object objExecuteWithRetry = fileStorageManager.executeWithRetry(anonymousClass1, this);
            return objExecuteWithRetry == coroutineSingletons ? coroutineSingletons : objExecuteWithRetry;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<byte[]>> cVar) {
            return ((C12692) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$readJson$2", f = "FileStorageManager.kt", l = {465}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lm9/z;", "Lcom/uxsense/file/FileResult;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$readJson$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12702 extends SuspendLambda implements n {
        final /* synthetic */ InterfaceC2123a $deserializer;
        final /* synthetic */ Path $path;
        int label;

        @c(c = "com.uxsense.file.FileStorageManager$readJson$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n"}, d2 = {"<anonymous>", "Lcom/uxsense/file/FileResult;", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: com.uxsense.file.FileStorageManager$readJson$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.k {
            final /* synthetic */ InterfaceC2123a $deserializer;
            final /* synthetic */ Path $path;
            int label;
            final /* synthetic */ FileStorageManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FileStorageManager fileStorageManager, Path path, InterfaceC2123a interfaceC2123a, H7.c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = fileStorageManager;
                this.$path = path;
                this.$deserializer = interfaceC2123a;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$path, this.$deserializer, cVar);
            }

            @Override // S7.k
            public final Object invoke(H7.c<? super FileResult<? extends T>> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String strC;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                try {
                    if (this.this$0.config.getEnableCache() && this.this$0.cache.containsKey(this.$path)) {
                        Object obj2 = this.this$0.cache.get(this.$path);
                        k.c(obj2);
                        strC = new String((byte[]) obj2, AbstractC1607a.f4778a);
                    } else {
                        if (!Files.exists(this.$path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                            return new FileResult.Error(new FileException.FileNotFound(this.$path));
                        }
                        strC = AbstractC0291a.C(this.$path);
                        if (this.this$0.config.getEnableCache()) {
                            Map map = this.this$0.cache;
                            Path path = this.$path;
                            byte[] bytes = strC.getBytes(AbstractC1607a.f4778a);
                            k.e(bytes, "getBytes(...)");
                            map.put(path, bytes);
                        }
                    }
                    return new FileResult.Success(this.this$0.config.getJson().a(this.$deserializer, strC));
                } catch (IOException e) {
                    return this.this$0.handleIOException(this.$path, e, false);
                } catch (SerializationException e6) {
                    return new FileResult.Error(new FileException.ReadError(this.$path, e6));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12702(Path path, InterfaceC2123a interfaceC2123a, H7.c<? super C12702> cVar) {
            super(2, cVar);
            this.$path = path;
            this.$deserializer = interfaceC2123a;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12702(this.$path, this.$deserializer, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            FileStorageManager fileStorageManager = FileStorageManager.this;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fileStorageManager, this.$path, this.$deserializer, null);
            this.label = 1;
            Object objExecuteWithRetry = fileStorageManager.executeWithRetry(anonymousClass1, this);
            return objExecuteWithRetry == coroutineSingletons ? coroutineSingletons : objExecuteWithRetry;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<? extends T>> cVar) {
            return ((C12702) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$readLines$1", f = "FileStorageManager.kt", l = {331, 334, 336}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lp9/d;", "Lcom/uxsense/file/FileResult;", "", "LC7/r;", "<anonymous>", "(Lp9/d;)V"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$readLines$1, reason: invalid class name and case insensitive filesystem */
    public static final class C12711 extends SuspendLambda implements n {
        final /* synthetic */ Path $path;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ FileStorageManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12711(Path path, FileStorageManager fileStorageManager, H7.c<? super C12711> cVar) {
            super(2, cVar);
            this.$path = path;
            this.this$0 = fileStorageManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C12711 c12711 = new C12711(this.$path, this.this$0, cVar);
            c12711.L$0 = obj;
            return c12711;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[Catch: all -> 0x0030, TRY_LEAVE, TryCatch #1 {all -> 0x0030, blocks: (B:11:0x002c, B:30:0x008b, B:32:0x0091, B:29:0x0078), top: B:47:0x000b, outer: #2 }] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00cb A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00cc A[RETURN] */
        /* JADX WARN: Type inference failed for: r6v0 */
        /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Closeable] */
        /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.io.IOException {
            /*
                r10 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r10.label
                C7.r r2 = C7.r.f317a
                r3 = 0
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r1 == 0) goto L3e
                if (r1 == r6) goto L33
                if (r1 == r5) goto L20
                if (r1 != r4) goto L18
                kotlin.b.b(r11)
                goto Lcc
            L18:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L20:
                java.lang.Object r1 = r10.L$2
                java.util.Iterator r1 = (java.util.Iterator) r1
                java.lang.Object r6 = r10.L$1
                java.io.Closeable r6 = (java.io.Closeable) r6
                java.lang.Object r8 = r10.L$0
                p9.d r8 = (p9.d) r8
                kotlin.b.b(r11)     // Catch: java.lang.Throwable -> L30
                goto L8b
            L30:
                r11 = move-exception
                goto Laf
            L33:
                java.lang.Object r1 = r10.L$0
                p9.d r1 = (p9.d) r1
                kotlin.b.b(r11)     // Catch: java.io.IOException -> L3b
                return r2
            L3b:
                r11 = move-exception
                goto Lb5
            L3e:
                kotlin.b.b(r11)
                java.lang.Object r11 = r10.L$0
                r8 = r11
                p9.d r8 = (p9.d) r8
                java.nio.file.Path r11 = r10.$path     // Catch: java.io.IOException -> L6d
                java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r3]     // Catch: java.io.IOException -> L6d
                java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r3)     // Catch: java.io.IOException -> L6d
                java.nio.file.LinkOption[] r1 = (java.nio.file.LinkOption[]) r1     // Catch: java.io.IOException -> L6d
                boolean r11 = java.nio.file.Files.exists(r11, r1)     // Catch: java.io.IOException -> L6d
                if (r11 != 0) goto L70
                com.uxsense.file.FileResult$Error r11 = new com.uxsense.file.FileResult$Error     // Catch: java.io.IOException -> L6d
                com.uxsense.file.FileException$FileNotFound r1 = new com.uxsense.file.FileException$FileNotFound     // Catch: java.io.IOException -> L6d
                java.nio.file.Path r5 = r10.$path     // Catch: java.io.IOException -> L6d
                r1.<init>(r5)     // Catch: java.io.IOException -> L6d
                r11.<init>(r1)     // Catch: java.io.IOException -> L6d
                r10.L$0 = r8     // Catch: java.io.IOException -> L6d
                r10.label = r6     // Catch: java.io.IOException -> L6d
                java.lang.Object r10 = r8.emit(r11, r10)     // Catch: java.io.IOException -> L6d
                if (r10 != r0) goto Lcc
                goto Lcb
            L6d:
                r11 = move-exception
                r1 = r8
                goto Lb5
            L70:
                java.nio.file.Path r11 = r10.$path     // Catch: java.io.IOException -> L6d
                java.nio.charset.Charset r1 = j9.AbstractC1607a.f4778a     // Catch: java.io.IOException -> L6d
                java.io.BufferedReader r6 = java.nio.file.Files.newBufferedReader(r11, r1)     // Catch: java.io.IOException -> L6d
                kotlin.jvm.internal.k.c(r6)     // Catch: java.lang.Throwable -> L30
                D7.t r11 = new D7.t     // Catch: java.lang.Throwable -> L30
                r1 = 2
                r11.<init>(r6, r1)     // Catch: java.lang.Throwable -> L30
                i9.a r1 = new i9.a     // Catch: java.lang.Throwable -> L30
                r1.<init>(r11)     // Catch: java.lang.Throwable -> L30
                java.util.Iterator r11 = r1.iterator()     // Catch: java.lang.Throwable -> L30
                r1 = r11
            L8b:
                boolean r11 = r1.hasNext()     // Catch: java.lang.Throwable -> L30
                if (r11 == 0) goto Lab
                java.lang.Object r11 = r1.next()     // Catch: java.lang.Throwable -> L30
                java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L30
                com.uxsense.file.FileResult$Success r9 = new com.uxsense.file.FileResult$Success     // Catch: java.lang.Throwable -> L30
                r9.<init>(r11)     // Catch: java.lang.Throwable -> L30
                r10.L$0 = r8     // Catch: java.lang.Throwable -> L30
                r10.L$1 = r6     // Catch: java.lang.Throwable -> L30
                r10.L$2 = r1     // Catch: java.lang.Throwable -> L30
                r10.label = r5     // Catch: java.lang.Throwable -> L30
                java.lang.Object r11 = r8.emit(r9, r10)     // Catch: java.lang.Throwable -> L30
                if (r11 != r0) goto L8b
                goto Lcb
            Lab:
                D7.N.t(r6, r7)     // Catch: java.io.IOException -> L6d
                return r2
            Laf:
                throw r11     // Catch: java.lang.Throwable -> Lb0
            Lb0:
                r1 = move-exception
                D7.N.t(r6, r11)     // Catch: java.io.IOException -> L6d
                throw r1     // Catch: java.io.IOException -> L6d
            Lb5:
                com.uxsense.file.FileStorageManager r5 = r10.this$0
                java.nio.file.Path r6 = r10.$path
                com.uxsense.file.FileResult$Error r11 = com.uxsense.file.FileStorageManager.access$handleIOException(r5, r6, r11, r3)
                r10.L$0 = r7
                r10.L$1 = r7
                r10.L$2 = r7
                r10.label = r4
                java.lang.Object r10 = r1.emit(r11, r10)
                if (r10 != r0) goto Lcc
            Lcb:
                return r0
            Lcc:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uxsense.file.FileStorageManager.C12711.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(d dVar, H7.c<? super r> cVar) {
            return ((C12711) create(dVar, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$readText$2", f = "FileStorageManager.kt", l = {249}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$readText$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12722 extends SuspendLambda implements n {
        final /* synthetic */ Path $path;
        int label;

        @c(c = "com.uxsense.file.FileStorageManager$readText$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/uxsense/file/FileResult;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        /* renamed from: com.uxsense.file.FileStorageManager$readText$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.k {
            final /* synthetic */ Path $path;
            int label;
            final /* synthetic */ FileStorageManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FileStorageManager fileStorageManager, Path path, H7.c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = fileStorageManager;
                this.$path = path;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$path, cVar);
            }

            @Override // S7.k
            public final Object invoke(H7.c<? super FileResult<String>> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                try {
                    if (this.this$0.config.getEnableCache() && this.this$0.cache.containsKey(this.$path)) {
                        Object obj2 = this.this$0.cache.get(this.$path);
                        k.c(obj2);
                        return new FileResult.Success(new String((byte[]) obj2, AbstractC1607a.f4778a));
                    }
                    if (!Files.exists(this.$path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                        return new FileResult.Error(new FileException.FileNotFound(this.$path));
                    }
                    String strC = AbstractC0291a.C(this.$path);
                    if (this.this$0.config.getEnableCache()) {
                        Map map = this.this$0.cache;
                        Path path = this.$path;
                        byte[] bytes = strC.getBytes(AbstractC1607a.f4778a);
                        k.e(bytes, "getBytes(...)");
                        map.put(path, bytes);
                    }
                    return new FileResult.Success(strC);
                } catch (IOException e) {
                    return this.this$0.handleIOException(this.$path, e, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12722(Path path, H7.c<? super C12722> cVar) {
            super(2, cVar);
            this.$path = path;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12722(this.$path, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            FileStorageManager fileStorageManager = FileStorageManager.this;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fileStorageManager, this.$path, null);
            this.label = 1;
            Object objExecuteWithRetry = fileStorageManager.executeWithRetry(anonymousClass1, this);
            return objExecuteWithRetry == coroutineSingletons ? coroutineSingletons : objExecuteWithRetry;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<String>> cVar) {
            return ((C12722) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$writeBytes$2", f = "FileStorageManager.kt", l = {280}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$writeBytes$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12732 extends SuspendLambda implements n {
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ Path $path;
        int label;

        @c(c = "com.uxsense.file.FileStorageManager$writeBytes$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "()Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.file.FileStorageManager$writeBytes$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.k {
            final /* synthetic */ byte[] $bytes;
            final /* synthetic */ Path $path;
            int label;
            final /* synthetic */ FileStorageManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FileStorageManager fileStorageManager, Path path, byte[] bArr, H7.c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = fileStorageManager;
                this.$path = path;
                this.$bytes = bArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$path, this.$bytes, cVar);
            }

            @Override // S7.k
            public final Object invoke(H7.c<? super FileResult<r>> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                try {
                    this.this$0.ensureParentExists(this.$path);
                    Files.write(this.$path, this.$bytes, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
                    if (this.this$0.config.getEnableCache()) {
                        this.this$0.cache.put(this.$path, this.$bytes);
                    }
                    return new FileResult.Success(r.f317a);
                } catch (IOException e) {
                    return this.this$0.handleIOException(this.$path, e, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12732(Path path, byte[] bArr, H7.c<? super C12732> cVar) {
            super(2, cVar);
            this.$path = path;
            this.$bytes = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12732(this.$path, this.$bytes, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            FileStorageManager fileStorageManager = FileStorageManager.this;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fileStorageManager, this.$path, this.$bytes, null);
            this.label = 1;
            Object objExecuteWithRetry = fileStorageManager.executeWithRetry(anonymousClass1, this);
            return objExecuteWithRetry == coroutineSingletons ? coroutineSingletons : objExecuteWithRetry;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12732) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$writeJson$2", f = "FileStorageManager.kt", l = {438}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$writeJson$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12742 extends SuspendLambda implements n {
        final /* synthetic */ T $data;
        final /* synthetic */ Path $path;
        final /* synthetic */ f $serializer;
        int label;

        @c(c = "com.uxsense.file.FileStorageManager$writeJson$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "()Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.file.FileStorageManager$writeJson$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.k {
            final /* synthetic */ T $data;
            final /* synthetic */ Path $path;
            final /* synthetic */ f $serializer;
            int label;
            final /* synthetic */ FileStorageManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FileStorageManager fileStorageManager, Path path, f fVar, T t9, H7.c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = fileStorageManager;
                this.$path = path;
                this.$serializer = fVar;
                this.$data = t9;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$path, this.$serializer, this.$data, cVar);
            }

            @Override // S7.k
            public final Object invoke(H7.c<? super FileResult<r>> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                try {
                    this.this$0.ensureParentExists(this.$path);
                    String strB = this.this$0.config.getJson().b(this.$serializer, this.$data);
                    Charset charset = AbstractC1607a.f4778a;
                    AbstractC0291a.K(this.$path, strB, charset, new OpenOption[0]);
                    if (this.this$0.config.getEnableCache()) {
                        Map map = this.this$0.cache;
                        Path path = this.$path;
                        byte[] bytes = strB.getBytes(charset);
                        k.e(bytes, "getBytes(...)");
                        map.put(path, bytes);
                    }
                    return new FileResult.Success(r.f317a);
                } catch (IOException e) {
                    return this.this$0.handleIOException(this.$path, e, true);
                } catch (SerializationException e6) {
                    return new FileResult.Error(new FileException.WriteError(this.$path, e6));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12742(Path path, f fVar, T t9, H7.c<? super C12742> cVar) {
            super(2, cVar);
            this.$path = path;
            this.$serializer = fVar;
            this.$data = t9;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12742(this.$path, this.$serializer, this.$data, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            FileStorageManager fileStorageManager = FileStorageManager.this;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fileStorageManager, this.$path, this.$serializer, this.$data, null);
            this.label = 1;
            Object objExecuteWithRetry = fileStorageManager.executeWithRetry(anonymousClass1, this);
            return objExecuteWithRetry == coroutineSingletons ? coroutineSingletons : objExecuteWithRetry;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12742) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$writeLines$2", f = "FileStorageManager.kt", l = {356}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$writeLines$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12752 extends SuspendLambda implements n {
        final /* synthetic */ boolean $append;
        final /* synthetic */ p9.c $lines;
        final /* synthetic */ Path $path;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12752(Path path, boolean z10, p9.c cVar, H7.c<? super C12752> cVar2) {
            super(2, cVar2);
            this.$path = path;
            this.$append = z10;
            this.$lines = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12752(this.$path, this.$append, this.$lines, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Closeable closeable;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    closeable = (Closeable) this.L$0;
                    try {
                        b.b(obj);
                        N.t(closeable, null);
                        return new FileResult.Success(r.f317a);
                    } catch (Throwable th) {
                        th = th;
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            N.t(closeable, th);
                            throw th2;
                        }
                    }
                }
                b.b(obj);
                FileStorageManager.this.ensureParentExists(this.$path);
                Path path = this.$path;
                final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), AbstractC1607a.f4778a), FileStorageManager.this.config.getBufferSize());
                boolean z10 = this.$append;
                Path path2 = this.$path;
                p9.c cVar = this.$lines;
                if (z10) {
                    try {
                        if (Files.exists(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                            bufferedWriter.newLine();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        closeable = bufferedWriter;
                        throw th;
                    }
                }
                d dVar = new d() { // from class: com.uxsense.file.FileStorageManager$writeLines$2$1$1
                    @Override // p9.d
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar2) {
                        return emit((String) obj2, (H7.c<? super r>) cVar2);
                    }

                    public final Object emit(String str, H7.c<? super r> cVar2) throws IOException {
                        bufferedWriter.write(str);
                        bufferedWriter.newLine();
                        return r.f317a;
                    }
                };
                this.L$0 = bufferedWriter;
                this.label = 1;
                if (cVar.collect(dVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                closeable = bufferedWriter;
                N.t(closeable, null);
                return new FileResult.Success(r.f317a);
            } catch (IOException e) {
                return FileStorageManager.this.handleIOException(this.$path, e, true);
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12752) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.uxsense.file.FileStorageManager$writeText$2", f = "FileStorageManager.kt", l = {224}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lm9/z;", "Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "(Lm9/z;)Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
    /* renamed from: com.uxsense.file.FileStorageManager$writeText$2, reason: invalid class name and case insensitive filesystem */
    public static final class C12762 extends SuspendLambda implements n {
        final /* synthetic */ boolean $append;
        final /* synthetic */ String $content;
        final /* synthetic */ Path $path;
        int label;

        @c(c = "com.uxsense.file.FileStorageManager$writeText$2$1", f = "FileStorageManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/uxsense/file/FileResult;", "LC7/r;", "<anonymous>", "()Lcom/uxsense/file/FileResult;"}, k = 3, mv = {2, 1, 0})
        /* renamed from: com.uxsense.file.FileStorageManager$writeText$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements S7.k {
            final /* synthetic */ boolean $append;
            final /* synthetic */ String $content;
            final /* synthetic */ Path $path;
            int label;
            final /* synthetic */ FileStorageManager this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(FileStorageManager fileStorageManager, Path path, boolean z10, String str, H7.c<? super AnonymousClass1> cVar) {
                super(1, cVar);
                this.this$0 = fileStorageManager;
                this.$path = path;
                this.$append = z10;
                this.$content = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(H7.c<?> cVar) {
                return new AnonymousClass1(this.this$0, this.$path, this.$append, this.$content, cVar);
            }

            @Override // S7.k
            public final Object invoke(H7.c<? super FileResult<r>> cVar) {
                return ((AnonymousClass1) create(cVar)).invokeSuspend(r.f317a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                try {
                    this.this$0.ensureParentExists(this.$path);
                    if (this.$append && Files.exists(this.$path, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                        Path path = this.$path;
                        String text = this.$content;
                        Charset charset = AbstractC1607a.f4778a;
                        k.f(path, "<this>");
                        k.f(text, "text");
                        k.f(charset, "charset");
                        AbstractC0291a.K(path, text, charset, StandardOpenOption.APPEND);
                    } else {
                        AbstractC0291a.K(this.$path, this.$content, AbstractC1607a.f4778a, new OpenOption[0]);
                    }
                    if (this.this$0.config.getEnableCache()) {
                        Map map = this.this$0.cache;
                        Path path2 = this.$path;
                        byte[] bytes = this.$content.getBytes(AbstractC1607a.f4778a);
                        k.e(bytes, "getBytes(...)");
                        map.put(path2, bytes);
                    }
                    return new FileResult.Success(r.f317a);
                } catch (IOException e) {
                    return this.this$0.handleIOException(this.$path, e, true);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C12762(Path path, boolean z10, String str, H7.c<? super C12762> cVar) {
            super(2, cVar);
            this.$path = path;
            this.$append = z10;
            this.$content = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return FileStorageManager.this.new C12762(this.$path, this.$append, this.$content, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
                return obj;
            }
            b.b(obj);
            FileStorageManager fileStorageManager = FileStorageManager.this;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(fileStorageManager, this.$path, this.$append, this.$content, null);
            this.label = 1;
            Object objExecuteWithRetry = fileStorageManager.executeWithRetry(anonymousClass1, this);
            return objExecuteWithRetry == coroutineSingletons ? coroutineSingletons : objExecuteWithRetry;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super FileResult<r>> cVar) {
            return ((C12762) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FileStorageManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Object copyFile$default(FileStorageManager fileStorageManager, Path path, Path path2, boolean z10, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = false;
        }
        return fileStorageManager.copyFile(path, path2, z10, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ensureParentExists(Path path) {
        Path parent = path.getParent();
        if (parent != null) {
            k.e(Files.createDirectories(parent, (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)), "createDirectories(...)");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b7 -> B:33:0x00bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00c2 -> B:35:0x00c5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object executeWithRetry(S7.k r12, H7.c<? super com.uxsense.file.FileResult<? extends T>> r13) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxsense.file.FileStorageManager.executeWithRetry(S7.k, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileResult.Error handleIOException(Path path, IOException e, boolean isWrite) {
        if (e instanceof FileNotFoundException) {
            return new FileResult.Error(new FileException.FileNotFound(path));
        }
        if (e instanceof AccessDeniedException) {
            return new FileResult.Error(new FileException.PermissionDenied(path));
        }
        String message = e.getMessage();
        return (message == null || !m.h0(message, "No space left", false)) ? isWrite ? new FileResult.Error(new FileException.WriteError(path, e)) : new FileResult.Error(new FileException.ReadError(path, e)) : new FileResult.Error(new FileException.DiskFull(path));
    }

    public static /* synthetic */ Object writeLines$default(FileStorageManager fileStorageManager, Path path, p9.c cVar, boolean z10, H7.c cVar2, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = false;
        }
        return fileStorageManager.writeLines(path, cVar, z10, cVar2);
    }

    public static /* synthetic */ Object writeText$default(FileStorageManager fileStorageManager, Path path, String str, boolean z10, H7.c cVar, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = false;
        }
        return fileStorageManager.writeText(path, str, z10, cVar);
    }

    public final Object batchWrite(List<? extends Pair<? extends Path, String>> list, H7.c<? super List<? extends FileResult<r>>> cVar) {
        return AbstractC1683A.f(new AnonymousClass2(list, this, null), cVar);
    }

    public final void clearCache() {
        this.cache.clear();
    }

    public final Object copyFile(Path path, Path path2, boolean z10, H7.c<? super FileResult<r>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12652(path, this, path2, z10, null), cVar);
    }

    public final Object deleteFile(Path path, H7.c<? super FileResult<Boolean>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12662(path, null), cVar);
    }

    public final Object exists(Path path, H7.c<? super Boolean> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12672(path, null), cVar);
    }

    public final Object getFileSize(Path path, H7.c<? super FileResult<Long>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12682(path, null), cVar);
    }

    public final Object readBytes(Path path, H7.c<? super FileResult<byte[]>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12692(path, null), cVar);
    }

    public final <T> Object readJson(Path path, InterfaceC2123a interfaceC2123a, H7.c<? super FileResult<? extends T>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12702(path, interfaceC2123a, null), cVar);
    }

    public final p9.c readLines(Path path) {
        k.f(path, "path");
        return kotlinx.coroutines.flow.d.j(new p9.m(new C12711(path, this, null)), this.config.getDispatcher());
    }

    public final Object readText(Path path, H7.c<? super FileResult<String>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12722(path, null), cVar);
    }

    public final Object writeBytes(Path path, byte[] bArr, H7.c<? super FileResult<r>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12732(path, bArr, null), cVar);
    }

    public final <T> Object writeJson(Path path, T t9, f fVar, H7.c<? super FileResult<r>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12742(path, fVar, t9, null), cVar);
    }

    public final Object writeLines(Path path, p9.c cVar, boolean z10, H7.c<? super FileResult<r>> cVar2) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12752(path, z10, cVar, null), cVar2);
    }

    public final Object writeText(Path path, String str, boolean z10, H7.c<? super FileResult<r>> cVar) {
        return AbstractC1683A.w(this.config.getDispatcher(), new C12762(path, z10, str, null), cVar);
    }

    public FileStorageManager(FileStorageConfig config) {
        k.f(config, "config");
        this.config = config;
        this.cache = new LinkedHashMap();
    }

    public /* synthetic */ FileStorageManager(FileStorageConfig fileStorageConfig, int i, e eVar) {
        this((i & 1) != 0 ? new FileStorageConfig(0, false, 0, 0L, null, null, 63, null) : fileStorageConfig);
    }
}
