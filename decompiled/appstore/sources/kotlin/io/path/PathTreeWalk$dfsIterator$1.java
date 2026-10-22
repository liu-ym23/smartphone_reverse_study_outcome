package kotlin.io.path;

import androidx.appcompat.widget.p;
import java.nio.file.FileSystemLoopException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/sequences/g;", "Ljava/nio/file/Path;", "", "<anonymous>", "(Lkotlin/sequences/g;)V"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlin.io.path.PathTreeWalk$dfsIterator$1", f = "PathTreeWalk.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3}, l = {184, 190, 199, 205}, m = "invokeSuspend", n = {"$this$iterator", "stack", "entriesReader", "startNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader", "$this$iterator", "stack", "entriesReader", "pathNode", "this_$iv", "path$iv", "$this$iterator", "stack", "entriesReader"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nPathTreeWalk.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n+ 2 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk\n*L\n1#1,177:1\n45#2,15:178\n45#2,15:193\n*S KotlinDebug\n*F\n+ 1 PathTreeWalk.kt\nkotlin/io/path/PathTreeWalk$dfsIterator$1\n*L\n67#1:178,15\n78#1:193,15\n*E\n"})
final class PathTreeWalk$dfsIterator$1 extends RestrictedSuspendLambda implements Function2<kotlin.sequences.g, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ g this$0;

    public PathTreeWalk$dfsIterator$1(g r10, Continuation<? super PathTreeWalk$dfsIterator$1> r11) {
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        PathTreeWalk$dfsIterator$1 r12 = new PathTreeWalk$dfsIterator$1(null, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(kotlin.sequences.g r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01ae -> B:36:0x0132). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x01b0 -> B:36:0x0132). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r14) {
        Object r10 = kotlin.coroutines.intrinsics.a.d();
        int r11 = this.label;
        if (r11 == 0) goto L14;
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L12;
        if (r11 == 3) goto L11;
        if (r11 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        Path r12 = (Path) this.L$5;
        p.a(this.L$4);
        e r13 = (e) this.L$3;
        b r15 = (b) this.L$2;
        kotlin.collections.i r16 = (kotlin.collections.i) this.L$1;
        kotlin.sequences.g r17 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r14);
    L50:
        e r18 = r13;
        kotlin.collections.i r19 = r16;
        Path r20 = r12;
        b r21 = r15;
        kotlin.sequences.g r22 = r17;
    L51:
        LinkOption[] r23 = g.c(null);
        LinkOption[] r24 = (LinkOption[]) Arrays.copyOf(r23, r23.length);
        if (Files.isDirectory(r20, (LinkOption[]) Arrays.copyOf(r24, r24.length)) == false) goto L37;
        r18.e(r21.b(r18).iterator());
        r19.addLast(r18);
    L37:
        if (r19.isEmpty() == true) goto L63;
        Iterator r110 = ((e) r19.last()).a();
        q.d(r110);
        if (r110.hasNext() == true) goto L40;
        r19.removeLast();
        goto L37
    L40:
        r18 = (e) r110.next();
        r20 = r18.d();
        LinkOption[] r25 = g.c(null);
        LinkOption[] r26 = (LinkOption[]) Arrays.copyOf(r25, r25.length);
        if (Files.isDirectory(r20, (LinkOption[]) Arrays.copyOf(r26, r26.length)) == true) goto L43;
        if (Files.exists(r20, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L37;
        this.L$0 = r22;
        this.L$1 = r19;
        this.L$2 = r21;
        this.L$3 = null;
        this.L$4 = null;
        this.L$5 = null;
        this.label = 4;
        if (r22.a(r20, this) != r10) goto L37;
        return r10;
    L43:
        if (h.a(r18) == true) goto L55;
        if (g.b(null) == false) goto L51;
        this.L$0 = r22;
        this.L$1 = r19;
        this.L$2 = r21;
        this.L$3 = r18;
        this.L$4 = null;
        this.L$5 = r20;
        this.label = 3;
        if (r22.a(r20, this) != r10) goto L49;
        return r10;
    L49:
        r17 = r22;
        r15 = r21;
        r12 = r20;
        r16 = r19;
        r13 = r18;
        goto L50
    L55:
        throw new FileSystemLoopException(r20.toString());
    L63:
        return Unit.f21064a;
    L12:
        r21 = (b) this.L$2;
        r19 = (kotlin.collections.i) this.L$1;
        r22 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r14);
        goto L37
    L13:
        Path r27 = (Path) this.L$5;
        p.a(this.L$4);
        e r28 = (e) this.L$3;
        b r29 = (b) this.L$2;
        kotlin.collections.i r30 = (kotlin.collections.i) this.L$1;
        kotlin.sequences.g r31 = (kotlin.sequences.g) this.L$0;
        kotlin.c.b(r14);
    L24:
        kotlin.collections.i r111 = r30;
        e r32 = r28;
        kotlin.sequences.g r112 = r31;
        Path r33 = r27;
        r21 = r29;
        r22 = r112;
    L25:
        LinkOption[] r34 = g.c(null);
        LinkOption[] r35 = (LinkOption[]) Arrays.copyOf(r34, r34.length);
        if (Files.isDirectory(r33, (LinkOption[]) Arrays.copyOf(r35, r35.length)) == false) goto L28;
        r32.e(r21.b(r32).iterator());
        r111.addLast(r32);
    L28:
        r19 = r111;
        goto L37
    L14:
        kotlin.c.b(r14);
        r22 = (kotlin.sequences.g) this.L$0;
        r111 = new kotlin.collections.i();
        r21 = new b(g.a(null));
        r32 = new e(g.d(null), h.b(g.d(null), g.c(null)), null);
        r33 = r32.d();
        LinkOption[] r113 = g.c(null);
        LinkOption[] r114 = (LinkOption[]) Arrays.copyOf(r113, r113.length);
        if (Files.isDirectory(r33, (LinkOption[]) Arrays.copyOf(r114, r114.length)) == false) goto L32;
        if (h.a(r32) == true) goto L30;
        if (g.b(null) == false) goto L25;
        this.L$0 = r22;
        this.L$1 = r111;
        this.L$2 = r21;
        this.L$3 = r32;
        this.L$4 = null;
        this.L$5 = r33;
        this.label = 1;
        if (r22.a(r33, this) != r10) goto L23;
        return r10;
    L23:
        r28 = r32;
        r30 = r111;
        r29 = r21;
        r27 = r33;
        r31 = r22;
        goto L24
    L30:
        throw new FileSystemLoopException(r33.toString());
    L32:
        if (Files.exists(r33, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L28;
        this.L$0 = r22;
        this.L$1 = r111;
        this.L$2 = r21;
        this.label = 2;
        if (r22.a(r33, this) != r10) goto L28;
        return r10;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull kotlin.sequences.g r10, @Nullable Continuation<? super Unit> r11) {
        return ((PathTreeWalk$dfsIterator$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
