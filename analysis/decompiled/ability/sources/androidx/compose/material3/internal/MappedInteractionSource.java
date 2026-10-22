package androidx.compose.material3.internal;

import C7.r;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import p9.c;
import p9.d;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/internal/MappedInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "underlyingInteractionSource", "Landroidx/compose/ui/geometry/Offset;", "delta", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/interaction/InteractionSource;JLkotlin/jvm/internal/e;)V", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "press", "mapPress", "(Landroidx/compose/foundation/interaction/PressInteraction$Press;)Landroidx/compose/foundation/interaction/PressInteraction$Press;", "J", "", "mappedPresses", "Ljava/util/Map;", "Lp9/c;", "Landroidx/compose/foundation/interaction/Interaction;", "interactions", "Lp9/c;", "getInteractions", "()Lp9/c;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MappedInteractionSource implements InteractionSource {
    public static final int $stable = 0;
    private final long delta;
    private final c interactions;
    private final Map<PressInteraction.Press, PressInteraction.Press> mappedPresses;

    public /* synthetic */ MappedInteractionSource(InteractionSource interactionSource, long j5, e eVar) {
        this(interactionSource, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PressInteraction.Press mapPress(PressInteraction.Press press) {
        return new PressInteraction.Press(Offset.m3899minusMKHz9U(press.getPressPosition(), this.delta), null);
    }

    @Override // androidx.compose.foundation.interaction.InteractionSource
    public c getInteractions() {
        return this.interactions;
    }

    private MappedInteractionSource(InteractionSource interactionSource, long j5) {
        this.delta = j5;
        this.mappedPresses = new LinkedHashMap();
        final c interactions = interactionSource.getInteractions();
        this.interactions = new c() { // from class: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "LC7/r;", "emit", "(Ljava/lang/Object;LH7/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements d {
                final /* synthetic */ d $this_unsafeFlow;
                final /* synthetic */ MappedInteractionSource this$0;

                @J7.c(c = "androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2", f = "MappedInteractionSource.kt", l = {223}, m = "emit")
                @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                /* renamed from: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(H7.c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(d dVar, MappedInteractionSource mappedInteractionSource) {
                    this.$this_unsafeFlow = dVar;
                    this.this$0 = mappedInteractionSource;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p9.d
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r6, H7.c r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r7
                        androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = (androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = new androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1$2$1
                        r0.<init>(r7)
                    L18:
                        java.lang.Object r7 = r0.result
                        kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L30
                        if (r2 != r3) goto L28
                        kotlin.b.b(r7)
                        goto L95
                    L28:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L30:
                        kotlin.b.b(r7)
                        p9.d r7 = r5.$this_unsafeFlow
                        androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
                        boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
                        if (r2 == 0) goto L4f
                        androidx.compose.material3.internal.MappedInteractionSource r2 = r5.this$0
                        r4 = r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r4 = (androidx.compose.foundation.interaction.PressInteraction.Press) r4
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = androidx.compose.material3.internal.MappedInteractionSource.access$mapPress(r2, r4)
                        androidx.compose.material3.internal.MappedInteractionSource r5 = r5.this$0
                        java.util.Map r5 = androidx.compose.material3.internal.MappedInteractionSource.access$getMappedPresses$p(r5)
                        r5.put(r6, r2)
                        r6 = r2
                        goto L8c
                    L4f:
                        boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Cancel
                        if (r2 == 0) goto L6e
                        androidx.compose.material3.internal.MappedInteractionSource r5 = r5.this$0
                        java.util.Map r5 = androidx.compose.material3.internal.MappedInteractionSource.access$getMappedPresses$p(r5)
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = r6.getPress()
                        java.lang.Object r5 = r5.remove(r2)
                        androidx.compose.foundation.interaction.PressInteraction$Press r5 = (androidx.compose.foundation.interaction.PressInteraction.Press) r5
                        if (r5 != 0) goto L68
                        goto L8c
                    L68:
                        androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                        r6.<init>(r5)
                        goto L8c
                    L6e:
                        boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Release
                        if (r2 == 0) goto L8c
                        androidx.compose.material3.internal.MappedInteractionSource r5 = r5.this$0
                        java.util.Map r5 = androidx.compose.material3.internal.MappedInteractionSource.access$getMappedPresses$p(r5)
                        androidx.compose.foundation.interaction.PressInteraction$Release r6 = (androidx.compose.foundation.interaction.PressInteraction.Release) r6
                        androidx.compose.foundation.interaction.PressInteraction$Press r2 = r6.getPress()
                        java.lang.Object r5 = r5.remove(r2)
                        androidx.compose.foundation.interaction.PressInteraction$Press r5 = (androidx.compose.foundation.interaction.PressInteraction.Press) r5
                        if (r5 != 0) goto L87
                        goto L8c
                    L87:
                        androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
                        r6.<init>(r5)
                    L8c:
                        r0.label = r3
                        java.lang.Object r5 = r7.emit(r6, r0)
                        if (r5 != r1) goto L95
                        return r1
                    L95:
                        C7.r r5 = C7.r.f317a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, H7.c):java.lang.Object");
                }
            }

            @Override // p9.c
            public Object collect(d dVar, H7.c cVar) {
                Object objCollect = interactions.collect(new AnonymousClass2(dVar, this), cVar);
                return objCollect == CoroutineSingletons.f4909a ? objCollect : r.f317a;
            }
        };
    }
}
