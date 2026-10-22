package androidx.compose.runtime;

import C7.r;
import S7.n;
import S7.o;
import S7.p;
import S7.q;
import androidx.compose.runtime.annotation.RememberInComposition;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u00022\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a?\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u00062\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\b\u001aQ\u0010\u0004\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n2\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\f\u001ac\u0010\u0004\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\r2#\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u000f\u001au\u0010\u0004\u001a%\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\n\"\u0004\b\u0002\u0010\r\"\u0004\b\u0003\u0010\u00102)\u0010\u0003\u001a%\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0012\u001a?\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u00132\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\b\u001aQ\u0010\u0014\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\u00062\u001d\u0010\u0003\u001a\u0019\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\f\u001ac\u0010\u0014\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\n2#\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u000f\u001au\u0010\u0014\u001a%\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0002\"\u0004\b\u0000\u0010\u0013\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\n\"\u0004\b\u0003\u0010\r2)\u0010\u0003\u001a%\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0012\"\u0014\u0010\u0016\u001a\u00020\u00158\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lkotlin/Function0;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "movableContentOf", "(LS7/n;)LS7/n;", "P", "Lkotlin/Function1;", "(LS7/o;)LS7/o;", "P1", "P2", "Lkotlin/Function2;", "(LS7/p;)LS7/p;", "P3", "Lkotlin/Function3;", "(LS7/q;)LS7/q;", "P4", "Lkotlin/Function4;", "(LS7/r;)LS7/r;", "R", "movableContentWithReceiverOf", "", "movableContentKey", "I", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MovableContentKt {
    public static final int movableContentKey = 126665345;

    @RememberInComposition
    public static final n movableContentOf(final n nVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(-703201834, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentOf$movableContent$1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Void) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Void r32, Composer composer, int i) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-703201834, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:39)");
                }
                nVar.invoke(composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(-328108779, true, new n() { // from class: androidx.compose.runtime.MovableContentKt.movableContentOf.1
            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Composer composer, int i) {
                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-328108779, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:40)");
                }
                composer.insertMovableContent(movableContent, null);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @ComposableInferredTarget(scheme = "[0[0]:[_]]")
    @RememberInComposition
    public static final <R> o movableContentWithReceiverOf(final o oVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(668517896, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$movableContent$1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((MovableContentKt$movableContentWithReceiverOf$movableContent$1) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(R r5, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(r5) : composer.changedInstance(r5) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(668517896, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:171)");
                }
                oVar.invoke(r5, composer, Integer.valueOf(i & 14));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(-1655274392, true, new o() { // from class: androidx.compose.runtime.MovableContentKt.movableContentWithReceiverOf.1
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((C06851) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(R r5, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(r5) : composer.changedInstance(r5) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1655274392, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:172)");
                }
                composer.insertMovableContent(movableContent, r5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <P> o movableContentOf(o oVar) {
        final MovableContent movableContent = new MovableContent(oVar);
        return ComposableLambdaKt.composableLambdaInstance(1032736913, true, new o() { // from class: androidx.compose.runtime.MovableContentKt.movableContentOf.2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((AnonymousClass2) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(P p, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(p) : composer.changedInstance(p) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1032736913, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:63)");
                }
                composer.insertMovableContent(movableContent, p);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <R, P> p movableContentWithReceiverOf(final p pVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(-95003188, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$movableContent$2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Pair<? extends R, ? extends P> pair, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(pair) : composer.changedInstance(pair) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-95003188, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:196)");
                }
                pVar.invoke(pair.f4886a, pair.b, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(1349529900, true, new p() { // from class: androidx.compose.runtime.MovableContentKt.movableContentWithReceiverOf.2
            @Override // S7.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((C06862) obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(R r5, P p, Composer composer, int i) {
                int i6;
                if ((i & 6) == 0) {
                    i6 = ((i & 8) == 0 ? composer.changed(r5) : composer.changedInstance(r5) ? 4 : 2) | i;
                } else {
                    i6 = i;
                }
                if ((i & 48) == 0) {
                    i6 |= (i & 64) == 0 ? composer.changed(p) : composer.changedInstance(p) ? 32 : 16;
                }
                if (!composer.shouldExecute((i6 & 147) != 146, i6 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1349529900, i6, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:197)");
                }
                composer.insertMovableContent(movableContent, new Pair(r5, p));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <P1, P2> p movableContentOf(final p pVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(561467799, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentOf$movableContent$2
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Pair) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Pair<? extends P1, ? extends P2> pair, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(pair) : composer.changedInstance(pair) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(561467799, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:87)");
                }
                pVar.invoke(pair.f4886a, pair.b, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(-525773808, true, new p() { // from class: androidx.compose.runtime.MovableContentKt.movableContentOf.3
            @Override // S7.p
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((AnonymousClass3) obj, obj2, (Composer) obj3, ((Number) obj4).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(P1 p1, P2 p22, Composer composer, int i) {
                int i6;
                if ((i & 6) == 0) {
                    i6 = ((i & 8) == 0 ? composer.changed(p1) : composer.changedInstance(p1) ? 4 : 2) | i;
                } else {
                    i6 = i;
                }
                if ((i & 48) == 0) {
                    i6 |= (i & 64) == 0 ? composer.changed(p22) : composer.changedInstance(p22) ? 32 : 16;
                }
                if (!composer.shouldExecute((i6 & 147) != 146, i6 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-525773808, i6, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:88)");
                }
                composer.insertMovableContent(movableContent, new Pair(p1, p22));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <R, P1, P2> q movableContentWithReceiverOf(final q qVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(-963896566, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$movableContent$3
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Triple) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Triple<? extends R, ? extends P1, ? extends P2> triple, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(triple) : composer.changedInstance(triple) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-963896566, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:221)");
                }
                qVar.invoke(triple.f4891a, triple.b, triple.c, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(2121535275, true, new q() { // from class: androidx.compose.runtime.MovableContentKt.movableContentWithReceiverOf.3
            @Override // S7.q
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                invoke((C06873) obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(R r5, P1 p1, P2 p22, Composer composer, int i) {
                int i6;
                if ((i & 6) == 0) {
                    i6 = ((i & 8) == 0 ? composer.changed(r5) : composer.changedInstance(r5) ? 4 : 2) | i;
                } else {
                    i6 = i;
                }
                if ((i & 48) == 0) {
                    i6 |= (i & 64) == 0 ? composer.changed(p1) : composer.changedInstance(p1) ? 32 : 16;
                }
                if ((i & 384) == 0) {
                    i6 |= (i & 512) == 0 ? composer.changed(p22) : composer.changedInstance(p22) ? 256 : 128;
                }
                if (!composer.shouldExecute((i6 & 1171) != 1170, i6 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2121535275, i6, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:222)");
                }
                composer.insertMovableContent(movableContent, new Triple(r5, p1, p22));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <P1, P2, P3> q movableContentOf(final q qVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(-846116651, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentOf$movableContent$3
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Triple) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Triple<? extends P1, ? extends P2, ? extends P3> triple, Composer composer, int i) {
                if ((i & 6) == 0) {
                    i |= (i & 8) == 0 ? composer.changed(triple) : composer.changedInstance(triple) ? 4 : 2;
                }
                if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-846116651, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:113)");
                }
                qVar.invoke(triple.f4891a, triple.b, triple.c, composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(1477386365, true, new q() { // from class: androidx.compose.runtime.MovableContentKt.movableContentOf.4
            @Override // S7.q
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                invoke((AnonymousClass4) obj, obj2, obj3, (Composer) obj4, ((Number) obj5).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(P1 p1, P2 p22, P3 p3, Composer composer, int i) {
                int i6;
                if ((i & 6) == 0) {
                    i6 = ((i & 8) == 0 ? composer.changed(p1) : composer.changedInstance(p1) ? 4 : 2) | i;
                } else {
                    i6 = i;
                }
                if ((i & 48) == 0) {
                    i6 |= (i & 64) == 0 ? composer.changed(p22) : composer.changedInstance(p22) ? 32 : 16;
                }
                if ((i & 384) == 0) {
                    i6 |= (i & 512) == 0 ? composer.changed(p3) : composer.changedInstance(p3) ? 256 : 128;
                }
                if (!composer.shouldExecute((i6 & 1171) != 1170, i6 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1477386365, i6, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:115)");
                }
                composer.insertMovableContent(movableContent, new Triple(p1, p22, p3));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <R, P1, P2, P3> S7.r movableContentWithReceiverOf(final S7.r rVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(-346590649, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentWithReceiverOf$movableContent$4
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Object[]) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Object[] objArr, Composer composer, int i) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-346590649, i, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:248)");
                }
                rVar.invoke(objArr[0], objArr[1], objArr[2], objArr[3], composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(572330192, true, new S7.r() { // from class: androidx.compose.runtime.MovableContentKt.movableContentWithReceiverOf.4
            @Override // S7.r
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke((C06884) obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(R r5, P1 p1, P2 p22, P3 p3, Composer composer, int i) {
                int i6;
                if ((i & 6) == 0) {
                    i6 = ((i & 8) == 0 ? composer.changed(r5) : composer.changedInstance(r5) ? 4 : 2) | i;
                } else {
                    i6 = i;
                }
                if ((i & 48) == 0) {
                    i6 |= (i & 64) == 0 ? composer.changed(p1) : composer.changedInstance(p1) ? 32 : 16;
                }
                if ((i & 384) == 0) {
                    i6 |= (i & 512) == 0 ? composer.changed(p22) : composer.changedInstance(p22) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i6 |= (i & 4096) == 0 ? composer.changed(p3) : composer.changedInstance(p3) ? 2048 : 1024;
                }
                if (!composer.shouldExecute((i6 & 9363) != 9362, i6 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(572330192, i6, -1, "androidx.compose.runtime.movableContentWithReceiverOf.<anonymous> (MovableContent.kt:252)");
                }
                composer.insertMovableContent(movableContent, new Object[]{r5, p1, p22, p3});
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }

    @RememberInComposition
    public static final <P1, P2, P3, P4> S7.r movableContentOf(final S7.r rVar) {
        final MovableContent movableContent = new MovableContent(ComposableLambdaKt.composableLambdaInstance(743481490, true, new o() { // from class: androidx.compose.runtime.MovableContentKt$movableContentOf$movableContent$4
            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((Object[]) obj, (Composer) obj2, ((Number) obj3).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(Object[] objArr, Composer composer, int i) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(743481490, i, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:142)");
                }
                rVar.invoke(objArr[0], objArr[1], objArr[2], objArr[3], composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return ComposableLambdaKt.composableLambdaInstance(-1304803723, true, new S7.r() { // from class: androidx.compose.runtime.MovableContentKt.movableContentOf.5
            @Override // S7.r
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                invoke((AnonymousClass5) obj, obj2, obj3, obj4, (Composer) obj5, ((Number) obj6).intValue());
                return r.f317a;
            }

            @Composable
            public final void invoke(P1 p1, P2 p22, P3 p3, P4 p42, Composer composer, int i) {
                int i6;
                if ((i & 6) == 0) {
                    i6 = ((i & 8) == 0 ? composer.changed(p1) : composer.changedInstance(p1) ? 4 : 2) | i;
                } else {
                    i6 = i;
                }
                if ((i & 48) == 0) {
                    i6 |= (i & 64) == 0 ? composer.changed(p22) : composer.changedInstance(p22) ? 32 : 16;
                }
                if ((i & 384) == 0) {
                    i6 |= (i & 512) == 0 ? composer.changed(p3) : composer.changedInstance(p3) ? 256 : 128;
                }
                if ((i & 3072) == 0) {
                    i6 |= (i & 4096) == 0 ? composer.changed(p42) : composer.changedInstance(p42) ? 2048 : 1024;
                }
                if (!composer.shouldExecute((i6 & 9363) != 9362, i6 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1304803723, i6, -1, "androidx.compose.runtime.movableContentOf.<anonymous> (MovableContent.kt:146)");
                }
                composer.insertMovableContent(movableContent, new Object[]{p1, p22, p3, p42});
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
    }
}
