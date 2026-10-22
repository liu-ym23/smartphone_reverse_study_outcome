package com.bytedance.android.livesdk.arch.state.source;

import com.bytedance.android.livesdk.arch.comp.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class TbRecordState {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f103850c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f103851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Action f103852b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/arch/state/source/TbRecordState$Action;", "", "OfferShowingRecord", "OfferPendingRecord", "OfferWaitingRecord", "RemovePendingRecord", "RemoveShowingRecord", "RemoveWaitingRecord", "toolbarservice-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Action extends Enum<Action> {
        public static final Action OfferPendingRecord = null;
        public static final Action OfferShowingRecord = null;
        public static final Action OfferWaitingRecord = null;
        public static final Action RemovePendingRecord = null;
        public static final Action RemoveShowingRecord = null;
        public static final Action RemoveWaitingRecord = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f103853a = null;

        static {
            Action r100 = new Action("OfferShowingRecord", 0);
            OfferShowingRecord = r100;
            Action r101 = new Action("OfferPendingRecord", 1);
            OfferPendingRecord = r101;
            Action r102 = new Action("OfferWaitingRecord", 2);
            OfferWaitingRecord = r102;
            Action r103 = new Action("RemovePendingRecord", 3);
            RemovePendingRecord = r103;
            Action r104 = new Action("RemoveShowingRecord", 4);
            RemoveShowingRecord = r104;
            Action r105 = new Action("RemoveWaitingRecord", 5);
            RemoveWaitingRecord = r105;
            f103853a = new Action[]{r100, r101, r102, r103, r104, r105};
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f103853a.clone();
        }

        public Action(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        @JvmStatic
        public static TbRecordState a(b r100, Action r101) {
            Intrinsics.checkNotNullParameter(r100, "comp");
            Intrinsics.checkNotNullParameter(r101, "action");
            return new TbRecordState(r100, r101);
        }
    }

    static {
    }

    public TbRecordState(b r100, Action r101) {
        this.f103851a = r100;
        this.f103852b = r101;
    }
}
