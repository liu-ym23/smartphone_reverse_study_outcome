package com.obric.structure.omvvm.core.flux;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluxFullLifecycleObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/structure/omvvm/core/flux/FluxFullLifecycleObserver;", "Lcom/obric/structure/omvvm/core/flux/FluxLifecycleObserver;", "onBindF", "", "onCreateF", "onDestroyF", "onDisplayF", "onHideF", "onLifecycleEvent", "event", "Lcom/obric/structure/omvvm/core/flux/FluxComponentLifecycle$Event;", "onUnbindF", "omvvm-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FluxFullLifecycleObserver extends FluxLifecycleObserver {

    /* JADX INFO: compiled from: FluxFullLifecycleObserver.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onBindF(FluxFullLifecycleObserver r0) {
        }

        public static void onCreateF(FluxFullLifecycleObserver r0) {
        }

        public static void onDestroyF(FluxFullLifecycleObserver r0) {
        }

        public static void onDisplayF(FluxFullLifecycleObserver r0) {
        }

        public static void onHideF(FluxFullLifecycleObserver r0) {
        }

        public static void onUnbindF(FluxFullLifecycleObserver r0) {
        }

        public static void onLifecycleEvent(FluxFullLifecycleObserver r1, FluxComponentLifecycle.Event r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            switch(WhenMappings.$EnumSwitchMapping$0[r2.ordinal()]) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L17;
            };
        L5:
            r1.onDestroyF();
            return;
        L6:
            r1.onUnbindF();
            return;
        L7:
            r1.onHideF();
            return;
        L8:
            r1.onDisplayF();
            return;
        L9:
            r1.onBindF();
            return;
        L10:
            r1.onCreateF();
            return;
        }
    }

    /* JADX INFO: compiled from: FluxFullLifecycleObserver.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[FluxComponentLifecycle.Event.values().length];
            r0[FluxComponentLifecycle.Event.ON_CREATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[FluxComponentLifecycle.Event.ON_BIND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[FluxComponentLifecycle.Event.ON_DISPLAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[FluxComponentLifecycle.Event.ON_HIDE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[FluxComponentLifecycle.Event.ON_UNBIND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[FluxComponentLifecycle.Event.ON_DESTROY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            $EnumSwitchMapping$0 = r0;
        }
    }

    void onBindF();

    void onCreateF();

    void onDestroyF();

    void onDisplayF();

    void onHideF();

    @Override // com.obric.structure.omvvm.core.flux.FluxLifecycleObserver
    void onLifecycleEvent(FluxComponentLifecycle.Event r1);

    void onUnbindF();
}
