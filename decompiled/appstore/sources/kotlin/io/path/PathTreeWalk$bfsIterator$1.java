package kotlin.io.path;

import androidx.appcompat.widget.p;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/g;", "Ljava/nio/file/Path;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$bfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {184, 190}, m = "invokeSuspend", n = {"$this$iterator", "queue", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "queue", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$bfsIterator$1\n*L\n98#1:178,15\n*E\n"})
final class PathTreeWalk$bfsIterator$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.g, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ g this$0;

    public PathTreeWalk$bfsIterator$1(g r10, Continuation<? super PathTreeWalk$bfsIterator$1> r11) {
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        PathTreeWalk$bfsIterator$1 r12 = new PathTreeWalk$bfsIterator$1(null, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlin.sequences.g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00df -> B:11:0x0076). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00e1 -> B:11:0x0076). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r12) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L10;
        if (r11 == 1) goto L9;
        if (r11 != 2) goto L8;
        b r13 = (b) this.L$2;
        kotlin.collections.i r14 = (kotlin.collections.i) this.L$1;
        kotlin.sequences.g r15 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r12);
    L12:
        if (r14.isEmpty() == true) goto L35;
        e r16 = (e) r14.removeFirst();
        Path r17 = r16.d();
        LinkOption[] r18 = g.c(null);
        LinkOption[] r19 = (LinkOption[]) Arrays.copyOf(r18, r18.length);
        if (Files.isDirectory(r17, (LinkOption[]) Arrays.copyOf(r19, r19.length)) == true) goto L16;
        if (Files.exists(r17, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L12;
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 2;
        if (r15.a(r17, this) != r10) goto L12;
        return r10;
    L16:
        if (h.a(r16) == true) goto L28;
        if (g.b(null) == false) goto L24;
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = r13;
        this.L$3 = r16;
        this.L$4 = null;
        this.L$5 = r17;
        this.label = 1;
        if (r15.a(r17, this) != r10) goto L22;
        return r10;
    L22:
        kotlin.sequences.g r20 = r15;
        b r21 = r13;
        Path r22 = r17;
        kotlin.collections.i r23 = r14;
        e r24 = r16;
    L23:
        r16 = r24;
        r14 = r23;
        r17 = r22;
        r13 = r21;
        r15 = r20;
    L24:
        LinkOption[] r25 = g.c(null);
        LinkOption[] r26 = (LinkOption[]) Arrays.copyOf(r25, r25.length);
        if (Files.isDirectory(r17, (LinkOption[]) Arrays.copyOf(r26, r26.length)) == false) goto L12;
        r14.addAll(r13.b(r16));
        goto L12
    L28:
        throw new FileSystemLoopException(r17.toString());
    L35:
        return Unit.f21064a;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r22 = (Path) this.L$5;
        p.a(this.L$4);
        r24 = (e) this.L$3;
        r21 = (b) this.L$2;
        r23 = (kotlin.collections.i) this.L$1;
        r20 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r12);
        goto L23
    L10:
        kotlin.c.b(r12);
        kotlin.sequences.g r110 = (kotlin.sequences.g) this.L$0;
        kotlin.collections.i r27 = new kotlin.collections.i();
        b r28 = new b(g.a(null));
        r27.addLast(new e(g.d(null), h.b(g.d(null), g.c(null)), null));
        r15 = r110;
        r14 = r27;
        r13 = r28;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull kotlin.sequences.g r10, @Nullable Continuation<? super Unit> r11) {
        return ((PathTreeWalk$bfsIterator$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
