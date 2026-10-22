package a7;

import com.bytedance.android.annie.api.card.IHybridComponent;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(IHybridComponent r100, String r101, Map r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.load(r101, r102);
    }
}
