package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlin/io/path/FileVisitorBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5 extends Lambda implements Function1<FileVisitorBuilder, Unit> {
    final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
    final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
    final /* synthetic */ Path $target;
    final /* synthetic */ Path $this_copyToRecursively;

    /* JADX INFO: renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$1, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
        final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
        final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
        final /* synthetic */ Path $target;
        final /* synthetic */ Path $this_copyToRecursively;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r10, Path r11, Path r12, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r13) {
            this.$copyAction = r10;
            this.$this_copyToRecursively = r11;
            this.$target = r12;
            this.$onError = r13;
            super(2, q.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ FileVisitResult mo0invoke(Path r10, BasicFileAttributes r11) {
            return invoke2(r10, r11);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final FileVisitResult invoke2(@NotNull Path r10, @NotNull BasicFileAttributes r11) {
            q.g(r10, "p0");
            q.g(r11, "p1");
            return j.a(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, r10, r11);
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function2<Path, BasicFileAttributes, FileVisitResult> {
        final /* synthetic */ Function3<CopyActionContext, Path, Path, CopyActionResult> $copyAction;
        final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
        final /* synthetic */ Path $target;
        final /* synthetic */ Path $this_copyToRecursively;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r10, Path r11, Path r12, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r13) {
            this.$copyAction = r10;
            this.$this_copyToRecursively = r11;
            this.$target = r12;
            this.$onError = r13;
            super(2, q.a.class, "copy", "copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/attribute/BasicFileAttributes;)Ljava/nio/file/FileVisitResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ FileVisitResult mo0invoke(Path r10, BasicFileAttributes r11) {
            return invoke2(r10, r11);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final FileVisitResult invoke2(@NotNull Path r10, @NotNull BasicFileAttributes r11) {
            q.g(r10, "p0");
            q.g(r11, "p1");
            return j.a(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError, r10, r11);
        }
    }

    /* JADX INFO: renamed from: kotlin.io.path.PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3, reason: invalid class name */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function2<Path, Exception, FileVisitResult> {
        final /* synthetic */ Function3<Path, Path, Exception, OnErrorResult> $onError;
        final /* synthetic */ Path $target;
        final /* synthetic */ Path $this_copyToRecursively;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r10, Path r11, Path r12) {
            this.$onError = r10;
            this.$this_copyToRecursively = r11;
            this.$target = r12;
            super(2, q.a.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ FileVisitResult mo0invoke(Path r10, Exception r11) {
            return invoke2(r10, r11);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final FileVisitResult invoke2(@NotNull Path r10, @NotNull Exception r11) {
            q.g(r10, "p0");
            q.g(r11, "p1");
            return j.b(this.$onError, this.$this_copyToRecursively, this.$target, r10, r11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r10, Path r11, Path r12, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r13) {
        this.$copyAction = r10;
        this.$this_copyToRecursively = r11;
        this.$target = r12;
        this.$onError = r13;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FileVisitorBuilder r10) {
        invoke2(r10);
        return Unit.f21064a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull FileVisitorBuilder r10) {
        q.g(r10, "$this$visitFileTree");
        r10.onPreVisitDirectory(new AnonymousClass1(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError));
        r10.onVisitFile(new AnonymousClass2(this.$copyAction, this.$this_copyToRecursively, this.$target, this.$onError));
        r10.onVisitFileFailed(new AnonymousClass3(this.$onError, this.$this_copyToRecursively, this.$target));
        final Function3<Path, Path, Exception, OnErrorResult> r11 = this.$onError;
        final Path r12 = this.$this_copyToRecursively;
        final Path r13 = this.$target;
        r10.onPostVisitDirectory(new AnonymousClass4(r11, r12, r13));
    }
}
