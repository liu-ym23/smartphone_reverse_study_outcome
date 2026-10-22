package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class MultiCameraPanelEvent extends o70.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MultiCameraPanelEvent f159575b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MultiCameraPanelEvent f159576c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Action f159577a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/MultiCameraPanelEvent$Action;", "", "SHOW", "HIDE", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Action extends Enum<Action> {
        public static final Action HIDE = null;
        public static final Action SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f159578a = null;

        static {
            Action r100 = new Action("SHOW", 0);
            SHOW = r100;
            Action r101 = new Action("HIDE", 1);
            HIDE = r101;
            f159578a = new Action[]{r100, r101};
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f159578a.clone();
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
        f159575b = new MultiCameraPanelEvent(Action.SHOW);
        f159576c = new MultiCameraPanelEvent(Action.HIDE);
    }

    public MultiCameraPanelEvent(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f159577a = r100;
    }
}
