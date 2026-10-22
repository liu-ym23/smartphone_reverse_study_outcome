package com.bytedance.android.ec.hybrid.list.holder;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
public interface IHybridListViewHolder {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/list/holder/IHybridListViewHolder$ECCardPlayState;", "", "IDLE", "PLAYING", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ECCardPlayState extends Enum<ECCardPlayState> {
        public static final ECCardPlayState IDLE = null;
        public static final ECCardPlayState PLAYING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ECCardPlayState[] f47193a = null;

        static {
            ECCardPlayState r100 = new ECCardPlayState("IDLE", 0);
            IDLE = r100;
            ECCardPlayState r101 = new ECCardPlayState("PLAYING", 1);
            PLAYING = r101;
            f47193a = new ECCardPlayState[]{r100, r101};
        }

        public static ECCardPlayState valueOf(String r100) {
            return (ECCardPlayState) r27.a.a(ECCardPlayState.class, r100);
        }

        public static ECCardPlayState[] values() {
            return (ECCardPlayState[]) f47193a.clone();
        }

        public ECCardPlayState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static /* synthetic */ void a(IHybridListViewHolder r100) {
            r100.D1(null);
        }
    }

    boolean C3();

    void D();

    void D1(Long r100);

    void K();

    void g1(int r100, int r101, double r102);

    void m1(int r100, double r101);

    void o();

    void onHide();

    void onRelease();

    void onShow();
}
