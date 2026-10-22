package an;

import com.bytedance.android.ec.store.search.datasource.LoadEvent;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f4478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f4479b = null;

    static {
        int[] r100 = new int[LoadEvent.values().length];
        f4478a = r100;
        r100[LoadEvent.NORMAL.ordinal()] = 1;
        LoadEvent r101 = LoadEvent.RECOMMEND_ON_NO_RESULT;
        r100[r101.ordinal()] = 2;
        LoadEvent r102 = LoadEvent.RECOMMEND_ON_LESS_RESULT;
        r100[r102.ordinal()] = 3;
        int[] r103 = new int[LoadEvent.values().length];
        f4479b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
