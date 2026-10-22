package androidx.compose.runtime.snapshots;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0001\u0018\u0000 ,2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001:\u0001,B5\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003\u0012\u000e\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00002\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\n\u0010\u0010\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000J\u0013\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u001bH\u0096\u0002J>\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00002+\u0010\u001e\u001a'\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020\u00000\u001fH\u0082\bJ!\u0010#\u001a\u00020$2\u0016\u0010%\u001a\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0004\u0012\u00020$0&H\u0086\bJ\u001b\u0010'\u001a\u00060\u0002j\u0002`\u00032\n\u0010(\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0002\u0010)J\b\u0010*\u001a\u00020+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0018\u0010\u0007\u001a\n\u0018\u00010\bj\u0004\u0018\u0001`\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006-"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "upperSet", "lowerSet", "lowerBound", "belowBound", "", "Landroidx/compose/runtime/snapshots/SnapshotIdArray;", "<init>", "(JJJ[J)V", "J", "[J", MonitorConstants.CONNECT_TYPE_GET, "", "id", "(J)Z", "set", "(J)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "clear", "andNot", "ids", "and", SRStrategy.KEY_ORIGIN_RESOLUTION, "bits", "iterator", "", "fastFold", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "fastForEach", "", "block", "Lkotlin/Function1;", "lowest", "default", "(J)J", "toString", "", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotIdSet implements Iterable<Long>, KMappedMarker {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final SnapshotIdSet EMPTY = null;
    private final long[] belowBound;
    private final long lowerBound;
    private final long lowerSet;
    private final long upperSet;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotIdSet$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getEMPTY", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final SnapshotIdSet getEMPTY() {
            return SnapshotIdSet.access$getEMPTY$cp();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", i = {0, 0, 1, 1, 2, 2}, l = {252, 256, MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE}, m = "invokeSuspend", n = {"$this$sequence", "$this$forEach$iv", "$this$sequence", "index", "$this$sequence", "index"}, s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Long>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SnapshotIdSet this$0;

        public AnonymousClass1(SnapshotIdSet r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass1 r102 = new AnonymousClass1(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Long> r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super Long> r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0079 -> B:19:0x007c). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009c -> B:31:0x00b9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b6 -> B:31:0x00b9). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f7 -> B:43:0x00fb). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00fa -> B:43:0x00fb). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            long r102 = 1;
            long r110 = 0;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            int r103 = this.I$0;
            SequenceScope r104 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            int r105 = r103;
            AnonymousClass1 r106 = this;
        L43:
            r105 = r105 + 1;
            r110 = 0;
        L36:
            if (r105 >= 64) goto L45;
            if ((SnapshotIdSet.access$getUpperSet$p(r106.this$0) & (1 << r105)) == r110) goto L43;
            Long r107 = Boxing.boxLong((SnapshotIdSet.access$getLowerBound$p(r106.this$0) + ((long) r105)) + ((long) 64));
            r106.L$0 = r104;
            r106.L$1 = null;
            r106.I$0 = r105;
            r106.label = 3;
            if (r104.yield(r107, r106) != r100) goto L43;
            return r100;
        L45:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r108 = this.I$0;
            SequenceScope r111 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            AnonymousClass1 r109 = this;
        L31:
            r108 = r108 + 1;
            r102 = 1;
        L25:
            if (r108 < 64) goto L27;
            SequenceScope r112 = r111;
        L34:
            if (SnapshotIdSet.access$getUpperSet$p(r109.this$0) == 0) goto L45;
            r104 = r112;
            r106 = r109;
            r105 = 0;
            goto L36
        L27:
            if ((SnapshotIdSet.access$getLowerSet$p(r109.this$0) & (r102 << r108)) == 0) goto L31;
            Long r113 = Boxing.boxLong(SnapshotIdSet.access$getLowerBound$p(r109.this$0) + ((long) r108));
            r109.L$0 = r111;
            r109.L$1 = null;
            r109.I$0 = r108;
            r109.label = 2;
            if (r111.yield(r113, r109) != r100) goto L31;
            return r100;
        L11:
            int r114 = this.I$1;
            int r115 = this.I$0;
            long[] r116 = (long[]) this.L$1;
            SequenceScope r117 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            r109 = this;
        L19:
            r115 = r115 + 1;
        L15:
            if (r115 >= r114) goto L20;
            Long r118 = Boxing.boxLong(r116[r115]);
            r109.L$0 = r117;
            r109.L$1 = r116;
            r109.I$0 = r115;
            r109.I$1 = r114;
            r109.label = 1;
            if (r117.yield(r118, r109) != r100) goto L19;
            return r100;
        L20:
            r112 = r117;
        L23:
            if (SnapshotIdSet.access$getLowerSet$p(r109.this$0) == 0) goto L34;
            r111 = r112;
            r108 = 0;
            goto L25
        L12:
            ResultKt.throwOnFailure(r210);
            r112 = (SequenceScope) this.L$0;
            long[] r119 = SnapshotIdSet.access$getBelowBound$p(this.this$0);
            if (r119 == null) goto L21;
            r109 = this;
            r117 = r112;
            r114 = r119.length;
            r116 = r119;
            r115 = 0;
            goto L15
        L21:
            r109 = this;
            goto L23
        }
    }

    static {
        Companion = new Companion(null);
        EMPTY = new SnapshotIdSet(0, 0, 0, null);
    }

    @Override // java.lang.Iterable
    public Iterator<Long> iterator() {
        return SequencesKt.sequence(new AnonymousClass1(this, null)).iterator();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(super.toString());
        r100.append(" [");
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(this, 10));
        Iterator<Long> r102 = iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(String.valueOf(r102.next().longValue()));
        goto L4
    L6:
        r100.append(ListUtilsKt.fastJoinToString$default(r101, null, null, null, 0, null, null, 63, null));
        r100.append(']');
        return r100.toString();
    }

    public static final /* synthetic */ SnapshotIdSet access$getEMPTY$cp() {
        return EMPTY;
    }

    public static final /* synthetic */ long[] access$getBelowBound$p(SnapshotIdSet r100) {
        return r100.belowBound;
    }

    public static final /* synthetic */ long access$getLowerBound$p(SnapshotIdSet r100) {
        return r100.lowerBound;
    }

    public static final /* synthetic */ long access$getLowerSet$p(SnapshotIdSet r100) {
        return r100.lowerSet;
    }

    public static final /* synthetic */ long access$getUpperSet$p(SnapshotIdSet r100) {
        return r100.upperSet;
    }

    public final SnapshotIdSet and(SnapshotIdSet r210) {
        SnapshotIdSet r100 = EMPTY;
        if (Intrinsics.areEqual(r210, r100) == false) goto L6;
        return r100;
    L6:
        if (Intrinsics.areEqual(this, r100) == false) goto L8;
        return r100;
    L8:
        long r101 = r210.lowerBound;
        long r110 = this.lowerBound;
        if (r101 != r110) goto L19;
        long[] r102 = r210.belowBound;
        long[] r111 = this.belowBound;
        if (r102 != r111) goto L19;
        long r103 = this.upperSet;
        long r104 = r210.upperSet;
        long r112 = r103 & r104;
        long r105 = this.lowerSet;
        long r106 = r210.lowerSet;
        long r113 = r105 & r106;
        if (r112 != 0) goto L98;
        if (r113 != 0) goto L98;
        if (r111 != null) goto L98;
        return r100;
    L98:
        return new SnapshotIdSet(r103 & r104, r105 & r106, r110, r111);
    L19:
        SnapshotIdSet r107 = r100;
        int r108 = 0;
        if (this.belowBound != null) goto L48;
        long[] r109 = access$getBelowBound$p(this);
        if (r109 == null) goto L29;
        int r114 = r109.length;
        int r115 = 0;
    L24:
        if (r115 >= r114) goto L29;
        long r116 = r109[r115];
        if (r210.get(r116) == false) goto L28;
        r107 = r107.set(r116);
    L28:
        r115 = r115 + 1;
    L29:
        SnapshotIdSet r117 = r107;
        long r118 = 0;
        if (access$getLowerSet$p(this) == 0) goto L39;
        int r119 = 0;
    L32:
        if (r119 >= 64) goto L39;
        if ((access$getLowerSet$p(this) & (1 << r119)) == r118) goto L38;
        long r120 = access$getLowerBound$p(this) + ((long) r119);
        if (r210.get(r120) == false) goto L38;
        r117 = r117.set(r120);
    L38:
        r119 = r119 + 1;
        r118 = 0;
    L39:
        long r121 = 0;
        if (access$getUpperSet$p(this) == 0) goto L99;
    L41:
        if (r108 >= 64) goto L101;
        if ((access$getUpperSet$p(this) & (1 << r108)) == r121) goto L47;
        long r122 = (access$getLowerBound$p(this) + ((long) r108)) + ((long) 64);
        if (r210.get(r122) == false) goto L47;
        r117 = r117.set(r122);
    L47:
        r108 = r108 + 1;
        r121 = 0;
        goto L41
    L101:
        return r117;
    L99:
        return r117;
    L48:
        long[] r123 = access$getBelowBound$p(r210);
        if (r123 == null) goto L56;
        int r124 = r123.length;
        int r125 = 0;
    L51:
        if (r125 >= r124) goto L56;
        long r126 = r123[r125];
        if (get(r126) == false) goto L55;
        r107 = r107.set(r126);
    L55:
        r125 = r125 + 1;
    L56:
        SnapshotIdSet r127 = r107;
        long r128 = 0;
        if (access$getLowerSet$p(r210) == 0) goto L67;
        int r129 = 0;
    L59:
        if (r129 >= 64) goto L67;
        if ((access$getLowerSet$p(r210) & (1 << r129)) == r128) goto L65;
        long r130 = access$getLowerBound$p(r210) + ((long) r129);
        if (get(r130) == false) goto L65;
        r127 = r127.set(r130);
    L65:
        r129 = r129 + 1;
        r128 = 0;
    L67:
        if (access$getUpperSet$p(r210) == 0) goto L100;
    L68:
        if (r108 >= 64) goto L102;
        if ((access$getUpperSet$p(r210) & (1 << r108)) == 0) goto L74;
        long r131 = (access$getLowerBound$p(r210) + ((long) r108)) + ((long) 64);
        if (get(r131) == false) goto L74;
        r127 = r127.set(r131);
    L74:
        r108 = r108 + 1;
        goto L68
    L102:
        return r127;
    L100:
        return r127;
    }

    public final SnapshotIdSet andNot(SnapshotIdSet r110) {
        SnapshotIdSet r100 = EMPTY;
        if (r110 != r100) goto L5;
        return this;
    L5:
        if (this != r100) goto L7;
        return r100;
    L7:
        long r101 = r110.lowerBound;
        long r102 = this.lowerBound;
        if (r101 != r102) goto L12;
        long[] r103 = r110.belowBound;
        long[] r104 = this.belowBound;
        if (r103 != r104) goto L12;
        long r105 = this.upperSet;
        long r106 = (~r110.upperSet) & r105;
        long r107 = this.lowerSet;
        return new SnapshotIdSet(r106, (~r110.lowerSet) & r107, r102, r104);
    L12:
        long[] r108 = access$getBelowBound$p(r110);
        int r109 = 0;
        if (r108 == null) goto L17;
        int r111 = r108.length;
        SnapshotIdSet r112 = this;
        int r113 = 0;
    L15:
        if (r113 >= r111) goto L19;
        r112 = r112.clear(r108[r113]);
        r113 = r113 + 1;
    L19:
        if (access$getLowerSet$p(r110) == 0) goto L27;
        int r114 = 0;
    L21:
        if (r114 >= 64) goto L27;
        if ((access$getLowerSet$p(r110) & (1 << r114)) == 0) goto L25;
        r112 = r112.clear(access$getLowerBound$p(r110) + ((long) r114));
    L25:
        r114 = r114 + 1;
    L27:
        if (access$getUpperSet$p(r110) == 0) goto L34;
    L28:
        if (r109 >= 64) goto L34;
        if ((access$getUpperSet$p(r110) & (1 << r109)) == 0) goto L32;
        r112 = r112.clear((access$getLowerBound$p(r110) + ((long) r109)) + ((long) 64));
    L32:
        r109 = r109 + 1;
    L34:
        return r112;
    L17:
        r112 = this;
        goto L19
    }

    public final SnapshotIdSet clear(long r110) {
        long r100 = r110 - this.lowerBound;
        long r101 = 0;
        if (Intrinsics.compare(r100, r101) < 0) goto L11;
        if (Intrinsics.compare(r100, 64) >= 0) goto L11;
        long r111 = 1 << ((int) r100);
        long r102 = this.lowerSet;
        if ((r102 & r111) != 0) goto L9;
    L26:
        return this;
    L9:
        return new SnapshotIdSet(this.upperSet, r102 & (~r111), this.lowerBound, this.belowBound);
    L11:
        if (Intrinsics.compare(r100, 64) < 0) goto L19;
        if (Intrinsics.compare(r100, 128) >= 0) goto L19;
        long r112 = 1 << (((int) r100) - 64);
        long r103 = this.upperSet;
        if ((r103 & r112) == 0) goto L26;
        return new SnapshotIdSet(r103 & (~r112), this.lowerSet, this.lowerBound, this.belowBound);
    L19:
        if (Intrinsics.compare(r100, r101) >= 0) goto L26;
        long[] r104 = this.belowBound;
        if (r104 == null) goto L26;
        int r113 = SnapshotId_jvmKt.binarySearch(r104, r110);
        if (r113 < 0) goto L26;
        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdRemovedAt(r104, r113));
    }

    public final void fastForEach(Function1<? super Long, Unit> r110) {
        long[] r100 = access$getBelowBound$p(this);
        int r101 = 0;
        if (r100 == null) goto L8;
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        r110.invoke(Long.valueOf(r100[r103]));
        r103 = r103 + 1;
    L8:
        if (access$getLowerSet$p(this) == 0) goto L16;
        int r104 = 0;
    L10:
        if (r104 >= 64) goto L16;
        if ((access$getLowerSet$p(this) & (1 << r104)) == 0) goto L14;
        r110.invoke(Long.valueOf(access$getLowerBound$p(this) + ((long) r104)));
    L14:
        r104 = r104 + 1;
    L16:
        if (access$getUpperSet$p(this) == 0) goto L22;
    L17:
        if (r101 >= 64) goto L30;
        if ((access$getUpperSet$p(this) & (1 << r101)) == 0) goto L21;
        r110.invoke(Long.valueOf((access$getLowerBound$p(this) + ((long) r101)) + ((long) 64)));
    L21:
        r101 = r101 + 1;
        goto L17
    L30:
        return;
    }

    public final boolean get(long r110) {
        long r100 = r110 - this.lowerBound;
        long r101 = 0;
        if (Intrinsics.compare(r100, r101) < 0) goto L10;
        if (Intrinsics.compare(r100, 64) >= 0) goto L10;
        if (((1 << ((int) r100)) & this.lowerSet) == 0) goto L18;
    L8:
        return true;
    L18:
        return false;
    L10:
        if (Intrinsics.compare(r100, 64) < 0) goto L17;
        if (Intrinsics.compare(r100, 128) >= 0) goto L17;
        if (((1 << (((int) r100) - 64)) & this.upperSet) == 0) goto L18;
    L17:
        if (Intrinsics.compare(r100, r101) > 0) goto L18;
        long[] r102 = this.belowBound;
        if (r102 == null) goto L18;
        if (SnapshotId_jvmKt.binarySearch(r102, r110) < 0) goto L18;
        goto L18
    }

    public final long lowest(long r100) {
        long[] r101 = this.belowBound;
        if (r101 != null) goto L5;
        long r102 = this.lowerSet;
        if (r102 != 0) goto L9;
        long r103 = this.upperSet;
        if (r103 != 0) goto L13;
        return r100;
    L13:
        return (this.lowerBound + ((long) 64)) + ((long) Long.numberOfTrailingZeros(r103));
    L9:
        return this.lowerBound + ((long) Long.numberOfTrailingZeros(r102));
    L5:
        return r101[0];
    }

    public final SnapshotIdSet or(SnapshotIdSet r110) {
        SnapshotIdSet r100 = EMPTY;
        if (r110 != r100) goto L5;
        return this;
    L5:
        if (this != r100) goto L7;
        return r110;
    L7:
        long r101 = r110.lowerBound;
        long r102 = this.lowerBound;
        if (r101 != r102) goto L12;
        long[] r103 = r110.belowBound;
        long[] r104 = this.belowBound;
        if (r103 != r104) goto L12;
        long r105 = this.upperSet;
        long r106 = r110.upperSet | r105;
        long r107 = this.lowerSet;
        return new SnapshotIdSet(r106, r110.lowerSet | r107, r102, r104);
    L12:
        int r108 = 0;
        if (this.belowBound != null) goto L35;
        long[] r109 = access$getBelowBound$p(this);
        if (r109 == null) goto L20;
        int r111 = r109.length;
        int r112 = 0;
    L17:
        if (r112 >= r111) goto L20;
        r110 = r110.set(r109[r112]);
        r112 = r112 + 1;
    L20:
        if (access$getLowerSet$p(this) == 0) goto L28;
        int r113 = 0;
    L22:
        if (r113 >= 64) goto L28;
        if ((access$getLowerSet$p(this) & (1 << r113)) == 0) goto L26;
        r110 = r110.set(access$getLowerBound$p(this) + ((long) r113));
    L26:
        r113 = r113 + 1;
    L28:
        if (access$getUpperSet$p(this) == 0) goto L73;
    L29:
        if (r108 >= 64) goto L73;
        if ((access$getUpperSet$p(this) & (1 << r108)) == 0) goto L33;
        r110 = r110.set((access$getLowerBound$p(this) + ((long) r108)) + ((long) 64));
    L33:
        r108 = r108 + 1;
    L73:
        return r110;
    L35:
        long[] r114 = access$getBelowBound$p(r110);
        if (r114 == null) goto L40;
        int r115 = r114.length;
        SnapshotIdSet r116 = this;
        int r117 = 0;
    L38:
        if (r117 >= r115) goto L42;
        r116 = r116.set(r114[r117]);
        r117 = r117 + 1;
    L42:
        if (access$getLowerSet$p(r110) == 0) goto L50;
        int r118 = 0;
    L44:
        if (r118 >= 64) goto L50;
        if ((access$getLowerSet$p(r110) & (1 << r118)) == 0) goto L48;
        r116 = r116.set(access$getLowerBound$p(r110) + ((long) r118));
    L48:
        r118 = r118 + 1;
    L50:
        if (access$getUpperSet$p(r110) == 0) goto L57;
    L51:
        if (r108 >= 64) goto L57;
        if ((access$getUpperSet$p(r110) & (1 << r108)) == 0) goto L55;
        r116 = r116.set((access$getLowerBound$p(r110) + ((long) r108)) + ((long) 64));
    L55:
        r108 = r108 + 1;
    L57:
        return r116;
    L40:
        r116 = this;
        goto L42
    }

    public final SnapshotIdSet set(long r310) {
        long r100 = r310 - this.lowerBound;
        long r101 = 0;
        if (Intrinsics.compare(r100, r101) >= 0) goto L5;
    L10:
        long r110 = 64;
        if (Intrinsics.compare(r100, r110) >= 0) goto L13;
    L18:
        long r111 = 128;
        if (Intrinsics.compare(r100, r111) >= 0) goto L21;
        long[] r102 = this.belowBound;
        if (r102 == null) goto L55;
        int r103 = SnapshotId_jvmKt.binarySearch(r102, r310);
        if (r103 < 0) goto L59;
    L60:
        return this;
    L59:
        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, SnapshotId_jvmKt.withIdInsertedAt(r102, -(r103 + 1), r310));
    L55:
        return new SnapshotIdSet(this.upperSet, this.lowerSet, this.lowerBound, new long[]{r310});
    L21:
        if (get(r310) == true) goto L60;
        long r104 = this.upperSet;
        long r112 = this.lowerSet;
        long r105 = this.lowerBound;
        long r106 = 1;
        long r107 = ((r310 + r106) / r110) * r110;
        if (Intrinsics.compare(r107, r101) >= 0) goto L25;
        r107 = (Long.MAX_VALUE - r111) + r106;
    L25:
        SnapshotIdArrayBuilder r108 = null;
        long r210 = r104;
    L27:
        if (Intrinsics.compare(r105, r107) >= 0) goto L44;
        if (r112 == 0) goto L39;
        if (r108 != null) goto L32;
        r108 = new SnapshotIdArrayBuilder(this.belowBound);
    L32:
        int r109 = 0;
    L33:
        if (r109 >= 64) goto L38;
        long r211 = r107;
        if ((r112 & (1 << r109)) == 0) goto L37;
        r108.add(((long) r109) + r105);
    L37:
        r109 = r109 + 1;
        r107 = r211;
        goto L33
    L38:
        long r212 = r107;
    L41:
        if (r210 == 0) goto L42;
        r105 = r105 + r110;
        r112 = r210;
        r210 = 0;
        r107 = r212;
        goto L27
    L42:
        long r213 = r212;
        long r214 = 0;
    L46:
        if (r108 == null) goto L49;
        long[] r113 = r108.toArray();
        if (r113 == null) goto L49;
    L51:
        return new SnapshotIdSet(r210, r214, r213, r113).set(r310);
    L49:
        r113 = this.belowBound;
        goto L51
    L39:
        r212 = r107;
        goto L41
    L44:
        r213 = r105;
        r214 = r112;
        goto L46
    L13:
        if (Intrinsics.compare(r100, 128) >= 0) goto L18;
        long r114 = 1 << (((int) r100) - 64);
        long r115 = this.upperSet;
        if ((r115 & r114) != 0) goto L60;
        return new SnapshotIdSet(r115 | r114, this.lowerSet, this.lowerBound, this.belowBound);
    L5:
        if (Intrinsics.compare(r100, 64) >= 0) goto L10;
        long r116 = 1 << ((int) r100);
        long r117 = this.lowerSet;
        if ((r117 & r116) != 0) goto L60;
        return new SnapshotIdSet(this.upperSet, r117 | r116, this.lowerBound, this.belowBound);
    }

    private final SnapshotIdSet fastFold(SnapshotIdSet r110, Function2<? super SnapshotIdSet, ? super Long, SnapshotIdSet> r111) {
        long[] r100 = access$getBelowBound$p(this);
        int r101 = 0;
        if (r100 == null) goto L8;
        int r102 = r100.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L8;
        r110 = r111.invoke(r110, Long.valueOf(r100[r103]));
        r103 = r103 + 1;
    L8:
        if (access$getLowerSet$p(this) == 0) goto L16;
        int r104 = 0;
    L10:
        if (r104 >= 64) goto L16;
        if ((access$getLowerSet$p(this) & (1 << r104)) == 0) goto L14;
        r110 = r111.invoke(r110, Long.valueOf(access$getLowerBound$p(this) + ((long) r104)));
    L14:
        r104 = r104 + 1;
    L16:
        if (access$getUpperSet$p(this) == 0) goto L23;
    L17:
        if (r101 >= 64) goto L23;
        if ((access$getUpperSet$p(this) & (1 << r101)) == 0) goto L21;
        r110 = r111.invoke(r110, Long.valueOf((access$getLowerBound$p(this) + ((long) r101)) + ((long) 64)));
    L21:
        r101 = r101 + 1;
    L23:
        return r110;
    }

    private SnapshotIdSet(long r100, long r101, long r102, long[] r103) {
        this.upperSet = r100;
        this.lowerSet = r101;
        this.lowerBound = r102;
        this.belowBound = r103;
    }
}
