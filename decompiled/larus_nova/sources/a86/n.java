package a86;

import com.bytedance.ies.xelement.picker.LynxPickerView;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class n implements y76.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxPickerView f2154a;

    @Override // y76.a
    public final Map<String, String> a() {
        Pair[] r100 = new Pair[2];
        String r101 = this.f2154a.f250221j;
        if (r101 != null) goto L5;
        r101 = "Confirm";
    L5:
        r100[0] = TuplesKt.to("confirm", r101);
        String r102 = this.f2154a.f250222k;
        if (r102 != null) goto L8;
        r102 = "Cancel";
    L8:
        r100[1] = TuplesKt.to("cancel", r102);
        return MapsKt.mapOf(r100);
    }

    public n(LynxPickerView r100) {
        this.f2154a = r100;
    }
}
